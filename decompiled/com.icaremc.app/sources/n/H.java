package n;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public final class H extends n implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    public final n f5229A;

    /* renamed from: B, reason: collision with root package name */
    public final q f5230B;

    public H(Context context, n nVar, q qVar) {
        super(context);
        this.f5229A = nVar;
        this.f5230B = qVar;
    }

    @Override // n.n
    public final boolean d(q qVar) {
        return this.f5229A.d(qVar);
    }

    @Override // n.n
    public final boolean e(n nVar, MenuItem menuItem) {
        if (!super.e(nVar, menuItem) && !this.f5229A.e(nVar, menuItem)) {
            return false;
        }
        return true;
    }

    @Override // n.n
    public final boolean f(q qVar) {
        return this.f5229A.f(qVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f5230B;
    }

    @Override // n.n
    public final String j() {
        int i4;
        q qVar = this.f5230B;
        if (qVar != null) {
            i4 = qVar.f5326a;
        } else {
            i4 = 0;
        }
        if (i4 == 0) {
            return null;
        }
        return A2.i.g(i4, "android:menu:actionviewstates:");
    }

    @Override // n.n
    public final n k() {
        return this.f5229A.k();
    }

    @Override // n.n
    public final boolean m() {
        return this.f5229A.m();
    }

    @Override // n.n
    public final boolean n() {
        return this.f5229A.n();
    }

    @Override // n.n
    public final boolean o() {
        return this.f5229A.o();
    }

    @Override // n.n, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.f5229A.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f5230B.setIcon(drawable);
        return this;
    }

    @Override // n.n, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f5229A.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i4) {
        u(0, null, i4, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i4) {
        u(i4, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i4) {
        this.f5230B.setIcon(i4);
        return this;
    }
}
