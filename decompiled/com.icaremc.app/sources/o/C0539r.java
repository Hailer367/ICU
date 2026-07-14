package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import f1.AbstractC0286a;

/* renamed from: o.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0539r extends CheckedTextView {

    /* renamed from: f, reason: collision with root package name */
    public final C0541s f5688f;

    /* renamed from: g, reason: collision with root package name */
    public final C0533o f5689g;

    /* renamed from: h, reason: collision with root package name */
    public final C0507c0 f5690h;

    /* renamed from: i, reason: collision with root package name */
    public C0549w f5691i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0085 A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:3:0x004b, B:5:0x0052, B:8:0x0058, B:9:0x007e, B:11:0x0085, B:12:0x008c, B:14:0x0093, B:21:0x0067, B:23:0x006d, B:25:0x0073), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #1 {all -> 0x0064, blocks: (B:3:0x004b, B:5:0x0052, B:8:0x0058, B:9:0x007e, B:11:0x0085, B:12:0x008c, B:14:0x0093, B:21:0x0067, B:23:0x006d, B:25:0x0073), top: B:2:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0539r(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            o.n1.a(r8)
            r6 = 2130903125(0x7f030055, float:1.741306E38)
            r7.<init>(r8, r9, r6)
            android.content.Context r8 = r7.getContext()
            o.m1.a(r7, r8)
            o.c0 r8 = new o.c0
            r8.<init>(r7)
            r7.f5690h = r8
            r8.f(r9, r6)
            r8.b()
            o.o r8 = new o.o
            r8.<init>(r7)
            r7.f5689g = r8
            r8.d(r9, r6)
            o.s r8 = new o.s
            r8.<init>(r7)
            r7.f5688f = r8
            android.content.Context r8 = r7.getContext()
            int[] r3 = i.AbstractC0357a.f4076l
            A2.t r8 = A2.t.P(r8, r9, r3, r6)
            java.lang.Object r0 = r8.f100h
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r7.getContext()
            java.lang.Object r1 = r8.f100h
            r5 = r1
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r1 = r7
            r4 = r9
            I.T.h(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r2 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L64
            r3 = 0
            if (r2 == 0) goto L67
            int r9 = r0.getResourceId(r9, r3)     // Catch: java.lang.Throwable -> L64
            if (r9 == 0) goto L67
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> L64 android.content.res.Resources.NotFoundException -> L67
            android.graphics.drawable.Drawable r9 = f1.AbstractC0286a.o(r2, r9)     // Catch: java.lang.Throwable -> L64 android.content.res.Resources.NotFoundException -> L67
            r7.setCheckMarkDrawable(r9)     // Catch: java.lang.Throwable -> L64 android.content.res.Resources.NotFoundException -> L67
            goto L7e
        L64:
            r0 = move-exception
            r9 = r0
            goto Lab
        L67:
            boolean r9 = r0.hasValue(r3)     // Catch: java.lang.Throwable -> L64
            if (r9 == 0) goto L7e
            int r9 = r0.getResourceId(r3, r3)     // Catch: java.lang.Throwable -> L64
            if (r9 == 0) goto L7e
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> L64
            android.graphics.drawable.Drawable r9 = f1.AbstractC0286a.o(r2, r9)     // Catch: java.lang.Throwable -> L64
            r7.setCheckMarkDrawable(r9)     // Catch: java.lang.Throwable -> L64
        L7e:
            r9 = 2
            boolean r2 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L8c
            android.content.res.ColorStateList r9 = r8.G(r9)     // Catch: java.lang.Throwable -> L64
            r7.setCheckMarkTintList(r9)     // Catch: java.lang.Throwable -> L64
        L8c:
            r9 = 3
            boolean r2 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto La0
            r2 = -1
            int r9 = r0.getInt(r9, r2)     // Catch: java.lang.Throwable -> L64
            r0 = 0
            android.graphics.PorterDuff$Mode r9 = o.AbstractC0546u0.c(r9, r0)     // Catch: java.lang.Throwable -> L64
            r7.setCheckMarkTintMode(r9)     // Catch: java.lang.Throwable -> L64
        La0:
            r8.T()
            o.w r8 = r7.getEmojiTextViewHelper()
            r8.b(r4, r6)
            return
        Lab:
            r8.T()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0539r.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private C0549w getEmojiTextViewHelper() {
        if (this.f5691i == null) {
            this.f5691i = new C0549w(this);
        }
        return this.f5691i;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0507c0 c0507c0 = this.f5690h;
        if (c0507c0 != null) {
            c0507c0.b();
        }
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            c0533o.a();
        }
        C0541s c0541s = this.f5688f;
        if (c0541s != null) {
            c0541s.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0286a.M(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0541s c0541s = this.f5688f;
        if (c0541s != null) {
            return (ColorStateList) c0541s.f5692a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0541s c0541s = this.f5688f;
        if (c0541s != null) {
            return (PorterDuff.Mode) c0541s.f5693b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5690h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5690h.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        android.support.v4.media.session.a.q(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0541s c0541s = this.f5688f;
        if (c0541s != null) {
            if (c0541s.f5696e) {
                c0541s.f5696e = false;
            } else {
                c0541s.f5696e = true;
                c0541s.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5690h;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0507c0 c0507c0 = this.f5690h;
        if (c0507c0 != null) {
            c0507c0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0286a.N(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5689g;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0541s c0541s = this.f5688f;
        if (c0541s != null) {
            c0541s.f5692a = colorStateList;
            c0541s.f5694c = true;
            c0541s.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0541s c0541s = this.f5688f;
        if (c0541s != null) {
            c0541s.f5693b = mode;
            c0541s.f5695d = true;
            c0541s.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0507c0 c0507c0 = this.f5690h;
        c0507c0.l(colorStateList);
        c0507c0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0507c0 c0507c0 = this.f5690h;
        c0507c0.m(mode);
        c0507c0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0507c0 c0507c0 = this.f5690h;
        if (c0507c0 != null) {
            c0507c0.g(context, i4);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i4) {
        setCheckMarkDrawable(AbstractC0286a.o(getContext(), i4));
    }
}
