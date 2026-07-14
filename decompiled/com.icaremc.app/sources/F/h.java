package F;

import java.util.ArrayList;
import t.C0661j;

/* loaded from: classes.dex */
public final class h implements H.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f501a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f502b;

    public /* synthetic */ h(int i4, Object obj) {
        this.f501a = i4;
        this.f502b = obj;
    }

    @Override // H.a
    public final void accept(Object obj) {
        switch (this.f501a) {
            case 0:
                i iVar = (i) obj;
                if (iVar == null) {
                    iVar = new i(-3);
                }
                ((E0.a) this.f502b).D(iVar);
                return;
            default:
                i iVar2 = (i) obj;
                synchronized (j.f507c) {
                    try {
                        C0661j c0661j = j.f508d;
                        ArrayList arrayList = (ArrayList) c0661j.get((String) this.f502b);
                        if (arrayList != null) {
                            c0661j.remove((String) this.f502b);
                            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                ((H.a) arrayList.get(i4)).accept(iVar2);
                            }
                            return;
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
