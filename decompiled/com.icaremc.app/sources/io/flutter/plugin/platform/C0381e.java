package io.flutter.plugin.platform;

import I.w0;
import I.y0;
import android.app.Activity;
import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.core.graphics.drawable.IconCompat;
import h2.AbstractActivityC0349b;
import java.util.Iterator;
import x.C0708h;
import x.K;

/* renamed from: io.flutter.plugin.platform.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0381e {

    /* renamed from: a, reason: collision with root package name */
    public int f4325a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4326b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4327c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4328d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4329e;

    /* JADX WARN: Removed duplicated region for block: B:138:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0381e(x.C0712l r26) {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.C0381e.<init>(x.l):void");
    }

    public void a(C0708h c0708h) {
        Bundle bundle;
        IconCompat a4 = c0708h.a();
        int i4 = c0708h.f6371f;
        boolean z = c0708h.f6369d;
        Bundle bundle2 = c0708h.f6366a;
        Icon icon = null;
        if (a4 != null) {
            icon = a4.h(null);
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(icon, c0708h.f6374i, c0708h.f6375j);
        K[] kArr = c0708h.f6368c;
        if (kArr != null) {
            RemoteInput[] remoteInputArr = new RemoteInput[kArr.length];
            for (int i5 = 0; i5 < kArr.length; i5++) {
                K k = kArr[i5];
                k.getClass();
                RemoteInput.Builder addExtras = new RemoteInput.Builder("FlutterLocalNotificationsPluginInputResult").setLabel(k.f6337a).setChoices(k.f6338b).setAllowFreeFormInput(k.f6339c).addExtras(k.f6340d);
                if (Build.VERSION.SDK_INT >= 26) {
                    Iterator it = k.f6341e.iterator();
                    while (it.hasNext()) {
                        C.a.i(addExtras, (String) it.next());
                    }
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    B.b.f(addExtras);
                }
                remoteInputArr[i5] = addExtras.build();
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (bundle2 != null) {
            bundle = new Bundle(bundle2);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", z);
        int i6 = Build.VERSION.SDK_INT;
        builder.setAllowGeneratedReplies(z);
        bundle.putInt("android.support.action.semanticAction", i4);
        if (i6 >= 28) {
            C.b.r(builder, i4);
        }
        if (i6 >= 29) {
            B.b.e(builder, c0708h.f6372g);
        }
        if (i6 >= 31) {
            x.C.a(builder);
        }
        bundle.putBoolean("android.support.action.showsUserInterface", c0708h.f6370e);
        builder.addExtras(bundle);
        ((Notification.Builder) this.f4327c).addAction(builder.build());
    }

    public void b(r2.c cVar) {
        k3.b w0Var;
        Window window = ((Activity) this.f4326b).getWindow();
        window.getDecorView();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 35) {
            w0Var = new y0(window);
        } else if (i4 >= 30) {
            w0Var = new y0(window);
        } else if (i4 >= 26) {
            w0Var = new w0(window);
        } else {
            w0Var = new w0(window);
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        int i6 = cVar.f6050a;
        if (i6 != 0) {
            int b4 = R.i.b(i6);
            if (b4 != 0) {
                if (b4 == 1) {
                    w0Var.x(true);
                }
            } else {
                w0Var.x(false);
            }
        }
        Integer num = (Integer) cVar.f6052c;
        if (num != null) {
            window.setStatusBarColor(num.intValue());
        }
        Boolean bool = (Boolean) cVar.f6055f;
        if (bool != null && i5 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i5 >= 26) {
            int i7 = cVar.f6051b;
            if (i7 != 0) {
                int b5 = R.i.b(i7);
                if (b5 != 0) {
                    if (b5 == 1) {
                        w0Var.w(true);
                    }
                } else {
                    w0Var.w(false);
                }
            }
            Integer num2 = (Integer) cVar.f6053d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = (Integer) cVar.f6054e;
        if (num3 != null && i5 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = (Boolean) cVar.f6056g;
        if (bool2 != null && i5 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f4329e = cVar;
    }

    public void c() {
        ((Activity) this.f4326b).getWindow().getDecorView().setSystemUiVisibility(this.f4325a);
        r2.c cVar = (r2.c) this.f4329e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public C0381e(AbstractActivityC0349b abstractActivityC0349b, s sVar, AbstractActivityC0349b abstractActivityC0349b2) {
        p pVar = new p(1, this);
        this.f4326b = abstractActivityC0349b;
        this.f4327c = sVar;
        sVar.f4391h = pVar;
        this.f4328d = abstractActivityC0349b2;
        this.f4325a = 1280;
    }
}
