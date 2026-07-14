package T;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public int f1572a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final s f1573b;

    /* renamed from: c, reason: collision with root package name */
    public s f1574c;

    /* renamed from: d, reason: collision with root package name */
    public s f1575d;

    /* renamed from: e, reason: collision with root package name */
    public int f1576e;

    /* renamed from: f, reason: collision with root package name */
    public int f1577f;

    public p(s sVar) {
        this.f1573b = sVar;
        this.f1574c = sVar;
    }

    public final int a(int i4) {
        s sVar;
        SparseArray sparseArray = this.f1574c.f1590a;
        if (sparseArray == null) {
            sVar = null;
        } else {
            sVar = (s) sparseArray.get(i4);
        }
        int i5 = 1;
        int i6 = 2;
        if (this.f1572a != 2) {
            if (sVar == null) {
                b();
            } else {
                this.f1572a = 2;
                this.f1574c = sVar;
                this.f1577f = 1;
                i5 = i6;
            }
        } else {
            if (sVar != null) {
                this.f1574c = sVar;
                this.f1577f++;
            } else if (i4 == 65038) {
                b();
            } else if (i4 != 65039) {
                s sVar2 = this.f1574c;
                if (sVar2.f1591b != null) {
                    i6 = 3;
                    if (this.f1577f == 1) {
                        if (c()) {
                            this.f1575d = this.f1574c;
                            b();
                        } else {
                            b();
                        }
                    } else {
                        this.f1575d = sVar2;
                        b();
                    }
                } else {
                    b();
                }
            }
            i5 = i6;
        }
        this.f1576e = i4;
        return i5;
    }

    public final void b() {
        this.f1572a = 1;
        this.f1574c = this.f1573b;
        this.f1577f = 0;
    }

    public final boolean c() {
        U.a b4 = this.f1574c.f1591b.b();
        int a4 = b4.a(6);
        if ((a4 != 0 && ((ByteBuffer) b4.f694d).get(a4 + b4.f691a) != 0) || this.f1576e == 65039) {
            return true;
        }
        return false;
    }
}
