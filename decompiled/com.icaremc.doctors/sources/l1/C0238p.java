package l1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: l1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0238p {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3006b = AtomicIntegerFieldUpdater.newUpdater(C0238p.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3007a;

    public C0238p(Throwable th, boolean z) {
        this.f3007a = th;
        this._handled$volatile = z ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f3007a + ']';
    }
}
