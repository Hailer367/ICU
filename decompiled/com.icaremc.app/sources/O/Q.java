package O;

import java.io.File;

/* loaded from: classes.dex */
public final class Q extends T2.i implements S2.l {

    /* renamed from: g, reason: collision with root package name */
    public static final Q f1137g = new T2.i(1);

    @Override // S2.l
    public final Object f(Object obj) {
        File file = (File) obj;
        T2.h.e(file, "it");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        T2.h.d(absolutePath, "file.canonicalFile.absolutePath");
        return new i0(absolutePath);
    }
}
