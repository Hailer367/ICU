package b1;

import I0.h;
import X0.g;
import Y0.k;
import Z0.j;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;

/* loaded from: classes.dex */
public final class d extends android.support.v4.media.session.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3207a;

    @Override // android.support.v4.media.session.a
    public X0.c e(Context context, Looper looper, h hVar, Object obj, X0.f fVar, g gVar) {
        switch (this.f3207a) {
            case 2:
                hVar.getClass();
                Integer num = (Integer) hVar.f820b;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new n1.a(context, looper, hVar, bundle, fVar, gVar);
            case 3:
                obj.getClass();
                throw new ClassCastException();
            default:
                return super.e(context, looper, hVar, obj, fVar, gVar);
        }
    }

    @Override // android.support.v4.media.session.a
    public X0.c f(Context context, Looper looper, h hVar, Object obj, k kVar, k kVar2) {
        switch (this.f3207a) {
            case 0:
                return new com.google.android.gms.common.internal.a(context, looper, 449, hVar, kVar, kVar2);
            case 1:
                return new f(context, looper, hVar, (j) obj, kVar, kVar2);
            default:
                return super.f(context, looper, hVar, obj, kVar, kVar2);
        }
    }
}
