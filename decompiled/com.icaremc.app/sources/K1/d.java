package K1;

import Z0.r;
import android.net.TrafficStats;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p1.C0580i;
import p1.C0585n;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f916m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final u1.f f917a;

    /* renamed from: b, reason: collision with root package name */
    public final M1.c f918b;

    /* renamed from: c, reason: collision with root package name */
    public final E0.a f919c;

    /* renamed from: d, reason: collision with root package name */
    public final k f920d;

    /* renamed from: e, reason: collision with root package name */
    public final x1.k f921e;

    /* renamed from: f, reason: collision with root package name */
    public final i f922f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f923g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorService f924h;

    /* renamed from: i, reason: collision with root package name */
    public final y1.i f925i;

    /* renamed from: j, reason: collision with root package name */
    public String f926j;
    public final HashSet k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f927l;

    static {
        new AtomicInteger(1);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [H1.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [K1.i, java.lang.Object] */
    public d(u1.f fVar, J1.a aVar, ExecutorService executorService, y1.i iVar) {
        fVar.a();
        M1.c cVar = new M1.c(fVar.f6221a, aVar);
        E0.a aVar2 = new E0.a(fVar);
        if (H1.f.f660f == null) {
            H1.f.f660f = new Object();
        }
        H1.f fVar2 = H1.f.f660f;
        if (k.f935d == null) {
            k.f935d = new k(fVar2);
        }
        k kVar = k.f935d;
        x1.k kVar2 = new x1.k(new b(0, fVar));
        ?? obj = new Object();
        this.f923g = new Object();
        this.k = new HashSet();
        this.f927l = new ArrayList();
        this.f917a = fVar;
        this.f918b = cVar;
        this.f919c = aVar2;
        this.f920d = kVar;
        this.f921e = kVar2;
        this.f922f = obj;
        this.f924h = executorService;
        this.f925i = iVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r3 = f(r2);
        r4 = r6.f919c;
        r2 = r2.a();
        r2.f1000a = r3;
        r2.f1001b = 3;
        r2 = r2.a();
        r4.C(r2);
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r6 = this;
            java.lang.Object r0 = K1.d.f916m
            monitor-enter(r0)
            u1.f r1 = r6.f917a     // Catch: java.lang.Throwable -> L3f
            r1.a()     // Catch: java.lang.Throwable -> L3f
            android.content.Context r1 = r1.f6221a     // Catch: java.lang.Throwable -> L3f
            E0.a r1 = E0.a.d(r1)     // Catch: java.lang.Throwable -> L3f
            E0.a r2 = r6.f919c     // Catch: java.lang.Throwable -> L37
            L1.b r2 = r2.F()     // Catch: java.lang.Throwable -> L37
            int r3 = r2.f1010b     // Catch: java.lang.Throwable -> L37
            r4 = 2
            r5 = 1
            if (r3 == r4) goto L1e
            if (r3 != r5) goto L1d
            goto L1e
        L1d:
            r5 = 0
        L1e:
            if (r5 == 0) goto L39
            java.lang.String r3 = r6.f(r2)     // Catch: java.lang.Throwable -> L37
            E0.a r4 = r6.f919c     // Catch: java.lang.Throwable -> L37
            L1.a r2 = r2.a()     // Catch: java.lang.Throwable -> L37
            r2.f1000a = r3     // Catch: java.lang.Throwable -> L37
            r3 = 3
            r2.f1001b = r3     // Catch: java.lang.Throwable -> L37
            L1.b r2 = r2.a()     // Catch: java.lang.Throwable -> L37
            r4.C(r2)     // Catch: java.lang.Throwable -> L37
            goto L39
        L37:
            r2 = move-exception
            goto L51
        L39:
            if (r1 == 0) goto L41
            r1.G()     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
            r1 = move-exception
            goto L57
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            r6.i(r2)
            y1.i r0 = r6.f925i
            K1.c r1 = new K1.c
            r2 = 2
            r1.<init>(r6, r2)
            r0.execute(r1)
            return
        L51:
            if (r1 == 0) goto L56
            r1.G()     // Catch: java.lang.Throwable -> L3f
        L56:
            throw r2     // Catch: java.lang.Throwable -> L3f
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.d.a():void");
    }

    public final L1.b b(L1.b bVar) {
        int i4;
        int responseCode;
        boolean z;
        M1.b bVar2;
        M1.b bVar3;
        M1.c cVar = this.f918b;
        u1.f fVar = this.f917a;
        fVar.a();
        String str = fVar.f6223c.f6231a;
        String str2 = bVar.f1009a;
        u1.f fVar2 = this.f917a;
        fVar2.a();
        String str3 = fVar2.f6223c.f6237g;
        String str4 = bVar.f1012d;
        M1.d dVar = cVar.f1044c;
        if (dVar.a()) {
            URL a4 = M1.c.a("projects/" + str3 + "/installations/" + str2 + "/authTokens:generate");
            for (int i5 = 0; i5 <= 1; i5 = i4 + 1) {
                TrafficStats.setThreadStatsTag(32771);
                HttpURLConnection c4 = cVar.c(a4, str);
                try {
                    try {
                        c4.setRequestMethod("POST");
                        c4.addRequestProperty("Authorization", "FIS_v2 " + str4);
                        c4.setDoOutput(true);
                        M1.c.h(c4);
                        responseCode = c4.getResponseCode();
                        dVar.b(responseCode);
                        if (responseCode >= 200 && responseCode < 300) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } finally {
                        c4.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (IOException | AssertionError unused) {
                    i4 = i5;
                }
                if (z) {
                    bVar3 = M1.c.f(c4);
                } else {
                    M1.c.b(c4, null, str, str3);
                    i4 = i5;
                    if (responseCode != 401 && responseCode != 404) {
                        if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                                if (((byte) (0 | 1)) == 1) {
                                    bVar2 = new M1.b(0L, null, 2);
                                } else {
                                    throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                                }
                            }
                        } else {
                            throw new f("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                    } else if (((byte) (0 | 1)) == 1) {
                        bVar2 = new M1.b(0L, null, 3);
                    } else {
                        throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                    }
                    c4.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    bVar3 = bVar2;
                }
                int b4 = R.i.b(bVar3.f1039c);
                if (b4 != 0) {
                    if (b4 != 1) {
                        if (b4 == 2) {
                            synchronized (this) {
                                this.f926j = null;
                            }
                            L1.a a5 = bVar.a();
                            a5.f1001b = 2;
                            return a5.a();
                        }
                        throw new f("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    L1.a a6 = bVar.a();
                    a6.f1006g = "BAD CONFIG";
                    a6.f1001b = 5;
                    return a6.a();
                }
                String str5 = bVar3.f1037a;
                long j4 = bVar3.f1038b;
                k kVar = this.f920d;
                kVar.getClass();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                kVar.f936a.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                L1.a a7 = bVar.a();
                a7.f1002c = str5;
                a7.f1004e = j4;
                byte b5 = (byte) (a7.f1007h | 1);
                a7.f1005f = seconds;
                a7.f1007h = (byte) (b5 | 2);
                return a7.a();
            }
            throw new f("Firebase Installations Service is unavailable. Please try again later.");
        }
        throw new f("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final C0585n c() {
        String str;
        e();
        synchronized (this) {
            str = this.f926j;
        }
        if (str != null) {
            return AbstractC0602b.A(str);
        }
        C0580i c0580i = new C0580i();
        h hVar = new h(c0580i);
        synchronized (this.f923g) {
            this.f927l.add(hVar);
        }
        C0585n c0585n = c0580i.f5821a;
        this.f924h.execute(new c(this, 0));
        return c0585n;
    }

    public final C0585n d() {
        e();
        C0580i c0580i = new C0580i();
        g gVar = new g(this.f920d, c0580i);
        synchronized (this.f923g) {
            this.f927l.add(gVar);
        }
        C0585n c0585n = c0580i.f5821a;
        this.f924h.execute(new c(this, 1));
        return c0585n;
    }

    public final void e() {
        u1.f fVar = this.f917a;
        fVar.a();
        r.d(fVar.f6223c.f6232b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        fVar.a();
        r.d(fVar.f6223c.f6237g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        fVar.a();
        r.d(fVar.f6223c.f6231a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        fVar.a();
        String str = fVar.f6223c.f6232b;
        Pattern pattern = k.f934c;
        r.a("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", str.contains(":"));
        fVar.a();
        r.a("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.", k.f934c.matcher(fVar.f6223c.f6231a).matches());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
    
        if ("[DEFAULT]".equals(r0.f6222b) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(L1.b r6) {
        /*
            r5 = this;
            u1.f r0 = r5.f917a
            r0.a()
            java.lang.String r0 = r0.f6222b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            u1.f r0 = r5.f917a
            java.lang.String r1 = "[DEFAULT]"
            r0.a()
            java.lang.String r0 = r0.f6222b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5c
        L1e:
            int r6 = r6.f1010b
            r0 = 1
            if (r6 != r0) goto L5c
            x1.k r6 = r5.f921e
            java.lang.Object r6 = r6.get()
            L1.c r6 = (L1.c) r6
            android.content.SharedPreferences r0 = r6.f1017a
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r6.f1017a     // Catch: java.lang.Throwable -> L3f
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L3f
            android.content.SharedPreferences r2 = r6.f1017a     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = "|S|id"
            r4 = 0
            java.lang.String r2 = r2.getString(r3, r4)     // Catch: java.lang.Throwable -> L57
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L41
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            goto L46
        L3f:
            r6 = move-exception
            goto L5a
        L41:
            java.lang.String r2 = r6.a()     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
        L46:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L56
            K1.i r6 = r5.f922f
            r6.getClass()
            java.lang.String r6 = K1.i.a()
            return r6
        L56:
            return r2
        L57:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L57
            throw r6     // Catch: java.lang.Throwable -> L3f
        L5a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r6
        L5c:
            K1.i r6 = r5.f922f
            r6.getClass()
            java.lang.String r6 = K1.i.a()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.d.f(L1.b):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [M1.c] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [M1.a] */
    public final L1.b g(L1.b bVar) {
        int responseCode;
        boolean z;
        String str = bVar.f1009a;
        String str2 = null;
        if (str != null && str.length() == 11) {
            L1.c cVar = (L1.c) this.f921e.get();
            synchronized (cVar.f1017a) {
                try {
                    String[] strArr = L1.c.f1016c;
                    int i4 = 0;
                    while (true) {
                        if (i4 < 4) {
                            String str3 = strArr[i4];
                            String string = cVar.f1017a.getString("|T|" + cVar.f1018b + "|" + str3, null);
                            if (string != null && !string.isEmpty()) {
                                if (string.startsWith("{")) {
                                    try {
                                        str2 = new JSONObject(string).getString("token");
                                    } catch (JSONException unused) {
                                    }
                                } else {
                                    str2 = string;
                                }
                            } else {
                                i4++;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        M1.c cVar2 = this.f918b;
        u1.f fVar = this.f917a;
        fVar.a();
        String str4 = fVar.f6223c.f6231a;
        String str5 = bVar.f1009a;
        u1.f fVar2 = this.f917a;
        fVar2.a();
        String str6 = fVar2.f6223c.f6237g;
        u1.f fVar3 = this.f917a;
        fVar3.a();
        String str7 = fVar3.f6223c.f6232b;
        M1.d dVar = cVar2.f1044c;
        if (dVar.a()) {
            URL a4 = M1.c.a("projects/" + str6 + "/installations");
            int i5 = 0;
            M1.a aVar = cVar2;
            while (i5 <= 1) {
                TrafficStats.setThreadStatsTag(32769);
                HttpURLConnection c4 = aVar.c(a4, str4);
                try {
                    try {
                        c4.setRequestMethod("POST");
                        c4.setDoOutput(true);
                        if (str2 != null) {
                            c4.addRequestProperty("x-goog-fis-android-iid-migration-auth", str2);
                        }
                        M1.c.g(c4, str5, str7);
                        responseCode = c4.getResponseCode();
                        dVar.b(responseCode);
                        if (responseCode >= 200 && responseCode < 300) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } catch (IOException | AssertionError unused2) {
                    }
                    if (z) {
                        M1.a e4 = M1.c.e(c4);
                        c4.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        aVar = e4;
                    } else {
                        try {
                            M1.c.b(c4, str7, str4, str6);
                        } catch (IOException | AssertionError unused3) {
                            c4.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            i5++;
                            aVar = aVar;
                        }
                        if (responseCode != 429) {
                            if (responseCode >= 500 && responseCode < 600) {
                                c4.disconnect();
                                TrafficStats.clearThreadStatsTag();
                                i5++;
                                aVar = aVar;
                            } else {
                                Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                                M1.a aVar2 = new M1.a(null, null, null, null, 2);
                                c4.disconnect();
                                TrafficStats.clearThreadStatsTag();
                                aVar = aVar2;
                            }
                        } else {
                            throw new f("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                            break;
                        }
                    }
                    int b4 = R.i.b(aVar.f1036e);
                    if (b4 != 0) {
                        if (b4 == 1) {
                            L1.a a5 = bVar.a();
                            a5.f1006g = "BAD CONFIG";
                            a5.f1001b = 5;
                            return a5.a();
                        }
                        throw new f("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    String str8 = aVar.f1033b;
                    String str9 = aVar.f1034c;
                    k kVar = this.f920d;
                    kVar.getClass();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    kVar.f936a.getClass();
                    long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                    M1.b bVar2 = aVar.f1035d;
                    String str10 = bVar2.f1037a;
                    long j4 = bVar2.f1038b;
                    L1.a a6 = bVar.a();
                    a6.f1000a = str8;
                    a6.f1001b = 4;
                    a6.f1002c = str10;
                    a6.f1003d = str9;
                    a6.f1004e = j4;
                    byte b5 = (byte) (a6.f1007h | 1);
                    a6.f1005f = seconds;
                    a6.f1007h = (byte) (b5 | 2);
                    return a6.a();
                } finally {
                    c4.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            }
            throw new f("Firebase Installations Service is unavailable. Please try again later.");
        }
        throw new f("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void h(Exception exc) {
        synchronized (this.f923g) {
            try {
                Iterator it = this.f927l.iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).b(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(L1.b bVar) {
        synchronized (this.f923g) {
            try {
                Iterator it = this.f927l.iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).a(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
