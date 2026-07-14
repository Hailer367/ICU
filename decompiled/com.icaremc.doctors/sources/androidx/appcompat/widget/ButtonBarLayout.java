package androidx.appcompat.widget;

import E.J;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.icaremc.doctors.R;
import h.AbstractC0201a;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public boolean f1133c;

    /* renamed from: d, reason: collision with root package name */
    public int f1134d;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1134d = -1;
        int[] iArr = AbstractC0201a.f2305h;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        this.f1133c = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    private void setStacked(boolean z) {
        int i2;
        int i3;
        setOrientation(z ? 1 : 0);
        if (z) {
            i2 = 5;
        } else {
            i2 = 80;
        }
        setGravity(i2);
        View findViewById = findViewById(R.id.spacer);
        if (findViewById != null) {
            if (z) {
                i3 = 8;
            } else {
                i3 = 4;
            }
            findViewById.setVisibility(i3);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(0, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        int size = View.MeasureSpec.getSize(i2);
        int i6 = 0;
        if (this.f1133c) {
            if (size > this.f1134d && getOrientation() == 1) {
                setStacked(false);
            }
            this.f1134d = size;
        }
        if (getOrientation() != 1 && View.MeasureSpec.getMode(i2) == 1073741824) {
            i4 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        } else {
            i4 = i2;
            z = false;
        }
        super.onMeasure(i4, i3);
        if (this.f1133c && getOrientation() != 1 && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            i5 = -1;
            if (i7 < childCount) {
                if (getChildAt(i7).getVisibility() == 0) {
                    break;
                } else {
                    i7++;
                }
            } else {
                i7 = -1;
                break;
            }
        }
        if (i7 >= 0) {
            View childAt = getChildAt(i7);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (getOrientation() == 1) {
                i6 = 1;
            }
            if (i6 != 0) {
                int i8 = i7 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i8 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i8).getVisibility() == 0) {
                        i5 = i8;
                        break;
                    }
                    i8++;
                }
                if (i5 >= 0) {
                    i6 = getChildAt(i5).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight;
                } else {
                    i6 = measuredHeight;
                }
            } else {
                i6 = getPaddingBottom() + measuredHeight;
            }
        }
        Field field = J.f180a;
        if (getMinimumHeight() != i6) {
            setMinimumHeight(i6);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f1133c != z) {
            this.f1133c = z;
            if (!z && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
