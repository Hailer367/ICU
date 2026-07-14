package o;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.icaremc.app.R;

/* renamed from: o.b1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC0505b1 implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f5558a;

    public ViewOnLayoutChangeListenerC0505b1(SearchView searchView) {
        this.f5558a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        SearchView searchView = this.f5558a;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f2400u;
        View view2 = searchView.f2369C;
        if (view2.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.f2402w.getPaddingLeft();
            Rect rect = new Rect();
            boolean a4 = E1.a(searchView);
            if (searchView.f2383R) {
                i12 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                i12 = 0;
            }
            searchAutoComplete.getDropDownBackground().getPadding(rect);
            if (a4) {
                i13 = -rect.left;
            } else {
                i13 = paddingLeft - (rect.left + i12);
            }
            searchAutoComplete.setDropDownHorizontalOffset(i13);
            searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + i12) - paddingLeft);
        }
    }
}
