package g;

import D2.M;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.r;
import h.AbstractC0296a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3753a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3754b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3755c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3756d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f3757e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f3758f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f3759g = new Bundle();

    public final boolean a(int i4, int i5, Intent intent) {
        InterfaceC0290b interfaceC0290b;
        String str = (String) this.f3753a.get(Integer.valueOf(i4));
        if (str == null) {
            return false;
        }
        e eVar = (e) this.f3757e.get(str);
        if (eVar != null) {
            interfaceC0290b = eVar.f3746a;
        } else {
            interfaceC0290b = null;
        }
        if (interfaceC0290b != null) {
            ArrayList arrayList = this.f3756d;
            if (arrayList.contains(str)) {
                eVar.f3746a.c(eVar.f3747b.c(intent, i5));
                arrayList.remove(str);
                return true;
            }
        }
        this.f3758f.remove(str);
        this.f3759g.putParcelable(str, new C0289a(intent, i5));
        return true;
    }

    public abstract void b(int i4, AbstractC0296a abstractC0296a, Object obj);

    public final h c(String str, AbstractC0296a abstractC0296a, InterfaceC0290b interfaceC0290b) {
        T2.h.e(str, "key");
        d(str);
        this.f3757e.put(str, new e(abstractC0296a, interfaceC0290b));
        LinkedHashMap linkedHashMap = this.f3758f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            interfaceC0290b.c(obj);
        }
        Bundle bundle = this.f3759g;
        C0289a c0289a = (C0289a) k3.b.j(bundle, str, C0289a.class);
        if (c0289a != null) {
            bundle.remove(str);
            interfaceC0290b.c(abstractC0296a.c(c0289a.f3741g, c0289a.f3740f));
        }
        return new h(this, str, abstractC0296a);
    }

    public final void d(String str) {
        LinkedHashMap linkedHashMap = this.f3754b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        A2.f fVar = new A2.f(4);
        Iterator it = new Z2.a(new Z2.c(fVar, new M(2, fVar))).iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            Integer valueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.f3753a;
            if (!linkedHashMap2.containsKey(valueOf)) {
                int intValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(intValue), str);
                linkedHashMap.put(str, Integer.valueOf(intValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void e(String str) {
        Integer num;
        T2.h.e(str, "key");
        if (!this.f3756d.contains(str) && (num = (Integer) this.f3754b.remove(str)) != null) {
            this.f3753a.remove(num);
        }
        this.f3757e.remove(str);
        LinkedHashMap linkedHashMap = this.f3758f;
        if (linkedHashMap.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + linkedHashMap.get(str));
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.f3759g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((C0289a) k3.b.j(bundle, str, C0289a.class)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.f3755c;
        f fVar = (f) linkedHashMap2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f3749b;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                fVar.f3748a.b((r) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
