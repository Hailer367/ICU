package b0;

import androidx.fragment.app.T;
import androidx.lifecycle.S;
import t.C0662k;

/* loaded from: classes.dex */
public class b extends S {

    /* renamed from: e, reason: collision with root package name */
    public static final T f3204e = new T(1);

    /* renamed from: d, reason: collision with root package name */
    public final C0662k f3205d = new C0662k();

    @Override // androidx.lifecycle.S
    public final void b() {
        C0662k c0662k = this.f3205d;
        int i4 = c0662k.f6199h;
        if (i4 <= 0) {
            Object[] objArr = c0662k.f6198g;
            for (int i5 = 0; i5 < i4; i5++) {
                objArr[i5] = null;
            }
            c0662k.f6199h = 0;
            return;
        }
        c0662k.f6198g[0].getClass();
        throw new ClassCastException();
    }
}
