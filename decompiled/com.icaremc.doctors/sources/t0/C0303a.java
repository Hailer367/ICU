package t0;

import a.AbstractC0051a;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import s0.C0301c;
import v0.l;

/* renamed from: t0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0303a implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final String f3638c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f3639d;

    /* renamed from: e, reason: collision with root package name */
    public static final C0303a f3640e;

    /* renamed from: f, reason: collision with root package name */
    public static final C0303a f3641f;

    /* renamed from: a, reason: collision with root package name */
    public final String f3642a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3643b;

    static {
        String G2 = AbstractC0051a.G("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f3638c = G2;
        String G3 = AbstractC0051a.G("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String G4 = AbstractC0051a.G("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f3639d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C0301c("proto"), new C0301c("json"))));
        f3640e = new C0303a(G2, null);
        f3641f = new C0303a(G3, G4);
    }

    public C0303a(String str, String str2) {
        this.f3642a = str;
        this.f3643b = str2;
    }

    public static C0303a a(byte[] bArr) {
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
                    return new C0303a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }
}
