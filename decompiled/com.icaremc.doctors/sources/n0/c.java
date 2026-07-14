package n0;

import Q0.j;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.r;
import l0.i;

/* loaded from: classes.dex */
public final class c implements m0.a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f3292a;

    /* renamed from: b, reason: collision with root package name */
    public final h0.b f3293b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f3294c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3295d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f3296e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f3297f = new LinkedHashMap();

    public c(WindowLayoutComponent windowLayoutComponent, h0.b bVar) {
        this.f3292a = windowLayoutComponent;
        this.f3293b = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [n0.b, kotlin.jvm.internal.g] */
    @Override // m0.a
    public final void a(Context context, Y.d dVar, i iVar) {
        j jVar;
        LinkedHashMap linkedHashMap = this.f3295d;
        ReentrantLock reentrantLock = this.f3294c;
        reentrantLock.lock();
        try {
            f fVar = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f3296e;
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
                if (context instanceof Activity) {
                    this.f3297f.put(fVar2, this.f3293b.a(this.f3292a, r.a(WindowLayoutInfo.class), (Activity) context, new g(1, fVar2, f.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0, 0)));
                } else {
                    fVar2.accept(new WindowLayoutInfo(R0.r.f750c));
                    reentrantLock.unlock();
                    return;
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // m0.a
    public final void b(i iVar) {
        LinkedHashMap linkedHashMap = this.f3295d;
        LinkedHashMap linkedHashMap2 = this.f3296e;
        ReentrantLock reentrantLock = this.f3294c;
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
                    i0.d dVar = (i0.d) this.f3297f.remove(fVar);
                    if (dVar != null) {
                        dVar.f2337a.invoke(dVar.f2338b, dVar.f2339c);
                    }
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
