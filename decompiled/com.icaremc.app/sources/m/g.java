package m;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import n.E;

/* loaded from: classes.dex */
public final class g extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5144a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC0438b f5145b;

    public g(Context context, AbstractC0438b abstractC0438b) {
        this.f5144a = context;
        this.f5145b = abstractC0438b;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f5145b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f5145b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new E(this.f5144a, this.f5145b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f5145b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f5145b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f5145b.f5131f;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f5145b.f();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f5145b.f5132g;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f5145b.g();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f5145b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f5145b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f5145b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f5145b.f5131f = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f5145b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.f5145b.p(z);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i4) {
        this.f5145b.l(i4);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i4) {
        this.f5145b.n(i4);
    }
}
