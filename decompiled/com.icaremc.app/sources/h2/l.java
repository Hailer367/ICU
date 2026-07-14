package h2;

import android.app.ActivityManager;
import android.app.Person;
import android.os.Parcelable;
import android.view.DisplayCutout;
import android.webkit.TracingConfig;

/* loaded from: classes.dex */
public abstract /* synthetic */ class l {
    public static /* synthetic */ ActivityManager.TaskDescription b(int i4, String str) {
        return new ActivityManager.TaskDescription(str, 0, i4);
    }

    public static /* bridge */ /* synthetic */ Person c(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ DisplayCutout h(Object obj) {
        return (DisplayCutout) obj;
    }

    public static /* synthetic */ TracingConfig.Builder i() {
        return new TracingConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj) {
        return obj instanceof DisplayCutout;
    }
}
