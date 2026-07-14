package Z0;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import h1.HandlerC0340e;

/* loaded from: classes.dex */
public final class u extends HandlerC0340e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f2180a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(com.google.android.gms.common.internal.a aVar, Looper looper) {
        super(looper, 2);
        this.f2180a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        p pVar;
        com.google.android.gms.common.internal.a aVar = this.f2180a;
        if (aVar.f3392w.get() != message.arg1) {
            int i4 = message.what;
            if ((i4 == 2 || i4 == 1 || i4 == 7) && (pVar = (p) message.obj) != null) {
                synchronized (pVar) {
                    pVar.f2168a = null;
                }
                com.google.android.gms.common.internal.a aVar2 = pVar.f2170c;
                synchronized (aVar2.k) {
                    aVar2.k.remove(pVar);
                }
                return;
            }
            return;
        }
        int i5 = message.what;
        if ((i5 != 1 && i5 != 7 && i5 != 4 && i5 != 5) || aVar.n()) {
            int i6 = message.what;
            if (i6 == 4) {
                aVar.f3389t = new W0.a(message.arg2, null, null);
                if (!aVar.f3390u && !TextUtils.isEmpty(aVar.j()) && !TextUtils.isEmpty(null)) {
                    try {
                        Class.forName(aVar.j());
                        if (!aVar.f3390u) {
                            aVar.p(3, null);
                            return;
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
                W0.a aVar3 = aVar.f3389t;
                if (aVar3 == null) {
                    aVar3 = new W0.a(8, null, null);
                }
                aVar.f3379i.b(aVar3);
                System.currentTimeMillis();
                return;
            }
            if (i6 == 5) {
                W0.a aVar4 = aVar.f3389t;
                if (aVar4 == null) {
                    aVar4 = new W0.a(8, null, null);
                }
                aVar.f3379i.b(aVar4);
                System.currentTimeMillis();
                return;
            }
            if (i6 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent2 = (PendingIntent) obj;
                } else {
                    pendingIntent2 = null;
                }
                aVar.f3379i.b(new W0.a(message.arg2, pendingIntent2, null));
                System.currentTimeMillis();
                return;
            }
            if (i6 == 6) {
                aVar.p(5, null);
                A2.q qVar = aVar.f3383n;
                if (qVar != null) {
                    ((X0.f) qVar.f93g).d(message.arg2);
                }
                System.currentTimeMillis();
                aVar.o(5, 1, null);
                return;
            }
            if (i6 == 2 && !aVar.m()) {
                p pVar2 = (p) message.obj;
                if (pVar2 != null) {
                    synchronized (pVar2) {
                        pVar2.f2168a = null;
                    }
                    com.google.android.gms.common.internal.a aVar5 = pVar2.f2170c;
                    synchronized (aVar5.k) {
                        aVar5.k.remove(pVar2);
                    }
                    return;
                }
                return;
            }
            int i7 = message.what;
            if (i7 != 2 && i7 != 1 && i7 != 7) {
                StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 34);
                sb.append("Don't know how to handle message: ");
                sb.append(i7);
                Log.wtf("GmsClient", sb.toString(), new Exception());
                return;
            }
            p pVar3 = (p) message.obj;
            synchronized (pVar3) {
                try {
                    bool = pVar3.f2168a;
                    if (pVar3.f2169b) {
                        String obj2 = pVar3.toString();
                        StringBuilder sb2 = new StringBuilder(obj2.length() + 47);
                        sb2.append("Callback proxy ");
                        sb2.append(obj2);
                        sb2.append(" being reused. This is not safe.");
                        Log.w("GmsClient", sb2.toString());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                com.google.android.gms.common.internal.a aVar6 = pVar3.f2173f;
                int i8 = pVar3.f2171d;
                if (i8 == 0) {
                    if (!pVar3.a()) {
                        aVar6.p(1, null);
                        pVar3.b(new W0.a(8, null, null));
                    }
                } else {
                    aVar6.p(1, null);
                    Bundle bundle = pVar3.f2172e;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                    } else {
                        pendingIntent = null;
                    }
                    pVar3.b(new W0.a(i8, pendingIntent, null));
                }
            }
            synchronized (pVar3) {
                pVar3.f2169b = true;
            }
            synchronized (pVar3) {
                pVar3.f2168a = null;
            }
            com.google.android.gms.common.internal.a aVar7 = pVar3.f2170c;
            synchronized (aVar7.k) {
                aVar7.k.remove(pVar3);
            }
            return;
        }
        p pVar4 = (p) message.obj;
        if (pVar4 != null) {
            synchronized (pVar4) {
                pVar4.f2168a = null;
            }
            com.google.android.gms.common.internal.a aVar8 = pVar4.f2170c;
            synchronized (aVar8.k) {
                aVar8.k.remove(pVar4);
            }
        }
    }
}
