package androidx.core.widget;

import A2.q;
import I.A;
import I.C0048b;
import I.C0053g;
import I.C0063q;
import I.C0065t;
import I.InterfaceC0064s;
import I.T;
import L.b;
import L.d;
import L.e;
import L.f;
import L.h;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.session.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0064s {

    /* renamed from: H, reason: collision with root package name */
    public static final float f2518H = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: I, reason: collision with root package name */
    public static final d f2519I = new C0048b();

    /* renamed from: J, reason: collision with root package name */
    public static final int[] f2520J = {R.attr.fillViewport};

    /* renamed from: A, reason: collision with root package name */
    public int f2521A;

    /* renamed from: B, reason: collision with root package name */
    public int f2522B;

    /* renamed from: C, reason: collision with root package name */
    public h f2523C;

    /* renamed from: D, reason: collision with root package name */
    public final C0065t f2524D;

    /* renamed from: E, reason: collision with root package name */
    public final C0063q f2525E;

    /* renamed from: F, reason: collision with root package name */
    public float f2526F;

    /* renamed from: G, reason: collision with root package name */
    public final C0053g f2527G;

    /* renamed from: f, reason: collision with root package name */
    public final float f2528f;

    /* renamed from: g, reason: collision with root package name */
    public long f2529g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f2530h;

    /* renamed from: i, reason: collision with root package name */
    public final OverScroller f2531i;

    /* renamed from: j, reason: collision with root package name */
    public final EdgeEffect f2532j;
    public final EdgeEffect k;

    /* renamed from: l, reason: collision with root package name */
    public A f2533l;

    /* renamed from: m, reason: collision with root package name */
    public int f2534m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2535n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2536o;

    /* renamed from: p, reason: collision with root package name */
    public View f2537p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2538q;

    /* renamed from: r, reason: collision with root package name */
    public VelocityTracker f2539r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2540s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2541t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2542u;

    /* renamed from: v, reason: collision with root package name */
    public final int f2543v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2544w;

    /* renamed from: x, reason: collision with root package name */
    public int f2545x;

    /* renamed from: y, reason: collision with root package name */
    public final int[] f2546y;
    public final int[] z;

    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, I.t] */
    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.icaremc.app.R.attr.nestedScrollViewStyle);
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        this.f2530h = new Rect();
        this.f2535n = true;
        this.f2536o = false;
        this.f2537p = null;
        this.f2538q = false;
        this.f2541t = true;
        this.f2545x = -1;
        this.f2546y = new int[2];
        this.z = new int[2];
        this.f2527G = new C0053g(getContext(), new q(6, this));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            edgeEffect = b.a(context, attributeSet);
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.f2532j = edgeEffect;
        if (i4 >= 31) {
            edgeEffect2 = b.a(context, attributeSet);
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.k = edgeEffect2;
        this.f2528f = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f2531i = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2542u = viewConfiguration.getScaledTouchSlop();
        this.f2543v = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2544w = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2520J, com.icaremc.app.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2524D = new Object();
        this.f2525E = new C0063q(this);
        setNestedScrollingEnabled(true);
        T.i(this, f2519I);
    }

    public static boolean g(View view, NestedScrollView nestedScrollView) {
        if (view != nestedScrollView) {
            Object parent = view.getParent();
            if ((parent instanceof ViewGroup) && g((View) parent, nestedScrollView)) {
                return true;
            }
            return false;
        }
        return true;
    }

    private A getScrollFeedbackProvider() {
        if (this.f2533l == null) {
            this.f2533l = new A(this);
        }
        return this.f2533l;
    }

    public final boolean a(int i4) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View view = findFocus;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i4);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && h(findNextFocus, maxScrollAmount, getHeight())) {
            Rect rect = this.f2530h;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            n(b(rect), -1, null, 0, 1, true);
            findNextFocus.requestFocus(i4);
        } else {
            if (i4 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i4 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i4 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            n(maxScrollAmount, -1, null, 0, 1, true);
        }
        if (view != null && view.isFocused() && !h(view, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final int b(Rect rect) {
        int i4;
        int i5;
        int i6;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i4 = i7 - verticalFadingEdgeLength;
        } else {
            i4 = i7;
        }
        int i8 = rect.bottom;
        if (i8 > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i6 = rect.top - scrollY;
            } else {
                i6 = rect.bottom - i4;
            }
            return Math.min(i6, (childAt.getBottom() + layoutParams.bottomMargin) - i7);
        }
        if (rect.top >= scrollY || i8 >= i4) {
            return 0;
        }
        if (rect.height() > height) {
            i5 = 0 - (i4 - rect.bottom);
        } else {
            i5 = 0 - (scrollY - rect.top);
        }
        return Math.max(i5, -getScrollY());
    }

    public final boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return this.f2525E.c(i4, i5, iArr, null, i6);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return (scrollY - max) + bottom;
        }
        return bottom;
    }

    public final boolean d(KeyEvent keyEvent) {
        this.f2530h.setEmpty();
        int i4 = 130;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 19) {
                        if (keyCode != 20) {
                            if (keyCode != 62) {
                                if (keyCode != 92) {
                                    if (keyCode != 93) {
                                        if (keyCode != 122) {
                                            if (keyCode == 123) {
                                                l(130);
                                                return false;
                                            }
                                        } else {
                                            l(33);
                                            return false;
                                        }
                                    } else {
                                        return f(130);
                                    }
                                } else {
                                    return f(33);
                                }
                            } else {
                                if (keyEvent.isShiftPressed()) {
                                    i4 = 33;
                                }
                                l(i4);
                                return false;
                            }
                        } else {
                            if (keyEvent.isAltPressed()) {
                                return f(130);
                            }
                            return a(130);
                        }
                    } else {
                        if (keyEvent.isAltPressed()) {
                            return f(33);
                        }
                        return a(33);
                    }
                }
                return false;
            }
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(130)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !d(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z) {
        return this.f2525E.a(f4, f5, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f2525E.b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return this.f2525E.c(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.f2525E.d(i4, i5, i6, i7, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f2532j;
        int i5 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (getClipToPadding()) {
                width -= getPaddingRight() + getPaddingLeft();
                i4 = getPaddingLeft();
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            } else {
                i4 = 0;
            }
            canvas.translate(i4, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.k;
        if (!edgeEffect2.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i5 = getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate(i5 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            edgeEffect2.setSize(width2, height2);
            if (edgeEffect2.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    public final void e(int i4) {
        if (getChildCount() > 0) {
            this.f2531i.fling(getScrollX(), getScrollY(), 0, i4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            q(2, 1);
            this.f2522B = getScrollY();
            postInvalidateOnAnimation();
            if (Build.VERSION.SDK_INT >= 35) {
                e.a(this, Math.abs(this.f2531i.getCurrVelocity()));
            }
        }
    }

    public final boolean f(int i4) {
        boolean z;
        int childCount;
        if (i4 == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.f2530h;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return m(i4, rect.top, rect.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0065t c0065t = this.f2524D;
        return c0065t.f786b | c0065t.f785a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f2526F == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.f2526F = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2526F;
    }

    public final boolean h(View view, int i4, int i5) {
        Rect rect = this.f2530h;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        if (rect.bottom + i4 >= getScrollY() && rect.top - i4 <= getScrollY() + i5) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f2525E.f(0);
    }

    public final void i(int i4, int i5, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2525E.d(0, scrollY2, 0, i4 - scrollY2, null, i5, iArr);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f2525E.f781d;
    }

    public final void j(MotionEvent motionEvent) {
        int i4;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2545x) {
            if (actionIndex == 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            this.f2534m = (int) motionEvent.getY(i4);
            this.f2545x = motionEvent.getPointerId(i4);
            VelocityTracker velocityTracker = this.f2539r;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean k(int i4, int i5, int i6, int i7) {
        int i8;
        boolean z;
        int i9;
        boolean z3;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i10 = i6 + i4;
        if (i5 > 0 || i5 < 0) {
            i8 = 0;
            z = true;
        } else {
            i8 = i5;
            z = false;
        }
        if (i10 > i7) {
            i9 = i7;
        } else if (i10 < 0) {
            i9 = 0;
        } else {
            i9 = i10;
            z3 = false;
            if (z3 && !this.f2525E.f(1)) {
                this.f2531i.springBack(i8, i9, 0, 0, 0, getScrollRange());
            }
            super.scrollTo(i8, i9);
            if (!z || z3) {
                return true;
            }
            return false;
        }
        z3 = true;
        if (z3) {
            this.f2531i.springBack(i8, i9, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i8, i9);
        if (!z) {
        }
        return true;
    }

    public final void l(int i4) {
        boolean z;
        if (i4 == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.f2530h;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i5 = rect.top;
        int i6 = height + i5;
        rect.bottom = i6;
        m(i4, i5, i6);
    }

    public final boolean m(int i4, int i5, int i6) {
        boolean z;
        View view;
        int i7;
        boolean z3;
        boolean z4;
        boolean z5;
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = height + scrollY;
        if (i4 == 33) {
            z = true;
        } else {
            z = false;
        }
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view2 = null;
        boolean z6 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view3 = focusables.get(i9);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i5 < bottom && top < i6) {
                if (i5 < top && bottom < i6) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (view2 == null) {
                    view2 = view3;
                    z6 = z4;
                } else {
                    if ((z && top < view2.getTop()) || (!z && bottom > view2.getBottom())) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z6) {
                        if (z4) {
                            if (!z5) {
                            }
                            view2 = view3;
                        }
                    } else if (z4) {
                        view2 = view3;
                        z6 = true;
                    } else {
                        if (!z5) {
                        }
                        view2 = view3;
                    }
                }
            }
        }
        if (view2 == null) {
            view = this;
        } else {
            view = view2;
        }
        if (i5 >= scrollY && i6 <= i8) {
            z3 = false;
        } else {
            if (z) {
                i7 = i5 - scrollY;
            } else {
                i7 = i6 - i8;
            }
            n(i7, -1, null, 0, 1, true);
            z3 = true;
        }
        if (view != findFocus()) {
            view.requestFocus(i4);
        }
        return z3;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n(int r21, int r22, android.view.MotionEvent r23, int r24, int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.n(int, int, android.view.MotionEvent, int, int, boolean):int");
    }

    public final boolean o(EdgeEffect edgeEffect, int i4) {
        if (i4 > 0) {
            return true;
        }
        float m3 = a.m(edgeEffect) * getHeight();
        float abs = Math.abs(-i4) * 0.35f;
        float f4 = this.f2528f * 0.015f;
        double log = Math.log(abs / f4);
        double d4 = f2518H;
        if (((float) (Math.exp((d4 / (d4 - 1.0d)) * log) * f4)) < m3) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2536o = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0122, code lost:
    
        if (r0 >= 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00d7, code lost:
    
        if (r7 >= 0) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ab  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r32) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.f2538q) {
            return true;
        }
        int i4 = action & 255;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 6) {
                            j(motionEvent);
                        }
                    }
                } else {
                    int i5 = this.f2545x;
                    if (i5 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i5);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i5 + " in onInterceptTouchEvent");
                        } else {
                            int y3 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y3 - this.f2534m) > this.f2542u && (2 & getNestedScrollAxes()) == 0) {
                                this.f2538q = true;
                                this.f2534m = y3;
                                if (this.f2539r == null) {
                                    this.f2539r = VelocityTracker.obtain();
                                }
                                this.f2539r.addMovement(motionEvent);
                                this.f2521A = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f2538q = false;
            this.f2545x = -1;
            VelocityTracker velocityTracker = this.f2539r;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2539r = null;
            }
            if (this.f2531i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            s(0);
        } else {
            int y4 = (int) motionEvent.getY();
            int x3 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y4 >= childAt.getTop() - scrollY && y4 < childAt.getBottom() - scrollY && x3 >= childAt.getLeft() && x3 < childAt.getRight()) {
                    this.f2534m = y4;
                    this.f2545x = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.f2539r;
                    if (velocityTracker2 == null) {
                        this.f2539r = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.f2539r.addMovement(motionEvent);
                    this.f2531i.computeScrollOffset();
                    if (!r(motionEvent) && this.f2531i.isFinished()) {
                        z = false;
                    }
                    this.f2538q = z;
                    q(2, 0);
                }
            }
            if (!r(motionEvent) && this.f2531i.isFinished()) {
                z = false;
            }
            this.f2538q = z;
            VelocityTracker velocityTracker3 = this.f2539r;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f2539r = null;
            }
        }
        return this.f2538q;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        super.onLayout(z, i4, i5, i6, i7);
        int i9 = 0;
        this.f2535n = false;
        View view = this.f2537p;
        if (view != null && g(view, this)) {
            View view2 = this.f2537p;
            Rect rect = this.f2530h;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int b4 = b(rect);
            if (b4 != 0) {
                scrollBy(0, b4);
            }
        }
        this.f2537p = null;
        if (!this.f2536o) {
            if (this.f2523C != null) {
                scrollTo(getScrollX(), this.f2523C.f970f);
                this.f2523C = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i8 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i8 = 0;
            }
            int paddingTop = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i8 && scrollY >= 0) {
                i9 = paddingTop + scrollY > i8 ? i8 - paddingTop : scrollY;
            }
            if (i9 != scrollY) {
                scrollTo(getScrollX(), i9);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2536o = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f2540s && View.MeasureSpec.getMode(i5) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z) {
        if (!z) {
            dispatchNestedFling(0.0f, f5, true);
            e((int) f5);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return this.f2525E.b(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        c(i4, i5, iArr, null, 0);
    }

    @Override // I.InterfaceC0064s
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        i(i7, i8, iArr);
    }

    @Override // I.r
    public final void onNestedScrollAccepted(View view, View view2, int i4, int i5) {
        C0065t c0065t = this.f2524D;
        if (i5 == 1) {
            c0065t.f786b = i4;
        } else {
            c0065t.f785a = i4;
        }
        q(2, i5);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i4, int i5, boolean z, boolean z3) {
        super.scrollTo(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        View findNextFocusFromRect;
        if (i4 == 2) {
            i4 = 130;
        } else if (i4 == 1) {
            i4 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i4);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i4);
        }
        if (findNextFocusFromRect == null || !h(findNextFocusFromRect, 0, getHeight())) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i4, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        this.f2523C = hVar;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, L.h] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f970f = getScrollY();
        return baseSavedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && h(findFocus, 0, i7)) {
            Rect rect = this.f2530h;
            findFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findFocus, rect);
            int b4 = b(rect);
            if (b4 != 0) {
                if (this.f2541t) {
                    p(0, b4, false);
                } else {
                    scrollBy(0, b4);
                }
            }
        }
    }

    @Override // I.r
    public final boolean onStartNestedScroll(View view, View view2, int i4, int i5) {
        return (i4 & 2) != 0;
    }

    @Override // I.r
    public final void onStopNestedScroll(View view, int i4) {
        C0065t c0065t = this.f2524D;
        if (i4 == 1) {
            c0065t.f786b = 0;
        } else {
            c0065t.f785a = 0;
        }
        s(i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i4, int i5, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2529g > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int max = Math.max(0, Math.min(i5 + scrollY, Math.max(0, height - height2))) - scrollY;
            this.f2531i.startScroll(getScrollX(), scrollY, 0, max, 250);
            if (z) {
                q(2, 1);
            } else {
                s(1);
            }
            this.f2522B = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f2531i.isFinished()) {
                this.f2531i.abortAnimation();
                s(1);
            }
            scrollBy(i4, i5);
        }
        this.f2529g = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean q(int i4, int i5) {
        return this.f2525E.g(2, i5);
    }

    public final boolean r(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.f2532j;
        if (a.m(edgeEffect) != 0.0f) {
            a.r(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.k;
        if (a.m(edgeEffect2) != 0.0f) {
            a.r(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.f2535n) {
            Rect rect = this.f2530h;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int b4 = b(rect);
            if (b4 != 0) {
                scrollBy(0, b4);
            }
        } else {
            this.f2537p = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        boolean z3;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int b4 = b(rect);
        if (b4 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (z) {
                scrollBy(0, b4);
                return z3;
            }
            p(0, b4, false);
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.f2539r) != null) {
            velocityTracker.recycle();
            this.f2539r = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f2535n = true;
        super.requestLayout();
    }

    public final void s(int i4) {
        this.f2525E.h(i4);
    }

    @Override // android.view.View
    public final void scrollTo(int i4, int i5) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width < width2 && i4 >= 0) {
                if (width + i4 > width2) {
                    i4 = width2 - width;
                }
            } else {
                i4 = 0;
            }
            if (height < height2 && i5 >= 0) {
                if (height + i5 > height2) {
                    i5 = height2 - height;
                }
            } else {
                i5 = 0;
            }
            if (i4 != getScrollX() || i5 != getScrollY()) {
                super.scrollTo(i4, i5);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f2540s) {
            this.f2540s = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0063q c0063q = this.f2525E;
        if (c0063q.f781d) {
            ViewGroup viewGroup = c0063q.f780c;
            WeakHashMap weakHashMap = T.f702a;
            viewGroup.stopNestedScroll();
        }
        c0063q.f781d = z;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f2541t = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i4) {
        return this.f2525E.g(i4, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        s(0);
    }

    @Override // I.r
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr, int i6) {
        c(i4, i5, iArr, null, i6);
    }

    @Override // I.r
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7, int i8) {
        i(i7, i8, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        return onStartNestedScroll(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        i(i7, 0, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4) {
        if (getChildCount() <= 0) {
            super.addView(view, i4);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        onNestedScrollAccepted(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i4, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(f fVar) {
    }
}
