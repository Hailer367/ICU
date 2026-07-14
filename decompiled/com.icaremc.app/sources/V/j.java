package V;

import T.k;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* loaded from: classes.dex */
public final class j implements TransformationMethod {

    /* renamed from: f, reason: collision with root package name */
    public final TransformationMethod f1671f;

    public j(TransformationMethod transformationMethod) {
        this.f1671f = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f1671f;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence != null && k.a().b() == 1) {
            k a4 = k.a();
            a4.getClass();
            return a4.e(charSequence, 0, charSequence.length());
        }
        return charSequence;
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i4, Rect rect) {
        TransformationMethod transformationMethod = this.f1671f;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i4, rect);
        }
    }
}
