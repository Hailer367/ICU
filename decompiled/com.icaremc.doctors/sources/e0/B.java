package e0;

import a.AbstractC0051a;
import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class B extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f2159f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f2160g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f2161h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f2162i = true;

    @Override // a.AbstractC0051a
    public void Q(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.Q(view, i2);
        } else if (f2162i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f2162i = false;
            }
        }
    }

    public void X(View view, int i2, int i3, int i4, int i5) {
        if (f2161h) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f2161h = false;
            }
        }
    }

    public void Y(View view, Matrix matrix) {
        if (f2159f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2159f = false;
            }
        }
    }

    public void Z(View view, Matrix matrix) {
        if (f2160g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2160g = false;
            }
        }
    }
}
