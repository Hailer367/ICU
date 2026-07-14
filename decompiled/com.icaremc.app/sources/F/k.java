package F;

import Z0.r;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import h2.C0341A;
import j.C0409d;
import j.C0410e;
import j.C0413h;
import j.DialogInterfaceC0414i;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f509a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f510b;

    public k(W0.a aVar, int i4) {
        r.e(aVar);
        this.f510b = aVar;
        this.f509a = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public DialogInterfaceC0414i a() {
        int i4;
        C0410e c0410e = (C0410e) this.f510b;
        DialogInterfaceC0414i dialogInterfaceC0414i = new DialogInterfaceC0414i(c0410e.f4945a, this.f509a);
        View view = c0410e.f4949e;
        C0413h c0413h = dialogInterfaceC0414i.f4992l;
        if (view != null) {
            c0413h.f4988w = view;
        } else {
            CharSequence charSequence = c0410e.f4948d;
            if (charSequence != null) {
                c0413h.f4970d = charSequence;
                TextView textView = c0413h.f4986u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c0410e.f4947c;
            if (drawable != null) {
                c0413h.f4984s = drawable;
                ImageView imageView = c0413h.f4985t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c0413h.f4985t.setImageDrawable(drawable);
                }
            }
        }
        String str = c0410e.f4950f;
        if (str != null) {
            c0413h.f4971e = str;
            TextView textView2 = c0413h.f4987v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        CharSequence charSequence2 = c0410e.f4951g;
        if (charSequence2 != null) {
            c0413h.c(-1, charSequence2, c0410e.f4952h);
        }
        CharSequence charSequence3 = c0410e.f4953i;
        if (charSequence3 != null) {
            c0413h.c(-2, charSequence3, c0410e.f4954j);
        }
        if (c0410e.f4956m != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c0410e.f4946b.inflate(c0413h.f4961A, (ViewGroup) null);
            if (c0410e.f4958o) {
                i4 = c0413h.f4962B;
            } else {
                i4 = c0413h.f4963C;
            }
            Object obj = c0410e.f4956m;
            ?? r7 = obj;
            if (obj == null) {
                r7 = new ArrayAdapter(c0410e.f4945a, i4, R.id.text1, (Object[]) null);
            }
            c0413h.f4989x = r7;
            c0413h.f4990y = c0410e.f4959p;
            if (c0410e.f4957n != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0409d(c0410e, c0413h));
            }
            if (c0410e.f4958o) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            c0413h.f4972f = alertController$RecycleListView;
        }
        dialogInterfaceC0414i.setCancelable(true);
        dialogInterfaceC0414i.setCanceledOnTouchOutside(true);
        dialogInterfaceC0414i.setOnCancelListener(c0410e.k);
        dialogInterfaceC0414i.setOnDismissListener(null);
        n.o oVar = c0410e.f4955l;
        if (oVar != null) {
            dialogInterfaceC0414i.setOnKeyListener(oVar);
        }
        return dialogInterfaceC0414i;
    }

    public k(int i4, C0341A[] c0341aArr) {
        this.f509a = i4;
        this.f510b = c0341aArr;
    }

    public k(int i4) {
        if (i4 > 0) {
            this.f510b = new Object[i4];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public k(Context context) {
        this(context, DialogInterfaceC0414i.e(context, 0));
    }

    public k(Context context, int i4) {
        this.f510b = new C0410e(new ContextThemeWrapper(context, DialogInterfaceC0414i.e(context, i4)));
        this.f509a = i4;
    }

    public k() {
        this.f509a = 1;
        this.f510b = Collections.singletonList(null);
    }

    public k(ArrayList arrayList) {
        this.f509a = 0;
        this.f510b = arrayList;
    }
}
