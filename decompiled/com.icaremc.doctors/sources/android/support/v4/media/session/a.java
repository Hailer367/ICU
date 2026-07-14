package android.support.v4.media.session;

import E.AbstractC0005e;
import E.AbstractC0015o;
import K.InterfaceC0034i;
import R0.f;
import T0.i;
import T0.j;
import a0.C0056E;
import a0.C0073o;
import a0.v;
import a0.w;
import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.os.Trace;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.BackEvent;
import c1.l;
import c1.p;
import com.google.firebase.encoders.json.BuildConfig;
import d0.AbstractC0175a;
import g.g;
import i0.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.t;
import l1.AbstractC0244w;
import l1.C;
import l1.C0238p;
import l1.C0241t;
import l1.Q;
import m.C0273u;
import q1.c;
import q1.q;
import s1.d;
import s1.e;
import u.H;
import u.InterfaceC0310a;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f1053a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static Method f1054b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Method f1055c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Method f1056d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1057e = true;

    public static h A(String str) {
        String group;
        String description;
        if (str != null && !k1.h.P(str)) {
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
                            description = matcher.group(4);
                        } else {
                            description = BuildConfig.FLAVOR;
                        }
                        kotlin.jvm.internal.h.d(description, "description");
                        return new h(parseInt, parseInt2, parseInt3, description);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static N.b B(String str, F.h hVar, com.google.firebase.datastorage.a aVar, int i2) {
        if ((i2 & 2) != 0) {
            hVar = null;
        }
        l lVar = aVar;
        if ((i2 & 4) != 0) {
            lVar = N.a.f612c;
        }
        e eVar = C.f2950a;
        i iVar = d.f3615e;
        Q q = new Q();
        iVar.getClass();
        if (q != j.f774c) {
            iVar = (i) q.c(iVar, new T0.b(1));
        }
        if (iVar.k(C0241t.f3012d) == null) {
            iVar = iVar.d(new Q());
        }
        return new N.b(str, hVar, lVar, new c(iVar));
    }

    public static void C(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            AbstractC0015o.h(context, broadcastReceiver, intentFilter);
        } else if (i2 >= 26) {
            AbstractC0015o.g(context, broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void D(Activity activity, String[] strArr, int i2) {
        String[] strArr2;
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (!TextUtils.isEmpty(strArr[i3])) {
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i3));
                }
            } else {
                throw new IllegalArgumentException(O.a.i(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
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
            int i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (!hashSet.contains(Integer.valueOf(i5))) {
                    strArr2[i4] = strArr[i5];
                    i4++;
                }
            }
        }
        if (activity instanceof InterfaceC0310a) {
            ((InterfaceC0310a) activity).validateRequestPermissionsRequestCode(i2);
        }
        activity.requestPermissions(strArr, i2);
    }

    public static void E(TextView textView, int i2) {
        int i3;
        if (i2 >= 0) {
            if (Build.VERSION.SDK_INT >= 28) {
                AbstractC0005e.p(textView, i2);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i3 = fontMetricsInt.top;
            } else {
                i3 = fontMetricsInt.ascent;
            }
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void F(TextView textView, int i2) {
        int i3;
        if (i2 >= 0) {
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i3 = fontMetricsInt.bottom;
            } else {
                i3 = fontMetricsInt.descent;
            }
            if (i2 > Math.abs(i3)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static final Object G(q qVar, q qVar2, p pVar) {
        Object c0238p;
        Object F2;
        try {
            t.a(2, pVar);
            c0238p = pVar.invoke(qVar2, qVar);
        } catch (Throwable th) {
            c0238p = new C0238p(th, false);
        }
        U0.a aVar = U0.a.f780c;
        if (c0238p != aVar && (F2 = qVar.F(c0238p)) != AbstractC0244w.f3019d) {
            if (!(F2 instanceof C0238p)) {
                return AbstractC0244w.k(F2);
            }
            throw ((C0238p) F2).f3007a;
        }
        return aVar;
    }

    public static void H(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (f1057e) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f1057e = false;
            }
        }
    }

    public static int I(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static String J(String str) {
        if (str.length() <= 127) {
            return str;
        }
        return str.substring(0, 127);
    }

    public static ActionMode.Callback K(ActionMode.Callback callback, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && i2 <= 27 && !(callback instanceof H.i) && callback != null) {
            return new H.i(callback, textView);
        }
        return callback;
    }

    public static Object L(p pVar, Object obj, T0.d dVar) {
        V0.a cVar;
        kotlin.jvm.internal.h.e(pVar, "<this>");
        i context = dVar.getContext();
        if (context == j.f774c) {
            cVar = new V0.a(dVar);
            if (dVar.getContext() != j.f774c) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
            }
        } else {
            cVar = new V0.c(dVar, context);
        }
        t.a(2, pVar);
        return pVar.invoke(obj, cVar);
    }

    public static final W.b a(BackEvent backEvent) {
        float touchX;
        float touchY;
        float progress;
        int swipeEdge;
        long j2;
        touchX = backEvent.getTouchX();
        touchY = backEvent.getTouchY();
        progress = backEvent.getProgress();
        swipeEdge = backEvent.getSwipeEdge();
        if (Build.VERSION.SDK_INT >= 36) {
            j2 = backEvent.getFrameTimeMillis();
        } else {
            j2 = 0;
        }
        return new W.b(swipeEdge, progress, touchX, touchY, j2);
    }

    public static final String b(Object[] objArr, int i2, int i3, f fVar) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2 + i4];
            if (obj == fVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.d(sb2, "toString(...)");
        return sb2;
    }

    public static void c(Throwable th, Throwable exception) {
        kotlin.jvm.internal.h.e(th, "<this>");
        kotlin.jvm.internal.h.e(exception, "exception");
        if (th != exception) {
            Integer num = Y0.a.f881a;
            if (num != null && num.intValue() < 19) {
                Method method = X0.a.f836a;
                if (method != null) {
                    method.invoke(th, exception);
                    return;
                }
                return;
            }
            th.addSuppressed(exception);
        }
    }

    public static void d(int i2, int i3, int i4) {
        if (i2 >= 0 && i3 <= i4) {
            if (i2 <= i3) {
                return;
            } else {
                throw new IllegalArgumentException(O.a.d("fromIndex: ", i2, " > toIndex: ", i3));
            }
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
    }

    public static int e(Context context, String str) {
        if (str != null) {
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                if (new H(context).f3699b.areNotificationsEnabled()) {
                    return 0;
                }
                return -1;
            }
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static int f(C0056E c0056e, C0073o c0073o, View view, View view2, v vVar, boolean z) {
        int s2;
        int t2;
        if (vVar.p() != 0 && c0056e.a() != 0 && view != null && view2 != null) {
            if (z) {
                int b2 = c0073o.b(view2) - c0073o.c(view);
                switch (c0073o.f999b) {
                    case 0:
                        v vVar2 = c0073o.f998a;
                        s2 = vVar2.f1011f - vVar2.s();
                        t2 = vVar2.t();
                        break;
                    default:
                        v vVar3 = c0073o.f998a;
                        s2 = vVar3.f1012g - vVar3.u();
                        t2 = vVar3.r();
                        break;
                }
                return Math.min(s2 - t2, b2);
            }
            ((w) view.getLayoutParams()).getClass();
            throw null;
        }
        return 0;
    }

    public static int g(C0056E c0056e, C0073o c0073o, View view, View view2, v vVar, boolean z) {
        if (vVar.p() != 0 && c0056e.a() != 0 && view != null && view2 != null) {
            if (!z) {
                return c0056e.a();
            }
            c0073o.b(view2);
            c0073o.c(view);
            ((w) view.getLayoutParams()).getClass();
            throw null;
        }
        return 0;
    }

    public static boolean h(File file, Resources resources, int i2) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i2);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean i3 = i(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return i3;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean i(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            fileOutputStream.close();
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static void j(String str, String str2, Object obj) {
        String p = p(str);
        if (Log.isLoggable(p, 3)) {
            Log.d(p, String.format(str2, obj));
        }
    }

    public static void k(String str, String str2, Exception exc) {
        String p = p(str);
        if (Log.isLoggable(p, 6)) {
            Log.e(p, str2, exc);
        }
    }

    public static final Object l(InterfaceC0034i interfaceC0034i, p pVar, T0.d dVar) {
        return interfaceC0034i.h(new O.j(pVar, null), dVar);
    }

    public static int m(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i2;
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r2 = r2.getRoundedCorner(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static E.C0021v n(android.view.Display r2, int r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L37
            android.view.RoundedCorner r2 = E.AbstractC0004d.k(r2, r3)
            if (r2 == 0) goto L37
            E.v r3 = new E.v
            int r0 = E.AbstractC0004d.c(r2)
            if (r0 == 0) goto L2a
            r1 = 1
            if (r0 == r1) goto L2b
            r1 = 2
            if (r0 == r1) goto L2b
            r1 = 3
            if (r0 != r1) goto L1e
            goto L2b
        L1e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid position: "
            java.lang.String r3 = O.a.c(r0, r3)
            r2.<init>(r3)
            throw r2
        L2a:
            r1 = 0
        L2b:
            int r0 = E.AbstractC0004d.v(r2)
            android.graphics.Point r2 = E.AbstractC0004d.e(r2)
            r3.<init>(r1, r0, r2)
            return r3
        L37:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.a.n(android.view.Display, int):E.v");
    }

    public static ResolveInfo o(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
    }

    public static String p(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            String concat = "TRuntime.".concat(str);
            if (concat.length() > 23) {
                return concat.substring(0, 23);
            }
            return concat;
        }
        return "TRuntime.".concat(str);
    }

    public static File q(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, str + i2);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static C.c r(C0273u c0273u) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new C.c(AbstractC0005e.m(c0273u));
        }
        TextPaint textPaint = new TextPaint(c0273u.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = c0273u.getBreakStrategy();
        int hyphenationFrequency = c0273u.getHyphenationFrequency();
        if (c0273u.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            boolean z = true;
            if (i2 >= 28 && (c0273u.getInputType() & 15) == 3) {
                byte directionality = Character.getDirectionality(AbstractC0005e.d(DecimalFormatSymbols.getInstance(c0273u.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                if (c0273u.getLayoutDirection() != 1) {
                    z = false;
                }
                switch (c0273u.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                        break;
                }
            }
        }
        return new C.c(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static String s(g.h input) {
        kotlin.jvm.internal.h.e(input, "input");
        if (input instanceof g.f) {
            return "image/*";
        }
        if (input instanceof g) {
            return "video/*";
        }
        if (input instanceof g.e) {
            return null;
        }
        throw new RuntimeException();
    }

    public static void t(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static int u(int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 != 32) {
                    if (i2 != 64) {
                        if (i2 != 128) {
                            if (i2 == 256) {
                                return 8;
                            }
                            if (i2 == 512) {
                                return 9;
                            }
                            throw new IllegalArgumentException(O.a.c(i2, "type needs to be >= FIRST and <= LAST, type="));
                        }
                        return 7;
                    }
                    return 6;
                }
                return 5;
            }
            return 3;
        }
        return 0;
    }

    public static T0.d v(T0.d dVar) {
        V0.c cVar;
        T0.d intercepted;
        kotlin.jvm.internal.h.e(dVar, "<this>");
        if (dVar instanceof V0.c) {
            cVar = (V0.c) dVar;
        } else {
            cVar = null;
        }
        if (cVar != null && (intercepted = cVar.intercepted()) != null) {
            return intercepted;
        }
        return dVar;
    }

    public static boolean w() {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC0175a.c();
        }
        try {
            if (f1054b == null) {
                f1053a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f1054b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f1054b.invoke(null, Long.valueOf(f1053a))).booleanValue();
        } catch (Exception e2) {
            t("isTagEnabled", e2);
            return false;
        }
    }

    public static boolean x(byte b2) {
        if (b2 > -65) {
            return true;
        }
        return false;
    }

    public static List y(Object obj) {
        List singletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.h.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static MappedByteBuffer z(Context context, Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (openFileDescriptor == null) {
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public abstract void M(byte[] bArr, int i2, int i3);
}
