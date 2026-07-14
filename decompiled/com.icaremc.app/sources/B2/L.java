package B2;

import O.InterfaceC0080i;
import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class L {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Y2.c[] f175a;

    /* renamed from: b, reason: collision with root package name */
    public static final R.b f176b;

    static {
        T2.m mVar = new T2.m(T2.b.f1629f, L.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        T2.q.f1646a.getClass();
        f175a = new Y2.c[]{mVar};
        f176b = android.support.v4.media.session.a.s("FlutterSharedPreferences", null, null, 14);
    }

    public static final InterfaceC0080i a(Context context) {
        T2.h.e(context, "<this>");
        return f176b.a(context, f175a[0]);
    }

    public static final boolean b(String str, Object obj, Set set) {
        T2.h.e(str, "key");
        if (set == null) {
            if (!(obj instanceof Boolean) && !(obj instanceof Long) && !(obj instanceof String) && !(obj instanceof Double)) {
                return false;
            }
            return true;
        }
        return set.contains(str);
    }

    public static final Object c(Object obj, H1.f fVar) {
        if (obj instanceof String) {
            String str = (String) obj;
            T2.h.e(str, "<this>");
            if (str.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                if (str.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!")) {
                    return obj;
                }
                String substring = str.substring(40);
                T2.h.d(substring, "substring(...)");
                fVar.getClass();
                T2.h.e(substring, "listString");
                Object readObject = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(substring, 0))).readObject();
                T2.h.c(readObject, "null cannot be cast to non-null type kotlin.collections.List<*>");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (List) readObject) {
                    if (obj2 instanceof String) {
                        arrayList.add(obj2);
                    }
                }
                return arrayList;
            }
            if (str.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                String substring2 = str.substring(40);
                T2.h.d(substring2, "substring(...)");
                return Double.valueOf(Double.parseDouble(substring2));
            }
            return obj;
        }
        return obj;
    }
}
