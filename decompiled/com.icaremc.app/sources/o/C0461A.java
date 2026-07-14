package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import f1.AbstractC0286a;

/* renamed from: o.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0461A extends MultiAutoCompleteTextView {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f5388i = {R.attr.popupBackground};

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5389f;

    /* renamed from: g, reason: collision with root package name */
    public final C0507c0 f5390g;

    /* renamed from: h, reason: collision with root package name */
    public final C0465C f5391h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0461A(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.icaremc.app.R.attr.autoCompleteTextViewStyle);
        n1.a(context);
        m1.a(this, getContext());
        A2.t P = A2.t.P(getContext(), attributeSet, f5388i, com.icaremc.app.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) P.f100h).hasValue(0)) {
            setDropDownBackgroundDrawable(P.H(0));
        }
        P.T();
        C0533o c0533o = new C0533o(this);
        this.f5389f = c0533o;
        c0533o.d(attributeSet, com.icaremc.app.R.attr.autoCompleteTextViewStyle);
        C0507c0 c0507c0 = new C0507c0(this);
        this.f5390g = c0507c0;
        c0507c0.f(attributeSet, com.icaremc.app.R.attr.autoCompleteTextViewStyle);
        c0507c0.b();
        C0465C c0465c = new C0465C(this);
        this.f5391h = c0465c;
        c0465c.b(attributeSet, com.icaremc.app.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = isFocusable();
            boolean isClickable = isClickable();
            boolean isLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener a4 = c0465c.a(keyListener);
            if (a4 != keyListener) {
                super.setKeyListener(a4);
                setRawInputType(inputType);
                setFocusable(isFocusable);
                setClickable(isClickable);
                setLongClickable(isLongClickable);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            c0533o.a();
        }
        C0507c0 c0507c0 = this.f5390g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5390g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5390g.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        android.support.v4.media.session.a.q(editorInfo, onCreateInputConnection, this);
        return this.f5391h.c(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5390g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5390g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i4) {
        setDropDownBackgroundDrawable(AbstractC0286a.o(getContext(), i4));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f5391h.d(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f5391h.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5389f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5390g;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5390g;
        c0507c0.m(mode);
        c0507c0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0507c0 c0507c0 = this.f5390g;
        if (c0507c0 != null) {
            c0507c0.g(context, i4);
        }
    }
}
