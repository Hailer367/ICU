package j2;

import A2.q;
import A2.t;
import I.Y;
import I.Z;
import android.content.res.AssetManager;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import s2.C0639k;
import s2.InterfaceC0632d;
import s2.InterfaceC0633e;
import s2.InterfaceC0634f;

/* renamed from: j2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0427b implements InterfaceC0634f {

    /* renamed from: f, reason: collision with root package name */
    public long f5056f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5057g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f5058h;

    /* renamed from: i, reason: collision with root package name */
    public Object f5059i;

    /* renamed from: j, reason: collision with root package name */
    public Object f5060j;
    public final Object k;

    public C0427b() {
        this.f5056f = -1L;
        this.k = new m.k(this);
        this.f5058h = new ArrayList();
    }

    @Override // s2.InterfaceC0634f
    public void a(String str, InterfaceC0632d interfaceC0632d) {
        ((q) this.k).a(str, interfaceC0632d);
    }

    public void b() {
        if (!this.f5057g) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f5058h;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((Y) obj).b();
        }
        this.f5057g = false;
    }

    public void c(t tVar) {
        if (this.f5057g) {
            Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        E2.a.b("DartExecutor#executeDartCallback");
        try {
            Objects.toString(tVar);
            FlutterJNI flutterJNI = (FlutterJNI) this.f5058h;
            String str = (String) tVar.f100h;
            FlutterCallbackInformation flutterCallbackInformation = (FlutterCallbackInformation) tVar.f101i;
            flutterJNI.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, (AssetManager) tVar.f99g, null, this.f5056f);
            this.f5057g = true;
            Trace.endSection();
        } finally {
        }
    }

    public void d(C0426a c0426a, List list) {
        if (this.f5057g) {
            Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        E2.a.b("DartExecutor#executeDartEntrypoint");
        try {
            Objects.toString(c0426a);
            ((FlutterJNI) this.f5058h).runBundleAndSnapshotFromLibrary(c0426a.f5053a, c0426a.f5055c, c0426a.f5054b, (AssetManager) this.f5059i, list, this.f5056f);
            this.f5057g = true;
            Trace.endSection();
        } finally {
        }
    }

    @Override // s2.InterfaceC0634f
    public void e(String str, ByteBuffer byteBuffer, InterfaceC0633e interfaceC0633e) {
        ((q) this.k).e(str, byteBuffer, interfaceC0633e);
    }

    public void f() {
        View view;
        if (this.f5057g) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f5058h;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            Y y3 = (Y) obj;
            long j4 = this.f5056f;
            if (j4 >= 0) {
                y3.c(j4);
            }
            Interpolator interpolator = (Interpolator) this.f5059i;
            if (interpolator != null && (view = (View) y3.f712a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (((Z) this.f5060j) != null) {
                y3.d((m.k) this.k);
            }
            View view2 = (View) y3.f712a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f5057g = true;
    }

    @Override // s2.InterfaceC0634f
    public W0.g h(C0639k c0639k) {
        return ((i) ((q) this.k).f93g).h(c0639k);
    }

    @Override // s2.InterfaceC0634f
    public void j(String str, ByteBuffer byteBuffer) {
        ((q) this.k).j(str, byteBuffer);
    }

    @Override // s2.InterfaceC0634f
    public void n(String str, InterfaceC0632d interfaceC0632d, W0.g gVar) {
        ((q) this.k).n(str, interfaceC0632d, gVar);
    }

    public C0427b(FlutterJNI flutterJNI, AssetManager assetManager, long j4) {
        this.f5057g = false;
        H1.f fVar = new H1.f(this);
        this.f5058h = flutterJNI;
        this.f5059i = assetManager;
        this.f5056f = j4;
        i iVar = new i(flutterJNI);
        this.f5060j = iVar;
        iVar.n("flutter/isolate", fVar, null);
        this.k = new q(28, iVar);
        if (flutterJNI.isAttached()) {
            this.f5057g = true;
        }
    }
}
