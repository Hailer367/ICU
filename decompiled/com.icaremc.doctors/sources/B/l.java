package B;

import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public int f66a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f67b;

    public l(int i2) {
        if (i2 > 0) {
            this.f67b = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public l() {
        this.f66a = 1;
        this.f67b = Collections.singletonList(null);
    }

    public l(ArrayList arrayList) {
        this.f66a = 0;
        this.f67b = arrayList;
    }
}
