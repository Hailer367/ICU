package j1;

import a.AbstractC0141a;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: h, reason: collision with root package name */
    public final transient int f5044h;

    /* renamed from: i, reason: collision with root package name */
    public final transient int f5045i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f5046j;

    public d(e eVar, int i4, int i5) {
        this.f5046j = eVar;
        this.f5044h = i4;
        this.f5045i = i5;
    }

    @Override // j1.AbstractC0425a
    public final Object[] a() {
        return this.f5046j.a();
    }

    @Override // j1.AbstractC0425a
    public final int b() {
        return this.f5046j.b() + this.f5044h;
    }

    @Override // j1.AbstractC0425a
    public final int c() {
        return this.f5046j.b() + this.f5044h + this.f5045i;
    }

    @Override // j1.e, java.util.List
    /* renamed from: f */
    public final e subList(int i4, int i5) {
        AbstractC0141a.T(i4, i5, this.f5045i);
        int i6 = this.f5044h;
        return this.f5046j.subList(i4 + i6, i5 + i6);
    }

    @Override // java.util.List
    public final Object get(int i4) {
        AbstractC0141a.R(i4, this.f5045i);
        return this.f5046j.get(i4 + this.f5044h);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5045i;
    }
}
