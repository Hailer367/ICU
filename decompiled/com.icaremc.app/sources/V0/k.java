package V0;

import Z0.A;
import Z0.B;
import Z0.C;
import Z0.r;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1699a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1700b;

    public /* synthetic */ k(int i4, Object obj) {
        this.f1699a = i4;
        this.f1700b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Exception, P1.x] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Exception, P1.x] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f1699a) {
            case 0:
                int i4 = message.arg1;
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    Log.d("MessengerIpcClient", "Received response to request: " + i4);
                }
                l lVar = (l) this.f1700b;
                synchronized (lVar) {
                    try {
                        m mVar = (m) lVar.f1705e.get(i4);
                        if (mVar == 0) {
                            Log.w("MessengerIpcClient", "Received response for unknown request: " + i4);
                            return true;
                        }
                        lVar.f1705e.remove(i4);
                        lVar.c();
                        Bundle data = message.getData();
                        if (data.getBoolean("unsupported", false)) {
                            mVar.b(new Exception("Not supported by GmsCore", null));
                            return true;
                        }
                        switch (mVar.f1711e) {
                            case 0:
                                if (data.getBoolean("ack", false)) {
                                    mVar.c(null);
                                    return true;
                                }
                                mVar.b(new Exception("Invalid response to one way request", null));
                                return true;
                            default:
                                Bundle bundle = data.getBundle("data");
                                if (bundle == null) {
                                    bundle = Bundle.EMPTY;
                                }
                                mVar.c(bundle);
                                return true;
                        }
                    } finally {
                    }
                }
            default:
                int i5 = message.what;
                if (i5 != 0) {
                    if (i5 != 1) {
                        return false;
                    }
                    C c4 = (C) this.f1700b;
                    synchronized (c4.f2101a) {
                        try {
                            A a4 = (A) message.obj;
                            B b4 = (B) c4.f2101a.get(a4);
                            if (b4 != null && b4.f2092b == 3) {
                                String valueOf = String.valueOf(a4);
                                StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                                sb.append("Timeout waiting for ServiceConnection callback ");
                                sb.append(valueOf);
                                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                                ComponentName componentName = b4.f2096f;
                                if (componentName == null) {
                                    a4.getClass();
                                    componentName = null;
                                }
                                if (componentName == null) {
                                    String str = a4.f2089b;
                                    r.e(str);
                                    componentName = new ComponentName(str, "unknown");
                                }
                                b4.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                    }
                } else {
                    C c5 = (C) this.f1700b;
                    synchronized (c5.f2101a) {
                        try {
                            A a5 = (A) message.obj;
                            B b5 = (B) c5.f2101a.get(a5);
                            if (b5 != null && b5.f2091a.isEmpty()) {
                                if (b5.f2093c) {
                                    A a6 = b5.f2095e;
                                    C c6 = b5.f2097g;
                                    c6.f2103c.removeMessages(1, a6);
                                    c6.f2104d.b(c6.f2102b, b5);
                                    b5.f2093c = false;
                                    b5.f2092b = 2;
                                }
                                c5.f2101a.remove(a5);
                            }
                        } finally {
                        }
                    }
                }
                return true;
        }
    }
}
