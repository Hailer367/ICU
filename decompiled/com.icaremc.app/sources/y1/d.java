package y1;

import java.util.concurrent.ExecutorService;
import n.p;
import v.AbstractFutureC0676h;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6569f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f6570g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Runnable f6571h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p f6572i;

    public /* synthetic */ d(f fVar, Runnable runnable, p pVar, int i4) {
        this.f6569f = i4;
        this.f6570g = fVar;
        this.f6571h = runnable;
        this.f6572i = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6569f) {
            case 0:
                ExecutorService executorService = this.f6570g.f6576f;
                final int i4 = 0;
                final Runnable runnable = this.f6571h;
                final p pVar = this.f6572i;
                executorService.execute(new Runnable() { // from class: y1.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e4) {
                                    pVar.k(e4);
                                    throw e4;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e5) {
                                    pVar.k(e5);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                p pVar2 = pVar;
                                try {
                                    runnable2.run();
                                    h hVar = (h) pVar2.f5322g;
                                    if (AbstractFutureC0676h.k.c(hVar, null, AbstractFutureC0676h.f6255l)) {
                                        AbstractFutureC0676h.c(hVar);
                                        return;
                                    }
                                    return;
                                } catch (Exception e6) {
                                    pVar2.k(e6);
                                    return;
                                }
                        }
                    }
                });
                return;
            case 1:
                ExecutorService executorService2 = this.f6570g.f6576f;
                final int i5 = 2;
                final Runnable runnable2 = this.f6571h;
                final p pVar2 = this.f6572i;
                executorService2.execute(new Runnable() { // from class: y1.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i5) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e4) {
                                    pVar2.k(e4);
                                    throw e4;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e5) {
                                    pVar2.k(e5);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                p pVar22 = pVar2;
                                try {
                                    runnable22.run();
                                    h hVar = (h) pVar22.f5322g;
                                    if (AbstractFutureC0676h.k.c(hVar, null, AbstractFutureC0676h.f6255l)) {
                                        AbstractFutureC0676h.c(hVar);
                                        return;
                                    }
                                    return;
                                } catch (Exception e6) {
                                    pVar22.k(e6);
                                    return;
                                }
                        }
                    }
                });
                return;
            default:
                ExecutorService executorService3 = this.f6570g.f6576f;
                final int i6 = 1;
                final Runnable runnable3 = this.f6571h;
                final p pVar3 = this.f6572i;
                executorService3.execute(new Runnable() { // from class: y1.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i6) {
                            case 0:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e4) {
                                    pVar3.k(e4);
                                    throw e4;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e5) {
                                    pVar3.k(e5);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                p pVar22 = pVar3;
                                try {
                                    runnable22.run();
                                    h hVar = (h) pVar22.f5322g;
                                    if (AbstractFutureC0676h.k.c(hVar, null, AbstractFutureC0676h.f6255l)) {
                                        AbstractFutureC0676h.c(hVar);
                                        return;
                                    }
                                    return;
                                } catch (Exception e6) {
                                    pVar22.k(e6);
                                    return;
                                }
                        }
                    }
                });
                return;
        }
    }
}
