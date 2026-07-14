package k1;

/* loaded from: classes.dex */
public abstract class h extends g {
    public static final int N(CharSequence charSequence) {
        kotlin.jvm.internal.h.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int O(String str, String string, int i2, boolean z) {
        String str2;
        String str3;
        boolean z2;
        boolean regionMatches;
        kotlin.jvm.internal.h.e(string, "string");
        if (!z) {
            return str.indexOf(string, i2);
        }
        int length = str.length();
        if (i2 < 0) {
            i2 = 0;
        }
        int length2 = str.length();
        if (length > length2) {
            length = length2;
        }
        int i3 = new h1.a(i2, length, 1).f2322d;
        if (i2 <= i3) {
            int i4 = i2;
            while (true) {
                int length3 = string.length();
                if (!z) {
                    regionMatches = string.regionMatches(0, str, i4, length3);
                    str2 = str;
                    str3 = string;
                    z2 = z;
                } else {
                    str2 = str;
                    str3 = string;
                    z2 = z;
                    regionMatches = str3.regionMatches(z2, 0, str2, i4, length3);
                }
                if (regionMatches) {
                    return i4;
                }
                if (i4 != i3) {
                    i4++;
                    string = str3;
                    z = z2;
                    str = str2;
                } else {
                    return -1;
                }
            }
        } else {
            return -1;
        }
    }

    public static boolean P(CharSequence charSequence) {
        kotlin.jvm.internal.h.e(charSequence, "<this>");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static String Q(String str, String delimiter) {
        kotlin.jvm.internal.h.e(delimiter, "delimiter");
        int O2 = O(str, delimiter, 0, false);
        if (O2 == -1) {
            return str;
        }
        String substring = str.substring(delimiter.length() + O2, str.length());
        kotlin.jvm.internal.h.d(substring, "substring(...)");
        return substring;
    }
}
