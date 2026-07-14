package E1;

import C1.f;
import C1.g;
import android.util.Base64;
import android.util.JsonWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements C1.e, g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f473a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f474b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f475c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f476d;

    /* renamed from: e, reason: collision with root package name */
    public final C1.d f477e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f478f;

    public e(BufferedWriter bufferedWriter, HashMap hashMap, HashMap hashMap2, a aVar, boolean z) {
        this.f474b = new JsonWriter(bufferedWriter);
        this.f475c = hashMap;
        this.f476d = hashMap2;
        this.f477e = aVar;
        this.f478f = z;
    }

    @Override // C1.e
    public final C1.e a(C1.c cVar, int i4) {
        String str = cVar.f255a;
        h();
        JsonWriter jsonWriter = this.f474b;
        jsonWriter.name(str);
        h();
        jsonWriter.value(i4);
        return this;
    }

    @Override // C1.e
    public final C1.e b(C1.c cVar, long j4) {
        String str = cVar.f255a;
        h();
        JsonWriter jsonWriter = this.f474b;
        jsonWriter.name(str);
        h();
        jsonWriter.value(j4);
        return this;
    }

    @Override // C1.e
    public final C1.e c(C1.c cVar, Object obj) {
        g(obj, cVar.f255a);
        return this;
    }

    @Override // C1.g
    public final g d(String str) {
        h();
        this.f474b.value(str);
        return this;
    }

    @Override // C1.g
    public final g e(boolean z) {
        h();
        this.f474b.value(z);
        return this;
    }

    public final e f(Object obj) {
        JsonWriter jsonWriter = this.f474b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                h();
                jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
                return this;
            }
            jsonWriter.beginArray();
            int i4 = 0;
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i4 < length) {
                    jsonWriter.value(r6[i4]);
                    i4++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i4 < length2) {
                    long j4 = jArr[i4];
                    h();
                    jsonWriter.value(j4);
                    i4++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i4 < length3) {
                    jsonWriter.value(dArr[i4]);
                    i4++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i4 < length4) {
                    jsonWriter.value(zArr[i4]);
                    i4++;
                }
            } else if (obj instanceof Number[]) {
                Number[] numberArr = (Number[]) obj;
                int length5 = numberArr.length;
                while (i4 < length5) {
                    f(numberArr[i4]);
                    i4++;
                }
            } else {
                Object[] objArr = (Object[]) obj;
                int length6 = objArr.length;
                while (i4 < length6) {
                    f(objArr[i4]);
                    i4++;
                }
            }
            jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            jsonWriter.beginArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Map) {
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    g(entry.getValue(), (String) key);
                } catch (ClassCastException e4) {
                    throw new RuntimeException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e4);
                }
            }
            jsonWriter.endObject();
            return this;
        }
        C1.d dVar = (C1.d) this.f475c.get(obj.getClass());
        if (dVar != null) {
            jsonWriter.beginObject();
            dVar.a(obj, this);
            jsonWriter.endObject();
            return this;
        }
        f fVar = (f) this.f476d.get(obj.getClass());
        if (fVar != null) {
            fVar.a(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            String name = ((Enum) obj).name();
            h();
            jsonWriter.value(name);
            return this;
        }
        jsonWriter.beginObject();
        this.f477e.a(obj, this);
        jsonWriter.endObject();
        return this;
    }

    public final e g(Object obj, String str) {
        boolean z = this.f478f;
        JsonWriter jsonWriter = this.f474b;
        if (z) {
            if (obj == null) {
                return this;
            }
            h();
            jsonWriter.name(str);
            f(obj);
            return this;
        }
        h();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        f(obj);
        return this;
    }

    public final void h() {
        if (this.f473a) {
        } else {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
