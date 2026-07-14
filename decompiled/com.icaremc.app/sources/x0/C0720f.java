package x0;

import T2.h;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import h2.m;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import v0.C0687j;

/* renamed from: x0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0720f implements H.a, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6451a;

    /* renamed from: c, reason: collision with root package name */
    public C0687j f6453c;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f6452b = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f6454d = new LinkedHashSet();

    public C0720f(Context context) {
        this.f6451a = context;
    }

    @Override // H.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo windowLayoutInfo) {
        h.e(windowLayoutInfo, "value");
        ReentrantLock reentrantLock = this.f6452b;
        reentrantLock.lock();
        try {
            this.f6453c = AbstractC0719e.b(this.f6451a, windowLayoutInfo);
            Iterator it = this.f6454d.iterator();
            while (it.hasNext()) {
                ((H.a) it.next()).accept(this.f6453c);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(m mVar) {
        ReentrantLock reentrantLock = this.f6452b;
        reentrantLock.lock();
        try {
            C0687j c0687j = this.f6453c;
            if (c0687j != null) {
                mVar.accept(c0687j);
            }
            this.f6454d.add(mVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
