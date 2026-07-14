package F;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f265c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f266d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f267e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f268f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f269a;

    /* renamed from: b, reason: collision with root package name */
    public final int f270b;

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0203, code lost:
    
        if (r4 >= 3600001) goto L67;
     */
    static {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F.d.<clinit>():void");
    }

    public d(Object obj, int i2, Class cls) {
        this.f270b = i2;
        if (obj == null) {
            this.f269a = new AccessibilityNodeInfo.AccessibilityAction(i2, null);
        } else {
            this.f269a = obj;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        Object obj2 = ((d) obj).f269a;
        Object obj3 = this.f269a;
        if (obj3 == null) {
            if (obj2 != null) {
                return false;
            }
            return true;
        }
        if (!obj3.equals(obj2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.f269a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String b2 = g.b(this.f270b);
        if (b2.equals("ACTION_UNKNOWN")) {
            Object obj = this.f269a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                b2 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(b2);
        return sb.toString();
    }
}
