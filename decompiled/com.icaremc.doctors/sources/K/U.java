package K;

import java.io.File;

/* loaded from: classes.dex */
public final class U extends kotlin.jvm.internal.i implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public static final U f426c = new kotlin.jvm.internal.i(1);

    @Override // c1.l
    public final Object invoke(Object obj) {
        File it = (File) obj;
        kotlin.jvm.internal.h.e(it, "it");
        String absolutePath = it.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.h.d(absolutePath, "file.canonicalFile.absolutePath");
        return new l0(absolutePath);
    }
}
