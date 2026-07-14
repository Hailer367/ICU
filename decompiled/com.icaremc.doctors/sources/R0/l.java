package R0;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class l extends k {
    public static int O(Iterable iterable) {
        kotlin.jvm.internal.h.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
