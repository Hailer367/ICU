package I;

import android.view.View;

/* loaded from: classes.dex */
public abstract class M {
    public static int a(View view) {
        return view.getImportantForAutofill();
    }

    public static void b(View view, int i4) {
        view.setImportantForAutofill(i4);
    }
}
