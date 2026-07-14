package T1;

import b2.C0223a;
import java.io.IOException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: f, reason: collision with root package name */
    public static final m f1623f;

    /* renamed from: g, reason: collision with root package name */
    public static final n f1624g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ q[] f1625h;

    static {
        m mVar = new m();
        f1623f = mVar;
        n nVar = new n();
        f1624g = nVar;
        f1625h = new q[]{mVar, nVar, new q() { // from class: T1.o
            public static Double b(String str, C0223a c0223a) {
                try {
                    Double valueOf = Double.valueOf(str);
                    if (!valueOf.isInfinite()) {
                        if (valueOf.isNaN()) {
                        }
                        return valueOf;
                    }
                    boolean z = true;
                    if (c0223a.f3222t != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new IOException("JSON forbids NaN and infinities: " + valueOf + "; at path " + c0223a.j());
                    }
                    return valueOf;
                } catch (NumberFormatException e4) {
                    throw new RuntimeException("Cannot parse " + str + "; at path " + c0223a.j(), e4);
                }
            }

            @Override // T1.q
            public final Number a(C0223a c0223a) {
                String v3 = c0223a.v();
                if (v3.indexOf(46) >= 0) {
                    return b(v3, c0223a);
                }
                try {
                    return Long.valueOf(Long.parseLong(v3));
                } catch (NumberFormatException unused) {
                    return b(v3, c0223a);
                }
            }
        }, new q() { // from class: T1.p
            @Override // T1.q
            public final Number a(C0223a c0223a) {
                String v3 = c0223a.v();
                try {
                    return V1.d.j(v3);
                } catch (NumberFormatException e4) {
                    throw new RuntimeException("Cannot parse " + v3 + "; at path " + c0223a.j(), e4);
                }
            }
        }};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f1625h.clone();
    }

    public abstract Number a(C0223a c0223a);
}
