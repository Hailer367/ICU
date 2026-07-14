package p0;

import java.util.Objects;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final o[] f5806a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5807b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f5808c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5809d;

    public n(String str, o[] oVarArr) {
        this.f5807b = str;
        this.f5808c = null;
        this.f5806a = oVarArr;
        this.f5809d = 0;
    }

    public final void a(int i4) {
        String str;
        int i5 = this.f5809d;
        if (i4 == i5) {
            return;
        }
        StringBuilder sb = new StringBuilder("Wrong data accessor type detected. ");
        String str2 = "String";
        if (i5 == 0) {
            str = "String";
        } else if (i5 == 1) {
            str = "ArrayBuffer";
        } else {
            str = "Unknown";
        }
        sb.append(str);
        sb.append(" expected, but got ");
        if (i4 != 0) {
            if (i4 == 1) {
                str2 = "ArrayBuffer";
            } else {
                str2 = "Unknown";
            }
        }
        sb.append(str2);
        throw new IllegalStateException(sb.toString());
    }

    public n(byte[] bArr, o[] oVarArr) {
        Objects.requireNonNull(bArr);
        this.f5808c = bArr;
        this.f5807b = null;
        this.f5806a = oVarArr;
        this.f5809d = 1;
    }
}
