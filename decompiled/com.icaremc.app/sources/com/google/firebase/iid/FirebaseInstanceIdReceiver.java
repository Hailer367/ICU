package com.google.firebase.iid;

import P1.C0106j;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import e1.ThreadFactoryC0275a;
import f1.AbstractC0286a;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static SoftReference f3404a;

    /* renamed from: b, reason: collision with root package name */
    public static SoftReference f3405b;

    public static int a(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if (Objects.equals(intent.getAction(), "com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            Intent putExtras = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(extras);
            if (AbstractC0286a.K(putExtras)) {
                AbstractC0286a.z("_nd", putExtras.getExtras());
                return -1;
            }
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        ExecutorService executorService;
        ExecutorService executorService2;
        if (intent == null) {
            return;
        }
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        synchronized (FirebaseInstanceIdReceiver.class) {
            try {
                SoftReference softReference = f3404a;
                if (softReference != null) {
                    executorService = (ExecutorService) softReference.get();
                } else {
                    executorService = null;
                }
                if (executorService == null) {
                    executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new ThreadFactoryC0275a("firebase-iid-executor")));
                    f3404a = new SoftReference(executorService);
                }
                executorService2 = executorService;
            } catch (Throwable th) {
                throw th;
            }
        }
        executorService2.execute(new Runnable(this) { // from class: V0.i
            @Override // java.lang.Runnable
            public final void run() {
                Intent intent2;
                int i4;
                Intent intent3 = intent;
                Context context2 = context;
                boolean z = isOrderedBroadcast;
                BroadcastReceiver.PendingResult pendingResult = goAsync;
                try {
                    Parcelable parcelableExtra = intent3.getParcelableExtra("wrapped_intent");
                    Executor executor = null;
                    if (parcelableExtra instanceof Intent) {
                        intent2 = (Intent) parcelableExtra;
                    } else {
                        intent2 = null;
                    }
                    if (intent2 != null) {
                        i4 = FirebaseInstanceIdReceiver.a(intent2);
                    } else {
                        int i5 = 500;
                        if (intent3.getExtras() != null) {
                            a aVar = new a(intent3);
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            synchronized (FirebaseInstanceIdReceiver.class) {
                                try {
                                    SoftReference softReference2 = FirebaseInstanceIdReceiver.f3405b;
                                    if (softReference2 != null) {
                                        executor = (Executor) softReference2.get();
                                    }
                                    if (executor == null) {
                                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0275a("pscm-ack-executor"));
                                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                                        executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
                                        FirebaseInstanceIdReceiver.f3405b = new SoftReference(executor);
                                    }
                                } finally {
                                }
                            }
                            executor.execute(new F.o(context2, aVar, countDownLatch));
                            try {
                                i5 = ((Integer) AbstractC0602b.c(new C0106j(context2).b(intent3))).intValue();
                            } catch (InterruptedException | ExecutionException e4) {
                                Log.e("FirebaseMessaging", "Failed to send message to service.", e4);
                            }
                            try {
                                if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                                    Log.w("CloudMessagingReceiver", "Message ack timed out");
                                }
                            } catch (InterruptedException e5) {
                                Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e5.toString()));
                            }
                        }
                        i4 = i5;
                    }
                    if (z && pendingResult != null) {
                        pendingResult.setResultCode(i4);
                    }
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                } catch (Throwable th2) {
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    throw th2;
                }
            }
        });
    }
}
