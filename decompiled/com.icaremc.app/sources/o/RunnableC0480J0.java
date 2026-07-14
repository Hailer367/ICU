package o;

import java.util.WeakHashMap;

/* renamed from: o.J0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0480J0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5467f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC0486M0 f5468g;

    public /* synthetic */ RunnableC0480J0(AbstractC0486M0 abstractC0486M0, int i4) {
        this.f5467f = i4;
        this.f5468g = abstractC0486M0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f5467f;
        AbstractC0486M0 abstractC0486M0 = this.f5468g;
        switch (i4) {
            case 0:
                C0462A0 c0462a0 = abstractC0486M0.f5483h;
                if (c0462a0 != null) {
                    c0462a0.setListSelectionHidden(true);
                    c0462a0.requestLayout();
                    return;
                }
                return;
            default:
                C0462A0 c0462a02 = abstractC0486M0.f5483h;
                if (c0462a02 != null) {
                    WeakHashMap weakHashMap = I.T.f702a;
                    if (c0462a02.isAttachedToWindow() && abstractC0486M0.f5483h.getCount() > abstractC0486M0.f5483h.getChildCount() && abstractC0486M0.f5483h.getChildCount() <= abstractC0486M0.f5492r) {
                        abstractC0486M0.f5480D.setInputMethodMode(2);
                        abstractC0486M0.c();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
