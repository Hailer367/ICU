package f1;

import java.util.Random;

/* loaded from: classes.dex */
public abstract class a extends d {
    @Override // f1.d
    public final int a(int i2) {
        return b().nextInt(i2);
    }

    public abstract Random b();
}
