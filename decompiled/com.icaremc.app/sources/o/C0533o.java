package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import i.AbstractC0357a;
import java.util.WeakHashMap;

/* renamed from: o.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0533o {

    /* renamed from: a, reason: collision with root package name */
    public final View f5669a;

    /* renamed from: d, reason: collision with root package name */
    public o1 f5672d;

    /* renamed from: e, reason: collision with root package name */
    public o1 f5673e;

    /* renamed from: f, reason: collision with root package name */
    public o1 f5674f;

    /* renamed from: c, reason: collision with root package name */
    public int f5671c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final C0543t f5670b = C0543t.a();

    public C0533o(View view) {
        this.f5669a = view;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [o.o1, java.lang.Object] */
    public final void a() {
        View view = this.f5669a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f5672d != null) {
                if (this.f5674f == null) {
                    this.f5674f = new Object();
                }
                o1 o1Var = this.f5674f;
                o1Var.f5675a = null;
                o1Var.f5678d = false;
                o1Var.f5676b = null;
                o1Var.f5677c = false;
                WeakHashMap weakHashMap = I.T.f702a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    o1Var.f5678d = true;
                    o1Var.f5675a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    o1Var.f5677c = true;
                    o1Var.f5676b = backgroundTintMode;
                }
                if (o1Var.f5678d || o1Var.f5677c) {
                    C0543t.d(background, o1Var, view.getDrawableState());
                    return;
                }
            }
            o1 o1Var2 = this.f5673e;
            if (o1Var2 != null) {
                C0543t.d(background, o1Var2, view.getDrawableState());
                return;
            }
            o1 o1Var3 = this.f5672d;
            if (o1Var3 != null) {
                C0543t.d(background, o1Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        o1 o1Var = this.f5673e;
        if (o1Var != null) {
            return o1Var.f5675a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        o1 o1Var = this.f5673e;
        if (o1Var != null) {
            return o1Var.f5676b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i4) {
        ColorStateList f4;
        View view = this.f5669a;
        Context context = view.getContext();
        int[] iArr = AbstractC0357a.f4064A;
        A2.t P = A2.t.P(context, attributeSet, iArr, i4);
        TypedArray typedArray = (TypedArray) P.f100h;
        View view2 = this.f5669a;
        I.T.h(view2, view2.getContext(), iArr, attributeSet, (TypedArray) P.f100h, i4);
        try {
            if (typedArray.hasValue(0)) {
                this.f5671c = typedArray.getResourceId(0, -1);
                C0543t c0543t = this.f5670b;
                Context context2 = view.getContext();
                int i5 = this.f5671c;
                synchronized (c0543t) {
                    f4 = c0543t.f5709a.f(context2, i5);
                }
                if (f4 != null) {
                    g(f4);
                }
            }
            if (typedArray.hasValue(1)) {
                view.setBackgroundTintList(P.G(1));
            }
            if (typedArray.hasValue(2)) {
                view.setBackgroundTintMode(AbstractC0546u0.c(typedArray.getInt(2, -1), null));
            }
            P.T();
        } catch (Throwable th) {
            P.T();
            throw th;
        }
    }

    public final void e() {
        this.f5671c = -1;
        g(null);
        a();
    }

    public final void f(int i4) {
        ColorStateList colorStateList;
        this.f5671c = i4;
        C0543t c0543t = this.f5670b;
        if (c0543t != null) {
            Context context = this.f5669a.getContext();
            synchronized (c0543t) {
                colorStateList = c0543t.f5709a.f(context, i4);
            }
        } else {
            colorStateList = null;
        }
        g(colorStateList);
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.o1, java.lang.Object] */
    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f5672d == null) {
                this.f5672d = new Object();
            }
            o1 o1Var = this.f5672d;
            o1Var.f5675a = colorStateList;
            o1Var.f5678d = true;
        } else {
            this.f5672d = null;
        }
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.o1, java.lang.Object] */
    public final void h(ColorStateList colorStateList) {
        if (this.f5673e == null) {
            this.f5673e = new Object();
        }
        o1 o1Var = this.f5673e;
        o1Var.f5675a = colorStateList;
        o1Var.f5678d = true;
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.o1, java.lang.Object] */
    public final void i(PorterDuff.Mode mode) {
        if (this.f5673e == null) {
            this.f5673e = new Object();
        }
        o1 o1Var = this.f5673e;
        o1Var.f5676b = mode;
        o1Var.f5677c = true;
        a();
    }
}
