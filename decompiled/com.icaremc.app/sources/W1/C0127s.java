package W1;

import a2.C0143a;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: W1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0127s implements T1.t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1963f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1964g;

    public /* synthetic */ C0127s(int i4, Object obj) {
        this.f1963f = i4;
        this.f1964g = obj;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        switch (this.f1963f) {
            case 0:
                if (c0143a.f2216a == Number.class) {
                    return (C0128t) this.f1964g;
                }
                return null;
            case 1:
                if (c0143a.f2216a == Object.class) {
                    return new C0129u(eVar, (T1.q) this.f1964g);
                }
                return null;
            default:
                Class cls = c0143a.f2216a;
                if (cls != Calendar.class && cls != GregorianCalendar.class) {
                    return null;
                }
                return (W) this.f1964g;
        }
    }

    public String toString() {
        switch (this.f1963f) {
            case 2:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((W) this.f1964g) + "]";
            default:
                return super.toString();
        }
    }
}
