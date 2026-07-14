package o0;

import R0.r;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class m implements m0.a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile m f3388c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f3389d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final a f3390a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3391b = new CopyOnWriteArrayList();

    public m(k kVar) {
        this.f3390a = kVar;
        if (kVar != null) {
            kVar.d(new F.h(16, this));
        }
    }

    @Override // m0.a
    public final void a(Context context, Y.d dVar, l0.i iVar) {
        Activity activity;
        Object obj;
        WindowManager.LayoutParams attributes;
        Q0.j jVar = null;
        r1 = null;
        IBinder iBinder = null;
        l0.k kVar = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        r rVar = r.f750c;
        if (activity != null) {
            ReentrantLock reentrantLock = f3389d;
            reentrantLock.lock();
            try {
                a aVar = this.f3390a;
                if (aVar == null) {
                    iVar.accept(new l0.k(rVar));
                    return;
                }
                CopyOnWriteArrayList copyOnWriteArrayList = this.f3391b;
                boolean z = false;
                if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((l) it.next()).f3385a.equals(activity)) {
                            z = true;
                            break;
                        }
                    }
                }
                l lVar = new l(activity, dVar, iVar);
                copyOnWriteArrayList.add(lVar);
                if (!z) {
                    k kVar2 = (k) aVar;
                    Window window = activity.getWindow();
                    if (window != null && (attributes = window.getAttributes()) != null) {
                        iBinder = attributes.token;
                    }
                    if (iBinder != null) {
                        kVar2.c(iBinder, activity);
                    } else {
                        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new j(kVar2, activity));
                    }
                } else {
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            if (activity.equals(((l) obj).f3385a)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    l lVar2 = (l) obj;
                    if (lVar2 != null) {
                        kVar = lVar2.f3387c;
                    }
                    if (kVar != null) {
                        lVar.f3387c = kVar;
                        lVar.f3386b.accept(kVar);
                    }
                }
                reentrantLock.unlock();
                jVar = Q0.j.f722a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (jVar == null) {
            iVar.accept(new l0.k(rVar));
        }
    }

    @Override // m0.a
    public final void b(l0.i iVar) {
        synchronized (f3389d) {
            try {
                if (this.f3390a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f3391b.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    if (lVar.f3386b == iVar) {
                        arrayList.add(lVar);
                    }
                }
                this.f3391b.removeAll(arrayList);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    Activity activity = ((l) obj).f3385a;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.f3391b;
                    if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                        Iterator it2 = copyOnWriteArrayList.iterator();
                        while (it2.hasNext()) {
                            if (((l) it2.next()).f3385a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    a aVar = this.f3390a;
                    if (aVar != null) {
                        ((k) aVar).b(activity);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
