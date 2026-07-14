package e0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: b, reason: collision with root package name */
    public final View f2248b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2247a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2249c = new ArrayList();

    public z(View view) {
        this.f2248b = view;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.f2248b == zVar.f2248b && this.f2247a.equals(zVar.f2247a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2247a.hashCode() + (this.f2248b.hashCode() * 31);
    }

    public final String toString() {
        String f2 = O.a.f(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2248b + "\n", "    values:");
        HashMap hashMap = this.f2247a;
        for (String str : hashMap.keySet()) {
            f2 = f2 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return f2;
    }
}
