package I0;

import D2.K;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import m1.C0441a;
import o.AbstractC0546u0;
import o.C0543t;
import o.U0;
import o.m1;
import p1.C0585n;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class h implements x1.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f819a;

    /* renamed from: b, reason: collision with root package name */
    public Object f820b;

    /* renamed from: c, reason: collision with root package name */
    public Object f821c;

    /* renamed from: d, reason: collision with root package name */
    public Object f822d;

    /* renamed from: e, reason: collision with root package name */
    public Object f823e;

    /* renamed from: f, reason: collision with root package name */
    public Object f824f;

    public h(String str, String str2, Set set) {
        Set unmodifiableSet;
        if (set == null) {
            unmodifiableSet = Collections.EMPTY_SET;
        } else {
            unmodifiableSet = Collections.unmodifiableSet(set);
        }
        this.f821c = unmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f819a = str;
        this.f823e = str2;
        this.f824f = C0441a.f5188b;
        HashSet hashSet = new HashSet(unmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f822d = Collections.unmodifiableSet(hashSet);
        } else {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public static boolean h(int[] iArr, int i4) {
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList j(Context context, int i4) {
        int c4 = m1.c(context, R.attr.colorControlHighlight);
        int b4 = m1.b(context, R.attr.colorButtonNormal);
        int[] iArr = m1.f5655b;
        int[] iArr2 = m1.f5657d;
        int b5 = B.a.b(c4, i4);
        return new ColorStateList(new int[][]{iArr, iArr2, m1.f5656c, m1.f5659f}, new int[]{b4, b5, B.a.b(c4, i4), i4});
    }

    public static LayerDrawable l(U0 u0, Context context, int i4) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i4);
        Drawable c4 = u0.c(context, R.drawable.abc_star_black_48dp);
        Drawable c5 = u0.c(context, R.drawable.abc_star_half_black_48dp);
        if ((c4 instanceof BitmapDrawable) && c4.getIntrinsicWidth() == dimensionPixelSize && c4.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) c4;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            c4.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c4.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((c5 instanceof BitmapDrawable) && c5.getIntrinsicWidth() == dimensionPixelSize && c5.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) c5;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            c5.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c5.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void o(Drawable drawable, int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter e4;
        int[] iArr = AbstractC0546u0.f5713a;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = C0543t.f5707b;
        }
        PorterDuff.Mode mode2 = C0543t.f5707b;
        synchronized (C0543t.class) {
            e4 = U0.e(i4, mode);
        }
        mutate.setColorFilter(e4);
    }

    @Override // x1.b
    public Object a(Class cls) {
        if (((Set) this.f819a).contains(x1.o.a(cls))) {
            Object a4 = ((x1.b) this.f824f).a(cls);
            if (!cls.equals(G1.b.class)) {
                return a4;
            }
            return new x1.p((Set) this.f823e, (G1.b) a4);
        }
        throw new RuntimeException("Attempting to request an undeclared dependency " + cls + ".");
    }

    @Override // x1.b
    public J1.a b(x1.o oVar) {
        if (((Set) this.f822d).contains(oVar)) {
            return ((x1.b) this.f824f).b(oVar);
        }
        throw new RuntimeException("Attempting to request an undeclared dependency Provider<Set<" + oVar + ">>.");
    }

    @Override // x1.b
    public Set c(x1.o oVar) {
        if (((Set) this.f821c).contains(oVar)) {
            return ((x1.b) this.f824f).c(oVar);
        }
        throw new RuntimeException("Attempting to request an undeclared dependency Set<" + oVar + ">.");
    }

    @Override // x1.b
    public J1.a d(Class cls) {
        return f(x1.o.a(cls));
    }

    @Override // x1.b
    public Object e(x1.o oVar) {
        if (((Set) this.f819a).contains(oVar)) {
            return ((x1.b) this.f824f).e(oVar);
        }
        throw new RuntimeException("Attempting to request an undeclared dependency " + oVar + ".");
    }

    @Override // x1.b
    public J1.a f(x1.o oVar) {
        if (((Set) this.f820b).contains(oVar)) {
            return ((x1.b) this.f824f).f(oVar);
        }
        throw new RuntimeException("Attempting to request an undeclared dependency Provider<" + oVar + ">.");
    }

    public void g(String str, String str2) {
        HashMap hashMap = (HashMap) this.f824f;
        if (hashMap != null) {
            hashMap.put(str, str2);
            return;
        }
        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }

    public i i() {
        String str;
        if (((String) this.f819a) == null) {
            str = " transportName";
        } else {
            str = "";
        }
        if (((m) this.f821c) == null) {
            str = str.concat(" encodedPayload");
        }
        if (((Long) this.f822d) == null) {
            str = r2.k.a(str, " eventMillis");
        }
        if (((Long) this.f823e) == null) {
            str = r2.k.a(str, " uptimeMillis");
        }
        if (((HashMap) this.f824f) == null) {
            str = r2.k.a(str, " autoMetadata");
        }
        if (str.isEmpty()) {
            return new i((String) this.f819a, (Integer) this.f820b, (m) this.f821c, ((Long) this.f822d).longValue(), ((Long) this.f823e).longValue(), (HashMap) this.f824f);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.Executor, java.lang.Object] */
    public C0585n k(C0585n c0585n) {
        return c0585n.i(new Object(), new K(19, this));
    }

    public ColorStateList m(Context context, int i4) {
        if (i4 == R.drawable.abc_edit_text_material) {
            return AbstractC0286a.n(context, R.color.abc_tint_edittext);
        }
        if (i4 == R.drawable.abc_switch_track_mtrl_alpha) {
            return AbstractC0286a.n(context, R.color.abc_tint_switch_track);
        }
        if (i4 == R.drawable.abc_switch_thumb_material) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList d4 = m1.d(context, R.attr.colorSwitchThumbNormal);
            if (d4 != null && d4.isStateful()) {
                int[] iArr3 = m1.f5655b;
                iArr[0] = iArr3;
                iArr2[0] = d4.getColorForState(iArr3, 0);
                iArr[1] = m1.f5658e;
                iArr2[1] = m1.c(context, R.attr.colorControlActivated);
                iArr[2] = m1.f5659f;
                iArr2[2] = d4.getDefaultColor();
            } else {
                iArr[0] = m1.f5655b;
                iArr2[0] = m1.b(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = m1.f5658e;
                iArr2[1] = m1.c(context, R.attr.colorControlActivated);
                iArr[2] = m1.f5659f;
                iArr2[2] = m1.c(context, R.attr.colorSwitchThumbNormal);
            }
            return new ColorStateList(iArr, iArr2);
        }
        if (i4 == R.drawable.abc_btn_default_mtrl_shape) {
            return j(context, m1.c(context, R.attr.colorButtonNormal));
        }
        if (i4 == R.drawable.abc_btn_borderless_material) {
            return j(context, 0);
        }
        if (i4 == R.drawable.abc_btn_colored_material) {
            return j(context, m1.c(context, R.attr.colorAccent));
        }
        if (i4 != R.drawable.abc_spinner_mtrl_am_alpha && i4 != R.drawable.abc_spinner_textfield_background_material) {
            if (h((int[]) this.f820b, i4)) {
                return m1.d(context, R.attr.colorControlNormal);
            }
            if (h((int[]) this.f823e, i4)) {
                return AbstractC0286a.n(context, R.color.abc_tint_default);
            }
            if (h((int[]) this.f824f, i4)) {
                return AbstractC0286a.n(context, R.color.abc_tint_btn_checkable);
            }
            if (i4 == R.drawable.abc_seekbar_thumb_material) {
                return AbstractC0286a.n(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        return AbstractC0286a.n(context, R.color.abc_tint_spinner);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0101 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0159 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(java.lang.String r7, java.lang.String r8, android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I0.h.n(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public C0585n p(String str, String str2, Bundle bundle) {
        int i4;
        try {
            n(str, str2, bundle);
            V0.b bVar = (V0.b) this.f821c;
            V0.h hVar = V0.h.f1691h;
            V0.o oVar = bVar.f1678c;
            if (oVar.a() < 12000000) {
                if (oVar.b() != 0) {
                    return bVar.a(bundle).j(hVar, new E0.a(11, bVar, bundle));
                }
                return AbstractC0602b.z(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            V0.n a4 = V0.n.a(bVar.f1677b);
            synchronized (a4) {
                i4 = a4.f1716d;
                a4.f1716d = i4 + 1;
            }
            return a4.b(new V0.m(i4, 1, bundle, 1)).i(hVar, V0.d.f1684g);
        } catch (InterruptedException | ExecutionException e4) {
            return AbstractC0602b.z(e4);
        }
    }
}
