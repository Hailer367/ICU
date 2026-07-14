package o;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class Y0 implements TextWatcher {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SearchView f5550f;

    public Y0(SearchView searchView) {
        this.f5550f = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        SearchView searchView = this.f5550f;
        Editable text = searchView.f2400u.getText();
        searchView.f2392d0 = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        searchView.u(!isEmpty);
        int i7 = 8;
        if (searchView.f2391c0 && !searchView.f2384S && isEmpty) {
            searchView.z.setVisibility(8);
            i7 = 0;
        }
        searchView.f2368B.setVisibility(i7);
        searchView.q();
        searchView.t();
        charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}
