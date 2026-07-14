package V;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class f extends AbstractC0602b {

    /* renamed from: b, reason: collision with root package name */
    public final TextView f1662b;

    /* renamed from: c, reason: collision with root package name */
    public final d f1663c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1664d = true;

    public f(TextView textView) {
        this.f1662b = textView;
        this.f1663c = new d(textView);
    }

    @Override // q1.AbstractC0602b
    public final InputFilter[] C(InputFilter[] inputFilterArr) {
        if (!this.f1664d) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i4 = 0; i4 < inputFilterArr.length; i4++) {
                InputFilter inputFilter = inputFilterArr[i4];
                if (inputFilter instanceof d) {
                    sparseArray.put(i4, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (sparseArray.indexOfKey(i6) < 0) {
                    inputFilterArr2[i5] = inputFilterArr[i6];
                    i5++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i7 = 0;
        while (true) {
            d dVar = this.f1663c;
            if (i7 < length2) {
                if (inputFilterArr[i7] == dVar) {
                    return inputFilterArr;
                }
                i7++;
            } else {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
        }
    }

    @Override // q1.AbstractC0602b
    public final boolean H() {
        return this.f1664d;
    }

    @Override // q1.AbstractC0602b
    public final void O(boolean z) {
        if (z) {
            TextView textView = this.f1662b;
            textView.setTransformationMethod(Z(textView.getTransformationMethod()));
        }
    }

    @Override // q1.AbstractC0602b
    public final void P(boolean z) {
        this.f1664d = z;
        TextView textView = this.f1662b;
        textView.setTransformationMethod(Z(textView.getTransformationMethod()));
        textView.setFilters(C(textView.getFilters()));
    }

    @Override // q1.AbstractC0602b
    public final TransformationMethod Z(TransformationMethod transformationMethod) {
        if (this.f1664d) {
            if (transformationMethod instanceof j) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return new j(transformationMethod);
        }
        if (transformationMethod instanceof j) {
            return ((j) transformationMethod).f1671f;
        }
        return transformationMethod;
    }
}
