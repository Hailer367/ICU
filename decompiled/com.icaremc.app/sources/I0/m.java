package I0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final F0.c f839a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f840b;

    public m(F0.c cVar, byte[] bArr) {
        if (cVar != null) {
            if (bArr != null) {
                this.f839a = cVar;
                this.f840b = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (!this.f839a.equals(mVar.f839a)) {
            return false;
        }
        return Arrays.equals(this.f840b, mVar.f840b);
    }

    public final int hashCode() {
        return ((this.f839a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f840b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f839a + ", bytes=[...]}";
    }
}
