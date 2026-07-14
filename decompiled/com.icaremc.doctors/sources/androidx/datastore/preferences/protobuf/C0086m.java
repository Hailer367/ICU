package androidx.datastore.preferences.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0086m extends android.support.v4.media.session.a {

    /* renamed from: k, reason: collision with root package name */
    public static final Logger f1452k = Logger.getLogger(C0086m.class.getName());

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f1453l = j0.f1444e;

    /* renamed from: f, reason: collision with root package name */
    public F f1454f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f1455g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1456h;

    /* renamed from: i, reason: collision with root package name */
    public int f1457i;

    /* renamed from: j, reason: collision with root package name */
    public final K.o0 f1458j;

    public C0086m(K.o0 o0Var, int i2) {
        if (i2 >= 0) {
            int max = Math.max(i2, 20);
            this.f1455g = new byte[max];
            this.f1456h = max;
            this.f1458j = o0Var;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public static int S(int i2, C0080g c0080g) {
        int U2 = U(i2);
        int size = c0080g.size();
        return V(size) + size + U2;
    }

    public static int T(String str) {
        int length;
        try {
            length = m0.a(str);
        } catch (l0 unused) {
            length = str.getBytes(AbstractC0097y.f1494a).length;
        }
        return V(length) + length;
    }

    public static int U(int i2) {
        return V(i2 << 3);
    }

    public static int V(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public static int W(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    @Override // android.support.v4.media.session.a
    public final void M(byte[] bArr, int i2, int i3) {
        a0(bArr, i2, i3);
    }

    public final void N(int i2) {
        int i3 = this.f1457i;
        int i4 = i3 + 1;
        this.f1457i = i4;
        byte[] bArr = this.f1455g;
        bArr[i3] = (byte) (i2 & 255);
        int i5 = i3 + 2;
        this.f1457i = i5;
        bArr[i4] = (byte) ((i2 >> 8) & 255);
        int i6 = i3 + 3;
        this.f1457i = i6;
        bArr[i5] = (byte) ((i2 >> 16) & 255);
        this.f1457i = i3 + 4;
        bArr[i6] = (byte) ((i2 >> 24) & 255);
    }

    public final void O(long j2) {
        int i2 = this.f1457i;
        int i3 = i2 + 1;
        this.f1457i = i3;
        byte[] bArr = this.f1455g;
        bArr[i2] = (byte) (j2 & 255);
        int i4 = i2 + 2;
        this.f1457i = i4;
        bArr[i3] = (byte) ((j2 >> 8) & 255);
        int i5 = i2 + 3;
        this.f1457i = i5;
        bArr[i4] = (byte) ((j2 >> 16) & 255);
        int i6 = i2 + 4;
        this.f1457i = i6;
        bArr[i5] = (byte) (255 & (j2 >> 24));
        int i7 = i2 + 5;
        this.f1457i = i7;
        bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
        int i8 = i2 + 6;
        this.f1457i = i8;
        bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
        int i9 = i2 + 7;
        this.f1457i = i9;
        bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
        this.f1457i = i2 + 8;
        bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
    }

    public final void P(int i2, int i3) {
        Q((i2 << 3) | i3);
    }

    public final void Q(int i2) {
        boolean z = f1453l;
        byte[] bArr = this.f1455g;
        if (z) {
            while ((i2 & (-128)) != 0) {
                int i3 = this.f1457i;
                this.f1457i = i3 + 1;
                j0.j(bArr, i3, (byte) ((i2 | 128) & 255));
                i2 >>>= 7;
            }
            int i4 = this.f1457i;
            this.f1457i = i4 + 1;
            j0.j(bArr, i4, (byte) i2);
            return;
        }
        while ((i2 & (-128)) != 0) {
            int i5 = this.f1457i;
            this.f1457i = i5 + 1;
            bArr[i5] = (byte) ((i2 | 128) & 255);
            i2 >>>= 7;
        }
        int i6 = this.f1457i;
        this.f1457i = i6 + 1;
        bArr[i6] = (byte) i2;
    }

    public final void R(long j2) {
        boolean z = f1453l;
        byte[] bArr = this.f1455g;
        if (z) {
            while ((j2 & (-128)) != 0) {
                int i2 = this.f1457i;
                this.f1457i = i2 + 1;
                j0.j(bArr, i2, (byte) ((((int) j2) | 128) & 255));
                j2 >>>= 7;
            }
            int i3 = this.f1457i;
            this.f1457i = i3 + 1;
            j0.j(bArr, i3, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i4 = this.f1457i;
            this.f1457i = i4 + 1;
            bArr[i4] = (byte) ((((int) j2) | 128) & 255);
            j2 >>>= 7;
        }
        int i5 = this.f1457i;
        this.f1457i = i5 + 1;
        bArr[i5] = (byte) j2;
    }

    public final void X() {
        this.f1458j.write(this.f1455g, 0, this.f1457i);
        this.f1457i = 0;
    }

    public final void Y(int i2) {
        if (this.f1456h - this.f1457i < i2) {
            X();
        }
    }

    public final void Z(byte b2) {
        if (this.f1457i == this.f1456h) {
            X();
        }
        int i2 = this.f1457i;
        this.f1457i = i2 + 1;
        this.f1455g[i2] = b2;
    }

    public final void a0(byte[] bArr, int i2, int i3) {
        int i4 = this.f1457i;
        int i5 = this.f1456h;
        int i6 = i5 - i4;
        byte[] bArr2 = this.f1455g;
        if (i6 >= i3) {
            System.arraycopy(bArr, i2, bArr2, i4, i3);
            this.f1457i += i3;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i4, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f1457i = i5;
        X();
        if (i8 <= i5) {
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.f1457i = i8;
        } else {
            this.f1458j.write(bArr, i7, i8);
        }
    }

    public final void b0(int i2, boolean z) {
        Y(11);
        P(i2, 0);
        byte b2 = z ? (byte) 1 : (byte) 0;
        int i3 = this.f1457i;
        this.f1457i = i3 + 1;
        this.f1455g[i3] = b2;
    }

    public final void c0(int i2, C0080g c0080g) {
        n0(i2, 2);
        d0(c0080g);
    }

    public final void d0(C0080g c0080g) {
        p0(c0080g.size());
        M(c0080g.f1420d, c0080g.e(), c0080g.size());
    }

    public final void e0(int i2, int i3) {
        Y(14);
        P(i2, 5);
        N(i3);
    }

    public final void f0(int i2) {
        Y(4);
        N(i2);
    }

    public final void g0(int i2, long j2) {
        Y(18);
        P(i2, 1);
        O(j2);
    }

    public final void h0(long j2) {
        Y(8);
        O(j2);
    }

    public final void i0(int i2, int i3) {
        Y(20);
        P(i2, 0);
        if (i3 >= 0) {
            Q(i3);
        } else {
            R(i3);
        }
    }

    public final void j0(int i2) {
        if (i2 >= 0) {
            p0(i2);
        } else {
            r0(i2);
        }
    }

    public final void k0(int i2, AbstractC0074a abstractC0074a, W w2) {
        n0(i2, 2);
        p0(abstractC0074a.a(w2));
        w2.b(abstractC0074a, this.f1454f);
    }

    public final void l0(int i2, String str) {
        n0(i2, 2);
        m0(str);
    }

    public final void m0(String str) {
        try {
            int length = str.length() * 3;
            int V2 = V(length);
            int i2 = V2 + length;
            int i3 = this.f1456h;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int s2 = m0.f1459a.s(str, bArr, 0, length);
                p0(s2);
                a0(bArr, 0, s2);
                return;
            }
            if (i2 > i3 - this.f1457i) {
                X();
            }
            int V3 = V(str.length());
            int i4 = this.f1457i;
            byte[] bArr2 = this.f1455g;
            try {
                try {
                    if (V3 == V2) {
                        int i5 = i4 + V3;
                        this.f1457i = i5;
                        int s3 = m0.f1459a.s(str, bArr2, i5, i3 - i5);
                        this.f1457i = i4;
                        Q((s3 - i4) - V3);
                        this.f1457i = s3;
                    } else {
                        int a2 = m0.a(str);
                        Q(a2);
                        this.f1457i = m0.f1459a.s(str, bArr2, this.f1457i, a2);
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new C0085l(e2);
                }
            } catch (l0 e3) {
                this.f1457i = i4;
                throw e3;
            }
        } catch (l0 e4) {
            f1452k.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e4);
            byte[] bytes = str.getBytes(AbstractC0097y.f1494a);
            try {
                p0(bytes.length);
                M(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e5) {
                throw new C0085l(e5);
            }
        }
    }

    public final void n0(int i2, int i3) {
        p0((i2 << 3) | i3);
    }

    public final void o0(int i2, int i3) {
        Y(20);
        P(i2, 0);
        Q(i3);
    }

    public final void p0(int i2) {
        Y(5);
        Q(i2);
    }

    public final void q0(int i2, long j2) {
        Y(20);
        P(i2, 0);
        R(j2);
    }

    public final void r0(long j2) {
        Y(10);
        R(j2);
    }
}
