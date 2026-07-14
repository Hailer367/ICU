package B;

import F.o;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import o.C0496W;
import q1.AbstractC0602b;
import t.C0660i;
import t.C0661j;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC0602b f128a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0660i f129b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f130c;

    static {
        Trace.beginSection(k3.b.B("TypefaceCompat static init"));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            f128a = new AbstractC0602b();
        } else if (i4 >= 29) {
            f128a = new AbstractC0602b();
        } else if (i4 >= 28) {
            f128a = new i();
        } else if (i4 >= 26) {
            f128a = new i();
        } else {
            Method method = h.f138d;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                f128a = new AbstractC0602b();
            } else {
                f128a = new AbstractC0602b();
            }
        }
        f129b = new C0660i(16);
        f130c = null;
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Typeface a(Context context, A.d dVar, Resources resources, int i4, String str, int i5, int i6, C0496W c0496w) {
        Typeface k;
        Typeface build;
        Font.Builder fontVariationSettings;
        Font build2;
        FontFamily build3;
        Object[] objArr;
        Handler handler;
        int i7 = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        if (dVar instanceof A.g) {
            A.g gVar = (A.g) dVar;
            String str2 = gVar.f24d;
            k = null;
            int i8 = 1;
            if (TextUtils.isEmpty(str2) || (build = c(str2)) == null) {
                ArrayList arrayList = gVar.f21a;
                if (arrayList.size() == 1) {
                    build = c(((F.f) arrayList.get(0)).f493e);
                } else {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i9 = 0;
                        while (true) {
                            if (i9 < arrayList.size()) {
                                if (c(((F.f) arrayList.get(i9)).f493e) == null) {
                                    break;
                                }
                                i9++;
                            } else {
                                int i10 = 0;
                                Typeface.CustomFallbackBuilder customFallbackBuilder = null;
                                while (true) {
                                    if (i10 >= arrayList.size()) {
                                        break;
                                    }
                                    F.f fVar = (F.f) arrayList.get(i10);
                                    if (i10 == arrayList.size() - 1 && TextUtils.isEmpty(fVar.f494f)) {
                                        customFallbackBuilder.setSystemFallback(fVar.f493e);
                                        break;
                                    }
                                    String str3 = fVar.f493e;
                                    String str4 = fVar.f494f;
                                    Font d4 = d(c(str3));
                                    if (d4 == null) {
                                        Log.w("TypefaceCompat", "Unable identify the primary font for " + fVar.f493e + ". Falling back to provider font.");
                                        break;
                                    }
                                    if (TextUtils.isEmpty(str4)) {
                                        build3 = d.f(d4).build();
                                    } else {
                                        try {
                                            d.n();
                                            d.v();
                                            fontVariationSettings = e.g(d4).setFontVariationSettings(str4);
                                            build2 = fontVariationSettings.build();
                                            build3 = d.f(build2).build();
                                        } catch (IOException unused) {
                                            Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                        }
                                    }
                                    if (customFallbackBuilder != null) {
                                        customFallbackBuilder.addCustomFallback(build3);
                                    } else {
                                        customFallbackBuilder = d.b(build3);
                                    }
                                    i10++;
                                }
                                build = customFallbackBuilder.build();
                            }
                        }
                    }
                    build = null;
                }
            }
            if (build != null) {
                new Handler(Looper.getMainLooper()).post(new A.j(i7, c0496w, build));
                f129b.b(b(resources, i4, str, i5, i6), build);
                return build;
            }
            if (gVar.f23c == 0) {
                objArr = true;
            } else {
                objArr = false;
            }
            int i11 = gVar.f22b;
            Handler handler2 = new Handler(Looper.getMainLooper());
            R1.c cVar = new R1.c(2, (boolean) (objArr6 == true ? 1 : 0));
            cVar.f1532g = c0496w;
            ArrayList arrayList2 = gVar.f21a;
            E.d dVar2 = new E.d(handler2, 1);
            E0.a aVar = new E0.a(i8, cVar, dVar2);
            if (objArr != false) {
                if (arrayList2.size() <= 1) {
                    F.f fVar2 = (F.f) arrayList2.get(0);
                    C0660i c0660i = F.j.f505a;
                    ArrayList arrayList3 = new ArrayList(1);
                    Object obj = new Object[]{fVar2}[0];
                    Objects.requireNonNull(obj);
                    arrayList3.add(obj);
                    String a4 = F.j.a(i6, Collections.unmodifiableList(arrayList3));
                    Typeface typeface = (Typeface) F.j.f505a.a(a4);
                    if (typeface != null) {
                        dVar2.execute(new F.a(objArr5 == true ? 1 : 0, cVar, typeface));
                        k = typeface;
                    } else if (i11 == -1) {
                        ArrayList arrayList4 = new ArrayList(1);
                        Object obj2 = new Object[]{fVar2}[0];
                        Objects.requireNonNull(obj2);
                        arrayList4.add(obj2);
                        F.i b4 = F.j.b(a4, context, Collections.unmodifiableList(arrayList4), i6);
                        aVar.D(b4);
                        k = b4.f503a;
                    } else {
                        try {
                            try {
                                try {
                                    F.i iVar = (F.i) F.j.f506b.submit(new F.g(a4, context, fVar2, i6, 0)).get(i11, TimeUnit.MILLISECONDS);
                                    aVar.D(iVar);
                                    k = iVar.f503a;
                                } catch (TimeoutException unused2) {
                                    throw new InterruptedException("timeout");
                                }
                            } catch (InterruptedException e4) {
                                throw e4;
                            } catch (ExecutionException e5) {
                                throw new RuntimeException(e5);
                            }
                        } catch (InterruptedException unused3) {
                            ((E.d) aVar.f460h).execute(new F.b((R1.c) aVar.f459g, -3));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
            } else {
                String a5 = F.j.a(i6, arrayList2);
                Typeface typeface2 = (Typeface) F.j.f505a.a(a5);
                if (typeface2 != null) {
                    dVar2.execute(new F.a(objArr4 == true ? 1 : 0, cVar, typeface2));
                    k = typeface2;
                } else {
                    F.h hVar = new F.h(objArr3 == true ? 1 : 0, aVar);
                    synchronized (F.j.f507c) {
                        try {
                            C0661j c0661j = F.j.f508d;
                            ArrayList arrayList5 = (ArrayList) c0661j.get(a5);
                            if (arrayList5 != null) {
                                arrayList5.add(hVar);
                            } else {
                                ArrayList arrayList6 = new ArrayList();
                                arrayList6.add(hVar);
                                c0661j.put(a5, arrayList6);
                                F.g gVar2 = new F.g(a5, context, arrayList2, i6, 1);
                                ThreadPoolExecutor threadPoolExecutor = F.j.f506b;
                                F.h hVar2 = new F.h(i8, a5);
                                if (Looper.myLooper() == null) {
                                    handler = new Handler(Looper.getMainLooper());
                                } else {
                                    handler = new Handler();
                                }
                                o oVar = new o();
                                oVar.f519g = gVar2;
                                oVar.f520h = hVar2;
                                oVar.f521i = handler;
                                threadPoolExecutor.execute(oVar);
                            }
                        } finally {
                        }
                    }
                }
            }
        } else {
            k = f128a.k(context, (A.e) dVar, resources, i6);
            if (k != null) {
                new Handler(Looper.getMainLooper()).post(new A.j(objArr2 == true ? 1 : 0, c0496w, k));
            } else {
                c0496w.a();
            }
        }
        if (k != null) {
            f129b.b(b(resources, i4, str, i5, i6), k);
        }
        return k;
    }

    public static String b(Resources resources, int i4, String str, int i5, int i6) {
        return resources.getResourcePackageName(i4) + '-' + str + '-' + i5 + '-' + i4 + '-' + i6;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface create = Typeface.create(str, 0);
            Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
            if (create != null && !create.equals(create2)) {
                return create;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        PositionedGlyphs shapeTextRun;
        int glyphCount;
        Font font;
        if (f130c == null) {
            f130c = new Paint();
        }
        f130c.setTextSize(10.0f);
        f130c.setTypeface(typeface);
        shapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f130c);
        glyphCount = shapeTextRun.glyphCount();
        if (glyphCount != 0) {
            font = shapeTextRun.getFont(0);
            return font;
        }
        return null;
    }
}
