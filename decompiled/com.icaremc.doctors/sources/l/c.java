package l;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import m.M;

/* loaded from: classes.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2802c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f2803d;

    public /* synthetic */ c(l lVar, int i2) {
        this.f2802c = i2;
        this.f2803d = lVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f2802c) {
            case 0:
                g gVar = (g) this.f2803d;
                ArrayList arrayList = gVar.f2821j;
                if (gVar.i() && arrayList.size() > 0) {
                    int i2 = 0;
                    if (!((f) arrayList.get(0)).f2810a.f3082w) {
                        View view = gVar.q;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i2 < size) {
                                Object obj = arrayList.get(i2);
                                i2++;
                                ((f) obj).f2810a.show();
                            }
                            return;
                        }
                        gVar.dismiss();
                        return;
                    }
                    return;
                }
                return;
            default:
                s sVar = (s) this.f2803d;
                M m2 = sVar.f2902j;
                if (sVar.i() && !m2.f3082w) {
                    View view2 = sVar.f2907o;
                    if (view2 != null && view2.isShown()) {
                        m2.show();
                        return;
                    } else {
                        sVar.dismiss();
                        return;
                    }
                }
                return;
        }
    }
}
