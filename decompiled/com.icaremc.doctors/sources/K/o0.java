package K;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class o0 extends OutputStream {

    /* renamed from: c, reason: collision with root package name */
    public final FileOutputStream f534c;

    public o0(FileOutputStream fileOutputStream) {
        this.f534c = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f534c.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        this.f534c.write(i2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b2) {
        kotlin.jvm.internal.h.e(b2, "b");
        this.f534c.write(b2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i2, int i3) {
        kotlin.jvm.internal.h.e(bytes, "bytes");
        this.f534c.write(bytes, i2, i3);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
