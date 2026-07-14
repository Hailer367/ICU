package W;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class g extends b {
    public g(byte[] bArr) {
        super(bArr);
        this.f1775f.mark(Integer.MAX_VALUE);
    }

    public final void b(long j4) {
        int i4 = this.f1776g;
        if (i4 > j4) {
            this.f1776g = 0;
            this.f1775f.reset();
        } else {
            j4 -= i4;
        }
        a((int) j4);
    }

    public g(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f1775f.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
