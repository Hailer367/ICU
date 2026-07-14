package o;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

/* renamed from: o.c1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0508c1 implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f5573a;

    public C0508c1(SearchView searchView) {
        this.f5573a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
        this.f5573a.p();
        return true;
    }
}
