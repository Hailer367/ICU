package P1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: P1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0100d extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    public long f1407f;

    /* renamed from: g, reason: collision with root package name */
    public long f1408g;

    public C0100d(InputStream inputStream) {
        super(inputStream);
        this.f1408g = -1L;
        this.f1407f = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f1407f);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i4) {
        ((FilterInputStream) this).in.mark(i4);
        this.f1408g = this.f1407f;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (this.f1407f == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f1407f--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.f1408g != -1) {
                ((FilterInputStream) this).in.reset();
                this.f1407f = this.f1408g;
            } else {
                throw new IOException("Mark not set");
            }
        } else {
            throw new IOException("Mark not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j4, this.f1407f));
        this.f1407f -= skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i4, int i5) {
        long j4 = this.f1407f;
        if (j4 == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i4, (int) Math.min(i5, j4));
        if (read != -1) {
            this.f1407f -= read;
        }
        return read;
    }
}
