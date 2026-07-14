package R1;

import A2.q;
import B.e;
import I.C0052f;
import I.InterfaceC0049c;
import M2.h;
import O.InterfaceC0080i;
import O.j0;
import O.k0;
import P1.y;
import S2.p;
import Y0.g;
import Z0.InterfaceC0136b;
import Z0.k;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Rect;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseIntArray;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import d2.C0265f;
import d2.InterfaceC0260a;
import e3.d;
import e3.r;
import h0.AbstractC0333u;
import h0.C0324l;
import h0.C0334v;
import h0.InterfaceC0311N;
import h1.AbstractC0337b;
import io.flutter.plugin.editing.f;
import io.flutter.plugin.editing.j;
import j.C0403K;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import n.l;
import n.n;
import o.B1;
import o2.InterfaceC0561a;
import p1.AbstractC0579h;
import p1.C0580i;
import p1.InterfaceC0574c;
import r2.m;
import r2.o;

/* loaded from: classes.dex */
public final class c implements d, InterfaceC0049c, K0.b, InterfaceC0080i, InterfaceC0574c, InterfaceC0136b, g, InterfaceC0260a, InterfaceC0311N, InterfaceC0561a, l {

    /* renamed from: h, reason: collision with root package name */
    public static volatile c f1530h;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1531f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1532g;

    public /* synthetic */ c(int i4, Object obj) {
        this.f1531f = i4;
        this.f1532g = obj;
    }

