package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class a0 extends Writer {

    /* renamed from: g, reason: collision with root package name */
    public final StringBuilder f2834g = new StringBuilder(128);

    /* renamed from: f, reason: collision with root package name */
    public final String f2833f = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f2834g;
        if (sb.length() > 0) {
            Log.d(this.f2833f, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            char c4 = cArr[i4 + i6];
            if (c4 == '\n') {
                a();
            } else {
                this.f2834g.append(c4);
            }
        }
    }
}
