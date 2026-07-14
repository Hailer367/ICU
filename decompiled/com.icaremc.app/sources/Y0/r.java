package Y0;

import a.AbstractC0141a;
import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import h1.AbstractC0337b;
import h1.HandlerC0340e;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import m1.AbstractC0442b;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class r extends j1.g implements X0.f, X0.g {

    /* renamed from: n, reason: collision with root package name */
    public static final b1.d f2069n = AbstractC0442b.f5189a;

    /* renamed from: g, reason: collision with root package name */
    public final Context f2070g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f2071h;

    /* renamed from: i, reason: collision with root package name */
    public final b1.d f2072i;

    /* renamed from: j, reason: collision with root package name */
    public final Set f2073j;
    public final I0.h k;

    /* renamed from: l, reason: collision with root package name */
    public n1.a f2074l;

    /* renamed from: m, reason: collision with root package name */
    public m f2075m;

    public r(Context context, HandlerC0340e handlerC0340e, I0.h hVar) {
        super(1);
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.f2070g = context;
        this.f2071h = handlerC0340e;
        this.k = hVar;
        this.f2073j = (Set) hVar.f821c;
        this.f2072i = f2069n;
    }

    @Override // X0.g
    public final void a(W0.a aVar) {
        this.f2075m.a(aVar);
    }

    @Override // X0.f
    public final void d(int i4) {
        m mVar = this.f2075m;
        k kVar = (k) mVar.k.f2039j.get(mVar.f2061g);
        if (kVar != null) {
            if (kVar.f2054n) {
                kVar.m(new W0.a(17, null, null));
            } else {
                kVar.d(i4);
            }
        }
    }

    @Override // X0.f
    public final void f() {
        GoogleSignInAccount googleSignInAccount;
        Parcel obtain;
        Parcel obtain2;
        n1.a aVar = this.f2074l;
        aVar.getClass();
        try {
            aVar.f5371A.getClass();
            Account account = new Account("<<default account>>", "com.google");
            try {
                if ("<<default account>>".equals(account.name)) {
                    Context context = aVar.f3373c;
                    ReentrantLock reentrantLock = U0.a.f1647c;
                    Z0.r.e(context);
                    ReentrantLock reentrantLock2 = U0.a.f1647c;
                    reentrantLock2.lock();
                    try {
                        if (U0.a.f1648d == null) {
                            U0.a.f1648d = new U0.a(context.getApplicationContext());
                        }
                        U0.a aVar2 = U0.a.f1648d;
                        reentrantLock2.unlock();
                        String a4 = aVar2.a("defaultGoogleSignInAccount");
                        if (!TextUtils.isEmpty(a4)) {
                            StringBuilder sb = new StringBuilder(20 + String.valueOf(a4).length());
                            sb.append("googleSignInAccount:");
                            sb.append(a4);
                            String a5 = aVar2.a(sb.toString());
                            if (a5 != null) {
                                try {
                                    googleSignInAccount = GoogleSignInAccount.a(a5);
                                } catch (JSONException unused) {
                                }
                                Integer num = aVar.f5373C;
                                Z0.r.e(num);
                                Z0.n nVar = new Z0.n(2, account, num.intValue(), googleSignInAccount);
                                n1.c cVar = (n1.c) aVar.i();
                                obtain = Parcel.obtain();
                                obtain.writeInterfaceToken(cVar.f3942g);
                                int i4 = AbstractC0337b.f3943a;
                                obtain.writeInt(1);
                                int Q2 = AbstractC0141a.Q(obtain, 20293);
                                AbstractC0141a.P(obtain, 1, 4);
                                obtain.writeInt(1);
                                AbstractC0141a.L(obtain, 2, nVar, 0);
                                AbstractC0141a.S(obtain, Q2);
                                obtain.writeStrongBinder(this);
                                obtain2 = Parcel.obtain();
                                cVar.f3941f.transact(12, obtain, obtain2, 0);
                                obtain2.readException();
                                obtain.recycle();
                                obtain2.recycle();
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLock2.unlock();
                        throw th;
                    }
                }
                cVar.f3941f.transact(12, obtain, obtain2, 0);
                obtain2.readException();
                obtain.recycle();
                obtain2.recycle();
                return;
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                throw th2;
            }
            googleSignInAccount = null;
            Integer num2 = aVar.f5373C;
            Z0.r.e(num2);
            Z0.n nVar2 = new Z0.n(2, account, num2.intValue(), googleSignInAccount);
            n1.c cVar2 = (n1.c) aVar.i();
            obtain = Parcel.obtain();
            obtain.writeInterfaceToken(cVar2.f3942g);
            int i42 = AbstractC0337b.f3943a;
            obtain.writeInt(1);
            int Q22 = AbstractC0141a.Q(obtain, 20293);
            AbstractC0141a.P(obtain, 1, 4);
            obtain.writeInt(1);
            AbstractC0141a.L(obtain, 2, nVar2, 0);
            AbstractC0141a.S(obtain, Q22);
            obtain.writeStrongBinder(this);
            obtain2 = Parcel.obtain();
        } catch (RemoteException e4) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.f2071h.post(new F.a(5, this, new n1.e(1, new W0.a(8, null, null), null), false));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e4);
            }
        }
    }
}
