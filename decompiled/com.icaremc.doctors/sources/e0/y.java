package e0;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2244a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f2245b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f2246c;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        f2244a = true;
        f2245b = true;
        if (i2 < 28) {
            z = false;
        }
        f2246c = z;
    }
}
