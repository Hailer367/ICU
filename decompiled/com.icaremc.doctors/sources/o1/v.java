package o1;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l1.C0230h;

/* loaded from: classes.dex */
public final class v extends p1.b implements r, d, p1.i {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3460g = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: f, reason: collision with root package name */
    public int f3461f;

    public v(Object obj) {
        this._state$volatile = obj;
    }

    @Override // p1.i
    public final d a(T0.i iVar, int i2, n1.a aVar) {
        return w.d(this, iVar, i2, aVar);
    }

    public final Object b() {
        Object obj = f3460g.get(this);
        if (obj == p1.k.f3488a) {
            return null;
        }
        return obj;
    }

    public final boolean c(Object obj, Object obj2) {
        int i2;
        x[] xVarArr;
        F.h hVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3460g;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.h.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.h.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i3 = this.f3461f;
            if ((i3 & 1) == 0) {
                int i4 = i3 + 1;
                this.f3461f = i4;
                x[] xVarArr2 = this.f3468c;
                while (true) {
                    if (xVarArr2 != null) {
                        for (x xVar : xVarArr2) {
                            if (xVar != null) {
                                AtomicReference atomicReference = xVar.f3464a;
                                while (true) {
                                    Object obj4 = atomicReference.get();
                                    if (obj4 != null && obj4 != (hVar = w.f3463b)) {
                                        F.h hVar2 = w.f3462a;
                                        if (obj4 == hVar2) {
                                            while (!atomicReference.compareAndSet(obj4, hVar)) {
                                                if (atomicReference.get() != obj4) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            while (!atomicReference.compareAndSet(obj4, hVar2)) {
                                                if (atomicReference.get() != obj4) {
                                                    break;
                                                }
                                            }
                                            ((C0230h) obj4).resumeWith(Q0.j.f722a);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        i2 = this.f3461f;
                        if (i2 == i4) {
                            this.f3461f = i4 + 1;
                            return true;
                        }
                        xVarArr = this.f3468c;
                    }
                    xVarArr2 = xVarArr;
                    i4 = i2;
                }
            } else {
                this.f3461f = i3 + 2;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e2, code lost:
    
        if (r0.equals(r4) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0144, code lost:
    
        if (r5 == r3) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0147, code lost:
    
        if (r4 != r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ce A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00ce, B:21:0x00d5, B:22:0x00db, B:26:0x00de, B:28:0x00ff, B:31:0x010f, B:32:0x012b, B:39:0x013b, B:34:0x0132, B:38:0x0138, B:47:0x00e4, B:50:0x00eb, B:58:0x0054, B:60:0x005f, B:61:0x00b7), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010f A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00ce, B:21:0x00d5, B:22:0x00db, B:26:0x00de, B:28:0x00ff, B:31:0x010f, B:32:0x012b, B:39:0x013b, B:34:0x0132, B:38:0x0138, B:47:0x00e4, B:50:0x00eb, B:58:0x0054, B:60:0x005f, B:61:0x00b7), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x010e -> B:16:0x00c6). Please report as a decompilation issue!!! */
    @Override // o1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(o1.e r18, T0.d r19) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.v.collect(o1.e, T0.d):java.lang.Object");
    }

    @Override // o1.e
    public final Object emit(Object obj, T0.d dVar) {
        if (obj == null) {
            obj = p1.k.f3488a;
        }
        c(null, obj);
        return Q0.j.f722a;
    }
}
