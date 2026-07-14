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
    m B(int i2);

    int C(m mVar, int i2);

    InterfaceC0206b G(TemporalAccessor temporalAccessor);

    InterfaceC0206b M();

    InterfaceC0206b Q(int i2, int i3, int i4);

    InterfaceC0206b S(Map map, j$.time.format.x xVar);

    ChronoZonedDateTime T(Instant instant, ZoneId zoneId);

    boolean equals(Object obj);

    int hashCode();

    InterfaceC0206b p(long j2);

    String q();

    String toString();

    String u();

    InterfaceC0206b v(int i2, int i3);

    j$.time.temporal.u y(j$.time.temporal.a aVar);

    List z();

    static l r(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.r.f2669b);
        s sVar = s.f2522c;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    static l of(String str) {
        ConcurrentHashMap concurrentHashMap = AbstractC0205a.f2489a;
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = AbstractC0205a.f2489a;
            l lVar = (l) concurrentHashMap2.get(str);
            if (lVar == null) {
                lVar = (l) AbstractC0205a.f2490b.get(str);
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
            o oVar = o.f2506l;
            oVar.getClass();
            AbstractC0205a.A(oVar, "Hijrah-umalqura");
            v vVar = v.f2525c;
            vVar.getClass();
            AbstractC0205a.A(vVar, "Japanese");
            A a2 = A.f2478c;
            a2.getClass();
            AbstractC0205a.A(a2, "Minguo");
            G g2 = G.f2485c;
            g2.getClass();
            AbstractC0205a.A(g2, "ThaiBuddhist");
            try {
                for (AbstractC0205a abstractC0205a : Arrays.asList(new AbstractC0205a[0])) {
                    if (!abstractC0205a.q().equals("ISO")) {
                        AbstractC0205a.A(abstractC0205a, abstractC0205a.q());
                    }
                }
                s sVar = s.f2522c;
                sVar.getClass();
                AbstractC0205a.A(sVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    default InterfaceC0209e H(LocalDateTime localDateTime) {
        try {
            return G(localDateTime).L(j$.time.l.F(localDateTime));
        } catch (j$.time.c e2) {
            throw new RuntimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e2);
        }
    }
}
