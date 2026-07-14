package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import h.AbstractC0201a;
import java.lang.reflect.Field;

/* renamed from: m.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0266m {

    /* renamed from: a, reason: collision with root package name */
    public final View f3191a;

    /* renamed from: b, reason: collision with root package name */
    public final C0268o f3192b;

    /* renamed from: c, reason: collision with root package name */
    public int f3193c = -1;

    /* renamed from: d, reason: collision with root package name */
    public h0 f3194d;

    /* renamed from: e, reason: collision with root package name */
    public h0 f3195e;

    /* renamed from: f, reason: collision with root package name */
    public h0 f3196f;

    public C0266m(View view) {
        C0268o c0268o;
        this.f3191a = view;
        PorterDuff.Mode mode = C0268o.f3205b;
        synchronized (C0268o.class) {
            try {
                if (C0268o.f3206c == null) {
                    C0268o.b();
                }
                c0268o = C0268o.f3206c;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3192b = c0268o;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, m.h0] */
    public final void a() {
        View view = this.f3191a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f3194d != null) {
                if (this.f3196f == null) {
                    this.f3196f = new Object();
                }
                h0 h0Var = this.f3196f;
                h0Var.f3171a = null;
                h0Var.f3174d = false;
                h0Var.f3172b = null;
                h0Var.f3173c = false;
                Field field = E.J.f180a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    h0Var.f3174d = true;
                    h0Var.f3171a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    h0Var.f3173c = true;
                    h0Var.f3172b = backgroundTintMode;
                }
                if (h0Var.f3174d || h0Var.f3173c) {
                    C0268o.c(background, h0Var, view.getDrawableState());
                    return;
                }
            }
            h0 h0Var2 = this.f3195e;
            if (h0Var2 != null) {
                C0268o.c(background, h0Var2, view.getDrawableState());
                return;
            }
            h0 h0Var3 = this.f3194d;
            if (h0Var3 != null) {
                C0268o.c(background, h0Var3, view.getDrawableState());
            }
        }
    }

    public final void b(AttributeSet attributeSet, int i2) {
        ColorStateList f2;
        View view = this.f3191a;
        A0.g i3 = A0.g.i(view.getContext(), attributeSet, AbstractC0201a.f2316u, i2);
        TypedArray typedArray = (TypedArray) i3.f31e;
        try {
            if (typedArray.hasValue(0)) {
                this.f3193c = typedArray.getResourceId(0, -1);
                C0268o c0268o = this.f3192b;
                Context context = view.getContext();
                int i4 = this.f3193c;
                synchronized (c0268o) {
                    f2 = c0268o.f3207a.f(context, i4);
                }
                if (f2 != null) {
                    d(f2);
                }
            }
            if (typedArray.hasValue(1)) {
                ColorStateList d2 = i3.d(1);
                Field field = E.J.f180a;
                view.setBackgroundTintList(d2);
            }
            if (typedArray.hasValue(2)) {
                PorterDuff.Mode c2 = AbstractC0277y.c(typedArray.getInt(2, -1), null);
                Field field2 = E.J.f180a;
                view.setBackgroundTintMode(c2);
            }
        } finally {
            i3.k();
        }
    }

    public final void c(int i2) {
        ColorStateList colorStateList;
        this.f3193c = i2;
        C0268o c0268o = this.f3192b;
        if (c0268o != null) {
            Context context = this.f3191a.getContext();
            synchronized (c0268o) {
                colorStateList = c0268o.f3207a.f(context, i2);
            }
        } else {
            colorStateList = null;
        }
        d(colorStateList);
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, m.h0] */
    public final void d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3194d == null) {
                this.f3194d = new Object();
            }
            h0 h0Var = this.f3194d;
            h0Var.f3171a = colorStateList;
            h0Var.f3174d = true;
        } else {
            this.f3194d = null;
        }
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, m.h0] */
    public final void e(ColorStateList colorStateList) {
        if (this.f3195e == null) {
            this.f3195e = new Object();
        }
        h0 h0Var = this.f3195e;
        h0Var.f3171a = colorStateList;
        h0Var.f3174d = true;
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, m.h0] */
    public final void f(PorterDuff.Mode mode) {
        if (this.f3195e == null) {
            this.f3195e = new Object();
        }
        h0 h0Var = this.f3195e;
        h0Var.f3172b = mode;
        h0Var.f3173c = true;
        a();
    }
}
