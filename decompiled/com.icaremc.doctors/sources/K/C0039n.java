package K;

import java.io.File;
import java.util.LinkedHashSet;

/* renamed from: K.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0039n extends kotlin.jvm.internal.i implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f529c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q f530d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0039n(Q q, int i2) {
        super(0);
        this.f529c = i2;
        this.f530d = q;
    }

    @Override // c1.a
    public final Object invoke() {
        switch (this.f529c) {
            case 0:
                return ((Z) this.f530d.f416l.a()).f447b;
            default:
                W w2 = this.f530d.f407c;
                File canonicalFile = ((File) w2.f432b.invoke()).getCanonicalFile();
                synchronized (W.f430d) {
                    String path = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = W.f429c;
                    if (!linkedHashSet.contains(path)) {
                        kotlin.jvm.internal.h.d(path, "path");
                        linkedHashSet.add(path);
                    } else {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                }
                return new Z(canonicalFile, (l0) w2.f431a.invoke(canonicalFile), new V(0, canonicalFile));
        }
    }
}
