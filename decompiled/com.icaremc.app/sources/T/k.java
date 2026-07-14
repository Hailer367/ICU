package T;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import t.C0657f;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f1555i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static volatile k f1556j;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f1557a;

    /* renamed from: b, reason: collision with root package name */
    public final C0657f f1558b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f1559c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f1560d;

    /* renamed from: e, reason: collision with root package name */
    public final f f1561e;

    /* renamed from: f, reason: collision with root package name */
    public final j f1562f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1563g;

    /* renamed from: h, reason: collision with root package name */
    public final d f1564h;

    public k(r rVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1557a = reentrantReadWriteLock;
        this.f1559c = 3;
        j jVar = rVar.f1587a;
        this.f1562f = jVar;
        int i4 = rVar.f1588b;
        this.f1563g = i4;
        this.f1564h = rVar.f1589c;
        this.f1560d = new Handler(Looper.getMainLooper());
        this.f1558b = new C0657f(0);
        f fVar = new f(this);
        this.f1561e = fVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i4 == 0) {
            try {
                this.f1559c = 0;
            } catch (Throwable th) {
                this.f1557a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                jVar.a(new e(fVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static k a() {
        k kVar;
        boolean z;
        synchronized (f1555i) {
            try {
                kVar = f1556j;
                if (kVar != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return kVar;
    }

    public final int b() {
        this.f1557a.readLock().lock();
        try {
            return this.f1559c;
        } finally {
            this.f1557a.readLock().unlock();
        }
    }

    public final void c() {
        boolean z;
        if (this.f1563g == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (b() == 1) {
                return;
            }
            this.f1557a.writeLock().lock();
            try {
                if (this.f1559c == 0) {
                    return;
                }
                this.f1559c = 0;
                this.f1557a.writeLock().unlock();
                f fVar = this.f1561e;
                k kVar = fVar.f1549a;
                try {
                    kVar.f1562f.a(new e(fVar));
                    return;
                } catch (Throwable th) {
                    kVar.d(th);
                    return;
                }
            } finally {
                this.f1557a.writeLock().unlock();
            }
        }
        throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1557a.writeLock().lock();
        try {
            this.f1559c = 2;
            arrayList.addAll(this.f1558b);
            this.f1558b.clear();
            this.f1557a.writeLock().unlock();
            this.f1560d.post(new i(arrayList, this.f1559c, th));
        } catch (Throwable th2) {
            this.f1557a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0160, code lost:
    
        if (r4 != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0162, code lost:
    
        ((T.u) r12).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0168, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0143 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:119:0x0051, B:122:0x0056, B:124:0x005a, B:126:0x0067, B:32:0x007a, B:34:0x0084, B:36:0x0087, B:38:0x008b, B:40:0x009b, B:42:0x009e, B:46:0x00ab, B:49:0x00b3, B:54:0x00d2, B:78:0x00de, B:82:0x00ea, B:83:0x00f4, B:66:0x0103, B:69:0x010a, B:57:0x010f, B:59:0x011a, B:88:0x0121, B:90:0x0125, B:92:0x012b, B:94:0x012f, B:97:0x0137, B:100:0x0143, B:101:0x0148, B:103:0x0156, B:30:0x0070), top: B:118:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0156 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #0 {all -> 0x006d, blocks: (B:119:0x0051, B:122:0x0056, B:124:0x005a, B:126:0x0067, B:32:0x007a, B:34:0x0084, B:36:0x0087, B:38:0x008b, B:40:0x009b, B:42:0x009e, B:46:0x00ab, B:49:0x00b3, B:54:0x00d2, B:78:0x00de, B:82:0x00ea, B:83:0x00f4, B:66:0x0103, B:69:0x010a, B:57:0x010f, B:59:0x011a, B:88:0x0121, B:90:0x0125, B:92:0x012b, B:94:0x012f, B:97:0x0137, B:100:0x0143, B:101:0x0148, B:103:0x0156, B:30:0x0070), top: B:118:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:119:0x0051, B:122:0x0056, B:124:0x005a, B:126:0x0067, B:32:0x007a, B:34:0x0084, B:36:0x0087, B:38:0x008b, B:40:0x009b, B:42:0x009e, B:46:0x00ab, B:49:0x00b3, B:54:0x00d2, B:78:0x00de, B:82:0x00ea, B:83:0x00f4, B:66:0x0103, B:69:0x010a, B:57:0x010f, B:59:0x011a, B:88:0x0121, B:90:0x0125, B:92:0x012b, B:94:0x012f, B:97:0x0137, B:100:0x0143, B:101:0x0148, B:103:0x0156, B:30:0x0070), top: B:118:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T.k.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(h hVar) {
        android.support.v4.media.session.a.h(hVar, "initCallback cannot be null");
        this.f1557a.writeLock().lock();
        try {
            if (this.f1559c != 1 && this.f1559c != 2) {
                this.f1558b.add(hVar);
                this.f1557a.writeLock().unlock();
            }
            this.f1560d.post(new i(Arrays.asList(hVar), this.f1559c, null));
            this.f1557a.writeLock().unlock();
        } catch (Throwable th) {
            this.f1557a.writeLock().unlock();
            throw th;
        }
    }
}
