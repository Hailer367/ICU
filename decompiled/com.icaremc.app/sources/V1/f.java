package V1;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.LinkedHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements p, x1.c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1729f;

    public /* synthetic */ f(int i4) {
        this.f1729f = i4;
    }

    @Override // x1.c
    public Object a(I0.h hVar) {
        switch (this.f1729f) {
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3400a.get();
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3402c.get();
            case 9:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3401b.get();
            default:
                x1.k kVar = ExecutorsRegistrar.f3400a;
                return y1.j.f6584f;
        }
    }

    @Override // V1.p
    public Object g() {
        return new LinkedHashMap();
    }
}
