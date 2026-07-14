package T;

import I.H;
import P1.y;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f1568d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f1569a;

    /* renamed from: b, reason: collision with root package name */
    public final y f1570b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f1571c = 0;

    public o(y yVar, int i4) {
        this.f1570b = yVar;
        this.f1569a = i4;
    }

    public final int a(int i4) {
        U.a b4 = b();
        int a4 = b4.a(16);
        if (a4 != 0) {
            ByteBuffer byteBuffer = (ByteBuffer) b4.f694d;
            int i5 = a4 + b4.f691a;
            return byteBuffer.getInt((i4 * 4) + byteBuffer.getInt(i5) + i5 + 4);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [I.H, java.lang.Object] */
    public final U.a b() {
        ThreadLocal threadLocal = f1568d;
        U.a aVar = (U.a) threadLocal.get();
        U.a aVar2 = aVar;
        if (aVar == null) {
            ?? h3 = new H();
            threadLocal.set(h3);
            aVar2 = h3;
        }
        U.b bVar = (U.b) this.f1570b.f1469f;
        int a4 = bVar.a(6);
        if (a4 != 0) {
            int i4 = a4 + bVar.f691a;
            int i5 = (this.f1569a * 4) + ((ByteBuffer) bVar.f694d).getInt(i4) + i4 + 4;
            int i6 = ((ByteBuffer) bVar.f694d).getInt(i5) + i5;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f694d;
            aVar2.f694d = byteBuffer;
            if (byteBuffer != null) {
                aVar2.f691a = i6;
                int i7 = i6 - byteBuffer.getInt(i6);
                aVar2.f692b = i7;
                aVar2.f693c = ((ByteBuffer) aVar2.f694d).getShort(i7);
                return aVar2;
            }
            aVar2.f691a = 0;
            aVar2.f692b = 0;
            aVar2.f693c = 0;
        }
        return aVar2;
    }

    public final String toString() {
        int i4;
        int i5;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        U.a b4 = b();
        int a4 = b4.a(4);
        if (a4 != 0) {
            i4 = ((ByteBuffer) b4.f694d).getInt(a4 + b4.f691a);
        } else {
            i4 = 0;
        }
        sb.append(Integer.toHexString(i4));
        sb.append(", codepoints:");
        U.a b5 = b();
        int a5 = b5.a(16);
        if (a5 != 0) {
            int i6 = a5 + b5.f691a;
            i5 = ((ByteBuffer) b5.f694d).getInt(((ByteBuffer) b5.f694d).getInt(i6) + i6);
        } else {
            i5 = 0;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append(Integer.toHexString(a(i7)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
