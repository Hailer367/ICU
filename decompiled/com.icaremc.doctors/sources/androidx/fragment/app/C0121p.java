package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import r.C0293e;

/* renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0121p {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f1714a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1715b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1716c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1717d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1718e;

    public C0121p(ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        this.f1714a = container;
        this.f1715b = new ArrayList();
        this.f1716c = new ArrayList();
    }

    public static void f(C0293e c0293e, View view) {
        Field field = E.J.f180a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            c0293e.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    f(c0293e, childAt);
                }
            }
        }
    }

    public static final C0121p j(ViewGroup container, h0 fragmentManager) {
        kotlin.jvm.internal.h.e(container, "container");
        kotlin.jvm.internal.h.e(fragmentManager, "fragmentManager");
        kotlin.jvm.internal.h.d(fragmentManager.I(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = container.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof C0121p) {
            return (C0121p) tag;
        }
        C0121p c0121p = new C0121p(container);
        container.setTag(R.id.special_effects_controller_view_tag, c0121p);
        return c0121p;
    }

    public static void m(C0293e c0293e, Collection collection) {
        Set entrySet = c0293e.entrySet();
        K.M m2 = new K.M(1, collection);
        Iterator it = ((androidx.datastore.preferences.protobuf.b0) entrySet).iterator();
        while (it.hasNext()) {
            if (!((Boolean) m2.invoke(it.next())).booleanValue()) {
                it.remove();
            }
        }
    }

    public final void a(E0 operation) {
        kotlin.jvm.internal.h.e(operation, "operation");
        if (operation.f1542i) {
            int i2 = operation.f1534a;
            View requireView = operation.f1536c.requireView();
            kotlin.jvm.internal.h.d(requireView, "operation.fragment.requireView()");
            O.a.a(i2, requireView, this.f1714a);
            operation.f1542i = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x04b2, code lost:
    
        r9.f1543j.add(new androidx.fragment.app.C0113h(r5));
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x048f, code lost:
    
        if (androidx.fragment.app.h0.K(r16) == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0491, code lost:
    
        android.util.Log.v(r0, "Ignoring Animator set on " + r7 + " as this Fragment was involved in a Transition.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x047d, code lost:
    
        r1.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x04be, code lost:
    
        r3 = r1.size();
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x04c6, code lost:
    
        if (r15 >= r3) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x04c8, code lost:
    
        r4 = r1.get(r15);
        r15 = r15 + 1;
        r4 = (androidx.fragment.app.C0109f) r4;
        r5 = r4.f1665a;
        r7 = r5.f1536c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x04d6, code lost:
    
        if (r2 != false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x04f3, code lost:
    
        if (r8 == false) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0510, code lost:
    
        r5.f1543j.add(new androidx.fragment.app.C0107e(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x04f9, code lost:
    
        if (androidx.fragment.app.h0.K(r16) == false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x04fb, code lost:
    
        android.util.Log.v(r0, "Ignoring Animation set on " + r7 + " as Animations cannot run alongside Animators.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04dc, code lost:
    
        if (androidx.fragment.app.h0.K(r16) == false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04de, code lost:
    
        android.util.Log.v(r0, "Ignoring Animation set on " + r7 + " as Animations cannot run alongside Transitions.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x051b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01c7, code lost:
    
        r1 = new java.util.ArrayList();
        r8 = new java.util.ArrayList();
        r9 = new r.j(0);
        r11 = new java.util.ArrayList<>();
        r12 = new java.util.ArrayList<>();
        r12 = new r.j(0);
        r17 = r12;
        r13 = new r.j(0);
        r10 = r6.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01f5, code lost:
    
        r18 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01f7, code lost:
    
        if (r15 >= r10) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01f9, code lost:
    
        r19 = r6.get(r15);
        r15 = r15 + 1;
        r20 = r1;
        r1 = ((androidx.fragment.app.C0120o) r19).f1708d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0207, code lost:
    
        if (r1 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0209, code lost:
    
        if (r3 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x020b, code lost:
    
        r19 = r2;
        r2 = r3.f1536c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x020f, code lost:
    
        if (r4 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0211, code lost:
    
        r11 = r4.f1536c;
        r1 = r7.s(r7.f(r1));
        r21 = r7;
        r7 = r11.getSharedElementSourceNames();
        r22 = r8;
        kotlin.jvm.internal.h.d(r7, "lastIn.fragment.sharedElementSourceNames");
        r8 = r2.getSharedElementSourceNames();
        r23 = r10;
        kotlin.jvm.internal.h.d(r8, "firstOut.fragment.sharedElementSourceNames");
        r10 = r2.getSharedElementTargetNames();
        kotlin.jvm.internal.h.d(r10, "firstOut.fragment.sharedElementTargetNames");
        r14 = r10.size();
        r24 = r15;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0244, code lost:
    
        if (r15 >= r14) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0246, code lost:
    
        r17 = r14;
        r14 = r7.indexOf(r10.get(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0250, code lost:
    
        if (r14 == (-1)) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0252, code lost:
    
        r7.set(r14, r8.get(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0259, code lost:
    
        r15 = r15 + 1;
        r14 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r3 = (androidx.fragment.app.E0) r11;
        r2 = r26.listIterator(r26.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x025e, code lost:
    
        r8 = r11.getSharedElementTargetNames();
        kotlin.jvm.internal.h.d(r8, "lastIn.fragment.sharedElementTargetNames");
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0267, code lost:
    
        if (r27 != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0269, code lost:
    
        r2.getExitTransitionCallback();
        r11.getEnterTransitionCallback();
        r10 = new Q0.e(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0284, code lost:
    
        if (r10.f714c != null) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0288, code lost:
    
        if (r10.f715d != null) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x028a, code lost:
    
        r10 = r7.size();
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x028f, code lost:
    
        if (r15 >= r10) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0291, code lost:
    
        r14 = r7.get(r15);
        kotlin.jvm.internal.h.d(r14, "exitingNames[i]");
        r0 = r8.get(r15);
        kotlin.jvm.internal.h.d(r0, "enteringNames[i]");
        r9.put(r14, r0);
        r15 = r15 + 1;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02b7, code lost:
    
        if (androidx.fragment.app.h0.K(r16) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02b9, code lost:
    
        android.util.Log.v("FragmentManager", ">>> entering view names <<<");
        r0 = r8.size();
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02c5, code lost:
    
        if (r10 >= r0) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02c7, code lost:
    
        r15 = r8.get(r10);
        r10 = r10 + 1;
        android.util.Log.v("FragmentManager", "Name: " + r15);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02e3, code lost:
    
        android.util.Log.v("FragmentManager", ">>> exiting view names <<<");
        r0 = r7.size();
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02ed, code lost:
    
        if (r10 >= r0) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r2.hasPrevious() == false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02ef, code lost:
    
        r15 = r7.get(r10);
        r10 = r10 + 1;
        android.util.Log.v("FragmentManager", "Name: " + r15);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x030b, code lost:
    
        r0 = r2.mView;
        kotlin.jvm.internal.h.d(r0, "firstOut.fragment.mView");
        f(r12, r0);
        r12.l(r7);
        r9.l(r12.keySet());
        r0 = r11.mView;
        kotlin.jvm.internal.h.d(r0, "lastIn.fragment.mView");
        f(r13, r0);
        r13.l(r8);
        r13.l(r9.values());
        r0 = androidx.fragment.app.s0.f1751a;
        r0 = r9.f3573e - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x033a, code lost:
    
        if ((-1) >= r0) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0346, code lost:
    
        if (r13.containsKey((java.lang.String) r9.i(r0)) != false) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0348, code lost:
    
        r9.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x034b, code lost:
    
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r11 = r2.previous();
        r12 = (androidx.fragment.app.E0) r11;
        r13 = r12.f1536c.mView;
        kotlin.jvm.internal.h.d(r13, "operation.fragment.mView");
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x034e, code lost:
    
        m(r12, r9.keySet());
        m(r13, r9.values());
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0360, code lost:
    
        if (r9.isEmpty() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03a3, code lost:
    
        r18 = r1;
        r17 = r7;
        r11 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03ac, code lost:
    
        r2 = r19;
        r1 = r20;
        r7 = r21;
        r8 = r22;
        r10 = r23;
        r15 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0362, code lost:
    
        android.util.Log.i("FragmentManager", "Ignoring shared elements transition " + r1 + " between " + r3 + " and " + r4 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
        r20.clear();
        r22.clear();
        r17 = r7;
        r11 = r8;
        r2 = r19;
        r1 = r20;
        r7 = r21;
        r8 = r22;
        r10 = r23;
        r15 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (r13.getAlpha() != 0.0f) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x03bf, code lost:
    
        throw new java.lang.ClassCastException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03c5, code lost:
    
        throw new java.lang.ClassCastException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0276, code lost:
    
        r2.getEnterTransitionCallback();
        r11.getExitTransitionCallback();
        r10 = new Q0.e(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x03c6, code lost:
    
        r21 = r7;
        r22 = r8;
        r23 = r10;
        r24 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03cf, code lost:
    
        r19 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03d7, code lost:
    
        r20 = r1;
        r19 = r2;
        r21 = r7;
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03df, code lost:
    
        if (r18 != null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03e5, code lost:
    
        if (r6.isEmpty() == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03e7, code lost:
    
        r0 = "FragmentManager";
        r15 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03eb, code lost:
    
        r0 = r6.size();
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03f0, code lost:
    
        if (r1 >= r0) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03f2, code lost:
    
        r2 = r6.get(r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03fc, code lost:
    
        if (((androidx.fragment.app.C0120o) r2).f1706b != null) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        if (r13.getVisibility() != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x03ff, code lost:
    
        r0 = "FragmentManager";
        r15 = r19;
        r1 = new androidx.fragment.app.C0119n(r6, r3, r4, r21, r18, r20, r22, r9, r11, r17, r12, r13, r27);
        r3 = r6.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x041a, code lost:
    
        if (r4 >= r3) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x041c, code lost:
    
        r5 = r6.get(r4);
        r4 = r4 + 1;
        ((androidx.fragment.app.C0120o) r5).f1665a.f1543j.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0524, code lost:
    
        throw new java.util.NoSuchElementException("List is empty.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x007f, code lost:
    
        r13 = r13.getVisibility();
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0083, code lost:
    
        if (r13 == 0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0085, code lost:
    
        if (r13 == 4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0087, code lost:
    
        if (r13 != 8) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0093, code lost:
    
        throw new java.lang.IllegalArgumentException(O.a.c(r13, "Unknown visibility "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0099, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
    
        if (r12.f1534a != 2) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009a, code lost:
    
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        if (androidx.fragment.app.h0.K(2) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
    
        android.util.Log.v("FragmentManager", "Executing operations from " + r3 + " to " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
    
        r2 = new java.util.ArrayList();
        r6 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cc, code lost:
    
        if (r26.isEmpty() != false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ce, code lost:
    
        r8 = 1;
        r7 = ((androidx.fragment.app.E0) r26.get(r26.size() - 1)).f1536c;
        r11 = r26.size();
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e1, code lost:
    
        if (r12 >= r11) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e3, code lost:
    
        r13 = r26.get(r12);
        r12 = r12 + 1;
        r13 = ((androidx.fragment.app.E0) r13).f1536c.mAnimationInfo;
        r16 = r9;
        r9 = r7.mAnimationInfo;
        r13.f1518b = r9.f1518b;
        r13.f1519c = r9.f1519c;
        r13.f1520d = r9.f1520d;
        r13.f1521e = r9.f1521e;
        r9 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0106, code lost:
    
        r16 = r9;
        r7 = r26.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010d, code lost:
    
        if (r9 >= r7) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010f, code lost:
    
        r10 = r26.get(r9);
        r9 = r9 + 1;
        r10 = (androidx.fragment.app.E0) r10;
        r2.add(new androidx.fragment.app.C0109f(r10, r27));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0121, code lost:
    
        if (r27 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0123, code lost:
    
        if (r10 != r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0125, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:
    
        r6.add(new androidx.fragment.app.C0120o(r10, r27, r12));
        r10.f1537d.add(new androidx.fragment.app.C0(r25, r10, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0127, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        if (r10 != r4) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013d, code lost:
    
        r1 = new java.util.ArrayList();
        r7 = r6.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0147, code lost:
    
        if (r9 >= r7) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0149, code lost:
    
        r10 = r6.get(r9);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0156, code lost:
    
        if (((androidx.fragment.app.C0120o) r10).a() != false) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0158, code lost:
    
        r1.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015c, code lost:
    
        r6 = new java.util.ArrayList();
        r7 = r1.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0166, code lost:
    
        if (r9 >= r7) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0168, code lost:
    
        r10 = r1.get(r9);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0175, code lost:
    
        if (((androidx.fragment.app.C0120o) r10).b() == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0177, code lost:
    
        r6.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x017b, code lost:
    
        r1 = r6.size();
        r9 = 0;
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0181, code lost:
    
        if (r9 >= r1) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0183, code lost:
    
        r10 = r6.get(r9);
        r9 = r9 + 1;
        r10 = (androidx.fragment.app.C0120o) r10;
        r11 = r10.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018f, code lost:
    
        if (r7 == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0191, code lost:
    
        if (r11 != r7) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01be, code lost:
    
        throw new java.lang.IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r10.f1665a.f1536c + " returned Transition " + r10.f1706b + " which uses a different Transition type than other Fragments.").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01bf, code lost:
    
        r7 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c1, code lost:
    
        if (r7 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01c3, code lost:
    
        r15 = r2;
        r0 = "FragmentManager";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x042c, code lost:
    
        r1 = new java.util.ArrayList();
        r2 = new java.util.ArrayList();
        r3 = r15.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x043b, code lost:
    
        if (r4 >= r3) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x043d, code lost:
    
        r5 = r15.get(r4);
        r4 = r4 + 1;
        R0.p.P(r2, ((androidx.fragment.app.C0109f) r5).f1665a.f1544k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x044d, code lost:
    
        r2 = r2.isEmpty();
        r3 = r15.size();
        r4 = 0;
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0457, code lost:
    
        if (r4 >= r3) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0459, code lost:
    
        r5 = r15.get(r4);
        r4 = r4 + 1;
        r5 = (androidx.fragment.app.C0109f) r5;
        r7 = r25.f1714a.getContext();
        r9 = r5.f1665a;
        kotlin.jvm.internal.h.d(r7, "context");
        r7 = r5.b(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0474, code lost:
    
        if (r7 != null) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x047b, code lost:
    
        if (((android.animation.AnimatorSet) r7.f1555b) != null) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0481, code lost:
    
        r7 = r9.f1536c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0489, code lost:
    
        if (r9.f1544k.isEmpty() != false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x04ab, code lost:
    
        if (r9.f1534a != 3) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x04ad, code lost:
    
        r9.f1542i = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v3, types: [r.e, r.j] */
    /* JADX WARN: Type inference failed for: r13v1, types: [r.e, r.j] */
    /* JADX WARN: Type inference failed for: r9v11, types: [r.e, r.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0121p.b(java.util.ArrayList, boolean):void");
    }

    public final void c(List operations) {
        kotlin.jvm.internal.h.e(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            R0.p.P(arrayList, ((E0) it.next()).f1544k);
        }
        List U2 = R0.j.U(R0.j.W(arrayList));
        int size = U2.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((D0) U2.get(i2)).c(this.f1714a);
        }
        int size2 = operations.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a((E0) operations.get(i3));
        }
        List U3 = R0.j.U(operations);
        int size3 = U3.size();
        for (int i4 = 0; i4 < size3; i4++) {
            E0 e02 = (E0) U3.get(i4);
            if (e02.f1544k.isEmpty()) {
                e02.b();
            }
        }
    }

    public final void d(int i2, int i3, o0 o0Var) {
        synchronized (this.f1715b) {
            try {
                H h2 = o0Var.f1711c;
                kotlin.jvm.internal.h.d(h2, "fragmentStateManager.fragment");
                E0 g2 = g(h2);
                if (g2 == null) {
                    H h3 = o0Var.f1711c;
                    if (h3.mTransitioning) {
                        g2 = h(h3);
                    } else {
                        g2 = null;
                    }
                }
                if (g2 != null) {
                    g2.d(i2, i3);
                    return;
                }
                E0 e02 = new E0(i2, i3, o0Var);
                this.f1715b.add(e02);
                e02.f1537d.add(new C0(this, e02, 0));
                e02.f1537d.add(new C0(this, e02, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016b A[Catch: all -> 0x005b, TryCatch #0 {all -> 0x005b, blocks: (B:12:0x0017, B:14:0x0020, B:16:0x0031, B:18:0x003f, B:19:0x005e, B:22:0x0070, B:25:0x0074, B:29:0x006d, B:33:0x007a, B:36:0x008d, B:38:0x009b, B:39:0x00b1, B:42:0x00c8, B:45:0x00cc, B:50:0x00c3, B:51:0x00c5, B:53:0x00d2, B:57:0x00e3, B:59:0x00f3, B:60:0x00fa, B:62:0x0108, B:64:0x0118, B:66:0x011c, B:70:0x013c, B:76:0x0123, B:78:0x012a, B:87:0x0147, B:89:0x0153, B:91:0x0161, B:95:0x016b, B:96:0x018a, B:98:0x0192, B:100:0x0174, B:102:0x017e), top: B:11:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0192 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #0 {all -> 0x005b, blocks: (B:12:0x0017, B:14:0x0020, B:16:0x0031, B:18:0x003f, B:19:0x005e, B:22:0x0070, B:25:0x0074, B:29:0x006d, B:33:0x007a, B:36:0x008d, B:38:0x009b, B:39:0x00b1, B:42:0x00c8, B:45:0x00cc, B:50:0x00c3, B:51:0x00c5, B:53:0x00d2, B:57:0x00e3, B:59:0x00f3, B:60:0x00fa, B:62:0x0108, B:64:0x0118, B:66:0x011c, B:70:0x013c, B:76:0x0123, B:78:0x012a, B:87:0x0147, B:89:0x0153, B:91:0x0161, B:95:0x016b, B:96:0x018a, B:98:0x0192, B:100:0x0174, B:102:0x017e), top: B:11:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0121p.e():void");
    }

    public final E0 g(H h2) {
        Object obj;
        ArrayList arrayList = this.f1715b;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                obj = arrayList.get(i2);
                i2++;
                E0 e02 = (E0) obj;
                if (kotlin.jvm.internal.h.a(e02.f1536c, h2) && !e02.f1538e) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (E0) obj;
    }

    public final E0 h(H h2) {
        Object obj;
        ArrayList arrayList = this.f1716c;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                obj = arrayList.get(i2);
                i2++;
                E0 e02 = (E0) obj;
                if (kotlin.jvm.internal.h.a(e02.f1536c, h2) && !e02.f1538e) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (E0) obj;
    }

    public final void i() {
        String str;
        String str2;
        if (h0.K(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.f1714a.isAttachedToWindow();
        synchronized (this.f1715b) {
            try {
                n();
                l(this.f1715b);
                ArrayList V2 = R0.j.V(this.f1716c);
                int size = V2.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = V2.get(i3);
                    i3++;
                    E0 e02 = (E0) obj;
                    if (h0.K(2)) {
                        if (isAttachedToWindow) {
                            str2 = BuildConfig.FLAVOR;
                        } else {
                            str2 = "Container " + this.f1714a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + e02);
                    }
                    e02.a(this.f1714a);
                }
                ArrayList V3 = R0.j.V(this.f1715b);
                int size2 = V3.size();
                while (i2 < size2) {
                    Object obj2 = V3.get(i2);
                    i2++;
                    E0 e03 = (E0) obj2;
                    if (h0.K(2)) {
                        if (isAttachedToWindow) {
                            str = BuildConfig.FLAVOR;
                        } else {
                            str = "Container " + this.f1714a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + e03);
                    }
                    e03.a(this.f1714a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        H h2;
        Object obj;
        boolean z;
        synchronized (this.f1715b) {
            try {
                n();
                ArrayList arrayList = this.f1715b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    h2 = null;
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        E0 e02 = (E0) obj;
                        View view = e02.f1536c.mView;
                        kotlin.jvm.internal.h.d(view, "operation.fragment.mView");
                        char c2 = 4;
                        if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                            int visibility = view.getVisibility();
                            if (visibility != 0) {
                                if (visibility != 4) {
                                    if (visibility == 8) {
                                        c2 = 3;
                                    } else {
                                        throw new IllegalArgumentException("Unknown visibility " + visibility);
                                    }
                                }
                            } else {
                                c2 = 2;
                            }
                        }
                        if (e02.f1534a == 2 && c2 != 2) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                E0 e03 = (E0) obj;
                if (e03 != null) {
                    h2 = e03.f1536c;
                }
                if (h2 != null) {
                    z = h2.isPostponed();
                } else {
                    z = false;
                }
                this.f1718e = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            E0 e02 = (E0) list.get(i2);
            o0 o0Var = e02.f1545l;
            if (!e02.f1541h) {
                e02.f1541h = true;
                int i3 = e02.f1535b;
                if (i3 == 2) {
                    H h2 = o0Var.f1711c;
                    kotlin.jvm.internal.h.d(h2, "fragmentStateManager.fragment");
                    View findFocus = h2.mView.findFocus();
                    if (findFocus != null) {
                        h2.setFocusedView(findFocus);
                        if (h0.K(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + h2);
                        }
                    }
                    View requireView = e02.f1536c.requireView();
                    kotlin.jvm.internal.h.d(requireView, "this.fragment.requireView()");
                    if (requireView.getParent() == null) {
                        o0Var.b();
                        requireView.setAlpha(0.0f);
                    }
                    if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                        requireView.setVisibility(4);
                    }
                    requireView.setAlpha(h2.getPostOnViewCreatedAlpha());
                } else if (i3 == 3) {
                    H h3 = o0Var.f1711c;
                    kotlin.jvm.internal.h.d(h3, "fragmentStateManager.fragment");
                    View requireView2 = h3.requireView();
                    kotlin.jvm.internal.h.d(requireView2, "fragment.requireView()");
                    if (h0.K(2)) {
                        Log.v("FragmentManager", "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + h3);
                    }
                    requireView2.clearFocus();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            R0.p.P(arrayList, ((E0) it.next()).f1544k);
        }
        List U2 = R0.j.U(R0.j.W(arrayList));
        int size2 = U2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            D0 d02 = (D0) U2.get(i4);
            d02.getClass();
            ViewGroup container = this.f1714a;
            kotlin.jvm.internal.h.e(container, "container");
            if (!d02.f1515a) {
                d02.e(container);
            }
            d02.f1515a = true;
        }
    }

    public final void n() {
        ArrayList arrayList = this.f1715b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            E0 e02 = (E0) obj;
            int i3 = 2;
            if (e02.f1535b == 2) {
                View requireView = e02.f1536c.requireView();
                kotlin.jvm.internal.h.d(requireView, "fragment.requireView()");
                int visibility = requireView.getVisibility();
                if (visibility != 0) {
                    i3 = 4;
                    if (visibility != 4) {
                        if (visibility == 8) {
                            i3 = 3;
                        } else {
                            throw new IllegalArgumentException(O.a.c(visibility, "Unknown visibility "));
                        }
                    }
                }
                e02.d(i3, 1);
            }
        }
    }
}
