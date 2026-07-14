package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import h.AbstractC0201a;
import i.AbstractC0203a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class J implements l.r {
    public static final Method y;
    public static final Method z;

    /* renamed from: c, reason: collision with root package name */
    public final Context f3064c;

    /* renamed from: d, reason: collision with root package name */
    public ListAdapter f3065d;

    /* renamed from: e, reason: collision with root package name */
    public L f3066e;

    /* renamed from: g, reason: collision with root package name */
    public int f3068g;

    /* renamed from: h, reason: collision with root package name */
    public int f3069h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3070i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3071j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3072k;

    /* renamed from: m, reason: collision with root package name */
    public I.b f3074m;

    /* renamed from: n, reason: collision with root package name */
    public View f3075n;

    /* renamed from: o, reason: collision with root package name */
    public l.l f3076o;

    /* renamed from: t, reason: collision with root package name */
    public final Handler f3079t;

    /* renamed from: v, reason: collision with root package name */
    public Rect f3081v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3082w;

    /* renamed from: x, reason: collision with root package name */
    public final r f3083x;

    /* renamed from: f, reason: collision with root package name */
    public int f3067f = -2;

    /* renamed from: l, reason: collision with root package name */
    public int f3073l = 0;
    public final G p = new G(this, 1);
    public final I q = new I(this);

    /* renamed from: r, reason: collision with root package name */
    public final H f3077r = new H(this);

    /* renamed from: s, reason: collision with root package name */
    public final G f3078s = new G(this, 0);

    /* renamed from: u, reason: collision with root package name */
    public final Rect f3080u = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                y = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                z = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [m.r, android.widget.PopupWindow] */
    public J(Context context, int i2) {
        Drawable drawable;
        int resourceId;
        this.f3064c = context;
        this.f3079t = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0201a.f2308k, i2, 0);
        this.f3068g = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f3069h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f3070i = true;
        }
        obtainStyledAttributes.recycle();
        ?? popupWindow = new PopupWindow(context, (AttributeSet) null, i2, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(null, AbstractC0201a.f2312o, i2, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            popupWindow.setOverlapAnchor(obtainStyledAttributes2.getBoolean(2, false));
        }
        if (obtainStyledAttributes2.hasValue(0) && (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) != 0) {
            drawable = AbstractC0203a.a(context, resourceId);
        } else {
            drawable = obtainStyledAttributes2.getDrawable(0);
        }
        popupWindow.setBackgroundDrawable(drawable);
        obtainStyledAttributes2.recycle();
        this.f3083x = popupWindow;
        popupWindow.setInputMethodMode(1);
    }

    public final void a(ListAdapter listAdapter) {
        I.b bVar = this.f3074m;
        if (bVar == null) {
            this.f3074m = new I.b(1, this);
        } else {
            ListAdapter listAdapter2 = this.f3065d;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.f3065d = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f3074m);
        }
        L l2 = this.f3066e;
        if (l2 != null) {
            l2.setAdapter(this.f3065d);
        }
    }

    @Override // l.r
    public final ListView c() {
        return this.f3066e;
    }

    @Override // l.r
    public final void dismiss() {
        r rVar = this.f3083x;
        rVar.dismiss();
        rVar.setContentView(null);
        this.f3066e = null;
        this.f3079t.removeCallbacks(this.p);
    }

    @Override // l.r
    public final boolean i() {
        return this.f3083x.isShowing();
    }

    @Override // l.r
    public final void show() {
        int i2;
        boolean z2;
        int makeMeasureSpec;
        L l2;
        int i3;
        int i4;
        L l3 = this.f3066e;
        Context context = this.f3064c;
        r rVar = this.f3083x;
        int i5 = 0;
        if (l3 == null) {
            L l4 = new L(context, !this.f3082w);
            l4.setHoverListener((M) this);
            this.f3066e = l4;
            l4.setAdapter(this.f3065d);
            this.f3066e.setOnItemClickListener(this.f3076o);
            this.f3066e.setFocusable(true);
            this.f3066e.setFocusableInTouchMode(true);
            this.f3066e.setOnItemSelectedListener(new C0253F(i5, this));
            this.f3066e.setOnScrollListener(this.f3077r);
            rVar.setContentView(this.f3066e);
        }
        Drawable background = rVar.getBackground();
        Rect rect = this.f3080u;
        if (background != null) {
            background.getPadding(rect);
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.f3070i) {
                this.f3069h = -i6;
            }
        } else {
            rect.setEmpty();
            i2 = 0;
        }
        if (rVar.getInputMethodMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        int maxAvailableHeight = rVar.getMaxAvailableHeight(this.f3075n, this.f3069h, z2);
        int i7 = this.f3067f;
        if (i7 != -2) {
            if (i7 != -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            }
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
        }
        int a2 = this.f3066e.a(makeMeasureSpec, maxAvailableHeight);
        if (a2 > 0) {
            i5 = this.f3066e.getPaddingBottom() + this.f3066e.getPaddingTop() + i2;
        }
        int i8 = a2 + i5;
        this.f3083x.getInputMethodMode();
        rVar.setWindowLayoutType(1002);
        if (rVar.isShowing()) {
            View view = this.f3075n;
            Field field = E.J.f180a;
            if (view.isAttachedToWindow()) {
                int i9 = this.f3067f;
                if (i9 == -1) {
                    i9 = -1;
                } else if (i9 == -2) {
                    i9 = this.f3075n.getWidth();
                }
                rVar.setOutsideTouchable(true);
                View view2 = this.f3075n;
                int i10 = this.f3068g;
                int i11 = this.f3069h;
                if (i9 < 0) {
                    i3 = -1;
                } else {
                    i3 = i9;
                }
                if (i8 < 0) {
                    i4 = -1;
                } else {
                    i4 = i8;
                }
                rVar.update(view2, i10, i11, i3, i4);
                return;
            }
            return;
        }
        int i12 = this.f3067f;
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = this.f3075n.getWidth();
        }
        rVar.setWidth(i12);
        rVar.setHeight(i8);
        if (Build.VERSION.SDK_INT > 28) {
            rVar.setIsClippedToScreen(true);
        } else {
            Method method = y;
            if (method != null) {
                try {
                    method.invoke(rVar, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        }
        rVar.setOutsideTouchable(true);
        rVar.setTouchInterceptor(this.q);
        if (this.f3072k) {
            rVar.setOverlapAnchor(this.f3071j);
        }
        if (Build.VERSION.SDK_INT > 28) {
            rVar.setEpicenterBounds(this.f3081v);
        } else {
            Method method2 = z;
            if (method2 != null) {
                try {
                    method2.invoke(rVar, this.f3081v);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        }
        rVar.showAsDropDown(this.f3075n, this.f3068g, this.f3069h, this.f3073l);
        this.f3066e.setSelection(-1);
        if ((!this.f3082w || this.f3066e.isInTouchMode()) && (l2 = this.f3066e) != null) {
            l2.setListSelectionHidden(true);
            l2.requestLayout();
        }
        if (!this.f3082w) {
            this.f3079t.post(this.f3078s);
        }
    }
}
