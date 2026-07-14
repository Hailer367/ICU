package W1;

import b2.C0223a;
import b2.C0224b;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* renamed from: W1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0117h extends T1.s {

    /* renamed from: c, reason: collision with root package name */
    public static final C0114e f1911c = new C0114e();

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0116g f1912a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1913b;

    public C0117h(AbstractC0116g abstractC0116g) {
        ArrayList arrayList = new ArrayList();
        this.f1913b = arrayList;
        Objects.requireNonNull(abstractC0116g);
        this.f1912a = abstractC0116g;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (V1.i.f1739a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        Date b4;
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        String v3 = c0223a.v();
        synchronized (this.f1913b) {
            try {
                ArrayList arrayList = this.f1913b;
                int size = arrayList.size();
                int i4 = 0;
                while (true) {
                    if (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        DateFormat dateFormat = (DateFormat) obj;
                        TimeZone timeZone = dateFormat.getTimeZone();
                        try {
                            try {
                                b4 = dateFormat.parse(v3);
                                break;
                            } finally {
                                dateFormat.setTimeZone(timeZone);
                            }
                        } catch (ParseException unused) {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } else {
                        try {
                            b4 = X1.a.b(v3, new ParsePosition(0));
                            break;
                        } catch (ParseException e4) {
                            throw new RuntimeException("Failed parsing '" + v3 + "' as Date; at path " + c0223a.j(), e4);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f1912a.a(b4);
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            c0224b.i();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f1913b.get(0);
        synchronized (this.f1913b) {
            format = dateFormat.format(date);
        }
        c0224b.r(format);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f1913b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
