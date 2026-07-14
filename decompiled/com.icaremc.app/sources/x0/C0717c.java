package x0;

import H2.i;
import T2.g;
import T2.q;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import f0.ExecutorC0283c;
import h2.m;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import r0.C0619a;
import w0.InterfaceC0695a;

/* renamed from: x0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0717c implements InterfaceC0695a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f6441a;

    /* renamed from: b, reason: collision with root package name */
    public final C0619a f6442b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f6443c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f6444d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f6445e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f6446f = new LinkedHashMap();

    public C0717c(WindowLayoutComponent windowLayoutComponent, C0619a c0619a) {
        this.f6441a = windowLayoutComponent;
        this.f6442b = c0619a;
    }

    @Override // w0.InterfaceC0695a
    public final void a(m mVar) {
        LinkedHashMap linkedHashMap = this.f6444d;
        LinkedHashMap linkedHashMap2 = this.f6445e;
        ReentrantLock reentrantLock = this.f6443c;
        reentrantLock.lock();
        try {
            Context context = (Context) linkedHashMap2.get(mVar);
            if (context == null) {
                return;
            }
            C0720f c0720f = (C0720f) linkedHashMap.get(context);
            if (c0720f == null) {
                return;
            }
            LinkedHashSet linkedHashSet = c0720f.f6454d;
            ReentrantLock reentrantLock2 = c0720f.f6452b;
            reentrantLock2.lock();
            try {
                linkedHashSet.remove(mVar);
                reentrantLock2.unlock();
                linkedHashMap2.remove(mVar);
                if (linkedHashSet.isEmpty()) {
                    linkedHashMap.remove(context);
                    s0.d dVar = (s0.d) this.f6446f.remove(c0720f);
                    if (dVar != null) {
                        dVar.f6131a.invoke(dVar.f6132b, dVar.f6133c);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T2.g, x0.b] */
    @Override // w0.InterfaceC0695a
    public final void b(Context context, ExecutorC0283c executorC0283c, m mVar) {
        i iVar;
        LinkedHashMap linkedHashMap = this.f6444d;
        ReentrantLock reentrantLock = this.f6443c;
        reentrantLock.lock();
        try {
            C0720f c0720f = (C0720f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f6445e;
            if (c0720f != null) {
                c0720f.b(mVar);
                linkedHashMap2.put(mVar, context);
                iVar = i.f681a;
            } else {
                iVar = null;
            }
            if (iVar == null) {
                C0720f c0720f2 = new C0720f(context);
                linkedHashMap.put(context, c0720f2);
                linkedHashMap2.put(mVar, context);
                c0720f2.b(mVar);
                if (context instanceof Activity) {
                    this.f6446f.put(c0720f2, this.f6442b.a(this.f6441a, q.a(WindowLayoutInfo.class), (Activity) context, new g(1, c0720f2, C0720f.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0, 0)));
                } else {
                    c0720f2.accept(new WindowLayoutInfo(I2.m.f862f));
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
}
