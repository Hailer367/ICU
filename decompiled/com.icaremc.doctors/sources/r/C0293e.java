package r;

import androidx.datastore.preferences.protobuf.b0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: r.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0293e extends j implements Map {

    /* renamed from: f, reason: collision with root package name */
    public b0 f3559f;

    /* renamed from: g, reason: collision with root package name */
    public C0290b f3560g;

    /* renamed from: h, reason: collision with root package name */
    public C0292d f3561h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0293e(j jVar) {
        super(0);
        int i2 = jVar.f3573e;
        b(this.f3573e + i2);
        if (this.f3573e == 0) {
            if (i2 > 0) {
                R0.i.X(0, 0, i2, jVar.f3571c, this.f3571c);
                R0.i.Y(jVar.f3572d, this.f3572d, 0, 0, i2 << 1);
                this.f3573e = i2;
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            put(jVar.f(i3), jVar.i(i3));
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        b0 b0Var = this.f3559f;
        if (b0Var == null) {
            b0 b0Var2 = new b0(1, this);
            this.f3559f = b0Var2;
            return b0Var2;
        }
        return b0Var;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i2 = this.f3573e;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        if (i2 != this.f3573e) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final Set keySet() {
        C0290b c0290b = this.f3560g;
        if (c0290b == null) {
            C0290b c0290b2 = new C0290b(this);
            this.f3560g = c0290b2;
            return c0290b2;
        }
        return c0290b;
    }

    public final boolean l(Collection collection) {
        int i2 = this.f3573e;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (!collection.contains(f(i3))) {
                g(i3);
            }
        }
        if (i2 != this.f3573e) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f3573e);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        C0292d c0292d = this.f3561h;
        if (c0292d == null) {
            C0292d c0292d2 = new C0292d(this);
            this.f3561h = c0292d2;
            return c0292d2;
        }
        return c0292d;
    }
}
