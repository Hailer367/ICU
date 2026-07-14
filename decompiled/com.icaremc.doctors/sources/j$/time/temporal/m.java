package j$.time.temporal;

/* loaded from: classes2.dex */
public interface m extends TemporalAccessor {
    m c(long j2, q qVar);

    m d(long j2, s sVar);

    /* renamed from: k */
    m m(j$.time.h hVar);

    default m a(long j2, s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }
}
