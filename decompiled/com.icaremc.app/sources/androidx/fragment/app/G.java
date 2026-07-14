package androidx.fragment.app;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2721a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f2722b = false;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f2723c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f2724d;

    public G(P p3) {
        this.f2724d = p3;
    }

    public final void a(boolean z) {
        boolean z3;
        d0.f fVar;
        this.f2722b = z;
        ArrayList arrayList = this.f2721a;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            e.p pVar = (e.p) obj;
            if (pVar.f3577e && z) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (pVar.f3574b != z3) {
                pVar.f3574b = z3;
                d0.c cVar = pVar.f3575c;
                if (cVar != null && (fVar = cVar.f3433b) != null) {
                    fVar.b();
                }
            }
        }
    }
}
