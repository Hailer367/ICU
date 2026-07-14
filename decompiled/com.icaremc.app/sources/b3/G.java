package b3;

/* loaded from: classes.dex */
public abstract class G extends AbstractC0242q {
    public static final /* synthetic */ int k = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f3242h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3243i;

    /* renamed from: j, reason: collision with root package name */
    public I2.c f3244j;

    public final void h(boolean z) {
        long j4;
        long j5 = this.f3242h;
        if (z) {
            j4 = 4294967296L;
        } else {
            j4 = 1;
        }
        long j6 = j5 - j4;
        this.f3242h = j6;
        if (j6 <= 0 && this.f3243i) {
            shutdown();
        }
    }

    public abstract Thread i();

    public final void l(boolean z) {
        long j4;
        long j5 = this.f3242h;
        if (z) {
            j4 = 4294967296L;
        } else {
            j4 = 1;
        }
        this.f3242h = j4 + j5;
        if (!z) {
            this.f3243i = true;
        }
    }

    public abstract long m();

    public final boolean n() {
        Object removeFirst;
        I2.c cVar = this.f3244j;
        if (cVar == null) {
            return false;
        }
        if (cVar.isEmpty()) {
            removeFirst = null;
        } else {
            removeFirst = cVar.removeFirst();
        }
        AbstractC0250z abstractC0250z = (AbstractC0250z) removeFirst;
        if (abstractC0250z == null) {
            return false;
        }
        abstractC0250z.run();
        return true;
    }

    public abstract void shutdown();
}
