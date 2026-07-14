package t2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import io.flutter.plugin.platform.s;
import java.util.ArrayList;
import java.util.Locale;
import n.p;
import s2.C0644p;

/* renamed from: t2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0664a {

    /* renamed from: a, reason: collision with root package name */
    public final s f6204a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6205b;

    public C0664a(Context context, s sVar) {
        p pVar = new p(18, this);
        this.f6205b = context;
        this.f6204a = sVar;
        sVar.f4391h = pVar;
    }

    public static Locale a(String str) {
        Locale.Builder builder = new Locale.Builder();
        String[] split = str.replace('_', '-').split("-");
        builder.setLanguage(split[0]);
        int i4 = 1;
        if (split.length > 1 && split[1].length() == 4) {
            builder.setScript(split[1]);
            i4 = 2;
        }
        if (split.length > i4 && split[i4].length() >= 2 && split[i4].length() <= 3) {
            builder.setRegion(split[i4]);
        }
        return builder.build();
    }

    public final void b(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(locales.get(i5));
        }
        s sVar = this.f6204a;
        sVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        while (i4 < size2) {
            Object obj = arrayList.get(i4);
            i4++;
            Locale locale = (Locale) obj;
            locale.getLanguage();
            locale.getCountry();
            locale.getVariant();
            arrayList2.add(locale.getLanguage());
            arrayList2.add(locale.getCountry());
            arrayList2.add(locale.getScript());
            arrayList2.add(locale.getVariant());
        }
        ((C0644p) sVar.f4390g).a("setLocale", arrayList2, null);
    }
}
