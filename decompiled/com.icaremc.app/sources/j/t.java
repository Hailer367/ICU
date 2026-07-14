package j;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes.dex */
public abstract class t {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (!locales.equals(locales2)) {
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    public static E.e b(Configuration configuration) {
        return E.e.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(E.e eVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(eVar.f454a.f455a.toLanguageTags()));
    }

    public static void d(Configuration configuration, E.e eVar) {
        configuration.setLocales(LocaleList.forLanguageTags(eVar.f454a.f455a.toLanguageTags()));
    }
}
