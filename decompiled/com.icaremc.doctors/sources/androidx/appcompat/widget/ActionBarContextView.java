package androidx.appcompat.widget;

import E.J;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.icaremc.doctors.R;
import h.AbstractC0201a;
import i.AbstractC0203a;
import java.lang.reflect.Field;
import m.u0;

/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public int f1092c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1093d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1094e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1095f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f1096g;

    /* renamed from: h, reason: collision with root package name */
    public View f1097h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f1098i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f1099j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f1100k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1101l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1102m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1103n;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        Drawable drawable;
        int resourceId;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.f2301d, R.attr.actionModeStyle, 0);
        if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
            drawable = AbstractC0203a.a(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(0);
        }
        Field field = J.f180a;
        setBackground(drawable);
        this.f1101l = obtainStyledAttributes.getResourceId(5, 0);
        this.f1102m = obtainStyledAttributes.getResourceId(4, 0);
        this.f1092c = obtainStyledAttributes.getLayoutDimension(3, 0);
        obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public static int b(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        if (z) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public final void a() {
        int i2;
        if (this.f1098i == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1098i = linearLayout;
            this.f1099j = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f1100k = (TextView) this.f1098i.findViewById(R.id.action_bar_subtitle);
            int i3 = this.f1101l;
            if (i3 != 0) {
                this.f1099j.setTextAppearance(getContext(), i3);
            }
            int i4 = this.f1102m;
            if (i4 != 0) {
                this.f1100k.setTextAppearance(getContext(), i4);
            }
        }
        this.f1099j.setText(this.f1095f);
        this.f1100k.setText(this.f1096g);
        boolean isEmpty = TextUtils.isEmpty(this.f1095f);
        boolean isEmpty2 = TextUtils.isEmpty(this.f1096g);
        TextView textView = this.f1100k;
        int i5 = 8;
        if (!isEmpty2) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
        LinearLayout linearLayout2 = this.f1098i;
        if (!isEmpty || !isEmpty2) {
            i5 = 0;
        }
        linearLayout2.setVisibility(i5);
        if (this.f1098i.getParent() == null) {
            addView(this.f1098i);
        }
    }

    @Override // android.view.View
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            super.setVisibility(i2);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1092c;
    }

    public CharSequence getSubtitle() {
        return this.f1096g;
    }

    public CharSequence getTitle() {
        return this.f1095f;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC0201a.f2298a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1094e = false;
        }
        if (!this.f1094e) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1094e = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f1094e = false;
        return true;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1095f);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        boolean a2 = u0.a(this);
        if (a2) {
            paddingLeft = (i4 - i2) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        LinearLayout linearLayout = this.f1098i;
        if (linearLayout != null && this.f1097h == null && linearLayout.getVisibility() != 8) {
            paddingLeft += b(this.f1098i, paddingLeft, paddingTop, paddingTop2, a2);
        }
        View view = this.f1097h;
        if (view != null) {
            b(view, paddingLeft, paddingTop, paddingTop2, a2);
        }
        if (a2) {
            getPaddingLeft();
        } else {
            getPaddingRight();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        int i6 = 1073741824;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            if (View.MeasureSpec.getMode(i3) != 0) {
                int size = View.MeasureSpec.getSize(i2);
                int i7 = this.f1092c;
                if (i7 <= 0) {
                    i7 = View.MeasureSpec.getSize(i3);
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i8 = i7 - paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
                LinearLayout linearLayout = this.f1098i;
                if (linearLayout != null && this.f1097h == null) {
                    if (this.f1103n) {
                        this.f1098i.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f1098i.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f1098i;
                        if (z) {
                            i5 = 0;
                        } else {
                            i5 = 8;
                        }
                        linearLayout2.setVisibility(i5);
                    } else {
                        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), makeMeasureSpec);
                        paddingLeft = Math.max(0, paddingLeft - linearLayout.getMeasuredWidth());
                    }
                }
                View view = this.f1097h;
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    int i9 = layoutParams.width;
                    if (i9 != -2) {
                        i4 = 1073741824;
                    } else {
                        i4 = Integer.MIN_VALUE;
                    }
                    if (i9 >= 0) {
                        paddingLeft = Math.min(i9, paddingLeft);
                    }
                    int i10 = layoutParams.height;
                    if (i10 == -2) {
                        i6 = Integer.MIN_VALUE;
                    }
                    if (i10 >= 0) {
                        i8 = Math.min(i10, i8);
                    }
                    this.f1097h.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i8, i6));
                }
                if (this.f1092c <= 0) {
                    int childCount = getChildCount();
                    int i11 = 0;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingBottom;
                        if (measuredHeight > i11) {
                            i11 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i11);
                    return;
                }
                setMeasuredDimension(size, i7);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1093d = false;
        }
        if (!this.f1093d) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1093d = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f1093d = false;
        return true;
    }

    public void setContentHeight(int i2) {
        this.f1092c = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1097h;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1097h = view;
        if (view != null && (linearLayout = this.f1098i) != null) {
            removeView(linearLayout);
            this.f1098i = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1096g = charSequence;
        a();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1095f = charSequence;
        a();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1103n) {
            requestLayout();
        }
        this.f1103n = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
