package D2;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import android.webkit.JsPromptResult;
import d2.C0265f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import q1.C0601a;
import q1.C0605e;

/* loaded from: classes.dex */
public final /* synthetic */ class U implements S2.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f323f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f324g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f325h;

    public /* synthetic */ U(int i4, Object obj, Object obj2) {
        this.f323f = i4;
        this.f324g = obj;
        this.f325h = obj2;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        Integer num;
        boolean z;
        switch (this.f323f) {
            case 0:
                W w2 = (W) this.f324g;
                JsPromptResult jsPromptResult = (JsPromptResult) this.f325h;
                N n3 = (N) obj;
                if (n3.f306d) {
                    L l3 = w2.f330b.f401a;
                    Throwable th = n3.f305c;
                    Objects.requireNonNull(th);
                    l3.getClass();
                    L.c(th);
                    return null;
                }
                String str = (String) n3.f304b;
                if (str != null) {
                    jsPromptResult.confirm(str);
                    return null;
                }
                jsPromptResult.cancel();
                return null;
            case 1:
                H1.j jVar = (H1.j) this.f324g;
                String str2 = (String) this.f325h;
                S.b bVar = (S.b) obj;
                jVar.getClass();
                bVar.e(H1.j.f669d, str2);
                jVar.d(bVar, str2);
                return null;
            case 2:
                C0265f c0265f = (C0265f) this.f324g;
                Activity activity = (Activity) this.f325h;
                C0601a c0601a = (C0601a) obj;
                if (c0601a.f5935c == 3 && (num = c0265f.f3489l) != null && num.intValue() == 1) {
                    try {
                        if (c0265f.f3491n != null) {
                            C0605e.c(c0601a, activity, q1.l.a(1));
                        }
                    } catch (IntentSender.SendIntentException e4) {
                        Log.e("in_app_update", "Could not start update flow", e4);
                    }
                }
                return H2.i.f681a;
            default:
                C0265f c0265f2 = (C0265f) this.f324g;
                r2.i iVar = (r2.i) this.f325h;
                C0601a c0601a2 = (C0601a) obj;
                c0265f2.f3490m = c0601a2;
                H2.d dVar = new H2.d("updateAvailability", Integer.valueOf(c0601a2.f5935c));
                boolean z3 = true;
                if (c0601a2.b(q1.l.a(1)) != null) {
                    z = true;
                } else {
                    z = false;
                }
                H2.d dVar2 = new H2.d("immediateAllowed", Boolean.valueOf(z));
                Set<Integer> a4 = c0601a2.a(q1.l.a(1));
                ArrayList arrayList = new ArrayList(a4.size());
                for (Integer num2 : a4) {
                    num2.getClass();
                    arrayList.add(num2);
                }
                H2.d dVar3 = new H2.d("immediateAllowedPreconditions", I2.e.I(arrayList));
                if (c0601a2.b(q1.l.a(0)) == null) {
                    z3 = false;
                }
                H2.d dVar4 = new H2.d("flexibleAllowed", Boolean.valueOf(z3));
                Set<Integer> a5 = c0601a2.a(q1.l.a(0));
                ArrayList arrayList2 = new ArrayList(a5.size());
                for (Integer num3 : a5) {
                    num3.getClass();
                    arrayList2.add(num3);
                }
                H2.d[] dVarArr = {dVar, dVar2, dVar3, dVar4, new H2.d("flexibleAllowedPreconditions", I2.e.I(arrayList2)), new H2.d("availableVersionCode", Integer.valueOf(c0601a2.f5934b)), new H2.d("installStatus", Integer.valueOf(c0601a2.f5936d)), new H2.d("packageName", c0601a2.f5933a), new H2.d("clientVersionStalenessDays", c0601a2.f5937e), new H2.d("updatePriority", Integer.valueOf(c0601a2.f5938f))};
                LinkedHashMap linkedHashMap = new LinkedHashMap(I2.p.Q(10));
                for (int i4 = 0; i4 < 10; i4++) {
                    H2.d dVar5 = dVarArr[i4];
                    linkedHashMap.put(dVar5.f673f, dVar5.f674g);
                }
                iVar.success(linkedHashMap);
                return H2.i.f681a;
        }
    }
}
