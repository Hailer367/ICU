package v0;

import android.util.Base64;
import com.google.firebase.encoders.json.BuildConfig;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f3913a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3914b;

    /* renamed from: c, reason: collision with root package name */
    public final s0.d f3915c;

    public j(String str, byte[] bArr, s0.d dVar) {
        this.f3913a = str;
        this.f3914b = bArr;
        this.f3915c = dVar;
    }

    public static A0.g a() {
        A0.g gVar = new A0.g();
        gVar.f32f = s0.d.f3585c;
        return gVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f3913a.equals(jVar.f3913a) && Arrays.equals(this.f3914b, jVar.f3914b) && this.f3915c.equals(jVar.f3915c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f3913a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3914b)) * 1000003) ^ this.f3915c.hashCode();
    }

    public final String toString() {
        String encodeToString;
        byte[] bArr = this.f3914b;
        if (bArr == null) {
            encodeToString = BuildConfig.FLAVOR;
        } else {
            encodeToString = Base64.encodeToString(bArr, 2);
        }
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.f3913a);
        sb.append(", ");
        sb.append(this.f3915c);
        sb.append(", ");
        return O.a.i(sb, encodeToString, ")");
    }
}
