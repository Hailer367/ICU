package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e0 {
    public static d0 a(Object obj) {
        AbstractC0165w abstractC0165w = (AbstractC0165w) obj;
        d0 d0Var = abstractC0165w.unknownFields;
        if (d0Var == d0.f2626f) {
            d0 d0Var2 = new d0(0, new int[8], new Object[8], true);
            abstractC0165w.unknownFields = d0Var2;
            return d0Var2;
        }
        return d0Var;
    }

    public static boolean b(int i4, C0154k c0154k, Object obj) {
        AbstractC0153j abstractC0153j = c0154k.f2664a;
        int i5 = c0154k.f2665b;
        int i6 = i5 >>> 3;
        int i7 = i5 & 7;
        if (i7 != 0) {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 3) {
                        if (i7 == 4) {
                            return false;
                        }
                        if (i7 == 5) {
                            c0154k.w(5);
                            ((d0) obj).c(5 | (i6 << 3), Integer.valueOf(abstractC0153j.j()));
                            return true;
                        }
                        throw A.b();
                    }
                    d0 d0Var = new d0(0, new int[8], new Object[8], true);
                    int i8 = i6 << 3;
                    int i9 = i8 | 4;
                    int i10 = i4 + 1;
                    if (i10 >= 100) {
                        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                    }
                    while (c0154k.a() != Integer.MAX_VALUE && b(i10, c0154k, d0Var)) {
                    }
                    if (i9 == c0154k.f2665b) {
                        if (d0Var.f2631e) {
                            d0Var.f2631e = false;
                        }
                        ((d0) obj).c(i8 | 3, d0Var);
                        return true;
                    }
                    throw new IOException("Protocol message end-group tag did not match expected tag.");
                }
                ((d0) obj).c((i6 << 3) | 2, c0154k.e());
                return true;
            }
            c0154k.w(1);
            ((d0) obj).c((i6 << 3) | 1, Long.valueOf(abstractC0153j.k()));
            return true;
        }
        c0154k.w(0);
        ((d0) obj).c(i6 << 3, Long.valueOf(abstractC0153j.n()));
        return true;
    }
}
