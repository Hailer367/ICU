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
public final class EnumC0161s {

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC0161s f2690g;

    /* renamed from: h, reason: collision with root package name */
    public static final EnumC0161s f2691h;

    /* renamed from: i, reason: collision with root package name */
    public static final EnumC0161s[] f2692i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ EnumC0161s[] f2693j;

    /* renamed from: f, reason: collision with root package name */
    public final int f2694f;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0161s EF0;

    static {
        B b4 = B.DOUBLE;
        EnumC0161s enumC0161s = new EnumC0161s("DOUBLE", 0, 0, 1, b4);
        B b5 = B.FLOAT;
        EnumC0161s enumC0161s2 = new EnumC0161s("FLOAT", 1, 1, 1, b5);
        B b6 = B.LONG;
        EnumC0161s enumC0161s3 = new EnumC0161s("INT64", 2, 2, 1, b6);
        EnumC0161s enumC0161s4 = new EnumC0161s("UINT64", 3, 3, 1, b6);
        B b7 = B.INT;
        EnumC0161s enumC0161s5 = new EnumC0161s("INT32", 4, 4, 1, b7);
        EnumC0161s enumC0161s6 = new EnumC0161s("FIXED64", 5, 5, 1, b6);
        EnumC0161s enumC0161s7 = new EnumC0161s("FIXED32", 6, 6, 1, b7);
        B b8 = B.BOOLEAN;
        EnumC0161s enumC0161s8 = new EnumC0161s("BOOL", 7, 7, 1, b8);
        B b9 = B.STRING;
        EnumC0161s enumC0161s9 = new EnumC0161s("STRING", 8, 8, 1, b9);
        B b10 = B.MESSAGE;
        EnumC0161s enumC0161s10 = new EnumC0161s("MESSAGE", 9, 9, 1, b10);
        B b11 = B.BYTE_STRING;
        EnumC0161s enumC0161s11 = new EnumC0161s("BYTES", 10, 10, 1, b11);
        EnumC0161s enumC0161s12 = new EnumC0161s("UINT32", 11, 11, 1, b7);
        B b12 = B.ENUM;
        EnumC0161s enumC0161s13 = new EnumC0161s("ENUM", 12, 12, 1, b12);
        EnumC0161s enumC0161s14 = new EnumC0161s("SFIXED32", 13, 13, 1, b7);
        EnumC0161s enumC0161s15 = new EnumC0161s("SFIXED64", 14, 14, 1, b6);
        EnumC0161s enumC0161s16 = new EnumC0161s("SINT32", 15, 15, 1, b7);
        EnumC0161s enumC0161s17 = new EnumC0161s("SINT64", 16, 16, 1, b6);
        EnumC0161s enumC0161s18 = new EnumC0161s("GROUP", 17, 17, 1, b10);
        EnumC0161s enumC0161s19 = new EnumC0161s("DOUBLE_LIST", 18, 18, 2, b4);
        EnumC0161s enumC0161s20 = new EnumC0161s("FLOAT_LIST", 19, 19, 2, b5);
        EnumC0161s enumC0161s21 = new EnumC0161s("INT64_LIST", 20, 20, 2, b6);
        EnumC0161s enumC0161s22 = new EnumC0161s("UINT64_LIST", 21, 21, 2, b6);
        EnumC0161s enumC0161s23 = new EnumC0161s("INT32_LIST", 22, 22, 2, b7);
        EnumC0161s enumC0161s24 = new EnumC0161s("FIXED64_LIST", 23, 23, 2, b6);
        EnumC0161s enumC0161s25 = new EnumC0161s("FIXED32_LIST", 24, 24, 2, b7);
        EnumC0161s enumC0161s26 = new EnumC0161s("BOOL_LIST", 25, 25, 2, b8);
        EnumC0161s enumC0161s27 = new EnumC0161s("STRING_LIST", 26, 26, 2, b9);
        EnumC0161s enumC0161s28 = new EnumC0161s("MESSAGE_LIST", 27, 27, 2, b10);
        EnumC0161s enumC0161s29 = new EnumC0161s("BYTES_LIST", 28, 28, 2, b11);
        EnumC0161s enumC0161s30 = new EnumC0161s("UINT32_LIST", 29, 29, 2, b7);
        EnumC0161s enumC0161s31 = new EnumC0161s("ENUM_LIST", 30, 30, 2, b12);
        EnumC0161s enumC0161s32 = new EnumC0161s("SFIXED32_LIST", 31, 31, 2, b7);
        EnumC0161s enumC0161s33 = new EnumC0161s("SFIXED64_LIST", 32, 32, 2, b6);
        EnumC0161s enumC0161s34 = new EnumC0161s("SINT32_LIST", 33, 33, 2, b7);
        EnumC0161s enumC0161s35 = new EnumC0161s("SINT64_LIST", 34, 34, 2, b6);
        EnumC0161s enumC0161s36 = new EnumC0161s("DOUBLE_LIST_PACKED", 35, 35, 3, b4);
        f2690g = enumC0161s36;
        EnumC0161s enumC0161s37 = new EnumC0161s("FLOAT_LIST_PACKED", 36, 36, 3, b5);
        EnumC0161s enumC0161s38 = new EnumC0161s("INT64_LIST_PACKED", 37, 37, 3, b6);
        EnumC0161s enumC0161s39 = new EnumC0161s("UINT64_LIST_PACKED", 38, 38, 3, b6);
        EnumC0161s enumC0161s40 = new EnumC0161s("INT32_LIST_PACKED", 39, 39, 3, b7);
        EnumC0161s enumC0161s41 = new EnumC0161s("FIXED64_LIST_PACKED", 40, 40, 3, b6);
        EnumC0161s enumC0161s42 = new EnumC0161s("FIXED32_LIST_PACKED", 41, 41, 3, b7);
        EnumC0161s enumC0161s43 = new EnumC0161s("BOOL_LIST_PACKED", 42, 42, 3, b8);
        EnumC0161s enumC0161s44 = new EnumC0161s("UINT32_LIST_PACKED", 43, 43, 3, b7);
        EnumC0161s enumC0161s45 = new EnumC0161s("ENUM_LIST_PACKED", 44, 44, 3, b12);
        EnumC0161s enumC0161s46 = new EnumC0161s("SFIXED32_LIST_PACKED", 45, 45, 3, b7);
        EnumC0161s enumC0161s47 = new EnumC0161s("SFIXED64_LIST_PACKED", 46, 46, 3, b6);
        EnumC0161s enumC0161s48 = new EnumC0161s("SINT32_LIST_PACKED", 47, 47, 3, b7);
        EnumC0161s enumC0161s49 = new EnumC0161s("SINT64_LIST_PACKED", 48, 48, 3, b6);
        f2691h = enumC0161s49;
        f2693j = new EnumC0161s[]{enumC0161s, enumC0161s2, enumC0161s3, enumC0161s4, enumC0161s5, enumC0161s6, enumC0161s7, enumC0161s8, enumC0161s9, enumC0161s10, enumC0161s11, enumC0161s12, enumC0161s13, enumC0161s14, enumC0161s15, enumC0161s16, enumC0161s17, enumC0161s18, enumC0161s19, enumC0161s20, enumC0161s21, enumC0161s22, enumC0161s23, enumC0161s24, enumC0161s25, enumC0161s26, enumC0161s27, enumC0161s28, enumC0161s29, enumC0161s30, enumC0161s31, enumC0161s32, enumC0161s33, enumC0161s34, enumC0161s35, enumC0161s36, enumC0161s37, enumC0161s38, enumC0161s39, enumC0161s40, enumC0161s41, enumC0161s42, enumC0161s43, enumC0161s44, enumC0161s45, enumC0161s46, enumC0161s47, enumC0161s48, enumC0161s49, new EnumC0161s("GROUP_LIST", 49, 49, 2, b10), new EnumC0161s("MAP", 50, 50, 4, B.VOID)};
        EnumC0161s[] values = values();
        f2692i = new EnumC0161s[values.length];
        for (EnumC0161s enumC0161s50 : values) {
            f2692i[enumC0161s50.f2694f] = enumC0161s50;
        }
    }

    public EnumC0161s(String str, int i4, int i5, int i6, B b4) {
        this.f2694f = i5;
        int b5 = R.i.b(i6);
        if (b5 != 1) {
            if (b5 == 3) {
                b4.getClass();
            }
        } else {
            b4.getClass();
        }
        if (i6 == 1) {
            b4.ordinal();
        }
    }

    public static EnumC0161s valueOf(String str) {
        return (EnumC0161s) Enum.valueOf(EnumC0161s.class, str);
    }

    public static EnumC0161s[] values() {
        return (EnumC0161s[]) f2693j.clone();
    }
}
