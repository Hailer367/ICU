package a;

import B.m;
import E.AbstractC0005e;
import E.I;
import E.J;
import H.c;
import O.e;
import P.b;
import Q0.f;
import T0.g;
import T0.i;
import T0.j;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.datastore.preferences.protobuf.C0080g;
import c1.l;
import com.google.android.gms.common.api.Api;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import m.q0;
import org.xmlpull.v1.XmlPullParser;
import w.C0337b;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0051a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f884a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f885b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Field f886c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f887d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f888e = true;

    public AbstractC0051a() {
        new ConcurrentHashMap();
    }

    public static int A(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC0005e.f(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    public static String B(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC0005e.g(obj);
        }
        try {
            return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    public static int D(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC0005e.n(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e4);
            return -1;
        }
    }

    public static Uri E(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC0005e.o(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    public static final e F(String name) {
        h.e(name, "name");
        return new e(name);
    }

    public static String G(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                sb.append(str.charAt(i2));
                if (str2.length() > i2) {
                    sb.append(str2.charAt(i2));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    public static i H(g gVar, T0.h key) {
        h.e(key, "key");
        if (h.a(gVar.getKey(), key)) {
            return j.f774c;
        }
        return gVar;
    }

    public static float I(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 31) {
            return c.c(edgeEffect, f2, f3);
        }
        edgeEffect.onPull(f2, f3);
        return f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w.InterfaceC0336a J(android.content.res.XmlResourceParser r25, android.content.res.Resources r26) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0051a.J(android.content.res.XmlResourceParser, android.content.res.Resources):w.a");
    }

    public static List K(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (obtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i2);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void O(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        q0 q0Var = q0.f3227l;
        if (q0Var != null && q0Var.f3229c == view) {
            q0.b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            q0 q0Var2 = q0.f3228m;
            if (q0Var2 != null && q0Var2.f3229c == view) {
                q0Var2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new q0(charSequence, view);
    }

    public static void R(XmlPullParser xmlPullParser) {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i2--;
                }
            } else {
                i2++;
            }
        }
    }

    public static boolean S(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] == bArr2[i2]) {
                }
            }
            return true;
        }
        return false;
    }

    public static final e T(String name) {
        h.e(name, "name");
        return new e(name);
    }

    public static final e U(String name) {
        h.e(name, "name");
        return new e(name);
    }

    public static final void V(Object obj) {
        if (!(obj instanceof f)) {
        } else {
            throw ((f) obj).f716c;
        }
    }

    public static final boolean W(String str, c1.a aVar) {
        try {
            boolean booleanValue = ((Boolean) aVar.invoke()).booleanValue();
            if (!booleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:13:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0085 -> B:13:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.util.List r6, K.C0037l r7, V0.c r8) {
        /*
            boolean r0 = r8 instanceof K.C0031f
            if (r0 == 0) goto L13
            r0 = r8
            K.f r0 = (K.C0031f) r0
            int r1 = r0.f470f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f470f = r1
            goto L18
        L13:
            K.f r0 = new K.f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f469e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f470f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.util.Iterator r6 = r0.f468d
            java.io.Serializable r7 = r0.f467c
            kotlin.jvm.internal.q r7 = (kotlin.jvm.internal.q) r7
            V(r8)     // Catch: java.lang.Throwable -> L30
            goto L65
        L30:
            r8 = move-exception
            goto L7e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.io.Serializable r6 = r0.f467c
            java.util.List r6 = (java.util.List) r6
            V(r8)
            goto L5c
        L42:
            V(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            K.h r2 = new K.h
            r5 = 0
            r2.<init>(r6, r8, r5)
            r0.f467c = r8
            r0.f470f = r4
            java.lang.Object r6 = r7.a(r2, r0)
            if (r6 != r1) goto L5b
            goto L93
        L5b:
            r6 = r8
        L5c:
            kotlin.jvm.internal.q r7 = new kotlin.jvm.internal.q
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()
            c1.l r8 = (c1.l) r8
            r0.f467c = r7     // Catch: java.lang.Throwable -> L30
            r0.f468d = r6     // Catch: java.lang.Throwable -> L30
            r0.f470f = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L65
            goto L93
        L7e:
            java.lang.Object r2 = r7.f2789c
            if (r2 != 0) goto L85
            r7.f2789c = r8
            goto L65
        L85:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            android.support.v4.media.session.a.c(r2, r8)
            goto L65
        L8b:
            java.lang.Object r6 = r7.f2789c
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 != 0) goto L94
            Q0.j r1 = Q0.j.f722a
        L93:
            return r1
        L94:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0051a.a(java.util.List, K.l, V0.c):java.lang.Object");
    }

    public static final e b(String name) {
        h.e(name, "name");
        return new e(name);
    }

    public static void c(float f2, String str) {
        if (!Float.isNaN(f2)) {
            if (!Float.isInfinite(f2)) {
                return;
            } else {
                throw new IllegalArgumentException(str.concat(" must not be infinite"));
            }
        }
        throw new IllegalArgumentException(str.concat(" must not be NaN"));
    }

    public static final void d(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                android.support.v4.media.session.a.c(th, th2);
            }
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] g(Serializable serializable) {
        if (serializable instanceof int[]) {
            int[] iArr = (int[]) serializable;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = iArr[i2];
            }
            return jArr;
        }
        if (serializable instanceof long[]) {
            return (long[]) serializable;
        }
        return null;
    }

    public static void h(b bVar, P.c cVar, int i2) {
        byte[] bArr = new byte[8192];
        while (i2 > 0) {
            int min = Math.min(i2, 8192);
            int read = bVar.read(bArr, 0, min);
            if (read == min) {
                i2 -= read;
                cVar.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    public static void i(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static final f j(Throwable exception) {
        h.e(exception, "exception");
        return new f(exception);
    }

    public static String o(Object value, String str) {
        h.e(value, "value");
        return str + " value: " + value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [E.I, java.lang.Object] */
    public static boolean q(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        Field field = J.f180a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = I.f176d;
            I i2 = (I) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            I i3 = i2;
            if (i2 == null) {
                ?? obj = new Object();
                obj.f177a = null;
                obj.f178b = null;
                obj.f179c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, obj);
                i3 = obj;
            }
            WeakReference weakReference2 = i3.f179c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                i3.f179c = new WeakReference(keyEvent);
                if (i3.f178b == null) {
                    i3.f178b = new SparseArray();
                }
                SparseArray sparseArray = i3.f178b;
                if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    arrayList.get(size).getClass();
                    throw new ClassCastException();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean r(Method method, d dVar) {
        Class a2 = dVar.a();
        h.c(a2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return method.getReturnType().equals(a2);
    }

    public static final W0.b t(Enum[] entries) {
        h.e(entries, "entries");
        return new W0.b(entries);
    }

    public static String u(C0080g c0080g) {
        StringBuilder sb = new StringBuilder(c0080g.size());
        for (int i2 = 0; i2 < c0080g.size(); i2++) {
            byte a2 = c0080g.a(i2);
            if (a2 != 34) {
                if (a2 != 39) {
                    if (a2 != 92) {
                        switch (a2) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case 12:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (a2 >= 32 && a2 <= 126) {
                                    sb.append((char) a2);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((a2 >>> 6) & 3) + 48));
                                    sb.append((char) (((a2 >>> 3) & 7) + 48));
                                    sb.append((char) ((a2 & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }

    public static m v(m[] mVarArr, int i2) {
        int i3;
        boolean z;
        int i4;
        if ((i2 & 1) == 0) {
            i3 = 400;
        } else {
            i3 = 700;
        }
        if ((i2 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        m mVar = null;
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (m mVar2 : mVarArr) {
            int abs = Math.abs(mVar2.f70c - i3) * 2;
            if (mVar2.f71d == z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            int i6 = abs + i4;
            if (mVar == null || i5 > i6) {
                mVar = mVar2;
                i5 = i6;
            }
        }
        return mVar;
    }

    public static g w(g gVar, T0.h key) {
        h.e(key, "key");
        if (h.a(gVar.getKey(), key)) {
            return gVar;
        }
        return null;
    }

    public static float x(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return c.b(edgeEffect);
        }
        return 0.0f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    public static final Class y(i1.c cVar) {
        h.e(cVar, "<this>");
        Class a2 = ((kotlin.jvm.internal.c) cVar).a();
        if (a2.isPrimitive()) {
            String name = a2.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return a2;
    }

    public static Object z(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return A.d.a(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public float C(View view) {
        float transitionAlpha;
        if (f888e) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f888e = false;
            }
        }
        return view.getAlpha();
    }

    public abstract AbstractC0051a L(String str, l lVar);

    public abstract void N(boolean z);

    public void P(View view, float f2) {
        if (f888e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f888e = false;
            }
        }
        view.setAlpha(f2);
    }

    public void Q(View view, int i2) {
        if (!f887d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f886c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f887d = true;
        }
        Field field = f886c;
        if (field != null) {
            try {
                f886c.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract Object f();

    public abstract Typeface k(Context context, C0337b c0337b, Resources resources, int i2);

    public abstract Typeface l(Context context, m[] mVarArr, int i2);

    public Typeface m(Context context, List list, int i2) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface n(Context context, Resources resources, int i2, String str, int i3) {
        File q = android.support.v4.media.session.a.q(context);
        if (q == null) {
            return null;
        }
        try {
            if (!android.support.v4.media.session.a.h(q, resources, i2)) {
                return null;
            }
            return Typeface.createFromFile(q.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            q.delete();
        }
    }

    public abstract String p(byte[] bArr, int i2, int i3);

    public abstract int s(String str, byte[] bArr, int i2, int i3);

    public void M(boolean z) {
    }
}
