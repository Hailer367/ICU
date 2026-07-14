package m;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public final class V implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f3108a;

    public V(SearchView searchView) {
        this.f3108a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        SearchView searchView = this.f3108a;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f1173r;
        View view2 = searchView.z;
        if (view2.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.f1175t.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = u0.a(searchView);
            if (searchView.f1156O) {
                i10 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                i10 = 0;
            }
            searchAutoComplete.getDropDownBackground().getPadding(rect);
            if (a2) {
                i11 = -rect.left;
            } else {
                i11 = paddingLeft - (rect.left + i10);
            }
            searchAutoComplete.setDropDownHorizontalOffset(i11);
            searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + i10) - paddingLeft);
        }
    }
}
