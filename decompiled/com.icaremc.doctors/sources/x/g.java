package x;

import B.m;
import a.AbstractC0051a;
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
import w.C0337b;
import w.C0338c;

/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: k, reason: collision with root package name */
    public final Class f3976k;

    /* renamed from: l, reason: collision with root package name */
    public final Constructor f3977l;

    /* renamed from: m, reason: collision with root package name */
    public final Method f3978m;

    /* renamed from: n, reason: collision with root package name */
    public final Method f3979n;

    /* renamed from: o, reason: collision with root package name */
    public final Method f3980o;
    public final Method p;
    public final Method q;

    public g() {
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
            method2 = c0(cls2);
            Class cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = d0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e2.getClass().getName()), e2);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f3976k = cls;
        this.f3977l = constructor;
        this.f3978m = method2;
        this.f3979n = method3;
        this.f3980o = method4;
        this.p = method5;
        this.q = method;
    }

    public static Method c0(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    public final boolean Z(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f3978m.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface a0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f3976k, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.q.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean b0(Object obj) {
        try {
            return ((Boolean) this.f3980o.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method d0(Class cls) {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // x.e, a.AbstractC0051a
    public final Typeface k(Context context, C0337b c0337b, Resources resources, int i2) {
        Object obj;
        Method method = this.f3978m;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                obj = this.f3977l.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj != null) {
                C0338c[] c0338cArr = c0337b.f3934a;
                int length = c0338cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        C0338c c0338c = c0338cArr[i3];
                        Context context2 = context;
                        if (!Z(context2, obj, c0338c.f3935a, c0338c.f3939e, c0338c.f3936b, c0338c.f3937c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0338c.f3938d))) {
                            try {
                                this.p.invoke(obj, null);
                                break;
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        } else {
                            i3++;
                            context = context2;
                        }
                    } else if (b0(obj)) {
                        return a0(obj);
                    }
                }
            }
            return null;
        }
        return super.k(context, c0337b, resources, i2);
    }

    @Override // x.e, a.AbstractC0051a
    public final Typeface l(Context context, m[] mVarArr, int i2) {
        Object obj;
        Typeface a02;
        boolean z;
        if (mVarArr.length >= 1) {
            Method method = this.f3978m;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap hashMap = new HashMap();
                    for (m mVar : mVarArr) {
                        if (mVar.f73f == 0) {
                            Uri uri = mVar.f68a;
                            if (!hashMap.containsKey(uri)) {
                                hashMap.put(uri, android.support.v4.media.session.a.z(context, uri));
                            }
                        }
                    }
                    Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                    try {
                        obj = this.f3977l.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        obj = null;
                    }
                    if (obj != null) {
                        int length = mVarArr.length;
                        int i3 = 0;
                        boolean z2 = false;
                        while (true) {
                            Method method2 = this.p;
                            if (i3 < length) {
                                m mVar2 = mVarArr[i3];
                                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(mVar2.f68a);
                                if (byteBuffer != null) {
                                    try {
                                        z = ((Boolean) this.f3979n.invoke(obj, byteBuffer, Integer.valueOf(mVar2.f69b), null, Integer.valueOf(mVar2.f70c), Integer.valueOf(mVar2.f71d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        z = false;
                                    }
                                    if (!z) {
                                        method2.invoke(obj, null);
                                        break;
                                    }
                                    z2 = true;
                                }
                                i3++;
                                z2 = z2;
                            } else if (!z2) {
                                method2.invoke(obj, null);
                            } else if (b0(obj) && (a02 = a0(obj)) != null) {
                                return Typeface.create(a02, i2);
                            }
                        }
                    }
                } else {
                    m v2 = AbstractC0051a.v(mVarArr, i2);
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(v2.f68a, "r", null);
                    if (openFileDescriptor == null) {
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                            return null;
                        }
                    } else {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(v2.f70c).setItalic(v2.f71d).build();
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

    @Override // a.AbstractC0051a
    public final Typeface n(Context context, Resources resources, int i2, String str, int i3) {
        Object obj;
        Method method = this.f3978m;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                obj = this.f3977l.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj != null) {
                if (!Z(context, obj, str, 0, -1, -1, null)) {
                    try {
                        this.p.invoke(obj, null);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } else if (b0(obj)) {
                    return a0(obj);
                }
            }
            return null;
        }
        return super.n(context, resources, i2, str, i3);
    }
}
