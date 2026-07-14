package B0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.BuildConfig;
import com.google.firebase.messaging.ServiceStarter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import io.flutter.util.ViewUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import t0.C0304b;
import t0.C0305c;
import y0.C0345a;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements D0.b, OnSuccessListener, OnFailureListener, ViewUtils.ViewVisitor, ObjectConstructor, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f98b;

    public /* synthetic */ h(int i2, Object obj) {
        this.f97a = i2;
        this.f98b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, B0.q] */
    @Override // D0.b
    public Object a() {
        SQLiteDatabase a2;
        int i2 = this.f97a;
        int i3 = 0;
        Object obj = this.f98b;
        switch (i2) {
            case 0:
                C0.j jVar = (C0.j) ((C0.c) obj);
                jVar.getClass();
                int i4 = C0345a.f3984e;
                ?? obj2 = new Object();
                obj2.f130c = null;
                obj2.f131d = new ArrayList();
                obj2.f132e = null;
                obj2.f133f = BuildConfig.FLAVOR;
                HashMap hashMap = new HashMap();
                a2 = jVar.a();
                a2.beginTransaction();
                try {
                    C0345a c0345a = (C0345a) C0.j.h(a2.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new A0.b(jVar, hashMap, (Object) obj2, 3));
                    a2.setTransactionSuccessful();
                    return c0345a;
                } finally {
                }
            case 1:
                C0.j jVar2 = (C0.j) ((C0.d) obj);
                long j2 = jVar2.f156d.j() - jVar2.f158f.f142d;
                a2 = jVar2.a();
                a2.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(j2)};
                    Cursor rawQuery = a2.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        try {
                            jVar2.e(rawQuery.getInt(0), y0.c.MESSAGE_TOO_OLD, rawQuery.getString(1));
                        } catch (Throwable th) {
                            rawQuery.close();
                            throw th;
                        }
                    }
                    rawQuery.close();
                    int delete = a2.delete("events", "timestamp_ms < ?", strArr);
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            case 2:
                C0.j jVar3 = (C0.j) ((n) obj).f123i;
                a2 = jVar3.a();
                a2.beginTransaction();
                try {
                    a2.compileStatement("DELETE FROM log_event_dropped").execute();
                    a2.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + jVar3.f156d.j()).execute();
                    a2.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                p pVar = (p) obj;
                Iterator it = ((Iterable) ((C0.j) pVar.f127b).c(new C0.f(i3))).iterator();
                while (it.hasNext()) {
                    pVar.f128c.a((v0.j) it.next(), 1, false);
                }
                return null;
        }
    }

    public C0304b b(A0.g gVar) {
        InputStream inputStream;
        C0305c c0305c = (C0305c) this.f98b;
        URL url = (URL) gVar.f30d;
        String p = android.support.v4.media.session.a.p("CctTransportBackend");
        if (Log.isLoggable(p, 4)) {
            Log.i(p, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(c0305c.f3653g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.9 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) gVar.f32f;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    c0305c.f3647a.encode((u0.j) gVar.f31e, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer valueOf = Integer.valueOf(responseCode);
                    String p2 = android.support.v4.media.session.a.p("CctTransportBackend");
                    if (Log.isLoggable(p2, 4)) {
                        Log.i(p2, String.format("Status Code: %d", valueOf));
                    }
                    android.support.v4.media.session.a.j("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    android.support.v4.media.session.a.j("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        if (responseCode != 200) {
                            return new C0304b(responseCode, null, 0L);
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            if ("gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"))) {
                                inputStream = new GZIPInputStream(inputStream2);
                            } else {
                                inputStream = inputStream2;
                            }
                            try {
                                C0304b c0304b = new C0304b(responseCode, null, u0.n.a(new BufferedReader(new InputStreamReader(inputStream))).f3873a);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                return c0304b;
                            } finally {
                            }
                        } catch (Throwable th) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                    return new C0304b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e2) {
            e = e2;
            android.support.v4.media.session.a.k("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new C0304b(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            android.support.v4.media.session.a.k("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new C0304b(ServiceStarter.ERROR_UNKNOWN, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            android.support.v4.media.session.a.k("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new C0304b(ServiceStarter.ERROR_UNKNOWN, null, 0L);
        } catch (IOException e5) {
            e = e5;
            android.support.v4.media.session.a.k("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new C0304b(400, null, 0L);
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Object lambda$newUnsafeAllocator$18;
        Object lambda$newDefaultConstructor$8;
        switch (this.f97a) {
            case 8:
                lambda$newUnsafeAllocator$18 = ConstructorConstructor.lambda$newUnsafeAllocator$18((Class) this.f98b);
                return lambda$newUnsafeAllocator$18;
            default:
                lambda$newDefaultConstructor$8 = ConstructorConstructor.lambda$newDefaultConstructor$8((Constructor) this.f98b);
                return lambda$newDefaultConstructor$8;
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f97a) {
            case 11:
                FlutterFirebaseCorePlugin.lambda$listenToVoidResponse$2((GeneratedAndroidFirebaseCore.VoidResult) this.f98b, task);
                return;
            default:
                FlutterFirebaseCorePlugin.lambda$listenToResponse$1((GeneratedAndroidFirebaseCore.Result) this.f98b, task);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception it) {
        MethodChannel.Result result = (MethodChannel.Result) this.f98b;
        kotlin.jvm.internal.h.e(it, "it");
        result.error("TASK_FAILURE", it.getMessage(), null);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f97a) {
            case 4:
                ((K0.e) this.f98b).invoke(obj);
                return;
            default:
                ((K0.e) this.f98b).invoke(obj);
                return;
        }
    }

    @Override // io.flutter.util.ViewUtils.ViewVisitor
    public boolean run(View view) {
        return ViewUtils.b((Class[]) this.f98b, view);
    }
}
