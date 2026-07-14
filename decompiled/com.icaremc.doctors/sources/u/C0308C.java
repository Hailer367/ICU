package u;

import E.AbstractC0005e;
import E.AbstractC0015o;
import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Iterator;

/* renamed from: u.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0308C {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3673a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f3674b;

    /* renamed from: c, reason: collision with root package name */
    public final C0319j f3675c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f3676d = new Bundle();

    /* renamed from: e, reason: collision with root package name */
    public final int f3677e;

    /* JADX WARN: Removed duplicated region for block: B:138:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0308C(u.C0319j r26) {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.C0308C.<init>(u.j):void");
    }

    public final void a(C0315f c0315f) {
        Bundle bundle;
        IconCompat a2 = c0315f.a();
        int i2 = c0315f.f3727f;
        boolean z = c0315f.f3725d;
        Bundle bundle2 = c0315f.f3722a;
        Icon icon = null;
        if (a2 != null) {
            icon = a2.h(null);
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(icon, c0315f.f3730i, c0315f.f3731j);
        M[] mArr = c0315f.f3724c;
        if (mArr != null) {
            RemoteInput[] remoteInputArr = new RemoteInput[mArr.length];
            for (int i3 = 0; i3 < mArr.length; i3++) {
                M m2 = mArr[i3];
                m2.getClass();
                RemoteInput.Builder addExtras = new RemoteInput.Builder("FlutterLocalNotificationsPluginInputResult").setLabel(m2.f3707a).setChoices(m2.f3708b).setAllowFreeFormInput(m2.f3709c).addExtras(m2.f3710d);
                if (Build.VERSION.SDK_INT >= 26) {
                    Iterator it = m2.f3711e.iterator();
                    while (it.hasNext()) {
                        AbstractC0015o.i(addExtras, (String) it.next());
                    }
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    AbstractC0306A.d(addExtras);
                }
                remoteInputArr[i3] = addExtras.build();
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
        int i4 = Build.VERSION.SDK_INT;
        builder.setAllowGeneratedReplies(z);
        bundle.putInt("android.support.action.semanticAction", i2);
        if (i4 >= 28) {
            AbstractC0005e.q(builder, i2);
        }
        if (i4 >= 29) {
            AbstractC0306A.c(builder, c0315f.f3728g);
        }
        if (i4 >= 31) {
            AbstractC0307B.a(builder);
        }
        bundle.putBoolean("android.support.action.showsUserInterface", c0315f.f3726e);
        builder.addExtras(bundle);
        this.f3674b.addAction(builder.build());
    }
}
