package s2;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class x implements InterfaceC0640l {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f6164a = Charset.forName("UTF8");

    /* renamed from: b, reason: collision with root package name */
    public static final x f6165b = new Object();

    public static String c(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i4;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i4 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i4 = 0;
        }
        return new String(bArr, i4, remaining, f6164a);
    }

    public static ByteBuffer d(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f6164a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }

    @Override // s2.InterfaceC0640l
    public final /* bridge */ /* synthetic */ ByteBuffer a(Object obj) {
        return d((String) obj);
    }

    @Override // s2.InterfaceC0640l
    public final /* bridge */ /* synthetic */ Object b(ByteBuffer byteBuffer) {
        return c(byteBuffer);
    }
}
