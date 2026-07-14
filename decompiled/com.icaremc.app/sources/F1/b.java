package F1;

import java.io.OutputStream;

/* loaded from: classes.dex */
public final class b extends OutputStream {

    /* renamed from: f, reason: collision with root package name */
    public long f531f;

    @Override // java.io.OutputStream
    public final void write(int i4) {
        this.f531f++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f531f += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i4, int i5) {
        int i6;
        if (i4 >= 0 && i4 <= bArr.length && i5 >= 0 && (i6 = i4 + i5) <= bArr.length && i6 >= 0) {
            this.f531f += i5;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
