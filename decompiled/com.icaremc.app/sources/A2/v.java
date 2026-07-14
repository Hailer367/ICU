package A2;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0212t;

/* loaded from: classes.dex */
public final class v implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

    /* renamed from: f, reason: collision with root package name */
    public final Activity f113f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w f114g;

    public v(w wVar, Activity activity) {
        this.f114g = wVar;
        this.f113f = activity;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void b(InterfaceC0212t interfaceC0212t) {
        onActivityDestroyed(this.f113f);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void g(InterfaceC0212t interfaceC0212t) {
        onActivityStopped(this.f113f);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f113f == activity && activity.getApplicationContext() != null) {
            ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int i4;
        if (this.f113f == activity) {
            u uVar = (u) this.f114g.f116g.f5416h;
            synchronized (uVar.f112q) {
                try {
                    t tVar = uVar.f111p;
                    if (tVar == null) {
                        return;
                    }
                    y yVar = (y) tVar.f99g;
                    l lVar = uVar.f105i;
                    if (yVar != null) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    lVar.getClass();
                    int b4 = R.i.b(i4);
                    if (b4 != 0) {
                        if (b4 == 1) {
                            lVar.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_type", "video").apply();
                        }
                    } else {
                        lVar.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_type", "image").apply();
                    }
                    if (yVar != null) {
                        SharedPreferences.Editor edit = uVar.f105i.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
                        Double d4 = yVar.f118a;
                        if (d4 != null) {
                            edit.putLong("flutter_image_picker_max_width", Double.doubleToRawLongBits(d4.doubleValue()));
                        }
                        Double d5 = yVar.f119b;
                        if (d5 != null) {
                            edit.putLong("flutter_image_picker_max_height", Double.doubleToRawLongBits(d5.doubleValue()));
                        }
                        edit.putInt("flutter_image_picker_image_quality", (int) yVar.f120c);
                        edit.apply();
                    }
                    Uri uri = uVar.f110o;
                    if (uri != null) {
                        uVar.f105i.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_pending_image_uri", uri.getPath()).apply();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void a(InterfaceC0212t interfaceC0212t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void c(InterfaceC0212t interfaceC0212t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void e(InterfaceC0212t interfaceC0212t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void f(InterfaceC0212t interfaceC0212t) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
