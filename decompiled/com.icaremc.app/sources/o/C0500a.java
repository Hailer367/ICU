package o;

import androidx.appcompat.widget.ActionBarContextView;

/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0500a implements I.Z {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5553a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f5554b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f5555c;

    public C0500a(ActionBarContextView actionBarContextView) {
        this.f5555c = actionBarContextView;
    }

    @Override // I.Z
    public final void a() {
        if (this.f5553a) {
            return;
        }
        ActionBarContextView actionBarContextView = this.f5555c;
        actionBarContextView.k = null;
        super/*android.view.View*/.setVisibility(this.f5554b);
    }

    @Override // I.Z
    public final void b() {
        this.f5553a = true;
    }

    @Override // I.Z
    public final void c() {
        super/*android.view.View*/.setVisibility(0);
        this.f5553a = false;
    }
}
