package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import i.AbstractC0203a;

/* renamed from: m.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0265l extends AutoCompleteTextView {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f3186e = {R.attr.popupBackground};

    /* renamed from: c, reason: collision with root package name */
    public final C0266m f3187c;

    /* renamed from: d, reason: collision with root package name */
    public final C0272t f3188d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0265l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.icaremc.doctors.R.attr.autoCompleteTextViewStyle);
        g0.a(context);
        A0.g i2 = A0.g.i(getContext(), attributeSet, f3186e, com.icaremc.doctors.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) i2.f31e).hasValue(0)) {
            setDropDownBackgroundDrawable(i2.e(0));
        }
        i2.k();
        C0266m c0266m = new C0266m(this);
        this.f3187c = c0266m;
        c0266m.b(attributeSet, com.icaremc.doctors.R.attr.autoCompleteTextViewStyle);
        C0272t c0272t = new C0272t(this);
        this.f3188d = c0272t;
        c0272t.d(attributeSet, com.icaremc.doctors.R.attr.autoCompleteTextViewStyle);
        c0272t.b();
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0266m c0266m = this.f3187c;
        if (c0266m != null) {
            c0266m.a();
        }
        C0272t c0272t = this.f3188d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        h0 h0Var;
        C0266m c0266m = this.f3187c;
        if (c0266m == null || (h0Var = c0266m.f3195e) == null) {
            return null;
        }
        return h0Var.f3171a;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        h0 h0Var;
        C0266m c0266m = this.f3187c;
        if (c0266m == null || (h0Var = c0266m.f3195e) == null) {
            return null;
        }
        return h0Var.f3172b;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0266m c0266m = this.f3187c;
        if (c0266m != null) {
            c0266m.f3193c = -1;
            c0266m.d(null);
            c0266m.a();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0266m c0266m = this.f3187c;
        if (c0266m != null) {
            c0266m.c(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.a.K(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(AbstractC0203a.a(getContext(), i2));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0266m c0266m = this.f3187c;
        if (c0266m != null) {
            c0266m.e(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0266m c0266m = this.f3187c;
        if (c0266m != null) {
            c0266m.f(mode);
        }
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0272t c0272t = this.f3188d;
        if (c0272t != null) {
            c0272t.e(context, i2);
        }
    }
}
