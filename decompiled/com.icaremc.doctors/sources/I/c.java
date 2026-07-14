package I;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import m.e0;

/* loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable {

    /* renamed from: c, reason: collision with root package name */
    public boolean f315c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f316d;

    /* renamed from: e, reason: collision with root package name */
    public Cursor f317e;

    /* renamed from: f, reason: collision with root package name */
    public Context f318f;

    /* renamed from: g, reason: collision with root package name */
    public int f319g;

    /* renamed from: h, reason: collision with root package name */
    public a f320h;

    /* renamed from: i, reason: collision with root package name */
    public b f321i;

    /* renamed from: j, reason: collision with root package name */
    public d f322j;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f317e;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f320h;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.f321i;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f317e = cursor;
            if (cursor != null) {
                a aVar2 = this.f320h;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.f321i;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f319g = cursor.getColumnIndexOrThrow("_id");
                this.f315c = true;
                notifyDataSetChanged();
            } else {
                this.f319g = -1;
                this.f315c = false;
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
        if (this.f315c && (cursor = this.f317e) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (this.f315c) {
            this.f317e.moveToPosition(i2);
            if (view == null) {
                e0 e0Var = (e0) this;
                view = e0Var.f3131m.inflate(e0Var.f3130l, viewGroup, false);
            }
            a(view, this.f317e);
            return view;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Filter, I.d] */
    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f322j == null) {
            ?? filter = new Filter();
            filter.f323a = this;
            this.f322j = filter;
        }
        return this.f322j;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        Cursor cursor;
        if (this.f315c && (cursor = this.f317e) != null) {
            cursor.moveToPosition(i2);
            return this.f317e;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        Cursor cursor;
        if (!this.f315c || (cursor = this.f317e) == null || !cursor.moveToPosition(i2)) {
            return 0L;
        }
        return this.f317e.getLong(this.f319g);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.f315c) {
            if (this.f317e.moveToPosition(i2)) {
                if (view == null) {
                    view = d(viewGroup);
                }
                a(view, this.f317e);
                return view;
            }
            throw new IllegalStateException(O.a.c(i2, "couldn't move cursor to position "));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
