package O;

import java.io.File;
import java.util.LinkedHashSet;

/* renamed from: O.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0085n extends T2.i implements S2.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1230g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ N f1231h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0085n(N n3, int i4) {
        super(0);
        this.f1230g = i4;
        this.f1231h = n3;
    }

    @Override // S2.a
    public final Object a() {
        switch (this.f1230g) {
            case 0:
                return ((W) this.f1231h.f1128o.a()).f1156b;
            default:
                T t3 = this.f1231h.f1120f;
                File canonicalFile = ((File) t3.f1143b.a()).getCanonicalFile();
                synchronized (T.f1141d) {
                    String absolutePath = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = T.f1140c;
                    if (!linkedHashSet.contains(absolutePath)) {
                        T2.h.d(absolutePath, "path");
                        linkedHashSet.add(absolutePath);
                    } else {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                }
                return new W(canonicalFile, (i0) t3.f1142a.f(canonicalFile), new S(0, canonicalFile));
        }
    }
}
