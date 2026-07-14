package B;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i implements D.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f59b;

    public /* synthetic */ i(int i2, Object obj) {
        this.f58a = i2;
        this.f59b = obj;
    }

    @Override // D.a
    public final void accept(Object obj) {
        switch (this.f58a) {
            case 0:
                j jVar = (j) obj;
                if (jVar == null) {
                    jVar = new j(-3);
                }
                ((c) this.f59b).e(jVar);
                return;
            default:
                j jVar2 = (j) obj;
                synchronized (k.f64c) {
                    try {
                        r.j jVar3 = k.f65d;
                        ArrayList arrayList = (ArrayList) jVar3.get((String) this.f59b);
                        if (arrayList != null) {
                            jVar3.remove((String) this.f59b);
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ((D.a) arrayList.get(i2)).accept(jVar2);
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
