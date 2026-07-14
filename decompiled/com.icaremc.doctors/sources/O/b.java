package O;

import c1.l;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends kotlin.jvm.internal.i implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final b f626c = new kotlin.jvm.internal.i(1);

    @Override // c1.l
    public final Object invoke(Object obj) {
        String valueOf;
        Map.Entry entry = (Map.Entry) obj;
        kotlin.jvm.internal.h.e(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            byte[] bArr = (byte[]) value;
            kotlin.jvm.internal.h.e(bArr, "<this>");
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "[");
            int i2 = 0;
            for (byte b2 : bArr) {
                i2++;
                if (i2 > 1) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) String.valueOf((int) b2));
            }
            sb.append((CharSequence) "]");
            valueOf = sb.toString();
        } else {
            valueOf = String.valueOf(entry.getValue());
        }
        return a.j(new StringBuilder("  "), ((e) entry.getKey()).f632a, " = ", valueOf);
    }
}
