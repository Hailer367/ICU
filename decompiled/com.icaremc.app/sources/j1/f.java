package j1;

import a.AbstractC0141a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: j, reason: collision with root package name */
    public static final f f5048j = new f(new Object[0], 0);

    /* renamed from: h, reason: collision with root package name */
    public final transient Object[] f5049h;

    /* renamed from: i, reason: collision with root package name */
    public final transient int f5050i;

    public f(Object[] objArr, int i4) {
        this.f5049h = objArr;
        this.f5050i = i4;
    }

    @Override // j1.AbstractC0425a
    public final Object[] a() {
        return this.f5049h;
    }

    @Override // j1.AbstractC0425a
    public final int b() {
        return 0;
    }

    @Override // j1.AbstractC0425a
    public final int c() {
        return this.f5050i;
    }

    @Override // j1.e, j1.AbstractC0425a
    public final int d(Object[] objArr) {
        Object[] objArr2 = this.f5049h;
        int i4 = this.f5050i;
        System.arraycopy(objArr2, 0, objArr, 0, i4);
        return i4;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        AbstractC0141a.R(i4, this.f5050i);
        Object obj = this.f5049h[i4];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5050i;
    }
}
