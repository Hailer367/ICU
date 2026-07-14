package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import h.AbstractC0201a;

/* renamed from: m.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0251D extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public final float f3043a;

    /* renamed from: b, reason: collision with root package name */
    public int f3044b;

    public C0251D(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3044b = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.f2307j);
        this.f3043a = obtainStyledAttributes.getFloat(3, 0.0f);
        this.f3044b = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }

    public C0251D(int i2) {
        super(i2, -2);
        this.f3044b = -1;
        this.f3043a = 0.0f;
    }

    public C0251D(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f3044b = -1;
    }
}
