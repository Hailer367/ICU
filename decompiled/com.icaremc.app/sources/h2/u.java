package h2;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import s2.InterfaceC0633e;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class u implements x {

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0634f f4055f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f4056g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f4057h;

    /* renamed from: i, reason: collision with root package name */
    public final v f4058i;

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, h2.B] */
    public u(InterfaceC0634f interfaceC0634f) {
        HashMap hashMap = new HashMap();
        this.f4057h = hashMap;
        this.f4058i = new v();
        this.f4055f = interfaceC0634f;
        z zVar = AbstractC0343C.f3951a;
        ?? obj = new Object();
        obj.f3950a = false;
        C0342B c0342b = new C0342B[]{obj}[0];
        c0342b.getClass();
        hashMap.put(4294967556L, c0342b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r30.getKeyCode() == 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x02e0, code lost:
    
        r0.c(true, 0L, 0L, 0);
        r31.b(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x02ec, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02d5  */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object, h2.r] */
    @Override // h2.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.KeyEvent r30, Z0.D r31) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.u.a(android.view.KeyEvent, Z0.D):void");
    }

    public final void b(r rVar, final Z0.D d4) {
        InterfaceC0633e interfaceC0633e;
        int length;
        long j4;
        long j5;
        long j6;
        byte[] bArr = null;
        if (d4 == null) {
            interfaceC0633e = null;
        } else {
            interfaceC0633e = new InterfaceC0633e() { // from class: h2.s
                @Override // s2.InterfaceC0633e
                public final void a(ByteBuffer byteBuffer) {
                    boolean z;
                    Boolean bool = Boolean.FALSE;
                    if (byteBuffer != null) {
                        byteBuffer.rewind();
                        if (byteBuffer.capacity() != 0) {
                            if (byteBuffer.get() != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        }
                    } else {
                        Log.w("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
                    }
                    Z0.D.this.b(bool.booleanValue());
                }
            };
        }
        try {
            String str = rVar.f4048g;
            if (str != null) {
                bArr = str.getBytes("UTF-8");
            }
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 56);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(rVar.f4042a);
            int i4 = rVar.f4043b;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        j4 = 2;
                    } else {
                        throw null;
                    }
                } else {
                    j4 = 1;
                }
            } else {
                j4 = 0;
            }
            allocateDirect.putLong(j4);
            allocateDirect.putLong(rVar.f4044c);
            allocateDirect.putLong(rVar.f4045d);
            if (rVar.f4046e) {
                j5 = 1;
            } else {
                j5 = 0;
            }
            allocateDirect.putLong(j5);
            int i5 = rVar.f4047f;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                j6 = 4;
                            } else {
                                throw null;
                            }
                        } else {
                            j6 = 3;
                        }
                    } else {
                        j6 = 2;
                    }
                } else {
                    j6 = 1;
                }
            } else {
                j6 = 0;
            }
            allocateDirect.putLong(j6);
            if (bArr != null) {
                allocateDirect.put(bArr);
            }
            this.f4055f.e("flutter/keydata", allocateDirect, interfaceC0633e);
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, h2.r] */
    public final void c(boolean z, Long l3, Long l4, long j4) {
        int i4;
        ?? obj = new Object();
        obj.f4042a = j4;
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        obj.f4043b = i4;
        obj.f4045d = l3.longValue();
        obj.f4044c = l4.longValue();
        obj.f4048g = null;
        obj.f4046e = true;
        obj.f4047f = 1;
        if (l4.longValue() != 0 && l3.longValue() != 0) {
            if (!z) {
                l3 = null;
            }
            d(l4, l3);
        }
        b(obj, null);
    }

    public final void d(Long l3, Long l4) {
        HashMap hashMap = this.f4056g;
        if (l4 != null) {
            if (((Long) hashMap.put(l3, l4)) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (((Long) hashMap.remove(l3)) != null) {
        } else {
            throw new AssertionError("The key was empty");
        }
    }
}
