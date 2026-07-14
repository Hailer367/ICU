package T1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public final class b extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1605a;

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        switch (this.f1605a) {
            case 0:
                if (c0223a.x() == 9) {
                    c0223a.t();
                    return null;
                }
                return Double.valueOf(c0223a.o());
            case 1:
                if (c0223a.x() == 9) {
                    c0223a.t();
                    return null;
                }
                return Float.valueOf((float) c0223a.o());
            default:
                c0223a.D();
                return null;
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        switch (this.f1605a) {
            case 0:
                Number number = (Number) obj;
                if (number == null) {
                    c0224b.i();
                    return;
                }
                double doubleValue = number.doubleValue();
                e.a(doubleValue);
                c0224b.n(doubleValue);
                return;
            case 1:
                Number number2 = (Number) obj;
                if (number2 == null) {
                    c0224b.i();
                    return;
                }
                float floatValue = number2.floatValue();
                e.a(floatValue);
                if (!(number2 instanceof Float)) {
                    number2 = Float.valueOf(floatValue);
                }
                c0224b.q(number2);
                return;
            default:
                c0224b.i();
                return;
        }
    }

    public String toString() {
        switch (this.f1605a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }
}
