package s2;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: s2.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0641m {

    /* renamed from: a, reason: collision with root package name */
    public final String f6155a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6156b;

    public C0641m(Object obj, String str) {
        this.f6155a = str;
        this.f6156b = obj;
    }

    public final Object a(String str) {
        Object obj = this.f6156b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }
}
