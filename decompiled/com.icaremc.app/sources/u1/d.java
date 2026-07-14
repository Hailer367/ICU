package u1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class d implements Y0.b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f6217a = new AtomicReference();

    @Override // Y0.b
    public final void a(boolean z) {
        synchronized (f.k) {
            try {
                ArrayList arrayList = new ArrayList(f.f6220l.values());
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    f fVar = (f) obj;
                    if (fVar.f6225e.get()) {
                        fVar.j(z);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
