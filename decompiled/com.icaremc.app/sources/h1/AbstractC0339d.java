package h1;

import android.os.Build;

/* renamed from: h1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0339d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3947a;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 31) {
            i4 = 33554432;
        } else {
            i4 = 0;
        }
        f3947a = i4;
    }
}
