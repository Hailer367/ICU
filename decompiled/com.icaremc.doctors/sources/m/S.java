package m;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class S implements TextWatcher {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SearchView f3104c;

    public S(SearchView searchView) {
        this.f3104c = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        SearchView searchView = this.f3104c;
        Editable text = searchView.f1173r.getText();
        searchView.f1165a0 = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        searchView.t(!isEmpty);
        int i5 = 8;
        if (searchView.f1164W && !searchView.f1157P && isEmpty) {
            searchView.f1178w.setVisibility(8);
            i5 = 0;
        }
        searchView.y.setVisibility(i5);
        searchView.p();
        searchView.s();
        charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
