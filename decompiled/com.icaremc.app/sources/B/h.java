package B;

import a.AbstractC0141a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import q1.AbstractC0602b;
import t.C0661j;

/* loaded from: classes.dex */
public final class h extends AbstractC0602b {

    /* renamed from: b, reason: collision with root package name */
    public static final Class f136b;

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor f137c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f138d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f139e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi24Impl", e4.getClass().getName(), e4);
            cls = null;
            method = null;
            method2 = null;
        }
        f137c = constructor;
        f136b = cls;
        f138d = method2;
        f139e = method;
    }

    public static boolean e0(Object obj, ByteBuffer byteBuffer, int i4, int i5, boolean z) {
        try {
            return ((Boolean) f138d.invoke(obj, byteBuffer, Integer.valueOf(i4), null, Integer.valueOf(i5), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface f0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f136b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f139e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // q1.AbstractC0602b
    public final Typeface k(Context context, A.e eVar, Resources resources, int i4) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
        try {
            obj = f137c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            for (A.f fVar : eVar.f14a) {
                int i5 = fVar.f20f;
                File t3 = AbstractC0141a.t(context);
                if (t3 != null) {
                    try {
                        if (AbstractC0141a.j(t3, resources, i5)) {
                            try {
                                fileInputStream = new FileInputStream(t3);
                            } catch (IOException unused2) {
                                mappedByteBuffer = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (mappedByteBuffer != null && e0(obj, mappedByteBuffer, fVar.f19e, fVar.f16b, fVar.f17c)) {
                                }
                            } finally {
                                break;
                            }
                        }
                    } finally {
                        t3.delete();
                    }
                }
                mappedByteBuffer = null;
                if (mappedByteBuffer != null) {
                }
            }
            return f0(obj);
        }
        return null;
    }

    @Override // q1.AbstractC0602b
    public final Typeface l(Context context, F.l[] lVarArr, int i4) {
        Object obj;
        try {
            obj = f137c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            int i5 = 0;
            C0661j c0661j = new C0661j(0);
            int length = lVarArr.length;
            while (true) {
                if (i5 < length) {
                    F.l lVar = lVarArr[i5];
                    Uri uri = lVar.f511a;
                    ByteBuffer byteBuffer = (ByteBuffer) c0661j.get(uri);
                    if (byteBuffer == null) {
                        byteBuffer = AbstractC0141a.w(context, uri);
                        c0661j.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null || !e0(obj, byteBuffer, lVar.f512b, lVar.f513c, lVar.f514d)) {
                        break;
                    }
                    i5++;
                } else {
                    Typeface f02 = f0(obj);
                    if (f02 != null) {
                        return Typeface.create(f02, i4);
                    }
                }
            }
        }
        return null;
    }
}
