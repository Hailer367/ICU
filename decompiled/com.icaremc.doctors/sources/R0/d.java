package R0;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class d extends e implements RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public final e f740c;

    /* renamed from: d, reason: collision with root package name */
    public final int f741d;

    /* renamed from: e, reason: collision with root package name */
    public final int f742e;

    public d(e eVar, int i2, int i3) {
        this.f740c = eVar;
        this.f741d = i2;
        android.support.v4.media.session.a.d(i2, i3, eVar.a());
        this.f742e = i3 - i2;
    }

    @Override // R0.e
    public final int a() {
        return this.f742e;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        int i3 = this.f742e;
        if (i2 >= 0 && i2 < i3) {
            return this.f740c.get(this.f741d + i2);
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", i3));
    }

    @Override // R0.e, java.util.List
    public final List subList(int i2, int i3) {
        android.support.v4.media.session.a.d(i2, i3, this.f742e);
        int i4 = this.f741d;
        return new d(this.f740c, i2 + i4, i4 + i3);
    }
}
