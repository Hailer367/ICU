package O;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class l0 extends OutputStream {

    /* renamed from: f, reason: collision with root package name */
    public final FileOutputStream f1220f;

    public l0(FileOutputStream fileOutputStream) {
        this.f1220f = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f1220f.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i4) {
        this.f1220f.write(i4);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        T2.h.e(bArr, "b");
        this.f1220f.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i4, int i5) {
        T2.h.e(bArr, "bytes");
        this.f1220f.write(bArr, i4, i5);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
