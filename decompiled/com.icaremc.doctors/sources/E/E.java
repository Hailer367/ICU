package E;

import android.view.View;

/* loaded from: classes.dex */
public abstract class E {
    public static int a(View view) {
        return view.getImportantForAutofill();
    }

    public static void b(View view, int i2) {
        view.setImportantForAutofill(i2);
    }
}
