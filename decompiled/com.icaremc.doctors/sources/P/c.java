package P;

import io.flutter.embedding.android.KeyboardMap;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class c extends FilterOutputStream {

    /* renamed from: c, reason: collision with root package name */
    public final DataOutputStream f645c;

    /* renamed from: d, reason: collision with root package name */
    public ByteOrder f646d;

    public c(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f645c = new DataOutputStream(outputStream);
        this.f646d = byteOrder;
    }

    public final void a(int i2) {
        this.f645c.write(i2);
    }

    public final void b(int i2) {
        ByteOrder byteOrder = this.f646d;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        DataOutputStream dataOutputStream = this.f645c;
        if (byteOrder == byteOrder2) {
            dataOutputStream.write(i2 & 255);
            dataOutputStream.write((i2 >>> 8) & 255);
            dataOutputStream.write((i2 >>> 16) & 255);
            dataOutputStream.write((i2 >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            dataOutputStream.write((i2 >>> 24) & 255);
            dataOutputStream.write((i2 >>> 16) & 255);
            dataOutputStream.write((i2 >>> 8) & 255);
            dataOutputStream.write(i2 & 255);
        }
    }

    public final void c(short s2) {
        ByteOrder byteOrder = this.f646d;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        DataOutputStream dataOutputStream = this.f645c;
        if (byteOrder == byteOrder2) {
            dataOutputStream.write(s2 & 255);
            dataOutputStream.write((s2 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            dataOutputStream.write((s2 >>> 8) & 255);
            dataOutputStream.write(s2 & 255);
        }
    }

    public final void d(long j2) {
        if (j2 <= KeyboardMap.kValueMask) {
            b((int) j2);
            return;
        }
        throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
    }

    public final void e(int i2) {
        if (i2 <= 65535) {
            c((short) i2);
            return;
        }
        throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f645c.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        this.f645c.write(bArr, i2, i3);
    }
}
