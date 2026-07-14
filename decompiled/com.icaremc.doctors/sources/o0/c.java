package o0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class c extends kotlin.jvm.internal.i implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public static final c f3370c = new kotlin.jvm.internal.i(1);

    @Override // c1.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        kotlin.jvm.internal.h.e(require, "$this$require");
        boolean z = true;
        if (require.getType() != 1 && require.getType() != 2) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
