package B;

import a.AbstractC0141a;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public class i extends g {

    /* renamed from: g, reason: collision with root package name */
    public final Class f140g;

    /* renamed from: h, reason: collision with root package name */
    public final Constructor f141h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f142i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f143j;
    public final Method k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f144l;

    /* renamed from: m, reason: collision with root package name */
    public final Method f145m;

    public i() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method2 = j0(cls2);
            Class cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = k0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e4.getClass().getName()), e4);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f140g = cls;
        this.f141h = constructor;
        this.f142i = method2;
        this.f143j = method3;
        this.k = method4;
        this.f144l = method5;
        this.f145m = method;
    }

    public static Method j0(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    public final boolean g0(Context context, Object obj, String str, int i4, int i5, int i6, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f142i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface h0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f140g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f145m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean i0(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    @Override // B.g, q1.AbstractC0602b
    public final Typeface k(Context context, A.e eVar, Resources resources, int i4) {
        Object obj;
        Method method = this.f142i;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                obj = this.f141h.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj != null) {
                A.f[] fVarArr = eVar.f14a;
                int length = fVarArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        A.f fVar = fVarArr[i5];
                        Context context2 = context;
                        if (!g0(context2, obj, fVar.f15a, fVar.f19e, fVar.f16b, fVar.f17c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fVar.f18d))) {
                            try {
                                this.f144l.invoke(obj, null);
                                break;
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        } else {
                            i5++;
                            context = context2;
                        }
                    } else if (i0(obj)) {
                        return h0(obj);
                    }
                }
            }
            return null;
        }
        return super.k(context, eVar, resources, i4);
    }

    public Method k0(Class cls) {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // B.g, q1.AbstractC0602b
    public final Typeface l(Context context, F.l[] lVarArr, int i4) {
        Object obj;
        Typeface h02;
        boolean z;
        if (lVarArr.length >= 1) {
            Method method = this.f142i;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap hashMap = new HashMap();
                    for (F.l lVar : lVarArr) {
                        if (lVar.f516f == 0) {
                            Uri uri = lVar.f511a;
                            if (!hashMap.containsKey(uri)) {
                                hashMap.put(uri, AbstractC0141a.w(context, uri));
                            }
                        }
                    }
                    Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                    try {
                        obj = this.f141h.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        obj = null;
                    }
                    if (obj != null) {
                        int length = lVarArr.length;
                        int i5 = 0;
                        boolean z3 = false;
                        while (true) {
                            Method method2 = this.f144l;
                            if (i5 < length) {
                                F.l lVar2 = lVarArr[i5];
                                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(lVar2.f511a);
                                if (byteBuffer != null) {
                                    try {
                                        z = ((Boolean) this.f143j.invoke(obj, byteBuffer, Integer.valueOf(lVar2.f512b), null, Integer.valueOf(lVar2.f513c), Integer.valueOf(lVar2.f514d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        z = false;
                                    }
                                    if (!z) {
                                        method2.invoke(obj, null);
                                        break;
                                    }
                                    z3 = true;
                                }
                                i5++;
                                z3 = z3;
                            } else if (!z3) {
                                method2.invoke(obj, null);
                            } else if (i0(obj) && (h02 = h0(obj)) != null) {
                                return Typeface.create(h02, i4);
                            }
                        }
                    }
                } else {
                    F.l x3 = AbstractC0602b.x(lVarArr, i4);
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(x3.f511a, "r", null);
                    if (openFileDescriptor == null) {
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                            return null;
                        }
                    } else {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(x3.f513c).setItalic(x3.f514d).build();
                            openFileDescriptor.close();
                            return build;
                        } finally {
                        }
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // q1.AbstractC0602b
    public final Typeface n(Context context, Resources resources, int i4, String str, int i5) {
        Object obj;
        Method method = this.f142i;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                obj = this.f141h.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj != null) {
                if (!g0(context, obj, str, 0, -1, -1, null)) {
                    try {
                        this.f144l.invoke(obj, null);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } else if (i0(obj)) {
                    return h0(obj);
                }
            }
            return null;
        }
        return super.n(context, resources, i4, str, i5);
    }
}
