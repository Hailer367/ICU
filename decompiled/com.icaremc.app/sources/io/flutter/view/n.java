package io.flutter.view;

import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Method f4536a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f4537b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f4538c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f4539d;

    /* renamed from: e, reason: collision with root package name */
    public final Field f4540e;

    /* renamed from: f, reason: collision with root package name */
    public final Method f4541f;

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Field field;
        Method method5;
        Method method6 = null;
        try {
            method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", null);
        } catch (NoSuchMethodException unused) {
            Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
            method = null;
        }
        try {
            method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", null);
        } catch (NoSuchMethodException unused2) {
            Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
            method2 = null;
        }
        int i4 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        if (i4 <= 26) {
            try {
                method3 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", null);
            } catch (NoSuchMethodException unused3) {
                Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
                method3 = null;
            }
            try {
                method4 = AccessibilityNodeInfo.class.getMethod("getChildId", cls);
                field = null;
            } catch (NoSuchMethodException unused4) {
                Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
                method4 = null;
                field = null;
            }
            method6 = method3;
        } else {
            try {
                Field declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                declaredField.setAccessible(true);
                method5 = Class.forName("android.util.LongArray").getMethod("get", cls);
                field = declaredField;
                method4 = null;
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException unused5) {
                Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
                method4 = null;
                field = null;
            }
            this.f4536a = method;
            this.f4537b = method6;
            this.f4538c = method2;
            this.f4539d = method4;
            this.f4540e = field;
            this.f4541f = method5;
        }
        method5 = field;
        this.f4536a = method;
        this.f4537b = method6;
        this.f4538c = method2;
        this.f4539d = method4;
        this.f4540e = field;
        this.f4541f = method5;
    }

    public static Long a(n nVar, AccessibilityRecord accessibilityRecord) {
        Method method = nVar.f4538c;
        if (method != null) {
            try {
                return (Long) method.invoke(accessibilityRecord, null);
            } catch (IllegalAccessException e4) {
                Log.w("AccessibilityBridge", "Failed to access the getRecordSourceNodeId method.", e4);
            } catch (InvocationTargetException e5) {
                Log.w("AccessibilityBridge", "The getRecordSourceNodeId method threw an exception when invoked.", e5);
            }
        }
        return null;
    }

    public static boolean b(long j4, int i4) {
        return (j4 & (1 << i4)) != 0;
    }
}
