package io.flutter.plugin.editing;

import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import r2.o;

/* loaded from: classes.dex */
public final class f extends SpannableStringBuilder {

    /* renamed from: f, reason: collision with root package name */
    public int f4264f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f4265g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f4266h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f4267i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f4268j = new ArrayList();
    public String k;

    /* renamed from: l, reason: collision with root package name */
    public String f4269l;

    /* renamed from: m, reason: collision with root package name */
    public int f4270m;

    /* renamed from: n, reason: collision with root package name */
    public int f4271n;

    /* renamed from: o, reason: collision with root package name */
    public int f4272o;

    /* renamed from: p, reason: collision with root package name */
    public int f4273p;

    /* renamed from: q, reason: collision with root package name */
    public final d f4274q;

    public f(o oVar, View view) {
        this.f4274q = new d(view, this);
        if (oVar != null) {
            f(oVar);
        }
    }

    public final void a(e eVar) {
        if (this.f4265g > 0) {
            Log.e("ListenableEditingState", "adding a listener " + eVar.toString() + " in a listener callback");
        }
        if (this.f4264f > 0) {
            Log.w("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.f4267i.add(eVar);
        } else {
            this.f4266h.add(eVar);
        }
    }

    public final void b() {
        this.f4264f++;
        if (this.f4265g > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f4264f == 1 && !this.f4266h.isEmpty()) {
            this.f4269l = toString();
            this.f4270m = Selection.getSelectionStart(this);
            this.f4271n = Selection.getSelectionEnd(this);
            this.f4272o = BaseInputConnection.getComposingSpanStart(this);
            this.f4273p = BaseInputConnection.getComposingSpanEnd(this);
        }
    }

    public final void c() {
        boolean z;
        int i4 = this.f4264f;
        if (i4 == 0) {
            Log.e("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        ArrayList arrayList = this.f4266h;
        ArrayList arrayList2 = this.f4267i;
        if (i4 == 1) {
            int size = arrayList2.size();
            boolean z3 = false;
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                this.f4265g++;
                ((e) obj).a(true);
                this.f4265g--;
            }
            if (!arrayList.isEmpty()) {
                arrayList.size();
                boolean z4 = !toString().equals(this.f4269l);
                if (this.f4270m == Selection.getSelectionStart(this) && this.f4271n == Selection.getSelectionEnd(this)) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.f4272o != BaseInputConnection.getComposingSpanStart(this) || this.f4273p != BaseInputConnection.getComposingSpanEnd(this)) {
                    z3 = true;
                }
                d(z4, z, z3);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList2.clear();
        this.f4264f--;
    }

    public final void d(boolean z, boolean z3, boolean z4) {
        if (z || z3 || z4) {
            ArrayList arrayList = this.f4266h;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                this.f4265g++;
                ((e) obj).a(z);
                this.f4265g--;
            }
        }
    }

    public final void e(e eVar) {
        if (this.f4265g > 0) {
            Log.e("ListenableEditingState", "removing a listener " + eVar.toString() + " in a listener callback");
        }
        this.f4266h.remove(eVar);
        if (this.f4264f > 0) {
            this.f4267i.remove(eVar);
        }
    }

    public final void f(o oVar) {
        b();
        replace(0, length(), (CharSequence) oVar.f6111a);
        int i4 = oVar.f6112b;
        if (i4 >= 0) {
            Selection.setSelection(this, i4, oVar.f6113c);
        } else {
            Selection.removeSelection(this);
        }
        int i5 = oVar.f6114d;
        int i6 = oVar.f6115e;
        if (i5 >= 0 && i5 < i6) {
            this.f4274q.setComposingRegion(i5, i6);
        } else {
            BaseInputConnection.removeComposingSpans(this);
        }
        this.f4268j.clear();
        c();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [io.flutter.plugin.editing.h, java.lang.Object] */
    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i4, int i5, int i6) {
        super.setSpan(obj, i4, i5, i6);
        String fVar = toString();
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        ?? obj2 = new Object();
        obj2.f4283e = selectionStart;
        obj2.f4284f = selectionEnd;
        obj2.f4285g = composingSpanStart;
        obj2.f4286h = composingSpanEnd;
        obj2.f4279a = fVar;
        obj2.f4280b = "";
        obj2.f4281c = -1;
        obj2.f4282d = -1;
        this.f4268j.add(obj2);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final String toString() {
        String str = this.k;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.k = spannableStringBuilder;
        return spannableStringBuilder;
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [io.flutter.plugin.editing.h, java.lang.Object] */
    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i4, int i5, CharSequence charSequence, int i6, int i7) {
        if (this.f4265g > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String fVar = toString();
        int i8 = i5 - i4;
        boolean z = i8 != i7 - i6;
        for (int i9 = 0; i9 < i8 && !z; i9++) {
            z |= charAt(i4 + i9) != charSequence.charAt(i6 + i9);
        }
        if (z) {
            this.k = null;
        }
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        SpannableStringBuilder replace = super.replace(i4, i5, charSequence, i6, i7);
        int selectionStart2 = Selection.getSelectionStart(this);
        int selectionEnd2 = Selection.getSelectionEnd(this);
        int composingSpanStart2 = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd2 = BaseInputConnection.getComposingSpanEnd(this);
        ?? obj = new Object();
        obj.f4283e = selectionStart2;
        obj.f4284f = selectionEnd2;
        obj.f4285g = composingSpanStart2;
        obj.f4286h = composingSpanEnd2;
        String charSequence2 = charSequence.toString();
        obj.f4279a = fVar;
        obj.f4280b = charSequence2;
        obj.f4281c = i4;
        obj.f4282d = i5;
        this.f4268j.add(obj);
        if (this.f4264f > 0) {
            return replace;
        }
        d(z, (Selection.getSelectionStart(this) == selectionStart && Selection.getSelectionEnd(this) == selectionEnd) ? false : true, (BaseInputConnection.getComposingSpanStart(this) == composingSpanStart && BaseInputConnection.getComposingSpanEnd(this) == composingSpanEnd) ? false : true);
        return replace;
    }
}
