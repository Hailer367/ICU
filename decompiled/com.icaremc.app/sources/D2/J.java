package D2;

import I.C0050d;
import I.InterfaceC0049c;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import f1.AbstractC0286a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import o.C0547v;
import org.json.JSONException;
import org.json.JSONObject;
import p1.AbstractC0579h;
import p1.InterfaceC0574c;
import p1.InterfaceC0576e;
import q1.AbstractC0602b;
import s2.InterfaceC0630b;
import s2.InterfaceC0631c;

/* loaded from: classes.dex */
public final /* synthetic */ class J implements InterfaceC0631c, InterfaceC0630b, E2.c, Q0.b, InterfaceC0574c, V1.p, InterfaceC0576e, x1.c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f293f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f294g;

    public /* synthetic */ J(int i4, Object obj) {
        this.f293f = i4;
        this.f294g = obj;
    }

    @Override // x1.c
    public Object a(I0.h hVar) {
        return this.f294g;
    }

    public G0.b b(A2.t tVar) {
        InputStream inputStream;
        G0.c cVar = (G0.c) this.f294g;
        URL url = (URL) tVar.f99g;
        String G3 = AbstractC0602b.G("CctTransportBackend");
        if (Log.isLoggable(G3, 4)) {
            Log.i(G3, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cVar.f569g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.9 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) tVar.f101i;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    A2.q qVar = cVar.f563a;
                    H0.i iVar = (H0.i) tVar.f100h;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    E1.d dVar = (E1.d) qVar.f93g;
                    E1.e eVar = new E1.e(bufferedWriter, dVar.f469a, dVar.f470b, dVar.f471c, dVar.f472d);
                    eVar.f(iVar);
                    eVar.h();
                    eVar.f474b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer valueOf = Integer.valueOf(responseCode);
                    String G4 = AbstractC0602b.G("CctTransportBackend");
                    if (Log.isLoggable(G4, 4)) {
                        Log.i(G4, String.format("Status Code: %d", valueOf));
                    }
                    AbstractC0602b.r("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    AbstractC0602b.r("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        if (responseCode != 200) {
                            return new G0.b(responseCode, null, 0L);
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            if ("gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"))) {
                                inputStream = new GZIPInputStream(inputStream2);
                            } else {
                                inputStream = inputStream2;
                            }
                            try {
                                G0.b bVar = new G0.b(responseCode, null, H0.m.a(new BufferedReader(new InputStreamReader(inputStream))).f635a);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                return bVar;
                            } finally {
                            }
                        } finally {
                        }
                    } else {
                        return new G0.b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                } finally {
                }
            } finally {
            }
        } catch (C1.b e4) {
            e = e4;
            AbstractC0602b.v("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new G0.b(400, null, 0L);
        } catch (ConnectException e5) {
            e = e5;
            AbstractC0602b.v("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new G0.b(500, null, 0L);
        } catch (UnknownHostException e6) {
            e = e6;
            AbstractC0602b.v("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new G0.b(500, null, 0L);
        } catch (IOException e7) {
            e = e7;
            AbstractC0602b.v("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new G0.b(400, null, 0L);
        }
    }

    @Override // E2.c
    public boolean c(View view) {
        for (Class cls : (Class[]) this.f294g) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [P1.y, java.lang.Object] */
    @Override // Q0.b
    public Object d() {
        SQLiteDatabase a4;
        int i4 = this.f293f;
        Object obj = this.f294g;
        switch (i4) {
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                P0.h hVar = (P0.h) ((P0.c) obj);
                hVar.getClass();
                int i5 = L0.a.f977e;
                ?? obj2 = new Object();
                obj2.f1470g = null;
                obj2.f1471h = new ArrayList();
                obj2.f1472i = null;
                obj2.f1469f = "";
                HashMap hashMap = new HashMap();
                a4 = hVar.a();
                a4.beginTransaction();
                try {
                    L0.a aVar = (L0.a) P0.h.h(a4.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new N0.a(hVar, hashMap, (Object) obj2, 3));
                    a4.setTransactionSuccessful();
                    return aVar;
                } finally {
                }
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                P0.h hVar2 = (P0.h) ((P0.d) obj);
                long a5 = hVar2.f1329g.a() - hVar2.f1331i.f1319d;
                a4 = hVar2.a();
                a4.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(a5)};
                    Cursor rawQuery = a4.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        try {
                            hVar2.e(rawQuery.getInt(0), L0.c.MESSAGE_TOO_OLD, rawQuery.getString(1));
                        } catch (Throwable th) {
                            rawQuery.close();
                            throw th;
                        }
                    }
                    rawQuery.close();
                    int delete = a4.delete("events", "timestamp_ms < ?", strArr);
                    a4.setTransactionSuccessful();
                    a4.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            case 9:
                P0.h hVar3 = (P0.h) ((O0.l) obj).f1305i;
                a4 = hVar3.a();
                a4.beginTransaction();
                try {
                    a4.compileStatement("DELETE FROM log_event_dropped").execute();
                    a4.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + hVar3.f1329g.a()).execute();
                    a4.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                O0.m mVar = (O0.m) obj;
                Iterator it = ((Iterable) ((P0.h) mVar.f1307b).c(new K(16))).iterator();
                while (it.hasNext()) {
                    mVar.f1308c.a((I0.j) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override // p1.InterfaceC0576e
    public void e(Object obj) {
        switch (this.f293f) {
            case 16:
                ((U) this.f294g).f(obj);
                return;
            default:
                ((U) this.f294g).f(obj);
                return;
        }
    }

    @Override // s2.InterfaceC0630b
    public void f(Object obj, io.flutter.plugin.platform.s sVar) {
        List C3;
        C0034m c0034m = (C0034m) this.f294g;
        T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Object obj2 = ((List) obj).get(0);
        T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
        try {
            ((C0024c) c0034m.f416a.f297g).a(((Long) obj2).longValue(), new d0(c0034m));
            C3 = android.support.v4.media.session.a.p(null);
        } catch (Throwable th) {
            if (th instanceof C0022a) {
                C0022a c0022a = th;
                C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
            } else {
                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
            }
        }
        sVar.t(C3);
    }

    @Override // V1.p
    public Object g() {
        int i4 = this.f293f;
        Object obj = this.f294g;
        switch (i4) {
            case 14:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e4) {
                    AbstractC0286a abstractC0286a = Y1.c.f2084a;
                    throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
                } catch (InstantiationException e5) {
                    throw new RuntimeException("Failed to invoke constructor '" + Y1.c.b(constructor) + "' with no args", e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException("Failed to invoke constructor '" + Y1.c.b(constructor) + "' with no args", e6.getCause());
                }
            default:
                Class cls = (Class) obj;
                try {
                    return V1.u.f1770a.a(cls);
                } catch (Exception e7) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e7);
                }
        }
    }

    public boolean h(A2.q qVar, int i4, Bundle bundle) {
        InterfaceC0049c interfaceC0049c;
        C0547v c0547v = (C0547v) this.f294g;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 25 && (i4 & 1) != 0) {
            try {
                ((K.h) qVar.f93g).m();
                Parcelable parcelable = (Parcelable) ((K.h) qVar.f93g).g();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e4) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e4);
                return false;
            }
        }
        K.h hVar = (K.h) qVar.f93g;
        ClipData clipData = new ClipData(hVar.getDescription(), new ClipData.Item(hVar.j()));
        if (i5 >= 31) {
            interfaceC0049c = new R1.c(clipData, 2);
        } else {
            C0050d c0050d = new C0050d();
            c0050d.f725g = clipData;
            c0050d.f726h = 2;
            interfaceC0049c = c0050d;
        }
        interfaceC0049c.c(hVar.p());
        interfaceC0049c.setExtras(bundle);
        if (I.T.g(c0547v, interfaceC0049c.build()) != null) {
            return false;
        }
        return true;
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        int i4 = this.f293f;
        Object obj = this.f294g;
        switch (i4) {
            case 11:
                P1.J.b((Intent) obj);
                return;
            case 12:
                ((P1.L) obj).f1382b.d(null);
                return;
            case 13:
                ((ScheduledFuture) obj).cancel(false);
                return;
            case 22:
                x2.i iVar = (x2.i) obj;
                HashMap hashMap = x2.d.f6504h;
                if (abstractC0579h.f()) {
                    switch (iVar.f6528a) {
                        case 0:
                            ArrayList arrayList = iVar.f6529b;
                            arrayList.add(0, null);
                            iVar.f6530c.t(arrayList);
                            return;
                        case 1:
                            ArrayList arrayList2 = iVar.f6529b;
                            arrayList2.add(0, null);
                            iVar.f6530c.t(arrayList2);
                            return;
                        default:
                            ArrayList arrayList3 = iVar.f6529b;
                            arrayList3.add(0, null);
                            iVar.f6530c.t(arrayList3);
                            return;
                    }
                }
                iVar.a(abstractC0579h.c());
                return;
            default:
                x2.i iVar2 = (x2.i) obj;
                HashMap hashMap2 = x2.d.f6504h;
                if (abstractC0579h.f()) {
                    Object d4 = abstractC0579h.d();
                    switch (iVar2.f6528a) {
                        case 3:
                            ArrayList arrayList4 = iVar2.f6529b;
                            arrayList4.add(0, (x2.g) d4);
                            iVar2.f6530c.t(arrayList4);
                            return;
                        case 4:
                            ArrayList arrayList5 = iVar2.f6529b;
                            arrayList5.add(0, (List) d4);
                            iVar2.f6530c.t(arrayList5);
                            return;
                        default:
                            ArrayList arrayList6 = iVar2.f6529b;
                            arrayList6.add(0, (x2.f) d4);
                            iVar2.f6530c.t(arrayList6);
                            return;
                    }
                }
                iVar2.a(abstractC0579h.c());
                return;
        }
    }

    @Override // s2.InterfaceC0631c
    public void t(Object obj) {
        switch (this.f293f) {
            case 0:
                Object obj2 = ((C0027f) this.f294g).f386g;
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (list.size() > 1) {
                        Object obj3 = list.get(0);
                        T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        Object obj4 = list.get(1);
                        T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj3, (String) obj4, (String) list.get(2)), "WebViewClient", obj2);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_newInstance'.", "", "WebViewClient", obj2);
                return;
            case 1:
            default:
                J j4 = (J) this.f294g;
                boolean z = false;
                if (obj != null) {
                    try {
                        z = ((JSONObject) obj).getBoolean("handled");
                    } catch (JSONException e4) {
                        Log.e("KeyEventChannel", "Unable to unpack JSON message: " + e4);
                    }
                }
                ((Z0.D) j4.f294g).b(z);
                return;
            case 2:
                Object obj5 = ((C0027f) this.f294g).f386g;
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    if (list2.size() > 1) {
                        Object obj6 = list2.get(0);
                        T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                        Object obj7 = list2.get(1);
                        T2.h.c(obj7, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj6, (String) obj7, (String) list2.get(2)), "WebViewPoint", obj5);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewPoint.pigeon_newInstance'.", "", "WebViewPoint", obj5);
                return;
            case 3:
                Object obj8 = ((C0027f) this.f294g).f386g;
                if (obj instanceof List) {
                    List list3 = (List) obj;
                    if (list3.size() > 1) {
                        Object obj9 = list3.get(0);
                        T2.h.c(obj9, "null cannot be cast to non-null type kotlin.String");
                        Object obj10 = list3.get(1);
                        T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj9, (String) obj10, (String) list3.get(2)), "X509Certificate", obj8);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.X509Certificate.pigeon_newInstance'.", "", "X509Certificate", obj8);
                return;
        }
    }
}
