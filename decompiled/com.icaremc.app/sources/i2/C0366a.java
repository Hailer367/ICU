package i2;

import android.util.SparseArray;
import io.flutter.plugin.platform.q;
import io.flutter.plugin.platform.r;
import java.util.Iterator;

/* renamed from: i2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0366a implements InterfaceC0367b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0368c f4104a;

    public C0366a(C0368c c0368c) {
        this.f4104a = c0368c;
    }

    @Override // i2.InterfaceC0367b
    public final void b() {
        C0368c c0368c = this.f4104a;
        Iterator it = c0368c.f4126v.iterator();
        while (it.hasNext()) {
            ((InterfaceC0367b) it.next()).b();
        }
        r rVar = c0368c.f4123s;
        SparseArray sparseArray = rVar.f4379q;
        while (sparseArray.size() > 0) {
            rVar.f4368B.s(sparseArray.keyAt(0));
        }
        q qVar = c0368c.f4124t;
        SparseArray sparseArray2 = qVar.f4358n;
        while (sparseArray2.size() > 0) {
            qVar.f4365u.s(sparseArray2.keyAt(0));
        }
        c0368c.k.f5697f = null;
    }

    @Override // i2.InterfaceC0367b
    public final void a() {
    }
}
