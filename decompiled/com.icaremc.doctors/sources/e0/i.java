package e0;

import a0.C0063e;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i extends s {
    public static final String[] y = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: x, reason: collision with root package name */
    public final int f2197x;

    public i(int i2) {
        this.f2197x = i2;
    }

    public static void H(z zVar) {
        int visibility = zVar.f2248b.getVisibility();
        HashMap hashMap = zVar.f2247a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = zVar.f2248b;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, e0.F] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e0.F J(e0.z r8, e0.z r9) {
        /*
            e0.F r0 = new e0.F
            r0.<init>()
            r1 = 0
            r0.f2173a = r1
            r0.f2174b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f2247a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f2175c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f2177e = r6
            goto L33
        L2f:
            r0.f2175c = r3
            r0.f2177e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f2247a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f2176d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f2178f = r2
            goto L56
        L52:
            r0.f2176d = r3
            r0.f2178f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f2175c
            int r9 = r0.f2176d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f2177e
            android.view.ViewGroup r4 = r0.f2178f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f2174b = r1
            r0.f2173a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f2174b = r2
            r0.f2173a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f2178f
            if (r8 != 0) goto L81
            r0.f2174b = r1
            r0.f2173a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.f2177e
            if (r8 != 0) goto L9f
            r0.f2174b = r2
            r0.f2173a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f2176d
            if (r8 != 0) goto L95
            r0.f2174b = r2
            r0.f2173a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f2175c
            if (r8 != 0) goto L9f
            r0.f2174b = r1
            r0.f2173a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.i.J(e0.z, e0.z):e0.F");
    }

    public final ObjectAnimator I(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        A.f2157a.P(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, A.f2158b, f3);
        ofFloat.addListener(new C0063e(view));
        a(new h(0, view));
        return ofFloat;
    }

    @Override // e0.s
    public final void e(z zVar) {
        H(zVar);
    }

    @Override // e0.s
    public final void h(z zVar) {
        H(zVar);
        zVar.f2247a.put("android:fade:transitionAlpha", Float.valueOf(A.f2157a.C(zVar.f2248b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (J(o(r3, false), r(r3, false)).f2173a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020b  */
    @Override // e0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator l(android.view.ViewGroup r24, e0.z r25, e0.z r26) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.i.l(android.view.ViewGroup, e0.z, e0.z):android.animation.Animator");
    }

    @Override // e0.s
    public final String[] q() {
        return y;
    }

    @Override // e0.s
    public final boolean s(z zVar, z zVar2) {
        if (zVar != null || zVar2 != null) {
            if (zVar == null || zVar2 == null || zVar2.f2247a.containsKey("android:visibility:visibility") == zVar.f2247a.containsKey("android:visibility:visibility")) {
                F J2 = J(zVar, zVar2);
                if (J2.f2173a) {
                    if (J2.f2175c == 0 || J2.f2176d == 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
