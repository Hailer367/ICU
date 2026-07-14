package y0;

import A2.t;
import I2.m;
import T2.h;
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
import j.O;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import v0.C0687j;
import y.InterfaceC0728d;
import y0.C0735g;
import y0.C0738j;

/* renamed from: y0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0738j implements InterfaceC0729a {

    /* renamed from: a, reason: collision with root package name */
    public final SidecarInterface f6544a;

    /* renamed from: b, reason: collision with root package name */
    public final C0735g f6545b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f6546c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f6547d;

    /* renamed from: e, reason: collision with root package name */
    public t f6548e;

    public C0738j(Context context) {
        T2.h.e(context, "context");
        SidecarInterface a4 = AbstractC0737i.a(context);
        C0735g c0735g = new C0735g();
        this.f6544a = a4;
        this.f6545b = c0735g;
        this.f6546c = new LinkedHashMap();
        this.f6547d = new LinkedHashMap();
    }

    public final C0687j a(Activity activity) {
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
            return new C0687j(m.f862f);
        }
        SidecarInterface sidecarInterface = this.f6544a;
        if (sidecarInterface != null) {
            sidecarWindowLayoutInfo = sidecarInterface.getWindowLayoutInfo(iBinder);
        }
        SidecarInterface sidecarInterface2 = this.f6544a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return this.f6545b.d(sidecarWindowLayoutInfo, sidecarDeviceState);
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
            SidecarInterface sidecarInterface2 = this.f6544a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinder);
            }
            LinkedHashMap linkedHashMap = this.f6547d;
            H.a aVar = (H.a) linkedHashMap.get(activity);
            if (aVar != null) {
                if (activity instanceof InterfaceC0728d) {
                    ((InterfaceC0728d) activity).removeOnConfigurationChangedListener(aVar);
                }
                linkedHashMap.remove(activity);
            }
            t tVar = this.f6548e;
            if (tVar != null) {
                ReentrantLock reentrantLock = (ReentrantLock) tVar.f100h;
                reentrantLock.lock();
                try {
                    ((WeakHashMap) tVar.f101i).put(activity, null);
                } finally {
                    reentrantLock.unlock();
                }
            }
            LinkedHashMap linkedHashMap2 = this.f6546c;
            if (linkedHashMap2.size() == 1) {
                z = true;
            } else {
                z = false;
            }
            linkedHashMap2.remove(iBinder);
            if (z && (sidecarInterface = this.f6544a) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(IBinder iBinder, final Activity activity) {
        SidecarInterface sidecarInterface;
        LinkedHashMap linkedHashMap = this.f6546c;
        linkedHashMap.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f6544a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (linkedHashMap.size() == 1 && (sidecarInterface = this.f6544a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        t tVar = this.f6548e;
        if (tVar != null) {
            tVar.R(activity, a(activity));
        }
        LinkedHashMap linkedHashMap2 = this.f6547d;
        if (linkedHashMap2.get(activity) == null && (activity instanceof InterfaceC0728d)) {
            H.a aVar = new H.a() { // from class: y0.h
                @Override // H.a
                public final void accept(Object obj) {
                    C0738j c0738j = C0738j.this;
                    T2.h.e(c0738j, "this$0");
                    Activity activity2 = activity;
                    T2.h.e(activity2, "$activity");
                    t tVar2 = c0738j.f6548e;
                    if (tVar2 != null) {
                        tVar2.R(activity2, c0738j.a(activity2));
                    }
                }
            };
            linkedHashMap2.put(activity, aVar);
            ((InterfaceC0728d) activity).addOnConfigurationChangedListener(aVar);
        }
    }

    public final void d(O o3) {
        this.f6548e = new t(o3);
        SidecarInterface sidecarInterface = this.f6544a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f6545b, new SidecarInterface.SidecarCallback() { // from class: androidx.window.layout.adapter.sidecar.SidecarCompat$TranslatingCallback
                public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
                    IBinder iBinder;
                    SidecarInterface sidecarInterface2;
                    Window window;
                    WindowManager.LayoutParams attributes;
                    h.e(sidecarDeviceState, "newDeviceState");
                    Collection<Activity> values = C0738j.this.f6546c.values();
                    C0738j c0738j = C0738j.this;
                    for (Activity activity : values) {
                        SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                            iBinder = attributes.token;
                        } else {
                            iBinder = null;
                        }
                        if (iBinder != null && (sidecarInterface2 = c0738j.f6544a) != null) {
                            sidecarWindowLayoutInfo = sidecarInterface2.getWindowLayoutInfo(iBinder);
                        }
                        t tVar = c0738j.f6548e;
                        if (tVar != null) {
                            tVar.R(activity, c0738j.f6545b.d(sidecarWindowLayoutInfo, sidecarDeviceState));
                        }
                    }
                }

                public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
                    SidecarDeviceState sidecarDeviceState;
                    h.e(iBinder, "windowToken");
                    h.e(sidecarWindowLayoutInfo, "newLayout");
                    Activity activity = (Activity) C0738j.this.f6546c.get(iBinder);
                    if (activity == null) {
                        Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                        return;
                    }
                    C0738j c0738j = C0738j.this;
                    C0735g c0735g = c0738j.f6545b;
                    SidecarInterface sidecarInterface2 = c0738j.f6544a;
                    if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
                        sidecarDeviceState = new SidecarDeviceState();
                    }
                    C0687j d4 = c0735g.d(sidecarWindowLayoutInfo, sidecarDeviceState);
                    t tVar = C0738j.this.f6548e;
                    if (tVar != null) {
                        tVar.R(activity, d4);
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
            SidecarInterface sidecarInterface = this.f6544a;
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
            if (T2.h.a(cls, cls9)) {
                SidecarInterface sidecarInterface2 = this.f6544a;
                if (sidecarInterface2 != null) {
                    sidecarInterface2.getDeviceState();
                }
                SidecarInterface sidecarInterface3 = this.f6544a;
                if (sidecarInterface3 != null) {
                    sidecarInterface3.onDeviceStateListenersChanged(true);
                }
                SidecarInterface sidecarInterface4 = this.f6544a;
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
                if (T2.h.a(cls2, SidecarWindowLayoutInfo.class)) {
                    SidecarInterface sidecarInterface5 = this.f6544a;
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
                    if (T2.h.a(cls3, cls9)) {
                        SidecarInterface sidecarInterface6 = this.f6544a;
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
                        if (T2.h.a(cls4, cls9)) {
                            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
                            try {
                                sidecarDeviceState.posture = 3;
                            } catch (NoSuchFieldError unused) {
                                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                                Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                                T2.h.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                                if (((Integer) invoke).intValue() != 3) {
                                    throw new Exception("Invalid device posture getter/setter");
                                }
                            }
                            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
                            Rect rect = sidecarDisplayFeature.getRect();
                            T2.h.d(rect, "displayFeature.rect");
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
                                T2.h.c(invoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
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
