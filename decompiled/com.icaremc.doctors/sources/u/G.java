package u;

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
import b.AbstractBinderC0157b;
import b.InterfaceC0158c;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class G implements Handler.Callback, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3689a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3690b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3691c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public HashSet f3692d = new HashSet();

    public G(Context context) {
        this.f3689a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f3690b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(F f2) {
        boolean z;
        ComponentName componentName = f2.f3684a;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + f2.f3687d.size() + " queued tasks");
        }
        ArrayDeque arrayDeque = f2.f3687d;
        if (!arrayDeque.isEmpty()) {
            if (f2.f3685b) {
                z = true;
            } else {
                Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
                Context context = this.f3689a;
                boolean bindService = context.bindService(component, this, 33);
                f2.f3685b = bindService;
                if (bindService) {
                    f2.f3688e = 0;
                } else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                    context.unbindService(this);
                }
                z = f2.f3685b;
            }
            if (z && f2.f3686c != null) {
                while (true) {
                    C0309D c0309d = (C0309D) arrayDeque.peek();
                    if (c0309d == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + c0309d);
                        }
                        c0309d.a(f2.f3686c);
                        arrayDeque.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + componentName);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e2);
                    }
                }
                if (!arrayDeque.isEmpty()) {
                    b(f2);
                    return;
                }
                return;
            }
            b(f2);
        }
    }

    public final void b(F f2) {
        ComponentName componentName = f2.f3684a;
        ArrayDeque arrayDeque = f2.f3687d;
        Handler handler = this.f3690b;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i2 = f2.f3688e;
        int i3 = i2 + 1;
        f2.f3688e = i3;
        if (i3 > 6) {
            Log.w("NotifManCompat", "Giving up on delivering " + arrayDeque.size() + " tasks to " + componentName + " after " + f2.f3688e + " retries");
            arrayDeque.clear();
            return;
        }
        int i4 = (1 << i2) * 1000;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + i4 + " ms");
        }
        handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i4);
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [b.a, java.lang.Object] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i2 = message.what;
        InterfaceC0158c interfaceC0158c = null;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    F f2 = (F) this.f3691c.get((ComponentName) message.obj);
                    if (f2 != null) {
                        a(f2);
                        return true;
                    }
                } else {
                    F f3 = (F) this.f3691c.get((ComponentName) message.obj);
                    if (f3 != null) {
                        if (f3.f3685b) {
                            this.f3689a.unbindService(this);
                            f3.f3685b = false;
                        }
                        f3.f3686c = null;
                        return true;
                    }
                }
            } else {
                E e2 = (E) message.obj;
                ComponentName componentName = e2.f3682a;
                IBinder iBinder = e2.f3683b;
                F f4 = (F) this.f3691c.get(componentName);
                if (f4 != null) {
                    int i3 = AbstractBinderC0157b.f1968c;
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface(InterfaceC0158c.f1969a);
                        if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC0158c)) {
                            interfaceC0158c = (InterfaceC0158c) queryLocalInterface;
                        } else {
                            ?? obj = new Object();
                            obj.f1967c = iBinder;
                            interfaceC0158c = obj;
                        }
                    }
                    f4.f3686c = interfaceC0158c;
                    f4.f3688e = 0;
                    a(f4);
                    return true;
                }
            }
        } else {
            C0309D c0309d = (C0309D) message.obj;
            String string = Settings.Secure.getString(this.f3689a.getContentResolver(), "enabled_notification_listeners");
            synchronized (H.f3693c) {
                if (string != null) {
                    try {
                        if (!string.equals(H.f3694d)) {
                            String[] split = string.split(":", -1);
                            HashSet hashSet2 = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet2.add(unflattenFromString.getPackageName());
                                }
                            }
                            H.f3695e = hashSet2;
                            H.f3694d = string;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                hashSet = H.f3695e;
            }
            if (!hashSet.equals(this.f3692d)) {
                this.f3692d = hashSet;
                List<ResolveInfo> queryIntentServices = this.f3689a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                    if (!this.f3691c.containsKey(componentName3)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName3);
                        }
                        this.f3691c.put(componentName3, new F(componentName3));
                    }
                }
                Iterator it2 = this.f3691c.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!hashSet3.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        F f5 = (F) entry.getValue();
                        if (f5.f3685b) {
                            this.f3689a.unbindService(this);
                            f5.f3685b = false;
                        }
                        f5.f3686c = null;
                        it2.remove();
                    }
                }
            }
            for (F f6 : this.f3691c.values()) {
                f6.f3687d.add(c0309d);
                a(f6);
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f3690b.obtainMessage(1, new E(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f3690b.obtainMessage(2, componentName).sendToTarget();
    }
}
