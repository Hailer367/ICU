package androidx.appcompat.widget;

import I.T;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.icaremc.app.R;
import i.AbstractC0357a;
import java.util.WeakHashMap;
import o.C0503b;
import o.X0;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public boolean f2291f;

    /* renamed from: g, reason: collision with root package name */
    public View f2292g;

    /* renamed from: h, reason: collision with root package name */
    public View f2293h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f2294i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f2295j;
    public Drawable k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2296l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2297m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2298n;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0503b c0503b = new C0503b(this);
        WeakHashMap weakHashMap = T.f702a;
        setBackground(c0503b);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4066a);
        boolean z = false;
        this.f2294i = obtainStyledAttributes.getDrawable(0);
        this.f2295j = obtainStyledAttributes.getDrawable(2);
        this.f2298n = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f2296l = true;
            this.k = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f2296l ? !(this.f2294i != null || this.f2295j != null) : this.k == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2294i;
        if (drawable != null && drawable.isStateful()) {
            this.f2294i.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2295j;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2295j.setState(getDrawableState());
        }
        Drawable drawable3 = this.k;
        if (drawable3 != null && drawable3.isStateful()) {
            this.k.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2294i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2295j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.k;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2292g = findViewById(R.id.action_bar);
        this.f2293h = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f2291f && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        super.onLayout(z, i4, i5, i6, i7);
        boolean z3 = true;
        if (this.f2296l) {
            Drawable drawable = this.k;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f2294i != null) {
                if (this.f2292g.getVisibility() == 0) {
                    this.f2294i.setBounds(this.f2292g.getLeft(), this.f2292g.getTop(), this.f2292g.getRight(), this.f2292g.getBottom());
                } else {
                    View view = this.f2293h;
                    if (view != null && view.getVisibility() == 0) {
                        this.f2294i.setBounds(this.f2293h.getLeft(), this.f2293h.getTop(), this.f2293h.getRight(), this.f2293h.getBottom());
                    } else {
                        this.f2294i.setBounds(0, 0, 0, 0);
                    }
                }
            } else {
                z3 = false;
            }
            this.f2297m = false;
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f2292g == null && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE && (i6 = this.f2298n) >= 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(i6, View.MeasureSpec.getSize(i5)), Integer.MIN_VALUE);
        }
        super.onMeasure(i4, i5);
        if (this.f2292g == null) {
            return;
        }
        View.MeasureSpec.getMode(i5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2294i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2294i);
        }
        this.f2294i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2292g;
            if (view != null) {
                this.f2294i.setBounds(view.getLeft(), this.f2292g.getTop(), this.f2292g.getRight(), this.f2292g.getBottom());
            }
        }
        boolean z = false;
        if (!this.f2296l ? !(this.f2294i != null || this.f2295j != null) : this.k == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.k);
        }
        this.k = drawable;
        boolean z = this.f2296l;
        boolean z3 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.k) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f2294i != null || this.f2295j != null) : this.k == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f2295j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2295j);
        }
        this.f2295j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2297m && this.f2295j != null) {
                throw null;
            }
        }
        boolean z = false;
        if (!this.f2296l ? !(this.f2294i != null || this.f2295j != null) : this.k == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z) {
        int i4;
        this.f2291f = z;
        if (z) {
            i4 = 393216;
        } else {
            i4 = 262144;
        }
        setDescendantFocusability(i4);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        boolean z;
        super.setVisibility(i4);
        if (i4 == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.f2294i;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f2295j;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.k;
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
        Drawable drawable2 = this.f2294i;
        boolean z = this.f2296l;
        if (drawable != drawable2 || z) {
            if (drawable != this.f2295j || !this.f2297m) {
                if ((drawable == this.k && z) || super.verifyDrawable(drawable)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i4) {
        if (i4 != 0) {
            return super.startActionModeForChild(view, callback, i4);
        }
        return null;
    }

    public void setTabContainer(X0 x02) {
    }
}
