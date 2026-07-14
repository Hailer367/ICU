package androidx.appcompat.widget;

import E.C0019t;
import E.InterfaceC0018s;
import E.J;
import E.r;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api;
import com.icaremc.doctors.R;
import e0.p;
import i.AbstractC0203a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import m.C0257d;
import m.InterfaceC0256c;
import m.InterfaceC0276x;
import m.RunnableC0255b;
import m.o0;
import m.u0;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements r, InterfaceC0018s {

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f1104A = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: c, reason: collision with root package name */
    public int f1105c;

    /* renamed from: d, reason: collision with root package name */
    public ContentFrameLayout f1106d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContainer f1107e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0276x f1108f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f1109g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1110h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1111i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1112j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1113k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1114l;

    /* renamed from: m, reason: collision with root package name */
    public int f1115m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f1116n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f1117o;
    public final Rect p;
    public final Rect q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f1118r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f1119s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f1120t;

    /* renamed from: u, reason: collision with root package name */
    public OverScroller f1121u;

    /* renamed from: v, reason: collision with root package name */
    public ViewPropertyAnimator f1122v;

    /* renamed from: w, reason: collision with root package name */
    public final p f1123w;

    /* renamed from: x, reason: collision with root package name */
    public final RunnableC0255b f1124x;
    public final RunnableC0255b y;
    public final C0019t z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1116n = new Rect();
        this.f1117o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.f1118r = new Rect();
        this.f1119s = new Rect();
        this.f1120t = new Rect();
        this.f1123w = new p(1, this);
        this.f1124x = new RunnableC0255b(this, 0);
        this.y = new RunnableC0255b(this, 1);
        i(context);
        this.z = new C0019t();
    }

    public static boolean g(View view, Rect rect, boolean z) {
        boolean z2;
        C0257d c0257d = (C0257d) view.getLayoutParams();
        int i2 = ((ViewGroup.MarginLayoutParams) c0257d).leftMargin;
        int i3 = rect.left;
        if (i2 != i3) {
            ((ViewGroup.MarginLayoutParams) c0257d).leftMargin = i3;
            z2 = true;
        } else {
            z2 = false;
        }
        int i4 = ((ViewGroup.MarginLayoutParams) c0257d).topMargin;
        int i5 = rect.top;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) c0257d).topMargin = i5;
            z2 = true;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) c0257d).rightMargin;
        int i7 = rect.right;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) c0257d).rightMargin = i7;
            z2 = true;
        }
        if (z) {
            int i8 = ((ViewGroup.MarginLayoutParams) c0257d).bottomMargin;
            int i9 = rect.bottom;
            if (i8 != i9) {
                ((ViewGroup.MarginLayoutParams) c0257d).bottomMargin = i9;
                return true;
            }
        }
        return z2;
    }

    @Override // E.r
    public final void a(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // E.r
    public final void b(ViewGroup viewGroup, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(viewGroup, i2, i3, i4, i5);
        }
    }

    @Override // E.r
    public final void c(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0257d;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f1109g != null && !this.f1110h) {
            if (this.f1107e.getVisibility() == 0) {
                i2 = (int) (this.f1107e.getTranslationY() + this.f1107e.getBottom() + 0.5f);
            } else {
                i2 = 0;
            }
            this.f1109g.setBounds(0, i2, getWidth(), this.f1109g.getIntrinsicHeight() + i2);
            this.f1109g.draw(canvas);
        }
    }

    @Override // E.InterfaceC0018s
    public final void e(ViewGroup viewGroup, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        b(viewGroup, i2, i3, i4, i5, i6);
    }

    @Override // E.r
    public final boolean f(View view, View view2, int i2, int i3) {
        if (i3 == 0 && onStartNestedScroll(view, view2, i2)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        j();
        Field field = J.f180a;
        getWindowSystemUiVisibility();
        boolean g2 = g(this.f1107e, rect, false);
        Rect rect2 = this.q;
        rect2.set(rect);
        Method method = u0.f3266a;
        Rect rect3 = this.f1116n;
        if (method != null) {
            try {
                method.invoke(this, rect2, rect3);
            } catch (Exception e2) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e2);
            }
        }
        Rect rect4 = this.f1118r;
        if (!rect4.equals(rect2)) {
            rect4.set(rect2);
            g2 = true;
        }
        Rect rect5 = this.f1117o;
        if (!rect5.equals(rect3)) {
            rect5.set(rect3);
            g2 = true;
        }
        if (g2) {
            requestLayout();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1107e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0019t c0019t = this.z;
        return c0019t.f253c | c0019t.f252b;
    }

    public CharSequence getTitle() {
        j();
        return ((o0) this.f1108f).f3208a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.f1124x);
        removeCallbacks(this.y);
        ViewPropertyAnimator viewPropertyAnimator = this.f1122v;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        boolean z;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1104A);
        boolean z2 = false;
        this.f1105c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1109g = drawable;
        if (drawable == null) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.f1110h = z2;
        this.f1121u = new OverScroller(context);
    }

    public final void j() {
        InterfaceC0276x wrapper;
        if (this.f1106d == null) {
            this.f1106d = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1107e = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof InterfaceC0276x) {
                wrapper = (InterfaceC0276x) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f1108f = wrapper;
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        Field field = J.f180a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0257d c0257d = (C0257d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) c0257d).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) c0257d).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        boolean z;
        j();
        measureChildWithMargins(this.f1107e, i2, 0, i3, 0);
        C0257d c0257d = (C0257d) this.f1107e.getLayoutParams();
        int i4 = 0;
        int max = Math.max(0, this.f1107e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0257d).leftMargin + ((ViewGroup.MarginLayoutParams) c0257d).rightMargin);
        int max2 = Math.max(0, this.f1107e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0257d).topMargin + ((ViewGroup.MarginLayoutParams) c0257d).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1107e.getMeasuredState());
        Field field = J.f180a;
        if ((getWindowSystemUiVisibility() & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i4 = this.f1105c;
            if (this.f1112j && this.f1107e.getTabContainer() != null) {
                i4 += this.f1105c;
            }
        } else if (this.f1107e.getVisibility() != 8) {
            i4 = this.f1107e.getMeasuredHeight();
        }
        Rect rect = this.f1116n;
        Rect rect2 = this.p;
        rect2.set(rect);
        Rect rect3 = this.q;
        Rect rect4 = this.f1119s;
        rect4.set(rect3);
        if (!this.f1111i && !z) {
            rect2.top += i4;
            rect2.bottom = rect2.bottom;
        } else {
            rect4.top += i4;
            rect4.bottom = rect4.bottom;
        }
        g(this.f1106d, rect2, true);
        Rect rect5 = this.f1120t;
        if (!rect5.equals(rect4)) {
            rect5.set(rect4);
            this.f1106d.a(rect4);
        }
        measureChildWithMargins(this.f1106d, i2, 0, i3, 0);
        C0257d c0257d2 = (C0257d) this.f1106d.getLayoutParams();
        int max3 = Math.max(max, this.f1106d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0257d2).leftMargin + ((ViewGroup.MarginLayoutParams) c0257d2).rightMargin);
        int max4 = Math.max(max2, this.f1106d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0257d2).topMargin + ((ViewGroup.MarginLayoutParams) c0257d2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1106d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (this.f1113k && z) {
            this.f1121u.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            if (this.f1121u.getFinalY() > this.f1107e.getHeight()) {
                h();
                this.y.run();
            } else {
                h();
                this.f1124x.run();
            }
            this.f1114l = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f1115m + i3;
        this.f1115m = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.z.f252b = i2;
        this.f1115m = getActionBarHideOffset();
        h();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) != 0 && this.f1107e.getVisibility() == 0) {
            return this.f1113k;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (this.f1113k && !this.f1114l) {
            if (this.f1115m <= this.f1107e.getHeight()) {
                h();
                postDelayed(this.f1124x, 600L);
            } else {
                h();
                postDelayed(this.y, 600L);
            }
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        j();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setActionBarHideOffset(int i2) {
        h();
        this.f1107e.setTranslationY(-Math.max(0, Math.min(i2, this.f1107e.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0256c interfaceC0256c) {
        if (getWindowToken() == null) {
        } else {
            throw null;
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1112j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1113k) {
            this.f1113k = z;
            if (!z) {
                h();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        j();
        o0 o0Var = (o0) this.f1108f;
        o0Var.f3211d = i2 != 0 ? AbstractC0203a.a(o0Var.f3208a.getContext(), i2) : null;
        o0Var.c();
    }

    public void setLogo(int i2) {
        Drawable drawable;
        j();
        o0 o0Var = (o0) this.f1108f;
        if (i2 != 0) {
            drawable = AbstractC0203a.a(o0Var.f3208a.getContext(), i2);
        } else {
            drawable = null;
        }
        o0Var.f3212e = drawable;
        o0Var.c();
    }

    public void setOverlayMode(boolean z) {
        boolean z2;
        this.f1111i = z;
        if (z && getContext().getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1110h = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Window.Callback callback) {
        j();
        ((o0) this.f1108f).f3218k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        j();
        o0 o0Var = (o0) this.f1108f;
        if (!o0Var.f3214g) {
            o0Var.f3215h = charSequence;
            if ((o0Var.f3209b & 8) != 0) {
                o0Var.f3208a.setTitle(charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        j();
        o0 o0Var = (o0) this.f1108f;
        o0Var.f3211d = drawable;
        o0Var.c();
    }

    @Override // E.r
    public final void d(int i2, int i3, int[] iArr, int i4) {
    }
}
