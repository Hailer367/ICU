package m;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.encoders.json.BuildConfig;
import java.util.ArrayList;
import k.InterfaceC0217a;

/* loaded from: classes.dex */
public final class k0 implements l.p {

    /* renamed from: c, reason: collision with root package name */
    public l.j f3183c;

    /* renamed from: d, reason: collision with root package name */
    public l.k f3184d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3185e;

    public k0(Toolbar toolbar) {
        this.f3185e = toolbar;
    }

    @Override // l.p
    public final void b() {
        if (this.f3184d != null) {
            l.j jVar = this.f3183c;
            if (jVar != null) {
                int size = jVar.f2846f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f3183c.getItem(i2) == this.f3184d) {
                        return;
                    }
                }
            }
            j(this.f3184d);
        }
    }

    @Override // l.p
    public final boolean e(l.k kVar) {
        Toolbar toolbar = this.f3185e;
        toolbar.c();
        ViewParent parent = toolbar.f1238j.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f1238j);
            }
            toolbar.addView(toolbar.f1238j);
        }
        View view = kVar.z;
        if (view == null) {
            view = null;
        }
        toolbar.f1239k = view;
        this.f3184d = kVar;
        ViewParent parent2 = view.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f1239k);
            }
            l0 g2 = Toolbar.g();
            g2.f3189a = (toolbar.p & 112) | 8388611;
            g2.f3190b = 2;
            toolbar.f1239k.setLayoutParams(g2);
            toolbar.addView(toolbar.f1239k);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((l0) childAt.getLayoutParams()).f3190b != 2 && childAt != toolbar.f1231c) {
                toolbar.removeViewAt(childCount);
                toolbar.f1225G.add(childAt);
            }
        }
        toolbar.requestLayout();
        kVar.f2860B = true;
        kVar.f2874n.o(false);
        KeyEvent.Callback callback = toolbar.f1239k;
        if (callback instanceof InterfaceC0217a) {
            SearchView searchView = (SearchView) ((InterfaceC0217a) callback);
            SearchView.SearchAutoComplete searchAutoComplete = searchView.f1173r;
            if (!searchView.f1166b0) {
                searchView.f1166b0 = true;
                int imeOptions = searchAutoComplete.getImeOptions();
                searchView.f1167c0 = imeOptions;
                searchAutoComplete.setImeOptions(imeOptions | 33554432);
                searchAutoComplete.setText(BuildConfig.FLAVOR);
                searchView.setIconified(false);
            }
        }
        return true;
    }

    @Override // l.p
    public final void f(Context context, l.j jVar) {
        l.k kVar;
        l.j jVar2 = this.f3183c;
        if (jVar2 != null && (kVar = this.f3184d) != null) {
            jVar2.d(kVar);
        }
        this.f3183c = jVar;
    }

    @Override // l.p
    public final boolean g() {
        return false;
    }

    @Override // l.p
    public final boolean h(l.t tVar) {
        return false;
    }

    @Override // l.p
    public final boolean j(l.k kVar) {
        Toolbar toolbar = this.f3185e;
        KeyEvent.Callback callback = toolbar.f1239k;
        if (callback instanceof InterfaceC0217a) {
            SearchView searchView = (SearchView) ((InterfaceC0217a) callback);
            SearchView.SearchAutoComplete searchAutoComplete = searchView.f1173r;
            searchAutoComplete.setText(BuildConfig.FLAVOR);
            searchAutoComplete.setSelection(searchAutoComplete.length());
            searchView.f1165a0 = BuildConfig.FLAVOR;
            searchView.clearFocus();
            searchView.u(true);
            searchAutoComplete.setImeOptions(searchView.f1167c0);
            searchView.f1166b0 = false;
        }
        toolbar.removeView(toolbar.f1239k);
        toolbar.removeView(toolbar.f1238j);
        toolbar.f1239k = null;
        ArrayList arrayList = toolbar.f1225G;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f3184d = null;
        toolbar.requestLayout();
        kVar.f2860B = false;
        kVar.f2874n.o(false);
        return true;
    }

    @Override // l.p
    public final void a(l.j jVar, boolean z) {
    }
}
