package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0079f extends C0080g {

    /* renamed from: g, reason: collision with root package name */
    public final int f1415g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1416h;

    public C0079f(byte[] bArr, int i2, int i3) {
        super(bArr);
        C0080g.b(i2, i2 + i3, bArr.length);
        this.f1415g = i2;
        this.f1416h = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.C0080g
    public final byte a(int i2) {
        int i3 = this.f1416h;
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(O.a.c(i2, "Index < 0: "));
            }
            throw new ArrayIndexOutOfBoundsException(O.a.d("Index > length: ", i2, ", ", i3));
        }
        return this.f1420d[this.f1415g + i2];
    }

    @Override // androidx.datastore.preferences.protobuf.C0080g
    public final void d(byte[] bArr, int i2) {
        System.arraycopy(this.f1420d, this.f1415g, bArr, 0, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.C0080g
    public final int e() {
        return this.f1415g;
    }

    @Override // androidx.datastore.preferences.protobuf.C0080g
    public final byte f(int i2) {
        return this.f1420d[this.f1415g + i2];
    }

    @Override // androidx.datastore.preferences.protobuf.C0080g
    public final int size() {
        return this.f1416h;
    }
}
