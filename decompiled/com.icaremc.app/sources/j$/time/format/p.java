package j$.time.format;

import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f4684a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4685b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4686c = true;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f4687d;

    public p(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f4687d = arrayList;
        this.f4684a = dateTimeFormatter;
        arrayList.add(new w());
    }

    public final boolean a(char c4, char c5) {
        if (this.f4685b) {
            return c4 == c5;
        }
        return b(c4, c5);
    }

    public final boolean g(CharSequence charSequence, int i4, CharSequence charSequence2, int i5, int i6) {
        if (i4 + i6 <= charSequence.length() && i5 + i6 <= charSequence2.length()) {
            if (this.f4685b) {
                for (int i7 = 0; i7 < i6; i7++) {
                    if (charSequence.charAt(i4 + i7) == charSequence2.charAt(i5 + i7)) {
                    }
                }
                return true;
            }
            for (int i8 = 0; i8 < i6; i8++) {
                char charAt = charSequence.charAt(i4 + i8);
                char charAt2 = charSequence2.charAt(i5 + i8);
                if (charAt == charAt2 || Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(char c4, char c5) {
        return c4 == c5 || Character.toUpperCase(c4) == Character.toUpperCase(c5) || Character.toLowerCase(c4) == Character.toLowerCase(c5);
    }

    public final w c() {
        return (w) this.f4687d.get(r0.size() - 1);
    }

    public final Long d(j$.time.temporal.a aVar) {
        return (Long) ((HashMap) c().f4698a).get(aVar);
    }

    public final int f(j$.time.temporal.q qVar, long j4, int i4, int i5) {
        Objects.requireNonNull(qVar, "field");
        Long l3 = (Long) ((HashMap) c().f4698a).put(qVar, Long.valueOf(j4));
        return (l3 == null || l3.longValue() == j4) ? i5 : ~i4;
    }

    public final void e(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        c().f4699b = zoneId;
    }

    public final String toString() {
        return c().toString();
    }
}
