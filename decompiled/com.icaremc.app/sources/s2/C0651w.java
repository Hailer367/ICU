package s2;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: s2.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0651w implements InterfaceC0645q {

    /* renamed from: a, reason: collision with root package name */
    public static final C0651w f6163a;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s2.w] */
    static {
        C0650v c0650v = C0650v.f6160a;
        f6163a = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, s2.u, java.io.ByteArrayOutputStream] */
    @Override // s2.InterfaceC0645q
    public final ByteBuffer a(Object obj) {
        ?? byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(0);
        C0650v.f6160a.k(byteArrayOutputStream, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArrayOutputStream.size());
        allocateDirect.put(byteArrayOutputStream.a(), 0, byteArrayOutputStream.size());
        return allocateDirect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, s2.u, java.io.ByteArrayOutputStream] */
    @Override // s2.InterfaceC0645q
    public final ByteBuffer b(String str, String str2) {
        ?? byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(1);
        C0650v c0650v = C0650v.f6160a;
        c0650v.k(byteArrayOutputStream, "error");
        c0650v.k(byteArrayOutputStream, str);
        c0650v.k(byteArrayOutputStream, null);
        c0650v.k(byteArrayOutputStream, str2);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArrayOutputStream.size());
        allocateDirect.put(byteArrayOutputStream.a(), 0, byteArrayOutputStream.size());
        return allocateDirect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, s2.u, java.io.ByteArrayOutputStream] */
    @Override // s2.InterfaceC0645q
    public final ByteBuffer c(String str, String str2, Object obj) {
        ?? byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(1);
        C0650v c0650v = C0650v.f6160a;
        c0650v.k(byteArrayOutputStream, str);
        c0650v.k(byteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            c0650v.k(byteArrayOutputStream, Log.getStackTraceString((Throwable) obj));
        } else {
            c0650v.k(byteArrayOutputStream, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArrayOutputStream.size());
        allocateDirect.put(byteArrayOutputStream.a(), 0, byteArrayOutputStream.size());
        return allocateDirect;
    }

    @Override // s2.InterfaceC0645q
    public final C0641m d(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        C0650v c0650v = C0650v.f6160a;
        Object e4 = c0650v.e(byteBuffer);
        Object e5 = c0650v.e(byteBuffer);
        if ((e4 instanceof String) && !byteBuffer.hasRemaining()) {
            return new C0641m(e5, (String) e4);
        }
        throw new IllegalArgumentException("Method call corrupted");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 == 1) goto L10;
     */
    @Override // s2.InterfaceC0645q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L46
            goto L1e
        L11:
            s2.v r0 = s2.C0650v.f6160a
            java.lang.Object r0 = r0.e(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            s2.v r0 = s2.C0650v.f6160a
            java.lang.Object r1 = r0.e(r5)
            java.lang.Object r2 = r0.e(r5)
            java.lang.Object r0 = r0.e(r5)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L46
            if (r2 == 0) goto L36
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L46
        L36:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L46
            s2.i r5 = new s2.i
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = (java.lang.String) r2
            r5.<init>(r1, r2, r0)
            throw r5
        L46:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.C0651w.e(java.nio.ByteBuffer):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [s2.u, java.io.ByteArrayOutputStream] */
    @Override // s2.InterfaceC0645q
    public final ByteBuffer f(C0641m c0641m) {
        ?? byteArrayOutputStream = new ByteArrayOutputStream();
        C0650v c0650v = C0650v.f6160a;
        c0650v.k(byteArrayOutputStream, c0641m.f6155a);
        c0650v.k(byteArrayOutputStream, c0641m.f6156b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArrayOutputStream.size());
        allocateDirect.put(byteArrayOutputStream.a(), 0, byteArrayOutputStream.size());
        return allocateDirect;
    }
}
