package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.icaremc.app.R;
import f1.AbstractC0286a;

/* renamed from: o.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0537q extends CheckBox {

    /* renamed from: f, reason: collision with root package name */
    public final C0541s f5682f;

    /* renamed from: g, reason: collision with root package name */
    public final C0533o f5683g;

    /* renamed from: h, reason: collision with root package name */
    public final C0507c0 f5684h;

    /* renamed from: i, reason: collision with root package name */
    public C0549w f5685i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0537q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkboxStyle);
        n1.a(context);
        m1.a(this, getContext());
        C0541s c0541s = new C0541s(this);
        this.f5682f = c0541s;
        c0541s.c(attributeSet, R.attr.checkboxStyle);
        C0533o c0533o = new C0533o(this);
        this.f5683g = c0533o;
        c0533o.d(attributeSet, R.attr.checkboxStyle);
        C0507c0 c0507c0 = new C0507c0(this);
        this.f5684h = c0507c0;
        c0507c0.f(attributeSet, R.attr.checkboxStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.checkboxStyle);
    }

    private C0549w getEmojiTextViewHelper() {
        if (this.f5685i == null) {
            this.f5685i = new C0549w(this);
        }
        return this.f5685i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            c0533o.a();
        }
        C0507c0 c0507c0 = this.f5684h;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0541s c0541s = this.f5682f;
        if (c0541s != null) {
            c0541s.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0541s c0541s = this.f5682f;
        if (c0541s != null) {
            return (ColorStateList) c0541s.f5692a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0541s c0541s = this.f5682f;
        if (c0541s != null) {
            return (PorterDuff.Mode) c0541s.f5693b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5684h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5684h.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0541s c0541s = this.f5682f;
        if (c0541s != null) {
            if (c0541s.f5696e) {
                c0541s.f5696e = false;
            } else {
                c0541s.f5696e = true;
                c0541s.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5684h;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5684h;
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
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5683g;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0541s c0541s = this.f5682f;
        if (c0541s != null) {
            c0541s.f5692a = colorStateList;
            c0541s.f5694c = true;
            c0541s.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0541s c0541s = this.f5682f;
        if (c0541s != null) {
            c0541s.f5693b = mode;
            c0541s.f5695d = true;
            c0541s.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5684h;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5684h;
        c0507c0.m(mode);
        c0507c0.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i4) {
        setButtonDrawable(AbstractC0286a.o(getContext(), i4));
    }
}
