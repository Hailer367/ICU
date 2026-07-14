package y2;

import java.util.concurrent.CountDownLatch;
import s2.InterfaceC0643o;

/* renamed from: y2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0745b implements InterfaceC0643o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f6592a;

    public C0745b(CountDownLatch countDownLatch) {
        this.f6592a = countDownLatch;
    }

    @Override // s2.InterfaceC0643o
    public final void error(String str, String str2, Object obj) {
        this.f6592a.countDown();
    }

    @Override // s2.InterfaceC0643o
    public final void notImplemented() {
        this.f6592a.countDown();
    }

    @Override // s2.InterfaceC0643o
    public final void success(Object obj) {
        this.f6592a.countDown();
    }
}
