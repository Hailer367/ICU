package A2;

import A2.q;
import I.InterfaceC0051e;
import O.C0073b;
import O.InterfaceC0074c;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.AbstractComponentCallbacksC0187t;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0185q;
import androidx.fragment.app.L;
import androidx.fragment.app.P;
import androidx.lifecycle.InterfaceC0212t;
import androidx.profileinstaller.ProfileInstallReceiver;
import d2.C0265f;
import d2.InterfaceC0260a;
import f0.InterfaceC0284d;
import g.C0289a;
import g.InterfaceC0290b;
import h0.AbstractC0333u;
import h0.C0334v;
import h0.InterfaceC0311N;
import h1.AbstractC0337b;
import i2.C0374i;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicBoolean;
import o.B1;
import org.json.JSONArray;
import org.json.JSONException;
import p1.C0580i;
import s2.C0639k;
import s2.C0641m;
import s2.InterfaceC0632d;
import s2.InterfaceC0633e;
import s2.InterfaceC0634f;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import z1.C0748a;

/* loaded from: classes.dex */
public class q implements InterfaceC0051e, e3.d, InterfaceC0074c, K0.b, androidx.lifecycle.A, InterfaceC0290b, Y0.g, InterfaceC0260a, InterfaceC0642n, InterfaceC0284d, InterfaceC0311N, io.flutter.plugin.editing.a, InterfaceC0634f {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f92f;

    /* renamed from: g, reason: collision with root package name */
    public Object f93g;

    public /* synthetic */ q() {
        this.f92f = 26;
    }

