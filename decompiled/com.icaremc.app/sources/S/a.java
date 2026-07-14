package S;

import S2.l;
import T2.i;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends i implements l {

    /* renamed from: g, reason: collision with root package name */
    public static final a f1533g = new i(1);

    @Override // S2.l
    public final Object f(Object obj) {
        String valueOf;
        Map.Entry entry = (Map.Entry) obj;
        T2.h.e(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            byte[] bArr = (byte[]) value;
            T2.h.e(bArr, "<this>");
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "[");
            int i4 = 0;
            for (byte b4 : bArr) {
                i4++;
                if (i4 > 1) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) String.valueOf((int) b4));
            }
            sb.append((CharSequence) "]");
            valueOf = sb.toString();
        } else {
            valueOf = String.valueOf(entry.getValue());
        }
        return "  " + ((d) entry.getKey()).f1538a + " = " + valueOf;
    }
}
