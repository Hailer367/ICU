package x;

import j.AbstractActivityC0416k;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class N implements Iterable {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f6342f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final AbstractActivityC0416k f6343g;

    public N(AbstractActivityC0416k abstractActivityC0416k) {
        this.f6343g = abstractActivityC0416k;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f6342f.iterator();
    }
}
