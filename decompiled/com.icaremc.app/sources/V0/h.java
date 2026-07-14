package V0;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Executor {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ h f1690g = new h(0);

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ h f1691h = new h(1);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1692f;

    public /* synthetic */ h(int i4) {
        this.f1692f = i4;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1692f) {
            case 0:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
