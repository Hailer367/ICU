package m;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.icaremc.doctors.R;
import java.util.ArrayList;

/* renamed from: m.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0261h implements l.p {

    /* renamed from: c, reason: collision with root package name */
    public final Context f3151c;

    /* renamed from: d, reason: collision with root package name */
    public Context f3152d;

    /* renamed from: e, reason: collision with root package name */
    public l.j f3153e;

    /* renamed from: f, reason: collision with root package name */
    public final LayoutInflater f3154f;

    /* renamed from: g, reason: collision with root package name */
    public l.o f3155g;

    /* renamed from: i, reason: collision with root package name */
    public ActionMenuView f3157i;

    /* renamed from: j, reason: collision with root package name */
    public C0260g f3158j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f3159k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3160l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3161m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3162n;

    /* renamed from: o, reason: collision with root package name */
    public int f3163o;
    public int p;
    public int q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3164r;

    /* renamed from: t, reason: collision with root package name */
    public C0258e f3166t;

    /* renamed from: u, reason: collision with root package name */
    public C0258e f3167u;

    /* renamed from: v, reason: collision with root package name */
    public B.a f3168v;

    /* renamed from: w, reason: collision with root package name */
    public C0259f f3169w;

    /* renamed from: h, reason: collision with root package name */
    public final int f3156h = R.layout.abc_action_menu_item_layout;

    /* renamed from: s, reason: collision with root package name */
    public final SparseBooleanArray f3165s = new SparseBooleanArray();

    /* renamed from: x, reason: collision with root package name */
    public final F.h f3170x = new F.h(13, this);

    public C0261h(Context context) {
        this.f3151c = context;
        this.f3154f = LayoutInflater.from(context);
    }

    @Override // l.p
    public final void a(l.j jVar, boolean z) {
        i();
        C0258e c0258e = this.f3167u;
        if (c0258e != null && c0258e.b()) {
            c0258e.f2893i.dismiss();
        }
        l.o oVar = this.f3155g;
        if (oVar != null) {
            oVar.a(jVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.p
    public final void b() {
        int i2;
        l.k kVar;
        ActionMenuView actionMenuView = this.f3157i;
        ArrayList arrayList = null;
        boolean z = false;
        if (actionMenuView != null) {
            l.j jVar = this.f3153e;
            if (jVar != null) {
                jVar.i();
                ArrayList k2 = this.f3153e.k();
                int size = k2.size();
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    l.k kVar2 = (l.k) k2.get(i3);
                    if ((kVar2.f2882x & 32) == 32) {
                        View childAt = actionMenuView.getChildAt(i2);
                        if (childAt instanceof l.q) {
                            kVar = ((l.q) childAt).getItemData();
                        } else {
                            kVar = null;
                        }
                        View c2 = c(kVar2, childAt, actionMenuView);
                        if (kVar2 != kVar) {
                            c2.setPressed(false);
                            c2.jumpDrawablesToCurrentState();
                        }
                        if (c2 != childAt) {
                            ViewGroup viewGroup = (ViewGroup) c2.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(c2);
                            }
                            this.f3157i.addView(c2, i2);
                        }
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            while (i2 < actionMenuView.getChildCount()) {
                if (actionMenuView.getChildAt(i2) == this.f3158j) {
                    i2++;
                } else {
                    actionMenuView.removeViewAt(i2);
                }
            }
        }
        this.f3157i.requestLayout();
        l.j jVar2 = this.f3153e;
        if (jVar2 != null) {
            jVar2.i();
            ArrayList arrayList2 = jVar2.f2849i;
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((l.k) arrayList2.get(i4)).getClass();
            }
        }
        l.j jVar3 = this.f3153e;
        if (jVar3 != null) {
            jVar3.i();
            arrayList = jVar3.f2850j;
        }
        if (this.f3161m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((l.k) arrayList.get(0)).f2860B;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.f3158j == null) {
                this.f3158j = new C0260g(this, this.f3151c);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f3158j.getParent();
            if (viewGroup2 != this.f3157i) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f3158j);
                }
                ActionMenuView actionMenuView2 = this.f3157i;
                C0260g c0260g = this.f3158j;
                actionMenuView2.getClass();
                C0263j h2 = ActionMenuView.h();
                h2.f3175c = true;
                actionMenuView2.addView(c0260g, h2);
            }
        } else {
            C0260g c0260g2 = this.f3158j;
            if (c0260g2 != null) {
                ViewParent parent = c0260g2.getParent();
                ActionMenuView actionMenuView3 = this.f3157i;
                if (parent == actionMenuView3) {
                    actionMenuView3.removeView(this.f3158j);
                }
            }
        }
        this.f3157i.setOverflowReserved(this.f3161m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v4, types: [l.q] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public final View c(l.k kVar, View view, ActionMenuView actionMenuView) {
        View view2;
        ActionMenuItemView actionMenuItemView;
        View view3 = kVar.z;
        if (view3 != null) {
            view2 = view3;
        } else {
            view2 = null;
        }
        int i2 = 8;
        if (view2 == null || ((kVar.y & 8) != 0 && view3 != null)) {
            if (view instanceof l.q) {
                actionMenuItemView = (l.q) view;
            } else {
                actionMenuItemView = (l.q) this.f3154f.inflate(this.f3156h, (ViewGroup) actionMenuView, false);
            }
            actionMenuItemView.b(kVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker(this.f3157i);
            if (this.f3169w == null) {
                this.f3169w = new C0259f(this);
            }
            actionMenuItemView2.setPopupCallback(this.f3169w);
            view2 = actionMenuItemView;
        }
        if (!kVar.f2860B) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        actionMenuView.getClass();
        if (!(layoutParams instanceof C0263j)) {
            view2.setLayoutParams(ActionMenuView.i(layoutParams));
        }
        return view2;
    }

    @Override // l.p
    public final void d(l.o oVar) {
        throw null;
    }

    @Override // l.p
    public final boolean e(l.k kVar) {
        return false;
    }

    @Override // l.p
    public final void f(Context context, l.j jVar) {
        this.f3152d = context;
        LayoutInflater.from(context);
        this.f3153e = jVar;
        Resources resources = context.getResources();
        if (!this.f3162n) {
            this.f3161m = true;
        }
        int i2 = 2;
        this.f3163o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i3 <= 600 && ((i3 <= 960 || i4 <= 720) && (i3 <= 720 || i4 <= 960))) {
            if (i3 < 500 && ((i3 <= 640 || i4 <= 480) && (i3 <= 480 || i4 <= 640))) {
                if (i3 >= 360) {
                    i2 = 3;
                }
            } else {
                i2 = 4;
            }
        } else {
            i2 = 5;
        }
        this.q = i2;
        int i5 = this.f3163o;
        if (this.f3161m) {
            if (this.f3158j == null) {
                C0260g c0260g = new C0260g(this, this.f3151c);
                this.f3158j = c0260g;
                if (this.f3160l) {
                    c0260g.setImageDrawable(this.f3159k);
                    this.f3159k = null;
                    this.f3160l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f3158j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.f3158j.getMeasuredWidth();
        } else {
            this.f3158j = null;
        }
        this.p = i5;
        float f2 = resources.getDisplayMetrics().density;
    }

    @Override // l.p
    public final boolean g() {
        int i2;
        ArrayList arrayList;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        C0261h c0261h = this;
        l.j jVar = c0261h.f3153e;
        if (jVar != null) {
            arrayList = jVar.k();
            i2 = arrayList.size();
        } else {
            i2 = 0;
            arrayList = null;
        }
        int i4 = c0261h.q;
        int i5 = c0261h.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ActionMenuView actionMenuView = c0261h.f3157i;
        int i6 = 0;
        boolean z5 = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = 2;
            z = true;
            if (i6 >= i2) {
                break;
            }
            l.k kVar = (l.k) arrayList.get(i6);
            int i9 = kVar.y;
            if ((i9 & 2) == 2) {
                i7++;
            } else if ((i9 & 1) == 1) {
                i8++;
            } else {
                z5 = true;
            }
            if (c0261h.f3164r && kVar.f2860B) {
                i4 = 0;
            }
            i6++;
        }
        if (c0261h.f3161m && (z5 || i8 + i7 > i4)) {
            i4--;
        }
        int i10 = i4 - i7;
        SparseBooleanArray sparseBooleanArray = c0261h.f3165s;
        sparseBooleanArray.clear();
        int i11 = 0;
        int i12 = 0;
        while (i11 < i2) {
            l.k kVar2 = (l.k) arrayList.get(i11);
            int i13 = kVar2.y;
            if ((i13 & 2) == i3) {
                z2 = z;
            } else {
                z2 = false;
            }
            int i14 = kVar2.f2862b;
            if (z2) {
                View c2 = c0261h.c(kVar2, null, actionMenuView);
                c2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = c2.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                if (i14 != 0) {
                    sparseBooleanArray.put(i14, z);
                }
                kVar2.d(z);
            } else if ((i13 & 1) == z) {
                boolean z6 = sparseBooleanArray.get(i14);
                if ((i10 > 0 || z6) && i5 > 0) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (z3) {
                    View c3 = c0261h.c(kVar2, null, actionMenuView);
                    c3.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = c3.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    if (i5 + i12 > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z3 &= z4;
                }
                if (z3 && i14 != 0) {
                    sparseBooleanArray.put(i14, true);
                } else if (z6) {
                    sparseBooleanArray.put(i14, false);
                    for (int i15 = 0; i15 < i11; i15++) {
                        l.k kVar3 = (l.k) arrayList.get(i15);
                        if (kVar3.f2862b == i14) {
                            if ((kVar3.f2882x & 32) == 32) {
                                i10++;
                            }
                            kVar3.d(false);
                        }
                    }
                }
                if (z3) {
                    i10--;
                }
                kVar2.d(z3);
            } else {
                kVar2.d(false);
                i11++;
                i3 = 2;
                c0261h = this;
                z = true;
            }
            i11++;
            i3 = 2;
            c0261h = this;
            z = true;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.p
    public final boolean h(l.t tVar) {
        boolean z;
        if (tVar.hasVisibleItems()) {
            l.t tVar2 = tVar;
            while (true) {
                l.j jVar = tVar2.f2913v;
                if (jVar == this.f3153e) {
                    break;
                }
                tVar2 = (l.t) jVar;
            }
            l.k kVar = tVar2.f2914w;
            ActionMenuView actionMenuView = this.f3157i;
            View view = null;
            if (actionMenuView != null) {
                int childCount = actionMenuView.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = actionMenuView.getChildAt(i2);
                    if ((childAt instanceof l.q) && ((l.q) childAt).getItemData() == kVar) {
                        view = childAt;
                        break;
                    }
                    i2++;
                }
            }
            if (view != null) {
                tVar.f2914w.getClass();
                int size = tVar.f2846f.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        MenuItem item = tVar.getItem(i3);
                        if (item.isVisible() && item.getIcon() != null) {
                            z = true;
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                C0258e c0258e = new C0258e(this, this.f3152d, tVar, view);
                this.f3167u = c0258e;
                c0258e.f2891g = z;
                l.l lVar = c0258e.f2893i;
                if (lVar != null) {
                    lVar.n(z);
                }
                C0258e c0258e2 = this.f3167u;
                if (!c0258e2.b()) {
                    if (c0258e2.f2889e != null) {
                        c0258e2.d(0, 0, false, false);
                    } else {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                }
                l.o oVar = this.f3155g;
                if (oVar != null) {
                    oVar.c(tVar);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        ActionMenuView actionMenuView;
        B.a aVar = this.f3168v;
        if (aVar != null && (actionMenuView = this.f3157i) != null) {
            actionMenuView.removeCallbacks(aVar);
            this.f3168v = null;
            return true;
        }
        C0258e c0258e = this.f3166t;
        if (c0258e != null) {
            if (c0258e.b()) {
                c0258e.f2893i.dismiss();
            }
            return true;
        }
        return false;
    }

    @Override // l.p
    public final boolean j(l.k kVar) {
        return false;
    }

    public final boolean k() {
        l.j jVar;
        if (this.f3161m) {
            C0258e c0258e = this.f3166t;
            if ((c0258e == null || !c0258e.b()) && (jVar = this.f3153e) != null && this.f3157i != null && this.f3168v == null) {
                jVar.i();
                if (!jVar.f2850j.isEmpty()) {
                    B.a aVar = new B.a(this, new C0258e(this, this.f3152d, this.f3153e, this.f3158j), 2, false);
                    this.f3168v = aVar;
                    this.f3157i.post(aVar);
                    l.o oVar = this.f3155g;
                    if (oVar != null) {
                        oVar.c(null);
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
