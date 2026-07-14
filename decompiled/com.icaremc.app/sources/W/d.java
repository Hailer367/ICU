package W;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f1782a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1783b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1784c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f1785d;

    public d(byte[] bArr, int i4, int i5) {
        this(-1L, bArr, i4, i5);
    }

    public static d a(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new d(new byte[]{(byte) (str.charAt(0) - '0')}, 1, 1);
        }
        byte[] bytes = str.getBytes(h.f1817a0);
        return new d(bytes, 1, bytes.length);
    }

    public static d b(String str) {
        byte[] bytes = str.concat(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR).getBytes(h.f1817a0);
        return new d(bytes, 2, bytes.length);
    }

    public static d c(long j4, ByteOrder byteOrder) {
        return d(new long[]{j4}, byteOrder);
    }

    public static d d(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f1808R[4] * jArr.length]);
        wrap.order(byteOrder);
        for (long j4 : jArr) {
            wrap.putInt((int) j4);
        }
        return new d(wrap.array(), 4, jArr.length);
    }

    public static d e(f[] fVarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f1808R[5] * fVarArr.length]);
        wrap.order(byteOrder);
        for (f fVar : fVarArr) {
            wrap.putInt((int) fVar.f1790a);
            wrap.putInt((int) fVar.f1791b);
        }
        return new d(wrap.array(), 5, fVarArr.length);
    }

    public static d f(int i4, ByteOrder byteOrder) {
        return g(new int[]{i4}, byteOrder);
    }

    public static d g(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f1808R[3] * iArr.length]);
        wrap.order(byteOrder);
        for (int i4 : iArr) {
            wrap.putShort((short) i4);
        }
        return new d(wrap.array(), 3, iArr.length);
    }

    public final double h(ByteOrder byteOrder) {
        Object k = k(byteOrder);
        if (k != null) {
            if (k instanceof String) {
                return Double.parseDouble((String) k);
            }
            if (k instanceof long[]) {
                if (((long[]) k).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k instanceof int[]) {
                if (((int[]) k).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k instanceof double[]) {
                double[] dArr = (double[]) k;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k instanceof f[]) {
                f[] fVarArr = (f[]) k;
                if (fVarArr.length == 1) {
                    f fVar = fVarArr[0];
                    return fVar.f1790a / fVar.f1791b;
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a double value");
        }
        throw new NumberFormatException("NULL can't be converted to a double value");
    }

    public final int i(ByteOrder byteOrder) {
        Object k = k(byteOrder);
        if (k != null) {
            if (k instanceof String) {
                return Integer.parseInt((String) k);
            }
            if (k instanceof long[]) {
                long[] jArr = (long[]) k;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k instanceof int[]) {
                int[] iArr = (int[]) k;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a integer value");
        }
        throw new NumberFormatException("NULL can't be converted to a integer value");
    }

    public final String j(ByteOrder byteOrder) {
        Object k = k(byteOrder);
        if (k != null) {
            if (k instanceof String) {
                return (String) k;
            }
            StringBuilder sb = new StringBuilder();
            int i4 = 0;
            if (k instanceof long[]) {
                long[] jArr = (long[]) k;
                while (i4 < jArr.length) {
                    sb.append(jArr[i4]);
                    i4++;
                    if (i4 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k instanceof int[]) {
                int[] iArr = (int[]) k;
                while (i4 < iArr.length) {
                    sb.append(iArr[i4]);
                    i4++;
                    if (i4 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k instanceof double[]) {
                double[] dArr = (double[]) k;
                while (i4 < dArr.length) {
                    sb.append(dArr[i4]);
                    i4++;
                    if (i4 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k instanceof f[]) {
                f[] fVarArr = (f[]) k;
                while (i4 < fVarArr.length) {
                    sb.append(fVarArr[i4].f1790a);
                    sb.append('/');
                    sb.append(fVarArr[i4].f1791b);
                    i4++;
                    if (i4 != fVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:100:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v24, types: [long[]] */
    /* JADX WARN: Type inference failed for: r14v25, types: [W.f[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v28, types: [W.f[]] */
    /* JADX WARN: Type inference failed for: r14v29, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r14v31, types: [double[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable k(java.nio.ByteOrder r14) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.d.k(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        return "(" + h.f1807Q[this.f1782a] + ", data length:" + this.f1785d.length + ")";
    }

    public d(long j4, byte[] bArr, int i4, int i5) {
        this.f1782a = i4;
        this.f1783b = i5;
        this.f1784c = j4;
        this.f1785d = bArr;
    }
}
