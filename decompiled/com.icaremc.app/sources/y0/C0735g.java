package y0;

import I2.m;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s0.C0628a;
import v0.C0679b;
import v0.C0680c;
import v0.C0687j;

/* renamed from: y0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0735g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6540b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f6541a;

    public C0735g() {
        A2.i.m(3, "verificationMode");
        this.f6541a = 3;
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (T2.h.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return T2.h.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list != list2) {
            if (list.size() == list2.size()) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (a((SidecarDisplayFeature) list.get(i4), (SidecarDisplayFeature) list2.get(i4))) {
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
            C0680c e4 = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (e4 != null) {
                arrayList.add(e4);
            }
        }
        return arrayList;
    }

    public final C0687j d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new C0687j(m.f862f);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        AbstractC0730b.d(sidecarDeviceState2, AbstractC0730b.b(sidecarDeviceState));
        return new C0687j(c(AbstractC0730b.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final C0680c e(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
        C0679b c0679b;
        C0679b c0679b2 = C0679b.f6263j;
        T2.h.e(sidecarDisplayFeature, "feature");
        int i4 = this.f6541a;
        A2.i.m(i4, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) new s0.g(sidecarDisplayFeature, i4, C0628a.f6124a).E("Type must be either TYPE_FOLD or TYPE_HINGE", C0731c.f6536g).E("Feature bounds must not be 0", C0732d.f6537g).E("TYPE_FOLD must have 0 area", C0733e.f6538g).E("Feature be pinned to either left or top", C0734f.f6539g).b();
        if (sidecarDisplayFeature2 != null) {
            int type = sidecarDisplayFeature2.getType();
            if (type != 1) {
                if (type == 2) {
                    c0679b = C0679b.f6265m;
                } else {
                    return null;
                }
            } else {
                c0679b = C0679b.f6264l;
            }
            int b4 = AbstractC0730b.b(sidecarDeviceState);
            if (b4 != 0 && b4 != 1) {
                if (b4 != 2) {
                    if (b4 != 3 && b4 == 4) {
                        return null;
                    }
                } else {
                    c0679b2 = C0679b.k;
                }
                Rect rect = sidecarDisplayFeature.getRect();
                T2.h.d(rect, "feature.rect");
                return new C0680c(new s0.b(rect), c0679b, c0679b2);
            }
            return null;
        }
        return null;
    }
}
