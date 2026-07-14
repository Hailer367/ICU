package n;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import j.C0410e;
import j.DialogInterfaceC0414i;

/* loaded from: classes.dex */
public final class j implements InterfaceC0449B, AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    public Context f5284f;

    /* renamed from: g, reason: collision with root package name */
    public LayoutInflater f5285g;

    /* renamed from: h, reason: collision with root package name */
    public n f5286h;

    /* renamed from: i, reason: collision with root package name */
    public ExpandedMenuView f5287i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0448A f5288j;
    public i k;

    public j(ContextWrapper contextWrapper) {
        this.f5284f = contextWrapper;
        this.f5285g = LayoutInflater.from(contextWrapper);
    }

    @Override // n.InterfaceC0449B
    public final void a(n nVar, boolean z) {
        InterfaceC0448A interfaceC0448A = this.f5288j;
        if (interfaceC0448A != null) {
            interfaceC0448A.a(nVar, z);
        }
    }

    @Override // n.InterfaceC0449B
    public final void d() {
        i iVar = this.k;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    @Override // n.InterfaceC0449B
    public final boolean e(q qVar) {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final void g(Context context, n nVar) {
        if (this.f5284f != null) {
            this.f5284f = context;
            if (this.f5285g == null) {
                this.f5285g = LayoutInflater.from(context);
            }
        }
        this.f5286h = nVar;
        i iVar = this.k;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [n.A, android.content.DialogInterface$OnClickListener, java.lang.Object, android.content.DialogInterface$OnDismissListener, n.o] */
    @Override // n.InterfaceC0449B
    public final boolean h(H h3) {
        boolean hasVisibleItems = h3.hasVisibleItems();
        Context context = h3.f5294a;
        if (!hasVisibleItems) {
            return false;
        }
        ?? obj = new Object();
        obj.f5318f = h3;
        F.k kVar = new F.k(context);
        C0410e c0410e = (C0410e) kVar.f510b;
        j jVar = new j(c0410e.f4945a);
        obj.f5320h = jVar;
        jVar.f5288j = obj;
        h3.b(jVar, context);
        j jVar2 = obj.f5320h;
        if (jVar2.k == null) {
            jVar2.k = new i(jVar2);
        }
        c0410e.f4956m = jVar2.k;
        c0410e.f4957n = obj;
        View view = h3.f5307o;
        if (view != null) {
            c0410e.f4949e = view;
        } else {
            c0410e.f4947c = h3.f5306n;
            c0410e.f4948d = h3.f5305m;
        }
        c0410e.f4955l = obj;
        DialogInterfaceC0414i a4 = kVar.a();
        obj.f5319g = a4;
        a4.setOnDismissListener(obj);
        WindowManager.LayoutParams attributes = obj.f5319g.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        obj.f5319g.show();
        InterfaceC0448A interfaceC0448A = this.f5288j;
        if (interfaceC0448A != null) {
            interfaceC0448A.c(h3);
            return true;
        }
        return true;
    }

    @Override // n.InterfaceC0449B
    public final boolean i() {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final void j(InterfaceC0448A interfaceC0448A) {
        throw null;
    }

    @Override // n.InterfaceC0449B
    public final boolean k(q qVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        this.f5286h.q(this.k.getItem(i4), this, 0);
    }
}
