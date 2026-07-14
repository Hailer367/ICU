package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class C {
    public static InterfaceC0166x a(long j4, Object obj) {
        int i4;
        InterfaceC0166x interfaceC0166x = (InterfaceC0166x) j0.f2659c.h(j4, obj);
        if (!((AbstractC0145b) interfaceC0166x).f2618f) {
            U u3 = (U) interfaceC0166x;
            int i5 = u3.f2598h;
            if (i5 == 0) {
                i4 = 10;
            } else {
                i4 = i5 * 2;
            }
            U c4 = u3.c(i4);
            j0.o(j4, obj, c4);
            return c4;
        }
        return interfaceC0166x;
    }
}
