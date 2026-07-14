package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import h2.C0350c;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$ImageTextureEntry;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import io.flutter.view.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f4233a;

    /* renamed from: c, reason: collision with root package name */
    public Surface f4235c;

    /* renamed from: h, reason: collision with root package name */
    public final C0350c f4240h;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f4234b = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name */
    public boolean f4236d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f4237e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f4238f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f4239g = new ArrayList();

    public j(FlutterJNI flutterJNI) {
        C0350c c0350c = new C0350c(3, this);
        this.f4240h = c0350c;
        this.f4233a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0350c);
    }

    public final void a(k kVar) {
        this.f4233a.addIsDisplayingFlutterUiListener(kVar);
        if (this.f4236d) {
            kVar.b();
        }
    }

    public final void b(q qVar) {
        HashSet hashSet = this.f4238f;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((q) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
        hashSet.add(new WeakReference(qVar));
    }

    public final TextureRegistry$ImageTextureEntry c() {
        FlutterRenderer$ImageTextureRegistryEntry flutterRenderer$ImageTextureRegistryEntry = new FlutterRenderer$ImageTextureRegistryEntry(this, this.f4234b.getAndIncrement());
        flutterRenderer$ImageTextureRegistryEntry.id();
        this.f4233a.registerImageTexture(flutterRenderer$ImageTextureRegistryEntry.id(), flutterRenderer$ImageTextureRegistryEntry, false);
        return flutterRenderer$ImageTextureRegistryEntry;
    }

    public final TextureRegistry$SurfaceProducer d(int i4) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 29) {
            long andIncrement = this.f4234b.getAndIncrement();
            FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer = new FlutterRenderer$ImageReaderSurfaceProducer(this, andIncrement);
            if (i4 == 2) {
                z = true;
            } else {
                z = false;
            }
            this.f4233a.registerImageTexture(andIncrement, flutterRenderer$ImageReaderSurfaceProducer, z);
            if (z) {
                b(flutterRenderer$ImageReaderSurfaceProducer);
            }
            this.f4239g.add(flutterRenderer$ImageReaderSurfaceProducer);
            return flutterRenderer$ImageReaderSurfaceProducer;
        }
        g e4 = e();
        return new n(e4.f4205a, this.f4237e, this.f4233a, e4);
    }

    public final g e() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        long andIncrement = this.f4234b.getAndIncrement();
        surfaceTexture.detachFromGLContext();
        g gVar = new g(this, andIncrement, surfaceTexture);
        this.f4233a.registerTexture(gVar.f4205a, gVar.f4206b);
        b(gVar);
        return gVar;
    }

    public final void f(int i4) {
        Iterator it = this.f4238f.iterator();
        while (it.hasNext()) {
            q qVar = (q) ((WeakReference) it.next()).get();
            if (qVar != null) {
                qVar.onTrimMemory(i4);
            } else {
                it.remove();
            }
        }
    }

    public final void g(k kVar) {
        this.f4233a.removeIsDisplayingFlutterUiListener(kVar);
    }

    public final void h(q qVar) {
        HashSet hashSet = this.f4238f;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == qVar) {
                hashSet.remove(weakReference);
                return;
            }
        }
    }

    public final void i() {
        ArrayList arrayList = this.f4239g;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((FlutterRenderer$ImageReaderSurfaceProducer) obj).getClass();
        }
    }

    public final void j() {
        if (this.f4235c != null) {
            this.f4233a.onSurfaceDestroyed();
            if (this.f4236d) {
                this.f4240h.a();
            }
            this.f4236d = false;
            this.f4235c = null;
        }
    }
}
