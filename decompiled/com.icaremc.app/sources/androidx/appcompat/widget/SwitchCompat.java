package androidx.appcompat.widget;

import A2.t;
import I.F;
import I.T;
import T.k;
import V.h;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import java.util.WeakHashMap;
import l.C0432a;
import o.AbstractC0546u0;
import o.C0507c0;
import o.C0549w;
import o.E1;
import o.k1;
import o.l1;
import o.m1;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: W, reason: collision with root package name */
    public static final k1 f2408W = new Property(Float.class, "thumbPos");

    /* renamed from: a0, reason: collision with root package name */
    public static final int[] f2409a0 = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public float f2410A;

    /* renamed from: B, reason: collision with root package name */
    public float f2411B;

    /* renamed from: C, reason: collision with root package name */
    public final VelocityTracker f2412C;

    /* renamed from: D, reason: collision with root package name */
    public final int f2413D;

    /* renamed from: E, reason: collision with root package name */
    public float f2414E;

    /* renamed from: F, reason: collision with root package name */
    public int f2415F;

    /* renamed from: G, reason: collision with root package name */
    public int f2416G;

    /* renamed from: H, reason: collision with root package name */
    public int f2417H;

    /* renamed from: I, reason: collision with root package name */
    public int f2418I;

    /* renamed from: J, reason: collision with root package name */
    public int f2419J;

    /* renamed from: K, reason: collision with root package name */
    public int f2420K;

    /* renamed from: L, reason: collision with root package name */
    public int f2421L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f2422M;

    /* renamed from: N, reason: collision with root package name */
    public final TextPaint f2423N;

    /* renamed from: O, reason: collision with root package name */
    public final ColorStateList f2424O;
    public StaticLayout P;

    /* renamed from: Q, reason: collision with root package name */
    public StaticLayout f2425Q;

    /* renamed from: R, reason: collision with root package name */
    public final C0432a f2426R;

    /* renamed from: S, reason: collision with root package name */
    public ObjectAnimator f2427S;

    /* renamed from: T, reason: collision with root package name */
    public C0549w f2428T;

    /* renamed from: U, reason: collision with root package name */
    public h f2429U;

    /* renamed from: V, reason: collision with root package name */
    public final Rect f2430V;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2431f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2432g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2433h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2434i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2435j;
    public Drawable k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f2436l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f2437m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2438n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2439o;

    /* renamed from: p, reason: collision with root package name */
    public int f2440p;

    /* renamed from: q, reason: collision with root package name */
    public int f2441q;

    /* renamed from: r, reason: collision with root package name */
    public int f2442r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2443s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f2444t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f2445u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f2446v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f2447w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2448x;

    /* renamed from: y, reason: collision with root package name */
    public int f2449y;
    public final int z;

    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.Object, l.a] */
    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.icaremc.app.R.attr.switchStyle);
        Typeface typeface;
        Typeface create;
        int i4;
        int resourceId;
        this.f2432g = null;
        this.f2433h = null;
        this.f2434i = false;
        this.f2435j = false;
        this.f2436l = null;
        this.f2437m = null;
        this.f2438n = false;
        this.f2439o = false;
        this.f2412C = VelocityTracker.obtain();
        this.f2422M = true;
        this.f2430V = new Rect();
        m1.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f2423N = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = AbstractC0357a.f4087w;
        t P = t.P(context, attributeSet, iArr, com.icaremc.app.R.attr.switchStyle);
        TypedArray typedArray = (TypedArray) P.f100h;
        T.h(this, context, iArr, attributeSet, typedArray, com.icaremc.app.R.attr.switchStyle);
        Drawable H3 = P.H(2);
        this.f2431f = H3;
        if (H3 != null) {
            H3.setCallback(this);
        }
        Drawable H4 = P.H(11);
        this.k = H4;
        if (H4 != null) {
            H4.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f2448x = typedArray.getBoolean(3, true);
        this.f2440p = typedArray.getDimensionPixelSize(8, 0);
        this.f2441q = typedArray.getDimensionPixelSize(5, 0);
        this.f2442r = typedArray.getDimensionPixelSize(6, 0);
        this.f2443s = typedArray.getBoolean(4, false);
        ColorStateList G3 = P.G(9);
        if (G3 != null) {
            this.f2432g = G3;
            this.f2434i = true;
        }
        PorterDuff.Mode c4 = AbstractC0546u0.c(typedArray.getInt(10, -1), null);
        if (this.f2433h != c4) {
            this.f2433h = c4;
            this.f2435j = true;
        }
        if (this.f2434i || this.f2435j) {
            a();
        }
        ColorStateList G4 = P.G(12);
        if (G4 != null) {
            this.f2436l = G4;
            this.f2438n = true;
        }
        PorterDuff.Mode c5 = AbstractC0546u0.c(typedArray.getInt(13, -1), null);
        if (this.f2437m != c5) {
            this.f2437m = c5;
            this.f2439o = true;
        }
        if (this.f2438n || this.f2439o) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId2, AbstractC0357a.f4088x);
            ColorStateList colorStateList = (!obtainStyledAttributes.hasValue(3) || (resourceId = obtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = AbstractC0286a.n(context, resourceId)) == null) ? obtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.f2424O = colorStateList;
            } else {
                this.f2424O = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f4 = dimensionPixelSize;
                if (f4 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f4);
                    requestLayout();
                }
            }
            int i5 = obtainStyledAttributes.getInt(1, -1);
            int i6 = obtainStyledAttributes.getInt(2, -1);
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        typeface = null;
                    } else {
                        typeface = Typeface.MONOSPACE;
                    }
                } else {
                    typeface = Typeface.SERIF;
                }
            } else {
                typeface = Typeface.SANS_SERIF;
            }
            if (i6 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i6);
                } else {
                    create = Typeface.create(typeface, i6);
                }
                setSwitchTypeface(create);
                if (create != null) {
                    i4 = create.getStyle();
                } else {
                    i4 = 0;
                }
                int i7 = (~i4) & i6;
                textPaint.setFakeBoldText((i7 & 1) != 0);
                textPaint.setTextSkewX((2 & i7) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                ?? obj = new Object();
                obj.f5120f = context2.getResources().getConfiguration().locale;
                this.f2426R = obj;
            } else {
                this.f2426R = null;
            }
            setTextOnInternal(this.f2444t);
            setTextOffInternal(this.f2446v);
            obtainStyledAttributes.recycle();
        }
        new C0507c0(this).f(attributeSet, com.icaremc.app.R.attr.switchStyle);
        P.T();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.z = viewConfiguration.getScaledTouchSlop();
        this.f2413D = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, com.icaremc.app.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private C0549w getEmojiTextViewHelper() {
        if (this.f2428T == null) {
            this.f2428T = new C0549w(this);
        }
        return this.f2428T;
    }

    private boolean getTargetCheckedState() {
        if (this.f2414E > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f4;
        if (E1.a(this)) {
            f4 = 1.0f - this.f2414E;
        } else {
            f4 = this.f2414E;
        }
        return (int) ((f4 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.k;
        if (drawable != null) {
            Rect rect2 = this.f2430V;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f2431f;
            if (drawable2 != null) {
                rect = AbstractC0546u0.b(drawable2);
            } else {
                rect = AbstractC0546u0.f5715c;
            }
            return ((((this.f2415F - this.f2417H) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2446v = charSequence;
        TransformationMethod Z3 = ((AbstractC0602b) getEmojiTextViewHelper().f5724b.f93g).Z(this.f2426R);
        if (Z3 != null) {
            charSequence = Z3.getTransformation(charSequence, this);
        }
        this.f2447w = charSequence;
        this.f2425Q = null;
        if (this.f2448x) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2444t = charSequence;
        TransformationMethod Z3 = ((AbstractC0602b) getEmojiTextViewHelper().f5724b.f93g).Z(this.f2426R);
        if (Z3 != null) {
            charSequence = Z3.getTransformation(charSequence, this);
        }
        this.f2445u = charSequence;
        this.P = null;
        if (this.f2448x) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f2431f;
        if (drawable != null) {
            if (this.f2434i || this.f2435j) {
                Drawable mutate = drawable.mutate();
                this.f2431f = mutate;
                if (this.f2434i) {
                    mutate.setTintList(this.f2432g);
                }
                if (this.f2435j) {
                    this.f2431f.setTintMode(this.f2433h);
                }
                if (this.f2431f.isStateful()) {
                    this.f2431f.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (this.f2438n || this.f2439o) {
                Drawable mutate = drawable.mutate();
                this.k = mutate;
                if (this.f2438n) {
                    mutate.setTintList(this.f2436l);
                }
                if (this.f2439o) {
                    this.k.setTintMode(this.f2437m);
                }
                if (this.k.isStateful()) {
                    this.k.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f2444t);
        setTextOffInternal(this.f2446v);
        requestLayout();
    }

    public final void d() {
        if (this.f2429U == null && ((AbstractC0602b) this.f2428T.f5724b.f93g).H() && k.f1556j != null) {
            k a4 = k.a();
            int b4 = a4.b();
            if (b4 == 3 || b4 == 0) {
                h hVar = new h(this);
                this.f2429U = hVar;
                a4.f(hVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect;
        int i4;
        int i5;
        int i6 = this.f2418I;
        int i7 = this.f2419J;
        int i8 = this.f2420K;
        int i9 = this.f2421L;
        int thumbOffset = getThumbOffset() + i6;
        Drawable drawable = this.f2431f;
        if (drawable != null) {
            rect = AbstractC0546u0.b(drawable);
        } else {
            rect = AbstractC0546u0.f5715c;
        }
        Drawable drawable2 = this.k;
        Rect rect2 = this.f2430V;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i10 = rect2.left;
            thumbOffset += i10;
            if (rect != null) {
                int i11 = rect.left;
                if (i11 > i10) {
                    i6 += i11 - i10;
                }
                int i12 = rect.top;
                int i13 = rect2.top;
                if (i12 > i13) {
                    i4 = (i12 - i13) + i7;
                } else {
                    i4 = i7;
                }
                int i14 = rect.right;
                int i15 = rect2.right;
                if (i14 > i15) {
                    i8 -= i14 - i15;
                }
                int i16 = rect.bottom;
                int i17 = rect2.bottom;
                if (i16 > i17) {
                    i5 = i9 - (i16 - i17);
                    this.k.setBounds(i6, i4, i8, i5);
                }
            } else {
                i4 = i7;
            }
            i5 = i9;
            this.k.setBounds(i6, i4, i8, i5);
        }
        Drawable drawable3 = this.f2431f;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i18 = thumbOffset - rect2.left;
            int i19 = thumbOffset + this.f2417H + rect2.right;
            this.f2431f.setBounds(i18, i7, i19, i9);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i18, i7, i19, i9);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f2431f;
        if (drawable != null) {
            drawable.setHotspot(f4, f5);
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.setHotspot(f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2431f;
        if (drawable != null && drawable.isStateful()) {
            z = drawable.setState(drawableState);
        } else {
            z = false;
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!E1.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2415F;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f2442r;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (E1.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2415F;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f2442r;
        }
        return compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0286a.M(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f2448x;
    }

    public boolean getSplitTrack() {
        return this.f2443s;
    }

    public int getSwitchMinWidth() {
        return this.f2441q;
    }

    public int getSwitchPadding() {
        return this.f2442r;
    }

    public CharSequence getTextOff() {
        return this.f2446v;
    }

    public CharSequence getTextOn() {
        return this.f2444t;
    }

    public Drawable getThumbDrawable() {
        return this.f2431f;
    }

    public final float getThumbPosition() {
        return this.f2414E;
    }

    public int getThumbTextPadding() {
        return this.f2440p;
    }

    public ColorStateList getThumbTintList() {
        return this.f2432g;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2433h;
    }

    public Drawable getTrackDrawable() {
        return this.k;
    }

    public ColorStateList getTrackTintList() {
        return this.f2436l;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2437m;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2431f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f2427S;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f2427S.end();
            this.f2427S = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f2409a0);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.k;
        Rect rect = this.f2430V;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i4 = this.f2419J;
        int i5 = this.f2421L;
        int i6 = i4 + rect.top;
        int i7 = i5 - rect.bottom;
        Drawable drawable2 = this.f2431f;
        if (drawable != null) {
            if (this.f2443s && drawable2 != null) {
                Rect b4 = AbstractC0546u0.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b4.left;
                rect.right -= b4.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            staticLayout = this.P;
        } else {
            staticLayout = this.f2425Q;
        }
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.f2423N;
            ColorStateList colorStateList = this.f2424O;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i6 + i7) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f2444t;
            } else {
                charSequence = this.f2446v;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int width;
        int i9;
        int i10;
        int i11;
        super.onLayout(z, i4, i5, i6, i7);
        int i12 = 0;
        if (this.f2431f != null) {
            Drawable drawable = this.k;
            Rect rect = this.f2430V;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b4 = AbstractC0546u0.b(this.f2431f);
            i8 = Math.max(0, b4.left - rect.left);
            i12 = Math.max(0, b4.right - rect.right);
        } else {
            i8 = 0;
        }
        if (E1.a(this)) {
            i9 = getPaddingLeft() + i8;
            width = ((this.f2415F + i9) - i8) - i12;
        } else {
            width = (getWidth() - getPaddingRight()) - i12;
            i9 = (width - this.f2415F) + i8 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i11 = getPaddingTop();
                i10 = this.f2416G + i11;
            } else {
                i10 = getHeight() - getPaddingBottom();
                i11 = i10 - this.f2416G;
            }
        } else {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i13 = this.f2416G;
            int i14 = height - (i13 / 2);
            i10 = i13 + i14;
            i11 = i14;
        }
        this.f2418I = i9;
        this.f2419J = i11;
        this.f2421L = i10;
        this.f2420K = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        if (this.f2448x) {
            StaticLayout staticLayout = this.P;
            TextPaint textPaint = this.f2423N;
            if (staticLayout == null) {
                CharSequence charSequence = this.f2445u;
                if (charSequence != null) {
                    i11 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
                } else {
                    i11 = 0;
                }
                this.P = new StaticLayout(charSequence, textPaint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f2425Q == null) {
                CharSequence charSequence2 = this.f2447w;
                if (charSequence2 != null) {
                    i10 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
                } else {
                    i10 = 0;
                }
                this.f2425Q = new StaticLayout(charSequence2, textPaint, i10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f2431f;
        Rect rect = this.f2430V;
        if (drawable != null) {
            drawable.getPadding(rect);
            i6 = (this.f2431f.getIntrinsicWidth() - rect.left) - rect.right;
            i7 = this.f2431f.getIntrinsicHeight();
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (this.f2448x) {
            i8 = (this.f2440p * 2) + Math.max(this.P.getWidth(), this.f2425Q.getWidth());
        } else {
            i8 = 0;
        }
        this.f2417H = Math.max(i8, i6);
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i12 = this.k.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i13 = rect.left;
        int i14 = rect.right;
        Drawable drawable3 = this.f2431f;
        if (drawable3 != null) {
            Rect b4 = AbstractC0546u0.b(drawable3);
            i13 = Math.max(i13, b4.left);
            i14 = Math.max(i14, b4.right);
        }
        if (this.f2422M) {
            i9 = Math.max(this.f2441q, (this.f2417H * 2) + i13 + i14);
        } else {
            i9 = this.f2441q;
        }
        int max = Math.max(i12, i7);
        this.f2415F = i9;
        this.f2416G = max;
        super.onMeasure(i4, i5);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f2444t;
        } else {
            charSequence = this.f2446v;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f2444t;
                if (obj == null) {
                    obj = getResources().getString(com.icaremc.app.R.string.abc_capital_on);
                }
                Object obj2 = obj;
                WeakHashMap weakHashMap = T.f702a;
                new F(com.icaremc.app.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj2);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj3 = this.f2446v;
            if (obj3 == null) {
                obj3 = getResources().getString(com.icaremc.app.R.string.abc_capital_off);
            }
            Object obj4 = obj3;
            WeakHashMap weakHashMap2 = T.f702a;
            new F(com.icaremc.app.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj4);
        }
        float f4 = 0.0f;
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = T.f702a;
            if (isLaidOut()) {
                if (isChecked) {
                    f4 = 1.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f2408W, f4);
                this.f2427S = ofFloat;
                ofFloat.setDuration(250L);
                l1.a(this.f2427S, true);
                this.f2427S.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.f2427S;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (isChecked) {
            f4 = 1.0f;
        }
        setThumbPosition(f4);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0286a.N(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
        setTextOnInternal(this.f2444t);
        setTextOffInternal(this.f2446v);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.f2422M = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.f2448x != z) {
            this.f2448x = z;
            requestLayout();
            if (z) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f2443s = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i4) {
        this.f2441q = i4;
        requestLayout();
    }

    public void setSwitchPadding(int i4) {
        this.f2442r = i4;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f2423N;
        if ((textPaint.getTypeface() != null && !textPaint.getTypeface().equals(typeface)) || (textPaint.getTypeface() == null && typeface != null)) {
            textPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f2446v;
            if (obj == null) {
                obj = getResources().getString(com.icaremc.app.R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap = T.f702a;
            new F(com.icaremc.app.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f2444t;
            if (obj == null) {
                obj = getResources().getString(com.icaremc.app.R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = T.f702a;
            new F(com.icaremc.app.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2431f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2431f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.f2414E = f4;
        invalidate();
    }

    public void setThumbResource(int i4) {
        setThumbDrawable(AbstractC0286a.o(getContext(), i4));
    }

    public void setThumbTextPadding(int i4) {
        this.f2440p = i4;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2432g = colorStateList;
        this.f2434i = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2433h = mode;
        this.f2435j = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i4) {
        setTrackDrawable(AbstractC0286a.o(getContext(), i4));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2436l = colorStateList;
        this.f2438n = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2437m = mode;
        this.f2439o = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f2431f && drawable != this.k) {
            return false;
        }
        return true;
    }
}
