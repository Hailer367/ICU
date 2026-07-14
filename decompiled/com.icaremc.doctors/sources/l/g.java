package l;

import E.J;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.icaremc.doctors.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m.M;

/* loaded from: classes.dex */
public final class g extends l implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: A, reason: collision with root package name */
    public PopupWindow.OnDismissListener f2813A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2814B;

    /* renamed from: d, reason: collision with root package name */
    public final Context f2815d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2816e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2817f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2818g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f2819h;

    /* renamed from: k, reason: collision with root package name */
    public final c f2822k;

    /* renamed from: l, reason: collision with root package name */
    public final d f2823l;
    public View p;
    public View q;

    /* renamed from: r, reason: collision with root package name */
    public int f2827r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2828s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2829t;

    /* renamed from: u, reason: collision with root package name */
    public int f2830u;

    /* renamed from: v, reason: collision with root package name */
    public int f2831v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2833x;
    public o y;
    public ViewTreeObserver z;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f2820i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2821j = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final F.h f2824m = new F.h(12, this);

    /* renamed from: n, reason: collision with root package name */
    public int f2825n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f2826o = 0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2832w = false;

    public g(Context context, View view, int i2, boolean z) {
        this.f2822k = new c(this, r1);
        this.f2823l = new d(this, r1);
        this.f2815d = context;
        this.p = view;
        this.f2817f = i2;
        this.f2818g = z;
        Field field = J.f180a;
        this.f2827r = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f2816e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2819h = new Handler();
    }

    @Override // l.p
    public final void a(j jVar, boolean z) {
        int i2;
        ArrayList arrayList = this.f2821j;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (jVar == ((f) arrayList.get(i3)).f2811b) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < arrayList.size()) {
                ((f) arrayList.get(i4)).f2811b.c(false);
            }
            f fVar = (f) arrayList.remove(i3);
            j jVar2 = fVar.f2811b;
            M m2 = fVar.f2810a;
            CopyOnWriteArrayList copyOnWriteArrayList = jVar2.f2856r;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                p pVar = (p) weakReference.get();
                if (pVar == null || pVar == this) {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            if (this.f2814B) {
                m2.f3083x.setExitTransition(null);
                m2.f3083x.setAnimationStyle(0);
            }
            m2.dismiss();
            int size2 = arrayList.size();
            if (size2 > 0) {
                this.f2827r = ((f) arrayList.get(size2 - 1)).f2812c;
            } else {
                View view = this.p;
                Field field = J.f180a;
                if (view.getLayoutDirection() == 1) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                this.f2827r = i2;
            }
            if (size2 == 0) {
                dismiss();
                o oVar = this.y;
                if (oVar != null) {
                    oVar.a(jVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.z.removeGlobalOnLayoutListener(this.f2822k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.f2823l);
                this.f2813A.onDismiss();
                return;
            }
            if (z) {
                ((f) arrayList.get(0)).f2811b.c(false);
            }
        }
    }

    @Override // l.p
    public final void b() {
        ArrayList arrayList = this.f2821j;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ListAdapter adapter = ((f) obj).f2810a.f3066e.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((h) adapter).notifyDataSetChanged();
        }
    }

    @Override // l.r
    public final ListView c() {
        ArrayList arrayList = this.f2821j;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((f) arrayList.get(arrayList.size() - 1)).f2810a.f3066e;
    }

    @Override // l.p
    public final void d(o oVar) {
        this.y = oVar;
    }

    @Override // l.r
    public final void dismiss() {
        ArrayList arrayList = this.f2821j;
        int size = arrayList.size();
        if (size > 0) {
            f[] fVarArr = (f[]) arrayList.toArray(new f[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                f fVar = fVarArr[i2];
                if (fVar.f2810a.f3083x.isShowing()) {
                    fVar.f2810a.dismiss();
                }
            }
        }
    }

    @Override // l.p
    public final boolean g() {
        return false;
    }

    @Override // l.p
    public final boolean h(t tVar) {
        ArrayList arrayList = this.f2821j;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            f fVar = (f) obj;
            if (tVar == fVar.f2811b) {
                fVar.f2810a.f3066e.requestFocus();
                return true;
            }
        }
        if (!tVar.hasVisibleItems()) {
            return false;
        }
        k(tVar);
        o oVar = this.y;
        if (oVar != null) {
            oVar.c(tVar);
        }
        return true;
    }

    @Override // l.r
    public final boolean i() {
        ArrayList arrayList = this.f2821j;
        if (arrayList.size() <= 0 || !((f) arrayList.get(0)).f2810a.f3083x.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // l.l
    public final void k(j jVar) {
        jVar.b(this, this.f2815d);
        if (i()) {
            t(jVar);
        } else {
            this.f2820i.add(jVar);
        }
    }

    @Override // l.l
    public final void m(View view) {
        if (this.p != view) {
            this.p = view;
            int i2 = this.f2825n;
            Field field = J.f180a;
            this.f2826o = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    @Override // l.l
    public final void n(boolean z) {
        this.f2832w = z;
    }

    @Override // l.l
    public final void o(int i2) {
        if (this.f2825n != i2) {
            this.f2825n = i2;
            View view = this.p;
            Field field = J.f180a;
            this.f2826o = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        f fVar;
        ArrayList arrayList = this.f2821j;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                fVar = (f) arrayList.get(i2);
                if (!fVar.f2810a.f3083x.isShowing()) {
                    break;
                } else {
                    i2++;
                }
            } else {
                fVar = null;
                break;
            }
        }
        if (fVar != null) {
            fVar.f2811b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i2 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // l.l
    public final void p(int i2) {
        this.f2828s = true;
        this.f2830u = i2;
    }

    @Override // l.l
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.f2813A = onDismissListener;
    }

    @Override // l.l
    public final void r(boolean z) {
        this.f2833x = z;
    }

    @Override // l.l
    public final void s(int i2) {
        this.f2829t = true;
        this.f2831v = i2;
    }

    @Override // l.r
    public final void show() {
        if (!i()) {
            ArrayList arrayList = this.f2820i;
            int size = arrayList.size();
            boolean z = false;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                t((j) obj);
            }
            arrayList.clear();
            View view = this.p;
            this.q = view;
            if (view != null) {
                if (this.z == null) {
                    z = true;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.z = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f2822k);
                }
                this.q.addOnAttachStateChangeListener(this.f2823l);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x017b, code lost:
    
        if (((r7.getWidth() + r11[r16]) + r5) > r9.right) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x017d, code lost:
    
        r7 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0181, code lost:
    
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0186, code lost:
    
        if ((r11[r16] - r5) < 0) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [m.J, m.M] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(l.j r19) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.g.t(l.j):void");
    }
}
