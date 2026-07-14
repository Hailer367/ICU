package d0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3427a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3428b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3429c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3430d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3431e;

    public b(int i4, float f4, float f5, float f6, long j4) {
        this.f3427a = i4;
        this.f3428b = f4;
        this.f3429c = f5;
        this.f3430d = f6;
        this.f3431e = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f3429c == bVar.f3429c && this.f3430d == bVar.f3430d && this.f3428b == bVar.f3428b && this.f3427a == bVar.f3427a && this.f3431e == bVar.f3431e) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f3431e) + ((Integer.hashCode(this.f3427a) + ((Float.hashCode(this.f3428b) + ((Float.hashCode(this.f3430d) + (Float.hashCode(this.f3429c) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.f3429c + ", touchY=" + this.f3430d + ", progress=" + this.f3428b + ", swipeEdge=" + this.f3427a + ", frameTimeMillis=" + this.f3431e + ')';
    }
}
