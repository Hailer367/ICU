package androidx.emoji2.text;

import A2.x;
import T.k;
import T.l;
import T.r;
import android.content.Context;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.InterfaceC0212t;
import androidx.lifecycle.ProcessLifecycleInitializer;
import j0.C0423a;
import j0.InterfaceC0424b;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC0424b {
    @Override // j0.InterfaceC0424b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // j0.InterfaceC0424b
    public final Object b(Context context) {
        Object obj;
        r rVar = new r(new x(context));
        rVar.f1588b = 1;
        if (k.f1556j == null) {
            synchronized (k.f1555i) {
                try {
                    if (k.f1556j == null) {
                        k.f1556j = new k(rVar);
                    }
                } finally {
                }
            }
        }
        C0423a c4 = C0423a.c(context);
        c4.getClass();
        synchronized (C0423a.f5035e) {
            try {
                obj = c4.f5036a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c4.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        AbstractC0208o lifecycle = ((InterfaceC0212t) obj).getLifecycle();
        lifecycle.a(new l(this, lifecycle));
        return Boolean.TRUE;
    }
}
