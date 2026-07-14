package x;

import B.k;
import E.AbstractC0004d;
import a.AbstractC0051a;
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
import m.C0271s;
import w.C0337b;
import w.C0339d;
import w.InterfaceC0336a;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC0051a f3964a;

    /* renamed from: b, reason: collision with root package name */
    public static final r.i f3965b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f3966c;

    static {
        Trace.beginSection(android.support.v4.media.session.a.J("TypefaceCompat static init"));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            f3964a = new AbstractC0051a();
        } else if (i2 >= 29) {
            f3964a = new AbstractC0051a();
        } else if (i2 >= 28) {
            f3964a = new g();
        } else if (i2 >= 26) {
            f3964a = new g();
        } else {
            Method method = f.f3974h;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                f3964a = new AbstractC0051a();
            } else {
                f3964a = new AbstractC0051a();
            }
        }
        f3965b = new r.i(16);
        f3966c = null;
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [B.p, java.lang.Object, java.lang.Runnable] */
    public static Typeface a(Context context, InterfaceC0336a interfaceC0336a, Resources resources, int i2, String str, int i3, int i4, C0271s c0271s) {
        Typeface k2;
        Typeface build;
        FontFamily c2;
        Handler handler;
        int i5 = 4;
        if (interfaceC0336a instanceof C0339d) {
            C0339d c0339d = (C0339d) interfaceC0336a;
            String str2 = c0339d.f3944d;
            k2 = null;
            int i6 = 1;
            boolean z = false;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            if (TextUtils.isEmpty(str2) || (build = c(str2)) == null) {
                ArrayList arrayList = c0339d.f3941a;
                if (arrayList.size() == 1) {
                    build = c(((B.g) arrayList.get(0)).f50e);
                } else {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= arrayList.size()) {
                                Typeface.CustomFallbackBuilder customFallbackBuilder = null;
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= arrayList.size()) {
                                        break;
                                    }
                                    B.g gVar = (B.g) arrayList.get(i8);
                                    if (i8 == arrayList.size() - 1 && TextUtils.isEmpty(gVar.f51f)) {
                                        c.f(customFallbackBuilder, gVar.f50e);
                                        break;
                                    }
                                    String str3 = gVar.f50e;
                                    String str4 = gVar.f51f;
                                    Font d2 = d(c(str3));
                                    if (d2 == null) {
                                        Log.w("TypefaceCompat", "Unable identify the primary font for " + gVar.f50e + ". Falling back to provider font.");
                                        break;
                                    }
                                    if (!TextUtils.isEmpty(str4)) {
                                        try {
                                            c.d();
                                            c.g();
                                            c2 = c.c(io.flutter.plugin.platform.a.e(c.b(c.a(AbstractC0004d.f(d2), str4))));
                                        } catch (IOException unused) {
                                            Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                        }
                                    } else {
                                        c2 = c.c(io.flutter.plugin.platform.a.e(d2));
                                    }
                                    if (customFallbackBuilder == null) {
                                        customFallbackBuilder = io.flutter.plugin.platform.a.c(c2);
                                    } else {
                                        c.e(customFallbackBuilder, c2);
                                    }
                                    i8++;
                                }
                                build = customFallbackBuilder.build();
                            } else {
                                if (c(((B.g) arrayList.get(i7)).f50e) == null) {
                                    break;
                                }
                                i7++;
                            }
                        }
                    }
                    build = null;
                }
            }
            if (build != null) {
                new Handler(Looper.getMainLooper()).post(new B0.e(i5, c0271s, build));
                f3965b.put(b(resources, i2, str, i3, i4), build);
                return build;
            }
            Object[] objArr5 = c0339d.f3943c == 0;
            int i9 = c0339d.f3942b;
            Handler handler2 = new Handler(Looper.getMainLooper());
            F.h hVar = new F.h(20, z);
            hVar.f274d = c0271s;
            ArrayList arrayList2 = c0339d.f3941a;
            A.f fVar = new A.f(1, handler2);
            B.c cVar = new B.c(objArr4 == true ? 1 : 0, hVar, fVar);
            if (objArr5 != false) {
                if (arrayList2.size() <= 1) {
                    B.g gVar2 = (B.g) arrayList2.get(0);
                    r.i iVar = k.f62a;
                    ArrayList arrayList3 = new ArrayList(1);
                    Object obj = new Object[]{gVar2}[0];
                    Objects.requireNonNull(obj);
                    arrayList3.add(obj);
                    String a2 = k.a(i4, Collections.unmodifiableList(arrayList3));
                    Typeface typeface = (Typeface) k.f62a.get(a2);
                    if (typeface != null) {
                        fVar.execute(new B.a(objArr3 == true ? 1 : 0, hVar, typeface));
                        k2 = typeface;
                    } else if (i9 == -1) {
                        ArrayList arrayList4 = new ArrayList(1);
                        Object obj2 = new Object[]{gVar2}[0];
                        Objects.requireNonNull(obj2);
                        arrayList4.add(obj2);
                        B.j b2 = k.b(a2, context, Collections.unmodifiableList(arrayList4), i4);
                        cVar.e(b2);
                        k2 = b2.f60a;
                    } else {
                        try {
                            try {
                                try {
                                    try {
                                        B.j jVar = (B.j) k.f63b.submit(new B.h(a2, context, gVar2, i4, 0)).get(i9, TimeUnit.MILLISECONDS);
                                        cVar.e(jVar);
                                        k2 = jVar.f60a;
                                    } catch (ExecutionException e2) {
                                        throw new RuntimeException(e2);
                                    }
                                } catch (TimeoutException unused2) {
                                    throw new InterruptedException("timeout");
                                }
                            } catch (InterruptedException e3) {
                                throw e3;
                            }
                        } catch (InterruptedException unused3) {
                            ((A.f) cVar.f40e).execute(new B.b((F.h) cVar.f39d, -3));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
            } else {
                String a3 = k.a(i4, arrayList2);
                Typeface typeface2 = (Typeface) k.f62a.get(a3);
                if (typeface2 != null) {
                    fVar.execute(new B.a(objArr2 == true ? 1 : 0, hVar, typeface2));
                    k2 = typeface2;
                } else {
                    B.i iVar2 = new B.i(objArr == true ? 1 : 0, cVar);
                    synchronized (k.f64c) {
                        try {
                            r.j jVar2 = k.f65d;
                            ArrayList arrayList5 = (ArrayList) jVar2.get(a3);
                            if (arrayList5 != null) {
                                arrayList5.add(iVar2);
                            } else {
                                ArrayList arrayList6 = new ArrayList();
                                arrayList6.add(iVar2);
                                jVar2.put(a3, arrayList6);
                                B.h hVar2 = new B.h(a3, context, arrayList2, i4, 1);
                                ThreadPoolExecutor threadPoolExecutor = k.f63b;
                                B.i iVar3 = new B.i(i6, a3);
                                if (Looper.myLooper() == null) {
                                    handler = new Handler(Looper.getMainLooper());
                                } else {
                                    handler = new Handler();
                                }
                                ?? obj3 = new Object();
                                obj3.f75c = hVar2;
                                obj3.f76d = iVar3;
                                obj3.f77e = handler;
                                threadPoolExecutor.execute(obj3);
                            }
                        } finally {
                        }
                    }
                }
            }
        } else {
            k2 = f3964a.k(context, (C0337b) interfaceC0336a, resources, i4);
            if (k2 != null) {
                new Handler(Looper.getMainLooper()).post(new B0.e(i5, c0271s, k2));
            } else {
                c0271s.a();
            }
        }
        if (k2 != null) {
            f3965b.put(b(resources, i2, str, i3, i4), k2);
        }
        return k2;
    }

    public static String b(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
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
        if (f3966c == null) {
            f3966c = new Paint();
        }
        f3966c.setTextSize(10.0f);
        f3966c.setTypeface(typeface);
        shapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f3966c);
        glyphCount = shapeTextRun.glyphCount();
        if (glyphCount != 0) {
            font = shapeTextRun.getFont(0);
            return font;
        }
        return null;
    }
}
