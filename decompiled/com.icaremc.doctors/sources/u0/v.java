package u0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: c, reason: collision with root package name */
    public static final SparseArray f3880c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ v[] f3881d;

    /* JADX INFO: Fake field, exist only in values array */
    v EF1;

    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, u0.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, u0.v, java.lang.Object] */
    static {
        ?? r1 = new Enum("MOBILE", 0);
        ?? r2 = new Enum("WIFI", 1);
        ?? r3 = new Enum("MOBILE_MMS", 2);
        ?? r4 = new Enum("MOBILE_SUPL", 3);
        ?? r5 = new Enum("MOBILE_DUN", 4);
        ?? r6 = new Enum("MOBILE_HIPRI", 5);
        ?? r7 = new Enum("WIMAX", 6);
        ?? r8 = new Enum("BLUETOOTH", 7);
        ?? r9 = new Enum("DUMMY", 8);
        ?? r10 = new Enum("ETHERNET", 9);
        ?? r11 = new Enum("MOBILE_FOTA", 10);
        ?? r12 = new Enum("MOBILE_IMS", 11);
        ?? r13 = new Enum("MOBILE_CBS", 12);
        ?? r14 = new Enum("WIFI_P2P", 13);
        ?? r15 = new Enum("MOBILE_IA", 14);
        ?? r02 = new Enum("MOBILE_EMERGENCY", 15);
        ?? r16 = new Enum("PROXY", 16);
        ?? r22 = new Enum("VPN", 17);
        ?? r03 = new Enum("NONE", 18);
        f3881d = new v[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r02, r16, r22, r03};
        SparseArray sparseArray = new SparseArray();
        f3880c = sparseArray;
        sparseArray.put(0, r1);
        sparseArray.put(1, r2);
        sparseArray.put(2, r3);
        sparseArray.put(3, r4);
        sparseArray.put(4, r5);
        sparseArray.put(5, r6);
        sparseArray.put(6, r7);
        sparseArray.put(7, r8);
        sparseArray.put(8, r9);
        sparseArray.put(9, r10);
        sparseArray.put(10, r11);
        sparseArray.put(11, r12);
        sparseArray.put(12, r13);
        sparseArray.put(13, r14);
        sparseArray.put(14, r15);
        sparseArray.put(15, r02);
        sparseArray.put(16, r16);
        sparseArray.put(17, r22);
        sparseArray.put(-1, r03);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f3881d.clone();
    }
}
