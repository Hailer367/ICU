package g0;

import android.os.Parcel;
import android.util.SparseIntArray;
import com.google.firebase.encoders.json.BuildConfig;
import r.C0293e;
import r.j;

/* loaded from: classes.dex */
public final class b extends AbstractC0200a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f2290d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f2291e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2292f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2293g;

    /* renamed from: h, reason: collision with root package name */
    public final String f2294h;

    /* renamed from: i, reason: collision with root package name */
    public int f2295i;

    /* renamed from: j, reason: collision with root package name */
    public int f2296j;

    /* renamed from: k, reason: collision with root package name */
    public int f2297k;

    /* JADX WARN: Type inference failed for: r5v0, types: [r.e, r.j] */
    /* JADX WARN: Type inference failed for: r6v0, types: [r.e, r.j] */
    /* JADX WARN: Type inference failed for: r7v0, types: [r.e, r.j] */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new j(0), new j(0), new j(0));
    }

    @Override // g0.AbstractC0200a
    public final b a() {
        Parcel parcel = this.f2291e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2296j;
        if (i2 == this.f2292f) {
            i2 = this.f2293g;
        }
        return new b(parcel, dataPosition, i2, O.a.i(new StringBuilder(), this.f2294h, "  "), this.f2287a, this.f2288b, this.f2289c);
    }

    @Override // g0.AbstractC0200a
    public final boolean e(int i2) {
        while (this.f2296j < this.f2293g) {
            int i3 = this.f2297k;
            if (i3 != i2) {
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) <= 0) {
                    int i4 = this.f2296j;
                    Parcel parcel = this.f2291e;
                    parcel.setDataPosition(i4);
                    int readInt = parcel.readInt();
                    this.f2297k = parcel.readInt();
                    this.f2296j += readInt;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if (this.f2297k == i2) {
            return true;
        }
        return false;
    }

    @Override // g0.AbstractC0200a
    public final void i(int i2) {
        int i3 = this.f2295i;
        SparseIntArray sparseIntArray = this.f2290d;
        Parcel parcel = this.f2291e;
        if (i3 >= 0) {
            int i4 = sparseIntArray.get(i3);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i4);
            parcel.writeInt(dataPosition - i4);
            parcel.setDataPosition(dataPosition);
        }
        this.f2295i = i2;
        sparseIntArray.put(i2, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i2);
    }

    public b(Parcel parcel, int i2, int i3, String str, C0293e c0293e, C0293e c0293e2, C0293e c0293e3) {
        super(c0293e, c0293e2, c0293e3);
        this.f2290d = new SparseIntArray();
        this.f2295i = -1;
        this.f2297k = -1;
        this.f2291e = parcel;
        this.f2292f = i2;
        this.f2293g = i3;
        this.f2296j = i2;
        this.f2294h = str;
    }
}
