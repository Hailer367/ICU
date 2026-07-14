package V;

import T.k;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class i implements TextWatcher {

    /* renamed from: f, reason: collision with root package name */
    public final EditText f1668f;

    /* renamed from: g, reason: collision with root package name */
    public h f1669g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1670h = true;

    public i(EditText editText) {
        this.f1668f = editText;
    }

    public static void a(EditText editText, int i4) {
        int length;
        if (i4 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            k a4 = k.a();
            if (editableText == null) {
                length = 0;
            } else {
                a4.getClass();
                length = editableText.length();
            }
            a4.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        EditText editText = this.f1668f;
        if (!editText.isInEditMode() && this.f1670h && k.f1556j != null && i5 <= i6 && (charSequence instanceof Spannable)) {
            int b4 = k.a().b();
            if (b4 != 0) {
                if (b4 != 1) {
                    if (b4 != 3) {
                        return;
                    }
                } else {
                    k.a().e((Spannable) charSequence, i4, i6 + i4);
                    return;
                }
            }
            k a4 = k.a();
            if (this.f1669g == null) {
                this.f1669g = new h(editText);
            }
            a4.f(this.f1669g);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}
