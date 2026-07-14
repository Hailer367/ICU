package P1;

import android.util.Log;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f1347d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    public final String f1348a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1349b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1350c;

    public D(String str, String str2) {
        String str3;
        if (str2 != null && str2.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            str3 = str2.substring(8);
        } else {
            str3 = str2;
        }
        if (str3 != null && f1347d.matcher(str3).matches()) {
            this.f1348a = str3;
            this.f1349b = str;
            this.f1350c = str + "!" + str2;
            return;
        }
        throw new IllegalArgumentException(r2.k.b("Invalid topic name: ", str3, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof D)) {
            return false;
        }
        D d4 = (D) obj;
        if (!this.f1348a.equals(d4.f1348a) || !this.f1349b.equals(d4.f1349b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1349b, this.f1348a});
    }
}
