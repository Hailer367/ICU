package K1;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final long f933b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f934c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d, reason: collision with root package name */
    public static k f935d;

    /* renamed from: a, reason: collision with root package name */
    public final H1.f f936a;

    public k(H1.f fVar) {
        this.f936a = fVar;
    }

    public final boolean a(L1.b bVar) {
        if (!TextUtils.isEmpty(bVar.f1011c)) {
            long j4 = bVar.f1014f + bVar.f1013e;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f936a.getClass();
            if (j4 < timeUnit.toSeconds(System.currentTimeMillis()) + f933b) {
                return true;
            }
            return false;
        }
        return true;
    }
}
