package androidx.lifecycle;

import android.os.Looper;
import java.util.Iterator;
import java.util.Map;
import n.C0279a;
import n.C0281c;
import o.C0283b;
import o.C0285d;
import o.C0287f;

/* loaded from: classes.dex */
public abstract class C {
    static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private boolean mChangingActiveState;
    private volatile Object mData;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;
    final Object mDataLock = new Object();
    private C0287f mObservers = new C0287f();
    int mActiveCount = 0;

    public C() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new RunnableC0154y(this);
        this.mData = obj;
        this.mVersion = -1;
    }

    public static void assertMainThread(String str) {
        C0279a.N().f3287f.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        } else {
            throw new IllegalStateException(O.a.g("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void a(B b2) {
        if (b2.f1780d) {
            if (!b2.e()) {
                b2.b(false);
                return;
            }
            int i2 = b2.f1781e;
            int i3 = this.mVersion;
            if (i2 >= i3) {
                return;
            }
            b2.f1781e = i3;
            b2.f1779c.a(this.mData);
        }
    }

    public void changeActiveCounter(int i2) {
        boolean z;
        boolean z2;
        int i3 = this.mActiveCount;
        this.mActiveCount = i2 + i3;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        while (true) {
            try {
                int i4 = this.mActiveCount;
                if (i3 != i4) {
                    if (i3 == 0 && i4 > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i3 > 0 && i4 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z) {
                        onActive();
                    } else if (z2) {
                        onInactive();
                    }
                    i3 = i4;
                } else {
                    this.mChangingActiveState = false;
                    return;
                }
            } catch (Throwable th) {
                this.mChangingActiveState = false;
                throw th;
            }
        }
    }

    public void dispatchingValue(B b2) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (b2 != null) {
                a(b2);
                b2 = null;
            } else {
                C0287f c0287f = this.mObservers;
                c0287f.getClass();
                C0285d c0285d = new C0285d(c0287f);
                c0287f.f3368e.put(c0285d, Boolean.FALSE);
                while (c0285d.hasNext()) {
                    a((B) ((Map.Entry) c0285d.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public Object getValue() {
        Object obj = this.mData;
        if (obj != NOT_SET) {
            return obj;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount > 0) {
            return true;
        }
        return false;
    }

    public boolean hasObservers() {
        if (this.mObservers.f3369f > 0) {
            return true;
        }
        return false;
    }

    public boolean isInitialized() {
        if (this.mData != NOT_SET) {
            return true;
        }
        return false;
    }

    public void observe(InterfaceC0150u interfaceC0150u, E e2) {
        assertMainThread("observe");
        if (((C0152w) interfaceC0150u.getLifecycle()).f1855c != EnumC0145o.f1844c) {
            A a2 = new A(this, interfaceC0150u, e2);
            B b2 = (B) this.mObservers.b(e2, a2);
            if (b2 != null && !b2.d(interfaceC0150u)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (b2 != null) {
                return;
            }
            interfaceC0150u.getLifecycle().a(a2);
        }
    }

    public void observeForever(E e2) {
        assertMainThread("observeForever");
        B b2 = new B(this, e2);
        B b3 = (B) this.mObservers.b(e2, b2);
        if (!(b3 instanceof A)) {
            if (b3 != null) {
                return;
            }
            b2.b(true);
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(Object obj) {
        boolean z;
        synchronized (this.mDataLock) {
            if (this.mPendingData == NOT_SET) {
                z = true;
            } else {
                z = false;
            }
            this.mPendingData = obj;
        }
        if (!z) {
            return;
        }
        C0279a N2 = C0279a.N();
        Runnable runnable = this.mPostValueRunnable;
        C0281c c0281c = N2.f3287f;
        if (c0281c.f3291h == null) {
            synchronized (c0281c.f3289f) {
                try {
                    if (c0281c.f3291h == null) {
                        c0281c.f3291h = C0281c.N(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        c0281c.f3291h.post(runnable);
    }

    public void removeObserver(E e2) {
        assertMainThread("removeObserver");
        B b2 = (B) this.mObservers.c(e2);
        if (b2 == null) {
            return;
        }
        b2.c();
        b2.b(false);
    }

    public void removeObservers(InterfaceC0150u interfaceC0150u) {
        assertMainThread("removeObservers");
        Iterator it = this.mObservers.iterator();
        while (true) {
            C0283b c0283b = (C0283b) it;
            if (c0283b.hasNext()) {
                Map.Entry entry = (Map.Entry) c0283b.next();
                if (((B) entry.getValue()).d(interfaceC0150u)) {
                    removeObserver((E) entry.getKey());
                }
            } else {
                return;
            }
        }
    }

    public void setValue(Object obj) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = obj;
        dispatchingValue(null);
    }
}
