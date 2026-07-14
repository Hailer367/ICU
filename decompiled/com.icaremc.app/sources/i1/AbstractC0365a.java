package i1;

import android.os.Build;

/* renamed from: i1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0365a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4103a;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 31) {
            i4 = 33554432;
        } else {
            i4 = 0;
        }
        f4103a = i4;
    }
}
