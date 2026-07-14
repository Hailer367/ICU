package j;

import I.T;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import o.C0523j;
import o.s1;
import o.x1;

/* renamed from: j.K, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0403K extends AbstractC0406a {

    /* renamed from: a, reason: collision with root package name */
    public final x1 f4894a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f4895b;

    /* renamed from: c, reason: collision with root package name */
    public final C0402J f4896c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4897d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4898e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4899f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f4900g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final F.b f4901h = new F.b(14, this);

    public C0403K(Toolbar toolbar, CharSequence charSequence, v vVar) {
        C0402J c0402j = new C0402J(this);
        x1 x1Var = new x1(toolbar, false);
        this.f4894a = x1Var;
        vVar.getClass();
        this.f4895b = vVar;
        x1Var.k = vVar;
        toolbar.setOnMenuItemClickListener(c0402j);
        if (!x1Var.f5740g) {
            x1Var.f5741h = charSequence;
            if ((x1Var.f5735b & 8) != 0) {
                Toolbar toolbar2 = x1Var.f5734a;
                toolbar2.setTitle(charSequence);
                if (x1Var.f5740g) {
                    T.j(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.f4896c = new C0402J(this);
    }

    @Override // j.AbstractC0406a
    public final boolean a() {
        C0523j c0523j;
        ActionMenuView actionMenuView = this.f4894a.f5734a.f2474f;
        if (actionMenuView != null && (c0523j = actionMenuView.f2354y) != null && c0523j.c()) {
            return true;
        }
        return false;
    }

    @Override // j.AbstractC0406a
    public final boolean b() {
        n.q qVar;
        s1 s1Var = this.f4894a.f5734a.f2466R;
        if (s1Var != null && (qVar = s1Var.f5705g) != null) {
            if (s1Var == null) {
                qVar = null;
            }
            if (qVar != null) {
                qVar.collapseActionView();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // j.AbstractC0406a
    public final void c(boolean z) {
        if (z != this.f4899f) {
            this.f4899f = z;
            ArrayList arrayList = this.f4900g;
            if (arrayList.size() <= 0) {
            } else {
                throw A2.i.f(arrayList, 0);
            }
        }
    }

    @Override // j.AbstractC0406a
    public final int d() {
        return this.f4894a.f5735b;
    }

    @Override // j.AbstractC0406a
    public final Context e() {
        return this.f4894a.f5734a.getContext();
    }

    @Override // j.AbstractC0406a
    public final void f() {
        this.f4894a.f5734a.setVisibility(8);
    }

    @Override // j.AbstractC0406a
    public final boolean g() {
        x1 x1Var = this.f4894a;
        Toolbar toolbar = x1Var.f5734a;
        F.b bVar = this.f4901h;
        toolbar.removeCallbacks(bVar);
        Toolbar toolbar2 = x1Var.f5734a;
        WeakHashMap weakHashMap = T.f702a;
        toolbar2.postOnAnimation(bVar);
        return true;
    }

    @Override // j.AbstractC0406a
    public final boolean h() {
        if (this.f4894a.f5734a.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // j.AbstractC0406a
    public final void j() {
        this.f4894a.f5734a.removeCallbacks(this.f4901h);
    }

    @Override // j.AbstractC0406a
    public final boolean k(int i4, KeyEvent keyEvent) {
        Menu v3 = v();
        if (v3 == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() == 1) {
            z = false;
        }
        v3.setQwertyMode(z);
        return v3.performShortcut(i4, keyEvent, 0);
    }

    @Override // j.AbstractC0406a
    public final boolean l(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            m();
        }
        return true;
    }

    @Override // j.AbstractC0406a
    public final boolean m() {
        return this.f4894a.f5734a.u();
    }

    @Override // j.AbstractC0406a
    public final void n(ColorDrawable colorDrawable) {
        Toolbar toolbar = this.f4894a.f5734a;
        WeakHashMap weakHashMap = T.f702a;
        toolbar.setBackground(colorDrawable);
    }

    @Override // j.AbstractC0406a
    public final void p(boolean z) {
        int i4;
        if (z) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        x1 x1Var = this.f4894a;
        x1Var.a((i4 & 8) | (x1Var.f5735b & (-9)));
    }

    @Override // j.AbstractC0406a
    public final void r(CharSequence charSequence) {
        x1 x1Var = this.f4894a;
        x1Var.f5740g = true;
        Toolbar toolbar = x1Var.f5734a;
        x1Var.f5741h = charSequence;
        if ((x1Var.f5735b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (x1Var.f5740g) {
                T.j(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // j.AbstractC0406a
    public final void s(CharSequence charSequence) {
        x1 x1Var = this.f4894a;
        if (!x1Var.f5740g) {
            Toolbar toolbar = x1Var.f5734a;
            x1Var.f5741h = charSequence;
            if ((x1Var.f5735b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (x1Var.f5740g) {
                    T.j(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // j.AbstractC0406a
    public final void t() {
        this.f4894a.f5734a.setVisibility(0);
    }

    public final Menu v() {
        boolean z = this.f4898e;
        x1 x1Var = this.f4894a;
        if (!z) {
            Z0.D d4 = new Z0.D(this);
            R1.c cVar = new R1.c(29, this);
            Toolbar toolbar = x1Var.f5734a;
            toolbar.f2467S = d4;
            toolbar.f2468T = cVar;
            ActionMenuView actionMenuView = toolbar.f2474f;
            if (actionMenuView != null) {
                actionMenuView.z = d4;
                actionMenuView.f2344A = cVar;
            }
            this.f4898e = true;
        }
        return x1Var.f5734a.getMenu();
    }

    @Override // j.AbstractC0406a
    public final void i() {
    }

    @Override // j.AbstractC0406a
    public final void o(boolean z) {
    }

    @Override // j.AbstractC0406a
    public final void q(boolean z) {
    }
}
