package h0;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: h0.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0334v extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3937a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3938b;

    public C0334v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3937a = new Rect();
        this.f3938b = true;
    }

    public C0334v(int i4, int i5) {
        super(i4, i5);
        this.f3937a = new Rect();
        this.f3938b = true;
    }

    public C0334v(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f3937a = new Rect();
        this.f3938b = true;
    }

    public C0334v(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f3937a = new Rect();
        this.f3938b = true;
    }

    public C0334v(C0334v c0334v) {
        super((ViewGroup.LayoutParams) c0334v);
        this.f3937a = new Rect();
        this.f3938b = true;
    }
}
