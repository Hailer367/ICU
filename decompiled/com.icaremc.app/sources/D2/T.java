package D2;

import android.webkit.JsResult;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class T implements S2.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f320f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ W f321g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ JsResult f322h;

    public /* synthetic */ T(W w2, JsResult jsResult, int i4) {
        this.f320f = i4;
        this.f321g = w2;
        this.f322h = jsResult;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        N n3 = (N) obj;
        switch (this.f320f) {
            case 0:
                if (n3.f306d) {
                    L l3 = this.f321g.f330b.f401a;
                    Throwable th = n3.f305c;
                    Objects.requireNonNull(th);
                    l3.getClass();
                    L.c(th);
                    return null;
                }
                boolean equals = Boolean.TRUE.equals(n3.f304b);
                JsResult jsResult = this.f322h;
                if (equals) {
                    jsResult.confirm();
                    return null;
                }
                jsResult.cancel();
                return null;
            default:
                if (n3.f306d) {
                    L l4 = this.f321g.f330b.f401a;
                    Throwable th2 = n3.f305c;
                    Objects.requireNonNull(th2);
                    l4.getClass();
                    L.c(th2);
                    return null;
                }
                this.f322h.confirm();
                return null;
        }
    }
}
