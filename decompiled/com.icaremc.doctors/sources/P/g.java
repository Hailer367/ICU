package P;

import com.google.android.gms.common.api.Api;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class g extends b {
    public g(byte[] bArr) {
        super(bArr);
        this.f640c.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final void b(long j2) {
        int i2 = this.f641d;
        if (i2 > j2) {
            this.f641d = 0;
            this.f640c.reset();
        } else {
            j2 -= i2;
        }
        a((int) j2);
    }

    public g(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f640c.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
