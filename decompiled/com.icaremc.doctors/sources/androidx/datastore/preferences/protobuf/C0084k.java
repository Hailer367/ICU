package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0084k {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0083j f1447a;

    /* renamed from: b, reason: collision with root package name */
    public int f1448b;

    /* renamed from: c, reason: collision with root package name */
    public int f1449c;

    /* renamed from: d, reason: collision with root package name */
    public int f1450d = 0;

    public C0084k(AbstractC0083j abstractC0083j) {
        Charset charset = AbstractC0097y.f1494a;
        this.f1447a = abstractC0083j;
        abstractC0083j.f1439b = this;
    }

    public final int a() {
        int i2 = this.f1450d;
        if (i2 != 0) {
            this.f1448b = i2;
            this.f1450d = 0;
        } else {
            this.f1448b = this.f1447a.u();
        }
        int i3 = this.f1448b;
        if (i3 != 0 && i3 != this.f1449c) {
            return i3 >>> 3;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void b(Object obj, W w2, C0088o c0088o) {
        int i2 = this.f1449c;
        this.f1449c = ((this.f1448b >>> 3) << 3) | 4;
        try {
            w2.g(obj, this, c0088o);
            if (this.f1448b == this.f1449c) {
            } else {
                throw new IOException("Failed to parse the message.");
            }
        } finally {
            this.f1449c = i2;
        }
    }

    public final void c(Object obj, W w2, C0088o c0088o) {
        AbstractC0083j abstractC0083j = this.f1447a;
        int v2 = abstractC0083j.v();
        if (abstractC0083j.f1438a < 100) {
            int e2 = abstractC0083j.e(v2);
            abstractC0083j.f1438a++;
            w2.g(obj, this, c0088o);
            abstractC0083j.a(0);
            abstractC0083j.f1438a--;
            abstractC0083j.d(e2);
            return;
        }
        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public final void d(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Boolean.valueOf(abstractC0083j.f()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Boolean.valueOf(abstractC0083j.f()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final C0080g e() {
        w(2);
        return this.f1447a.g();
    }

    public final void f(InterfaceC0096x interfaceC0096x) {
        int u2;
        if ((this.f1448b & 7) != 2) {
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(e());
            AbstractC0083j abstractC0083j = this.f1447a;
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void g(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 1) {
            if (i2 == 2) {
                int v2 = abstractC0083j.v();
                if ((v2 & 7) == 0) {
                    int b2 = abstractC0083j.b() + v2;
                    do {
                        ((U) interfaceC0096x).add(Double.valueOf(abstractC0083j.h()));
                    } while (abstractC0083j.b() < b2);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Double.valueOf(abstractC0083j.h()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void h(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.i()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.i()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final Object i(r0 r0Var, Class cls, C0088o c0088o) {
        int ordinal = r0Var.ordinal();
        AbstractC0083j abstractC0083j = this.f1447a;
        switch (ordinal) {
            case 0:
                w(1);
                return Double.valueOf(abstractC0083j.h());
            case 1:
                w(5);
                return Float.valueOf(abstractC0083j.l());
            case 2:
                w(0);
                return Long.valueOf(abstractC0083j.n());
            case 3:
                w(0);
                return Long.valueOf(abstractC0083j.w());
            case 4:
                w(0);
                return Integer.valueOf(abstractC0083j.m());
            case 5:
                w(1);
                return Long.valueOf(abstractC0083j.k());
            case 6:
                w(5);
                return Integer.valueOf(abstractC0083j.j());
            case 7:
                w(0);
                return Boolean.valueOf(abstractC0083j.f());
            case 8:
                w(2);
                return abstractC0083j.t();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                w(2);
                W a2 = T.f1374c.a(cls);
                AbstractC0095w i2 = a2.i();
                c(i2, a2, c0088o);
                a2.d(i2);
                return i2;
            case 11:
                return e();
            case 12:
                w(0);
                return Integer.valueOf(abstractC0083j.v());
            case 13:
                w(0);
                return Integer.valueOf(abstractC0083j.i());
            case 14:
                w(5);
                return Integer.valueOf(abstractC0083j.o());
            case 15:
                w(1);
                return Long.valueOf(abstractC0083j.p());
            case 16:
                w(0);
                return Integer.valueOf(abstractC0083j.q());
            case 17:
                w(0);
                return Long.valueOf(abstractC0083j.r());
        }
    }

    public final void j(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 2) {
            if (i2 != 5) {
                throw A.b();
            }
            do {
                ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.j()));
                if (!abstractC0083j.c()) {
                    u2 = abstractC0083j.u();
                } else {
                    return;
                }
            } while (u2 == this.f1448b);
            this.f1450d = u2;
            return;
        }
        int v2 = abstractC0083j.v();
        if ((v2 & 3) == 0) {
            int b2 = abstractC0083j.b() + v2;
            do {
                ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.j()));
            } while (abstractC0083j.b() < b2);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void k(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 1) {
            if (i2 == 2) {
                int v2 = abstractC0083j.v();
                if ((v2 & 7) == 0) {
                    int b2 = abstractC0083j.b() + v2;
                    do {
                        ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.k()));
                    } while (abstractC0083j.b() < b2);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.k()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void l(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 2) {
            if (i2 != 5) {
                throw A.b();
            }
            do {
                ((U) interfaceC0096x).add(Float.valueOf(abstractC0083j.l()));
                if (!abstractC0083j.c()) {
                    u2 = abstractC0083j.u();
                } else {
                    return;
                }
            } while (u2 == this.f1448b);
            this.f1450d = u2;
            return;
        }
        int v2 = abstractC0083j.v();
        if ((v2 & 3) == 0) {
            int b2 = abstractC0083j.b() + v2;
            do {
                ((U) interfaceC0096x).add(Float.valueOf(abstractC0083j.l()));
            } while (abstractC0083j.b() < b2);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void m(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.m()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.m()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void n(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.n()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.n()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void o(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 2) {
            if (i2 != 5) {
                throw A.b();
            }
            do {
                ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.o()));
                if (!abstractC0083j.c()) {
                    u2 = abstractC0083j.u();
                } else {
                    return;
                }
            } while (u2 == this.f1448b);
            this.f1450d = u2;
            return;
        }
        int v2 = abstractC0083j.v();
        if ((v2 & 3) == 0) {
            int b2 = abstractC0083j.b() + v2;
            do {
                ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.o()));
            } while (abstractC0083j.b() < b2);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void p(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 1) {
            if (i2 == 2) {
                int v2 = abstractC0083j.v();
                if ((v2 & 7) == 0) {
                    int b2 = abstractC0083j.b() + v2;
                    do {
                        ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.p()));
                    } while (abstractC0083j.b() < b2);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.p()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void q(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.q()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.q()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void r(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.r()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.r()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void s(InterfaceC0096x interfaceC0096x, boolean z) {
        String s2;
        int u2;
        if ((this.f1448b & 7) != 2) {
            throw A.b();
        }
        do {
            AbstractC0083j abstractC0083j = this.f1447a;
            if (z) {
                w(2);
                s2 = abstractC0083j.t();
            } else {
                w(2);
                s2 = abstractC0083j.s();
            }
            ((U) interfaceC0096x).add(s2);
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void t(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.v()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Integer.valueOf(abstractC0083j.v()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void u(InterfaceC0096x interfaceC0096x) {
        int u2;
        int i2 = this.f1448b & 7;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (i2 != 0) {
            if (i2 == 2) {
                int b2 = abstractC0083j.b() + abstractC0083j.v();
                do {
                    ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.w()));
                } while (abstractC0083j.b() < b2);
                v(b2);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0096x).add(Long.valueOf(abstractC0083j.w()));
            if (abstractC0083j.c()) {
                return;
            } else {
                u2 = abstractC0083j.u();
            }
        } while (u2 == this.f1448b);
        this.f1450d = u2;
    }

    public final void v(int i2) {
        if (this.f1447a.b() == i2) {
        } else {
            throw A.e();
        }
    }

    public final void w(int i2) {
        if ((this.f1448b & 7) == i2) {
        } else {
            throw A.b();
        }
    }

    public final boolean x() {
        int i2;
        AbstractC0083j abstractC0083j = this.f1447a;
        if (!abstractC0083j.c() && (i2 = this.f1448b) != this.f1449c) {
            return abstractC0083j.x(i2);
        }
        return false;
    }
}
