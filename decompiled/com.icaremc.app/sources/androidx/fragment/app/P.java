package androidx.fragment.app;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0207n;
import com.icaremc.app.R;
import i0.C0362e;
import j.AbstractActivityC0416k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import t.C0662k;
import x.C0706f;

/* loaded from: classes.dex */
public abstract class P {

    /* renamed from: A, reason: collision with root package name */
    public final Z0.g f2735A;

    /* renamed from: B, reason: collision with root package name */
    public g.h f2736B;

    /* renamed from: C, reason: collision with root package name */
    public g.h f2737C;

    /* renamed from: D, reason: collision with root package name */
    public g.h f2738D;

    /* renamed from: E, reason: collision with root package name */
    public ArrayDeque f2739E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f2740F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f2741G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f2742H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f2743I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f2744J;

    /* renamed from: K, reason: collision with root package name */
    public ArrayList f2745K;

    /* renamed from: L, reason: collision with root package name */
    public ArrayList f2746L;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList f2747M;

    /* renamed from: N, reason: collision with root package name */
    public U f2748N;

    /* renamed from: O, reason: collision with root package name */
    public final F.b f2749O;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2751b;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f2754e;

    /* renamed from: g, reason: collision with root package name */
    public e.t f2756g;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2761m;

    /* renamed from: n, reason: collision with root package name */
    public final E0.a f2762n;

    /* renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f2763o;

    /* renamed from: p, reason: collision with root package name */
    public final E f2764p;

    /* renamed from: q, reason: collision with root package name */
    public final E f2765q;

    /* renamed from: r, reason: collision with root package name */
    public final E f2766r;

    /* renamed from: s, reason: collision with root package name */
    public final E f2767s;

    /* renamed from: t, reason: collision with root package name */
    public final H f2768t;

    /* renamed from: u, reason: collision with root package name */
    public int f2769u;

    /* renamed from: v, reason: collision with root package name */
    public C0191x f2770v;

    /* renamed from: w, reason: collision with root package name */
    public A f2771w;

    /* renamed from: x, reason: collision with root package name */
    public AbstractComponentCallbacksC0187t f2772x;

    /* renamed from: y, reason: collision with root package name */
    public AbstractComponentCallbacksC0187t f2773y;
    public final I z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2750a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final P1.y f2752c = new P1.y(7);

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2753d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final D f2755f = new D(this);

    /* renamed from: h, reason: collision with root package name */
    public C0169a f2757h = null;

