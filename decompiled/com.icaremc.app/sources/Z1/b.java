package Z1;

import T1.s;
import T1.t;
import a2.C0143a;
import b2.C0223a;
import b2.C0224b;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class b extends s {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2194b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f2195a;

    /* loaded from: classes.dex */
    public class a implements t {
        @Override // T1.t
        public final s create(T1.e eVar, C0143a c0143a) {
            if (c0143a.f2216a == Time.class) {
                return new b(0);
            }
            return null;
        }
    }

    public /* synthetic */ b(int i4) {
        this();
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        Time time;
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        synchronized (this) {
            TimeZone timeZone = this.f2195a.getTimeZone();
            try {
                try {
                    time = new Time(this.f2195a.parse(v3).getTime());
                } catch (ParseException e4) {
                    throw new RuntimeException("Failed parsing '" + v3 + "' as SQL Time; at path " + c0223a.j(), e4);
                }
            } finally {
                this.f2195a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String format;
        Time time = (Time) obj;
        if (time == null) {
            c0224b.i();
            return;
        }
        synchronized (this) {
            format = this.f2195a.format((Date) time);
        }
        c0224b.r(format);
    }

    private b() {
        this.f2195a = new SimpleDateFormat("hh:mm:ss a");
    }
}
