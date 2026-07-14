package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class t0 extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1754a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f1755b;

    public /* synthetic */ t0(int i2, Rect rect) {
        this.f1754a = i2;
        this.f1755b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        switch (this.f1754a) {
            case 0:
                return this.f1755b;
            default:
                Rect rect = this.f1755b;
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
