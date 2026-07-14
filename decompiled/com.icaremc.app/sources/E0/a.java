package E0;

import A.k;
import A2.m;
import A2.t;
import D2.J;
import J0.e;
import P0.j;
import P1.y;
import R.i;
import T.g;
import T.o;
import T.v;
import V0.h;
import Z0.D;
import Z0.r;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.AbstractComponentCallbacksC0187t;
import androidx.fragment.app.P;
import com.google.android.gms.common.api.Status;
import com.icaremc.app.R;
import e3.d;
import h0.C0310M;
import h0.InterfaceC0311N;
import h2.C0344D;
import h2.x;
import j.AbstractActivityC0416k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import m2.C0447e;
import n.p;
import org.json.JSONException;
import org.json.JSONObject;
import p1.AbstractC0579h;
import p1.C0580i;
import p1.InterfaceC0572a;
import p1.InterfaceC0574c;
import s2.C0635g;
import s2.C0641m;
import s2.InterfaceC0636h;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import u1.f;

/* loaded from: classes.dex */
public final class a implements InterfaceC0642n, K0.b, InterfaceC0572a, InterfaceC0574c, InterfaceC0636h, d, x {

    /* renamed from: i, reason: collision with root package name */
    public static a f457i;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f458f;

    /* renamed from: g, reason: collision with root package name */
    public Object f459g;

    /* renamed from: h, reason: collision with root package name */
    public Object f460h;

