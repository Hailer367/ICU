package f0;

import android.content.pm.PackageInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* renamed from: f0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0285e {

    /* renamed from: a, reason: collision with root package name */
    public static final H1.f f3679a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f3680b = {112, 114, 111, 0};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f3681c = {112, 114, 109, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f3682d = {48, 49, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f3683e = {48, 49, 48, 0};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f3684f = {48, 48, 57, 0};

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f3685g = {48, 48, 53, 0};

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f3686h = {48, 48, 49, 0};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f3687i = {48, 48, 49, 0};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f3688j = {48, 48, 50, 0};

    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static byte[] b(C0282b[] c0282bArr, byte[] bArr) {
        int i4 = 0;
        int i5 = 0;
        for (C0282b c0282b : c0282bArr) {
            i5 += ((((c0282b.f3676g * 2) + 7) & (-8)) / 8) + (c0282b.f3674e * 2) + d(bArr, c0282b.f3670a, c0282b.f3671b).getBytes(StandardCharsets.UTF_8).length + 16 + c0282b.f3675f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i5);
        if (Arrays.equals(bArr, f3684f)) {
            int length = c0282bArr.length;
            while (i4 < length) {
                C0282b c0282b2 = c0282bArr[i4];
                q(byteArrayOutputStream, c0282b2, d(bArr, c0282b2.f3670a, c0282b2.f3671b));
                p(byteArrayOutputStream, c0282b2);
                i4++;
            }
        } else {
            for (C0282b c0282b3 : c0282bArr) {
                q(byteArrayOutputStream, c0282b3, d(bArr, c0282b3.f3670a, c0282b3.f3671b));
            }
            int length2 = c0282bArr.length;
            while (i4 < length2) {
                p(byteArrayOutputStream, c0282bArr[i4]);
                i4++;
            }
        }
        if (byteArrayOutputStream.size() == i5) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i5);
    }

    public static boolean c(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z = true;
            for (File file2 : listFiles) {
                if (c(file2) && z) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        file.delete();
        return true;
    }

    public static String d(byte[] bArr, String str, String str2) {
        Object obj;
        byte[] bArr2 = f3686h;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f3685g;
        String str3 = "!";
        if (!equals && !Arrays.equals(bArr, bArr3)) {
            obj = "!";
        } else {
            obj = ":";
        }
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            if (":".equals(obj)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (!str2.contains("!") && !str2.contains(":")) {
                if (!str2.endsWith(".apk")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                        str3 = ":";
                    }
                    return r2.k.c(sb, str3, str2);
                }
            } else {
                if ("!".equals(obj)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(obj)) {
                    return str2.replace("!", ":");
                }
            }
        }
        return str2;
    }

    public static void e(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] f(InputStream inputStream, int i4) {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int read = inputStream.read(bArr, i5, i4 - i5);
            if (read >= 0) {
                i5 += read;
            } else {
                throw new IllegalStateException(A2.i.g(i4, "Not enough bytes to read: "));
            }
        }
        return bArr;
    }

    public static int[] g(ByteArrayInputStream byteArrayInputStream, int i4) {
        int[] iArr = new int[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += (int) m(byteArrayInputStream, 2);
            iArr[i6] = i5;
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r0.finished() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] h(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L2e
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            r4 = r3
            r5 = r4
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            if (r4 >= r9) goto L57
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L2e
            if (r6 < 0) goto L3b
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L2e
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.lang.Throwable -> L2e java.util.zip.DataFormatException -> L30
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            goto L8a
        L30:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L3b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L57:
            if (r4 != r9) goto L6b
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L63
            r0.end()
            return r1
        L63:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            r8.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L8a:
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.AbstractC0285e.h(java.io.FileInputStream, int, int):byte[]");
    }

    public static C0282b[] i(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, C0282b[] c0282bArr) {
        byte[] bArr3 = f3687i;
        if (Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(f3682d, bArr2)) {
                if (Arrays.equals(bArr, bArr3)) {
                    int m3 = (int) m(fileInputStream, 1);
                    byte[] h3 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
                    if (fileInputStream.read() <= 0) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(h3);
                        try {
                            C0282b[] j4 = j(byteArrayInputStream, m3, c0282bArr);
                            byteArrayInputStream.close();
                            return j4;
                        } catch (Throwable th) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    throw new IllegalStateException("Content found after the end of file");
                }
                throw new IllegalStateException("Unsupported meta version");
            }
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (Arrays.equals(bArr, f3688j)) {
            int m4 = (int) m(fileInputStream, 2);
            byte[] h4 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(h4);
                try {
                    C0282b[] k = k(byteArrayInputStream2, bArr2, m4, c0282bArr);
                    byteArrayInputStream2.close();
                    return k;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported meta version");
    }

    public static C0282b[] j(ByteArrayInputStream byteArrayInputStream, int i4, C0282b[] c0282bArr) {
        if (byteArrayInputStream.available() == 0) {
            return new C0282b[0];
        }
        if (i4 == c0282bArr.length) {
            String[] strArr = new String[i4];
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int m3 = (int) m(byteArrayInputStream, 2);
                iArr[i5] = (int) m(byteArrayInputStream, 2);
                strArr[i5] = new String(f(byteArrayInputStream, m3), StandardCharsets.UTF_8);
            }
            for (int i6 = 0; i6 < i4; i6++) {
                C0282b c0282b = c0282bArr[i6];
                if (c0282b.f3671b.equals(strArr[i6])) {
                    int i7 = iArr[i6];
                    c0282b.f3674e = i7;
                    c0282b.f3677h = g(byteArrayInputStream, i7);
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return c0282bArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static C0282b[] k(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i4, C0282b[] c0282bArr) {
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new C0282b[0];
        }
        if (i4 == c0282bArr.length) {
            for (int i5 = 0; i5 < i4; i5++) {
                m(byteArrayInputStream, 2);
                String str2 = new String(f(byteArrayInputStream, (int) m(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
                long m3 = m(byteArrayInputStream, 4);
                int m4 = (int) m(byteArrayInputStream, 2);
                C0282b c0282b = null;
                if (c0282bArr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(":");
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= c0282bArr.length) {
                            break;
                        }
                        if (c0282bArr[i6].f3671b.equals(str)) {
                            c0282b = c0282bArr[i6];
                            break;
                        }
                        i6++;
                    }
                }
                if (c0282b != null) {
                    c0282b.f3673d = m3;
                    int[] g4 = g(byteArrayInputStream, m4);
                    if (Arrays.equals(bArr, f3686h)) {
                        c0282b.f3674e = m4;
                        c0282b.f3677h = g4;
                    }
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return c0282bArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static C0282b[] l(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, f3683e)) {
            int m3 = (int) m(fileInputStream, 1);
            byte[] h3 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(h3);
                try {
                    C0282b[] n3 = n(byteArrayInputStream, str, m3);
                    byteArrayInputStream.close();
                    return n3;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported version");
    }

    public static long m(InputStream inputStream, int i4) {
        byte[] f4 = f(inputStream, i4);
        long j4 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            j4 += (f4[i5] & 255) << (i5 * 8);
        }
        return j4;
    }

    public static C0282b[] n(ByteArrayInputStream byteArrayInputStream, String str, int i4) {
        int i5;
        int i6 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new C0282b[0];
        }
        C0282b[] c0282bArr = new C0282b[i4];
        for (int i7 = 0; i7 < i4; i7++) {
            int m3 = (int) m(byteArrayInputStream, 2);
            int m4 = (int) m(byteArrayInputStream, 2);
            c0282bArr[i7] = new C0282b(str, new String(f(byteArrayInputStream, m3), StandardCharsets.UTF_8), m(byteArrayInputStream, 4), m4, (int) m(byteArrayInputStream, 4), (int) m(byteArrayInputStream, 4), new int[m4], new TreeMap());
        }
        int i8 = 0;
        while (i8 < i4) {
            C0282b c0282b = c0282bArr[i8];
            int available = byteArrayInputStream.available();
            int i9 = c0282b.f3675f;
            int i10 = c0282b.f3676g;
            TreeMap treeMap = c0282b.f3678i;
            int i11 = available - i9;
            int i12 = i6;
            while (byteArrayInputStream.available() > i11) {
                i12 += (int) m(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i12), 1);
                int m5 = (int) m(byteArrayInputStream, 2);
                while (m5 > 0) {
                    m(byteArrayInputStream, 2);
                    int m6 = (int) m(byteArrayInputStream, 1);
                    if (m6 != 6 && m6 != 7) {
                        while (m6 > 0) {
                            m(byteArrayInputStream, 1);
                            int i13 = i6;
                            int i14 = i8;
                            for (int m7 = (int) m(byteArrayInputStream, 1); m7 > 0; m7--) {
                                m(byteArrayInputStream, 2);
                            }
                            m6--;
                            i6 = i13;
                            i8 = i14;
                        }
                    }
                    m5--;
                    i6 = i6;
                    i8 = i8;
                }
            }
            int i15 = i6;
            int i16 = i8;
            if (byteArrayInputStream.available() == i11) {
                c0282b.f3677h = g(byteArrayInputStream, c0282b.f3674e);
                BitSet valueOf = BitSet.valueOf(f(byteArrayInputStream, (((i10 * 2) + 7) & (-8)) / 8));
                for (int i17 = i15; i17 < i10; i17++) {
                    if (valueOf.get(i17)) {
                        i5 = 2;
                    } else {
                        i5 = i15;
                    }
                    if (valueOf.get(i17 + i10)) {
                        i5 |= 4;
                    }
                    if (i5 != 0) {
                        Integer num = (Integer) treeMap.get(Integer.valueOf(i17));
                        if (num == null) {
                            num = Integer.valueOf(i15);
                        }
                        treeMap.put(Integer.valueOf(i17), Integer.valueOf(i5 | num.intValue()));
                    }
                }
                i8 = i16 + 1;
                i6 = i15;
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return c0282bArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean o(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, C0282b[] c0282bArr) {
        long j4;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f3682d;
        int i4 = 0;
        if (Arrays.equals(bArr, bArr2)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                v(byteArrayOutputStream2, c0282bArr.length);
                int i5 = 2;
                int i6 = 2;
                for (C0282b c0282b : c0282bArr) {
                    u(byteArrayOutputStream2, c0282b.f3672c, 4);
                    u(byteArrayOutputStream2, c0282b.f3673d, 4);
                    u(byteArrayOutputStream2, c0282b.f3676g, 4);
                    String d4 = d(bArr2, c0282b.f3670a, c0282b.f3671b);
                    Charset charset = StandardCharsets.UTF_8;
                    int length2 = d4.getBytes(charset).length;
                    v(byteArrayOutputStream2, length2);
                    i6 = i6 + 14 + length2;
                    byteArrayOutputStream2.write(d4.getBytes(charset));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i6 == byteArray.length) {
                    k kVar = new k(1, byteArray, false);
                    byteArrayOutputStream2.close();
                    arrayList2.add(kVar);
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < c0282bArr.length) {
                        try {
                            C0282b c0282b2 = c0282bArr[i7];
                            v(byteArrayOutputStream3, i7);
                            v(byteArrayOutputStream3, c0282b2.f3674e);
                            i8 = i8 + 4 + (c0282b2.f3674e * i5);
                            int[] iArr = c0282b2.f3677h;
                            int length3 = iArr.length;
                            int i9 = i4;
                            int i10 = i5;
                            int i11 = i9;
                            while (i11 < length3) {
                                int i12 = iArr[i11];
                                v(byteArrayOutputStream3, i12 - i9);
                                i11++;
                                i9 = i12;
                            }
                            i7++;
                            i5 = i10;
                            i4 = 0;
                        } catch (Throwable th) {
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    if (i8 == byteArray2.length) {
                        k kVar2 = new k(3, byteArray2, true);
                        byteArrayOutputStream3.close();
                        arrayList2.add(kVar2);
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < c0282bArr.length) {
                            try {
                                C0282b c0282b3 = c0282bArr[i13];
                                Iterator it = c0282b3.f3678i.entrySet().iterator();
                                int i15 = 0;
                                while (it.hasNext()) {
                                    i15 |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
                                }
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                try {
                                    r(byteArrayOutputStream4, i15, c0282b3);
                                    byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                                    byteArrayOutputStream4.close();
                                    byteArrayOutputStream4 = new ByteArrayOutputStream();
                                    try {
                                        s(byteArrayOutputStream4, c0282b3);
                                        byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                                        byteArrayOutputStream4.close();
                                        v(byteArrayOutputStream3, i13);
                                        int length4 = byteArray3.length + 2 + byteArray4.length;
                                        int i16 = i14 + 6;
                                        ArrayList arrayList4 = arrayList3;
                                        u(byteArrayOutputStream3, length4, 4);
                                        v(byteArrayOutputStream3, i15);
                                        byteArrayOutputStream3.write(byteArray3);
                                        byteArrayOutputStream3.write(byteArray4);
                                        i14 = i16 + length4;
                                        i13++;
                                        arrayList3 = arrayList4;
                                    } finally {
                                    }
                                } finally {
                                }
                            } finally {
                                try {
                                    byteArrayOutputStream3.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
                        if (i14 == byteArray5.length) {
                            k kVar3 = new k(4, byteArray5, true);
                            byteArrayOutputStream3.close();
                            arrayList2.add(kVar3);
                            long j5 = 4;
                            long size = j5 + j5 + 4 + (arrayList2.size() * 16);
                            u(byteArrayOutputStream, arrayList2.size(), 4);
                            int i17 = 0;
                            while (i17 < arrayList2.size()) {
                                k kVar4 = (k) arrayList2.get(i17);
                                int i18 = kVar4.f3699a;
                                byte[] bArr3 = kVar4.f3700b;
                                if (i18 != 1) {
                                    if (i18 != 2) {
                                        if (i18 != 3) {
                                            if (i18 != 4) {
                                                if (i18 == 5) {
                                                    j4 = 4;
                                                } else {
                                                    throw null;
                                                }
                                            } else {
                                                j4 = 3;
                                            }
                                        } else {
                                            j4 = 2;
                                        }
                                    } else {
                                        j4 = 1;
                                    }
                                } else {
                                    j4 = 0;
                                }
                                u(byteArrayOutputStream, j4, 4);
                                u(byteArrayOutputStream, size, 4);
                                if (kVar4.f3701c) {
                                    long length5 = bArr3.length;
                                    byte[] a4 = a(bArr3);
                                    arrayList = arrayList5;
                                    arrayList.add(a4);
                                    u(byteArrayOutputStream, a4.length, 4);
                                    u(byteArrayOutputStream, length5, 4);
                                    length = a4.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr3);
                                    u(byteArrayOutputStream, bArr3.length, 4);
                                    u(byteArrayOutputStream, 0L, 4);
                                    length = bArr3.length;
                                }
                                size += length;
                                i17++;
                                arrayList5 = arrayList;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int i19 = 0; i19 < arrayList6.size(); i19++) {
                                byteArrayOutputStream.write((byte[]) arrayList6.get(i19));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray5.length);
                    }
                    throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
                }
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream2.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        }
        byte[] bArr4 = f3683e;
        if (Arrays.equals(bArr, bArr4)) {
            byte[] b4 = b(c0282bArr, bArr4);
            u(byteArrayOutputStream, c0282bArr.length, 1);
            u(byteArrayOutputStream, b4.length, 4);
            byte[] a5 = a(b4);
            u(byteArrayOutputStream, a5.length, 4);
            byteArrayOutputStream.write(a5);
            return true;
        }
        byte[] bArr5 = f3685g;
        if (Arrays.equals(bArr, bArr5)) {
            u(byteArrayOutputStream, c0282bArr.length, 1);
            for (C0282b c0282b4 : c0282bArr) {
                int size2 = c0282b4.f3678i.size() * 4;
                String d5 = d(bArr5, c0282b4.f3670a, c0282b4.f3671b);
                Charset charset2 = StandardCharsets.UTF_8;
                v(byteArrayOutputStream, d5.getBytes(charset2).length);
                v(byteArrayOutputStream, c0282b4.f3677h.length);
                u(byteArrayOutputStream, size2, 4);
                u(byteArrayOutputStream, c0282b4.f3672c, 4);
                byteArrayOutputStream.write(d5.getBytes(charset2));
                Iterator it2 = c0282b4.f3678i.keySet().iterator();
                while (it2.hasNext()) {
                    v(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                    v(byteArrayOutputStream, 0);
                }
                for (int i20 : c0282b4.f3677h) {
                    v(byteArrayOutputStream, i20);
                }
            }
            return true;
        }
        byte[] bArr6 = f3684f;
        if (Arrays.equals(bArr, bArr6)) {
            byte[] b5 = b(c0282bArr, bArr6);
            u(byteArrayOutputStream, c0282bArr.length, 1);
            u(byteArrayOutputStream, b5.length, 4);
            byte[] a6 = a(b5);
            u(byteArrayOutputStream, a6.length, 4);
            byteArrayOutputStream.write(a6);
            return true;
        }
        byte[] bArr7 = f3686h;
        if (Arrays.equals(bArr, bArr7)) {
            v(byteArrayOutputStream, c0282bArr.length);
            for (C0282b c0282b5 : c0282bArr) {
                String str = c0282b5.f3670a;
                TreeMap treeMap = c0282b5.f3678i;
                String d6 = d(bArr7, str, c0282b5.f3671b);
                Charset charset3 = StandardCharsets.UTF_8;
                v(byteArrayOutputStream, d6.getBytes(charset3).length);
                v(byteArrayOutputStream, treeMap.size());
                v(byteArrayOutputStream, c0282b5.f3677h.length);
                u(byteArrayOutputStream, c0282b5.f3672c, 4);
                byteArrayOutputStream.write(d6.getBytes(charset3));
                Iterator it3 = treeMap.keySet().iterator();
                while (it3.hasNext()) {
                    v(byteArrayOutputStream, ((Integer) it3.next()).intValue());
                }
                for (int i21 : c0282b5.f3677h) {
                    v(byteArrayOutputStream, i21);
                }
            }
            return true;
        }
        return false;
    }

    public static void p(ByteArrayOutputStream byteArrayOutputStream, C0282b c0282b) {
        s(byteArrayOutputStream, c0282b);
        int i4 = c0282b.f3676g;
        int[] iArr = c0282b.f3677h;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            v(byteArrayOutputStream, i7 - i6);
            i5++;
            i6 = i7;
        }
        byte[] bArr = new byte[(((i4 * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : c0282b.f3678i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                int i8 = intValue / 8;
                bArr[i8] = (byte) (bArr[i8] | (1 << (intValue % 8)));
            }
            if ((intValue2 & 4) != 0) {
                int i9 = intValue + i4;
                int i10 = i9 / 8;
                bArr[i10] = (byte) ((1 << (i9 % 8)) | bArr[i10]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void q(ByteArrayOutputStream byteArrayOutputStream, C0282b c0282b, String str) {
        Charset charset = StandardCharsets.UTF_8;
        v(byteArrayOutputStream, str.getBytes(charset).length);
        v(byteArrayOutputStream, c0282b.f3674e);
        u(byteArrayOutputStream, c0282b.f3675f, 4);
        u(byteArrayOutputStream, c0282b.f3672c, 4);
        u(byteArrayOutputStream, c0282b.f3676g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void r(ByteArrayOutputStream byteArrayOutputStream, int i4, C0282b c0282b) {
        int i5 = c0282b.f3676g;
        byte[] bArr = new byte[(((Integer.bitCount(i4 & (-2)) * i5) + 7) & (-8)) / 8];
        for (Map.Entry entry : c0282b.f3678i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i6 = 0;
            for (int i7 = 1; i7 <= 4; i7 <<= 1) {
                if (i7 != 1 && (i7 & i4) != 0) {
                    if ((i7 & intValue2) == i7) {
                        int i8 = (i6 * i5) + intValue;
                        int i9 = i8 / 8;
                        bArr[i9] = (byte) ((1 << (i8 % 8)) | bArr[i9]);
                    }
                    i6++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void s(ByteArrayOutputStream byteArrayOutputStream, C0282b c0282b) {
        int i4 = 0;
        for (Map.Entry entry : c0282b.f3678i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                v(byteArrayOutputStream, intValue - i4);
                v(byteArrayOutputStream, 0);
                i4 = intValue;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v26, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v27, types: [int] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void t(android.content.Context r18, java.util.concurrent.Executor r19, f0.InterfaceC0284d r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.AbstractC0285e.t(android.content.Context, java.util.concurrent.Executor, f0.d, boolean):void");
    }

    public static void u(ByteArrayOutputStream byteArrayOutputStream, long j4, int i4) {
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) ((j4 >> (i5 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void v(ByteArrayOutputStream byteArrayOutputStream, int i4) {
        u(byteArrayOutputStream, i4, 2);
    }
}
