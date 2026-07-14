package m;

import android.widget.AbsListView;

/* loaded from: classes.dex */
public final class H implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3062a;

    public H(J j2) {
        this.f3062a = j2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        J j2 = this.f3062a;
        G g2 = j2.p;
        if (i2 == 1 && j2.f3083x.getInputMethodMode() != 2 && j2.f3083x.getContentView() != null) {
            j2.f3079t.removeCallbacks(g2);
            g2.run();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }
}
