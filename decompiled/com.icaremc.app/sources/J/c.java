package J;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f868c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f869d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f870e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f871f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f872a;

    /* renamed from: b, reason: collision with root package name */
    public final int f873b;

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0203, code lost:
    
        if (r4 >= 3600001) goto L67;
     */
    static {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J.c.<clinit>():void");
    }

    public c(Object obj, int i4, Class cls) {
        this.f873b = i4;
        if (obj == null) {
            this.f872a = new AccessibilityNodeInfo.AccessibilityAction(i4, null);
        } else {
            this.f872a = obj;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        Object obj2 = ((c) obj).f872a;
        Object obj3 = this.f872a;
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
        Object obj = this.f872a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String b4 = f.b(this.f873b);
        if (b4.equals("ACTION_UNKNOWN")) {
            Object obj = this.f872a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                b4 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(b4);
        return sb.toString();
    }
}