    public /* synthetic */ a(int i4, Object obj) {
        this.f458f = i4;
        this.f460h = null;
        this.f459g = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static E0.a d(android.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L28 java.lang.Error -> L2b java.io.IOException -> L2d
            E0.a r2 = new E0.a     // Catch: java.nio.channels.OverlappingFileLockException -> L22 java.lang.Error -> L24 java.io.IOException -> L26
            r3 = 5
            r2.<init>(r3, r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L22 java.lang.Error -> L24 java.io.IOException -> L26
            return r2
        L22:
            r2 = move-exception
            goto L37
        L24:
            r2 = move-exception
            goto L37
        L26:
            r2 = move-exception
            goto L37
        L28:
            r2 = move-exception
        L29:
            r0 = r1
            goto L37
        L2b:
            r2 = move-exception
            goto L29
        L2d:
            r2 = move-exception
            goto L29
        L2f:
            r2 = move-exception
        L30:
            r5 = r1
            r0 = r5
            goto L37
        L33:
            r2 = move-exception
            goto L30
        L35:
            r2 = move-exception
            goto L30
        L37:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L43
            r0.release()     // Catch: java.io.IOException -> L43
        L43:
            if (r5 == 0) goto L48
            r5.close()     // Catch: java.io.IOException -> L48
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.a.d(android.content.Context):E0.a");
    }

    public static String f(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
        }
        return null;
    }

    public static boolean g(Editable editable, KeyEvent keyEvent, boolean z) {
        v[] vVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (vVarArr = (v[]) editable.getSpans(selectionStart, selectionEnd, v.class)) != null && vVarArr.length > 0) {
                for (v vVar : vVarArr) {
                    int spanStart = editable.getSpanStart(vVar);
                    int spanEnd = editable.getSpanEnd(vVar);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String A(String str) {
        String str2 = (String) this.f460h;
        Resources resources = (Resources) this.f459g;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public boolean B(CharSequence charSequence, int i4, int i5, o oVar) {
        int i6;
        if (oVar.f1571c == 0) {
            g gVar = (g) this.f460h;
            U.a b4 = oVar.b();
            int a4 = b4.a(8);
            if (a4 != 0) {
                ((ByteBuffer) b4.f694d).getShort(a4 + b4.f691a);
            }
            T.d dVar = (T.d) gVar;
            dVar.getClass();
            ThreadLocal threadLocal = T.d.f1546b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i4 < i5) {
                sb.append(charSequence.charAt(i4));
                i4++;
            }
            if (dVar.f1547a.hasGlyph(sb.toString())) {
                i6 = 2;
            } else {
                i6 = 1;
            }
            oVar.f1571c = i6;
        }
        if (oVar.f1571c != 2) {
            return false;
        }
        return true;
    }

    public void C(L1.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.f1009a);
            jSONObject.put("Status", i.b(bVar.f1010b));
            jSONObject.put("AuthToken", bVar.f1011c);
            jSONObject.put("RefreshToken", bVar.f1012d);
            jSONObject.put("TokenCreationEpochInSecs", bVar.f1014f);
            jSONObject.put("ExpiresInSecs", bVar.f1013e);
            jSONObject.put("FisError", bVar.f1015g);
            f fVar = (f) this.f460h;
            fVar.a();
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", fVar.f6221a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (!createTempFile.renameTo(z())) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public void D(F.i iVar) {
        E.d dVar = (E.d) this.f460h;
        R1.c cVar = (R1.c) this.f459g;
        int i4 = iVar.f504b;
        if (i4 == 0) {
            dVar.execute(new F.a(0, cVar, iVar.f503a));
        } else {
            dVar.execute(new F.b(cVar, i4));
        }
    }

    public MotionEvent E(C0344D c0344d) {
        long j4 = c0344d.f3955a;
        LongSparseArray longSparseArray = (LongSparseArray) this.f459g;
        PriorityQueue priorityQueue = (PriorityQueue) this.f460h;
        while (!priorityQueue.isEmpty() && ((Long) priorityQueue.peek()).longValue() < j4) {
            longSparseArray.remove(((Long) priorityQueue.poll()).longValue());
        }
        if (!priorityQueue.isEmpty() && ((Long) priorityQueue.peek()).longValue() == j4) {
            priorityQueue.poll();
        }
        MotionEvent motionEvent = (MotionEvent) longSparseArray.get(j4);
        longSparseArray.remove(j4);
        return motionEvent;
    }

    public L1.b F() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(z());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } finally {
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("Fid", null);
        int optInt = jSONObject.optInt("Status", 0);
        String optString2 = jSONObject.optString("AuthToken", null);
        String optString3 = jSONObject.optString("RefreshToken", null);
        long optLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String optString4 = jSONObject.optString("FisError", null);
        int i4 = L1.b.f1008h;
        byte b4 = (byte) (((byte) (0 | 2)) | 1);
        int i5 = i.c(5)[optInt];
        if (i5 != 0) {
            byte b5 = (byte) (((byte) (b4 | 2)) | 1);
            if (b5 == 3 && i5 != 0) {
                return new L1.b(optString, i5, optString2, optString3, optLong2, optLong, optString4);
            }
            StringBuilder sb = new StringBuilder();
            if (i5 == 0) {
                sb.append(" registrationStatus");
            }
            if ((b5 & 1) == 0) {
                sb.append(" expiresInSecs");
            }
            if ((b5 & 2) == 0) {
                sb.append(" tokenCreationEpochInSecs");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }
        throw new NullPointerException("Null registrationStatus");
    }

    public void G() {
        try {
            ((FileLock) this.f460h).release();
            ((FileChannel) this.f459g).close();
        } catch (IOException e4) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e4);
        }
    }

