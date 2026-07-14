package M2;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public Method f1054a;

    /* renamed from: b, reason: collision with root package name */
    public Method f1055b;

    /* renamed from: c, reason: collision with root package name */
    public Method f1056c;

    public f(Method method, Method method2, Method method3) {
        this.f1054a = method;
        this.f1055b = method2;
        this.f1056c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT < 29) {
        } else {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
