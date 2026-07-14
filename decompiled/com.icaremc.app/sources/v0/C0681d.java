package v0;

import T2.q;
import a.AbstractC0141a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.core.util.function.Consumer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: v0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0681d extends T2.i implements S2.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6271g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0682e f6272h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0681d(C0682e c0682e, int i4) {
        super(0);
        this.f6271g = i4;
        this.f6272h = c0682e;
    }

    @Override // S2.a
    public final Object a() {
        boolean z;
        Class cls;
        boolean z3;
        boolean z4;
        boolean z5;
        switch (this.f6271g) {
            case 0:
                Class<?> loadClass = this.f6272h.f6273a.loadClass("androidx.window.extensions.layout.FoldingFeature");
                T2.h.d(loadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
                Method method = loadClass.getMethod("getBounds", null);
                Method method2 = loadClass.getMethod("getType", null);
                Method method3 = loadClass.getMethod("getState", null);
                T2.h.d(method, "getBoundsMethod");
                if (AbstractC0141a.o(method, q.a(Rect.class)) && Modifier.isPublic(method.getModifiers())) {
                    T2.h.d(method2, "getTypeMethod");
                    Class cls2 = Integer.TYPE;
                    if (AbstractC0141a.o(method2, q.a(cls2)) && Modifier.isPublic(method2.getModifiers())) {
                        T2.h.d(method3, "getStateMethod");
                        if (AbstractC0141a.o(method3, q.a(cls2)) && Modifier.isPublic(method3.getModifiers())) {
                            z = true;
                            return Boolean.valueOf(z);
                        }
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            case 1:
                C0682e c0682e = this.f6272h;
                try {
                    cls = c0682e.f6274b.b();
                } catch (ClassNotFoundException unused) {
                    cls = null;
                }
                if (cls == null) {
                    return Boolean.FALSE;
                }
                Class<?> loadClass2 = c0682e.f6273a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                T2.h.d(loadClass2, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                Method method4 = loadClass2.getMethod("addWindowLayoutInfoListener", Activity.class, cls);
                Method method5 = loadClass2.getMethod("removeWindowLayoutInfoListener", cls);
                T2.h.d(method4, "addListenerMethod");
                if (Modifier.isPublic(method4.getModifiers())) {
                    T2.h.d(method5, "removeListenerMethod");
                    if (Modifier.isPublic(method5.getModifiers())) {
                        z3 = true;
                        return Boolean.valueOf(z3);
                    }
                }
                z3 = false;
                return Boolean.valueOf(z3);
            case 2:
                Class<?> loadClass3 = this.f6272h.f6273a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                T2.h.d(loadClass3, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                Method method6 = loadClass3.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
                Method method7 = loadClass3.getMethod("removeWindowLayoutInfoListener", Consumer.class);
                T2.h.d(method6, "addListenerMethod");
                if (Modifier.isPublic(method6.getModifiers())) {
                    T2.h.d(method7, "removeListenerMethod");
                    if (Modifier.isPublic(method7.getModifiers())) {
                        z4 = true;
                        return Boolean.valueOf(z4);
                    }
                }
                z4 = false;
                return Boolean.valueOf(z4);
            default:
                C0682e c0682e2 = this.f6272h;
                Class<?> loadClass4 = c0682e2.f6275c.f6015a.loadClass("androidx.window.extensions.WindowExtensions");
                T2.h.d(loadClass4, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                Method method8 = loadClass4.getMethod("getWindowLayoutComponent", null);
                Class<?> loadClass5 = c0682e2.f6273a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                T2.h.d(loadClass5, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                T2.h.d(method8, "getWindowLayoutComponentMethod");
                if (Modifier.isPublic(method8.getModifiers()) && method8.getReturnType().equals(loadClass5)) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                return Boolean.valueOf(z5);
        }
    }
}
