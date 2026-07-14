package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: m.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0274v {

    /* renamed from: k, reason: collision with root package name */
    public static final RectF f3267k = new RectF();

    /* renamed from: l, reason: collision with root package name */
    public static final ConcurrentHashMap f3268l = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f3269a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3270b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f3271c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f3272d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f3273e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f3274f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f3275g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f3276h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f3277i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f3278j;

    static {
        new ConcurrentHashMap();
    }

    public C0274v(TextView textView) {
        this.f3277i = textView;
        this.f3278j = textView.getContext();
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f3268l;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
                return method;
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    public static Object e(Object obj, String str, Object obj2) {
        try {
            return d(str).invoke(obj, null);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return obj2;
        }
    }

    public final void a() {
        boolean booleanValue;
        int measuredWidth;
        if (this.f3269a != 0) {
            if (this.f3270b) {
                if (this.f3277i.getMeasuredHeight() > 0 && this.f3277i.getMeasuredWidth() > 0) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        booleanValue = this.f3277i.isHorizontallyScrollable();
                    } else {
                        booleanValue = ((Boolean) e(this.f3277i, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
                    }
                    if (booleanValue) {
                        measuredWidth = 1048576;
                    } else {
                        measuredWidth = (this.f3277i.getMeasuredWidth() - this.f3277i.getTotalPaddingLeft()) - this.f3277i.getTotalPaddingRight();
                    }
                    int height = (this.f3277i.getHeight() - this.f3277i.getCompoundPaddingBottom()) - this.f3277i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f3267k;
                        synchronized (rectF) {
                            try {
                                rectF.setEmpty();
                                rectF.right = measuredWidth;
                                rectF.bottom = height;
                                float c2 = c(rectF);
                                if (c2 != this.f3277i.getTextSize()) {
                                    f(0, c2);
                                }
                            } finally {
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f3270b = true;
        }
    }

    public final int c(RectF rectF) {
        int i2;
        TextDirectionHeuristic textDirectionHeuristic;
        CharSequence transformation;
        int length = this.f3274f.length;
        if (length != 0) {
            int i3 = length - 1;
            int i4 = 1;
            int i5 = 0;
            while (i4 <= i3) {
                int i6 = (i4 + i3) / 2;
                int i7 = this.f3274f[i6];
                TextView textView = this.f3277i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    text = transformation;
                }
                int i8 = Build.VERSION.SDK_INT;
                int maxLines = textView.getMaxLines();
                TextPaint textPaint = this.f3276h;
                if (textPaint == null) {
                    this.f3276h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f3276h.set(textView.getPaint());
                this.f3276h.setTextSize(i7);
                Layout.Alignment alignment = (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(text, 0, text.length(), this.f3276h, Math.round(rectF.right));
                StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
                if (maxLines == -1) {
                    i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i2 = maxLines;
                }
                hyphenationFrequency.setMaxLines(i2);
                if (i8 >= 29) {
                    try {
                        textDirectionHeuristic = textView.getTextDirectionHeuristic();
                    } catch (ClassCastException unused) {
                        Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
                    }
                } else {
                    textDirectionHeuristic = (TextDirectionHeuristic) e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
                }
                obtain.setTextDirection(textDirectionHeuristic);
                StaticLayout build = obtain.build();
                if ((maxLines != -1 && (build.getLineCount() > maxLines || build.getLineEnd(build.getLineCount() - 1) != text.length())) || build.getHeight() > rectF.bottom) {
                    i5 = i6 - 1;
                    i3 = i5;
                } else {
                    int i9 = i6 + 1;
                    i5 = i4;
                    i4 = i9;
                }
            }
            return this.f3274f[i5];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final void f(int i2, float f2) {
        Resources resources;
        Context context = this.f3278j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics());
        TextView textView = this.f3277i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.f3270b = false;
                try {
                    Method d2 = d("nullLayouts");
                    if (d2 != null) {
                        d2.invoke(textView, null);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean g() {
        if (this.f3269a == 1) {
            if (!this.f3275g || this.f3274f.length == 0) {
                int floor = ((int) Math.floor((this.f3273e - this.f3272d) / this.f3271c)) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round((i2 * this.f3271c) + this.f3272d);
                }
                this.f3274f = b(iArr);
            }
            this.f3270b = true;
        } else {
            this.f3270b = false;
        }
        return this.f3270b;
    }

    public final boolean h() {
        boolean z;
        if (this.f3274f.length > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3275g = z;
        if (z) {
            this.f3269a = 1;
            this.f3272d = r0[0];
            this.f3273e = r0[r1 - 1];
            this.f3271c = -1.0f;
        }
        return z;
    }

    public final void i(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            if (f3 > f2) {
                if (f4 > 0.0f) {
                    this.f3269a = 1;
                    this.f3272d = f2;
                    this.f3273e = f3;
                    this.f3271c = f4;
                    this.f3275g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
    }
}
