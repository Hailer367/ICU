package e3;

import b3.C0232g;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class r extends f3.b implements o, d, f3.i {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3654j = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: i, reason: collision with root package name */
    public int f3655i;

    public r(Object obj) {
        this._state$volatile = obj;
    }

    public final Object a() {
        Object obj = f3654j.get(this);
        if (obj == f3.k.f3727a) {
            return null;
        }
        return obj;
    }

    public final void b(Object obj) {
        if (obj == null) {
            obj = f3.k.f3727a;
        }
        c(null, obj);
    }

    public final boolean c(Object obj, Object obj2) {
        int i4;
        t[] tVarArr;
        R1.c cVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3654j;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !T2.h.a(obj3, obj)) {
                return false;
            }
            if (T2.h.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i5 = this.f3655i;
            if ((i5 & 1) == 0) {
                int i6 = i5 + 1;
                this.f3655i = i6;
                t[] tVarArr2 = this.f3710f;
                while (true) {
                    if (tVarArr2 != null) {
                        for (t tVar : tVarArr2) {
                            if (tVar != null) {
                                AtomicReference atomicReference = tVar.f3658a;
                                while (true) {
                                    Object obj4 = atomicReference.get();
                                    if (obj4 != null && obj4 != (cVar = s.f3657b)) {
                                        R1.c cVar2 = s.f3656a;
                                        if (obj4 == cVar2) {
                                            while (!atomicReference.compareAndSet(obj4, cVar)) {
                                                if (atomicReference.get() != obj4) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            while (!atomicReference.compareAndSet(obj4, cVar2)) {
                                                if (atomicReference.get() != obj4) {
                                                    break;
                                                }
                                            }
                                            ((C0232g) obj4).resumeWith(H2.i.f681a);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        i4 = this.f3655i;
                        if (i4 == i6) {
                            this.f3655i = i6 + 1;
                            return true;
                        }
                        tVarArr = this.f3710f;
                    }
                    tVarArr2 = tVarArr;
                    i6 = i4;
                }
            } else {
                this.f3655i = i5 + 2;
                return true;
            }
        }
    }

    @Override // e3.e
    public final Object g(Object obj, K2.d dVar) {
        b(obj);
        return H2.i.f681a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e3, code lost:
    
        if (r0.equals(r4) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0145, code lost:
    
        if (r5 == r3) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0148, code lost:
    
        if (r4 != r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cf A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:13:0x0039, B:16:0x00c7, B:18:0x00cf, B:21:0x00d6, B:22:0x00dc, B:26:0x00df, B:28:0x0100, B:31:0x0110, B:32:0x012c, B:39:0x013c, B:34:0x0133, B:38:0x0139, B:47:0x00e5, B:50:0x00ec, B:58:0x0054, B:60:0x005f, B:61:0x00b7), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110 A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:13:0x0039, B:16:0x00c7, B:18:0x00cf, B:21:0x00d6, B:22:0x00dc, B:26:0x00df, B:28:0x0100, B:31:0x0110, B:32:0x012c, B:39:0x013c, B:34:0x0133, B:38:0x0139, B:47:0x00e5, B:50:0x00ec, B:58:0x0054, B:60:0x005f, B:61:0x00b7), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x010f -> B:16:0x00c7). Please report as a decompilation issue!!! */
    @Override // e3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(e3.e r18, K2.d r19) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.r.u(e3.e, K2.d):java.lang.Object");
    }
}
