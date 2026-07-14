package y0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* renamed from: y0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0732d extends T2.i implements S2.l {

    /* renamed from: g, reason: collision with root package name */
    public static final C0732d f6537g = new T2.i(1);

    @Override // S2.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SidecarDisplayFeature sidecarDisplayFeature) {
        boolean z;
        T2.h.e(sidecarDisplayFeature, "$this$require");
        if (sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
