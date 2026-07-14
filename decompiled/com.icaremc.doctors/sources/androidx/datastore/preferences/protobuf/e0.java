package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e0 {
    public static d0 a(Object obj) {
        AbstractC0095w abstractC0095w = (AbstractC0095w) obj;
        d0 d0Var = abstractC0095w.unknownFields;
        if (d0Var == d0.f1408f) {
            d0 d0Var2 = new d0(0, new int[8], new Object[8], true);
            abstractC0095w.unknownFields = d0Var2;
            return d0Var2;
        }
        return d0Var;
    }

    public static boolean b(int i2, C0084k c0084k, Object obj) {
        AbstractC0083j abstractC0083j = c0084k.f1447a;
        int i3 = c0084k.f1448b;
        int i4 = i3 >>> 3;
        int i5 = i3 & 7;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            return false;
                        }
                        if (i5 == 5) {
                            c0084k.w(5);
                            ((d0) obj).c(5 | (i4 << 3), Integer.valueOf(abstractC0083j.j()));
                            return true;
                        }
                        throw A.b();
                    }
                    d0 d0Var = new d0(0, new int[8], new Object[8], true);
                    int i6 = i4 << 3;
                    int i7 = i6 | 4;
                    int i8 = i2 + 1;
                    if (i8 >= 100) {
                        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                    }
                    while (c0084k.a() != Integer.MAX_VALUE && b(i8, c0084k, d0Var)) {
                    }
                    if (i7 == c0084k.f1448b) {
                        if (d0Var.f1413e) {
                            d0Var.f1413e = false;
                        }
                        ((d0) obj).c(i6 | 3, d0Var);
                        return true;
                    }
                    throw new IOException("Protocol message end-group tag did not match expected tag.");
                }
                ((d0) obj).c((i4 << 3) | 2, c0084k.e());
                return true;
            }
            c0084k.w(1);
            ((d0) obj).c((i4 << 3) | 1, Long.valueOf(abstractC0083j.k()));
            return true;
        }
        c0084k.w(0);
        ((d0) obj).c(i4 << 3, Long.valueOf(abstractC0083j.n()));
        return true;
    }
}
