package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3178a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f3179b;

    public /* synthetic */ f(m mVar, int i4) {
        this.f3178a = i4;
        this.f3179b = mVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        j jVar;
        switch (this.f3178a) {
            case 0:
                m mVar = this.f3179b;
                if (mVar.mRefreshing) {
                    mVar.mProgress.setAlpha(255);
                    mVar.mProgress.start();
                    if (mVar.mNotify && (jVar = mVar.mListener) != null) {
                        jVar.onRefresh();
                    }
                    mVar.mCurrentTargetOffsetTop = mVar.mCircleView.getTop();
                    return;
                }
                mVar.reset();
                return;
            default:
                m mVar2 = this.f3179b;
                if (!mVar2.mScale) {
                    mVar2.startScaleDownAnimation(null);
                    return;
                }
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i4 = this.f3178a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i4 = this.f3178a;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
