package com.google.firebase.heartbeatinfo;

import Q0.j;
import a.AbstractC0051a;
import android.content.Context;
import android.os.Build;
import c1.l;
import com.google.firebase.datastorage.JavaDataStorage;
import com.google.firebase.datastorage.JavaDataStorageKt;
import com.google.firebase.encoders.json.BuildConfig;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HeartBeatInfoStorage {
    private static final String HEARTBEAT_PREFERENCES_NAME = "FirebaseHeartBeat";
    private static final int HEART_BEAT_COUNT_LIMIT = 30;
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static HeartBeatInfoStorage instance;
    private final JavaDataStorage firebaseDataStore;
    private static final O.e GLOBAL = AbstractC0051a.F("fire-global");
    private static final O.e HEART_BEAT_COUNT_TAG = AbstractC0051a.F("fire-count");
    private static final O.e LAST_STORED_DATE = AbstractC0051a.T("last-used-date");

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseDataStore = new JavaDataStorage(context, O.a.m(HEARTBEAT_PREFERENCES_NAME, str));
    }

    private synchronized long cleanUpStoredHeartBeats(O.c cVar) {
        long j2;
        try {
            long longValue = ((Long) JavaDataStorageKt.getOrDefault(cVar, HEART_BEAT_COUNT_TAG, 0L)).longValue();
            String str = BuildConfig.FLAVOR;
            Set hashSet = new HashSet();
            String str2 = null;
            for (Map.Entry entry : cVar.a().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str3 : set) {
                        if (str2 != null && str2.compareTo(str3) <= 0) {
                        }
                        str = ((O.e) entry.getKey()).f632a;
                        hashSet = set;
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str2);
            cVar.f(AbstractC0051a.U(str), hashSet2);
            j2 = longValue - 1;
            cVar.e(HEART_BEAT_COUNT_TAG, Long.valueOf(j2));
        } catch (Throwable th) {
            throw th;
        }
        return j2;
    }

    private synchronized String getFormattedDate(long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j2)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j2));
    }

    private synchronized O.e getStoredUserAgentString(O.c cVar, String str) {
        for (Map.Entry entry : cVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return AbstractC0051a.U(((O.e) entry.getKey()).f632a);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j lambda$deleteAllHeartBeats$0(O.c cVar) {
        long j2 = 0;
        for (Map.Entry entry : cVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                O.e eVar = (O.e) entry.getKey();
                Set set = (Set) entry.getValue();
                String formattedDate = getFormattedDate(System.currentTimeMillis());
                if (set.contains(formattedDate)) {
                    Object[] objArr = {formattedDate};
                    HashSet hashSet = new HashSet(1);
                    Object obj = objArr[0];
                    Objects.requireNonNull(obj);
                    if (hashSet.add(obj)) {
                        cVar.e(eVar, Collections.unmodifiableSet(hashSet));
                        j2++;
                    } else {
                        throw new IllegalArgumentException("duplicate element: " + obj);
                    }
                } else {
                    cVar.d(eVar);
                }
            }
        }
        if (j2 == 0) {
            cVar.d(HEART_BEAT_COUNT_TAG);
            return null;
        }
        cVar.e(HEART_BEAT_COUNT_TAG, Long.valueOf(j2));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j lambda$postHeartBeatCleanUp$1(String str, O.c cVar) {
        cVar.e(LAST_STORED_DATE, str);
        removeStoredDate(cVar, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j lambda$storeHeartBeat$2(String str, String str2, O.e eVar, O.c cVar) {
        O.e eVar2 = LAST_STORED_DATE;
        if (((String) JavaDataStorageKt.getOrDefault(cVar, eVar2, BuildConfig.FLAVOR)).equals(str)) {
            O.e storedUserAgentString = getStoredUserAgentString(cVar, str);
            if (storedUserAgentString == null || storedUserAgentString.f632a.equals(str2)) {
                return null;
            }
            updateStoredUserAgent(cVar, eVar, str);
            return null;
        }
        O.e eVar3 = HEART_BEAT_COUNT_TAG;
        long longValue = ((Long) JavaDataStorageKt.getOrDefault(cVar, eVar3, 0L)).longValue();
        if (longValue + 1 == 30) {
            longValue = cleanUpStoredHeartBeats(cVar);
        }
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(cVar, eVar, new HashSet()));
        hashSet.add(str);
        cVar.e(eVar, hashSet);
        cVar.e(eVar3, Long.valueOf(longValue + 1));
        cVar.e(eVar2, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j lambda$updateGlobalHeartBeat$3(long j2, O.c cVar) {
        cVar.e(GLOBAL, Long.valueOf(j2));
        return null;
    }

    private synchronized void removeStoredDate(O.c cVar, String str) {
        try {
            O.e storedUserAgentString = getStoredUserAgentString(cVar, str);
            if (storedUserAgentString == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(cVar, storedUserAgentString, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                cVar.d(storedUserAgentString);
            } else {
                cVar.getClass();
                cVar.f(storedUserAgentString, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void updateStoredUserAgent(O.c cVar, O.e eVar, String str) {
        removeStoredDate(cVar, str);
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(cVar, eVar, new HashSet()));
        hashSet.add(str);
        cVar.e(eVar, hashSet);
    }

    public synchronized void deleteAllHeartBeats() {
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.e
            @Override // c1.l
            public final Object invoke(Object obj) {
                j lambda$deleteAllHeartBeats$0;
                lambda$deleteAllHeartBeats$0 = HeartBeatInfoStorage.this.lambda$deleteAllHeartBeats$0((O.c) obj);
                return lambda$deleteAllHeartBeats$0;
            }
        });
    }

    public synchronized List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String formattedDate = getFormattedDate(System.currentTimeMillis());
            for (Map.Entry<O.e, Object> entry : this.firebaseDataStore.getAllSync().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(formattedDate);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(HeartBeatResult.create(entry.getKey().f632a, new ArrayList(hashSet)));
                    }
                }
            }
            updateGlobalHeartBeat(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public int getHeartBeatCount() {
        return ((Long) this.firebaseDataStore.getSync(HEART_BEAT_COUNT_TAG, 0L)).intValue();
    }

    public synchronized long getLastGlobalHeartBeat() {
        return ((Long) this.firebaseDataStore.getSync(GLOBAL, -1L)).longValue();
    }

    public synchronized boolean isSameDateUtc(long j2, long j3) {
        return getFormattedDate(j2).equals(getFormattedDate(j3));
    }

    public synchronized void postHeartBeatCleanUp() {
        final String formattedDate = getFormattedDate(System.currentTimeMillis());
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.f
            @Override // c1.l
            public final Object invoke(Object obj) {
                j lambda$postHeartBeatCleanUp$1;
                lambda$postHeartBeatCleanUp$1 = HeartBeatInfoStorage.this.lambda$postHeartBeatCleanUp$1(formattedDate, (O.c) obj);
                return lambda$postHeartBeatCleanUp$1;
            }
        });
    }

    public synchronized boolean shouldSendGlobalHeartBeat(long j2) {
        return shouldSendSdkHeartBeat(GLOBAL, j2);
    }

    public synchronized boolean shouldSendSdkHeartBeat(O.e eVar, long j2) {
        if (isSameDateUtc(((Long) this.firebaseDataStore.getSync(eVar, -1L)).longValue(), j2)) {
            return false;
        }
        this.firebaseDataStore.putSync(eVar, Long.valueOf(j2));
        return true;
    }

    public synchronized void storeHeartBeat(long j2, final String str) {
        final String formattedDate = getFormattedDate(j2);
        final O.e U2 = AbstractC0051a.U(str);
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.d
            @Override // c1.l
            public final Object invoke(Object obj) {
                j lambda$storeHeartBeat$2;
                lambda$storeHeartBeat$2 = HeartBeatInfoStorage.this.lambda$storeHeartBeat$2(formattedDate, str, U2, (O.c) obj);
                return lambda$storeHeartBeat$2;
            }
        });
    }

    public synchronized void updateGlobalHeartBeat(final long j2) {
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.g
            @Override // c1.l
            public final Object invoke(Object obj) {
                j lambda$updateGlobalHeartBeat$3;
                lambda$updateGlobalHeartBeat$3 = HeartBeatInfoStorage.lambda$updateGlobalHeartBeat$3(j2, (O.c) obj);
                return lambda$updateGlobalHeartBeat$3;
            }
        });
    }

    public HeartBeatInfoStorage(JavaDataStorage javaDataStorage) {
        this.firebaseDataStore = javaDataStorage;
    }
}
