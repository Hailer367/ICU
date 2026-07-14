package androidx.fragment.app;

import android.util.Log;
import f.C0185a;
import f.InterfaceC0186b;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class X implements InterfaceC0186b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1575a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f1576b;

    public /* synthetic */ X(h0 h0Var, int i2) {
        this.f1575a = i2;
        this.f1576b = h0Var;
    }

    @Override // f.InterfaceC0186b
    public final void a(Object obj) {
        int i2;
        switch (this.f1575a) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (((Boolean) arrayList.get(i3)).booleanValue()) {
                        i2 = 0;
                    } else {
                        i2 = -1;
                    }
                    iArr[i3] = i2;
                }
                h0 h0Var = this.f1576b;
                C0106d0 c0106d0 = (C0106d0) h0Var.f1623E.pollFirst();
                if (c0106d0 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    return;
                }
                String str = c0106d0.f1603c;
                int i4 = c0106d0.f1604d;
                H c2 = h0Var.f1635c.c(str);
                if (c2 == null) {
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    return;
                }
                c2.onRequestPermissionsResult(i4, strArr, iArr);
                return;
            case 1:
                C0185a c0185a = (C0185a) obj;
                h0 h0Var2 = this.f1576b;
                C0106d0 c0106d02 = (C0106d0) h0Var2.f1623E.pollLast();
                if (c0106d02 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    return;
                }
                String str2 = c0106d02.f1603c;
                int i5 = c0106d02.f1604d;
                H c3 = h0Var2.f1635c.c(str2);
                if (c3 == null) {
                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    return;
                }
                c3.onActivityResult(i5, c0185a.f2250c, c0185a.f2251d);
                return;
            default:
                C0185a c0185a2 = (C0185a) obj;
                h0 h0Var3 = this.f1576b;
                C0106d0 c0106d03 = (C0106d0) h0Var3.f1623E.pollFirst();
                if (c0106d03 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    return;
                }
                String str3 = c0106d03.f1603c;
                int i6 = c0106d03.f1604d;
                H c4 = h0Var3.f1635c.c(str3);
                if (c4 == null) {
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                    return;
                }
                c4.onActivityResult(i6, c0185a2.f2250c, c0185a2.f2251d);
                return;
        }
    }
}
