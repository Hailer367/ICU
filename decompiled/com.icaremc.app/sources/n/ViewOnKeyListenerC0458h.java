package n;

import I.T;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.icaremc.app.R;
import j.O;
import java.util.ArrayList;
import java.util.WeakHashMap;
import o.C0462A0;
import o.O0;
import o.S0;

/* renamed from: n.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0458h extends w implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: A, reason: collision with root package name */
    public boolean f5259A;

    /* renamed from: B, reason: collision with root package name */
    public InterfaceC0448A f5260B;

    /* renamed from: C, reason: collision with root package name */
    public ViewTreeObserver f5261C;

    /* renamed from: D, reason: collision with root package name */
    public PopupWindow.OnDismissListener f5262D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f5263E;

    /* renamed from: g, reason: collision with root package name */
    public final Context f5264g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5265h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5266i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5267j;
    public final Handler k;

    /* renamed from: n, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0454d f5270n;

    /* renamed from: o, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0455e f5271o;

    /* renamed from: s, reason: collision with root package name */
    public View f5275s;

    /* renamed from: t, reason: collision with root package name */
    public View f5276t;

    /* renamed from: u, reason: collision with root package name */
    public int f5277u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5278v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5279w;

    /* renamed from: x, reason: collision with root package name */
    public int f5280x;

    /* renamed from: y, reason: collision with root package name */
    public int f5281y;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f5268l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f5269m = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final O f5272p = new O(2, this);

    /* renamed from: q, reason: collision with root package name */
    public int f5273q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f5274r = 0;
    public boolean z = false;

    public ViewOnKeyListenerC0458h(Context context, View view, int i4, boolean z) {
        this.f5270n = new ViewTreeObserverOnGlobalLayoutListenerC0454d(r1, this);
        this.f5271o = new ViewOnAttachStateChangeListenerC0455e(this, r1);
        this.f5264g = context;
        this.f5275s = view;
        this.f5266i = i4;
        this.f5267j = z;
        WeakHashMap weakHashMap = T.f702a;
        this.f5277u = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f5265h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.k = new Handler();
    }

    @Override // n.InterfaceC0449B
    public final void a(n nVar, boolean z) {
        int i4;
        ArrayList arrayList = this.f5269m;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                if (nVar == ((C0457g) arrayList.get(i5)).f5257b) {
                    break;
                } else {
                    i5++;
                }
            } else {
                i5 = -1;
                break;
            }
        }
        if (i5 >= 0) {
            int i6 = i5 + 1;
            if (i6 < arrayList.size()) {
                ((C0457g) arrayList.get(i6)).f5257b.c(false);
            }
            C0457g c0457g = (C0457g) arrayList.remove(i5);
            n nVar2 = c0457g.f5257b;
            S0 s02 = c0457g.f5256a;
            nVar2.r(this);
            if (this.f5263E) {
                O0.b(s02.f5480D, null);
                s02.f5480D.setAnimationStyle(0);
            }
            s02.dismiss();
            int size2 = arrayList.size();
            if (size2 > 0) {
                this.f5277u = ((C0457g) arrayList.get(size2 - 1)).f5258c;
            } else {
                View view = this.f5275s;
                WeakHashMap weakHashMap = T.f702a;
                if (view.getLayoutDirection() == 1) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                this.f5277u = i4;
            }
            if (size2 == 0) {
                dismiss();
                InterfaceC0448A interfaceC0448A = this.f5260B;
                if (interfaceC0448A != null) {
                    interfaceC0448A.a(nVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f5261C;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f5261C.removeGlobalOnLayoutListener(this.f5270n);
                    }
                    this.f5261C = null;
                }
                this.f5276t.removeOnAttachStateChangeListener(this.f5271o);
                this.f5262D.onDismiss();
                return;
            }
            if (z) {
                ((C0457g) arrayList.get(0)).f5257b.c(false);
            }
        }
    }

    @Override // n.F
    public final boolean b() {
        ArrayList arrayList = this.f5269m;
        if (arrayList.size() <= 0 || !((C0457g) arrayList.get(0)).f5256a.f5480D.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // n.F
    public final void c() {
        if (!b()) {
            ArrayList arrayList = this.f5268l;
            int size = arrayList.size();
            boolean z = false;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                u((n) obj);
            }
            arrayList.clear();
            View view = this.f5275s;
            this.f5276t = view;
            if (view != null) {
                if (this.f5261C == null) {
                    z = true;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f5261C = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f5270n);
                }
                this.f5276t.addOnAttachStateChangeListener(this.f5271o);
            }
        }
    }

    @Override // n.InterfaceC0449B
    public final void d() {
        ArrayList arrayList = this.f5269m;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ListAdapter adapter = ((C0457g) obj).f5256a.f5483h.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((k) adapter).notifyDataSetChanged();
        }
    }

    @Override // n.F
    public final void dismiss() {
        ArrayList arrayList = this.f5269m;
        int size = arrayList.size();
        if (size > 0) {
            C0457g[] c0457gArr = (C0457g[]) arrayList.toArray(new C0457g[size]);
            for (int i4 = size - 1; i4 >= 0; i4--) {
                C0457g c0457g = c0457gArr[i4];
                if (c0457g.f5256a.f5480D.isShowing()) {
                    c0457g.f5256a.dismiss();
                }
            }
        }
    }

    @Override // n.F
    public final C0462A0 f() {
        ArrayList arrayList = this.f5269m;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C0457g) arrayList.get(arrayList.size() - 1)).f5256a.f5483h;
    }

    @Override // n.InterfaceC0449B
    public final boolean h(H h3) {
        ArrayList arrayList = this.f5269m;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            C0457g c0457g = (C0457g) obj;
            if (h3 == c0457g.f5257b) {
                c0457g.f5256a.f5483h.requestFocus();
                return true;
            }
        }
        if (!h3.hasVisibleItems()) {
            return false;
        }
        l(h3);
        InterfaceC0448A interfaceC0448A = this.f5260B;
        if (interfaceC0448A != null) {
            interfaceC0448A.c(h3);
        }
        return true;
    }

    @Override // n.InterfaceC0449B
    public final boolean i() {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final void j(InterfaceC0448A interfaceC0448A) {
        this.f5260B = interfaceC0448A;
    }

    @Override // n.w
    public final void l(n nVar) {
        nVar.b(this, this.f5264g);
        if (b()) {
            u(nVar);
        } else {
            this.f5268l.add(nVar);
        }
    }

    @Override // n.w
    public final void n(View view) {
        if (this.f5275s != view) {
            this.f5275s = view;
            int i4 = this.f5273q;
            WeakHashMap weakHashMap = T.f702a;
            this.f5274r = Gravity.getAbsoluteGravity(i4, view.getLayoutDirection());
        }
    }

    @Override // n.w
    public final void o(boolean z) {
        this.z = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C0457g c0457g;
        ArrayList arrayList = this.f5269m;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                c0457g = (C0457g) arrayList.get(i4);
                if (!c0457g.f5256a.f5480D.isShowing()) {
                    break;
                } else {
                    i4++;
                }
            } else {
                c0457g = null;
                break;
            }
        }
        if (c0457g != null) {
            c0457g.f5257b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i4 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // n.w
    public final void p(int i4) {
        if (this.f5273q != i4) {
            this.f5273q = i4;
            View view = this.f5275s;
            WeakHashMap weakHashMap = T.f702a;
            this.f5274r = Gravity.getAbsoluteGravity(i4, view.getLayoutDirection());
        }
    }

    @Override // n.w
    public final void q(int i4) {
        this.f5278v = true;
        this.f5280x = i4;
    }

    @Override // n.w
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f5262D = onDismissListener;
    }

    @Override // n.w
    public final void s(boolean z) {
        this.f5259A = z;
    }

    @Override // n.w
    public final void t(int i4) {
        this.f5279w = true;
        this.f5281y = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0161, code lost:
    
        if (((r9.getWidth() + r11[0]) + r5) > r10.right) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0163, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0166, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016b, code lost:
    
        if ((r11[0] - r5) < 0) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d5  */
    /* JADX WARN: Type inference failed for: r8v3, types: [o.M0, o.S0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(n.n r18) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.ViewOnKeyListenerC0458h.u(n.n):void");
    }
}
