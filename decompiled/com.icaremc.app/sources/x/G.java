package x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import c.AbstractBinderC0252b;
import c.InterfaceC0253c;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class G implements Handler.Callback, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6319a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f6320b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6321c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public HashSet f6322d = new HashSet();

    public G(Context context) {
        this.f6319a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f6320b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(F f4) {
        boolean z;
        ComponentName componentName = f4.f6314a;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + f4.f6317d.size() + " queued tasks");
        }
        ArrayDeque arrayDeque = f4.f6317d;
        if (!arrayDeque.isEmpty()) {
            if (f4.f6315b) {
                z = true;
            } else {
                Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
                Context context = this.f6319a;
                boolean bindService = context.bindService(component, this, 33);
                f4.f6315b = bindService;
                if (bindService) {
                    f4.f6318e = 0;
                } else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                    context.unbindService(this);
                }
                z = f4.f6315b;
            }
            if (z && f4.f6316c != null) {
                while (true) {
                    D d4 = (D) arrayDeque.peek();
                    if (d4 == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + d4);
                        }
                        d4.a(f4.f6316c);
                        arrayDeque.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + componentName);
                        }
                    } catch (RemoteException e4) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e4);
                    }
                }
                if (!arrayDeque.isEmpty()) {
                    b(f4);
                    return;
                }
                return;
            }
            b(f4);
        }
    }

    public final void b(F f4) {
        ComponentName componentName = f4.f6314a;
        ArrayDeque arrayDeque = f4.f6317d;
        Handler handler = this.f6320b;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i4 = f4.f6318e;
        int i5 = i4 + 1;
        f4.f6318e = i5;
        if (i5 > 6) {
            Log.w("NotifManCompat", "Giving up on delivering " + arrayDeque.size() + " tasks to " + componentName + " after " + f4.f6318e + " retries");
            arrayDeque.clear();
            return;
        }
        int i6 = (1 << i4) * 1000;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + i6 + " ms");
        }
        handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i6);
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [c.a, java.lang.Object] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i4 = message.what;
        InterfaceC0253c interfaceC0253c = null;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return false;
                    }
                    F f4 = (F) this.f6321c.get((ComponentName) message.obj);
                    if (f4 != null) {
                        a(f4);
                        return true;
                    }
                } else {
                    F f5 = (F) this.f6321c.get((ComponentName) message.obj);
                    if (f5 != null) {
                        if (f5.f6315b) {
                            this.f6319a.unbindService(this);
                            f5.f6315b = false;
                        }
                        f5.f6316c = null;
                        return true;
                    }
                }
            } else {
                E e4 = (E) message.obj;
                ComponentName componentName = e4.f6312a;
                IBinder iBinder = e4.f6313b;
                F f6 = (F) this.f6321c.get(componentName);
                if (f6 != null) {
                    int i5 = AbstractBinderC0252b.f3314f;
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface(InterfaceC0253c.f3315d);
                        if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC0253c)) {
                            interfaceC0253c = (InterfaceC0253c) queryLocalInterface;
                        } else {
                            ?? obj = new Object();
                            obj.f3313f = iBinder;
                            interfaceC0253c = obj;
                        }
                    }
                    f6.f6316c = interfaceC0253c;
                    f6.f6318e = 0;
                    a(f6);
                    return true;
                }
            }
        } else {
            D d4 = (D) message.obj;
            String string = Settings.Secure.getString(this.f6319a.getContentResolver(), "enabled_notification_listeners");
            synchronized (H.f6323c) {
                if (string != null) {
                    try {
                        if (!string.equals(H.f6324d)) {
                            String[] split = string.split(":", -1);
                            HashSet hashSet2 = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet2.add(unflattenFromString.getPackageName());
                                }
                            }
                            H.f6325e = hashSet2;
                            H.f6324d = string;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                hashSet = H.f6325e;
            }
            if (!hashSet.equals(this.f6322d)) {
                this.f6322d = hashSet;
                List<ResolveInfo> queryIntentServices = this.f6319a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet hashSet3 = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName2 = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName2 + ", not adding listener record.");
                        } else {
                            hashSet3.add(componentName2);
                        }
                    }
                }
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    ComponentName componentName3 = (ComponentName) it.next();
                    if (!this.f6321c.containsKey(componentName3)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName3);
                        }
                        this.f6321c.put(componentName3, new F(componentName3));
                    }
                }
                Iterator it2 = this.f6321c.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!hashSet3.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        F f7 = (F) entry.getValue();
                        if (f7.f6315b) {
                            this.f6319a.unbindService(this);
                            f7.f6315b = false;
                        }
                        f7.f6316c = null;
                        it2.remove();
                    }
                }
            }
            for (F f8 : this.f6321c.values()) {
                f8.f6317d.add(d4);
                a(f8);
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f6320b.obtainMessage(1, new E(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f6320b.obtainMessage(2, componentName).sendToTarget();
    }
}
