package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class J {
    public static I a(Object obj, Object obj2) {
        I i2 = (I) obj;
        I i3 = (I) obj2;
        if (!i3.isEmpty()) {
            if (!i2.f1350c) {
                i2 = i2.b();
            }
            i2.a();
            if (!i3.isEmpty()) {
                i2.putAll(i3);
            }
        }
        return i2;
    }
}
