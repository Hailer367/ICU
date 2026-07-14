package m;

import I.Z;
import j2.C0427b;
import java.util.ArrayList;
import o.x1;

/* loaded from: classes.dex */
public final class k extends android.support.v4.media.session.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5184a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5185b;

    /* renamed from: c, reason: collision with root package name */
    public int f5186c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5187d;

    public k(C0427b c0427b) {
        this.f5184a = 0;
        this.f5187d = c0427b;
        this.f5185b = false;
        this.f5186c = 0;
    }

    @Override // I.Z
    public final void a() {
        switch (this.f5184a) {
            case 0:
                int i4 = this.f5186c + 1;
                this.f5186c = i4;
                C0427b c0427b = (C0427b) this.f5187d;
                if (i4 == ((ArrayList) c0427b.f5058h).size()) {
                    Z z = (Z) c0427b.f5060j;
                    if (z != null) {
                        z.a();
                    }
                    this.f5186c = 0;
                    this.f5185b = false;
                    c0427b.f5057g = false;
                    return;
                }
                return;
            default:
                if (!this.f5185b) {
                    ((x1) this.f5187d).f5734a.setVisibility(this.f5186c);
                    return;
                }
                return;
        }
    }

    @Override // android.support.v4.media.session.a, I.Z
    public void b() {
        switch (this.f5184a) {
            case 1:
                this.f5185b = true;
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.media.session.a, I.Z
    public final void c() {
        switch (this.f5184a) {
            case 0:
                if (!this.f5185b) {
                    this.f5185b = true;
                    Z z = (Z) ((C0427b) this.f5187d).f5060j;
                    if (z != null) {
                        z.c();
                        return;
                    }
                    return;
                }
                return;
            default:
                ((x1) this.f5187d).f5734a.setVisibility(0);
                return;
        }
    }

    public k(x1 x1Var, int i4) {
        this.f5184a = 1;
        this.f5187d = x1Var;
        this.f5186c = i4;
        this.f5185b = false;
    }
}
