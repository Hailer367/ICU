package o;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* renamed from: o.N, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0487N implements ListAdapter, SpinnerAdapter {

    /* renamed from: f, reason: collision with root package name */
    public SpinnerAdapter f5500f;

    /* renamed from: g, reason: collision with root package name */
    public ListAdapter f5501g;

    @Override // android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f5501g;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter == null) {
            return 0;
        }
        return spinnerAdapter.getCount();
    }

    @Override // android.widget.SpinnerAdapter
    public final View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getDropDownView(i4, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getItem(i4);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter == null) {
            return -1L;
        }
        return spinnerAdapter.getItemId(i4);
    }

    @Override // android.widget.Adapter
    public final int getItemViewType(int i4) {
        return 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        return getDropDownView(i4, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public final int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public final boolean hasStableIds() {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter != null && spinnerAdapter.hasStableIds()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public final boolean isEmpty() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ListAdapter
    public final boolean isEnabled(int i4) {
        ListAdapter listAdapter = this.f5501g;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i4);
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter != null) {
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f5500f;
        if (spinnerAdapter != null) {
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
