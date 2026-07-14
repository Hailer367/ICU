package j$.time.format;

/* loaded from: classes2.dex */
public final class i implements e {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f4661d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e, reason: collision with root package name */
    public static final i f4662e = new i("+HH:MM:ss", "Z");

    /* renamed from: f, reason: collision with root package name */
    public static final i f4663f = new i("+HH:MM:ss", "0");

    /* renamed from: a, reason: collision with root package name */
    public final String f4664a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4665b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4666c;

    public i(String str, String str2) {
        for (int i4 = 0; i4 < 22; i4++) {
            if (f4661d[i4].equals(str)) {
                this.f4665b = i4;
                this.f4666c = i4 % 11;
                this.f4664a = str2;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        Long a4 = sVar.a(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z = false;
        if (a4 == null) {
            return false;
        }
        int intExact = Math.toIntExact(a4.longValue());
        String str = this.f4664a;
        if (intExact == 0) {
            sb.append(str);
            return true;
        }
        int abs = Math.abs((intExact / 3600) % 100);
        int abs2 = Math.abs((intExact / 60) % 60);
        int abs3 = Math.abs(intExact % 60);
        int length = sb.length();
        sb.append(intExact < 0 ? "-" : "+");
        if (this.f4665b < 11 || abs >= 10) {
            a(false, abs, sb);
        } else {
            sb.append((char) (abs + 48));
        }
        int i4 = this.f4666c;
        if ((i4 >= 3 && i4 <= 8) || ((i4 >= 9 && abs3 > 0) || (i4 >= 1 && abs2 > 0))) {
            a(i4 > 0 && i4 % 2 == 0, abs2, sb);
            abs += abs2;
            if (i4 == 7 || i4 == 8 || (i4 >= 5 && abs3 > 0)) {
                if (i4 > 0 && i4 % 2 == 0) {
                    z = true;
                }
                a(z, abs3, sb);
                abs += abs3;
            }
        }
        if (abs == 0) {
            sb.setLength(length);
            sb.append(str);
        }
        return true;
    }

    public static void a(boolean z, int i4, StringBuilder sb) {
        sb.append(z ? ":" : "");
        sb.append((char) ((i4 / 10) + 48));
        sb.append((char) ((i4 % 10) + 48));
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i4) {
        CharSequence charSequence2;
        int i5;
        int i6;
        int i7;
        int i8;
        int length = charSequence.length();
        int length2 = this.f4664a.length();
        if (length2 == 0) {
            if (i4 == length) {
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i4, i4);
            }
            charSequence2 = charSequence;
        } else {
            if (i4 == length) {
                return ~i4;
            }
            charSequence2 = charSequence;
            if (pVar.g(charSequence2, i4, this.f4664a, 0, length2)) {
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i4, i4 + length2);
            }
        }
        char charAt = charSequence.charAt(i4);
        if (charAt == '+' || charAt == '-') {
            int i9 = charAt == '-' ? -1 : 1;
            int i10 = this.f4666c;
            boolean z = i10 > 0 && i10 % 2 == 0;
            int i11 = this.f4665b;
            boolean z3 = i11 < 11;
            int[] iArr = new int[4];
            iArr[0] = i4 + 1;
            if (!pVar.f4686c) {
                if (z3) {
                    if (z || (i11 == 0 && length > (i8 = i4 + 3) && charSequence2.charAt(i8) == ':')) {
                        i11 = 10;
                        z = true;
                    } else {
                        i11 = 9;
                    }
                } else if (z || (i11 == 11 && length > (i7 = i4 + 3) && (charSequence2.charAt(i4 + 2) == ':' || charSequence2.charAt(i7) == ':'))) {
                    i11 = 21;
                    z = true;
                } else {
                    i11 = 20;
                }
            }
            switch (i11) {
                case 0:
                case 11:
                    c(charSequence2, z3, iArr);
                    break;
                case 1:
                case 2:
                case 13:
                    c(charSequence2, z3, iArr);
                    d(charSequence2, z, false, iArr);
                    break;
                case 3:
                case 4:
                case 15:
                    c(charSequence2, z3, iArr);
                    d(charSequence2, z, true, iArr);
                    break;
                case 5:
                case 6:
                case 17:
                    c(charSequence2, z3, iArr);
                    d(charSequence2, z, true, iArr);
                    b(charSequence2, z, 3, iArr);
                    break;
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                case 19:
                    c(charSequence2, z3, iArr);
                    d(charSequence2, z, true, iArr);
                    if (!b(charSequence2, z, 3, iArr)) {
                        iArr[0] = ~iArr[0];
                        break;
                    }
                    break;
                case 9:
                case 10:
                case 21:
                    c(charSequence2, z3, iArr);
                    if (b(charSequence2, z, 2, iArr)) {
                        b(charSequence2, z, 3, iArr);
                        break;
                    }
                    break;
                case 12:
                    e(charSequence2, 1, 4, iArr);
                    break;
                case 14:
                    e(charSequence2, 3, 4, iArr);
                    break;
                case 16:
                    e(charSequence2, 3, 6, iArr);
                    break;
                case 18:
                    e(charSequence2, 5, 6, iArr);
                    break;
                case 20:
                    e(charSequence2, 1, 6, iArr);
                    break;
            }
            int i12 = iArr[0];
            if (i12 > 0) {
                int i13 = iArr[1];
                if (i13 > 23 || (i5 = iArr[2]) > 59 || (i6 = iArr[3]) > 59) {
                    throw new RuntimeException("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((i5 * 60) + (i13 * 3600) + i6) * i9, i4, i12);
            }
        }
        return length2 == 0 ? pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i4, i4) : ~i4;
    }

    public static void c(CharSequence charSequence, boolean z, int[] iArr) {
        if (z) {
            if (b(charSequence, false, 1, iArr)) {
                return;
            }
            iArr[0] = ~iArr[0];
            return;
        }
        e(charSequence, 1, 2, iArr);
    }

    public static void d(CharSequence charSequence, boolean z, boolean z3, int[] iArr) {
        if (b(charSequence, z, 2, iArr) || !z3) {
            return;
        }
        iArr[0] = ~iArr[0];
    }

    public static boolean b(CharSequence charSequence, boolean z, int i4, int[] iArr) {
        int i5 = iArr[0];
        if (i5 < 0) {
            return true;
        }
        if (z && i4 != 1) {
            int i6 = i5 + 1;
            if (i6 <= charSequence.length() && charSequence.charAt(i5) == ':') {
                i5 = i6;
            }
            return false;
        }
        int i7 = i5 + 2;
        if (i7 <= charSequence.length()) {
            int i8 = i5 + 1;
            char charAt = charSequence.charAt(i5);
            char charAt2 = charSequence.charAt(i8);
            if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                int i9 = (charAt2 - '0') + ((charAt - '0') * 10);
                if (i9 >= 0 && i9 <= 59) {
                    iArr[i4] = i9;
                    iArr[0] = i7;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        r12[0] = ~r12[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.CharSequence r9, int r10, int r11, int[] r12) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.i.e(java.lang.CharSequence, int, int, int[]):void");
    }

    public final String toString() {
        String replace = this.f4664a.replace("'", "''");
        return "Offset(" + f4661d[this.f4665b] + ",'" + replace + "')";
    }
}
