package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import h0.C0298A;
import h2.AbstractActivityC0349b;
import h2.C0344D;
import h2.C0348a;
import h2.C0354g;
import i2.C0368c;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class r implements l {

    /* renamed from: C, reason: collision with root package name */
    public static final Class[] f4366C = {SurfaceView.class};

    /* renamed from: g, reason: collision with root package name */
    public C0348a f4370g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractActivityC0349b f4371h;

    /* renamed from: i, reason: collision with root package name */
    public h2.p f4372i;
    public io.flutter.embedding.engine.renderer.j k;

    /* renamed from: l, reason: collision with root package name */
    public io.flutter.plugin.editing.j f4374l;

    /* renamed from: m, reason: collision with root package name */
    public s f4375m;
    public final E0.a z;

    /* renamed from: j, reason: collision with root package name */
    public FlutterJNI f4373j = null;

    /* renamed from: u, reason: collision with root package name */
    public int f4383u = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4384v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4385w = true;

    /* renamed from: A, reason: collision with root package name */
    public boolean f4367A = false;

    /* renamed from: B, reason: collision with root package name */
    public final p f4368B = new p(0, this);

    /* renamed from: f, reason: collision with root package name */
    public final p f4369f = new p(2);

    /* renamed from: o, reason: collision with root package name */
    public final HashMap f4377o = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public final C0377a f4376n = new Object();

    /* renamed from: p, reason: collision with root package name */
    public final HashMap f4378p = new HashMap();

    /* renamed from: s, reason: collision with root package name */
    public final SparseArray f4381s = new SparseArray();

    /* renamed from: x, reason: collision with root package name */
    public final HashSet f4386x = new HashSet();

    /* renamed from: y, reason: collision with root package name */
    public final HashSet f4387y = new HashSet();

    /* renamed from: t, reason: collision with root package name */
    public final SparseArray f4382t = new SparseArray();

    /* renamed from: q, reason: collision with root package name */
    public final SparseArray f4379q = new SparseArray();

    /* renamed from: r, reason: collision with root package name */
    public final SparseArray f4380r = new SparseArray();

    /* JADX WARN: Type inference failed for: r0v5, types: [io.flutter.plugin.platform.a, java.lang.Object] */
    public r() {
        if (E0.a.f457i == null) {
            E0.a.f457i = new E0.a(28);
        }
        this.z = E0.a.f457i;
    }

    public static void a(r rVar, r2.e eVar) {
        int i4 = eVar.f6067g;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + i4 + "(view id: " + eVar.f6061a + ")");
        }
    }

    public static void e(int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= i4) {
        } else {
            throw new IllegalStateException(A2.i.h("Trying to use platform views with API ", ", required API level is: ", i5, i4));
        }
    }

    public static i j(io.flutter.embedding.engine.renderer.j jVar) {
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            if (i5 <= 34) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            TextureRegistry$SurfaceProducer d4 = jVar.d(i4);
            p pVar = new p(4);
            pVar.f4350g = d4;
            return pVar;
        }
        if (i5 >= 29) {
            return new C0298A(jVar.c());
        }
        return new z(jVar.e());
    }

    public final InterfaceC0382f b(r2.e eVar, boolean z) {
        Object obj;
        Context context;
        String str = eVar.f6062b;
        int i4 = eVar.f6061a;
        ByteBuffer byteBuffer = eVar.f6069i;
        g gVar = (g) ((HashMap) this.f4369f.f4350g).get(str);
        if (gVar != null) {
            if (byteBuffer != null) {
                obj = gVar.getCreateArgsCodec().b(byteBuffer);
            } else {
                obj = null;
            }
            if (z) {
                context = new MutableContextWrapper(this.f4371h);
            } else {
                context = this.f4371h;
            }
            InterfaceC0382f create = gVar.create(context, i4, obj);
            View view = create.getView();
            if (view != null) {
                view.setLayoutDirection(eVar.f6067g);
                this.f4379q.put(i4, create);
                h2.p pVar = this.f4372i;
                if (pVar == null) {
                    return create;
                }
                create.onFlutterViewAttached(pVar);
                return create;
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str);
    }

    public final void c() {
        int i4 = 0;
        while (true) {
            SparseArray sparseArray = this.f4381s;
            if (i4 < sparseArray.size()) {
                C0379c c0379c = (C0379c) sparseArray.valueAt(i4);
                c0379c.a();
                c0379c.f3991f.close();
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // io.flutter.plugin.platform.l
    public final void d(io.flutter.view.j jVar) {
        this.f4376n.f4320a = jVar;
    }

    public final void f(boolean z) {
        int i4 = 0;
        while (true) {
            SparseArray sparseArray = this.f4381s;
            if (i4 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i4);
            C0379c c0379c = (C0379c) sparseArray.valueAt(i4);
            if (this.f4386x.contains(Integer.valueOf(keyAt))) {
                C0368c c0368c = this.f4372i.f4031o;
                if (c0368c != null) {
                    c0379c.c(c0368c.f4107b);
                }
                z &= c0379c.e();
            } else {
                if (!this.f4384v) {
                    c0379c.a();
                }
                c0379c.setVisibility(8);
                this.f4372i.removeView(c0379c);
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            SparseArray sparseArray2 = this.f4380r;
            if (i5 < sparseArray2.size()) {
                int keyAt2 = sparseArray2.keyAt(i5);
                View view = (View) sparseArray2.get(keyAt2);
                if (this.f4387y.contains(Integer.valueOf(keyAt2)) && (z || !this.f4385w)) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(8);
                }
                i5++;
            } else {
                return;
            }
        }
    }

    @Override // io.flutter.plugin.platform.l
    public final boolean g(int i4) {
        return this.f4377o.containsKey(Integer.valueOf(i4));
    }

    public final float h() {
        return this.f4371h.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, io.flutter.embedding.engine.renderer.m] */
    public final void i() {
        if (this.f4385w && !this.f4384v) {
            h2.p pVar = this.f4372i;
            pVar.k.d();
            C0354g c0354g = pVar.f4027j;
            if (c0354g == null) {
                C0354g c0354g2 = new C0354g(pVar.getContext(), pVar.getWidth(), pVar.getHeight(), 1);
                pVar.f4027j = c0354g2;
                pVar.addView(c0354g2);
            } else {
                c0354g.g(pVar.getWidth(), pVar.getHeight());
            }
            pVar.f4028l = pVar.k;
            C0354g c0354g3 = pVar.f4027j;
            pVar.k = c0354g3;
            C0368c c0368c = pVar.f4031o;
            if (c0368c != null) {
                c0354g3.c(c0368c.f4107b);
            }
            this.f4384v = true;
        }
    }

    public final void k() {
        for (E e4 : this.f4377o.values()) {
            i iVar = e4.f4315f;
            i iVar2 = e4.f4315f;
            int width = iVar.getWidth();
            int height = iVar2.getHeight();
            boolean isFocused = e4.a().isFocused();
            x detachState = e4.f4310a.detachState();
            e4.f4317h.setSurface(null);
            e4.f4317h.release();
            e4.f4317h = ((DisplayManager) e4.f4311b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + e4.f4314e, width, height, e4.f4313d, iVar2.getSurface(), 0, E.f4309i, null);
            SingleViewPresentation singleViewPresentation = new SingleViewPresentation(e4.f4311b, e4.f4317h.getDisplay(), e4.f4312c, detachState, e4.f4316g, isFocused);
            singleViewPresentation.show();
            e4.f4310a.cancel();
            e4.f4310a = singleViewPresentation;
        }
    }

    @Override // io.flutter.plugin.platform.l
    public final View l(int i4) {
        if (g(i4)) {
            return ((E) this.f4377o.get(Integer.valueOf(i4))).a();
        }
        InterfaceC0382f interfaceC0382f = (InterfaceC0382f) this.f4379q.get(i4);
        if (interfaceC0382f == null) {
            return null;
        }
        return interfaceC0382f.getView();
    }

    public final MotionEvent m(float f4, r2.f fVar, boolean z) {
        long j4 = fVar.f6084p;
        int i4 = fVar.f6074e;
        MotionEvent E3 = this.z.E(new C0344D(j4));
        List<List> list = (List) fVar.f6076g;
        ArrayList arrayList = new ArrayList();
        for (List list2 : list) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
            double d4 = f4;
            pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d4);
            pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d4);
            pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d4);
            pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d4);
            pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d4);
            pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d4);
            arrayList.add(pointerCoords);
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i4]);
        List<List> list3 = (List) fVar.f6075f;
        ArrayList arrayList2 = new ArrayList();
        for (List list4 : list3) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = ((Integer) list4.get(0)).intValue();
            pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
            arrayList2.add(pointerProperties);
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i4]);
        if (!z && E3 != null) {
            if (E3.getPointerCount() == i4 && E3.getAction() == fVar.f6073d) {
                if (pointerCoordsArr.length < 1) {
                    return E3;
                }
                E3.offsetLocation(pointerCoordsArr[0].x - E3.getX(), pointerCoordsArr[0].y - E3.getY());
                return E3;
            }
            return MotionEvent.obtain(E3.getDownTime(), E3.getEventTime(), fVar.f6073d, fVar.f6074e, pointerPropertiesArr, pointerCoordsArr, E3.getMetaState(), E3.getButtonState(), E3.getXPrecision(), E3.getYPrecision(), E3.getDeviceId(), E3.getEdgeFlags(), E3.getSource(), E3.getFlags());
        }
        return MotionEvent.obtain(fVar.f6071b.longValue(), fVar.f6072c.longValue(), fVar.f6073d, fVar.f6074e, pointerPropertiesArr, pointerCoordsArr, fVar.f6077h, fVar.f6078i, fVar.f6079j, fVar.k, fVar.f6080l, fVar.f6081m, fVar.f6082n, fVar.f6083o);
    }

    public final int n(double d4) {
        return (int) Math.round(d4 * h());
    }

    @Override // io.flutter.plugin.platform.l
    public final void o() {
        this.f4376n.f4320a = null;
    }
}
