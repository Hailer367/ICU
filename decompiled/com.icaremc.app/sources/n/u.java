package n;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class u implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f5355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f5356b;

    public u(v vVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5356b = vVar;
        this.f5355a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f5355a.onMenuItemClick(this.f5356b.f(menuItem));
    }
}
