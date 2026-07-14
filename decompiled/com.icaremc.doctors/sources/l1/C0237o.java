package l1;

import java.util.concurrent.CancellationException;

/* renamed from: l1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0237o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3001a;

    /* renamed from: b, reason: collision with root package name */
    public final C0227e f3002b;

    /* renamed from: c, reason: collision with root package name */
    public final c1.q f3003c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3004d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f3005e;

    public C0237o(Object obj, C0227e c0227e, c1.q qVar, Object obj2, Throwable th) {
        this.f3001a = obj;
        this.f3002b = c0227e;
        this.f3003c = qVar;
        this.f3004d = obj2;
        this.f3005e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static C0237o a(C0237o c0237o, C0227e c0227e, CancellationException cancellationException, int i2) {
        Object obj = c0237o.f3001a;
        if ((i2 & 2) != 0) {
            c0227e = c0237o.f3002b;
        }
        C0227e c0227e2 = c0227e;
        c1.q qVar = c0237o.f3003c;
        Object obj2 = c0237o.f3004d;
        CancellationException cancellationException2 = cancellationException;
        if ((i2 & 16) != 0) {
            cancellationException2 = c0237o.f3005e;
        }
        c0237o.getClass();
        return new C0237o(obj, c0227e2, qVar, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0237o)) {
            return false;
        }
        C0237o c0237o = (C0237o) obj;
        if (kotlin.jvm.internal.h.a(this.f3001a, c0237o.f3001a) && kotlin.jvm.internal.h.a(this.f3002b, c0237o.f3002b) && kotlin.jvm.internal.h.a(this.f3003c, c0237o.f3003c) && kotlin.jvm.internal.h.a(this.f3004d, c0237o.f3004d) && kotlin.jvm.internal.h.a(this.f3005e, c0237o.f3005e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i2 = 0;
        Object obj = this.f3001a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i3 = hashCode * 31;
        C0227e c0227e = this.f3002b;
        if (c0227e == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = c0227e.hashCode();
        }
        int i4 = (i3 + hashCode2) * 31;
        c1.q qVar = this.f3003c;
        if (qVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = qVar.hashCode();
        }
        int i5 = (i4 + hashCode3) * 31;
        Object obj2 = this.f3004d;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int i6 = (i5 + hashCode4) * 31;
        Throwable th = this.f3005e;
        if (th != null) {
            i2 = th.hashCode();
        }
        return i6 + i2;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f3001a + ", cancelHandler=" + this.f3002b + ", onCancellation=" + this.f3003c + ", idempotentResume=" + this.f3004d + ", cancelCause=" + this.f3005e + ')';
    }

    public /* synthetic */ C0237o(Object obj, C0227e c0227e, c1.q qVar, CancellationException cancellationException, int i2) {
        this(obj, (i2 & 2) != 0 ? null : c0227e, (i2 & 4) != 0 ? null : qVar, (Object) null, (i2 & 16) != 0 ? null : cancellationException);
    }
}
