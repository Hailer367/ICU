package o0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class d extends kotlin.jvm.internal.i implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public static final d f3371c = new kotlin.jvm.internal.i(1);

    @Override // c1.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        boolean z;
        kotlin.jvm.internal.h.e(require, "$this$require");
        if (require.getRect().width() == 0 && require.getRect().height() == 0) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
