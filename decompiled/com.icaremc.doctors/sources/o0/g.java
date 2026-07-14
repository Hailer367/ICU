package o0;

import R0.r;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import i0.C0204a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3374b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f3375a;

    public g() {
        O.a.k(3, "verificationMode");
        this.f3375a = 3;
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (kotlin.jvm.internal.h.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return kotlin.jvm.internal.h.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list != list2) {
            if (list.size() == list2.size()) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (a((SidecarDisplayFeature) list.get(i2), (SidecarDisplayFeature) list2.get(i2))) {
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final ArrayList c(List list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l0.c e2 = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (e2 != null) {
                arrayList.add(e2);
            }
        }
        return arrayList;
    }

    public final l0.k d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new l0.k(r.f750c);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        b.d(sidecarDeviceState2, b.b(sidecarDeviceState));
        return new l0.k(c(b.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final l0.c e(SidecarDisplayFeature feature, SidecarDeviceState sidecarDeviceState) {
        l0.b bVar;
        l0.b bVar2 = l0.b.f2919f;
        kotlin.jvm.internal.h.e(feature, "feature");
        int i2 = this.f3375a;
        O.a.k(i2, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) new i0.g(feature, i2, C0204a.f2330a).L("Type must be either TYPE_FOLD or TYPE_HINGE", c.f3370c).L("Feature bounds must not be 0", d.f3371c).L("TYPE_FOLD must have 0 area", e.f3372c).L("Feature be pinned to either left or top", f.f3373c).f();
        if (sidecarDisplayFeature != null) {
            int type = sidecarDisplayFeature.getType();
            if (type != 1) {
                if (type == 2) {
                    bVar = l0.b.f2922i;
                } else {
                    return null;
                }
            } else {
                bVar = l0.b.f2921h;
            }
            int b2 = b.b(sidecarDeviceState);
            if (b2 != 0 && b2 != 1) {
                if (b2 != 2) {
                    if (b2 != 3 && b2 == 4) {
                        return null;
                    }
                } else {
                    bVar2 = l0.b.f2920g;
                }
                Rect rect = feature.getRect();
                kotlin.jvm.internal.h.d(rect, "feature.rect");
                return new l0.c(new i0.b(rect), bVar, bVar2);
            }
            return null;
        }
        return null;
    }
}
