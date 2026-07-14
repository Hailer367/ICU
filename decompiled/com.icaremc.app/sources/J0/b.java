package J0;

import android.content.Context;
import r2.k;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f878a;

    /* renamed from: b, reason: collision with root package name */
    public final R0.a f879b;

    /* renamed from: c, reason: collision with root package name */
    public final R0.a f880c;

    /* renamed from: d, reason: collision with root package name */
    public final String f881d;

    public b(Context context, R0.a aVar, R0.a aVar2, String str) {
        if (context != null) {
            this.f878a = context;
            if (aVar != null) {
                this.f879b = aVar;
                if (aVar2 != null) {
                    this.f880c = aVar2;
                    if (str != null) {
                        this.f881d = str;
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
            if (this.f878a.equals(((b) cVar).f878a)) {
                b bVar = (b) cVar;
                if (this.f879b.equals(bVar.f879b) && this.f880c.equals(bVar.f880c) && this.f881d.equals(bVar.f881d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f878a.hashCode() ^ 1000003) * 1000003) ^ this.f879b.hashCode()) * 1000003) ^ this.f880c.hashCode()) * 1000003) ^ this.f881d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f878a);
        sb.append(", wallClock=");
        sb.append(this.f879b);
        sb.append(", monotonicClock=");
        sb.append(this.f880c);
        sb.append(", backendName=");
        return k.c(sb, this.f881d, "}");
    }
}
