package androidx.datastore.preferences.protobuf;

import a.AbstractC0051a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0080g implements Iterable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final C0080g f1417e = new C0080g(AbstractC0097y.f1495b);

    /* renamed from: f, reason: collision with root package name */
    public static final C0078e f1418f;

    /* renamed from: c, reason: collision with root package name */
    public int f1419c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f1420d;

    static {
        C0078e c0078e;
        if (AbstractC0076c.a()) {
            c0078e = new C0078e(1);
        } else {
            c0078e = new C0078e(0);
        }
        f1418f = c0078e;
    }

    public C0080g(byte[] bArr) {
        bArr.getClass();
        this.f1420d = bArr;
    }

    public static int b(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) < 0) {
            if (i2 >= 0) {
                if (i3 < i2) {
                    throw new IndexOutOfBoundsException(O.a.d("Beginning index larger than ending index: ", i2, ", ", i3));
                }
                throw new IndexOutOfBoundsException(O.a.d("End index: ", i3, " >= ", i4));
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        }
        return i5;
    }

    public static C0080g c(byte[] bArr, int i2, int i3) {
        byte[] copyOfRange;
        b(i2, i2 + i3, bArr.length);
        switch (f1418f.f1414a) {
            case 0:
                copyOfRange = Arrays.copyOfRange(bArr, i2, i3 + i2);
                break;
            default:
                copyOfRange = new byte[i3];
                System.arraycopy(bArr, i2, copyOfRange, 0, i3);
                break;
        }
        return new C0080g(copyOfRange);
    }

    public byte a(int i2) {
        return this.f1420d[i2];
    }

    public void d(byte[] bArr, int i2) {
        System.arraycopy(this.f1420d, 0, bArr, 0, i2);
    }

    public int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if ((obj instanceof C0080g) && size() == ((C0080g) obj).size()) {
                if (size() != 0) {
                    if (obj instanceof C0080g) {
                        C0080g c0080g = (C0080g) obj;
                        int i2 = this.f1419c;
                        int i3 = c0080g.f1419c;
                        if (i2 == 0 || i3 == 0 || i2 == i3) {
                            int size = size();
                            if (size <= c0080g.size()) {
                                if (size <= c0080g.size()) {
                                    byte[] bArr = c0080g.f1420d;
                                    int e2 = e() + size;
                                    int e3 = e();
                                    int e4 = c0080g.e();
                                    while (e3 < e2) {
                                        if (this.f1420d[e3] != bArr[e4]) {
                                            return false;
                                        }
                                        e3++;
                                        e4++;
                                    }
                                    return true;
                                }
                                throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + c0080g.size());
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

    public byte f(int i2) {
        return this.f1420d[i2];
    }

    public final int hashCode() {
        int i2 = this.f1419c;
        if (i2 == 0) {
            int size = size();
            int e2 = e();
            int i3 = size;
            for (int i4 = e2; i4 < e2 + size; i4++) {
                i3 = (i3 * 31) + this.f1420d[i4];
            }
            if (i3 == 0) {
                i3 = 1;
            }
            this.f1419c = i3;
            return i3;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0077d(this);
    }

    public int size() {
        return this.f1420d.length;
    }

    public final String toString() {
        C0080g c0079f;
        String sb;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            sb = AbstractC0051a.u(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            int b2 = b(0, 47, size());
            if (b2 == 0) {
                c0079f = f1417e;
            } else {
                c0079f = new C0079f(this.f1420d, e(), b2);
            }
            sb2.append(AbstractC0051a.u(c0079f));
            sb2.append("...");
            sb = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder("<ByteString@");
        sb3.append(hexString);
        sb3.append(" size=");
        sb3.append(size);
        sb3.append(" contents=\"");
        return O.a.i(sb3, sb, "\">");
    }
}
