package com.google.gson.internal;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements ObjectConstructor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2109a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2110b;

    public /* synthetic */ c(String str, int i2) {
        this.f2109a = i2;
        this.f2110b = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f2109a) {
            case 0:
                return ConstructorConstructor.q(this.f2110b);
            case 1:
                return ConstructorConstructor.d(this.f2110b);
            case 2:
                return ConstructorConstructor.j(this.f2110b);
            case 3:
                return ConstructorConstructor.n(this.f2110b);
            default:
                return ConstructorConstructor.p(this.f2110b);
        }
    }
}
