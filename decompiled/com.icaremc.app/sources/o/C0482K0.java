package o;

import android.widget.AbsListView;

/* renamed from: o.K0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0482K0 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0486M0 f5469a;

    public C0482K0(AbstractC0486M0 abstractC0486M0) {
        this.f5469a = abstractC0486M0;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i4) {
        AbstractC0486M0 abstractC0486M0 = this.f5469a;
        RunnableC0480J0 runnableC0480J0 = abstractC0486M0.f5496v;
        if (i4 == 1 && abstractC0486M0.f5480D.getInputMethodMode() != 2 && abstractC0486M0.f5480D.getContentView() != null) {
            abstractC0486M0.z.removeCallbacks(runnableC0480J0);
            runnableC0480J0.run();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i4, int i5, int i6) {
    }
}
