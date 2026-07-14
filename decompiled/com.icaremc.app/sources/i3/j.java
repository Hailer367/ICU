package i3;

import b3.AbstractC0245u;

/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f4179h;

    public j(Runnable runnable, long j4, boolean z) {
        super(j4, z);
        this.f4179h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4179h.run();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f4179h;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC0245u.b(runnable));
        sb.append(", ");
        sb.append(this.f4177f);
        sb.append(", ");
        if (this.f4178g) {
            str = "Blocking";
        } else {
            str = "Non-blocking";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
