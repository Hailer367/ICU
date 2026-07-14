package d;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.M;
import f.AbstractC0193i;
import f.C0195k;
import g.AbstractC0199b;
import g.C0198a;

/* loaded from: classes.dex */
public final class j extends AbstractC0193i {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ M f2129h;

    public j(M m2) {
        this.f2129h = m2;
    }

    @Override // f.AbstractC0193i
    public final void b(int i2, AbstractC0199b contract, Object obj) {
        Bundle bundle;
        int i3;
        kotlin.jvm.internal.h.e(contract, "contract");
        M m2 = this.f2129h;
        C0198a b2 = contract.b(m2, obj);
        if (b2 != null) {
            new Handler(Looper.getMainLooper()).post(new Y.a(this, i2, b2, 1));
            return;
        }
        Intent a2 = contract.a(m2, obj);
        if (a2.getExtras() != null) {
            Bundle extras = a2.getExtras();
            kotlin.jvm.internal.h.b(extras);
            if (extras.getClassLoader() == null) {
                a2.setExtrasClassLoader(m2.getClassLoader());
            }
        }
        if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
            String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            android.support.v4.media.session.a.D(m2, stringArrayExtra, i2);
            return;
        }
        if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
            C0195k c0195k = (C0195k) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                kotlin.jvm.internal.h.b(c0195k);
                i3 = i2;
            } catch (IntentSender.SendIntentException e2) {
                e = e2;
                i3 = i2;
            }
            try {
                m2.startIntentSenderForResult(c0195k.f2272c, i3, c0195k.f2273d, c0195k.f2274e, c0195k.f2275f, 0, bundle2);
                return;
            } catch (IntentSender.SendIntentException e3) {
                e = e3;
                new Handler(Looper.getMainLooper()).post(new Y.a(this, i3, e, 2));
                return;
            }
        }
        m2.startActivityForResult(a2, i2, bundle2);
    }
}
