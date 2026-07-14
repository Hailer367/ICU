package K;

import android.view.View;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class M extends kotlin.jvm.internal.i implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f391c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f392d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ M(int i2, Object obj) {
        super(1);
        this.f391c = i2;
        this.f392d = obj;
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        switch (this.f391c) {
            case 0:
                Throwable th = (Throwable) obj;
                Q q = (Q) this.f392d;
                if (th != null) {
                    q.f414j.m(new c0(th));
                }
                if (q.f416l.f719d != Q0.i.f721a) {
                    ((Z) q.f416l.a()).close();
                }
                return Q0.j.f722a;
            default:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.h.e(entry, "entry");
                Collection collection = (Collection) this.f392d;
                View view = (View) entry.getValue();
                Field field = E.J.f180a;
                return Boolean.valueOf(R0.j.Q(collection, view.getTransitionName()));
        }
    }
}
