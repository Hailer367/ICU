package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class B0 extends Writer {

    /* renamed from: d, reason: collision with root package name */
    public final StringBuilder f1504d = new StringBuilder(128);

    /* renamed from: c, reason: collision with root package name */
    public final String f1503c = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f1504d;
        if (sb.length() > 0) {
            Log.d(this.f1503c, sb.toString());
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
    public final void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f1504d.append(c2);
            }
        }
    }
}
