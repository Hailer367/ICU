package T;

import P1.y;
import f1.AbstractC0286a;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class m extends AbstractC0286a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0286a f1566d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1567e;

    public m(AbstractC0286a abstractC0286a, ThreadPoolExecutor threadPoolExecutor) {
        this.f1566d = abstractC0286a;
        this.f1567e = threadPoolExecutor;
    }

    @Override // f1.AbstractC0286a
    public final void A(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f1567e;
        try {
            this.f1566d.A(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // f1.AbstractC0286a
    public final void B(y yVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f1567e;
        try {
            this.f1566d.B(yVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
