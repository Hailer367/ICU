package V1;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* loaded from: classes.dex */
public final class o extends AbstractMap implements Serializable {

    /* renamed from: n, reason: collision with root package name */
    public static final k f1757n = new k(0);

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1759g;

    /* renamed from: h, reason: collision with root package name */
    public n f1760h;
    public final n k;

    /* renamed from: l, reason: collision with root package name */
    public m f1763l;

    /* renamed from: m, reason: collision with root package name */
    public m f1764m;

    /* renamed from: i, reason: collision with root package name */
    public int f1761i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f1762j = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Comparator f1758f = f1757n;

    public o(boolean z) {
        this.f1759g = z;
        this.k = new n(z);
    }

    public final n a(Object obj, boolean z) {
        int i4;
        n nVar;
        Comparable comparable;
        n nVar2;
        n nVar3 = this.f1760h;
        k kVar = f1757n;
        Comparator comparator = this.f1758f;
        if (nVar3 != null) {
            if (comparator == kVar) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                Object obj2 = nVar3.k;
                if (comparable != null) {
                    i4 = comparable.compareTo(obj2);
                } else {
                    i4 = comparator.compare(obj, obj2);
                }
                if (i4 == 0) {
                    return nVar3;
                }
                if (i4 < 0) {
                    nVar2 = nVar3.f1750g;
                } else {
                    nVar2 = nVar3.f1751h;
                }
                if (nVar2 == null) {
                    break;
                }
                nVar3 = nVar2;
            }
        } else {
            i4 = 0;
        }
        n nVar4 = nVar3;
        if (!z) {
            return null;
        }
        n nVar5 = this.k;
        if (nVar4 == null) {
            if (comparator == kVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            nVar = new n(this.f1759g, nVar4, obj, nVar5, nVar5.f1753j);
            this.f1760h = nVar;
        } else {
            nVar = new n(this.f1759g, nVar4, obj, nVar5, nVar5.f1753j);
            if (i4 < 0) {
                nVar4.f1750g = nVar;
            } else {
                nVar4.f1751h = nVar;
            }
            b(nVar4, true);
        }
        this.f1761i++;
        this.f1762j++;
        return nVar;
    }

    public final void b(n nVar, boolean z) {
        int i4;
        int i5;
        int i6;
        int i7;
        while (nVar != null) {
            n nVar2 = nVar.f1750g;
            n nVar3 = nVar.f1751h;
            int i8 = 0;
            if (nVar2 != null) {
                i4 = nVar2.f1756n;
            } else {
                i4 = 0;
            }
            if (nVar3 != null) {
                i5 = nVar3.f1756n;
            } else {
                i5 = 0;
            }
            int i9 = i4 - i5;
            if (i9 == -2) {
                n nVar4 = nVar3.f1750g;
                n nVar5 = nVar3.f1751h;
                if (nVar5 != null) {
                    i7 = nVar5.f1756n;
                } else {
                    i7 = 0;
                }
                if (nVar4 != null) {
                    i8 = nVar4.f1756n;
                }
                int i10 = i8 - i7;
                if (i10 != -1 && (i10 != 0 || z)) {
                    f(nVar3);
                    e(nVar);
                } else {
                    e(nVar);
                }
                if (z) {
                    return;
                }
            } else if (i9 == 2) {
                n nVar6 = nVar2.f1750g;
                n nVar7 = nVar2.f1751h;
                if (nVar7 != null) {
                    i6 = nVar7.f1756n;
                } else {
                    i6 = 0;
                }
                if (nVar6 != null) {
                    i8 = nVar6.f1756n;
                }
                int i11 = i8 - i6;
                if (i11 != 1 && (i11 != 0 || z)) {
                    e(nVar2);
                    f(nVar);
                } else {
                    f(nVar);
                }
                if (z) {
                    return;
                }
            } else if (i9 == 0) {
                nVar.f1756n = i4 + 1;
                if (z) {
                    return;
                }
            } else {
                nVar.f1756n = Math.max(i4, i5) + 1;
                if (!z) {
                    return;
                }
            }
            nVar = nVar.f1749f;
        }
    }

