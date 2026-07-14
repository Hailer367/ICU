package T;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class t implements TextWatcher, SpanWatcher {

    /* renamed from: f, reason: collision with root package name */
    public final Object f1592f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicInteger f1593g = new AtomicInteger(0);

    public t(Object obj) {
        this.f1592f = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f1592f).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        ((TextWatcher) this.f1592f).beforeTextChanged(charSequence, i4, i5, i6);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i4, int i5) {
        if (this.f1593g.get() > 0 && (obj instanceof v)) {
            return;
        }
        ((SpanWatcher) this.f1592f).onSpanAdded(spannable, obj, i4, i5);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        if (this.f1593g.get() > 0 && (obj instanceof v)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (i4 > i5) {
                i4 = 0;
            }
            if (i6 > i7) {
                i8 = i4;
                i9 = 0;
                ((SpanWatcher) this.f1592f).onSpanChanged(spannable, obj, i8, i5, i9, i7);
            }
        }
        i8 = i4;
        i9 = i6;
        ((SpanWatcher) this.f1592f).onSpanChanged(spannable, obj, i8, i5, i9, i7);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i4, int i5) {
        if (this.f1593g.get() > 0 && (obj instanceof v)) {
            return;
        }
        ((SpanWatcher) this.f1592f).onSpanRemoved(spannable, obj, i4, i5);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        ((TextWatcher) this.f1592f).onTextChanged(charSequence, i4, i5, i6);
    }
}
