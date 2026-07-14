package s2;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: s2.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0650v implements InterfaceC0640l {

    /* renamed from: a, reason: collision with root package name */
    public static final C0650v f6160a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f6161b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f6162c;

    /* JADX WARN: Type inference failed for: r0v0, types: [s2.v, java.lang.Object] */
    static {
        boolean z;
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            z = true;
        } else {
            z = false;
        }
        f6161b = z;
        f6162c = Charset.forName("UTF8");
    }

    public static void c(ByteBuffer byteBuffer, int i4) {
        int position = byteBuffer.position() % i4;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i4) - position);
        }
    }

    public static int d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            int i4 = byteBuffer.get() & 255;
            if (i4 < 254) {
                return i4;
            }
            if (i4 == 254) {
                return byteBuffer.getChar();
            }
            return byteBuffer.getInt();
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public static void g(C0649u c0649u, int i4) {
        int size = c0649u.size() % i4;
        if (size != 0) {
            for (int i5 = 0; i5 < i4 - size; i5++) {
                c0649u.write(0);
            }
        }
    }

    public static void h(C0649u c0649u, int i4) {
        if (f6161b) {
            c0649u.write(i4);
            c0649u.write(i4 >>> 8);
            c0649u.write(i4 >>> 16);
            c0649u.write(i4 >>> 24);
            return;
        }
        c0649u.write(i4 >>> 24);
        c0649u.write(i4 >>> 16);
        c0649u.write(i4 >>> 8);
        c0649u.write(i4);
    }

    public static void i(C0649u c0649u, long j4) {
        if (f6161b) {
            c0649u.write((byte) j4);
            c0649u.write((byte) (j4 >>> 8));
            c0649u.write((byte) (j4 >>> 16));
            c0649u.write((byte) (j4 >>> 24));
            c0649u.write((byte) (j4 >>> 32));
            c0649u.write((byte) (j4 >>> 40));
            c0649u.write((byte) (j4 >>> 48));
            c0649u.write((byte) (j4 >>> 56));
            return;
        }
        c0649u.write((byte) (j4 >>> 56));
        c0649u.write((byte) (j4 >>> 48));
        c0649u.write((byte) (j4 >>> 40));
        c0649u.write((byte) (j4 >>> 32));
        c0649u.write((byte) (j4 >>> 24));
        c0649u.write((byte) (j4 >>> 16));
        c0649u.write((byte) (j4 >>> 8));
        c0649u.write((byte) j4);
    }

    public static void j(C0649u c0649u, int i4) {
        if (i4 < 254) {
            c0649u.write(i4);
            return;
        }
        if (i4 <= 65535) {
            c0649u.write(254);
            if (f6161b) {
                c0649u.write(i4);
                c0649u.write(i4 >>> 8);
                return;
            } else {
                c0649u.write(i4 >>> 8);
                c0649u.write(i4);
                return;
            }
        }
        c0649u.write(255);
        h(c0649u, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [s2.u, java.io.ByteArrayOutputStream] */
    @Override // s2.InterfaceC0640l
    public final ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        ?? byteArrayOutputStream = new ByteArrayOutputStream();
        k(byteArrayOutputStream, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArrayOutputStream.size());
        allocateDirect.put(byteArrayOutputStream.a(), 0, byteArrayOutputStream.size());
        return allocateDirect;
    }

    @Override // s2.InterfaceC0640l
    public final Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object e4 = e(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return e4;
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public final Object e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return f(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public Object f(byte b4, ByteBuffer byteBuffer) {
        Charset charset = f6162c;
        int i4 = 0;
        switch (b4) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                byte[] bArr = new byte[d(byteBuffer)];
                byteBuffer.get(bArr);
                return new BigInteger(new String(bArr, charset), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                byte[] bArr2 = new byte[d(byteBuffer)];
                byteBuffer.get(bArr2);
                return new String(bArr2, charset);
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                byte[] bArr3 = new byte[d(byteBuffer)];
                byteBuffer.get(bArr3);
                return bArr3;
            case 9:
                int d4 = d(byteBuffer);
                int[] iArr = new int[d4];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr);
                byteBuffer.position((d4 * 4) + byteBuffer.position());
                return iArr;
            case 10:
                int d5 = d(byteBuffer);
                long[] jArr = new long[d5];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr);
                byteBuffer.position((d5 * 8) + byteBuffer.position());
                return jArr;
            case 11:
                int d6 = d(byteBuffer);
                double[] dArr = new double[d6];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                byteBuffer.position((d6 * 8) + byteBuffer.position());
                return dArr;
            case 12:
                int d7 = d(byteBuffer);
                ArrayList arrayList = new ArrayList(d7);
                while (i4 < d7) {
                    arrayList.add(e(byteBuffer));
                    i4++;
                }
                return arrayList;
            case 13:
                int d8 = d(byteBuffer);
                HashMap hashMap = new HashMap();
                while (i4 < d8) {
                    hashMap.put(e(byteBuffer), e(byteBuffer));
                    i4++;
                }
                return hashMap;
            case 14:
                int d9 = d(byteBuffer);
                float[] fArr = new float[d9];
                c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr);
                byteBuffer.position((d9 * 4) + byteBuffer.position());
                return fArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    public void k(C0649u c0649u, Object obj) {
        int i4;
        int i5 = 0;
        if (obj != null && !obj.equals(null)) {
            if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    i4 = 1;
                } else {
                    i4 = 2;
                }
                c0649u.write(i4);
                return;
            }
            boolean z = obj instanceof Number;
            Charset charset = f6162c;
            if (z) {
                if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                    if (obj instanceof Long) {
                        c0649u.write(4);
                        i(c0649u, ((Long) obj).longValue());
                        return;
                    }
                    if (!(obj instanceof Float) && !(obj instanceof Double)) {
                        if (obj instanceof BigInteger) {
                            c0649u.write(5);
                            byte[] bytes = ((BigInteger) obj).toString(16).getBytes(charset);
                            j(c0649u, bytes.length);
                            c0649u.write(bytes, 0, bytes.length);
                            return;
                        }
                        throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                    }
                    c0649u.write(6);
                    g(c0649u, 8);
                    i(c0649u, Double.doubleToLongBits(((Number) obj).doubleValue()));
                    return;
                }
                c0649u.write(3);
                h(c0649u, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof CharSequence) {
                c0649u.write(7);
                byte[] bytes2 = obj.toString().getBytes(charset);
                j(c0649u, bytes2.length);
                c0649u.write(bytes2, 0, bytes2.length);
                return;
            }
            if (obj instanceof byte[]) {
                c0649u.write(8);
                byte[] bArr = (byte[]) obj;
                j(c0649u, bArr.length);
                c0649u.write(bArr, 0, bArr.length);
                return;
            }
            if (obj instanceof int[]) {
                c0649u.write(9);
                int[] iArr = (int[]) obj;
                j(c0649u, iArr.length);
                g(c0649u, 4);
                int length = iArr.length;
                while (i5 < length) {
                    h(c0649u, iArr[i5]);
                    i5++;
                }
                return;
            }
            if (obj instanceof long[]) {
                c0649u.write(10);
                long[] jArr = (long[]) obj;
                j(c0649u, jArr.length);
                g(c0649u, 8);
                int length2 = jArr.length;
                while (i5 < length2) {
                    i(c0649u, jArr[i5]);
                    i5++;
                }
                return;
            }
            if (obj instanceof double[]) {
                c0649u.write(11);
                double[] dArr = (double[]) obj;
                j(c0649u, dArr.length);
                g(c0649u, 8);
                int length3 = dArr.length;
                while (i5 < length3) {
                    i(c0649u, Double.doubleToLongBits(dArr[i5]));
                    i5++;
                }
                return;
            }
            if (obj instanceof List) {
                c0649u.write(12);
                List list = (List) obj;
                j(c0649u, list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    k(c0649u, it.next());
                }
                return;
            }
            if (obj instanceof Map) {
                c0649u.write(13);
                Map map = (Map) obj;
                j(c0649u, map.size());
                for (Map.Entry entry : map.entrySet()) {
                    k(c0649u, entry.getKey());
                    k(c0649u, entry.getValue());
                }
                return;
            }
            if (obj instanceof float[]) {
                c0649u.write(14);
                float[] fArr = (float[]) obj;
                j(c0649u, fArr.length);
                g(c0649u, 4);
                int length4 = fArr.length;
                while (i5 < length4) {
                    h(c0649u, Float.floatToIntBits(fArr[i5]));
                    i5++;
                }
                return;
            }
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
        c0649u.write(0);
    }
}
