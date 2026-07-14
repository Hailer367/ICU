package A2;

import B2.C0011e;
import B2.C0013g;
import B2.InterfaceC0012f;
import B2.L;
import D2.K;
import D2.Y;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.Selection;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.M;
import androidx.lifecycle.P;
import androidx.lifecycle.S;
import androidx.lifecycle.T;
import androidx.lifecycle.V;
import androidx.lifecycle.X;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.messaging.FirebaseMessagingService;
import f1.AbstractC0286a;
import h0.AbstractC0313a;
import h0.C0314b;
import h2.t;
import i0.C0362e;
import i2.C0368c;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService;
import io.flutter.plugins.urllauncher.WebViewActivity;
import io.flutter.view.FlutterCallbackInformation;
import j.O;
import j2.C0427b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import m2.C0447e;
import m2.RunnableC0444b;
import o.B1;
import o.C0496W;
import o.C0543t;
import org.xmlpull.v1.XmlPullParserException;
import p1.AbstractC0579h;
import p1.InterfaceC0574c;
import q1.C0603c;
import q1.C0605e;
import r.C0614i;
import r.C0615j;
import r1.InterfaceC0622c;
import s2.C0635g;
import s2.C0641m;
import s2.C0644p;
import s2.C0650v;
import s2.C0651w;
import s2.InterfaceC0632d;
import s2.InterfaceC0634f;
import s2.InterfaceC0636h;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.InterfaceC0645q;
import t.C0660i;
import v0.C0687j;
import y0.C0739k;
import y0.C0740l;
import y2.C0745b;

/* loaded from: classes.dex */
public final class t implements InterfaceC0012f, e3.d, C2.f, K0.b, K.h, InterfaceC0574c, InterfaceC0622c, InterfaceC0632d, InterfaceC0642n {

    /* renamed from: j, reason: collision with root package name */
    public static t f97j;
    public static t k;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f98f;

    /* renamed from: g, reason: collision with root package name */
    public Object f99g;

    /* renamed from: h, reason: collision with root package name */
    public Object f100h;

    /* renamed from: i, reason: collision with root package name */
    public Object f101i;

    public /* synthetic */ t(int i4, boolean z) {
        this.f98f = i4;
    }

    public static Bundle D(Map map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [g2.a, java.lang.Object, java.util.concurrent.ThreadFactory] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, m2.e] */
    public static t O() {
        if (f97j == null) {
            Object obj = new Object();
            ?? obj2 = new Object();
            obj2.f3769a = 0;
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(obj2);
            FlutterJNI flutterJNI = new FlutterJNI();
            ?? obj3 = new Object();
            obj3.f5203a = false;
            obj3.f5207e = flutterJNI;
            obj3.f5208f = newCachedThreadPool;
            t tVar = new t(15, false);
            tVar.f99g = obj3;
            tVar.f100h = obj;
            tVar.f101i = newCachedThreadPool;
            f97j = tVar;
        }
        return f97j;
    }

    public static t P(Context context, AttributeSet attributeSet, int[] iArr, int i4) {
        return new t(context, context.obtainStyledAttributes(attributeSet, iArr, i4, 0));
    }

    public void A(int i4, io.flutter.view.g gVar, Serializable serializable) {
        ((FlutterJNI) this.f100h).dispatchSemanticsAction(i4, gVar, serializable);
    }

