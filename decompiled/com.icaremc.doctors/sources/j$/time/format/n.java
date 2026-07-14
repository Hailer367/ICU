package j$.time.format;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class n implements e {

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f2577a;

    /* renamed from: b, reason: collision with root package name */
    public final z f2578b;

    /* renamed from: c, reason: collision with root package name */
    public final a f2579c;

    /* renamed from: d, reason: collision with root package name */
    public volatile h f2580d;

    public n(j$.time.temporal.q qVar, z zVar, a aVar) {
        this.f2577a = qVar;
        this.f2578b = zVar;
        this.f2579c = aVar;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        String a2;
        Long a3 = sVar.a(this.f2577a);
        DateTimeFormatter dateTimeFormatter = sVar.f2596b;
        if (a3 == null) {
            return false;
        }
        j$.time.chrono.l lVar = (j$.time.chrono.l) sVar.f2595a.b(j$.time.temporal.r.f2669b);
        if (lVar == null || lVar == j$.time.chrono.s.f2522c) {
            a aVar = this.f2579c;
            long longValue = a3.longValue();
            z zVar = this.f2578b;
            Locale locale = dateTimeFormatter.f2544b;
            a2 = aVar.f2549a.a(longValue, zVar);
        } else {
            a aVar2 = this.f2579c;
            long longValue2 = a3.longValue();
            z zVar2 = this.f2578b;
            Locale locale2 = dateTimeFormatter.f2544b;
            a2 = aVar2.f2549a.a(longValue2, zVar2);
        }
        if (a2 != null) {
            sb.append(a2);
            return true;
        }
        if (this.f2580d == null) {
            this.f2580d = new h(this.f2577a, 1, 19, y.NORMAL);
        }
        return this.f2580d.s(sVar, sb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        if (r8 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        if (r8.hasNext() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        r9 = (java.util.Map.Entry) r8.next();
        r1 = (java.lang.String) r9.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        if (r11.g(r1, 0, r12, r13, r1.length()) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
    
        return r11.f(r10.f2577a, ((java.lang.Long) r9.getValue()).longValue(), r13, r1.length() + r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
    
        if (r6 != j$.time.temporal.a.ERA) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        if (r11.f2589c != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        r6 = r7.z().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
    
        if (r6.hasNext() == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00af, code lost:
    
        r1 = ((j$.time.chrono.m) r6.next()).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c6, code lost:
    
        if (r11.g(r1, 0, r12, r13, r1.length()) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dc, code lost:
    
        return r11.f(r10.f2577a, r7.getValue(), r13, r1.length() + r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00df, code lost:
    
        if (r11.f2589c == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e2, code lost:
    
        return ~r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e5, code lost:
    
        if (r10.f2580d != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e7, code lost:
    
        r10.f2580d = new j$.time.format.h(r10.f2577a, 1, 19, j$.time.format.y.NORMAL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
    
        return r10.f2580d.A(r11, r12, r13);
     */
    @Override // j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A(j$.time.format.p r11, java.lang.CharSequence r12, int r13) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.n.A(j$.time.format.p, java.lang.CharSequence, int):int");
    }

    public final String toString() {
        z zVar = z.FULL;
        j$.time.temporal.q qVar = this.f2577a;
        z zVar2 = this.f2578b;
        if (zVar2 == zVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + zVar2 + ")";
    }
}
