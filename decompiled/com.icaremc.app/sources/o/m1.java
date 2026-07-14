package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import f1.AbstractC0286a;
import i.AbstractC0357a;

/* loaded from: classes.dex */
public abstract class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f5654a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5655b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f5656c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f5657d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f5658e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f5659f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f5660g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(AbstractC0357a.f4075j);
        try {
            if (!obtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i4) {
        ColorStateList d4 = d(context, i4);
        if (d4 != null && d4.isStateful()) {
            return d4.getColorForState(f5655b, d4.getDefaultColor());
        }
        ThreadLocal threadLocal = f5654a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f4 = typedValue.getFloat();
        int c4 = c(context, i4);
        int round = Math.round(Color.alpha(c4) * f4);
        int i5 = B.a.f122a;
        if (round >= 0 && round <= 255) {
            return (c4 & 16777215) | (round << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static int c(Context context, int i4) {
        int[] iArr = f5660g;
        iArr[0] = i4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(Context context, int i4) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f5660g;
        iArr[0] = i4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = AbstractC0286a.n(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
