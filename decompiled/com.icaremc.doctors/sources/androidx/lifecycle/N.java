package androidx.lifecycle;

import android.os.Bundle;
import b0.InterfaceC0162d;

/* loaded from: classes.dex */
public final /* synthetic */ class N implements InterfaceC0162d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1795a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1796b;

    public /* synthetic */ N(int i2, Object obj) {
        this.f1795a = i2;
        this.f1796b = obj;
    }

    @Override // b0.InterfaceC0162d
    public final Bundle a() {
        switch (this.f1795a) {
            case 0:
                return O.a((O) this.f1796b);
            default:
                return d.k.a((androidx.fragment.app.M) this.f1796b);
        }
    }
}
