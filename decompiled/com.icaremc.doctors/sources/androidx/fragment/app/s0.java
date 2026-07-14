package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x0 f1751a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final z0 f1752b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.x0, java.lang.Object] */
    static {
        z0 z0Var = null;
        try {
            z0Var = (z0) e0.n.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f1752b = z0Var;
    }

    public static final void a(int i2, ArrayList views) {
        kotlin.jvm.internal.h.e(views, "views");
        int size = views.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = views.get(i3);
            i3++;
            ((View) obj).setVisibility(i2);
        }
    }
}
