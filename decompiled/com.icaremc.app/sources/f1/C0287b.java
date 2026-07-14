package f1;

import A2.x;
import android.content.Context;

/* renamed from: f1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0287b {

    /* renamed from: b, reason: collision with root package name */
    public static final C0287b f3705b;

    /* renamed from: a, reason: collision with root package name */
    public x f3706a;

    /* JADX WARN: Type inference failed for: r0v0, types: [f1.b, java.lang.Object] */
    static {
        ?? obj = new Object();
        obj.f3706a = null;
        f3705b = obj;
    }

    public static x a(Context context) {
        x xVar;
        C0287b c0287b = f3705b;
        synchronized (c0287b) {
            try {
                if (c0287b.f3706a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    c0287b.f3706a = new x(context, false);
                }
                xVar = c0287b.f3706a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }
}
