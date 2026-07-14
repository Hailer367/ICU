package l1;

/* loaded from: classes.dex */
public abstract class H extends AbstractC0240s {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2955h = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f2956e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2957f;

    /* renamed from: g, reason: collision with root package name */
    public R0.h f2958g;

    public final void i(boolean z) {
        long j2;
        long j3 = this.f2956e;
        if (z) {
            j2 = 4294967296L;
        } else {
            j2 = 1;
        }
        long j4 = j3 - j2;
        this.f2956e = j4;
        if (j4 <= 0 && this.f2957f) {
            shutdown();
        }
    }

    public abstract Thread j();

    public final void l(boolean z) {
        long j2;
        long j3 = this.f2956e;
        if (z) {
            j2 = 4294967296L;
        } else {
            j2 = 1;
        }
        this.f2956e = j2 + j3;
        if (!z) {
            this.f2957f = true;
        }
    }

    public abstract long m();

    public final boolean n() {
        Object removeFirst;
        R0.h hVar = this.f2958g;
        if (hVar == null) {
            return false;
        }
        if (hVar.isEmpty()) {
            removeFirst = null;
        } else {
            removeFirst = hVar.removeFirst();
        }
        B b2 = (B) removeFirst;
        if (b2 == null) {
            return false;
        }
        b2.run();
        return true;
    }

    public abstract void shutdown();
}
