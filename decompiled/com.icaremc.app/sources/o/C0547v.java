package o;

import I.C0050d;
import I.C0052f;
import I.InterfaceC0049c;
import I.InterfaceC0067v;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.icaremc.app.R;
import f1.AbstractC0286a;

/* renamed from: o.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0547v extends EditText implements InterfaceC0067v {

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5716f;

    /* renamed from: g, reason: collision with root package name */
    public final C0507c0 f5717g;

    /* renamed from: h, reason: collision with root package name */
    public final C0465C f5718h;

    /* renamed from: i, reason: collision with root package name */
    public final L.j f5719i;

    /* renamed from: j, reason: collision with root package name */
    public final C0465C f5720j;
    public C0545u k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v5, types: [L.j, java.lang.Object] */
    public C0547v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        n1.a(context);
        m1.a(this, getContext());
        C0533o c0533o = new C0533o(this);
        this.f5716f = c0533o;
        c0533o.d(attributeSet, R.attr.editTextStyle);
        C0507c0 c0507c0 = new C0507c0(this);
        this.f5717g = c0507c0;
        c0507c0.f(attributeSet, R.attr.editTextStyle);
        c0507c0.b();
        C0465C c0465c = new C0465C();
        c0465c.f5422b = this;
        this.f5718h = c0465c;
        this.f5719i = new Object();
        C0465C c0465c2 = new C0465C(this);
        this.f5720j = c0465c2;
        c0465c2.b(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = isFocusable();
            boolean isClickable = isClickable();
            boolean isLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener a4 = c0465c2.a(keyListener);
            if (a4 != keyListener) {
                super.setKeyListener(a4);
                setRawInputType(inputType);
                setFocusable(isFocusable);
                setClickable(isClickable);
                setLongClickable(isLongClickable);
            }
        }
    }

    private C0545u getSuperCaller() {
        if (this.k == null) {
            this.k = new C0545u(this);
        }
        return this.k;
    }

    @Override // I.InterfaceC0067v
    public final C0052f a(C0052f c0052f) {
        this.f5719i.getClass();
        return L.j.a(this, c0052f);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            c0533o.a();
        }
        C0507c0 c0507c0 = this.f5717g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0286a.M(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5717g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5717g.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0465C c0465c;
        if (Build.VERSION.SDK_INT < 28 && (c0465c = this.f5718h) != null) {
            TextClassifier textClassifier = (TextClassifier) c0465c.f5423c;
            if (textClassifier == null) {
                return AbstractC0495V.a((TextView) c0465c.f5422b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r1 != null) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r6) {
        /*
            r5 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r6)
            o.c0 r1 = r5.f5717g
            r1.getClass()
            o.C0507c0.h(r6, r0, r5)
            android.support.v4.media.session.a.q(r6, r0, r5)
            if (r0 == 0) goto L5f
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L5f
            java.lang.String[] r2 = I.T.e(r5)
            if (r2 == 0) goto L5f
            K.d.a(r6, r2)
            D2.J r2 = new D2.J
            r3 = 6
            r2.<init>(r3, r5)
            r3 = 25
            if (r1 < r3) goto L31
            K.e r1 = new K.e
            r1.<init>(r0, r2)
        L2f:
            r0 = r1
            goto L5f
        L31:
            java.lang.String[] r4 = K.d.f902a
            if (r1 < r3) goto L3d
            java.lang.String[] r1 = K.a.e(r6)
            if (r1 == 0) goto L55
        L3b:
            r4 = r1
            goto L55
        L3d:
            android.os.Bundle r1 = r6.extras
            if (r1 != 0) goto L42
            goto L55
        L42:
            java.lang.String r3 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r1 = r1.getStringArray(r3)
            if (r1 != 0) goto L52
            android.os.Bundle r1 = r6.extras
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r1 = r1.getStringArray(r3)
        L52:
            if (r1 == 0) goto L55
            goto L3b
        L55:
            int r1 = r4.length
            if (r1 != 0) goto L59
            goto L5f
        L59:
            K.f r1 = new K.f
            r1.<init>(r0, r2)
            goto L2f
        L5f:
            o.C r1 = r5.f5720j
            V.b r6 = r1.c(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0547v.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && I.T.e(this) != null) {
            Context context = getContext();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = AbstractC0471F.a(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i4) {
        ClipData primaryClip;
        InterfaceC0049c interfaceC0049c;
        int i5;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 31 && I.T.e(this) != null && (i4 == 16908322 || i4 == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                primaryClip = null;
            } else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                if (i6 >= 31) {
                    interfaceC0049c = new R1.c(primaryClip, 1);
                } else {
                    C0050d c0050d = new C0050d();
                    c0050d.f725g = primaryClip;
                    c0050d.f726h = 1;
                    interfaceC0049c = c0050d;
                }
                if (i4 == 16908322) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                interfaceC0049c.e(i5);
                I.T.g(this, interfaceC0049c.build());
            }
            return true;
        }
        return super.onTextContextMenuItem(i4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5717g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5717g;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0286a.N(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f5720j.d(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f5720j.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5716f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5717g;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5717g;
        c0507c0.m(mode);
        c0507c0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0507c0 c0507c0 = this.f5717g;
        if (c0507c0 != null) {
            c0507c0.g(context, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C0465C c0465c;
        if (Build.VERSION.SDK_INT < 28 && (c0465c = this.f5718h) != null) {
            c0465c.f5423c = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return getEditableText();
    }
}
