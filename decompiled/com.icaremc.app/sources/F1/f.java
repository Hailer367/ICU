package F1;

import A2.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f implements C1.e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f534f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final C1.c f535g = new C1.c("key", i.l(i.k(e.class, new a(1))));

    /* renamed from: h, reason: collision with root package name */
    public static final C1.c f536h = new C1.c("value", i.l(i.k(e.class, new a(2))));

    /* renamed from: i, reason: collision with root package name */
    public static final E1.a f537i = new E1.a(1);

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f538a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f539b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f540c;

    /* renamed from: d, reason: collision with root package name */
    public final C1.d f541d;

    /* renamed from: e, reason: collision with root package name */
    public final h f542e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, HashMap hashMap, HashMap hashMap2, C1.d dVar) {
        this.f538a = byteArrayOutputStream;
        this.f539b = hashMap;
        this.f540c = hashMap2;
        this.f541d = dVar;
    }

    public static int g(C1.c cVar) {
        e eVar = (e) ((Annotation) cVar.f256b.get(e.class));
        if (eVar != null) {
            return ((a) eVar).f530a;
        }
        throw new RuntimeException("Field has no @Protobuf config");
    }

    @Override // C1.e
    public final C1.e a(C1.c cVar, int i4) {
        d(cVar, i4, true);
        return this;
    }

    @Override // C1.e
    public final C1.e b(C1.c cVar, long j4) {
        if (j4 == 0) {
            return this;
        }
        e eVar = (e) ((Annotation) cVar.f256b.get(e.class));
        if (eVar != null) {
            h(((a) eVar).f530a << 3);
            i(j4);
            return this;
        }
        throw new RuntimeException("Field has no @Protobuf config");
    }

    @Override // C1.e
    public final C1.e c(C1.c cVar, Object obj) {
        e(cVar, obj, true);
        return this;
    }

    public final void d(C1.c cVar, int i4, boolean z) {
        if (z && i4 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f256b.get(e.class));
        if (eVar != null) {
            h(((a) eVar).f530a << 3);
            h(i4);
            return;
        }
        throw new RuntimeException("Field has no @Protobuf config");
    }

    public final void e(C1.c cVar, Object obj, boolean z) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z || charSequence.length() != 0) {
                    h((g(cVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f534f);
                    h(bytes.length);
                    this.f538a.write(bytes);
                    return;
                }
                return;
            }
            if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(cVar, it.next(), false);
                }
                return;
            }
            if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    f(f537i, cVar, (Map.Entry) it2.next(), false);
                }
                return;
            }
            if (obj instanceof Double) {
                double doubleValue = ((Double) obj).doubleValue();
                if (!z || doubleValue != 0.0d) {
                    h((g(cVar) << 3) | 1);
                    this.f538a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
                    return;
                }
                return;
            }
            if (obj instanceof Float) {
                float floatValue = ((Float) obj).floatValue();
                if (!z || floatValue != 0.0f) {
                    h((g(cVar) << 3) | 5);
                    this.f538a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
                    return;
                }
                return;
            }
            if (obj instanceof Number) {
                long longValue = ((Number) obj).longValue();
                if (!z || longValue != 0) {
                    e eVar = (e) ((Annotation) cVar.f256b.get(e.class));
                    if (eVar != null) {
                        h(((a) eVar).f530a << 3);
                        i(longValue);
                        return;
                    }
                    throw new RuntimeException("Field has no @Protobuf config");
                }
                return;
            }
            if (obj instanceof Boolean) {
                d(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z);
                return;
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z && bArr.length == 0) {
                    return;
                }
                h((g(cVar) << 3) | 2);
                h(bArr.length);
                this.f538a.write(bArr);
                return;
            }
            C1.d dVar = (C1.d) this.f539b.get(obj.getClass());
            if (dVar != null) {
                f(dVar, cVar, obj, z);
                return;
            }
            C1.f fVar = (C1.f) this.f540c.get(obj.getClass());
            if (fVar != null) {
                h hVar = this.f542e;
                hVar.f544a = false;
                hVar.f546c = cVar;
                hVar.f545b = z;
                fVar.a(obj, hVar);
                return;
            }
            if (obj instanceof c) {
                d(cVar, ((c) obj).a(), true);
            } else if (obj instanceof Enum) {
                d(cVar, ((Enum) obj).ordinal(), true);
            } else {
                f(this.f541d, cVar, obj, z);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, F1.b] */
    public final void f(C1.d dVar, C1.c cVar, Object obj, boolean z) {
        ?? outputStream = new OutputStream();
        outputStream.f531f = 0L;
        try {
            OutputStream outputStream2 = this.f538a;
            this.f538a = outputStream;
            try {
                dVar.a(obj, this);
                this.f538a = outputStream2;
                long j4 = outputStream.f531f;
                outputStream.close();
                if (z && j4 == 0) {
                    return;
                }
                h((g(cVar) << 3) | 2);
                i(j4);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f538a = outputStream2;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                outputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void h(int i4) {
        while ((i4 & (-128)) != 0) {
            this.f538a.write((i4 & 127) | 128);
            i4 >>>= 7;
        }
        this.f538a.write(i4 & 127);
    }

    public final void i(long j4) {
        while (((-128) & j4) != 0) {
            this.f538a.write((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        this.f538a.write(((int) j4) & 127);
    }
}
