package o;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* renamed from: o.a1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC0502a1 implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f5556a;

    public ViewOnFocusChangeListenerC0502a1(SearchView searchView) {
        this.f5556a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        SearchView searchView = this.f5556a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.P;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
