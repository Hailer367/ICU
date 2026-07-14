package I;

import android.os.Build;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0071z f682a;

    /* JADX WARN: Type inference failed for: r3v1, types: [I.z, java.lang.Object] */
    public A(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f682a = new C0070y(nestedScrollView);
        } else {
            this.f682a = new Object();
        }
    }
}
