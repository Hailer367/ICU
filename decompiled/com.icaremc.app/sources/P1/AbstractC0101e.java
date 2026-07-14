package P1;

import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: P1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0101e {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f1409a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static boolean a(Resources resources, int i4) {
        if (Build.VERSION.SDK_INT == 26) {
            try {
                if (G.a.r(resources.getDrawable(i4, null))) {
                    Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i4);
                    return false;
                }
                return true;
            } catch (Resources.NotFoundException unused) {
                Log.e("FirebaseMessaging", "Couldn't find resource " + i4 + ", treating it as an invalid icon");
                return false;
            }
        }
        return true;
    }
}
