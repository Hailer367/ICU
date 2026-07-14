package o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.icaremc.app.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class A1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: p, reason: collision with root package name */
    public static A1 f5403p;

    /* renamed from: q, reason: collision with root package name */
    public static A1 f5404q;

    /* renamed from: f, reason: collision with root package name */
    public final View f5405f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f5406g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5407h;

    /* renamed from: i, reason: collision with root package name */
    public final z1 f5408i;

    /* renamed from: j, reason: collision with root package name */
    public final z1 f5409j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public int f5410l;

    /* renamed from: m, reason: collision with root package name */
    public B1 f5411m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5412n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5413o;

    /* JADX WARN: Type inference failed for: r0v0, types: [o.z1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [o.z1] */
    public A1(View view, CharSequence charSequence) {
        int scaledTouchSlop;
        final int i4 = 0;
        this.f5408i = new Runnable(this) { // from class: o.z1

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ A1 f5758g;

            {
                this.f5758g = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        this.f5758g.c(false);
                        return;
                    default:
                        this.f5758g.a();
                        return;
                }
            }
        };
        final int i5 = 1;
        this.f5409j = new Runnable(this) { // from class: o.z1

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ A1 f5758g;

            {
                this.f5758g = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i5) {
                    case 0:
                        this.f5758g.c(false);
                        return;
                    default:
                        this.f5758g.a();
                        return;
                }
            }
        };
        this.f5405f = view;
        this.f5406g = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = I.U.f707a;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = C.b.m(viewConfiguration);
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.f5407h = scaledTouchSlop;
        this.f5413o = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(A1 a12) {
        A1 a13 = f5403p;
        if (a13 != null) {
            a13.f5405f.removeCallbacks(a13.f5408i);
        }
        f5403p = a12;
        if (a12 != null) {
            a12.f5405f.postDelayed(a12.f5408i, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        A1 a12 = f5404q;
        View view = this.f5405f;
        if (a12 == this) {
            f5404q = null;
            B1 b12 = this.f5411m;
            if (b12 != null) {
                View view2 = (View) b12.f5415g;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) b12.f5414f).getSystemService("window")).removeView(view2);
                }
                this.f5411m = null;
                this.f5413o = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f5403p == this) {
            b(null);
        }
        view.removeCallbacks(this.f5409j);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, o.B1] */
    public final void c(boolean z) {
        int height;
        int i4;
        int i5;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        long longPressTimeout;
        long j4;
        long j5;
        WeakHashMap weakHashMap = I.T.f702a;
        View view = this.f5405f;
        if (!view.isAttachedToWindow()) {
            return;
        }
        b(null);
        A1 a12 = f5404q;
        if (a12 != null) {
            a12.a();
        }
        f5404q = this;
        this.f5412n = z;
        Context context = view.getContext();
        ?? obj = new Object();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        obj.f5417i = layoutParams;
        obj.f5418j = new Rect();
        obj.k = new int[2];
        obj.f5419l = new int[2];
        obj.f5414f = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        obj.f5415g = inflate;
        obj.f5416h = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(B1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
        View view2 = (View) obj.f5415g;
        Context context2 = (Context) obj.f5414f;
        this.f5411m = obj;
        int i10 = this.k;
        int i11 = this.f5410l;
        boolean z4 = this.f5412n;
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) obj.f5417i;
        if (view2.getParent() != null && view2.getParent() != null) {
            ((WindowManager) context2.getSystemService("window")).removeView(view2);
        }
        ((TextView) obj.f5416h).setText(this.f5406g);
        int[] iArr = (int[]) obj.f5419l;
        int[] iArr2 = (int[]) obj.k;
        Rect rect = (Rect) obj.f5418j;
        layoutParams2.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i11 + dimensionPixelOffset2;
            i4 = i11 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams2.gravity = 49;
        Resources resources = context2.getResources();
        if (z4) {
            i5 = R.dimen.tooltip_y_offset_touch;
        } else {
            i5 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i5);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
        int i12 = i10;
        if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
            Context context3 = view.getContext();
            while (true) {
                if (!(context3 instanceof ContextWrapper)) {
                    break;
                }
                if (context3 instanceof Activity) {
                    rootView = ((Activity) context3).getWindow().getDecorView();
                    break;
                }
                context3 = ((ContextWrapper) context3).getBaseContext();
            }
        }
        if (rootView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            i8 = 1;
        } else {
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left < 0 && rect.top < 0) {
                Resources resources2 = context2.getResources();
                i8 = 1;
                i6 = i4;
                z3 = z4;
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i9 = resources2.getDimensionPixelSize(identifier);
                } else {
                    i9 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                i7 = 0;
                rect.set(0, i9, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                i6 = i4;
                z3 = z4;
                i7 = 0;
                i8 = 1;
            }
            rootView.getLocationOnScreen(iArr);
            view.getLocationOnScreen(iArr2);
            int i13 = iArr2[i7] - iArr[i7];
            iArr2[i7] = i13;
            iArr2[i8] = iArr2[i8] - iArr[i8];
            layoutParams2.x = (i13 + i12) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, i7);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int i14 = iArr2[i8];
            int i15 = ((i14 + i6) - dimensionPixelOffset3) - measuredHeight;
            int i16 = i14 + height + dimensionPixelOffset3;
            if (z3) {
                if (i15 >= 0) {
                    layoutParams2.y = i15;
                } else {
                    layoutParams2.y = i16;
                }
            } else if (measuredHeight + i16 <= rect.height()) {
                layoutParams2.y = i16;
            } else {
                layoutParams2.y = i15;
            }
        }
        ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
        view.addOnAttachStateChangeListener(this);
        if (this.f5412n) {
            j5 = 2500;
        } else {
            if ((view.getWindowSystemUiVisibility() & 1) == i8) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j4 = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j4 = 15000;
            }
            j5 = j4 - longPressTimeout;
        }
        z1 z1Var = this.f5409j;
        view.removeCallbacks(z1Var);
        view.postDelayed(z1Var, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.f5410l) <= r2) goto L30;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            o.B1 r4 = r3.f5411m
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f5412n
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f5405f
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f5413o = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            o.B1 r4 = r3.f5411m
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f5413o
            if (r1 != 0) goto L66
            int r1 = r3.k
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f5407h
            if (r1 > r2) goto L66
            int r1 = r3.f5410l
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.k = r4
            r3.f5410l = r5
            r3.f5413o = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.A1.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.k = view.getWidth() / 2;
        this.f5410l = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
