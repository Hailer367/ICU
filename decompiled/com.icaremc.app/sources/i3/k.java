package i3;

import g3.t;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4180a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f4181b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f4182c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f4183d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f4184e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f4185f;

    static {
        String str;
        int i4 = t.f3809a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f4180a = str;
        f4181b = g3.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i5 = t.f3809a;
        if (i5 < 2) {
            i5 = 2;
        }
        f4182c = g3.a.j(i5, "kotlinx.coroutines.scheduler.core.pool.size", 8);
        f4183d = g3.a.j(2097150, "kotlinx.coroutines.scheduler.max.pool.size", 4);
        f4184e = TimeUnit.SECONDS.toNanos(g3.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f4185f = g.f4175a;
    }
}
