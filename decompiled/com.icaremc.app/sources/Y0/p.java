package Y0;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f2065a;

    public p(int i4) {
        this.f2065a = i4;
    }

    public static Status h(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract W0.c[] a(k kVar);

    public abstract boolean b(k kVar);

    public abstract int c(k kVar);

    public abstract void d(Status status);

    public abstract void e(Exception exc);

    public abstract void f(E0.a aVar, boolean z);

    public abstract void g(k kVar);
}
