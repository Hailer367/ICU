package s1;

import java.util.concurrent.TimeUnit;
import q1.t;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3623a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f3624b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f3625c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f3626d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f3627e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f3628f;

    static {
        String str;
        int i2 = t.f3544a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f3623a = str;
        f3624b = q1.a.i(100000L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        int i3 = t.f3544a;
        if (i3 < 2) {
            i3 = 2;
        }
        f3625c = q1.a.j("kotlinx.coroutines.scheduler.core.pool.size", i3, 8);
        f3626d = q1.a.j("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 4);
        f3627e = TimeUnit.SECONDS.toNanos(q1.a.i(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f3628f = g.f3618a;
    }
}
