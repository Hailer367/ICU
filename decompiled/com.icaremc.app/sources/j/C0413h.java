package j;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.icaremc.app.R;
import i.AbstractC0357a;
import java.lang.ref.WeakReference;

/* renamed from: j.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0413h {

    /* renamed from: A, reason: collision with root package name */
    public final int f4961A;

    /* renamed from: B, reason: collision with root package name */
    public final int f4962B;

    /* renamed from: C, reason: collision with root package name */
    public final int f4963C;

    /* renamed from: D, reason: collision with root package name */
    public final boolean f4964D;

    /* renamed from: E, reason: collision with root package name */
    public final HandlerC0411f f4965E;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4967a;

    /* renamed from: b, reason: collision with root package name */
    public final DialogInterfaceC0414i f4968b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f4969c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f4970d;

    /* renamed from: e, reason: collision with root package name */
    public String f4971e;

    /* renamed from: f, reason: collision with root package name */
    public AlertController$RecycleListView f4972f;

    /* renamed from: g, reason: collision with root package name */
    public FrameLayout f4973g;

    /* renamed from: i, reason: collision with root package name */
    public Button f4975i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f4976j;
    public Message k;

    /* renamed from: l, reason: collision with root package name */
    public Button f4977l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f4978m;

    /* renamed from: n, reason: collision with root package name */
    public Message f4979n;

    /* renamed from: o, reason: collision with root package name */
    public Button f4980o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f4981p;

    /* renamed from: q, reason: collision with root package name */
    public Message f4982q;

    /* renamed from: r, reason: collision with root package name */
    public NestedScrollView f4983r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f4984s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f4985t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f4986u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f4987v;

    /* renamed from: w, reason: collision with root package name */
    public View f4988w;

    /* renamed from: x, reason: collision with root package name */
    public ListAdapter f4989x;
    public final int z;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4974h = false;

    /* renamed from: y, reason: collision with root package name */
    public int f4990y = -1;

    /* renamed from: F, reason: collision with root package name */
    public final ViewOnClickListenerC0408c f4966F = new ViewOnClickListenerC0408c(0, this);

    /* JADX WARN: Type inference failed for: r6v1, types: [j.f, android.os.Handler] */
    public C0413h(Context context, DialogInterfaceC0414i dialogInterfaceC0414i, Window window) {
        this.f4967a = context;
        this.f4968b = dialogInterfaceC0414i;
        this.f4969c = window;
        ?? handler = new Handler();
        handler.f4960a = new WeakReference(dialogInterfaceC0414i);
        this.f4965E = handler;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0357a.f4070e, R.attr.alertDialogStyle, 0);
        this.z = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.f4961A = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.getResourceId(5, 0);
        this.f4962B = obtainStyledAttributes.getResourceId(7, 0);
        this.f4963C = obtainStyledAttributes.getResourceId(3, 0);
        this.f4964D = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        dialogInterfaceC0414i.c().g(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i4, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message message;
        if (onClickListener != null) {
            message = this.f4965E.obtainMessage(i4, onClickListener);
        } else {
            message = null;
        }
        if (i4 != -3) {
            if (i4 != -2) {
                if (i4 == -1) {
                    this.f4976j = charSequence;
                    this.k = message;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f4978m = charSequence;
            this.f4979n = message;
            return;
        }
        this.f4981p = charSequence;
        this.f4982q = message;
    }
}
