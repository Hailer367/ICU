package E;

import T2.h;
import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f450a = 0;

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            C.c.c(30);
        }
        if (i4 >= 30) {
            C.c.c(31);
        }
        if (i4 >= 30) {
            C.c.c(33);
        }
        if (i4 >= 30) {
            C.c.c(1000000);
        }
    }

    public static final boolean a() {
        Integer num;
        Integer num2 = 0;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 33) {
            if (i4 >= 32) {
                String str = Build.VERSION.CODENAME;
                h.d(str, "CODENAME");
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = str.toUpperCase(locale);
                    h.d(upperCase, "toUpperCase(...)");
                    if (upperCase.equals("BAKLAVA")) {
                        num = num2;
                    } else {
                        num = null;
                    }
                    String upperCase2 = "Tiramisu".toUpperCase(locale);
                    h.d(upperCase2, "toUpperCase(...)");
                    if (!upperCase2.equals("BAKLAVA")) {
                        num2 = null;
                    }
                    if (num != null && num2 != null) {
                        if (num.intValue() >= num2.intValue()) {
                            return true;
                        }
                    } else if (num == null && num2 == null) {
                        String upperCase3 = str.toUpperCase(locale);
                        h.d(upperCase3, "toUpperCase(...)");
                        String upperCase4 = "Tiramisu".toUpperCase(locale);
                        h.d(upperCase4, "toUpperCase(...)");
                        if (upperCase3.compareTo(upperCase4) >= 0) {
                            return true;
                        }
                    } else if (num != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
