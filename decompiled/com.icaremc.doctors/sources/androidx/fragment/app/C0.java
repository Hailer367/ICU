package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class C0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1507c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0121p f1508d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ E0 f1509e;

    public /* synthetic */ C0(C0121p c0121p, E0 e02, int i2) {
        this.f1507c = i2;
        this.f1508d = c0121p;
        this.f1509e = e02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1507c) {
            case 0:
                C0121p c0121p = this.f1508d;
                ArrayList arrayList = c0121p.f1715b;
                E0 e02 = this.f1509e;
                if (arrayList.contains(e02)) {
                    int i2 = e02.f1534a;
                    View view = e02.f1536c.mView;
                    kotlin.jvm.internal.h.d(view, "operation.fragment.mView");
                    O.a.a(i2, view, c0121p.f1714a);
                    return;
                }
                return;
            case 1:
                C0121p this$0 = this.f1508d;
                kotlin.jvm.internal.h.e(this$0, "this$0");
                E0 operation = this.f1509e;
                kotlin.jvm.internal.h.e(operation, "$operation");
                this$0.a(operation);
                return;
            default:
                C0121p c0121p2 = this.f1508d;
                ArrayList arrayList2 = c0121p2.f1715b;
                E0 e03 = this.f1509e;
                arrayList2.remove(e03);
                c0121p2.f1716c.remove(e03);
                return;
        }
    }
}
