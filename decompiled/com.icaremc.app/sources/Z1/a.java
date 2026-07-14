package Z1;

import T1.s;
import T1.t;
import a2.C0143a;
import b2.C0223a;
import b2.C0224b;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class a extends s {

    /* renamed from: b, reason: collision with root package name */
    public static final C0000a f2192b = new C0000a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f2193a;

    /* renamed from: Z1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a implements t {
        @Override // T1.t
        public final s create(T1.e eVar, C0143a c0143a) {
            if (c0143a.f2216a == Date.class) {
                return new a(0);
            }
            return null;
        }
    }

    public /* synthetic */ a(int i4) {
        this();
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        Date date;
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        synchronized (this) {
            TimeZone timeZone = this.f2193a.getTimeZone();
            try {
                try {
                    date = new Date(this.f2193a.parse(v3).getTime());
                } catch (ParseException e4) {
                    throw new RuntimeException("Failed parsing '" + v3 + "' as SQL Date; at path " + c0223a.j(), e4);
                }
            } finally {
                this.f2193a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            c0224b.i();
            return;
        }
        synchronized (this) {
            format = this.f2193a.format((java.util.Date) date);
        }
        c0224b.r(format);
    }

    private a() {
        this.f2193a = new SimpleDateFormat("MMM d, yyyy");
    }
}
