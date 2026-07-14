package x2;

import I.C0050d;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;
import e1.ThreadFactoryC0275a;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.concurrent.Executors;
import p1.C0580i;
import p1.C0585n;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6507f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0580i f6508g;

    public /* synthetic */ e(C0580i c0580i, int i4) {
        this.f6507f = i4;
        this.f6508g = c0580i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0585n c0585n;
        switch (this.f6507f) {
            case 0:
                FlutterFirebasePluginRegistry.lambda$didReinitializeFirebaseCore$1(this.f6508g);
                return;
            case 1:
                this.f6508g.b(null);
                return;
            case 2:
                C0580i c0580i = this.f6508g;
                try {
                    final FirebaseMessaging c4 = FirebaseMessaging.c();
                    c4.getClass();
                    final C0580i c0580i2 = new C0580i();
                    final int i4 = 0;
                    c4.f3414f.execute(new Runnable() { // from class: P1.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i4) {
                                case 0:
                                    FirebaseMessaging firebaseMessaging = c4;
                                    C0580i c0580i3 = c0580i2;
                                    A a4 = FirebaseMessaging.f3406l;
                                    try {
                                        c0580i3.b(firebaseMessaging.a());
                                        return;
                                    } catch (Exception e4) {
                                        c0580i3.a(e4);
                                        return;
                                    }
                                default:
                                    FirebaseMessaging firebaseMessaging2 = c4;
                                    C0580i c0580i4 = c0580i2;
                                    A a5 = FirebaseMessaging.f3406l;
                                    try {
                                        I0.h hVar = firebaseMessaging2.f3411c;
                                        hVar.getClass();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("delete", "1");
                                        AbstractC0602b.c(hVar.k(hVar.p(C0050d.d((u1.f) hVar.f819a), "*", bundle)));
                                        A d4 = FirebaseMessaging.d(firebaseMessaging2.f3410b);
                                        String e5 = firebaseMessaging2.e();
                                        String d5 = C0050d.d(firebaseMessaging2.f3409a);
                                        synchronized (d4) {
                                            String a6 = A.a(e5, d5);
                                            SharedPreferences.Editor edit = d4.f1340a.edit();
                                            edit.remove(a6);
                                            edit.commit();
                                        }
                                        c0580i4.b(null);
                                        return;
                                    } catch (Exception e6) {
                                        c0580i4.a(e6);
                                        return;
                                    }
                            }
                        }
                    });
                    String str = (String) AbstractC0602b.c(c0580i2.f5821a);
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", str);
                    c0580i.b(hashMap);
                    return;
                } catch (Exception e4) {
                    c0580i.a(e4);
                    return;
                }
            default:
                C0580i c0580i3 = this.f6508g;
                try {
                    final FirebaseMessaging c5 = FirebaseMessaging.c();
                    if (c5.f() == null) {
                        c0585n = AbstractC0602b.A(null);
                    } else {
                        final C0580i c0580i4 = new C0580i();
                        final int i5 = 1;
                        Executors.newSingleThreadExecutor(new ThreadFactoryC0275a("Firebase-Messaging-Network-Io")).execute(new Runnable() { // from class: P1.p
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i5) {
                                    case 0:
                                        FirebaseMessaging firebaseMessaging = c5;
                                        C0580i c0580i32 = c0580i4;
                                        A a4 = FirebaseMessaging.f3406l;
                                        try {
                                            c0580i32.b(firebaseMessaging.a());
                                            return;
                                        } catch (Exception e42) {
                                            c0580i32.a(e42);
                                            return;
                                        }
                                    default:
                                        FirebaseMessaging firebaseMessaging2 = c5;
                                        C0580i c0580i42 = c0580i4;
                                        A a5 = FirebaseMessaging.f3406l;
                                        try {
                                            I0.h hVar = firebaseMessaging2.f3411c;
                                            hVar.getClass();
                                            Bundle bundle = new Bundle();
                                            bundle.putString("delete", "1");
                                            AbstractC0602b.c(hVar.k(hVar.p(C0050d.d((u1.f) hVar.f819a), "*", bundle)));
                                            A d4 = FirebaseMessaging.d(firebaseMessaging2.f3410b);
                                            String e5 = firebaseMessaging2.e();
                                            String d5 = C0050d.d(firebaseMessaging2.f3409a);
                                            synchronized (d4) {
                                                String a6 = A.a(e5, d5);
                                                SharedPreferences.Editor edit = d4.f1340a.edit();
                                                edit.remove(a6);
                                                edit.commit();
                                            }
                                            c0580i42.b(null);
                                            return;
                                        } catch (Exception e6) {
                                            c0580i42.a(e6);
                                            return;
                                        }
                                }
                            }
                        });
                        c0585n = c0580i4.f5821a;
                    }
                    AbstractC0602b.c(c0585n);
                    c0580i3.b(null);
                    return;
                } catch (Exception e5) {
                    c0580i3.a(e5);
                    return;
                }
        }
    }

    public /* synthetic */ e(y2.f fVar, C0580i c0580i) {
        this.f6507f = 2;
        this.f6508g = c0580i;
    }
}
