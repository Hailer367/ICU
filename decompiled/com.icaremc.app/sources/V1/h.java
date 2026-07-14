package V1;

import a2.C0143a;
import f1.AbstractC0286a;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements T1.t, Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final h f1736h = new h();

    /* renamed from: f, reason: collision with root package name */
    public final List f1737f;

    /* renamed from: g, reason: collision with root package name */
    public final List f1738g;

    public h() {
        List list = Collections.EMPTY_LIST;
        this.f1737f = list;
        this.f1738g = list;
    }

    public final boolean a(Class cls, boolean z) {
        List list;
        if (!z && !Enum.class.isAssignableFrom(cls)) {
            AbstractC0286a abstractC0286a = Y1.c.f2084a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        if (z) {
            list = this.f1737f;
        } else {
            list = this.f1738g;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    public final Object clone() {
        try {
            return (h) super.clone();
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        Class cls = c0143a.f2216a;
        boolean a4 = a(cls, true);
        boolean a5 = a(cls, false);
        if (!a4 && !a5) {
            return null;
        }
        return new g(this, a5, a4, eVar, c0143a);
    }
}
