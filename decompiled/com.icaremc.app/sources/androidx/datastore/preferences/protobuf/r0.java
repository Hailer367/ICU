package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class r0 {

    /* renamed from: h, reason: collision with root package name */
    public static final n0 f2685h;

    /* renamed from: i, reason: collision with root package name */
    public static final o0 f2686i;

    /* renamed from: j, reason: collision with root package name */
    public static final p0 f2687j;
    public static final /* synthetic */ r0[] k;

    /* renamed from: f, reason: collision with root package name */
    public final s0 f2688f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2689g;

    /* JADX INFO: Fake field, exist only in values array */
    r0 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    r0 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    r0 EF2;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.datastore.preferences.protobuf.p0, androidx.datastore.preferences.protobuf.r0] */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.datastore.preferences.protobuf.n0, androidx.datastore.preferences.protobuf.r0] */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.datastore.preferences.protobuf.o0, androidx.datastore.preferences.protobuf.r0] */
    static {
        r0 r0Var = new r0("DOUBLE", 0, s0.DOUBLE, 1);
        r0 r0Var2 = new r0("FLOAT", 1, s0.FLOAT, 5);
        s0 s0Var = s0.LONG;
        r0 r0Var3 = new r0("INT64", 2, s0Var, 0);
        r0 r0Var4 = new r0("UINT64", 3, s0Var, 0);
        s0 s0Var2 = s0.INT;
        r0 r0Var5 = new r0("INT32", 4, s0Var2, 0);
        r0 r0Var6 = new r0("FIXED64", 5, s0Var, 1);
        r0 r0Var7 = new r0("FIXED32", 6, s0Var2, 5);
        r0 r0Var8 = new r0("BOOL", 7, s0.BOOLEAN, 0);
        ?? r0Var9 = new r0("STRING", 8, s0.STRING, 2);
        f2685h = r0Var9;
        s0 s0Var3 = s0.MESSAGE;
        ?? r0Var10 = new r0("GROUP", 9, s0Var3, 3);
        f2686i = r0Var10;
        ?? r0Var11 = new r0("MESSAGE", 10, s0Var3, 2);
        f2687j = r0Var11;
        k = new r0[]{r0Var, r0Var2, r0Var3, r0Var4, r0Var5, r0Var6, r0Var7, r0Var8, r0Var9, r0Var10, r0Var11, new r0("BYTES", 11, s0.BYTE_STRING, 2), new r0("UINT32", 12, s0Var2, 0), new r0("ENUM", 13, s0.ENUM, 0), new r0("SFIXED32", 14, s0Var2, 5), new r0("SFIXED64", 15, s0Var, 1), new r0("SINT32", 16, s0Var2, 0), new r0("SINT64", 17, s0Var, 0)};
    }

    public r0(String str, int i4, s0 s0Var, int i5) {
        this.f2688f = s0Var;
        this.f2689g = i5;
    }

    public static r0 valueOf(String str) {
        return (r0) Enum.valueOf(r0.class, str);
    }

    public static r0[] values() {
        return (r0[]) k.clone();
    }
}
