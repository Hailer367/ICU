package e0;

import E.J;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.HashMap;

/* renamed from: e0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0184g extends s {

    /* renamed from: A, reason: collision with root package name */
    public static final C0180c f2191A;

    /* renamed from: B, reason: collision with root package name */
    public static final C0180c f2192B;

    /* renamed from: C, reason: collision with root package name */
    public static final C0180c f2193C;

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f2194x = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final C0180c y;
    public static final C0180c z;

    /* JADX WARN: Type inference failed for: r0v2, types: [e0.b, android.util.Property] */
    static {
        new Property(PointF.class, "boundsOrigin").f2180a = new Rect();
        y = new C0180c("topLeft", 0, PointF.class);
        z = new C0180c("bottomRight", 1, PointF.class);
        f2191A = new C0180c("bottomRight", 2, PointF.class);
        f2192B = new C0180c("topLeft", 3, PointF.class);
        f2193C = new C0180c("position", 4, PointF.class);
    }

    public static void H(z zVar) {
        View view = zVar.f2248b;
        HashMap hashMap = zVar.f2247a;
        Field field = J.f180a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", zVar.f2248b.getParent());
    }

    @Override // e0.s
    public final void e(z zVar) {
        H(zVar);
    }

    @Override // e0.s
    public final void h(z zVar) {
        H(zVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object, e0.f] */
    @Override // e0.s
    public final Animator l(ViewGroup viewGroup, z zVar, z zVar2) {
        int i2;
        C0184g c0184g;
        ObjectAnimator ofObject;
        if (zVar != null) {
            HashMap hashMap = zVar.f2247a;
            if (zVar2 != null) {
                HashMap hashMap2 = zVar2.f2247a;
                ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = zVar2.f2248b;
                    Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                    int i3 = rect.left;
                    int i4 = rect2.left;
                    int i5 = rect.top;
                    int i6 = rect2.top;
                    int i7 = rect.right;
                    int i8 = rect2.right;
                    int i9 = rect.bottom;
                    int i10 = rect2.bottom;
                    int i11 = i7 - i3;
                    int i12 = i9 - i5;
                    int i13 = i8 - i4;
                    int i14 = i10 - i6;
                    Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                    if ((i11 != 0 && i12 != 0) || (i13 != 0 && i14 != 0)) {
                        if (i3 == i4 && i5 == i6) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i7 != i8 || i9 != i10) {
                            i2++;
                        }
                    } else {
                        i2 = 0;
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i2++;
                    }
                    int i15 = i2;
                    if (i15 > 0) {
                        A.a(view, i3, i5, i7, i9);
                        if (i15 == 2) {
                            if (i11 == i13 && i12 == i14) {
                                c0184g = this;
                                c0184g.f2233t.getClass();
                                ofObject = ObjectAnimator.ofObject(view, f2193C, (TypeConverter) null, A0.f.h(i3, i5, i4, i6));
                            } else {
                                c0184g = this;
                                ?? obj = new Object();
                                obj.f2188e = view;
                                c0184g.f2233t.getClass();
                                ObjectAnimator ofObject2 = ObjectAnimator.ofObject(obj, y, (TypeConverter) null, A0.f.h(i3, i5, i4, i6));
                                c0184g.f2233t.getClass();
                                ObjectAnimator ofObject3 = ObjectAnimator.ofObject(obj, z, (TypeConverter) null, A0.f.h(i7, i9, i8, i10));
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ofObject2, ofObject3);
                                animatorSet.addListener(new C0181d(obj));
                                ofObject = animatorSet;
                            }
                        } else {
                            c0184g = this;
                            if (i3 == i4 && i5 == i6) {
                                c0184g.f2233t.getClass();
                                ofObject = ObjectAnimator.ofObject(view, f2191A, (TypeConverter) null, A0.f.h(i7, i9, i8, i10));
                            } else {
                                c0184g.f2233t.getClass();
                                ofObject = ObjectAnimator.ofObject(view, f2192B, (TypeConverter) null, A0.f.h(i3, i5, i4, i6));
                            }
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            android.support.v4.media.session.a.H(viewGroup4, true);
                            c0184g.a(new C0182e(viewGroup4));
                        }
                        return ofObject;
                    }
                }
            }
        }
        return null;
    }

    @Override // e0.s
    public final String[] q() {
        return f2194x;
    }
}
