package com.google.firebase.components;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1998a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1999b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f1998a = i2;
        this.f1999b = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        Object lambda$of$2;
        Object lambda$intoSet$4;
        Object lambda$intoSet$3;
        Object lambda$of$0;
        Object lambda$of$1;
        switch (this.f1998a) {
            case 0:
                lambda$of$2 = Component.lambda$of$2(this.f1999b, componentContainer);
                return lambda$of$2;
            case 1:
                lambda$intoSet$4 = Component.lambda$intoSet$4(this.f1999b, componentContainer);
                return lambda$intoSet$4;
            case 2:
                lambda$intoSet$3 = Component.lambda$intoSet$3(this.f1999b, componentContainer);
                return lambda$intoSet$3;
            case 3:
                lambda$of$0 = Component.lambda$of$0(this.f1999b, componentContainer);
                return lambda$of$0;
            default:
                lambda$of$1 = Component.lambda$of$1(this.f1999b, componentContainer);
                return lambda$of$1;
        }
    }
}
