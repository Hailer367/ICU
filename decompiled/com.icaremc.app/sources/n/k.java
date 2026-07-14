package n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    public final n f5289f;

    /* renamed from: g, reason: collision with root package name */
    public int f5290g = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5291h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5292i;

    /* renamed from: j, reason: collision with root package name */
    public final LayoutInflater f5293j;
    public final int k;

    public k(n nVar, LayoutInflater layoutInflater, boolean z, int i4) {
        this.f5292i = z;
        this.f5293j = layoutInflater;
        this.f5289f = nVar;
        this.k = i4;
        a();
    }

    public final void a() {
        n nVar = this.f5289f;
        q qVar = nVar.f5315w;
        if (qVar != null) {
            nVar.i();
            ArrayList arrayList = nVar.f5303j;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((q) arrayList.get(i4)) == qVar) {
                    this.f5290g = i4;
                    return;
                }
            }
        }
        this.f5290g = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final q getItem(int i4) {
        ArrayList l3;
        boolean z = this.f5292i;
        n nVar = this.f5289f;
        if (z) {
            nVar.i();
            l3 = nVar.f5303j;
        } else {
            l3 = nVar.l();
        }
        int i5 = this.f5290g;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (q) l3.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l3;
        boolean z = this.f5292i;
        n nVar = this.f5289f;
        if (z) {
            nVar.i();
            l3 = nVar.f5303j;
        } else {
            l3 = nVar.l();
        }
        if (this.f5290g < 0) {
            return l3.size();
        }
        return l3.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        int i5;
        boolean z = false;
        if (view == null) {
            view = this.f5293j.inflate(this.k, viewGroup, false);
        }
        int i6 = getItem(i4).f5327b;
        int i7 = i4 - 1;
        if (i7 >= 0) {
            i5 = getItem(i7).f5327b;
        } else {
            i5 = i6;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f5289f.m() && i6 != i5) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        InterfaceC0450C interfaceC0450C = (InterfaceC0450C) view;
        if (this.f5291h) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC0450C.a(getItem(i4));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
