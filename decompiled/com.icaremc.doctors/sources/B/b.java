package B;

import E.J;
import a0.C0061c;
import a0.C0065g;
import a0.t;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import m.AbstractC0248A;
import m.C0261h;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f36c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f37d;

    public /* synthetic */ b(int i2, Object obj) {
        this.f36c = i2;
        this.f37d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j2;
        C0261h c0261h;
        int i2 = this.f36c;
        long j3 = 0;
        Object obj = this.f37d;
        switch (i2) {
            case 0:
                Object obj2 = ((F.h) obj).f274d;
                return;
            case 1:
                H.d dVar = (H.d) obj;
                AbstractC0248A abstractC0248A = dVar.f290e;
                H.a aVar = dVar.f288c;
                if (dVar.q) {
                    if (dVar.f300o) {
                        dVar.f300o = false;
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f281e = currentAnimationTimeMillis;
                        aVar.f283g = -1L;
                        aVar.f282f = currentAnimationTimeMillis;
                        aVar.f284h = 0.5f;
                    }
                    if ((aVar.f283g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.f283g + aVar.f285i) || !dVar.e()) {
                        dVar.q = false;
                        return;
                    }
                    if (dVar.p) {
                        dVar.p = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        abstractC0248A.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (aVar.f282f != 0) {
                        long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float a2 = aVar.a(currentAnimationTimeMillis2);
                        long j4 = currentAnimationTimeMillis2 - aVar.f282f;
                        aVar.f282f = currentAnimationTimeMillis2;
                        dVar.f302s.scrollListBy((int) (((float) j4) * ((a2 * 4.0f) + ((-4.0f) * a2 * a2)) * aVar.f280d));
                        Field field = J.f180a;
                        abstractC0248A.postOnAnimation(this);
                        return;
                    }
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                return;
            case 2:
                C0065g c0065g = (C0065g) obj;
                ValueAnimator valueAnimator = c0065g.f973u;
                int i3 = c0065g.f974v;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    }
                } else {
                    valueAnimator.cancel();
                }
                c0065g.f974v = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(ServiceStarter.ERROR_UNKNOWN);
                valueAnimator.start();
                return;
            case 3:
                t tVar = ((RecyclerView) obj).f1904F;
                if (tVar != null) {
                    C0061c c0061c = (C0061c) tVar;
                    ArrayList arrayList = c0061c.f939e;
                    ArrayList arrayList2 = c0061c.f943i;
                    ArrayList arrayList3 = c0061c.f945k;
                    ArrayList arrayList4 = c0061c.f944j;
                    boolean isEmpty = arrayList.isEmpty();
                    ArrayList arrayList5 = c0061c.f941g;
                    boolean isEmpty2 = arrayList5.isEmpty();
                    ArrayList arrayList6 = c0061c.f942h;
                    boolean isEmpty3 = arrayList6.isEmpty();
                    ArrayList arrayList7 = c0061c.f940f;
                    boolean isEmpty4 = arrayList7.isEmpty();
                    if (!isEmpty || !isEmpty2 || !isEmpty4 || !isEmpty3) {
                        Iterator it = arrayList.iterator();
                        if (!it.hasNext()) {
                            arrayList.clear();
                            if (!isEmpty2) {
                                ArrayList arrayList8 = new ArrayList();
                                arrayList8.addAll(arrayList5);
                                arrayList4.add(arrayList8);
                                arrayList5.clear();
                                if (isEmpty) {
                                    Iterator it2 = arrayList8.iterator();
                                    if (!it2.hasNext()) {
                                        arrayList8.clear();
                                        arrayList4.remove(arrayList8);
                                    } else {
                                        O.a.l(it2.next());
                                        throw null;
                                    }
                                } else {
                                    O.a.l(arrayList8.get(0));
                                    throw null;
                                }
                            }
                            if (!isEmpty3) {
                                ArrayList arrayList9 = new ArrayList();
                                arrayList9.addAll(arrayList6);
                                arrayList3.add(arrayList9);
                                arrayList6.clear();
                                if (isEmpty) {
                                    if (arrayList9.size() <= 0) {
                                        arrayList9.clear();
                                        arrayList3.remove(arrayList9);
                                    } else {
                                        O.a.l(arrayList9.get(0));
                                        throw null;
                                    }
                                } else {
                                    O.a.l(arrayList9.get(0));
                                    throw null;
                                }
                            }
                            if (!isEmpty4) {
                                ArrayList arrayList10 = new ArrayList();
                                arrayList10.addAll(arrayList7);
                                arrayList2.add(arrayList10);
                                arrayList7.clear();
                                if (isEmpty && isEmpty2 && isEmpty3) {
                                    Iterator it3 = arrayList10.iterator();
                                    if (!it3.hasNext()) {
                                        arrayList10.clear();
                                        arrayList2.remove(arrayList10);
                                        return;
                                    } else {
                                        it3.next().getClass();
                                        throw new ClassCastException();
                                    }
                                }
                                if (!isEmpty2) {
                                    j2 = c0061c.f1002c;
                                } else {
                                    j2 = 0;
                                }
                                if (!isEmpty3) {
                                    j3 = c0061c.f1003d;
                                }
                                Math.max(j2, j3);
                                arrayList10.get(0).getClass();
                                throw new ClassCastException();
                            }
                            return;
                        }
                        it.next().getClass();
                        throw new ClassCastException();
                    }
                    return;
                }
                return;
            case 4:
                ((StaggeredGridLayoutManager) obj).J();
                return;
            case 5:
                AbstractC0248A abstractC0248A2 = (AbstractC0248A) obj;
                abstractC0248A2.f3040o = null;
                abstractC0248A2.drawableStateChanged();
                return;
            case 6:
                ActionMenuView actionMenuView = ((Toolbar) obj).f1231c;
                if (actionMenuView != null && (c0261h = actionMenuView.f1128u) != null) {
                    c0261h.k();
                    return;
                }
                return;
            default:
                try {
                    ((Runnable) obj).run();
                    return;
                } catch (Exception e2) {
                    android.support.v4.media.session.a.k("Executor", "Background execution failure.", e2);
                    return;
                }
        }
    }

    public b(F.h hVar, int i2) {
        this.f36c = 0;
        this.f37d = hVar;
    }
}
