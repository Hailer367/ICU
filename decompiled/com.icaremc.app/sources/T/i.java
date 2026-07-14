package T;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1552f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final int f1553g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1554h;

    public i(Y0.k kVar, int i4) {
        this.f1553g = i4;
        this.f1554h = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1552f) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f1554h;
                int size = arrayList.size();
                int i4 = 0;
                if (this.f1553g != 1) {
                    while (i4 < size) {
                        ((h) arrayList.get(i4)).a();
                        i4++;
                    }
                    return;
                } else {
                    while (i4 < size) {
                        ((h) arrayList.get(i4)).b();
                        i4++;
                    }
                    return;
                }
            default:
                ((Y0.k) this.f1554h).c(this.f1553g);
                return;
        }
    }

    public i(List list, int i4, Throwable th) {
        android.support.v4.media.session.a.h(list, "initCallbacks cannot be null");
        this.f1554h = new ArrayList(list);
        this.f1553g = i4;
    }
}
