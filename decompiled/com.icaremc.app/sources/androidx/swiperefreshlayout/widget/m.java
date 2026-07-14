package androidx.swiperefreshlayout.widget;

import I.C0063q;
import I.C0065t;
import I.InterfaceC0064s;
import I.T;
import I.r;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.WeakHashMap;
import k0.AbstractC0429a;

/* loaded from: classes.dex */
public abstract class m extends ViewGroup implements InterfaceC0064s, r {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};
    private static final String LOG_TAG = "m";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private i mChildScrollUpCallback;
    private int mCircleDiameter;
    a mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private boolean mEnableLegacyRequestDisallowInterceptTouch;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    j mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final C0063q mNestedScrollingChildHelper;
    private final C0065t mNestedScrollingParentHelper;
    private final int[] mNestedScrollingV2ConsumedCompat;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    e mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Object, I.t] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.widget.ImageView, androidx.swiperefreshlayout.widget.a, android.view.View] */
    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new f(this, 0);
        this.mAnimateToCorrectPosition = new h(this, 0);
        this.mAnimateToStartPosition = new h(this, 4);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        ?? imageView = new ImageView(getContext());
        float f4 = imageView.getContext().getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = imageView.getContext().obtainStyledAttributes(AbstractC0429a.f5106a);
        imageView.f3145g = obtainStyledAttributes.getColor(0, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = T.f702a;
        imageView.setElevation(f4 * 4.0f);
        shapeDrawable.getPaint().setColor(imageView.f3145g);
        imageView.setBackground(shapeDrawable);
        this.mCircleView = imageView;
        e eVar = new e(getContext());
        this.mProgress = eVar;
        eVar.c(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
        setChildrenDrawingOrderEnabled(true);
        int i4 = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i4;
        this.mTotalDragDistance = i4;
        this.mNestedScrollingParentHelper = new Object();
        this.mNestedScrollingChildHelper = new C0063q(this);
        setNestedScrollingEnabled(true);
        int i5 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i5;
        this.mOriginalOffsetTop = i5;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes2.getBoolean(0, true));
        obtainStyledAttributes2.recycle();
    }

    private void setColorViewAlpha(int i4) {
        this.mCircleView.getBackground().setAlpha(i4);
        this.mProgress.setAlpha(i4);
    }

    public final void a() {
        if (this.mTarget == null) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public final void b(float f4) {
        f fVar;
        if (f4 > this.mTotalDragDistance) {
            d(true, true);
            return;
        }
        this.mRefreshing = false;
        e eVar = this.mProgress;
        d dVar = eVar.f3173f;
        dVar.f3154e = 0.0f;
        dVar.f3155f = 0.0f;
        eVar.invalidateSelf();
        boolean z = this.mScale;
        if (!z) {
            fVar = new f(this, 1);
        } else {
            fVar = null;
        }
        int i4 = this.mCurrentTargetOffsetTop;
        if (z) {
            this.mFrom = i4;
            this.mStartingScale = this.mCircleView.getScaleX();
            h hVar = new h(this, 1);
            this.mScaleDownToStartAnimation = hVar;
            hVar.setDuration(150L);
            if (fVar != null) {
                this.mCircleView.f3144f = fVar;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
        } else {
            this.mFrom = i4;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200L);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if (fVar != null) {
                this.mCircleView.f3144f = fVar;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mAnimateToStartPosition);
        }
        e eVar2 = this.mProgress;
        d dVar2 = eVar2.f3173f;
        if (dVar2.f3162n) {
            dVar2.f3162n = false;
        }
        eVar2.invalidateSelf();
    }

    public final void c(float f4) {
        Animation animation;
        Animation animation2;
        e eVar = this.mProgress;
        d dVar = eVar.f3173f;
        if (!dVar.f3162n) {
            dVar.f3162n = true;
        }
        eVar.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f4 / this.mTotalDragDistance));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f4) - this.mTotalDragDistance;
        int i4 = this.mCustomSlingshotDistance;
        if (i4 <= 0) {
            if (this.mUsingCustomStart) {
                i4 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
            } else {
                i4 = this.mSpinnerOffsetEnd;
            }
        }
        float f5 = i4;
        double max2 = Math.max(0.0f, Math.min(abs, f5 * DECELERATE_INTERPOLATION_FACTOR) / f5) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int i5 = this.mOriginalOffsetTop + ((int) ((f5 * min) + (f5 * pow * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f4 / this.mTotalDragDistance));
        }
        if (f4 < this.mTotalDragDistance) {
            if (this.mProgress.f3173f.f3168t > STARTING_PROGRESS_ALPHA && ((animation2 = this.mAlphaStartAnimation) == null || !animation2.hasStarted() || animation2.hasEnded())) {
                g gVar = new g(this, this.mProgress.f3173f.f3168t, STARTING_PROGRESS_ALPHA);
                gVar.setDuration(300L);
                a aVar = this.mCircleView;
                aVar.f3144f = null;
                aVar.clearAnimation();
                this.mCircleView.startAnimation(gVar);
                this.mAlphaStartAnimation = gVar;
            }
        } else if (this.mProgress.f3173f.f3168t < MAX_ALPHA && ((animation = this.mAlphaMaxAnimation) == null || !animation.hasStarted() || animation.hasEnded())) {
            g gVar2 = new g(this, this.mProgress.f3173f.f3168t, MAX_ALPHA);
            gVar2.setDuration(300L);
            a aVar2 = this.mCircleView;
            aVar2.f3144f = null;
            aVar2.clearAnimation();
            this.mCircleView.startAnimation(gVar2);
            this.mAlphaMaxAnimation = gVar2;
        }
        float f6 = max * MAX_PROGRESS_ANGLE;
        e eVar2 = this.mProgress;
        float min2 = Math.min(MAX_PROGRESS_ANGLE, f6);
        d dVar2 = eVar2.f3173f;
        dVar2.f3154e = 0.0f;
        dVar2.f3155f = min2;
        eVar2.invalidateSelf();
        e eVar3 = this.mProgress;
        float min3 = Math.min(1.0f, max);
        d dVar3 = eVar3.f3173f;
        if (min3 != dVar3.f3164p) {
            dVar3.f3164p = min3;
        }
        eVar3.invalidateSelf();
        float f7 = ((pow * DECELERATE_INTERPOLATION_FACTOR) + ((max * 0.4f) - 0.25f)) * DRAG_RATE;
        e eVar4 = this.mProgress;
        eVar4.f3173f.f3156g = f7;
        eVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i5 - this.mCurrentTargetOffsetTop);
    }

    public boolean canChildScrollUp() {
        i iVar = this.mChildScrollUpCallback;
        if (iVar != null) {
            return iVar.canChildScrollUp(this, this.mTarget);
        }
        View view = this.mTarget;
        if (view instanceof ListView) {
            return ((ListView) view).canScrollList(-1);
        }
        return view.canScrollVertically(-1);
    }

    public final void d(boolean z, boolean z3) {
        if (this.mRefreshing != z) {
            this.mNotify = z3;
            a();
            this.mRefreshing = z;
            if (z) {
                int i4 = this.mCurrentTargetOffsetTop;
                Animation.AnimationListener animationListener = this.mRefreshListener;
                this.mFrom = i4;
                this.mAnimateToCorrectPosition.reset();
                this.mAnimateToCorrectPosition.setDuration(200L);
                this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
                if (animationListener != null) {
                    this.mCircleView.f3144f = animationListener;
                }
                this.mCircleView.clearAnimation();
                this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
                return;
            }
            startScaleDownAnimation(this.mRefreshListener);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z) {
        return this.mNestedScrollingChildHelper.a(f4, f5, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return this.mNestedScrollingChildHelper.b(f4, f5);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return i6 == 0 && dispatchNestedPreScroll(i4, i5, iArr, iArr2);
    }

    public void dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        if (i8 == 0) {
            this.mNestedScrollingChildHelper.d(i4, i5, i6, i7, iArr, i8, iArr2);
        }
    }

    public final void e(float f4) {
        float f5 = this.mInitialDownY;
        float f6 = f4 - f5;
        int i4 = this.mTouchSlop;
        if (f6 > i4 && !this.mIsBeingDragged) {
            this.mInitialMotionY = f5 + i4;
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(STARTING_PROGRESS_ALPHA);
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i4, int i5) {
        int i6 = this.mCircleViewIndex;
        if (i6 >= 0) {
            if (i5 == i4 - 1) {
                return i6;
            }
            if (i5 >= i6) {
                return i5 + 1;
            }
            return i5;
        }
        return i5;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0065t c0065t = this.mNestedScrollingParentHelper;
        return c0065t.f786b | c0065t.f785a;
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent(int i4) {
        return i4 == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.f781d;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void moveToStart(float f4) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f4))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a();
        int actionMasked = motionEvent.getActionMasked();
        int i4 = 0;
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (isEnabled() && !this.mReturningToStart && !canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
                                    if (actionIndex == 0) {
                                        i4 = 1;
                                    }
                                    this.mActivePointerId = motionEvent.getPointerId(i4);
                                }
                            }
                        }
                    } else {
                        int i5 = this.mActivePointerId;
                        if (i5 == -1) {
                            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        int findPointerIndex = motionEvent.findPointerIndex(i5);
                        if (findPointerIndex >= 0) {
                            e(motionEvent.getY(findPointerIndex));
                        }
                    }
                    return this.mIsBeingDragged;
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                return this.mIsBeingDragged;
            }
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 >= 0) {
                this.mInitialDownY = motionEvent.getY(findPointerIndex2);
                return this.mIsBeingDragged;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                a();
            }
            View view = this.mTarget;
            if (view == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            int measuredWidth2 = this.mCircleView.getMeasuredWidth();
            int measuredHeight2 = this.mCircleView.getMeasuredHeight();
            int i8 = measuredWidth / 2;
            int i9 = measuredWidth2 / 2;
            int i10 = this.mCurrentTargetOffsetTop;
            this.mCircleView.layout(i8 - i9, i10, i8 + i9, measuredHeight2 + i10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.mTarget == null) {
            a();
        }
        View view = this.mTarget;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                if (getChildAt(i6) == this.mCircleView) {
                    this.mCircleViewIndex = i6;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z) {
        return dispatchNestedFling(f4, f5, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return dispatchNestedPreFling(f4, f5);
    }

    @Override // I.r
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr, int i6) {
        if (i6 == 0) {
            onNestedPreScroll(view, i4, i5, iArr);
        }
    }

    @Override // I.InterfaceC0064s
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        if (i8 != 0) {
            return;
        }
        int i9 = iArr[1];
        dispatchNestedScroll(i4, i5, i6, i7, this.mParentOffsetInWindow, i8, iArr);
        int i10 = i7 - (iArr[1] - i9);
        if ((i10 == 0 ? i7 + this.mParentOffsetInWindow[1] : i10) >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.mTotalUnconsumed + Math.abs(r14);
        this.mTotalUnconsumed = abs;
        c(abs);
        iArr[1] = iArr[1] + i10;
    }

    @Override // I.r
    public void onNestedScrollAccepted(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i4);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.getSuperState());
        setRefreshing(lVar.f3186f);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new l(super.onSaveInstanceState(), this.mRefreshing);
    }

    @Override // I.r
    public boolean onStartNestedScroll(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            return onStartNestedScroll(view, view2, i4);
        }
        return false;
    }

    @Override // I.r
    public void onStopNestedScroll(View view, int i4) {
        if (i4 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int i4 = 0;
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (isEnabled() && !this.mReturningToStart && !canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
                                        if (actionIndex == 0) {
                                            i4 = 1;
                                        }
                                        this.mActivePointerId = motionEvent.getPointerId(i4);
                                        return true;
                                    }
                                }
                                return true;
                            }
                            int actionIndex2 = motionEvent.getActionIndex();
                            if (actionIndex2 < 0) {
                                Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                                return false;
                            }
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex2);
                            return true;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex < 0) {
                            Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        float y3 = motionEvent.getY(findPointerIndex);
                        e(y3);
                        if (this.mIsBeingDragged) {
                            float f4 = (y3 - this.mInitialMotionY) * DRAG_RATE;
                            if (f4 > 0.0f) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                c(f4);
                            }
                        }
                        return true;
                    }
                } else {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex2 < 0) {
                        Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    if (this.mIsBeingDragged) {
                        float y4 = (motionEvent.getY(findPointerIndex2) - this.mInitialMotionY) * DRAG_RATE;
                        this.mIsBeingDragged = false;
                        b(y4);
                    }
                    this.mActivePointerId = -1;
                    return false;
                }
            } else {
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        View view = this.mTarget;
        if (view != null) {
            WeakHashMap weakHashMap = T.f702a;
            if (!view.isNestedScrollingEnabled()) {
                if (!this.mEnableLegacyRequestDisallowInterceptTouch && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(z);
                    return;
                }
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(MAX_ALPHA);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setAnimationProgress(float f4) {
        this.mCircleView.setScaleX(f4);
        this.mCircleView.setScaleY(f4);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        a();
        e eVar = this.mProgress;
        d dVar = eVar.f3173f;
        dVar.f3158i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr2[i4] = context.getColor(iArr[i4]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i4) {
        this.mTotalDragDistance = i4;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.mEnableLegacyRequestDisallowInterceptTouch = z;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0063q c0063q = this.mNestedScrollingChildHelper;
        if (c0063q.f781d) {
            ViewGroup viewGroup = c0063q.f780c;
            WeakHashMap weakHashMap = T.f702a;
            viewGroup.stopNestedScroll();
        }
        c0063q.f781d = z;
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.mChildScrollUpCallback = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.mListener = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i4) {
        setProgressBackgroundColorSchemeResource(i4);
    }

    public void setProgressBackgroundColorSchemeColor(int i4) {
        this.mCircleView.setBackgroundColor(i4);
    }

    public void setProgressBackgroundColorSchemeResource(int i4) {
        setProgressBackgroundColorSchemeColor(getContext().getColor(i4));
    }

    public void setProgressViewEndTarget(boolean z, int i4) {
        this.mSpinnerOffsetEnd = i4;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i4, int i5) {
        this.mScale = z;
        this.mOriginalOffsetTop = i4;
        this.mSpinnerOffsetEnd = i5;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean z) {
        int i4;
        if (z && this.mRefreshing != z) {
            this.mRefreshing = z;
            if (!this.mUsingCustomStart) {
                i4 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
            } else {
                i4 = this.mSpinnerOffsetEnd;
            }
            setTargetOffsetTopAndBottom(i4 - this.mCurrentTargetOffsetTop);
            this.mNotify = false;
            Animation.AnimationListener animationListener = this.mRefreshListener;
            this.mCircleView.setVisibility(0);
            this.mProgress.setAlpha(MAX_ALPHA);
            h hVar = new h(this, 2);
            this.mScaleAnimation = hVar;
            hVar.setDuration(this.mMediumAnimationDuration);
            if (animationListener != null) {
                this.mCircleView.f3144f = animationListener;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mScaleAnimation);
            return;
        }
        d(z, false);
    }

    public void setSize(int i4) {
        if (i4 != 0 && i4 != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i4 == 0) {
            this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
        } else {
            this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        }
        this.mCircleView.setImageDrawable(null);
        this.mProgress.c(i4);
        this.mCircleView.setImageDrawable(this.mProgress);
    }

    public void setSlingshotDistance(int i4) {
        this.mCustomSlingshotDistance = i4;
    }

    public void setTargetOffsetTopAndBottom(int i4) {
        this.mCircleView.bringToFront();
        a aVar = this.mCircleView;
        WeakHashMap weakHashMap = T.f702a;
        aVar.offsetTopAndBottom(i4);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public boolean startNestedScroll(int i4, int i5) {
        return i5 == 0 && startNestedScroll(i4);
    }

    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        h hVar = new h(this, 3);
        this.mScaleDownAnimation = hVar;
        hVar.setDuration(150L);
        a aVar = this.mCircleView;
        aVar.f3144f = animationListener;
        aVar.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    public void stopNestedScroll(int i4) {
        if (i4 == 0) {
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.c(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.f(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        if (i5 > 0) {
            float f4 = this.mTotalUnconsumed;
            if (f4 > 0.0f) {
                float f5 = i5;
                if (f5 > f4) {
                    iArr[1] = (int) f4;
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f4 - f5;
                    iArr[1] = i5;
                }
                c(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i5 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i5 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i4 - iArr[0], i5 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i4) {
        this.mNestedScrollingParentHelper.f785a = i4;
        startNestedScroll(i4 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (i4 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.f785a = 0;
        this.mNestedScrollInProgress = false;
        float f4 = this.mTotalUnconsumed;
        if (f4 > 0.0f) {
            b(f4);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i4) {
        return this.mNestedScrollingChildHelper.g(i4, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.h(0);
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        return i8 == 0 && this.mNestedScrollingChildHelper.d(i4, i5, i6, i7, iArr, i8, null);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.mNestedScrollingChildHelper.d(i4, i5, i6, i7, iArr, 0, null);
    }

    @Override // I.r
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7, int i8) {
        onNestedScroll(view, i4, i5, i6, i7, i8, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        onNestedScroll(view, i4, i5, i6, i7, 0, this.mNestedScrollingV2ConsumedCompat);
    }
}
