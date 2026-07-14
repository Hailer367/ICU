package I2;

import java.util.AbstractList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends AbstractList implements List, U2.a {
    public abstract int a();

    public abstract Object b(int i4);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i4) {
        return b(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
