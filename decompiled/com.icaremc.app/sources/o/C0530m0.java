package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: o.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0530m0 {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f5642l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f5643m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f5644a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5645b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f5646c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f5647d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f5648e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f5649f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f5650g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f5651h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f5652i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f5653j;
    public final C0524j0 k;

    static {
        new ConcurrentHashMap();
    }

    public C0530m0(TextView textView) {
        this.f5652i = textView;
        this.f5653j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.k = new C0526k0();
        } else {
            this.k = new C0524j0();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i4 : iArr) {
                if (i4 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i4)) < 0) {
                    arrayList.add(Integer.valueOf(i4));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i5 = 0; i5 < size; i5++) {
                    iArr2[i5] = ((Integer) arrayList.get(i5)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f5643m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
                return method;
            }
            return method;
        } catch (Exception e4) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e4);
            return null;
        }
    }

    public static Object e(Object obj, String str, Object obj2) {
        try {
            return d(str).invoke(obj, null);
        } catch (Exception e4) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e4);
            return obj2;
        }
    }

    public final void a() {
        int measuredWidth;
        if (f()) {
            if (this.f5645b) {
                if (this.f5652i.getMeasuredHeight() > 0 && this.f5652i.getMeasuredWidth() > 0) {
                    if (this.k.b(this.f5652i)) {
                        measuredWidth = 1048576;
                    } else {
                        measuredWidth = (this.f5652i.getMeasuredWidth() - this.f5652i.getTotalPaddingLeft()) - this.f5652i.getTotalPaddingRight();
                    }
                    int height = (this.f5652i.getHeight() - this.f5652i.getCompoundPaddingBottom()) - this.f5652i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f5642l;
                        synchronized (rectF) {
                            try {
                                rectF.setEmpty();
                                rectF.right = measuredWidth;
                                rectF.bottom = height;
                                float c4 = c(rectF);
                                if (c4 != this.f5652i.getTextSize()) {
                                    g(0, c4);
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
            this.f5645b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence charSequence;
        CharSequence transformation;
        int length = this.f5649f.length;
        if (length != 0) {
            int i4 = length - 1;
            int i5 = 0;
            int i6 = 1;
            while (i6 <= i4) {
                int i7 = (i6 + i4) / 2;
                int i8 = this.f5649f[i7];
                TextView textView = this.f5652i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    charSequence = transformation;
                } else {
                    charSequence = text;
                }
                int b4 = AbstractC0518g0.b(textView);
                TextPaint textPaint = this.f5651h;
                if (textPaint == null) {
                    this.f5651h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f5651h.set(textView.getPaint());
                this.f5651h.setTextSize(i8);
                StaticLayout a4 = AbstractC0522i0.a(charSequence, (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b4, this.f5652i, this.f5651h, this.k);
                if ((b4 != -1 && (a4.getLineCount() > b4 || a4.getLineEnd(a4.getLineCount() - 1) != charSequence.length())) || a4.getHeight() > rectF.bottom) {
                    i5 = i7 - 1;
                    i4 = i5;
                } else {
                    int i9 = i7 + 1;
                    i5 = i6;
                    i6 = i9;
                }
            }
            return this.f5649f[i5];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final boolean f() {
        if (j() && this.f5644a != 0) {
            return true;
        }
        return false;
    }

    public final void g(int i4, float f4) {
        Resources resources;
        Context context = this.f5653j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i4, f4, resources.getDisplayMetrics());
        TextView textView = this.f5652i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean a4 = AbstractC0520h0.a(textView);
            if (textView.getLayout() != null) {
                this.f5645b = false;
                try {
                    Method d4 = d("nullLayouts");
                    if (d4 != null) {
                        d4.invoke(textView, null);
                    }
                } catch (Exception e4) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e4);
                }
                if (!a4) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f5644a == 1) {
            if (!this.f5650g || this.f5649f.length == 0) {
                int floor = ((int) Math.floor((this.f5648e - this.f5647d) / this.f5646c)) + 1;
                int[] iArr = new int[floor];
                for (int i4 = 0; i4 < floor; i4++) {
                    iArr[i4] = Math.round((i4 * this.f5646c) + this.f5647d);
                }
                this.f5649f = b(iArr);
            }
            this.f5645b = true;
        } else {
            this.f5645b = false;
        }
        return this.f5645b;
    }

    public final boolean i() {
        boolean z;
        if (this.f5649f.length > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f5650g = z;
        if (z) {
            this.f5644a = 1;
            this.f5647d = r0[0];
            this.f5648e = r0[r1 - 1];
            this.f5646c = -1.0f;
        }
        return z;
    }

    public final boolean j() {
        return !(this.f5652i instanceof C0547v);
    }

    public final void k(float f4, float f5, float f6) {
        if (f4 > 0.0f) {
            if (f5 > f4) {
                if (f6 > 0.0f) {
                    this.f5644a = 1;
                    this.f5647d = f4;
                    this.f5648e = f5;
                    this.f5646c = f6;
                    this.f5650g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f6 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f5 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
    }
}
