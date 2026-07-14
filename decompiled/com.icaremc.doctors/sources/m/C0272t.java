package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import h.AbstractC0201a;

/* renamed from: m.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0272t {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f3249a;

    /* renamed from: b, reason: collision with root package name */
    public h0 f3250b;

    /* renamed from: c, reason: collision with root package name */
    public h0 f3251c;

    /* renamed from: d, reason: collision with root package name */
    public h0 f3252d;

    /* renamed from: e, reason: collision with root package name */
    public h0 f3253e;

    /* renamed from: f, reason: collision with root package name */
    public h0 f3254f;

    /* renamed from: g, reason: collision with root package name */
    public h0 f3255g;

    /* renamed from: h, reason: collision with root package name */
    public h0 f3256h;

    /* renamed from: i, reason: collision with root package name */
    public final C0274v f3257i;

    /* renamed from: j, reason: collision with root package name */
    public int f3258j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f3259k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f3260l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3261m;

    public C0272t(TextView textView) {
        this.f3249a = textView;
        this.f3257i = new C0274v(textView);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, m.h0] */
    public static h0 c(Context context, C0268o c0268o, int i2) {
        ColorStateList f2;
        synchronized (c0268o) {
            f2 = c0268o.f3207a.f(context, i2);
        }
        if (f2 != null) {
            ?? obj = new Object();
            obj.f3174d = true;
            obj.f3171a = f2;
            return obj;
        }
        return null;
    }

    public final void a(Drawable drawable, h0 h0Var) {
        if (drawable != null && h0Var != null) {
            C0268o.c(drawable, h0Var, this.f3249a.getDrawableState());
        }
    }

    public final void b() {
        h0 h0Var = this.f3250b;
        TextView textView = this.f3249a;
        if (h0Var != null || this.f3251c != null || this.f3252d != null || this.f3253e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f3250b);
            a(compoundDrawables[1], this.f3251c);
            a(compoundDrawables[2], this.f3252d);
            a(compoundDrawables[3], this.f3253e);
        }
        if (this.f3254f == null && this.f3255g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f3254f);
        a(compoundDrawablesRelative[2], this.f3255g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x0346, code lost:
    
        if (r3 != null) goto L224;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(android.util.AttributeSet r29, int r30) {
        /*
            Method dump skipped, instructions count: 930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.C0272t.d(android.util.AttributeSet, int):void");
    }

    public final void e(Context context, int i2) {
        String string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, AbstractC0201a.f2314s);
        A0.g gVar = new A0.g(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f3249a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        f(context, gVar);
        if (i3 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            textView.setFontVariationSettings(string);
        }
        gVar.k();
        Typeface typeface = this.f3260l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f3258j);
        }
    }

    public final void f(Context context, A0.g gVar) {
        String string;
        Typeface create;
        boolean z;
        boolean z2;
        Typeface create2;
        int i2 = this.f3258j;
        TypedArray typedArray = (TypedArray) gVar.f31e;
        this.f3258j = typedArray.getInt(2, i2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int i4 = typedArray.getInt(11, -1);
            this.f3259k = i4;
            if (i4 != -1) {
                this.f3258j &= 2;
            }
        }
        int i5 = 10;
        boolean z3 = false;
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f3261m = false;
                int i6 = typedArray.getInt(1, 1);
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            this.f3260l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f3260l = Typeface.SERIF;
                    return;
                }
                this.f3260l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f3260l = null;
        if (typedArray.hasValue(12)) {
            i5 = 12;
        }
        int i7 = this.f3259k;
        int i8 = this.f3258j;
        if (!context.isRestricted()) {
            try {
                Typeface f2 = gVar.f(i5, this.f3258j, new C0271s(this, i7, i8));
                if (f2 != null) {
                    if (i3 >= 28 && this.f3259k != -1) {
                        Typeface create3 = Typeface.create(f2, 0);
                        int i9 = this.f3259k;
                        if ((this.f3258j & 2) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        create2 = Typeface.create(create3, i9, z2);
                        this.f3260l = create2;
                    } else {
                        this.f3260l = f2;
                    }
                }
                if (this.f3260l == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.f3261m = z;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3260l == null && (string = typedArray.getString(i5)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f3259k != -1) {
                Typeface create4 = Typeface.create(string, 0);
                int i10 = this.f3259k;
                if ((this.f3258j & 2) != 0) {
                    z3 = true;
                }
                create = Typeface.create(create4, i10, z3);
                this.f3260l = create;
                return;
            }
            this.f3260l = Typeface.create(string, this.f3258j);
        }
    }
}
