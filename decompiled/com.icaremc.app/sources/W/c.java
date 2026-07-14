package W;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class c extends FilterOutputStream {

    /* renamed from: f, reason: collision with root package name */
    public final DataOutputStream f1780f;

    /* renamed from: g, reason: collision with root package name */
    public ByteOrder f1781g;

    public c(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f1780f = new DataOutputStream(outputStream);
        this.f1781g = byteOrder;
    }

    public final void a(int i4) {
        this.f1780f.write(i4);
    }

    public final void b(int i4) {
        ByteOrder byteOrder = this.f1781g;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        DataOutputStream dataOutputStream = this.f1780f;
        if (byteOrder == byteOrder2) {
            dataOutputStream.write(i4 & 255);
            dataOutputStream.write((i4 >>> 8) & 255);
            dataOutputStream.write((i4 >>> 16) & 255);
            dataOutputStream.write((i4 >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            dataOutputStream.write((i4 >>> 24) & 255);
            dataOutputStream.write((i4 >>> 16) & 255);
            dataOutputStream.write((i4 >>> 8) & 255);
            dataOutputStream.write(i4 & 255);
        }
    }

    public final void c(short s3) {
        ByteOrder byteOrder = this.f1781g;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        DataOutputStream dataOutputStream = this.f1780f;
        if (byteOrder == byteOrder2) {
            dataOutputStream.write(s3 & 255);
            dataOutputStream.write((s3 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            dataOutputStream.write((s3 >>> 8) & 255);
            dataOutputStream.write(s3 & 255);
        }
    }

    public final void d(long j4) {
        if (j4 <= 4294967295L) {
            b((int) j4);
            return;
        }
        throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
    }

    public final void e(int i4) {
        if (i4 <= 65535) {
            c((short) i4);
            return;
        }
        throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f1780f.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i4, int i5) {
        this.f1780f.write(bArr, i4, i5);
    }
}
