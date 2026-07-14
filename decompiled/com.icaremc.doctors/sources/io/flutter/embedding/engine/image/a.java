package io.flutter.embedding.engine.image;

import android.app.ActivityManager;
import android.app.Person;
import android.os.Parcelable;
import android.view.DisplayCutout;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ ActivityManager.TaskDescription c(int i2, String str) {
        return new ActivityManager.TaskDescription(str, 0, i2);
    }

    public static /* bridge */ /* synthetic */ Person d(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ DisplayCutout i(Object obj) {
        return (DisplayCutout) obj;
    }

    public static /* bridge */ /* synthetic */ boolean o(Object obj) {
        return obj instanceof DisplayCutout;
    }
}