    public final void c(n nVar, boolean z) {
        n nVar2;
        n nVar3;
        int i4;
        if (z) {
            n nVar4 = nVar.f1753j;
            nVar4.f1752i = nVar.f1752i;
            nVar.f1752i.f1753j = nVar4;
        }
        n nVar5 = nVar.f1750g;
        n nVar6 = nVar.f1751h;
        n nVar7 = nVar.f1749f;
        int i5 = 0;
        if (nVar5 != null && nVar6 != null) {
            if (nVar5.f1756n > nVar6.f1756n) {
                n nVar8 = nVar5.f1751h;
                while (true) {
                    n nVar9 = nVar8;
                    nVar3 = nVar5;
                    nVar5 = nVar9;
                    if (nVar5 == null) {
                        break;
                    } else {
                        nVar8 = nVar5.f1751h;
                    }
                }
            } else {
                n nVar10 = nVar6.f1750g;
                while (true) {
                    nVar2 = nVar6;
                    nVar6 = nVar10;
                    if (nVar6 == null) {
                        break;
                    } else {
                        nVar10 = nVar6.f1750g;
                    }
                }
                nVar3 = nVar2;
            }
            c(nVar3, false);
            n nVar11 = nVar.f1750g;
            if (nVar11 != null) {
                i4 = nVar11.f1756n;
                nVar3.f1750g = nVar11;
                nVar11.f1749f = nVar3;
                nVar.f1750g = null;
            } else {
                i4 = 0;
            }
            n nVar12 = nVar.f1751h;
            if (nVar12 != null) {
                i5 = nVar12.f1756n;
                nVar3.f1751h = nVar12;
                nVar12.f1749f = nVar3;
                nVar.f1751h = null;
            }
            nVar3.f1756n = Math.max(i4, i5) + 1;
            d(nVar, nVar3);
            return;
        }
        if (nVar5 != null) {
            d(nVar, nVar5);
            nVar.f1750g = null;
        } else if (nVar6 != null) {
            d(nVar, nVar6);
            nVar.f1751h = null;
        } else {
            d(nVar, null);
        }
        b(nVar7, false);
        this.f1761i--;
        this.f1762j++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f1760h = null;
        this.f1761i = 0;
        this.f1762j++;
        n nVar = this.k;
        nVar.f1753j = nVar;
        nVar.f1752i = nVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        n nVar = null;
        if (obj != null) {
            try {
                nVar = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (nVar == null) {
            return false;
        }
        return true;
    }

    public final void d(n nVar, n nVar2) {
        n nVar3 = nVar.f1749f;
        nVar.f1749f = null;
        if (nVar2 != null) {
            nVar2.f1749f = nVar3;
        }
        if (nVar3 != null) {
            if (nVar3.f1750g == nVar) {
                nVar3.f1750g = nVar2;
                return;
            } else {
                nVar3.f1751h = nVar2;
                return;
            }
        }
        this.f1760h = nVar2;
    }

    public final void e(n nVar) {
        int i4;
        int i5;
        n nVar2 = nVar.f1750g;
        n nVar3 = nVar.f1751h;
        n nVar4 = nVar3.f1750g;
        n nVar5 = nVar3.f1751h;
        nVar.f1751h = nVar4;
        if (nVar4 != null) {
            nVar4.f1749f = nVar;
        }
        d(nVar, nVar3);
        nVar3.f1750g = nVar;
        nVar.f1749f = nVar3;
        int i6 = 0;
        if (nVar2 != null) {
            i4 = nVar2.f1756n;
        } else {
            i4 = 0;
        }
        if (nVar4 != null) {
            i5 = nVar4.f1756n;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        nVar.f1756n = max;
        if (nVar5 != null) {
            i6 = nVar5.f1756n;
        }
        nVar3.f1756n = Math.max(max, i6) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        m mVar = this.f1763l;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this, 0);
        this.f1763l = mVar2;
        return mVar2;
    }

    public final void f(n nVar) {
        int i4;
        int i5;
        n nVar2 = nVar.f1750g;
        n nVar3 = nVar.f1751h;
        n nVar4 = nVar2.f1750g;
        n nVar5 = nVar2.f1751h;
        nVar.f1750g = nVar5;
        if (nVar5 != null) {
            nVar5.f1749f = nVar;
        }
        d(nVar, nVar2);
        nVar2.f1751h = nVar;
        nVar.f1749f = nVar2;
        int i6 = 0;
        if (nVar3 != null) {
            i4 = nVar3.f1756n;
        } else {
            i4 = 0;
        }
        if (nVar5 != null) {
            i5 = nVar5.f1756n;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        nVar.f1756n = max;
        if (nVar4 != null) {
            i6 = nVar4.f1756n;
        }
        nVar2.f1756n = Math.max(max, i6) + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            V1.n r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto Lf
            java.lang.Object r3 = r3.f1755m
            return r3
        Lf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: V1.o.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        m mVar = this.f1764m;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this, 1);
        this.f1764m = mVar2;
        return mVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 == null && !this.f1759g) {
                throw new NullPointerException("value == null");
            }
            n a4 = a(obj, true);
            Object obj3 = a4.f1755m;
            a4.f1755m = obj2;
            return obj3;
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            V1.n r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto L10
            r1 = 1
            r2.c(r3, r1)
        L10:
            if (r3 == 0) goto L15
            java.lang.Object r3 = r3.f1755m
            return r3
        L15:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: V1.o.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f1761i;
    }
}
