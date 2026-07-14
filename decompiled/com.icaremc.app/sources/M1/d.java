package M1;

import H1.f;
import K1.k;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final long f1045d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    public static final long f1046e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    public final k f1047a;

    /* renamed from: b, reason: collision with root package name */
    public long f1048b;

    /* renamed from: c, reason: collision with root package name */
    public int f1049c;

    /* JADX WARN: Type inference failed for: r0v4, types: [H1.f, java.lang.Object] */
    public d() {
        if (f.f660f == null) {
            Pattern pattern = k.f934c;
            f.f660f = new Object();
        }
        f fVar = f.f660f;
        if (k.f935d == null) {
            k.f935d = new k(fVar);
        }
        this.f1047a = k.f935d;
    }

    public final synchronized boolean a() {
        boolean z;
        if (this.f1049c != 0) {
            this.f1047a.f936a.getClass();
            if (System.currentTimeMillis() <= this.f1048b) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void b(int i4) {
        long min;
        if ((i4 < 200 || i4 >= 300) && i4 != 401 && i4 != 404) {
            this.f1049c++;
            synchronized (this) {
                if (i4 != 429 && (i4 < 500 || i4 >= 600)) {
                    min = f1045d;
                } else {
                    double pow = Math.pow(2.0d, this.f1049c);
                    this.f1047a.getClass();
                    min = (long) Math.min(pow + ((long) (Math.random() * 1000.0d)), f1046e);
                }
                this.f1047a.f936a.getClass();
                this.f1048b = System.currentTimeMillis() + min;
            }
            return;
        }
        synchronized (this) {
            this.f1049c = 0;
        }
        return;
    }
}
