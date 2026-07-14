package G0;

import I0.l;
import a.AbstractC0141a;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final String f554c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f555d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f556e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f557f;

    /* renamed from: a, reason: collision with root package name */
    public final String f558a;

    /* renamed from: b, reason: collision with root package name */
    public final String f559b;

    static {
        String u3 = AbstractC0141a.u("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f554c = u3;
        String u4 = AbstractC0141a.u("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String u5 = AbstractC0141a.u("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f555d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new F0.c("proto"), new F0.c("json"))));
        f556e = new a(u3, null);
        f557f = new a(u4, u5);
    }

    public a(String str, String str2) {
        this.f558a = str;
        this.f559b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }
}
