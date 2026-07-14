package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: o.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0507c0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5561a;

    /* renamed from: b, reason: collision with root package name */
    public o1 f5562b;

    /* renamed from: c, reason: collision with root package name */
    public o1 f5563c;

    /* renamed from: d, reason: collision with root package name */
    public o1 f5564d;

    /* renamed from: e, reason: collision with root package name */
    public o1 f5565e;

    /* renamed from: f, reason: collision with root package name */
    public o1 f5566f;

    /* renamed from: g, reason: collision with root package name */
    public o1 f5567g;

    /* renamed from: h, reason: collision with root package name */
    public o1 f5568h;

    /* renamed from: i, reason: collision with root package name */
    public final C0530m0 f5569i;

    /* renamed from: j, reason: collision with root package name */
    public int f5570j = 0;
    public int k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f5571l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5572m;

    public C0507c0(TextView textView) {
        this.f5561a = textView;
        this.f5569i = new C0530m0(textView);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [o.o1, java.lang.Object] */
    public static o1 c(Context context, C0543t c0543t, int i4) {
        ColorStateList f4;
        synchronized (c0543t) {
            f4 = c0543t.f5709a.f(context, i4);
        }
        if (f4 != null) {
            ?? obj = new Object();
            obj.f5678d = true;
            obj.f5675a = f4;
            return obj;
        }
        return null;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i4;
        int i5;
        CharSequence subSequence;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i6 >= 30) {
                K.b.a(editorInfo, text);
                return;
            }
            text.getClass();
            if (i6 >= 30) {
                K.b.a(editorInfo, text);
                return;
            }
            int i7 = editorInfo.initialSelStart;
            int i8 = editorInfo.initialSelEnd;
            if (i7 > i8) {
                i4 = i8;
            } else {
                i4 = i7;
            }
            if (i7 <= i8) {
                i7 = i8;
            }
            int length = text.length();
            if (i4 >= 0 && i7 <= length) {
                int i9 = editorInfo.inputType & 4095;
                if (i9 != 129 && i9 != 225 && i9 != 18) {
                    if (length <= 2048) {
                        K.d.b(editorInfo, text, i4, i7);
                        return;
                    }
                    int i10 = i7 - i4;
                    if (i10 > 1024) {
                        i5 = 0;
                    } else {
                        i5 = i10;
                    }
                    int i11 = 2048 - i5;
                    int min = Math.min(text.length() - i7, i11 - Math.min(i4, (int) (i11 * 0.8d)));
                    int min2 = Math.min(i4, i11 - min);
                    int i12 = i4 - min2;
                    if (Character.isLowSurrogate(text.charAt(i12))) {
                        i12++;
                        min2--;
                    }
                    if (Character.isHighSurrogate(text.charAt((i7 + min) - 1))) {
                        min--;
                    }
                    int i13 = min2 + i5;
                    int i14 = i13 + min;
                    if (i5 != i10) {
                        subSequence = TextUtils.concat(text.subSequence(i12, i12 + min2), text.subSequence(i7, min + i7));
                    } else {
                        subSequence = text.subSequence(i12, i14 + i12);
                    }
                    K.d.b(editorInfo, subSequence, min2, i13);
                    return;
                }
                K.d.b(editorInfo, null, 0, 0);
                return;
            }
            K.d.b(editorInfo, null, 0, 0);
        }
    }

    public final void a(Drawable drawable, o1 o1Var) {
        if (drawable != null && o1Var != null) {
            C0543t.d(drawable, o1Var, this.f5561a.getDrawableState());
        }
    }

    public final void b() {
        o1 o1Var = this.f5562b;
        TextView textView = this.f5561a;
        if (o1Var != null || this.f5563c != null || this.f5564d != null || this.f5565e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f5562b);
            a(compoundDrawables[1], this.f5563c);
            a(compoundDrawables[2], this.f5564d);
            a(compoundDrawables[3], this.f5565e);
        }
        if (this.f5566f == null && this.f5567g == null) {
            return;
        }
        Drawable[] a4 = AbstractC0498Y.a(textView);
        a(a4[0], this.f5566f);
        a(a4[2], this.f5567g);
    }

    public final ColorStateList d() {
        o1 o1Var = this.f5568h;
        if (o1Var != null) {
            return o1Var.f5675a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        o1 o1Var = this.f5568h;
        if (o1Var != null) {
            return o1Var.f5676b;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i4) {
        boolean z;
        boolean z3;
        String str;
        String str2;
        float f4;
        float f5;
        float f6;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        ColorStateList colorStateList;
        int resourceId;
        int i5;
        int resourceId2;
        TextView textView = this.f5561a;
        Context context = textView.getContext();
        C0543t a4 = C0543t.a();
        int[] iArr = AbstractC0357a.f4073h;
        A2.t P = A2.t.P(context, attributeSet, iArr, i4);
        I.T.h(textView, textView.getContext(), iArr, attributeSet, (TypedArray) P.f100h, i4);
        TypedArray typedArray = (TypedArray) P.f100h;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f5562b = c(context, a4, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f5563c = c(context, a4, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f5564d = c(context, a4, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f5565e = c(context, a4, typedArray.getResourceId(2, 0));
        }
        int i6 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(5)) {
            this.f5566f = c(context, a4, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.f5567g = c(context, a4, typedArray.getResourceId(6, 0));
        }
        P.T();
        boolean z4 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = AbstractC0357a.f4088x;
        if (resourceId3 != -1) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            A2.t tVar = new A2.t(context, obtainStyledAttributes);
            if (!z4 && obtainStyledAttributes.hasValue(14)) {
                z3 = obtainStyledAttributes.getBoolean(14, false);
                z = true;
            } else {
                z = false;
                z3 = false;
            }
            n(context, tVar);
            if (obtainStyledAttributes.hasValue(15)) {
                str2 = obtainStyledAttributes.getString(15);
            } else {
                str2 = null;
            }
            if (i6 >= 26 && obtainStyledAttributes.hasValue(13)) {
                str = obtainStyledAttributes.getString(13);
            } else {
                str = null;
            }
            tVar.T();
        } else {
            z = false;
            z3 = false;
            str = null;
            str2 = null;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i4, 0);
        A2.t tVar2 = new A2.t(context, obtainStyledAttributes2);
        if (!z4 && obtainStyledAttributes2.hasValue(14)) {
            z3 = obtainStyledAttributes2.getBoolean(14, false);
            z = true;
        }
        boolean z5 = z3;
        if (obtainStyledAttributes2.hasValue(15)) {
            str2 = obtainStyledAttributes2.getString(15);
        }
        if (i6 >= 26 && obtainStyledAttributes2.hasValue(13)) {
            str = obtainStyledAttributes2.getString(13);
        }
        if (i6 >= 28 && obtainStyledAttributes2.hasValue(0) && obtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, tVar2);
        tVar2.T();
        if (!z4 && z) {
            textView.setAllCaps(z5);
        }
        Typeface typeface = this.f5571l;
        if (typeface != null) {
            if (this.k == -1) {
                textView.setTypeface(typeface, this.f5570j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str != null) {
            AbstractC0501a0.d(textView, str);
        }
        if (str2 != null) {
            AbstractC0499Z.b(textView, AbstractC0499Z.a(str2));
        }
        C0530m0 c0530m0 = this.f5569i;
        Context context2 = c0530m0.f5653j;
        int[] iArr3 = AbstractC0357a.f4074i;
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i4, 0);
        TextView textView2 = c0530m0.f5652i;
        I.T.h(textView2, textView2.getContext(), iArr3, attributeSet, obtainStyledAttributes3, i4);
        if (obtainStyledAttributes3.hasValue(5)) {
            c0530m0.f5644a = obtainStyledAttributes3.getInt(5, 0);
        }
        if (obtainStyledAttributes3.hasValue(4)) {
            f4 = obtainStyledAttributes3.getDimension(4, -1.0f);
        } else {
            f4 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(2)) {
            f5 = obtainStyledAttributes3.getDimension(2, -1.0f);
        } else {
            f5 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(1)) {
            f6 = obtainStyledAttributes3.getDimension(1, -1.0f);
        } else {
            f6 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(3) && (resourceId2 = obtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i7 = 0; i7 < length; i7++) {
                    iArr4[i7] = obtainTypedArray.getDimensionPixelSize(i7, -1);
                }
                c0530m0.f5649f = C0530m0.b(iArr4);
                c0530m0.i();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes3.recycle();
        if (c0530m0.j()) {
            if (c0530m0.f5644a == 1) {
                if (!c0530m0.f5650g) {
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    if (f5 == -1.0f) {
                        i5 = 2;
                        f5 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    } else {
                        i5 = 2;
                    }
                    if (f6 == -1.0f) {
                        f6 = TypedValue.applyDimension(i5, 112.0f, displayMetrics);
                    }
                    float f7 = f6;
                    if (f4 == -1.0f) {
                        f4 = 1.0f;
                    }
                    c0530m0.k(f5, f7, f4);
                }
                c0530m0.h();
            }
        } else {
            c0530m0.f5644a = 0;
        }
        if (E1.f5441b && c0530m0.f5644a != 0) {
            int[] iArr5 = c0530m0.f5649f;
            if (iArr5.length > 0) {
                if (AbstractC0501a0.a(textView) != -1.0f) {
                    AbstractC0501a0.b(textView, Math.round(c0530m0.f5647d), Math.round(c0530m0.f5648e), Math.round(c0530m0.f5646c), 0);
                } else {
                    AbstractC0501a0.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = obtainStyledAttributes4.getResourceId(8, -1);
        if (resourceId4 != -1) {
            drawable = a4.b(context, resourceId4);
        } else {
            drawable = null;
        }
        int resourceId5 = obtainStyledAttributes4.getResourceId(13, -1);
        if (resourceId5 != -1) {
            drawable2 = a4.b(context, resourceId5);
        } else {
            drawable2 = null;
        }
        int resourceId6 = obtainStyledAttributes4.getResourceId(9, -1);
        if (resourceId6 != -1) {
            drawable3 = a4.b(context, resourceId6);
        } else {
            drawable3 = null;
        }
        int resourceId7 = obtainStyledAttributes4.getResourceId(6, -1);
        if (resourceId7 != -1) {
            drawable4 = a4.b(context, resourceId7);
        } else {
            drawable4 = null;
        }
        int resourceId8 = obtainStyledAttributes4.getResourceId(10, -1);
        if (resourceId8 != -1) {
            drawable5 = a4.b(context, resourceId8);
        } else {
            drawable5 = null;
        }
        int resourceId9 = obtainStyledAttributes4.getResourceId(7, -1);
        if (resourceId9 != -1) {
            drawable6 = a4.b(context, resourceId9);
        } else {
            drawable6 = null;
        }
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] a5 = AbstractC0498Y.a(textView);
                Drawable drawable7 = a5[0];
                if (drawable7 == null && a5[2] == null) {
                    Drawable[] compoundDrawables = textView.getCompoundDrawables();
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                } else {
                    if (drawable2 == null) {
                        drawable2 = a5[1];
                    }
                    Drawable drawable8 = a5[2];
                    if (drawable4 == null) {
                        drawable4 = a5[3];
                    }
                    AbstractC0498Y.b(textView, drawable7, drawable2, drawable8, drawable4);
                }
            }
        } else {
            Drawable[] a6 = AbstractC0498Y.a(textView);
            if (drawable5 == null) {
                drawable5 = a6[0];
            }
            if (drawable2 == null) {
                drawable2 = a6[1];
            }
            if (drawable6 == null) {
                drawable6 = a6[2];
            }
            if (drawable4 == null) {
                drawable4 = a6[3];
            }
            AbstractC0498Y.b(textView, drawable5, drawable2, drawable6, drawable4);
        }
        if (obtainStyledAttributes4.hasValue(11)) {
            if (!obtainStyledAttributes4.hasValue(11) || (resourceId = obtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = AbstractC0286a.n(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes4.getColorStateList(11);
            }
            textView.setCompoundDrawableTintList(colorStateList);
        }
        if (obtainStyledAttributes4.hasValue(12)) {
            textView.setCompoundDrawableTintMode(AbstractC0546u0.c(obtainStyledAttributes4.getInt(12, -1), null));
        }
        int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(18, -1);
        int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(19, -1);
        obtainStyledAttributes4.recycle();
        if (dimensionPixelSize != -1) {
            AbstractC0286a.F(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            AbstractC0286a.G(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            if (dimensionPixelSize3 >= 0) {
                if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(null)) {
                    textView.setLineSpacing(dimensionPixelSize3 - r1, 1.0f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void g(Context context, int i4) {
        String string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, AbstractC0357a.f4088x);
        A2.t tVar = new A2.t(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f5561a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, tVar);
        if (i5 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            AbstractC0501a0.d(textView, string);
        }
        tVar.T();
        Typeface typeface = this.f5571l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f5570j);
        }
    }

    public final void i(int i4, int i5, int i6, int i7) {
        C0530m0 c0530m0 = this.f5569i;
        if (c0530m0.j()) {
            DisplayMetrics displayMetrics = c0530m0.f5653j.getResources().getDisplayMetrics();
            c0530m0.k(TypedValue.applyDimension(i7, i4, displayMetrics), TypedValue.applyDimension(i7, i5, displayMetrics), TypedValue.applyDimension(i7, i6, displayMetrics));
            if (c0530m0.h()) {
                c0530m0.a();
            }
        }
    }

    public final void j(int[] iArr, int i4) {
        C0530m0 c0530m0 = this.f5569i;
        if (c0530m0.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i4 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c0530m0.f5653j.getResources().getDisplayMetrics();
                    for (int i5 = 0; i5 < length; i5++) {
                        iArr2[i5] = Math.round(TypedValue.applyDimension(i4, iArr[i5], displayMetrics));
                    }
                }
                c0530m0.f5649f = C0530m0.b(iArr2);
                if (!c0530m0.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                c0530m0.f5650g = false;
            }
            if (c0530m0.h()) {
                c0530m0.a();
            }
        }
    }

    public final void k(int i4) {
        C0530m0 c0530m0 = this.f5569i;
        if (c0530m0.j()) {
            if (i4 != 0) {
                if (i4 == 1) {
                    DisplayMetrics displayMetrics = c0530m0.f5653j.getResources().getDisplayMetrics();
                    c0530m0.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (c0530m0.h()) {
                        c0530m0.a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(A2.i.g(i4, "Unknown auto-size text type: "));
            }
            c0530m0.f5644a = 0;
            c0530m0.f5647d = -1.0f;
            c0530m0.f5648e = -1.0f;
            c0530m0.f5646c = -1.0f;
            c0530m0.f5649f = new int[0];
            c0530m0.f5645b = false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.o1, java.lang.Object] */
    public final void l(ColorStateList colorStateList) {
        boolean z;
        if (this.f5568h == null) {
            this.f5568h = new Object();
        }
        o1 o1Var = this.f5568h;
        o1Var.f5675a = colorStateList;
        if (colorStateList != null) {
            z = true;
        } else {
            z = false;
        }
        o1Var.f5678d = z;
        this.f5562b = o1Var;
        this.f5563c = o1Var;
        this.f5564d = o1Var;
        this.f5565e = o1Var;
        this.f5566f = o1Var;
        this.f5567g = o1Var;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.o1, java.lang.Object] */
    public final void m(PorterDuff.Mode mode) {
        boolean z;
        if (this.f5568h == null) {
            this.f5568h = new Object();
        }
        o1 o1Var = this.f5568h;
        o1Var.f5676b = mode;
        if (mode != null) {
            z = true;
        } else {
            z = false;
        }
        o1Var.f5677c = z;
        this.f5562b = o1Var;
        this.f5563c = o1Var;
        this.f5564d = o1Var;
        this.f5565e = o1Var;
        this.f5566f = o1Var;
        this.f5567g = o1Var;
    }

    public final void n(Context context, A2.t tVar) {
        String string;
        boolean z;
        boolean z3;
        int i4 = this.f5570j;
        TypedArray typedArray = (TypedArray) tVar.f100h;
        this.f5570j = typedArray.getInt(2, i4);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            int i6 = typedArray.getInt(11, -1);
            this.k = i6;
            if (i6 != -1) {
                this.f5570j &= 2;
            }
        }
        int i7 = 10;
        boolean z4 = false;
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f5572m = false;
                int i8 = typedArray.getInt(1, 1);
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            this.f5571l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f5571l = Typeface.SERIF;
                    return;
                }
                this.f5571l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f5571l = null;
        if (typedArray.hasValue(12)) {
            i7 = 12;
        }
        int i9 = this.k;
        int i10 = this.f5570j;
        if (!context.isRestricted()) {
            try {
                Typeface J3 = tVar.J(i7, this.f5570j, new C0496W(this, i9, i10, new WeakReference(this.f5561a)));
                if (J3 != null) {
                    if (i5 >= 28 && this.k != -1) {
                        Typeface create = Typeface.create(J3, 0);
                        int i11 = this.k;
                        if ((this.f5570j & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.f5571l = AbstractC0504b0.a(create, i11, z3);
                    } else {
                        this.f5571l = J3;
                    }
                }
                if (this.f5571l == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.f5572m = z;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f5571l == null && (string = typedArray.getString(i7)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                Typeface create2 = Typeface.create(string, 0);
                int i12 = this.k;
                if ((this.f5570j & 2) != 0) {
                    z4 = true;
                }
                this.f5571l = AbstractC0504b0.a(create2, i12, z4);
                return;
            }
            this.f5571l = Typeface.create(string, this.f5570j);
        }
    }
}
