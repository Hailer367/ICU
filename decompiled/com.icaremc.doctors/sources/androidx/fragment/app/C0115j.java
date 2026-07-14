package androidx.fragment.app;

import android.animation.AnimatorSet;

/* renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0115j {

    /* renamed from: a, reason: collision with root package name */
    public static final C0115j f1656a = new Object();

    public final void a(AnimatorSet animatorSet) {
        kotlin.jvm.internal.h.e(animatorSet, "animatorSet");
        animatorSet.reverse();
    }

    public final void b(AnimatorSet animatorSet, long j2) {
        kotlin.jvm.internal.h.e(animatorSet, "animatorSet");
        animatorSet.setCurrentPlayTime(j2);
    }
}
