package B;

import a0.N;
import a0.u;
import a0.v;
import a0.w;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import g.C0198a;
import h.AbstractC0201a;
import i.AbstractC0203a;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import m.AbstractC0277y;
import m.C0268o;
import m.h0;

/* loaded from: classes.dex */
public final class c implements x0.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f38c;

    /* renamed from: d, reason: collision with root package name */
    public Object f39d;

    /* renamed from: e, reason: collision with root package name */
    public Object f40e;

    public /* synthetic */ c(int i2) {
        this.f38c = i2;
    }

    public void a() {
        h0 h0Var;
        ImageView imageView = (ImageView) this.f39d;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            Rect rect = AbstractC0277y.f3279a;
        }
        if (drawable != null && (h0Var = (h0) this.f40e) != null) {
            C0268o.c(drawable, h0Var, imageView.getDrawableState());
        }
    }

    public View b(int i2, int i3, int i4, int i5) {
        int s2;
        int i6;
        int t2;
        int i7;
        View o2;
        int left;
        int i8;
        int right;
        int i9;
        N n2 = (N) this.f40e;
        u uVar = (u) this.f39d;
        switch (uVar.f1004a) {
            case 0:
                s2 = uVar.f1005b.s();
                break;
            default:
                s2 = uVar.f1005b.u();
                break;
        }
        switch (uVar.f1004a) {
            case 0:
                v vVar = uVar.f1005b;
                i6 = vVar.f1011f;
                t2 = vVar.t();
                break;
            default:
                v vVar2 = uVar.f1005b;
                i6 = vVar2.f1012g;
                t2 = vVar2.r();
                break;
        }
        int i10 = i6 - t2;
        if (i3 > i2) {
            i7 = 1;
        } else {
            i7 = -1;
        }
        View view = null;
        while (i2 != i3) {
            switch (uVar.f1004a) {
                case 0:
                    o2 = uVar.f1005b.o(i2);
                    break;
                default:
                    o2 = uVar.f1005b.o(i2);
                    break;
            }
            switch (uVar.f1004a) {
                case 0:
                    w wVar = (w) o2.getLayoutParams();
                    left = o2.getLeft() - ((w) o2.getLayoutParams()).f1013a.left;
                    i8 = ((ViewGroup.MarginLayoutParams) wVar).leftMargin;
                    break;
                default:
                    w wVar2 = (w) o2.getLayoutParams();
                    left = o2.getTop() - ((w) o2.getLayoutParams()).f1013a.top;
                    i8 = ((ViewGroup.MarginLayoutParams) wVar2).topMargin;
                    break;
            }
            int i11 = left - i8;
            switch (uVar.f1004a) {
                case 0:
                    w wVar3 = (w) o2.getLayoutParams();
                    right = o2.getRight() + ((w) o2.getLayoutParams()).f1013a.right;
                    i9 = ((ViewGroup.MarginLayoutParams) wVar3).rightMargin;
                    break;
                default:
                    w wVar4 = (w) o2.getLayoutParams();
                    right = o2.getBottom() + ((w) o2.getLayoutParams()).f1013a.bottom;
                    i9 = ((ViewGroup.MarginLayoutParams) wVar4).bottomMargin;
                    break;
            }
            int i12 = right + i9;
            n2.f932b = s2;
            n2.f933c = i10;
            n2.f934d = i11;
            n2.f935e = i12;
            if (i4 != 0) {
                n2.f931a = i4;
                if (n2.a()) {
                    return o2;
                }
            }
            if (i5 != 0) {
                n2.f931a = i5;
                if (n2.a()) {
                    view = o2;
                }
            }
            i2 += i7;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory c(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.c.c(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public void d(int i2) {
        int resourceId;
        ImageView imageView = (ImageView) this.f39d;
        A0.g i3 = A0.g.i(imageView.getContext(), null, AbstractC0201a.f2302e, i2);
        TypedArray typedArray = (TypedArray) i3.f31e;
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = AbstractC0203a.a(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                Rect rect = AbstractC0277y.f3279a;
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(i3.d(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(AbstractC0277y.c(typedArray.getInt(3, -1), null));
            }
            i3.k();
        } catch (Throwable th) {
            i3.k();
            throw th;
        }
    }

    public void e(j jVar) {
        A.f fVar = (A.f) this.f40e;
        F.h hVar = (F.h) this.f39d;
        int i2 = jVar.f61b;
        if (i2 == 0) {
            fVar.execute(new a(0, hVar, jVar.f60a));
        } else {
            fVar.execute(new b(hVar, i2));
        }
    }

    @Override // P0.a
    public Object get() {
        switch (this.f38c) {
            case 1:
                A0.f fVar = new A0.f(3);
                A0.f fVar2 = new A0.f(2);
                Object obj = ((P0.a) this.f39d).get();
                P0.a aVar = (P0.a) this.f40e;
                return new C0.j(fVar, fVar2, C0.a.f138f, (C0.l) obj, aVar);
            default:
                return new w0.e((Context) ((C0198a) this.f39d).f2281c, (w0.d) ((F.h) this.f40e).get());
        }
    }

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f38c = i2;
        this.f39d = obj;
        this.f40e = obj2;
    }

    public c() {
        this.f38c = 3;
        this.f39d = new ReentrantLock();
        this.f40e = new LinkedHashMap();
    }

    public c(ImageView imageView) {
        this.f38c = 4;
        this.f39d = imageView;
    }

    public c(Context context) {
        this.f38c = 7;
        this.f40e = null;
        this.f39d = context;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [a0.N, java.lang.Object] */
    public c(u uVar) {
        this.f38c = 2;
        this.f39d = uVar;
        ?? obj = new Object();
        obj.f931a = 0;
        this.f40e = obj;
    }
}
