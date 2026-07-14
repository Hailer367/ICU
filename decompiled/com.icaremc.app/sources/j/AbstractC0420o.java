package j;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import t.C0652a;
import t.C0657f;

/* renamed from: j.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0420o {

    /* renamed from: f, reason: collision with root package name */
    public static final ExecutorC0399G f4994f = new ExecutorC0399G(new ExecutorC0400H(0));

    /* renamed from: g, reason: collision with root package name */
    public static final int f4995g = -100;

    /* renamed from: h, reason: collision with root package name */
    public static E.e f4996h = null;

    /* renamed from: i, reason: collision with root package name */
    public static E.e f4997i = null;

    /* renamed from: j, reason: collision with root package name */
    public static Boolean f4998j = null;
    public static boolean k = false;

    /* renamed from: l, reason: collision with root package name */
    public static final C0657f f4999l = new C0657f(0);

    /* renamed from: m, reason: collision with root package name */
    public static final Object f5000m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public static final Object f5001n = new Object();

    public static boolean c(Context context) {
        if (f4998j == null) {
            try {
                int i4 = AbstractServiceC0398F.f4887f;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AbstractServiceC0398F.class), AbstractC0397E.a() | 128).metaData;
                if (bundle != null) {
                    f4998j = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f4998j = Boolean.FALSE;
            }
        }
        return f4998j.booleanValue();
    }

    public static void f(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A) {
        synchronized (f5000m) {
            try {
                C0657f c0657f = f4999l;
                c0657f.getClass();
                C0652a c0652a = new C0652a(c0657f);
                while (c0652a.hasNext()) {
                    AbstractC0420o abstractC0420o = (AbstractC0420o) ((WeakReference) c0652a.next()).get();
                    if (abstractC0420o == layoutInflaterFactory2C0393A || abstractC0420o == null) {
                        c0652a.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract void e();

    public abstract boolean g(int i4);

    public abstract void j(int i4);

    public abstract void k(View view);

    public abstract void l(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void m(CharSequence charSequence);

    public abstract AbstractC0438b n(InterfaceC0437a interfaceC0437a);
}
