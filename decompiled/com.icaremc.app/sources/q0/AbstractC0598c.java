package q0;

import android.os.Build;
import java.util.HashSet;

/* renamed from: q0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0598c implements InterfaceC0600e {

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f5863c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f5864a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5865b;

    public AbstractC0598c(String str, String str2) {
        this.f5864a = str;
        this.f5865b = str2;
        f5863c.add(this);
    }

    public abstract boolean a();

    public boolean b() {
        HashSet hashSet = AbstractC0596a.f5861a;
        String str = this.f5865b;
        if (!hashSet.contains(str)) {
            String str2 = Build.TYPE;
            if ("eng".equals(str2) || "userdebug".equals(str2)) {
                if (!hashSet.contains(str + ":dev")) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
}
