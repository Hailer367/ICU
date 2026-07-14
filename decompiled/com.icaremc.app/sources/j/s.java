package j;

import I.T;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s extends android.support.v4.media.session.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5006a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5007b;

    public /* synthetic */ s(int i4, Object obj) {
        this.f5006a = i4;
        this.f5007b = obj;
    }

    @Override // I.Z
    public final void a() {
        int i4 = this.f5006a;
        Object obj = this.f5007b;
        switch (i4) {
            case 0:
                LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = ((RunnableC0421p) obj).f5003g;
                layoutInflaterFactory2C0393A.f4826A.setAlpha(1.0f);
                layoutInflaterFactory2C0393A.f4829D.d(null);
                layoutInflaterFactory2C0393A.f4829D = null;
                return;
            case 1:
                LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A2 = (LayoutInflaterFactory2C0393A) obj;
                layoutInflaterFactory2C0393A2.f4826A.setAlpha(1.0f);
                layoutInflaterFactory2C0393A2.f4829D.d(null);
                layoutInflaterFactory2C0393A2.f4829D = null;
                return;
            default:
                LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A3 = (LayoutInflaterFactory2C0393A) ((io.flutter.plugin.platform.s) obj).f4391h;
                layoutInflaterFactory2C0393A3.f4826A.setVisibility(8);
                PopupWindow popupWindow = layoutInflaterFactory2C0393A3.f4827B;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflaterFactory2C0393A3.f4826A.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C0393A3.f4826A.getParent();
                    WeakHashMap weakHashMap = T.f702a;
                    view.requestApplyInsets();
                }
                layoutInflaterFactory2C0393A3.f4826A.e();
                layoutInflaterFactory2C0393A3.f4829D.d(null);
                layoutInflaterFactory2C0393A3.f4829D = null;
                ViewGroup viewGroup = layoutInflaterFactory2C0393A3.f4831F;
                WeakHashMap weakHashMap2 = T.f702a;
                viewGroup.requestApplyInsets();
                return;
        }
    }

    @Override // android.support.v4.media.session.a, I.Z
    public void c() {
        int i4 = this.f5006a;
        Object obj = this.f5007b;
        switch (i4) {
            case 0:
                ((RunnableC0421p) obj).f5003g.f4826A.setVisibility(0);
                return;
            case 1:
                LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) obj;
                layoutInflaterFactory2C0393A.f4826A.setVisibility(0);
                if (layoutInflaterFactory2C0393A.f4826A.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C0393A.f4826A.getParent();
                    WeakHashMap weakHashMap = T.f702a;
                    view.requestApplyInsets();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
