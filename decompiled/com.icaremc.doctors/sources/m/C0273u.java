package m;

import a.AbstractC0051a;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import i.AbstractC0203a;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: m.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0273u extends TextView implements H.b {

    /* renamed from: c, reason: collision with root package name */
    public final C0266m f3262c;

    /* renamed from: d, reason: collision with root package name */
    public final C0272t f3263d;

    /* renamed from: e, reason: collision with root package name */
    public final B.c f3264e;

    /* renamed from: f, reason: collision with root package name */
    public Future f3265f;

    public C0273u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0266m c0266m = this.f3262c;
        if (c0266m != null) {
            c0266m.a();
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (H.b.f286a) {
            return super.getAutoSizeMaxTextSize();
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            return Math.round(c0272t.f3257i.f3273e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (H.b.f286a) {
            return super.getAutoSizeMinTextSize();
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            return Math.round(c0272t.f3257i.f3272d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (H.b.f286a) {
            return super.getAutoSizeStepGranularity();
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            return Math.round(c0272t.f3257i.f3271c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (H.b.f286a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            return c0272t.f3257i.f3274f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (H.b.f286a) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        C0272t c0272t = this.f3263d;
        if (c0272t == null) {
            return 0;
        }
        return c0272t.f3257i.f3269a;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        h0 h0Var;
        C0266m c0266m = this.f3262c;
        if (c0266m == null || (h0Var = c0266m.f3195e) == null) {
            return null;
        }
        return h0Var.f3171a;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        h0 h0Var;
        C0266m c0266m = this.f3262c;
        if (c0266m == null || (h0Var = c0266m.f3195e) == null) {
            return null;
        }
        return h0Var.f3172b;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        h0 h0Var = this.f3263d.f3256h;
        if (h0Var != null) {
            return h0Var.f3171a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        h0 h0Var = this.f3263d.f3256h;
        if (h0Var != null) {
            return h0Var.f3172b;
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f3265f;
        if (future != null) {
            try {
                this.f3265f = null;
                if (future.get() == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        throw null;
                    }
                    android.support.v4.media.session.a.r(this);
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
        B.c cVar;
        if (Build.VERSION.SDK_INT < 28 && (cVar = this.f3264e) != null) {
            TextClassifier textClassifier = (TextClassifier) cVar.f40e;
            if (textClassifier == null) {
                TextClassificationManager textClassificationManager = (TextClassificationManager) ((C0273u) cVar.f39d).getContext().getSystemService(TextClassificationManager.class);
                if (textClassificationManager != null) {
                    return textClassificationManager.getTextClassifier();
                }
                return TextClassifier.NO_OP;
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    public C.c getTextMetricsParamsCompat() {
        return android.support.v4.media.session.a.r(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        C0272t c0272t = this.f3263d;
        if (c0272t != null && !H.b.f286a) {
            c0272t.f3257i.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Future future = this.f3265f;
        if (future != null) {
            try {
                this.f3265f = null;
                if (future.get() == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        throw null;
                    }
                    android.support.v4.media.session.a.r(this);
                    throw null;
                }
                throw new ClassCastException();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        C0272t c0272t = this.f3263d;
        if (c0272t != null && !H.b.f286a) {
            C0274v c0274v = c0272t.f3257i;
            if (c0274v.f3269a != 0) {
                c0274v.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (H.b.f286a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            C0274v c0274v = c0272t.f3257i;
            DisplayMetrics displayMetrics = c0274v.f3278j.getResources().getDisplayMetrics();
            c0274v.i(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (c0274v.g()) {
                c0274v.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (H.b.f286a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            C0274v c0274v = c0272t.f3257i;
            c0274v.getClass();
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c0274v.f3278j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                c0274v.f3274f = C0274v.b(iArr2);
                if (!c0274v.h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                c0274v.f3275g = false;
            }
            if (c0274v.g()) {
                c0274v.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (H.b.f286a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            C0274v c0274v = c0272t.f3257i;
            if (i2 != 0) {
                if (i2 == 1) {
                    DisplayMetrics displayMetrics = c0274v.f3278j.getResources().getDisplayMetrics();
                    c0274v.i(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (c0274v.g()) {
                        c0274v.a();
                        return;
                    }
                    return;
                }
                c0274v.getClass();
                throw new IllegalArgumentException(O.a.c(i2, "Unknown auto-size text type: "));
            }
            c0274v.f3269a = 0;
            c0274v.f3272d = -1.0f;
            c0274v.f3273e = -1.0f;
            c0274v.f3271c = -1.0f;
            c0274v.f3274f = new int[0];
            c0274v.f3270b = false;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0266m c0266m = this.f3262c;
        if (c0266m != null) {
            c0266m.f3193c = -1;
            c0266m.d(null);
            c0266m.a();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0266m c0266m = this.f3262c;
        if (c0266m != null) {
            c0266m.c(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.a.K(callback, this));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            android.support.v4.media.session.a.E(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            android.support.v4.media.session.a.F(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        if (i2 >= 0) {
            if (i2 != getPaint().getFontMetricsInt(null)) {
                setLineSpacing(i2 - r0, 1.0f);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setPrecomputedText(C.d dVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        android.support.v4.media.session.a.r(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0266m c0266m = this.f3262c;
        if (c0266m != null) {
            c0266m.e(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0266m c0266m = this.f3262c;
        if (c0266m != null) {
            c0266m.f(mode);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, m.h0] */
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        boolean z;
        C0272t c0272t = this.f3263d;
        if (c0272t.f3256h == null) {
            c0272t.f3256h = new Object();
        }
        h0 h0Var = c0272t.f3256h;
        h0Var.f3171a = colorStateList;
        if (colorStateList != null) {
            z = true;
        } else {
            z = false;
        }
        h0Var.f3174d = z;
        c0272t.f3250b = h0Var;
        c0272t.f3251c = h0Var;
        c0272t.f3252d = h0Var;
        c0272t.f3253e = h0Var;
        c0272t.f3254f = h0Var;
        c0272t.f3255g = h0Var;
        c0272t.b();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, m.h0] */
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        boolean z;
        C0272t c0272t = this.f3263d;
        if (c0272t.f3256h == null) {
            c0272t.f3256h = new Object();
        }
        h0 h0Var = c0272t.f3256h;
        h0Var.f3172b = mode;
        if (mode != null) {
            z = true;
        } else {
            z = false;
        }
        h0Var.f3173c = z;
        c0272t.f3250b = h0Var;
        c0272t.f3251c = h0Var;
        c0272t.f3252d = h0Var;
        c0272t.f3253e = h0Var;
        c0272t.f3254f = h0Var;
        c0272t.f3255g = h0Var;
        c0272t.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.e(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        B.c cVar;
        if (Build.VERSION.SDK_INT < 28 && (cVar = this.f3264e) != null) {
            cVar.f40e = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<C.d> future) {
        this.f3265f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(C.c cVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = cVar.f135b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i2 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i2 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i2 = 7;
            }
        }
        setTextDirection(i2);
        getPaint().set(cVar.f134a);
        setBreakStrategy(cVar.f136c);
        setHyphenationFrequency(cVar.f137d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f2) {
        boolean z = H.b.f286a;
        if (z) {
            super.setTextSize(i2, f2);
            return;
        }
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            C0274v c0274v = c0272t.f3257i;
            if (z || c0274v.f3269a != 0) {
                return;
            }
            c0274v.f(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i2) {
        Typeface typeface2;
        if (typeface != null && i2 > 0) {
            Context context = getContext();
            AbstractC0051a abstractC0051a = x.d.f3964a;
            if (context != null) {
                typeface2 = Typeface.create(typeface, i2);
            } else {
                throw new IllegalArgumentException("Context cannot be null");
            }
        } else {
            typeface2 = null;
        }
        if (typeface2 != null) {
            typeface = typeface2;
        }
        super.setTypeface(typeface, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0273u(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g0.a(context);
        C0266m c0266m = new C0266m(this);
        this.f3262c = c0266m;
        c0266m.b(attributeSet, i2);
        C0272t c0272t = new C0272t(this);
        this.f3263d = c0272t;
        c0272t.d(attributeSet, i2);
        c0272t.b();
        B.c cVar = new B.c(5);
        cVar.f39d = this;
        this.f3264e = cVar;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? AbstractC0203a.a(context, i2) : null, i3 != 0 ? AbstractC0203a.a(context, i3) : null, i4 != 0 ? AbstractC0203a.a(context, i4) : null, i5 != 0 ? AbstractC0203a.a(context, i5) : null);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? AbstractC0203a.a(context, i2) : null, i3 != 0 ? AbstractC0203a.a(context, i3) : null, i4 != 0 ? AbstractC0203a.a(context, i4) : null, i5 != 0 ? AbstractC0203a.a(context, i5) : null);
        C0272t c0272t = this.f3263d;
        if (c0272t != null) {
            c0272t.b();
        }
    }
}
