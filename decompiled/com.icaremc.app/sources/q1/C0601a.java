package q1;

import android.app.PendingIntent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: q1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0601a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5933a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5934b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5935c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5936d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f5937e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5938f;

    /* renamed from: g, reason: collision with root package name */
    public final PendingIntent f5939g;

    /* renamed from: h, reason: collision with root package name */
    public final PendingIntent f5940h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f5941i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5942j = false;

    public C0601a(String str, int i4, int i5, int i6, Integer num, int i7, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, HashMap hashMap) {
        this.f5933a = str;
        this.f5934b = i4;
        this.f5935c = i5;
        this.f5936d = i6;
        this.f5937e = num;
        this.f5938f = i7;
        this.f5939g = pendingIntent;
        this.f5940h = pendingIntent2;
        this.f5941i = hashMap;
    }

    public final Set a(l lVar) {
        int i4 = lVar.f5969a;
        HashMap hashMap = this.f5941i;
        if (i4 == 0) {
            Set set = (Set) hashMap.get("nonblocking.intent");
            if (set == null) {
                return new HashSet();
            }
            return set;
        }
        Set set2 = (Set) hashMap.get("blocking.intent");
        if (set2 == null) {
            return new HashSet();
        }
        return set2;
    }

    public final PendingIntent b(l lVar) {
        PendingIntent pendingIntent;
        int i4 = lVar.f5969a;
        if (i4 == 0) {
            PendingIntent pendingIntent2 = this.f5940h;
            if (pendingIntent2 == null) {
                return null;
            }
            return pendingIntent2;
        }
        if (i4 != 1 || (pendingIntent = this.f5939g) == null) {
            return null;
        }
        return pendingIntent;
    }
}
