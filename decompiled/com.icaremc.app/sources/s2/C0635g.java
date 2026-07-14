package s2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: s2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0635g {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f6149a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A2.t f6150b;

    public C0635g(A2.t tVar) {
        this.f6150b = tVar;
    }

    public final void a(Object obj) {
        if (!this.f6149a.get()) {
            A2.t tVar = this.f6150b;
            if (((AtomicReference) tVar.f100h).get() == this) {
                A2.t tVar2 = (A2.t) tVar.f101i;
                ((InterfaceC0634f) tVar2.f99g).j((String) tVar2.f100h, ((InterfaceC0645q) tVar2.f101i).a(obj));
            }
        }
    }
}
