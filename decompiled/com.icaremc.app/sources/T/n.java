package T;

import android.os.Trace;

/* loaded from: classes.dex */
public final class n implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            int i4 = E.g.f456a;
            Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (k.f1556j != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                k.a().c();
            }
            Trace.endSection();
        } catch (Throwable th) {
            int i5 = E.g.f456a;
            Trace.endSection();
            throw th;
        }
    }
}
