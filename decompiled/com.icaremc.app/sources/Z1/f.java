package Z1;

import Z1.a;
import Z1.b;
import java.sql.Date;
import java.sql.Timestamp;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2199a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.C0000a f2200b;

    /* renamed from: c, reason: collision with root package name */
    public static final b.a f2201c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f2202d;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f2199a = z;
        if (z) {
            new e(Date.class, 0);
            new e(Timestamp.class, 1);
            f2200b = a.f2192b;
            f2201c = b.f2194b;
            f2202d = d.f2196b;
            return;
        }
        f2200b = null;
        f2201c = null;
        f2202d = null;
    }
}
