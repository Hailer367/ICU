package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public final class R0 extends C0462A0 {

    /* renamed from: r, reason: collision with root package name */
    public final int f5511r;

    /* renamed from: s, reason: collision with root package name */
    public final int f5512s;

    /* renamed from: t, reason: collision with root package name */
    public InterfaceC0488N0 f5513t;

    /* renamed from: u, reason: collision with root package name */
    public n.q f5514u;

    public R0(Context context, boolean z) {
        super(context, z);
        if (1 == Q0.a(context.getResources().getConfiguration())) {
            this.f5511r = 21;
            this.f5512s = 22;
        } else {
            this.f5511r = 22;
            this.f5512s = 21;
        }
    }

    @Override // o.C0462A0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        n.k kVar;
        int i4;
        n.q qVar;
        int pointToPosition;
        int i5;
        if (this.f5513t != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i4 = headerViewListAdapter.getHeadersCount();
                kVar = (n.k) headerViewListAdapter.getWrappedAdapter();
            } else {
                kVar = (n.k) adapter;
                i4 = 0;
            }
            if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i5 = pointToPosition - i4) >= 0 && i5 < kVar.getCount()) {
                qVar = kVar.getItem(i5);
            } else {
                qVar = null;
            }
            n.q qVar2 = this.f5514u;
            if (qVar2 != qVar) {
                n.n nVar = kVar.f5289f;
                if (qVar2 != null) {
                    this.f5513t.e(nVar, qVar2);
                }
                this.f5514u = qVar;
                if (qVar != null) {
                    this.f5513t.o(nVar, qVar);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        n.k kVar;
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i4 == this.f5511r) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView != null && i4 == this.f5512s) {
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                kVar = (n.k) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            } else {
                kVar = (n.k) adapter;
            }
            kVar.f5289f.c(false);
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    public void setHoverListener(InterfaceC0488N0 interfaceC0488N0) {
        this.f5513t = interfaceC0488N0;
    }

    @Override // o.C0462A0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
