package I;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class J implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public v0 f695a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f696b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0066u f697c;

    public J(View view, InterfaceC0066u interfaceC0066u) {
        this.f696b = view;
        this.f697c = interfaceC0066u;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        v0 c4 = v0.c(windowInsets, view);
        int i4 = Build.VERSION.SDK_INT;
        InterfaceC0066u interfaceC0066u = this.f697c;
        if (i4 < 30) {
            K.a(windowInsets, this.f696b);
            if (c4.equals(this.f695a)) {
                return interfaceC0066u.d(view, c4).b();
            }
        }
        this.f695a = c4;
        v0 d4 = interfaceC0066u.d(view, c4);
        if (i4 >= 30) {
            return d4.b();
        }
        WeakHashMap weakHashMap = T.f702a;
        view.requestApplyInsets();
        return d4.b();
    }
}
