package W;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f789a;

    /* renamed from: b, reason: collision with root package name */
    public final float f790b;

    /* renamed from: c, reason: collision with root package name */
    public final float f791c;

    /* renamed from: d, reason: collision with root package name */
    public final float f792d;

    /* renamed from: e, reason: collision with root package name */
    public final long f793e;

    public b(int i2, float f2, float f3, float f4, long j2) {
        this.f789a = i2;
        this.f790b = f2;
        this.f791c = f3;
        this.f792d = f4;
        this.f793e = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f791c == bVar.f791c && this.f792d == bVar.f792d && this.f790b == bVar.f790b && this.f789a == bVar.f789a && this.f793e == bVar.f793e) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f793e) + ((Integer.hashCode(this.f789a) + ((Float.hashCode(this.f790b) + ((Float.hashCode(this.f792d) + (Float.hashCode(this.f791c) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.f791c + ", touchY=" + this.f792d + ", progress=" + this.f790b + ", swipeEdge=" + this.f789a + ", frameTimeMillis=" + this.f793e + ')';
    }
}
