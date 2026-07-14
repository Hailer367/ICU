package b3;

import java.util.concurrent.CancellationException;

/* renamed from: b3.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0239n {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3284a;

    /* renamed from: b, reason: collision with root package name */
    public final C f3285b;

    /* renamed from: c, reason: collision with root package name */
    public final S2.q f3286c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3287d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f3288e;

    public C0239n(Object obj, C c4, S2.q qVar, Object obj2, Throwable th) {
        this.f3284a = obj;
        this.f3285b = c4;
        this.f3286c = qVar;
        this.f3287d = obj2;
        this.f3288e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static C0239n a(C0239n c0239n, C c4, CancellationException cancellationException, int i4) {
        Object obj = c0239n.f3284a;
        if ((i4 & 2) != 0) {
            c4 = c0239n.f3285b;
        }
        C c5 = c4;
        S2.q qVar = c0239n.f3286c;
        Object obj2 = c0239n.f3287d;
        CancellationException cancellationException2 = cancellationException;
        if ((i4 & 16) != 0) {
            cancellationException2 = c0239n.f3288e;
        }
        c0239n.getClass();
        return new C0239n(obj, c5, qVar, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0239n)) {
            return false;
        }
        C0239n c0239n = (C0239n) obj;
        if (T2.h.a(this.f3284a, c0239n.f3284a) && T2.h.a(this.f3285b, c0239n.f3285b) && T2.h.a(this.f3286c, c0239n.f3286c) && T2.h.a(this.f3287d, c0239n.f3287d) && T2.h.a(this.f3288e, c0239n.f3288e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i4 = 0;
        Object obj = this.f3284a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i5 = hashCode * 31;
        C c4 = this.f3285b;
        if (c4 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = c4.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        S2.q qVar = this.f3286c;
        if (qVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = qVar.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        Object obj2 = this.f3287d;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        Throwable th = this.f3288e;
        if (th != null) {
            i4 = th.hashCode();
        }
        return i8 + i4;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f3284a + ", cancelHandler=" + this.f3285b + ", onCancellation=" + this.f3286c + ", idempotentResume=" + this.f3287d + ", cancelCause=" + this.f3288e + ')';
    }

    public /* synthetic */ C0239n(Object obj, C c4, S2.q qVar, CancellationException cancellationException, int i4) {
        this(obj, (i4 & 2) != 0 ? null : c4, (i4 & 4) != 0 ? null : qVar, (Object) null, (i4 & 16) != 0 ? null : cancellationException);
    }
}
