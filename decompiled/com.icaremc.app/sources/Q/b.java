package Q;

import T2.h;
import android.content.Context;

/* loaded from: classes.dex */
public abstract class b {
    public static final boolean a(Context context, String str) {
        h.e(context, "context");
        h.e(str, "name");
        return context.deleteSharedPreferences(str);
    }
}
