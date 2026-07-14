package j;

import I.T;
import I.Y;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* renamed from: j.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0421p implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5002f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ LayoutInflaterFactory2C0393A f5003g;

    public /* synthetic */ RunnableC0421p(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A, int i4) {
        this.f5002f = i4;
        this.f5003g = layoutInflaterFactory2C0393A;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        int i4 = this.f5002f;
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.f5003g;
        switch (i4) {
            case 0:
                if ((layoutInflaterFactory2C0393A.f4855e0 & 1) != 0) {
                    layoutInflaterFactory2C0393A.w(0);
                }
                if ((layoutInflaterFactory2C0393A.f4855e0 & 4096) != 0) {
                    layoutInflaterFactory2C0393A.w(108);
                }
                layoutInflaterFactory2C0393A.f4854d0 = false;
                layoutInflaterFactory2C0393A.f4855e0 = 0;
                return;
            default:
                layoutInflaterFactory2C0393A.f4827B.showAtLocation(layoutInflaterFactory2C0393A.f4826A, 55, 0, 0);
                Y y3 = layoutInflaterFactory2C0393A.f4829D;
                if (y3 != null) {
                    y3.b();
                }
                if (layoutInflaterFactory2C0393A.f4830E && (viewGroup = layoutInflaterFactory2C0393A.f4831F) != null) {
                    WeakHashMap weakHashMap = T.f702a;
                    if (viewGroup.isLaidOut()) {
                        layoutInflaterFactory2C0393A.f4826A.setAlpha(0.0f);
                        Y a4 = T.a(layoutInflaterFactory2C0393A.f4826A);
                        a4.a(1.0f);
                        layoutInflaterFactory2C0393A.f4829D = a4;
                        a4.d(new s(0, this));
                        return;
                    }
                }
                layoutInflaterFactory2C0393A.f4826A.setAlpha(1.0f);
                layoutInflaterFactory2C0393A.f4826A.setVisibility(0);
                return;
        }
    }
}
