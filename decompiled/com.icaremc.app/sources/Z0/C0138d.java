package Z0;

import a1.AbstractC0142a;
import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;

/* renamed from: Z0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0138d extends AbstractC0142a {
    public static final Parcelable.Creator<C0138d> CREATOR = new L.g(15);

    /* renamed from: t, reason: collision with root package name */
    public static final Scope[] f2116t = new Scope[0];

    /* renamed from: u, reason: collision with root package name */
    public static final W0.c[] f2117u = new W0.c[0];

    /* renamed from: f, reason: collision with root package name */
    public final int f2118f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2119g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2120h;

    /* renamed from: i, reason: collision with root package name */
    public String f2121i;

    /* renamed from: j, reason: collision with root package name */
    public IBinder f2122j;
    public Scope[] k;

    /* renamed from: l, reason: collision with root package name */
    public Bundle f2123l;

    /* renamed from: m, reason: collision with root package name */
    public Account f2124m;

    /* renamed from: n, reason: collision with root package name */
    public W0.c[] f2125n;

    /* renamed from: o, reason: collision with root package name */
    public W0.c[] f2126o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f2127p;

    /* renamed from: q, reason: collision with root package name */
    public final int f2128q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2129r;

    /* renamed from: s, reason: collision with root package name */
    public final String f2130s;

    public C0138d(int i4, int i5, int i6, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, W0.c[] cVarArr, W0.c[] cVarArr2, boolean z, int i7, boolean z3, String str2) {
        scopeArr = scopeArr == null ? f2116t : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        W0.c[] cVarArr3 = f2117u;
        cVarArr = cVarArr == null ? cVarArr3 : cVarArr;
        cVarArr2 = cVarArr2 == null ? cVarArr3 : cVarArr2;
        this.f2118f = i4;
        this.f2119g = i5;
        this.f2120h = i6;
        if ("com.google.android.gms".equals(str)) {
            this.f2121i = "com.google.android.gms";
        } else {
            this.f2121i = str;
        }
        if (i4 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i8 = AbstractBinderC0135a.f2110g;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                InterfaceC0139e e4 = queryLocalInterface instanceof InterfaceC0139e ? (InterfaceC0139e) queryLocalInterface : new E(iBinder);
                if (e4 != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            account2 = ((E) e4).a();
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                        }
                    } finally {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            }
            this.f2124m = account2;
        } else {
            this.f2122j = iBinder;
            this.f2124m = account;
        }
        this.k = scopeArr;
        this.f2123l = bundle;
        this.f2125n = cVarArr;
        this.f2126o = cVarArr2;
        this.f2127p = z;
        this.f2128q = i7;
        this.f2129r = z3;
        this.f2130s = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        L.g.a(this, parcel, i4);
    }
}
