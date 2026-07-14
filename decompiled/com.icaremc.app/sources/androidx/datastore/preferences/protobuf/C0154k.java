package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0154k {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0153j f2664a;

    /* renamed from: b, reason: collision with root package name */
    public int f2665b;

    /* renamed from: c, reason: collision with root package name */
    public int f2666c;

    /* renamed from: d, reason: collision with root package name */
    public int f2667d = 0;

    public C0154k(AbstractC0153j abstractC0153j) {
        Charset charset = AbstractC0167y.f2709a;
        this.f2664a = abstractC0153j;
        abstractC0153j.f2656b = this;
    }

    public final int a() {
        int i4 = this.f2667d;
        if (i4 != 0) {
            this.f2665b = i4;
            this.f2667d = 0;
        } else {
            this.f2665b = this.f2664a.u();
        }
        int i5 = this.f2665b;
        if (i5 != 0 && i5 != this.f2666c) {
            return i5 >>> 3;
        }
        return Integer.MAX_VALUE;
    }

    public final void b(Object obj, W w2, C0158o c0158o) {
        int i4 = this.f2666c;
        this.f2666c = ((this.f2665b >>> 3) << 3) | 4;
        try {
            w2.g(obj, this, c0158o);
            if (this.f2665b == this.f2666c) {
            } else {
                throw new IOException("Failed to parse the message.");
            }
        } finally {
            this.f2666c = i4;
        }
    }

    public final void c(Object obj, W w2, C0158o c0158o) {
        AbstractC0153j abstractC0153j = this.f2664a;
        int v3 = abstractC0153j.v();
        if (abstractC0153j.f2655a < 100) {
            int e4 = abstractC0153j.e(v3);
            abstractC0153j.f2655a++;
            w2.g(obj, this, c0158o);
            abstractC0153j.a(0);
            abstractC0153j.f2655a--;
            abstractC0153j.d(e4);
            return;
        }
        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public final void d(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Boolean.valueOf(abstractC0153j.f()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Boolean.valueOf(abstractC0153j.f()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final C0150g e() {
        w(2);
        return this.f2664a.g();
    }

    public final void f(InterfaceC0166x interfaceC0166x) {
        int u3;
        if ((this.f2665b & 7) != 2) {
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(e());
            AbstractC0153j abstractC0153j = this.f2664a;
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void g(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 1) {
            if (i4 == 2) {
                int v3 = abstractC0153j.v();
                if ((v3 & 7) == 0) {
                    int b4 = abstractC0153j.b() + v3;
                    do {
                        ((U) interfaceC0166x).add(Double.valueOf(abstractC0153j.h()));
                    } while (abstractC0153j.b() < b4);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Double.valueOf(abstractC0153j.h()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void h(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.i()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.i()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final Object i(r0 r0Var, Class cls, C0158o c0158o) {
        int ordinal = r0Var.ordinal();
        AbstractC0153j abstractC0153j = this.f2664a;
        switch (ordinal) {
            case 0:
                w(1);
                return Double.valueOf(abstractC0153j.h());
            case 1:
                w(5);
                return Float.valueOf(abstractC0153j.l());
            case 2:
                w(0);
                return Long.valueOf(abstractC0153j.n());
            case 3:
                w(0);
                return Long.valueOf(abstractC0153j.w());
            case 4:
                w(0);
                return Integer.valueOf(abstractC0153j.m());
            case 5:
                w(1);
                return Long.valueOf(abstractC0153j.k());
            case 6:
                w(5);
                return Integer.valueOf(abstractC0153j.j());
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                w(0);
                return Boolean.valueOf(abstractC0153j.f());
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                w(2);
                return abstractC0153j.t();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                w(2);
                W a4 = T.f2593c.a(cls);
                AbstractC0165w i4 = a4.i();
                c(i4, a4, c0158o);
                a4.d(i4);
                return i4;
            case 11:
                return e();
            case 12:
                w(0);
                return Integer.valueOf(abstractC0153j.v());
            case 13:
                w(0);
                return Integer.valueOf(abstractC0153j.i());
            case 14:
                w(5);
                return Integer.valueOf(abstractC0153j.o());
            case 15:
                w(1);
                return Long.valueOf(abstractC0153j.p());
            case 16:
                w(0);
                return Integer.valueOf(abstractC0153j.q());
            case 17:
                w(0);
                return Long.valueOf(abstractC0153j.r());
        }
    }

    public final void j(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 2) {
            if (i4 != 5) {
                throw A.b();
            }
            do {
                ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.j()));
                if (!abstractC0153j.c()) {
                    u3 = abstractC0153j.u();
                } else {
                    return;
                }
            } while (u3 == this.f2665b);
            this.f2667d = u3;
            return;
        }
        int v3 = abstractC0153j.v();
        if ((v3 & 3) == 0) {
            int b4 = abstractC0153j.b() + v3;
            do {
                ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.j()));
            } while (abstractC0153j.b() < b4);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void k(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 1) {
            if (i4 == 2) {
                int v3 = abstractC0153j.v();
                if ((v3 & 7) == 0) {
                    int b4 = abstractC0153j.b() + v3;
                    do {
                        ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.k()));
                    } while (abstractC0153j.b() < b4);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.k()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void l(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 2) {
            if (i4 != 5) {
                throw A.b();
            }
            do {
                ((U) interfaceC0166x).add(Float.valueOf(abstractC0153j.l()));
                if (!abstractC0153j.c()) {
                    u3 = abstractC0153j.u();
                } else {
                    return;
                }
            } while (u3 == this.f2665b);
            this.f2667d = u3;
            return;
        }
        int v3 = abstractC0153j.v();
        if ((v3 & 3) == 0) {
            int b4 = abstractC0153j.b() + v3;
            do {
                ((U) interfaceC0166x).add(Float.valueOf(abstractC0153j.l()));
            } while (abstractC0153j.b() < b4);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void m(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.m()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.m()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void n(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.n()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.n()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void o(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 2) {
            if (i4 != 5) {
                throw A.b();
            }
            do {
                ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.o()));
                if (!abstractC0153j.c()) {
                    u3 = abstractC0153j.u();
                } else {
                    return;
                }
            } while (u3 == this.f2665b);
            this.f2667d = u3;
            return;
        }
        int v3 = abstractC0153j.v();
        if ((v3 & 3) == 0) {
            int b4 = abstractC0153j.b() + v3;
            do {
                ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.o()));
            } while (abstractC0153j.b() < b4);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void p(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 1) {
            if (i4 == 2) {
                int v3 = abstractC0153j.v();
                if ((v3 & 7) == 0) {
                    int b4 = abstractC0153j.b() + v3;
                    do {
                        ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.p()));
                    } while (abstractC0153j.b() < b4);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.p()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void q(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.q()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.q()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void r(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.r()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.r()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void s(InterfaceC0166x interfaceC0166x, boolean z) {
        String s3;
        int u3;
        if ((this.f2665b & 7) != 2) {
            throw A.b();
        }
        do {
            AbstractC0153j abstractC0153j = this.f2664a;
            if (z) {
                w(2);
                s3 = abstractC0153j.t();
            } else {
                w(2);
                s3 = abstractC0153j.s();
            }
            ((U) interfaceC0166x).add(s3);
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void t(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.v()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Integer.valueOf(abstractC0153j.v()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void u(InterfaceC0166x interfaceC0166x) {
        int u3;
        int i4 = this.f2665b & 7;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (i4 != 0) {
            if (i4 == 2) {
                int b4 = abstractC0153j.b() + abstractC0153j.v();
                do {
                    ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.w()));
                } while (abstractC0153j.b() < b4);
                v(b4);
                return;
            }
            throw A.b();
        }
        do {
            ((U) interfaceC0166x).add(Long.valueOf(abstractC0153j.w()));
            if (abstractC0153j.c()) {
                return;
            } else {
                u3 = abstractC0153j.u();
            }
        } while (u3 == this.f2665b);
        this.f2667d = u3;
    }

    public final void v(int i4) {
        if (this.f2664a.b() == i4) {
        } else {
            throw A.e();
        }
    }

    public final void w(int i4) {
        if ((this.f2665b & 7) == i4) {
        } else {
            throw A.b();
        }
    }

    public final boolean x() {
        int i4;
        AbstractC0153j abstractC0153j = this.f2664a;
        if (!abstractC0153j.c() && (i4 = this.f2665b) != this.f2666c) {
            return abstractC0153j.x(i4);
        }
        return false;
    }
}
