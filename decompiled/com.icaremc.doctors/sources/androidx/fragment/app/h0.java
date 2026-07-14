package androidx.fragment.app;

import E.InterfaceC0010j;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.EnumC0145o;
import androidx.lifecycle.InterfaceC0150u;
import b0.C0163e;
import b0.InterfaceC0165g;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import f.AbstractC0193i;
import f.C0192h;
import f.InterfaceC0194j;
import io.flutter.embedding.android.FlutterFragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import u.C0313d;

/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: A, reason: collision with root package name */
    public final A0.f f1619A;

    /* renamed from: B, reason: collision with root package name */
    public C0192h f1620B;

    /* renamed from: C, reason: collision with root package name */
    public C0192h f1621C;

    /* renamed from: D, reason: collision with root package name */
    public C0192h f1622D;

    /* renamed from: E, reason: collision with root package name */
    public ArrayDeque f1623E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f1624F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f1625G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f1626H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f1627I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f1628J;

    /* renamed from: K, reason: collision with root package name */
    public ArrayList f1629K;
    public ArrayList L;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList f1630M;

    /* renamed from: N, reason: collision with root package name */
    public k0 f1631N;

    /* renamed from: O, reason: collision with root package name */
    public final RunnableC0122q f1632O;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1634b;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f1637e;

    /* renamed from: g, reason: collision with root package name */
    public d.t f1639g;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f1645m;

    /* renamed from: n, reason: collision with root package name */
    public final N f1646n;

    /* renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f1647o;
    public final W p;
    public final W q;

    /* renamed from: r, reason: collision with root package name */
    public final W f1648r;

    /* renamed from: s, reason: collision with root package name */
    public final W f1649s;

    /* renamed from: t, reason: collision with root package name */
    public final Z f1650t;

    /* renamed from: u, reason: collision with root package name */
    public int f1651u;

    /* renamed from: v, reason: collision with root package name */
    public T f1652v;

    /* renamed from: w, reason: collision with root package name */
    public P f1653w;

    /* renamed from: x, reason: collision with root package name */
    public H f1654x;
    public H y;
    public final C0100a0 z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1633a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final p0 f1635c = new p0();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f1636d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final V f1638f = new V(this);

    /* renamed from: h, reason: collision with root package name */
    public C0099a f1640h = null;

    /* renamed from: i, reason: collision with root package name */
    public final Y f1641i = new Y(this);

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f1642j = new AtomicInteger();

    /* renamed from: k, reason: collision with root package name */
    public final Map f1643k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    public final Map f1644l = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.W] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.W] */
    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.fragment.app.W] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.fragment.app.W] */
    public h0() {
        Collections.synchronizedMap(new HashMap());
        this.f1645m = new ArrayList();
        this.f1646n = new N(this);
        this.f1647o = new CopyOnWriteArrayList();
        final int i2 = 0;
        this.p = new D.a(this) { // from class: androidx.fragment.app.W

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f1574b;

            {
                this.f1574b = this;
            }

            @Override // D.a
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        h0 h0Var = this.f1574b;
                        if (h0Var.M()) {
                            h0Var.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        h0 h0Var2 = this.f1574b;
                        if (h0Var2.M() && num.intValue() == 80) {
                            h0Var2.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0313d c0313d = (C0313d) obj;
                        h0 h0Var3 = this.f1574b;
                        if (h0Var3.M()) {
                            h0Var3.n(c0313d.f3712a, false);
                            return;
                        }
                        return;
                    default:
                        u.L l2 = (u.L) obj;
                        h0 h0Var4 = this.f1574b;
                        if (h0Var4.M()) {
                            h0Var4.s(l2.f3706a, false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i3 = 1;
        this.q = new D.a(this) { // from class: androidx.fragment.app.W

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f1574b;

            {
                this.f1574b = this;
            }

            @Override // D.a
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        h0 h0Var = this.f1574b;
                        if (h0Var.M()) {
                            h0Var.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        h0 h0Var2 = this.f1574b;
                        if (h0Var2.M() && num.intValue() == 80) {
                            h0Var2.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0313d c0313d = (C0313d) obj;
                        h0 h0Var3 = this.f1574b;
                        if (h0Var3.M()) {
                            h0Var3.n(c0313d.f3712a, false);
                            return;
                        }
                        return;
                    default:
                        u.L l2 = (u.L) obj;
                        h0 h0Var4 = this.f1574b;
                        if (h0Var4.M()) {
                            h0Var4.s(l2.f3706a, false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i4 = 2;
        this.f1648r = new D.a(this) { // from class: androidx.fragment.app.W

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f1574b;

            {
                this.f1574b = this;
            }

            @Override // D.a
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        h0 h0Var = this.f1574b;
                        if (h0Var.M()) {
                            h0Var.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        h0 h0Var2 = this.f1574b;
                        if (h0Var2.M() && num.intValue() == 80) {
                            h0Var2.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0313d c0313d = (C0313d) obj;
                        h0 h0Var3 = this.f1574b;
                        if (h0Var3.M()) {
                            h0Var3.n(c0313d.f3712a, false);
                            return;
                        }
                        return;
                    default:
                        u.L l2 = (u.L) obj;
                        h0 h0Var4 = this.f1574b;
                        if (h0Var4.M()) {
                            h0Var4.s(l2.f3706a, false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i5 = 3;
        this.f1649s = new D.a(this) { // from class: androidx.fragment.app.W

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f1574b;

            {
                this.f1574b = this;
            }

            @Override // D.a
            public final void accept(Object obj) {
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        h0 h0Var = this.f1574b;
                        if (h0Var.M()) {
                            h0Var.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        h0 h0Var2 = this.f1574b;
                        if (h0Var2.M() && num.intValue() == 80) {
                            h0Var2.m(false);
                            return;
                        }
                        return;
                    case 2:
                        C0313d c0313d = (C0313d) obj;
                        h0 h0Var3 = this.f1574b;
                        if (h0Var3.M()) {
                            h0Var3.n(c0313d.f3712a, false);
                            return;
                        }
                        return;
                    default:
                        u.L l2 = (u.L) obj;
                        h0 h0Var4 = this.f1574b;
                        if (h0Var4.M()) {
                            h0Var4.s(l2.f3706a, false);
                            return;
                        }
                        return;
                }
            }
        };
        this.f1650t = new Z(this);
        this.f1651u = -1;
        this.z = new C0100a0(this);
        this.f1619A = new A0.f(17);
        this.f1623E = new ArrayDeque();
        this.f1632O = new RunnableC0122q(2, this);
    }

    public static HashSet F(C0099a c0099a) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < c0099a.f1735a.size(); i2++) {
            H h2 = ((q0) c0099a.f1735a.get(i2)).f1726b;
            if (h2 != null && c0099a.f1741g) {
                hashSet.add(h2);
            }
        }
        return hashSet;
    }

    public static boolean K(int i2) {
        if (Log.isLoggable("FragmentManager", i2)) {
            return true;
        }
        return false;
    }

    public static boolean L(H h2) {
        if (!h2.mHasMenu || !h2.mMenuVisible) {
            ArrayList e2 = h2.mChildFragmentManager.f1635c.e();
            int size = e2.size();
            boolean z = false;
            int i2 = 0;
            while (i2 < size) {
                Object obj = e2.get(i2);
                i2++;
                H h3 = (H) obj;
                if (h3 != null) {
                    z = L(h3);
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean N(H h2) {
        if (h2 != null) {
            h0 h0Var = h2.mFragmentManager;
            if (h2.equals(h0Var.y) && N(h0Var.f1654x)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void c0(H h2) {
        if (K(2)) {
            Log.v("FragmentManager", "show: " + h2);
        }
        if (h2.mHidden) {
            h2.mHidden = false;
            h2.mHiddenChanged = !h2.mHiddenChanged;
        }
    }

    public final void A(C0099a c0099a, boolean z) {
        if (z && (this.f1652v == null || this.f1627I)) {
            return;
        }
        y(z);
        c0099a.a(this.f1629K, this.L);
        this.f1634b = true;
        try {
            U(this.f1629K, this.L);
            d();
            e0();
            boolean z2 = this.f1628J;
            p0 p0Var = this.f1635c;
            if (z2) {
                this.f1628J = false;
                ArrayList d2 = p0Var.d();
                int size = d2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = d2.get(i2);
                    i2++;
                    o0 o0Var = (o0) obj;
                    H h2 = o0Var.f1711c;
                    if (h2.mDeferStart) {
                        if (this.f1634b) {
                            this.f1628J = true;
                        } else {
                            h2.mDeferStart = false;
                            o0Var.k();
                        }
                    }
                }
            }
            p0Var.f1720b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:135:0x022a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:162:0x02ef. Please report as an issue. */
    public final void B(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        boolean z2;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10 = i2;
        boolean z4 = ((C0099a) arrayList.get(i10)).f1749o;
        ArrayList arrayList3 = this.f1630M;
        if (arrayList3 == null) {
            this.f1630M = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.f1630M;
        p0 p0Var = this.f1635c;
        arrayList4.addAll(p0Var.f());
        H h2 = this.y;
        int i11 = i10;
        boolean z5 = false;
        while (true) {
            int i12 = 1;
            if (i11 < i3) {
                C0099a c0099a = (C0099a) arrayList.get(i11);
                if (!((Boolean) arrayList2.get(i11)).booleanValue()) {
                    ArrayList arrayList5 = this.f1630M;
                    ArrayList arrayList6 = c0099a.f1735a;
                    int i13 = 0;
                    while (i13 < arrayList6.size()) {
                        q0 q0Var = (q0) arrayList6.get(i13);
                        boolean z6 = z4;
                        int i14 = q0Var.f1725a;
                        if (i14 != i12) {
                            i6 = i11;
                            if (i14 != 2) {
                                if (i14 == 3 || i14 == 6) {
                                    arrayList5.remove(q0Var.f1726b);
                                    H h3 = q0Var.f1726b;
                                    if (h3 == h2) {
                                        arrayList6.add(i13, new q0(h3, 9));
                                        i13++;
                                        z3 = z5;
                                        h2 = null;
                                        i7 = 1;
                                    }
                                } else if (i14 == 7) {
                                    i7 = 1;
                                } else if (i14 == 8) {
                                    arrayList6.add(i13, new q0(h2, 9, 0));
                                    q0Var.f1727c = true;
                                    i13++;
                                    h2 = q0Var.f1726b;
                                }
                                z3 = z5;
                                i7 = 1;
                            } else {
                                H h4 = q0Var.f1726b;
                                int i15 = h4.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z7 = false;
                                while (size >= 0) {
                                    int i16 = size;
                                    H h5 = (H) arrayList5.get(size);
                                    boolean z8 = z5;
                                    if (h5.mContainerId != i15) {
                                        i8 = i15;
                                    } else if (h5 == h4) {
                                        i8 = i15;
                                        z7 = true;
                                    } else {
                                        if (h5 == h2) {
                                            i8 = i15;
                                            i9 = 0;
                                            arrayList6.add(i13, new q0(h5, 9, 0));
                                            i13++;
                                            h2 = null;
                                        } else {
                                            i8 = i15;
                                            i9 = 0;
                                        }
                                        q0 q0Var2 = new q0(h5, 3, i9);
                                        q0Var2.f1728d = q0Var.f1728d;
                                        q0Var2.f1730f = q0Var.f1730f;
                                        q0Var2.f1729e = q0Var.f1729e;
                                        q0Var2.f1731g = q0Var.f1731g;
                                        arrayList6.add(i13, q0Var2);
                                        arrayList5.remove(h5);
                                        i13++;
                                        h2 = h2;
                                    }
                                    size = i16 - 1;
                                    i15 = i8;
                                    z5 = z8;
                                }
                                z3 = z5;
                                i7 = 1;
                                if (z7) {
                                    arrayList6.remove(i13);
                                    i13--;
                                } else {
                                    q0Var.f1725a = 1;
                                    q0Var.f1727c = true;
                                    arrayList5.add(h4);
                                }
                            }
                            i13 += i7;
                            i12 = i7;
                            z4 = z6;
                            i11 = i6;
                            z5 = z3;
                        } else {
                            i6 = i11;
                            i7 = i12;
                        }
                        z3 = z5;
                        arrayList5.add(q0Var.f1726b);
                        i13 += i7;
                        i12 = i7;
                        z4 = z6;
                        i11 = i6;
                        z5 = z3;
                    }
                    z = z4;
                    i5 = i11;
                    z2 = z5;
                } else {
                    z = z4;
                    i5 = i11;
                    z2 = z5;
                    int i17 = 1;
                    ArrayList arrayList7 = this.f1630M;
                    ArrayList arrayList8 = c0099a.f1735a;
                    int size2 = arrayList8.size() - 1;
                    while (size2 >= 0) {
                        q0 q0Var3 = (q0) arrayList8.get(size2);
                        int i18 = q0Var3.f1725a;
                        if (i18 != i17) {
                            if (i18 != 3) {
                                switch (i18) {
                                    case 8:
                                        h2 = null;
                                        break;
                                    case 9:
                                        h2 = q0Var3.f1726b;
                                        break;
                                    case 10:
                                        q0Var3.f1733i = q0Var3.f1732h;
                                        break;
                                }
                                size2--;
                                i17 = 1;
                            }
                            arrayList7.add(q0Var3.f1726b);
                            size2--;
                            i17 = 1;
                        }
                        arrayList7.remove(q0Var3.f1726b);
                        size2--;
                        i17 = 1;
                    }
                }
                z5 = z2 || c0099a.f1741g;
                i11 = i5 + 1;
                z4 = z;
            } else {
                boolean z9 = z4;
                boolean z10 = z5;
                this.f1630M.clear();
                if (!z9 && this.f1651u >= 1) {
                    for (int i19 = i10; i19 < i3; i19++) {
                        ArrayList arrayList9 = ((C0099a) arrayList.get(i19)).f1735a;
                        int size3 = arrayList9.size();
                        int i20 = 0;
                        while (i20 < size3) {
                            Object obj = arrayList9.get(i20);
                            i20++;
                            H h6 = ((q0) obj).f1726b;
                            if (h6 != null && h6.mFragmentManager != null) {
                                p0Var.g(g(h6));
                            }
                        }
                    }
                }
                int i21 = i10;
                while (i21 < i3) {
                    C0099a c0099a2 = (C0099a) arrayList.get(i21);
                    if (((Boolean) arrayList2.get(i21)).booleanValue()) {
                        c0099a2.d(-1);
                        h0 h0Var = c0099a2.p;
                        ArrayList arrayList10 = c0099a2.f1735a;
                        boolean z11 = true;
                        for (int size4 = arrayList10.size() - 1; size4 >= 0; size4--) {
                            q0 q0Var4 = (q0) arrayList10.get(size4);
                            H h7 = q0Var4.f1726b;
                            if (h7 != null) {
                                h7.mBeingSaved = false;
                                h7.setPopDirection(z11);
                                int i22 = c0099a2.f1740f;
                                int i23 = 8194;
                                int i24 = 4097;
                                if (i22 != 4097) {
                                    if (i22 != 8194) {
                                        i23 = 4100;
                                        if (i22 != 8197) {
                                            i24 = 4099;
                                            if (i22 != 4099) {
                                                i23 = i22 != 4100 ? 0 : 8197;
                                            }
                                        }
                                    }
                                    i23 = i24;
                                }
                                h7.setNextTransition(i23);
                                h7.setSharedElementNames(c0099a2.f1748n, c0099a2.f1747m);
                            }
                            switch (q0Var4.f1725a) {
                                case 1:
                                    h7.setAnimations(q0Var4.f1728d, q0Var4.f1729e, q0Var4.f1730f, q0Var4.f1731g);
                                    z11 = true;
                                    h0Var.Y(h7, true);
                                    h0Var.T(h7);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + q0Var4.f1725a);
                                case 3:
                                    h7.setAnimations(q0Var4.f1728d, q0Var4.f1729e, q0Var4.f1730f, q0Var4.f1731g);
                                    h0Var.a(h7);
                                    z11 = true;
                                case 4:
                                    h7.setAnimations(q0Var4.f1728d, q0Var4.f1729e, q0Var4.f1730f, q0Var4.f1731g);
                                    h0Var.getClass();
                                    c0(h7);
                                    z11 = true;
                                case 5:
                                    h7.setAnimations(q0Var4.f1728d, q0Var4.f1729e, q0Var4.f1730f, q0Var4.f1731g);
                                    h0Var.Y(h7, true);
                                    h0Var.J(h7);
                                    z11 = true;
                                case 6:
                                    h7.setAnimations(q0Var4.f1728d, q0Var4.f1729e, q0Var4.f1730f, q0Var4.f1731g);
                                    h0Var.c(h7);
                                    z11 = true;
                                case 7:
                                    h7.setAnimations(q0Var4.f1728d, q0Var4.f1729e, q0Var4.f1730f, q0Var4.f1731g);
                                    h0Var.Y(h7, true);
                                    h0Var.h(h7);
                                    z11 = true;
                                case 8:
                                    h0Var.a0(null);
                                    z11 = true;
                                case 9:
                                    h0Var.a0(h7);
                                    z11 = true;
                                case 10:
                                    h0Var.Z(h7, q0Var4.f1732h);
                                    z11 = true;
                            }
                        }
                    } else {
                        c0099a2.d(1);
                        h0 h0Var2 = c0099a2.p;
                        ArrayList arrayList11 = c0099a2.f1735a;
                        int size5 = arrayList11.size();
                        int i25 = 0;
                        while (i25 < size5) {
                            q0 q0Var5 = (q0) arrayList11.get(i25);
                            H h8 = q0Var5.f1726b;
                            if (h8 != null) {
                                h8.mBeingSaved = false;
                                h8.setPopDirection(false);
                                h8.setNextTransition(c0099a2.f1740f);
                                h8.setSharedElementNames(c0099a2.f1747m, c0099a2.f1748n);
                            }
                            switch (q0Var5.f1725a) {
                                case 1:
                                    i4 = i21;
                                    h8.setAnimations(q0Var5.f1728d, q0Var5.f1729e, q0Var5.f1730f, q0Var5.f1731g);
                                    h0Var2.Y(h8, false);
                                    h0Var2.a(h8);
                                    i25++;
                                    i21 = i4;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + q0Var5.f1725a);
                                case 3:
                                    i4 = i21;
                                    h8.setAnimations(q0Var5.f1728d, q0Var5.f1729e, q0Var5.f1730f, q0Var5.f1731g);
                                    h0Var2.T(h8);
                                    i25++;
                                    i21 = i4;
                                case 4:
                                    i4 = i21;
                                    h8.setAnimations(q0Var5.f1728d, q0Var5.f1729e, q0Var5.f1730f, q0Var5.f1731g);
                                    h0Var2.J(h8);
                                    i25++;
                                    i21 = i4;
                                case 5:
                                    i4 = i21;
                                    h8.setAnimations(q0Var5.f1728d, q0Var5.f1729e, q0Var5.f1730f, q0Var5.f1731g);
                                    h0Var2.Y(h8, false);
                                    c0(h8);
                                    i25++;
                                    i21 = i4;
                                case 6:
                                    i4 = i21;
                                    h8.setAnimations(q0Var5.f1728d, q0Var5.f1729e, q0Var5.f1730f, q0Var5.f1731g);
                                    h0Var2.h(h8);
                                    i25++;
                                    i21 = i4;
                                case 7:
                                    i4 = i21;
                                    h8.setAnimations(q0Var5.f1728d, q0Var5.f1729e, q0Var5.f1730f, q0Var5.f1731g);
                                    h0Var2.Y(h8, false);
                                    h0Var2.c(h8);
                                    i25++;
                                    i21 = i4;
                                case 8:
                                    h0Var2.a0(h8);
                                    i4 = i21;
                                    i25++;
                                    i21 = i4;
                                case 9:
                                    h0Var2.a0(null);
                                    i4 = i21;
                                    i25++;
                                    i21 = i4;
                                case 10:
                                    h0Var2.Z(h8, q0Var5.f1733i);
                                    i4 = i21;
                                    i25++;
                                    i21 = i4;
                            }
                        }
                    }
                    i21++;
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
                ArrayList arrayList12 = this.f1645m;
                if (z10 && !arrayList12.isEmpty()) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int size6 = arrayList.size();
                    int i26 = 0;
                    while (i26 < size6) {
                        Object obj2 = arrayList.get(i26);
                        i26++;
                        linkedHashSet.addAll(F((C0099a) obj2));
                    }
                    if (this.f1640h == null) {
                        int size7 = arrayList12.size();
                        int i27 = 0;
                        while (i27 < size7) {
                            Object obj3 = arrayList12.get(i27);
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
                        int size8 = arrayList12.size();
                        int i28 = 0;
                        while (i28 < size8) {
                            Object obj4 = arrayList12.get(i28);
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
                for (int i29 = i10; i29 < i3; i29++) {
                    C0099a c0099a3 = (C0099a) arrayList.get(i29);
                    if (booleanValue) {
                        for (int size9 = c0099a3.f1735a.size() - 1; size9 >= 0; size9--) {
                            H h9 = ((q0) c0099a3.f1735a.get(size9)).f1726b;
                            if (h9 != null) {
                                g(h9).k();
                            }
                        }
                    } else {
                        ArrayList arrayList13 = c0099a3.f1735a;
                        int size10 = arrayList13.size();
                        int i30 = 0;
                        while (i30 < size10) {
                            Object obj5 = arrayList13.get(i30);
                            i30++;
                            H h10 = ((q0) obj5).f1726b;
                            if (h10 != null) {
                                g(h10).k();
                            }
                        }
                    }
                }
                O(this.f1651u, true);
                Iterator it3 = f(arrayList, i10, i3).iterator();
                while (it3.hasNext()) {
                    C0121p c0121p = (C0121p) it3.next();
                    c0121p.f1717d = booleanValue;
                    c0121p.k();
                    c0121p.e();
                }
                while (i10 < i3) {
                    C0099a c0099a4 = (C0099a) arrayList.get(i10);
                    if (((Boolean) arrayList2.get(i10)).booleanValue() && c0099a4.f1579r >= 0) {
                        c0099a4.f1579r = -1;
                    }
                    c0099a4.getClass();
                    i10++;
                }
                if (!z10 || arrayList12.size() <= 0) {
                    return;
                }
                arrayList12.get(0).getClass();
                throw new ClassCastException();
            }
        }
    }

    public final H C(int i2) {
        p0 p0Var = this.f1635c;
        ArrayList arrayList = p0Var.f1719a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            H h2 = (H) arrayList.get(size);
            if (h2 != null && h2.mFragmentId == i2) {
                return h2;
            }
        }
        for (o0 o0Var : p0Var.f1720b.values()) {
            if (o0Var != null) {
                H h3 = o0Var.f1711c;
                if (h3.mFragmentId == i2) {
                    return h3;
                }
            }
        }
        return null;
    }

    public final H D(String str) {
        p0 p0Var = this.f1635c;
        ArrayList arrayList = p0Var.f1719a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            H h2 = (H) arrayList.get(size);
            if (h2 != null && str.equals(h2.mTag)) {
                return h2;
            }
        }
        for (o0 o0Var : p0Var.f1720b.values()) {
            if (o0Var != null) {
                H h3 = o0Var.f1711c;
                if (str.equals(h3.mTag)) {
                    return h3;
                }
            }
        }
        return null;
    }

    public final void E() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            C0121p c0121p = (C0121p) it.next();
            if (c0121p.f1718e) {
                if (K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                c0121p.f1718e = false;
                c0121p.e();
            }
        }
    }

    public final ViewGroup G(H h2) {
        ViewGroup viewGroup = h2.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (h2.mContainerId > 0 && this.f1653w.c()) {
            View b2 = this.f1653w.b(h2.mContainerId);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
            return null;
        }
        return null;
    }

    public final C0100a0 H() {
        H h2 = this.f1654x;
        if (h2 != null) {
            return h2.mFragmentManager.H();
        }
        return this.z;
    }

    public final A0.f I() {
        H h2 = this.f1654x;
        if (h2 != null) {
            return h2.mFragmentManager.I();
        }
        return this.f1619A;
    }

    public final void J(H h2) {
        if (K(2)) {
            Log.v("FragmentManager", "hide: " + h2);
        }
        if (!h2.mHidden) {
            h2.mHidden = true;
            h2.mHiddenChanged = true ^ h2.mHiddenChanged;
            b0(h2);
        }
    }

    public final boolean M() {
        H h2 = this.f1654x;
        if (h2 == null) {
            return true;
        }
        if (h2.isAdded() && this.f1654x.getParentFragmentManager().M()) {
            return true;
        }
        return false;
    }

    public final void O(int i2, boolean z) {
        T t2;
        if (this.f1652v == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.f1651u) {
            this.f1651u = i2;
            p0 p0Var = this.f1635c;
            HashMap hashMap = p0Var.f1720b;
            ArrayList arrayList = p0Var.f1719a;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                o0 o0Var = (o0) hashMap.get(((H) obj).mWho);
                if (o0Var != null) {
                    o0Var.k();
                }
            }
            for (o0 o0Var2 : hashMap.values()) {
                if (o0Var2 != null) {
                    o0Var2.k();
                    H h2 = o0Var2.f1711c;
                    if (h2.mRemoving && !h2.isInBackStack()) {
                        if (h2.mBeingSaved && !p0Var.f1721c.containsKey(h2.mWho)) {
                            p0Var.i(o0Var2.n(), h2.mWho);
                        }
                        p0Var.h(o0Var2);
                    }
                }
            }
            ArrayList d2 = p0Var.d();
            int size2 = d2.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = d2.get(i4);
                i4++;
                o0 o0Var3 = (o0) obj2;
                H h3 = o0Var3.f1711c;
                if (h3.mDeferStart) {
                    if (this.f1634b) {
                        this.f1628J = true;
                    } else {
                        h3.mDeferStart = false;
                        o0Var3.k();
                    }
                }
            }
            if (this.f1624F && (t2 = this.f1652v) != null && this.f1651u == 7) {
                ((L) t2).f1553g.invalidateMenu();
                this.f1624F = false;
            }
        }
    }

    public final void P() {
        if (this.f1652v != null) {
            this.f1625G = false;
            this.f1626H = false;
            this.f1631N.f1672i = false;
            for (H h2 : this.f1635c.f()) {
                if (h2 != null) {
                    h2.noteStateNotSaved();
                }
            }
        }
    }

    public final boolean Q() {
        return R(-1, 0);
    }

    public final boolean R(int i2, int i3) {
        z(false);
        y(true);
        H h2 = this.y;
        if (h2 != null && i2 < 0 && h2.getChildFragmentManager().Q()) {
            return true;
        }
        boolean S2 = S(this.f1629K, this.L, i2, i3);
        if (S2) {
            this.f1634b = true;
            try {
                U(this.f1629K, this.L);
            } finally {
                d();
            }
        }
        e0();
        boolean z = this.f1628J;
        p0 p0Var = this.f1635c;
        if (z) {
            this.f1628J = false;
            ArrayList d2 = p0Var.d();
            int size = d2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = d2.get(i4);
                i4++;
                o0 o0Var = (o0) obj;
                H h3 = o0Var.f1711c;
                if (h3.mDeferStart) {
                    if (this.f1634b) {
                        this.f1628J = true;
                    } else {
                        h3.mDeferStart = false;
                        o0Var.k();
                    }
                }
            }
        }
        p0Var.f1720b.values().removeAll(Collections.singleton(null));
        return S2;
    }

    public final boolean S(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        boolean z;
        if ((i3 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        int i4 = -1;
        if (!this.f1636d.isEmpty()) {
            if (i2 < 0) {
                i4 = z ? 0 : this.f1636d.size() - 1;
            } else {
                int size = this.f1636d.size() - 1;
                while (size >= 0) {
                    C0099a c0099a = (C0099a) this.f1636d.get(size);
                    if (i2 >= 0 && i2 == c0099a.f1579r) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    i4 = size;
                } else if (z) {
                    i4 = size;
                    while (i4 > 0) {
                        C0099a c0099a2 = (C0099a) this.f1636d.get(i4 - 1);
                        if (i2 < 0 || i2 != c0099a2.f1579r) {
                            break;
                        }
                        i4--;
                    }
                } else if (size != this.f1636d.size() - 1) {
                    i4 = size + 1;
                }
            }
        }
        if (i4 < 0) {
            return false;
        }
        for (int size2 = this.f1636d.size() - 1; size2 >= i4; size2--) {
            arrayList.add((C0099a) this.f1636d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void T(H h2) {
        if (K(2)) {
            Log.v("FragmentManager", "remove: " + h2 + " nesting=" + h2.mBackStackNesting);
        }
        boolean isInBackStack = h2.isInBackStack();
        if (h2.mDetached && isInBackStack) {
            return;
        }
        p0 p0Var = this.f1635c;
        synchronized (p0Var.f1719a) {
            p0Var.f1719a.remove(h2);
        }
        h2.mAdded = false;
        if (L(h2)) {
            this.f1624F = true;
        }
        h2.mRemoving = true;
        b0(h2);
    }

    public final void U(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!((C0099a) arrayList.get(i2)).f1749o) {
                        if (i3 != i2) {
                            B(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                            while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C0099a) arrayList.get(i3)).f1749o) {
                                i3++;
                            }
                        }
                        B(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    B(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [androidx.fragment.app.q0, java.lang.Object] */
    public final void V(Bundle bundle) {
        N n2;
        int i2;
        boolean z;
        int i3;
        Bundle bundle2;
        o0 o0Var;
        Bundle bundle3;
        Bundle bundle4;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle4 = bundle.getBundle(str)) != null) {
                bundle4.setClassLoader(this.f1652v.f1567d.getClassLoader());
                this.f1644l.put(str.substring(7), bundle4);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle3 = bundle.getBundle(str2)) != null) {
                bundle3.setClassLoader(this.f1652v.f1567d.getClassLoader());
                hashMap.put(str2.substring(9), bundle3);
            }
        }
        p0 p0Var = this.f1635c;
        HashMap hashMap2 = p0Var.f1721c;
        HashMap hashMap3 = p0Var.f1720b;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        j0 j0Var = (j0) bundle.getParcelable("state");
        if (j0Var == null) {
            return;
        }
        hashMap3.clear();
        ArrayList arrayList = j0Var.f1657c;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            n2 = this.f1646n;
            if (i4 >= size) {
                break;
            }
            Object obj = arrayList.get(i4);
            i4++;
            Bundle i5 = p0Var.i(null, (String) obj);
            if (i5 != null) {
                H h2 = (H) this.f1631N.f1667d.get(((m0) i5.getParcelable("state")).f1680d);
                if (h2 != null) {
                    if (K(2)) {
                        i3 = 2;
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + h2);
                    } else {
                        i3 = 2;
                    }
                    o0Var = new o0(n2, p0Var, h2, i5);
                    bundle2 = i5;
                } else {
                    i3 = 2;
                    bundle2 = i5;
                    o0Var = new o0(this.f1646n, this.f1635c, this.f1652v.f1567d.getClassLoader(), H(), i5);
                }
                H h3 = o0Var.f1711c;
                h3.mSavedFragmentState = bundle2;
                h3.mFragmentManager = this;
                if (K(i3)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + h3.mWho + "): " + h3);
                }
                o0Var.l(this.f1652v.f1567d.getClassLoader());
                p0Var.g(o0Var);
                o0Var.f1713e = this.f1651u;
            }
        }
        k0 k0Var = this.f1631N;
        k0Var.getClass();
        ArrayList arrayList2 = new ArrayList(k0Var.f1667d.values());
        int size2 = arrayList2.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj2 = arrayList2.get(i6);
            i6++;
            H h4 = (H) obj2;
            if (hashMap3.get(h4.mWho) == null) {
                if (K(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + h4 + " that was not found in the set of active Fragments " + j0Var.f1657c);
                }
                this.f1631N.g(h4);
                h4.mFragmentManager = this;
                o0 o0Var2 = new o0(n2, p0Var, h4);
                o0Var2.f1713e = 1;
                o0Var2.k();
                h4.mRemoving = true;
                o0Var2.k();
            }
        }
        ArrayList arrayList3 = j0Var.f1658d;
        p0Var.f1719a.clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i7 = 0;
            while (i7 < size3) {
                Object obj3 = arrayList3.get(i7);
                i7++;
                String str3 = (String) obj3;
                H b2 = p0Var.b(str3);
                if (b2 != null) {
                    if (K(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + b2);
                    }
                    p0Var.a(b2);
                } else {
                    throw new IllegalStateException(O.a.g("No instantiated fragment for (", str3, ")"));
                }
            }
        }
        if (j0Var.f1659e != null) {
            this.f1636d = new ArrayList(j0Var.f1659e.length);
            int i8 = 0;
            while (true) {
                C0101b[] c0101bArr = j0Var.f1659e;
                if (i8 >= c0101bArr.length) {
                    break;
                }
                C0101b c0101b = c0101bArr[i8];
                ArrayList arrayList4 = c0101b.f1583d;
                C0099a c0099a = new C0099a(this);
                int[] iArr = c0101b.f1582c;
                int i9 = 0;
                int i10 = 0;
                while (i9 < iArr.length) {
                    ?? obj4 = new Object();
                    int i11 = i9 + 1;
                    obj4.f1725a = iArr[i9];
                    if (K(2)) {
                        Log.v("FragmentManager", "Instantiate " + c0099a + " op #" + i10 + " base fragment #" + iArr[i11]);
                    }
                    obj4.f1732h = EnumC0145o.values()[c0101b.f1584e[i10]];
                    obj4.f1733i = EnumC0145o.values()[c0101b.f1585f[i10]];
                    int i12 = i9 + 2;
                    if (iArr[i11] != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    obj4.f1727c = z;
                    int i13 = iArr[i12];
                    obj4.f1728d = i13;
                    int i14 = iArr[i9 + 3];
                    obj4.f1729e = i14;
                    int i15 = i9 + 5;
                    int i16 = iArr[i9 + 4];
                    obj4.f1730f = i16;
                    i9 += 6;
                    int[] iArr2 = iArr;
                    int i17 = iArr2[i15];
                    obj4.f1731g = i17;
                    c0099a.f1736b = i13;
                    c0099a.f1737c = i14;
                    c0099a.f1738d = i16;
                    c0099a.f1739e = i17;
                    c0099a.b(obj4);
                    i10++;
                    iArr = iArr2;
                }
                c0099a.f1740f = c0101b.f1586g;
                c0099a.f1742h = c0101b.f1587h;
                c0099a.f1741g = true;
                c0099a.f1743i = c0101b.f1589j;
                c0099a.f1744j = c0101b.f1590k;
                c0099a.f1745k = c0101b.f1591l;
                c0099a.f1746l = c0101b.f1592m;
                c0099a.f1747m = c0101b.f1593n;
                c0099a.f1748n = c0101b.f1594o;
                c0099a.f1749o = c0101b.p;
                c0099a.f1579r = c0101b.f1588i;
                for (int i18 = 0; i18 < arrayList4.size(); i18++) {
                    String str4 = (String) arrayList4.get(i18);
                    if (str4 != null) {
                        ((q0) c0099a.f1735a.get(i18)).f1726b = p0Var.b(str4);
                    }
                }
                c0099a.d(1);
                if (K(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + c0099a.f1579r + "): " + c0099a);
                    PrintWriter printWriter = new PrintWriter(new B0());
                    c0099a.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1636d.add(c0099a);
                i8++;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.f1636d = new ArrayList();
        }
        this.f1642j.set(j0Var.f1660f);
        String str5 = j0Var.f1661g;
        if (str5 != null) {
            H b3 = p0Var.b(str5);
            this.y = b3;
            r(b3);
        }
        ArrayList arrayList5 = j0Var.f1662h;
        if (arrayList5 != null) {
            for (int i19 = i2; i19 < arrayList5.size(); i19++) {
                this.f1643k.put((String) arrayList5.get(i19), (C0103c) j0Var.f1663i.get(i19));
            }
        }
        this.f1623E = new ArrayDeque(j0Var.f1664j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.fragment.app.j0, android.os.Parcelable, java.lang.Object] */
    public final Bundle W() {
        int i2;
        ArrayList arrayList;
        C0101b[] c0101bArr;
        Bundle bundle = new Bundle();
        E();
        w();
        z(true);
        this.f1625G = true;
        this.f1631N.f1672i = true;
        p0 p0Var = this.f1635c;
        p0Var.getClass();
        HashMap hashMap = p0Var.f1720b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (o0 o0Var : hashMap.values()) {
            if (o0Var != null) {
                H h2 = o0Var.f1711c;
                p0Var.i(o0Var.n(), h2.mWho);
                arrayList2.add(h2.mWho);
                if (K(2)) {
                    Log.v("FragmentManager", "Saved state of " + h2 + ": " + h2.mSavedFragmentState);
                }
            }
        }
        HashMap hashMap2 = this.f1635c.f1721c;
        if (hashMap2.isEmpty()) {
            if (K(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return bundle;
            }
        } else {
            p0 p0Var2 = this.f1635c;
            synchronized (p0Var2.f1719a) {
                try {
                    if (p0Var2.f1719a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(p0Var2.f1719a.size());
                        ArrayList arrayList3 = p0Var2.f1719a;
                        int size = arrayList3.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = arrayList3.get(i3);
                            i3++;
                            H h3 = (H) obj;
                            arrayList.add(h3.mWho);
                            if (K(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + h3.mWho + "): " + h3);
                            }
                        }
                    }
                } finally {
                }
            }
            int size2 = this.f1636d.size();
            if (size2 > 0) {
                c0101bArr = new C0101b[size2];
                for (i2 = 0; i2 < size2; i2++) {
                    c0101bArr[i2] = new C0101b((C0099a) this.f1636d.get(i2));
                    if (K(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1636d.get(i2));
                    }
                }
            } else {
                c0101bArr = null;
            }
            ?? obj2 = new Object();
            obj2.f1661g = null;
            ArrayList arrayList4 = new ArrayList();
            obj2.f1662h = arrayList4;
            ArrayList arrayList5 = new ArrayList();
            obj2.f1663i = arrayList5;
            obj2.f1657c = arrayList2;
            obj2.f1658d = arrayList;
            obj2.f1659e = c0101bArr;
            obj2.f1660f = this.f1642j.get();
            H h4 = this.y;
            if (h4 != null) {
                obj2.f1661g = h4.mWho;
            }
            arrayList4.addAll(this.f1643k.keySet());
            arrayList5.addAll(this.f1643k.values());
            obj2.f1664j = new ArrayList(this.f1623E);
            bundle.putParcelable("state", obj2);
            for (String str : this.f1644l.keySet()) {
                bundle.putBundle(O.a.m("result_", str), (Bundle) this.f1644l.get(str));
            }
            for (String str2 : hashMap2.keySet()) {
                bundle.putBundle(O.a.m("fragment_", str2), (Bundle) hashMap2.get(str2));
            }
        }
        return bundle;
    }

    public final void X() {
        synchronized (this.f1633a) {
            try {
                if (this.f1633a.size() == 1) {
                    this.f1652v.f1568e.removeCallbacks(this.f1632O);
                    this.f1652v.f1568e.post(this.f1632O);
                    e0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Y(H h2, boolean z) {
        ViewGroup G2 = G(h2);
        if (G2 != null && (G2 instanceof Q)) {
            ((Q) G2).setDrawDisappearingViewsLast(!z);
        }
    }

    public final void Z(H h2, EnumC0145o enumC0145o) {
        if (h2.equals(this.f1635c.b(h2.mWho)) && (h2.mHost == null || h2.mFragmentManager == this)) {
            h2.mMaxState = enumC0145o;
            return;
        }
        throw new IllegalArgumentException("Fragment " + h2 + " is not an active fragment of FragmentManager " + this);
    }

    public final o0 a(H h2) {
        String str = h2.mPreviousWho;
        if (str != null) {
            R.d.c(h2, str);
        }
        if (K(2)) {
            Log.v("FragmentManager", "add: " + h2);
        }
        o0 g2 = g(h2);
        h2.mFragmentManager = this;
        p0 p0Var = this.f1635c;
        p0Var.g(g2);
        if (!h2.mDetached) {
            p0Var.a(h2);
            h2.mRemoving = false;
            if (h2.mView == null) {
                h2.mHiddenChanged = false;
            }
            if (L(h2)) {
                this.f1624F = true;
            }
        }
        return g2;
    }

    public final void a0(H h2) {
        if (h2 != null) {
            if (!h2.equals(this.f1635c.b(h2.mWho)) || (h2.mHost != null && h2.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + h2 + " is not an active fragment of FragmentManager " + this);
            }
        }
        H h3 = this.y;
        this.y = h2;
        r(h3);
        r(this.y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(T t2, P p, H h2) {
        String str;
        if (this.f1652v == null) {
            this.f1652v = t2;
            this.f1653w = p;
            this.f1654x = h2;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f1647o;
            if (h2 != null) {
                copyOnWriteArrayList.add(new C0102b0(h2));
            } else if (t2 instanceof l0) {
                copyOnWriteArrayList.add((l0) t2);
            }
            if (this.f1654x != null) {
                e0();
            }
            if (t2 instanceof d.u) {
                d.u uVar = (d.u) t2;
                d.t onBackPressedDispatcher = uVar.getOnBackPressedDispatcher();
                this.f1639g = onBackPressedDispatcher;
                InterfaceC0150u interfaceC0150u = uVar;
                if (h2 != null) {
                    interfaceC0150u = h2;
                }
                onBackPressedDispatcher.a(interfaceC0150u, this.f1641i);
            }
            boolean z = false;
            if (h2 != null) {
                k0 k0Var = h2.mFragmentManager.f1631N;
                HashMap hashMap = k0Var.f1668e;
                k0 k0Var2 = (k0) hashMap.get(h2.mWho);
                if (k0Var2 == null) {
                    k0Var2 = new k0(k0Var.f1670g);
                    hashMap.put(h2.mWho, k0Var2);
                }
                this.f1631N = k0Var2;
            } else if (t2 instanceof androidx.lifecycle.d0) {
                A0.g gVar = new A0.g(((androidx.lifecycle.d0) t2).getViewModelStore(), k0.f1666j);
                String canonicalName = k0.class.getCanonicalName();
                if (canonicalName != null) {
                    this.f1631N = (k0) gVar.c(k0.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.f1631N = new k0(false);
            }
            k0 k0Var3 = this.f1631N;
            if (this.f1625G || this.f1626H) {
                z = true;
            }
            k0Var3.f1672i = z;
            this.f1635c.f1722d = k0Var3;
            Object obj = this.f1652v;
            if ((obj instanceof InterfaceC0165g) && h2 == null) {
                C0163e savedStateRegistry = ((InterfaceC0165g) obj).getSavedStateRegistry();
                savedStateRegistry.c("android:support:fragments", new I(1, this));
                Bundle a2 = savedStateRegistry.a("android:support:fragments");
                if (a2 != null) {
                    V(a2);
                }
            }
            Object obj2 = this.f1652v;
            if (obj2 instanceof InterfaceC0194j) {
                AbstractC0193i activityResultRegistry = ((InterfaceC0194j) obj2).getActivityResultRegistry();
                if (h2 != null) {
                    str = O.a.i(new StringBuilder(), h2.mWho, ":");
                } else {
                    str = BuildConfig.FLAVOR;
                }
                String m2 = O.a.m("FragmentManager:", str);
                this.f1620B = activityResultRegistry.d(O.a.f(m2, "StartActivityForResult"), new C0104c0(3), new X(this, 1));
                this.f1621C = activityResultRegistry.d(O.a.f(m2, "StartIntentSenderForResult"), new C0104c0(0), new X(this, 2));
                this.f1622D = activityResultRegistry.d(O.a.f(m2, "RequestPermissions"), new C0104c0(2), new X(this, 0));
            }
            Object obj3 = this.f1652v;
            if (obj3 instanceof v.d) {
                ((v.d) obj3).addOnConfigurationChangedListener(this.p);
            }
            Object obj4 = this.f1652v;
            if (obj4 instanceof v.e) {
                ((v.e) obj4).addOnTrimMemoryListener(this.q);
            }
            Object obj5 = this.f1652v;
            if (obj5 instanceof u.I) {
                ((u.I) obj5).addOnMultiWindowModeChangedListener(this.f1648r);
            }
            Object obj6 = this.f1652v;
            if (obj6 instanceof u.J) {
                ((u.J) obj6).addOnPictureInPictureModeChangedListener(this.f1649s);
            }
            Object obj7 = this.f1652v;
            if ((obj7 instanceof InterfaceC0010j) && h2 == null) {
                ((InterfaceC0010j) obj7).addMenuProvider(this.f1650t);
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void b0(H h2) {
        ViewGroup G2 = G(h2);
        if (G2 != null) {
            if (h2.getPopExitAnim() + h2.getPopEnterAnim() + h2.getExitAnim() + h2.getEnterAnim() > 0) {
                if (G2.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    G2.setTag(R.id.visible_removing_fragment_view_tag, h2);
                }
                ((H) G2.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(h2.getPopDirection());
            }
        }
    }

    public final void c(H h2) {
        if (K(2)) {
            Log.v("FragmentManager", "attach: " + h2);
        }
        if (h2.mDetached) {
            h2.mDetached = false;
            if (!h2.mAdded) {
                this.f1635c.a(h2);
                if (K(2)) {
                    Log.v("FragmentManager", "add from attach: " + h2);
                }
                if (L(h2)) {
                    this.f1624F = true;
                }
            }
        }
    }

    public final void d() {
        this.f1634b = false;
        this.L.clear();
        this.f1629K.clear();
    }

    public final void d0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new B0());
        T t2 = this.f1652v;
        if (t2 != null) {
            try {
                ((L) t2).f1553g.dump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw illegalStateException;
            }
        }
        try {
            v("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw illegalStateException;
        }
    }

    public final HashSet e() {
        C0121p c0121p;
        HashSet hashSet = new HashSet();
        ArrayList d2 = this.f1635c.d();
        int size = d2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = d2.get(i2);
            i2++;
            ViewGroup viewGroup = ((o0) obj).f1711c.mContainer;
            if (viewGroup != null) {
                A0.f factory = I();
                kotlin.jvm.internal.h.e(factory, "factory");
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof C0121p) {
                    c0121p = (C0121p) tag;
                } else {
                    c0121p = new C0121p(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, c0121p);
                }
                hashSet.add(c0121p);
            }
        }
        return hashSet;
    }

    public final void e0() {
        int i2;
        synchronized (this.f1633a) {
            try {
                boolean z = true;
                if (!this.f1633a.isEmpty()) {
                    this.f1641i.setEnabled(true);
                    if (K(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                int size = this.f1636d.size();
                if (this.f1640h != null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (size + i2 <= 0 || !N(this.f1654x)) {
                    z = false;
                }
                if (K(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.f1641i.setEnabled(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet f(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            ArrayList arrayList2 = ((C0099a) arrayList.get(i2)).f1735a;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                H h2 = ((q0) obj).f1726b;
                if (h2 != null && (viewGroup = h2.mContainer) != null) {
                    hashSet.add(C0121p.j(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public final o0 g(H h2) {
        String str = h2.mWho;
        p0 p0Var = this.f1635c;
        o0 o0Var = (o0) p0Var.f1720b.get(str);
        if (o0Var != null) {
            return o0Var;
        }
        o0 o0Var2 = new o0(this.f1646n, p0Var, h2);
        o0Var2.l(this.f1652v.f1567d.getClassLoader());
        o0Var2.f1713e = this.f1651u;
        return o0Var2;
    }

    public final void h(H h2) {
        if (K(2)) {
            Log.v("FragmentManager", "detach: " + h2);
        }
        if (!h2.mDetached) {
            h2.mDetached = true;
            if (h2.mAdded) {
                if (K(2)) {
                    Log.v("FragmentManager", "remove from detach: " + h2);
                }
                p0 p0Var = this.f1635c;
                synchronized (p0Var.f1719a) {
                    p0Var.f1719a.remove(h2);
                }
                h2.mAdded = false;
                if (L(h2)) {
                    this.f1624F = true;
                }
                b0(h2);
            }
        }
    }

    public final void i(boolean z, Configuration configuration) {
        if (z && (this.f1652v instanceof v.d)) {
            d0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null) {
                h2.performConfigurationChanged(configuration);
                if (z) {
                    h2.mChildFragmentManager.i(true, configuration);
                }
            }
        }
    }

    public final boolean j(MenuItem menuItem) {
        if (this.f1651u < 1) {
            return false;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null && h2.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(Menu menu, MenuInflater menuInflater) {
        if (this.f1651u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (H h2 : this.f1635c.f()) {
            if (h2 != null && h2.isMenuVisible() && h2.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(h2);
                z = true;
            }
        }
        if (this.f1637e != null) {
            for (int i2 = 0; i2 < this.f1637e.size(); i2++) {
                H h3 = (H) this.f1637e.get(i2);
                if (arrayList == null || !arrayList.contains(h3)) {
                    h3.onDestroyOptionsMenu();
                }
            }
        }
        this.f1637e = arrayList;
        return z;
    }

    public final void l() {
        boolean z = true;
        this.f1627I = true;
        z(true);
        w();
        T t2 = this.f1652v;
        boolean z2 = t2 instanceof androidx.lifecycle.d0;
        p0 p0Var = this.f1635c;
        if (z2) {
            z = p0Var.f1722d.f1671h;
        } else {
            FlutterFragmentActivity flutterFragmentActivity = t2.f1567d;
            if (flutterFragmentActivity != null) {
                z = true ^ flutterFragmentActivity.isChangingConfigurations();
            }
        }
        if (z) {
            Iterator it = this.f1643k.values().iterator();
            while (it.hasNext()) {
                ArrayList arrayList = ((C0103c) it.next()).f1596c;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    p0Var.f1722d.e((String) obj, false);
                }
            }
        }
        u(-1);
        Object obj2 = this.f1652v;
        if (obj2 instanceof v.e) {
            ((v.e) obj2).removeOnTrimMemoryListener(this.q);
        }
        Object obj3 = this.f1652v;
        if (obj3 instanceof v.d) {
            ((v.d) obj3).removeOnConfigurationChangedListener(this.p);
        }
        Object obj4 = this.f1652v;
        if (obj4 instanceof u.I) {
            ((u.I) obj4).removeOnMultiWindowModeChangedListener(this.f1648r);
        }
        Object obj5 = this.f1652v;
        if (obj5 instanceof u.J) {
            ((u.J) obj5).removeOnPictureInPictureModeChangedListener(this.f1649s);
        }
        Object obj6 = this.f1652v;
        if ((obj6 instanceof InterfaceC0010j) && this.f1654x == null) {
            ((InterfaceC0010j) obj6).removeMenuProvider(this.f1650t);
        }
        this.f1652v = null;
        this.f1653w = null;
        this.f1654x = null;
        if (this.f1639g != null) {
            this.f1641i.remove();
            this.f1639g = null;
        }
        C0192h c0192h = this.f1620B;
        if (c0192h != null) {
            c0192h.b();
            this.f1621C.b();
            this.f1622D.b();
        }
    }

    public final void m(boolean z) {
        if (z && (this.f1652v instanceof v.e)) {
            d0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null) {
                h2.performLowMemory();
                if (z) {
                    h2.mChildFragmentManager.m(true);
                }
            }
        }
    }

    public final void n(boolean z, boolean z2) {
        if (z2 && (this.f1652v instanceof u.I)) {
            d0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null) {
                h2.performMultiWindowModeChanged(z);
                if (z2) {
                    h2.mChildFragmentManager.n(z, true);
                }
            }
        }
    }

    public final void o() {
        ArrayList e2 = this.f1635c.e();
        int size = e2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = e2.get(i2);
            i2++;
            H h2 = (H) obj;
            if (h2 != null) {
                h2.onHiddenChanged(h2.isHidden());
                h2.mChildFragmentManager.o();
            }
        }
    }

    public final boolean p(MenuItem menuItem) {
        if (this.f1651u < 1) {
            return false;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null && h2.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void q(Menu menu) {
        if (this.f1651u >= 1) {
            for (H h2 : this.f1635c.f()) {
                if (h2 != null) {
                    h2.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void r(H h2) {
        if (h2 != null) {
            if (h2.equals(this.f1635c.b(h2.mWho))) {
                h2.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void s(boolean z, boolean z2) {
        if (z2 && (this.f1652v instanceof u.J)) {
            d0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null) {
                h2.performPictureInPictureModeChanged(z);
                if (z2) {
                    h2.mChildFragmentManager.s(z, true);
                }
            }
        }
    }

    public final boolean t(Menu menu) {
        boolean z = false;
        if (this.f1651u < 1) {
            return false;
        }
        for (H h2 : this.f1635c.f()) {
            if (h2 != null && h2.isMenuVisible() && h2.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        H h2 = this.f1654x;
        if (h2 != null) {
            sb.append(h2.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1654x)));
            sb.append("}");
        } else {
            T t2 = this.f1652v;
            if (t2 != null) {
                sb.append(t2.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f1652v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(int i2) {
        try {
            this.f1634b = true;
            for (o0 o0Var : this.f1635c.f1720b.values()) {
                if (o0Var != null) {
                    o0Var.f1713e = i2;
                }
            }
            O(i2, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((C0121p) it.next()).i();
            }
            this.f1634b = false;
            z(true);
        } catch (Throwable th) {
            this.f1634b = false;
            throw th;
        }
    }

    public final void v(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String f2 = O.a.f(str, "    ");
        p0 p0Var = this.f1635c;
        ArrayList arrayList = p0Var.f1719a;
        String f3 = O.a.f(str, "    ");
        HashMap hashMap = p0Var.f1720b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (o0 o0Var : hashMap.values()) {
                printWriter.print(str);
                if (o0Var != null) {
                    H h2 = o0Var.f1711c;
                    printWriter.println(h2);
                    h2.dump(f3, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size2; i2++) {
                H h3 = (H) arrayList.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(h3.toString());
            }
        }
        ArrayList arrayList2 = this.f1637e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size; i3++) {
                H h4 = (H) this.f1637e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(h4.toString());
            }
        }
        int size3 = this.f1636d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                C0099a c0099a = (C0099a) this.f1636d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(c0099a.toString());
                c0099a.f(f2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1642j.get());
        synchronized (this.f1633a) {
            try {
                int size4 = this.f1633a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        Object obj = (InterfaceC0108e0) this.f1633a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(obj);
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
        printWriter.println(this.f1652v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1653w);
        if (this.f1654x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1654x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1651u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1625G);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1626H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1627I);
        if (this.f1624F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1624F);
        }
    }

    public final void w() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((C0121p) it.next()).i();
        }
    }

    public final void x(InterfaceC0108e0 interfaceC0108e0, boolean z) {
        if (!z) {
            if (this.f1652v == null) {
                if (this.f1627I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (this.f1625G || this.f1626H) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1633a) {
            try {
                if (this.f1652v == null) {
                    if (z) {
                    } else {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f1633a.add(interfaceC0108e0);
                    X();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(boolean z) {
        if (!this.f1634b) {
            if (this.f1652v == null) {
                if (this.f1627I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.f1652v.f1568e.getLooper()) {
                if (!z && (this.f1625G || this.f1626H)) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.f1629K == null) {
                    this.f1629K = new ArrayList();
                    this.L = new ArrayList();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public final boolean z(boolean z) {
        boolean z2;
        y(z);
        boolean z3 = false;
        while (true) {
            ArrayList arrayList = this.f1629K;
            ArrayList arrayList2 = this.L;
            synchronized (this.f1633a) {
                if (this.f1633a.isEmpty()) {
                    z2 = false;
                } else {
                    try {
                        int size = this.f1633a.size();
                        z2 = false;
                        for (int i2 = 0; i2 < size; i2++) {
                            z2 |= ((InterfaceC0108e0) this.f1633a.get(i2)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!z2) {
                break;
            }
            this.f1634b = true;
            try {
                U(this.f1629K, this.L);
                d();
                z3 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        e0();
        if (this.f1628J) {
            this.f1628J = false;
            ArrayList d2 = this.f1635c.d();
            int size2 = d2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = d2.get(i3);
                i3++;
                o0 o0Var = (o0) obj;
                H h2 = o0Var.f1711c;
                if (h2.mDeferStart) {
                    if (this.f1634b) {
                        this.f1628J = true;
                    } else {
                        h2.mDeferStart = false;
                        o0Var.k();
                    }
                }
            }
        }
        this.f1635c.f1720b.values().removeAll(Collections.singleton(null));
        return z3;
    }
}
