package io.flutter.plugin.editing;

import android.app.job.JobWorkItem;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ JobWorkItem c(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* synthetic */ Locale.LanguageRange j(String str) {
        return new Locale.LanguageRange(str);
    }

    public static /* bridge */ /* synthetic */ Locale k(ArrayList arrayList, ArrayList arrayList2) {
        return Locale.lookup(arrayList, arrayList2);
    }

    public static /* synthetic */ void l() {
    }
}
