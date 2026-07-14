package n0;

import Q0.j;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import l0.i;

/* loaded from: classes.dex */
public final class d implements m0.a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f3298a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f3299b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3300c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3301d = new LinkedHashMap();

    public d(WindowLayoutComponent windowLayoutComponent) {
        this.f3298a = windowLayoutComponent;
    }

    @Override // m0.a
    public final void a(Context context, Y.d dVar, i iVar) {
        j jVar;
        LinkedHashMap linkedHashMap = this.f3300c;
        ReentrantLock reentrantLock = this.f3299b;
        reentrantLock.lock();
        try {
            f fVar = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f3301d;
            if (fVar != null) {
                fVar.b(iVar);
                linkedHashMap2.put(iVar, context);
                jVar = j.f722a;
            } else {
                jVar = null;
            }
            if (jVar == null) {
                f fVar2 = new f(context);
                linkedHashMap.put(context, fVar2);
                linkedHashMap2.put(iVar, context);
                fVar2.b(iVar);
                this.f3298a.addWindowLayoutInfoListener(context, fVar2);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // m0.a
    public final void b(i iVar) {
        LinkedHashMap linkedHashMap = this.f3300c;
        LinkedHashMap linkedHashMap2 = this.f3301d;
        ReentrantLock reentrantLock = this.f3299b;
        reentrantLock.lock();
        try {
            Context context = (Context) linkedHashMap2.get(iVar);
            if (context == null) {
                return;
            }
            f fVar = (f) linkedHashMap.get(context);
            if (fVar == null) {
                return;
            }
            LinkedHashSet linkedHashSet = fVar.f3305d;
            ReentrantLock reentrantLock2 = fVar.f3303b;
            reentrantLock2.lock();
            try {
                linkedHashSet.remove(iVar);
                reentrantLock2.unlock();
                linkedHashMap2.remove(iVar);
                if (linkedHashSet.isEmpty()) {
                    linkedHashMap.remove(context);
                    this.f3298a.removeWindowLayoutInfoListener(fVar);
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
