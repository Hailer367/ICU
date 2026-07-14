package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.inject.Provider;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2006c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2007d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2008e;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f2006c = i2;
        this.f2008e = obj;
        this.f2007d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2006c) {
            case 0:
                ((OptionalProvider) this.f2008e).set((Provider) this.f2007d);
                return;
            case 1:
                ((LazySet) this.f2008e).add((Provider) this.f2007d);
                return;
            default:
                EventBus.lambda$publish$0((Map.Entry) this.f2008e, (Event) this.f2007d);
                return;
        }
    }
}
