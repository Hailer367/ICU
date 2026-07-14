package x;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import io.flutter.plugin.platform.C0381e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w extends B {

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f6430e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f6431f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public I f6432g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f6433h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f6434i;

    public w() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x019d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x.w e(android.app.Notification r6) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.w.e(android.app.Notification):x.w");
    }

    @Override // x.B
    public final void a(Bundle bundle) {
        super.a(bundle);
        bundle.putCharSequence("android.selfDisplayName", this.f6432g.f6330a);
        bundle.putBundle("android.messagingStyleUser", this.f6432g.b());
        bundle.putCharSequence("android.hiddenConversationTitle", this.f6433h);
        if (this.f6433h != null && this.f6434i.booleanValue()) {
            bundle.putCharSequence("android.conversationTitle", this.f6433h);
        }
        ArrayList arrayList = this.f6430e;
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArray("android.messages", v.a(arrayList));
        }
        ArrayList arrayList2 = this.f6431f;
        if (!arrayList2.isEmpty()) {
            bundle.putParcelableArray("android.messages.historic", v.a(arrayList2));
        }
        Boolean bool = this.f6434i;
        if (bool != null) {
            bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
        }
    }

    @Override // x.B
    public final void b(C0381e c0381e) {
        Notification.MessagingStyle b4;
        this.f6434i = Boolean.valueOf(f());
        if (Build.VERSION.SDK_INT >= 28) {
            I i4 = this.f6432g;
            i4.getClass();
            b4 = s.a(C.b.t(i4));
        } else {
            b4 = q.b(this.f6432g.f6330a);
        }
        ArrayList arrayList = this.f6430e;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            q.a(b4, ((v) obj).c());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList2 = this.f6431f;
            int size2 = arrayList2.size();
            while (i5 < size2) {
                Object obj2 = arrayList2.get(i5);
                i5++;
                r.a(b4, ((v) obj2).c());
            }
        }
        if (this.f6434i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
            q.c(b4, this.f6433h);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            s.b(b4, this.f6434i.booleanValue());
        }
        b4.setBuilder((Notification.Builder) c0381e.f4327c);
    }

    @Override // x.B
    public final String c() {
        return "androidx.core.app.NotificationCompat$MessagingStyle";
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [x.I, java.lang.Object] */
    @Override // x.B
    public final void d(Bundle bundle) {
        super.d(bundle);
        ArrayList arrayList = this.f6430e;
        arrayList.clear();
        if (bundle.containsKey("android.messagingStyleUser")) {
            this.f6432g = I.a(bundle.getBundle("android.messagingStyleUser"));
        } else {
            String string = bundle.getString("android.selfDisplayName");
            ?? obj = new Object();
            obj.f6330a = string;
            obj.f6331b = null;
            obj.f6332c = null;
            obj.f6333d = null;
            obj.f6334e = false;
            obj.f6335f = false;
            this.f6432g = obj;
        }
        CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
        this.f6433h = charSequence;
        if (charSequence == null) {
            this.f6433h = bundle.getCharSequence("android.hiddenConversationTitle");
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
        if (parcelableArray != null) {
            arrayList.addAll(v.b(parcelableArray));
        }
        Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
        if (parcelableArray2 != null) {
            this.f6431f.addAll(v.b(parcelableArray2));
        }
        if (bundle.containsKey("android.isGroupConversation")) {
            this.f6434i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
        }
    }

    public final boolean f() {
        C0712l c0712l = this.f6304a;
        if (c0712l != null && c0712l.f6391a.getApplicationInfo().targetSdkVersion < 28 && this.f6434i == null) {
            if (this.f6433h == null) {
                return false;
            }
            return true;
        }
        Boolean bool = this.f6434i;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public w(I i4) {
        if (!TextUtils.isEmpty(i4.f6330a)) {
            this.f6432g = i4;
            return;
        }
        throw new IllegalArgumentException("User's name must not be empty.");
    }
}
