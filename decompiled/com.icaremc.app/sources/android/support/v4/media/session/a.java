package android.support.v4.media.session;

import A2.q;
import D2.C0024c;
import D2.C0026e;
import D2.C0030i;
import D2.C0034m;
import D2.L;
import H2.g;
import I.Z;
import K2.c;
import K2.i;
import K2.j;
import L.f;
import P1.C0100d;
import P1.y;
import S2.l;
import T2.h;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.widget.EdgeEffect;
import android.widget.TextView;
import android.window.BackEvent;
import androidx.fragment.app.c0;
import b3.A;
import b3.P;
import b3.r;
import i2.C0368c;
import i3.d;
import i3.e;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import r2.k;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;
import x.H;
import x.InterfaceC0701a;
import z1.C0748a;

/* loaded from: classes.dex */
public abstract class a implements Z, f {
    public a(c0 c0Var) {
        h.e(c0Var, "operation");
    }

    public static String A(String str, Object... objArr) {
        int length;
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i4 = 0;
        int i5 = 0;
        while (true) {
            length = objArr.length;
            if (i4 >= length || (indexOf = str.indexOf("%s", i5)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i5, indexOf);
            sb.append(B(objArr[i4]));
            i5 = indexOf + 2;
            i4++;
        }
        sb.append((CharSequence) str, i5, str.length());
        if (i4 < length) {
            String str2 = " [";
            while (i4 < objArr.length) {
                sb.append(str2);
                sb.append(B(objArr[i4]));
                i4++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String B(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e4) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
            sb.append(name);
            sb.append("@");
            sb.append(hexString);
            String sb2 = sb.toString();
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(sb2), (Throwable) e4);
            String name2 = e4.getClass().getName();
            StringBuilder sb3 = new StringBuilder(sb2.length() + 8 + name2.length() + 1);
            sb3.append("<");
            sb3.append(sb2);
            sb3.append(" threw ");
            sb3.append(name2);
            sb3.append(">");
            return sb3.toString();
        }
    }

    public static final d0.b d(BackEvent backEvent) {
        float touchX;
        float touchY;
        float progress;
        int swipeEdge;
        long j4;
        touchX = backEvent.getTouchX();
        touchY = backEvent.getTouchY();
        progress = backEvent.getProgress();
        swipeEdge = backEvent.getSwipeEdge();
        if (Build.VERSION.SDK_INT >= 36) {
            j4 = backEvent.getFrameTimeMillis();
        } else {
            j4 = 0;
        }
        return new d0.b(swipeEdge, progress, touchX, touchY, j4);
    }

    public static void g(float f4, String str) {
        if (!Float.isNaN(f4)) {
            if (!Float.isInfinite(f4)) {
                return;
            } else {
                throw new IllegalArgumentException(str.concat(" must not be infinite"));
            }
        }
        throw new IllegalArgumentException(str.concat(" must not be NaN"));
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static int i(Context context, String str) {
        if (str != null) {
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                if (new H(context).f6329b.areNotificationsEnabled()) {
                    return 0;
                }
                return -1;
            }
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static int j(Context context, String str) {
        int noteProxyOpNoThrow;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) != -1) {
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (permissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int myUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (myUid2 == myUid && Objects.equals(packageName2, packageName)) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                        int callingUid = Binder.getCallingUid();
                        int i4 = 1;
                        if (appOpsManager == null) {
                            noteProxyOpNoThrow = 1;
                        } else {
                            noteProxyOpNoThrow = appOpsManager.checkOpNoThrow(permissionToOp, callingUid, packageName);
                        }
                        if (noteProxyOpNoThrow == 0) {
                            String a4 = B.b.a(context);
                            if (appOpsManager != null) {
                                i4 = appOpsManager.checkOpNoThrow(permissionToOp, myUid, a4);
                            }
                            noteProxyOpNoThrow = i4;
                        }
                    } else {
                        noteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName);
                    }
                } else {
                    noteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName);
                }
                if (noteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static byte[] k(ArrayDeque arrayDeque, int i4) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i4) {
            return bArr;
        }
        int length = i4 - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, i4);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i4 - length, min);
            length -= min;
        }
        return copyOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [Z0.g] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static T.r l(android.content.Context r13) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Lc
            T.c r0 = new T.c
            r0.<init>()
            goto L11
        Lc:
            Z0.g r0 = new Z0.g
            r0.<init>()
        L11:
            android.content.pm.PackageManager r1 = r13.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            h(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2a:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L46
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2a
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2a
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2a
            goto L47
        L46:
            r4 = r5
        L47:
            if (r4 != 0) goto L4b
        L49:
            r6 = r5
            goto L7c
        L4b:
            java.lang.String r7 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r8 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            android.content.pm.Signature[] r0 = r0.f(r1, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r2 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
        L59:
            if (r3 >= r2) goto L67
            r4 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            byte[] r4 = r4.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.add(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r3 = r3 + 1
            goto L59
        L67:
            java.util.List r10 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            F.f r6 = new F.f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r9 = "emojicompat-emoji-font"
            r11 = 0
            r12 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            goto L7c
        L75:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L49
        L7c:
            if (r6 != 0) goto L7f
            goto L89
        L7f:
            T.r r5 = new T.r
            T.q r0 = new T.q
            r0.<init>(r13, r6)
            r5.<init>(r0)
        L89:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.a.l(android.content.Context):T.r");
    }

    public static float m(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return L.b.b(edgeEffect);
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r0 >= 2) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int n(A2.C0006e r5) {
        /*
            java.lang.Long r5 = r5.f73c
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 >= r1) goto L18
            r1 = 30
            if (r0 < r1) goto L14
            int r0 = F2.b.C()
            r1 = 2
            if (r0 < r1) goto L14
            goto L18
        L14:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L1c
        L18:
            int r0 = A2.m.a()
        L1c:
            if (r5 == 0) goto L30
            long r1 = r5.longValue()
            long r3 = (long) r0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L30
            long r0 = r5.longValue()
            int r5 = java.lang.Math.toIntExact(r0)
            return r5
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.a.n(A2.e):int");
    }

    public static List p(Object obj) {
        List singletonList = Collections.singletonList(obj);
        h.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static void q(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
    }

    public static float r(EdgeEffect edgeEffect, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 31) {
            return L.b.c(edgeEffect, f4, f5);
        }
        edgeEffect.onPull(f4, f5);
        return f4;
    }

    public static R.b s(String str, q qVar, C0748a c0748a, int i4) {
        c cVar;
        if ((i4 & 2) != 0) {
            qVar = null;
        }
        l lVar = c0748a;
        if ((i4 & 4) != 0) {
            lVar = R.a.f1514g;
        }
        e eVar = A.f3236a;
        i iVar = d.f4172h;
        P p3 = new P();
        iVar.getClass();
        j jVar = j.f942f;
        if (p3 != jVar) {
            i c4 = iVar.c(p3.getKey());
            if (c4 == jVar) {
                iVar = p3;
            } else {
                K2.e eVar2 = K2.e.f941f;
                K2.f fVar = (K2.f) c4.e(eVar2);
                if (fVar == null) {
                    cVar = new c(c4, p3);
                } else {
                    i c5 = c4.c(eVar2);
                    if (c5 == jVar) {
                        iVar = new c(p3, fVar);
                    } else {
                        cVar = new c(new c(c5, p3), fVar);
                    }
                }
                iVar = cVar;
            }
        }
        if (iVar.e(r.f3295g) == null) {
            iVar = iVar.j(new P());
        }
        g3.c cVar2 = new g3.c(iVar);
        h.e(str, "name");
        return new R.b(str, qVar, lVar, cVar2);
    }

    public static void t(C0368c c0368c) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", C0368c.class).invoke(null, c0368c);
        } catch (Exception e4) {
            Log.e("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + c0368c + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e("GeneratedPluginsRegister", "Received exception while registering", e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void u(Activity activity, String[] strArr, int i4) {
        String[] strArr2;
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (!TextUtils.isEmpty(strArr[i5])) {
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i5], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i5));
                }
            } else {
                throw new IllegalArgumentException(k.c(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[strArr.length - size];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < strArr.length; i7++) {
                if (!hashSet.contains(Integer.valueOf(i7))) {
                    strArr2[i6] = strArr[i7];
                    i6++;
                }
            }
        }
        if (activity instanceof InterfaceC0701a) {
            ((InterfaceC0701a) activity).validateRequestPermissionsRequestCode(i4);
        }
        activity.requestPermissions(strArr, i4);
    }

    public static void v(InterfaceC0634f interfaceC0634f, final C0024c c0024c) {
        h.e(interfaceC0634f, "binaryMessenger");
        g gVar = C0026e.f381b;
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", (InterfaceC0640l) gVar.a(), null);
        if (c0024c != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    switch (i4) {
                        case 0:
                            C0024c c0024c2 = c0024c;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            Long l3 = (Long) obj2;
                            long longValue = l3.longValue();
                            try {
                                c0024c2.f();
                                Object e4 = c0024c2.e(longValue);
                                if (e4 instanceof h0) {
                                    ((h0) e4).destroy();
                                }
                                c0024c2.f365d.remove(l3);
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
                        default:
                            C0024c c0024c3 = c0024c;
                            try {
                                c0024c3.f363b.clear();
                                c0024c3.f364c.clear();
                                c0024c3.f365d.clear();
                                c0024c3.f367f.clear();
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
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.clear", (InterfaceC0640l) gVar.a(), null);
        if (c0024c != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    switch (i5) {
                        case 0:
                            C0024c c0024c2 = c0024c;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            Long l3 = (Long) obj2;
                            long longValue = l3.longValue();
                            try {
                                c0024c2.f();
                                Object e4 = c0024c2.e(longValue);
                                if (e4 instanceof h0) {
                                    ((h0) e4).destroy();
                                }
                                c0024c2.f365d.remove(l3);
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
                        default:
                            C0024c c0024c3 = c0024c;
                            try {
                                c0024c3.f363b.clear();
                                c0024c3.f364c.clear();
                                c0024c3.f365d.clear();
                                c0024c3.f367f.clear();
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
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
    }

    public static void w(InterfaceC0634f interfaceC0634f, final C0030i c0030i) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0030i != null && (l3 = c0030i.f401a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A2.A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.useHttpAuthUsernamePassword", a4, null);
        if (c0030i != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.B
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
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(httpAuthHandler.useHttpAuthUsernamePassword()));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler2 = (HttpAuthHandler) obj3;
                            try {
                                c0030i3.getClass();
                                httpAuthHandler2.cancel();
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
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler3 = (HttpAuthHandler) obj4;
                            Object obj5 = list.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj5;
                            Object obj6 = list.get(2);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj6;
                            try {
                                c0030i4.getClass();
                                httpAuthHandler3.proceed(str, str2);
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
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.cancel", a4, null);
        if (c0030i != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.B
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
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(httpAuthHandler.useHttpAuthUsernamePassword()));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler2 = (HttpAuthHandler) obj3;
                            try {
                                c0030i3.getClass();
                                httpAuthHandler2.cancel();
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
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler3 = (HttpAuthHandler) obj4;
                            Object obj5 = list.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj5;
                            Object obj6 = list.get(2);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj6;
                            try {
                                c0030i4.getClass();
                                httpAuthHandler3.proceed(str, str2);
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
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.proceed", a4, null);
        if (c0030i != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.B
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
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
                            try {
                                c0030i2.getClass();
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(httpAuthHandler.useHttpAuthUsernamePassword()));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler2 = (HttpAuthHandler) obj3;
                            try {
                                c0030i3.getClass();
                                httpAuthHandler2.cancel();
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
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
                            HttpAuthHandler httpAuthHandler3 = (HttpAuthHandler) obj4;
                            Object obj5 = list.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj5;
                            Object obj6 = list.get(2);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj6;
                            try {
                                c0030i4.getClass();
                                httpAuthHandler3.proceed(str, str2);
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

    public static void x(InterfaceC0634f interfaceC0634f, final C0034m c0034m) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0034m != null && (l3 = c0034m.f416a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A2.A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setDomStorageEnabled", a4, null);
        if (c0034m != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i4) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setJavaScriptCanOpenWindowsAutomatically", a4, null);
        if (c0034m != null) {
            final int i5 = 15;
            yVar2.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i5) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setSupportMultipleWindows", a4, null);
        if (c0034m != null) {
            final int i6 = 16;
            yVar3.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i6) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setJavaScriptEnabled", a4, null);
        if (c0034m != null) {
            final int i7 = 1;
            yVar4.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i7) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setUserAgentString", a4, null);
        if (c0034m != null) {
            final int i8 = 2;
            yVar5.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i8) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
        y yVar6 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setMediaPlaybackRequiresUserGesture", a4, null);
        if (c0034m != null) {
            final int i9 = 3;
            yVar6.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i9) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar6.w(null);
        }
        y yVar7 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setSupportZoom", a4, null);
        if (c0034m != null) {
            final int i10 = 4;
            yVar7.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i10) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar7.w(null);
        }
        y yVar8 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setLoadWithOverviewMode", a4, null);
        if (c0034m != null) {
            final int i11 = 5;
            yVar8.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i11) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar8.w(null);
        }
        y yVar9 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setUseWideViewPort", a4, null);
        if (c0034m != null) {
            final int i12 = 6;
            yVar9.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i12) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar9.w(null);
        }
        y yVar10 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setDisplayZoomControls", a4, null);
        if (c0034m != null) {
            final int i13 = 7;
            yVar10.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i13) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar10.w(null);
        }
        y yVar11 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setBuiltInZoomControls", a4, null);
        if (c0034m != null) {
            final int i14 = 8;
            yVar11.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i14) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar11.w(null);
        }
        y yVar12 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setAllowFileAccess", a4, null);
        if (c0034m != null) {
            final int i15 = 9;
            yVar12.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i15) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar12.w(null);
        }
        y yVar13 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setAllowContentAccess", a4, null);
        if (c0034m != null) {
            final int i16 = 10;
            yVar13.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i16) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar13.w(null);
        }
        y yVar14 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setGeolocationEnabled", a4, null);
        if (c0034m != null) {
            final int i17 = 11;
            yVar14.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i17) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar14.w(null);
        }
        y yVar15 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setTextZoom", a4, null);
        if (c0034m != null) {
            final int i18 = 12;
            yVar15.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i18) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar15.w(null);
        }
        y yVar16 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.getUserAgentString", a4, null);
        if (c0034m != null) {
            final int i19 = 13;
            yVar16.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i19) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar16.w(null);
        }
        y yVar17 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setMixedContentMode", a4, null);
        if (c0034m != null) {
            final int i20 = 14;
            yVar17.w(new InterfaceC0630b() { // from class: D2.H
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    switch (i20) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c0034m2.getClass();
                                webSettings.setDomStorageEnabled(booleanValue);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c0034m3.getClass();
                                webSettings2.setJavaScriptEnabled(booleanValue2);
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
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c0034m4.getClass();
                                webSettings3.setUserAgentString(str);
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
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0034m5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(booleanValue3);
                                C6 = android.support.v4.media.session.a.p(null);
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
                        case 4:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m6.getClass();
                                webSettings5.setSupportZoom(booleanValue4);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0034m c0034m7 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m7.getClass();
                                webSettings6.setLoadWithOverviewMode(booleanValue5);
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0034m c0034m8 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c0034m8.getClass();
                                webSettings7.setUseWideViewPort(booleanValue6);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0034m c0034m9 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c0034m9.getClass();
                                webSettings8.setDisplayZoomControls(booleanValue7);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0034m c0034m10 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c0034m10.getClass();
                                webSettings9.setBuiltInZoomControls(booleanValue8);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0034m c0034m11 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c0034m11.getClass();
                                webSettings10.setAllowFileAccess(booleanValue9);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0034m c0034m12 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c0034m12.getClass();
                                webSettings11.setAllowContentAccess(booleanValue10);
                                C13 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0034m c0034m13 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c0034m13.getClass();
                                webSettings12.setGeolocationEnabled(booleanValue11);
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0034m c0034m14 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj26).longValue();
                            try {
                                c0034m14.getClass();
                                webSettings13.setTextZoom((int) longValue);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0034m c0034m15 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj27 = ((List) obj).get(0);
                            T2.h.c(obj27, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c0034m15.getClass();
                                C16 = android.support.v4.media.session.a.p(webSettings14.getUserAgentString());
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0034m c0034m16 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
                            EnumC0043w enumC0043w = (EnumC0043w) obj29;
                            try {
                                c0034m16.getClass();
                                int ordinal = enumC0043w.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal == 2) {
                                            webSettings15.setMixedContentMode(1);
                                        }
                                    } else {
                                        webSettings15.setMixedContentMode(2);
                                    }
                                } else {
                                    webSettings15.setMixedContentMode(0);
                                }
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0034m c0034m17 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c0034m17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(booleanValue12);
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        default:
                            C0034m c0034m18 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebSettings");
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c0034m18.getClass();
                                webSettings17.setSupportMultipleWindows(booleanValue13);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                    }
                }
            });
        } else {
            yVar17.w(null);
        }
    }

    public static byte[] y(C0100d c0100d) {
        int i4;
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i5 = 0;
        while (i5 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i5);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = c0100d.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return k(arrayDeque, i5);
                }
                i6 += read;
                i5 += read;
            }
            long j4 = min;
            if (min < 4096) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            long j5 = j4 * i4;
            if (j5 > 2147483647L) {
                min = Integer.MAX_VALUE;
            } else if (j5 < -2147483648L) {
                min = Integer.MIN_VALUE;
            } else {
                min = (int) j5;
            }
        }
        if (c0100d.read() == -1) {
            return k(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static ArrayList z(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }

    public X0.c e(Context context, Looper looper, I0.h hVar, Object obj, X0.f fVar, X0.g gVar) {
        return f(context, looper, hVar, obj, (Y0.k) fVar, (Y0.k) gVar);
    }

    public X0.c f(Context context, Looper looper, I0.h hVar, Object obj, Y0.k kVar, Y0.k kVar2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public boolean o() {
        throw null;
    }

    @Override // I.Z
    public void b() {
    }

    @Override // I.Z
    public void c() {
    }
}
