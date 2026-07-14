package o0;

import A0.g;
import R0.r;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.h;
import o0.k;

/* loaded from: classes.dex */
public final class k implements a {

    /* renamed from: a, reason: collision with root package name */
    public final SidecarInterface f3380a;

    /* renamed from: b, reason: collision with root package name */
    public final g f3381b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3382c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3383d;

    /* renamed from: e, reason: collision with root package name */
    public A0.g f3384e;

    public k(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        SidecarInterface a2 = i.a(context);
        g gVar = new g();
        this.f3380a = a2;
        this.f3381b = gVar;
        this.f3382c = new LinkedHashMap();
        this.f3383d = new LinkedHashMap();
    }

    public final l0.k a(Activity activity) {
        IBinder iBinder;
        SidecarDeviceState sidecarDeviceState;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
        if (window != null && (attributes = window.getAttributes()) != null) {
            iBinder = attributes.token;
        } else {
            iBinder = null;
        }
        if (iBinder == null) {
            return new l0.k(r.f750c);
        }
        SidecarInterface sidecarInterface = this.f3380a;
        if (sidecarInterface != null) {
            sidecarWindowLayoutInfo = sidecarInterface.getWindowLayoutInfo(iBinder);
        }
        SidecarInterface sidecarInterface2 = this.f3380a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return this.f3381b.d(sidecarWindowLayoutInfo, sidecarDeviceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Activity activity) {
        IBinder iBinder;
        boolean z;
        SidecarInterface sidecarInterface;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            iBinder = attributes.token;
        } else {
            iBinder = null;
        }
        if (iBinder != null) {
            SidecarInterface sidecarInterface2 = this.f3380a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinder);
            }
            LinkedHashMap linkedHashMap = this.f3383d;
            D.a aVar = (D.a) linkedHashMap.get(activity);
            if (aVar != null) {
                if (activity instanceof v.d) {
                    ((v.d) activity).removeOnConfigurationChangedListener(aVar);
                }
                linkedHashMap.remove(activity);
            }
            A0.g gVar = this.f3384e;
            if (gVar != null) {
                ReentrantLock reentrantLock = (ReentrantLock) gVar.f31e;
                reentrantLock.lock();
                try {
                    ((WeakHashMap) gVar.f32f).put(activity, null);
                } finally {
                    reentrantLock.unlock();
                }
            }
            LinkedHashMap linkedHashMap2 = this.f3382c;
            if (linkedHashMap2.size() == 1) {
                z = true;
            } else {
                z = false;
            }
            linkedHashMap2.remove(iBinder);
            if (z && (sidecarInterface = this.f3380a) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(IBinder iBinder, final Activity activity) {
        SidecarInterface sidecarInterface;
        LinkedHashMap linkedHashMap = this.f3382c;
        linkedHashMap.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f3380a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (linkedHashMap.size() == 1 && (sidecarInterface = this.f3380a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        A0.g gVar = this.f3384e;
        if (gVar != null) {
            gVar.j(activity, a(activity));
        }
        LinkedHashMap linkedHashMap2 = this.f3383d;
        if (linkedHashMap2.get(activity) == null && (activity instanceof v.d)) {
            D.a aVar = new D.a() { // from class: o0.h
                @Override // D.a
                public final void accept(Object obj) {
                    k this$0 = k.this;
                    kotlin.jvm.internal.h.e(this$0, "this$0");
                    Activity activity2 = activity;
                    kotlin.jvm.internal.h.e(activity2, "$activity");
                    A0.g gVar2 = this$0.f3384e;
                    if (gVar2 != null) {
                        gVar2.j(activity2, this$0.a(activity2));
                    }
                }
            };
            linkedHashMap2.put(activity, aVar);
            ((v.d) activity).addOnConfigurationChangedListener(aVar);
        }
    }

    public final void d(F.h hVar) {
        this.f3384e = new A0.g(hVar, (byte) 0);
        SidecarInterface sidecarInterface = this.f3380a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f3381b, new SidecarInterface.SidecarCallback() { // from class: androidx.window.layout.adapter.sidecar.SidecarCompat$TranslatingCallback
                public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
                    IBinder iBinder;
                    SidecarInterface sidecarInterface2;
                    Window window;
                    WindowManager.LayoutParams attributes;
                    h.e(newDeviceState, "newDeviceState");
                    Collection<Activity> values = k.this.f3382c.values();
                    k kVar = k.this;
                    for (Activity activity : values) {
                        SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                            iBinder = attributes.token;
                        } else {
                            iBinder = null;
                        }
                        if (iBinder != null && (sidecarInterface2 = kVar.f3380a) != null) {
                            sidecarWindowLayoutInfo = sidecarInterface2.getWindowLayoutInfo(iBinder);
                        }
                        g gVar = kVar.f3384e;
                        if (gVar != null) {
                            gVar.j(activity, kVar.f3381b.d(sidecarWindowLayoutInfo, newDeviceState));
                        }
                    }
                }

                public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
                    SidecarDeviceState sidecarDeviceState;
                    h.e(windowToken, "windowToken");
                    h.e(newLayout, "newLayout");
                    Activity activity = (Activity) k.this.f3382c.get(windowToken);
                    if (activity == null) {
                        Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                        return;
                    }
                    k kVar = k.this;
                    o0.g gVar = kVar.f3381b;
                    SidecarInterface sidecarInterface2 = kVar.f3380a;
                    if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
                        sidecarDeviceState = new SidecarDeviceState();
                    }
                    l0.k d2 = gVar.d(newLayout, sidecarDeviceState);
                    g gVar2 = k.this.f3384e;
                    if (gVar2 != null) {
                        gVar2.j(activity, d2);
                    }
                }
            }));
        }
    }

    public final boolean e() {
        Method method;
        Class<?> cls;
        Method method2;
        Class<?> cls2;
        Method method3;
        Class<?> cls3;
        Method method4;
        Class<?> cls4;
        Class<?> cls5;
        Class<?> cls6;
        Class<?> cls7;
        Class<?> cls8;
        try {
            SidecarInterface sidecarInterface = this.f3380a;
            if (sidecarInterface != null && (cls8 = sidecarInterface.getClass()) != null) {
                method = cls8.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            } else {
                method = null;
            }
            if (method != null) {
                cls = method.getReturnType();
            } else {
                cls = null;
            }
            Class cls9 = Void.TYPE;
            if (kotlin.jvm.internal.h.a(cls, cls9)) {
                SidecarInterface sidecarInterface2 = this.f3380a;
                if (sidecarInterface2 != null) {
                    sidecarInterface2.getDeviceState();
                }
                SidecarInterface sidecarInterface3 = this.f3380a;
                if (sidecarInterface3 != null) {
                    sidecarInterface3.onDeviceStateListenersChanged(true);
                }
                SidecarInterface sidecarInterface4 = this.f3380a;
                if (sidecarInterface4 != null && (cls7 = sidecarInterface4.getClass()) != null) {
                    method2 = cls7.getMethod("getWindowLayoutInfo", IBinder.class);
                } else {
                    method2 = null;
                }
                if (method2 != null) {
                    cls2 = method2.getReturnType();
                } else {
                    cls2 = null;
                }
                if (kotlin.jvm.internal.h.a(cls2, SidecarWindowLayoutInfo.class)) {
                    SidecarInterface sidecarInterface5 = this.f3380a;
                    if (sidecarInterface5 != null && (cls6 = sidecarInterface5.getClass()) != null) {
                        method3 = cls6.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
                    } else {
                        method3 = null;
                    }
                    if (method3 != null) {
                        cls3 = method3.getReturnType();
                    } else {
                        cls3 = null;
                    }
                    if (kotlin.jvm.internal.h.a(cls3, cls9)) {
                        SidecarInterface sidecarInterface6 = this.f3380a;
                        if (sidecarInterface6 != null && (cls5 = sidecarInterface6.getClass()) != null) {
                            method4 = cls5.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
                        } else {
                            method4 = null;
                        }
                        if (method4 != null) {
                            cls4 = method4.getReturnType();
                        } else {
                            cls4 = null;
                        }
                        if (kotlin.jvm.internal.h.a(cls4, cls9)) {
                            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
                            try {
                                sidecarDeviceState.posture = 3;
                            } catch (NoSuchFieldError unused) {
                                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                                Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                                kotlin.jvm.internal.h.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                                if (((Integer) invoke).intValue() != 3) {
                                    throw new Exception("Invalid device posture getter/setter");
                                }
                            }
                            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
                            Rect rect = sidecarDisplayFeature.getRect();
                            kotlin.jvm.internal.h.d(rect, "displayFeature.rect");
                            sidecarDisplayFeature.setRect(rect);
                            sidecarDisplayFeature.getType();
                            sidecarDisplayFeature.setType(1);
                            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
                            try {
                                List list = sidecarWindowLayoutInfo.displayFeatures;
                                return true;
                            } catch (NoSuchFieldError unused2) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(sidecarDisplayFeature);
                                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                                Object invoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                                kotlin.jvm.internal.h.c(invoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                                if (arrayList.equals((List) invoke2)) {
                                    return true;
                                }
                                throw new Exception("Invalid display feature getter/setter");
                            }
                        }
                        throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + cls4);
                    }
                    throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + cls3);
                }
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + cls2);
            }
            throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + cls);
        } catch (Throwable unused3) {
            return false;
        }
    }
}
