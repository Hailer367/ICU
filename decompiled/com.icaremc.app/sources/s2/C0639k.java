package s2;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import q1.AbstractC0602b;

/* renamed from: s2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0639k implements InterfaceC0645q {

    /* renamed from: a, reason: collision with root package name */
    public static final C0639k f6154a = new Object();

    @Override // s2.InterfaceC0645q
    public ByteBuffer a(Object obj) {
        JSONArray put = new JSONArray().put(AbstractC0602b.Y(obj));
        if (put == null) {
            return null;
        }
        Object Y3 = AbstractC0602b.Y(put);
        if (Y3 instanceof String) {
            x xVar = x.f6165b;
            String quote = JSONObject.quote((String) Y3);
            xVar.getClass();
            return x.d(quote);
        }
        x xVar2 = x.f6165b;
        String obj2 = Y3.toString();
        xVar2.getClass();
        return x.d(obj2);
    }

    @Override // s2.InterfaceC0645q
    public ByteBuffer b(String str, String str2) {
        JSONArray put = new JSONArray().put("error").put(AbstractC0602b.Y(str)).put(JSONObject.NULL).put(AbstractC0602b.Y(str2));
        if (put == null) {
            return null;
        }
        Object Y3 = AbstractC0602b.Y(put);
        if (Y3 instanceof String) {
            x xVar = x.f6165b;
            String quote = JSONObject.quote((String) Y3);
            xVar.getClass();
            return x.d(quote);
        }
        x xVar2 = x.f6165b;
        String obj = Y3.toString();
        xVar2.getClass();
        return x.d(obj);
    }

    @Override // s2.InterfaceC0645q
    public ByteBuffer c(String str, String str2, Object obj) {
        JSONArray put = new JSONArray().put(str).put(AbstractC0602b.Y(str2)).put(AbstractC0602b.Y(obj));
        if (put == null) {
            return null;
        }
        Object Y3 = AbstractC0602b.Y(put);
        if (Y3 instanceof String) {
            x xVar = x.f6165b;
            String quote = JSONObject.quote((String) Y3);
            xVar.getClass();
            return x.d(quote);
        }
        x xVar2 = x.f6165b;
        String obj2 = Y3.toString();
        xVar2.getClass();
        return x.d(obj2);
    }

    @Override // s2.InterfaceC0645q
    public C0641m d(ByteBuffer byteBuffer) {
        Object nextValue;
        Object obj = null;
        try {
            if (byteBuffer == null) {
                nextValue = null;
            } else {
                try {
                    x.f6165b.getClass();
                    JSONTokener jSONTokener = new JSONTokener(x.c(byteBuffer));
                    nextValue = jSONTokener.nextValue();
                    if (jSONTokener.more()) {
                        throw new IllegalArgumentException("Invalid JSON");
                    }
                } catch (JSONException e4) {
                    throw new IllegalArgumentException("Invalid JSON", e4);
                }
            }
            if (nextValue instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) nextValue;
                Object obj2 = jSONObject.get("method");
                Object opt = jSONObject.opt("args");
                if (opt != JSONObject.NULL) {
                    obj = opt;
                }
                if (obj2 instanceof String) {
                    return new C0641m(obj, (String) obj2);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + nextValue);
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }

    @Override // s2.InterfaceC0645q
    public Object e(ByteBuffer byteBuffer) {
        try {
            try {
                x.f6165b.getClass();
                JSONTokener jSONTokener = new JSONTokener(x.c(byteBuffer));
                Object nextValue = jSONTokener.nextValue();
                if (!jSONTokener.more()) {
                    if (nextValue instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) nextValue;
                        Object obj = null;
                        if (jSONArray.length() == 1) {
                            Object opt = jSONArray.opt(0);
                            if (opt == JSONObject.NULL) {
                                return null;
                            }
                            return opt;
                        }
                        if (jSONArray.length() == 3) {
                            Object obj2 = jSONArray.get(0);
                            Object opt2 = jSONArray.opt(1);
                            Object obj3 = JSONObject.NULL;
                            if (opt2 == obj3) {
                                opt2 = null;
                            }
                            Object opt3 = jSONArray.opt(2);
                            if (opt3 != obj3) {
                                obj = opt3;
                            }
                            if ((obj2 instanceof String) && (opt2 == null || (opt2 instanceof String))) {
                                throw new C0637i((String) obj2, (String) opt2, obj);
                            }
                        }
                    }
                    throw new IllegalArgumentException("Invalid envelope: " + nextValue);
                }
                throw new IllegalArgumentException("Invalid JSON");
            } catch (JSONException e4) {
                throw new IllegalArgumentException("Invalid JSON", e4);
            }
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Invalid JSON", e5);
        }
    }

    @Override // s2.InterfaceC0645q
    public ByteBuffer f(C0641m c0641m) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", c0641m.f6155a);
            jSONObject.put("args", AbstractC0602b.Y(c0641m.f6156b));
            Object Y3 = AbstractC0602b.Y(jSONObject);
            if (Y3 instanceof String) {
                x xVar = x.f6165b;
                String quote = JSONObject.quote((String) Y3);
                xVar.getClass();
                return x.d(quote);
            }
            x xVar2 = x.f6165b;
            String obj = Y3.toString();
            xVar2.getClass();
            return x.d(obj);
        } catch (JSONException e4) {
            throw new IllegalArgumentException("Invalid JSON", e4);
        }
    }
}
