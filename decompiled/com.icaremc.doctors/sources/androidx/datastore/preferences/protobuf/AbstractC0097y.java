package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0097y {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f1494a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1495b;

    static {
        Charset.forName("US-ASCII");
        f1494a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1495b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new C0081h(bArr, 0, 0, false).e(0);
        } catch (A e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
