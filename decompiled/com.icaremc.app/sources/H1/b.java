package H1;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import java.util.concurrent.Executor;
import x1.o;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements x1.c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f648f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ o f649g;

    public /* synthetic */ b(o oVar, int i4) {
        this.f648f = i4;
        this.f649g = oVar;
    }

    @Override // x1.c
    public final Object a(I0.h hVar) {
        switch (this.f648f) {
            case 0:
                return new e((Context) hVar.a(Context.class), ((u1.f) hVar.a(u1.f.class)).f(), hVar.c(o.a(f.class)), hVar.d(R1.b.class), (Executor) hVar.e(this.f649g));
            default:
                return FirebaseMessagingRegistrar.a(this.f649g, hVar);
        }
    }
}
