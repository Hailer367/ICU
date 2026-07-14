package n;

import I.L;
import I.T;
import I.v0;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import android.window.BackEvent;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import h0.C0324l;
import io.flutter.embedding.engine.FlutterJNI;
import j.C0402J;
import j.O;
import j2.C0427b;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import o.C0541s;
import o.InterfaceC0529m;
import o.u1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p1.InterfaceC0573b;
import p1.InterfaceC0575d;
import p1.InterfaceC0576e;
import q1.C0604d;
import r1.C0621b;
import r1.InterfaceC0622c;
import s2.C0638j;
import s2.C0639k;
import s2.C0641m;
import s2.C0644p;
import s2.C0651w;
import s2.InterfaceC0634f;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import t2.C0664a;
import u2.InterfaceC0668a;
import v.AbstractFutureC0676h;
import v.C0671c;

/* loaded from: classes.dex */
public final class p implements l, InterfaceC0529m, InterfaceC0576e, InterfaceC0575d, InterfaceC0573b, InterfaceC0622c, InterfaceC0642n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5321f;

    /* renamed from: g, reason: collision with root package name */
    public Object f5322g;

    public /* synthetic */ p(int i4, Object obj) {
        this.f5321f = i4;
        this.f5322g = obj;
    }

    public static int a(p pVar, int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                return 1;
            }
            if (i4 == 2) {
                return 2;
            }
            throw new IllegalArgumentException("contentSensitivityIndex " + i4 + " not known to the SensitiveContentChannel.");
        }
        return 0;
    }

    public static HashMap f(BackEvent backEvent) {
        float touchX;
        float touchY;
        List list;
        float progress;
        int swipeEdge;
        HashMap hashMap = new HashMap(3);
        touchX = backEvent.getTouchX();
        touchY = backEvent.getTouchY();
        if (!Float.isNaN(touchX) && !Float.isNaN(touchY)) {
            list = Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY));
        } else {
            list = null;
        }
        hashMap.put("touchOffset", list);
        progress = backEvent.getProgress();
        hashMap.put("progress", Float.valueOf(progress));
        swipeEdge = backEvent.getSwipeEdge();
        hashMap.put("swipeEdge", Integer.valueOf(swipeEdge));
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0189 A[Catch: JSONException -> 0x002e, TryCatch #10 {JSONException -> 0x002e, blocks: (B:5:0x0015, B:6:0x001e, B:11:0x00d1, B:14:0x00d9, B:16:0x010a, B:19:0x0130, B:21:0x0123, B:24:0x012a, B:25:0x0142, B:27:0x016b, B:37:0x016f, B:30:0x017f, B:32:0x0189, B:34:0x0199, B:39:0x0174, B:40:0x01a1, B:42:0x01b1, B:43:0x01c2, B:45:0x01bf, B:46:0x01ca, B:48:0x01de, B:49:0x01e3, B:51:0x0213, B:53:0x0226, B:66:0x0328, B:56:0x0348, B:58:0x0358, B:59:0x0367, B:98:0x0207, B:124:0x0281, B:91:0x02a5, B:84:0x02f1, B:105:0x031d, B:70:0x033d, B:63:0x036f, B:126:0x0023, B:129:0x0031, B:132:0x003c, B:135:0x0048, B:138:0x0054, B:141:0x005f, B:144:0x006b, B:147:0x0075, B:150:0x007f, B:153:0x0089, B:156:0x0093, B:159:0x009d, B:162:0x00a8, B:165:0x00b3, B:168:0x00be, B:73:0x02b1, B:75:0x02bb, B:76:0x02be, B:78:0x02d6, B:79:0x02e8, B:82:0x02df), top: B:4:0x0015, inners: #1, #9, #11, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0199 A[Catch: JSONException -> 0x002e, TryCatch #10 {JSONException -> 0x002e, blocks: (B:5:0x0015, B:6:0x001e, B:11:0x00d1, B:14:0x00d9, B:16:0x010a, B:19:0x0130, B:21:0x0123, B:24:0x012a, B:25:0x0142, B:27:0x016b, B:37:0x016f, B:30:0x017f, B:32:0x0189, B:34:0x0199, B:39:0x0174, B:40:0x01a1, B:42:0x01b1, B:43:0x01c2, B:45:0x01bf, B:46:0x01ca, B:48:0x01de, B:49:0x01e3, B:51:0x0213, B:53:0x0226, B:66:0x0328, B:56:0x0348, B:58:0x0358, B:59:0x0367, B:98:0x0207, B:124:0x0281, B:91:0x02a5, B:84:0x02f1, B:105:0x031d, B:70:0x033d, B:63:0x036f, B:126:0x0023, B:129:0x0031, B:132:0x003c, B:135:0x0048, B:138:0x0054, B:141:0x005f, B:144:0x006b, B:147:0x0075, B:150:0x007f, B:153:0x0089, B:156:0x0093, B:159:0x009d, B:162:0x00a8, B:165:0x00b3, B:168:0x00be, B:73:0x02b1, B:75:0x02bb, B:76:0x02be, B:78:0x02d6, B:79:0x02e8, B:82:0x02df), top: B:4:0x0015, inners: #1, #9, #11, #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j(s2.C0641m r13, s2.InterfaceC0643o r14) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.p.j(s2.m, s2.o):void");
    }

    public static String p(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e4) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e4);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + "]";
            }
        }
        return str + " : " + str2;
    }

    @Override // p1.InterfaceC0573b
    public void b() {
        ((CountDownLatch) this.f5322g).countDown();
    }

    @Override // p1.InterfaceC0575d
    public void c(Exception exc) {
        ((CountDownLatch) this.f5322g).countDown();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.AbstractMap, h2.z, java.util.HashMap] */
    public void d(String str) {
        InterfaceC0668a interfaceC0668a = (InterfaceC0668a) ((io.flutter.plugin.platform.s) this.f5322g).f4390g;
        if (io.flutter.plugin.platform.s.f4388i == null) {
            ?? hashMap = new HashMap();
            hashMap.put("alias", 1010);
            hashMap.put("allScroll", 1013);
            hashMap.put("basic", 1000);
            hashMap.put("cell", 1006);
            hashMap.put("click", 1002);
            hashMap.put("contextMenu", 1001);
            hashMap.put("copy", 1011);
            hashMap.put("forbidden", 1012);
            hashMap.put("grab", 1020);
            hashMap.put("grabbing", 1021);
            hashMap.put("help", 1003);
            hashMap.put("move", 1013);
            hashMap.put("none", 0);
            hashMap.put("noDrop", 1012);
            hashMap.put("precise", 1007);
            hashMap.put("text", 1008);
            hashMap.put("resizeColumn", 1014);
            hashMap.put("resizeDown", 1015);
            hashMap.put("resizeUpLeft", 1016);
            hashMap.put("resizeDownRight", 1017);
            hashMap.put("resizeLeft", 1014);
            hashMap.put("resizeLeftRight", 1014);
            hashMap.put("resizeRight", 1014);
            hashMap.put("resizeRow", 1015);
            hashMap.put("resizeUp", 1015);
            hashMap.put("resizeUpDown", 1015);
            hashMap.put("resizeUpLeft", 1017);
            hashMap.put("resizeUpRight", 1016);
            hashMap.put("resizeUpLeftDownRight", 1017);
            hashMap.put("resizeUpRightDownLeft", 1016);
            hashMap.put("verticalText", 1009);
            hashMap.put("wait", 1004);
            hashMap.put("zoomIn", 1018);
            hashMap.put("zoomOut", 1019);
            io.flutter.plugin.platform.s.f4388i = hashMap;
        }
        interfaceC0668a.setPointerIcon(PointerIcon.getSystemIcon(((h2.p) interfaceC0668a).getContext(), ((Integer) io.flutter.plugin.platform.s.f4388i.getOrDefault(str, 1000)).intValue()));
    }

    @Override // p1.InterfaceC0576e
    public void e(Object obj) {
        ((CountDownLatch) this.f5322g).countDown();
    }

    public String g(String str, String str2) {
        C0664a c0664a = (C0664a) this.f5322g;
        Context context = c0664a.f6205b;
        if (str2 != null) {
            Locale a4 = C0664a.a(str2);
            Configuration configuration = new Configuration(c0664a.f6205b.getResources().getConfiguration());
            configuration.setLocale(a4);
            context = c0664a.f6205b.createConfigurationContext(configuration);
        }
        int identifier = context.getResources().getIdentifier(str, "string", c0664a.f6205b.getPackageName());
        if (identifier != 0) {
            return context.getResources().getString(identifier);
        }
        return null;
    }

    @Override // n.l
    public boolean h(n nVar, MenuItem menuItem) {
        boolean z;
        InterfaceC0529m interfaceC0529m = ((ActionMenuView) this.f5322g).f2349F;
        if (interfaceC0529m != null) {
            Toolbar toolbar = (Toolbar) ((p) interfaceC0529m).f5322g;
            if (toolbar.f2461L.a()) {
                z = true;
            } else {
                u1 u1Var = toolbar.f2463N;
                if (u1Var != null) {
                    z = ((C0402J) u1Var).f4893a.f4895b.onMenuItemSelected(0, menuItem);
                } else {
                    z = false;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // n.l
    public void i(n nVar) {
        l lVar = ((ActionMenuView) this.f5322g).f2344A;
        if (lVar != null) {
            lVar.i(nVar);
        }
    }

    public void k(Exception exc) {
        y1.h hVar = (y1.h) this.f5322g;
        if (AbstractFutureC0676h.k.c(hVar, null, new C0671c(exc))) {
            AbstractFutureC0676h.c(hVar);
        }
    }

    public void l(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            Log.d("PlayCore", p((String) this.f5322g, str, objArr));
        }
    }

    public void m(RemoteException remoteException, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", p((String) this.f5322g, str, objArr), remoteException);
        }
    }

    @Override // r1.InterfaceC0622c
    public Object n() {
        return ((A2.x) this.f5322g).f117a;
    }

    public void o(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            Log.i("PlayCore", p((String) this.f5322g, str, objArr));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        String str;
        char c4;
        ByteBuffer byteBuffer;
        char c5;
        Bundle bundle;
        boolean z = false;
        switch (this.f5321f) {
            case 9:
                io.flutter.plugin.platform.s sVar = (io.flutter.plugin.platform.s) this.f5322g;
                if (((p) sVar.f4391h) != null) {
                    String str2 = c0641m.f6155a;
                    str2.getClass();
                    if (!str2.equals("Localization.getStringResource")) {
                        ((r2.i) interfaceC0643o).notImplemented();
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) c0641m.f6156b;
                    try {
                        String string = jSONObject.getString("key");
                        if (jSONObject.has("locale")) {
                            str = jSONObject.getString("locale");
                        } else {
                            str = null;
                        }
                        ((r2.i) interfaceC0643o).success(((p) sVar.f4391h).g(string, str));
                        return;
                    } catch (JSONException e4) {
                        ((r2.i) interfaceC0643o).error("error", e4.getMessage(), null);
                        return;
                    }
                }
                return;
            case 10:
            default:
                io.flutter.plugin.platform.s sVar2 = (io.flutter.plugin.platform.s) this.f5322g;
                if (((R1.c) sVar2.f4391h) != null) {
                    String str3 = c0641m.f6155a;
                    Object obj = c0641m.f6156b;
                    str3.getClass();
                    switch (str3.hashCode()) {
                        case -1779068172:
                            if (str3.equals("TextInput.setPlatformViewClient")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case -1015421462:
                            if (str3.equals("TextInput.setEditingState")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case -37561188:
                            if (str3.equals("TextInput.setClient")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 270476819:
                            if (str3.equals("TextInput.hide")) {
                                c5 = 3;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 270803918:
                            if (str3.equals("TextInput.show")) {
                                c5 = 4;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 649192816:
                            if (str3.equals("TextInput.sendAppPrivateCommand")) {
                                c5 = 5;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1204752139:
                            if (str3.equals("TextInput.setEditableSizeAndTransform")) {
                                c5 = 6;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1727570905:
                            if (str3.equals("TextInput.finishAutofillContext")) {
                                c5 = 7;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1904427655:
                            if (str3.equals("TextInput.clearClient")) {
                                c5 = '\b';
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 2113369584:
                            if (str3.equals("TextInput.requestAutofill")) {
                                c5 = '\t';
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    switch (c5) {
                        case 0:
                            try {
                                JSONObject jSONObject2 = (JSONObject) obj;
                                int i4 = jSONObject2.getInt("platformViewId");
                                boolean optBoolean = jSONObject2.optBoolean("usesVirtualDisplay", false);
                                io.flutter.plugin.editing.j jVar = (io.flutter.plugin.editing.j) ((R1.c) sVar2.f4391h).f1532g;
                                View view = jVar.f4287a;
                                if (optBoolean) {
                                    view.requestFocus();
                                    jVar.f4291e = new C0324l(3, i4);
                                    jVar.f4288b.restartInput(view);
                                    jVar.f4295i = false;
                                } else {
                                    jVar.f4291e = new C0324l(4, i4);
                                    jVar.f4296j = null;
                                }
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (JSONException e5) {
                                ((r2.i) interfaceC0643o).error("error", e5.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                ((R1.c) sVar2.f4391h).v(r2.o.a((JSONObject) obj));
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (JSONException e6) {
                                ((r2.i) interfaceC0643o).error("error", e6.getMessage(), null);
                                return;
                            }
                        case 2:
                            try {
                                JSONArray jSONArray = (JSONArray) obj;
                                ((R1.c) sVar2.f4391h).n(jSONArray.getInt(0), r2.m.a(jSONArray.getJSONObject(1)));
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e7) {
                                ((r2.i) interfaceC0643o).error("error", e7.getMessage(), null);
                                return;
                            }
                        case 3:
                            io.flutter.plugin.editing.j jVar2 = (io.flutter.plugin.editing.j) ((R1.c) sVar2.f4391h).f1532g;
                            if (jVar2.f4291e.f3914b == 4) {
                                jVar2.d();
                            } else {
                                View view2 = jVar2.f4287a;
                                jVar2.d();
                                jVar2.f4288b.hideSoftInputFromWindow(view2.getApplicationWindowToken(), 0);
                            }
                            ((r2.i) interfaceC0643o).success(null);
                            return;
                        case 4:
                            io.flutter.plugin.editing.j jVar3 = (io.flutter.plugin.editing.j) ((R1.c) sVar2.f4391h).f1532g;
                            InputMethodManager inputMethodManager = jVar3.f4288b;
                            View view3 = jVar3.f4287a;
                            r2.m mVar = jVar3.f4292f;
                            if (mVar != null && mVar.f6102g.f6108a == 11) {
                                jVar3.d();
                                inputMethodManager.hideSoftInputFromWindow(view3.getApplicationWindowToken(), 0);
                            } else {
                                view3.requestFocus();
                                inputMethodManager.showSoftInput(view3, 0);
                            }
                            ((r2.i) interfaceC0643o).success(null);
                            return;
                        case 5:
                            try {
                                JSONObject jSONObject3 = (JSONObject) obj;
                                String string2 = jSONObject3.getString("action");
                                String string3 = jSONObject3.getString("data");
                                if (string3 != null && !string3.isEmpty()) {
                                    bundle = new Bundle();
                                    bundle.putString("data", string3);
                                } else {
                                    bundle = null;
                                }
                                io.flutter.plugin.editing.j jVar4 = (io.flutter.plugin.editing.j) ((R1.c) sVar2.f4391h).f1532g;
                                jVar4.f4288b.sendAppPrivateCommand(jVar4.f4287a, string2, bundle);
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (JSONException e8) {
                                ((r2.i) interfaceC0643o).error("error", e8.getMessage(), null);
                                return;
                            }
                        case 6:
                            try {
                                JSONObject jSONObject4 = (JSONObject) obj;
                                double d4 = jSONObject4.getDouble("width");
                                double d5 = jSONObject4.getDouble("height");
                                JSONArray jSONArray2 = jSONObject4.getJSONArray("transform");
                                double[] dArr = new double[16];
                                for (int i5 = 0; i5 < 16; i5++) {
                                    dArr[i5] = jSONArray2.getDouble(i5);
                                }
                                ((R1.c) sVar2.f4391h).t(d4, d5, dArr);
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (JSONException e9) {
                                ((r2.i) interfaceC0643o).error("error", e9.getMessage(), null);
                                return;
                            }
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            R1.c cVar = (R1.c) sVar2.f4391h;
                            boolean booleanValue = ((Boolean) obj).booleanValue();
                            if (Build.VERSION.SDK_INT >= 26) {
                                AutofillManager autofillManager = ((io.flutter.plugin.editing.j) cVar.f1532g).f4289c;
                                if (autofillManager != null) {
                                    if (booleanValue) {
                                        autofillManager.commit();
                                    } else {
                                        autofillManager.cancel();
                                    }
                                }
                            } else {
                                cVar.getClass();
                            }
                            ((r2.i) interfaceC0643o).success(null);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            io.flutter.plugin.editing.j jVar5 = (io.flutter.plugin.editing.j) ((R1.c) sVar2.f4391h).f1532g;
                            View view4 = jVar5.f4287a;
                            if (jVar5.f4291e.f3914b != 3) {
                                jVar5.f4294h.e(jVar5);
                                jVar5.d();
                                jVar5.f4292f = null;
                                jVar5.e(null);
                                jVar5.f4291e = new C0324l(1, 0);
                                jVar5.f4298m = null;
                                WeakHashMap weakHashMap = T.f702a;
                                v0 a4 = L.a(view4);
                                if (a4 != null && !a4.f788a.s(8)) {
                                    jVar5.f4288b.restartInput(view4);
                                }
                            }
                            ((r2.i) interfaceC0643o).success(null);
                            return;
                        case '\t':
                            io.flutter.plugin.editing.j jVar6 = (io.flutter.plugin.editing.j) ((R1.c) sVar2.f4391h).f1532g;
                            View view5 = jVar6.f4287a;
                            if (Build.VERSION.SDK_INT >= 26 && jVar6.f4289c != null && jVar6.f4293g != null) {
                                String str4 = (String) jVar6.f4292f.f6105j.f1469f;
                                int[] iArr = new int[2];
                                view5.getLocationOnScreen(iArr);
                                Rect rect = new Rect(jVar6.f4298m);
                                rect.offset(iArr[0], iArr[1]);
                                jVar6.f4289c.notifyViewEntered(view5, str4.hashCode(), rect);
                            }
                            ((r2.i) interfaceC0643o).success(null);
                            return;
                        default:
                            ((r2.i) interfaceC0643o).notImplemented();
                            return;
                    }
                }
                return;
            case 11:
                j(c0641m, interfaceC0643o);
                return;
            case 12:
                io.flutter.plugin.platform.s sVar3 = (io.flutter.plugin.platform.s) this.f5322g;
                if (((io.flutter.plugin.platform.p) sVar3.f4391h) != null) {
                    String str5 = c0641m.f6155a;
                    Object obj2 = c0641m.f6156b;
                    str5.getClass();
                    switch (str5.hashCode()) {
                        case -1352294148:
                            if (str5.equals("create")) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -756050293:
                            if (str5.equals("clearFocus")) {
                                c4 = 1;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 110550847:
                            if (str5.equals("touch")) {
                                c4 = 2;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 576796989:
                            if (str5.equals("setDirection")) {
                                c4 = 3;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 751366695:
                            if (str5.equals("isSurfaceControlEnabled")) {
                                c4 = 4;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 1671767583:
                            if (str5.equals("dispose")) {
                                c4 = 5;
                                break;
                            }
                            c4 = 65535;
                            break;
                        default:
                            c4 = 65535;
                            break;
                    }
                    switch (c4) {
                        case 0:
                            Map map = (Map) obj2;
                            if (map.containsKey("params")) {
                                byteBuffer = ByteBuffer.wrap((byte[]) map.get("params"));
                            } else {
                                byteBuffer = null;
                            }
                            try {
                                ((io.flutter.plugin.platform.p) sVar3.f4391h).d(new r2.e(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), 0, byteBuffer));
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e10) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e10), null);
                                return;
                            }
                        case 1:
                            try {
                                ((io.flutter.plugin.platform.p) sVar3.f4391h).m(((Integer) obj2).intValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e11) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e11), null);
                                return;
                            }
                        case 2:
                            List list = (List) obj2;
                            try {
                                ((io.flutter.plugin.platform.p) sVar3.f4391h).a(new r2.f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e12) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e12), null);
                                return;
                            }
                        case 3:
                            Map map2 = (Map) obj2;
                            try {
                                ((io.flutter.plugin.platform.p) sVar3.f4391h).f(((Integer) map2.get("id")).intValue(), ((Integer) map2.get("direction")).intValue());
                                ((r2.i) interfaceC0643o).success(null);
                                return;
                            } catch (IllegalStateException e13) {
                                ((r2.i) interfaceC0643o).error("error", Log.getStackTraceString(e13), null);
                                return;
                            }
                        case 4:
                            FlutterJNI flutterJNI = ((io.flutter.plugin.platform.q) ((io.flutter.plugin.platform.p) sVar3.f4391h).f4350g).f4355j;
                            if (flutterJNI != null) {
                                z = flutterJNI.IsSurfaceControlEnabled();
                            }
                            ((r2.i) interfaceC0643o).success(Boolean.valueOf(z));
                            return;
                        case 5:
                            try {
                                ((io.flutter.plugin.platform.p) sVar3.f4391h).s(((Integer) ((Map) obj2).get("id")).intValue());
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
                C0541s c0541s = (C0541s) this.f5322g;
                String str6 = c0641m.f6155a;
                Object obj3 = c0641m.f6156b;
                str6.getClass();
                if (!str6.equals("get")) {
                    if (!str6.equals("put")) {
                        ((r2.i) interfaceC0643o).notImplemented();
                        return;
                    } else {
                        c0541s.f5697f = (byte[]) obj3;
                        ((r2.i) interfaceC0643o).success(null);
                        return;
                    }
                }
                c0541s.f5696e = true;
                if (!c0541s.f5695d && c0541s.f5694c) {
                    c0541s.f5693b = (r2.i) interfaceC0643o;
                    return;
                } else {
                    ((r2.i) interfaceC0643o).success(C0541s.d((byte[]) c0541s.f5697f));
                    return;
                }
        }
    }

    public /* synthetic */ p(A2.x xVar) {
        this.f5321f = 5;
        p pVar = new p(4, xVar);
        this.f5322g = C0621b.a(new O(6, C0621b.a(new A2.t(C0621b.a(new io.flutter.plugin.platform.s(2, pVar, C0621b.a(new C0604d(pVar, 1)), false)), C0621b.a(new C0604d(pVar, 0)), pVar, 22))));
    }

    public p(String str) {
        this.f5321f = 6;
        this.f5322g = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat(str);
    }

    public /* synthetic */ p() {
        this.f5321f = 3;
        this.f5322g = new CountDownLatch(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, s2.n] */
    public p(C0427b c0427b, int i4) {
        this.f5321f = i4;
        switch (i4) {
            case 10:
                new C0644p(c0427b, "flutter/mousecursor", C0651w.f6163a).b(new O(10, this));
                return;
            case 11:
            case 12:
            case 13:
            default:
                ?? obj = new Object();
                C0644p c0644p = new C0644p(c0427b, "flutter/backgesture", C0651w.f6163a);
                this.f5322g = c0644p;
                c0644p.b(obj);
                return;
            case 14:
                new C0644p(c0427b, "flutter/scribe", C0639k.f6154a).b(new O(14, this));
                return;
            case 15:
                new C0644p(c0427b, "flutter/sensitivecontent", C0651w.f6163a).b(new O(15, this));
                return;
            case 16:
                new C0644p(c0427b, "flutter/spellcheck", C0651w.f6163a).b(new O(16, this));
                return;
        }
    }

    public p(InterfaceC0634f interfaceC0634f) {
        this.f5321f = 8;
        this.f5322g = new P1.y(interfaceC0634f, "flutter/keyevent", C0638j.f6153a, null);
    }
}
