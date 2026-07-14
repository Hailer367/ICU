package x;

import B.m;
import a.AbstractC0051a;
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
import w.C0337b;
import w.C0338c;

/* loaded from: classes.dex */
public final class f extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public static final Class f3972f;

    /* renamed from: g, reason: collision with root package name */
    public static final Constructor f3973g;

    /* renamed from: h, reason: collision with root package name */
    public static final Method f3974h;

    /* renamed from: i, reason: collision with root package name */
    public static final Method f3975i;

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
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f3973g = constructor;
        f3972f = cls;
        f3974h = method2;
        f3975i = method;
    }

    public static boolean X(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f3974h.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface Y(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f3972f, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f3975i.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // a.AbstractC0051a
    public final Typeface k(Context context, C0337b c0337b, Resources resources, int i2) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
        try {
            obj = f3973g.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            for (C0338c c0338c : c0337b.f3934a) {
                int i3 = c0338c.f3940f;
                File q = android.support.v4.media.session.a.q(context);
                if (q != null) {
                    try {
                        if (android.support.v4.media.session.a.h(q, resources, i3)) {
                            try {
                                fileInputStream = new FileInputStream(q);
                            } catch (IOException unused2) {
                                mappedByteBuffer = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (mappedByteBuffer != null && X(obj, mappedByteBuffer, c0338c.f3939e, c0338c.f3936b, c0338c.f3937c)) {
                                }
                            } finally {
                                break;
                            }
                        }
                    } finally {
                        q.delete();
                    }
                }
                mappedByteBuffer = null;
                if (mappedByteBuffer != null) {
                }
            }
            return Y(obj);
        }
        return null;
    }

    @Override // a.AbstractC0051a
    public final Typeface l(Context context, m[] mVarArr, int i2) {
        Object obj;
        try {
            obj = f3973g.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            int i3 = 0;
            r.j jVar = new r.j(0);
            int length = mVarArr.length;
            while (true) {
                if (i3 < length) {
                    m mVar = mVarArr[i3];
                    Uri uri = mVar.f68a;
                    ByteBuffer byteBuffer = (ByteBuffer) jVar.get(uri);
                    if (byteBuffer == null) {
                        byteBuffer = android.support.v4.media.session.a.z(context, uri);
                        jVar.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null || !X(obj, byteBuffer, mVar.f69b, mVar.f70c, mVar.f71d)) {
                        break;
                    }
                    i3++;
                } else {
                    Typeface Y2 = Y(obj);
                    if (Y2 != null) {
                        return Typeface.create(Y2, i2);
                    }
                }
            }
        }
        return null;
    }
}
