package j;

import I.InterfaceC0062p;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.Toolbar;
import d2.C0264e;
import j2.C0427b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n.C0457g;
import n.InterfaceC0448A;
import n.RunnableC0456f;
import n.ViewOnKeyListenerC0458h;
import o.C0523j;
import o.C0553y;
import o.InterfaceC0488N0;
import o.InterfaceC0510d0;
import q1.C0605e;
import r1.InterfaceC0622c;
import s2.C0638j;
import s2.C0639k;
import s2.C0641m;
import s2.C0644p;
import s2.C0651w;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import v2.C0693b;

/* loaded from: classes.dex */
public class O implements InterfaceC0488N0, InterfaceC0448A, InterfaceC0510d0, n.l, InterfaceC0622c, InterfaceC0630b, InterfaceC0642n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4910f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4911g;

    public /* synthetic */ O(int i4, Object obj) {
        this.f4910f = i4;
        this.f4911g = obj;
    }

    @Override // n.InterfaceC0448A
    public void a(n.n nVar, boolean z) {
        if (nVar instanceof n.H) {
            ((n.H) nVar).f5229A.k().c(false);
        }
        InterfaceC0448A interfaceC0448A = ((C0523j) this.f4911g).f5605j;
        if (interfaceC0448A != null) {
            interfaceC0448A.a(nVar, z);
        }
    }

    @Override // n.InterfaceC0448A
    public boolean c(n.n nVar) {
        C0523j c0523j = (C0523j) this.f4911g;
        if (nVar == c0523j.f5603h) {
            return false;
        }
        ((n.H) nVar).f5230B.getClass();
        c0523j.getClass();
        InterfaceC0448A interfaceC0448A = c0523j.f5605j;
        if (interfaceC0448A == null) {
            return false;
        }
        return interfaceC0448A.c(nVar);
    }

    @Override // o.InterfaceC0488N0
    public void e(n.n nVar, MenuItem menuItem) {
        ((ViewOnKeyListenerC0458h) this.f4911g).k.removeCallbacksAndMessages(nVar);
    }

    @Override // s2.InterfaceC0630b
    public void f(Object obj, io.flutter.plugin.platform.s sVar) {
        A2.t tVar = (A2.t) this.f4911g;
        if (((io.flutter.view.d) tVar.f101i) == null) {
            sVar.t(null);
            return;
        }
        HashMap hashMap = (HashMap) obj;
        String str = (String) hashMap.get("type");
        HashMap hashMap2 = (HashMap) hashMap.get("data");
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1140076541:
                if (str.equals("tooltip")) {
                    c4 = 0;
                    break;
                }
                break;
            case -649620375:
                if (str.equals("announce")) {
                    c4 = 1;
                    break;
                }
                break;
            case 114595:
                if (str.equals("tap")) {
                    c4 = 2;
                    break;
                }
                break;
            case 97604824:
                if (str.equals("focus")) {
                    c4 = 3;
                    break;
                }
                break;
            case 114203431:
                if (str.equals("longPress")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                String str2 = (String) hashMap2.get("message");
                if (str2 != null) {
                    io.flutter.view.j jVar = (io.flutter.view.j) ((io.flutter.view.d) tVar.f101i).f4423a;
                    if (Build.VERSION.SDK_INT < 28) {
                        AccessibilityEvent e4 = jVar.e(0, 32);
                        e4.getText().add(str2);
                        jVar.i(e4);
                        break;
                    }
                }
                break;
            case 1:
                String str3 = (String) hashMap2.get("message");
                if (str3 != null) {
                    io.flutter.view.d dVar = (io.flutter.view.d) tVar.f101i;
                    if (Build.VERSION.SDK_INT >= 36) {
                        dVar.getClass();
                        Log.w("AccessibilityBridge", "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
                    }
                    ((io.flutter.view.j) dVar.f4423a).f4509a.announceForAccessibility(str3);
                    break;
                }
                break;
            case 2:
                Integer num = (Integer) hashMap.get("nodeId");
                if (num != null) {
                    ((io.flutter.view.j) ((io.flutter.view.d) tVar.f101i).f4423a).h(num.intValue(), 1);
                    break;
                }
                break;
            case 3:
                Integer num2 = (Integer) hashMap.get("nodeId");
                if (num2 != null) {
                    ((io.flutter.view.j) ((io.flutter.view.d) tVar.f101i).f4423a).h(num2.intValue(), 8);
                    break;
                }
                break;
            case 4:
                Integer num3 = (Integer) hashMap.get("nodeId");
                if (num3 != null) {
                    ((io.flutter.view.j) ((io.flutter.view.d) tVar.f101i).f4423a).h(num3.intValue(), 2);
                    break;
                }
                break;
        }
        sVar.t(null);
    }

    @Override // n.l
    public boolean h(n.n nVar, MenuItem menuItem) {
        return false;
    }

    @Override // n.l
    public void i(n.n nVar) {
        Toolbar toolbar = (Toolbar) this.f4911g;
        C0523j c0523j = toolbar.f2474f.f2354y;
        if (c0523j == null || !c0523j.f()) {
            Iterator it = toolbar.f2461L.f775b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.H) ((InterfaceC0062p) it.next())).f2725a.t();
            }
        }
        R1.c cVar = toolbar.f2468T;
        if (cVar != null) {
            cVar.i(nVar);
        }
    }

    @Override // r1.InterfaceC0622c
    public Object n() {
        C0605e c0605e = (C0605e) ((InterfaceC0622c) this.f4911g).n();
        if (c0605e != null) {
            return c0605e;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // o.InterfaceC0488N0
    public void o(n.n nVar, n.q qVar) {
        ViewOnKeyListenerC0458h viewOnKeyListenerC0458h = (ViewOnKeyListenerC0458h) this.f4911g;
        Handler handler = viewOnKeyListenerC0458h.k;
        C0457g c0457g = null;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = viewOnKeyListenerC0458h.f5269m;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                if (nVar == ((C0457g) arrayList.get(i4)).f5257b) {
                    break;
                } else {
                    i4++;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 == -1) {
            return;
        }
        int i5 = i4 + 1;
        if (i5 < arrayList.size()) {
            c0457g = (C0457g) arrayList.get(i5);
        }
        handler.postAtTime(new RunnableC0456f(this, c0457g, qVar, nVar), nVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        boolean z;
        ByteBuffer byteBuffer;
        double d4;
        int i4;
        boolean isStylusHandwritingAvailable;
        boolean isStylusHandwritingAvailable2;
        int i5 = 3;
        char c4 = 65535;
        boolean z3 = true;
        boolean z4 = false;
        switch (this.f4910f) {
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                ((W0.g) this.f4911g).getClass();
                return;
            case 9:
            case 11:
            default:
                n.p pVar = (n.p) this.f4911g;
                if (((io.flutter.plugin.editing.g) pVar.f5322g) != null) {
                    String str = c0641m.f6155a;
                    Object obj = c0641m.f6156b;
                    str.getClass();
                    if (!str.equals("SpellCheck.initiateSpellCheck")) {
                        ((r2.i) interfaceC0643o).notImplemented();
                        return;
                    }
                    try {
                        ArrayList arrayList = (ArrayList) obj;
                        ((io.flutter.plugin.editing.g) pVar.f5322g).a((String) arrayList.get(0), (String) arrayList.get(1), (r2.i) interfaceC0643o);
                        return;
                    } catch (IllegalStateException e4) {
                        ((r2.i) interfaceC0643o).error("error", e4.getMessage(), null);
                        return;
                    }
                }
                return;
            case 10:
                n.p pVar2 = (n.p) this.f4911g;
                if (((n.p) pVar2.f5322g) != null) {
                    String str2 = c0641m.f6155a;
                    try {
                        if (str2.hashCode() == -1307105544 && str2.equals("activateSystemCursor")) {
                            try {
                                ((n.p) pVar2.f5322g).d((String) ((HashMap) c0641m.f6156b).get("kind"));
                                ((r2.i) interfaceC0643o).success(Boolean.TRUE);
                            } catch (Exception e5) {
                                ((r2.i) interfaceC0643o).error("error", "Error when setting cursors: " + e5.getMessage(), null);
                            }
                        }
                        return;
                    } catch (Exception e6) {
                        ((r2.i) interfaceC0643o).error("error", "Unhandled error: " + e6.getMessage(), null);
                        return;
                    }
                }
                return;
            case 12:
                io.flutter.plugin.platform.s sVar = (io.flutter.plugin.platform.s) this.f4911g;
                if (((r2.h) sVar.f4391h) != null) {
                    String str3 = c0641m.f6155a;
                    Object obj2 = c0641m.f6156b;
                    str3.getClass();
                    switch (str3.hashCode()) {
                        case -1352294148:
                            if (str3.equals("create")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -1019779949:
                            if (str3.equals("offset")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case -934437708:
                            if (str3.equals("resize")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case -756050293:
                            if (str3.equals("clearFocus")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case -308988850:
                            if (str3.equals("synchronizeToNativeViewHierarchy")) {
                                c4 = 4;
                                break;
                            }
                            break;
                        case 110550847:
                            if (str3.equals("touch")) {
                                c4 = 5;
                                break;
                            }
                            break;
                        case 576796989:
                            if (str3.equals("setDirection")) {
                                c4 = 6;
                                break;
                            }
                            break;
                        case 1671767583:
                            if (str3.equals("dispose")) {
                                c4 = 7;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            Map map = (Map) obj2;
                            if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (map.containsKey("params")) {
                                byteBuffer = ByteBuffer.wrap((byte[]) map.get("params"));
                            } else {
                                byteBuffer = null;
                            }
                            try {
                                if (z) {
                                    ((r2.h) sVar.f4391h).i(new r2.e(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), 3, byteBuffer));
                                    ((r2.i) interfaceC0643o).success(null);
                                    return;
                                }
                                if (map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue()) {
                                    z4 = true;
                                }
                                int intValue = ((Integer) map.get("id")).intValue();
                                String str4 = (String) map.get("viewType");
                                double d5 = 0.0d;
                                if (map.containsKey("top")) {
                                    d4 = ((Double) map.get("top")).doubleValue();
                                } else {
                                    d4 = 0.0d;
                                }
                                if (map.containsKey("left")) {
                                    d5 = ((Double) map.get("left")).doubleValue();
                                }
                                double d6 = d5;
                                double doubleValue = ((Double) map.get("width")).doubleValue();
                                double doubleValue2 = ((Double) map.get("height")).doubleValue();
                                int intValue2 = ((Integer) map.get("direction")).intValue();
                                if (z4) {
                                    i4 = 2;
                                } else {
                                    i4 = 1;
                                }
                                long j4 = ((r2.h) sVar.f4391h).j(new r2.e(intValue, str4, d4, d6, doubleValue, doubleValue2, intValue2, i4, byteBuffer));
                                if (j4 == -2) {
                                    if (z4) {
                                        ((r2.i) interfaceC0643o).success(null);
                                        return;
                                    }
                                    throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                                }
                                ((r2.i) interfaceC0643o).success(Long.valueOf(j4));
                                return;
                            } catch (IllegalStateException e7) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e7), null);
                                return;
                            }
                        case 1:
                            Map map2 = (Map) obj2;
                            try {
                                ((r2.h) sVar.f4391h).e(((Integer) map2.get("id")).intValue(), ((Double) map2.get("top")).doubleValue(), ((Double) map2.get("left")).doubleValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e8) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e8), null);
                                return;
                            }
                        case 2:
                            Map map3 = (Map) obj2;
                            try {
                                ((r2.h) sVar.f4391h).p(new r2.g(((Integer) map3.get("id")).intValue(), ((Double) map3.get("width")).doubleValue(), ((Double) map3.get("height")).doubleValue()), new C0264e((r2.i) interfaceC0643o));
                                return;
                            } catch (IllegalStateException e9) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e9), null);
                                return;
                            }
                        case 3:
                            try {
                                ((r2.h) sVar.f4391h).m(((Integer) obj2).intValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e10) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e10), null);
                                return;
                            }
                        case 4:
                            try {
                                ((r2.h) sVar.f4391h).c(((Boolean) obj2).booleanValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e11) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e11), null);
                                return;
                            }
                        case 5:
                            List list = (List) obj2;
                            try {
                                ((r2.h) sVar.f4391h).a(new r2.f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e12) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e12), null);
                                return;
                            }
                        case 6:
                            Map map4 = (Map) obj2;
                            try {
                                ((r2.h) sVar.f4391h).f(((Integer) map4.get("id")).intValue(), ((Integer) map4.get("direction")).intValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e13) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e13), null);
                                return;
                            }
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            try {
                                ((r2.h) sVar.f4391h).s(((Integer) ((Map) obj2).get("id")).intValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e14) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e14), null);
                                return;
                            }
                        default:
                            ((r2.i) interfaceC0643o).notImplemented();
                            return;
                    }
                }
                return;
            case 13:
                io.flutter.plugin.platform.s sVar2 = (io.flutter.plugin.platform.s) this.f4911g;
                if (((C0693b) sVar2.f4391h) != null) {
                    String str5 = c0641m.f6155a;
                    Object obj3 = c0641m.f6156b;
                    str5.getClass();
                    if (!str5.equals("ProcessText.processTextAction")) {
                        if (!str5.equals("ProcessText.queryTextActions")) {
                            ((r2.i) interfaceC0643o).notImplemented();
                            return;
                        }
                        try {
                            ((r2.i) interfaceC0643o).success(((C0693b) sVar2.f4391h).b());
                            return;
                        } catch (IllegalStateException e15) {
                            ((r2.i) interfaceC0643o).error("error", e15.getMessage(), null);
                            return;
                        }
                    }
                    try {
                        ArrayList arrayList2 = (ArrayList) obj3;
                        ((C0693b) sVar2.f4391h).a((String) arrayList2.get(0), (String) arrayList2.get(1), ((Boolean) arrayList2.get(2)).booleanValue(), (r2.i) interfaceC0643o);
                        return;
                    } catch (IllegalStateException e16) {
                        ((r2.i) interfaceC0643o).error("error", e16.getMessage(), null);
                        return;
                    }
                }
                return;
            case 14:
                n.p pVar3 = (n.p) this.f4911g;
                if (((E0.a) pVar3.f5322g) != null) {
                    String str6 = c0641m.f6155a;
                    str6.getClass();
                    switch (str6.hashCode()) {
                        case -705821951:
                            if (str6.equals("Scribe.isFeatureAvailable")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case 1759284829:
                            if (str6.equals("Scribe.startStylusHandwriting")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 2119738044:
                            if (str6.equals("Scribe.isStylusHandwritingAvailable")) {
                                c4 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            try {
                                E0.a aVar = (E0.a) pVar3.f5322g;
                                if (Build.VERSION.SDK_INT >= 34) {
                                    isStylusHandwritingAvailable = ((InputMethodManager) aVar.f459g).isStylusHandwritingAvailable();
                                    if (isStylusHandwritingAvailable) {
                                        ((r2.i) interfaceC0643o).success(Boolean.valueOf(z3));
                                        return;
                                    }
                                } else {
                                    aVar.getClass();
                                }
                                z3 = false;
                                ((r2.i) interfaceC0643o).success(Boolean.valueOf(z3));
                                return;
                            } catch (IllegalStateException e17) {
                                ((r2.i) interfaceC0643o).error("error", e17.getMessage(), null);
                                return;
                            }
                        case 1:
                            if (Build.VERSION.SDK_INT < 33) {
                                ((r2.i) interfaceC0643o).error("error", "Requires API level 33 or higher.", null);
                                return;
                            }
                            try {
                                E0.a aVar2 = (E0.a) pVar3.f5322g;
                                A2.m.w((InputMethodManager) aVar2.f459g, (View) aVar2.f460h);
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e18) {
                                ((r2.i) interfaceC0643o).error("error", e18.getMessage(), null);
                                return;
                            }
                        case 2:
                            if (Build.VERSION.SDK_INT >= 34) {
                                try {
                                    isStylusHandwritingAvailable2 = ((InputMethodManager) ((E0.a) pVar3.f5322g).f459g).isStylusHandwritingAvailable();
                                    ((r2.i) interfaceC0643o).success(Boolean.valueOf(isStylusHandwritingAvailable2));
                                    return;
                                } catch (IllegalStateException e19) {
                                    ((r2.i) interfaceC0643o).error("error", e19.getMessage(), null);
                                    return;
                                }
                            }
                            ((r2.i) interfaceC0643o).error("error", "Requires API level 34 or higher.", null);
                            return;
                        default:
                            ((r2.i) interfaceC0643o).notImplemented();
                            return;
                    }
                }
                return;
            case 15:
                n.p pVar4 = (n.p) this.f4911g;
                if (((C0553y) pVar4.f5322g) != null) {
                    String str7 = c0641m.f6155a;
                    str7.getClass();
                    switch (str7.hashCode()) {
                        case -1937987631:
                            if (str7.equals("SensitiveContent.getContentSensitivity")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case 598223325:
                            if (str7.equals("SensitiveContent.setContentSensitivity")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 1615625817:
                            if (str7.equals("SensitiveContent.isSupported")) {
                                c4 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            try {
                                int b4 = ((C0553y) pVar4.f5322g).b();
                                if (b4 != 0) {
                                    if (b4 != 1) {
                                        if (b4 == 2) {
                                            i5 = 2;
                                        }
                                    } else {
                                        i5 = 1;
                                    }
                                } else {
                                    i5 = 0;
                                }
                                ((r2.i) interfaceC0643o).success(Integer.valueOf(i5));
                                return;
                            } catch (IllegalArgumentException | IllegalStateException e20) {
                                ((r2.i) interfaceC0643o).error("error", e20.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                ((C0553y) pVar4.f5322g).d(n.p.a(pVar4, ((Integer) c0641m.f6156b).intValue()));
                                return;
                            } catch (IllegalArgumentException | IllegalStateException e21) {
                                ((r2.i) interfaceC0643o).error("error", e21.getMessage(), null);
                                return;
                            }
                        case 2:
                            ((C0553y) pVar4.f5322g).getClass();
                            if (Build.VERSION.SDK_INT < 35) {
                                z3 = false;
                            }
                            ((r2.i) interfaceC0643o).success(Boolean.valueOf(z3));
                            return;
                        default:
                            ((r2.i) interfaceC0643o).notImplemented();
                            return;
                    }
                }
                return;
        }
    }

    public O(int i4) {
        this.f4910f = i4;
        switch (i4) {
            case 18:
                this.f4911g = new LinkedHashMap(0, 0.75f, true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, s2.n] */
    public O(C0427b c0427b, int i4) {
        this.f4910f = i4;
        switch (i4) {
            case 17:
                this.f4911g = new P1.y(c0427b, "flutter/system", C0638j.f6153a, null);
                return;
            default:
                ?? obj = new Object();
                C0644p c0644p = new C0644p(c0427b, "flutter/navigation", C0639k.f6154a);
                this.f4911g = c0644p;
                c0644p.b(obj);
                return;
        }
    }

    public O(InterfaceC0634f interfaceC0634f) {
        this.f4910f = 9;
        new C0644p(interfaceC0634f, "flutter/keyboard", C0651w.f6163a).b(new io.flutter.plugin.platform.s(this));
    }

    @Override // o.InterfaceC0510d0
    public void b(int i4) {
    }

    @Override // o.InterfaceC0510d0
    public void d(int i4) {
    }
}
