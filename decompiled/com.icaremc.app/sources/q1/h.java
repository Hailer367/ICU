package q1;

import android.os.Bundle;
import p1.C0580i;

/* loaded from: classes.dex */
public final class h extends g {
    @Override // q1.g, r1.h
    public final void e(Bundle bundle) {
        super.e(bundle);
        int i4 = bundle.getInt("error.code", -2);
        C0580i c0580i = this.f5959h;
        if (i4 != 0) {
            c0580i.c(new X0.i(bundle.getInt("error.code", -2)));
        } else {
            c0580i.d(null);
        }
    }
}
