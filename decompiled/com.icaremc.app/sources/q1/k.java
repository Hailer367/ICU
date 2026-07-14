package q1;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5968a;

    public k(Context context) {
        this.f5968a = context;
    }

    public static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j4 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j4 += a(file2);
            }
        }
        return j4;
    }
}
