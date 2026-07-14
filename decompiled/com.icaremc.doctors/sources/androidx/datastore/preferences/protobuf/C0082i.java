package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.firebase.encoders.json.BuildConfig;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0082i extends AbstractC0083j {

    /* renamed from: c, reason: collision with root package name */
    public final FileInputStream f1429c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f1430d;

    /* renamed from: e, reason: collision with root package name */
    public int f1431e;

    /* renamed from: f, reason: collision with root package name */
    public int f1432f;

    /* renamed from: g, reason: collision with root package name */
    public int f1433g;

    /* renamed from: h, reason: collision with root package name */
    public int f1434h;

    /* renamed from: i, reason: collision with root package name */
    public int f1435i;

    /* renamed from: j, reason: collision with root package name */
    public int f1436j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public C0082i(FileInputStream fileInputStream) {
        Charset charset = AbstractC0097y.f1494a;
        this.f1429c = fileInputStream;
        this.f1430d = new byte[4096];
        this.f1431e = 0;
        this.f1433g = 0;
        this.f1435i = 0;
    }

    public final byte[] A(int i2) {
        if (i2 == 0) {
            return AbstractC0097y.f1495b;
        }
        if (i2 >= 0) {
            int i3 = this.f1435i;
            int i4 = this.f1433g;
            int i5 = i3 + i4 + i2;
            if (i5 - Api.BaseClientBuilder.API_PRIORITY_OTHER <= 0) {
                int i6 = this.f1436j;
                if (i5 <= i6) {
                    int i7 = this.f1431e - i4;
                    int i8 = i2 - i7;
                    FileInputStream fileInputStream = this.f1429c;
                    if (i8 >= 4096) {
                        try {
                            if (i8 > fileInputStream.available()) {
                                return null;
                            }
                        } catch (A e2) {
                            e2.f1326c = true;
                            throw e2;
                        }
                    }
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f1430d, this.f1433g, bArr, 0, i7);
                    this.f1435i += this.f1431e;
                    this.f1433g = 0;
                    this.f1431e = 0;
                    while (i7 < i2) {
                        try {
                            int read = fileInputStream.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.f1435i += read;
                                i7 += read;
                            } else {
                                throw A.e();
                            }
                        } catch (A e3) {
                            e3.f1326c = true;
                            throw e3;
                        }
                    }
                    return bArr;
                }
                J((i6 - i3) - i4);
                throw A.e();
            }
            throw new IOException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        throw A.d();
    }

    public final ArrayList B(int i2) {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int min = Math.min(i2, 4096);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.f1429c.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.f1435i += read;
                    i3 += read;
                } else {
                    throw A.e();
                }
            }
            i2 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int C() {
        int i2 = this.f1433g;
        if (this.f1431e - i2 < 4) {
            I(4);
            i2 = this.f1433g;
        }
        this.f1433g = i2 + 4;
        byte[] bArr = this.f1430d;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long D() {
        int i2 = this.f1433g;
        if (this.f1431e - i2 < 8) {
            I(8);
            i2 = this.f1433g;
        }
        this.f1433g = i2 + 8;
        byte[] bArr = this.f1430d;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public final int E() {
        int i2;
        int i3 = this.f1433g;
        int i4 = this.f1431e;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f1430d;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f1433g = i5;
                return b2;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b2;
                if (i7 < 0) {
                    i2 = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i2 = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i2 = (-2080896) ^ i11;
                        } else {
                            i8 = i3 + 5;
                            byte b3 = bArr[i10];
                            int i12 = (i11 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i2 = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i12;
                            }
                            i2 = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.f1433g = i6;
                return i2;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j2;
        long j3;
        long j4;
        long j5;
        int i2 = this.f1433g;
        int i3 = this.f1431e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.f1430d;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f1433g = i4;
                return b2;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b2;
                if (i6 < 0) {
                    j2 = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                        i5 = i7;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            j5 = (-2080896) ^ i10;
                        } else {
                            long j6 = i10;
                            i5 = i2 + 5;
                            long j7 = j6 ^ (bArr[i9] << 28);
                            if (j7 >= 0) {
                                j4 = 266354560;
                            } else {
                                i9 = i2 + 6;
                                long j8 = j7 ^ (bArr[i5] << 35);
                                if (j8 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i2 + 7;
                                    j7 = j8 ^ (bArr[i9] << 42);
                                    if (j7 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i9 = i2 + 8;
                                        j8 = j7 ^ (bArr[i5] << 49);
                                        if (j8 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i2 + 9;
                                            long j9 = (j8 ^ (bArr[i9] << 56)) ^ 71499008037633920L;
                                            if (j9 < 0) {
                                                int i11 = i2 + 10;
                                                if (bArr[i5] >= 0) {
                                                    i5 = i11;
                                                }
                                            }
                                            j2 = j9;
                                        }
                                    }
                                }
                                j5 = j3 ^ j8;
                            }
                            j2 = j4 ^ j7;
                        }
                        i5 = i9;
                        j2 = j5;
                    }
                }
                this.f1433g = i5;
                return j2;
            }
        }
        return G();
    }

    public final long G() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            if (this.f1433g == this.f1431e) {
                I(1);
            }
            int i3 = this.f1433g;
            this.f1433g = i3 + 1;
            j2 |= (r3 & Byte.MAX_VALUE) << i2;
            if ((this.f1430d[i3] & 128) == 0) {
                return j2;
            }
        }
        throw A.c();
    }

    public final void H() {
        int i2 = this.f1431e + this.f1432f;
        this.f1431e = i2;
        int i3 = this.f1435i + i2;
        int i4 = this.f1436j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f1432f = i5;
            this.f1431e = i2 - i5;
            return;
        }
        this.f1432f = 0;
    }

    public final void I(int i2) {
        if (!K(i2)) {
            if (i2 > (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f1435i) - this.f1433g) {
                throw new IOException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw A.e();
        }
    }

    public final void J(int i2) {
        int i3 = this.f1431e;
        int i4 = this.f1433g;
        int i5 = i3 - i4;
        if (i2 <= i5 && i2 >= 0) {
            this.f1433g = i4 + i2;
            return;
        }
        FileInputStream fileInputStream = this.f1429c;
        if (i2 >= 0) {
            int i6 = this.f1435i;
            int i7 = i6 + i4;
            int i8 = i7 + i2;
            int i9 = this.f1436j;
            if (i8 <= i9) {
                this.f1435i = i7;
                this.f1431e = 0;
                this.f1433g = 0;
                while (i5 < i2) {
                    long j2 = i2 - i5;
                    try {
                        try {
                            long skip = fileInputStream.skip(j2);
                            if (skip >= 0 && skip <= j2) {
                                if (skip == 0) {
                                    break;
                                } else {
                                    i5 += (int) skip;
                                }
                            } else {
                                throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                            }
                        } catch (A e2) {
                            e2.f1326c = true;
                            throw e2;
                        }
                    } catch (Throwable th) {
                        this.f1435i += i5;
                        H();
                        throw th;
                    }
                }
                this.f1435i += i5;
                H();
                if (i5 < i2) {
                    int i10 = this.f1431e;
                    int i11 = i10 - this.f1433g;
                    this.f1433g = i10;
                    I(1);
                    while (true) {
                        int i12 = i2 - i11;
                        int i13 = this.f1431e;
                        if (i12 > i13) {
                            i11 += i13;
                            this.f1433g = i13;
                            I(1);
                        } else {
                            this.f1433g = i12;
                            return;
                        }
                    }
                }
            } else {
                J((i9 - i6) - i4);
                throw A.e();
            }
        } else {
            throw A.d();
        }
    }

    public final boolean K(int i2) {
        FileInputStream fileInputStream = this.f1429c;
        int i3 = this.f1433g;
        int i4 = i3 + i2;
        int i5 = this.f1431e;
        if (i4 > i5) {
            int i6 = this.f1435i;
            if (i2 <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i3 && i6 + i3 + i2 <= this.f1436j) {
                byte[] bArr = this.f1430d;
                if (i3 > 0) {
                    if (i5 > i3) {
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.f1435i += i3;
                    this.f1431e -= i3;
                    this.f1433g = 0;
                }
                int i7 = this.f1431e;
                try {
                    int read = fileInputStream.read(bArr, i7, Math.min(bArr.length - i7, (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f1435i) - i7));
                    if (read != 0 && read >= -1 && read <= bArr.length) {
                        if (read > 0) {
                            this.f1431e += read;
                            H();
                            if (this.f1431e >= i2) {
                                return true;
                            }
                            return K(i2);
                        }
                    } else {
                        throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                    }
                } catch (A e2) {
                    e2.f1326c = true;
                    throw e2;
                }
            }
            return false;
        }
        throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final void a(int i2) {
        if (this.f1434h == i2) {
        } else {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int b() {
        return this.f1435i + this.f1433g;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final boolean c() {
        if (this.f1433g == this.f1431e && !K(1)) {
            return true;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final void d(int i2) {
        this.f1436j = i2;
        H();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int e(int i2) {
        if (i2 >= 0) {
            int i3 = this.f1435i + this.f1433g + i2;
            if (i3 >= 0) {
                int i4 = this.f1436j;
                if (i3 <= i4) {
                    this.f1436j = i3;
                    H();
                    return i4;
                }
                throw A.e();
            }
            throw new IOException("Failed to parse the message.");
        }
        throw A.d();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final boolean f() {
        if (F() != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final C0080g g() {
        int E2 = E();
        int i2 = this.f1431e;
        int i3 = this.f1433g;
        int i4 = i2 - i3;
        byte[] bArr = this.f1430d;
        if (E2 <= i4 && E2 > 0) {
            C0080g c2 = C0080g.c(bArr, i3, E2);
            this.f1433g += E2;
            return c2;
        }
        if (E2 == 0) {
            return C0080g.f1417e;
        }
        if (E2 >= 0) {
            byte[] A2 = A(E2);
            if (A2 != null) {
                return C0080g.c(A2, 0, A2.length);
            }
            int i5 = this.f1433g;
            int i6 = this.f1431e;
            int i7 = i6 - i5;
            this.f1435i += i6;
            this.f1433g = 0;
            this.f1431e = 0;
            ArrayList B2 = B(E2 - i7);
            byte[] bArr2 = new byte[E2];
            System.arraycopy(bArr, i5, bArr2, 0, i7);
            int size = B2.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = B2.get(i8);
                i8++;
                byte[] bArr3 = (byte[]) obj;
                System.arraycopy(bArr3, 0, bArr2, i7, bArr3.length);
                i7 += bArr3.length;
            }
            C0080g c0080g = C0080g.f1417e;
            return new C0080g(bArr2);
        }
        throw A.d();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final double h() {
        return Double.longBitsToDouble(D());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int i() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int j() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long k() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final float l() {
        return Float.intBitsToFloat(C());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int m() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long n() {
        return F();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int o() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long p() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int q() {
        int E2 = E();
        return (-(E2 & 1)) ^ (E2 >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long r() {
        long F2 = F();
        return (-(F2 & 1)) ^ (F2 >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final String s() {
        int E2 = E();
        byte[] bArr = this.f1430d;
        if (E2 > 0) {
            int i2 = this.f1431e;
            int i3 = this.f1433g;
            if (E2 <= i2 - i3) {
                String str = new String(bArr, i3, E2, AbstractC0097y.f1494a);
                this.f1433g += E2;
                return str;
            }
        }
        if (E2 == 0) {
            return BuildConfig.FLAVOR;
        }
        if (E2 >= 0) {
            if (E2 <= this.f1431e) {
                I(E2);
                String str2 = new String(bArr, this.f1433g, E2, AbstractC0097y.f1494a);
                this.f1433g += E2;
                return str2;
            }
            return new String(z(E2), AbstractC0097y.f1494a);
        }
        throw A.d();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final String t() {
        int E2 = E();
        int i2 = this.f1433g;
        int i3 = this.f1431e;
        int i4 = i3 - i2;
        byte[] bArr = this.f1430d;
        if (E2 <= i4 && E2 > 0) {
            this.f1433g = i2 + E2;
        } else {
            if (E2 == 0) {
                return BuildConfig.FLAVOR;
            }
            if (E2 >= 0) {
                i2 = 0;
                if (E2 <= i3) {
                    I(E2);
                    this.f1433g = E2;
                } else {
                    bArr = z(E2);
                }
            } else {
                throw A.d();
            }
        }
        return m0.f1459a.p(bArr, i2, E2);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int u() {
        if (c()) {
            this.f1434h = 0;
            return 0;
        }
        int E2 = E();
        this.f1434h = E2;
        if ((E2 >>> 3) != 0) {
            return E2;
        }
        throw new IOException("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int v() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long w() {
        return F();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final boolean x(int i2) {
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return false;
                        }
                        if (i3 == 5) {
                            J(4);
                            return true;
                        }
                        throw A.b();
                    }
                    y();
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                }
                J(E());
                return true;
            }
            J(8);
            return true;
        }
        int i5 = this.f1431e - this.f1433g;
        byte[] bArr = this.f1430d;
        if (i5 >= 10) {
            while (i4 < 10) {
                int i6 = this.f1433g;
                this.f1433g = i6 + 1;
                if (bArr[i6] < 0) {
                    i4++;
                }
            }
            throw A.c();
        }
        while (i4 < 10) {
            if (this.f1433g == this.f1431e) {
                I(1);
            }
            int i7 = this.f1433g;
            this.f1433g = i7 + 1;
            if (bArr[i7] < 0) {
                i4++;
            }
        }
        throw A.c();
        return true;
    }

    public final byte[] z(int i2) {
        byte[] A2 = A(i2);
        if (A2 != null) {
            return A2;
        }
        int i3 = this.f1433g;
        int i4 = this.f1431e;
        int i5 = i4 - i3;
        this.f1435i += i4;
        this.f1433g = 0;
        this.f1431e = 0;
        ArrayList B2 = B(i2 - i5);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f1430d, i3, bArr, 0, i5);
        int size = B2.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = B2.get(i6);
            i6++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return bArr;
    }
}
