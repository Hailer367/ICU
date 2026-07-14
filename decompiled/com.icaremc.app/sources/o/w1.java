package o;

import android.content.Context;
import android.view.View;
import android.view.Window;
import n.C0451a;

/* loaded from: classes.dex */
public final class w1 implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public final C0451a f5729f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x1 f5730g;

    /* JADX WARN: Type inference failed for: r0v0, types: [n.a, java.lang.Object] */
    public w1(x1 x1Var) {
        this.f5730g = x1Var;
        Context context = x1Var.f5734a.getContext();
        CharSequence charSequence = x1Var.f5741h;
        ?? obj = new Object();
        obj.f5235e = 4096;
        obj.f5237g = 4096;
        obj.f5241l = null;
        obj.f5242m = null;
        obj.f5243n = false;
        obj.f5244o = false;
        obj.f5245p = 16;
        obj.f5239i = context;
        obj.f5231a = charSequence;
        this.f5729f = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x1 x1Var = this.f5730g;
        Window.Callback callback = x1Var.k;
        if (callback != null && x1Var.f5744l) {
            callback.onMenuItemSelected(0, this.f5729f);
        }
    }
}
