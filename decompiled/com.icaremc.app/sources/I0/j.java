package I0;

import A2.t;
import android.util.Base64;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f831a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f832b;

    /* renamed from: c, reason: collision with root package name */
    public final F0.d f833c;

    public j(String str, byte[] bArr, F0.d dVar) {
        this.f831a = str;
        this.f832b = bArr;
        this.f833c = dVar;
    }

    public static t a() {
        t tVar = new t(6, false);
        tVar.f101i = F0.d.f526f;
        return tVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f831a.equals(jVar.f831a) && Arrays.equals(this.f832b, jVar.f832b) && this.f833c.equals(jVar.f833c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f831a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f832b)) * 1000003) ^ this.f833c.hashCode();
    }

    public final String toString() {
        String encodeToString;
        byte[] bArr = this.f832b;
        if (bArr == null) {
            encodeToString = "";
        } else {
            encodeToString = Base64.encodeToString(bArr, 2);
        }
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.f831a);
        sb.append(", ");
        sb.append(this.f833c);
        sb.append(", ");
        return r2.k.c(sb, encodeToString, ")");
    }
}
