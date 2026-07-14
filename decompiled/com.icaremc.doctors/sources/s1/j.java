package s1;

import l1.AbstractC0244w;

/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f3622e;

    public j(Runnable runnable, long j2, boolean z) {
        super(j2, z);
        this.f3622e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3622e.run();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f3622e;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC0244w.b(runnable));
        sb.append(", ");
        sb.append(this.f3620c);
        sb.append(", ");
        if (this.f3621d) {
            str = "Blocking";
        } else {
            str = "Non-blocking";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
