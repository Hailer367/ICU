package E;

import android.os.Build;
import androidx.core.widget.NestedScrollView;

/* renamed from: E.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0024y {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0023x f261a;

    public C0024y(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f261a = new C0022w(nestedScrollView);
        } else {
            this.f261a = new A0.f(1);
        }
    }
}
