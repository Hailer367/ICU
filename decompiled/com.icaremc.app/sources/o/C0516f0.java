package o;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import f1.AbstractC0286a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import q1.AbstractC0602b;

/* renamed from: o.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0516f0 extends TextView {

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5577f;

    /* renamed from: g, reason: collision with root package name */
    public final C0507c0 f5578g;

    /* renamed from: h, reason: collision with root package name */
    public final C0465C f5579h;

    /* renamed from: i, reason: collision with root package name */
    public C0549w f5580i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5581j;
    public j.O k;

    /* renamed from: l, reason: collision with root package name */
    public Future f5582l;

    public C0516f0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C0549w getEmojiTextViewHelper() {
        if (this.f5580i == null) {
            this.f5580i = new C0549w(this);
        }
        return this.f5580i;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            c0533o.a();
        }
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (E1.f5441b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0507c0 c0507c0 = this.f5578g;
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
        C0507c0 c0507c0 = this.f5578g;
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
        C0507c0 c0507c0 = this.f5578g;
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
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            return c0507c0.f5569i.f5649f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (E1.f5441b) {
            if (super.getAutoSizeTextType() == 1) {
                return 1;
            }
            return 0;
        }
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            return c0507c0.f5569i.f5644a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0286a.M(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public InterfaceC0510d0 getSuperCaller() {
        if (this.k == null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                this.k = new C0513e0(this);
            } else if (i4 >= 26) {
                this.k = new j.O(4, this);
            }
        }
        return this.k;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5578g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5578g.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f5582l;
        if (future != null) {
            try {
                this.f5582l = null;
                if (future.get() == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        throw null;
                    }
                    AbstractC0286a.u(this);
                    throw null;
                }
                throw new ClassCastException();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0465C c0465c;
        if (Build.VERSION.SDK_INT < 28 && (c0465c = this.f5579h) != null) {
            TextClassifier textClassifier = (TextClassifier) c0465c.f5423c;
            if (textClassifier == null) {
                return AbstractC0495V.a((TextView) c0465c.f5422b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    public G.c getTextMetricsParamsCompat() {
        return AbstractC0286a.u(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f5578g.getClass();
        C0507c0.h(editorInfo, onCreateInputConnection, this);
        android.support.v4.media.session.a.q(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        super.onLayout(z, i4, i5, i6, i7);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null && !E1.f5441b) {
            c0507c0.f5569i.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        Future future = this.f5582l;
        if (future != null) {
            try {
                this.f5582l = null;
                if (future.get() == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        throw null;
                    }
                    AbstractC0286a.u(this);
                    throw null;
                }
                throw new ClassCastException();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        C0507c0 c0507c0 = this.f5578g;
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
        C0507c0 c0507c0 = this.f5578g;
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
        C0507c0 c0507c0 = this.f5578g;
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
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.k(i4);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().d(i4);
        } else {
            AbstractC0286a.F(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i4);
        } else {
            AbstractC0286a.G(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i4) {
        if (i4 >= 0) {
            if (i4 != getPaint().getFontMetricsInt(null)) {
                setLineSpacing(i4 - r0, 1.0f);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setPrecomputedText(G.d dVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        AbstractC0286a.u(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5577f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5578g;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5578g;
        c0507c0.m(mode);
        c0507c0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.g(context, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C0465C c0465c;
        if (Build.VERSION.SDK_INT < 28 && (c0465c = this.f5579h) != null) {
            c0465c.f5423c = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<G.d> future) {
        this.f5582l = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(G.c cVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = cVar.f551b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i4 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i4 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i4 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i4 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i4 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i4 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i4 = 7;
            }
        }
        setTextDirection(i4);
        getPaint().set(cVar.f550a);
        setBreakStrategy(cVar.f552c);
        setHyphenationFrequency(cVar.f553d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i4, float f4) {
        boolean z = E1.f5441b;
        if (z) {
            super.setTextSize(i4, f4);
            return;
        }
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            C0530m0 c0530m0 = c0507c0.f5569i;
            if (!z && !c0530m0.f()) {
                c0530m0.g(i4, f4);
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i4) {
        Typeface typeface2;
        if (this.f5581j) {
            return;
        }
        if (typeface != null && i4 > 0) {
            Context context = getContext();
            AbstractC0602b abstractC0602b = B.f.f128a;
            if (context != null) {
                typeface2 = Typeface.create(typeface, i4);
            } else {
                throw new IllegalArgumentException("Context cannot be null");
            }
        } else {
            typeface2 = null;
        }
        this.f5581j = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i4);
        } finally {
            this.f5581j = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0516f0(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n1.a(context);
        this.f5581j = false;
        this.k = null;
        m1.a(this, getContext());
        C0533o c0533o = new C0533o(this);
        this.f5577f = c0533o;
        c0533o.d(attributeSet, i4);
        C0507c0 c0507c0 = new C0507c0(this);
        this.f5578g = c0507c0;
        c0507c0.f(attributeSet, i4);
        c0507c0.b();
        C0465C c0465c = new C0465C();
        c0465c.f5422b = this;
        this.f5579h = c0465c;
        getEmojiTextViewHelper().b(attributeSet, i4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i4 != 0 ? AbstractC0286a.o(context, i4) : null, i5 != 0 ? AbstractC0286a.o(context, i5) : null, i6 != 0 ? AbstractC0286a.o(context, i6) : null, i7 != 0 ? AbstractC0286a.o(context, i7) : null);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i4 != 0 ? AbstractC0286a.o(context, i4) : null, i5 != 0 ? AbstractC0286a.o(context, i5) : null, i6 != 0 ? AbstractC0286a.o(context, i6) : null, i7 != 0 ? AbstractC0286a.o(context, i7) : null);
        C0507c0 c0507c0 = this.f5578g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }
}
