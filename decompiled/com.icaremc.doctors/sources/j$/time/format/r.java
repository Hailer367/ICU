package j$.time.format;

import com.google.firebase.encoders.json.BuildConfig;
import j$.time.ZoneId;
import j$.time.chrono.InterfaceC0206b;
import j$.time.temporal.TemporalAccessor;

/* loaded from: classes2.dex */
public final class r implements TemporalAccessor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0206b f2591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemporalAccessor f2592b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.l f2593c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f2594d;

    public r(InterfaceC0206b interfaceC0206b, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f2591a = interfaceC0206b;
        this.f2592b = temporalAccessor;
        this.f2593c = lVar;
        this.f2594d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        InterfaceC0206b interfaceC0206b = this.f2591a;
        if (interfaceC0206b != null && qVar.isDateBased()) {
            return interfaceC0206b.h(qVar);
        }
        return this.f2592b.h(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        InterfaceC0206b interfaceC0206b = this.f2591a;
        if (interfaceC0206b != null && qVar.isDateBased()) {
            return interfaceC0206b.l(qVar);
        }
        return this.f2592b.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        InterfaceC0206b interfaceC0206b = this.f2591a;
        if (interfaceC0206b != null && qVar.isDateBased()) {
            return interfaceC0206b.i(qVar);
        }
        return this.f2592b.i(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f2669b) {
            return this.f2593c;
        }
        if (iVar == j$.time.temporal.r.f2668a) {
            return this.f2594d;
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return this.f2592b.b(iVar);
        }
        return iVar.k(this);
    }

    public final String toString() {
        String str;
        String str2 = BuildConfig.FLAVOR;
        j$.time.chrono.l lVar = this.f2593c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = BuildConfig.FLAVOR;
        }
        ZoneId zoneId = this.f2594d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f2592b + str + str2;
    }
}
