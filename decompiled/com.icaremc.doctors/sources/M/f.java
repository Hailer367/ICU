package M;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f610a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f611b;

    public f(SharedPreferences prefs, Set set) {
        h.e(prefs, "prefs");
        this.f610a = prefs;
        this.f611b = set;
    }
}
