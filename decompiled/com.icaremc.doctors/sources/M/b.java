package M;

import android.content.Context;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public abstract class b {
    public static final boolean a(Context context, String name) {
        h.e(context, "context");
        h.e(name, "name");
        return context.deleteSharedPreferences(name);
    }
}
