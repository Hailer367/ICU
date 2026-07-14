package V;

import T.k;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class g extends AbstractC0602b {

    /* renamed from: b, reason: collision with root package name */
    public final f f1665b;

    public g(TextView textView) {
        this.f1665b = new f(textView);
    }

    @Override // q1.AbstractC0602b
    public final InputFilter[] C(InputFilter[] inputFilterArr) {
        boolean z;
        if (k.f1556j != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return inputFilterArr;
        }
        return this.f1665b.C(inputFilterArr);
    }

    @Override // q1.AbstractC0602b
    public final boolean H() {
        return this.f1665b.f1664d;
    }

    @Override // q1.AbstractC0602b
    public final void O(boolean z) {
        boolean z3;
        if (k.f1556j != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return;
        }
        this.f1665b.O(z);
    }

    @Override // q1.AbstractC0602b
    public final void P(boolean z) {
        boolean z3;
        f fVar = this.f1665b;
        if (k.f1556j != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            fVar.f1664d = z;
        } else {
            fVar.P(z);
        }
    }

    @Override // q1.AbstractC0602b
    public final TransformationMethod Z(TransformationMethod transformationMethod) {
        boolean z;
        if (k.f1556j != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return transformationMethod;
        }
        return this.f1665b.Z(transformationMethod);
    }
}
