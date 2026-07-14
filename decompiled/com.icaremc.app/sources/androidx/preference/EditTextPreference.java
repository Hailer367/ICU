package androidx.preference;

import android.content.res.TypedArray;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, W0.g] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EditTextPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130903187(0x7f030093, float:1.7413185E38)
            r1 = 16842898(0x1010092, float:2.3693967E-38)
            int r0 = A.b.a(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            int[] r1 = e0.AbstractC0274b.f3588c
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            boolean r5 = r4.getBoolean(r2, r2)
            boolean r5 = r4.getBoolean(r2, r5)
            if (r5 == 0) goto L2d
            W0.g r5 = W0.g.f1867g
            if (r5 != 0) goto L29
            W0.g r5 = new W0.g
            r5.<init>()
            W0.g.f1867g = r5
        L29:
            W0.g r5 = W0.g.f1867g
            r3.f3063l = r5
        L2d:
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.EditTextPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i4) {
        return typedArray.getString(i4);
    }
}
