package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.firebase.encoders.json.BuildConfig;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0081h extends AbstractC0083j {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f1422c;

    /* renamed from: d, reason: collision with root package name */
    public int f1423d;

    /* renamed from: e, reason: collision with root package name */
    public int f1424e;

    /* renamed from: f, reason: collision with root package name */
    public int f1425f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1426g;

    /* renamed from: h, reason: collision with root package name */
    public int f1427h;

    /* renamed from: i, reason: collision with root package name */
    public int f1428i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public C0081h(byte[] bArr, int i2, int i3, boolean z) {
        this.f1422c = bArr;
        this.f1423d = i3 + i2;
        this.f1425f = i2;
        this.f1426g = i2;
    }

    public final long A() {
        int i2 = this.f1425f;
        if (this.f1423d - i2 >= 8) {
            this.f1425f = i2 + 8;
            byte[] bArr = this.f1422c;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }
        throw A.e();
    }

    public final int B() {
        int i2;
        int i3 = this.f1425f;
        int i4 = this.f1423d;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f1422c;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f1425f = i5;
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
                this.f1425f = i6;
                return i2;
            }
        }
        return (int) D();
    }

    public final long C() {
        long j2;
        long j3;
        long j4;
        long j5;
        int i2 = this.f1425f;
        int i3 = this.f1423d;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.f1422c;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f1425f = i4;
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
                this.f1425f = i5;
                return j2;
            }
        }
        return D();
    }

    public final long D() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            int i3 = this.f1425f;
            if (i3 != this.f1423d) {
                this.f1425f = i3 + 1;
                j2 |= (r3 & Byte.MAX_VALUE) << i2;
                if ((this.f1422c[i3] & 128) == 0) {
                    return j2;
                }
            } else {
                throw A.e();
            }
        }
        throw A.c();
    }

    public final void E() {
        int i2 = this.f1423d + this.f1424e;
        this.f1423d = i2;
        int i3 = i2 - this.f1426g;
        int i4 = this.f1428i;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f1424e = i5;
            this.f1423d = i2 - i5;
            return;
        }
        this.f1424e = 0;
    }

    public final void F(int i2) {
        if (i2 >= 0) {
            int i3 = this.f1423d;
            int i4 = this.f1425f;
            if (i2 <= i3 - i4) {
                this.f1425f = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw A.d();
        }
        throw A.e();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final void a(int i2) {
        if (this.f1427h == i2) {
        } else {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int b() {
        return this.f1425f - this.f1426g;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final boolean c() {
        if (this.f1425f == this.f1423d) {
            return true;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final void d(int i2) {
        this.f1428i = i2;
        E();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int e(int i2) {
        if (i2 >= 0) {
            int b2 = b() + i2;
            if (b2 >= 0) {
                int i3 = this.f1428i;
                if (b2 <= i3) {
                    this.f1428i = b2;
                    E();
                    return i3;
                }
                throw A.e();
            }
            throw new IOException("Failed to parse the message.");
        }
        throw A.d();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final boolean f() {
        if (C() != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final C0080g g() {
        byte[] bArr;
        int B2 = B();
        byte[] bArr2 = this.f1422c;
        if (B2 > 0) {
            int i2 = this.f1423d;
            int i3 = this.f1425f;
            if (B2 <= i2 - i3) {
                C0080g c2 = C0080g.c(bArr2, i3, B2);
                this.f1425f += B2;
                return c2;
            }
        }
        if (B2 == 0) {
            return C0080g.f1417e;
        }
        if (B2 > 0) {
            int i4 = this.f1423d;
            int i5 = this.f1425f;
            if (B2 <= i4 - i5) {
                int i6 = B2 + i5;
                this.f1425f = i6;
                bArr = Arrays.copyOfRange(bArr2, i5, i6);
                C0080g c0080g = C0080g.f1417e;
                return new C0080g(bArr);
            }
        }
        if (B2 <= 0) {
            if (B2 == 0) {
                bArr = AbstractC0097y.f1495b;
                C0080g c0080g2 = C0080g.f1417e;
                return new C0080g(bArr);
            }
            throw A.d();
        }
        throw A.e();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final double h() {
        return Double.longBitsToDouble(A());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int i() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int j() {
        return z();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long k() {
        return A();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final float l() {
        return Float.intBitsToFloat(z());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int m() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long n() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int o() {
        return z();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long p() {
        return A();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int q() {
        int B2 = B();
        return (-(B2 & 1)) ^ (B2 >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long r() {
        long C2 = C();
        return (-(C2 & 1)) ^ (C2 >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final String s() {
        int B2 = B();
        if (B2 > 0) {
            int i2 = this.f1423d;
            int i3 = this.f1425f;
            if (B2 <= i2 - i3) {
                String str = new String(this.f1422c, i3, B2, AbstractC0097y.f1494a);
                this.f1425f += B2;
                return str;
            }
        }
        if (B2 == 0) {
            return BuildConfig.FLAVOR;
        }
        if (B2 < 0) {
            throw A.d();
        }
        throw A.e();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final String t() {
        int B2 = B();
        if (B2 > 0) {
            int i2 = this.f1423d;
            int i3 = this.f1425f;
            if (B2 <= i2 - i3) {
                String p = m0.f1459a.p(this.f1422c, i3, B2);
                this.f1425f += B2;
                return p;
            }
        }
        if (B2 == 0) {
            return BuildConfig.FLAVOR;
        }
        if (B2 <= 0) {
            throw A.d();
        }
        throw A.e();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int u() {
        if (c()) {
            this.f1427h = 0;
            return 0;
        }
        int B2 = B();
        this.f1427h = B2;
        if ((B2 >>> 3) != 0) {
            return B2;
        }
        throw new IOException("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final int v() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0083j
    public final long w() {
        return C();
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
                            F(4);
                            return true;
                        }
                        throw A.b();
                    }
                    y();
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                }
                F(B());
                return true;
            }
            F(8);
            return true;
        }
        int i5 = this.f1423d - this.f1425f;
        byte[] bArr = this.f1422c;
        if (i5 >= 10) {
            while (i4 < 10) {
                int i6 = this.f1425f;
                this.f1425f = i6 + 1;
                if (bArr[i6] < 0) {
                    i4++;
                }
            }
            throw A.c();
        }
        while (i4 < 10) {
            int i7 = this.f1425f;
            if (i7 != this.f1423d) {
                this.f1425f = i7 + 1;
                if (bArr[i7] < 0) {
                    i4++;
                }
            } else {
                throw A.e();
            }
        }
        throw A.c();
        return true;
    }

    public final int z() {
        int i2 = this.f1425f;
        if (this.f1423d - i2 >= 4) {
            this.f1425f = i2 + 4;
            byte[] bArr = this.f1422c;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw A.e();
    }
}
