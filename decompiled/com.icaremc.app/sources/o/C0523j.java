package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.icaremc.app.R;
import java.util.ArrayList;
import n.InterfaceC0448A;
import n.InterfaceC0449B;
import n.InterfaceC0450C;

/* renamed from: o.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0523j implements InterfaceC0449B {

    /* renamed from: A, reason: collision with root package name */
    public C0517g f5599A;

    /* renamed from: f, reason: collision with root package name */
    public final Context f5601f;

    /* renamed from: g, reason: collision with root package name */
    public Context f5602g;

    /* renamed from: h, reason: collision with root package name */
    public n.n f5603h;

    /* renamed from: i, reason: collision with root package name */
    public final LayoutInflater f5604i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0448A f5605j;

    /* renamed from: m, reason: collision with root package name */
    public n.D f5607m;

    /* renamed from: n, reason: collision with root package name */
    public C0521i f5608n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f5609o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5610p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5611q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5612r;

    /* renamed from: s, reason: collision with root package name */
    public int f5613s;

    /* renamed from: t, reason: collision with root package name */
    public int f5614t;

    /* renamed from: u, reason: collision with root package name */
    public int f5615u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5616v;

    /* renamed from: x, reason: collision with root package name */
    public C0515f f5618x;

    /* renamed from: y, reason: collision with root package name */
    public C0515f f5619y;
    public RunnableC0519h z;
    public final int k = R.layout.abc_action_menu_layout;

    /* renamed from: l, reason: collision with root package name */
    public final int f5606l = R.layout.abc_action_menu_item_layout;

    /* renamed from: w, reason: collision with root package name */
    public final SparseBooleanArray f5617w = new SparseBooleanArray();

    /* renamed from: B, reason: collision with root package name */
    public final j.O f5600B = new j.O(3, this);

    public C0523j(Context context) {
        this.f5601f = context;
        this.f5604i = LayoutInflater.from(context);
    }

    @Override // n.InterfaceC0449B
    public final void a(n.n nVar, boolean z) {
        c();
        C0515f c0515f = this.f5619y;
        if (c0515f != null && c0515f.b()) {
            c0515f.f5369i.dismiss();
        }
        InterfaceC0448A interfaceC0448A = this.f5605j;
        if (interfaceC0448A != null) {
            interfaceC0448A.a(nVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [n.C] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View b(n.q qVar, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        View actionView = qVar.getActionView();
        int i4 = 0;
        if (actionView == null || qVar.e()) {
            if (view instanceof InterfaceC0450C) {
                actionMenuItemView = (InterfaceC0450C) view;
            } else {
                actionMenuItemView = (InterfaceC0450C) this.f5604i.inflate(this.f5606l, viewGroup, false);
            }
            actionMenuItemView.a(qVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f5607m);
            if (this.f5599A == null) {
                this.f5599A = new C0517g(this);
            }
            actionMenuItemView2.setPopupCallback(this.f5599A);
            actionView = actionMenuItemView;
        }
        if (qVar.f5325C) {
            i4 = 8;
        }
        actionView.setVisibility(i4);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C0527l)) {
            actionView.setLayoutParams(ActionMenuView.j(layoutParams));
        }
        return actionView;
    }

    public final boolean c() {
        Object obj;
        RunnableC0519h runnableC0519h = this.z;
        if (runnableC0519h != null && (obj = this.f5607m) != null) {
            ((View) obj).removeCallbacks(runnableC0519h);
            this.z = null;
            return true;
        }
        C0515f c0515f = this.f5618x;
        if (c0515f != null) {
            if (c0515f.b()) {
                c0515f.f5369i.dismiss();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.InterfaceC0449B
    public final void d() {
        int i4;
        n.q qVar;
        ViewGroup viewGroup = (ViewGroup) this.f5607m;
        ArrayList arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            n.n nVar = this.f5603h;
            if (nVar != null) {
                nVar.i();
                ArrayList l3 = this.f5603h.l();
                int size = l3.size();
                i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    n.q qVar2 = (n.q) l3.get(i5);
                    if ((qVar2.f5348x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i4);
                        if (childAt instanceof InterfaceC0450C) {
                            qVar = ((InterfaceC0450C) childAt).getItemData();
                        } else {
                            qVar = null;
                        }
                        View b4 = b(qVar2, childAt, viewGroup);
                        if (qVar2 != qVar) {
                            b4.setPressed(false);
                            b4.jumpDrawablesToCurrentState();
                        }
                        if (b4 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) b4.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(b4);
                            }
                            ((ViewGroup) this.f5607m).addView(b4, i4);
                        }
                        i4++;
                    }
                }
            } else {
                i4 = 0;
            }
            while (i4 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i4) == this.f5608n) {
                    i4++;
                } else {
                    viewGroup.removeViewAt(i4);
                }
            }
        }
        ((View) this.f5607m).requestLayout();
        n.n nVar2 = this.f5603h;
        if (nVar2 != null) {
            nVar2.i();
            ArrayList arrayList2 = nVar2.f5302i;
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                n.r rVar = ((n.q) arrayList2.get(i6)).f5323A;
            }
        }
        n.n nVar3 = this.f5603h;
        if (nVar3 != null) {
            nVar3.i();
            arrayList = nVar3.f5303j;
        }
        if (this.f5611q && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((n.q) arrayList.get(0)).f5325C;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.f5608n == null) {
                this.f5608n = new C0521i(this, this.f5601f);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f5608n.getParent();
            if (viewGroup3 != this.f5607m) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f5608n);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f5607m;
                C0521i c0521i = this.f5608n;
                actionMenuView.getClass();
                C0527l i7 = ActionMenuView.i();
                i7.f5636a = true;
                actionMenuView.addView(c0521i, i7);
            }
        } else {
            C0521i c0521i2 = this.f5608n;
            if (c0521i2 != null) {
                Object parent = c0521i2.getParent();
                Object obj = this.f5607m;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f5608n);
                }
            }
        }
        ((ActionMenuView) this.f5607m).setOverflowReserved(this.f5611q);
    }

    @Override // n.InterfaceC0449B
    public final boolean e(n.q qVar) {
        return false;
    }

    public final boolean f() {
        C0515f c0515f = this.f5618x;
        if (c0515f != null && c0515f.b()) {
            return true;
        }
        return false;
    }

    @Override // n.InterfaceC0449B
    public final void g(Context context, n.n nVar) {
        this.f5602g = context;
        LayoutInflater.from(context);
        this.f5603h = nVar;
        Resources resources = context.getResources();
        if (!this.f5612r) {
            this.f5611q = true;
        }
        int i4 = 2;
        this.f5613s = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i5 <= 600 && ((i5 <= 960 || i6 <= 720) && (i5 <= 720 || i6 <= 960))) {
            if (i5 < 500 && ((i5 <= 640 || i6 <= 480) && (i5 <= 480 || i6 <= 640))) {
                if (i5 >= 360) {
                    i4 = 3;
                }
            } else {
                i4 = 4;
            }
        } else {
            i4 = 5;
        }
        this.f5615u = i4;
        int i7 = this.f5613s;
        if (this.f5611q) {
            if (this.f5608n == null) {
                C0521i c0521i = new C0521i(this, this.f5601f);
                this.f5608n = c0521i;
                if (this.f5610p) {
                    c0521i.setImageDrawable(this.f5609o);
                    this.f5609o = null;
                    this.f5610p = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f5608n.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i7 -= this.f5608n.getMeasuredWidth();
        } else {
            this.f5608n = null;
        }
        this.f5614t = i7;
        float f4 = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.InterfaceC0449B
    public final boolean h(n.H h3) {
        boolean z;
        if (h3.hasVisibleItems()) {
            n.H h4 = h3;
            while (true) {
                n.n nVar = h4.f5229A;
                if (nVar == this.f5603h) {
                    break;
                }
                h4 = (n.H) nVar;
            }
            n.q qVar = h4.f5230B;
            ViewGroup viewGroup = (ViewGroup) this.f5607m;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i4);
                    if ((childAt instanceof InterfaceC0450C) && ((InterfaceC0450C) childAt).getItemData() == qVar) {
                        view = childAt;
                        break;
                    }
                    i4++;
                }
            }
            if (view != null) {
                h3.f5230B.getClass();
                int size = h3.f5299f.size();
                int i5 = 0;
                while (true) {
                    if (i5 < size) {
                        MenuItem item = h3.getItem(i5);
                        if (item.isVisible() && item.getIcon() != null) {
                            z = true;
                            break;
                        }
                        i5++;
                    } else {
                        z = false;
                        break;
                    }
                }
                C0515f c0515f = new C0515f(this, this.f5602g, h3, view);
                this.f5619y = c0515f;
                c0515f.f5367g = z;
                n.w wVar = c0515f.f5369i;
                if (wVar != null) {
                    wVar.o(z);
                }
                C0515f c0515f2 = this.f5619y;
                if (!c0515f2.b()) {
                    if (c0515f2.f5365e != null) {
                        c0515f2.d(0, 0, false, false);
                    } else {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                }
                InterfaceC0448A interfaceC0448A = this.f5605j;
                if (interfaceC0448A != null) {
                    interfaceC0448A.c(h3);
                }
                return true;
            }
        }
        return false;
    }

    @Override // n.InterfaceC0449B
    public final boolean i() {
        int i4;
        ArrayList arrayList;
        int i5;
        boolean z;
        boolean z3;
        boolean z4;
        boolean z5;
        C0523j c0523j = this;
        n.n nVar = c0523j.f5603h;
        if (nVar != null) {
            arrayList = nVar.l();
            i4 = arrayList.size();
        } else {
            i4 = 0;
            arrayList = null;
        }
        int i6 = c0523j.f5615u;
        int i7 = c0523j.f5614t;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0523j.f5607m;
        int i8 = 0;
        boolean z6 = false;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i5 = 2;
            z = true;
            if (i8 >= i4) {
                break;
            }
            n.q qVar = (n.q) arrayList.get(i8);
            int i11 = qVar.f5349y;
            if ((i11 & 2) == 2) {
                i9++;
            } else if ((i11 & 1) == 1) {
                i10++;
            } else {
                z6 = true;
            }
            if (c0523j.f5616v && qVar.f5325C) {
                i6 = 0;
            }
            i8++;
        }
        if (c0523j.f5611q && (z6 || i10 + i9 > i6)) {
            i6--;
        }
        int i12 = i6 - i9;
        SparseBooleanArray sparseBooleanArray = c0523j.f5617w;
        sparseBooleanArray.clear();
        int i13 = 0;
        int i14 = 0;
        while (i13 < i4) {
            n.q qVar2 = (n.q) arrayList.get(i13);
            int i15 = qVar2.f5349y;
            if ((i15 & 2) == i5) {
                z3 = z;
            } else {
                z3 = false;
            }
            int i16 = qVar2.f5327b;
            if (z3) {
                View b4 = c0523j.b(qVar2, null, viewGroup);
                b4.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = b4.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                if (i16 != 0) {
                    sparseBooleanArray.put(i16, z);
                }
                qVar2.f(z);
            } else if ((i15 & 1) == z) {
                boolean z7 = sparseBooleanArray.get(i16);
                if ((i12 > 0 || z7) && i7 > 0) {
                    z4 = z;
                } else {
                    z4 = false;
                }
                if (z4) {
                    View b5 = c0523j.b(qVar2, null, viewGroup);
                    b5.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = b5.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    if (i7 + i14 > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z4 &= z5;
                }
                if (z4 && i16 != 0) {
                    sparseBooleanArray.put(i16, true);
                } else if (z7) {
                    sparseBooleanArray.put(i16, false);
                    for (int i17 = 0; i17 < i13; i17++) {
                        n.q qVar3 = (n.q) arrayList.get(i17);
                        if (qVar3.f5327b == i16) {
                            if ((qVar3.f5348x & 32) == 32) {
                                i12++;
                            }
                            qVar3.f(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                qVar2.f(z4);
            } else {
                qVar2.f(false);
                i13++;
                i5 = 2;
                c0523j = this;
                z = true;
            }
            i13++;
            i5 = 2;
            c0523j = this;
            z = true;
        }
        return z;
    }

    @Override // n.InterfaceC0449B
    public final void j(InterfaceC0448A interfaceC0448A) {
        throw null;
    }

    @Override // n.InterfaceC0449B
    public final boolean k(n.q qVar) {
        return false;
    }

    public final boolean l() {
        n.n nVar;
        if (this.f5611q && !f() && (nVar = this.f5603h) != null && this.f5607m != null && this.z == null) {
            nVar.i();
            if (!nVar.f5303j.isEmpty()) {
                RunnableC0519h runnableC0519h = new RunnableC0519h(this, new C0515f(this, this.f5602g, this.f5603h, this.f5608n));
                this.z = runnableC0519h;
                ((View) this.f5607m).post(runnableC0519h);
                return true;
            }
            return false;
        }
        return false;
    }
}
