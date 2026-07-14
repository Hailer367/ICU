package j;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import m.AbstractC0438b;
import o.s1;

/* renamed from: j.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0408c implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4941f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4942g;

    public /* synthetic */ ViewOnClickListenerC0408c(int i4, Object obj) {
        this.f4941f = i4;
        this.f4942g = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        Message message4;
        n.q qVar;
        switch (this.f4941f) {
            case 0:
                C0413h c0413h = (C0413h) this.f4942g;
                if (view == c0413h.f4975i && (message4 = c0413h.k) != null) {
                    message = Message.obtain(message4);
                } else if (view == c0413h.f4977l && (message3 = c0413h.f4979n) != null) {
                    message = Message.obtain(message3);
                } else if (view == c0413h.f4980o && (message2 = c0413h.f4982q) != null) {
                    message = Message.obtain(message2);
                } else {
                    message = null;
                }
                if (message != null) {
                    message.sendToTarget();
                }
                c0413h.f4965E.obtainMessage(1, c0413h.f4968b).sendToTarget();
                return;
            case 1:
                ((AbstractC0438b) this.f4942g).a();
                return;
            default:
                s1 s1Var = ((Toolbar) this.f4942g).f2466R;
                if (s1Var == null) {
                    qVar = null;
                } else {
                    qVar = s1Var.f5705g;
                }
                if (qVar != null) {
                    qVar.collapseActionView();
                    return;
                }
                return;
        }
    }
}
