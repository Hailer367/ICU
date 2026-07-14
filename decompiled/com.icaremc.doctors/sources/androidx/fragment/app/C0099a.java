package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0099a extends r0 implements InterfaceC0108e0 {
    public final h0 p;
    public boolean q;

    /* renamed from: r, reason: collision with root package name */
    public int f1579r;

    public C0099a(h0 h0Var) {
        h0Var.H();
        T t2 = h0Var.f1652v;
        if (t2 != null) {
            t2.f1567d.getClassLoader();
        }
        this.f1735a = new ArrayList();
        this.f1749o = false;
        this.f1579r = -1;
        this.p = h0Var;
    }

    @Override // androidx.fragment.app.InterfaceC0108e0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (h0.K(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1741g) {
            this.p.f1636d.add(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.r0
    public final void c(int i2, H h2, String str) {
        String str2 = h2.mPreviousWho;
        if (str2 != null) {
            R.d.c(h2, str2);
        }
        Class<?> cls = h2.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str3 = h2.mTag;
                if (str3 != null && !str.equals(str3)) {
                    StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                    sb.append(h2);
                    sb.append(": was ");
                    throw new IllegalStateException(O.a.j(sb, h2.mTag, " now ", str));
                }
                h2.mTag = str;
            }
            if (i2 != 0) {
                if (i2 != -1) {
                    int i3 = h2.mFragmentId;
                    if (i3 != 0 && i3 != i2) {
                        throw new IllegalStateException("Can't change container ID of fragment " + h2 + ": was " + h2.mFragmentId + " now " + i2);
                    }
                    h2.mFragmentId = i2;
                    h2.mContainerId = i2;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + h2 + " with tag " + str + " to container view with no id");
                }
            }
            b(new q0(h2, 1));
            h2.mFragmentManager = this.p;
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final void d(int i2) {
        ArrayList arrayList = this.f1735a;
        if (this.f1741g) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                q0 q0Var = (q0) arrayList.get(i3);
                H h2 = q0Var.f1726b;
                if (h2 != null) {
                    h2.mBackStackNesting += i2;
                    if (h0.K(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + q0Var.f1726b + " to " + q0Var.f1726b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int e(boolean z) {
        if (!this.q) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new B0());
                f("  ", printWriter, true);
                printWriter.close();
            }
            this.q = true;
            boolean z2 = this.f1741g;
            h0 h0Var = this.p;
            if (z2) {
                this.f1579r = h0Var.f1642j.getAndIncrement();
            } else {
                this.f1579r = -1;
            }
            h0Var.x(this, z);
            return this.f1579r;
        }
        throw new IllegalStateException("commit already called");
    }

    public final void f(String str, PrintWriter printWriter, boolean z) {
        String str2;
        ArrayList arrayList = this.f1735a;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1742h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1579r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.q);
            if (this.f1740f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1740f));
            }
            if (this.f1736b != 0 || this.f1737c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1736b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1737c));
            }
            if (this.f1738d != 0 || this.f1739e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1738d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1739e));
            }
            if (this.f1743i != 0 || this.f1744j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1743i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1744j);
            }
            if (this.f1745k != 0 || this.f1746l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1745k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1746l);
            }
        }
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                q0 q0Var = (q0) arrayList.get(i2);
                switch (q0Var.f1725a) {
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
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + q0Var.f1725a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(q0Var.f1726b);
                if (z) {
                    if (q0Var.f1728d != 0 || q0Var.f1729e != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(q0Var.f1728d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(q0Var.f1729e));
                    }
                    if (q0Var.f1730f != 0 || q0Var.f1731g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(q0Var.f1730f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(q0Var.f1731g));
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1579r >= 0) {
            sb.append(" #");
            sb.append(this.f1579r);
        }
        if (this.f1742h != null) {
            sb.append(" ");
            sb.append(this.f1742h);
        }
        sb.append("}");
        return sb.toString();
    }
}
