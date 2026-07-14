package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC0384b;
import j$.time.temporal.TemporalAccessor;

/* loaded from: classes2.dex */
public final class r implements TemporalAccessor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0384b f4688a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemporalAccessor f4689b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.l f4690c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f4691d;

    public r(InterfaceC0384b interfaceC0384b, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f4688a = interfaceC0384b;
        this.f4689b = temporalAccessor;
        this.f4690c = lVar;
        this.f4691d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        InterfaceC0384b interfaceC0384b = this.f4688a;
        if (interfaceC0384b != null && qVar.isDateBased()) {
            return interfaceC0384b.h(qVar);
        }
        return this.f4689b.h(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        InterfaceC0384b interfaceC0384b = this.f4688a;
        if (interfaceC0384b != null && qVar.isDateBased()) {
            return interfaceC0384b.l(qVar);
        }
        return this.f4689b.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        InterfaceC0384b interfaceC0384b = this.f4688a;
        if (interfaceC0384b != null && qVar.isDateBased()) {
            return interfaceC0384b.i(qVar);
        }
        return this.f4689b.i(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f4766b) {
            return this.f4690c;
        }
        if (iVar == j$.time.temporal.r.f4765a) {
            return this.f4691d;
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return this.f4689b.b(iVar);
        }
        return iVar.k(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.f4690c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f4691d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f4689b + str + str2;
    }
}
