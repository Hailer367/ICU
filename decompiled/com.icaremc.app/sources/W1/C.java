package W1;

import a2.C0143a;
import com.dexterous.flutterlocalnotifications.models.ScheduleMode;

/* loaded from: classes.dex */
public final class C implements T1.t {

    /* renamed from: f, reason: collision with root package name */
    public final C0143a f1887f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1888g;

    /* renamed from: h, reason: collision with root package name */
    public final T1.g f1889h;

    public C(ScheduleMode.a aVar, C0143a c0143a, boolean z) {
        this.f1889h = aVar;
        this.f1887f = c0143a;
        this.f1888g = z;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        C0143a c0143a2 = this.f1887f;
        if (c0143a2 != null) {
            if (!c0143a2.equals(c0143a) && (!this.f1888g || c0143a2.f2217b != c0143a.f2216a)) {
                return null;
            }
            return new D(this.f1889h, eVar, c0143a, this, true);
        }
        Class cls = c0143a.f2216a;
        throw null;
    }
}
