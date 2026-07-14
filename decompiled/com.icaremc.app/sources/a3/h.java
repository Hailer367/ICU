package a3;

/* loaded from: classes.dex */
public abstract class h extends g {
    public static final int C(CharSequence charSequence) {
        T2.h.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static boolean D(CharSequence charSequence) {
        T2.h.e(charSequence, "<this>");
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            char charAt = charSequence.charAt(i4);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static String E(String str, String str2) {
        T2.h.e(str2, "delimiter");
        T2.h.e(str2, "string");
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + indexOf, str.length());
        T2.h.d(substring, "substring(...)");
        return substring;
    }
}
