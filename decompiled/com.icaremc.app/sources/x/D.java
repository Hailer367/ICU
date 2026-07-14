package x;

import android.app.Notification;
import android.os.Parcel;
import c.C0251a;
import c.InterfaceC0253c;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final String f6308a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6309b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6310c;

    /* renamed from: d, reason: collision with root package name */
    public final Notification f6311d;

    public D(String str, int i4, String str2, Notification notification) {
        this.f6308a = str;
        this.f6309b = i4;
        this.f6310c = str2;
        this.f6311d = notification;
    }

    public final void a(InterfaceC0253c interfaceC0253c) {
        String str = this.f6308a;
        int i4 = this.f6309b;
        String str2 = this.f6310c;
        Notification notification = this.f6311d;
        C0251a c0251a = (C0251a) interfaceC0253c;
        c0251a.getClass();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0253c.f3315d);
            obtain.writeString(str);
            obtain.writeInt(i4);
            obtain.writeString(str2);
            obtain.writeTypedObject(notification, 0);
            c0251a.f3313f.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
        sb.append(this.f6308a);
        sb.append(", id:");
        sb.append(this.f6309b);
        sb.append(", tag:");
        return r2.k.c(sb, this.f6310c, "]");
    }
}
