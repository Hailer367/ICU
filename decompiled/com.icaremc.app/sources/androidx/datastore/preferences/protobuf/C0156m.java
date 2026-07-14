package androidx.datastore.preferences.protobuf;

import f1.AbstractC0286a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0156m extends AbstractC0286a {

    /* renamed from: i, reason: collision with root package name */
    public static final Logger f2669i = Logger.getLogger(C0156m.class.getName());

    /* renamed from: j, reason: collision with root package name */
    public static final boolean f2670j = j0.f2661e;

    /* renamed from: d, reason: collision with root package name */
    public F f2671d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f2672e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2673f;

    /* renamed from: g, reason: collision with root package name */
    public int f2674g;

    /* renamed from: h, reason: collision with root package name */
    public final O.l0 f2675h;

    public C0156m(O.l0 l0Var, int i4) {
        if (i4 >= 0) {
            int max = Math.max(i4, 20);
            this.f2672e = new byte[max];
            this.f2673f = max;
            this.f2675h = l0Var;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public static int V(int i4, C0150g c0150g) {
        int X3 = X(i4);
        int size = c0150g.size();
        return Y(size) + size + X3;
    }

    public static int W(String str) {
        int length;
        try {
            length = m0.a(str);
        } catch (l0 unused) {
            length = str.getBytes(AbstractC0167y.f2709a).length;
        }
        return Y(length) + length;
    }

    public static int X(int i4) {
        return Y(i4 << 3);
    }

    public static int Y(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
    }

    public static int Z(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    @Override // f1.AbstractC0286a
    public final void O(byte[] bArr, int i4, int i5) {
        d0(bArr, i4, i5);
    }

    public final void Q(int i4) {
        int i5 = this.f2674g;
        int i6 = i5 + 1;
        this.f2674g = i6;
        byte[] bArr = this.f2672e;
        bArr[i5] = (byte) (i4 & 255);
        int i7 = i5 + 2;
        this.f2674g = i7;
        bArr[i6] = (byte) ((i4 >> 8) & 255);
        int i8 = i5 + 3;
        this.f2674g = i8;
        bArr[i7] = (byte) ((i4 >> 16) & 255);
        this.f2674g = i5 + 4;
        bArr[i8] = (byte) ((i4 >> 24) & 255);
    }

    public final void R(long j4) {
        int i4 = this.f2674g;
        int i5 = i4 + 1;
        this.f2674g = i5;
        byte[] bArr = this.f2672e;
        bArr[i4] = (byte) (j4 & 255);
        int i6 = i4 + 2;
        this.f2674g = i6;
        bArr[i5] = (byte) ((j4 >> 8) & 255);
        int i7 = i4 + 3;
        this.f2674g = i7;
        bArr[i6] = (byte) ((j4 >> 16) & 255);
        int i8 = i4 + 4;
        this.f2674g = i8;
        bArr[i7] = (byte) (255 & (j4 >> 24));
        int i9 = i4 + 5;
        this.f2674g = i9;
        bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
        int i10 = i4 + 6;
        this.f2674g = i10;
        bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
        int i11 = i4 + 7;
        this.f2674g = i11;
        bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
        this.f2674g = i4 + 8;
        bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
    }

    public final void S(int i4, int i5) {
        T((i4 << 3) | i5);
    }

    public final void T(int i4) {
        boolean z = f2670j;
        byte[] bArr = this.f2672e;
        if (z) {
            while ((i4 & (-128)) != 0) {
                int i5 = this.f2674g;
                this.f2674g = i5 + 1;
                j0.j(bArr, i5, (byte) ((i4 | 128) & 255));
                i4 >>>= 7;
            }
            int i6 = this.f2674g;
            this.f2674g = i6 + 1;
            j0.j(bArr, i6, (byte) i4);
            return;
        }
        while ((i4 & (-128)) != 0) {
            int i7 = this.f2674g;
            this.f2674g = i7 + 1;
            bArr[i7] = (byte) ((i4 | 128) & 255);
            i4 >>>= 7;
        }
        int i8 = this.f2674g;
        this.f2674g = i8 + 1;
        bArr[i8] = (byte) i4;
    }

    public final void U(long j4) {
        boolean z = f2670j;
        byte[] bArr = this.f2672e;
        if (z) {
            while ((j4 & (-128)) != 0) {
                int i4 = this.f2674g;
                this.f2674g = i4 + 1;
                j0.j(bArr, i4, (byte) ((((int) j4) | 128) & 255));
                j4 >>>= 7;
            }
            int i5 = this.f2674g;
            this.f2674g = i5 + 1;
            j0.j(bArr, i5, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            int i6 = this.f2674g;
            this.f2674g = i6 + 1;
            bArr[i6] = (byte) ((((int) j4) | 128) & 255);
            j4 >>>= 7;
        }
        int i7 = this.f2674g;
        this.f2674g = i7 + 1;
        bArr[i7] = (byte) j4;
    }

    public final void a0() {
        this.f2675h.write(this.f2672e, 0, this.f2674g);
        this.f2674g = 0;
    }

    public final void b0(int i4) {
        if (this.f2673f - this.f2674g < i4) {
            a0();
        }
    }

    public final void c0(byte b4) {
        if (this.f2674g == this.f2673f) {
            a0();
        }
        int i4 = this.f2674g;
        this.f2674g = i4 + 1;
        this.f2672e[i4] = b4;
    }

    public final void d0(byte[] bArr, int i4, int i5) {
        int i6 = this.f2674g;
        int i7 = this.f2673f;
        int i8 = i7 - i6;
        byte[] bArr2 = this.f2672e;
        if (i8 >= i5) {
            System.arraycopy(bArr, i4, bArr2, i6, i5);
            this.f2674g += i5;
            return;
        }
        System.arraycopy(bArr, i4, bArr2, i6, i8);
        int i9 = i4 + i8;
        int i10 = i5 - i8;
        this.f2674g = i7;
        a0();
        if (i10 <= i7) {
            System.arraycopy(bArr, i9, bArr2, 0, i10);
            this.f2674g = i10;
        } else {
            this.f2675h.write(bArr, i9, i10);
        }
    }

    public final void e0(int i4, boolean z) {
        b0(11);
        S(i4, 0);
        byte b4 = z ? (byte) 1 : (byte) 0;
        int i5 = this.f2674g;
        this.f2674g = i5 + 1;
        this.f2672e[i5] = b4;
    }

    public final void f0(int i4, C0150g c0150g) {
        q0(i4, 2);
        g0(c0150g);
    }

    public final void g0(C0150g c0150g) {
        s0(c0150g.size());
        O(c0150g.f2637g, c0150g.e(), c0150g.size());
    }

    public final void h0(int i4, int i5) {
        b0(14);
        S(i4, 5);
        Q(i5);
    }

    public final void i0(int i4) {
        b0(4);
        Q(i4);
    }

    public final void j0(long j4, int i4) {
        b0(18);
        S(i4, 1);
        R(j4);
    }

    public final void k0(long j4) {
        b0(8);
        R(j4);
    }

    public final void l0(int i4, int i5) {
        b0(20);
        S(i4, 0);
        if (i5 >= 0) {
            T(i5);
        } else {
            U(i5);
        }
    }

    public final void m0(int i4) {
        if (i4 >= 0) {
            s0(i4);
        } else {
            u0(i4);
        }
    }

    public final void n0(int i4, AbstractC0144a abstractC0144a, W w2) {
        q0(i4, 2);
        s0(abstractC0144a.a(w2));
        w2.b(abstractC0144a, this.f2671d);
    }

    public final void o0(int i4, String str) {
        q0(i4, 2);
        p0(str);
    }

    public final void p0(String str) {
        try {
            int length = str.length() * 3;
            int Y3 = Y(length);
            int i4 = Y3 + length;
            int i5 = this.f2673f;
            if (i4 > i5) {
                byte[] bArr = new byte[length];
                int q2 = m0.f2676a.q(str, bArr, 0, length);
                s0(q2);
                d0(bArr, 0, q2);
                return;
            }
            if (i4 > i5 - this.f2674g) {
                a0();
            }
            int Y4 = Y(str.length());
            int i6 = this.f2674g;
            byte[] bArr2 = this.f2672e;
            try {
                try {
                    if (Y4 == Y3) {
                        int i7 = i6 + Y4;
                        this.f2674g = i7;
                        int q3 = m0.f2676a.q(str, bArr2, i7, i5 - i7);
                        this.f2674g = i6;
                        T((q3 - i6) - Y4);
                        this.f2674g = q3;
                    } else {
                        int a4 = m0.a(str);
                        T(a4);
                        this.f2674g = m0.f2676a.q(str, bArr2, this.f2674g, a4);
                    }
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new C0155l(e4);
                }
            } catch (l0 e5) {
                this.f2674g = i6;
                throw e5;
            }
        } catch (l0 e6) {
            f2669i.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e6);
            byte[] bytes = str.getBytes(AbstractC0167y.f2709a);
            try {
                s0(bytes.length);
                O(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e7) {
                throw new C0155l(e7);
            }
        }
    }

    public final void q0(int i4, int i5) {
        s0((i4 << 3) | i5);
    }

    public final void r0(int i4, int i5) {
        b0(20);
        S(i4, 0);
        T(i5);
    }

    public final void s0(int i4) {
        b0(5);
        T(i4);
    }

    public final void t0(long j4, int i4) {
        b0(20);
        S(i4, 0);
        U(j4);
    }

    public final void u0(long j4) {
        b0(10);
        U(j4);
    }
}
