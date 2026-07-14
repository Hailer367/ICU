package io.flutter.plugin.platform;

import android.view.View;
import s2.C0644p;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4340b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f4341c;

    public /* synthetic */ m(l lVar, int i4, int i5) {
        this.f4339a = i5;
        this.f4341c = lVar;
        this.f4340b = i4;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f4339a) {
            case 0:
                r rVar = (r) this.f4341c;
                int i4 = this.f4340b;
                if (z) {
                    C0644p c0644p = (C0644p) rVar.f4375m.f4390g;
                    if (c0644p != null) {
                        c0644p.a("viewFocused", Integer.valueOf(i4), null);
                        return;
                    }
                    return;
                }
                io.flutter.plugin.editing.j jVar = rVar.f4374l;
                if (jVar != null) {
                    jVar.b(i4);
                    return;
                }
                return;
            default:
                q qVar = (q) this.f4341c;
                int i5 = this.f4340b;
                if (z) {
                    C0644p c0644p2 = (C0644p) qVar.f4356l.f4390g;
                    if (c0644p2 != null) {
                        c0644p2.a("viewFocused", Integer.valueOf(i5), null);
                        return;
                    }
                    return;
                }
                io.flutter.plugin.editing.j jVar2 = qVar.k;
                if (jVar2 != null) {
                    jVar2.b(i5);
                    return;
                }
                return;
        }
    }
}
