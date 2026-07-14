package P1;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f1448a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1449b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f1450c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1451d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1452e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f1453f;

    /* renamed from: g, reason: collision with root package name */
    public final String f1454g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1455h;

    /* renamed from: i, reason: collision with root package name */
    public final String f1456i;

    /* renamed from: j, reason: collision with root package name */
    public final String f1457j;
    public final String k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1458l;

    /* renamed from: m, reason: collision with root package name */
    public final String f1459m;

    /* renamed from: n, reason: collision with root package name */
    public final Uri f1460n;

    /* renamed from: o, reason: collision with root package name */
    public final String f1461o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f1462p;

    /* renamed from: q, reason: collision with root package name */
    public final Integer f1463q;

    /* renamed from: r, reason: collision with root package name */
    public final Integer f1464r;

    public v(A2.q qVar) {
        String[] strArr;
        String[] strArr2;
        this.f1448a = qVar.G("gcm.n.title");
        this.f1449b = qVar.D("gcm.n.title");
        Object[] C3 = qVar.C("gcm.n.title");
        if (C3 == null) {
            strArr = null;
        } else {
            strArr = new String[C3.length];
            for (int i4 = 0; i4 < C3.length; i4++) {
                strArr[i4] = String.valueOf(C3[i4]);
            }
        }
        this.f1450c = strArr;
        this.f1451d = qVar.G("gcm.n.body");
        this.f1452e = qVar.D("gcm.n.body");
        Object[] C4 = qVar.C("gcm.n.body");
        if (C4 == null) {
            strArr2 = null;
        } else {
            strArr2 = new String[C4.length];
            for (int i5 = 0; i5 < C4.length; i5++) {
                strArr2[i5] = String.valueOf(C4[i5]);
            }
        }
        this.f1453f = strArr2;
        this.f1454g = qVar.G("gcm.n.icon");
        String G3 = qVar.G("gcm.n.sound2");
        this.f1456i = TextUtils.isEmpty(G3) ? qVar.G("gcm.n.sound") : G3;
        this.f1457j = qVar.G("gcm.n.tag");
        this.k = qVar.G("gcm.n.color");
        this.f1458l = qVar.G("gcm.n.click_action");
        this.f1459m = qVar.G("gcm.n.android_channel_id");
        String G4 = qVar.G("gcm.n.link_android");
        G4 = TextUtils.isEmpty(G4) ? qVar.G("gcm.n.link") : G4;
        this.f1460n = TextUtils.isEmpty(G4) ? null : Uri.parse(G4);
        this.f1455h = qVar.G("gcm.n.image");
        this.f1461o = qVar.G("gcm.n.ticker");
        this.f1462p = qVar.z("gcm.n.notification_priority");
        this.f1463q = qVar.z("gcm.n.visibility");
        this.f1464r = qVar.z("gcm.n.notification_count");
        qVar.y("gcm.n.sticky");
        qVar.y("gcm.n.local_only");
        qVar.y("gcm.n.default_sound");
        qVar.y("gcm.n.default_vibrate_timings");
        qVar.y("gcm.n.default_light_settings");
        qVar.E();
        qVar.B();
        qVar.H();
    }
}
