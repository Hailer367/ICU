package p1;

import com.google.firebase.encoders.json.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l1.C0241t;
import l1.O;
import l1.X;

/* loaded from: classes.dex */
public final class l extends V0.c implements o1.e {

    /* renamed from: c, reason: collision with root package name */
    public final o1.e f3489c;

    /* renamed from: d, reason: collision with root package name */
    public final T0.i f3490d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3491e;

    /* renamed from: f, reason: collision with root package name */
    public T0.i f3492f;

    /* renamed from: g, reason: collision with root package name */
    public T0.d f3493g;

    public l(o1.e eVar, T0.i iVar) {
        super(j.f3487c, T0.j.f774c);
        this.f3489c = eVar;
        this.f3490d = iVar;
        this.f3491e = ((Number) iVar.c(0, new T0.b(5))).intValue();
    }

    public final Object b(T0.d dVar, Object obj) {
        List list;
        Comparable comparable;
        int i2;
        String str;
        T0.i context = dVar.getContext();
        O o2 = (O) context.k(C0241t.f3012d);
        if (o2 != null && !o2.a()) {
            throw ((X) o2).v();
        }
        T0.i iVar = this.f3492f;
        if (iVar != context) {
            int i3 = 0;
            if (iVar instanceof h) {
                String str2 = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((h) iVar).f3486d + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                kotlin.jvm.internal.h.e(str2, "<this>");
                k1.a aVar = new k1.a(str2);
                if (!aVar.hasNext()) {
                    list = R0.r.f750c;
                } else {
                    Object next = aVar.next();
                    if (!aVar.hasNext()) {
                        list = android.support.v4.media.session.a.y(next);
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
                    if (!k1.h.P((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(R0.l.O(arrayList2));
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj3 = arrayList2.get(i4);
                    i4++;
                    String str3 = (String) obj3;
                    int length = str3.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            char charAt = str3.charAt(i5);
                            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                                break;
                            }
                            i5++;
                        } else {
                            i5 = -1;
                            break;
                        }
                    }
                    if (i5 == -1) {
                        i5 = str3.length();
                    }
                    arrayList3.add(Integer.valueOf(i5));
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
                    i2 = num.intValue();
                } else {
                    i2 = 0;
                }
                int length2 = str2.length();
                list.size();
                int size2 = list.size() - 1;
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : list) {
                    int i6 = i3 + 1;
                    if (i3 >= 0) {
                        String str4 = (String) obj4;
                        if ((i3 == 0 || i3 == size2) && k1.h.P(str4)) {
                            str = null;
                        } else {
                            kotlin.jvm.internal.h.e(str4, "<this>");
                            if (i2 >= 0) {
                                int length3 = str4.length();
                                if (i2 <= length3) {
                                    length3 = i2;
                                }
                                str = str4.substring(length3);
                                kotlin.jvm.internal.h.d(str, "substring(...)");
                            } else {
                                throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
                            }
                        }
                        if (str != null) {
                            arrayList4.add(str);
                        }
                        i3 = i6;
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                StringBuilder sb = new StringBuilder(length2);
                R0.j.R(arrayList4, sb, "\n", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "...", null);
                throw new IllegalStateException(sb.toString().toString());
            }
            if (((Number) context.c(0, new c1.p() { // from class: p1.o
                /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
                
                    if (r1 == null) goto L17;
                 */
                @Override // c1.p
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invoke(java.lang.Object r4, java.lang.Object r5) {
                    /*
                        r3 = this;
                        java.lang.Integer r4 = (java.lang.Integer) r4
                        int r4 = r4.intValue()
                        T0.g r5 = (T0.g) r5
                        T0.h r0 = r5.getKey()
                        p1.l r1 = p1.l.this
                        T0.i r1 = r1.f3490d
                        T0.g r1 = r1.k(r0)
                        l1.t r2 = l1.C0241t.f3012d
                        if (r0 == r2) goto L20
                        if (r5 == r1) goto L1d
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        goto L34
                    L1d:
                        int r4 = r4 + 1
                        goto L34
                    L20:
                        l1.O r1 = (l1.O) r1
                        l1.O r5 = (l1.O) r5
                    L24:
                        r0 = 0
                        if (r5 != 0) goto L29
                        r5 = r0
                        goto L30
                    L29:
                        if (r5 != r1) goto L2c
                        goto L30
                    L2c:
                        boolean r2 = r5 instanceof q1.q
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
                        q1.q r5 = (q1.q) r5
                        java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = l1.X.f2977d
                        java.lang.Object r5 = r2.get(r5)
                        l1.k r5 = (l1.InterfaceC0233k) r5
                        if (r5 == 0) goto L6f
                        l1.O r5 = r5.getParent()
                        goto L24
                    L6f:
                        r5 = r0
                        goto L24
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p1.o.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            })).intValue() == this.f3491e) {
                this.f3492f = context;
            } else {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f3490d + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
        }
        this.f3493g = dVar;
        c1.q qVar = n.f3495a;
        o1.e eVar = this.f3489c;
        kotlin.jvm.internal.h.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object a2 = qVar.a(eVar, obj, this);
        if (!kotlin.jvm.internal.h.a(a2, U0.a.f780c)) {
            this.f3493g = null;
        }
        return a2;
    }

    @Override // o1.e
    public final Object emit(Object obj, T0.d dVar) {
        try {
            Object b2 = b(dVar, obj);
            if (b2 == U0.a.f780c) {
                return b2;
            }
            return Q0.j.f722a;
        } catch (Throwable th) {
            this.f3492f = new h(dVar.getContext(), th);
            throw th;
        }
    }

    @Override // V0.a, V0.d
    public final V0.d getCallerFrame() {
        T0.d dVar = this.f3493g;
        if (dVar instanceof V0.d) {
            return (V0.d) dVar;
        }
        return null;
    }

    @Override // V0.c, T0.d
    public final T0.i getContext() {
        T0.i iVar = this.f3492f;
        if (iVar == null) {
            return T0.j.f774c;
        }
        return iVar;
    }

    @Override // V0.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Throwable a2 = Q0.g.a(obj);
        if (a2 != null) {
            this.f3492f = new h(getContext(), a2);
        }
        T0.d dVar = this.f3493g;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return U0.a.f780c;
    }
}
