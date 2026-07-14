package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0150g implements Iterable, Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final C0150g f2634h = new C0150g(AbstractC0167y.f2710b);

    /* renamed from: i, reason: collision with root package name */
    public static final C0148e f2635i;

    /* renamed from: f, reason: collision with root package name */
    public int f2636f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f2637g;

    static {
        C0148e c0148e;
        if (AbstractC0146c.a()) {
            c0148e = new C0148e(1);
        } else {
            c0148e = new C0148e(0);
        }
        f2635i = c0148e;
    }

    public C0150g(byte[] bArr) {
        bArr.getClass();
        this.f2637g = bArr;
    }

    public static int b(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) < 0) {
            if (i4 >= 0) {
                if (i5 < i4) {
                    throw new IndexOutOfBoundsException(A2.i.h("Beginning index larger than ending index: ", ", ", i4, i5));
                }
                throw new IndexOutOfBoundsException(A2.i.h("End index: ", " >= ", i5, i6));
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i4 + " < 0");
        }
        return i7;
    }

    public static C0150g c(byte[] bArr, int i4, int i5) {
        byte[] copyOfRange;
        b(i4, i4 + i5, bArr.length);
        switch (f2635i.f2632a) {
            case 0:
                copyOfRange = Arrays.copyOfRange(bArr, i4, i5 + i4);
                break;
            default:
                copyOfRange = new byte[i5];
                System.arraycopy(bArr, i4, copyOfRange, 0, i5);
                break;
        }
        return new C0150g(copyOfRange);
    }

    public byte a(int i4) {
        return this.f2637g[i4];
    }

    public void d(byte[] bArr, int i4) {
        System.arraycopy(this.f2637g, 0, bArr, 0, i4);
    }

    public int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if ((obj instanceof C0150g) && size() == ((C0150g) obj).size()) {
                if (size() != 0) {
                    if (obj instanceof C0150g) {
                        C0150g c0150g = (C0150g) obj;
                        int i4 = this.f2636f;
                        int i5 = c0150g.f2636f;
                        if (i4 == 0 || i5 == 0 || i4 == i5) {
                            int size = size();
                            if (size <= c0150g.size()) {
                                if (size <= c0150g.size()) {
                                    byte[] bArr = c0150g.f2637g;
                                    int e4 = e() + size;
                                    int e5 = e();
                                    int e6 = c0150g.e();
                                    while (e5 < e4) {
                                        if (this.f2637g[e5] != bArr[e6]) {
                                            return false;
                                        }
                                        e5++;
                                        e6++;
                                    }
                                    return true;
                                }
                                throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + c0150g.size());
                            }
                            throw new IllegalArgumentException("Length too large: " + size + size());
                        }
                        return false;
                    }
                    return obj.equals(this);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public byte f(int i4) {
        return this.f2637g[i4];
    }

    public final int hashCode() {
        int i4 = this.f2636f;
        if (i4 == 0) {
            int size = size();
            int e4 = e();
            int i5 = size;
            for (int i6 = e4; i6 < e4 + size; i6++) {
                i5 = (i5 * 31) + this.f2637g[i6];
            }
            if (i5 == 0) {
                i5 = 1;
            }
            this.f2636f = i5;
            return i5;
        }
        return i4;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0147d(this);
    }

    public int size() {
        return this.f2637g.length;
    }

    public final String toString() {
        C0150g c0149f;
        String sb;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            sb = k3.b.h(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            int b4 = b(0, 47, size());
            if (b4 == 0) {
                c0149f = f2634h;
            } else {
                c0149f = new C0149f(this.f2637g, e(), b4);
            }
            sb2.append(k3.b.h(c0149f));
            sb2.append("...");
            sb = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder("<ByteString@");
        sb3.append(hexString);
        sb3.append(" size=");
        sb3.append(size);
        sb3.append(" contents=\"");
        return r2.k.c(sb3, sb, "\">");
    }
}
