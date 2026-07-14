package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.icaremc.app.R;
import i.AbstractC0357a;

/* renamed from: o.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0475H extends C0465C {

    /* renamed from: e, reason: collision with root package name */
    public final C0473G f5459e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f5460f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f5461g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f5462h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5463i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5464j;

    public C0475H(C0473G c0473g) {
        super(c0473g);
        this.f5461g = null;
        this.f5462h = null;
        this.f5463i = false;
        this.f5464j = false;
        this.f5459e = c0473g;
    }

    @Override // o.C0465C
    public final void b(AttributeSet attributeSet, int i4) {
        super.b(attributeSet, R.attr.seekBarStyle);
        C0473G c0473g = this.f5459e;
        Context context = c0473g.getContext();
        int[] iArr = AbstractC0357a.f4072g;
        A2.t P = A2.t.P(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) P.f100h;
        I.T.h(c0473g, c0473g.getContext(), iArr, attributeSet, (TypedArray) P.f100h, R.attr.seekBarStyle);
        Drawable I3 = P.I(0);
        if (I3 != null) {
            c0473g.setThumb(I3);
        }
        Drawable H3 = P.H(1);
        Drawable drawable = this.f5460f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f5460f = H3;
        if (H3 != null) {
            H3.setCallback(c0473g);
            H3.setLayoutDirection(c0473g.getLayoutDirection());
            if (H3.isStateful()) {
                H3.setState(c0473g.getDrawableState());
            }
            f();
        }
        c0473g.invalidate();
        if (typedArray.hasValue(3)) {
            this.f5462h = AbstractC0546u0.c(typedArray.getInt(3, -1), this.f5462h);
            this.f5464j = true;
        }
        if (typedArray.hasValue(2)) {
            this.f5461g = P.G(2);
            this.f5463i = true;
        }
        P.T();
        f();
    }

    public final void f() {
        Drawable drawable = this.f5460f;
        if (drawable != null) {
            if (this.f5463i || this.f5464j) {
                Drawable mutate = drawable.mutate();
                this.f5460f = mutate;
                if (this.f5463i) {
                    mutate.setTintList(this.f5461g);
                }
                if (this.f5464j) {
                    this.f5460f.setTintMode(this.f5462h);
                }
                if (this.f5460f.isStateful()) {
                    this.f5460f.setState(this.f5459e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        int i4;
        if (this.f5460f != null) {
            int max = this.f5459e.getMax();
            int i5 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f5460f.getIntrinsicWidth();
                int intrinsicHeight = this.f5460f.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i4 = intrinsicWidth / 2;
                } else {
                    i4 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i5 = intrinsicHeight / 2;
                }
                this.f5460f.setBounds(-i4, -i5, i4, i5);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i6 = 0; i6 <= max; i6++) {
                    this.f5460f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
