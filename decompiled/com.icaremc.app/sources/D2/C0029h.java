package D2;

import android.util.Log;

/* renamed from: D2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0029h implements S2.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f395f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f396g;

    public /* synthetic */ C0029h(long j4, int i4) {
        this.f395f = i4;
        this.f396g = j4;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        switch (this.f395f) {
            case 0:
                if (((H2.f) obj).f676f instanceof H2.e) {
                    Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + this.f396g);
                }
                return H2.i.f681a;
            default:
                ((S.b) obj).e(H1.j.f667b, Long.valueOf(this.f396g));
                return null;
        }
    }
}
