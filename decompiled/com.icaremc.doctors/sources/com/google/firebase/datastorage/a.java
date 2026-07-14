package com.google.firebase.datastorage;

import K.C0027b;
import android.content.Context;
import c1.l;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2042c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JavaDataStorage f2043d;

    public /* synthetic */ a(JavaDataStorage javaDataStorage, int i2) {
        this.f2042c = i2;
        this.f2043d = javaDataStorage;
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        switch (this.f2042c) {
            case 0:
                return JavaDataStorage.b(this.f2043d, (C0027b) obj);
            default:
                return JavaDataStorage.a(this.f2043d, (Context) obj);
        }
    }
}
