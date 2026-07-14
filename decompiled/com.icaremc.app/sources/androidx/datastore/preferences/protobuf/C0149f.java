package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0149f extends C0150g {

    /* renamed from: j, reason: collision with root package name */
    public final int f2633j;
    public final int k;

    public C0149f(byte[] bArr, int i4, int i5) {
        super(bArr);
        C0150g.b(i4, i4 + i5, bArr.length);
        this.f2633j = i4;
        this.k = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.C0150g
    public final byte a(int i4) {
        int i5 = this.k;
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException(A2.i.g(i4, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(A2.i.h("Index > length: ", ", ", i4, i5));
        }
        return this.f2637g[this.f2633j + i4];
    }

    @Override // androidx.datastore.preferences.protobuf.C0150g
    public final void d(byte[] bArr, int i4) {
        System.arraycopy(this.f2637g, this.f2633j, bArr, 0, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.C0150g
    public final int e() {
        return this.f2633j;
    }

    @Override // androidx.datastore.preferences.protobuf.C0150g
    public final byte f(int i4) {
        return this.f2637g[this.f2633j + i4];
    }

    @Override // androidx.datastore.preferences.protobuf.C0150g
    public final int size() {
        return this.k;
    }
}
