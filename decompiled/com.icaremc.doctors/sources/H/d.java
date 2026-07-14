package H;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import com.google.firebase.messaging.ServiceStarter;
import m.AbstractC0248A;

/* loaded from: classes.dex */
public final class d implements View.OnTouchListener {

    /* renamed from: t, reason: collision with root package name */
    public static final int f287t = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    public final a f288c;

    /* renamed from: d, reason: collision with root package name */
    public final AccelerateInterpolator f289d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0248A f290e;

    /* renamed from: f, reason: collision with root package name */
    public B.b f291f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f292g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f293h;

    /* renamed from: i, reason: collision with root package name */
    public final int f294i;

    /* renamed from: j, reason: collision with root package name */
    public final int f295j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f296k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f297l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f298m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f299n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f300o;
    public boolean p;
    public boolean q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f301r;

    /* renamed from: s, reason: collision with root package name */
    public final AbstractC0248A f302s;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, H.a] */
    public d(AbstractC0248A abstractC0248A) {
        ?? obj = new Object();
        obj.f281e = Long.MIN_VALUE;
        obj.f283g = -1L;
        obj.f282f = 0L;
        this.f288c = obj;
        this.f289d = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f292g = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f293h = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f296k = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f297l = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f298m = fArr5;
        this.f290e = abstractC0248A;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = ((int) ((1575.0f * f2) + 0.5f)) / 1000.0f;
        fArr5[0] = f3;
        fArr5[1] = f3;
        float f4 = ((int) ((f2 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f4;
        fArr4[1] = f4;
        this.f294i = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f295j = f287t;
        obj.f277a = ServiceStarter.ERROR_UNKNOWN;
        obj.f278b = ServiceStarter.ERROR_UNKNOWN;
        this.f302s = abstractC0248A;
    }

    public static float b(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        if (f2 < f3) {
            return f3;
        }
        return f2;
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
            float[] r0 = r3.f292g
            r0 = r0[r4]
            float[] r1 = r3.f293h
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f289d
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
            float[] r0 = r3.f296k
            r0 = r0[r4]
            float[] r1 = r3.f297l
            r1 = r1[r4]
            float[] r2 = r3.f298m
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
        throw new UnsupportedOperationException("Method not decompiled: H.d.a(int, float, float, float):float");
    }

    public final float c(float f2, float f3) {
        if (f3 != 0.0f) {
            int i2 = this.f294i;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2 && f2 < 0.0f) {
                    return f2 / (-f3);
                }
            } else if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.q && i2 == 1) {
                    return 1.0f;
                }
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i2 = 0;
        if (this.f300o) {
            this.q = false;
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f288c;
        int i3 = (int) (currentAnimationTimeMillis - aVar.f281e);
        int i4 = aVar.f278b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.f285i = i2;
        aVar.f284h = aVar.a(currentAnimationTimeMillis);
        aVar.f283g = currentAnimationTimeMillis;
    }

    public final boolean e() {
        AbstractC0248A abstractC0248A;
        int count;
        a aVar = this.f288c;
        float f2 = aVar.f280d;
        int abs = (int) (f2 / Math.abs(f2));
        Math.abs(aVar.f279c);
        if (abs != 0 && (count = (abstractC0248A = this.f302s).getCount()) != 0) {
            int childCount = abstractC0248A.getChildCount();
            int firstVisiblePosition = abstractC0248A.getFirstVisiblePosition();
            int i2 = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && abstractC0248A.getChildAt(0).getTop() >= 0)) : !(i2 >= count && abstractC0248A.getChildAt(childCount - 1).getBottom() <= abstractC0248A.getHeight())) {
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
            boolean r0 = r7.f301r
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
            r7.p = r2
            r7.f299n = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            m.A r4 = r7.f290e
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            H.a r9 = r7.f288c
            r9.f279c = r0
            r9.f280d = r8
            boolean r8 = r7.q
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            B.b r8 = r7.f291f
            if (r8 != 0) goto L60
            B.b r8 = new B.b
            r8.<init>(r2, r7)
            r7.f291f = r8
        L60:
            r7.q = r2
            r7.f300o = r2
            boolean r8 = r7.f299n
            if (r8 != 0) goto L75
            int r8 = r7.f295j
            if (r8 <= 0) goto L75
            B.b r9 = r7.f291f
            long r5 = (long) r8
            java.lang.reflect.Field r8 = E.J.f180a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            B.b r8 = r7.f291f
            r8.run()
        L7a:
            r7.f299n = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: H.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
