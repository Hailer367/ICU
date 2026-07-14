package b3;

/* loaded from: classes.dex */
public final class D implements K {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3238a;

    public D(boolean z) {
        this.f3238a = z;
    }

    @Override // b3.K
    public final boolean a() {
        return this.f3238a;
    }

    @Override // b3.K
    public final X c() {
        return null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Empty{");
        if (this.f3238a) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