    /* renamed from: i, reason: collision with root package name */
    public final G f2758i = new G(this);

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f2759j = new AtomicInteger();
    public final Map k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    public final Map f2760l = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.E] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.E] */
    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.fragment.app.E] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.fragment.app.E] */
    /* JADX WARN: Type inference failed for: r0v22, types: [Z0.g, java.lang.Object] */
    public P() {
        Collections.synchronizedMap(new HashMap());
        this.f2761m = new ArrayList();
        this.f2762n = new E0.a(this);
        this.f2763o = new CopyOnWriteArrayList();
        final int i4 = 0;
        this.f2764p = new H.a(this) { // from class: androidx.fragment.app.E

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ P f2718b;

            {
                this.f2718b = this;
            }

            @Override // H.a
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        P p3 = this.f2718b;
                        if (p3.L()) {
                            p3.i(false);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        P p4 = this.f2718b;
                        if (p4.L() && num.intValue() == 80) {
                            p4.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0706f c0706f = (C0706f) obj;
                        P p5 = this.f2718b;
                        if (p5.L()) {
                            boolean z = c0706f.f6356a;
                            p5.n(false);
                            return;
                        }
                        return;
                    default:
                        x.J j4 = (x.J) obj;
                        P p6 = this.f2718b;
                        if (p6.L()) {
                            boolean z3 = j4.f6336a;
                            p6.s(false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i5 = 1;
        this.f2765q = new H.a(this) { // from class: androidx.fragment.app.E

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ P f2718b;

            {
                this.f2718b = this;
            }

            @Override // H.a
            public final void accept(Object obj) {
                switch (i5) {
                    case 0:
                        P p3 = this.f2718b;
                        if (p3.L()) {
                            p3.i(false);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        P p4 = this.f2718b;
                        if (p4.L() && num.intValue() == 80) {
                            p4.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0706f c0706f = (C0706f) obj;
                        P p5 = this.f2718b;
                        if (p5.L()) {
                            boolean z = c0706f.f6356a;
                            p5.n(false);
                            return;
                        }
                        return;
                    default:
                        x.J j4 = (x.J) obj;
                        P p6 = this.f2718b;
                        if (p6.L()) {
                            boolean z3 = j4.f6336a;
                            p6.s(false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i6 = 2;
        this.f2766r = new H.a(this) { // from class: androidx.fragment.app.E

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ P f2718b;

            {
                this.f2718b = this;
            }

            @Override // H.a
            public final void accept(Object obj) {
                switch (i6) {
                    case 0:
                        P p3 = this.f2718b;
                        if (p3.L()) {
                            p3.i(false);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        P p4 = this.f2718b;
                        if (p4.L() && num.intValue() == 80) {
                            p4.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0706f c0706f = (C0706f) obj;
                        P p5 = this.f2718b;
                        if (p5.L()) {
                            boolean z = c0706f.f6356a;
                            p5.n(false);
                            return;
                        }
                        return;
                    default:
                        x.J j4 = (x.J) obj;
                        P p6 = this.f2718b;
                        if (p6.L()) {
                            boolean z3 = j4.f6336a;
                            p6.s(false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i7 = 3;
        this.f2767s = new H.a(this) { // from class: androidx.fragment.app.E

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ P f2718b;

            {
                this.f2718b = this;
            }

            @Override // H.a
            public final void accept(Object obj) {
                switch (i7) {
                    case 0:
                        P p3 = this.f2718b;
                        if (p3.L()) {
                            p3.i(false);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        P p4 = this.f2718b;
                        if (p4.L() && num.intValue() == 80) {
                            p4.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0706f c0706f = (C0706f) obj;
                        P p5 = this.f2718b;
                        if (p5.L()) {
                            boolean z = c0706f.f6356a;
                            p5.n(false);
                            return;
                        }
                        return;
                    default:
                        x.J j4 = (x.J) obj;
                        P p6 = this.f2718b;
                        if (p6.L()) {
                            boolean z3 = j4.f6336a;
                            p6.s(false);
                            return;
                        }
                        return;
                }
            }
        };
        this.f2768t = new H(this);
        this.f2769u = -1;
        this.z = new I(this);
        this.f2735A = new Object();
        this.f2739E = new ArrayDeque();
        this.f2749O = new F.b(9, this);
    }

    public static HashSet E(C0169a c0169a) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < c0169a.f2816a.size(); i4++) {
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = ((Y) c0169a.f2816a.get(i4)).f2808b;
            if (abstractComponentCallbacksC0187t != null && c0169a.f2822g) {
                hashSet.add(abstractComponentCallbacksC0187t);
            }
        }
        return hashSet;
    }

    public static boolean J(int i4) {
        if (Log.isLoggable("FragmentManager", i4)) {
            return true;
        }
        return false;
    }

    public static boolean K(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        abstractComponentCallbacksC0187t.getClass();
        ArrayList i4 = abstractComponentCallbacksC0187t.z.f2752c.i();
        int size = i4.size();
        boolean z = false;
        int i5 = 0;
        while (i5 < size) {
            Object obj = i4.get(i5);
            i5++;
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = (AbstractComponentCallbacksC0187t) obj;
            if (abstractComponentCallbacksC0187t2 != null) {
                z = K(abstractComponentCallbacksC0187t2);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean M(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (abstractComponentCallbacksC0187t != null) {
            if (abstractComponentCallbacksC0187t.f2910H) {
                if (abstractComponentCallbacksC0187t.f2941x == null || M(abstractComponentCallbacksC0187t.f2903A)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean N(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (abstractComponentCallbacksC0187t != null) {
            P p3 = abstractComponentCallbacksC0187t.f2941x;
            if (abstractComponentCallbacksC0187t.equals(p3.f2773y) && N(p3.f2772x)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void b0(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (J(2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC0187t);
        }
        if (abstractComponentCallbacksC0187t.f2907E) {
            abstractComponentCallbacksC0187t.f2907E = false;
            abstractComponentCallbacksC0187t.f2916N = !abstractComponentCallbacksC0187t.f2916N;
        }
    }

    public final boolean A(boolean z) {
        boolean z3;
        z(z);
        boolean z4 = false;
        while (true) {
            ArrayList arrayList = this.f2745K;
            ArrayList arrayList2 = this.f2746L;
            synchronized (this.f2750a) {
                if (this.f2750a.isEmpty()) {
                    z3 = false;
                } else {
                    try {
                        int size = this.f2750a.size();
                        z3 = false;
                        for (int i4 = 0; i4 < size; i4++) {
                            z3 |= ((M) this.f2750a.get(i4)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (z3) {
                z4 = true;
                this.f2751b = true;
                try {
                    T(this.f2745K, this.f2746L);
                } finally {
                    d();
                }
            } else {
                e0();
                v();
                ((HashMap) this.f2752c.f1470g).values().removeAll(Collections.singleton(null));
                return z4;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:139:0x0237. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:173:0x030e. Please report as an issue. */
    public final void B(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        String str;
        boolean z;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        int i8;
        P1.y yVar = this.f2752c;
        ArrayList arrayList3 = this.f2761m;
        boolean z5 = ((C0169a) arrayList.get(i4)).f2829o;
        ArrayList arrayList4 = this.f2747M;
        if (arrayList4 == null) {
            this.f2747M = new ArrayList();
        } else {
            arrayList4.clear();
        }
        this.f2747M.addAll(yVar.j());
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2773y;
        int i9 = i4;
        boolean z6 = false;
        while (i9 < i5) {
            C0169a c0169a = (C0169a) arrayList.get(i9);
            if (!((Boolean) arrayList2.get(i9)).booleanValue()) {
                ArrayList arrayList5 = this.f2747M;
                ArrayList arrayList6 = c0169a.f2816a;
                int i10 = 0;
                while (i10 < arrayList6.size()) {
                    Y y3 = (Y) arrayList6.get(i10);
                    boolean z7 = z5;
                    int i11 = y3.f2807a;
                    int i12 = i9;
                    int i13 = 1;
                    if (i11 != 1) {
                        z4 = z6;
                        if (i11 != 2) {
                            if (i11 == 3 || i11 == 6) {
                                arrayList5.remove(y3.f2808b);
                                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = y3.f2808b;
                                if (abstractComponentCallbacksC0187t2 == abstractComponentCallbacksC0187t) {
                                    arrayList6.add(i10, new Y(9, abstractComponentCallbacksC0187t2));
                                    i10++;
                                    abstractComponentCallbacksC0187t = null;
                                }
                            } else if (i11 == 7) {
                                i13 = 1;
                            } else if (i11 == 8) {
                                arrayList6.add(i10, new Y(9, abstractComponentCallbacksC0187t, 0));
                                y3.f2809c = true;
                                i10++;
                                abstractComponentCallbacksC0187t = y3.f2808b;
                            }
                            i13 = 1;
                        } else {
                            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t3 = y3.f2808b;
                            int i14 = abstractComponentCallbacksC0187t3.f2905C;
                            int size = arrayList5.size() - 1;
                            boolean z8 = false;
                            while (size >= 0) {
                                int i15 = size;
                                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t4 = (AbstractComponentCallbacksC0187t) arrayList5.get(size);
                                if (abstractComponentCallbacksC0187t4.f2905C != i14) {
                                    i7 = i14;
                                } else if (abstractComponentCallbacksC0187t4 == abstractComponentCallbacksC0187t3) {
                                    i7 = i14;
                                    z8 = true;
                                } else {
                                    if (abstractComponentCallbacksC0187t4 == abstractComponentCallbacksC0187t) {
                                        i7 = i14;
                                        arrayList6.add(i10, new Y(9, abstractComponentCallbacksC0187t4, 0));
                                        i10++;
                                        i8 = 0;
                                        abstractComponentCallbacksC0187t = null;
                                    } else {
                                        i7 = i14;
                                        i8 = 0;
                                    }
                                    Y y4 = new Y(3, abstractComponentCallbacksC0187t4, i8);
                                    y4.f2810d = y3.f2810d;
                                    y4.f2812f = y3.f2812f;
                                    y4.f2811e = y3.f2811e;
                                    y4.f2813g = y3.f2813g;
                                    arrayList6.add(i10, y4);
                                    arrayList5.remove(abstractComponentCallbacksC0187t4);
                                    i10++;
                                    abstractComponentCallbacksC0187t = abstractComponentCallbacksC0187t;
                                }
                                size = i15 - 1;
                                i14 = i7;
                            }
                            i13 = 1;
                            if (z8) {
                                arrayList6.remove(i10);
                                i10--;
                            } else {
                                y3.f2807a = 1;
                                y3.f2809c = true;
                                arrayList5.add(abstractComponentCallbacksC0187t3);
                            }
                        }
                        i10 += i13;
                        z5 = z7;
                        i9 = i12;
                        z6 = z4;
                    } else {
                        z4 = z6;
                    }
                    arrayList5.add(y3.f2808b);
                    i10 += i13;
                    z5 = z7;
                    i9 = i12;
                    z6 = z4;
                }
                z = z5;
                i6 = i9;
                z3 = z6;
            } else {
                z = z5;
                i6 = i9;
                z3 = z6;
                int i16 = 1;
                ArrayList arrayList7 = this.f2747M;
                ArrayList arrayList8 = c0169a.f2816a;
                int size2 = arrayList8.size() - 1;
                while (size2 >= 0) {
                    Y y5 = (Y) arrayList8.get(size2);
                    int i17 = y5.f2807a;
                    if (i17 != i16) {
                        if (i17 != 3) {
                            switch (i17) {
                                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                    abstractComponentCallbacksC0187t = null;
                                    break;
                                case 9:
                                    abstractComponentCallbacksC0187t = y5.f2808b;
                                    break;
                                case 10:
                                    y5.f2815i = y5.f2814h;
                                    break;
                            }
                            size2--;
                            i16 = 1;
                        }
                        arrayList7.add(y5.f2808b);
                        size2--;
                        i16 = 1;
                    }
                    arrayList7.remove(y5.f2808b);
                    size2--;
                    i16 = 1;
                }
            }
            z6 = z3 || c0169a.f2822g;
            i9 = i6 + 1;
            z5 = z;
        }
        boolean z9 = z5;
        boolean z10 = z6;
        this.f2747M.clear();
        if (!z9 && this.f2769u >= 1) {
            for (int i18 = i4; i18 < i5; i18++) {
                ArrayList arrayList9 = ((C0169a) arrayList.get(i18)).f2816a;
                int size3 = arrayList9.size();
                int i19 = 0;
                while (i19 < size3) {
                    Object obj = arrayList9.get(i19);
                    i19++;
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t5 = ((Y) obj).f2808b;
                    if (abstractComponentCallbacksC0187t5 != null && abstractComponentCallbacksC0187t5.f2941x != null) {
                        yVar.q(g(abstractComponentCallbacksC0187t5));
                    }
                }
            }
        }
        String str2 = "Unknown cmd: ";
        int i20 = i4;
        while (i20 < i5) {
            C0169a c0169a2 = (C0169a) arrayList.get(i20);
            if (((Boolean) arrayList2.get(i20)).booleanValue()) {
                c0169a2.c(-1);
                P p3 = c0169a2.f2830p;
                ArrayList arrayList10 = c0169a2.f2816a;
                boolean z11 = true;
                for (int size4 = arrayList10.size() - 1; size4 >= 0; size4--) {
                    Y y6 = (Y) arrayList10.get(size4);
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t6 = y6.f2808b;
                    if (abstractComponentCallbacksC0187t6 != null) {
                        if (abstractComponentCallbacksC0187t6.f2915M != null) {
                            abstractComponentCallbacksC0187t6.b().f2892a = z11;
                        }
                        int i21 = c0169a2.f2821f;
                        int i22 = 8194;
                        int i23 = 4097;
                        if (i21 != 4097) {
                            if (i21 != 8194) {
                                i22 = 4100;
                                if (i21 != 8197) {
                                    i23 = 4099;
                                    if (i21 != 4099) {
                                        i22 = i21 != 4100 ? 0 : 8197;
                                    }
                                }
                            }
                            i22 = i23;
                        }
                        if (abstractComponentCallbacksC0187t6.f2915M != null || i22 != 0) {
                            abstractComponentCallbacksC0187t6.b();
                            abstractComponentCallbacksC0187t6.f2915M.f2897f = i22;
                        }
                        abstractComponentCallbacksC0187t6.b();
                        abstractComponentCallbacksC0187t6.f2915M.getClass();
                    }
                    switch (y6.f2807a) {
                        case 1:
                            abstractComponentCallbacksC0187t6.v(y6.f2810d, y6.f2811e, y6.f2812f, y6.f2813g);
                            z11 = true;
                            p3.X(abstractComponentCallbacksC0187t6, true);
                            p3.S(abstractComponentCallbacksC0187t6);
                        case 2:
                        default:
                            throw new IllegalArgumentException(str2 + y6.f2807a);
                        case 3:
                            abstractComponentCallbacksC0187t6.v(y6.f2810d, y6.f2811e, y6.f2812f, y6.f2813g);
                            p3.a(abstractComponentCallbacksC0187t6);
                            z11 = true;
                        case 4:
                            abstractComponentCallbacksC0187t6.v(y6.f2810d, y6.f2811e, y6.f2812f, y6.f2813g);
                            p3.getClass();
                            b0(abstractComponentCallbacksC0187t6);
                            z11 = true;
                        case 5:
                            abstractComponentCallbacksC0187t6.v(y6.f2810d, y6.f2811e, y6.f2812f, y6.f2813g);
                            p3.X(abstractComponentCallbacksC0187t6, true);
                            p3.I(abstractComponentCallbacksC0187t6);
                            z11 = true;
                        case 6:
                            abstractComponentCallbacksC0187t6.v(y6.f2810d, y6.f2811e, y6.f2812f, y6.f2813g);
                            p3.c(abstractComponentCallbacksC0187t6);
                            z11 = true;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            abstractComponentCallbacksC0187t6.v(y6.f2810d, y6.f2811e, y6.f2812f, y6.f2813g);
                            p3.X(abstractComponentCallbacksC0187t6, true);
                            p3.h(abstractComponentCallbacksC0187t6);
                            z11 = true;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            p3.Z(null);
                            z11 = true;
                        case 9:
                            p3.Z(abstractComponentCallbacksC0187t6);
                            z11 = true;
                        case 10:
                            p3.Y(abstractComponentCallbacksC0187t6, y6.f2814h);
                            z11 = true;
                    }
                }
            } else {
                c0169a2.c(1);
                P p4 = c0169a2.f2830p;
                ArrayList arrayList11 = c0169a2.f2816a;
                int size5 = arrayList11.size();
                int i24 = 0;
                while (i24 < size5) {
                    Y y7 = (Y) arrayList11.get(i24);
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t7 = y7.f2808b;
                    if (abstractComponentCallbacksC0187t7 != null) {
                        if (abstractComponentCallbacksC0187t7.f2915M != null) {
                            abstractComponentCallbacksC0187t7.b().f2892a = false;
                        }
                        int i25 = c0169a2.f2821f;
                        if (abstractComponentCallbacksC0187t7.f2915M != null || i25 != 0) {
                            abstractComponentCallbacksC0187t7.b();
                            abstractComponentCallbacksC0187t7.f2915M.f2897f = i25;
                        }
                        abstractComponentCallbacksC0187t7.b();
                        abstractComponentCallbacksC0187t7.f2915M.getClass();
                    }
                    switch (y7.f2807a) {
                        case 1:
                            str = str2;
                            abstractComponentCallbacksC0187t7.v(y7.f2810d, y7.f2811e, y7.f2812f, y7.f2813g);
                            p4.X(abstractComponentCallbacksC0187t7, false);
                            p4.a(abstractComponentCallbacksC0187t7);
                            i24++;
                            str2 = str;
                        case 2:
                        default:
                            throw new IllegalArgumentException(str2 + y7.f2807a);
                        case 3:
                            str = str2;
                            abstractComponentCallbacksC0187t7.v(y7.f2810d, y7.f2811e, y7.f2812f, y7.f2813g);
                            p4.S(abstractComponentCallbacksC0187t7);
                            i24++;
                            str2 = str;
                        case 4:
                            str = str2;
                            abstractComponentCallbacksC0187t7.v(y7.f2810d, y7.f2811e, y7.f2812f, y7.f2813g);
                            p4.I(abstractComponentCallbacksC0187t7);
                            i24++;
                            str2 = str;
                        case 5:
                            str = str2;
                            abstractComponentCallbacksC0187t7.v(y7.f2810d, y7.f2811e, y7.f2812f, y7.f2813g);
                            p4.X(abstractComponentCallbacksC0187t7, false);
                            b0(abstractComponentCallbacksC0187t7);
                            i24++;
                            str2 = str;
                        case 6:
                            str = str2;
                            abstractComponentCallbacksC0187t7.v(y7.f2810d, y7.f2811e, y7.f2812f, y7.f2813g);
                            p4.h(abstractComponentCallbacksC0187t7);
                            i24++;
                            str2 = str;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            str = str2;
                            abstractComponentCallbacksC0187t7.v(y7.f2810d, y7.f2811e, y7.f2812f, y7.f2813g);
                            p4.X(abstractComponentCallbacksC0187t7, false);
                            p4.c(abstractComponentCallbacksC0187t7);
                            i24++;
                            str2 = str;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            p4.Z(abstractComponentCallbacksC0187t7);
                            str = str2;
                            i24++;
                            str2 = str;
                        case 9:
                            p4.Z(null);
                            str = str2;
                            i24++;
                            str2 = str;
                        case 10:
                            p4.Y(abstractComponentCallbacksC0187t7, y7.f2815i);
                            str = str2;
                            i24++;
                            str2 = str;
                    }
                }
            }
            i20++;
            str2 = str2;
        }
        boolean booleanValue = ((Boolean) arrayList2.get(i5 - 1)).booleanValue();
        if (z10 && !arrayList3.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size6 = arrayList.size();
            int i26 = 0;
            while (i26 < size6) {
                Object obj2 = arrayList.get(i26);
                i26++;
                linkedHashSet.addAll(E((C0169a) obj2));
            }
            if (this.f2757h == null) {
                int size7 = arrayList3.size();
                int i27 = 0;
                while (i27 < size7) {
                    Object obj3 = arrayList3.get(i27);
                    i27++;
                    if (obj3 == null) {
                        Iterator it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            throw null;
                        }
                    } else {
                        throw new ClassCastException();
                    }
                }
                int size8 = arrayList3.size();
                int i28 = 0;
                while (i28 < size8) {
                    Object obj4 = arrayList3.get(i28);
                    i28++;
                    if (obj4 == null) {
                        Iterator it2 = linkedHashSet.iterator();
                        if (it2.hasNext()) {
                            throw null;
                        }
                    } else {
                        throw new ClassCastException();
                    }
                }
            }
        }
        for (int i29 = i4; i29 < i5; i29++) {
            C0169a c0169a3 = (C0169a) arrayList.get(i29);
            if (booleanValue) {
                for (int size9 = c0169a3.f2816a.size() - 1; size9 >= 0; size9--) {
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t8 = ((Y) c0169a3.f2816a.get(size9)).f2808b;
                    if (abstractComponentCallbacksC0187t8 != null) {
                        g(abstractComponentCallbacksC0187t8).j();
                    }
                }
            } else {
                ArrayList arrayList12 = c0169a3.f2816a;
                int size10 = arrayList12.size();
                int i30 = 0;
                while (i30 < size10) {
                    Object obj5 = arrayList12.get(i30);
                    i30++;
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t9 = ((Y) obj5).f2808b;
                    if (abstractComponentCallbacksC0187t9 != null) {
                        g(abstractComponentCallbacksC0187t9).j();
                    }
                }
            }
        }
        O(this.f2769u, true);
        int i31 = i4;
        Iterator it3 = f(arrayList, i31, i5).iterator();
        while (it3.hasNext()) {
            C0181m c0181m = (C0181m) it3.next();
            c0181m.f2871d = booleanValue;
            synchronized (c0181m.f2869b) {
                c0181m.g();
                ArrayList arrayList13 = c0181m.f2869b;
                ListIterator listIterator = arrayList13.listIterator(arrayList13.size());
                if (!listIterator.hasPrevious()) {
                    c0181m.f2872e = false;
                } else {
                    ((c0) listIterator.previous()).getClass();
                    throw null;
                }
            }
            c0181m.c();
        }
        while (i31 < i5) {
            C0169a c0169a4 = (C0169a) arrayList.get(i31);
            if (((Boolean) arrayList2.get(i31)).booleanValue() && c0169a4.f2832r >= 0) {
                c0169a4.f2832r = -1;
            }
            c0169a4.getClass();
            i31++;
        }
        if (z10 && arrayList3.size() > 0) {
            throw A2.i.f(arrayList3, 0);
        }
    }

    public final AbstractComponentCallbacksC0187t C(int i4) {
        P1.y yVar = this.f2752c;
        ArrayList arrayList = (ArrayList) yVar.f1469f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = (AbstractComponentCallbacksC0187t) arrayList.get(size);
            if (abstractComponentCallbacksC0187t != null && abstractComponentCallbacksC0187t.f2904B == i4) {
                return abstractComponentCallbacksC0187t;
            }
        }
        for (X x3 : ((HashMap) yVar.f1470g).values()) {
            if (x3 != null) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = x3.f2804c;
                if (abstractComponentCallbacksC0187t2.f2904B == i4) {
                    return abstractComponentCallbacksC0187t2;
                }
            }
        }
        return null;
    }

    public final void D() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            C0181m c0181m = (C0181m) it.next();
            if (c0181m.f2872e) {
                if (J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                c0181m.f2872e = false;
                c0181m.c();
            }
        }
    }

    public final ViewGroup F(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        ViewGroup viewGroup = abstractComponentCallbacksC0187t.f2912J;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC0187t.f2905C > 0 && this.f2771w.c()) {
            View b4 = this.f2771w.b(abstractComponentCallbacksC0187t.f2905C);
            if (b4 instanceof ViewGroup) {
                return (ViewGroup) b4;
            }
            return null;
        }
        return null;
    }

    public final I G() {
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2772x;
        if (abstractComponentCallbacksC0187t != null) {
            return abstractComponentCallbacksC0187t.f2941x.G();
        }
        return this.z;
    }

    public final Z0.g H() {
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2772x;
        if (abstractComponentCallbacksC0187t != null) {
            return abstractComponentCallbacksC0187t.f2941x.H();
        }
        return this.f2735A;
    }

    public final void I(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (J(2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC0187t);
        }
        if (!abstractComponentCallbacksC0187t.f2907E) {
            abstractComponentCallbacksC0187t.f2907E = true;
            abstractComponentCallbacksC0187t.f2916N = true ^ abstractComponentCallbacksC0187t.f2916N;
            a0(abstractComponentCallbacksC0187t);
        }
    }

    public final boolean L() {
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2772x;
        if (abstractComponentCallbacksC0187t != null) {
            if (abstractComponentCallbacksC0187t.f2942y != null && abstractComponentCallbacksC0187t.f2933p && abstractComponentCallbacksC0187t.e().L()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void O(int i4, boolean z) {
        C0191x c0191x;
        if (this.f2770v == null && i4 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i4 != this.f2769u) {
            this.f2769u = i4;
            P1.y yVar = this.f2752c;
            HashMap hashMap = (HashMap) yVar.f1470g;
            ArrayList arrayList = (ArrayList) yVar.f1469f;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                X x3 = (X) hashMap.get(((AbstractComponentCallbacksC0187t) obj).f2928j);
                if (x3 != null) {
                    x3.j();
                }
            }
            for (X x4 : hashMap.values()) {
                if (x4 != null) {
                    x4.j();
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x4.f2804c;
                    if (abstractComponentCallbacksC0187t.f2934q && !abstractComponentCallbacksC0187t.i()) {
                        yVar.s(x4);
                    }
                }
            }
            c0();
            if (this.f2740F && (c0191x = this.f2770v) != null && this.f2769u == 7) {
                c0191x.f2952j.invalidateMenu();
                this.f2740F = false;
            }
        }
    }

    public final void P() {
        if (this.f2770v != null) {
            this.f2741G = false;
            this.f2742H = false;
            this.f2748N.f2788i = false;
            for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
                if (abstractComponentCallbacksC0187t != null) {
                    abstractComponentCallbacksC0187t.z.P();
                }
            }
        }
    }

    public final boolean Q() {
        A(false);
        z(true);
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2773y;
        if (abstractComponentCallbacksC0187t != null && abstractComponentCallbacksC0187t.c().Q()) {
            return true;
        }
        boolean R3 = R(this.f2745K, this.f2746L, -1, 0);
        if (R3) {
            this.f2751b = true;
            try {
                T(this.f2745K, this.f2746L);
            } finally {
                d();
            }
        }
        e0();
        v();
        ((HashMap) this.f2752c.f1470g).values().removeAll(Collections.singleton(null));
        return R3;
    }

    public final boolean R(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        boolean z;
        if ((i5 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        int i6 = -1;
        if (!this.f2753d.isEmpty()) {
            if (i4 < 0) {
                i6 = z ? 0 : this.f2753d.size() - 1;
            } else {
                int size = this.f2753d.size() - 1;
                while (size >= 0) {
                    C0169a c0169a = (C0169a) this.f2753d.get(size);
                    if (i4 >= 0 && i4 == c0169a.f2832r) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    i6 = size;
                } else if (z) {
                    i6 = size;
                    while (i6 > 0) {
                        C0169a c0169a2 = (C0169a) this.f2753d.get(i6 - 1);
                        if (i4 < 0 || i4 != c0169a2.f2832r) {
                            break;
                        }
                        i6--;
                    }
                } else if (size != this.f2753d.size() - 1) {
                    i6 = size + 1;
                }
            }
        }
        if (i6 < 0) {
            return false;
        }
        for (int size2 = this.f2753d.size() - 1; size2 >= i6; size2--) {
            arrayList.add((C0169a) this.f2753d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void S(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (J(2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC0187t + " nesting=" + abstractComponentCallbacksC0187t.f2940w);
        }
        boolean i4 = abstractComponentCallbacksC0187t.i();
        if (abstractComponentCallbacksC0187t.f2908F && i4) {
            return;
        }
        P1.y yVar = this.f2752c;
        synchronized (((ArrayList) yVar.f1469f)) {
            ((ArrayList) yVar.f1469f).remove(abstractComponentCallbacksC0187t);
        }
        abstractComponentCallbacksC0187t.f2933p = false;
        if (K(abstractComponentCallbacksC0187t)) {
            this.f2740F = true;
        }
        abstractComponentCallbacksC0187t.f2934q = true;
        a0(abstractComponentCallbacksC0187t);
    }

    public final void T(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i4 = 0;
                int i5 = 0;
                while (i4 < size) {
                    if (!((C0169a) arrayList.get(i4)).f2829o) {
                        if (i5 != i4) {
                            B(arrayList, arrayList2, i5, i4);
                        }
                        i5 = i4 + 1;
                        if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                            while (i5 < size && ((Boolean) arrayList2.get(i5)).booleanValue() && !((C0169a) arrayList.get(i5)).f2829o) {
                                i5++;
                            }
                        }
                        B(arrayList, arrayList2, i4, i5);
                        i4 = i5 - 1;
                    }
                    i4++;
                }
                if (i5 != size) {
                    B(arrayList, arrayList2, i5, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, androidx.fragment.app.Y] */
    public final void U(Bundle bundle) {
        E0.a aVar;
        int i4;
        boolean z;
        int i5;
        Bundle bundle2;
        X x3;
        Bundle bundle3;
        Bundle bundle4;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle4 = bundle.getBundle(str)) != null) {
                bundle4.setClassLoader(this.f2770v.f2949g.getClassLoader());
                this.f2760l.put(str.substring(7), bundle4);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle3 = bundle.getBundle(str2)) != null) {
                bundle3.setClassLoader(this.f2770v.f2949g.getClassLoader());
                hashMap.put(str2.substring(9), bundle3);
            }
        }
        P1.y yVar = this.f2752c;
        HashMap hashMap2 = (HashMap) yVar.f1471h;
        HashMap hashMap3 = (HashMap) yVar.f1470g;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        S s3 = (S) bundle.getParcelable("state");
        if (s3 == null) {
            return;
        }
        hashMap3.clear();
        ArrayList arrayList = s3.f2774f;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            aVar = this.f2762n;
            if (i6 >= size) {
                break;
            }
            Object obj = arrayList.get(i6);
            i6++;
            Bundle x4 = yVar.x((String) obj, null);
            if (x4 != null) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = (AbstractComponentCallbacksC0187t) this.f2748N.f2783d.get(((W) x4.getParcelable("state")).f2790g);
                if (abstractComponentCallbacksC0187t != null) {
                    if (J(2)) {
                        i5 = 2;
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC0187t);
                    } else {
                        i5 = 2;
                    }
                    x3 = new X(aVar, yVar, abstractComponentCallbacksC0187t, x4);
                    bundle2 = x4;
                } else {
                    i5 = 2;
                    bundle2 = x4;
                    x3 = new X(this.f2762n, this.f2752c, this.f2770v.f2949g.getClassLoader(), G(), x4);
                }
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = x3.f2804c;
                abstractComponentCallbacksC0187t2.f2925g = bundle2;
                abstractComponentCallbacksC0187t2.f2941x = this;
                if (J(i5)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC0187t2.f2928j + "): " + abstractComponentCallbacksC0187t2);
                }
                x3.l(this.f2770v.f2949g.getClassLoader());
                yVar.q(x3);
                x3.f2806e = this.f2769u;
            }
        }
        U u3 = this.f2748N;
        u3.getClass();
        ArrayList arrayList2 = new ArrayList(u3.f2783d.values());
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj2 = arrayList2.get(i7);
            i7++;
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t3 = (AbstractComponentCallbacksC0187t) obj2;
            if (hashMap3.get(abstractComponentCallbacksC0187t3.f2928j) == null) {
                if (J(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC0187t3 + " that was not found in the set of active Fragments " + s3.f2774f);
                }
                this.f2748N.f(abstractComponentCallbacksC0187t3);
                abstractComponentCallbacksC0187t3.f2941x = this;
                X x5 = new X(aVar, yVar, abstractComponentCallbacksC0187t3);
                x5.f2806e = 1;
                x5.j();
                abstractComponentCallbacksC0187t3.f2934q = true;
                x5.j();
            }
        }
        ArrayList arrayList3 = s3.f2775g;
        ((ArrayList) yVar.f1469f).clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i8 = 0;
            while (i8 < size3) {
                Object obj3 = arrayList3.get(i8);
                i8++;
                String str3 = (String) obj3;
                AbstractComponentCallbacksC0187t e4 = yVar.e(str3);
                if (e4 != null) {
                    if (J(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + e4);
                    }
                    yVar.a(e4);
                } else {
                    throw new IllegalStateException(r2.k.b("No instantiated fragment for (", str3, ")"));
                }
            }
        }
        if (s3.f2776h != null) {
            this.f2753d = new ArrayList(s3.f2776h.length);
            int i9 = 0;
            while (true) {
                C0170b[] c0170bArr = s3.f2776h;
                if (i9 >= c0170bArr.length) {
                    break;
                }
                C0170b c0170b = c0170bArr[i9];
                ArrayList arrayList4 = c0170b.f2836g;
                C0169a c0169a = new C0169a(this);
                int[] iArr = c0170b.f2835f;
                int i10 = 0;
                int i11 = 0;
                while (i10 < iArr.length) {
                    ?? obj4 = new Object();
                    int i12 = i10 + 1;
                    obj4.f2807a = iArr[i10];
                    if (J(2)) {
                        Log.v("FragmentManager", "Instantiate " + c0169a + " op #" + i11 + " base fragment #" + iArr[i12]);
                    }
                    obj4.f2814h = EnumC0207n.values()[c0170b.f2837h[i11]];
                    obj4.f2815i = EnumC0207n.values()[c0170b.f2838i[i11]];
                    int i13 = i10 + 2;
                    if (iArr[i12] != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    obj4.f2809c = z;
                    int i14 = iArr[i13];
                    obj4.f2810d = i14;
                    int i15 = iArr[i10 + 3];
                    obj4.f2811e = i15;
                    int i16 = i10 + 5;
                    int i17 = iArr[i10 + 4];
                    obj4.f2812f = i17;
                    i10 += 6;
                    int[] iArr2 = iArr;
                    int i18 = iArr2[i16];
                    obj4.f2813g = i18;
                    c0169a.f2817b = i14;
                    c0169a.f2818c = i15;
                    c0169a.f2819d = i17;
                    c0169a.f2820e = i18;
                    c0169a.b(obj4);
                    i11++;
                    iArr = iArr2;
                }
                c0169a.f2821f = c0170b.f2839j;
                c0169a.f2823h = c0170b.k;
                c0169a.f2822g = true;
                c0169a.f2824i = c0170b.f2841m;
                c0169a.f2825j = c0170b.f2842n;
                c0169a.k = c0170b.f2843o;
                c0169a.f2826l = c0170b.f2844p;
                c0169a.f2827m = c0170b.f2845q;
                c0169a.f2828n = c0170b.f2846r;
                c0169a.f2829o = c0170b.f2847s;
                c0169a.f2832r = c0170b.f2840l;
                for (int i19 = 0; i19 < arrayList4.size(); i19++) {
                    String str4 = (String) arrayList4.get(i19);
                    if (str4 != null) {
                        ((Y) c0169a.f2816a.get(i19)).f2808b = yVar.e(str4);
                    }
                }
                c0169a.c(1);
                if (J(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i9 + " (index " + c0169a.f2832r + "): " + c0169a);
                    PrintWriter printWriter = new PrintWriter(new a0());
                    c0169a.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2753d.add(c0169a);
                i9++;
            }
            i4 = 0;
        } else {
            i4 = 0;
            this.f2753d = new ArrayList();
        }
        this.f2759j.set(s3.f2777i);
        String str5 = s3.f2778j;
        if (str5 != null) {
            AbstractComponentCallbacksC0187t e5 = yVar.e(str5);
            this.f2773y = e5;
            r(e5);
        }
        ArrayList arrayList5 = s3.k;
        if (arrayList5 != null) {
            for (int i20 = i4; i20 < arrayList5.size(); i20++) {
                this.k.put((String) arrayList5.get(i20), (C0171c) s3.f2779l.get(i20));
            }
        }
        this.f2739E = new ArrayDeque(s3.f2780m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.fragment.app.S, android.os.Parcelable, java.lang.Object] */
    public final Bundle V() {
        int i4;
        ArrayList arrayList;
        C0170b[] c0170bArr;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        D();
        x();
        A(true);
        this.f2741G = true;
        this.f2748N.f2788i = true;
        P1.y yVar = this.f2752c;
        yVar.getClass();
        HashMap hashMap = (HashMap) yVar.f1470g;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        Iterator it = hashMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            X x3 = (X) it.next();
            if (x3 != null) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x3.f2804c;
                String str = abstractComponentCallbacksC0187t.f2928j;
                Bundle bundle3 = new Bundle();
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = x3.f2804c;
                if (abstractComponentCallbacksC0187t2.f2924f == -1 && (bundle = abstractComponentCallbacksC0187t2.f2925g) != null) {
                    bundle3.putAll(bundle);
                }
                bundle3.putParcelable("state", new W(abstractComponentCallbacksC0187t2));
                if (abstractComponentCallbacksC0187t2.f2924f > -1) {
                    Bundle bundle4 = new Bundle();
                    abstractComponentCallbacksC0187t2.q(bundle4);
                    if (!bundle4.isEmpty()) {
                        bundle3.putBundle("savedInstanceState", bundle4);
                    }
                    x3.f2802a.r(abstractComponentCallbacksC0187t2, bundle4, false);
                    Bundle bundle5 = new Bundle();
                    abstractComponentCallbacksC0187t2.f2921T.c(bundle5);
                    if (!bundle5.isEmpty()) {
                        bundle3.putBundle("registryState", bundle5);
                    }
                    Bundle V3 = abstractComponentCallbacksC0187t2.z.V();
                    if (!V3.isEmpty()) {
                        bundle3.putBundle("childFragmentManager", V3);
                    }
                    SparseArray<? extends Parcelable> sparseArray = abstractComponentCallbacksC0187t2.f2926h;
                    if (sparseArray != null) {
                        bundle3.putSparseParcelableArray("viewState", sparseArray);
                    }
                    Bundle bundle6 = abstractComponentCallbacksC0187t2.f2927i;
                    if (bundle6 != null) {
                        bundle3.putBundle("viewRegistryState", bundle6);
                    }
                }
                Bundle bundle7 = abstractComponentCallbacksC0187t2.k;
                if (bundle7 != null) {
                    bundle3.putBundle("arguments", bundle7);
                }
                yVar.x(str, bundle3);
                arrayList2.add(abstractComponentCallbacksC0187t.f2928j);
                if (J(2)) {
                    Log.v("FragmentManager", "Saved state of " + abstractComponentCallbacksC0187t + ": " + abstractComponentCallbacksC0187t.f2925g);
                }
            }
        }
        HashMap hashMap2 = (HashMap) this.f2752c.f1471h;
        if (hashMap2.isEmpty()) {
            if (J(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return bundle2;
            }
        } else {
            P1.y yVar2 = this.f2752c;
            synchronized (((ArrayList) yVar2.f1469f)) {
                try {
                    if (((ArrayList) yVar2.f1469f).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) yVar2.f1469f).size());
                        ArrayList arrayList3 = (ArrayList) yVar2.f1469f;
                        int size = arrayList3.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Object obj = arrayList3.get(i5);
                            i5++;
                            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t3 = (AbstractComponentCallbacksC0187t) obj;
                            arrayList.add(abstractComponentCallbacksC0187t3.f2928j);
                            if (J(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + abstractComponentCallbacksC0187t3.f2928j + "): " + abstractComponentCallbacksC0187t3);
                            }
                        }
                    }
                } finally {
                }
            }
            int size2 = this.f2753d.size();
            if (size2 > 0) {
                c0170bArr = new C0170b[size2];
                for (i4 = 0; i4 < size2; i4++) {
                    c0170bArr[i4] = new C0170b((C0169a) this.f2753d.get(i4));
                    if (J(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.f2753d.get(i4));
                    }
                }
            } else {
                c0170bArr = null;
            }
            ?? obj2 = new Object();
            obj2.f2778j = null;
            ArrayList arrayList4 = new ArrayList();
            obj2.k = arrayList4;
            ArrayList arrayList5 = new ArrayList();
            obj2.f2779l = arrayList5;
            obj2.f2774f = arrayList2;
            obj2.f2775g = arrayList;
            obj2.f2776h = c0170bArr;
            obj2.f2777i = this.f2759j.get();
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t4 = this.f2773y;
            if (abstractComponentCallbacksC0187t4 != null) {
                obj2.f2778j = abstractComponentCallbacksC0187t4.f2928j;
            }
            arrayList4.addAll(this.k.keySet());
            arrayList5.addAll(this.k.values());
            obj2.f2780m = new ArrayList(this.f2739E);
            bundle2.putParcelable("state", obj2);
            for (String str2 : this.f2760l.keySet()) {
                bundle2.putBundle(r2.k.d("result_", str2), (Bundle) this.f2760l.get(str2));
            }
            for (String str3 : hashMap2.keySet()) {
                bundle2.putBundle(r2.k.d("fragment_", str3), (Bundle) hashMap2.get(str3));
            }
        }
        return bundle2;
    }

    public final void W() {
        synchronized (this.f2750a) {
            try {
                if (this.f2750a.size() == 1) {
                    this.f2770v.f2950h.removeCallbacks(this.f2749O);
                    this.f2770v.f2950h.post(this.f2749O);
                    e0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void X(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        ViewGroup F3 = F(abstractComponentCallbacksC0187t);
        if (F3 != null && (F3 instanceof B)) {
            ((B) F3).setDrawDisappearingViewsLast(!z);
        }
    }

    public final void Y(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, EnumC0207n enumC0207n) {
        if (abstractComponentCallbacksC0187t.equals(this.f2752c.e(abstractComponentCallbacksC0187t.f2928j)) && (abstractComponentCallbacksC0187t.f2942y == null || abstractComponentCallbacksC0187t.f2941x == this)) {
            abstractComponentCallbacksC0187t.f2918Q = enumC0207n;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0187t + " is not an active fragment of FragmentManager " + this);
    }

    public final void Z(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (abstractComponentCallbacksC0187t != null) {
            if (!abstractComponentCallbacksC0187t.equals(this.f2752c.e(abstractComponentCallbacksC0187t.f2928j)) || (abstractComponentCallbacksC0187t.f2942y != null && abstractComponentCallbacksC0187t.f2941x != this)) {
                throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0187t + " is not an active fragment of FragmentManager " + this);
            }
        }
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = this.f2773y;
        this.f2773y = abstractComponentCallbacksC0187t;
        r(abstractComponentCallbacksC0187t2);
        r(this.f2773y);
    }

    public final X a(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        String str = abstractComponentCallbacksC0187t.P;
        if (str != null) {
            Y.d.c(abstractComponentCallbacksC0187t, str);
        }
        if (J(2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC0187t);
        }
        X g4 = g(abstractComponentCallbacksC0187t);
        abstractComponentCallbacksC0187t.f2941x = this;
        P1.y yVar = this.f2752c;
        yVar.q(g4);
        if (!abstractComponentCallbacksC0187t.f2908F) {
            yVar.a(abstractComponentCallbacksC0187t);
            abstractComponentCallbacksC0187t.f2934q = false;
            abstractComponentCallbacksC0187t.f2916N = false;
            if (K(abstractComponentCallbacksC0187t)) {
                this.f2740F = true;
            }
        }
        return g4;
    }

    public final void a0(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        int i4;
        int i5;
        int i6;
        int i7;
        ViewGroup F3 = F(abstractComponentCallbacksC0187t);
        if (F3 != null) {
            C0186s c0186s = abstractComponentCallbacksC0187t.f2915M;
            boolean z = false;
            if (c0186s == null) {
                i4 = 0;
            } else {
                i4 = c0186s.f2893b;
            }
            if (c0186s == null) {
                i5 = 0;
            } else {
                i5 = c0186s.f2894c;
            }
            int i8 = i5 + i4;
            if (c0186s == null) {
                i6 = 0;
            } else {
                i6 = c0186s.f2895d;
            }
            int i9 = i6 + i8;
            if (c0186s == null) {
                i7 = 0;
            } else {
                i7 = c0186s.f2896e;
            }
            if (i7 + i9 > 0) {
                if (F3.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    F3.setTag(R.id.visible_removing_fragment_view_tag, abstractComponentCallbacksC0187t);
                }
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = (AbstractComponentCallbacksC0187t) F3.getTag(R.id.visible_removing_fragment_view_tag);
                C0186s c0186s2 = abstractComponentCallbacksC0187t.f2915M;
                if (c0186s2 != null) {
                    z = c0186s2.f2892a;
                }
                if (abstractComponentCallbacksC0187t2.f2915M != null) {
                    abstractComponentCallbacksC0187t2.b().f2892a = z;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(C0191x c0191x, A a4, AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        String str;
        C0191x c0191x2;
        if (this.f2770v == null) {
            this.f2770v = c0191x;
            this.f2771w = a4;
            this.f2772x = abstractComponentCallbacksC0187t;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f2763o;
            if (abstractComponentCallbacksC0187t != 0) {
                copyOnWriteArrayList.add(new J(abstractComponentCallbacksC0187t));
            } else if (c0191x != null) {
                copyOnWriteArrayList.add(c0191x);
            }
            if (this.f2772x != null) {
                e0();
            }
            boolean z = false;
            if (c0191x != null) {
                e.t onBackPressedDispatcher = c0191x.f2952j.getOnBackPressedDispatcher();
                this.f2756g = onBackPressedDispatcher;
                if (abstractComponentCallbacksC0187t != 0) {
                    c0191x2 = abstractComponentCallbacksC0187t;
                } else {
                    c0191x2 = c0191x;
                }
                onBackPressedDispatcher.getClass();
                G g4 = this.f2758i;
                T2.h.e(g4, "onBackPressedCallback");
                AbstractC0208o lifecycle = c0191x2.getLifecycle();
                if (((C0214v) lifecycle).f3024c != EnumC0207n.f3014f) {
                    e.p pVar = new e.p(g4, new e.q(g4, c0191x2));
                    g4.f2721a.add(pVar);
                    pVar.c(false);
                    d0.c cVar = onBackPressedDispatcher.a().f3580c;
                    cVar.getClass();
                    if (cVar.f3434c.add(pVar)) {
                        d0.f fVar = cVar.f3433b;
                        fVar.getClass();
                        if (pVar.f3575c == null) {
                            fVar.f3444e.addFirst(pVar);
                            pVar.f3575c = cVar;
                            fVar.b();
                        } else {
                            throw new IllegalArgumentException(("Handler '" + pVar + "' is already registered with a dispatcher").toString());
                        }
                    }
                    e.s sVar = new e.s(pVar, onBackPressedDispatcher, lifecycle);
                    lifecycle.a(sVar);
                    g4.f2723c.add(sVar);
                }
            }
            if (abstractComponentCallbacksC0187t != 0) {
                U u3 = abstractComponentCallbacksC0187t.f2941x.f2748N;
                HashMap hashMap = u3.f2784e;
                U u4 = (U) hashMap.get(abstractComponentCallbacksC0187t.f2928j);
                if (u4 == null) {
                    u4 = new U(u3.f2786g);
                    hashMap.put(abstractComponentCallbacksC0187t.f2928j, u4);
                }
                this.f2748N = u4;
            } else if (c0191x != null) {
                A2.t tVar = new A2.t(c0191x.f2952j.getViewModelStore(), U.f2782j);
                String canonicalName = U.class.getCanonicalName();
                if (canonicalName != null) {
                    this.f2748N = (U) tVar.F(U.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.f2748N = new U(false);
            }
            U u5 = this.f2748N;
            if (this.f2741G || this.f2742H) {
                z = true;
            }
            u5.f2788i = z;
            this.f2752c.f1472i = u5;
            C0191x c0191x3 = this.f2770v;
            if (c0191x3 != null && abstractComponentCallbacksC0187t == 0) {
                C0362e savedStateRegistry = c0191x3.f2952j.getSavedStateRegistry();
                savedStateRegistry.c("android:support:fragments", new C0188u(1, this));
                Bundle a5 = savedStateRegistry.a("android:support:fragments");
                if (a5 != null) {
                    U(a5);
                }
            }
            C0191x c0191x4 = this.f2770v;
            if (c0191x4 != null) {
                g.i activityResultRegistry = c0191x4.f2952j.getActivityResultRegistry();
                if (abstractComponentCallbacksC0187t != 0) {
                    str = r2.k.c(new StringBuilder(), abstractComponentCallbacksC0187t.f2928j, ":");
                } else {
                    str = "";
                }
                String d4 = r2.k.d("FragmentManager:", str);
                this.f2736B = activityResultRegistry.c(r2.k.a(d4, "StartActivityForResult"), new K(3), new A2.q(16, this));
                this.f2737C = activityResultRegistry.c(r2.k.a(d4, "StartIntentSenderForResult"), new K(0), new F(this, 1));
                this.f2738D = activityResultRegistry.c(r2.k.a(d4, "RequestPermissions"), new K(2), new F(this, 0));
            }
            C0191x c0191x5 = this.f2770v;
            if (c0191x5 != null) {
                c0191x5.addOnConfigurationChangedListener(this.f2764p);
            }
            C0191x c0191x6 = this.f2770v;
            if (c0191x6 != null) {
                c0191x6.f2952j.addOnTrimMemoryListener(this.f2765q);
            }
            C0191x c0191x7 = this.f2770v;
            if (c0191x7 != null) {
                c0191x7.f2952j.addOnMultiWindowModeChangedListener(this.f2766r);
            }
            C0191x c0191x8 = this.f2770v;
            if (c0191x8 != null) {
                c0191x8.f2952j.addOnPictureInPictureModeChangedListener(this.f2767s);
            }
            C0191x c0191x9 = this.f2770v;
            if (c0191x9 != null && abstractComponentCallbacksC0187t == 0) {
                c0191x9.f2952j.addMenuProvider(this.f2768t);
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void c(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (J(2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC0187t);
        }
        if (abstractComponentCallbacksC0187t.f2908F) {
            abstractComponentCallbacksC0187t.f2908F = false;
            if (!abstractComponentCallbacksC0187t.f2933p) {
                this.f2752c.a(abstractComponentCallbacksC0187t);
                if (J(2)) {
                    Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC0187t);
                }
                if (K(abstractComponentCallbacksC0187t)) {
                    this.f2740F = true;
                }
            }
        }
    }

    public final void c0() {
        ArrayList h3 = this.f2752c.h();
        int size = h3.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = h3.get(i4);
            i4++;
            X x3 = (X) obj;
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x3.f2804c;
            if (abstractComponentCallbacksC0187t.f2913K) {
                if (this.f2751b) {
                    this.f2744J = true;
                } else {
                    abstractComponentCallbacksC0187t.f2913K = false;
                    x3.j();
                }
            }
        }
    }

    public final void d() {
        this.f2751b = false;
        this.f2746L.clear();
        this.f2745K.clear();
    }

    public final void d0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a0());
        C0191x c0191x = this.f2770v;
        if (c0191x != null) {
            try {
                c0191x.f2952j.dump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e4) {
                Log.e("FragmentManager", "Failed dumping state", e4);
                throw illegalStateException;
            }
        }
        try {
            w("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e5) {
            Log.e("FragmentManager", "Failed dumping state", e5);
            throw illegalStateException;
        }
    }

    public final HashSet e() {
        C0181m c0181m;
        HashSet hashSet = new HashSet();
        ArrayList h3 = this.f2752c.h();
        int size = h3.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = h3.get(i4);
            i4++;
            ViewGroup viewGroup = ((X) obj).f2804c.f2912J;
            if (viewGroup != null) {
                T2.h.e(H(), "factory");
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof C0181m) {
                    c0181m = (C0181m) tag;
                } else {
                    c0181m = new C0181m(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, c0181m);
                }
                hashSet.add(c0181m);
            }
        }
        return hashSet;
    }

    public final void e0() {
        int i4;
        synchronized (this.f2750a) {
            try {
                boolean z = true;
                if (!this.f2750a.isEmpty()) {
                    this.f2758i.a(true);
                    if (J(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                int size = this.f2753d.size();
                if (this.f2757h != null) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                if (size + i4 <= 0 || !N(this.f2772x)) {
                    z = false;
                }
                if (J(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.f2758i.a(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet f(ArrayList arrayList, int i4, int i5) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i4 < i5) {
            ArrayList arrayList2 = ((C0169a) arrayList.get(i4)).f2816a;
            int size = arrayList2.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList2.get(i6);
                i6++;
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = ((Y) obj).f2808b;
                if (abstractComponentCallbacksC0187t != null && (viewGroup = abstractComponentCallbacksC0187t.f2912J) != null) {
                    hashSet.add(C0181m.e(viewGroup, this));
                }
            }
            i4++;
        }
        return hashSet;
    }

    public final X g(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        String str = abstractComponentCallbacksC0187t.f2928j;
        P1.y yVar = this.f2752c;
        X x3 = (X) ((HashMap) yVar.f1470g).get(str);
        if (x3 != null) {
            return x3;
        }
        X x4 = new X(this.f2762n, yVar, abstractComponentCallbacksC0187t);
        x4.l(this.f2770v.f2949g.getClassLoader());
        x4.f2806e = this.f2769u;
        return x4;
    }

    public final void h(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (J(2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC0187t);
        }
        if (!abstractComponentCallbacksC0187t.f2908F) {
            abstractComponentCallbacksC0187t.f2908F = true;
            if (abstractComponentCallbacksC0187t.f2933p) {
                if (J(2)) {
                    Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC0187t);
                }
                P1.y yVar = this.f2752c;
                synchronized (((ArrayList) yVar.f1469f)) {
                    ((ArrayList) yVar.f1469f).remove(abstractComponentCallbacksC0187t);
                }
                abstractComponentCallbacksC0187t.f2933p = false;
                if (K(abstractComponentCallbacksC0187t)) {
                    this.f2740F = true;
                }
                a0(abstractComponentCallbacksC0187t);
            }
        }
    }

    public final void i(boolean z) {
        if (z && this.f2770v != null) {
            d0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null) {
                abstractComponentCallbacksC0187t.f2911I = true;
                if (z) {
                    abstractComponentCallbacksC0187t.z.i(true);
                }
            }
        }
    }

    public final boolean j() {
        boolean z;
        if (this.f2769u >= 1) {
            for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
                if (abstractComponentCallbacksC0187t != null) {
                    if (!abstractComponentCallbacksC0187t.f2907E) {
                        z = abstractComponentCallbacksC0187t.z.j();
                    } else {
                        z = false;
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean k() {
        boolean z;
        if (this.f2769u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z3 = false;
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null && M(abstractComponentCallbacksC0187t)) {
                if (!abstractComponentCallbacksC0187t.f2907E) {
                    z = abstractComponentCallbacksC0187t.z.k();
                } else {
                    z = false;
                }
                if (z) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(abstractComponentCallbacksC0187t);
                    z3 = true;
                }
            }
        }
        if (this.f2754e != null) {
            for (int i4 = 0; i4 < this.f2754e.size(); i4++) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = (AbstractComponentCallbacksC0187t) this.f2754e.get(i4);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC0187t2)) {
                    abstractComponentCallbacksC0187t2.getClass();
                }
            }
        }
        this.f2754e = arrayList;
        return z3;
    }

    public final void l() {
        boolean z;
        boolean isTerminated;
        this.f2743I = true;
        A(true);
        x();
        C0191x c0191x = this.f2770v;
        P1.y yVar = this.f2752c;
        if (c0191x != null) {
            z = ((U) yVar.f1472i).f2787h;
        } else {
            AbstractActivityC0416k abstractActivityC0416k = c0191x.f2949g;
            if (abstractActivityC0416k != null) {
                z = !abstractActivityC0416k.isChangingConfigurations();
            } else {
                z = true;
            }
        }
        int i4 = 0;
        if (z) {
            Iterator it = this.k.values().iterator();
            while (it.hasNext()) {
                ArrayList arrayList = ((C0171c) it.next()).f2849f;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((U) yVar.f1472i).d((String) obj, false);
                }
            }
        }
        u(-1);
        C0191x c0191x2 = this.f2770v;
        if (c0191x2 != null) {
            c0191x2.f2952j.removeOnTrimMemoryListener(this.f2765q);
        }
        C0191x c0191x3 = this.f2770v;
        if (c0191x3 != null) {
            c0191x3.removeOnConfigurationChangedListener(this.f2764p);
        }
        C0191x c0191x4 = this.f2770v;
        if (c0191x4 != null) {
            c0191x4.f2952j.removeOnMultiWindowModeChangedListener(this.f2766r);
        }
        C0191x c0191x5 = this.f2770v;
        if (c0191x5 != null) {
            c0191x5.f2952j.removeOnPictureInPictureModeChangedListener(this.f2767s);
        }
        C0191x c0191x6 = this.f2770v;
        if (c0191x6 != null && this.f2772x == null) {
            c0191x6.f2952j.removeMenuProvider(this.f2768t);
        }
        this.f2770v = null;
        this.f2771w = null;
        this.f2772x = null;
        if (this.f2756g != null) {
            G g4 = this.f2758i;
            ArrayList arrayList2 = g4.f2721a;
            CopyOnWriteArrayList copyOnWriteArrayList = g4.f2723c;
            Iterator it2 = copyOnWriteArrayList.iterator();
            T2.h.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                AutoCloseable autoCloseable = (AutoCloseable) it2.next();
                if (autoCloseable instanceof AutoCloseable) {
                    autoCloseable.close();
                } else if (autoCloseable instanceof ExecutorService) {
                    ExecutorService executorService = (ExecutorService) autoCloseable;
                    if (executorService != ForkJoinPool.commonPool() && !(isTerminated = executorService.isTerminated())) {
                        executorService.shutdown();
                        boolean z3 = false;
                        while (!isTerminated) {
                            try {
                                isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                            } catch (InterruptedException unused) {
                                if (!z3) {
                                    executorService.shutdownNow();
                                    z3 = true;
                                }
                            }
                        }
                        if (z3) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } else if (autoCloseable instanceof TypedArray) {
                    ((TypedArray) autoCloseable).recycle();
                } else if (autoCloseable instanceof MediaMetadataRetriever) {
                    ((MediaMetadataRetriever) autoCloseable).release();
                } else if (autoCloseable instanceof MediaDrm) {
                    ((MediaDrm) autoCloseable).release();
                } else {
                    throw new IllegalArgumentException();
                }
            }
            copyOnWriteArrayList.clear();
            int size2 = arrayList2.size();
            while (i4 < size2) {
                Object obj2 = arrayList2.get(i4);
                i4++;
                ((e.p) obj2).b();
            }
            arrayList2.clear();
            this.f2756g = null;
        }
        g.h hVar = this.f2736B;
        if (hVar != null) {
            hVar.f3750a.e(hVar.f3751b);
            g.h hVar2 = this.f2737C;
            hVar2.f3750a.e(hVar2.f3751b);
            g.h hVar3 = this.f2738D;
            hVar3.f3750a.e(hVar3.f3751b);
        }
    }

    public final void m(boolean z) {
        if (z && this.f2770v != null) {
            d0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null) {
                abstractComponentCallbacksC0187t.f2911I = true;
                if (z) {
                    abstractComponentCallbacksC0187t.z.m(true);
                }
            }
        }
    }

    public final void n(boolean z) {
        if (z && this.f2770v != null) {
            d0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null && z) {
                abstractComponentCallbacksC0187t.z.n(true);
            }
        }
    }

    public final void o() {
        ArrayList i4 = this.f2752c.i();
        int size = i4.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = i4.get(i5);
            i5++;
            AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = (AbstractComponentCallbacksC0187t) obj;
            if (abstractComponentCallbacksC0187t != null) {
                abstractComponentCallbacksC0187t.h();
                abstractComponentCallbacksC0187t.z.o();
            }
        }
    }

    public final boolean p() {
        boolean z;
        if (this.f2769u >= 1) {
            for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
                if (abstractComponentCallbacksC0187t != null) {
                    if (!abstractComponentCallbacksC0187t.f2907E) {
                        z = abstractComponentCallbacksC0187t.z.p();
                    } else {
                        z = false;
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void q() {
        if (this.f2769u >= 1) {
            for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
                if (abstractComponentCallbacksC0187t != null && !abstractComponentCallbacksC0187t.f2907E) {
                    abstractComponentCallbacksC0187t.z.q();
                }
            }
        }
    }

    public final void r(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (abstractComponentCallbacksC0187t != null) {
            if (abstractComponentCallbacksC0187t.equals(this.f2752c.e(abstractComponentCallbacksC0187t.f2928j))) {
                abstractComponentCallbacksC0187t.f2941x.getClass();
                boolean N3 = N(abstractComponentCallbacksC0187t);
                Boolean bool = abstractComponentCallbacksC0187t.f2932o;
                if (bool == null || bool.booleanValue() != N3) {
                    abstractComponentCallbacksC0187t.f2932o = Boolean.valueOf(N3);
                    Q q2 = abstractComponentCallbacksC0187t.z;
                    q2.e0();
                    q2.r(q2.f2773y);
                }
            }
        }
    }

    public final void s(boolean z) {
        if (z && this.f2770v != null) {
            d0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null && z) {
                abstractComponentCallbacksC0187t.z.s(true);
            }
        }
    }

    public final boolean t() {
        boolean z;
        if (this.f2769u < 1) {
            return false;
        }
        boolean z3 = false;
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : this.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null && M(abstractComponentCallbacksC0187t)) {
                if (!abstractComponentCallbacksC0187t.f2907E) {
                    z = abstractComponentCallbacksC0187t.z.t();
                } else {
                    z = false;
                }
                if (z) {
                    z3 = true;
                }
            }
        }
        return z3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = this.f2772x;
        if (abstractComponentCallbacksC0187t != null) {
            sb.append(abstractComponentCallbacksC0187t.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2772x)));
            sb.append("}");
        } else {
            C0191x c0191x = this.f2770v;
            if (c0191x != null) {
                sb.append(c0191x.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f2770v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(int i4) {
        try {
            this.f2751b = true;
            for (X x3 : ((HashMap) this.f2752c.f1470g).values()) {
                if (x3 != null) {
                    x3.f2806e = i4;
                }
            }
            O(i4, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((C0181m) it.next()).d();
            }
            this.f2751b = false;
            A(true);
        } catch (Throwable th) {
            this.f2751b = false;
            throw th;
        }
    }

    public final void v() {
        if (this.f2744J) {
            this.f2744J = false;
            c0();
        }
    }

    public final void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2;
        String a4 = r2.k.a(str, "    ");
        P1.y yVar = this.f2752c;
        ArrayList arrayList = (ArrayList) yVar.f1469f;
        String a5 = r2.k.a(str, "    ");
        HashMap hashMap = (HashMap) yVar.f1470g;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (X x3 : hashMap.values()) {
                printWriter.print(str);
                if (x3 != null) {
                    AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x3.f2804c;
                    printWriter.println(abstractComponentCallbacksC0187t);
                    abstractComponentCallbacksC0187t.getClass();
                    printWriter.print(a5);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(abstractComponentCallbacksC0187t.f2904B));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(abstractComponentCallbacksC0187t.f2905C));
                    printWriter.print(" mTag=");
                    printWriter.println(abstractComponentCallbacksC0187t.f2906D);
                    printWriter.print(a5);
                    printWriter.print("mState=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2924f);
                    printWriter.print(" mWho=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2928j);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(abstractComponentCallbacksC0187t.f2940w);
                    printWriter.print(a5);
                    printWriter.print("mAdded=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2933p);
                    printWriter.print(" mRemoving=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2934q);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2936s);
                    printWriter.print(" mInLayout=");
                    printWriter.println(abstractComponentCallbacksC0187t.f2937t);
                    printWriter.print(a5);
                    printWriter.print("mHidden=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2907E);
                    printWriter.print(" mDetached=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2908F);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2910H);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(a5);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(abstractComponentCallbacksC0187t.f2909G);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(abstractComponentCallbacksC0187t.f2914L);
                    if (abstractComponentCallbacksC0187t.f2941x != null) {
                        printWriter.print(a5);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2941x);
                    }
                    if (abstractComponentCallbacksC0187t.f2942y != null) {
                        printWriter.print(a5);
                        printWriter.print("mHost=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2942y);
                    }
                    if (abstractComponentCallbacksC0187t.f2903A != null) {
                        printWriter.print(a5);
                        printWriter.print("mParentFragment=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2903A);
                    }
                    if (abstractComponentCallbacksC0187t.k != null) {
                        printWriter.print(a5);
                        printWriter.print("mArguments=");
                        printWriter.println(abstractComponentCallbacksC0187t.k);
                    }
                    if (abstractComponentCallbacksC0187t.f2925g != null) {
                        printWriter.print(a5);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2925g);
                    }
                    if (abstractComponentCallbacksC0187t.f2926h != null) {
                        printWriter.print(a5);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2926h);
                    }
                    if (abstractComponentCallbacksC0187t.f2927i != null) {
                        printWriter.print(a5);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2927i);
                    }
                    Object obj = abstractComponentCallbacksC0187t.f2929l;
                    if (obj == null) {
                        P p3 = abstractComponentCallbacksC0187t.f2941x;
                        obj = (p3 == null || (str2 = abstractComponentCallbacksC0187t.f2930m) == null) ? null : p3.f2752c.e(str2);
                    }
                    if (obj != null) {
                        printWriter.print(a5);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2931n);
                    }
                    printWriter.print(a5);
                    printWriter.print("mPopDirection=");
                    C0186s c0186s = abstractComponentCallbacksC0187t.f2915M;
                    printWriter.println(c0186s == null ? false : c0186s.f2892a);
                    C0186s c0186s2 = abstractComponentCallbacksC0187t.f2915M;
                    if ((c0186s2 == null ? 0 : c0186s2.f2893b) != 0) {
                        printWriter.print(a5);
                        printWriter.print("getEnterAnim=");
                        C0186s c0186s3 = abstractComponentCallbacksC0187t.f2915M;
                        printWriter.println(c0186s3 == null ? 0 : c0186s3.f2893b);
                    }
                    C0186s c0186s4 = abstractComponentCallbacksC0187t.f2915M;
                    if ((c0186s4 == null ? 0 : c0186s4.f2894c) != 0) {
                        printWriter.print(a5);
                        printWriter.print("getExitAnim=");
                        C0186s c0186s5 = abstractComponentCallbacksC0187t.f2915M;
                        printWriter.println(c0186s5 == null ? 0 : c0186s5.f2894c);
                    }
                    C0186s c0186s6 = abstractComponentCallbacksC0187t.f2915M;
                    if ((c0186s6 == null ? 0 : c0186s6.f2895d) != 0) {
                        printWriter.print(a5);
                        printWriter.print("getPopEnterAnim=");
                        C0186s c0186s7 = abstractComponentCallbacksC0187t.f2915M;
                        printWriter.println(c0186s7 == null ? 0 : c0186s7.f2895d);
                    }
                    C0186s c0186s8 = abstractComponentCallbacksC0187t.f2915M;
                    if ((c0186s8 == null ? 0 : c0186s8.f2896e) != 0) {
                        printWriter.print(a5);
                        printWriter.print("getPopExitAnim=");
                        C0186s c0186s9 = abstractComponentCallbacksC0187t.f2915M;
                        printWriter.println(c0186s9 == null ? 0 : c0186s9.f2896e);
                    }
                    if (abstractComponentCallbacksC0187t.f2912J != null) {
                        printWriter.print(a5);
                        printWriter.print("mContainer=");
                        printWriter.println(abstractComponentCallbacksC0187t.f2912J);
                    }
                    C0191x c0191x = abstractComponentCallbacksC0187t.f2942y;
                    if ((c0191x == null ? null : c0191x.f2949g) != null) {
                        A2.t tVar = new A2.t(abstractComponentCallbacksC0187t.getViewModelStore(), b0.b.f3204e);
                        String canonicalName = b0.b.class.getCanonicalName();
                        if (canonicalName != null) {
                            C0662k c0662k = ((b0.b) tVar.F(b0.b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).f3205d;
                            if (c0662k.f6199h > 0) {
                                printWriter.print(a5);
                                printWriter.println("Loaders:");
                                if (c0662k.f6199h > 0) {
                                    if (c0662k.f6198g[0] == null) {
                                        printWriter.print(a5);
                                        printWriter.print("  #");
                                        printWriter.print(c0662k.f6197f[0]);
                                        printWriter.print(": ");
                                        throw null;
                                    }
                                    throw new ClassCastException();
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                        }
                    }
                    printWriter.print(a5);
                    printWriter.println("Child " + abstractComponentCallbacksC0187t.z + ":");
                    abstractComponentCallbacksC0187t.z.w(r2.k.a(a5, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i4 = 0; i4 < size2; i4++) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = (AbstractComponentCallbacksC0187t) arrayList.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0187t2.toString());
            }
        }
        ArrayList arrayList2 = this.f2754e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size; i5++) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t3 = (AbstractComponentCallbacksC0187t) this.f2754e.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0187t3.toString());
            }
        }
        int size3 = this.f2753d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size3; i6++) {
                C0169a c0169a = (C0169a) this.f2753d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(c0169a.toString());
                c0169a.f(a4, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2759j.get());
        synchronized (this.f2750a) {
            try {
                int size4 = this.f2750a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i7 = 0; i7 < size4; i7++) {
                        Object obj2 = (M) this.f2750a.get(i7);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i7);
                        printWriter.print(": ");
                        printWriter.println(obj2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2770v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2771w);
        if (this.f2772x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2772x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2769u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2741G);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2742H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f2743I);
        if (this.f2740F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2740F);
        }
    }

    public final void x() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((C0181m) it.next()).d();
        }
    }

    public final void y(M m3, boolean z) {
        if (!z) {
            if (this.f2770v == null) {
                if (this.f2743I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (this.f2741G || this.f2742H) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f2750a) {
            try {
                if (this.f2770v == null) {
                    if (z) {
                    } else {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f2750a.add(m3);
                    W();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(boolean z) {
        if (!this.f2751b) {
            if (this.f2770v == null) {
                if (this.f2743I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.f2770v.f2950h.getLooper()) {
                if (!z && (this.f2741G || this.f2742H)) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.f2745K == null) {
                    this.f2745K = new ArrayList();
                    this.f2746L = new ArrayList();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }
}
