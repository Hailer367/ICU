package j1;

import f.C0189e;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final C0189e f2735a;

    /* renamed from: b, reason: collision with root package name */
    public final R0.a f2736b;

    public c(C0189e c0189e, R0.a aVar) {
        this.f2735a = c0189e;
        this.f2736b = aVar;
    }

    @Override // j1.d
    public final Iterator iterator() {
        return new b(this);
    }
}
