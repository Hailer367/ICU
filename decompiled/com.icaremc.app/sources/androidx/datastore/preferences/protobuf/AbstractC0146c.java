package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0146c {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2621a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f2622b;

    static {
        Class<?> cls;
        boolean z;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f2621a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        if (cls2 != null) {
            z = true;
        } else {
            z = false;
        }
        f2622b = z;
    }

    public static boolean a() {
        if (f2621a != null && !f2622b) {
            return true;
        }
        return false;
    }
}
