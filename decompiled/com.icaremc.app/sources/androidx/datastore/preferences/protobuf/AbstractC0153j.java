package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0153j {

    /* renamed from: a, reason: collision with root package name */
    public int f2655a;

    /* renamed from: b, reason: collision with root package name */
    public C0154k f2656b;

    public abstract void a(int i4);

    public abstract int b();

    public abstract boolean c();

    public abstract void d(int i4);

    public abstract int e(int i4);

    public abstract boolean f();

    public abstract C0150g g();

    public abstract double h();

    public abstract int i();

    public abstract int j();

    public abstract long k();

    public abstract float l();

    public abstract int m();

    public abstract long n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    public abstract String s();

    public abstract String t();

    public abstract int u();

    public abstract int v();

    public abstract long w();

    public abstract boolean x(int i4);

    public final void y() {
        int u3;
        do {
            u3 = u();
            if (u3 != 0) {
                int i4 = this.f2655a;
                if (i4 < 100) {
                    this.f2655a = i4 + 1;
                    this.f2655a--;
                } else {
                    throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                }
            } else {
                return;
            }
        } while (x(u3));
    }
}
