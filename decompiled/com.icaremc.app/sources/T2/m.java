package T2;

/* loaded from: classes.dex */
public abstract class m extends c implements Y2.c {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1642l;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m(java.lang.Object r9, java.lang.Class r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            r8 = this;
            r0 = 1
            r13 = r13 & r0
            r1 = 0
            if (r13 != r0) goto Lc
            r7 = r0
        L6:
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            goto Le
        Lc:
            r7 = r1
            goto L6
        Le:
            r2.<init>(r3, r4, r5, r6, r7)
            r2.f1642l = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T2.m.<init>(java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof m) {
                m mVar = (m) obj;
                if (g().equals(mVar.g()) && this.f1633i.equals(mVar.f1633i) && this.f1634j.equals(mVar.f1634j) && this.f1631g.equals(mVar.f1631g)) {
                    return true;
                }
                return false;
            }
            if (obj instanceof Y2.c) {
                return obj.equals(h());
            }
            return false;
        }
        return true;
    }

    public final Y2.a h() {
        if (this.f1642l) {
            return this;
        }
        Y2.a aVar = this.f1630f;
        if (aVar == null) {
            Y2.a d4 = d();
            this.f1630f = d4;
            return d4;
        }
        return aVar;
    }

    public final int hashCode() {
        return this.f1634j.hashCode() + ((this.f1633i.hashCode() + (g().hashCode() * 31)) * 31);
    }

    public final String toString() {
        Y2.a h3 = h();
        if (h3 != this) {
            return h3.toString();
        }
        return r2.k.c(new StringBuilder("property "), this.f1633i, " (Kotlin reflection is not available)");
    }
}
