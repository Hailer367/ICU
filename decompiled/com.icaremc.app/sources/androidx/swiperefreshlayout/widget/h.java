package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class h extends Animation {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3183f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m f3184g;

    public /* synthetic */ h(m mVar, int i4) {
        this.f3183f = i4;
        this.f3184g = mVar;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f4, Transformation transformation) {
        int i4;
        switch (this.f3183f) {
            case 0:
                m mVar = this.f3184g;
                if (!mVar.mUsingCustomStart) {
                    i4 = mVar.mSpinnerOffsetEnd - Math.abs(mVar.mOriginalOffsetTop);
                } else {
                    i4 = mVar.mSpinnerOffsetEnd;
                }
                mVar.setTargetOffsetTopAndBottom((mVar.mFrom + ((int) ((i4 - r1) * f4))) - mVar.mCircleView.getTop());
                e eVar = mVar.mProgress;
                float f5 = 1.0f - f4;
                d dVar = eVar.f3173f;
                if (f5 != dVar.f3164p) {
                    dVar.f3164p = f5;
                }
                eVar.invalidateSelf();
                return;
            case 1:
                m mVar2 = this.f3184g;
                float f6 = mVar2.mStartingScale;
                mVar2.setAnimationProgress(((-f6) * f4) + f6);
                mVar2.moveToStart(f4);
                return;
            case 2:
                this.f3184g.setAnimationProgress(f4);
                return;
            case 3:
                this.f3184g.setAnimationProgress(1.0f - f4);
                return;
            default:
                this.f3184g.moveToStart(f4);
                return;
        }
    }
}
