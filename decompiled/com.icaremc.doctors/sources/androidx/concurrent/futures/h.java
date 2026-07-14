package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class h extends a {
    @Override // androidx.concurrent.futures.a
    public final boolean a(j jVar, e eVar, e eVar2) {
        synchronized (jVar) {
            try {
                if (jVar.listeners == eVar) {
                    jVar.listeners = eVar2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.concurrent.futures.a
    public final boolean b(j jVar, Object obj, Object obj2) {
        synchronized (jVar) {
            try {
                if (jVar.value == obj) {
                    jVar.value = obj2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.concurrent.futures.a
    public final boolean c(j jVar, i iVar, i iVar2) {
        synchronized (jVar) {
            try {
                if (jVar.waiters == iVar) {
                    jVar.waiters = iVar2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.concurrent.futures.a
    public final void d(i iVar, i iVar2) {
        iVar.f1279b = iVar2;
    }

    @Override // androidx.concurrent.futures.a
    public final void e(i iVar, Thread thread) {
        iVar.f1278a = thread;
    }
}
