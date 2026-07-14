package androidx.fragment.app;

import android.util.Log;
import g.C0289a;
import g.InterfaceC0290b;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class F implements InterfaceC0290b {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2719f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ P f2720g;

    public /* synthetic */ F(P p3, int i4) {
        this.f2719f = i4;
        this.f2720g = p3;
    }

    @Override // g.InterfaceC0290b
    public final void c(Object obj) {
        int i4;
        switch (this.f2719f) {
            case 0:
                Map map = (Map) obj;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    if (((Boolean) arrayList.get(i5)).booleanValue()) {
                        i4 = 0;
                    } else {
                        i4 = -1;
                    }
                    iArr[i5] = i4;
                }
                P p3 = this.f2720g;
                L l3 = (L) p3.f2739E.pollFirst();
                if (l3 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    return;
                }
                String str = l3.f2730f;
                if (p3.f2752c.f(str) == null) {
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    return;
                }
                return;
            default:
                C0289a c0289a = (C0289a) obj;
                P p4 = this.f2720g;
                L l4 = (L) p4.f2739E.pollFirst();
                if (l4 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    return;
                }
                String str2 = l4.f2730f;
                int i6 = l4.f2731g;
                AbstractComponentCallbacksC0187t f4 = p4.f2752c.f(str2);
                if (f4 == null) {
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str2);
                    return;
                }
                f4.k(i6, c0289a.f3740f, c0289a.f3741g);
                return;
        }
    }
}
