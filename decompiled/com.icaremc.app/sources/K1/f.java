package K1;

import Z0.r;

/* loaded from: classes.dex */
public final class f extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(str);
        r.d(str, "Detail message must not be empty");
    }
}
