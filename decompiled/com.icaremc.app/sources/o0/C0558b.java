package o0;

import android.os.Parcel;
import android.util.SparseIntArray;
import r2.k;
import t.C0656e;
import t.C0661j;

/* renamed from: o0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0558b extends AbstractC0557a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f5762d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f5763e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5764f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5765g;

    /* renamed from: h, reason: collision with root package name */
    public final String f5766h;

    /* renamed from: i, reason: collision with root package name */
    public int f5767i;

    /* renamed from: j, reason: collision with root package name */
    public int f5768j;
    public int k;

    /* JADX WARN: Type inference failed for: r5v0, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r6v0, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r7v0, types: [t.j, t.e] */
    public C0558b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0661j(0), new C0661j(0), new C0661j(0));
    }

    @Override // o0.AbstractC0557a
    public final C0558b a() {
        Parcel parcel = this.f5763e;
        int dataPosition = parcel.dataPosition();
        int i4 = this.f5768j;
        if (i4 == this.f5764f) {
            i4 = this.f5765g;
        }
        return new C0558b(parcel, dataPosition, i4, k.c(new StringBuilder(), this.f5766h, "  "), this.f5759a, this.f5760b, this.f5761c);
    }

    @Override // o0.AbstractC0557a
    public final boolean e(int i4) {
        while (this.f5768j < this.f5765g) {
            int i5 = this.k;
            if (i5 != i4) {
                if (String.valueOf(i5).compareTo(String.valueOf(i4)) <= 0) {
                    int i6 = this.f5768j;
                    Parcel parcel = this.f5763e;
                    parcel.setDataPosition(i6);
                    int readInt = parcel.readInt();
                    this.k = parcel.readInt();
                    this.f5768j += readInt;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if (this.k == i4) {
            return true;
        }
        return false;
    }

    @Override // o0.AbstractC0557a
    public final void i(int i4) {
        int i5 = this.f5767i;
        SparseIntArray sparseIntArray = this.f5762d;
        Parcel parcel = this.f5763e;
        if (i5 >= 0) {
            int i6 = sparseIntArray.get(i5);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i6);
            parcel.writeInt(dataPosition - i6);
            parcel.setDataPosition(dataPosition);
        }
        this.f5767i = i4;
        sparseIntArray.put(i4, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i4);
    }

    public C0558b(Parcel parcel, int i4, int i5, String str, C0656e c0656e, C0656e c0656e2, C0656e c0656e3) {
        super(c0656e, c0656e2, c0656e3);
        this.f5762d = new SparseIntArray();
        this.f5767i = -1;
        this.k = -1;
        this.f5763e = parcel;
        this.f5764f = i4;
        this.f5765g = i5;
        this.f5768j = i4;
        this.f5766h = str;
    }
}
