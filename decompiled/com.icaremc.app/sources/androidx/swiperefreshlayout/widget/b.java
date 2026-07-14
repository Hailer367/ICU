package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3146a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3147b;

    public b(e eVar, d dVar) {
        this.f3147b = eVar;
        this.f3146a = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d dVar = this.f3146a;
        e.d(floatValue, dVar);
        e eVar = this.f3147b;
        eVar.a(floatValue, dVar, false);
        eVar.invalidateSelf();
    }
}
