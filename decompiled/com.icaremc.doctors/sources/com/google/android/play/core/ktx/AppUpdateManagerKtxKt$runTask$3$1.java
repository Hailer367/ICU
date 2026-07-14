package com.google.android.play.core.ktx;

import Q0.j;
import c1.a;
import c1.l;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class AppUpdateManagerKtxKt$runTask$3$1 extends i implements l {
    final /* synthetic */ a $onCanceled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUpdateManagerKtxKt$runTask$3$1(a aVar) {
        super(1);
        this.$onCanceled = aVar;
    }

    @Override // c1.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return j.f722a;
    }

    public final void invoke(Throwable th) {
        this.$onCanceled.invoke();
    }
}
