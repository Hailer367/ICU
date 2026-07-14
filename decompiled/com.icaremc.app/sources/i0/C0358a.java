package i0;

import android.os.Bundle;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0358a implements InterfaceC0361d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4090a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4091b;

    public C0358a(C0362e c0362e) {
        this.f4090a = 0;
        this.f4091b = new LinkedHashSet();
        c0362e.c("androidx.savedstate.Restarter", this);
    }

    @Override // i0.InterfaceC0361d
    public final Bundle a() {
        switch (this.f4090a) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f4091b));
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                ((InAppBrowserActivity) this.f4091b).getDelegate().getClass();
                return bundle2;
        }
    }

    public C0358a(InAppBrowserActivity inAppBrowserActivity) {
        this.f4090a = 1;
        this.f4091b = inAppBrowserActivity;
    }
}
