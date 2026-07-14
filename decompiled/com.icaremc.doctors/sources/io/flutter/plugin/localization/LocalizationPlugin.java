package io.flutter.plugin.localization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.plugin.editing.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class LocalizationPlugin {
    private final Context context;
    private final LocalizationChannel localizationChannel;

    @SuppressLint({"AppBundleLocaleChanges", "DiscouragedApi"})
    final LocalizationChannel.LocalizationMessageHandler localizationMessageHandler;

    public LocalizationPlugin(Context context, LocalizationChannel localizationChannel) {
        LocalizationChannel.LocalizationMessageHandler localizationMessageHandler = new LocalizationChannel.LocalizationMessageHandler() { // from class: io.flutter.plugin.localization.LocalizationPlugin.1
            @Override // io.flutter.embedding.engine.systemchannels.LocalizationChannel.LocalizationMessageHandler
            public String getStringResource(String str, String str2) {
                Context context2 = LocalizationPlugin.this.context;
                if (str2 != null) {
                    Locale localeFromString = LocalizationPlugin.localeFromString(str2);
                    Configuration configuration = new Configuration(LocalizationPlugin.this.context.getResources().getConfiguration());
                    configuration.setLocale(localeFromString);
                    context2 = LocalizationPlugin.this.context.createConfigurationContext(configuration);
                }
                int identifier = context2.getResources().getIdentifier(str, "string", LocalizationPlugin.this.context.getPackageName());
                if (identifier != 0) {
                    return context2.getResources().getString(identifier);
                }
                return null;
            }
        };
        this.localizationMessageHandler = localizationMessageHandler;
        this.context = context;
        this.localizationChannel = localizationChannel;
        localizationChannel.setLocalizationMessageHandler(localizationMessageHandler);
    }

    public static Locale localeFromString(String str) {
        Locale.Builder builder = new Locale.Builder();
        String[] split = str.replace('_', '-').split("-");
        builder.setLanguage(split[0]);
        int i2 = 1;
        if (split.length > 1 && split[1].length() == 4) {
            builder.setScript(split[1]);
            i2 = 2;
        }
        if (split.length > i2 && split[i2].length() >= 2 && split[i2].length() <= 3) {
            builder.setRegion(split[i2]);
        }
        return builder.build();
    }

    public Locale resolveNativeLocale(List<Locale> list) {
        Locale lookup;
        if (list != null && !list.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 26) {
                ArrayList arrayList = new ArrayList();
                LocaleList locales = this.context.getResources().getConfiguration().getLocales();
                int size = locales.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Locale locale = locales.get(i2);
                    String language = locale.getLanguage();
                    if (!locale.getScript().isEmpty()) {
                        language = language + "-" + locale.getScript();
                    }
                    if (!locale.getCountry().isEmpty()) {
                        language = language + "-" + locale.getCountry();
                    }
                    arrayList.add(a.j(language));
                    a.l();
                    arrayList.add(a.j(locale.getLanguage()));
                    a.l();
                    arrayList.add(a.j(locale.getLanguage() + "-*"));
                }
                lookup = Locale.lookup(arrayList, list);
                if (lookup != null) {
                    return lookup;
                }
            } else {
                LocaleList locales2 = this.context.getResources().getConfiguration().getLocales();
                for (int i3 = 0; i3 < locales2.size(); i3++) {
                    Locale locale2 = locales2.get(i3);
                    for (Locale locale3 : list) {
                        if (locale2.equals(locale3)) {
                            return locale3;
                        }
                    }
                    for (Locale locale4 : list) {
                        if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                            return locale4;
                        }
                    }
                    for (Locale locale5 : list) {
                        if (locale2.getLanguage().equals(locale5.getLanguage())) {
                            return locale5;
                        }
                    }
                }
            }
            return list.get(0);
        }
        return null;
    }

    public void sendLocalesToFlutter(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(locales.get(i2));
        }
        this.localizationChannel.sendLocales(arrayList);
    }
}
