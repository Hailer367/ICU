package P;

import android.media.MediaDataSource;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* renamed from: c, reason: collision with root package name */
    public long f638c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f639d;

    public a(g gVar) {
        this.f639d = gVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j2, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (j2 < 0) {
            return -1;
        }
        try {
            long j3 = this.f638c;
            g gVar = this.f639d;
            if (j3 != j2) {
                if (j3 >= 0 && j2 >= j3 + gVar.f640c.available()) {
                    return -1;
                }
                gVar.b(j2);
                this.f638c = j2;
            }
            if (i3 > gVar.f640c.available()) {
                i3 = gVar.f640c.available();
            }
            int read = gVar.read(bArr, i2, i3);
            if (read >= 0) {
                this.f638c += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f638c = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
