package io.flutter.plugin.editing;

import android.app.job.JobWorkItem;
import android.content.Intent;
import android.view.autofill.AutofillManager;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ JobWorkItem c(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* bridge */ /* synthetic */ Class h() {
        return AutofillManager.class;
    }

    public static /* synthetic */ Locale.LanguageRange j(String str) {
        return new Locale.LanguageRange(str);
    }

    public static /* synthetic */ void l() {
    }
}
