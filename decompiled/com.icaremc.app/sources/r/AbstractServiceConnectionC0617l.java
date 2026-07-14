package r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import b.AbstractBinderC0220c;
import b.InterfaceC0221d;

/* renamed from: r.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractServiceConnectionC0617l implements ServiceConnection {
    private Context mApplicationContext;

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, AbstractC0613h abstractC0613h);

    /* JADX WARN: Type inference failed for: r1v3, types: [b.b, java.lang.Object] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC0221d interfaceC0221d;
        if (this.mApplicationContext != null) {
            int i4 = AbstractBinderC0220c.f3201f;
            if (iBinder == null) {
                interfaceC0221d = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(InterfaceC0221d.f3202b);
                if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC0221d)) {
                    interfaceC0221d = (InterfaceC0221d) queryLocalInterface;
                } else {
                    ?? obj = new Object();
                    obj.f3200f = iBinder;
                    interfaceC0221d = obj;
                }
            }
            onCustomTabsServiceConnected(componentName, new AbstractC0613h(interfaceC0221d, componentName));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}
