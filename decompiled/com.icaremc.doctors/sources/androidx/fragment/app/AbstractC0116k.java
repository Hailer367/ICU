package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0116k {

    /* renamed from: a, reason: collision with root package name */
    public final E0 f1665a;

    public AbstractC0116k(E0 operation) {
        kotlin.jvm.internal.h.e(operation, "operation");
        this.f1665a = operation;
    }

    public final boolean a() {
        int i2;
        E0 e02 = this.f1665a;
        View view = e02.f1536c.mView;
        if (view != null) {
            i2 = 4;
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility != 0) {
                    if (visibility != 4) {
                        if (visibility == 8) {
                            i2 = 3;
                        } else {
                            throw new IllegalArgumentException(O.a.c(visibility, "Unknown visibility "));
                        }
                    }
                } else {
                    i2 = 2;
                }
            }
        } else {
            i2 = 0;
        }
        int i3 = e02.f1534a;
        if (i2 != i3) {
            if (i2 == 2 || i3 == 2) {
                return false;
            }
            return true;
        }
        return true;
    }
}
