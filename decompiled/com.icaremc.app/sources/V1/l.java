package V1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class l implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public n f1742f;

    /* renamed from: g, reason: collision with root package name */
    public n f1743g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f1744h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f1745i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1746j;

    public l(o oVar, int i4) {
        this.f1746j = i4;
        this.f1745i = oVar;
        this.f1742f = oVar.k.f1752i;
        this.f1744h = oVar.f1762j;
    }

    public final Object a() {
        return b();
    }

    public final n b() {
        n nVar = this.f1742f;
        o oVar = this.f1745i;
        if (nVar != oVar.k) {
            if (oVar.f1762j == this.f1744h) {
                this.f1742f = nVar.f1752i;
                this.f1743g = nVar;
                return nVar;
            }
            throw new ConcurrentModificationException();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1742f != this.f1745i.k) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f1746j) {
            case 1:
                return b().k;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        n nVar = this.f1743g;
        if (nVar != null) {
            o oVar = this.f1745i;
            oVar.c(nVar, true);
            this.f1743g = null;
            this.f1744h = oVar.f1762j;
            return;
        }
        throw new IllegalStateException();
    }
}
