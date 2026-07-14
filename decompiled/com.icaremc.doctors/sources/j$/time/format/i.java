package j$.time.format;

import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.encoders.json.BuildConfig;

/* loaded from: classes2.dex */
public final class i implements e {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f2564d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e, reason: collision with root package name */
    public static final i f2565e = new i("+HH:MM:ss", "Z");

    /* renamed from: f, reason: collision with root package name */
    public static final i f2566f = new i("+HH:MM:ss", "0");

    /* renamed from: a, reason: collision with root package name */
    public final String f2567a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2568b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2569c;

    public i(String str, String str2) {
        for (int i2 = 0; i2 < 22; i2++) {
            if (f2564d[i2].equals(str)) {
                this.f2568b = i2;
                this.f2569c = i2 % 11;
                this.f2567a = str2;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        Long a2 = sVar.a(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z = false;
        if (a2 == null) {
            return false;
        }
        int intExact = Math.toIntExact(a2.longValue());
        String str = this.f2567a;
        if (intExact == 0) {
            sb.append(str);
            return true;
        }
        int abs = Math.abs((intExact / 3600) % 100);
        int abs2 = Math.abs((intExact / 60) % 60);
        int abs3 = Math.abs(intExact % 60);
        int length = sb.length();
        sb.append(intExact < 0 ? "-" : "+");
        if (this.f2568b < 11 || abs >= 10) {
            a(false, abs, sb);
        } else {
            sb.append((char) (abs + 48));
        }
        int i2 = this.f2569c;
        if ((i2 >= 3 && i2 <= 8) || ((i2 >= 9 && abs3 > 0) || (i2 >= 1 && abs2 > 0))) {
            a(i2 > 0 && i2 % 2 == 0, abs2, sb);
            abs += abs2;
            if (i2 == 7 || i2 == 8 || (i2 >= 5 && abs3 > 0)) {
                if (i2 > 0 && i2 % 2 == 0) {
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

    public static void a(boolean z, int i2, StringBuilder sb) {
        sb.append(z ? ":" : BuildConfig.FLAVOR);
        sb.append((char) ((i2 / 10) + 48));
        sb.append((char) ((i2 % 10) + 48));
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i2) {
        CharSequence charSequence2;
        int i3;
        int i4;
        int i5;
        int i6;
        int length = charSequence.length();
        int length2 = this.f2567a.length();
        if (length2 == 0) {
            if (i2 == length) {
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i2, i2);
            }
            charSequence2 = charSequence;
        } else {
            if (i2 == length) {
                return ~i2;
            }
            charSequence2 = charSequence;
            if (pVar.g(charSequence2, i2, this.f2567a, 0, length2)) {
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i2, i2 + length2);
            }
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == '+' || charAt == '-') {
            int i7 = charAt == '-' ? -1 : 1;
            int i8 = this.f2569c;
            boolean z = i8 > 0 && i8 % 2 == 0;
            int i9 = this.f2568b;
            boolean z2 = i9 < 11;
            int[] iArr = new int[4];
            iArr[0] = i2 + 1;
            if (!pVar.f2589c) {
                if (z2) {
                    if (z || (i9 == 0 && length > (i6 = i2 + 3) && charSequence2.charAt(i6) == ':')) {
                        i9 = 10;
                        z = true;
                    } else {
                        i9 = 9;
                    }
                } else if (z || (i9 == 11 && length > (i5 = i2 + 3) && (charSequence2.charAt(i2 + 2) == ':' || charSequence2.charAt(i5) == ':'))) {
                    i9 = 21;
                    z = true;
                } else {
                    i9 = 20;
                }
            }
            switch (i9) {
                case 0:
                case 11:
                    c(charSequence2, z2, iArr);
                    break;
                case 1:
                case 2:
                case 13:
                    c(charSequence2, z2, iArr);
                    d(charSequence2, z, false, iArr);
                    break;
                case 3:
                case 4:
                case 15:
                    c(charSequence2, z2, iArr);
                    d(charSequence2, z, true, iArr);
                    break;
                case 5:
                case 6:
                case 17:
                    c(charSequence2, z2, iArr);
                    d(charSequence2, z, true, iArr);
                    b(charSequence2, z, 3, iArr);
                    break;
                case 7:
                case 8:
                case 19:
                    c(charSequence2, z2, iArr);
                    d(charSequence2, z, true, iArr);
                    if (!b(charSequence2, z, 3, iArr)) {
                        iArr[0] = ~iArr[0];
                        break;
                    }
                    break;
                case 9:
                case 10:
                case 21:
                    c(charSequence2, z2, iArr);
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
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    e(charSequence2, 5, 6, iArr);
                    break;
                case 20:
                    e(charSequence2, 1, 6, iArr);
                    break;
            }
            int i10 = iArr[0];
            if (i10 > 0) {
                int i11 = iArr[1];
                if (i11 > 23 || (i3 = iArr[2]) > 59 || (i4 = iArr[3]) > 59) {
                    throw new RuntimeException("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((i3 * 60) + (i11 * 3600) + i4) * i7, i2, i10);
            }
        }
        return length2 == 0 ? pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i2, i2) : ~i2;
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

    public static void d(CharSequence charSequence, boolean z, boolean z2, int[] iArr) {
        if (b(charSequence, z, 2, iArr) || !z2) {
            return;
        }
        iArr[0] = ~iArr[0];
    }

    public static boolean b(CharSequence charSequence, boolean z, int i2, int[] iArr) {
        int i3 = iArr[0];
        if (i3 < 0) {
            return true;
        }
        if (z && i2 != 1) {
            int i4 = i3 + 1;
            if (i4 <= charSequence.length() && charSequence.charAt(i3) == ':') {
                i3 = i4;
            }
            return false;
        }
        int i5 = i3 + 2;
        if (i5 <= charSequence.length()) {
            int i6 = i3 + 1;
            char charAt = charSequence.charAt(i3);
            char charAt2 = charSequence.charAt(i6);
            if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                int i7 = (charAt2 - '0') + ((charAt - '0') * 10);
                if (i7 >= 0 && i7 <= 59) {
                    iArr[i2] = i7;
                    iArr[0] = i5;
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
        String replace = this.f2567a.replace("'", "''");
        return "Offset(" + f2564d[this.f2568b] + ",'" + replace + "')";
    }
}
