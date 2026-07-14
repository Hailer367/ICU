package x0;

import H2.i;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import f0.ExecutorC0283c;
import h2.m;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import w0.InterfaceC0695a;

/* renamed from: x0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0718d implements InterfaceC0695a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f6447a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f6448b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f6449c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f6450d = new LinkedHashMap();

    public C0718d(WindowLayoutComponent windowLayoutComponent) {
        this.f6447a = windowLayoutComponent;
    }

    @Override // w0.InterfaceC0695a
    public final void a(m mVar) {
        LinkedHashMap linkedHashMap = this.f6449c;
        LinkedHashMap linkedHashMap2 = this.f6450d;
        ReentrantLock reentrantLock = this.f6448b;
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
                    this.f6447a.removeWindowLayoutInfoListener(c0720f);
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // w0.InterfaceC0695a
    public final void b(Context context, ExecutorC0283c executorC0283c, m mVar) {
        i iVar;
        LinkedHashMap linkedHashMap = this.f6449c;
        ReentrantLock reentrantLock = this.f6448b;
        reentrantLock.lock();
        try {
            C0720f c0720f = (C0720f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f6450d;
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
                this.f6447a.addWindowLayoutInfoListener(context, c0720f2);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
