package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public interface l extends Comparable {
    m B(int i4);

    int C(m mVar, int i4);

    InterfaceC0384b G(TemporalAccessor temporalAccessor);

    InterfaceC0384b M();

    InterfaceC0384b Q(int i4, int i5, int i6);

    InterfaceC0384b S(Map map, j$.time.format.x xVar);

    ChronoZonedDateTime T(Instant instant, ZoneId zoneId);

    boolean equals(Object obj);

    int hashCode();

    InterfaceC0384b p(long j4);

    String q();

    String toString();

    String u();

    InterfaceC0384b v(int i4, int i5);

    j$.time.temporal.u y(j$.time.temporal.a aVar);

    List z();

    static l r(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.r.f4766b);
        s sVar = s.f4619c;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    static l of(String str) {
        ConcurrentHashMap concurrentHashMap = AbstractC0383a.f4587a;
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = AbstractC0383a.f4587a;
            l lVar = (l) concurrentHashMap2.get(str);
            if (lVar == null) {
                lVar = (l) AbstractC0383a.f4588b.get(str);
            }
            if (lVar != null) {
                return lVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                Iterator it = ServiceLoader.load(l.class).iterator();
                while (it.hasNext()) {
                    l lVar2 = (l) it.next();
                    if (str.equals(lVar2.q()) || str.equals(lVar2.u())) {
                        return lVar2;
                    }
                }
                throw new RuntimeException("Unknown chronology: ".concat(str));
            }
            o oVar = o.f4604l;
            oVar.getClass();
            AbstractC0383a.A(oVar, "Hijrah-umalqura");
            v vVar = v.f4622c;
            vVar.getClass();
            AbstractC0383a.A(vVar, "Japanese");
            A a4 = A.f4576c;
            a4.getClass();
            AbstractC0383a.A(a4, "Minguo");
            G g4 = G.f4583c;
            g4.getClass();
            AbstractC0383a.A(g4, "ThaiBuddhist");
            try {
                for (AbstractC0383a abstractC0383a : Arrays.asList(new AbstractC0383a[0])) {
                    if (!abstractC0383a.q().equals("ISO")) {
                        AbstractC0383a.A(abstractC0383a, abstractC0383a.q());
                    }
                }
                s sVar = s.f4619c;
                sVar.getClass();
                AbstractC0383a.A(sVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    default InterfaceC0387e H(LocalDateTime localDateTime) {
        try {
            return G(localDateTime).L(j$.time.l.F(localDateTime));
        } catch (j$.time.c e4) {
            throw new RuntimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e4);
        }
    }
}
