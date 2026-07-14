package f3;

import b3.N;
import b3.W;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends M2.c implements e3.e {

    /* renamed from: i, reason: collision with root package name */
    public final e3.e f3728i;

    /* renamed from: j, reason: collision with root package name */
    public final K2.i f3729j;
    public final int k;

    /* renamed from: l, reason: collision with root package name */
    public K2.i f3730l;

    /* renamed from: m, reason: collision with root package name */
    public K2.d f3731m;

    public l(e3.e eVar, K2.i iVar) {
        super(j.f3726f, K2.j.f942f);
        this.f3728i = eVar;
        this.f3729j = iVar;
        this.k = ((Number) iVar.k(0, new K2.b(5))).intValue();
    }

    @Override // M2.a, M2.d
    public final M2.d d() {
        K2.d dVar = this.f3731m;
        if (dVar instanceof M2.d) {
            return (M2.d) dVar;
        }
        return null;
    }

    @Override // e3.e
    public final Object g(Object obj, K2.d dVar) {
        try {
            Object n3 = n(dVar, obj);
            if (n3 == L2.a.f1019f) {
                return n3;
            }
            return H2.i.f681a;
        } catch (Throwable th) {
            this.f3730l = new h(dVar.getContext(), th);
            throw th;
        }
    }

    @Override // M2.c, K2.d
    public final K2.i getContext() {
        K2.i iVar = this.f3730l;
        if (iVar == null) {
            return K2.j.f942f;
        }
        return iVar;
    }

    @Override // M2.a
    public final StackTraceElement j() {
        return null;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        Throwable a4 = H2.f.a(obj);
        if (a4 != null) {
            this.f3730l = new h(getContext(), a4);
        }
        K2.d dVar = this.f3731m;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return L2.a.f1019f;
    }

    public final Object n(K2.d dVar, Object obj) {
        List list;
        Comparable comparable;
        int i4;
        String str;
        K2.i context = dVar.getContext();
        N n3 = (N) context.e(b3.r.f3295g);
        if (n3 != null && !n3.a()) {
            throw ((W) n3).w();
        }
        K2.i iVar = this.f3730l;
        if (iVar != context) {
            int i5 = 0;
            if (iVar instanceof h) {
                String str2 = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((h) iVar).f3725g + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                T2.h.e(str2, "<this>");
                a3.a aVar = new a3.a(str2);
                if (!aVar.hasNext()) {
                    list = I2.m.f862f;
                } else {
                    Object next = aVar.next();
                    if (!aVar.hasNext()) {
                        list = android.support.v4.media.session.a.p(next);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        while (aVar.hasNext()) {
                            arrayList.add(aVar.next());
                        }
                        list = arrayList;
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (!a3.h.D((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(arrayList2.size());
                int size = arrayList2.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj3 = arrayList2.get(i6);
                    i6++;
                    String str3 = (String) obj3;
                    int length = str3.length();
                    int i7 = 0;
                    while (true) {
                        if (i7 < length) {
                            char charAt = str3.charAt(i7);
                            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                                break;
                            }
                            i7++;
                        } else {
                            i7 = -1;
                            break;
                        }
                    }
                    if (i7 == -1) {
                        i7 = str3.length();
                    }
                    arrayList3.add(Integer.valueOf(i7));
                }
                Iterator it = arrayList3.iterator();
                if (!it.hasNext()) {
                    comparable = null;
                } else {
                    comparable = (Comparable) it.next();
                    while (it.hasNext()) {
                        Comparable comparable2 = (Comparable) it.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                }
                Integer num = (Integer) comparable;
                if (num != null) {
                    i4 = num.intValue();
                } else {
                    i4 = 0;
                }
                int length2 = str2.length();
                list.size();
                int size2 = list.size() - 1;
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : list) {
                    int i8 = i5 + 1;
                    if (i5 >= 0) {
                        String str4 = (String) obj4;
                        if ((i5 == 0 || i5 == size2) && a3.h.D(str4)) {
                            str = null;
                        } else {
                            T2.h.e(str4, "<this>");
                            if (i4 >= 0) {
                                int length3 = str4.length();
                                if (i4 <= length3) {
                                    length3 = i4;
                                }
                                str = str4.substring(length3);
                                T2.h.d(str, "substring(...)");
                            } else {
                                throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
                            }
                        }
                        if (str != null) {
                            arrayList4.add(str);
                        }
                        i5 = i8;
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                StringBuilder sb = new StringBuilder(length2);
                I2.e.F(arrayList4, sb, "\n", "", "", "...", null);
                throw new IllegalStateException(sb.toString().toString());
            }
            if (((Number) context.k(0, new S2.p() { // from class: f3.o
                /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
                
                    if (r1 == null) goto L17;
                 */
                @Override // S2.p
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object e(java.lang.Object r4, java.lang.Object r5) {
                    /*
                        r3 = this;
                        java.lang.Integer r4 = (java.lang.Integer) r4
                        int r4 = r4.intValue()
                        K2.g r5 = (K2.g) r5
                        K2.h r0 = r5.getKey()
                        f3.l r1 = f3.l.this
                        K2.i r1 = r1.f3729j
                        K2.g r1 = r1.e(r0)
                        b3.r r2 = b3.r.f3295g
                        if (r0 == r2) goto L20
                        if (r5 == r1) goto L1d
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        goto L34
                    L1d:
                        int r4 = r4 + 1
                        goto L34
                    L20:
                        b3.N r1 = (b3.N) r1
                        b3.N r5 = (b3.N) r5
                    L24:
                        r0 = 0
                        if (r5 != 0) goto L29
                        r5 = r0
                        goto L30
                    L29:
                        if (r5 != r1) goto L2c
                        goto L30
                    L2c:
                        boolean r2 = r5 instanceof g3.q
                        if (r2 != 0) goto L5e
                    L30:
                        if (r5 != r1) goto L39
                        if (r1 != 0) goto L1d
                    L34:
                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                        return r4
                    L39:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r2 = "Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of "
                        r0.<init>(r2)
                        r0.append(r5)
                        java.lang.String r5 = ", expected child of "
                        r0.append(r5)
                        r0.append(r1)
                        java.lang.String r5 = ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'"
                        r0.append(r5)
                        java.lang.String r5 = r0.toString()
                        java.lang.String r5 = r5.toString()
                        r4.<init>(r5)
                        throw r4
                    L5e:
                        g3.q r5 = (g3.q) r5
                        java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = b3.W.f3263g
                        java.lang.Object r5 = r2.get(r5)
                        b3.j r5 = (b3.InterfaceC0235j) r5
                        if (r5 == 0) goto L6f
                        b3.N r5 = r5.getParent()
                        goto L24
                    L6f:
                        r5 = r0
                        goto L24
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f3.o.e(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            })).intValue() == this.k) {
                this.f3730l = context;
            } else {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f3729j + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
        }
        this.f3731m = dVar;
        S2.q qVar = n.f3733a;
        e3.e eVar = this.f3728i;
        T2.h.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object c4 = qVar.c(eVar, obj, this);
        if (!T2.h.a(c4, L2.a.f1019f)) {
            this.f3731m = null;
        }
        return c4;
    }
}
