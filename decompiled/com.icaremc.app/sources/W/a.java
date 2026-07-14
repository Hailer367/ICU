package W;

import android.media.MediaDataSource;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* renamed from: f, reason: collision with root package name */
    public long f1773f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f1774g;

    public a(g gVar) {
        this.f1774g = gVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        if (j4 < 0) {
            return -1;
        }
        try {
            long j5 = this.f1773f;
            g gVar = this.f1774g;
            if (j5 != j4) {
                if (j5 >= 0 && j4 >= j5 + gVar.f1775f.available()) {
                    return -1;
                }
                gVar.b(j4);
                this.f1773f = j4;
            }
            if (i5 > gVar.f1775f.available()) {
                i5 = gVar.f1775f.available();
            }
            int read = gVar.read(bArr, i4, i5);
            if (read >= 0) {
                this.f1773f += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f1773f = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
