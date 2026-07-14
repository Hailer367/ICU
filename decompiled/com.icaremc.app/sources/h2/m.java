package h2;

import v0.C0687j;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements H.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4009a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4010b;

    public /* synthetic */ m(int i4, Object obj) {
        this.f4009a = i4;
        this.f4010b = obj;
    }

    @Override // H.a
    public final void accept(Object obj) {
        switch (this.f4009a) {
            case 0:
                ((p) this.f4010b).setWindowInfoListenerDisplayFeatures((C0687j) obj);
                return;
            default:
                ((d3.q) ((d3.r) this.f4010b)).i((C0687j) obj);
                return;
        }
    }
}
