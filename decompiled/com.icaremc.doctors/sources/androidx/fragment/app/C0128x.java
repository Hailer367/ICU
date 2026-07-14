package androidx.fragment.app;

import f.AbstractC0187c;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.fragment.app.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0128x extends AbstractC0187c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1768a;

    public C0128x(AtomicReference atomicReference) {
        this.f1768a = atomicReference;
    }

    @Override // f.AbstractC0187c
    public final void a(Object obj) {
        AbstractC0187c abstractC0187c = (AbstractC0187c) this.f1768a.get();
        if (abstractC0187c != null) {
            abstractC0187c.a(obj);
            return;
        }
        throw new IllegalStateException("Operation cannot be started before fragment is in created state");
    }
}
