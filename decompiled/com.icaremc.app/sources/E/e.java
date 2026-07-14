package E;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f453b = new e(new f(new LocaleList(new Locale[0])));

    /* renamed from: a, reason: collision with root package name */
    public final f f454a;

    public e(f fVar) {
        this.f454a = fVar;
    }

    public static e a(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i4 = 0; i4 < length; i4++) {
                localeArr[i4] = Locale.forLanguageTag(split[i4]);
            }
            return new e(new f(new LocaleList(localeArr)));
        }
        return f453b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            if (this.f454a.equals(((e) obj).f454a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f454a.f455a.hashCode();
    }

    public final String toString() {
        return this.f454a.f455a.toString();
    }
}
