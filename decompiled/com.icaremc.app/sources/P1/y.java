package P1;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.AbstractComponentCallbacksC0187t;
import androidx.fragment.app.P;
import androidx.fragment.app.U;
import androidx.fragment.app.X;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import s2.C0629a;
import s2.InterfaceC0630b;
import s2.InterfaceC0631c;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;
import t.C0661j;

/* loaded from: classes.dex */
public final class y implements K0.b, InterfaceC0437a {

    /* renamed from: j, reason: collision with root package name */
    public static y f1468j;

    /* renamed from: f, reason: collision with root package name */
    public Object f1469f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1470g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1471h;

    /* renamed from: i, reason: collision with root package name */
    public Object f1472i;

    public y(InterfaceC0634f interfaceC0634f, String str, InterfaceC0640l interfaceC0640l, W0.g gVar) {
        this.f1470g = interfaceC0634f;
        this.f1469f = str;
        this.f1471h = interfaceC0640l;
        this.f1472i = gVar;
    }

    public static synchronized y l() {
        y yVar;
        synchronized (y.class) {
            try {
                if (f1468j == null) {
                    f1468j = new y(0);
                }
                yVar = f1468j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    public void a(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (!((ArrayList) this.f1469f).contains(abstractComponentCallbacksC0187t)) {
            synchronized (((ArrayList) this.f1469f)) {
                ((ArrayList) this.f1469f).add(abstractComponentCallbacksC0187t);
            }
            abstractComponentCallbacksC0187t.f2933p = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + abstractComponentCallbacksC0187t);
    }

    @Override // m.InterfaceC0437a
    public boolean b(AbstractC0438b abstractC0438b, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f1469f;
        m.g g4 = g(abstractC0438b);
        C0661j c0661j = (C0661j) this.f1472i;
        Menu menu2 = (Menu) c0661j.get(menu);
        if (menu2 == null) {
            menu2 = new n.E((Context) this.f1470g, (n.n) menu);
            c0661j.put(menu, menu2);
        }
        return callback.onCreateActionMode(g4, menu2);
    }

    public SpannableString c() {
        if (((String) this.f1469f) == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString((String) this.f1469f);
        List<io.flutter.view.m> list = (List) this.f1470g;
        if (list != null) {
            for (io.flutter.view.m mVar : list) {
                int b4 = R.i.b(mVar.f4535c);
                if (b4 != 0) {
                    if (b4 == 1) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((io.flutter.view.k) mVar).f4532d)), mVar.f4533a, mVar.f4534b, 0);
                    }
                } else {
                    spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), mVar.f4533a, mVar.f4534b, 0);
                }
            }
        }
        String str = (String) this.f1472i;
        if (str != null && !str.isEmpty()) {
            spannableString.setSpan(new URLSpan((String) this.f1472i), 0, ((String) this.f1469f).length(), 0);
        }
        String str2 = (String) this.f1471h;
        if (str2 != null && !str2.isEmpty()) {
            spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag((String) this.f1471h)), 0, ((String) this.f1469f).length(), 0);
        }
        return spannableString;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(M2.c r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f1472i
            O.N r0 = (O.N) r0
            boolean r1 = r7 instanceof O.C0081j
            if (r1 == 0) goto L17
            r1 = r7
            O.j r1 = (O.C0081j) r1
            int r2 = r1.f1206l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f1206l = r2
            goto L1c
        L17:
            O.j r1 = new O.j
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f1205j
            int r2 = r1.f1206l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            P1.y r0 = r1.f1204i
            k3.b.A(r7)
            goto L64
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            P1.y r0 = r1.f1204i
            k3.b.A(r7)
            goto L74
        L3c:
            k3.b.A(r7)
            java.lang.Object r7 = r6.f1471h
            java.util.List r7 = (java.util.List) r7
            L2.a r2 = L2.a.f1019f
            if (r7 == 0) goto L67
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L67
        L4e:
            O.i0 r7 = r0.g()
            O.m r4 = new O.m
            r5 = 0
            r4.<init>(r0, r6, r5)
            r1.f1204i = r6
            r1.f1206l = r3
            java.lang.Object r7 = r7.b(r4, r1)
            if (r7 != r2) goto L63
            goto L72
        L63:
            r0 = r6
        L64:
            O.d r7 = (O.C0075d) r7
            goto L76
        L67:
            r1.f1204i = r6
            r1.f1206l = r4
            r7 = 0
            java.lang.Object r7 = O.N.f(r0, r7, r1)
            if (r7 != r2) goto L73
        L72:
            return r2
        L73:
            r0 = r6
        L74:
            O.d r7 = (O.C0075d) r7
        L76:
            java.lang.Object r0 = r0.f1472i
            O.N r0 = (O.N) r0
            R1.c r0 = r0.f1126m
            r0.w(r7)
            H2.i r7 = H2.i.f681a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.y.d(M2.c):java.lang.Object");
    }

    public AbstractComponentCallbacksC0187t e(String str) {
        X x3 = (X) ((HashMap) this.f1470g).get(str);
        if (x3 != null) {
            return x3.f2804c;
        }
        return null;
    }

    public AbstractComponentCallbacksC0187t f(String str) {
        for (X x3 : ((HashMap) this.f1470g).values()) {
            if (x3 != null) {
                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x3.f2804c;
                if (!str.equals(abstractComponentCallbacksC0187t.f2928j)) {
                    abstractComponentCallbacksC0187t = abstractComponentCallbacksC0187t.z.f2752c.f(str);
                }
                if (abstractComponentCallbacksC0187t != null) {
                    return abstractComponentCallbacksC0187t;
                }
            }
        }
        return null;
    }

    public m.g g(AbstractC0438b abstractC0438b) {
        ArrayList arrayList = (ArrayList) this.f1471h;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            m.g gVar = (m.g) arrayList.get(i4);
            if (gVar != null && gVar.f5145b == abstractC0438b) {
                return gVar;
            }
        }
        m.g gVar2 = new m.g((Context) this.f1470g, abstractC0438b);
        arrayList.add(gVar2);
        return gVar2;
    }

    @Override // G2.a
    public Object get() {
        return new O0.m((Executor) ((G2.a) this.f1469f).get(), (P0.d) ((G2.a) this.f1470g).get(), (O0.d) ((A2.t) this.f1471h).get(), (Q0.c) ((G2.a) this.f1472i).get());
    }

    public ArrayList h() {
        ArrayList arrayList = new ArrayList();
        for (X x3 : ((HashMap) this.f1470g).values()) {
            if (x3 != null) {
                arrayList.add(x3);
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        ArrayList arrayList = new ArrayList();
        for (X x3 : ((HashMap) this.f1470g).values()) {
            if (x3 != null) {
                arrayList.add(x3.f2804c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List j() {
        ArrayList arrayList;
        if (((ArrayList) this.f1469f).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f1469f)) {
            arrayList = new ArrayList((ArrayList) this.f1469f);
        }
        return arrayList;
    }

    @Override // m.InterfaceC0437a
    public void k(AbstractC0438b abstractC0438b) {
        ((ActionMode.Callback) this.f1469f).onDestroyActionMode(g(abstractC0438b));
    }

    public File m(Context context) {
        ((Z0.g) this.f1470g).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("flutter"));
    }

    public boolean n(Context context) {
        boolean z;
        if (((Boolean) this.f1471h) == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f1471h = Boolean.valueOf(z);
        }
        if (!((Boolean) this.f1470g).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f1471h).booleanValue();
    }

    public boolean o(Context context) {
        boolean z;
        if (((Boolean) this.f1470g) == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f1470g = Boolean.valueOf(z);
        }
        if (!((Boolean) this.f1470g).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f1470g).booleanValue();
    }

    public void p(String str, Object... objArr) {
        String format = String.format(Locale.US, str, objArr);
        if (((V1.f) this.f1472i) != null) {
            FlutterJNI.lambda$loadLibrary$0(format);
        }
    }

    public void q(X x3) {
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x3.f2804c;
        String str = abstractComponentCallbacksC0187t.f2928j;
        HashMap hashMap = (HashMap) this.f1470g;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(abstractComponentCallbacksC0187t.f2928j, x3);
        if (P.J(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + abstractComponentCallbacksC0187t);
        }
    }

    @Override // m.InterfaceC0437a
    public boolean r(AbstractC0438b abstractC0438b, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f1469f;
        m.g g4 = g(abstractC0438b);
        C0661j c0661j = (C0661j) this.f1472i;
        Menu menu2 = (Menu) c0661j.get(menu);
        if (menu2 == null) {
            menu2 = new n.E((Context) this.f1470g, (n.n) menu);
            c0661j.put(menu, menu2);
        }
        return callback.onPrepareActionMode(g4, menu2);
    }

    public void s(X x3) {
        HashMap hashMap = (HashMap) this.f1470g;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t = x3.f2804c;
        if (abstractComponentCallbacksC0187t.f2909G) {
            ((U) this.f1472i).f(abstractComponentCallbacksC0187t);
        }
        if (hashMap.get(abstractComponentCallbacksC0187t.f2928j) == x3 && ((X) hashMap.put(abstractComponentCallbacksC0187t.f2928j, null)) != null && P.J(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + abstractComponentCallbacksC0187t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:13:0x0090, B:21:0x006b, B:23:0x0082), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [j3.a] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object t(M2.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof O.c0
            if (r0 == 0) goto L13
            r0 = r9
            O.c0 r0 = (O.c0) r0
            int r1 = r0.f1173m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1173m = r1
            goto L18
        L13:
            O.c0 r0 = new O.c0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.k
            int r1 = r0.f1173m
            r2 = 2
            r3 = 1
            H2.i r4 = H2.i.f681a
            r5 = 0
            L2.a r6 = L2.a.f1019f
            if (r1 == 0) goto L43
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            j3.a r1 = r0.f1171j
            P1.y r0 = r0.f1170i
            k3.b.A(r9)     // Catch: java.lang.Throwable -> L31
            goto L90
        L31:
            r9 = move-exception
            goto L98
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            j3.a r1 = r0.f1171j
            P1.y r3 = r0.f1170i
            k3.b.A(r9)
            goto L6b
        L43:
            k3.b.A(r9)
            java.lang.Object r9 = r8.f1470g
            b3.m r9 = (b3.C0238m) r9
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = b3.W.f3262f
            java.lang.Object r9 = r1.get(r9)
            boolean r9 = r9 instanceof b3.K
            if (r9 != 0) goto L58
            return r4
        L58:
            java.lang.Object r9 = r8.f1469f
            j3.c r9 = (j3.c) r9
            r0.f1170i = r8
            r0.f1171j = r9
            r0.f1173m = r3
            java.lang.Object r1 = r9.c(r0)
            if (r1 != r6) goto L69
            goto L8e
        L69:
            r3 = r8
            r1 = r9
        L6b:
            java.lang.Object r9 = r3.f1470g     // Catch: java.lang.Throwable -> L31
            b3.m r9 = (b3.C0238m) r9     // Catch: java.lang.Throwable -> L31
            r9.getClass()     // Catch: java.lang.Throwable -> L31
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = b3.W.f3262f     // Catch: java.lang.Throwable -> L31
            java.lang.Object r9 = r7.get(r9)     // Catch: java.lang.Throwable -> L31
            boolean r9 = r9 instanceof b3.K     // Catch: java.lang.Throwable -> L31
            if (r9 != 0) goto L82
        L7c:
            j3.c r1 = (j3.c) r1
            r1.e(r5)
            return r4
        L82:
            r0.f1170i = r3     // Catch: java.lang.Throwable -> L31
            r0.f1171j = r1     // Catch: java.lang.Throwable -> L31
            r0.f1173m = r2     // Catch: java.lang.Throwable -> L31
            java.lang.Object r9 = r3.d(r0)     // Catch: java.lang.Throwable -> L31
            if (r9 != r6) goto L8f
        L8e:
            return r6
        L8f:
            r0 = r3
        L90:
            java.lang.Object r9 = r0.f1470g     // Catch: java.lang.Throwable -> L31
            b3.m r9 = (b3.C0238m) r9     // Catch: java.lang.Throwable -> L31
            r9.F(r4)     // Catch: java.lang.Throwable -> L31
            goto L7c
        L98:
            j3.c r1 = (j3.c) r1
            r1.e(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.y.t(M2.c):java.lang.Object");
    }

    @Override // m.InterfaceC0437a
    public boolean u(AbstractC0438b abstractC0438b, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f1469f).onActionItemClicked(g(abstractC0438b), new n.v((Context) this.f1470g, (D.a) menuItem));
    }

    public void v(Object obj, InterfaceC0631c interfaceC0631c) {
        C0629a c0629a;
        InterfaceC0634f interfaceC0634f = (InterfaceC0634f) this.f1470g;
        String str = (String) this.f1469f;
        ByteBuffer a4 = ((InterfaceC0640l) this.f1471h).a(obj);
        if (interfaceC0631c == null) {
            c0629a = null;
        } else {
            c0629a = new C0629a(0, this, interfaceC0631c);
        }
        interfaceC0634f.e(str, a4, c0629a);
    }

    public void w(InterfaceC0630b interfaceC0630b) {
        String str = (String) this.f1469f;
        InterfaceC0634f interfaceC0634f = (InterfaceC0634f) this.f1470g;
        W0.g gVar = (W0.g) this.f1472i;
        io.flutter.plugin.platform.s sVar = null;
        if (gVar != null) {
            if (interfaceC0630b != null) {
                sVar = new io.flutter.plugin.platform.s(13, this, interfaceC0630b);
            }
            interfaceC0634f.n(str, sVar, gVar);
        } else {
            if (interfaceC0630b != null) {
                sVar = new io.flutter.plugin.platform.s(13, this, interfaceC0630b);
            }
            interfaceC0634f.a(str, sVar);
        }
    }

    public Bundle x(String str, Bundle bundle) {
        HashMap hashMap = (HashMap) this.f1471h;
        if (bundle != null) {
            return (Bundle) hashMap.put(str, bundle);
        }
        return (Bundle) hashMap.remove(str);
    }

    public y(Typeface typeface, U.b bVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        this.f1472i = typeface;
        this.f1469f = bVar;
        this.f1471h = new T.s(1024);
        int a4 = bVar.a(6);
        if (a4 != 0) {
            int i8 = a4 + bVar.f691a;
            i4 = ((ByteBuffer) bVar.f694d).getInt(((ByteBuffer) bVar.f694d).getInt(i8) + i8);
        } else {
            i4 = 0;
        }
        this.f1470g = new char[i4 * 2];
        int a5 = bVar.a(6);
        if (a5 != 0) {
            int i9 = a5 + bVar.f691a;
            i5 = ((ByteBuffer) bVar.f694d).getInt(((ByteBuffer) bVar.f694d).getInt(i9) + i9);
        } else {
            i5 = 0;
        }
        for (int i10 = 0; i10 < i5; i10++) {
            T.o oVar = new T.o(this, i10);
            U.a b4 = oVar.b();
            int a6 = b4.a(4);
            Character.toChars(a6 != 0 ? ((ByteBuffer) b4.f694d).getInt(a6 + b4.f691a) : 0, (char[]) this.f1470g, i10 * 2);
            U.a b5 = oVar.b();
            int a7 = b5.a(16);
            if (a7 != 0) {
                int i11 = a7 + b5.f691a;
                i6 = ((ByteBuffer) b5.f694d).getInt(((ByteBuffer) b5.f694d).getInt(i11) + i11);
            } else {
                i6 = 0;
            }
            if (i6 > 0) {
                T.s sVar = (T.s) this.f1471h;
                U.a b6 = oVar.b();
                int a8 = b6.a(16);
                if (a8 != 0) {
                    int i12 = a8 + b6.f691a;
                    i7 = ((ByteBuffer) b6.f694d).getInt(((ByteBuffer) b6.f694d).getInt(i12) + i12);
                } else {
                    i7 = 0;
                }
                sVar.a(oVar, 0, i7 - 1);
            } else {
                throw new IllegalArgumentException("invalid metadata codepoint length");
            }
        }
    }

    public y(int i4) {
        switch (i4) {
            case 1:
                Object obj = new Object();
                Object obj2 = new Object();
                this.f1469f = new HashSet();
                this.f1470g = obj;
                this.f1471h = obj2;
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f1469f = new ArrayList();
                this.f1470g = new HashMap();
                this.f1471h = new HashMap();
                return;
            default:
                this.f1469f = null;
                this.f1470g = null;
                this.f1471h = null;
                this.f1472i = new ArrayDeque();
                return;
        }
    }
}
