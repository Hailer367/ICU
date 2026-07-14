package x;

import a.AbstractC0051a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import w.C0337b;
import w.C0338c;

/* loaded from: classes.dex */
public class e extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public static Class f3967f = null;

    /* renamed from: g, reason: collision with root package name */
    public static Constructor f3968g = null;

    /* renamed from: h, reason: collision with root package name */
    public static Method f3969h = null;

    /* renamed from: i, reason: collision with root package name */
    public static Method f3970i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f3971j = false;

    public static boolean X(Object obj, String str, int i2, boolean z) {
        Y();
        try {
            return ((Boolean) f3969h.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void Y() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f3971j) {
            return;
        }
        f3971j = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f3968g = constructor;
        f3967f = cls;
        f3969h = method2;
        f3970i = method;
    }

    @Override // a.AbstractC0051a
    public Typeface k(Context context, C0337b c0337b, Resources resources, int i2) {
        Y();
        try {
            Object newInstance = f3968g.newInstance(null);
            for (C0338c c0338c : c0337b.f3934a) {
                File q = android.support.v4.media.session.a.q(context);
                if (q == null) {
                    return null;
                }
                try {
                    if (!android.support.v4.media.session.a.h(q, resources, c0338c.f3940f)) {
                        return null;
                    }
                    if (!X(newInstance, q.getPath(), c0338c.f3936b, c0338c.f3937c)) {
                        return null;
                    }
                    q.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    q.delete();
                }
            }
            Y();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f3967f, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f3970i.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // a.AbstractC0051a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface l(android.content.Context r4, B.m[] r5, int r6) {
        /*
            r3 = this;
            int r0 = r5.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L7
            goto La1
        L7:
            B.m r5 = a.AbstractC0051a.v(r5, r6)
            android.content.ContentResolver r6 = r4.getContentResolver()
            android.net.Uri r5 = r5.f68a     // Catch: java.io.IOException -> La1
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r5 = r6.openFileDescriptor(r5, r0, r2)     // Catch: java.io.IOException -> La1
            if (r5 != 0) goto L1f
            if (r5 == 0) goto La1
            r5.close()     // Catch: java.io.IOException -> La1
            return r2
        L1f:
            java.lang.String r6 = "/proc/self/fd/"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            r0.<init>(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            int r6 = r5.getFd()     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            r0.append(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            java.lang.String r6 = r0.toString()     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            java.lang.String r6 = android.system.Os.readlink(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            android.system.StructStat r0 = android.system.Os.stat(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            int r0 = r0.st_mode     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            boolean r0 = android.system.OsConstants.S_ISREG(r0)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            if (r0 == 0) goto L47
            java.io.File r0 = new java.io.File     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            r0.<init>(r6)     // Catch: android.system.ErrnoException -> L47 java.lang.Throwable -> L59
            goto L48
        L47:
            r0 = r2
        L48:
            if (r0 == 0) goto L5b
            boolean r6 = r0.canRead()     // Catch: java.lang.Throwable -> L59
            if (r6 != 0) goto L51
            goto L5b
        L51:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r0)     // Catch: java.lang.Throwable -> L59
            r5.close()     // Catch: java.io.IOException -> La1
            return r4
        L59:
            r4 = move-exception
            goto L98
        L5b:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L59
            java.io.FileDescriptor r0 = r5.getFileDescriptor()     // Catch: java.lang.Throwable -> L59
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L59
            java.io.File r4 = android.support.v4.media.session.a.q(r4)     // Catch: java.lang.Throwable -> L8e
            if (r4 != 0) goto L6c
        L6a:
            r0 = r2
            goto L87
        L6c:
            boolean r0 = android.support.v4.media.session.a.i(r4, r6)     // Catch: java.lang.RuntimeException -> L72 java.lang.Throwable -> L82
            if (r0 != 0) goto L76
        L72:
            r4.delete()     // Catch: java.lang.Throwable -> L8e
            goto L6a
        L76:
            java.lang.String r0 = r4.getPath()     // Catch: java.lang.RuntimeException -> L72 java.lang.Throwable -> L82
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromFile(r0)     // Catch: java.lang.RuntimeException -> L72 java.lang.Throwable -> L82
            r4.delete()     // Catch: java.lang.Throwable -> L8e
            goto L87
        L82:
            r0 = move-exception
            r4.delete()     // Catch: java.lang.Throwable -> L8e
            throw r0     // Catch: java.lang.Throwable -> L8e
        L87:
            r6.close()     // Catch: java.lang.Throwable -> L59
            r5.close()     // Catch: java.io.IOException -> La1
            return r0
        L8e:
            r4 = move-exception
            r6.close()     // Catch: java.lang.Throwable -> L93
            goto L97
        L93:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch: java.lang.Throwable -> L59
        L97:
            throw r4     // Catch: java.lang.Throwable -> L59
        L98:
            r5.close()     // Catch: java.lang.Throwable -> L9c
            goto La0
        L9c:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch: java.io.IOException -> La1
        La0:
            throw r4     // Catch: java.io.IOException -> La1
        La1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.l(android.content.Context, B.m[], int):android.graphics.Typeface");
    }
}
