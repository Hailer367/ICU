package L;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import o.C0462A0;

/* loaded from: classes.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: w, reason: collision with root package name */
    public static final int f952w = ViewConfiguration.getTapTimeout();

    /* renamed from: f, reason: collision with root package name */
    public final a f953f;

    /* renamed from: g, reason: collision with root package name */
    public final AccelerateInterpolator f954g;

    /* renamed from: h, reason: collision with root package name */
    public final C0462A0 f955h;

    /* renamed from: i, reason: collision with root package name */
    public F.b f956i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f957j;
    public final float[] k;

    /* renamed from: l, reason: collision with root package name */
    public final int f958l;

    /* renamed from: m, reason: collision with root package name */
    public final int f959m;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f960n;

    /* renamed from: o, reason: collision with root package name */
    public final float[] f961o;

    /* renamed from: p, reason: collision with root package name */
    public final float[] f962p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f963q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f964r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f965s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f966t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f967u;

    /* renamed from: v, reason: collision with root package name */
    public final C0462A0 f968v;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, L.a] */
    public c(C0462A0 c0462a0) {
        ?? obj = new Object();
        obj.f947e = Long.MIN_VALUE;
        obj.f949g = -1L;
        obj.f948f = 0L;
        this.f953f = obj;
        this.f954g = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f957j = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.k = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f960n = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f961o = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f962p = fArr5;
        this.f955h = c0462a0;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float f5 = ((int) ((1575.0f * f4) + 0.5f)) / 1000.0f;
        fArr5[0] = f5;
        fArr5[1] = f5;
        float f6 = ((int) ((f4 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f6;
        fArr4[1] = f6;
        this.f958l = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f959m = f952w;
        obj.f943a = 500;
        obj.f944b = 500;
        this.f968v = c0462a0;
    }

    public static float b(float f4, float f5, float f6) {
        if (f4 > f6) {
            return f6;
        }
        if (f4 < f5) {
            return f5;
        }
        return f4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f957j
            r0 = r0[r4]
            float[] r1 = r3.k
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f954g
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f960n
            r0 = r0[r4]
            float[] r1 = r3.f961o
            r1 = r1[r4]
            float[] r2 = r3.f962p
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: L.c.a(int, float, float, float):float");
    }

    public final float c(float f4, float f5) {
        if (f5 != 0.0f) {
            int i4 = this.f958l;
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2 && f4 < 0.0f) {
                    return f4 / (-f5);
                }
            } else if (f4 < f5) {
                if (f4 >= 0.0f) {
                    return 1.0f - (f4 / f5);
                }
                if (this.f966t && i4 == 1) {
                    return 1.0f;
                }
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i4 = 0;
        if (this.f964r) {
            this.f966t = false;
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f953f;
        int i5 = (int) (currentAnimationTimeMillis - aVar.f947e);
        int i6 = aVar.f944b;
        if (i5 > i6) {
            i4 = i6;
        } else if (i5 >= 0) {
            i4 = i5;
        }
        aVar.f951i = i4;
        aVar.f950h = aVar.a(currentAnimationTimeMillis);
        aVar.f949g = currentAnimationTimeMillis;
    }

    public final boolean e() {
        C0462A0 c0462a0;
        int count;
        a aVar = this.f953f;
        float f4 = aVar.f946d;
        int abs = (int) (f4 / Math.abs(f4));
        Math.abs(aVar.f945c);
        if (abs != 0 && (count = (c0462a0 = this.f968v).getCount()) != 0) {
            int childCount = c0462a0.getChildCount();
            int firstVisiblePosition = c0462a0.getFirstVisiblePosition();
            int i4 = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && c0462a0.getChildAt(0).getTop() >= 0)) : !(i4 >= count && c0462a0.getChildAt(childCount - 1).getBottom() <= c0462a0.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f967u
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.f965s = r2
            r7.f963q = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            o.A0 r4 = r7.f955h
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            L.a r9 = r7.f953f
            r9.f945c = r0
            r9.f946d = r8
            boolean r8 = r7.f966t
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            F.b r8 = r7.f956i
            if (r8 != 0) goto L60
            F.b r8 = new F.b
            r8.<init>(r2, r7)
            r7.f956i = r8
        L60:
            r7.f966t = r2
            r7.f964r = r2
            boolean r8 = r7.f963q
            if (r8 != 0) goto L75
            int r8 = r7.f959m
            if (r8 <= 0) goto L75
            F.b r9 = r7.f956i
            long r5 = (long) r8
            java.util.WeakHashMap r8 = I.T.f702a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            F.b r8 = r7.f956i
            r8.run()
        L7a:
            r7.f963q = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: L.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
