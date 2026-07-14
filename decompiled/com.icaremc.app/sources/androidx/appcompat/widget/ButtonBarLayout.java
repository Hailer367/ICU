package androidx.appcompat.widget;

import I.T;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.icaremc.app.R;
import i.AbstractC0357a;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    public boolean f2356f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2357g;

    /* renamed from: h, reason: collision with root package name */
    public int f2358h;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2358h = -1;
        int[] iArr = AbstractC0357a.k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        T.h(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        this.f2356f = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f2356f);
        }
    }

    private void setStacked(boolean z) {
        int i4;
        int i5;
        if (this.f2357g != z) {
            if (!z || this.f2356f) {
                this.f2357g = z;
                setOrientation(z ? 1 : 0);
                if (z) {
                    i4 = 8388613;
                } else {
                    i4 = 80;
                }
                setGravity(i4);
                View findViewById = findViewById(R.id.spacer);
                if (findViewById != null) {
                    if (z) {
                        i5 = 8;
                    } else {
                        i5 = 4;
                    }
                    findViewById.setVisibility(i5);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        boolean z;
        int i7;
        int size = View.MeasureSpec.getSize(i4);
        int i8 = 0;
        if (this.f2356f) {
            if (size > this.f2358h && this.f2357g) {
                setStacked(false);
            }
            this.f2358h = size;
        }
        if (!this.f2357g && View.MeasureSpec.getMode(i4) == 1073741824) {
            i6 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        } else {
            i6 = i4;
            z = false;
        }
        super.onMeasure(i6, i5);
        if (this.f2356f && !this.f2357g && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i4, i5);
        }
        int childCount = getChildCount();
        int i9 = 0;
        while (true) {
            i7 = -1;
            if (i9 < childCount) {
                if (getChildAt(i9).getVisibility() == 0) {
                    break;
                } else {
                    i9++;
                }
            } else {
                i9 = -1;
                break;
            }
        }
        if (i9 >= 0) {
            View childAt = getChildAt(i9);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f2357g) {
                int i10 = i9 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i10 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i10).getVisibility() == 0) {
                        i7 = i10;
                        break;
                    }
                    i10++;
                }
                if (i7 >= 0) {
                    i8 = getChildAt(i7).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight;
                } else {
                    i8 = measuredHeight;
                }
            } else {
                i8 = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = T.f702a;
        if (getMinimumHeight() != i8) {
            setMinimumHeight(i8);
            if (i5 == 0) {
                super.onMeasure(i4, i5);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f2356f != z) {
            this.f2356f = z;
            if (!z && this.f2357g) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
