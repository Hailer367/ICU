package t0;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import u0.h;
import w0.f;

/* renamed from: t0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0305c implements f {

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f3648b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f3649c;

    /* renamed from: e, reason: collision with root package name */
    public final A0.f f3651e;

    /* renamed from: f, reason: collision with root package name */
    public final A0.f f3652f;

    /* renamed from: a, reason: collision with root package name */
    public final DataEncoder f3647a = new JsonDataEncoderBuilder().configureWith(h.f3845c).ignoreNullValues(true).build();

    /* renamed from: d, reason: collision with root package name */
    public final URL f3650d = b(C0303a.f3638c);

    /* renamed from: g, reason: collision with root package name */
    public final int f3653g = 130000;

    public C0305c(Context context, A0.f fVar, A0.f fVar2) {
        this.f3649c = context;
        this.f3648b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f3651e = fVar2;
        this.f3652f = fVar;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(O.a.m("Invalid url: ", str), e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        if (((u0.u) u0.u.f3878c.get(r0)) != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v0.i a(v0.i r7) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.C0305c.a(v0.i):v0.i");
    }
}
