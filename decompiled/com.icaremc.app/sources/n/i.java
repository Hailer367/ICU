package n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.icaremc.app.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    public int f5282f = -1;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f5283g;

    public i(j jVar) {
        this.f5283g = jVar;
        a();
    }

    public final void a() {
        n nVar = this.f5283g.f5286h;
        q qVar = nVar.f5315w;
        if (qVar != null) {
            nVar.i();
            ArrayList arrayList = nVar.f5303j;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((q) arrayList.get(i4)) == qVar) {
                    this.f5282f = i4;
                    return;
                }
            }
        }
        this.f5282f = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final q getItem(int i4) {
        j jVar = this.f5283g;
        n nVar = jVar.f5286h;
        nVar.i();
        ArrayList arrayList = nVar.f5303j;
        jVar.getClass();
        int i5 = this.f5282f;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (q) arrayList.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        j jVar = this.f5283g;
        n nVar = jVar.f5286h;
        nVar.i();
        int size = nVar.f5303j.size();
        jVar.getClass();
        if (this.f5282f < 0) {
            return size;
        }
        return size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5283g.f5285g.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((InterfaceC0450C) view).a(getItem(i4));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
