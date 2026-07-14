package b3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: b3.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0240o {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3289b = AtomicIntegerFieldUpdater.newUpdater(C0240o.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3290a;

    public C0240o(Throwable th, boolean z) {
        this.f3290a = th;
        this._handled$volatile = z ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f3290a + ']';
    }
}
