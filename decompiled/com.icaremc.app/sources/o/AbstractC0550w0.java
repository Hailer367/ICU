package o;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* renamed from: o.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0550w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f5725a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f5726b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f5727c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f5728d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
            f5725a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f5726b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f5727c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f5728d = true;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
    }
}
