package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC0206b;
import j$.time.temporal.TemporalAccessor;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final TemporalAccessor f2595a;

    /* renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f2596b;

    /* renamed from: c, reason: collision with root package name */
    public int f2597c;

    public s(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVar = dateTimeFormatter.f2547e;
        if (lVar != null) {
            j$.time.chrono.l lVar2 = (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.r.f2669b);
            ZoneId zoneId = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f2668a);
            InterfaceC0206b interfaceC0206b = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            if (lVar != null) {
                j$.time.chrono.l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (temporalAccessor.h(j$.time.temporal.a.EPOCH_DAY)) {
                        interfaceC0206b = lVar3.G(temporalAccessor);
                    } else if (lVar != j$.time.chrono.s.f2522c || lVar2 != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.isDateBased() && temporalAccessor.h(aVar)) {
                                throw new RuntimeException("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new r(interfaceC0206b, temporalAccessor, lVar3, zoneId);
            }
        }
        this.f2595a = temporalAccessor;
        this.f2596b = dateTimeFormatter;
    }

    public final Long a(j$.time.temporal.q qVar) {
        int i2 = this.f2597c;
        TemporalAccessor temporalAccessor = this.f2595a;
        if (i2 <= 0 || temporalAccessor.h(qVar)) {
            return Long.valueOf(temporalAccessor.i(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f2595a.toString();
    }
}
