package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* renamed from: o.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0532n0 extends ToggleButton {

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5665f;

    /* renamed from: g, reason: collision with root package name */
    public final C0507c0 f5666g;

    /* renamed from: h, reason: collision with root package name */
    public C0549w f5667h;

    public C0532n0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        m1.a(this, getContext());
        C0533o c0533o = new C0533o(this);
        this.f5665f = c0533o;
        c0533o.d(attributeSet, R.attr.buttonStyleToggle);
        C0507c0 c0507c0 = new C0507c0(this);
        this.f5666g = c0507c0;
        c0507c0.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyleToggle);
    }

    private C0549w getEmojiTextViewHelper() {
        if (this.f5667h == null) {
            this.f5667h = new C0549w(this);
        }
        return this.f5667h;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            c0533o.a();
        }
        C0507c0 c0507c0 = this.f5666g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5666g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5666g.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5666g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5666g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5665f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5666g;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5666g;
        c0507c0.m(mode);
        c0507c0.b();
    }
}
