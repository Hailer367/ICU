package j$.time.format;

import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f2587a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2588b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2589c = true;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2590d;

    public p(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f2590d = arrayList;
        this.f2587a = dateTimeFormatter;
        arrayList.add(new w());
    }

    public final boolean a(char c2, char c3) {
        if (this.f2588b) {
            return c2 == c3;
        }
        return b(c2, c3);
    }

    public final boolean g(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4) {
        if (i2 + i4 <= charSequence.length() && i3 + i4 <= charSequence2.length()) {
            if (this.f2588b) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (charSequence.charAt(i2 + i5) == charSequence2.charAt(i3 + i5)) {
                    }
                }
                return true;
            }
            for (int i6 = 0; i6 < i4; i6++) {
                char charAt = charSequence.charAt(i2 + i6);
                char charAt2 = charSequence2.charAt(i3 + i6);
                if (charAt == charAt2 || Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(char c2, char c3) {
        return c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }

    public final w c() {
        return (w) this.f2590d.get(r0.size() - 1);
    }

    public final Long d(j$.time.temporal.a aVar) {
        return (Long) ((HashMap) c().f2601a).get(aVar);
    }

    public final int f(j$.time.temporal.q qVar, long j2, int i2, int i3) {
        Objects.requireNonNull(qVar, "field");
        Long l2 = (Long) ((HashMap) c().f2601a).put(qVar, Long.valueOf(j2));
        return (l2 == null || l2.longValue() == j2) ? i3 : ~i2;
    }

    public final void e(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        c().f2602b = zoneId;
    }

    public final String toString() {
        return c().toString();
    }
}
