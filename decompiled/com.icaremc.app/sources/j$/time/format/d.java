package j$.time.format;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final e[] f4649a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4650b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(java.util.List r2, boolean r3) {
        /*
            r1 = this;
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r0 = r2.size()
            j$.time.format.e[] r0 = new j$.time.format.e[r0]
            java.lang.Object[] r2 = r2.toArray(r0)
            j$.time.format.e[] r2 = (j$.time.format.e[]) r2
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.d.<init>(java.util.List, boolean):void");
    }

    public d(e[] eVarArr, boolean z) {
        this.f4649a = eVarArr;
        this.f4650b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r2 != false) goto L11;
     */
    @Override // j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(j$.time.format.s r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 1
            boolean r2 = r7.f4650b
            if (r2 == 0) goto Le
            int r3 = r8.f4694c
            int r3 = r3 + r1
            r8.f4694c = r3
        Le:
            j$.time.format.e[] r3 = r7.f4649a     // Catch: java.lang.Throwable -> L27
            int r4 = r3.length     // Catch: java.lang.Throwable -> L27
            r5 = 0
        L12:
            if (r5 >= r4) goto L2c
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L27
            boolean r6 = r6.s(r8, r9)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L29
            r9.setLength(r0)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2f
        L21:
            int r9 = r8.f4694c
            int r9 = r9 - r1
            r8.f4694c = r9
            return r1
        L27:
            r9 = move-exception
            goto L30
        L29:
            int r5 = r5 + 1
            goto L12
        L2c:
            if (r2 == 0) goto L2f
            goto L21
        L2f:
            return r1
        L30:
            if (r2 == 0) goto L37
            int r0 = r8.f4694c
            int r0 = r0 - r1
            r8.f4694c = r0
        L37:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.d.s(j$.time.format.s, java.lang.StringBuilder):boolean");
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i4) {
        boolean z = this.f4650b;
        e[] eVarArr = this.f4649a;
        int i5 = 0;
        if (z) {
            ArrayList arrayList = pVar.f4687d;
            w c4 = pVar.c();
            c4.getClass();
            w wVar = new w();
            ((HashMap) wVar.f4698a).putAll(c4.f4698a);
            wVar.f4699b = c4.f4699b;
            wVar.f4700c = c4.f4700c;
            wVar.f4701d = c4.f4701d;
            arrayList.add(wVar);
            int length = eVarArr.length;
            int i6 = i4;
            while (i5 < length) {
                i6 = eVarArr[i5].A(pVar, charSequence, i6);
                if (i6 < 0) {
                    pVar.f4687d.remove(r8.size() - 1);
                    return i4;
                }
                i5++;
            }
            pVar.f4687d.remove(r8.size() - 2);
            return i6;
        }
        int length2 = eVarArr.length;
        while (i5 < length2) {
            i4 = eVarArr[i5].A(pVar, charSequence, i4);
            if (i4 < 0) {
                return i4;
            }
            i5++;
        }
        return i4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        e[] eVarArr = this.f4649a;
        if (eVarArr != null) {
            boolean z = this.f4650b;
            sb.append(z ? "[" : "(");
            for (e eVar : eVarArr) {
                sb.append(eVar);
            }
            sb.append(z ? "]" : ")");
        }
        return sb.toString();
    }
}
