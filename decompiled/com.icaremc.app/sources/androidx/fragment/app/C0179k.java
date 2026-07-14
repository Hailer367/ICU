package androidx.fragment.app;

import android.animation.AnimatorSet;

/* renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0179k {

    /* renamed from: a, reason: collision with root package name */
    public static final C0179k f2867a = new Object();

    public final void a(AnimatorSet animatorSet) {
        T2.h.e(animatorSet, "animatorSet");
        animatorSet.reverse();
    }

    public final void b(AnimatorSet animatorSet, long j4) {
        T2.h.e(animatorSet, "animatorSet");
        animatorSet.setCurrentPlayTime(j4);
    }
}
