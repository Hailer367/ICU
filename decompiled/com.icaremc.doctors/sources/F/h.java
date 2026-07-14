package F;

import K.C0027b;
import K.InterfaceC0028c;
import K.InterfaceC0034i;
import K.m0;
import K.n0;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MenuItem;
import androidx.profileinstaller.ProfileInstallReceiver;
import c1.p;
import com.google.firebase.datastorage.JavaDataStorage;
import com.google.firebase.encoders.json.BuildConfig;
import g.C0198a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import l.t;
import m.C0261h;
import m.InterfaceC0264k;
import m.K;
import o1.v;
import x0.C0344a;

/* loaded from: classes.dex */
public final class h implements InterfaceC0028c, InterfaceC0034i, Y.e, K, l.o, InterfaceC0264k, x0.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f273c;

    /* renamed from: d, reason: collision with root package name */
    public Object f274d;

    public /* synthetic */ h(int i2, Object obj) {
        this.f273c = i2;
        this.f274d = obj;
    }

    public static int l(int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            i4++;
            if (i4 == i3) {
                i5++;
                i4 = 0;
            } else if (i4 > i3) {
                i5++;
                i4 = 1;
            }
        }
        if (i4 + 1 > i3) {
            return i5 + 1;
        }
        return i5;
    }

    @Override // l.o
    public void a(l.j jVar, boolean z) {
        if (jVar instanceof t) {
            ((t) jVar).f2913v.j().c(false);
        }
        l.o oVar = ((C0261h) this.f274d).f3155g;
        if (oVar != null) {
            oVar.a(jVar, z);
        }
    }

    @Override // m.K
    public void b(l.j jVar, l.k kVar) {
        l.g gVar = (l.g) this.f274d;
        Handler handler = gVar.f2819h;
        l.f fVar = null;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = gVar.f2821j;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                if (jVar == ((l.f) arrayList.get(i2)).f2811b) {
                    break;
                } else {
                    i2++;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 == -1) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 < arrayList.size()) {
            fVar = (l.f) arrayList.get(i3);
        }
        handler.postAtTime(new l.e(this, fVar, kVar, jVar), jVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // l.o
    public boolean c(l.j jVar) {
        C0261h c0261h = (C0261h) this.f274d;
        if (jVar == null) {
            return false;
        }
        ((t) jVar).f2914w.getClass();
        c0261h.getClass();
        l.o oVar = c0261h.f3155g;
        if (oVar == null) {
            return false;
        }
        return oVar.c(jVar);
    }

    @Override // m.K
    public void d(l.j jVar, MenuItem menuItem) {
        ((l.g) this.f274d).f2819h.removeCallbacksAndMessages(jVar);
    }

    @Override // Y.e
    public void e() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // K.InterfaceC0028c
    public Object f(C0027b c0027b) {
        return JavaDataStorage.b(((com.google.firebase.datastorage.a) this.f274d).f2043d, c0027b);
    }

    @Override // Y.e
    public void g(int i2, Object obj) {
        String str;
        switch (i2) {
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
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = BuildConfig.FLAVOR;
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            Log.d("ProfileInstaller", str);
        } else {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
        ((ProfileInstallReceiver) this.f274d).setResultCode(i2);
    }

    @Override // P0.a
    public Object get() {
        return new w0.d((Context) ((C0198a) this.f274d).f2281c, new A0.f(3), new A0.f(2));
    }

    @Override // K.InterfaceC0034i
    public Object h(p pVar, T0.d dVar) {
        return ((InterfaceC0034i) this.f274d).h(new O.d(pVar, null), dVar);
    }

    @Override // K.InterfaceC0034i
    public o1.d i() {
        return ((InterfaceC0034i) this.f274d).i();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, m.r0] */
    /* JADX WARN: Type inference failed for: r1v2, types: [v0.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, B0.q] */
    public v0.k j() {
        Context context = (Context) this.f274d;
        if (context != null) {
            ?? obj = new Object();
            obj.f3916c = C0344a.a(v0.n.f3924a);
            C0198a c0198a = new C0198a(context);
            obj.f3917d = c0198a;
            obj.f3918e = C0344a.a(new B.c(8, c0198a, new h(19, c0198a)));
            C0198a c0198a2 = obj.f3917d;
            obj.f3919f = new C0.e(c0198a2, 1);
            P0.a a2 = C0344a.a(new B.c(1, obj.f3919f, C0344a.a(new C0.e(c0198a2, 0))));
            obj.f3920g = a2;
            A0.f fVar = new A0.f(0);
            C0198a c0198a3 = obj.f3917d;
            A0.g gVar = new A0.g(c0198a3, a2, fVar, 0);
            P0.a aVar = obj.f3916c;
            P0.a aVar2 = obj.f3918e;
            A0.d dVar = new A0.d(aVar, aVar2, gVar, a2, a2);
            ?? obj2 = new Object();
            obj2.f3238c = c0198a3;
            obj2.f3239d = aVar2;
            obj2.f3240e = a2;
            obj2.f3241f = gVar;
            obj2.f3242g = aVar;
            obj2.f3243h = a2;
            obj2.f3244i = a2;
            ?? obj3 = new Object();
            obj3.f130c = aVar;
            obj3.f131d = a2;
            obj3.f133f = gVar;
            obj3.f132e = a2;
            obj.f3921h = C0344a.a(new A0.g(dVar, (Object) obj2, (Object) obj3, 9));
            return obj;
        }
        throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
    }

    public m0 k() {
        return (m0) ((v) this.f274d).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r6.f528a > r2.f528a) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Type inference failed for: r3v4, types: [F.h] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(K.m0 r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.h.e(r6, r0)
            java.lang.Object r0 = r5.f274d
            o1.v r0 = (o1.v) r0
        L9:
            java.lang.Object r1 = r0.b()
            r2 = r1
            K.m0 r2 = (K.m0) r2
            boolean r3 = r2 instanceof K.e0
            if (r3 == 0) goto L16
            r3 = 1
            goto L1c
        L16:
            K.n0 r3 = K.n0.f531b
            boolean r3 = kotlin.jvm.internal.h.a(r2, r3)
        L1c:
            if (r3 == 0) goto L1f
            goto L29
        L1f:
            boolean r3 = r2 instanceof K.C0029d
            if (r3 == 0) goto L2b
            int r3 = r6.f528a
            int r4 = r2.f528a
            if (r3 <= r4) goto L2f
        L29:
            r2 = r6
            goto L2f
        L2b:
            boolean r3 = r2 instanceof K.c0
            if (r3 == 0) goto L3e
        L2f:
            F.h r3 = p1.k.f3488a
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
            Q0.d r6 = new Q0.d
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: F.h.m(K.m0):void");
    }

    public String toString() {
        switch (this.f273c) {
            case 17:
                return "<" + ((String) this.f274d) + '>';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ h(int i2, boolean z) {
        this.f273c = i2;
    }

    public h(int i2) {
        this.f273c = i2;
        switch (i2) {
            case 3:
                this.f274d = new v(n0.f531b);
                return;
            case 8:
                this.f274d = new SparseIntArray();
                return;
            default:
                this.f274d = new AtomicInteger(0);
                return;
        }
    }

    public h(boolean z) {
        this.f273c = 5;
        this.f274d = new AtomicBoolean(z);
    }
}
