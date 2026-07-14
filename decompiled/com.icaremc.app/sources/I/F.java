package I;

import android.text.TextUtils;
import android.view.View;

/* loaded from: classes.dex */
public final class F extends H {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f689e;

    public F(int i4, Class cls, int i5, int i6, int i7) {
        this.f689e = i7;
        this.f691a = i4;
        this.f694d = cls;
        this.f693c = i5;
        this.f692b = i6;
    }

    @Override // I.H
    public final Object b(View view) {
        switch (this.f689e) {
            case 0:
                return Boolean.valueOf(N.c(view));
            case 1:
                return N.a(view);
            case 2:
                return P.b(view);
            default:
                return Boolean.valueOf(N.b(view));
        }
    }

    @Override // I.H
    public final void c(View view, Object obj) {
        switch (this.f689e) {
            case 0:
                N.f(view, ((Boolean) obj).booleanValue());
                return;
            case 1:
                N.e(view, (CharSequence) obj);
                return;
            case 2:
                P.c(view, (CharSequence) obj);
                return;
            default:
                N.d(view, ((Boolean) obj).booleanValue());
                return;
        }
    }

    @Override // I.H
    public final boolean e(Object obj, Object obj2) {
        boolean z;
        boolean z3;
        boolean equals;
        boolean z4;
        boolean z5;
        switch (this.f689e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                boolean z6 = false;
                if (bool != null && bool.booleanValue()) {
                    z = true;
                } else {
                    z = false;
                }
                if (bool2 != null && bool2.booleanValue()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z == z3) {
                    z6 = true;
                }
                return !z6;
            case 1:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                boolean z7 = false;
                if (bool3 != null && bool3.booleanValue()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (bool4 != null && bool4.booleanValue()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 == z5) {
                    z7 = true;
                }
                return !z7;
        }
        return !equals;
    }
}
