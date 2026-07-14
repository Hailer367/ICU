package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: o.M0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0486M0 implements n.F {

    /* renamed from: E, reason: collision with root package name */
    public static final Method f5475E;

    /* renamed from: F, reason: collision with root package name */
    public static final Method f5476F;

    /* renamed from: B, reason: collision with root package name */
    public Rect f5478B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f5479C;

    /* renamed from: D, reason: collision with root package name */
    public final C0463B f5480D;

    /* renamed from: f, reason: collision with root package name */
    public final Context f5481f;

    /* renamed from: g, reason: collision with root package name */
    public ListAdapter f5482g;

    /* renamed from: h, reason: collision with root package name */
    public C0462A0 f5483h;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public int f5486l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5488n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5489o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5490p;

    /* renamed from: s, reason: collision with root package name */
    public M.b f5493s;

    /* renamed from: t, reason: collision with root package name */
    public View f5494t;

    /* renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f5495u;
    public final Handler z;

    /* renamed from: i, reason: collision with root package name */
    public final int f5484i = -2;

    /* renamed from: j, reason: collision with root package name */
    public int f5485j = -2;

    /* renamed from: m, reason: collision with root package name */
    public final int f5487m = 1002;

    /* renamed from: q, reason: collision with root package name */
    public int f5491q = 0;

    /* renamed from: r, reason: collision with root package name */
    public final int f5492r = Integer.MAX_VALUE;

    /* renamed from: v, reason: collision with root package name */
    public final RunnableC0480J0 f5496v = new RunnableC0480J0(this, 1);

    /* renamed from: w, reason: collision with root package name */
    public final ViewOnTouchListenerC0484L0 f5497w = new ViewOnTouchListenerC0484L0(this);

    /* renamed from: x, reason: collision with root package name */
    public final C0482K0 f5498x = new C0482K0(this);

    /* renamed from: y, reason: collision with root package name */
    public final RunnableC0480J0 f5499y = new RunnableC0480J0(this, 0);

    /* renamed from: A, reason: collision with root package name */
    public final Rect f5477A = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f5475E = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f5476F = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [o.B, android.widget.PopupWindow] */
    public AbstractC0486M0(Context context, AttributeSet attributeSet, int i4) {
        Drawable drawable;
        int resourceId;
        this.f5481f = context;
        this.z = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4079o, i4, 0);
        this.k = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f5486l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f5488n = true;
        }
        obtainStyledAttributes.recycle();
        ?? popupWindow = new PopupWindow(context, attributeSet, i4, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4083s, i4, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            popupWindow.setOverlapAnchor(obtainStyledAttributes2.getBoolean(2, false));
        }
        if (obtainStyledAttributes2.hasValue(0) && (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) != 0) {
            drawable = AbstractC0286a.o(context, resourceId);
        } else {
            drawable = obtainStyledAttributes2.getDrawable(0);
        }
        popupWindow.setBackgroundDrawable(drawable);
        obtainStyledAttributes2.recycle();
        this.f5480D = popupWindow;
        popupWindow.setInputMethodMode(1);
    }

    public final int a() {
        return this.k;
    }

    @Override // n.F
    public final boolean b() {
        return this.f5480D.isShowing();
    }

    @Override // n.F
    public final void c() {
        int i4;
        boolean z;
        int makeMeasureSpec;
        int i5;
        int i6;
        boolean z3;
        C0462A0 c0462a0;
        int i7;
        int i8;
        C0462A0 c0462a02 = this.f5483h;
        Context context = this.f5481f;
        C0463B c0463b = this.f5480D;
        int i9 = 0;
        if (c0462a02 == null) {
            C0462A0 q2 = q(context, !this.f5479C);
            this.f5483h = q2;
            q2.setAdapter(this.f5482g);
            this.f5483h.setOnItemClickListener(this.f5495u);
            this.f5483h.setFocusable(true);
            this.f5483h.setFocusableInTouchMode(true);
            this.f5483h.setOnItemSelectedListener(new C0474G0(0, this));
            this.f5483h.setOnScrollListener(this.f5498x);
            c0463b.setContentView(this.f5483h);
        }
        Drawable background = c0463b.getBackground();
        Rect rect = this.f5477A;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i4 = rect.bottom + i10;
            if (!this.f5488n) {
                this.f5486l = -i10;
            }
        } else {
            rect.setEmpty();
            i4 = 0;
        }
        if (c0463b.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int a4 = AbstractC0476H0.a(c0463b, this.f5494t, this.f5486l, z);
        int i11 = this.f5484i;
        if (i11 == -1) {
            i6 = a4 + i4;
        } else {
            int i12 = this.f5485j;
            if (i12 != -2) {
                if (i12 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int a5 = this.f5483h.a(makeMeasureSpec, a4);
            if (a5 > 0) {
                i5 = this.f5483h.getPaddingBottom() + this.f5483h.getPaddingTop() + i4;
            } else {
                i5 = 0;
            }
            i6 = a5 + i5;
        }
        if (this.f5480D.getInputMethodMode() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        c0463b.setWindowLayoutType(this.f5487m);
        if (c0463b.isShowing()) {
            View view = this.f5494t;
            WeakHashMap weakHashMap = I.T.f702a;
            if (view.isAttachedToWindow()) {
                int i13 = this.f5485j;
                if (i13 == -1) {
                    i13 = -1;
                } else if (i13 == -2) {
                    i13 = this.f5494t.getWidth();
                }
                if (i11 == -1) {
                    if (z3) {
                        i11 = i6;
                    } else {
                        i11 = -1;
                    }
                    if (z3) {
                        if (this.f5485j == -1) {
                            i8 = -1;
                        } else {
                            i8 = 0;
                        }
                        c0463b.setWidth(i8);
                        c0463b.setHeight(0);
                    } else {
                        if (this.f5485j == -1) {
                            i9 = -1;
                        }
                        c0463b.setWidth(i9);
                        c0463b.setHeight(-1);
                    }
                } else if (i11 == -2) {
                    i11 = i6;
                }
                c0463b.setOutsideTouchable(true);
                View view2 = this.f5494t;
                int i14 = i13;
                int i15 = this.k;
                int i16 = this.f5486l;
                if (i14 < 0) {
                    i7 = -1;
                } else {
                    i7 = i14;
                }
                if (i11 < 0) {
                    i11 = -1;
                }
                c0463b.update(view2, i15, i16, i7, i11);
                return;
            }
            return;
        }
        int i17 = this.f5485j;
        if (i17 == -1) {
            i17 = -1;
        } else if (i17 == -2) {
            i17 = this.f5494t.getWidth();
        }
        if (i11 == -1) {
            i11 = -1;
        } else if (i11 == -2) {
            i11 = i6;
        }
        c0463b.setWidth(i17);
        c0463b.setHeight(i11);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f5475E;
            if (method != null) {
                try {
                    method.invoke(c0463b, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            AbstractC0478I0.b(c0463b, true);
        }
        c0463b.setOutsideTouchable(true);
        c0463b.setTouchInterceptor(this.f5497w);
        if (this.f5490p) {
            c0463b.setOverlapAnchor(this.f5489o);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f5476F;
            if (method2 != null) {
                try {
                    method2.invoke(c0463b, this.f5478B);
                } catch (Exception e4) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e4);
                }
            }
        } else {
            AbstractC0478I0.a(c0463b, this.f5478B);
        }
        c0463b.showAsDropDown(this.f5494t, this.k, this.f5486l, this.f5491q);
        this.f5483h.setSelection(-1);
        if ((!this.f5479C || this.f5483h.isInTouchMode()) && (c0462a0 = this.f5483h) != null) {
            c0462a0.setListSelectionHidden(true);
            c0462a0.requestLayout();
        }
        if (!this.f5479C) {
            this.z.post(this.f5499y);
        }
    }

    public final Drawable d() {
        return this.f5480D.getBackground();
    }

    @Override // n.F
    public final void dismiss() {
        C0463B c0463b = this.f5480D;
        c0463b.dismiss();
        c0463b.setContentView(null);
        this.f5483h = null;
        this.z.removeCallbacks(this.f5496v);
    }

    @Override // n.F
    public final C0462A0 f() {
        return this.f5483h;
    }

    public final void h(Drawable drawable) {
        this.f5480D.setBackgroundDrawable(drawable);
    }

    public final void i(int i4) {
        this.f5486l = i4;
        this.f5488n = true;
    }

    public final void k(int i4) {
        this.k = i4;
    }

    public final int m() {
        if (!this.f5488n) {
            return 0;
        }
        return this.f5486l;
    }

    public void p(ListAdapter listAdapter) {
        M.b bVar = this.f5493s;
        if (bVar == null) {
            this.f5493s = new M.b(1, this);
        } else {
            ListAdapter listAdapter2 = this.f5482g;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.f5482g = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f5493s);
        }
        C0462A0 c0462a0 = this.f5483h;
        if (c0462a0 != null) {
            c0462a0.setAdapter(this.f5482g);
        }
    }

    public C0462A0 q(Context context, boolean z) {
        return new C0462A0(context, z);
    }

    public final void r(int i4) {
        Drawable background = this.f5480D.getBackground();
        if (background != null) {
            Rect rect = this.f5477A;
            background.getPadding(rect);
            this.f5485j = rect.left + rect.right + i4;
            return;
        }
        this.f5485j = i4;
    }
}
