package com.dexterous.flutterlocalnotifications;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void C() {
    }

    public static /* bridge */ /* synthetic */ NotificationChannel d(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel e(String str, CharSequence charSequence, int i4) {
        return new NotificationChannel(str, charSequence, i4);
    }

    public static /* synthetic */ NotificationChannelGroup f(String str, String str2) {
        return new NotificationChannelGroup(str, str2);
    }

    public static /* bridge */ /* synthetic */ AutofillManager i(Object obj) {
        return (AutofillManager) obj;
    }

    public static /* bridge */ /* synthetic */ AutofillValue k(Object obj) {
        return (AutofillValue) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return AutofillManager.class;
    }

    public static /* synthetic */ void n() {
    }
}
