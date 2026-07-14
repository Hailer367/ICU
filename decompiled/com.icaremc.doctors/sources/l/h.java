package l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends BaseAdapter {

    /* renamed from: c, reason: collision with root package name */
    public final j f2834c;

    /* renamed from: d, reason: collision with root package name */
    public int f2835d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2836e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2837f;

    /* renamed from: g, reason: collision with root package name */
    public final LayoutInflater f2838g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2839h;

    public h(j jVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f2837f = z;
        this.f2838g = layoutInflater;
        this.f2834c = jVar;
        this.f2839h = i2;
        a();
    }

    public final void a() {
        j jVar = this.f2834c;
        k kVar = jVar.f2857s;
        if (kVar != null) {
            jVar.i();
            ArrayList arrayList = jVar.f2850j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((k) arrayList.get(i2)) == kVar) {
                    this.f2835d = i2;
                    return;
                }
            }
        }
        this.f2835d = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final k getItem(int i2) {
        ArrayList k2;
        boolean z = this.f2837f;
        j jVar = this.f2834c;
        if (z) {
            jVar.i();
            k2 = jVar.f2850j;
        } else {
            k2 = jVar.k();
        }
        int i3 = this.f2835d;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (k) k2.get(i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList k2;
        boolean z = this.f2837f;
        j jVar = this.f2834c;
        if (z) {
            jVar.i();
            k2 = jVar.f2850j;
        } else {
            k2 = jVar.k();
        }
        if (this.f2835d < 0) {
            return k2.size();
        }
        return k2.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        boolean z = false;
        if (view == null) {
            view = this.f2838g.inflate(this.f2839h, viewGroup, false);
        }
        int i4 = getItem(i2).f2862b;
        int i5 = i2 - 1;
        if (i5 >= 0) {
            i3 = getItem(i5).f2862b;
        } else {
            i3 = i4;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f2834c.l() && i4 != i3) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        q qVar = (q) view;
        if (this.f2836e) {
            listMenuItemView.setForceShowIcon(true);
        }
        qVar.b(getItem(i2));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
