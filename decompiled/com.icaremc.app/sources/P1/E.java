package P1;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference f1351b;

    /* renamed from: a, reason: collision with root package name */
    public D2.L f1352a;

    public final synchronized D a() {
        String str;
        D d4;
        D2.L l3 = this.f1352a;
        synchronized (((ArrayDeque) l3.f299i)) {
            str = (String) ((ArrayDeque) l3.f299i).peek();
        }
        Pattern pattern = D.f1347d;
        d4 = null;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("!", -1);
            if (split.length == 2) {
                d4 = new D(split[0], split[1]);
            }
        }
        return d4;
    }
}
