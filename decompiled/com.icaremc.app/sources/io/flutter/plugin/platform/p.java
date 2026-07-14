package io.flutter.plugin.platform;

import D2.J;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import d2.C0264e;
import h2.AbstractActivityC0349b;
import h2.C0344D;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import n2.C0460a;
import q1.AbstractC0602b;
import s2.C0644p;

/* loaded from: classes.dex */
public final class p implements r2.h, h, i {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4349f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4350g;

    public /* synthetic */ p(int i4, Object obj) {
        this.f4349f = i4;
        this.f4350g = obj;
    }

    @Override // r2.h
    public void a(r2.f fVar) {
        switch (this.f4349f) {
            case 0:
                int i4 = fVar.f6070a;
                r rVar = (r) this.f4350g;
                float f4 = rVar.f4371h.getResources().getDisplayMetrics().density;
                if (rVar.g(i4)) {
                    E e4 = (E) rVar.f4377o.get(Integer.valueOf(i4));
                    MotionEvent m3 = rVar.m(f4, fVar, true);
                    SingleViewPresentation singleViewPresentation = e4.f4310a;
                    if (singleViewPresentation != null) {
                        singleViewPresentation.dispatchTouchEvent(m3);
                        return;
                    }
                    return;
                }
                InterfaceC0382f interfaceC0382f = (InterfaceC0382f) rVar.f4379q.get(i4);
                if (interfaceC0382f == null) {
                    Log.e("PlatformViewsController", "Sending touch to an unknown view with id: " + i4);
                    return;
                }
                View view = interfaceC0382f.getView();
                if (view == null) {
                    Log.e("PlatformViewsController", "Sending touch to a null view with id: " + i4);
                    return;
                }
                view.dispatchTouchEvent(rVar.m(f4, fVar, false));
                return;
            default:
                int i5 = fVar.f6070a;
                q qVar = (q) this.f4350g;
                float f5 = qVar.f4353h.getResources().getDisplayMetrics().density;
                InterfaceC0382f interfaceC0382f2 = (InterfaceC0382f) qVar.f4358n.get(i5);
                if (interfaceC0382f2 == null) {
                    Log.e("PlatformViewsController2", "Sending touch to an unknown view with id: " + i5);
                    return;
                }
                View view2 = interfaceC0382f2.getView();
                if (view2 == null) {
                    Log.e("PlatformViewsController2", "Sending touch to a null view with id: " + i5);
                    return;
                }
                long j4 = fVar.f6084p;
                int i6 = fVar.f6074e;
                MotionEvent E3 = qVar.f4360p.E(new C0344D(j4));
                List<List> list = (List) fVar.f6076g;
                ArrayList arrayList = new ArrayList();
                for (List list2 : list) {
                    MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                    pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
                    pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
                    pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
                    double d4 = f5;
                    pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d4);
                    pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d4);
                    pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d4);
                    pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d4);
                    pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d4);
                    pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d4);
                    arrayList.add(pointerCoords);
                }
                MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i6]);
                if (E3 != null) {
                    if (pointerCoordsArr.length >= 1) {
                        E3.offsetLocation(pointerCoordsArr[0].x - E3.getX(), pointerCoordsArr[0].y - E3.getY());
                    }
                } else {
                    List<List> list3 = (List) fVar.f6075f;
                    ArrayList arrayList2 = new ArrayList();
                    for (List list4 : list3) {
                        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                        pointerProperties.id = ((Integer) list4.get(0)).intValue();
                        pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
                        arrayList2.add(pointerProperties);
                    }
                    E3 = MotionEvent.obtain(fVar.f6071b.longValue(), fVar.f6072c.longValue(), fVar.f6073d, fVar.f6074e, (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i6]), pointerCoordsArr, fVar.f6077h, fVar.f6078i, fVar.f6079j, fVar.k, fVar.f6080l, fVar.f6081m, fVar.f6082n, fVar.f6083o);
                }
                view2.dispatchTouchEvent(E3);
                return;
        }
    }

    @Override // io.flutter.plugin.platform.i
    public void b(int i4, int i5) {
        ((TextureRegistry$SurfaceProducer) this.f4350g).setSize(i4, i5);
    }

    @Override // r2.h
    public void c(boolean z) {
        ((r) this.f4350g).f4385w = z;
    }

    public void d(r2.e eVar) {
        Object obj;
        q qVar = (q) this.f4350g;
        p pVar = qVar.f4351f;
        String str = eVar.f6062b;
        int i4 = eVar.f6061a;
        ByteBuffer byteBuffer = eVar.f6069i;
        g gVar = (g) ((HashMap) pVar.f4350g).get(str);
        if (gVar != null) {
            if (byteBuffer != null) {
                obj = gVar.getCreateArgsCodec().b(byteBuffer);
            } else {
                obj = null;
            }
            InterfaceC0382f create = gVar.create(qVar.f4353h, i4, obj);
            View view = create.getView();
            if (view != null) {
                view.setLayoutDirection(eVar.f6067g);
                qVar.f4358n.put(i4, create);
                h2.p pVar2 = qVar.f4354i;
                if (pVar2 == null) {
                    return;
                }
                create.onFlutterViewAttached(pVar2);
                return;
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str);
    }

    @Override // r2.h
    public void e(int i4, double d4, double d5) {
        r rVar = (r) this.f4350g;
        if (rVar.g(i4)) {
            return;
        }
        k kVar = (k) rVar.f4382t.get(i4);
        if (kVar == null) {
            Log.e("PlatformViewsController", "Setting offset for unknown platform view with id: " + i4);
        } else {
            int n3 = rVar.n(d4);
            int n4 = rVar.n(d5);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kVar.getLayoutParams();
            layoutParams.topMargin = n3;
            layoutParams.leftMargin = n4;
            kVar.setLayoutParams(layoutParams);
        }
    }

    @Override // r2.h
    public void f(int i4, int i5) {
        View view;
        switch (this.f4349f) {
            case 0:
                r rVar = (r) this.f4350g;
                if (i5 != 0 && i5 != 1) {
                    throw new IllegalStateException("Trying to set unknown direction value: " + i5 + "(view id: " + i4 + ")");
                }
                if (rVar.g(i4)) {
                    view = ((E) rVar.f4377o.get(Integer.valueOf(i4))).a();
                } else {
                    InterfaceC0382f interfaceC0382f = (InterfaceC0382f) rVar.f4379q.get(i4);
                    if (interfaceC0382f == null) {
                        Log.e("PlatformViewsController", "Setting direction to an unknown view with id: " + i4);
                        return;
                    }
                    view = interfaceC0382f.getView();
                }
                if (view == null) {
                    Log.e("PlatformViewsController", "Setting direction to a null view with id: " + i4);
                    return;
                }
                view.setLayoutDirection(i5);
                return;
            default:
                InterfaceC0382f interfaceC0382f2 = (InterfaceC0382f) ((q) this.f4350g).f4358n.get(i4);
                if (interfaceC0382f2 == null) {
                    Log.e("PlatformViewsController2", "Setting direction to an unknown view with id: " + i4);
                    return;
                }
                View view2 = interfaceC0382f2.getView();
                if (view2 == null) {
                    Log.e("PlatformViewsController2", "Setting direction to a null view with id: " + i4);
                    return;
                }
                view2.setLayoutDirection(i5);
                return;
        }
    }

    public CharSequence g(r2.b bVar) {
        Activity activity = (Activity) ((C0381e) this.f4350g).f4326b;
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (clipboardManager.hasPrimaryClip()) {
            try {
                try {
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (primaryClip != null) {
                        if (bVar != null) {
                            if (bVar == r2.b.f6048f) {
                            }
                        }
                        ClipData.Item itemAt = primaryClip.getItemAt(0);
                        CharSequence text = itemAt.getText();
                        if (text == null) {
                            try {
                                Uri uri = itemAt.getUri();
                                if (uri == null) {
                                    Log.w("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                                    return null;
                                }
                                String scheme = uri.getScheme();
                                if (!scheme.equals("content")) {
                                    Log.w("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                                    return null;
                                }
                                AssetFileDescriptor openTypedAssetFileDescriptor = activity.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                                CharSequence coerceToText = itemAt.coerceToText(activity);
                                if (openTypedAssetFileDescriptor != null) {
                                    try {
                                        openTypedAssetFileDescriptor.close();
                                        return coerceToText;
                                    } catch (IOException e4) {
                                        charSequence = coerceToText;
                                        e = e4;
                                        Log.w("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                                        return charSequence;
                                    }
                                }
                                return coerceToText;
                            } catch (IOException e5) {
                                e = e5;
                                charSequence = text;
                            }
                        } else {
                            return text;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (FileNotFoundException unused) {
                Log.w("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
                return charSequence;
            } catch (SecurityException e7) {
                Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e7);
                return charSequence;
            }
        }
        return null;
    }

    @Override // io.flutter.plugin.platform.i
    public int getHeight() {
        return ((TextureRegistry$SurfaceProducer) this.f4350g).getHeight();
    }

    @Override // io.flutter.plugin.platform.i
    public long getId() {
        return ((TextureRegistry$SurfaceProducer) this.f4350g).id();
    }

    @Override // io.flutter.plugin.platform.i
    public Surface getSurface() {
        return ((TextureRegistry$SurfaceProducer) this.f4350g).getSurface();
    }

    @Override // io.flutter.plugin.platform.i
    public int getWidth() {
        return ((TextureRegistry$SurfaceProducer) this.f4350g).getWidth();
    }

    public void h(ArrayList arrayList) {
        int i4;
        C0381e c0381e = (C0381e) this.f4350g;
        if (arrayList.isEmpty()) {
            i4 = 5894;
        } else {
            i4 = 1798;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            int ordinal = ((r2.d) arrayList.get(i5)).ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    i4 &= -515;
                }
            } else {
                i4 &= -5;
            }
        }
        c0381e.f4325a = i4;
        c0381e.c();
    }

    @Override // r2.h
    public void i(r2.e eVar) {
        r rVar = (r) this.f4350g;
        r.e(19);
        r.a(rVar, eVar);
        if (!rVar.f4373j.IsSurfaceControlEnabled()) {
            rVar.b(eVar, false);
            r.e(19);
            if (!rVar.f4373j.IsSurfaceControlEnabled()) {
                return;
            } else {
                throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
            }
        }
        throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [io.flutter.plugin.platform.n] */
    @Override // r2.h
    public long j(final r2.e eVar) {
        k kVar;
        long j4;
        final r rVar = (r) this.f4350g;
        r.a(rVar, eVar);
        double d4 = eVar.f6064d;
        double d5 = eVar.f6063c;
        int i4 = eVar.f6061a;
        SparseArray sparseArray = rVar.f4382t;
        if (sparseArray.get(i4) == null) {
            if (rVar.k != null) {
                if (rVar.f4372i != null) {
                    final int i5 = 1;
                    InterfaceC0382f b4 = rVar.b(eVar, true);
                    View view = b4.getView();
                    if (view.getParent() == null) {
                        if (AbstractC0602b.W(view, new J(4, r.f4366C))) {
                            if (eVar.f6068h == 2) {
                                r.e(19);
                                if (!rVar.f4373j.IsSurfaceControlEnabled()) {
                                    return -2L;
                                }
                                throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
                            }
                            if (!rVar.f4367A) {
                                r.e(20);
                                i j5 = r.j(rVar.k);
                                int n3 = rVar.n(d5);
                                int n4 = rVar.n(d4);
                                AbstractActivityC0349b abstractActivityC0349b = rVar.f4371h;
                                C0377a c0377a = rVar.f4376n;
                                int i6 = eVar.f6061a;
                                ?? r6 = new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.n
                                    @Override // android.view.View.OnFocusChangeListener
                                    public final void onFocusChange(View view2, boolean z) {
                                        switch (i5) {
                                            case 0:
                                                int i7 = eVar.f6061a;
                                                r rVar2 = rVar;
                                                if (z) {
                                                    C0644p c0644p = (C0644p) rVar2.f4375m.f4390g;
                                                    if (c0644p != null) {
                                                        c0644p.a("viewFocused", Integer.valueOf(i7), null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                io.flutter.plugin.editing.j jVar = rVar2.f4374l;
                                                if (jVar != null) {
                                                    jVar.b(i7);
                                                    return;
                                                }
                                                return;
                                            default:
                                                if (z) {
                                                    s sVar = rVar.f4375m;
                                                    int i8 = eVar.f6061a;
                                                    C0644p c0644p2 = (C0644p) sVar.f4390g;
                                                    if (c0644p2 != null) {
                                                        c0644p2.a("viewFocused", Integer.valueOf(i8), null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                        }
                                    }
                                };
                                A a4 = E.f4309i;
                                E e4 = null;
                                if (n3 != 0 && n4 != 0) {
                                    DisplayManager displayManager = (DisplayManager) abstractActivityC0349b.getSystemService("display");
                                    DisplayMetrics displayMetrics = abstractActivityC0349b.getResources().getDisplayMetrics();
                                    j5.b(n3, n4);
                                    VirtualDisplay createVirtualDisplay = displayManager.createVirtualDisplay(A2.i.g(i6, "flutter-vd#"), n3, n4, displayMetrics.densityDpi, j5.getSurface(), 0, E.f4309i, null);
                                    if (createVirtualDisplay != null) {
                                        e4 = new E(abstractActivityC0349b, c0377a, createVirtualDisplay, b4, j5, r6, i6);
                                    }
                                }
                                if (e4 != null) {
                                    rVar.f4377o.put(Integer.valueOf(i4), e4);
                                    View view2 = b4.getView();
                                    rVar.f4378p.put(view2.getContext(), view2);
                                    return j5.getId();
                                }
                                throw new IllegalStateException("Failed creating virtual display for a " + eVar.f6062b + " with id: " + i4);
                            }
                        }
                        r.e(23);
                        int n5 = rVar.n(d5);
                        int n6 = rVar.n(d4);
                        if (rVar.f4367A) {
                            kVar = new k(rVar.f4371h);
                            j4 = -1;
                        } else {
                            i j6 = r.j(rVar.k);
                            k kVar2 = new k(rVar.f4371h);
                            kVar2.k = j6;
                            Surface surface = j6.getSurface();
                            if (surface != null) {
                                Canvas lockHardwareCanvas = surface.lockHardwareCanvas();
                                try {
                                    lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                                } finally {
                                    surface.unlockCanvasAndPost(lockHardwareCanvas);
                                }
                            }
                            long id = j6.getId();
                            kVar = kVar2;
                            j4 = id;
                        }
                        kVar.setTouchProcessor(rVar.f4370g);
                        i iVar = kVar.k;
                        if (iVar != null) {
                            iVar.b(n5, n6);
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n5, n6);
                        int n7 = rVar.n(eVar.f6065e);
                        int n8 = rVar.n(eVar.f6066f);
                        layoutParams.topMargin = n7;
                        layoutParams.leftMargin = n8;
                        kVar.setLayoutParams(layoutParams);
                        View view3 = b4.getView();
                        view3.setLayoutParams(new FrameLayout.LayoutParams(n5, n6));
                        view3.setImportantForAccessibility(4);
                        kVar.addView(view3);
                        final int i7 = 0;
                        kVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.n
                            @Override // android.view.View.OnFocusChangeListener
                            public final void onFocusChange(View view22, boolean z) {
                                switch (i7) {
                                    case 0:
                                        int i72 = eVar.f6061a;
                                        r rVar2 = rVar;
                                        if (z) {
                                            C0644p c0644p = (C0644p) rVar2.f4375m.f4390g;
                                            if (c0644p != null) {
                                                c0644p.a("viewFocused", Integer.valueOf(i72), null);
                                                return;
                                            }
                                            return;
                                        }
                                        io.flutter.plugin.editing.j jVar = rVar2.f4374l;
                                        if (jVar != null) {
                                            jVar.b(i72);
                                            return;
                                        }
                                        return;
                                    default:
                                        if (z) {
                                            s sVar = rVar.f4375m;
                                            int i8 = eVar.f6061a;
                                            C0644p c0644p2 = (C0644p) sVar.f4390g;
                                            if (c0644p2 != null) {
                                                c0644p2.a("viewFocused", Integer.valueOf(i8), null);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                }
                            }
                        });
                        rVar.f4372i.addView(kVar);
                        sparseArray.append(i4, kVar);
                        h2.p pVar = rVar.f4372i;
                        if (pVar == null) {
                            return j4;
                        }
                        b4.onFlutterViewAttached(pVar);
                        return j4;
                    }
                    throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
                }
                throw new IllegalStateException(A2.i.g(i4, "Flutter view is null. This means the platform views controller doesn't have an attached view, view id: "));
            }
            throw new IllegalStateException(A2.i.g(i4, "Texture registry is null. This means that platform views controller was detached, view id: "));
        }
        throw new IllegalStateException(A2.i.g(i4, "Trying to create an already created platform view, view id: "));
    }

    public void k(int i4) {
        View decorView = ((Activity) ((C0381e) this.f4350g).f4326b).getWindow().getDecorView();
        switch (R.i.b(i4)) {
            case 0:
                decorView.performHapticFeedback(0);
                return;
            case 1:
                decorView.performHapticFeedback(1);
                return;
            case 2:
                decorView.performHapticFeedback(3);
                return;
            case 3:
                decorView.performHapticFeedback(6);
                return;
            case 4:
                decorView.performHapticFeedback(4);
                return;
            case 5:
                if (Build.VERSION.SDK_INT >= 30) {
                    decorView.performHapticFeedback(16);
                    return;
                }
                return;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    decorView.performHapticFeedback(3);
                    return;
                }
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                if (Build.VERSION.SDK_INT >= 30) {
                    decorView.performHapticFeedback(17);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // r2.h
    public void m(int i4) {
        View view;
        switch (this.f4349f) {
            case 0:
                r rVar = (r) this.f4350g;
                if (rVar.g(i4)) {
                    view = ((E) rVar.f4377o.get(Integer.valueOf(i4))).a();
                } else {
                    InterfaceC0382f interfaceC0382f = (InterfaceC0382f) rVar.f4379q.get(i4);
                    if (interfaceC0382f == null) {
                        Log.e("PlatformViewsController", "Clearing focus on an unknown view with id: " + i4);
                        return;
                    }
                    view = interfaceC0382f.getView();
                }
                if (view == null) {
                    Log.e("PlatformViewsController", "Clearing focus on a null view with id: " + i4);
                    return;
                }
                view.clearFocus();
                return;
            default:
                InterfaceC0382f interfaceC0382f2 = (InterfaceC0382f) ((q) this.f4350g).f4358n.get(i4);
                if (interfaceC0382f2 == null) {
                    Log.e("PlatformViewsController2", "Clearing focus on an unknown view with id: " + i4);
                    return;
                }
                View view2 = interfaceC0382f2.getView();
                if (view2 == null) {
                    Log.e("PlatformViewsController2", "Clearing focus on a null view with id: " + i4);
                    return;
                }
                view2.clearFocus();
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [io.flutter.plugin.platform.o, java.lang.Runnable] */
    @Override // r2.h
    public void p(r2.g gVar, final C0264e c0264e) {
        i iVar;
        r rVar = (r) this.f4350g;
        int n3 = rVar.n(gVar.f6086b);
        int n4 = rVar.n(gVar.f6087c);
        int i4 = gVar.f6085a;
        if (rVar.g(i4)) {
            final float h3 = rVar.h();
            final E e4 = (E) rVar.f4377o.get(Integer.valueOf(i4));
            io.flutter.plugin.editing.j jVar = rVar.f4374l;
            if (jVar != null) {
                if (jVar.f4291e.f3914b == 3) {
                    jVar.f4301p = true;
                }
                SingleViewPresentation singleViewPresentation = e4.f4310a;
                if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
                    e4.f4310a.getView().onInputConnectionLocked();
                }
            }
            ?? r3 = new Runnable() { // from class: io.flutter.plugin.platform.o
                @Override // java.lang.Runnable
                public final void run() {
                    float h4;
                    r rVar2 = (r) p.this.f4350g;
                    io.flutter.plugin.editing.j jVar2 = rVar2.f4374l;
                    E e5 = e4;
                    if (jVar2 != null) {
                        if (jVar2.f4291e.f3914b == 3) {
                            jVar2.f4301p = false;
                        }
                        SingleViewPresentation singleViewPresentation2 = e5.f4310a;
                        if (singleViewPresentation2 != null && singleViewPresentation2.getView() != null) {
                            e5.f4310a.getView().onInputConnectionUnlocked();
                        }
                    }
                    if (rVar2.f4371h == null) {
                        h4 = h3;
                    } else {
                        h4 = rVar2.h();
                    }
                    double d4 = h4;
                    int round = (int) Math.round(e5.f4315f.getWidth() / d4);
                    int round2 = (int) Math.round(e5.f4315f.getHeight() / d4);
                    r2.i iVar2 = c0264e.f3483f;
                    HashMap hashMap = new HashMap();
                    hashMap.put("width", Double.valueOf(round));
                    hashMap.put("height", Double.valueOf(round2));
                    iVar2.success(hashMap);
                }
            };
            i iVar2 = e4.f4315f;
            if (n3 == iVar2.getWidth() && n4 == e4.f4315f.getHeight()) {
                e4.a().postDelayed(r3, 0L);
                return;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                View a4 = e4.a();
                iVar2.b(n3, n4);
                e4.f4317h.resize(n3, n4, e4.f4313d);
                e4.f4317h.setSurface(iVar2.getSurface());
                a4.postDelayed(r3, 0L);
                return;
            }
            boolean isFocused = e4.a().isFocused();
            x detachState = e4.f4310a.detachState();
            e4.f4317h.setSurface(null);
            e4.f4317h.release();
            DisplayManager displayManager = (DisplayManager) e4.f4311b.getSystemService("display");
            iVar2.b(n3, n4);
            e4.f4317h = displayManager.createVirtualDisplay("flutter-vd#" + e4.f4314e, n3, n4, e4.f4313d, iVar2.getSurface(), 0, E.f4309i, null);
            View a5 = e4.a();
            a5.addOnAttachStateChangeListener(new C(a5, (o) r3));
            SingleViewPresentation singleViewPresentation2 = new SingleViewPresentation(e4.f4311b, e4.f4317h.getDisplay(), e4.f4312c, detachState, e4.f4316g, isFocused);
            singleViewPresentation2.show();
            e4.f4310a.cancel();
            e4.f4310a = singleViewPresentation2;
            return;
        }
        InterfaceC0382f interfaceC0382f = (InterfaceC0382f) rVar.f4379q.get(i4);
        k kVar = (k) rVar.f4382t.get(i4);
        if (interfaceC0382f != null && kVar != null) {
            if ((n3 > kVar.getRenderTargetWidth() || n4 > kVar.getRenderTargetHeight()) && (iVar = kVar.k) != null) {
                iVar.b(n3, n4);
            }
            ViewGroup.LayoutParams layoutParams = kVar.getLayoutParams();
            layoutParams.width = n3;
            layoutParams.height = n4;
            kVar.setLayoutParams(layoutParams);
            View view = interfaceC0382f.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = n3;
                layoutParams2.height = n4;
                view.setLayoutParams(layoutParams2);
            }
            int round = (int) Math.round(kVar.getRenderTargetWidth() / rVar.h());
            int round2 = (int) Math.round(kVar.getRenderTargetHeight() / rVar.h());
            r2.i iVar3 = c0264e.f3483f;
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(round));
            hashMap.put("height", Double.valueOf(round2));
            iVar3.success(hashMap);
            return;
        }
        Log.e("PlatformViewsController", "Resizing unknown platform view with id: " + i4);
    }

    @Override // io.flutter.plugin.platform.i
    public void release() {
        ((TextureRegistry$SurfaceProducer) this.f4350g).release();
        this.f4350g = null;
    }

    @Override // r2.h
    public void s(int i4) {
        j jVar;
        switch (this.f4349f) {
            case 0:
                r rVar = (r) this.f4350g;
                SparseArray sparseArray = rVar.f4380r;
                SparseArray sparseArray2 = rVar.f4382t;
                HashMap hashMap = rVar.f4377o;
                SparseArray sparseArray3 = rVar.f4379q;
                InterfaceC0382f interfaceC0382f = (InterfaceC0382f) sparseArray3.get(i4);
                if (interfaceC0382f == null) {
                    Log.e("PlatformViewsController", "Disposing unknown platform view with id: " + i4);
                    return;
                }
                if (interfaceC0382f.getView() != null) {
                    View view = interfaceC0382f.getView();
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                }
                sparseArray3.remove(i4);
                try {
                    interfaceC0382f.dispose();
                } catch (RuntimeException e4) {
                    Log.e("PlatformViewsController", "Disposing platform view threw an exception", e4);
                }
                if (rVar.g(i4)) {
                    E e5 = (E) hashMap.get(Integer.valueOf(i4));
                    View a4 = e5.a();
                    if (a4 != null) {
                        rVar.f4378p.remove(a4.getContext());
                    }
                    e5.f4310a.cancel();
                    e5.f4310a.detachState();
                    e5.f4317h.release();
                    e5.f4315f.release();
                    hashMap.remove(Integer.valueOf(i4));
                    return;
                }
                k kVar = (k) sparseArray2.get(i4);
                if (kVar != null) {
                    kVar.removeAllViews();
                    i iVar = kVar.k;
                    if (iVar != null) {
                        iVar.release();
                        kVar.k = null;
                    }
                    ViewTreeObserver viewTreeObserver = kVar.getViewTreeObserver();
                    if (viewTreeObserver.isAlive() && (jVar = kVar.f4338l) != null) {
                        kVar.f4338l = null;
                        viewTreeObserver.removeOnGlobalFocusChangeListener(jVar);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) kVar.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(kVar);
                    }
                    sparseArray2.remove(i4);
                    return;
                }
                C0460a c0460a = (C0460a) sparseArray.get(i4);
                if (c0460a != null) {
                    c0460a.removeAllViews();
                    c0460a.a();
                    ViewGroup viewGroup3 = (ViewGroup) c0460a.getParent();
                    if (viewGroup3 != null) {
                        viewGroup3.removeView(c0460a);
                    }
                    sparseArray.remove(i4);
                    return;
                }
                return;
            default:
                q qVar = (q) this.f4350g;
                InterfaceC0382f interfaceC0382f2 = (InterfaceC0382f) qVar.f4358n.get(i4);
                if (interfaceC0382f2 == null) {
                    Log.e("PlatformViewsController2", "Disposing unknown platform view with id: " + i4);
                    return;
                }
                if (interfaceC0382f2.getView() != null) {
                    View view2 = interfaceC0382f2.getView();
                    ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
                    if (viewGroup4 != null) {
                        viewGroup4.removeView(view2);
                    }
                }
                qVar.f4358n.remove(i4);
                try {
                    interfaceC0382f2.dispose();
                } catch (RuntimeException e6) {
                    Log.e("PlatformViewsController2", "Disposing platform view threw an exception", e6);
                }
                C0460a c0460a2 = (C0460a) qVar.f4359o.get(i4);
                if (c0460a2 != null) {
                    c0460a2.removeAllViews();
                    c0460a2.a();
                    ViewGroup viewGroup5 = (ViewGroup) c0460a2.getParent();
                    if (viewGroup5 != null) {
                        viewGroup5.removeView(c0460a2);
                    }
                    qVar.f4359o.remove(i4);
                    return;
                }
                return;
        }
    }

    @Override // io.flutter.plugin.platform.i
    public void scheduleFrame() {
        ((TextureRegistry$SurfaceProducer) this.f4350g).scheduleFrame();
    }

    public p(int i4) {
        this.f4349f = i4;
        switch (i4) {
            case 4:
                return;
            default:
                this.f4350g = new HashMap();
                return;
        }
    }
}
