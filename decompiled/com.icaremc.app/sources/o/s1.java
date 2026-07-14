package o;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import m.InterfaceC0439c;
import n.InterfaceC0449B;

/* loaded from: classes.dex */
public final class s1 implements InterfaceC0449B {

    /* renamed from: f, reason: collision with root package name */
    public n.n f5704f;

    /* renamed from: g, reason: collision with root package name */
    public n.q f5705g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Toolbar f5706h;

    public s1(Toolbar toolbar) {
        this.f5706h = toolbar;
    }

    @Override // n.InterfaceC0449B
    public final void d() {
        if (this.f5705g != null) {
            n.n nVar = this.f5704f;
            if (nVar != null) {
                int size = nVar.f5299f.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.f5704f.getItem(i4) == this.f5705g) {
                        return;
                    }
                }
            }
            k(this.f5705g);
        }
    }

    @Override // n.InterfaceC0449B
    public final boolean e(n.q qVar) {
        Toolbar toolbar = this.f5706h;
        toolbar.c();
        ViewParent parent = toolbar.f2480m.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f2480m);
            }
            toolbar.addView(toolbar.f2480m);
        }
        View actionView = qVar.getActionView();
        toolbar.f2481n = actionView;
        this.f5705g = qVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f2481n);
            }
            t1 h3 = Toolbar.h();
            h3.f5710a = (toolbar.f2486s & 112) | 8388611;
            h3.f5711b = 2;
            toolbar.f2481n.setLayoutParams(h3);
            toolbar.addView(toolbar.f2481n);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((t1) childAt.getLayoutParams()).f5711b != 2 && childAt != toolbar.f2474f) {
                toolbar.removeViewAt(childCount);
                toolbar.f2459J.add(childAt);
            }
        }
        toolbar.requestLayout();
        qVar.f5325C = true;
        qVar.f5338n.p(false);
        KeyEvent.Callback callback = toolbar.f2481n;
        if (callback instanceof InterfaceC0439c) {
            ((InterfaceC0439c) callback).onActionViewExpanded();
        }
        toolbar.v();
        return true;
    }

    @Override // n.InterfaceC0449B
    public final void g(Context context, n.n nVar) {
        n.q qVar;
        n.n nVar2 = this.f5704f;
        if (nVar2 != null && (qVar = this.f5705g) != null) {
            nVar2.d(qVar);
        }
        this.f5704f = nVar;
    }

    @Override // n.InterfaceC0449B
    public final boolean h(n.H h3) {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final boolean i() {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final boolean k(n.q qVar) {
        Toolbar toolbar = this.f5706h;
        KeyEvent.Callback callback = toolbar.f2481n;
        if (callback instanceof InterfaceC0439c) {
            ((InterfaceC0439c) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f2481n);
        toolbar.removeView(toolbar.f2480m);
        toolbar.f2481n = null;
        ArrayList arrayList = toolbar.f2459J;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f5705g = null;
        toolbar.requestLayout();
        qVar.f5325C = false;
        qVar.f5338n.p(false);
        toolbar.v();
        return true;
    }

    @Override // n.InterfaceC0449B
    public final void a(n.n nVar, boolean z) {
    }
}
