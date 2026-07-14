package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.icaremc.app.R;
import f1.AbstractC0286a;

/* renamed from: o.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0535p extends Button {

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5679f;

    /* renamed from: g, reason: collision with root package name */
    public final C0507c0 f5680g;

    /* renamed from: h, reason: collision with root package name */
    public C0549w f5681h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0535p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
        n1.a(context);
        m1.a(this, getContext());
        C0533o c0533o = new C0533o(this);
        this.f5679f = c0533o;
        c0533o.d(attributeSet, R.attr.buttonStyle);
        C0507c0 c0507c0 = new C0507c0(this);
        this.f5680g = c0507c0;
        c0507c0.f(attributeSet, R.attr.buttonStyle);
        c0507c0.b();
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyle);
    }

    private C0549w getEmojiTextViewHelper() {
        if (this.f5681h == null) {
            this.f5681h = new C0549w(this);
        }
        return this.f5681h;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            c0533o.a();
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (E1.f5441b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            return Math.round(c0507c0.f5569i.f5648e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (E1.f5441b) {
            return super.getAutoSizeMinTextSize();
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            return Math.round(c0507c0.f5569i.f5647d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (E1.f5441b) {
            return super.getAutoSizeStepGranularity();
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            return Math.round(c0507c0.f5569i.f5646c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (E1.f5441b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            return c0507c0.f5569i.f5649f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (E1.f5441b) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 == null) {
            return 0;
        }
        return c0507c0.f5569i.f5644a;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0286a.M(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5680g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5680g.e();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        super.onLayout(z, i4, i5, i6, i7);
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null && !E1.f5441b) {
            c0507c0.f5569i.a();
        }
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            C0530m0 c0530m0 = c0507c0.f5569i;
            if (!E1.f5441b && c0530m0.f()) {
                c0530m0.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i4, int i5, int i6, int i7) {
        if (E1.f5441b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
            return;
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            c0507c0.i(i4, i5, i6, i7);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i4) {
        if (E1.f5441b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
            return;
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            c0507c0.j(iArr, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i4) {
        if (E1.f5441b) {
            super.setAutoSizeTextTypeWithDefaults(i4);
            return;
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            c0507c0.k(i4);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0286a.N(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            c0507c0.f5561a.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5679f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5680g;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5680g;
        c0507c0.m(mode);
        c0507c0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            c0507c0.g(context, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i4, float f4) {
        boolean z = E1.f5441b;
        if (z) {
            super.setTextSize(i4, f4);
            return;
        }
        C0507c0 c0507c0 = this.f5680g;
        if (c0507c0 != null) {
            C0530m0 c0530m0 = c0507c0.f5569i;
            if (!z && !c0530m0.f()) {
                c0530m0.g(i4, f4);
            }
        }
    }
}