    public int H(Context context, X0.c cVar) {
        int i4;
        int i5;
        r.e(context);
        r.e(cVar);
        int a4 = cVar.a();
        SparseIntArray sparseIntArray = (SparseIntArray) this.f459g;
        synchronized (sparseIntArray) {
            i4 = sparseIntArray.get(a4, -1);
        }
        if (i4 != -1) {
            return i4;
        }
        SparseIntArray sparseIntArray2 = (SparseIntArray) this.f459g;
        synchronized (sparseIntArray2) {
            i5 = 0;
            int i6 = 0;
            while (true) {
                try {
                    if (i6 < sparseIntArray2.size()) {
                        int keyAt = sparseIntArray2.keyAt(i6);
                        if (keyAt > a4 && sparseIntArray2.get(keyAt) == 0) {
                            break;
                        }
                        i6++;
                    } else {
                        i5 = -1;
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i5 == -1) {
                i5 = ((W0.d) this.f460h).b(context, a4);
            }
            sparseIntArray2.put(a4, i5);
        }
        return i5;
    }

    public void I(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        Map map = (Map) this.f459g;
        synchronized (map) {
            hashMap = new HashMap(map);
        }
        Map map2 = (Map) this.f460h;
        synchronized (map2) {
            hashMap2 = new HashMap(map2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C0580i) entry2.getKey()).c(new P1.x(status));
            }
        }
    }

