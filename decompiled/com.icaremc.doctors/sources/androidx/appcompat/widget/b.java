package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class b implements View.OnKeyListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SearchView f1256c;

    public b(SearchView searchView) {
        this.f1256c = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        int length;
        SearchView searchView = this.f1256c;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f1173r;
        if (searchView.f1168d0 != null) {
            if (searchAutoComplete.isPopupShowing() && searchAutoComplete.getListSelection() != -1) {
                if (searchView.f1168d0 != null && searchView.f1158Q != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                    if (i2 != 66 && i2 != 84 && i2 != 61) {
                        if (i2 != 21 && i2 != 22) {
                            if (i2 == 19) {
                                searchAutoComplete.getListSelection();
                                return false;
                            }
                        } else {
                            if (i2 == 21) {
                                length = 0;
                            } else {
                                length = searchAutoComplete.length();
                            }
                            searchAutoComplete.setSelection(length);
                            searchAutoComplete.setListSelection(0);
                            searchAutoComplete.clearListSelection();
                            Method method = SearchView.f1142i0.f786c;
                            if (method != null) {
                                try {
                                    method.invoke(searchAutoComplete, Boolean.TRUE);
                                } catch (Exception unused) {
                                }
                            }
                            return true;
                        }
                    } else {
                        searchView.l(searchAutoComplete.getListSelection());
                        return true;
                    }
                }
            } else if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) != 0 && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i2 == 66) {
                view.cancelLongPress();
                searchView.getContext().startActivity(searchView.h("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
                return true;
            }
        }
        return false;
    }
}
