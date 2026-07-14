package I2;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f extends android.support.v4.media.session.a {
    public static List C(Object... objArr) {
        if (objArr.length > 0) {
            List asList = Arrays.asList(objArr);
            T2.h.d(asList, "asList(...)");
            return asList;
        }
        return m.f862f;
    }
}
