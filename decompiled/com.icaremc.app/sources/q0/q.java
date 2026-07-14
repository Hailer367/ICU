package q0;

import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* loaded from: classes.dex */
public final class q implements WebMessagePayloadBoundaryInterface {

    /* renamed from: a, reason: collision with root package name */
    public final int f5886a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5887b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f5888c;

    public q(String str) {
        this.f5886a = 0;
        this.f5887b = str;
        this.f5888c = null;
    }

    public final void a(int i4) {
        int i5 = this.f5886a;
        if (i5 == i4) {
        } else {
            throw new IllegalStateException(A2.i.h("Expected ", ", but type is ", i4, i5));
        }
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final byte[] getAsArrayBuffer() {
        a(1);
        byte[] bArr = this.f5888c;
        Objects.requireNonNull(bArr);
        return bArr;
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final String getAsString() {
        a(0);
        return this.f5887b;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return new String[0];
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final int getType() {
        return this.f5886a;
    }

    public q(byte[] bArr) {
        this.f5886a = 1;
        this.f5887b = null;
        this.f5888c = bArr;
    }
}
