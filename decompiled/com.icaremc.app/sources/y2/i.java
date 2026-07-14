package y2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class i extends o {

    /* renamed from: d, reason: collision with root package name */
    public final Context f6615d;

    /* renamed from: e, reason: collision with root package name */
    public final PowerManager.WakeLock f6616e;

    /* renamed from: f, reason: collision with root package name */
    public final PowerManager.WakeLock f6617f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6618g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6619h;

    public i(Context context, ComponentName componentName) {
        super(componentName);
        this.f6615d = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.f6616e = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f6617f = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // y2.o
    public final void a(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.f6630a);
        if (this.f6615d.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.f6618g) {
                        this.f6618g = true;
                        if (!this.f6619h) {
                            this.f6616e.acquire(60000L);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // y2.o
    public final void c() {
        synchronized (this) {
            try {
                if (this.f6619h) {
                    if (this.f6618g) {
                        this.f6616e.acquire(60000L);
                    }
                    this.f6619h = false;
                    this.f6617f.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y2.o
    public final void d() {
        synchronized (this) {
            try {
                if (!this.f6619h) {
                    this.f6619h = true;
                    this.f6617f.acquire(600000L);
                    this.f6616e.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y2.o
    public final void e() {
        synchronized (this) {
            this.f6618g = false;
        }
    }
}
