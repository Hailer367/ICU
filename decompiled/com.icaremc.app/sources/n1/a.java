package n1;

import I0.h;
import X0.f;
import X0.g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import h1.AbstractC0336a;

/* loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.a implements X0.c {

    /* renamed from: A, reason: collision with root package name */
    public final h f5371A;

    /* renamed from: B, reason: collision with root package name */
    public final Bundle f5372B;

    /* renamed from: C, reason: collision with root package name */
    public final Integer f5373C;
    public final boolean z;

    public a(Context context, Looper looper, h hVar, Bundle bundle, f fVar, g gVar) {
        super(context, looper, 44, hVar, fVar, gVar);
        this.z = true;
        this.f5371A = hVar;
        this.f5372B = bundle;
        this.f5373C = (Integer) hVar.f820b;
    }

    @Override // X0.c
    public final int a() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a, X0.c
    public final boolean b() {
        return this.z;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new AbstractC0336a(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle g() {
        h hVar = this.f5371A;
        boolean equals = this.f3373c.getPackageName().equals((String) hVar.f819a);
        Bundle bundle = this.f5372B;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) hVar.f819a);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String j() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.signin.service.START";
    }
}
