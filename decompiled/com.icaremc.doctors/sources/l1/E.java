package l1;

/* loaded from: classes.dex */
public final class E implements L {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2951a;

    public E(boolean z) {
        this.f2951a = z;
    }

    @Override // l1.L
    public final boolean a() {
        return this.f2951a;
    }

    @Override // l1.L
    public final Y c() {
        return null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Empty{");
        if (this.f2951a) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
