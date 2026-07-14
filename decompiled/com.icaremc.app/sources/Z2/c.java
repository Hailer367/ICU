package Z2;

import D2.M;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final A2.f f2207a;

    /* renamed from: b, reason: collision with root package name */
    public final M f2208b;

    public c(A2.f fVar, M m3) {
        this.f2207a = fVar;
        this.f2208b = m3;
    }

    @Override // Z2.d
    public final Iterator iterator() {
        return new b(this);
    }
}
