package A0;

import B0.n;
import B0.p;
import a.AbstractC0051a;
import a0.AbstractC0059a;
import a0.C0060b;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.S;
import androidx.lifecycle.V;
import androidx.lifecycle.X;
import androidx.lifecycle.Y;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.RecyclerView;
import b0.C0163e;
import com.google.firebase.encoders.json.BuildConfig;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import i.AbstractC0203a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.h;
import l0.k;
import m.C0271s;
import m.r0;
import o0.l;
import o0.m;
import org.xmlpull.v1.XmlPullParserException;
import r.i;
import s0.C0299a;
import s0.C0301c;
import v0.j;
import v0.q;
import w.AbstractC0340e;
import w.InterfaceC0336a;

/* loaded from: classes.dex */
public final class g implements x0.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f29c;

    /* renamed from: d, reason: collision with root package name */
    public Object f30d;

    /* renamed from: e, reason: collision with root package name */
    public Object f31e;

    /* renamed from: f, reason: collision with root package name */
    public Object f32f;

    public /* synthetic */ g() {
        this.f29c = 7;
    }

    public static g i(Context context, AttributeSet attributeSet, int[] iArr, int i2) {
        return new g(context, context.obtainStyledAttributes(attributeSet, iArr, i2, 0));
    }

    public j a() {
        String str;
        if (((String) this.f30d) == null) {
            str = " backendName";
        } else {
            str = BuildConfig.FLAVOR;
        }
        if (((s0.d) this.f32f) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new j((String) this.f30d, (byte[]) this.f31e, (s0.d) this.f32f);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public int b(int i2, int i3) {
        ArrayList arrayList = (ArrayList) this.f32f;
        int size = arrayList.size();
        while (i3 < size) {
            ((AbstractC0059a) arrayList.get(i3)).getClass();
            i3++;
        }
        return i2;
    }

    public X c(Class cls, String key) {
        X viewModel;
        V v2;
        a0 a0Var = (a0) this.f31e;
        h.e(key, "key");
        c0 c0Var = (c0) this.f30d;
        c0Var.getClass();
        LinkedHashMap linkedHashMap = c0Var.f1833a;
        X x2 = (X) linkedHashMap.get(key);
        if (cls.isInstance(x2)) {
            if (a0Var instanceof V) {
                v2 = (V) a0Var;
            } else {
                v2 = null;
            }
            if (v2 != null) {
                h.b(x2);
                AbstractC0146p abstractC0146p = v2.f1817d;
                if (abstractC0146p != null) {
                    C0163e c0163e = v2.f1818e;
                    h.b(c0163e);
                    S.a(x2, c0163e, abstractC0146p);
                }
            }
            h.c(x2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return x2;
        }
        T.c cVar = new T.c((T.b) this.f32f);
        cVar.f768a.put(Y.f1825b, key);
        try {
            viewModel = a0Var.b(cls, cVar);
        } catch (AbstractMethodError unused) {
            viewModel = a0Var.a(cls);
        }
        h.e(viewModel, "viewModel");
        X x3 = (X) linkedHashMap.put(key, viewModel);
        if (x3 != null) {
            x3.b();
        }
        return viewModel;
    }

    public ColorStateList d(int i2) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f31e;
        if (typedArray.hasValue(i2) && (resourceId = typedArray.getResourceId(i2, 0)) != 0) {
            Context context = (Context) this.f30d;
            Object obj = AbstractC0203a.f2329a;
            ColorStateList colorStateList = context.getColorStateList(resourceId);
            if (colorStateList != null) {
                return colorStateList;
            }
        }
        return typedArray.getColorStateList(i2);
    }

    public Drawable e(int i2) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f31e;
        if (typedArray.hasValue(i2) && (resourceId = typedArray.getResourceId(i2, 0)) != 0) {
            return AbstractC0203a.a((Context) this.f30d, resourceId);
        }
        return typedArray.getDrawable(i2);
    }

    public Typeface f(int i2, int i3, C0271s c0271s) {
        C0271s c0271s2;
        XmlPullParserException xmlPullParserException;
        IOException iOException;
        int resourceId = ((TypedArray) this.f31e).getResourceId(i2, 0);
        if (resourceId != 0) {
            if (((TypedValue) this.f32f) == null) {
                this.f32f = new TypedValue();
            }
            Context context = (Context) this.f30d;
            TypedValue typedValue = (TypedValue) this.f32f;
            Object obj = AbstractC0340e.f3945a;
            if (!context.isRestricted()) {
                Resources resources = context.getResources();
                resources.getValue(resourceId, typedValue, true);
                CharSequence charSequence = typedValue.string;
                if (charSequence != null) {
                    String charSequence2 = charSequence.toString();
                    if (!charSequence2.startsWith("res/")) {
                        c0271s.a();
                        return null;
                    }
                    int i4 = typedValue.assetCookie;
                    i iVar = x.d.f3965b;
                    Typeface typeface = (Typeface) iVar.get(x.d.b(resources, resourceId, charSequence2, i4, i3));
                    int i5 = 4;
                    if (typeface != null) {
                        new Handler(Looper.getMainLooper()).post(new B0.e(i5, c0271s, typeface));
                        return typeface;
                    }
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            InterfaceC0336a J2 = AbstractC0051a.J(resources.getXml(resourceId), resources);
                            if (J2 == null) {
                                try {
                                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                                    c0271s.a();
                                    return null;
                                } catch (IOException e2) {
                                    iOException = e2;
                                    c0271s2 = c0271s;
                                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), iOException);
                                    c0271s2.a();
                                    return null;
                                } catch (XmlPullParserException e3) {
                                    xmlPullParserException = e3;
                                    c0271s2 = c0271s;
                                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), xmlPullParserException);
                                    c0271s2.a();
                                    return null;
                                }
                            }
                            try {
                                return x.d.a(context, J2, resources, resourceId, charSequence2, typedValue.assetCookie, i3, c0271s);
                            } catch (IOException e4) {
                                e = e4;
                                c0271s2 = c0271s;
                                iOException = e;
                                Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), iOException);
                                c0271s2.a();
                                return null;
                            } catch (XmlPullParserException e5) {
                                e = e5;
                                c0271s2 = c0271s;
                                xmlPullParserException = e;
                                Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), xmlPullParserException);
                                c0271s2.a();
                                return null;
                            }
                        }
                        c0271s2 = c0271s;
                        try {
                            int i6 = typedValue.assetCookie;
                            Typeface n2 = x.d.f3964a.n(context, resources, resourceId, charSequence2, i3);
                            if (n2 != null) {
                                iVar.put(x.d.b(resources, resourceId, charSequence2, i6, i3), n2);
                            }
                            if (n2 != null) {
                                new Handler(Looper.getMainLooper()).post(new B0.e(i5, c0271s2, n2));
                            } else {
                                c0271s2.a();
                            }
                            return n2;
                        } catch (IOException e6) {
                            e = e6;
                            iOException = e;
                            Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), iOException);
                            c0271s2.a();
                            return null;
                        } catch (XmlPullParserException e7) {
                            e = e7;
                            xmlPullParserException = e;
                            Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), xmlPullParserException);
                            c0271s2.a();
                            return null;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        c0271s2 = c0271s;
                    } catch (XmlPullParserException e9) {
                        e = e9;
                        c0271s2 = c0271s;
                    }
                } else {
                    throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(resourceId) + "\" (" + Integer.toHexString(resourceId) + ") is not a Font: " + typedValue);
                }
            }
        }
        return null;
    }

    public View g(int i2) {
        return ((RecyclerView) ((F.h) this.f30d).f274d).getChildAt(i2);
    }

    @Override // P0.a
    public Object get() {
        switch (this.f29c) {
            case 0:
                return new B0.d((Context) ((P0.a) this.f30d).get(), (C0.d) ((P0.a) this.f31e).get(), (B0.b) ((f) this.f32f).get());
            default:
                return new q(new f(3), new f(2), (e) ((d) this.f30d).get(), (n) ((r0) this.f31e).get(), (p) ((B0.q) this.f32f).get());
        }
    }

    public int h() {
        return ((RecyclerView) ((F.h) this.f30d).f274d).getChildCount();
    }

    public void j(Activity activity, k kVar) {
        WeakHashMap weakHashMap = (WeakHashMap) this.f32f;
        h.e(activity, "activity");
        ReentrantLock reentrantLock = (ReentrantLock) this.f31e;
        reentrantLock.lock();
        try {
            if (kVar.equals((k) weakHashMap.get(activity))) {
                return;
            }
            reentrantLock.unlock();
            Iterator it = ((m) ((F.h) this.f30d).f274d).f3391b.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.f3385a.equals(activity)) {
                    lVar.f3387c = kVar;
                    lVar.f3386b.accept(kVar);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void k() {
        ((TypedArray) this.f31e).recycle();
    }

    public void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0059a instance = (AbstractC0059a) arrayList.get(i2);
            instance.getClass();
            B.l lVar = (B.l) this.f30d;
            Object[] objArr = (Object[]) lVar.f67b;
            h.e(instance, "instance");
            int i3 = lVar.f66a;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4] == instance) {
                    throw new IllegalStateException("Already in the pool!");
                }
            }
            int i5 = lVar.f66a;
            if (i5 < objArr.length) {
                objArr[i5] = instance;
                lVar.f66a = i5 + 1;
            }
        }
        arrayList.clear();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, m.n] */
    public void m(C0299a c0299a) {
        C0.f fVar = new C0.f(21);
        q qVar = (q) this.f32f;
        j jVar = (j) this.f30d;
        C0301c c0301c = (C0301c) this.f31e;
        e eVar = qVar.f3932c;
        g a2 = j.a();
        a2.n(jVar.f3913a);
        a2.f32f = s0.d.f3585c;
        a2.f31e = jVar.f3914b;
        j a3 = a2.a();
        ?? obj = new Object();
        obj.f3202f = new HashMap();
        obj.f3200d = Long.valueOf(qVar.f3930a.j());
        obj.f3201e = Long.valueOf(qVar.f3931b.j());
        obj.f3197a = Constants.FirelogAnalytics.FCM_LOG_SOURCE;
        obj.f3199c = new v0.m(c0301c, ((MessagingClientEventExtension) c0299a.f3581a).toByteArray());
        obj.f3198b = null;
        c cVar = (c) eVar;
        cVar.f17b.execute(new a(cVar, a3, fVar, obj.c()));
    }

    public void n(String str) {
        if (str != null) {
            this.f30d = str;
            return;
        }
        throw new NullPointerException("Null backendName");
    }

    public String toString() {
        switch (this.f29c) {
            case 2:
                return ((C0060b) this.f31e).toString() + ", hidden list:" + ((ArrayList) this.f32f).size();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, int i2) {
        this.f29c = i2;
        this.f30d = obj;
        this.f31e = obj2;
        this.f32f = obj3;
    }

    public g(j jVar, C0301c c0301c, C0.f fVar, q qVar) {
        this.f29c = 8;
        this.f30d = jVar;
        this.f31e = c0301c;
        this.f32f = qVar;
    }

    public g(c0 store, a0 a0Var, T.b defaultCreationExtras) {
        this.f29c = 3;
        h.e(store, "store");
        h.e(defaultCreationExtras, "defaultCreationExtras");
        this.f30d = store;
        this.f31e = a0Var;
        this.f32f = defaultCreationExtras;
    }

    public g(F.h hVar) {
        this.f29c = 2;
        this.f30d = hVar;
        this.f31e = new C0060b();
        this.f32f = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(c0 store, a0 a0Var) {
        this(store, a0Var, T.a.f767b);
        this.f29c = 3;
        h.e(store, "store");
    }

    public g(Context context, TypedArray typedArray) {
        this.f29c = 4;
        this.f30d = context;
        this.f31e = typedArray;
    }

    public g(f fVar) {
        this.f29c = 1;
        this.f30d = new B.l(30);
        this.f31e = new ArrayList();
        this.f32f = new ArrayList();
        new f(12, this);
    }

    public g(F.h hVar, byte b2) {
        this.f29c = 5;
        this.f30d = hVar;
        this.f31e = new ReentrantLock();
        this.f32f = new WeakHashMap();
    }
}
