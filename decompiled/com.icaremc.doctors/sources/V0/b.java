package V0;

import T0.i;

/* loaded from: classes.dex */
public final class b implements T0.d {

    /* renamed from: c, reason: collision with root package name */
    public static final b f783c = new Object();

    @Override // T0.d
    public final i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // T0.d
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
