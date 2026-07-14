package e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.AbstractActivityC0192y;
import h.AbstractC0296a;

/* loaded from: classes.dex */
public final class k extends g.i {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0192y f3563h;

    public k(AbstractActivityC0192y abstractActivityC0192y) {
        this.f3563h = abstractActivityC0192y;
    }

    @Override // g.i
    public final void b(int i4, AbstractC0296a abstractC0296a, Object obj) {
        Bundle bundle;
        int i5;
        AbstractActivityC0192y abstractActivityC0192y = this.f3563h;
        A2.q b4 = abstractC0296a.b(abstractActivityC0192y, obj);
        if (b4 != null) {
            new Handler(Looper.getMainLooper()).post(new j(this, i4, b4, 0));
            return;
        }
        Intent a4 = abstractC0296a.a(abstractActivityC0192y, obj);
        if (a4.getExtras() != null) {
            Bundle extras = a4.getExtras();
            T2.h.b(extras);
            if (extras.getClassLoader() == null) {
                a4.setExtrasClassLoader(abstractActivityC0192y.getClassLoader());
            }
        }
        if (a4.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = a4.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a4.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a4.getAction())) {
            String[] stringArrayExtra = a4.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            android.support.v4.media.session.a.u(abstractActivityC0192y, stringArrayExtra, i4);
            return;
        }
        if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a4.getAction())) {
            g.j jVar = (g.j) a4.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                T2.h.b(jVar);
                i5 = i4;
            } catch (IntentSender.SendIntentException e4) {
                e = e4;
                i5 = i4;
            }
            try {
                abstractActivityC0192y.startIntentSenderForResult(jVar.f3760f, i5, jVar.f3761g, jVar.f3762h, jVar.f3763i, 0, bundle2);
                return;
            } catch (IntentSender.SendIntentException e5) {
                e = e5;
                new Handler(Looper.getMainLooper()).post(new j(this, i5, e, 1));
                return;
            }
        }
        abstractActivityC0192y.startActivityForResult(a4, i4, bundle2);
    }
}
