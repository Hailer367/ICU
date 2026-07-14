package V;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f1660a;

    /* renamed from: b, reason: collision with root package name */
    public final Z0.g f1661b;

    /* JADX WARN: Type inference failed for: r0v0, types: [Z0.g, java.lang.Object] */
    public e(KeyListener keyListener) {
        ?? obj = new Object();
        this.f1660a = keyListener;
        this.f1661b = obj;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i4) {
        this.f1660a.clearMetaKeyState(view, editable, i4);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f1660a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i4, KeyEvent keyEvent) {
        boolean g4;
        boolean z;
        this.f1661b.getClass();
        if (i4 != 67) {
            if (i4 != 112) {
                g4 = false;
            } else {
                g4 = E0.a.g(editable, keyEvent, true);
            }
        } else {
            g4 = E0.a.g(editable, keyEvent, false);
        }
        if (g4) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z = true;
        } else {
            z = false;
        }
        if (z || this.f1660a.onKeyDown(view, editable, i4, keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f1660a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i4, KeyEvent keyEvent) {
        return this.f1660a.onKeyUp(view, editable, i4, keyEvent);
    }
}
