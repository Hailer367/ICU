package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3149b;

    public c(e eVar, d dVar) {
        this.f3149b = eVar;
        this.f3148a = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f3149b;
        d dVar = this.f3148a;
        eVar.a(1.0f, dVar, true);
        dVar.k = dVar.f3154e;
        dVar.f3160l = dVar.f3155f;
        dVar.f3161m = dVar.f3156g;
        dVar.a((dVar.f3159j + 1) % dVar.f3158i.length);
        if (eVar.k) {
            eVar.k = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            if (dVar.f3162n) {
                dVar.f3162n = false;
                return;
            }
            return;
        }
        eVar.f3177j += 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f3149b.f3177j = 0.0f;
    }
}
