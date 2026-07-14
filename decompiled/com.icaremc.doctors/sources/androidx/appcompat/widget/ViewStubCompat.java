package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import h.AbstractC0201a;
import java.lang.ref.WeakReference;
import m.t0;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: c, reason: collision with root package name */
    public int f1251c;

    /* renamed from: d, reason: collision with root package name */
    public int f1252d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference f1253e;

    /* renamed from: f, reason: collision with root package name */
    public LayoutInflater f1254f;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1251c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.f2317v, 0, 0);
        this.f1252d = obtainStyledAttributes.getResourceId(2, -1);
        this.f1251c = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1252d;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1254f;
    }

    public int getLayoutResource() {
        return this.f1251c;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i2) {
        this.f1252d = i2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1254f = layoutInflater;
    }

    public void setLayoutResource(int i2) {
        this.f1251c = i2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        WeakReference weakReference = this.f1253e;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i2);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i2);
        if (i2 != 0 && i2 != 4) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f1251c != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f1254f;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f1251c, viewGroup, false);
                int i3 = this.f1252d;
                if (i3 != -1) {
                    inflate.setId(i3);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f1253e = new WeakReference(inflate);
                return;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(t0 t0Var) {
    }
}
