package androidx.appcompat.widget;

import I.Y;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import j.LayoutInflaterFactory2C0393A;
import j.r;
import n.n;
import o.C0515f;
import o.C0523j;
import o.InterfaceC0534o0;
import o.InterfaceC0536p0;
import o.x1;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f2359f;

    /* renamed from: g, reason: collision with root package name */
    public TypedValue f2360g;

    /* renamed from: h, reason: collision with root package name */
    public TypedValue f2361h;

    /* renamed from: i, reason: collision with root package name */
    public TypedValue f2362i;

    /* renamed from: j, reason: collision with root package name */
    public TypedValue f2363j;
    public TypedValue k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f2364l;

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC0534o0 f2365m;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2364l = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2363j == null) {
            this.f2363j = new TypedValue();
        }
        return this.f2363j;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.k == null) {
            this.k = new TypedValue();
        }
        return this.k;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2361h == null) {
            this.f2361h = new TypedValue();
        }
        return this.f2361h;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2362i == null) {
            this.f2362i = new TypedValue();
        }
        return this.f2362i;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2359f == null) {
            this.f2359f = new TypedValue();
        }
        return this.f2359f;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2360g == null) {
            this.f2360g = new TypedValue();
        }
        return this.f2360g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0534o0 interfaceC0534o0 = this.f2365m;
        if (interfaceC0534o0 != null) {
            interfaceC0534o0.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0523j c0523j;
        super.onDetachedFromWindow();
        InterfaceC0534o0 interfaceC0534o0 = this.f2365m;
        if (interfaceC0534o0 != null) {
            LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = ((r) interfaceC0534o0).f5005f;
            InterfaceC0536p0 interfaceC0536p0 = layoutInflaterFactory2C0393A.f4871w;
            if (interfaceC0536p0 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0536p0;
                actionBarOverlayLayout.e();
                ActionMenuView actionMenuView = ((x1) actionBarOverlayLayout.f2329j).f5734a.f2474f;
                if (actionMenuView != null && (c0523j = actionMenuView.f2354y) != null) {
                    c0523j.c();
                    C0515f c0515f = c0523j.f5619y;
                    if (c0515f != null && c0515f.b()) {
                        c0515f.f5369i.dismiss();
                    }
                }
            }
            if (layoutInflaterFactory2C0393A.f4827B != null) {
                layoutInflaterFactory2C0393A.f4865q.getDecorView().removeCallbacks(layoutInflaterFactory2C0393A.f4828C);
                if (layoutInflaterFactory2C0393A.f4827B.isShowing()) {
                    try {
                        layoutInflaterFactory2C0393A.f4827B.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                layoutInflaterFactory2C0393A.f4827B = null;
            }
            Y y3 = layoutInflaterFactory2C0393A.f4829D;
            if (y3 != null) {
                y3.b();
            }
            n nVar = layoutInflaterFactory2C0393A.A(0).f5026h;
            if (nVar != null) {
                nVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC0534o0 interfaceC0534o0) {
        this.f2365m = interfaceC0534o0;
    }
}
