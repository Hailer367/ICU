package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.icaremc.doctors.R;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0109f extends AbstractC0116k {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1606b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1607c;

    /* renamed from: d, reason: collision with root package name */
    public N f1608d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0109f(E0 operation, boolean z) {
        super(operation);
        kotlin.jvm.internal.h.e(operation, "operation");
        this.f1606b = z;
    }

    public final N b(Context context) {
        boolean z;
        int exitAnim;
        Animation loadAnimation;
        N n2;
        int i2;
        if (this.f1607c) {
            return this.f1608d;
        }
        E0 e02 = this.f1665a;
        H h2 = e02.f1536c;
        if (e02.f1534a == 2) {
            z = true;
        } else {
            z = false;
        }
        int nextTransition = h2.getNextTransition();
        if (this.f1606b) {
            if (z) {
                exitAnim = h2.getPopEnterAnim();
            } else {
                exitAnim = h2.getPopExitAnim();
            }
        } else if (z) {
            exitAnim = h2.getEnterAnim();
        } else {
            exitAnim = h2.getExitAnim();
        }
        h2.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = h2.mContainer;
        N n3 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            h2.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = h2.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = h2.onCreateAnimation(nextTransition, z, exitAnim);
            if (onCreateAnimation != null) {
                n3 = new N(onCreateAnimation);
            } else {
                Animator onCreateAnimator = h2.onCreateAnimator(nextTransition, z, exitAnim);
                if (onCreateAnimator != null) {
                    n3 = new N(onCreateAnimator);
                } else {
                    if (exitAnim == 0 && nextTransition != 0) {
                        if (nextTransition != 4097) {
                            if (nextTransition != 8194) {
                                if (nextTransition != 8197) {
                                    if (nextTransition != 4099) {
                                        if (nextTransition != 4100) {
                                            i2 = -1;
                                        } else if (z) {
                                            i2 = android.support.v4.media.session.a.I(context, android.R.attr.activityOpenEnterAnimation);
                                        } else {
                                            i2 = android.support.v4.media.session.a.I(context, android.R.attr.activityOpenExitAnimation);
                                        }
                                    } else if (z) {
                                        i2 = R.animator.fragment_fade_enter;
                                    } else {
                                        i2 = R.animator.fragment_fade_exit;
                                    }
                                } else if (z) {
                                    i2 = android.support.v4.media.session.a.I(context, android.R.attr.activityCloseEnterAnimation);
                                } else {
                                    i2 = android.support.v4.media.session.a.I(context, android.R.attr.activityCloseExitAnimation);
                                }
                            } else if (z) {
                                i2 = R.animator.fragment_close_enter;
                            } else {
                                i2 = R.animator.fragment_close_exit;
                            }
                        } else if (z) {
                            i2 = R.animator.fragment_open_enter;
                        } else {
                            i2 = R.animator.fragment_open_exit;
                        }
                        exitAnim = i2;
                    }
                    if (exitAnim != 0) {
                        boolean equals = "anim".equals(context.getResources().getResourceTypeName(exitAnim));
                        try {
                            if (equals) {
                                try {
                                    loadAnimation = AnimationUtils.loadAnimation(context, exitAnim);
                                } catch (Resources.NotFoundException e2) {
                                    throw e2;
                                } catch (RuntimeException unused) {
                                }
                                if (loadAnimation != null) {
                                    n2 = new N(loadAnimation);
                                    n3 = n2;
                                }
                            }
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, exitAnim);
                            if (loadAnimator != null) {
                                n2 = new N(loadAnimator);
                                n3 = n2;
                            }
                        } catch (RuntimeException e3) {
                            if (!equals) {
                                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, exitAnim);
                                if (loadAnimation2 != null) {
                                    n3 = new N(loadAnimation2);
                                }
                            } else {
                                throw e3;
                            }
                        }
                    }
                }
            }
        }
        this.f1608d = n3;
        this.f1607c = true;
        return n3;
    }
}
