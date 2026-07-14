package com.google.android.play.core.ktx;

import Q0.j;
import c1.l;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import n1.q;
import n1.r;

/* loaded from: classes.dex */
public final class AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2 extends i implements l {
    final /* synthetic */ r $$this$callbackFlow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2(r rVar) {
        super(1);
        this.$$this$callbackFlow = rVar;
    }

    @Override // c1.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppUpdatePassthroughListener) obj);
        return j.f722a;
    }

    public final void invoke(AppUpdatePassthroughListener $receiver) {
        h.e($receiver, "$this$$receiver");
        ((q) this.$$this$callbackFlow).T(null);
    }
}