    public void B(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap hashMap = (HashMap) this.f99g;
        F1.f fVar = new F1.f(byteArrayOutputStream, hashMap, (HashMap) this.f100h, (C1.d) this.f101i);
        C1.d dVar = (C1.d) hashMap.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, fVar);
        } else {
            throw new RuntimeException("No encoder for " + obj.getClass());
        }
    }

    public void C(Intent intent, CountDownLatch countDownLatch) {
        C0745b c0745b;
        if (((C0368c) this.f101i) == null) {
            Log.i("FLTFireBGExecutor", "A background message could not be handled in Dart as no onBackgroundMessage handler has been registered.");
            return;
        }
        if (countDownLatch != null) {
            c0745b = new C0745b(countDownLatch);
        } else {
            c0745b = null;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("notification");
        if (byteArrayExtra != null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                obtain.setDataPosition(0);
                HashMap v3 = k3.b.v(P1.w.CREATOR.createFromParcel(obtain));
                C0644p c0644p = (C0644p) this.f100h;
                HashMap hashMap = new HashMap();
                hashMap.put("userCallbackHandle", Long.valueOf(AbstractC0286a.f3704c.getSharedPreferences("io.flutter.firebase.messaging.callback", 0).getLong("user_callback_handle", 0L)));
                hashMap.put("message", v3);
                c0644p.a("MessagingBackground#onMessage", hashMap, c0745b);
                return;
            } finally {
                obtain.recycle();
            }
        }
        Log.e("FLTFireBGExecutor", "RemoteMessage byte array not found in Intent.");
    }

    public int E(int i4, int i5) {
        ArrayList arrayList = (ArrayList) this.f101i;
        int size = arrayList.size();
        while (i5 < size) {
            ((AbstractC0313a) arrayList.get(i5)).getClass();
            i5++;
        }
        return i4;
    }

    public S F(Class cls, String str) {
        S a4;
        P p3;
        V v3 = (V) this.f100h;
        T2.h.e(str, "key");
        X x3 = (X) this.f99g;
        x3.getClass();
        LinkedHashMap linkedHashMap = x3.f3001a;
        S s3 = (S) linkedHashMap.get(str);
        if (cls.isInstance(s3)) {
            if (v3 instanceof P) {
                p3 = (P) v3;
            } else {
                p3 = null;
            }
            if (p3 != null) {
                T2.h.b(s3);
                AbstractC0208o abstractC0208o = p3.f2989d;
                if (abstractC0208o != null) {
                    C0362e c0362e = p3.f2990e;
                    T2.h.b(c0362e);
                    M.a(s3, c0362e, abstractC0208o);
                }
            }
            T2.h.c(s3, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return s3;
        }
        a0.c cVar = new a0.c((a0.b) this.f101i);
        cVar.f2215a.put(T.f2997b, str);
        try {
            a4 = v3.b(cls, cVar);
        } catch (AbstractMethodError unused) {
            a4 = v3.a(cls);
        }
        T2.h.e(a4, "viewModel");
        S s4 = (S) linkedHashMap.put(str, a4);
        if (s4 != null) {
            s4.b();
        }
        return a4;
    }

    public ColorStateList G(int i4) {
        int resourceId;
        ColorStateList n3;
        TypedArray typedArray = (TypedArray) this.f100h;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0 && (n3 = AbstractC0286a.n((Context) this.f99g, resourceId)) != null) {
            return n3;
        }
        return typedArray.getColorStateList(i4);
    }

    public Drawable H(int i4) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f100h;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0) {
            return AbstractC0286a.o((Context) this.f99g, resourceId);
        }
        return typedArray.getDrawable(i4);
    }

    public Drawable I(int i4) {
        int resourceId;
        Drawable d4;
        if (((TypedArray) this.f100h).hasValue(i4) && (resourceId = ((TypedArray) this.f100h).getResourceId(i4, 0)) != 0) {
            C0543t a4 = C0543t.a();
            Context context = (Context) this.f99g;
            synchronized (a4) {
                d4 = a4.f5709a.d(context, resourceId, true);
            }
            return d4;
        }
        return null;
    }

    public Typeface J(int i4, int i5, C0496W c0496w) {
        C0496W c0496w2;
        XmlPullParserException xmlPullParserException;
        IOException iOException;
        int i6 = 0;
        int resourceId = ((TypedArray) this.f100h).getResourceId(i4, 0);
        if (resourceId != 0) {
            if (((TypedValue) this.f101i) == null) {
                this.f101i = new TypedValue();
            }
            Context context = (Context) this.f99g;
            TypedValue typedValue = (TypedValue) this.f101i;
            ThreadLocal threadLocal = A.m.f35a;
            if (!context.isRestricted()) {
                Resources resources = context.getResources();
                resources.getValue(resourceId, typedValue, true);
                CharSequence charSequence = typedValue.string;
                if (charSequence != null) {
                    String charSequence2 = charSequence.toString();
                    if (!charSequence2.startsWith("res/")) {
                        c0496w.a();
                        return null;
                    }
                    int i7 = typedValue.assetCookie;
                    C0660i c0660i = B.f.f129b;
                    Typeface typeface = (Typeface) c0660i.a(B.f.b(resources, resourceId, charSequence2, i7, i5));
                    if (typeface != null) {
                        new Handler(Looper.getMainLooper()).post(new A.j(i6, c0496w, typeface));
                        return typeface;
                    }
                    try {
                    } catch (IOException e4) {
                        e = e4;
                        c0496w2 = c0496w;
                    } catch (XmlPullParserException e5) {
                        e = e5;
                        c0496w2 = c0496w;
                    }
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            A.d d4 = A.b.d(resources.getXml(resourceId), resources);
                            if (d4 == null) {
                                try {
                                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                                    c0496w.a();
                                    return null;
                                } catch (IOException e6) {
                                    iOException = e6;
                                    c0496w2 = c0496w;
                                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), iOException);
                                    c0496w2.a();
                                    return null;
                                } catch (XmlPullParserException e7) {
                                    xmlPullParserException = e7;
                                    c0496w2 = c0496w;
                                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), xmlPullParserException);
                                    c0496w2.a();
                                    return null;
                                }
                            }
                            return B.f.a(context, d4, resources, resourceId, charSequence2, typedValue.assetCookie, i5, c0496w);
                        }
                        int i8 = typedValue.assetCookie;
                        Typeface n3 = B.f.f128a.n(context, resources, resourceId, charSequence2, i5);
                        if (n3 != null) {
                            c0660i.b(B.f.b(resources, resourceId, charSequence2, i8, i5), n3);
                        }
                        if (n3 != null) {
                            new Handler(Looper.getMainLooper()).post(new A.j(i6, c0496w, n3));
                        } else {
                            c0496w.a();
                        }
                        return n3;
                    } catch (IOException e8) {
                        e = e8;
                        iOException = e;
                        Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), iOException);
                        c0496w2.a();
                        return null;
                    } catch (XmlPullParserException e9) {
                        e = e9;
                        xmlPullParserException = e;
                        Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), xmlPullParserException);
                        c0496w2.a();
                        return null;
                    }
                }
                throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(resourceId) + "\" (" + Integer.toHexString(resourceId) + ") is not a Font: " + typedValue);
            }
        }
        return null;
    }

    public View K(int i4) {
        return ((RecyclerView) ((q) this.f99g).f93g).getChildAt(i4);
    }

    public int L() {
        return ((RecyclerView) ((q) this.f99g).f93g).getChildCount();
    }

    public boolean M(KeyEvent keyEvent) {
        h2.x[] xVarArr = (h2.x[]) this.f99g;
        if (((HashSet) this.f100h).remove(keyEvent)) {
            return false;
        }
        if (xVarArr.length > 0) {
            h2.w wVar = new h2.w(this, keyEvent);
            for (h2.x xVar : xVarArr) {
                xVar.a(keyEvent, new Z0.D(wVar));
            }
            return true;
        }
        Q(keyEvent);
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(80:5|(2:7|(2:9|(2:10|(2:12|(3:14|15|(1:17)(0))(1:18))(1:19)))(0))(0)|20|(77:243|244|23|(1:25)|26|27|28|(1:30)|240|32|33|(3:215|216|(71:218|(63:220|(1:222)|36|(1:38)|39|(1:41)|42|(2:44|(1:199)(53:48|49|(1:51)|52|(1:54)(2:189|(1:194)(1:193))|(1:56)|57|(1:59)(5:177|(1:179)|180|(1:182)(1:188)|(1:184)(2:185|(1:187)))|60|(1:62)(6:159|(4:162|(2:170|171)(1:168)|169|160)|172|173|(1:175)|176)|63|(1:65)(1:158)|(1:67)|68|(37:154|155|(1:74)|75|(1:77)|78|(31:145|(1:149)|(1:82)|83|(27:140|(1:144)|(1:87)|88|(23:137|(1:139)|(1:92)|93|(1:95)|96|(1:98)|99|(3:101|(1:106)(1:104)|105)|107|(1:109)|110|(1:112)|113|(1:115)|116|(1:136)|118|(4:125|126|(1:128)(1:131)|129)|120|(1:122)|123|124)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)|70|(37:150|151|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)|72|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124))(1:214)|200|(2:209|210)|(1:208)(1:207)|49|(0)|52|(0)(0)|(0)|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|68|(0)|70|(0)|72|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)|223|(66:225|(1:227)|36|(0)|39|(0)|42|(0)(0)|200|(1:202)|209|210|(1:205)|208|49|(0)|52|(0)(0)|(0)|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|68|(0)|70|(0)|72|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)(1:236)|228|(3:230|(1:232)(1:234)|233)|235|36|(0)|39|(0)|42|(0)(0)|200|(0)|209|210|(0)|208|49|(0)|52|(0)(0)|(0)|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|68|(0)|70|(0)|72|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124))|35|36|(0)|39|(0)|42|(0)(0)|200|(0)|209|210|(0)|208|49|(0)|52|(0)(0)|(0)|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|68|(0)|70|(0)|72|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124)|22|23|(0)|26|27|28|(0)|240|32|33|(0)|35|36|(0)|39|(0)|42|(0)(0)|200|(0)|209|210|(0)|208|49|(0)|52|(0)(0)|(0)|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|68|(0)|70|(0)|72|(0)|75|(0)|78|(0)|80|(0)|83|(0)|85|(0)|88|(0)|90|(0)|93|(0)|96|(0)|99|(0)|107|(0)|110|(0)|113|(0)|116|(0)|118|(0)|120|(0)|123|124) */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x020d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x020e, code lost:
    
        android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x00c1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x00c2, code lost:
    
        android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
    
        if (r0 != null) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x050c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x037b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb A[Catch: NameNotFoundException -> 0x00c1, TRY_LEAVE, TryCatch #6 {NameNotFoundException -> 0x00c1, blocks: (B:28:0x00b5, B:30:0x00bb), top: B:27:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0495  */
    /* JADX WARN: Type inference failed for: r0v105, types: [int] */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v180 */
    /* JADX WARN: Type inference failed for: r0v181 */
    /* JADX WARN: Type inference failed for: r5v31, types: [x.j, x.B] */
    /* JADX WARN: Type inference failed for: r7v3, types: [x.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N() {
        /*
            Method dump skipped, instructions count: 1417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.t.N():boolean");
    }

    public void Q(KeyEvent keyEvent) {
        InputConnection inputConnection;
        HashSet hashSet = (HashSet) this.f100h;
        h2.y yVar = (h2.y) this.f101i;
        if (yVar != null) {
            io.flutter.plugin.editing.j jVar = ((h2.p) yVar).f4034r;
            boolean z = false;
            if (jVar.f4288b.isAcceptingText() && (inputConnection = jVar.f4296j) != null) {
                if (inputConnection instanceof io.flutter.plugin.editing.c) {
                    io.flutter.plugin.editing.c cVar = (io.flutter.plugin.editing.c) inputConnection;
                    io.flutter.plugin.editing.f fVar = cVar.f4253d;
                    if (keyEvent.getAction() == 0) {
                        if (keyEvent.getKeyCode() == 21) {
                            z = cVar.d(true, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 22) {
                            z = cVar.d(false, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 19) {
                            z = cVar.e(true, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 20) {
                            z = cVar.e(false, keyEvent.isShiftPressed());
                        } else {
                            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                                EditorInfo editorInfo = cVar.f4254e;
                                if ((editorInfo.inputType & 131072) == 0) {
                                    cVar.performEditorAction(editorInfo.imeOptions & 255);
                                    z = true;
                                }
                            }
                            int selectionStart = Selection.getSelectionStart(fVar);
                            int selectionEnd = Selection.getSelectionEnd(fVar);
                            int unicodeChar = keyEvent.getUnicodeChar();
                            if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                                int min = Math.min(selectionStart, selectionEnd);
                                int max = Math.max(selectionStart, selectionEnd);
                                cVar.beginBatchEdit();
                                if (min != max) {
                                    fVar.delete(min, max);
                                }
                                fVar.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
                                int i4 = min + 1;
                                cVar.setSelection(i4, i4);
                                cVar.endBatchEdit();
                                z = true;
                            }
                        }
                    }
                } else {
                    z = inputConnection.sendKeyEvent(keyEvent);
                }
            }
            if (!z) {
                hashSet.add(keyEvent);
                ((h2.p) yVar).getRootView().dispatchKeyEvent(keyEvent);
                if (hashSet.remove(keyEvent)) {
                    Log.w("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
                }
            }
        }
    }

    public void R(Activity activity, C0687j c0687j) {
        WeakHashMap weakHashMap = (WeakHashMap) this.f101i;
        T2.h.e(activity, "activity");
        ReentrantLock reentrantLock = (ReentrantLock) this.f100h;
        reentrantLock.lock();
        try {
            if (c0687j.equals((C0687j) weakHashMap.get(activity))) {
                return;
            }
            reentrantLock.unlock();
            Iterator it = ((C0740l) ((O) this.f99g).f4911g).f6555b.iterator();
            while (it.hasNext()) {
                C0739k c0739k = (C0739k) it.next();
                if (c0739k.f6549a.equals(activity)) {
                    c0739k.f6551c = c0687j;
                    c0739k.f6550b.accept(c0687j);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0063. Please report as an issue. */
    public boolean S(String str, boolean z, C2.l lVar, C2.a aVar) {
        Map map = lVar.f274c;
        if (((Activity) this.f101i) != null) {
            Bundle D3 = D(map);
            if (z) {
                Iterator it = map.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String lowerCase = ((String) it.next()).toLowerCase(Locale.US);
                        lowerCase.getClass();
                        char c4 = 65535;
                        switch (lowerCase.hashCode()) {
                            case -1423461112:
                                if (!lowerCase.equals("accept")) {
                                    break;
                                } else {
                                    c4 = 0;
                                    break;
                                }
                            case -1229727188:
                                if (!lowerCase.equals("content-language")) {
                                    break;
                                } else {
                                    c4 = 1;
                                    break;
                                }
                            case 785670158:
                                if (!lowerCase.equals("content-type")) {
                                    break;
                                } else {
                                    c4 = 2;
                                    break;
                                }
                            case 802785917:
                                if (!lowerCase.equals("accept-language")) {
                                    break;
                                } else {
                                    c4 = 3;
                                    break;
                                }
                        }
                        switch (c4) {
                        }
                    } else {
                        Uri parse = Uri.parse(str);
                        Activity activity = (Activity) this.f101i;
                        C0614i c0614i = new C0614i();
                        c0614i.f5996a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", aVar.f257a ? 1 : 0);
                        C0615j a4 = c0614i.a();
                        Intent intent = a4.f6003a;
                        intent.putExtra("com.android.browser.headers", D3);
                        try {
                            intent.setData(parse);
                            activity.startActivity(intent, a4.f6004b);
                            return true;
                        } catch (ActivityNotFoundException unused) {
                        }
                    }
                }
            }
            Activity activity2 = (Activity) this.f101i;
            boolean z3 = lVar.f272a;
            boolean z4 = lVar.f273b;
            int i4 = WebViewActivity.f4418j;
            try {
                ((Activity) this.f101i).startActivity(new Intent(activity2, (Class<?>) WebViewActivity.class).putExtra("url", str).putExtra("enableJavaScript", z3).putExtra("enableDomStorage", z4).putExtra("com.android.browser.headers", D3));
                return true;
            } catch (ActivityNotFoundException unused2) {
                return false;
            }
        }
        throw new C2.b();
    }

    public void T() {
        ((TypedArray) this.f100h).recycle();
    }

    public void U(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0313a abstractC0313a = (AbstractC0313a) arrayList.get(i4);
            abstractC0313a.getClass();
            F.k kVar = (F.k) this.f99g;
            Object[] objArr = (Object[]) kVar.f510b;
            T2.h.e(abstractC0313a, "instance");
            int i5 = kVar.f509a;
            for (int i6 = 0; i6 < i5; i6++) {
                if (objArr[i6] == abstractC0313a) {
                    throw new IllegalStateException("Already in the pool!");
                }
            }
            int i7 = kVar.f509a;
            if (i7 < objArr.length) {
                objArr[i7] = abstractC0313a;
                kVar.f509a = i7 + 1;
            }
        }
        arrayList.clear();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [I0.h, java.lang.Object] */
    public void V(F0.a aVar) {
        K k4 = new K(14);
        I0.s sVar = (I0.s) this.f101i;
        I0.j jVar = (I0.j) this.f99g;
        F0.c cVar = (F0.c) this.f100h;
        N0.c cVar2 = sVar.f853c;
        t a4 = I0.j.a();
        a4.W(jVar.f831a);
        a4.f101i = F0.d.f526f;
        a4.f100h = jVar.f832b;
        I0.j x3 = a4.x();
        ?? obj = new Object();
        obj.f824f = new HashMap();
        obj.f822d = Long.valueOf(sVar.f851a.a());
        obj.f823e = Long.valueOf(sVar.f852b.a());
        obj.f819a = "FCM_CLIENT_EVENT_LOGGING";
        Q1.e eVar = aVar.f522a;
        t tVar = P1.t.f1445a;
        tVar.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            tVar.B(eVar, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        obj.f821c = new I0.m(cVar, byteArrayOutputStream.toByteArray());
        obj.f820b = null;
        N0.b bVar = (N0.b) cVar2;
        bVar.f1069b.execute(new Y(bVar, x3, k4, obj.i()));
    }

    public void W(String str) {
        if (str != null) {
            this.f99g = str;
            return;
        }
        throw new NullPointerException("Null backendName");
    }

    public void X(InterfaceC0636h interfaceC0636h) {
        t tVar;
        String str = (String) this.f100h;
        InterfaceC0634f interfaceC0634f = (InterfaceC0634f) this.f99g;
        if (interfaceC0636h == null) {
            tVar = null;
        } else {
            tVar = new t(this, interfaceC0636h);
        }
        interfaceC0634f.a(str, tVar);
    }

    public void Y(final long j4, final q qVar) {
        if (((C0368c) this.f101i) != null) {
            Log.e("FLTFireBGExecutor", "Background isolate already started.");
            return;
        }
        final C0447e c0447e = (C0447e) O().f99g;
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: y2.a
            @Override // java.lang.Runnable
            public final void run() {
                Context context = AbstractC0286a.f3704c;
                C0447e c0447e2 = c0447e;
                c0447e2.d(context);
                Context context2 = AbstractC0286a.f3704c;
                t tVar = new t(A2.t.this, c0447e2, qVar, j4);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    if (c0447e2.f5204b != null) {
                        boolean z = c0447e2.f5203a;
                        Handler handler2 = handler;
                        if (z) {
                            handler2.post(tVar);
                            return;
                        } else {
                            c0447e2.f5208f.execute(new RunnableC0444b(c0447e2, context2, handler2, tVar, 0));
                            return;
                        }
                    }
                    throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
                }
                throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            }
        });
    }

    @Override // B2.InterfaceC0012f
    public Double a(String str, C0013g c0013g) {
        SharedPreferences y3 = y(c0013g);
        if (y3.contains(str)) {
            Object c4 = L.c(y3.getString(str, ""), (H1.f) this.f101i);
            T2.h.c(c4, "null cannot be cast to non-null type kotlin.Double");
            return (Double) c4;
        }
        return null;
    }

    @Override // B2.InterfaceC0012f
    public void b(String str, boolean z, C0013g c0013g) {
        y(c0013g).edit().putBoolean(str, z).apply();
    }

    @Override // B2.InterfaceC0012f
    public void c(String str, String str2, C0013g c0013g) {
        y(c0013g).edit().putString(str, str2).apply();
    }

    @Override // B2.InterfaceC0012f
    public List d(List list, C0013g c0013g) {
        Set set;
        Map<String, ?> all = y(c0013g).getAll();
        T2.h.d(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            T2.h.d(key, "<get-key>(...)");
            String str = key;
            Object value = entry.getValue();
            if (list != null) {
                set = I2.e.K(list);
            } else {
                set = null;
            }
            if (L.b(str, value, set)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return I2.e.I(linkedHashMap.keySet());
    }

    @Override // B2.InterfaceC0012f
    public Long e(String str, C0013g c0013g) {
        long j4;
        SharedPreferences y3 = y(c0013g);
        if (y3.contains(str)) {
            try {
                j4 = y3.getLong(str, 0L);
            } catch (ClassCastException unused) {
                j4 = y3.getInt(str, 0);
            }
            return Long.valueOf(j4);
        }
        return null;
    }

    @Override // B2.InterfaceC0012f
    public void f(List list, C0013g c0013g) {
        Set set;
        SharedPreferences y3 = y(c0013g);
        SharedPreferences.Editor edit = y3.edit();
        T2.h.d(edit, "edit(...)");
        Map<String, ?> all = y3.getAll();
        T2.h.d(all, "getAll(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            Object obj = all.get(str);
            if (list != null) {
                set = I2.e.K(list);
            } else {
                set = null;
            }
            if (L.b(str, obj, set)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            T2.h.d(next, "next(...)");
            edit.remove((String) next);
        }
        edit.apply();
    }

    @Override // K.h
    public Object g() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [R0.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [R0.a, java.lang.Object] */
    @Override // G2.a
    public Object get() {
        switch (this.f98f) {
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return new I0.s(new Object(), new Object(), (N0.c) ((D2.L) this.f99g).get(), (O0.l) ((B1) this.f100h).get(), (O0.m) ((P1.y) this.f101i).get());
            default:
                return new O0.d((Context) ((G2.a) this.f99g).get(), (P0.d) ((G2.a) this.f100h).get(), (O0.b) ((Z0.g) this.f101i).get());
        }
    }

    @Override // K.h
    public ClipDescription getDescription() {
        return (ClipDescription) this.f100h;
    }

    @Override // s2.InterfaceC0632d
    public void h(ByteBuffer byteBuffer, j2.g gVar) {
        AtomicReference atomicReference = (AtomicReference) this.f100h;
        InterfaceC0636h interfaceC0636h = (InterfaceC0636h) this.f99g;
        t tVar = (t) this.f101i;
        String str = (String) tVar.f100h;
        InterfaceC0645q interfaceC0645q = (InterfaceC0645q) tVar.f101i;
        String str2 = interfaceC0645q.d(byteBuffer).f6155a;
        if (str2.equals("listen")) {
            C0635g c0635g = new C0635g(this);
            if (((C0635g) atomicReference.getAndSet(c0635g)) != null) {
                try {
                    interfaceC0636h.onCancel();
                } catch (RuntimeException e4) {
                    Log.e("EventChannel#" + str, "Failed to close existing event stream", e4);
                }
            }
            try {
                interfaceC0636h.c(c0635g);
                gVar.a(interfaceC0645q.a(null));
                return;
            } catch (RuntimeException e5) {
                atomicReference.set(null);
                Log.e("EventChannel#" + str, "Failed to open event stream", e5);
                gVar.a(interfaceC0645q.c("error", e5.getMessage(), null));
                return;
            }
        }
        if (str2.equals("cancel")) {
            if (((C0635g) atomicReference.getAndSet(null)) != null) {
                try {
                    interfaceC0636h.onCancel();
                    gVar.a(interfaceC0645q.a(null));
                    return;
                } catch (RuntimeException e6) {
                    Log.e("EventChannel#" + str, "Failed to close event stream", e6);
                    gVar.a(interfaceC0645q.c("error", e6.getMessage(), null));
                    return;
                }
            }
            gVar.a(interfaceC0645q.c("error", "No active stream to cancel", null));
            return;
        }
        gVar.a(null);
    }

    @Override // B2.InterfaceC0012f
    public void i(String str, String str2, C0013g c0013g) {
        y(c0013g).edit().putString(str, str2).apply();
    }

    @Override // K.h
    public Uri j() {
        return (Uri) this.f99g;
    }

    @Override // B2.InterfaceC0012f
    public void k(String str, double d4, C0013g c0013g) {
        y(c0013g).edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d4).apply();
    }

    @Override // B2.InterfaceC0012f
    public Boolean l(String str, C0013g c0013g) {
        SharedPreferences y3 = y(c0013g);
        if (y3.contains(str)) {
            return Boolean.valueOf(y3.getBoolean(str, true));
        }
        return null;
    }

    @Override // r1.InterfaceC0622c
    public Object n() {
        return new C0605e((q1.j) ((InterfaceC0622c) this.f99g).n(), (C0603c) ((InterfaceC0622c) this.f100h).n(), ((x) ((n.p) this.f101i).f5322g).f117a);
    }

    @Override // B2.InterfaceC0012f
    public ArrayList o(String str, C0013g c0013g) {
        List list;
        SharedPreferences y3 = y(c0013g);
        if (y3.contains(str)) {
            String string = y3.getString(str, "");
            T2.h.b(string);
            if (string.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") && !string.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!") && (list = (List) L.c(y3.getString(str, ""), (H1.f) this.f101i)) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof String) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        if (c0641m.f6155a.equals("MessagingBackground#initialized")) {
            ((AtomicBoolean) this.f99g).set(true);
            List list = FlutterFirebaseMessagingBackgroundService.f4409m;
            Log.i("FLTFireMsgService", "FlutterFirebaseMessagingBackgroundService started!");
            List list2 = FlutterFirebaseMessagingBackgroundService.f4409m;
            synchronized (list2) {
                try {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        FlutterFirebaseMessagingBackgroundService.f4410n.C((Intent) it.next(), null);
                    }
                    FlutterFirebaseMessagingBackgroundService.f4409m.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            ((r2.i) interfaceC0643o).success(Boolean.TRUE);
            return;
        }
        ((r2.i) interfaceC0643o).notImplemented();
    }

    @Override // K.h
    public Uri p() {
        return (Uri) this.f101i;
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        V0.b bVar = (V0.b) this.f99g;
        String str = (String) this.f100h;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f101i;
        synchronized (bVar.f1676a) {
            bVar.f1676a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    @Override // B2.InterfaceC0012f
    public void r(String str, long j4, C0013g c0013g) {
        y(c0013g).edit().putLong(str, j4).apply();
    }

    @Override // B2.InterfaceC0012f
    public String s(String str, C0013g c0013g) {
        SharedPreferences y3 = y(c0013g);
        if (y3.contains(str)) {
            return y3.getString(str, "");
        }
        return null;
    }

    @Override // B2.InterfaceC0012f
    public void t(String str, List list, C0013g c0013g) {
        y(c0013g).edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu".concat(((H1.f) this.f101i).c(list))).apply();
    }

    public String toString() {
        switch (this.f98f) {
            case 17:
                return ((C0314b) this.f100h).toString() + ", hidden list:" + ((ArrayList) this.f101i).size();
            case 20:
                StringBuilder sb = new StringBuilder("DartCallback( bundle path: ");
                sb.append((String) this.f100h);
                sb.append(", library path: ");
                FlutterCallbackInformation flutterCallbackInformation = (FlutterCallbackInformation) this.f101i;
                sb.append(flutterCallbackInformation.callbackLibraryPath);
                sb.append(", function: ");
                return r2.k.c(sb, flutterCallbackInformation.callbackName, " )");
            default:
                return super.toString();
        }
    }

    @Override // e3.d
    public Object u(e3.e eVar, K2.d dVar) {
        Object u3 = ((e3.d) this.f99g).u(new B2.q(eVar, (S.d) this.f100h, (B2.K) this.f101i), dVar);
        if (u3 == L2.a.f1019f) {
            return u3;
        }
        return H2.i.f681a;
    }

    @Override // B2.InterfaceC0012f
    public B2.O v(String str, C0013g c0013g) {
        SharedPreferences y3 = y(c0013g);
        if (!y3.contains(str)) {
            return null;
        }
        String string = y3.getString(str, "");
        T2.h.b(string);
        if (string.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!")) {
            return new B2.O(string, B2.M.JSON_ENCODED);
        }
        if (string.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
            return new B2.O(null, B2.M.PLATFORM_ENCODED);
        }
        return new B2.O(null, B2.M.UNEXPECTED_STRING);
    }

    @Override // B2.InterfaceC0012f
    public Map w(List list, C0013g c0013g) {
        Set set;
        Object value;
        Map<String, ?> all = y(c0013g).getAll();
        T2.h.d(all, "getAll(...)");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value2 = entry.getValue();
            if (list != null) {
                set = I2.e.K(list);
            } else {
                set = null;
            }
            if (L.b(key, value2, set) && (value = entry.getValue()) != null) {
                String key2 = entry.getKey();
                Object c4 = L.c(value, (H1.f) this.f101i);
                T2.h.c(c4, "null cannot be cast to non-null type kotlin.Any");
                hashMap.put(key2, c4);
            }
        }
        return hashMap;
    }

    public I0.j x() {
        String str;
        if (((String) this.f99g) == null) {
            str = " backendName";
        } else {
            str = "";
        }
        if (((F0.d) this.f101i) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new I0.j((String) this.f99g, (byte[]) this.f100h, (F0.d) this.f101i);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public SharedPreferences y(C0013g c0013g) {
        Context context = (Context) this.f100h;
        String str = c0013g.f195a;
        if (str == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            T2.h.b(sharedPreferences);
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        T2.h.b(sharedPreferences2);
        return sharedPreferences2;
    }

    public void z(int i4, io.flutter.view.g gVar) {
        ((FlutterJNI) this.f100h).dispatchSemanticsAction(i4, gVar);
    }

    public /* synthetic */ t(Object obj, Object obj2, Object obj3, int i4) {
        this.f98f = i4;
        this.f99g = obj;
        this.f100h = obj2;
        this.f101i = obj3;
    }

    public t(I0.j jVar, F0.c cVar, K k4, I0.s sVar) {
        this.f98f = 7;
        this.f99g = jVar;
        this.f100h = cVar;
        this.f101i = sVar;
    }

    public t(X x3, V v3, a0.b bVar) {
        this.f98f = 14;
        T2.h.e(x3, "store");
        T2.h.e(bVar, "defaultCreationExtras");
        this.f99g = x3;
        this.f100h = v3;
        this.f101i = bVar;
    }

    public t(q qVar) {
        this.f98f = 17;
        this.f99g = qVar;
        this.f100h = new C0314b();
        this.f101i = new ArrayList();
    }

    public t(InterfaceC0634f interfaceC0634f, String str) {
        this.f98f = 26;
        C0651w c0651w = C0651w.f6163a;
        this.f99g = interfaceC0634f;
        this.f100h = str;
        this.f101i = c0651w;
    }

    public t(Context context) {
        this.f98f = 3;
        C2.c cVar = new C2.c(0, context);
        this.f99g = context;
        this.f100h = cVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(X x3, V v3) {
        this(x3, v3, a0.a.f2214b);
        this.f98f = 14;
        T2.h.e(x3, "store");
    }

    public t(FirebaseMessagingService firebaseMessagingService, q qVar, ExecutorService executorService) {
        this.f98f = 11;
        this.f99g = executorService;
        this.f100h = firebaseMessagingService;
        this.f101i = qVar;
    }

    public t(Context context, TypedArray typedArray) {
        this.f98f = 21;
        this.f99g = context;
        this.f100h = typedArray;
    }

    public t(Context context, LocationManager locationManager) {
        this.f98f = 19;
        this.f101i = new Object();
        this.f99g = context;
        this.f100h = locationManager;
    }

    public t(H1.f fVar) {
        this.f98f = 16;
        this.f99g = new F.k(30);
        this.f100h = new ArrayList();
        this.f101i = new ArrayList();
        new Z0.g(this);
    }

    public t(C0427b c0427b, FlutterJNI flutterJNI) {
        this.f98f = 23;
        O o3 = new O(7, this);
        P1.y yVar = new P1.y(c0427b, "flutter/accessibility", C0650v.f6160a, null);
        this.f99g = yVar;
        yVar.w(o3);
        this.f100h = flutterJNI;
    }

    public t(h2.y yVar) {
        this.f98f = 18;
        this.f100h = new HashSet();
        this.f101i = yVar;
        h2.p pVar = (h2.p) yVar;
        this.f99g = new h2.x[]{new h2.u(pVar.getBinaryMessenger()), new E0.a(new n.p(pVar.getBinaryMessenger()))};
        new O(pVar.getBinaryMessenger()).f4911g = this;
    }

    public t(int i4) {
        this.f98f = i4;
        switch (i4) {
            case 28:
                this.f99g = new AtomicBoolean(false);
                return;
            default:
                this.f99g = new ConcurrentLinkedQueue();
                return;
        }
    }

    public t(t tVar, InterfaceC0636h interfaceC0636h) {
        this.f98f = 25;
        this.f101i = tVar;
        this.f100h = new AtomicReference(null);
        this.f99g = interfaceC0636h;
    }

    @Override // K.h
    public void m() {
    }

    public t(InterfaceC0634f interfaceC0634f, Context context, H1.f fVar) {
        this.f98f = 1;
        T2.h.e(interfaceC0634f, "messenger");
        T2.h.e(context, "context");
        this.f99g = interfaceC0634f;
        this.f100h = context;
        this.f101i = fVar;
        try {
            InterfaceC0012f.f194b.getClass();
            C0011e.b(interfaceC0634f, this, "shared_preferences");
        } catch (Exception e4) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesBackend", e4);
        }
    }

    public t(io.flutter.plugins.firebase.messaging.a aVar) {
        this.f98f = 29;
        this.f101i = aVar;
        this.f99g = Executors.newSingleThreadExecutor();
        this.f100h = new Handler(Looper.getMainLooper());
    }

    public t(O o3) {
        this.f98f = 27;
        this.f99g = o3;
        this.f100h = new ReentrantLock();
        this.f101i = new WeakHashMap();
    }
}