    public static boolean I(Bundle bundle) {
        if (!"1".equals(bundle.getString("gcm.n.e")) && !"1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")))) {
            return false;
        }
        return true;
    }

    public static String L(String str) {
        if (str.startsWith("gcm.n.")) {
            return str.substring(6);
        }
        return str;
    }

    public static q x(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent.getBooleanExtra("trace-startup", false)) {
            arrayList.add("--trace-startup");
        }
        if (intent.getBooleanExtra("start-paused", false)) {
            arrayList.add("--start-paused");
        }
        int intExtra = intent.getIntExtra("vm-service-port", 0);
        if (intExtra > 0) {
            arrayList.add("--vm-service-port=" + Integer.toString(intExtra));
        }
        if (intent.getBooleanExtra("disable-service-auth-codes", false)) {
            arrayList.add("--disable-service-auth-codes");
        }
        if (intent.getBooleanExtra("endless-trace-buffer", false)) {
            arrayList.add("--endless-trace-buffer");
        }
        if (intent.getBooleanExtra("use-test-fonts", false)) {
            arrayList.add("--use-test-fonts");
        }
        if (intent.getBooleanExtra("enable-dart-profiling", false)) {
            arrayList.add("--enable-dart-profiling");
        }
        if (intent.getBooleanExtra("profile-startup", false)) {
            arrayList.add("--profile-startup");
        }
        if (intent.getBooleanExtra("enable-software-rendering", false)) {
            arrayList.add("--enable-software-rendering");
        }
        if (intent.getBooleanExtra("skia-deterministic-rendering", false)) {
            arrayList.add("--skia-deterministic-rendering");
        }
        if (intent.getBooleanExtra("trace-skia", false)) {
            arrayList.add("--trace-skia");
        }
        String stringExtra = intent.getStringExtra("trace-skia-allowlist");
        if (stringExtra != null) {
            arrayList.add("--trace-skia-allowlist=".concat(stringExtra));
        }
        if (intent.getBooleanExtra("trace-systrace", false)) {
            arrayList.add("--trace-systrace");
        }
        if (intent.hasExtra("trace-to-file")) {
            arrayList.add("--trace-to-file=" + intent.getStringExtra("trace-to-file"));
        }
        if (intent.hasExtra("profile-microtasks")) {
            arrayList.add("--profile-microtasks");
        }
        if (intent.hasExtra("enable-impeller")) {
            if (intent.getBooleanExtra("enable-impeller", false)) {
                arrayList.add("--enable-impeller=true");
            } else {
                arrayList.add("--enable-impeller=false");
            }
        }
        if (intent.getBooleanExtra("enable-vulkan-validation", false)) {
            arrayList.add("--enable-vulkan-validation");
        }
        if (intent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
            arrayList.add("--dump-skp-on-shader-compilation");
        }
        if (intent.getBooleanExtra("cache-sksl", false)) {
            arrayList.add("--cache-sksl");
        }
        if (intent.getBooleanExtra("purge-persistent-cache", false)) {
            arrayList.add("--purge-persistent-cache");
        }
        if (intent.getBooleanExtra("verbose-logging", false)) {
            arrayList.add("--verbose-logging");
        }
        if (intent.hasExtra("dart-flags")) {
            arrayList.add("--dart-flags=" + intent.getStringExtra("dart-flags"));
        }
        q qVar = new q();
        qVar.f93g = new HashSet(arrayList);
        return qVar;
    }

    public JSONArray A(String str) {
        String G3 = G(str);
        if (!TextUtils.isEmpty(G3)) {
            try {
                return new JSONArray(G3);
            } catch (JSONException unused) {
                Log.w("NotificationParams", "Malformed JSON for key " + L(str) + ": " + G3 + ", falling back to default");
                return null;
            }
        }
        return null;
    }

    public int[] B() {
        JSONArray A3 = A("gcm.n.light_settings");
        if (A3 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (A3.length() == 3) {
                int parseColor = Color.parseColor(A3.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = A3.optInt(1);
                    iArr[2] = A3.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (IllegalArgumentException e4) {
            Log.w("NotificationParams", "LightSettings is invalid: " + A3 + ". " + e4.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + A3 + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Object[] C(String str) {
        JSONArray A3 = A(str.concat("_loc_args"));
        if (A3 == null) {
            return null;
        }
        int length = A3.length();
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = A3.optString(i4);
        }
        return strArr;
    }

    public String D(String str) {
        return G(str.concat("_loc_key"));
    }

    public Long E() {
        String G3 = G("gcm.n.event_time");
        if (!TextUtils.isEmpty(G3)) {
            try {
                return Long.valueOf(Long.parseLong(G3));
            } catch (NumberFormatException unused) {
                Log.w("NotificationParams", "Couldn't parse value of " + L("gcm.n.event_time") + "(" + G3 + ") into a long");
                return null;
            }
        }
        return null;
    }

    public String F(Resources resources, String str, String str2) {
        String G3 = G(str2);
        if (!TextUtils.isEmpty(G3)) {
            return G3;
        }
        String D3 = D(str2);
        if (TextUtils.isEmpty(D3)) {
            return null;
        }
        int identifier = resources.getIdentifier(D3, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", L(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] C3 = C(str2);
        if (C3 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, C3);
        } catch (MissingFormatArgumentException e4) {
            Log.w("NotificationParams", "Missing format argument for " + L(str2) + ": " + Arrays.toString(C3) + " Default value will be used.", e4);
            return null;
        }
    }

    public String G(String str) {
        String replace;
        Bundle bundle = (Bundle) this.f93g;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            if (!str.startsWith("gcm.n.")) {
                replace = str;
            } else {
                replace = str.replace("gcm.n.", "gcm.notification.");
            }
            if (bundle.containsKey(replace)) {
                str = replace;
            }
        }
        return bundle.getString(str);
    }

    public long[] H() {
        JSONArray A3 = A("gcm.n.vibrate_timings");
        if (A3 == null) {
            return null;
        }
        try {
            if (A3.length() > 1) {
                int length = A3.length();
                long[] jArr = new long[length];
                for (int i4 = 0; i4 < length; i4++) {
                    jArr[i4] = A3.optLong(i4);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + A3 + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    public Bundle J() {
        Bundle bundle = (Bundle) this.f93g;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    public String[] K() {
        HashSet hashSet = (HashSet) this.f93g;
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // s2.InterfaceC0634f
    public void a(String str, InterfaceC0632d interfaceC0632d) {
        ((j2.i) this.f93g).n(str, interfaceC0632d, null);
    }

    @Override // Y0.g
    public void accept(Object obj, Object obj2) {
        C0580i c0580i = (C0580i) obj2;
        b1.c cVar = (b1.c) ((b1.f) obj).i();
        Z0.i iVar = (Z0.i) this.f93g;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(cVar.f3942g);
        int i4 = AbstractC0337b.f3943a;
        if (iVar == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            iVar.writeToParcel(obtain, 0);
        }
        try {
            cVar.f3941f.transact(1, obtain, null, 1);
            obtain.recycle();
            c0580i.b(null);
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // I.InterfaceC0051e
    public ClipData b() {
        ClipData clip;
        clip = ((ContentInfo) this.f93g).getClip();
        return clip;
    }

    @Override // g.InterfaceC0290b
    public void c(Object obj) {
        C0289a c0289a = (C0289a) obj;
        P p3 = (P) this.f93g;
        L l3 = (L) p3.f2739E.pollLast();
        if (l3 == null) {
            Log.w("FragmentManager", "No Activities were started for result for " + this);
            return;
        }
        String str = l3.f2730f;
        int i4 = l3.f2731g;
        AbstractComponentCallbacksC0187t f4 = p3.f2752c.f(str);
        if (f4 == null) {
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
            return;
        }
        f4.k(i4, c0289a.f3740f, c0289a.f3741g);
    }

    @Override // h0.InterfaceC0311N
    public int d() {
        AbstractC0333u abstractC0333u = (AbstractC0333u) this.f93g;
        return abstractC0333u.f3936g - abstractC0333u.r();
    }

    @Override // s2.InterfaceC0634f
    public void e(String str, ByteBuffer byteBuffer, InterfaceC0633e interfaceC0633e) {
        ((j2.i) this.f93g).e(str, byteBuffer, interfaceC0633e);
    }

    @Override // h0.InterfaceC0311N
    public int f(View view) {
        return (view.getTop() - ((C0334v) view.getLayoutParams()).f3937a.top) - ((ViewGroup.MarginLayoutParams) ((C0334v) view.getLayoutParams())).topMargin;
    }

    @Override // d2.InterfaceC0260a
    public void g(C0265f c0265f) {
        ((B1) ((p2.b) this.f93g)).a(c0265f);
    }

    @Override // G2.a
    public Object get() {
        return new P0.j(Integer.valueOf(P0.j.f1335i).intValue(), (Context) ((G2.a) this.f93g).get(), "com.google.android.datatransport.events");
    }

    @Override // s2.InterfaceC0634f
    public W0.g h(C0639k c0639k) {
        return ((j2.i) this.f93g).h(c0639k);
    }

    @Override // I.InterfaceC0051e
    public int i() {
        int flags;
        flags = ((ContentInfo) this.f93g).getFlags();
        return flags;
    }

    @Override // s2.InterfaceC0634f
    public void j(String str, ByteBuffer byteBuffer) {
        ((j2.i) this.f93g).e(str, byteBuffer, null);
    }

    @Override // f0.InterfaceC0284d
    public void k() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // I.InterfaceC0051e
    public ContentInfo l() {
        return (ContentInfo) this.f93g;
    }

    @Override // f0.InterfaceC0284d
    public void m(int i4, Object obj) {
        String str;
        switch (i4) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "RESULT_IO_EXCEPTION";
                break;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i4 != 6 && i4 != 7 && i4 != 8) {
            Log.d("ProfileInstaller", str);
        } else {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
        ((ProfileInstallReceiver) this.f93g).setResultCode(i4);
    }

    @Override // s2.InterfaceC0634f
    public void n(String str, InterfaceC0632d interfaceC0632d, W0.g gVar) {
        ((j2.i) this.f93g).n(str, interfaceC0632d, gVar);
    }

    @Override // h0.InterfaceC0311N
    public View o(int i4) {
        return ((AbstractC0333u) this.f93g).o(i4);
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        if ("check".equals(c0641m.f6155a)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) ((R1.c) this.f93g).f1532g;
            ((r2.i) interfaceC0643o).success(R1.c.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())));
            return;
        }
        ((r2.i) interfaceC0643o).notImplemented();
    }

    @Override // d2.InterfaceC0260a
    public Activity p() {
        Activity activity = (Activity) ((B1) ((p2.b) this.f93g)).f5414f;
        T2.h.d(activity, "getActivity(...)");
        return activity;
    }

    @Override // I.InterfaceC0051e
    public int q() {
        int source;
        source = ((ContentInfo) this.f93g).getSource();
        return source;
    }

    @Override // h0.InterfaceC0311N
    public int r() {
        return ((AbstractC0333u) this.f93g).u();
    }

    @Override // h0.InterfaceC0311N
    public int s(View view) {
        return view.getBottom() + ((C0334v) view.getLayoutParams()).f3937a.bottom + ((ViewGroup.MarginLayoutParams) ((C0334v) view.getLayoutParams())).bottomMargin;
    }

    @Override // O.InterfaceC0074c
    public Object t(C0073b c0073b) {
        return ((C0748a) this.f93g).f(c0073b);
    }

    public String toString() {
        switch (this.f92f) {
            case 3:
                return "ContentInfoCompat{" + ((ContentInfo) this.f93g) + "}";
            default:
                return super.toString();
        }
    }

    @Override // e3.d
    public Object u(e3.e eVar, K2.d dVar) {
        Object u3 = ((E0.a) this.f93g).u(new B2.A(eVar, 1), dVar);
        if (u3 == L2.a.f1019f) {
            return u3;
        }
        return H2.i.f681a;
    }

    @Override // androidx.lifecycle.A
    public void v(Object obj) {
        InterfaceC0212t interfaceC0212t = (InterfaceC0212t) obj;
        DialogInterfaceOnCancelListenerC0185q dialogInterfaceOnCancelListenerC0185q = (DialogInterfaceOnCancelListenerC0185q) this.f93g;
        if (interfaceC0212t != null && dialogInterfaceOnCancelListenerC0185q.f2882c0) {
            dialogInterfaceOnCancelListenerC0185q.getClass();
            throw new IllegalStateException("Fragment " + dialogInterfaceOnCancelListenerC0185q + " did not return a View from onCreateView() or this was called before onCreateView().");
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [l2.a] */
    public Bitmap w(ByteBuffer byteBuffer, l2.d dVar) {
        ImageDecoder.Source createSource;
        Bitmap decodeBitmap;
        createSource = ImageDecoder.createSource(byteBuffer);
        try {
            decodeBitmap = ImageDecoder.decodeBitmap(createSource, new ImageDecoder.OnHeaderDecodedListener() { // from class: l2.a
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    ColorSpace colorSpace;
                    Size size;
                    ColorSpace.Named unused;
                    q qVar = q.this;
                    unused = ColorSpace.Named.SRGB;
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    imageDecoder.setAllocator(1);
                    C0374i c0374i = (C0374i) qVar.f93g;
                    if (c0374i != null) {
                        size = imageInfo.getSize();
                        FlutterJNI.nativeImageHeaderCallback(c0374i.f4148a, size.getWidth(), size.getHeight());
                    }
                }
            });
            return decodeBitmap;
        } catch (IOException e4) {
            Log.e("FlutterImageDecoderImplDefault", "Failed to decode image", e4);
            return null;
        }
    }

    public boolean y(String str) {
        String G3 = G(str);
        if (!"1".equals(G3) && !Boolean.parseBoolean(G3)) {
            return false;
        }
        return true;
    }

    public Integer z(String str) {
        String G3 = G(str);
        if (!TextUtils.isEmpty(G3)) {
            try {
                return Integer.valueOf(Integer.parseInt(G3));
            } catch (NumberFormatException unused) {
                Log.w("NotificationParams", "Couldn't parse value of " + L(str) + "(" + G3 + ") into an int");
                return null;
            }
        }
        return null;
    }

    public /* synthetic */ q(int i4, Object obj) {
        this.f92f = i4;
        this.f93g = obj;
    }

    public q(boolean z) {
        this.f92f = 11;
        this.f93g = new AtomicBoolean(z);
    }

    public q(Bundle bundle) {
        this.f92f = 10;
        if (bundle != null) {
            this.f93g = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    public q(TextView textView) {
        this.f92f = 12;
        this.f93g = new V.g(textView);
    }

    public q(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f92f = 5;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f93g = new K.g(uri, clipDescription, uri2);
        } else {
            this.f93g = new t(uri, clipDescription, uri2, 9);
        }
    }

    public q(ContentInfo contentInfo) {
        this.f92f = 3;
        contentInfo.getClass();
        this.f93g = B.e.n(contentInfo);
    }
}
