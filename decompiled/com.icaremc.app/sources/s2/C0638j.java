package s2;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import q1.AbstractC0602b;

/* renamed from: s2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0638j implements InterfaceC0640l {

    /* renamed from: a, reason: collision with root package name */
    public static final C0638j f6153a = new Object();

    @Override // s2.InterfaceC0640l
    public final ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object Y3 = AbstractC0602b.Y(obj);
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

    @Override // s2.InterfaceC0640l
    public final Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            x.f6165b.getClass();
            JSONTokener jSONTokener = new JSONTokener(x.c(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (!jSONTokener.more()) {
                return nextValue;
            }
            throw new IllegalArgumentException("Invalid JSON");
        } catch (JSONException e4) {
            throw new IllegalArgumentException("Invalid JSON", e4);
        }
    }
}
