package l2;

import android.media.MediaDataSource;

/* renamed from: l2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0436c extends MediaDataSource {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ byte[] f5123f;

    public C0436c(byte[] bArr) {
        this.f5123f = bArr;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f5123f.length;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i4, int i5) {
        byte[] bArr2 = this.f5123f;
        if (j4 >= bArr2.length) {
            return -1;
        }
        if (i5 + j4 > bArr2.length) {
            i5 = (int) (bArr2.length - j4);
        }
        System.arraycopy(bArr2, (int) j4, bArr, i4, i5);
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
