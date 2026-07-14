package androidx.appcompat.widget;

import E.J;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.icaremc.doctors.R;
import h.AbstractC0201a;
import java.lang.reflect.Field;
import m.C0254a;
import m.Q;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public boolean f1083c;

    /* renamed from: d, reason: collision with root package name */
    public View f1084d;

    /* renamed from: e, reason: collision with root package name */
    public View f1085e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1086f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f1087g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f1088h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1089i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1090j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1091k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0254a c0254a = new C0254a(this);
        Field field = J.f180a;
        setBackground(c0254a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.f2298a);
        boolean z = false;
        this.f1086f = obtainStyledAttributes.getDrawable(0);
        this.f1087g = obtainStyledAttributes.getDrawable(2);
        this.f1091k = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f1089i = true;
            this.f1088h = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1089i ? !(this.f1086f != null || this.f1087g != null) : this.f1088h == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1086f;
        if (drawable != null && drawable.isStateful()) {
            this.f1086f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1087g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1087g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1088h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1088h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1086f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1087g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1088h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f1084d = findViewById(R.id.action_bar);
        this.f1085e = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f1083c && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = true;
        if (this.f1089i) {
            Drawable drawable = this.f1088h;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f1086f != null) {
                if (this.f1084d.getVisibility() == 0) {
                    this.f1086f.setBounds(this.f1084d.getLeft(), this.f1084d.getTop(), this.f1084d.getRight(), this.f1084d.getBottom());
                } else {
                    View view = this.f1085e;
                    if (view != null && view.getVisibility() == 0) {
                        this.f1086f.setBounds(this.f1085e.getLeft(), this.f1085e.getTop(), this.f1085e.getRight(), this.f1085e.getBottom());
                    } else {
                        this.f1086f.setBounds(0, 0, 0, 0);
                    }
                }
            } else {
                z2 = false;
            }
            this.f1090j = false;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        if (this.f1084d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f1091k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f1084d == null) {
            return;
        }
        View.MeasureSpec.getMode(i3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1086f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1086f);
        }
        this.f1086f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1084d;
            if (view != null) {
                this.f1086f.setBounds(view.getLeft(), this.f1084d.getTop(), this.f1084d.getRight(), this.f1084d.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1089i ? !(this.f1086f != null || this.f1087g != null) : this.f1088h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1088h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1088h);
        }
        this.f1088h = drawable;
        boolean z = this.f1089i;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f1088h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f1086f != null || this.f1087g != null) : this.f1088h == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f1087g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1087g);
        }
        this.f1087g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1090j && this.f1087g != null) {
                throw null;
            }
        }
        boolean z = false;
        if (!this.f1089i ? !(this.f1086f != null || this.f1087g != null) : this.f1088h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z) {
        int i2;
        this.f1083c = z;
        if (z) {
            i2 = 393216;
        } else {
            i2 = 262144;
        }
        setDescendantFocusability(i2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        boolean z;
        super.setVisibility(i2);
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.f1086f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f1087g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f1088h;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1086f;
        boolean z = this.f1089i;
        if (drawable != drawable2 || z) {
            if (drawable != this.f1087g || !this.f1090j) {
                if ((drawable == this.f1088h && z) || super.verifyDrawable(drawable)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    public void setTabContainer(Q q) {
    }
}