    @Override // h2.x
    public void a(KeyEvent keyEvent, D d4) {
        String str;
        int action = keyEvent.getAction();
        boolean z = true;
        if (action != 0 && action != 1) {
            d4.b(false);
            return;
        }
        Character a4 = ((h2.v) this.f460h).a(keyEvent.getUnicodeChar());
        if (action == 0) {
            z = false;
        }
        p pVar = (p) this.f459g;
        J j4 = new J(19, d4);
        y yVar = (y) pVar.f5322g;
        HashMap hashMap = new HashMap();
        if (z) {
            str = "keyup";
        } else {
            str = "keydown";
        }
        hashMap.put("type", str);
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(keyEvent.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(keyEvent.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(keyEvent.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(keyEvent.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(keyEvent.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(keyEvent.getMetaState()));
        hashMap.put("character", a4.toString());
        hashMap.put("source", Integer.valueOf(keyEvent.getSource()));
        hashMap.put("deviceId", Integer.valueOf(keyEvent.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(keyEvent.getRepeatCount()));
        yVar.v(hashMap, new J(20, j4));
    }

    @Override // p1.InterfaceC0572a
    public Object b(AbstractC0579h abstractC0579h) {
        V0.b bVar = (V0.b) this.f459g;
        Bundle bundle = (Bundle) this.f460h;
        bVar.getClass();
        if (!abstractC0579h.f()) {
            return abstractC0579h;
        }
        Bundle bundle2 = (Bundle) abstractC0579h.d();
        if (bundle2 != null && bundle2.containsKey("google.messenger")) {
            return bVar.a(bundle).k(h.f1691h, V0.d.f1686i);
        }
        return abstractC0579h;
    }

    @Override // s2.InterfaceC0636h
    public void c(C0635g c0635g) {
        ArrayList arrayList = (ArrayList) this.f459g;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            c0635g.a((Map) obj);
        }
        arrayList.clear();
        this.f460h = c0635g;
    }

    public void e(Object obj, String str) {
        int length = str.length();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(length + 1 + valueOf.length());
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        ((ArrayList) this.f459g).add(sb.toString());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [R0.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [R0.a, java.lang.Object] */
    @Override // G2.a
    public Object get() {
        switch (this.f458f) {
            case 4:
                return new e((Context) ((R1.c) this.f459g).f1532g, (J0.d) ((R1.c) this.f460h).get());
            default:
                ?? obj = new Object();
                ?? obj2 = new Object();
                Object obj3 = ((G2.a) this.f459g).get();
                G2.a aVar = (G2.a) this.f460h;
                return new P0.h(obj, obj2, P0.a.f1315f, (j) obj3, aVar);
        }
    }

    public void h(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.h(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void i(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        P p3 = (P) this.f459g;
        AbstractActivityC0416k abstractActivityC0416k = p3.f2770v.f2949g;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = p3.f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.i(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void j(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.j(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void k(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.k(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void l(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.l(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void m(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.m(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void n(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        P p3 = (P) this.f459g;
        AbstractActivityC0416k abstractActivityC0416k = p3.f2770v.f2949g;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = p3.f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.n(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void o(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.o(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    @Override // s2.InterfaceC0636h
    public void onCancel() {
        this.f460h = null;
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        int i4;
        Toast toast;
        Context context = (Context) this.f459g;
        T2.h.e(c0641m, "call");
        String str = c0641m.f6155a;
        View view = null;
        if (T2.h.a(str, "showToast")) {
            String valueOf = String.valueOf(c0641m.a("msg"));
            String valueOf2 = String.valueOf(c0641m.a("length"));
            String valueOf3 = String.valueOf(c0641m.a("gravity"));
            Number number = (Number) c0641m.a("bgcolor");
            Number number2 = (Number) c0641m.a("textcolor");
            Number number3 = (Number) c0641m.a("fontSize");
            String str2 = (String) c0641m.a("fontAsset");
            if (valueOf3.equals("top")) {
                i4 = 48;
            } else if (valueOf3.equals("center")) {
                i4 = 17;
            } else {
                i4 = 80;
            }
            boolean equals = valueOf2.equals("long");
            if (number != null) {
                Object systemService = context.getSystemService("layout_inflater");
                T2.h.c(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View inflate = ((LayoutInflater) systemService).inflate(R.layout.toast_custom, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.text);
                textView.setText(valueOf);
                Drawable drawable = context.getDrawable(R.drawable.corner);
                T2.h.b(drawable);
                drawable.setColorFilter(number.intValue(), PorterDuff.Mode.SRC_IN);
                textView.setBackground(drawable);
                if (number3 != null) {
                    textView.setTextSize(number3.floatValue());
                }
                if (number2 != null) {
                    textView.setTextColor(number2.intValue());
                }
                Toast toast2 = new Toast(context);
                this.f460h = toast2;
                toast2.setDuration(equals ? 1 : 0);
                if (str2 != null) {
                    AssetManager assets = context.getAssets();
                    T2.h.d(assets, "getAssets(...)");
                    String b4 = ((C0447e) t.O().f99g).b(str2);
                    T2.h.d(b4, "getLookupKeyForAsset(...)");
                    textView.setTypeface(Typeface.createFromAsset(assets, b4));
                }
                Toast toast3 = (Toast) this.f460h;
                if (toast3 != null) {
                    toast3.setView(inflate);
                }
            } else {
                Log.d("KARTHIK", "showToast: " + number + " " + number2 + " " + number3 + " " + str2);
                Toast makeText = Toast.makeText(context, valueOf, equals ? 1 : 0);
                this.f460h = makeText;
                if (Build.VERSION.SDK_INT < 30) {
                    if (makeText != null) {
                        view = makeText.getView();
                    }
                    T2.h.b(view);
                    View findViewById = view.findViewById(android.R.id.message);
                    T2.h.d(findViewById, "findViewById(...)");
                    TextView textView2 = (TextView) findViewById;
                    if (number3 != null) {
                        textView2.setTextSize(number3.floatValue());
                    }
                    if (number2 != null) {
                        textView2.setTextColor(number2.intValue());
                    }
                    if (str2 != null) {
                        AssetManager assets2 = context.getAssets();
                        T2.h.d(assets2, "getAssets(...)");
                        String b5 = ((C0447e) t.O().f99g).b(str2);
                        T2.h.d(b5, "getLookupKeyForAsset(...)");
                        textView2.setTypeface(Typeface.createFromAsset(assets2, b5));
                    }
                }
            }
            try {
                if (i4 != 17) {
                    if (i4 != 48) {
                        Toast toast4 = (Toast) this.f460h;
                        if (toast4 != null) {
                            toast4.setGravity(i4, 0, 100);
                        }
                    } else {
                        Toast toast5 = (Toast) this.f460h;
                        if (toast5 != null) {
                            toast5.setGravity(i4, 0, 100);
                        }
                    }
                } else {
                    Toast toast6 = (Toast) this.f460h;
                    if (toast6 != null) {
                        toast6.setGravity(i4, 0, 0);
                    }
                }
            } catch (Exception unused) {
            }
            if (context instanceof Activity) {
                T2.h.c(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new k(2, this));
            } else {
                Toast toast7 = (Toast) this.f460h;
                if (toast7 != null) {
                    toast7.show();
                }
            }
            if (Build.VERSION.SDK_INT >= 30 && (toast = (Toast) this.f460h) != null) {
                toast.addCallback(new F2.c(this));
            }
            ((r2.i) interfaceC0643o).success(Boolean.TRUE);
            return;
        }
        if (T2.h.a(str, "cancel")) {
            Toast toast8 = (Toast) this.f460h;
            if (toast8 != null) {
                toast8.cancel();
                this.f460h = null;
            }
            ((r2.i) interfaceC0643o).success(Boolean.TRUE);
            return;
        }
        ((r2.i) interfaceC0643o).notImplemented();
    }

    public void p(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.p(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        ((Map) ((a) this.f460h).f460h).remove((C0580i) this.f459g);
    }

    public void r(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, Bundle bundle, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.r(abstractComponentCallbacksC0187t, bundle, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void s(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.s(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public void t(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.t(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public String toString() {
        switch (this.f458f) {
            case 12:
                return ((HashMap) this.f459g).toString();
            case 17:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f460h.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f459g;
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    sb.append((String) arrayList.get(i4));
                    if (i4 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Type inference failed for: r0v6, types: [T2.n, java.lang.Object] */
    @Override // e3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(e3.e r7, K2.d r8) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.a.u(e3.e, K2.d):java.lang.Object");
    }

    public void v(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        T2.h.e(abstractComponentCallbacksC0187t, "f");
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = ((P) this.f459g).f2772x;
        if (abstractComponentCallbacksC0187t2 != null) {
            abstractComponentCallbacksC0187t2.e().f2762n.v(abstractComponentCallbacksC0187t, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f460h).iterator();
        if (it.hasNext()) {
            if (it.next() == null) {
                if (z) {
                    throw null;
                }
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public View w(int i4, int i5, int i6, int i7) {
        int i8;
        C0310M c0310m = (C0310M) this.f460h;
        InterfaceC0311N interfaceC0311N = (InterfaceC0311N) this.f459g;
        int r3 = interfaceC0311N.r();
        int d4 = interfaceC0311N.d();
        if (i5 > i4) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        View view = null;
        while (i4 != i5) {
            View o3 = interfaceC0311N.o(i4);
            int f4 = interfaceC0311N.f(o3);
            int s3 = interfaceC0311N.s(o3);
            c0310m.f3856b = r3;
            c0310m.f3857c = d4;
            c0310m.f3858d = f4;
            c0310m.f3859e = s3;
            if (i6 != 0) {
                c0310m.f3855a = i6;
                if (c0310m.a()) {
                    return o3;
                }
            }
            if (i7 != 0) {
                c0310m.f3855a = i7;
                if (c0310m.a()) {
                    view = o3;
                }
            }
            i4 += i8;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public V1.p x(a2.C0143a r8) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.a.x(a2.a):V1.p");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory y(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.a.y(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public File z() {
        if (((File) this.f459g) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f459g) == null) {
                        String str = "PersistedInstallation." + ((f) this.f460h).f() + ".json";
                        f fVar = (f) this.f460h;
                        fVar.a();
                        File file = new File(fVar.f6221a.getNoBackupFilesDir(), str);
                        this.f459g = file;
                        if (file.exists()) {
                            return (File) this.f459g;
                        }
                        f fVar2 = (f) this.f460h;
                        fVar2.a();
                        File file2 = new File(fVar2.f6221a.getFilesDir(), str);
                        if (file2.exists() && !file2.renameTo((File) this.f459g)) {
                            Log.e("PersistedInstallation", "Unable to move the file from back up to non back up directory", new IOException("Unable to move the file from back up to non back up directory"));
                            return file2;
                        }
                    }
                } finally {
                }
            }
        }
        return (File) this.f459g;
    }

    public /* synthetic */ a(int i4, Object obj, Object obj2) {
        this.f458f = i4;
        this.f459g = obj;
        this.f460h = obj2;
    }

    public /* synthetic */ a(int i4, boolean z) {
        this.f458f = i4;
    }

    public a(F.b bVar, AlertDialog alertDialog) {
        this.f458f = 15;
        this.f459g = alertDialog;
        this.f460h = bVar;
    }

    public a(int i4) {
        this.f458f = i4;
        switch (i4) {
            case 19:
                W0.d dVar = W0.d.f1860d;
                this.f459g = new SparseIntArray();
                this.f460h = dVar;
                return;
            case 22:
                this.f459g = new ArrayList();
                return;
            case 28:
                this.f459g = new LongSparseArray();
                this.f460h = new PriorityQueue();
                return;
            default:
                this.f459g = Collections.synchronizedMap(new WeakHashMap());
                this.f460h = Collections.synchronizedMap(new WeakHashMap());
                return;
        }
    }

    public a(a aVar, C0580i c0580i) {
        this.f458f = 16;
        this.f459g = c0580i;
        Objects.requireNonNull(aVar);
        this.f460h = aVar;
    }

    public a(Context context) {
        this.f458f = 18;
        r.e(context);
        Resources resources = context.getResources();
        this.f459g = resources;
        this.f460h = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public a(IBinder iBinder) {
        this.f458f = 10;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f459g = new Messenger(iBinder);
            this.f460h = null;
        } else if (Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
            this.f460h = new V0.g(iBinder);
            this.f459g = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    public /* synthetic */ a(Object obj) {
        this.f458f = 17;
        this.f460h = obj;
        this.f459g = new ArrayList();
    }

    public a(String str, android.support.v4.media.session.a aVar, H1.f fVar) {
        this.f458f = 13;
        this.f460h = str;
        this.f459g = aVar;
    }

    public a(P p3) {
        this.f458f = 21;
        this.f459g = p3;
        this.f460h = new CopyOnWriteArrayList();
    }

    public a(p pVar) {
        this.f458f = 27;
        this.f460h = new h2.v();
        this.f459g = pVar;
    }

    public a(View view, InputMethodManager inputMethodManager, p pVar) {
        this.f458f = 29;
        if (Build.VERSION.SDK_INT >= 33) {
            m.v(view);
        }
        this.f460h = view;
        this.f459g = inputMethodManager;
        pVar.f5322g = this;
    }

    public a(f fVar) {
        this.f458f = 6;
        this.f460h = fVar;
    }

    public a(y yVar, H1.f fVar, T.d dVar) {
        this.f458f = 8;
        this.f459g = yVar;
        this.f460h = dVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [h0.M, java.lang.Object] */
    public a(InterfaceC0311N interfaceC0311N) {
        this.f458f = 26;
        this.f459g = interfaceC0311N;
        ?? obj = new Object();
        obj.f3855a = 0;
        this.f460h = obj;
    }

    public a(Animator animator) {
        this.f458f = 20;
        this.f459g = null;
        AnimatorSet animatorSet = new AnimatorSet();
        this.f460h = animatorSet;
        animatorSet.play(animator);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.text.Editable$Factory, V.a] */
    public a(EditText editText) {
        this.f458f = 9;
        this.f459g = editText;
        V.i iVar = new V.i(editText);
        this.f460h = iVar;
        editText.addTextChangedListener(iVar);
        if (V.a.f1652b == null) {
            synchronized (V.a.f1651a) {
                try {
                    if (V.a.f1652b == null) {
                        ?? factory = new Editable.Factory();
                        try {
                            V.a.f1653c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, V.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        V.a.f1652b = factory;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(V.a.f1652b);
    }
}
