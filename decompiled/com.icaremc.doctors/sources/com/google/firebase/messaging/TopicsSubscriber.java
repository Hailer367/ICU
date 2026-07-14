package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TopicsSubscriber {
    static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final long RPC_TIMEOUT_SEC = 30;
    private final Context context;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new r.j(0);
    private boolean syncScheduledOrRunning = false;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>>, r.j] */
    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.pendingOperations) {
            try {
                String serialize = topicOperation.serialize();
                if (this.pendingOperations.containsKey(serialize)) {
                    arrayDeque = this.pendingOperations.get(serialize);
                } else {
                    ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                    this.pendingOperations.put(serialize, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static <T> void awaitTask(Task<T> task) {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e3);
            }
            throw ((IOException) cause);
        }
    }

    private void blockingSubscribeToTopic(String str) {
        awaitTask(this.rpc.subscribeToTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) {
        awaitTask(this.rpc.unsubscribeFromTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    public static Task<TopicsSubscriber> createInstance(final FirebaseMessaging firebaseMessaging, final Metadata metadata, final GmsRpc gmsRpc, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsSubscriber lambda$createInstance$0;
                lambda$createInstance$0 = TopicsSubscriber.lambda$createInstance$0(context, scheduledExecutorService, firebaseMessaging, metadata, gmsRpc);
                return lambda$createInstance$0;
            }
        });
    }

    public static boolean isDebugLogEnabled() {
        if (!Log.isLoggable(Constants.TAG, 3)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TopicsSubscriber lambda$createInstance$0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        return new TopicsSubscriber(firebaseMessaging, metadata, TopicsStore.getInstance(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            try {
                String serialize = topicOperation.serialize();
                if (!this.pendingOperations.containsKey(serialize)) {
                    return;
                }
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.pendingOperations.get(serialize);
                TaskCompletionSource<Void> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.setResult(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.pendingOperations.remove(serialize);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0L);
        }
    }

    public TopicsStore getStore() {
        return this.store;
    }

    public boolean hasPendingOperation() {
        if (this.store.getNextTopicOperation() != null) {
            return true;
        }
        return false;
    }

    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078 A[Catch: IOException -> 0x0025, TryCatch #0 {IOException -> 0x0025, blocks: (B:3:0x0009, B:12:0x0039, B:14:0x003f, B:17:0x0054, B:19:0x0061, B:20:0x0078, B:22:0x0085, B:23:0x001b, B:26:0x0028), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean performTopicOperation(com.google.firebase.messaging.TopicOperation r10) {
        /*
            r9 = this;
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "Unknown topic operation"
            java.lang.String r2 = "Subscribe to topic: "
            java.lang.String r3 = "Unsubscribe from topic: "
            r4 = 0
            java.lang.String r5 = r10.getOperation()     // Catch: java.io.IOException -> L25
            int r6 = r5.hashCode()     // Catch: java.io.IOException -> L25
            r7 = 83
            r8 = 1
            if (r6 == r7) goto L28
            r7 = 85
            if (r6 == r7) goto L1b
            goto L32
        L1b:
            java.lang.String r6 = "U"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L25
            if (r5 == 0) goto L32
            r5 = r8
            goto L33
        L25:
            r10 = move-exception
            goto L9c
        L28:
            java.lang.String r6 = "S"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L25
            if (r5 == 0) goto L32
            r5 = r4
            goto L33
        L32:
            r5 = -1
        L33:
            java.lang.String r6 = " succeeded."
            if (r5 == 0) goto L78
            if (r5 == r8) goto L54
            boolean r2 = isDebugLogEnabled()     // Catch: java.io.IOException -> L25
            if (r2 == 0) goto L9b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L25
            r2.<init>(r1)     // Catch: java.io.IOException -> L25
            r2.append(r10)     // Catch: java.io.IOException -> L25
            java.lang.String r10 = "."
            r2.append(r10)     // Catch: java.io.IOException -> L25
            java.lang.String r10 = r2.toString()     // Catch: java.io.IOException -> L25
            android.util.Log.d(r0, r10)     // Catch: java.io.IOException -> L25
            goto L9b
        L54:
            java.lang.String r1 = r10.getTopic()     // Catch: java.io.IOException -> L25
            r9.blockingUnsubscribeFromTopic(r1)     // Catch: java.io.IOException -> L25
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> L25
            if (r1 == 0) goto L9b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L25
            r1.<init>(r3)     // Catch: java.io.IOException -> L25
            java.lang.String r10 = r10.getTopic()     // Catch: java.io.IOException -> L25
            r1.append(r10)     // Catch: java.io.IOException -> L25
            r1.append(r6)     // Catch: java.io.IOException -> L25
            java.lang.String r10 = r1.toString()     // Catch: java.io.IOException -> L25
            android.util.Log.d(r0, r10)     // Catch: java.io.IOException -> L25
            goto L9b
        L78:
            java.lang.String r1 = r10.getTopic()     // Catch: java.io.IOException -> L25
            r9.blockingSubscribeToTopic(r1)     // Catch: java.io.IOException -> L25
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> L25
            if (r1 == 0) goto L9b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L25
            r1.<init>(r2)     // Catch: java.io.IOException -> L25
            java.lang.String r10 = r10.getTopic()     // Catch: java.io.IOException -> L25
            r1.append(r10)     // Catch: java.io.IOException -> L25
            r1.append(r6)     // Catch: java.io.IOException -> L25
            java.lang.String r10 = r1.toString()     // Catch: java.io.IOException -> L25
            android.util.Log.d(r0, r10)     // Catch: java.io.IOException -> L25
        L9b:
            return r8
        L9c:
            java.lang.String r1 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r2 = r10.getMessage()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Lce
            java.lang.String r1 = "INTERNAL_SERVER_ERROR"
            java.lang.String r2 = r10.getMessage()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Lce
            java.lang.String r1 = "TOO_MANY_SUBSCRIBERS"
            java.lang.String r2 = r10.getMessage()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lc1
            goto Lce
        Lc1:
            java.lang.String r1 = r10.getMessage()
            if (r1 != 0) goto Lcd
            java.lang.String r10 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r10)
            return r4
        Lcd:
            throw r10
        Lce:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Topic operation failed: "
            r1.<init>(r2)
            java.lang.String r10 = r10.getMessage()
            r1.append(r10)
            java.lang.String r10 = ". Will retry Topic operation."
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            android.util.Log.e(r0, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.performTopicOperation(com.google.firebase.messaging.TopicOperation):boolean");
    }

    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j2) {
        this.syncExecutor.schedule(runnable, j2, TimeUnit.SECONDS);
    }

    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    public Task<Void> subscribeToTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x000d, code lost:
    
        if (isDebugLogEnabled() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x000f, code lost:
    
        android.util.Log.d(com.google.firebase.messaging.Constants.TAG, "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001b, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean syncTopics() {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.store     // Catch: java.lang.Throwable -> L17
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1c
            boolean r0 = isDebugLogEnabled()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L19
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r0 = move-exception
            goto L2e
        L19:
            r0 = 1
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            return r0
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            boolean r1 = r2.performTopicOperation(r0)
            if (r1 != 0) goto L25
            r0 = 0
            return r0
        L25:
            com.google.firebase.messaging.TopicsStore r1 = r2.store
            r1.removeTopicOperation(r0)
            r2.markCompletePendingOperation(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    public void syncWithDelaySecondsInternal(long j2) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, 2 * j2), MAX_DELAY_SEC)), j2);
        setSyncScheduledOrRunning(true);
    }

    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }
}
