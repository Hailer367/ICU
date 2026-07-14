package y0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* renamed from: y0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0733e extends T2.i implements S2.l {

    /* renamed from: g, reason: collision with root package name */
    public static final C0733e f6538g = new T2.i(1);

    @Override // S2.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SidecarDisplayFeature sidecarDisplayFeature) {
        T2.h.e(sidecarDisplayFeature, "$this$require");
        boolean z = true;
        if (sidecarDisplayFeature.getType() == 1 && sidecarDisplayFeature.getRect().width() != 0 && sidecarDisplayFeature.getRect().height() != 0) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
