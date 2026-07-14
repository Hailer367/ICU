package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0169a implements M {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2816a;

    /* renamed from: b, reason: collision with root package name */
    public int f2817b;

    /* renamed from: c, reason: collision with root package name */
    public int f2818c;

    /* renamed from: d, reason: collision with root package name */
    public int f2819d;

    /* renamed from: e, reason: collision with root package name */
    public int f2820e;

    /* renamed from: f, reason: collision with root package name */
    public int f2821f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2822g;

    /* renamed from: h, reason: collision with root package name */
    public String f2823h;

    /* renamed from: i, reason: collision with root package name */
    public int f2824i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f2825j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2826l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f2827m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f2828n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2829o;

    /* renamed from: p, reason: collision with root package name */
    public final P f2830p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2831q;

    /* renamed from: r, reason: collision with root package name */
    public int f2832r;

    public C0169a(P p3) {
        p3.G();
        C0191x c0191x = p3.f2770v;
        if (c0191x != null) {
            c0191x.f2949g.getClassLoader();
        }
        this.f2816a = new ArrayList();
        this.f2829o = false;
        this.f2832r = -1;
        this.f2830p = p3;
    }

    @Override // androidx.fragment.app.M
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (P.J(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f2822g) {
            this.f2830p.f2753d.add(this);
            return true;
        }
        return true;
    }

    public final void b(Y y3) {
        this.f2816a.add(y3);
        y3.f2810d = this.f2817b;
        y3.f2811e = this.f2818c;
        y3.f2812f = this.f2819d;
        y3.f2813g = this.f2820e;
    }

    public final void c(int i4) {
        if (this.f2822g) {
            if (P.J(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i4);
            }
            ArrayList arrayList = this.f2816a;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                Y y3 = (Y) arrayList.get(i5);
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = y3.f2808b;
                if (abstractComponentCallbacksC0187t != null) {
                    abstractComponentCallbacksC0187t.f2940w += i4;
                    if (P.J(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + y3.f2808b + " to " + y3.f2808b.f2940w);
                    }
                }
            }
        }
    }

    public final int d(boolean z) {
        if (!this.f2831q) {
            if (P.J(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new a0());
                f("  ", printWriter, true);
                printWriter.close();
            }
            this.f2831q = true;
            boolean z3 = this.f2822g;
            P p3 = this.f2830p;
            if (z3) {
                this.f2832r = p3.f2759j.getAndIncrement();
            } else {
                this.f2832r = -1;
            }
            p3.y(this, z);
            return this.f2832r;
        }
        throw new IllegalStateException("commit already called");
    }

    public final void e(int i4, AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, String str) {
        String str2 = abstractComponentCallbacksC0187t.P;
        if (str2 != null) {
            Y.d.c(abstractComponentCallbacksC0187t, str2);
        }
        Class<?> cls = abstractComponentCallbacksC0187t.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str3 = abstractComponentCallbacksC0187t.f2906D;
                if (str3 != null && !str.equals(str3)) {
                    throw new IllegalStateException("Can't change tag of fragment " + abstractComponentCallbacksC0187t + ": was " + abstractComponentCallbacksC0187t.f2906D + " now " + str);
                }
                abstractComponentCallbacksC0187t.f2906D = str;
            }
            if (i4 != 0) {
                if (i4 != -1) {
                    int i5 = abstractComponentCallbacksC0187t.f2904B;
                    if (i5 != 0 && i5 != i4) {
                        throw new IllegalStateException("Can't change container ID of fragment " + abstractComponentCallbacksC0187t + ": was " + abstractComponentCallbacksC0187t.f2904B + " now " + i4);
                    }
                    abstractComponentCallbacksC0187t.f2904B = i4;
                    abstractComponentCallbacksC0187t.f2905C = i4;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + abstractComponentCallbacksC0187t + " with tag " + str + " to container view with no id");
                }
            }
            b(new Y(1, abstractComponentCallbacksC0187t));
            abstractComponentCallbacksC0187t.f2941x = this.f2830p;
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final void f(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2823h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2832r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2831q);
            if (this.f2821f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2821f));
            }
            if (this.f2817b != 0 || this.f2818c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2817b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2818c));
            }
            if (this.f2819d != 0 || this.f2820e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2819d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2820e));
            }
            if (this.f2824i != 0 || this.f2825j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2824i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2825j);
            }
            if (this.k != 0 || this.f2826l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2826l);
            }
        }
        ArrayList arrayList = this.f2816a;
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                Y y3 = (Y) arrayList.get(i4);
                switch (y3.f2807a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        str2 = "ATTACH";
                        break;
                    case R.j.BYTES_FIELD_NUMBER /* 8 */:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + y3.f2807a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(y3.f2808b);
                if (z) {
                    if (y3.f2810d != 0 || y3.f2811e != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(y3.f2810d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(y3.f2811e));
                    }
                    if (y3.f2812f != 0 || y3.f2813g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(y3.f2812f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(y3.f2813g));
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2832r >= 0) {
            sb.append(" #");
            sb.append(this.f2832r);
        }
        if (this.f2823h != null) {
            sb.append(" ");
            sb.append(this.f2823h);
        }
        sb.append("}");
        return sb.toString();
    }
}
