package M;

import A2.i;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import o.j1;

/* loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable {

    /* renamed from: f, reason: collision with root package name */
    public boolean f1025f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1026g;

    /* renamed from: h, reason: collision with root package name */
    public Cursor f1027h;

    /* renamed from: i, reason: collision with root package name */
    public int f1028i;

    /* renamed from: j, reason: collision with root package name */
    public a f1029j;
    public b k;

    /* renamed from: l, reason: collision with root package name */
    public d f1030l;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1027h;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f1029j;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.k;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f1027h = cursor;
            if (cursor != null) {
                a aVar2 = this.f1029j;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.k;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f1028i = cursor.getColumnIndexOrThrow("_id");
                this.f1025f = true;
                notifyDataSetChanged();
            } else {
                this.f1028i = -1;
                this.f1025f = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (this.f1025f && (cursor = this.f1027h) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        if (this.f1025f) {
            this.f1027h.moveToPosition(i4);
            if (view == null) {
                j1 j1Var = (j1) this;
                view = j1Var.f5625o.inflate(j1Var.f5624n, viewGroup, false);
            }
            a(view, this.f1027h);
            return view;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [M.d, android.widget.Filter] */
    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f1030l == null) {
            ?? filter = new Filter();
            filter.f1031a = this;
            this.f1030l = filter;
        }
        return this.f1030l;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        Cursor cursor;
        if (this.f1025f && (cursor = this.f1027h) != null) {
            cursor.moveToPosition(i4);
            return this.f1027h;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        Cursor cursor;
        if (!this.f1025f || (cursor = this.f1027h) == null || !cursor.moveToPosition(i4)) {
            return 0L;
        }
        return this.f1027h.getLong(this.f1028i);
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (this.f1025f) {
            if (this.f1027h.moveToPosition(i4)) {
                if (view == null) {
                    view = d(viewGroup);
                }
                a(view, this.f1027h);
                return view;
            }
            throw new IllegalStateException(i.g(i4, "couldn't move cursor to position "));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
