package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.EnumC0206m;
import i0.InterfaceC0361d;
import j.AbstractActivityC0416k;

/* renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0188u implements InterfaceC0361d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2943a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2944b;

    public /* synthetic */ C0188u(int i4, Object obj) {
        this.f2943a = i4;
        this.f2944b = obj;
    }

    @Override // i0.InterfaceC0361d
    public final Bundle a() {
        switch (this.f2943a) {
            case 0:
                AbstractActivityC0416k abstractActivityC0416k = (AbstractActivityC0416k) this.f2944b;
                abstractActivityC0416k.markFragmentsCreated();
                abstractActivityC0416k.mFragmentLifecycleRegistry.e(EnumC0206m.ON_STOP);
                return new Bundle();
            default:
                return ((P) this.f2944b).V();
        }
    }
}
