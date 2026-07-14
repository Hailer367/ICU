package androidx.lifecycle;

import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0192y;
import i0.InterfaceC0361d;

/* loaded from: classes.dex */
public final /* synthetic */ class I implements InterfaceC0361d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2967a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2968b;

    public /* synthetic */ I(int i4, Object obj) {
        this.f2967a = i4;
        this.f2968b = obj;
    }

    @Override // i0.InterfaceC0361d
    public final Bundle a() {
        switch (this.f2967a) {
            case 0:
                return J.a((J) this.f2968b);
            default:
                return e.l.a((AbstractActivityC0192y) this.f2968b);
        }
    }
}
