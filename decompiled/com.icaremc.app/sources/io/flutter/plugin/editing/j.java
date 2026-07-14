package io.flutter.plugin.editing;

import P1.y;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.util.SparseArray;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import h0.C0324l;
import io.flutter.plugin.platform.q;
import io.flutter.plugin.platform.r;
import io.flutter.plugin.platform.s;
import n.p;
import r2.m;
import r2.o;
import s2.C0644p;

/* loaded from: classes.dex */
public final class j implements e {

    /* renamed from: a, reason: collision with root package name */
    public final View f4287a;

    /* renamed from: b, reason: collision with root package name */
    public final InputMethodManager f4288b;

    /* renamed from: c, reason: collision with root package name */
    public final AutofillManager f4289c;

    /* renamed from: d, reason: collision with root package name */
    public final s f4290d;

    /* renamed from: e, reason: collision with root package name */
    public C0324l f4291e = new C0324l(1, 0);

    /* renamed from: f, reason: collision with root package name */
    public m f4292f;

    /* renamed from: g, reason: collision with root package name */
    public SparseArray f4293g;

    /* renamed from: h, reason: collision with root package name */
    public f f4294h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4295i;

    /* renamed from: j, reason: collision with root package name */
    public InputConnection f4296j;
    public final r k;

    /* renamed from: l, reason: collision with root package name */
    public final q f4297l;

    /* renamed from: m, reason: collision with root package name */
    public Rect f4298m;

    /* renamed from: n, reason: collision with root package name */
    public final ImeSyncDeferringInsetsCallback f4299n;

    /* renamed from: o, reason: collision with root package name */
    public o f4300o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4301p;

    public j(View view, s sVar, p pVar, r rVar, q qVar) {
        this.f4287a = view;
        this.f4294h = new f(null, view);
        this.f4288b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            this.f4289c = com.dexterous.flutterlocalnotifications.a.i(view.getContext().getSystemService(com.dexterous.flutterlocalnotifications.a.m()));
        } else {
            this.f4289c = null;
        }
        if (i4 >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.f4299n = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
            imeSyncDeferringInsetsCallback.setImeVisibilityListener(new A2.q(27, this));
        }
        this.f4290d = sVar;
        sVar.f4391h = new R1.c(28, this);
        ((C0644p) sVar.f4390g).a("TextInputClient.requestExistingInputState", null, null);
        this.k = rVar;
        rVar.f4374l = this;
        this.f4297l = qVar;
        qVar.k = this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
    
        if (r7 == r0.f6115e) goto L38;
     */
    @Override // io.flutter.plugin.editing.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r19) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.j.a(boolean):void");
    }

    public final void b(int i4) {
        C0324l c0324l = this.f4291e;
        int i5 = c0324l.f3914b;
        if ((i5 == 3 || i5 == 4) && c0324l.f3915c == i4) {
            this.f4291e = new C0324l(1, 0);
            d();
            View view = this.f4287a;
            IBinder applicationWindowToken = view.getApplicationWindowToken();
            InputMethodManager inputMethodManager = this.f4288b;
            inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0);
            inputMethodManager.restartInput(view);
            this.f4295i = false;
        }
    }

    public final void c() {
        this.k.f4374l = null;
        this.f4297l.k = null;
        this.f4290d.f4391h = null;
        d();
        this.f4294h.e(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f4299n;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public final void d() {
        AutofillManager autofillManager;
        m mVar;
        y yVar;
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager = this.f4289c) != null && (mVar = this.f4292f) != null && (yVar = mVar.f6105j) != null && this.f4293g != null) {
            autofillManager.notifyViewExited(this.f4287a, ((String) yVar.f1469f).hashCode());
        }
    }

    public final void e(m mVar) {
        y yVar;
        AutofillValue forText;
        if (Build.VERSION.SDK_INT >= 26) {
            if (mVar != null && (yVar = mVar.f6105j) != null) {
                m[] mVarArr = mVar.f6106l;
                SparseArray sparseArray = new SparseArray();
                this.f4293g = sparseArray;
                if (mVarArr == null) {
                    sparseArray.put(((String) yVar.f1469f).hashCode(), mVar);
                    return;
                }
                for (m mVar2 : mVarArr) {
                    y yVar2 = mVar2.f6105j;
                    if (yVar2 != null) {
                        String str = (String) yVar2.f1469f;
                        this.f4293g.put(str.hashCode(), mVar2);
                        AutofillManager autofillManager = this.f4289c;
                        int hashCode = str.hashCode();
                        forText = AutofillValue.forText(((o) yVar2.f1471h).f6111a);
                        autofillManager.notifyValueChanged(this.f4287a, hashCode, forText);
                    }
                }
                return;
            }
            this.f4293g = null;
        }
    }
}
