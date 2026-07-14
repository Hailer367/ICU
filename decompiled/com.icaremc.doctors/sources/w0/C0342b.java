package w0;

import android.content.Context;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0342b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3948a;

    /* renamed from: b, reason: collision with root package name */
    public final A0.f f3949b;

    /* renamed from: c, reason: collision with root package name */
    public final A0.f f3950c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3951d;

    public C0342b(Context context, A0.f fVar, A0.f fVar2, String str) {
        if (context != null) {
            this.f3948a = context;
            if (fVar != null) {
                this.f3949b = fVar;
                if (fVar2 != null) {
                    this.f3950c = fVar2;
                    if (str != null) {
                        this.f3951d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f3948a.equals(((C0342b) cVar).f3948a)) {
                C0342b c0342b = (C0342b) cVar;
                if (this.f3949b.equals(c0342b.f3949b) && this.f3950c.equals(c0342b.f3950c) && this.f3951d.equals(c0342b.f3951d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f3948a.hashCode() ^ 1000003) * 1000003) ^ this.f3949b.hashCode()) * 1000003) ^ this.f3950c.hashCode()) * 1000003) ^ this.f3951d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f3948a);
        sb.append(", wallClock=");
        sb.append(this.f3949b);
        sb.append(", monotonicClock=");
        sb.append(this.f3950c);
        sb.append(", backendName=");
        return O.a.i(sb, this.f3951d, "}");
    }
}
