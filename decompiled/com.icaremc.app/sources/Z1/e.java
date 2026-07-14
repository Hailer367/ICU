package Z1;

import W1.AbstractC0116g;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public final class e extends AbstractC0116g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2198b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Class cls, int i4) {
        super(cls);
        this.f2198b = i4;
    }

    @Override // W1.AbstractC0116g
    public final Date a(Date date) {
        switch (this.f2198b) {
            case 0:
                return new java.sql.Date(date.getTime());
            default:
                return new Timestamp(date.getTime());
        }
    }
}
