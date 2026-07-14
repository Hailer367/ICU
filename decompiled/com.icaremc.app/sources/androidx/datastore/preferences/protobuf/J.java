package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class J {
    public static I a(Object obj, Object obj2) {
        I i4 = (I) obj;
        I i5 = (I) obj2;
        if (!i5.isEmpty()) {
            if (!i4.f2570f) {
                i4 = i4.b();
            }
            i4.a();
            if (!i5.isEmpty()) {
                i4.putAll(i5);
            }
        }
        return i4;
    }
}
