package androidx.preference;

import android.content.res.TypedArray;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EditTextPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130903182(0x7f03008e, float:1.7413175E38)
            r1 = 16842898(0x1010092, float:2.3693967E-38)
            int r0 = android.support.v4.media.session.a.m(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            int[] r1 = X.a.f827c
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            boolean r5 = r4.getBoolean(r2, r2)
            boolean r5 = r4.getBoolean(r2, r5)
            if (r5 == 0) goto L2e
            A0.f r5 = A0.f.f26d
            if (r5 != 0) goto L2a
            A0.f r5 = new A0.f
            r0 = 5
            r5.<init>(r0)
            A0.f.f26d = r5
        L2a:
            A0.f r5 = A0.f.f26d
            r3.f1882i = r5
        L2e:
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.EditTextPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }
}
