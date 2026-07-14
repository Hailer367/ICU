package io.flutter.plugin.platform;

import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import h2.AbstractActivityC0349b;
import h2.C0348a;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;
import n2.C0460a;

/* loaded from: classes.dex */
public final class q implements l {

    /* renamed from: f, reason: collision with root package name */
    public p f4351f;

    /* renamed from: g, reason: collision with root package name */
    public C0348a f4352g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractActivityC0349b f4353h;

    /* renamed from: i, reason: collision with root package name */
    public h2.p f4354i;
    public io.flutter.plugin.editing.j k;

    /* renamed from: l, reason: collision with root package name */
    public s f4356l;

    /* renamed from: p, reason: collision with root package name */
    public final E0.a f4360p;

    /* renamed from: j, reason: collision with root package name */
    public FlutterJNI f4355j = null;

    /* renamed from: s, reason: collision with root package name */
    public Surface f4363s = null;

    /* renamed from: t, reason: collision with root package name */
    public SurfaceControl f4364t = null;

    /* renamed from: u, reason: collision with root package name */
    public final p f4365u = new p(3, this);

    /* renamed from: m, reason: collision with root package name */
    public final C0377a f4357m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public final SparseArray f4358n = new SparseArray();

    /* renamed from: o, reason: collision with root package name */
    public final SparseArray f4359o = new SparseArray();

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f4361q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f4362r = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v2, types: [io.flutter.plugin.platform.a, java.lang.Object] */
    public q() {
        if (E0.a.f457i == null) {
            E0.a.f457i = new E0.a(28);
        }
        this.f4360p = E0.a.f457i;
    }

    public final boolean a(int i4) {
        InterfaceC0382f interfaceC0382f = (InterfaceC0382f) this.f4358n.get(i4);
        if (interfaceC0382f == null) {
            return false;
        }
        SparseArray sparseArray = this.f4359o;
        if (sparseArray.get(i4) != null) {
            return true;
        }
        View view = interfaceC0382f.getView();
        if (view != null) {
            if (view.getParent() == null) {
                AbstractActivityC0349b abstractActivityC0349b = this.f4353h;
                C0460a c0460a = new C0460a(abstractActivityC0349b, abstractActivityC0349b.getResources().getDisplayMetrics().density, this.f4352g);
                c0460a.setOnDescendantFocusChangeListener(new m(this, i4, 1));
                sparseArray.put(i4, c0460a);
                view.setImportantForAccessibility(4);
                c0460a.addView(view);
                this.f4354i.addView(c0460a);
                return true;
            }
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
    }

    @Override // io.flutter.plugin.platform.l
    public final void d(io.flutter.view.j jVar) {
        this.f4357m.f4320a = jVar;
    }

    @Override // io.flutter.plugin.platform.l
    public final boolean g(int i4) {
        return false;
    }

    @Override // io.flutter.plugin.platform.l
    public final View l(int i4) {
        InterfaceC0382f interfaceC0382f = (InterfaceC0382f) this.f4358n.get(i4);
        if (interfaceC0382f == null) {
            return null;
        }
        return interfaceC0382f.getView();
    }

    @Override // io.flutter.plugin.platform.l
    public final void o() {
        this.f4357m.f4320a = null;
    }
}
