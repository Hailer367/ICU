package u;

import android.app.Notification;
import android.os.Parcel;
import b.C0156a;
import b.InterfaceC0158c;

/* renamed from: u.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0309D {

    /* renamed from: a, reason: collision with root package name */
    public final String f3678a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3679b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3680c;

    /* renamed from: d, reason: collision with root package name */
    public final Notification f3681d;

    public C0309D(String str, int i2, String str2, Notification notification) {
        this.f3678a = str;
        this.f3679b = i2;
        this.f3680c = str2;
        this.f3681d = notification;
    }

    public final void a(InterfaceC0158c interfaceC0158c) {
        String str = this.f3678a;
        int i2 = this.f3679b;
        String str2 = this.f3680c;
        Notification notification = this.f3681d;
        C0156a c0156a = (C0156a) interfaceC0158c;
        c0156a.getClass();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0158c.f1969a);
            obtain.writeString(str);
            obtain.writeInt(i2);
            obtain.writeString(str2);
            obtain.writeTypedObject(notification, 0);
            c0156a.f1967c.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
        sb.append(this.f3678a);
        sb.append(", id:");
        sb.append(this.f3679b);
        sb.append(", tag:");
        return O.a.i(sb, this.f3680c, "]");
    }
}
