package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0091s {

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0091s f1474d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0091s f1475e;

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0091s[] f1476f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumC0091s[] f1477g;

    /* renamed from: c, reason: collision with root package name */
    public final int f1478c;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0091s EF0;

    static {
        B b2 = B.DOUBLE;
        EnumC0091s enumC0091s = new EnumC0091s("DOUBLE", 0, 0, 1, b2);
        B b3 = B.FLOAT;
        EnumC0091s enumC0091s2 = new EnumC0091s("FLOAT", 1, 1, 1, b3);
        B b4 = B.LONG;
        EnumC0091s enumC0091s3 = new EnumC0091s("INT64", 2, 2, 1, b4);
        EnumC0091s enumC0091s4 = new EnumC0091s("UINT64", 3, 3, 1, b4);
        B b5 = B.INT;
        EnumC0091s enumC0091s5 = new EnumC0091s("INT32", 4, 4, 1, b5);
        EnumC0091s enumC0091s6 = new EnumC0091s("FIXED64", 5, 5, 1, b4);
        EnumC0091s enumC0091s7 = new EnumC0091s("FIXED32", 6, 6, 1, b5);
        B b6 = B.BOOLEAN;
        EnumC0091s enumC0091s8 = new EnumC0091s("BOOL", 7, 7, 1, b6);
        B b7 = B.STRING;
        EnumC0091s enumC0091s9 = new EnumC0091s("STRING", 8, 8, 1, b7);
        B b8 = B.MESSAGE;
        EnumC0091s enumC0091s10 = new EnumC0091s("MESSAGE", 9, 9, 1, b8);
        B b9 = B.BYTE_STRING;
        EnumC0091s enumC0091s11 = new EnumC0091s("BYTES", 10, 10, 1, b9);
        EnumC0091s enumC0091s12 = new EnumC0091s("UINT32", 11, 11, 1, b5);
        B b10 = B.ENUM;
        EnumC0091s enumC0091s13 = new EnumC0091s("ENUM", 12, 12, 1, b10);
        EnumC0091s enumC0091s14 = new EnumC0091s("SFIXED32", 13, 13, 1, b5);
        EnumC0091s enumC0091s15 = new EnumC0091s("SFIXED64", 14, 14, 1, b4);
        EnumC0091s enumC0091s16 = new EnumC0091s("SINT32", 15, 15, 1, b5);
        EnumC0091s enumC0091s17 = new EnumC0091s("SINT64", 16, 16, 1, b4);
        EnumC0091s enumC0091s18 = new EnumC0091s("GROUP", 17, 17, 1, b8);
        EnumC0091s enumC0091s19 = new EnumC0091s("DOUBLE_LIST", 18, 18, 2, b2);
        EnumC0091s enumC0091s20 = new EnumC0091s("FLOAT_LIST", 19, 19, 2, b3);
        EnumC0091s enumC0091s21 = new EnumC0091s("INT64_LIST", 20, 20, 2, b4);
        EnumC0091s enumC0091s22 = new EnumC0091s("UINT64_LIST", 21, 21, 2, b4);
        EnumC0091s enumC0091s23 = new EnumC0091s("INT32_LIST", 22, 22, 2, b5);
        EnumC0091s enumC0091s24 = new EnumC0091s("FIXED64_LIST", 23, 23, 2, b4);
        EnumC0091s enumC0091s25 = new EnumC0091s("FIXED32_LIST", 24, 24, 2, b5);
        EnumC0091s enumC0091s26 = new EnumC0091s("BOOL_LIST", 25, 25, 2, b6);
        EnumC0091s enumC0091s27 = new EnumC0091s("STRING_LIST", 26, 26, 2, b7);
        EnumC0091s enumC0091s28 = new EnumC0091s("MESSAGE_LIST", 27, 27, 2, b8);
        EnumC0091s enumC0091s29 = new EnumC0091s("BYTES_LIST", 28, 28, 2, b9);
        EnumC0091s enumC0091s30 = new EnumC0091s("UINT32_LIST", 29, 29, 2, b5);
        EnumC0091s enumC0091s31 = new EnumC0091s("ENUM_LIST", 30, 30, 2, b10);
        EnumC0091s enumC0091s32 = new EnumC0091s("SFIXED32_LIST", 31, 31, 2, b5);
        EnumC0091s enumC0091s33 = new EnumC0091s("SFIXED64_LIST", 32, 32, 2, b4);
        EnumC0091s enumC0091s34 = new EnumC0091s("SINT32_LIST", 33, 33, 2, b5);
        EnumC0091s enumC0091s35 = new EnumC0091s("SINT64_LIST", 34, 34, 2, b4);
        EnumC0091s enumC0091s36 = new EnumC0091s("DOUBLE_LIST_PACKED", 35, 35, 3, b2);
        f1474d = enumC0091s36;
        EnumC0091s enumC0091s37 = new EnumC0091s("FLOAT_LIST_PACKED", 36, 36, 3, b3);
        EnumC0091s enumC0091s38 = new EnumC0091s("INT64_LIST_PACKED", 37, 37, 3, b4);
        EnumC0091s enumC0091s39 = new EnumC0091s("UINT64_LIST_PACKED", 38, 38, 3, b4);
        EnumC0091s enumC0091s40 = new EnumC0091s("INT32_LIST_PACKED", 39, 39, 3, b5);
        EnumC0091s enumC0091s41 = new EnumC0091s("FIXED64_LIST_PACKED", 40, 40, 3, b4);
        EnumC0091s enumC0091s42 = new EnumC0091s("FIXED32_LIST_PACKED", 41, 41, 3, b5);
        EnumC0091s enumC0091s43 = new EnumC0091s("BOOL_LIST_PACKED", 42, 42, 3, b6);
        EnumC0091s enumC0091s44 = new EnumC0091s("UINT32_LIST_PACKED", 43, 43, 3, b5);
        EnumC0091s enumC0091s45 = new EnumC0091s("ENUM_LIST_PACKED", 44, 44, 3, b10);
        EnumC0091s enumC0091s46 = new EnumC0091s("SFIXED32_LIST_PACKED", 45, 45, 3, b5);
        EnumC0091s enumC0091s47 = new EnumC0091s("SFIXED64_LIST_PACKED", 46, 46, 3, b4);
        EnumC0091s enumC0091s48 = new EnumC0091s("SINT32_LIST_PACKED", 47, 47, 3, b5);
        EnumC0091s enumC0091s49 = new EnumC0091s("SINT64_LIST_PACKED", 48, 48, 3, b4);
        f1475e = enumC0091s49;
        f1477g = new EnumC0091s[]{enumC0091s, enumC0091s2, enumC0091s3, enumC0091s4, enumC0091s5, enumC0091s6, enumC0091s7, enumC0091s8, enumC0091s9, enumC0091s10, enumC0091s11, enumC0091s12, enumC0091s13, enumC0091s14, enumC0091s15, enumC0091s16, enumC0091s17, enumC0091s18, enumC0091s19, enumC0091s20, enumC0091s21, enumC0091s22, enumC0091s23, enumC0091s24, enumC0091s25, enumC0091s26, enumC0091s27, enumC0091s28, enumC0091s29, enumC0091s30, enumC0091s31, enumC0091s32, enumC0091s33, enumC0091s34, enumC0091s35, enumC0091s36, enumC0091s37, enumC0091s38, enumC0091s39, enumC0091s40, enumC0091s41, enumC0091s42, enumC0091s43, enumC0091s44, enumC0091s45, enumC0091s46, enumC0091s47, enumC0091s48, enumC0091s49, new EnumC0091s("GROUP_LIST", 49, 49, 2, b8), new EnumC0091s("MAP", 50, 50, 4, B.VOID)};
        EnumC0091s[] values = values();
        f1476f = new EnumC0091s[values.length];
        for (EnumC0091s enumC0091s50 : values) {
            f1476f[enumC0091s50.f1478c] = enumC0091s50;
        }
    }

    public EnumC0091s(String str, int i2, int i3, int i4, B b2) {
        this.f1478c = i3;
        int b3 = N.i.b(i4);
        if (b3 != 1) {
            if (b3 == 3) {
                b2.getClass();
            }
        } else {
            b2.getClass();
        }
        if (i4 == 1) {
            b2.ordinal();
        }
    }

    public static EnumC0091s valueOf(String str) {
        return (EnumC0091s) Enum.valueOf(EnumC0091s.class, str);
    }

    public static EnumC0091s[] values() {
        return (EnumC0091s[]) f1477g.clone();
    }
}
