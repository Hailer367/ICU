package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0167y {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2709a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2710b;

    static {
        Charset.forName("US-ASCII");
        f2709a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2710b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new C0151h(bArr, 0, 0, false).e(0);
        } catch (A e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }
}
