package m;

import E.AbstractC0005e;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import com.google.android.gms.common.api.Api;
import com.icaremc.doctors.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class q0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: l, reason: collision with root package name */
    public static q0 f3227l;

    /* renamed from: m, reason: collision with root package name */
    public static q0 f3228m;

    /* renamed from: c, reason: collision with root package name */
    public final View f3229c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f3230d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3231e;

    /* renamed from: f, reason: collision with root package name */
    public final p0 f3232f = new p0(this, 0);

    /* renamed from: g, reason: collision with root package name */
    public final p0 f3233g = new p0(this, 1);

    /* renamed from: h, reason: collision with root package name */
    public int f3234h;

    /* renamed from: i, reason: collision with root package name */
    public int f3235i;

    /* renamed from: j, reason: collision with root package name */
    public r0 f3236j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3237k;

    public q0(CharSequence charSequence, View view) {
        int scaledTouchSlop;
        this.f3229c = view;
        this.f3230d = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = E.K.f182a;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = AbstractC0005e.l(viewConfiguration);
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.f3231e = scaledTouchSlop;
        this.f3234h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3235i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(q0 q0Var) {
        q0 q0Var2 = f3227l;
        if (q0Var2 != null) {
            q0Var2.f3229c.removeCallbacks(q0Var2.f3232f);
        }
        f3227l = q0Var;
        if (q0Var != null) {
            q0Var.f3229c.postDelayed(q0Var.f3232f, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        q0 q0Var = f3228m;
        View view = this.f3229c;
        if (q0Var == this) {
            f3228m = null;
            r0 r0Var = this.f3236j;
            if (r0Var != null) {
                View view2 = (View) r0Var.f3239d;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) r0Var.f3238c).getSystemService("window")).removeView(view2);
                }
                this.f3236j = null;
                this.f3234h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                this.f3235i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f3227l == this) {
            b(null);
        }
        view.removeCallbacks(this.f3233g);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, m.r0] */
    public final void c(boolean z) {
        int height;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        long longPressTimeout;
        long j2;
        long j3;
        Field field = E.J.f180a;
        View view = this.f3229c;
        if (!view.isAttachedToWindow()) {
            return;
        }
        b(null);
        q0 q0Var = f3228m;
        if (q0Var != null) {
            q0Var.a();
        }
        f3228m = this;
        this.f3237k = z;
        Context context = view.getContext();
        ?? obj = new Object();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        obj.f3241f = layoutParams;
        obj.f3242g = new Rect();
        obj.f3243h = new int[2];
        obj.f3244i = new int[2];
        obj.f3238c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        obj.f3239d = inflate;
        obj.f3240e = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(r0.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
        View view2 = (View) obj.f3239d;
        Context context2 = (Context) obj.f3238c;
        this.f3236j = obj;
        int i8 = this.f3234h;
        int i9 = this.f3235i;
        boolean z3 = this.f3237k;
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) obj.f3241f;
        if (view2.getParent() != null && view2.getParent() != null) {
            ((WindowManager) context2.getSystemService("window")).removeView(view2);
        }
        ((TextView) obj.f3240e).setText(this.f3230d);
        int[] iArr = (int[]) obj.f3244i;
        int[] iArr2 = (int[]) obj.f3243h;
        Rect rect = (Rect) obj.f3242g;
        layoutParams2.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i8 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i9 + dimensionPixelOffset2;
            i2 = i9 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i2 = 0;
        }
        layoutParams2.gravity = 49;
        Resources resources = context2.getResources();
        if (z3) {
            i3 = R.dimen.tooltip_y_offset_touch;
        } else {
            i3 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i3);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
        int i10 = i8;
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
            i6 = 1;
        } else {
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left < 0 && rect.top < 0) {
                Resources resources2 = context2.getResources();
                i6 = 1;
                i4 = i2;
                z2 = z3;
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i7 = resources2.getDimensionPixelSize(identifier);
                } else {
                    i7 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                i5 = 0;
                rect.set(0, i7, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                i4 = i2;
                z2 = z3;
                i5 = 0;
                i6 = 1;
            }
            rootView.getLocationOnScreen(iArr);
            view.getLocationOnScreen(iArr2);
            int i11 = iArr2[i5] - iArr[i5];
            iArr2[i5] = i11;
            iArr2[i6] = iArr2[i6] - iArr[i6];
            layoutParams2.x = (i11 + i10) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, i5);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int i12 = iArr2[i6];
            int i13 = ((i12 + i4) - dimensionPixelOffset3) - measuredHeight;
            int i14 = i12 + height + dimensionPixelOffset3;
            if (z2) {
                if (i13 >= 0) {
                    layoutParams2.y = i13;
                } else {
                    layoutParams2.y = i14;
                }
            } else if (measuredHeight + i14 <= rect.height()) {
                layoutParams2.y = i14;
            } else {
                layoutParams2.y = i13;
            }
        }
        ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
        view.addOnAttachStateChangeListener(this);
        if (this.f3237k) {
            j3 = 2500;
        } else {
            if ((view.getWindowSystemUiVisibility() & 1) == i6) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j2 = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j2 = 15000;
            }
            j3 = j2 - longPressTimeout;
        }
        p0 p0Var = this.f3233g;
        view.removeCallbacks(p0Var);
        view.postDelayed(p0Var, j3);
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f3236j == null || !this.f3237k) {
            View view2 = this.f3229c;
            AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action != 7) {
                    if (action == 10) {
                        this.f3234h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        this.f3235i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        a();
                        return false;
                    }
                } else if (view2.isEnabled() && this.f3236j == null) {
                    int x2 = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int abs = Math.abs(x2 - this.f3234h);
                    int i2 = this.f3231e;
                    if (abs > i2 || Math.abs(y - this.f3235i) > i2) {
                        this.f3234h = x2;
                        this.f3235i = y;
                        b(this);
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f3234h = view.getWidth() / 2;
        this.f3235i = view.getHeight() / 2;
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