    public static ArrayList j(NetworkCapabilities networkCapabilities) {
        ArrayList arrayList = new ArrayList();
        if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
            if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(5)) {
                arrayList.add("wifi");
            }
            if (networkCapabilities.hasTransport(3)) {
                arrayList.add("ethernet");
            }
            if (networkCapabilities.hasTransport(4)) {
                arrayList.add("vpn");
            }
            if (networkCapabilities.hasTransport(0)) {
                arrayList.add("mobile");
            }
            if (networkCapabilities.hasTransport(2)) {
                arrayList.add("bluetooth");
            }
            if (arrayList.isEmpty() && networkCapabilities.hasCapability(12)) {
                arrayList.add("other");
            }
            if (arrayList.isEmpty()) {
                arrayList.add("none");
            }
            return arrayList;
        }
        arrayList.add("none");
        return arrayList;
    }

    public static int l(int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            i6++;
            if (i6 == i5) {
                i7++;
                i6 = 0;
            } else if (i6 > i5) {
                i7++;
                i6 = 1;
            }
        }
        if (i6 + 1 > i5) {
            return i7 + 1;
        }
        return i7;
    }

    public static boolean m(int i4) {
        if ((48 > i4 || i4 > 57) && i4 != 35 && i4 != 42) {
            return false;
        }
        return true;
    }

    @Override // O.InterfaceC0080i
    public Object a(p pVar, h hVar) {
        return ((InterfaceC0080i) this.f1532g).a(new S.c(pVar, null), hVar);
    }

    @Override // Y0.g
    public void accept(Object obj, Object obj2) {
        C0580i c0580i = (C0580i) obj2;
        b1.b bVar = (b1.b) ((b1.a) obj).i();
        k kVar = (k) this.f1532g;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(bVar.f3942g);
        int i4 = AbstractC0337b.f3943a;
        obtain.writeInt(1);
        kVar.writeToParcel(obtain, 0);
        try {
            bVar.f3941f.transact(1, obtain, null, 1);
            obtain.recycle();
            c0580i.b(null);
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // Z0.InterfaceC0136b
    public void b(W0.a aVar) {
        com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) this.f1532g;
        if (aVar.f1848g == 0) {
            aVar2.h(null, aVar2.f3393x);
            return;
        }
        c cVar = aVar2.f3384o;
        if (cVar != null) {
            ((X0.g) cVar.f1532g).a(aVar);
        }
    }

    @Override // I.InterfaceC0049c
    public C0052f build() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f1532g).build();
        return new C0052f(new q(build));
    }

    @Override // I.InterfaceC0049c
    public void c(Uri uri) {
        ((ContentInfo.Builder) this.f1532g).setLinkUri(uri);
    }

    @Override // h0.InterfaceC0311N
    public int d() {
        AbstractC0333u abstractC0333u = (AbstractC0333u) this.f1532g;
        return abstractC0333u.f3935f - abstractC0333u.t();
    }

    @Override // I.InterfaceC0049c
    public void e(int i4) {
        ((ContentInfo.Builder) this.f1532g).setFlags(i4);
    }

    @Override // h0.InterfaceC0311N
    public int f(View view) {
        return (view.getLeft() - ((C0334v) view.getLayoutParams()).f3937a.left) - ((ViewGroup.MarginLayoutParams) ((C0334v) view.getLayoutParams())).leftMargin;
    }

    @Override // d2.InterfaceC0260a
    public void g(C0265f c0265f) {
        ((B1) ((p2.b) this.f1532g)).a(c0265f);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [R0.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [R0.a, java.lang.Object] */
    @Override // G2.a
    public Object get() {
        switch (this.f1531f) {
            case 5:
                return new J0.d((Context) ((c) this.f1532g).f1532g, new Object(), new Object());
            case 6:
                return this.f1532g;
            default:
                String packageName = ((Context) ((G2.a) this.f1532g).get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    @Override // O.InterfaceC0080i
    public d getData() {
        return ((InterfaceC0080i) this.f1532g).getData();
    }

    @Override // n.l
    public boolean h(n nVar, MenuItem menuItem) {
        return false;
    }

    @Override // n.l
    public void i(n nVar) {
        C0403K c0403k = (C0403K) this.f1532g;
        Window.Callback callback = c0403k.f4895b;
        if (c0403k.f4894a.f5734a.o()) {
            callback.onPanelClosed(108, nVar);
        } else if (callback.onPreparePanel(0, null, nVar)) {
            callback.onMenuOpened(108, nVar);
        }
    }

    public j0 k() {
        return (j0) ((r) this.f1532g).a();
    }

    public void n(int i4, m mVar) {
        o oVar;
        j jVar = (j) this.f1532g;
        jVar.d();
        jVar.f4292f = mVar;
        jVar.f4291e = new C0324l(2, i4);
        jVar.f4294h.e(jVar);
        y yVar = mVar.f6105j;
        if (yVar != null) {
            oVar = (o) yVar.f1471h;
        } else {
            oVar = null;
        }
        jVar.f4294h = new f(oVar, jVar.f4287a);
        jVar.e(mVar);
        jVar.f4295i = true;
        if (jVar.f4291e.f3914b == 3) {
            jVar.f4301p = false;
        }
        jVar.f4298m = null;
        jVar.f4294h.a(jVar);
    }

    @Override // h0.InterfaceC0311N
    public View o(int i4) {
        return ((AbstractC0333u) this.f1532g).o(i4);
    }

    @Override // d2.InterfaceC0260a
    public Activity p() {
        Activity activity = (Activity) ((B1) ((p2.b) this.f1532g)).f5414f;
        T2.h.d(activity, "getActivity(...)");
        return activity;
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        ((CountDownLatch) this.f1532g).countDown();
    }

    @Override // h0.InterfaceC0311N
    public int r() {
        return ((AbstractC0333u) this.f1532g).s();
    }

    @Override // h0.InterfaceC0311N
    public int s(View view) {
        return view.getRight() + ((C0334v) view.getLayoutParams()).f3937a.right + ((ViewGroup.MarginLayoutParams) ((C0334v) view.getLayoutParams())).rightMargin;
    }

    @Override // I.InterfaceC0049c
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f1532g).setExtras(bundle);
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [Y0.h, java.lang.Object] */
    public void t(double d4, double d5, double[] dArr) {
        boolean z;
        j jVar = (j) this.f1532g;
        double[] dArr2 = new double[4];
        if (dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d) {
            z = true;
        } else {
            z = false;
        }
        double d6 = dArr[12];
        double d7 = dArr[15];
        double d8 = d6 / d7;
        dArr2[1] = d8;
        dArr2[0] = d8;
        double d9 = dArr[13] / d7;
        dArr2[3] = d9;
        dArr2[2] = d9;
        ?? obj = new Object();
        obj.f2044b = z;
        obj.f2045c = dArr;
        obj.f2043a = dArr2;
        obj.a(d4, 0.0d);
        obj.a(d4, d5);
        obj.a(0.0d, d5);
        double d10 = jVar.f4287a.getContext().getResources().getDisplayMetrics().density;
        jVar.f4298m = new Rect((int) (dArr2[0] * d10), (int) (dArr2[2] * d10), (int) Math.ceil(dArr2[1] * d10), (int) Math.ceil(dArr2[3] * d10));
    }

    public String toString() {
        switch (this.f1531f) {
            case 21:
                return "<" + ((String) this.f1532g) + '>';
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Type inference failed for: r6v6, types: [S2.p, M2.h] */
    @Override // e3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(e3.e r6, K2.d r7) {
        /*
            r5 = this;
            int r0 = r5.f1531f
            switch(r0) {
                case 3: goto L6a;
                default: goto L5;
            }
        L5:
            boolean r0 = r7 instanceof e3.a
            if (r0 == 0) goto L18
            r0 = r7
            e3.a r0 = (e3.a) r0
            int r1 = r0.f3608l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.f3608l = r1
            goto L1d
        L18:
            e3.a r0 = new e3.a
            r0.<init>(r5, r7)
        L1d:
            java.lang.Object r7 = r0.f3607j
            int r1 = r0.f3608l
            H2.i r2 = H2.i.f681a
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 != r3) goto L30
            f3.l r6 = r0.f3606i
            k3.b.A(r7)     // Catch: java.lang.Throwable -> L2e
            goto L5c
        L2e:
            r7 = move-exception
            goto L66
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            k3.b.A(r7)
            f3.l r7 = new f3.l
            K2.i r1 = r0.f1052g
            T2.h.b(r1)
            r7.<init>(r6, r1)
            r0.f3606i = r7     // Catch: java.lang.Throwable -> L64
            r0.f3608l = r3     // Catch: java.lang.Throwable -> L64
            java.lang.Object r6 = r5.f1532g     // Catch: java.lang.Throwable -> L64
            M2.h r6 = (M2.h) r6     // Catch: java.lang.Throwable -> L64
            java.lang.Object r6 = r6.e(r7, r0)     // Catch: java.lang.Throwable -> L64
            L2.a r0 = L2.a.f1019f
            if (r6 != r0) goto L56
            goto L57
        L56:
            r6 = r2
        L57:
            if (r6 != r0) goto L5b
            r2 = r0
            goto L5f
        L5b:
            r6 = r7
        L5c:
            r6.m()
        L5f:
            return r2
        L60:
            r4 = r7
            r7 = r6
            r6 = r4
            goto L66
        L64:
            r6 = move-exception
            goto L60
        L66:
            r6.m()
            throw r7
        L6a:
            java.lang.Object r0 = r5.f1532g
            e3.d r0 = (e3.d) r0
            B2.A r1 = new B2.A
            r2 = 0
            r1.<init>(r6, r2)
            java.lang.Object r6 = r0.u(r1, r7)
            L2.a r7 = L2.a.f1019f
            if (r6 != r7) goto L7d
            goto L7f
        L7d:
            H2.i r6 = H2.i.f681a
        L7f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.c.u(e3.e, K2.d):java.lang.Object");
    }

    public void v(o oVar) {
        o oVar2;
        int i4;
        int i5;
        j jVar = (j) this.f1532g;
        View view = jVar.f4287a;
        if (!jVar.f4295i && (oVar2 = jVar.f4300o) != null && (i4 = oVar2.f6114d) >= 0 && (i5 = oVar2.f6115e) > i4) {
            int i6 = i5 - i4;
            int i7 = oVar.f6115e;
            int i8 = oVar.f6114d;
            boolean z = true;
            if (i6 == i7 - i8) {
                int i9 = 0;
                while (true) {
                    if (i9 < i6) {
                        if (oVar2.f6111a.charAt(i9 + i4) != oVar.f6111a.charAt(i9 + i8)) {
                            break;
                        } else {
                            i9++;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            jVar.f4295i = z;
        }
        jVar.f4300o = oVar;
        jVar.f4294h.f(oVar);
        if (jVar.f4295i) {
            jVar.f4288b.restartInput(view);
            jVar.f4295i = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r6.f1207a > r2.f1207a) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Type inference failed for: r3v4, types: [R1.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w(O.j0 r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            T2.h.e(r6, r0)
            java.lang.Object r0 = r5.f1532g
            e3.r r0 = (e3.r) r0
        L9:
            java.lang.Object r1 = r0.a()
            r2 = r1
            O.j0 r2 = (O.j0) r2
            boolean r3 = r2 instanceof O.b0
            if (r3 == 0) goto L16
            r3 = 1
            goto L1c
        L16:
            O.k0 r3 = O.k0.f1215b
            boolean r3 = T2.h.a(r2, r3)
        L1c:
            if (r3 == 0) goto L1f
            goto L29
        L1f:
            boolean r3 = r2 instanceof O.C0075d
            if (r3 == 0) goto L2b
            int r3 = r6.f1207a
            int r4 = r2.f1207a
            if (r3 <= r4) goto L2f
        L29:
            r2 = r6
            goto L2f
        L2b:
            boolean r3 = r2 instanceof O.Z
            if (r3 == 0) goto L3e
        L2f:
            R1.c r3 = f3.k.f3727a
            if (r1 != 0) goto L34
            r1 = r3
        L34:
            if (r2 != 0) goto L37
            r2 = r3
        L37:
            boolean r1 = r0.c(r1, r2)
            if (r1 == 0) goto L9
            return
        L3e:
            E0.b r6 = new E0.b
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.c.w(O.j0):void");
    }

    public /* synthetic */ c(int i4, boolean z) {
        this.f1531f = i4;
    }

    public c(com.google.android.gms.common.internal.a aVar) {
        this.f1531f = 14;
        Objects.requireNonNull(aVar);
        this.f1532g = aVar;
    }

    public c(int i4) {
        this.f1531f = i4;
        switch (i4) {
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f1532g = new AtomicInteger(0);
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                this.f1532g = new r(k0.f1215b);
                return;
            case 22:
                this.f1532g = new SparseIntArray();
                return;
            default:
                this.f1532g = new HashSet();
                return;
        }
    }

    public c(EditText editText) {
        this.f1531f = 12;
        this.f1532g = new E0.a(editText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar) {
        this.f1531f = 19;
        this.f1532g = (h) pVar;
    }

    public c(ClipData clipData, int i4) {
        this.f1531f = 4;
        this.f1532g = e.l(clipData, i4);
    }
}
