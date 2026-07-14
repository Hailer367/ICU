package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import m.InterfaceC0275w;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f1135c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f1136d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f1137e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f1138f;

    /* renamed from: g, reason: collision with root package name */
    public TypedValue f1139g;

    /* renamed from: h, reason: collision with root package name */
    public TypedValue f1140h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f1141i;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1141i = new Rect();
    }

    public final void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1139g == null) {
            this.f1139g = new TypedValue();
        }
        return this.f1139g;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1140h == null) {
            this.f1140h = new TypedValue();
        }
        return this.f1140h;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1137e == null) {
            this.f1137e = new TypedValue();
        }
        return this.f1137e;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1138f == null) {
            this.f1138f = new TypedValue();
        }
        return this.f1138f;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1135c == null) {
            this.f1135c = new TypedValue();
        }
        return this.f1135c;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1136d == null) {
            this.f1136d = new TypedValue();
        }
        return this.f1136d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
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

    public void setAttachListener(InterfaceC0275w interfaceC0275w) {
    }
}
