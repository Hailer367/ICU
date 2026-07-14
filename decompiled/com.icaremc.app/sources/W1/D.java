package W1;

import a2.C0143a;
import b2.C0223a;
import b2.C0224b;
import com.dexterous.flutterlocalnotifications.models.ScheduleMode;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class D extends B {

    /* renamed from: a, reason: collision with root package name */
    public final T1.g f1890a;

    /* renamed from: b, reason: collision with root package name */
    public final T1.e f1891b;

    /* renamed from: c, reason: collision with root package name */
    public final C0143a f1892c;

    /* renamed from: d, reason: collision with root package name */
    public final T1.t f1893d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1894e;

    /* renamed from: f, reason: collision with root package name */
    public volatile T1.s f1895f;

    public D(T1.g gVar, T1.e eVar, C0143a c0143a, T1.t tVar, boolean z) {
        this.f1890a = gVar;
        this.f1891b = eVar;
        this.f1892c = c0143a;
        this.f1893d = tVar;
        this.f1894e = z;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (this.f1890a == null) {
            T1.s sVar = this.f1895f;
            if (sVar == null) {
                sVar = this.f1891b.d(this.f1893d, this.f1892c);
                this.f1895f = sVar;
            }
            return sVar.b(c0223a);
        }
        T1.h i4 = V1.d.i(c0223a);
        if (this.f1894e) {
            i4.getClass();
            if (i4 instanceof T1.j) {
                return null;
            }
        }
        Type type = this.f1892c.f2217b;
        try {
            return ScheduleMode.valueOf(i4.c());
        } catch (Exception unused) {
            if (i4.a()) {
                return ScheduleMode.exactAllowWhileIdle;
            }
            return ScheduleMode.exact;
        }
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        T1.s sVar = this.f1895f;
        if (sVar == null) {
            sVar = this.f1891b.d(this.f1893d, this.f1892c);
            this.f1895f = sVar;
        }
        sVar.c(c0224b, obj);
    }

    @Override // W1.B
    public final T1.s d() {
        T1.s sVar = this.f1895f;
        if (sVar != null) {
            return sVar;
        }
        T1.s d4 = this.f1891b.d(this.f1893d, this.f1892c);
        this.f1895f = d4;
        return d4;
    }
}
