package o0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class f extends kotlin.jvm.internal.i implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public static final f f3373c = new kotlin.jvm.internal.i(1);

    @Override // c1.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        boolean z;
        kotlin.jvm.internal.h.e(require, "$this$require");
        if (require.getRect().left != 0 && require.getRect().top != 0) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
