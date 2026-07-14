package j;

import I.T;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class N extends android.support.v4.media.session.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4908a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Q f4909b;

    public /* synthetic */ N(Q q2, int i4) {
        this.f4908a = i4;
        this.f4909b = q2;
    }

    @Override // I.Z
    public final void a() {
        View view;
        int i4 = this.f4908a;
        Q q2 = this.f4909b;
        switch (i4) {
            case 0:
                if (q2.f4930o && (view = q2.f4923g) != null) {
                    view.setTranslationY(0.0f);
                    q2.f4920d.setTranslationY(0.0f);
                }
                q2.f4920d.setVisibility(8);
                q2.f4920d.setTransitioning(false);
                q2.f4935t = null;
                io.flutter.plugin.platform.s sVar = q2.k;
                if (sVar != null) {
                    sVar.k(q2.f4926j);
                    q2.f4926j = null;
                    q2.k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = q2.f4919c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = T.f702a;
                    actionBarOverlayLayout.requestApplyInsets();
                    return;
                }
                return;
            default:
                q2.f4935t = null;
                q2.f4920d.requestLayout();
                return;
        }
    }
}
