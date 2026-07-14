package j;

import I.T;
import a.AbstractC0141a;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.icaremc.app.R;
import java.util.WeakHashMap;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import o.C0470E0;

/* renamed from: j.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceC0414i extends e.n implements DialogInterface, InterfaceC0417l {

    /* renamed from: j, reason: collision with root package name */
    public LayoutInflaterFactory2C0393A f4991j;
    public final C0394B k;

    /* renamed from: l, reason: collision with root package name */
    public final C0413h f4992l;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [j.B] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DialogInterfaceC0414i(android.view.ContextThemeWrapper r5, int r6) {
        /*
            r4 = this;
            int r6 = e(r5, r6)
            r0 = 1
            r1 = 2130903164(0x7f03007c, float:1.7413138E38)
            if (r6 != 0) goto L19
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L1a
        L19:
            r2 = r6
        L1a:
            r4.<init>(r5, r2)
            j.B r2 = new j.B
            r2.<init>()
            r4.k = r2
            j.o r2 = r4.c()
            if (r6 != 0) goto L38
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L38:
            r5 = r2
            j.A r5 = (j.LayoutInflaterFactory2C0393A) r5
            r5.f4849Y = r6
            r2.d()
            j.h r5 = new j.h
            android.content.Context r6 = r4.getContext()
            android.view.Window r0 = r4.getWindow()
            r5.<init>(r6, r4, r0)
            r4.f4992l = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.DialogInterfaceC0414i.<init>(android.view.ContextThemeWrapper, int):void");
    }

    public static int e(Context context, int i4) {
        if (((i4 >>> 24) & 255) >= 1) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // e.n, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) c();
        layoutInflaterFactory2C0393A.x();
        ((ViewGroup) layoutInflaterFactory2C0393A.f4831F.findViewById(android.R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C0393A.f4866r.a(layoutInflaterFactory2C0393A.f4865q.getCallback());
    }

    public final AbstractC0420o c() {
        if (this.f4991j == null) {
            ExecutorC0399G executorC0399G = AbstractC0420o.f4994f;
            this.f4991j = new LayoutInflaterFactory2C0393A(getContext(), getWindow(), this, this);
        }
        return this.f4991j;
    }

    public final void d(Bundle bundle) {
        c().a();
        super.onCreate(bundle);
        c().d();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        c().e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0141a.n(this.k, getWindow().getDecorView(), this, keyEvent);
    }

    public final void f(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().m(charSequence);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i4) {
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) c();
        layoutInflaterFactory2C0393A.x();
        return layoutInflaterFactory2C0393A.f4865q.findViewById(i4);
    }

    public final boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        c().b();
    }

    @Override // e.n, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        boolean z;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        ListAdapter listAdapter;
        int i6;
        int i7;
        View findViewById;
        View findViewById2;
        d(bundle);
        C0413h c0413h = this.f4992l;
        c0413h.f4968b.setContentView(c0413h.z);
        Context context = c0413h.f4967a;
        Window window = c0413h.f4969c;
        View findViewById3 = window.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        FrameLayout frameLayout = c0413h.f4973g;
        if (frameLayout == null) {
            frameLayout = null;
        }
        int i8 = 0;
        if (frameLayout != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !C0413h.a(frameLayout)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout2 = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout2.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            if (c0413h.f4974h) {
                frameLayout2.setPadding(0, 0, 0, 0);
            }
            if (c0413h.f4972f != null) {
                ((LinearLayout.LayoutParams) ((C0470E0) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup b4 = C0413h.b(findViewById7, findViewById4);
        ViewGroup b5 = C0413h.b(findViewById8, findViewById5);
        ViewGroup b6 = C0413h.b(findViewById9, findViewById6);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c0413h.f4983r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c0413h.f4983r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) b5.findViewById(android.R.id.message);
        c0413h.f4987v = textView;
        if (textView != null) {
            String str = c0413h.f4971e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                c0413h.f4983r.removeView(c0413h.f4987v);
                if (c0413h.f4972f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) c0413h.f4983r.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(c0413h.f4983r);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(c0413h.f4972f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    b5.setVisibility(8);
                }
            }
        }
        Button button = (Button) b6.findViewById(android.R.id.button1);
        c0413h.f4975i = button;
        ViewOnClickListenerC0408c viewOnClickListenerC0408c = c0413h.f4966F;
        button.setOnClickListener(viewOnClickListenerC0408c);
        if (TextUtils.isEmpty(c0413h.f4976j)) {
            c0413h.f4975i.setVisibility(8);
            i4 = 0;
        } else {
            c0413h.f4975i.setText(c0413h.f4976j);
            c0413h.f4975i.setVisibility(0);
            i4 = 1;
        }
        Button button2 = (Button) b6.findViewById(android.R.id.button2);
        c0413h.f4977l = button2;
        button2.setOnClickListener(viewOnClickListenerC0408c);
        if (TextUtils.isEmpty(c0413h.f4978m)) {
            c0413h.f4977l.setVisibility(8);
        } else {
            c0413h.f4977l.setText(c0413h.f4978m);
            c0413h.f4977l.setVisibility(0);
            i4 |= 2;
        }
        Button button3 = (Button) b6.findViewById(android.R.id.button3);
        c0413h.f4980o = button3;
        button3.setOnClickListener(viewOnClickListenerC0408c);
        if (TextUtils.isEmpty(c0413h.f4981p)) {
            c0413h.f4980o.setVisibility(8);
        } else {
            c0413h.f4980o.setText(c0413h.f4981p);
            c0413h.f4980o.setVisibility(0);
            i4 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i4 == 1) {
                Button button4 = c0413h.f4975i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i4 == 2) {
                Button button5 = c0413h.f4977l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i4 == 4) {
                Button button6 = c0413h.f4980o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i4 == 0) {
            b6.setVisibility(8);
        }
        if (c0413h.f4988w != null) {
            b4.addView(c0413h.f4988w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c0413h.f4985t = (ImageView) window.findViewById(android.R.id.icon);
            if (!TextUtils.isEmpty(c0413h.f4970d) && c0413h.f4964D) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c0413h.f4986u = textView2;
                textView2.setText(c0413h.f4970d);
                Drawable drawable = c0413h.f4984s;
                if (drawable != null) {
                    c0413h.f4985t.setImageDrawable(drawable);
                } else {
                    c0413h.f4986u.setPadding(c0413h.f4985t.getPaddingLeft(), c0413h.f4985t.getPaddingTop(), c0413h.f4985t.getPaddingRight(), c0413h.f4985t.getPaddingBottom());
                    c0413h.f4985t.setVisibility(8);
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                c0413h.f4985t.setVisibility(8);
                b4.setVisibility(8);
            }
        }
        if (viewGroup.getVisibility() != 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (b4 != null && b4.getVisibility() != 8) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (b6.getVisibility() != 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && (findViewById2 = b5.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (i5 != 0) {
            NestedScrollView nestedScrollView2 = c0413h.f4983r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (c0413h.f4971e == null && c0413h.f4972f == null) {
                findViewById = null;
            } else {
                findViewById = b4.findViewById(R.id.titleDividerNoCustom);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else {
            View findViewById10 = b5.findViewById(R.id.textSpacerNoTitle);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c0413h.f4972f;
        if (alertController$RecycleListView != null && (!z4 || i5 == 0)) {
            int paddingLeft = alertController$RecycleListView.getPaddingLeft();
            if (i5 != 0) {
                i6 = alertController$RecycleListView.getPaddingTop();
            } else {
                i6 = alertController$RecycleListView.f2260f;
            }
            int paddingRight = alertController$RecycleListView.getPaddingRight();
            if (z4) {
                i7 = alertController$RecycleListView.getPaddingBottom();
            } else {
                i7 = alertController$RecycleListView.f2261g;
            }
            alertController$RecycleListView.setPadding(paddingLeft, i6, paddingRight, i7);
        }
        if (!z3) {
            View view = c0413h.f4972f;
            if (view == null) {
                view = c0413h.f4983r;
            }
            if (view != null) {
                if (z4) {
                    i8 = 2;
                }
                View findViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View findViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = T.f702a;
                view.setScrollIndicators(i5 | i8, 3);
                if (findViewById11 != null) {
                    b5.removeView(findViewById11);
                }
                if (findViewById12 != null) {
                    b5.removeView(findViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c0413h.f4972f;
        if (alertController$RecycleListView2 != null && (listAdapter = c0413h.f4989x) != null) {
            alertController$RecycleListView2.setAdapter(listAdapter);
            int i9 = c0413h.f4990y;
            if (i9 > -1) {
                alertController$RecycleListView2.setItemChecked(i9, true);
                alertController$RecycleListView2.setSelection(i9);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4992l.f4983r;
        if (nestedScrollView != null && nestedScrollView.d(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4992l.f4983r;
        if (nestedScrollView != null && nestedScrollView.d(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // e.n, android.app.Dialog
    public final void onStop() {
        super.onStop();
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) c();
        layoutInflaterFactory2C0393A.B();
        AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
        if (abstractC0406a != null) {
            abstractC0406a.q(false);
        }
    }

    @Override // j.InterfaceC0417l
    public final AbstractC0438b onWindowStartingSupportActionMode(InterfaceC0437a interfaceC0437a) {
        return null;
    }

    @Override // e.n, android.app.Dialog
    public final void setContentView(int i4) {
        c().j(i4);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i4) {
        super.setTitle(i4);
        c().m(getContext().getString(i4));
    }

    @Override // e.n, android.app.Dialog
    public final void setContentView(View view) {
        c().k(view);
    }

    @Override // e.n, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().l(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        f(charSequence);
        C0413h c0413h = this.f4992l;
        c0413h.f4970d = charSequence;
        TextView textView = c0413h.f4986u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // j.InterfaceC0417l
    public final void onSupportActionModeFinished(AbstractC0438b abstractC0438b) {
    }

    @Override // j.InterfaceC0417l
    public final void onSupportActionModeStarted(AbstractC0438b abstractC0438b) {
    }
}
