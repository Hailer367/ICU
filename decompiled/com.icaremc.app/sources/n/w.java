package n;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public abstract class w implements F, InterfaceC0449B, AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    public Rect f5359f;

    public static int m(ListAdapter listAdapter, Context context, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i5 = 0;
        int i6 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i7 = 0; i7 < count; i7++) {
            int itemViewType = listAdapter.getItemViewType(i7);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i7, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i4) {
                return i4;
            }
            if (measuredWidth > i5) {
                i5 = measuredWidth;
            }
        }
        return i5;
    }

    @Override // n.InterfaceC0449B
    public final boolean e(q qVar) {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final boolean k(q qVar) {
        return false;
    }

    public abstract void l(n nVar);

    public abstract void n(View view);

    public abstract void o(boolean z);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        k kVar;
        int i5;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            kVar = (k) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            kVar = (k) listAdapter;
        }
        n nVar = kVar.f5289f;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i4);
        if (!(this instanceof ViewOnKeyListenerC0458h)) {
            i5 = 0;
        } else {
            i5 = 4;
        }
        nVar.q(menuItem, this, i5);
    }

    public abstract void p(int i4);

    public abstract void q(int i4);

    public abstract void r(PopupWindow.OnDismissListener onDismissListener);

    public abstract void s(boolean z);

    public abstract void t(int i4);

    @Override // n.InterfaceC0449B
    public final void g(Context context, n nVar) {
    }
}
