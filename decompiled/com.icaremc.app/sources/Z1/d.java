package Z1;

import T1.s;
import b2.C0223a;
import b2.C0224b;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public final class d extends s {

    /* renamed from: b, reason: collision with root package name */
    public static final c f2196b = new c();

    /* renamed from: a, reason: collision with root package name */
    public final s f2197a;

    public d(s sVar) {
        this.f2197a = sVar;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        Date date = (Date) this.f2197a.b(c0223a);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        this.f2197a.c(c0224b, (Timestamp) obj);
    }
}
