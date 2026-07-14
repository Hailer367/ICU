package A0;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0107e;
import androidx.fragment.app.C0119n;
import androidx.fragment.app.E0;
import androidx.fragment.app.H;
import androidx.fragment.app.s0;
import androidx.fragment.app.x0;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.jvm.internal.h;
import t0.C0305c;
import v0.i;
import v0.j;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f9e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10f;

    public /* synthetic */ a(c cVar, j jVar, C0.f fVar, i iVar) {
        this.f7c = 0;
        this.f8d = cVar;
        this.f9e = jVar;
        this.f10f = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f7c;
        Object obj = this.f10f;
        Object obj2 = this.f9e;
        Object obj3 = this.f8d;
        switch (i2) {
            case 0:
                c cVar = (c) obj3;
                j jVar = (j) obj2;
                String str = jVar.f3913a;
                i iVar = (i) obj;
                cVar.getClass();
                Logger logger = c.f15f;
                try {
                    w0.f a2 = cVar.f18c.a(str);
                    if (a2 == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((C0.j) cVar.f20e).f(new b(cVar, jVar, ((C0305c) a2).a(iVar), 0));
                    }
                    return;
                } catch (Exception e2) {
                    logger.warning("Error scheduling event " + e2.getMessage());
                    return;
                }
            case 1:
                ViewGroup container = (ViewGroup) obj3;
                C0107e this$0 = (C0107e) obj;
                h.e(container, "$container");
                h.e(this$0, "this$0");
                container.endViewTransition((View) obj2);
                this$0.f1605c.f1665a.c(this$0);
                return;
            case 2:
                H inFragment = ((E0) obj3).f1536c;
                H outFragment = ((E0) obj2).f1536c;
                boolean z = ((C0119n) obj).f1704o;
                x0 x0Var = s0.f1751a;
                h.e(inFragment, "inFragment");
                h.e(outFragment, "outFragment");
                if (z) {
                    outFragment.getEnterTransitionCallback();
                    return;
                } else {
                    inFragment.getEnterTransitionCallback();
                    return;
                }
            case 3:
                ((FlutterFirebaseCorePlugin) obj3).lambda$firebaseAppToMap$0((FirebaseApp) obj2, (TaskCompletionSource) obj);
                return;
            default:
                ((FlutterFirebaseMessagingPlugin) obj3).lambda$setAutoInitEnabled$7((Map) obj2, (TaskCompletionSource) obj);
                return;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f7c = i2;
        this.f8d = obj;
        this.f9e = obj2;
        this.f10f = obj3;
    }
}
