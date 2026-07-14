package u;

import E.AbstractC0005e;
import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u extends z {

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f3785e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3786f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public K f3787g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f3788h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f3789i;

    public u() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x019d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static u.u e(android.app.Notification r6) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.u.e(android.app.Notification):u.u");
    }

    @Override // u.z
    public final void a(Bundle bundle) {
        super.a(bundle);
        bundle.putCharSequence("android.selfDisplayName", this.f3787g.f3700a);
        bundle.putBundle("android.messagingStyleUser", this.f3787g.b());
        bundle.putCharSequence("android.hiddenConversationTitle", this.f3788h);
        if (this.f3788h != null && this.f3789i.booleanValue()) {
            bundle.putCharSequence("android.conversationTitle", this.f3788h);
        }
        ArrayList arrayList = this.f3785e;
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArray("android.messages", t.a(arrayList));
        }
        ArrayList arrayList2 = this.f3786f;
        if (!arrayList2.isEmpty()) {
            bundle.putParcelableArray("android.messages.historic", t.a(arrayList2));
        }
        Boolean bool = this.f3789i;
        if (bool != null) {
            bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
        }
    }

    @Override // u.z
    public final void b(C0308C c0308c) {
        Notification.MessagingStyle b2;
        this.f3789i = Boolean.valueOf(f());
        if (Build.VERSION.SDK_INT >= 28) {
            K k2 = this.f3787g;
            k2.getClass();
            b2 = q.a(AbstractC0005e.s(k2));
        } else {
            b2 = o.b(this.f3787g.f3700a);
        }
        ArrayList arrayList = this.f3785e;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            o.a(b2, ((t) obj).c());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList2 = this.f3786f;
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                p.a(b2, ((t) obj2).c());
            }
        }
        if (this.f3789i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
            o.c(b2, this.f3788h);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            q.b(b2, this.f3789i.booleanValue());
        }
        b2.setBuilder(c0308c.f3674b);
    }

    @Override // u.z
    public final String c() {
        return "androidx.core.app.NotificationCompat$MessagingStyle";
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [u.K, java.lang.Object] */
    @Override // u.z
    public final void d(Bundle bundle) {
        super.d(bundle);
        ArrayList arrayList = this.f3785e;
        arrayList.clear();
        if (bundle.containsKey("android.messagingStyleUser")) {
            this.f3787g = K.a(bundle.getBundle("android.messagingStyleUser"));
        } else {
            String string = bundle.getString("android.selfDisplayName");
            ?? obj = new Object();
            obj.f3700a = string;
            obj.f3701b = null;
            obj.f3702c = null;
            obj.f3703d = null;
            obj.f3704e = false;
            obj.f3705f = false;
            this.f3787g = obj;
        }
        CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
        this.f3788h = charSequence;
        if (charSequence == null) {
            this.f3788h = bundle.getCharSequence("android.hiddenConversationTitle");
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
        if (parcelableArray != null) {
            arrayList.addAll(t.b(parcelableArray));
        }
        Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
        if (parcelableArray2 != null) {
            this.f3786f.addAll(t.b(parcelableArray2));
        }
        if (bundle.containsKey("android.isGroupConversation")) {
            this.f3789i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
        }
    }

    public final boolean f() {
        C0319j c0319j = this.f3804a;
        if (c0319j != null && c0319j.f3747a.getApplicationInfo().targetSdkVersion < 28 && this.f3789i == null) {
            if (this.f3788h == null) {
                return false;
            }
            return true;
        }
        Boolean bool = this.f3789i;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public u(K k2) {
        if (!TextUtils.isEmpty(k2.f3700a)) {
            this.f3787g = k2;
            return;
        }
        throw new IllegalArgumentException("User's name must not be empty.");
    }
}
