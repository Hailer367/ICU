package b0;

import android.os.Bundle;
import androidx.lifecycle.C0141k;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.h;
import o.C0283b;
import o.C0287f;

/* renamed from: b0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0163e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1974b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1975c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1976d;

    /* renamed from: e, reason: collision with root package name */
    public C0159a f1977e;

    /* renamed from: a, reason: collision with root package name */
    public final C0287f f1973a = new C0287f();

    /* renamed from: f, reason: collision with root package name */
    public boolean f1978f = true;

    public final Bundle a(String str) {
        if (this.f1976d) {
            Bundle bundle = this.f1975c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            Bundle bundle3 = this.f1975c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f1975c;
            if (bundle4 != null && !bundle4.isEmpty()) {
                return bundle2;
            }
            this.f1975c = null;
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public final InterfaceC0162d b() {
        String str;
        InterfaceC0162d interfaceC0162d;
        Iterator it = this.f1973a.iterator();
        do {
            C0283b c0283b = (C0283b) it;
            if (c0283b.hasNext()) {
                Map.Entry components = (Map.Entry) c0283b.next();
                h.d(components, "components");
                str = (String) components.getKey();
                interfaceC0162d = (InterfaceC0162d) components.getValue();
            } else {
                return null;
            }
        } while (!h.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return interfaceC0162d;
    }

    public final void c(String str, InterfaceC0162d provider) {
        h.e(provider, "provider");
        if (((InterfaceC0162d) this.f1973a.b(str, provider)) == null) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (this.f1978f) {
            C0159a c0159a = this.f1977e;
            if (c0159a == null) {
                c0159a = new C0159a(this);
            }
            this.f1977e = c0159a;
            try {
                C0141k.class.getDeclaredConstructor(null);
                C0159a c0159a2 = this.f1977e;
                if (c0159a2 != null) {
                    c0159a2.f1970a.add(C0141k.class.getName());
                    return;
                }
                return;
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class " + C0141k.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}
