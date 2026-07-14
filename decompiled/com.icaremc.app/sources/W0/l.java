package W0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l extends k {

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f1876h;

    public l(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f1876h = bArr;
    }

    @Override // W0.k
    public final byte[] i() {
        return this.f1876h;
    }
}
