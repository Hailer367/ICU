package androidx.appcompat.widget;

import E.J;
import android.R;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import e0.C0180c;
import i.AbstractC0203a;
import j.C0215a;
import java.lang.reflect.Field;
import m.AbstractC0277y;
import m.u0;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: O, reason: collision with root package name */
    public static final C0180c f1184O = new C0180c("thumbPos", 7, Float.class);

    /* renamed from: P, reason: collision with root package name */
    public static final int[] f1185P = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public int f1186A;

    /* renamed from: B, reason: collision with root package name */
    public int f1187B;

    /* renamed from: C, reason: collision with root package name */
    public int f1188C;

    /* renamed from: D, reason: collision with root package name */
    public int f1189D;

    /* renamed from: E, reason: collision with root package name */
    public int f1190E;

    /* renamed from: F, reason: collision with root package name */
    public int f1191F;

    /* renamed from: G, reason: collision with root package name */
    public int f1192G;

    /* renamed from: H, reason: collision with root package name */
    public final TextPaint f1193H;

    /* renamed from: I, reason: collision with root package name */
    public final ColorStateList f1194I;

    /* renamed from: J, reason: collision with root package name */
    public StaticLayout f1195J;

    /* renamed from: K, reason: collision with root package name */
    public StaticLayout f1196K;
    public final C0215a L;

    /* renamed from: M, reason: collision with root package name */
    public ObjectAnimator f1197M;

    /* renamed from: N, reason: collision with root package name */
    public final Rect f1198N;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f1199c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f1200d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f1201e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1202f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1203g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f1204h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f1205i;

    /* renamed from: j, reason: collision with root package name */
    public PorterDuff.Mode f1206j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1207k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1208l;

    /* renamed from: m, reason: collision with root package name */
    public int f1209m;

    /* renamed from: n, reason: collision with root package name */
    public int f1210n;

    /* renamed from: o, reason: collision with root package name */
    public int f1211o;
    public boolean p;
    public CharSequence q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f1212r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1213s;

    /* renamed from: t, reason: collision with root package name */
    public int f1214t;

    /* renamed from: u, reason: collision with root package name */
    public final int f1215u;

    /* renamed from: v, reason: collision with root package name */
    public float f1216v;

    /* renamed from: w, reason: collision with root package name */
    public float f1217w;

    /* renamed from: x, reason: collision with root package name */
    public final VelocityTracker f1218x;
    public final int y;
    public float z;

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fe, code lost:
    
        if (r9 != null) goto L40;
     */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, j.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchCompat(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private boolean getTargetCheckedState() {
        if (this.z > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f2;
        if (u0.a(this)) {
            f2 = 1.0f - this.z;
        } else {
            f2 = this.z;
        }
        return (int) ((f2 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f1204h;
        if (drawable != null) {
            Rect rect2 = this.f1198N;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f1199c;
            if (drawable2 != null) {
                rect = AbstractC0277y.b(drawable2);
            } else {
                rect = AbstractC0277y.f3279a;
            }
            return ((((this.f1186A - this.f1188C) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    public final void a() {
        Drawable drawable = this.f1199c;
        if (drawable != null) {
            if (this.f1202f || this.f1203g) {
                Drawable mutate = drawable.mutate();
                this.f1199c = mutate;
                if (this.f1202f) {
                    mutate.setTintList(this.f1200d);
                }
                if (this.f1203g) {
                    this.f1199c.setTintMode(this.f1201e);
                }
                if (this.f1199c.isStateful()) {
                    this.f1199c.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f1204h;
        if (drawable != null) {
            if (this.f1207k || this.f1208l) {
                Drawable mutate = drawable.mutate();
                this.f1204h = mutate;
                if (this.f1207k) {
                    mutate.setTintList(this.f1205i);
                }
                if (this.f1208l) {
                    this.f1204h.setTintMode(this.f1206j);
                }
                if (this.f1204h.isStateful()) {
                    this.f1204h.setState(getDrawableState());
                }
            }
        }
    }

    public final StaticLayout c(CharSequence charSequence) {
        int i2;
        C0215a c0215a = this.L;
        if (c0215a != null) {
            charSequence = c0215a.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.f1193H;
        if (charSequence2 != null) {
            i2 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
        } else {
            i2 = 0;
        }
        return new StaticLayout(charSequence2, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        int i4 = this.f1189D;
        int i5 = this.f1190E;
        int i6 = this.f1191F;
        int i7 = this.f1192G;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f1199c;
        if (drawable != null) {
            rect = AbstractC0277y.b(drawable);
        } else {
            rect = AbstractC0277y.f3279a;
        }
        Drawable drawable2 = this.f1204h;
        Rect rect2 = this.f1198N;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                if (i10 > i11) {
                    i2 = (i10 - i11) + i5;
                } else {
                    i2 = i5;
                }
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f1204h.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f1204h.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f1199c;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.f1188C + rect2.right;
            this.f1199c.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f1199c;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
        Drawable drawable2 = this.f1204h;
        if (drawable2 != null) {
            drawable2.setHotspot(f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1199c;
        if (drawable != null && drawable.isStateful()) {
            z = drawable.setState(drawableState);
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1204h;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!u0.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f1186A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f1211o;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (u0.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1186A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f1211o;
        }
        return compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f1213s;
    }

    public boolean getSplitTrack() {
        return this.p;
    }

    public int getSwitchMinWidth() {
        return this.f1210n;
    }

    public int getSwitchPadding() {
        return this.f1211o;
    }

    public CharSequence getTextOff() {
        return this.f1212r;
    }

    public CharSequence getTextOn() {
        return this.q;
    }

    public Drawable getThumbDrawable() {
        return this.f1199c;
    }

    public int getThumbTextPadding() {
        return this.f1209m;
    }

    public ColorStateList getThumbTintList() {
        return this.f1200d;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f1201e;
    }

    public Drawable getTrackDrawable() {
        return this.f1204h;
    }

    public ColorStateList getTrackTintList() {
        return this.f1205i;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f1206j;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1199c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1204h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1197M;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1197M.end();
            this.f1197M = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f1185P);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f1204h;
        Rect rect = this.f1198N;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.f1190E;
        int i3 = this.f1192G;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f1199c;
        if (drawable != null) {
            if (this.p && drawable2 != null) {
                Rect b2 = AbstractC0277y.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b2.left;
                rect.right -= b2.right;
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
            staticLayout = this.f1195J;
        } else {
            staticLayout = this.f1196K;
        }
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.f1193H;
            ColorStateList colorStateList = this.f1194I;
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
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i4 + i5) / 2) - (staticLayout.getHeight() / 2));
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
        if (isChecked()) {
            charSequence = this.q;
        } else {
            charSequence = this.f1212r;
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

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        super.onLayout(z, i2, i3, i4, i5);
        int i10 = 0;
        if (this.f1199c != null) {
            Drawable drawable = this.f1204h;
            Rect rect = this.f1198N;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b2 = AbstractC0277y.b(this.f1199c);
            i6 = Math.max(0, b2.left - rect.left);
            i10 = Math.max(0, b2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (u0.a(this)) {
            i7 = getPaddingLeft() + i6;
            width = ((this.f1186A + i7) - i6) - i10;
        } else {
            width = (getWidth() - getPaddingRight()) - i10;
            i7 = (width - this.f1186A) + i6 + i10;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i9 = getPaddingTop();
                i8 = this.f1187B + i9;
            } else {
                i8 = getHeight() - getPaddingBottom();
                i9 = i8 - this.f1187B;
            }
        } else {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i11 = this.f1187B;
            int i12 = height - (i11 / 2);
            i8 = i11 + i12;
            i9 = i12;
        }
        this.f1189D = i7;
        this.f1190E = i9;
        this.f1192G = i8;
        this.f1191F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (this.f1213s) {
            if (this.f1195J == null) {
                this.f1195J = c(this.q);
            }
            if (this.f1196K == null) {
                this.f1196K = c(this.f1212r);
            }
        }
        Drawable drawable = this.f1199c;
        int i7 = 0;
        Rect rect = this.f1198N;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f1199c.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.f1199c.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (this.f1213s) {
            i6 = (this.f1209m * 2) + Math.max(this.f1195J.getWidth(), this.f1196K.getWidth());
        } else {
            i6 = 0;
        }
        this.f1188C = Math.max(i6, i4);
        Drawable drawable2 = this.f1204h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i7 = this.f1204h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i8 = rect.left;
        int i9 = rect.right;
        Drawable drawable3 = this.f1199c;
        if (drawable3 != null) {
            Rect b2 = AbstractC0277y.b(drawable3);
            i8 = Math.max(i8, b2.left);
            i9 = Math.max(i9, b2.right);
        }
        int max = Math.max(this.f1210n, (this.f1188C * 2) + i8 + i9);
        int max2 = Math.max(i7, i5);
        this.f1186A = max;
        this.f1187B = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.q;
        } else {
            charSequence = this.f1212r;
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

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        float f2 = 0.0f;
        if (getWindowToken() != null) {
            Field field = J.f180a;
            if (isLaidOut()) {
                if (isChecked) {
                    f2 = 1.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1184O, f2);
                this.f1197M = ofFloat;
                ofFloat.setDuration(250L);
                this.f1197M.setAutoCancel(true);
                this.f1197M.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.f1197M;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (isChecked) {
            f2 = 1.0f;
        }
        setThumbPosition(f2);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.a.K(callback, this));
    }

    public void setShowText(boolean z) {
        if (this.f1213s != z) {
            this.f1213s = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.p = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.f1210n = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.f1211o = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f1193H;
        if ((textPaint.getTypeface() != null && !textPaint.getTypeface().equals(typeface)) || (textPaint.getTypeface() == null && typeface != null)) {
            textPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f1212r = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1199c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1199c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.z = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(AbstractC0203a.a(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.f1209m = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f1200d = colorStateList;
        this.f1202f = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f1201e = mode;
        this.f1203g = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1204h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1204h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(AbstractC0203a.a(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f1205i = colorStateList;
        this.f1207k = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f1206j = mode;
        this.f1208l = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f1199c && drawable != this.f1204h) {
            return false;
        }
        return true;
    }
}
