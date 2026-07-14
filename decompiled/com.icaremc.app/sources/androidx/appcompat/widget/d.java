package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SearchView.SearchAutoComplete f2499f;

    public d(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f2499f = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f2499f;
        if (searchAutoComplete.f2406l) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f2406l = false;
        }
    }
}
