package W1;

import b2.C0223a;
import b2.C0224b;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class X extends T1.s {
    @Override // T1.s
    public final Object b(C0223a c0223a) {
        String str;
        String str2;
        String str3 = null;
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(c0223a.v(), "_");
        if (stringTokenizer.hasMoreElements()) {
            str = stringTokenizer.nextToken();
        } else {
            str = null;
        }
        if (stringTokenizer.hasMoreElements()) {
            str2 = stringTokenizer.nextToken();
        } else {
            str2 = null;
        }
        if (stringTokenizer.hasMoreElements()) {
            str3 = stringTokenizer.nextToken();
        }
        if (str2 == null && str3 == null) {
            return new Locale(str);
        }
        if (str3 == null) {
            return new Locale(str, str2);
        }
        return new Locale(str, str2, str3);
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String locale;
        Locale locale2 = (Locale) obj;
        if (locale2 == null) {
            locale = null;
        } else {
            locale = locale2.toString();
        }
        c0224b.r(locale);
    }
}
