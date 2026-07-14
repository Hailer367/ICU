package j$.time.temporal;

import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* loaded from: classes2.dex */
public interface q {
    u A(TemporalAccessor temporalAccessor);

    u I();

    long P(TemporalAccessor temporalAccessor);

    m V(m mVar, long j4);

    boolean isDateBased();

    boolean s(TemporalAccessor temporalAccessor);

    default TemporalAccessor F(Map map, w wVar, x xVar) {
        return null;
    }
}
