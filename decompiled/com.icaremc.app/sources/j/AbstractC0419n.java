package j;

import android.app.LocaleManager;
import android.os.LocaleList;

/* renamed from: j.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0419n {
    public static LocaleList a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    public static void b(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}
