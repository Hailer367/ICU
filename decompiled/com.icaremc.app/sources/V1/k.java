package V1;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class k implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1741a;

    public /* synthetic */ k(int i4) {
        this.f1741a = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        if (r0 != false) goto L18;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            int r0 = r5.f1741a
            switch(r0) {
                case 0: goto L3c;
                default: goto L5;
            }
        L5:
            h0.i r6 = (h0.C0321i) r6
            h0.i r7 = (h0.C0321i) r7
            androidx.recyclerview.widget.RecyclerView r0 = r6.f3906d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L11
            r3 = r2
            goto L12
        L11:
            r3 = r1
        L12:
            androidx.recyclerview.widget.RecyclerView r4 = r7.f3906d
            if (r4 != 0) goto L18
            r4 = r2
            goto L19
        L18:
            r4 = r1
        L19:
            if (r3 == r4) goto L1e
            if (r0 != 0) goto L26
            goto L28
        L1e:
            boolean r0 = r6.f3903a
            boolean r3 = r7.f3903a
            if (r0 == r3) goto L2a
            if (r0 == 0) goto L28
        L26:
            r1 = -1
            goto L3b
        L28:
            r1 = r2
            goto L3b
        L2a:
            int r0 = r7.f3904b
            int r2 = r6.f3904b
            int r0 = r0 - r2
            if (r0 == 0) goto L33
            r1 = r0
            goto L3b
        L33:
            int r6 = r6.f3905c
            int r7 = r7.f3905c
            int r6 = r6 - r7
            if (r6 == 0) goto L3b
            r1 = r6
        L3b:
            return r1
        L3c:
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            int r6 = r6.compareTo(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: V1.k.compare(java.lang.Object, java.lang.Object):int");
    }
}
