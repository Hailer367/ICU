package y0;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import f0.ExecutorC0283c;
import h2.m;
import io.flutter.plugin.platform.C;
import j.O;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import v0.C0687j;
import w0.InterfaceC0695a;

/* renamed from: y0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0740l implements InterfaceC0695a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile C0740l f6552c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f6553d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0729a f6554a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f6555b = new CopyOnWriteArrayList();

    public C0740l(C0738j c0738j) {
        this.f6554a = c0738j;
        if (c0738j != null) {
            c0738j.d(new O(19, this));
        }
    }

    @Override // w0.InterfaceC0695a
    public final void a(m mVar) {
        synchronized (f6553d) {
            try {
                if (this.f6554a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f6555b.iterator();
                while (it.hasNext()) {
                    C0739k c0739k = (C0739k) it.next();
                    if (c0739k.f6550b == mVar) {
                        arrayList.add(c0739k);
                    }
                }
                this.f6555b.removeAll(arrayList);
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    Activity activity = ((C0739k) obj).f6549a;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.f6555b;
                    if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                        Iterator it2 = copyOnWriteArrayList.iterator();
                        while (it2.hasNext()) {
                            if (((C0739k) it2.next()).f6549a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    InterfaceC0729a interfaceC0729a = this.f6554a;
                    if (interfaceC0729a != null) {
                        ((C0738j) interfaceC0729a).b(activity);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w0.InterfaceC0695a
    public final void b(Context context, ExecutorC0283c executorC0283c, m mVar) {
        Activity activity;
        Object obj;
        WindowManager.LayoutParams attributes;
        H2.i iVar = null;
        r1 = null;
        IBinder iBinder = null;
        C0687j c0687j = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        I2.m mVar2 = I2.m.f862f;
        if (activity != null) {
            ReentrantLock reentrantLock = f6553d;
            reentrantLock.lock();
            try {
                InterfaceC0729a interfaceC0729a = this.f6554a;
                if (interfaceC0729a == null) {
                    mVar.accept(new C0687j(mVar2));
                    return;
                }
                CopyOnWriteArrayList copyOnWriteArrayList = this.f6555b;
                boolean z = false;
                if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((C0739k) it.next()).f6549a.equals(activity)) {
                            z = true;
                            break;
                        }
                    }
                }
                C0739k c0739k = new C0739k(activity, executorC0283c, mVar);
                copyOnWriteArrayList.add(c0739k);
                if (!z) {
                    C0738j c0738j = (C0738j) interfaceC0729a;
                    Window window = activity.getWindow();
                    if (window != null && (attributes = window.getAttributes()) != null) {
                        iBinder = attributes.token;
                    }
                    if (iBinder != null) {
                        c0738j.c(iBinder, activity);
                    } else {
                        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new C(c0738j, activity));
                    }
                } else {
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            if (activity.equals(((C0739k) obj).f6549a)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    C0739k c0739k2 = (C0739k) obj;
                    if (c0739k2 != null) {
                        c0687j = c0739k2.f6551c;
                    }
                    if (c0687j != null) {
                        c0739k.f6551c = c0687j;
                        c0739k.f6550b.accept(c0687j);
                    }
                }
                reentrantLock.unlock();
                iVar = H2.i.f681a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (iVar == null) {
            mVar.accept(new C0687j(mVar2));
        }
    }
}
