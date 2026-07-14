package V;

import T.k;
import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f1654a;

    /* renamed from: b, reason: collision with root package name */
    public final W0.g f1655b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, W0.g] */
    public b(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        int i4;
        ?? obj = new Object();
        this.f1654a = editText;
        this.f1655b = obj;
        if (k.f1556j != null) {
            k a4 = k.a();
            if (a4.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            T.f fVar = a4.f1561e;
            fVar.getClass();
            Bundle bundle = editorInfo.extras;
            U.b bVar = (U.b) fVar.f1551c.f1469f;
            int a5 = bVar.a(4);
            if (a5 != 0) {
                i4 = ((ByteBuffer) bVar.f694d).getInt(a5 + bVar.f691a);
            } else {
                i4 = 0;
            }
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i4);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i4, int i5) {
        Editable editableText = this.f1654a.getEditableText();
        this.f1655b.getClass();
        if (!W0.g.h(this, editableText, i4, i5, false) && !super.deleteSurroundingText(i4, i5)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i4, int i5) {
        Editable editableText = this.f1654a.getEditableText();
        this.f1655b.getClass();
        if (W0.g.h(this, editableText, i4, i5, true) || super.deleteSurroundingTextInCodePoints(i4, i5)) {
            return true;
        }
        return false;
    }
}
