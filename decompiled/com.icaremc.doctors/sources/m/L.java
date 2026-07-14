package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public final class L extends AbstractC0248A {
    public final int p;
    public final int q;

    /* renamed from: r, reason: collision with root package name */
    public K f3084r;

    /* renamed from: s, reason: collision with root package name */
    public l.k f3085s;

    public L(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.p = 21;
            this.q = 22;
        } else {
            this.p = 22;
            this.q = 21;
        }
    }

    @Override // m.AbstractC0248A, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        l.h hVar;
        int i2;
        l.k kVar;
        int pointToPosition;
        int i3;
        if (this.f3084r != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i2 = headerViewListAdapter.getHeadersCount();
                hVar = (l.h) headerViewListAdapter.getWrappedAdapter();
            } else {
                hVar = (l.h) adapter;
                i2 = 0;
            }
            if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < hVar.getCount()) {
                kVar = hVar.getItem(i3);
            } else {
                kVar = null;
            }
            l.k kVar2 = this.f3085s;
            if (kVar2 != kVar) {
                l.j jVar = hVar.f2834c;
                if (kVar2 != null) {
                    this.f3084r.d(jVar, kVar2);
                }
                this.f3085s = kVar;
                if (kVar != null) {
                    this.f3084r.b(jVar, kVar);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i2 == this.p) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView != null && i2 == this.q) {
            setSelection(-1);
            ((l.h) getAdapter()).f2834c.c(false);
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void setHoverListener(K k2) {
        this.f3084r = k2;
    }

    @Override // m.AbstractC0248A, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
