package j2;

import A2.t;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import j.O;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import l0.AbstractC0433a;
import s2.C0639k;
import s2.InterfaceC0632d;
import s2.InterfaceC0633e;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class i implements InterfaceC0634f, j {

    /* renamed from: f, reason: collision with root package name */
    public final FlutterJNI f5077f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f5078g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f5079h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f5080i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f5081j;
    public final HashMap k;

    /* renamed from: l, reason: collision with root package name */
    public int f5082l;

    /* renamed from: m, reason: collision with root package name */
    public final k f5083m;

    /* renamed from: n, reason: collision with root package name */
    public final WeakHashMap f5084n;

    /* renamed from: o, reason: collision with root package name */
    public final O f5085o;

    public i(FlutterJNI flutterJNI) {
        O o3 = new O(1);
        o3.f4911g = (ExecutorService) t.O().f101i;
        this.f5078g = new HashMap();
        this.f5079h = new HashMap();
        this.f5080i = new Object();
        this.f5081j = new AtomicBoolean(false);
        this.k = new HashMap();
        this.f5082l = 1;
        this.f5083m = new k();
        this.f5084n = new WeakHashMap();
        this.f5077f = flutterJNI;
        this.f5085o = o3;
    }

    @Override // s2.InterfaceC0634f
    public final void a(String str, InterfaceC0632d interfaceC0632d) {
        n(str, interfaceC0632d, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [j2.c] */
    public final void b(final String str, final f fVar, final ByteBuffer byteBuffer, final int i4, final long j4) {
        e eVar;
        if (fVar != null) {
            eVar = fVar.f5070b;
        } else {
            eVar = null;
        }
        String a4 = E2.a.a("PlatformChannel ScheduleHandler on " + str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0433a.a(i4, k3.b.B(a4));
        } else {
            String B3 = k3.b.B(a4);
            try {
                if (k3.b.k == null) {
                    k3.b.k = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                k3.b.k.invoke(null, Long.valueOf(k3.b.f5117i), B3, Integer.valueOf(i4));
            } catch (Exception e4) {
                k3.b.p("asyncTraceBegin", e4);
            }
        }
        ?? r02 = new Runnable() { // from class: j2.c
            @Override // java.lang.Runnable
            public final void run() {
                long j5 = j4;
                FlutterJNI flutterJNI = i.this.f5077f;
                StringBuilder sb = new StringBuilder("PlatformChannel ScheduleHandler on ");
                String str2 = str;
                sb.append(str2);
                String a5 = E2.a.a(sb.toString());
                int i5 = Build.VERSION.SDK_INT;
                int i6 = i4;
                if (i5 >= 29) {
                    AbstractC0433a.b(i6, k3.b.B(a5));
                } else {
                    String B4 = k3.b.B(a5);
                    try {
                        if (k3.b.f5119l == null) {
                            k3.b.f5119l = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                        }
                        k3.b.f5119l.invoke(null, Long.valueOf(k3.b.f5117i), B4, Integer.valueOf(i6));
                    } catch (Exception e5) {
                        k3.b.p("asyncTraceEnd", e5);
                    }
                }
                try {
                    E2.a.b("DartMessenger#handleMessageFromDart on " + str2);
                    f fVar2 = fVar;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    try {
                        if (fVar2 != null) {
                            try {
                                try {
                                    fVar2.f5069a.h(byteBuffer2, new g(flutterJNI, i6));
                                } catch (Exception e6) {
                                    Log.e("DartMessenger", "Uncaught exception in binary message listener", e6);
                                    flutterJNI.invokePlatformMessageEmptyResponseCallback(i6);
                                }
                            } catch (Error e7) {
                                Thread currentThread = Thread.currentThread();
                                if (currentThread.getUncaughtExceptionHandler() != null) {
                                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e7);
                                } else {
                                    throw e7;
                                }
                            }
                        } else {
                            flutterJNI.invokePlatformMessageEmptyResponseCallback(i6);
                        }
                        if (byteBuffer2 != null && byteBuffer2.isDirect()) {
                            byteBuffer2.limit(0);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                    flutterJNI.cleanupMessageData(j5);
                }
            }
        };
        e eVar2 = eVar;
        if (eVar == null) {
            eVar2 = this.f5083m;
        }
        eVar2.a(r02);
    }

    @Override // s2.InterfaceC0634f
    public final void e(String str, ByteBuffer byteBuffer, InterfaceC0633e interfaceC0633e) {
        E2.a.b("DartMessenger#send on " + str);
        try {
            int i4 = this.f5082l;
            this.f5082l = i4 + 1;
            if (interfaceC0633e != null) {
                this.k.put(Integer.valueOf(i4), interfaceC0633e);
            }
            FlutterJNI flutterJNI = this.f5077f;
            if (byteBuffer == null) {
                flutterJNI.dispatchEmptyPlatformMessage(str, i4);
            } else {
                flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i4);
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, W0.g] */
    @Override // s2.InterfaceC0634f
    public final W0.g h(C0639k c0639k) {
        O o3 = this.f5085o;
        o3.getClass();
        h hVar = new h((ExecutorService) o3.f4911g);
        ?? obj = new Object();
        this.f5084n.put(obj, hVar);
        return obj;
    }

    @Override // s2.InterfaceC0634f
    public final void j(String str, ByteBuffer byteBuffer) {
        e(str, byteBuffer, null);
    }

    @Override // s2.InterfaceC0634f
    public final void n(String str, InterfaceC0632d interfaceC0632d, W0.g gVar) {
        e eVar;
        if (interfaceC0632d == null) {
            synchronized (this.f5080i) {
                this.f5078g.remove(str);
            }
            return;
        }
        if (gVar != null) {
            eVar = (e) this.f5084n.get(gVar);
            if (eVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            eVar = null;
        }
        synchronized (this.f5080i) {
            try {
                this.f5078g.put(str, new f(interfaceC0632d, eVar));
                List<d> list = (List) this.f5079h.remove(str);
                if (list == null) {
                    return;
                }
                for (d dVar : list) {
                    b(str, (f) this.f5078g.get(str), dVar.f5066a, dVar.f5067b, dVar.f5068c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
