package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.EnumC0144n;
import b0.InterfaceC0162d;
import io.flutter.embedding.android.FlutterFragmentActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class I implements InterfaceC0162d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1548a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1549b;

    public /* synthetic */ I(int i2, Object obj) {
        this.f1548a = i2;
        this.f1549b = obj;
    }

    @Override // b0.InterfaceC0162d
    public final Bundle a() {
        switch (this.f1548a) {
            case 0:
                FlutterFragmentActivity flutterFragmentActivity = (FlutterFragmentActivity) this.f1549b;
                flutterFragmentActivity.markFragmentsCreated();
                flutterFragmentActivity.mFragmentLifecycleRegistry.e(EnumC0144n.ON_STOP);
                return new Bundle();
            default:
                return ((h0) this.f1549b).W();
        }
    }
}
