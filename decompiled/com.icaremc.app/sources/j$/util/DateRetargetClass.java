package j$.util;

import j$.time.Instant;
import java.util.Date;

/* loaded from: classes2.dex */
public final /* synthetic */ class DateRetargetClass {
    public static Instant toInstant(Date date) {
        long time = date.getTime();
        Instant instant = Instant.f4554c;
        long j4 = 1000;
        return Instant.s(Math.floorDiv(time, j4), ((int) Math.floorMod(time, j4)) * 1000000);
    }
}
