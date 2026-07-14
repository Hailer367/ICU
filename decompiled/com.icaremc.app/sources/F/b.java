package F;

import Y0.r;
import android.util.Log;
import java.util.Objects;
import o1.C0560a;
import p1.C0583l;
import p1.InterfaceC0573b;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f482f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f483g;

    public /* synthetic */ b(int i4, Object obj) {
        this.f482f = i4;
        this.f483g = obj;
    }

    private final void a() {
        C0560a c0560a = (C0560a) this.f483g;
        synchronized (c0560a.f5772a) {
            try {
                if (!c0560a.b()) {
                    return;
                }
                Log.e("WakeLock", String.valueOf(c0560a.f5781j).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                c0560a.d();
                if (!c0560a.b()) {
                    return;
                }
                c0560a.f5774c = 1;
                c0560a.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        C0583l c0583l = (C0583l) this.f483g;
        synchronized (c0583l.f5830h) {
            try {
                InterfaceC0573b interfaceC0573b = (InterfaceC0573b) c0583l.f5831i;
                if (interfaceC0573b != null) {
                    interfaceC0573b.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 996
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F.b.run():void");
    }

    public b(Y0.i iVar, k kVar) {
        this.f482f = 6;
        Objects.requireNonNull(iVar);
        this.f483g = kVar;
    }

    public b(r rVar) {
        this.f482f = 5;
        Objects.requireNonNull(rVar);
        this.f483g = rVar;
    }

    public b(R1.c cVar, int i4) {
        this.f482f = 0;
        this.f483g = cVar;
    }
}
