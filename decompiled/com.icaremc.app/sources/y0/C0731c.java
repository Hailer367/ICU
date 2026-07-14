package y0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* renamed from: y0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0731c extends T2.i implements S2.l {

    /* renamed from: g, reason: collision with root package name */
    public static final C0731c f6536g = new T2.i(1);

    @Override // S2.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SidecarDisplayFeature sidecarDisplayFeature) {
        T2.h.e(sidecarDisplayFeature, "$this$require");
        boolean z = true;
        if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
