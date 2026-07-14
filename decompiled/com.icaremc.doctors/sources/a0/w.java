package a0;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class w extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f1013a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1014b;

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1013a = new Rect();
        this.f1014b = true;
    }

    public w(int i2, int i3) {
        super(i2, i3);
        this.f1013a = new Rect();
        this.f1014b = true;
    }

    public w(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1013a = new Rect();
        this.f1014b = true;
    }

    public w(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f1013a = new Rect();
        this.f1014b = true;
    }

    public w(w wVar) {
        super((ViewGroup.LayoutParams) wVar);
        this.f1013a = new Rect();
        this.f1014b = true;
    }
}
