package V1;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1739a;

    static {
        int i4;
        String property = System.getProperty("java.version");
        try {
            String[] split = property.split("[._]", 3);
            i4 = Integer.parseInt(split[0]);
            if (i4 == 1 && split.length > 1) {
                i4 = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException unused) {
            i4 = -1;
        }
        if (i4 == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i5 = 0; i5 < property.length(); i5++) {
                    char charAt = property.charAt(i5);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb.append(charAt);
                }
                i4 = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i4 = -1;
            }
        }
        if (i4 == -1) {
            i4 = 6;
        }
        f1739a = i4;
    }
}
