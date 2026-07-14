package P;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f647a;

    /* renamed from: b, reason: collision with root package name */
    public final int f648b;

    /* renamed from: c, reason: collision with root package name */
    public final long f649c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f650d;

    public d(byte[] bArr, int i2, int i3) {
        this(-1L, bArr, i2, i3);
    }

    public static d a(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new d(new byte[]{(byte) (str.charAt(0) - '0')}, 1, 1);
        }
        byte[] bytes = str.getBytes(h.f682a0);
        return new d(bytes, 1, bytes.length);
    }

    public static d b(String str) {
        byte[] bytes = str.concat("\u0000").getBytes(h.f682a0);
        return new d(bytes, 2, bytes.length);
    }

    public static d c(long j2, ByteOrder byteOrder) {
        return d(new long[]{j2}, byteOrder);
    }

    public static d d(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f673R[4] * jArr.length]);
        wrap.order(byteOrder);
        for (long j2 : jArr) {
            wrap.putInt((int) j2);
        }
        return new d(wrap.array(), 4, jArr.length);
    }

    public static d e(f[] fVarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f673R[5] * fVarArr.length]);
        wrap.order(byteOrder);
        for (f fVar : fVarArr) {
            wrap.putInt((int) fVar.f655a);
            wrap.putInt((int) fVar.f656b);
        }
        return new d(wrap.array(), 5, fVarArr.length);
    }

    public static d f(int i2, ByteOrder byteOrder) {
        return g(new int[]{i2}, byteOrder);
    }

    public static d g(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f673R[3] * iArr.length]);
        wrap.order(byteOrder);
        for (int i2 : iArr) {
            wrap.putShort((short) i2);
        }
        return new d(wrap.array(), 3, iArr.length);
    }

    public final double h(ByteOrder byteOrder) {
        Object k2 = k(byteOrder);
        if (k2 != null) {
            if (k2 instanceof String) {
                return Double.parseDouble((String) k2);
            }
            if (k2 instanceof long[]) {
                if (((long[]) k2).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k2 instanceof int[]) {
                if (((int[]) k2).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k2 instanceof double[]) {
                double[] dArr = (double[]) k2;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k2 instanceof f[]) {
                f[] fVarArr = (f[]) k2;
                if (fVarArr.length == 1) {
                    f fVar = fVarArr[0];
                    return fVar.f655a / fVar.f656b;
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a double value");
        }
        throw new NumberFormatException("NULL can't be converted to a double value");
    }

    public final int i(ByteOrder byteOrder) {
        Object k2 = k(byteOrder);
        if (k2 != null) {
            if (k2 instanceof String) {
                return Integer.parseInt((String) k2);
            }
            if (k2 instanceof long[]) {
                long[] jArr = (long[]) k2;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k2 instanceof int[]) {
                int[] iArr = (int[]) k2;
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
        Object k2 = k(byteOrder);
        if (k2 != null) {
            if (k2 instanceof String) {
                return (String) k2;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (k2 instanceof long[]) {
                long[] jArr = (long[]) k2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k2 instanceof int[]) {
                int[] iArr = (int[]) k2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k2 instanceof double[]) {
                double[] dArr = (double[]) k2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k2 instanceof f[]) {
                f[] fVarArr = (f[]) k2;
                while (i2 < fVarArr.length) {
                    sb.append(fVarArr[i2].f655a);
                    sb.append('/');
                    sb.append(fVarArr[i2].f656b);
                    i2++;
                    if (i2 != fVarArr.length) {
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
    /* JADX WARN: Type inference failed for: r14v25, types: [P.f[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v28, types: [P.f[]] */
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
        throw new UnsupportedOperationException("Method not decompiled: P.d.k(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        return "(" + h.f672Q[this.f647a] + ", data length:" + this.f650d.length + ")";
    }

    public d(long j2, byte[] bArr, int i2, int i3) {
        this.f647a = i2;
        this.f648b = i3;
        this.f649c = j2;
        this.f650d = bArr;
    }
}
