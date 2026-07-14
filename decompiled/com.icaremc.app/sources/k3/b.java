package k3;

import A2.A;
import A2.C0005d;
import D2.C0030i;
import D2.L;
import H2.e;
import H2.f;
import I.H;
import K2.d;
import K2.i;
import K2.j;
import M2.c;
import P1.v;
import P1.w;
import P1.y;
import S2.l;
import S2.p;
import T2.h;
import T2.s;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import androidx.datastore.preferences.protobuf.C0150g;
import androidx.datastore.preferences.protobuf.b0;
import b3.AbstractC0242q;
import h0.AbstractC0333u;
import h0.C0301D;
import h0.C0327o;
import h0.C0334v;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l0.AbstractC0433a;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;
import t.C0654c;
import t.C0661j;
import x1.C0721a;
import x1.g;
import x1.o;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static Field f5109a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5110b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f5111c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f5112d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f5113e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f5114f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f5115g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f5116h;

    /* renamed from: i, reason: collision with root package name */
    public static long f5117i;

    /* renamed from: j, reason: collision with root package name */
    public static Method f5118j;
    public static Method k;

    /* renamed from: l, reason: collision with root package name */
    public static Method f5119l;

    public static final void A(Object obj) {
        if (!(obj instanceof e)) {
        } else {
            throw ((e) obj).f675f;
        }
    }

    public static String B(String str) {
        if (str.length() <= 127) {
            return str;
        }
        return str.substring(0, 127);
    }

    public static Object C(p pVar, Object obj, d dVar) {
        M2.a cVar;
        h.e(pVar, "<this>");
        i context = dVar.getContext();
        if (context == j.f942f) {
            cVar = new M2.a(dVar);
            if (dVar.getContext() != j.f942f) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
            }
        } else {
            cVar = new c(dVar, context);
        }
        s.a(2, pVar);
        return pVar.e(obj, cVar);
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static Object b(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static final void c(l lVar, C0005d c0005d) {
        lVar.f(new f(f(c0005d)));
    }

    public static int d(C0301D c0301d, C0327o c0327o, View view, View view2, AbstractC0333u abstractC0333u, boolean z) {
        int s3;
        int t3;
        if (abstractC0333u.p() != 0 && c0301d.a() != 0 && view != null && view2 != null) {
            if (z) {
                int b4 = c0327o.b(view2) - c0327o.c(view);
                switch (c0327o.f3925b) {
                    case 0:
                        AbstractC0333u abstractC0333u2 = c0327o.f3924a;
                        s3 = abstractC0333u2.f3935f - abstractC0333u2.s();
                        t3 = abstractC0333u2.t();
                        break;
                    default:
                        AbstractC0333u abstractC0333u3 = c0327o.f3924a;
                        s3 = abstractC0333u3.f3936g - abstractC0333u3.u();
                        t3 = abstractC0333u3.r();
                        break;
                }
                return Math.min(s3 - t3, b4);
            }
            ((C0334v) view.getLayoutParams()).getClass();
            throw null;
        }
        return 0;
    }

    public static int e(C0301D c0301d, C0327o c0327o, View view, View view2, AbstractC0333u abstractC0333u, boolean z) {
        if (abstractC0333u.p() != 0 && c0301d.a() != 0 && view != null && view2 != null) {
            if (!z) {
                return c0301d.a();
            }
            c0327o.b(view2);
            c0327o.c(view);
            ((C0334v) view.getLayoutParams()).getClass();
            throw null;
        }
        return 0;
    }

    public static final e f(Throwable th) {
        h.e(th, "exception");
        return new e(th);
    }

    public static void g(ArrayList arrayList) {
        boolean z;
        boolean z3;
        HashMap hashMap = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            C0721a c0721a = (C0721a) obj;
            x1.e eVar = new x1.e(c0721a);
            for (o oVar : c0721a.f6456b) {
                if (c0721a.f6459e == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                x1.f fVar = new x1.f(oVar, !z3);
                if (!hashMap.containsKey(fVar)) {
                    hashMap.put(fVar, new HashSet());
                }
                Set set = (Set) hashMap.get(fVar);
                if (!set.isEmpty() && z3) {
                    throw new IllegalArgumentException("Multiple components provide " + oVar + ".");
                }
                set.add(eVar);
            }
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            for (x1.e eVar2 : (Set) it.next()) {
                for (g gVar : eVar2.f6470a.f6457c) {
                    if (gVar.f6477c == 0) {
                        o oVar2 = gVar.f6475a;
                        if (gVar.f6476b == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Set<x1.e> set2 = (Set) hashMap.get(new x1.f(oVar2, z));
                        if (set2 != null) {
                            for (x1.e eVar3 : set2) {
                                eVar2.f6471b.add(eVar3);
                                eVar3.f6472c.add(eVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = hashMap.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            x1.e eVar4 = (x1.e) it3.next();
            if (eVar4.f6472c.isEmpty()) {
                hashSet2.add(eVar4);
            }
        }
        while (!hashSet2.isEmpty()) {
            x1.e eVar5 = (x1.e) hashSet2.iterator().next();
            hashSet2.remove(eVar5);
            i4++;
            Iterator it4 = eVar5.f6471b.iterator();
            while (it4.hasNext()) {
                x1.e eVar6 = (x1.e) it4.next();
                eVar6.f6472c.remove(eVar5);
                if (eVar6.f6472c.isEmpty()) {
                    hashSet2.add(eVar6);
                }
            }
        }
        if (i4 == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            x1.e eVar7 = (x1.e) it5.next();
            if (!eVar7.f6472c.isEmpty() && !eVar7.f6471b.isEmpty()) {
                arrayList2.add(eVar7.f6470a);
            }
        }
        throw new RuntimeException("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }

    public static String h(C0150g c0150g) {
        StringBuilder sb = new StringBuilder(c0150g.size());
        for (int i4 = 0; i4 < c0150g.size(); i4++) {
            byte a4 = c0150g.a(i4);
            if (a4 != 34) {
                if (a4 != 39) {
                    if (a4 != 92) {
                        switch (a4) {
                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                sb.append("\\a");
                                break;
                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
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
                                if (a4 >= 32 && a4 <= 126) {
                                    sb.append((char) a4);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((a4 >>> 6) & 3) + 48));
                                    sb.append((char) (((a4 >>> 3) & 7) + 48));
                                    sb.append((char) ((a4 & 7) + 48));
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    public static final Class i(Y2.b bVar) {
        h.e(bVar, "<this>");
        Class a4 = ((T2.d) bVar).a();
        if (a4.isPrimitive()) {
            String name = a4.getName();
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
        return a4;
    }

    public static Object j(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return E.c.a(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [t.j, t.e] */
    public static w k(Map map) {
        Object obj = map.get("message");
        Objects.requireNonNull(obj);
        Map map2 = (Map) obj;
        Object obj2 = map2.get("to");
        Objects.requireNonNull(obj2);
        String str = (String) obj2;
        Bundle bundle = new Bundle();
        ?? c0661j = new C0661j(0);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("google.to", str);
            String str2 = (String) map2.get("collapseKey");
            String str3 = (String) map2.get("messageId");
            String str4 = (String) map2.get("messageType");
            Integer num = (Integer) map2.get("ttl");
            Map map3 = (Map) map2.get("data");
            if (str2 != null) {
                bundle.putString("collapse_key", str2);
            }
            if (str4 != null) {
                bundle.putString("message_type", str4);
            }
            if (str3 != null) {
                bundle.putString("google.message_id", str3);
            }
            if (num != null) {
                bundle.putString("google.ttl", String.valueOf(num.intValue()));
            }
            if (map3 != null) {
                c0661j.clear();
                c0661j.putAll(map3);
            }
            Bundle bundle2 = new Bundle();
            Iterator it = ((b0) c0661j.entrySet()).iterator();
            while (true) {
                C0654c c0654c = (C0654c) it;
                if (c0654c.hasNext()) {
                    c0654c.next();
                    C0654c c0654c2 = c0654c;
                    bundle2.putString((String) c0654c2.getKey(), (String) c0654c2.getValue());
                } else {
                    bundle2.putAll(bundle);
                    bundle.remove("from");
                    return new w(bundle2);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid to: ".concat(str));
        }
    }

    public static int l(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return C.b.g(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        } catch (NoSuchMethodException e5) {
            Log.e("IconCompat", "Unable to get icon resource", e5);
            return 0;
        } catch (InvocationTargetException e6) {
            Log.e("IconCompat", "Unable to get icon resource", e6);
            return 0;
        }
    }

    public static String m(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return C.b.h(obj);
        }
        try {
            return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
        } catch (IllegalAccessException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        } catch (NoSuchMethodException e5) {
            Log.e("IconCompat", "Unable to get icon package", e5);
            return null;
        } catch (InvocationTargetException e6) {
            Log.e("IconCompat", "Unable to get icon package", e6);
            return null;
        }
    }

    public static int n(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return C.b.o(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e4) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e4);
            return -1;
        } catch (NoSuchMethodException e5) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e5);
            return -1;
        } catch (InvocationTargetException e6) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e6);
            return -1;
        }
    }

    public static Uri o(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return C.b.p(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        } catch (NoSuchMethodException e5) {
            Log.e("IconCompat", "Unable to get icon uri", e5);
            return null;
        } catch (InvocationTargetException e6) {
            Log.e("IconCompat", "Unable to get icon uri", e6);
            return null;
        }
    }

    public static void p(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q(android.content.Context r4) {
        /*
            android.content.SharedPreferences r0 = q1.AbstractC0602b.E(r4)
            java.lang.String r1 = "proxy_notification_initialized"
            r2 = 0
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 == 0) goto Le
            goto L51
        Le:
            java.lang.String r0 = "firebase_messaging_notification_delegation_enabled"
            android.content.Context r1 = r4.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            android.content.pm.PackageManager r2 = r1.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            if (r2 == 0) goto L37
            java.lang.String r1 = r1.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r1 = r2.getApplicationInfo(r1, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            if (r1 == 0) goto L37
            android.os.Bundle r2 = r1.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            if (r2 == 0) goto L37
            boolean r2 = r2.containsKey(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            if (r2 == 0) goto L37
            android.os.Bundle r1 = r1.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            boolean r0 = r1.getBoolean(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L37
            goto L38
        L37:
            r0 = 1
        L38:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 < r2) goto L4d
            p1.i r1 = new p1.i
            r1.<init>()
            r.m r2 = new r.m
            r3 = 2
            r2.<init>(r3, r4, r1, r0)
            r2.run()
            goto L51
        L4d:
            r4 = 0
            q1.AbstractC0602b.A(r4)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.b.q(android.content.Context):void");
    }

    public static d r(d dVar) {
        c cVar;
        d dVar2;
        h.e(dVar, "<this>");
        if (dVar instanceof c) {
            cVar = (c) dVar;
        } else {
            cVar = null;
        }
        if (cVar != null && (dVar = cVar.f1053h) == null) {
            K2.f fVar = (K2.f) cVar.getContext().e(K2.e.f941f);
            if (fVar != null) {
                dVar2 = new g3.f((AbstractC0242q) fVar, cVar);
            } else {
                dVar2 = cVar;
            }
            cVar.f1053h = dVar2;
            return dVar2;
        }
        return dVar;
    }

    public static boolean s() {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC0433a.c();
        }
        try {
            if (f5118j == null) {
                f5117i = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f5118j = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f5118j.invoke(null, Long.valueOf(f5117i))).booleanValue();
        } catch (Exception e4) {
            p("isTagEnabled", e4);
            return false;
        }
    }

    public static s0.h t(String str) {
        String group;
        String str2;
        if (str != null && !a3.h.D(str)) {
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (matcher.matches() && (group = matcher.group(1)) != null) {
                int parseInt = Integer.parseInt(group);
                String group2 = matcher.group(2);
                if (group2 != null) {
                    int parseInt2 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    if (group3 != null) {
                        int parseInt3 = Integer.parseInt(group3);
                        if (matcher.group(4) != null) {
                            str2 = matcher.group(4);
                        } else {
                            str2 = "";
                        }
                        h.d(str2, "description");
                        return new s0.h(parseInt, parseInt2, parseInt3, str2);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [I.H, U.b] */
    public static U.b u(MappedByteBuffer mappedByteBuffer) {
        long j4;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i4 = duplicate.getShort() & 65535;
        if (i4 <= 100) {
            duplicate.position(duplicate.position() + 6);
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    int i6 = duplicate.getInt();
                    duplicate.position(duplicate.position() + 4);
                    j4 = duplicate.getInt() & 4294967295L;
                    duplicate.position(duplicate.position() + 4);
                    if (1835365473 == i6) {
                        break;
                    }
                    i5++;
                } else {
                    j4 = -1;
                    break;
                }
            }
            if (j4 != -1) {
                duplicate.position(duplicate.position() + ((int) (j4 - duplicate.position())));
                duplicate.position(duplicate.position() + 12);
                long j5 = duplicate.getInt() & 4294967295L;
                for (int i7 = 0; i7 < j5; i7++) {
                    int i8 = duplicate.getInt();
                    long j6 = duplicate.getInt() & 4294967295L;
                    duplicate.getInt();
                    if (1164798569 == i8 || 1701669481 == i8) {
                        duplicate.position((int) (j6 + j4));
                        ?? h3 = new H();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int position = duplicate.position() + duplicate.getInt(duplicate.position());
                        h3.f694d = duplicate;
                        h3.f691a = position;
                        int i9 = position - duplicate.getInt(position);
                        h3.f692b = i9;
                        h3.f693c = ((ByteBuffer) h3.f694d).getShort(i9);
                        return h3;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    public static HashMap v(w wVar) {
        int parseInt;
        long parseLong;
        Uri uri;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        String string = wVar.f1465f.getString("collapse_key");
        Bundle bundle = wVar.f1465f;
        if (string != null) {
            hashMap.put("collapseKey", bundle.getString("collapse_key"));
        }
        if (wVar.f1465f.getString("from") != null) {
            hashMap.put("from", wVar.f1465f.getString("from"));
        }
        if (wVar.f1465f.getString("google.to") != null) {
            hashMap.put("to", wVar.f1465f.getString("google.to"));
        }
        if (wVar.b() != null) {
            hashMap.put("messageId", wVar.b());
        }
        if (wVar.f1465f.getString("message_type") != null) {
            hashMap.put("messageType", wVar.f1465f.getString("message_type"));
        }
        if (!wVar.a().isEmpty()) {
            for (Map.Entry entry : wVar.a().entrySet()) {
                hashMap2.put((String) entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("data", hashMap2);
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            parseInt = ((Integer) obj).intValue();
        } else {
            if (obj instanceof String) {
                try {
                    parseInt = Integer.parseInt((String) obj);
                } catch (NumberFormatException unused) {
                    Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
                }
            }
            parseInt = 0;
        }
        hashMap.put("ttl", Integer.valueOf(parseInt));
        Object obj2 = bundle.get("google.sent_time");
        if (obj2 instanceof Long) {
            parseLong = ((Long) obj2).longValue();
        } else {
            if (obj2 instanceof String) {
                try {
                    parseLong = Long.parseLong((String) obj2);
                } catch (NumberFormatException unused2) {
                    Log.w("FirebaseMessaging", "Invalid sent time: " + obj2);
                }
            }
            parseLong = 0;
        }
        hashMap.put("sentTime", Long.valueOf(parseLong));
        if (wVar.c() != null) {
            v c4 = wVar.c();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            String str = c4.f1448a;
            String str2 = c4.f1455h;
            if (str != null) {
                hashMap3.put("title", str);
            }
            String str3 = c4.f1449b;
            if (str3 != null) {
                hashMap3.put("titleLocKey", str3);
            }
            String[] strArr = c4.f1450c;
            if (strArr != null) {
                hashMap3.put("titleLocArgs", Arrays.asList(strArr));
            }
            String str4 = c4.f1451d;
            if (str4 != null) {
                hashMap3.put("body", str4);
            }
            String str5 = c4.f1452e;
            if (str5 != null) {
                hashMap3.put("bodyLocKey", str5);
            }
            String[] strArr2 = c4.f1453f;
            if (strArr2 != null) {
                hashMap3.put("bodyLocArgs", Arrays.asList(strArr2));
            }
            String str6 = c4.f1459m;
            if (str6 != null) {
                hashMap4.put("channelId", str6);
            }
            String str7 = c4.f1458l;
            if (str7 != null) {
                hashMap4.put("clickAction", str7);
            }
            String str8 = c4.k;
            if (str8 != null) {
                hashMap4.put("color", str8);
            }
            String str9 = c4.f1454g;
            if (str9 != null) {
                hashMap4.put("smallIcon", str9);
            }
            Uri uri2 = null;
            if (str2 != null) {
                uri = Uri.parse(str2);
            } else {
                uri = null;
            }
            if (uri != null) {
                if (str2 != null) {
                    uri2 = Uri.parse(str2);
                }
                hashMap4.put("imageUrl", uri2.toString());
            }
            Uri uri3 = c4.f1460n;
            if (uri3 != null) {
                hashMap4.put("link", uri3.toString());
            }
            Integer num = c4.f1464r;
            if (num != null) {
                hashMap4.put("count", num);
            }
            Integer num2 = c4.f1462p;
            if (num2 != null) {
                hashMap4.put("priority", num2);
            }
            String str10 = c4.f1456i;
            if (str10 != null) {
                hashMap4.put("sound", str10);
            }
            String str11 = c4.f1461o;
            if (str11 != null) {
                hashMap4.put("ticker", str11);
            }
            Integer num3 = c4.f1463q;
            if (num3 != null) {
                hashMap4.put("visibility", num3);
            }
            String str12 = c4.f1457j;
            if (str12 != null) {
                hashMap4.put("tag", str12);
            }
            hashMap3.put("android", hashMap4);
            hashMap.put("notification", hashMap3);
        }
        return hashMap;
    }

    public static void y(InterfaceC0634f interfaceC0634f, final C0030i c0030i) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0030i != null && (l3 = c0030i.f401a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.cancel", a4, null);
        if (c0030i != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.y
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    switch (i4) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
                            try {
                                c0030i2.getClass();
                                clientCertRequest.cancel();
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest2 = (ClientCertRequest) obj3;
                            try {
                                c0030i3.getClass();
                                clientCertRequest2.ignore();
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        default:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest3 = (ClientCertRequest) obj4;
                            Object obj5 = list.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type java.security.PrivateKey");
                            PrivateKey privateKey = (PrivateKey) obj5;
                            Object obj6 = list.get(2);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>");
                            List list2 = (List) obj6;
                            try {
                                c0030i4.getClass();
                                clientCertRequest3.proceed(privateKey, (X509Certificate[]) list2.toArray(new X509Certificate[0]));
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.ignore", a4, null);
        if (c0030i != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.y
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    switch (i5) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
                            try {
                                c0030i2.getClass();
                                clientCertRequest.cancel();
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest2 = (ClientCertRequest) obj3;
                            try {
                                c0030i3.getClass();
                                clientCertRequest2.ignore();
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        default:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest3 = (ClientCertRequest) obj4;
                            Object obj5 = list.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type java.security.PrivateKey");
                            PrivateKey privateKey = (PrivateKey) obj5;
                            Object obj6 = list.get(2);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>");
                            List list2 = (List) obj6;
                            try {
                                c0030i4.getClass();
                                clientCertRequest3.proceed(privateKey, (X509Certificate[]) list2.toArray(new X509Certificate[0]));
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.proceed", a4, null);
        if (c0030i != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.y
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    switch (i6) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
                            try {
                                c0030i2.getClass();
                                clientCertRequest.cancel();
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest2 = (ClientCertRequest) obj3;
                            try {
                                c0030i3.getClass();
                                clientCertRequest2.ignore();
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        default:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
                            ClientCertRequest clientCertRequest3 = (ClientCertRequest) obj4;
                            Object obj5 = list.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type java.security.PrivateKey");
                            PrivateKey privateKey = (PrivateKey) obj5;
                            Object obj6 = list.get(2);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>");
                            List list2 = (List) obj6;
                            try {
                                c0030i4.getClass();
                                clientCertRequest3.proceed(privateKey, (X509Certificate[]) list2.toArray(new X509Certificate[0]));
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
    }

    public static void z(InterfaceC0634f interfaceC0634f, final C0030i c0030i) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0030i != null && (l3 = c0030i.f401a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getCName", a4, null);
        if (c0030i != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.D
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i4) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(dName.getCName());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c0030i3.getClass();
                                C4 = android.support.v4.media.session.a.p(dName2.getDName());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c0030i4.getClass();
                                C5 = android.support.v4.media.session.a.p(dName3.getOName());
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c0030i5.getClass();
                                C6 = android.support.v4.media.session.a.p(dName4.getUName());
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getDName", a4, null);
        if (c0030i != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.D
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i5) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(dName.getCName());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c0030i3.getClass();
                                C4 = android.support.v4.media.session.a.p(dName2.getDName());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c0030i4.getClass();
                                C5 = android.support.v4.media.session.a.p(dName3.getOName());
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c0030i5.getClass();
                                C6 = android.support.v4.media.session.a.p(dName4.getUName());
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getOName", a4, null);
        if (c0030i != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.D
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i6) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(dName.getCName());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c0030i3.getClass();
                                C4 = android.support.v4.media.session.a.p(dName2.getDName());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c0030i4.getClass();
                                C5 = android.support.v4.media.session.a.p(dName3.getOName());
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c0030i5.getClass();
                                C6 = android.support.v4.media.session.a.p(dName4.getUName());
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getUName", a4, null);
        if (c0030i != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b() { // from class: D2.D
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i7) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(dName.getCName());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c0030i3.getClass();
                                C4 = android.support.v4.media.session.a.p(dName2.getDName());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c0030i4.getClass();
                                C5 = android.support.v4.media.session.a.p(dName3.getOName());
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate.DName");
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c0030i5.getClass();
                                C6 = android.support.v4.media.session.a.p(dName4.getUName());
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
    }

    public abstract void x(boolean z);

    public void w(boolean z) {
    }
}
