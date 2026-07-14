package j$.time.temporal;

/* loaded from: classes2.dex */
public interface m extends TemporalAccessor {
    m c(long j4, q qVar);

    m d(long j4, s sVar);

    /* renamed from: k */
    m m(j$.time.h hVar);

    default m a(long j4, s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }
}
