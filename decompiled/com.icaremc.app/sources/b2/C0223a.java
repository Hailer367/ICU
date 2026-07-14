package b2;

import A2.i;
import H1.f;
import R.j;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0223a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final Reader f3209f;

    /* renamed from: m, reason: collision with root package name */
    public long f3215m;

    /* renamed from: n, reason: collision with root package name */
    public int f3216n;

    /* renamed from: o, reason: collision with root package name */
    public String f3217o;

    /* renamed from: p, reason: collision with root package name */
    public int[] f3218p;

    /* renamed from: r, reason: collision with root package name */
    public String[] f3220r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f3221s;

    /* renamed from: t, reason: collision with root package name */
    public int f3222t = 2;

    /* renamed from: g, reason: collision with root package name */
    public final char[] f3210g = new char[1024];

    /* renamed from: h, reason: collision with root package name */
    public int f3211h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f3212i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f3213j = 0;
    public int k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f3214l = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f3219q = 1;

    /* JADX WARN: Type inference failed for: r0v0, types: [H1.f, java.lang.Object] */
    static {
        f.f662h = new Object();
    }

    public C0223a(Reader reader) {
        int[] iArr = new int[32];
        this.f3218p = iArr;
        iArr[0] = 6;
        this.f3220r = new String[32];
        this.f3221s = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f3209f = reader;
    }

    public final void A(char c4) {
        do {
            int i4 = this.f3211h;
            int i5 = this.f3212i;
            while (i4 < i5) {
                int i6 = i4 + 1;
                char c5 = this.f3210g[i4];
                if (c5 == c4) {
                    this.f3211h = i6;
                    return;
                }
                if (c5 == '\\') {
                    this.f3211h = i6;
                    z();
                    i4 = this.f3211h;
                    i5 = this.f3212i;
                } else {
                    if (c5 == '\n') {
                        this.f3213j++;
                        this.k = i6;
                    }
                    i4 = i6;
                }
            }
            this.f3211h = i4;
        } while (g(1));
        E("Unterminated string");
        throw null;
    }

    public final void B() {
        char c4;
        do {
            if (this.f3211h < this.f3212i || g(1)) {
                int i4 = this.f3211h;
                int i5 = i4 + 1;
                this.f3211h = i5;
                c4 = this.f3210g[i4];
                if (c4 == '\n') {
                    this.f3213j++;
                    this.k = i5;
                    return;
                }
            } else {
                return;
            }
        } while (c4 != '\r');
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:242)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void C() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f3211h
            int r2 = r1 + r0
            int r3 = r4.f3212i
            if (r2 >= r3) goto L51
            char[] r2 = r4.f3210g
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.c()
        L4b:
            int r1 = r4.f3211h
            int r1 = r1 + r0
            r4.f3211h = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f3211h = r1
            r0 = 1
            boolean r0 = r4.g(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C0223a.C():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0011. Please report as an issue. */
    public void D() {
        int i4 = 0;
        do {
            int i5 = this.f3214l;
            if (i5 == 0) {
                i5 = d();
            }
            switch (i5) {
                case 1:
                    y(3);
                    i4++;
                    this.f3214l = 0;
                    break;
                case 2:
                    if (i4 == 0) {
                        this.f3220r[this.f3219q - 1] = null;
                    }
                    this.f3219q--;
                    i4--;
                    this.f3214l = 0;
                    break;
                case 3:
                    y(1);
                    i4++;
                    this.f3214l = 0;
                    break;
                case 4:
                    this.f3219q--;
                    i4--;
                    this.f3214l = 0;
                    break;
                case 5:
                case 6:
                case j.DOUBLE_FIELD_NUMBER /* 7 */:
                case 11:
                case 15:
                default:
                    this.f3214l = 0;
                    break;
                case j.BYTES_FIELD_NUMBER /* 8 */:
                    A('\'');
                    this.f3214l = 0;
                    break;
                case 9:
                    A('\"');
                    this.f3214l = 0;
                    break;
                case 10:
                    C();
                    this.f3214l = 0;
                    break;
                case 12:
                    A('\'');
                    if (i4 == 0) {
                        this.f3220r[this.f3219q - 1] = "<skipped>";
                    }
                    this.f3214l = 0;
                    break;
                case 13:
                    A('\"');
                    if (i4 == 0) {
                        this.f3220r[this.f3219q - 1] = "<skipped>";
                    }
                    this.f3214l = 0;
                    break;
                case 14:
                    C();
                    if (i4 == 0) {
                        this.f3220r[this.f3219q - 1] = "<skipped>";
                    }
                    this.f3214l = 0;
                    break;
                case 16:
                    this.f3211h += this.f3216n;
                    this.f3214l = 0;
                    break;
                case 17:
                    return;
            }
        } while (i4 > 0);
        int[] iArr = this.f3221s;
        int i6 = this.f3219q - 1;
        iArr[i6] = iArr[i6] + 1;
    }

    public final void E(String str) {
        throw new IOException(str + m() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
    }

    public final IllegalStateException F(String str) {
        String str2;
        if (x() == 9) {
            str2 = "adapter-not-null-safe";
        } else {
            str2 = "unexpected-json-structure";
        }
        return new IllegalStateException("Expected " + str + " but was " + i.s(x()) + m() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
    }

    public void a() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 3) {
            y(1);
            this.f3221s[this.f3219q - 1] = 0;
            this.f3214l = 0;
            return;
        }
        throw F("BEGIN_ARRAY");
    }

    public void b() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 1) {
            y(3);
            this.f3214l = 0;
            return;
        }
        throw F("BEGIN_OBJECT");
    }

    public final void c() {
        if (this.f3222t == 1) {
            return;
        }
        E("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3214l = 0;
        this.f3218p[0] = 8;
        this.f3219q = 1;
        this.f3209f.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0218, code lost:
    
        if (l(r12) != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01a9, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x021b, code lost:
    
        if (r5 != 2) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x021d, code lost:
    
        if (r10 == false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0223, code lost:
    
        if (r1 != Long.MIN_VALUE) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0225, code lost:
    
        if (r17 == 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x022c, code lost:
    
        if (r1 != 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x022e, code lost:
    
        if (r17 != 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0230, code lost:
    
        if (r17 == 0) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0233, code lost:
    
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0234, code lost:
    
        r24.f3215m = r1;
        r24.f3211h += r7;
        r9 = 15;
        r24.f3214l = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0228, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0240, code lost:
    
        if (r5 == r13) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0243, code lost:
    
        if (r5 == 4) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0246, code lost:
    
        if (r5 != 7) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0248, code lost:
    
        r24.f3216n = r7;
        r9 = 16;
        r24.f3214l = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0188 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0270 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d() {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C0223a.d():int");
    }

    public void e() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 4) {
            int i5 = this.f3219q;
            this.f3219q = i5 - 1;
            int[] iArr = this.f3221s;
            int i6 = i5 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.f3214l = 0;
            return;
        }
        throw F("END_ARRAY");
    }

    public void f() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 2) {
            int i5 = this.f3219q;
            int i6 = i5 - 1;
            this.f3219q = i6;
            this.f3220r[i6] = null;
            int[] iArr = this.f3221s;
            int i7 = i5 - 2;
            iArr[i7] = iArr[i7] + 1;
            this.f3214l = 0;
            return;
        }
        throw F("END_OBJECT");
    }

    public final boolean g(int i4) {
        int i5;
        int i6;
        int i7 = this.k;
        int i8 = this.f3211h;
        this.k = i7 - i8;
        int i9 = this.f3212i;
        char[] cArr = this.f3210g;
        if (i9 != i8) {
            int i10 = i9 - i8;
            this.f3212i = i10;
            System.arraycopy(cArr, i8, cArr, 0, i10);
        } else {
            this.f3212i = 0;
        }
        this.f3211h = 0;
        do {
            int i11 = this.f3212i;
            int read = this.f3209f.read(cArr, i11, cArr.length - i11);
            if (read == -1) {
                return false;
            }
            i5 = this.f3212i + read;
            this.f3212i = i5;
            if (this.f3213j == 0 && (i6 = this.k) == 0 && i5 > 0 && cArr[0] == 65279) {
                this.f3211h++;
                this.k = i6 + 1;
                i4++;
            }
        } while (i5 < i4);
        return true;
    }

    public String h() {
        return i(false);
    }

    public final String i(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i4 = 0;
        while (true) {
            int i5 = this.f3219q;
            if (i4 < i5) {
                int i6 = this.f3218p[i4];
                switch (i6) {
                    case 1:
                    case 2:
                        int i7 = this.f3221s[i4];
                        if (z && i7 > 0 && i4 == i5 - 1) {
                            i7--;
                        }
                        sb.append('[');
                        sb.append(i7);
                        sb.append(']');
                        break;
                    case 3:
                    case 4:
                    case 5:
                        sb.append('.');
                        String str = this.f3220r[i4];
                        if (str == null) {
                            break;
                        } else {
                            sb.append(str);
                            break;
                        }
                    case 6:
                    case j.DOUBLE_FIELD_NUMBER /* 7 */:
                    case j.BYTES_FIELD_NUMBER /* 8 */:
                        break;
                    default:
                        throw new AssertionError(i.g(i6, "Unknown scope value: "));
                }
                i4++;
            } else {
                return sb.toString();
            }
        }
    }

    public String j() {
        return i(true);
    }

    public boolean k() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 != 2 && i4 != 4 && i4 != 17) {
            return true;
        }
        return false;
    }

    public final boolean l(char c4) {
        if (c4 != '\t' && c4 != '\n' && c4 != '\f' && c4 != '\r' && c4 != ' ') {
            if (c4 != '#') {
                if (c4 != ',') {
                    if (c4 != '/' && c4 != '=') {
                        if (c4 != '{' && c4 != '}' && c4 != ':') {
                            if (c4 != ';') {
                                switch (c4) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            c();
            return false;
        }
        return false;
    }

    final String m() {
        return " at line " + (this.f3213j + 1) + " column " + ((this.f3211h - this.k) + 1) + " path " + h();
    }

    public boolean n() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 5) {
            this.f3214l = 0;
            int[] iArr = this.f3221s;
            int i5 = this.f3219q - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        }
        if (i4 == 6) {
            this.f3214l = 0;
            int[] iArr2 = this.f3221s;
            int i6 = this.f3219q - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        }
        throw F("a boolean");
    }

    public double o() {
        char c4;
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 15) {
            this.f3214l = 0;
            int[] iArr = this.f3221s;
            int i5 = this.f3219q - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f3215m;
        }
        if (i4 == 16) {
            this.f3217o = new String(this.f3210g, this.f3211h, this.f3216n);
            this.f3211h += this.f3216n;
        } else if (i4 != 8 && i4 != 9) {
            if (i4 == 10) {
                this.f3217o = w();
            } else if (i4 != 11) {
                throw F("a double");
            }
        } else {
            if (i4 == 8) {
                c4 = '\'';
            } else {
                c4 = '\"';
            }
            this.f3217o = u(c4);
        }
        this.f3214l = 11;
        double parseDouble = Double.parseDouble(this.f3217o);
        if (this.f3222t != 1 && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            E("JSON forbids NaN and infinities: " + parseDouble);
            throw null;
        }
        this.f3217o = null;
        this.f3214l = 0;
        int[] iArr2 = this.f3221s;
        int i6 = this.f3219q - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return parseDouble;
    }

    public int p() {
        char c4;
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 15) {
            long j4 = this.f3215m;
            int i5 = (int) j4;
            if (j4 == i5) {
                this.f3214l = 0;
                int[] iArr = this.f3221s;
                int i6 = this.f3219q - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.f3215m + m());
        }
        if (i4 == 16) {
            this.f3217o = new String(this.f3210g, this.f3211h, this.f3216n);
            this.f3211h += this.f3216n;
        } else {
            if (i4 != 8 && i4 != 9 && i4 != 10) {
                throw F("an int");
            }
            if (i4 == 10) {
                this.f3217o = w();
            } else {
                if (i4 == 8) {
                    c4 = '\'';
                } else {
                    c4 = '\"';
                }
                this.f3217o = u(c4);
            }
            try {
                int parseInt = Integer.parseInt(this.f3217o);
                this.f3214l = 0;
                int[] iArr2 = this.f3221s;
                int i7 = this.f3219q - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3214l = 11;
        double parseDouble = Double.parseDouble(this.f3217o);
        int i8 = (int) parseDouble;
        if (i8 == parseDouble) {
            this.f3217o = null;
            this.f3214l = 0;
            int[] iArr3 = this.f3221s;
            int i9 = this.f3219q - 1;
            iArr3[i9] = iArr3[i9] + 1;
            return i8;
        }
        throw new NumberFormatException("Expected an int but was " + this.f3217o + m());
    }

    public long q() {
        char c4;
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 15) {
            this.f3214l = 0;
            int[] iArr = this.f3221s;
            int i5 = this.f3219q - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f3215m;
        }
        if (i4 == 16) {
            this.f3217o = new String(this.f3210g, this.f3211h, this.f3216n);
            this.f3211h += this.f3216n;
        } else {
            if (i4 != 8 && i4 != 9 && i4 != 10) {
                throw F("a long");
            }
            if (i4 == 10) {
                this.f3217o = w();
            } else {
                if (i4 == 8) {
                    c4 = '\'';
                } else {
                    c4 = '\"';
                }
                this.f3217o = u(c4);
            }
            try {
                long parseLong = Long.parseLong(this.f3217o);
                this.f3214l = 0;
                int[] iArr2 = this.f3221s;
                int i6 = this.f3219q - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3214l = 11;
        double parseDouble = Double.parseDouble(this.f3217o);
        long j4 = (long) parseDouble;
        if (j4 == parseDouble) {
            this.f3217o = null;
            this.f3214l = 0;
            int[] iArr3 = this.f3221s;
            int i7 = this.f3219q - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return j4;
        }
        throw new NumberFormatException("Expected a long but was " + this.f3217o + m());
    }

    public String r() {
        String u3;
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 14) {
            u3 = w();
        } else if (i4 == 12) {
            u3 = u('\'');
        } else if (i4 == 13) {
            u3 = u('\"');
        } else {
            throw F("a name");
        }
        this.f3214l = 0;
        this.f3220r[this.f3219q - 1] = u3;
        return u3;
    }

    public final int s(boolean z) {
        char c4;
        int i4 = this.f3211h;
        int i5 = this.f3212i;
        while (true) {
            if (i4 == i5) {
                this.f3211h = i4;
                if (!g(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + m());
                }
                i4 = this.f3211h;
                i5 = this.f3212i;
            }
            int i6 = i4 + 1;
            char[] cArr = this.f3210g;
            c4 = cArr[i4];
            if (c4 == '\n') {
                this.f3213j++;
                this.k = i6;
            } else if (c4 != ' ' && c4 != '\r' && c4 != '\t') {
                if (c4 == '/') {
                    this.f3211h = i6;
                    if (i6 == i5) {
                        this.f3211h = i4;
                        boolean g4 = g(2);
                        this.f3211h++;
                        if (!g4) {
                            break;
                        }
                    }
                    c();
                    int i7 = this.f3211h;
                    char c5 = cArr[i7];
                    if (c5 != '*') {
                        if (c5 != '/') {
                            break;
                        }
                        this.f3211h = i7 + 1;
                        B();
                        i4 = this.f3211h;
                        i5 = this.f3212i;
                    } else {
                        this.f3211h = i7 + 1;
                        while (true) {
                            if (this.f3211h + 2 > this.f3212i && !g(2)) {
                                E("Unterminated comment");
                                throw null;
                            }
                            int i8 = this.f3211h;
                            if (cArr[i8] == '\n') {
                                this.f3213j++;
                                this.k = i8 + 1;
                            } else {
                                for (int i9 = 0; i9 < 2; i9++) {
                                    if (cArr[this.f3211h + i9] != "*/".charAt(i9)) {
                                        break;
                                    }
                                }
                                i4 = this.f3211h + 2;
                                i5 = this.f3212i;
                                break;
                            }
                            this.f3211h++;
                        }
                    }
                } else if (c4 == '#') {
                    this.f3211h = i6;
                    c();
                    B();
                    i4 = this.f3211h;
                    i5 = this.f3212i;
                } else {
                    this.f3211h = i6;
                    return c4;
                }
            }
            i4 = i6;
        }
        return c4;
    }

    public void t() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 7) {
            this.f3214l = 0;
            int[] iArr = this.f3221s;
            int i5 = this.f3219q - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw F("null");
    }

    public String toString() {
        return getClass().getSimpleName() + m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        r11.f3211h = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.f3211h = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String u(char r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f3211h
            int r3 = r11.f3212i
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f3210g
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.f3222t
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.E(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.f3211h = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r12 = new java.lang.String
            r12.<init>(r7, r3, r8)
            return r12
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r12 = r1.toString()
            return r12
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.f3211h = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.z()
            r1.append(r2)
            int r2 = r11.f3211h
            int r3 = r11.f3212i
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.f3213j
            int r2 = r2 + r6
            r11.f3213j = r2
            r11.k = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.f3211h = r2
            boolean r2 = r11.g(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.E(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C0223a.u(char):java.lang.String");
    }

    public String v() {
        String str;
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        if (i4 == 10) {
            str = w();
        } else if (i4 == 8) {
            str = u('\'');
        } else if (i4 == 9) {
            str = u('\"');
        } else if (i4 == 11) {
            str = this.f3217o;
            this.f3217o = null;
        } else if (i4 == 15) {
            str = Long.toString(this.f3215m);
        } else if (i4 == 16) {
            str = new String(this.f3210g, this.f3211h, this.f3216n);
            this.f3211h += this.f3216n;
        } else {
            throw F("a string");
        }
        this.f3214l = 0;
        int[] iArr = this.f3221s;
        int i5 = this.f3219q - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String w() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f3211h
            int r4 = r3 + r2
            int r5 = r7.f3212i
            char[] r6 = r7.f3210g
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.c()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.g(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f3211h
            r0.append(r6, r3, r2)
            int r3 = r7.f3211h
            int r3 = r3 + r2
            r7.f3211h = r3
            r2 = 1
            boolean r2 = r7.g(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f3211h
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f3211h
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f3211h
            int r2 = r2 + r1
            r7.f3211h = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C0223a.w():java.lang.String");
    }

    public int x() {
        int i4 = this.f3214l;
        if (i4 == 0) {
            i4 = d();
        }
        switch (i4) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                return 9;
            case j.BYTES_FIELD_NUMBER /* 8 */:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void y(int i4) {
        int i5 = this.f3219q;
        if (i5 - 1 < 255) {
            int[] iArr = this.f3218p;
            if (i5 == iArr.length) {
                int i6 = i5 * 2;
                this.f3218p = Arrays.copyOf(iArr, i6);
                this.f3221s = Arrays.copyOf(this.f3221s, i6);
                this.f3220r = (String[]) Arrays.copyOf(this.f3220r, i6);
            }
            int[] iArr2 = this.f3218p;
            int i7 = this.f3219q;
            this.f3219q = i7 + 1;
            iArr2[i7] = i4;
            return;
        }
        throw new IOException("Nesting limit 255 reached" + m());
    }

    public final char z() {
        int i4;
        if (this.f3211h == this.f3212i && !g(1)) {
            E("Unterminated escape sequence");
            throw null;
        }
        int i5 = this.f3211h;
        int i6 = i5 + 1;
        this.f3211h = i6;
        char[] cArr = this.f3210g;
        char c4 = cArr[i5];
        if (c4 != '\n') {
            if (c4 != '\"') {
                if (c4 != '\'') {
                    if (c4 != '/' && c4 != '\\') {
                        if (c4 != 'b') {
                            if (c4 != 'f') {
                                if (c4 == 'n') {
                                    return '\n';
                                }
                                if (c4 != 'r') {
                                    if (c4 != 't') {
                                        if (c4 == 'u') {
                                            if (i5 + 5 > this.f3212i && !g(4)) {
                                                E("Unterminated escape sequence");
                                                throw null;
                                            }
                                            int i7 = this.f3211h;
                                            int i8 = i7 + 4;
                                            int i9 = 0;
                                            while (i7 < i8) {
                                                char c5 = cArr[i7];
                                                int i10 = i9 << 4;
                                                if (c5 >= '0' && c5 <= '9') {
                                                    i4 = c5 - '0';
                                                } else if (c5 >= 'a' && c5 <= 'f') {
                                                    i4 = c5 - 'W';
                                                } else if (c5 >= 'A' && c5 <= 'F') {
                                                    i4 = c5 - '7';
                                                } else {
                                                    E("Malformed Unicode escape \\u".concat(new String(cArr, this.f3211h, 4)));
                                                    throw null;
                                                }
                                                i9 = i4 + i10;
                                                i7++;
                                            }
                                            this.f3211h += 4;
                                            return (char) i9;
                                        }
                                        E("Invalid escape sequence");
                                        throw null;
                                    }
                                    return '\t';
                                }
                                return '\r';
                            }
                            return '\f';
                        }
                        return '\b';
                    }
                }
            }
            return c4;
        }
        if (this.f3222t != 3) {
            this.f3213j++;
            this.k = i6;
        } else {
            E("Cannot escape a newline character in strict mode");
            throw null;
        }
        if (this.f3222t == 3) {
            E("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c4;
    }
}
