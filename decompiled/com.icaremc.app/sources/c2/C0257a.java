package c2;

import A2.t;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import java.util.HashSet;
import o.B1;
import o2.c;
import p2.InterfaceC0586a;
import p2.b;
import r2.i;
import s2.C0635g;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0636h;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.InterfaceC0647s;

/* renamed from: c2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0257a implements c, InterfaceC0642n, InterfaceC0636h, InterfaceC0586a, InterfaceC0647s {

    /* renamed from: f, reason: collision with root package name */
    public C0644p f3320f;

    /* renamed from: g, reason: collision with root package name */
    public t f3321g;

    /* renamed from: h, reason: collision with root package name */
    public C0635g f3322h;

    /* renamed from: i, reason: collision with root package name */
    public b f3323i;

    /* renamed from: j, reason: collision with root package name */
    public String f3324j;
    public boolean k = false;

    /* renamed from: l, reason: collision with root package name */
    public String f3325l;

    public final boolean a(Intent intent) {
        String str;
        if (intent == null) {
            return false;
        }
        Log.d("com.llfbandit.app_links", intent.toString());
        if ((intent.getFlags() & 1048576) == 1048576) {
            return false;
        }
        String action = intent.getAction();
        if (!"android.intent.action.SEND".equals(action) && !"android.intent.action.SEND_MULTIPLE".equals(action) && !"android.intent.action.SENDTO".equals(action)) {
            str = intent.getDataString();
            if (str != null) {
                Log.d("com.llfbandit.app_links", "Handled intent: action: " + action + " / data: " + str);
            }
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        if (this.f3324j == null) {
            this.f3324j = str;
        }
        this.f3325l = str;
        C0635g c0635g = this.f3322h;
        if (c0635g != null) {
            this.k = true;
            c0635g.a(str);
        }
        return true;
    }

    @Override // s2.InterfaceC0636h
    public final void c(C0635g c0635g) {
        String str;
        this.f3322h = c0635g;
        if (!this.k && (str = this.f3324j) != null) {
            this.k = true;
            c0635g.a(str);
        }
    }

    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(b bVar) {
        this.f3323i = bVar;
        B1 b12 = (B1) bVar;
        b12.b(this);
        a(((Activity) b12.f5414f).getIntent());
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        C0644p c0644p = new C0644p(bVar.f5787c, "com.llfbandit.app_links/messages");
        this.f3320f = c0644p;
        c0644p.b(this);
        t tVar = new t(bVar.f5787c, "com.llfbandit.app_links/events");
        this.f3321g = tVar;
        tVar.X(this);
    }

    @Override // s2.InterfaceC0636h
    public final void onCancel() {
        this.f3322h = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        b bVar = this.f3323i;
        if (bVar != null) {
            ((HashSet) ((B1) bVar).f5418j).remove(this);
        }
        this.f3323i = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        this.f3320f.b(null);
        this.f3321g.X(null);
    }

    @Override // s2.InterfaceC0642n
    public final void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        if (c0641m.f6155a.equals("getLatestLink")) {
            ((i) interfaceC0643o).success(this.f3325l);
        } else if (c0641m.f6155a.equals("getInitialLink")) {
            ((i) interfaceC0643o).success(this.f3324j);
        } else {
            ((i) interfaceC0643o).notImplemented();
        }
    }

    @Override // s2.InterfaceC0647s
    public final boolean onNewIntent(Intent intent) {
        return a(intent);
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(b bVar) {
        this.f3323i = bVar;
        ((B1) bVar).b(this);
    }
}
