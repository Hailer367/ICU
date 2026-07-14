package r2;

import P1.y;
import java.util.Locale;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6096a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6097b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6098c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6099d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6100e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6101f;

    /* renamed from: g, reason: collision with root package name */
    public final n f6102g;

    /* renamed from: h, reason: collision with root package name */
    public final Integer f6103h;

    /* renamed from: i, reason: collision with root package name */
    public final String f6104i;

    /* renamed from: j, reason: collision with root package name */
    public final y f6105j;
    public final String[] k;

    /* renamed from: l, reason: collision with root package name */
    public final m[] f6106l;

    /* renamed from: m, reason: collision with root package name */
    public final Locale[] f6107m;

    public m(boolean z, boolean z3, boolean z4, boolean z5, boolean z6, int i4, n nVar, Integer num, String str, y yVar, String[] strArr, m[] mVarArr, Locale[] localeArr) {
        this.f6096a = z;
        this.f6097b = z3;
        this.f6098c = z4;
        this.f6099d = z5;
        this.f6100e = z6;
        this.f6101f = i4;
        this.f6102g = nVar;
        this.f6103h = num;
        this.f6104i = str;
        this.f6105j = yVar;
        this.k = strArr;
        this.f6106l = mVarArr;
        this.f6107m = localeArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v1 r2.m, still in use, count: 2, list:
          (r8v1 r2.m) from 0x021e: PHI (r8v2 r2.m) = (r8v1 r2.m), (r8v4 r2.m) binds: [B:68:0x0211, B:75:0x04fc] A[DONT_GENERATE, DONT_INLINE]
          (r8v1 r2.m) from 0x01e8: MOVE (r30v5 r2.m) = (r8v1 r2.m) (LINE:489)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:447)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    /* JADX WARN: Type inference failed for: r4v3, types: [P1.y, java.lang.Object] */
    public static r2.m a(org.json.JSONObject r35) {
        /*
            Method dump skipped, instructions count: 1748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.m.a(org.json.JSONObject):r2.m");
    }
}
