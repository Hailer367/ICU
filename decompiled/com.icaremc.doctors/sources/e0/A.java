package e0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class A {

    /* renamed from: a, reason: collision with root package name */
    public static final B f2157a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0180c f2158b;

    /* JADX WARN: Type inference failed for: r0v1, types: [e0.B, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [e0.B, java.lang.Object] */
    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2157a = new Object();
        } else {
            f2157a = new Object();
        }
        f2158b = new C0180c("translationAlpha", 5, Float.class);
        new C0180c("clipBounds", 6, Rect.class);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f2157a.X(view, i2, i3, i4, i5);
    }
}
