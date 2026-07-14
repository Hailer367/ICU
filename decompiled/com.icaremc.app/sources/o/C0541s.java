package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.HashMap;

/* renamed from: o.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0541s {

    /* renamed from: a, reason: collision with root package name */
    public Object f5692a = null;

    /* renamed from: b, reason: collision with root package name */
    public Object f5693b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5694c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5695d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5696e;

    /* renamed from: f, reason: collision with root package name */
    public Object f5697f;

    public /* synthetic */ C0541s(TextView textView) {
        this.f5697f = textView;
    }

    public static HashMap d(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f5697f;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f5694c || this.f5695d) {
                Drawable mutate = buttonDrawable.mutate();
                if (this.f5694c) {
                    mutate.setTintList((ColorStateList) this.f5692a);
                }
                if (this.f5695d) {
                    mutate.setTintMode((PorterDuff.Mode) this.f5693b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    public void b() {
        C0539r c0539r = (C0539r) this.f5697f;
        Drawable checkMarkDrawable = c0539r.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f5694c || this.f5695d) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.f5694c) {
                    mutate.setTintList((ColorStateList) this.f5692a);
                }
                if (this.f5695d) {
                    mutate.setTintMode((PorterDuff.Mode) this.f5693b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(c0539r.getDrawableState());
                }
                c0539r.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f5697f
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.content.Context r0 = r1.getContext()
            int[] r3 = i.AbstractC0357a.f4077m
            A2.t r7 = A2.t.P(r0, r9, r3, r10)
            java.lang.Object r0 = r7.f100h
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r1.getContext()
            java.lang.Object r4 = r7.f100h
            r5 = r4
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r4 = r9
            r6 = r10
            I.T.h(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            if (r10 == 0) goto L3e
            int r9 = r0.getResourceId(r9, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L3e
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            android.graphics.drawable.Drawable r9 = f1.AbstractC0286a.o(r10, r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            goto L55
        L3b:
            r0 = move-exception
            r9 = r0
            goto L7b
        L3e:
            boolean r9 = r0.hasValue(r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            int r9 = r0.getResourceId(r2, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b
            android.graphics.drawable.Drawable r9 = f1.AbstractC0286a.o(r10, r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b
        L55:
            r9 = 2
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L63
            android.content.res.ColorStateList r9 = r7.G(r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonTintList(r9)     // Catch: java.lang.Throwable -> L3b
        L63:
            r9 = 3
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L77
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = o.AbstractC0546u0.c(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonTintMode(r9)     // Catch: java.lang.Throwable -> L3b
        L77:
            r7.T()
            return
        L7b:
            r7.T()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0541s.c(android.util.AttributeSet, int):void");
    }
}
