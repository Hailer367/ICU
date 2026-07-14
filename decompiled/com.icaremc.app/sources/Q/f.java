package Q;

import T2.h;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f1491a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f1492b;

    public f(SharedPreferences sharedPreferences, Set set) {
        h.e(sharedPreferences, "prefs");
        this.f1491a = sharedPreferences;
        this.f1492b = set;
    }
}
