package n;

import I.T;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.WeakHashMap;
import o.AbstractC0479J;
import o.AbstractC0481K;
import o.C0491Q;
import o.C0494U;
import o.S0;

/* renamed from: n.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0454d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5248f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5249g;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0454d(int i4, Object obj) {
        this.f5248f = i4;
        this.f5249g = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i4 = this.f5248f;
        Object obj = this.f5249g;
        switch (i4) {
            case 0:
                ViewOnKeyListenerC0458h viewOnKeyListenerC0458h = (ViewOnKeyListenerC0458h) obj;
                ArrayList arrayList = viewOnKeyListenerC0458h.f5269m;
                if (viewOnKeyListenerC0458h.b() && arrayList.size() > 0) {
                    int i5 = 0;
                    if (!((C0457g) arrayList.get(0)).f5256a.f5479C) {
                        View view = viewOnKeyListenerC0458h.f5276t;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i5 < size) {
                                Object obj2 = arrayList.get(i5);
                                i5++;
                                ((C0457g) obj2).f5256a.c();
                            }
                            return;
                        }
                        viewOnKeyListenerC0458h.dismiss();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                G g4 = (G) obj;
                S0 s02 = g4.f5216m;
                if (g4.b() && !s02.f5479C) {
                    View view2 = g4.f5221r;
                    if (view2 != null && view2.isShown()) {
                        s02.c();
                        return;
                    } else {
                        g4.dismiss();
                        return;
                    }
                }
                return;
            case 2:
                C0494U c0494u = (C0494U) obj;
                if (!c0494u.getInternalPopup().b()) {
                    c0494u.k.l(AbstractC0481K.b(c0494u), AbstractC0481K.a(c0494u));
                }
                ViewTreeObserver viewTreeObserver = c0494u.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    AbstractC0479J.a(viewTreeObserver, this);
                    return;
                }
                return;
            default:
                C0491Q c0491q = (C0491Q) obj;
                C0494U c0494u2 = c0491q.f5510K;
                c0491q.getClass();
                WeakHashMap weakHashMap = T.f702a;
                if (c0494u2.isAttachedToWindow() && c0494u2.getGlobalVisibleRect(c0491q.f5508I)) {
                    c0491q.s();
                    c0491q.c();
                    return;
                } else {
                    c0491q.dismiss();
                    return;
                }
        }
    }
}
