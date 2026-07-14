package v0;

import java.util.Arrays;
import s0.C0301c;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final C0301c f3922a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3923b;

    public m(C0301c c0301c, byte[] bArr) {
        if (c0301c != null) {
            if (bArr != null) {
                this.f3922a = c0301c;
                this.f3923b = bArr;
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
        if (!this.f3922a.equals(mVar.f3922a)) {
            return false;
        }
        return Arrays.equals(this.f3923b, mVar.f3923b);
    }

    public final int hashCode() {
        return ((this.f3922a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3923b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f3922a + ", bytes=[...]}";
    }
}
