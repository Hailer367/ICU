package F1;

/* loaded from: classes.dex */
public final class h implements C1.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f544a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f545b = false;

    /* renamed from: c, reason: collision with root package name */
    public C1.c f546c;

    /* renamed from: d, reason: collision with root package name */
    public final f f547d;

    public h(f fVar) {
        this.f547d = fVar;
    }

    @Override // C1.g
    public final C1.g d(String str) {
        if (!this.f544a) {
            this.f544a = true;
            this.f547d.e(this.f546c, str, this.f545b);
            return this;
        }
        throw new RuntimeException("Cannot encode a second value in the ValueEncoderContext");
    }

    @Override // C1.g
    public final C1.g e(boolean z) {
        if (!this.f544a) {
            this.f544a = true;
            this.f547d.d(this.f546c, z ? 1 : 0, this.f545b);
            return this;
        }
        throw new RuntimeException("Cannot encode a second value in the ValueEncoderContext");
    }
}
