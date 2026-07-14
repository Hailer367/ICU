package W0;

import Z0.r;
import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c extends AbstractC0142a {
    public static final Parcelable.Creator<c> CREATOR = new L.g(4);

    /* renamed from: f, reason: collision with root package name */
    public final String f1855f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1856g;

    /* renamed from: h, reason: collision with root package name */
    public final long f1857h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1858i;

    public c(String str, int i4, long j4, boolean z) {
        this.f1855f = str;
        this.f1856g = i4;
        this.f1857h = j4;
        this.f1858i = z;
    }

    public final long a() {
        long j4 = this.f1857h;
        if (j4 == -1) {
            return this.f1856g;
        }
        return j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (r.g(this.f1855f, cVar.f1855f) && a() == cVar.a() && this.f1858i == cVar.f1858i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1855f, Long.valueOf(a()), Boolean.valueOf(this.f1858i)});
    }

    public final String toString() {
        E0.a aVar = new E0.a(this);
        aVar.e(this.f1855f, "name");
        aVar.e(Long.valueOf(a()), "version");
        aVar.e(Boolean.valueOf(this.f1858i), "is_fully_rolled_out");
        return aVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.M(parcel, 1, this.f1855f);
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(this.f1856g);
        long a4 = a();
        AbstractC0141a.P(parcel, 3, 8);
        parcel.writeLong(a4);
        AbstractC0141a.P(parcel, 4, 4);
        parcel.writeInt(this.f1858i ? 1 : 0);
        AbstractC0141a.S(parcel, Q2);
    }

    public c(String str) {
        this(str, -1, 1L, false);
    }
}
