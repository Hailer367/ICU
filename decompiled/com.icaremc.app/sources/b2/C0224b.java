package b2;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* renamed from: b2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0224b implements Closeable, Flushable {

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f3223q = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f3224r = new String[128];

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f3225s;

    /* renamed from: f, reason: collision with root package name */
    public final Writer f3226f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f3227g;

    /* renamed from: h, reason: collision with root package name */
    public int f3228h;

    /* renamed from: i, reason: collision with root package name */
    public T1.a f3229i;

    /* renamed from: j, reason: collision with root package name */
    public String f3230j;
    public String k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3231l;

    /* renamed from: m, reason: collision with root package name */
    public int f3232m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3233n;

    /* renamed from: o, reason: collision with root package name */
    public String f3234o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3235p;

    static {
        for (int i4 = 0; i4 <= 31; i4++) {
            f3224r[i4] = String.format("\\u%04x", Integer.valueOf(i4));
        }
        String[] strArr = f3224r;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f3225s = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C0224b(Writer writer) {
        int[] iArr = new int[32];
        this.f3227g = iArr;
        this.f3228h = 0;
        if (iArr.length == 0) {
            this.f3227g = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f3227g;
        int i4 = this.f3228h;
        this.f3228h = i4 + 1;
        iArr2[i4] = 6;
        this.f3232m = 2;
        this.f3235p = true;
        Objects.requireNonNull(writer, "out == null");
        this.f3226f = writer;
        k(T1.a.f1601d);
    }

    public final void a() {
        int j4 = j();
        if (j4 != 1) {
            Writer writer = this.f3226f;
            if (j4 != 2) {
                if (j4 != 4) {
                    if (j4 != 6) {
                        if (j4 == 7) {
                            if (this.f3232m != 1) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    this.f3227g[this.f3228h - 1] = 7;
                    return;
                }
                writer.append((CharSequence) this.f3230j);
                this.f3227g[this.f3228h - 1] = 5;
                return;
            }
            writer.append((CharSequence) this.k);
            h();
            return;
        }
        this.f3227g[this.f3228h - 1] = 2;
        h();
    }

    public void b() {
        t();
        a();
        int i4 = this.f3228h;
        int[] iArr = this.f3227g;
        if (i4 == iArr.length) {
            this.f3227g = Arrays.copyOf(iArr, i4 * 2);
        }
        int[] iArr2 = this.f3227g;
        int i5 = this.f3228h;
        this.f3228h = i5 + 1;
        iArr2[i5] = 1;
        this.f3226f.write(91);
    }

    public void c() {
        t();
        a();
        int i4 = this.f3228h;
        int[] iArr = this.f3227g;
        if (i4 == iArr.length) {
            this.f3227g = Arrays.copyOf(iArr, i4 * 2);
        }
        int[] iArr2 = this.f3227g;
        int i5 = this.f3228h;
        this.f3228h = i5 + 1;
        iArr2[i5] = 3;
        this.f3226f.write(123);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3226f.close();
        int i4 = this.f3228h;
        if (i4 <= 1 && (i4 != 1 || this.f3227g[i4 - 1] == 7)) {
            this.f3228h = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final void d(int i4, int i5, char c4) {
        int j4 = j();
        if (j4 != i5 && j4 != i4) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3234o == null) {
            this.f3228h--;
            if (j4 == i5) {
                h();
            }
            this.f3226f.write(c4);
            return;
        }
        throw new IllegalStateException("Dangling name: " + this.f3234o);
    }

    public void e() {
        d(1, 2, ']');
    }

    public void f() {
        d(3, 5, '}');
    }

    public void flush() {
        if (this.f3228h != 0) {
            this.f3226f.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void g(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f3234o == null) {
            int j4 = j();
            if (j4 != 3 && j4 != 5) {
                throw new IllegalStateException("Please begin an object before writing a name.");
            }
            this.f3234o = str;
            return;
        }
        throw new IllegalStateException("Already wrote a name, expecting a value.");
    }

    public final void h() {
        if (!this.f3231l) {
            String str = this.f3229i.f1602a;
            Writer writer = this.f3226f;
            writer.write(str);
            int i4 = this.f3228h;
            for (int i5 = 1; i5 < i4; i5++) {
                writer.write(this.f3229i.f1603b);
            }
        }
    }

    public C0224b i() {
        if (this.f3234o != null) {
            if (this.f3235p) {
                t();
            } else {
                this.f3234o = null;
                return this;
            }
        }
        a();
        this.f3226f.write("null");
        return this;
    }

    public final int j() {
        int i4 = this.f3228h;
        if (i4 != 0) {
            return this.f3227g[i4 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void k(T1.a aVar) {
        boolean z;
        Objects.requireNonNull(aVar);
        this.f3229i = aVar;
        this.k = ",";
        if (aVar.f1604c) {
            this.f3230j = ": ";
            if (aVar.f1602a.isEmpty()) {
                this.k = ", ";
            }
        } else {
            this.f3230j = ":";
        }
        if (this.f3229i.f1602a.isEmpty() && this.f3229i.f1603b.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        this.f3231l = z;
    }

    public final void l(int i4) {
        if (i4 != 0) {
            this.f3232m = i4;
            return;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f3233n
            if (r0 == 0) goto L7
            java.lang.String[] r0 = b2.C0224b.f3225s
            goto L9
        L7:
            java.lang.String[] r0 = b2.C0224b.f3224r
        L9:
            java.io.Writer r1 = r8.f3226f
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C0224b.m(java.lang.String):void");
    }

    public void n(double d4) {
        t();
        if (this.f3232m != 1 && (Double.isNaN(d4) || Double.isInfinite(d4))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d4);
        }
        a();
        this.f3226f.append((CharSequence) Double.toString(d4));
    }

    public void o(long j4) {
        t();
        a();
        this.f3226f.write(Long.toString(j4));
    }

    public void p(Boolean bool) {
        String str;
        if (bool == null) {
            i();
            return;
        }
        t();
        a();
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        this.f3226f.write(str);
    }

    public void q(Number number) {
        if (number == null) {
            i();
            return;
        }
        t();
        String obj = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
                if (cls != Float.class && cls != Double.class && !f3223q.matcher(obj).matches()) {
                    throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
                }
            } else if (this.f3232m != 1) {
                throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
            }
        }
        a();
        this.f3226f.append((CharSequence) obj);
    }

    public void r(String str) {
        if (str == null) {
            i();
            return;
        }
        t();
        a();
        m(str);
    }

    public void s(boolean z) {
        String str;
        t();
        a();
        if (z) {
            str = "true";
        } else {
            str = "false";
        }
        this.f3226f.write(str);
    }

    public final void t() {
        if (this.f3234o != null) {
            int j4 = j();
            if (j4 == 5) {
                this.f3226f.write(this.k);
            } else if (j4 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            h();
            this.f3227g[this.f3228h - 1] = 4;
            m(this.f3234o);
            this.f3234o = null;
        }
    }
}
