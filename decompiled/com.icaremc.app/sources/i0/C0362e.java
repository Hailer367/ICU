package i0;

import T2.h;
import android.os.Bundle;
import androidx.lifecycle.C0203j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import q.C0588b;
import q.C0589c;
import q.C0592f;

/* renamed from: i0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0362e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f4095b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f4096c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4097d;

    /* renamed from: e, reason: collision with root package name */
    public C0358a f4098e;

    /* renamed from: a, reason: collision with root package name */
    public final C0592f f4094a = new C0592f();

    /* renamed from: f, reason: collision with root package name */
    public boolean f4099f = true;

    public final Bundle a(String str) {
        if (this.f4097d) {
            Bundle bundle = this.f4096c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            Bundle bundle3 = this.f4096c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f4096c;
            if (bundle4 != null && !bundle4.isEmpty()) {
                return bundle2;
            }
            this.f4096c = null;
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public final InterfaceC0361d b() {
        String str;
        InterfaceC0361d interfaceC0361d;
        Iterator it = this.f4094a.iterator();
        do {
            C0588b c0588b = (C0588b) it;
            if (c0588b.hasNext()) {
                Map.Entry entry = (Map.Entry) c0588b.next();
                h.d(entry, "components");
                str = (String) entry.getKey();
                interfaceC0361d = (InterfaceC0361d) entry.getValue();
            } else {
                return null;
            }
        } while (!h.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return interfaceC0361d;
    }

    public final void c(String str, InterfaceC0361d interfaceC0361d) {
        Object obj;
        h.e(interfaceC0361d, "provider");
        C0592f c0592f = this.f4094a;
        C0589c a4 = c0592f.a(str);
        if (a4 != null) {
            obj = a4.f5843g;
        } else {
            C0589c c0589c = new C0589c(str, interfaceC0361d);
            c0592f.f5852i++;
            C0589c c0589c2 = c0592f.f5850g;
            if (c0589c2 == null) {
                c0592f.f5849f = c0589c;
                c0592f.f5850g = c0589c;
            } else {
                c0589c2.f5844h = c0589c;
                c0589c.f5845i = c0589c2;
                c0592f.f5850g = c0589c;
            }
            obj = null;
        }
        if (((InterfaceC0361d) obj) == null) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (this.f4099f) {
            C0358a c0358a = this.f4098e;
            if (c0358a == null) {
                c0358a = new C0358a(this);
            }
            this.f4098e = c0358a;
            try {
                C0203j.class.getDeclaredConstructor(null);
                C0358a c0358a2 = this.f4098e;
                if (c0358a2 != null) {
                    ((LinkedHashSet) c0358a2.f4091b).add(C0203j.class.getName());
                    return;
                }
                return;
            } catch (NoSuchMethodException e4) {
                throw new IllegalArgumentException("Class " + C0203j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}
