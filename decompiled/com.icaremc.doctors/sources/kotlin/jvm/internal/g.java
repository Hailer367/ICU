package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class g extends b implements f, i1.e {

    /* renamed from: c, reason: collision with root package name */
    public final int f2783c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2784d;

    public g(int i2, Class cls, String str, String str2, int i3) {
        this(i2, b.NO_RECEIVER, cls, str, str2, i3, 0);
    }

    @Override // kotlin.jvm.internal.b
    public final i1.b computeReflected() {
        r.f2790a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (getName().equals(gVar.getName()) && getSignature().equals(gVar.getSignature()) && this.f2784d == gVar.f2784d && this.f2783c == gVar.f2783c && h.a(getBoundReceiver(), gVar.getBoundReceiver()) && h.a(getOwner(), gVar.getOwner())) {
                    return true;
                }
                return false;
            }
            if (obj instanceof i1.e) {
                return obj.equals(compute());
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.jvm.internal.f
    public final int getArity() {
        return this.f2783c;
    }

    @Override // kotlin.jvm.internal.b
    public final i1.b getReflected() {
        return (i1.e) super.getReflected();
    }

    public final int hashCode() {
        int hashCode;
        if (getOwner() == null) {
            hashCode = 0;
        } else {
            hashCode = getOwner().hashCode() * 31;
        }
        return getSignature().hashCode() + ((getName().hashCode() + hashCode) * 31);
    }

    @Override // kotlin.jvm.internal.b, i1.b
    public final boolean isSuspend() {
        return ((g) ((i1.e) super.getReflected())).isSuspend();
    }

    public final String toString() {
        i1.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public g(int i2, Object obj, Class cls, String str, String str2, int i3, int i4) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f2783c = i2;
        this.f2784d = 0;
    }
}
