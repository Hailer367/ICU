package u;

import E.AbstractC0005e;
import android.app.Notification;
import android.app.Person;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f3779a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3780b;

    /* renamed from: c, reason: collision with root package name */
    public final K f3781c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f3782d = new Bundle();

    /* renamed from: e, reason: collision with root package name */
    public String f3783e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f3784f;

    public t(CharSequence charSequence, long j2, K k2) {
        this.f3779a = charSequence;
        this.f3780b = j2;
        this.f3781c = k2;
    }

    public static Bundle[] a(ArrayList arrayList) {
        Bundle[] bundleArr = new Bundle[arrayList.size()];
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            t tVar = (t) arrayList.get(i2);
            K k2 = tVar.f3781c;
            Bundle bundle = new Bundle();
            CharSequence charSequence = tVar.f3779a;
            if (charSequence != null) {
                bundle.putCharSequence("text", charSequence);
            }
            bundle.putLong("time", tVar.f3780b);
            if (k2 != null) {
                bundle.putCharSequence("sender", k2.f3700a);
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("sender_person", s.a(AbstractC0005e.s(k2)));
                } else {
                    bundle.putBundle("person", k2.b());
                }
            }
            String str = tVar.f3783e;
            if (str != null) {
                bundle.putString("type", str);
            }
            Uri uri = tVar.f3784f;
            if (uri != null) {
                bundle.putParcelable("uri", uri);
            }
            Bundle bundle2 = tVar.f3782d;
            if (bundle2 != null) {
                bundle.putBundle("extras", bundle2);
            }
            bundleArr[i2] = bundle;
        }
        return bundleArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r0.add(r12);
     */
    /* JADX WARN: Type inference failed for: r8v2, types: [u.K, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList b(android.os.Parcelable[] r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r14.length
            r0.<init>(r1)
            r1 = 0
            r2 = r1
        L8:
            int r3 = r14.length
            if (r2 >= r3) goto Lb8
            r3 = r14[r2]
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto Lb4
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r4 = "extras"
            java.lang.String r5 = "uri"
            java.lang.String r6 = "type"
            java.lang.String r7 = "sender"
            java.lang.String r8 = "sender_person"
            java.lang.String r9 = "person"
            java.lang.String r10 = "time"
            java.lang.String r11 = "text"
            r12 = 0
            boolean r13 = r3.containsKey(r11)     // Catch: java.lang.ClassCastException -> Laf
            if (r13 == 0) goto Laf
            boolean r13 = r3.containsKey(r10)     // Catch: java.lang.ClassCastException -> Laf
            if (r13 != 0) goto L32
            goto Laf
        L32:
            boolean r13 = r3.containsKey(r9)     // Catch: java.lang.ClassCastException -> Laf
            if (r13 == 0) goto L41
            android.os.Bundle r7 = r3.getBundle(r9)     // Catch: java.lang.ClassCastException -> Laf
            u.K r7 = u.K.a(r7)     // Catch: java.lang.ClassCastException -> Laf
            goto L78
        L41:
            boolean r9 = r3.containsKey(r8)     // Catch: java.lang.ClassCastException -> Laf
            if (r9 == 0) goto L5a
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.ClassCastException -> Laf
            r13 = 28
            if (r9 < r13) goto L5a
            android.os.Parcelable r7 = r3.getParcelable(r8)     // Catch: java.lang.ClassCastException -> Laf
            android.app.Person r7 = io.flutter.embedding.engine.image.a.d(r7)     // Catch: java.lang.ClassCastException -> Laf
            u.K r7 = E.AbstractC0005e.c(r7)     // Catch: java.lang.ClassCastException -> Laf
            goto L78
        L5a:
            boolean r8 = r3.containsKey(r7)     // Catch: java.lang.ClassCastException -> Laf
            if (r8 == 0) goto L77
            java.lang.CharSequence r7 = r3.getCharSequence(r7)     // Catch: java.lang.ClassCastException -> Laf
            u.K r8 = new u.K     // Catch: java.lang.ClassCastException -> Laf
            r8.<init>()     // Catch: java.lang.ClassCastException -> Laf
            r8.f3700a = r7     // Catch: java.lang.ClassCastException -> Laf
            r8.f3701b = r12     // Catch: java.lang.ClassCastException -> Laf
            r8.f3702c = r12     // Catch: java.lang.ClassCastException -> Laf
            r8.f3703d = r12     // Catch: java.lang.ClassCastException -> Laf
            r8.f3704e = r1     // Catch: java.lang.ClassCastException -> Laf
            r8.f3705f = r1     // Catch: java.lang.ClassCastException -> Laf
            r7 = r8
            goto L78
        L77:
            r7 = r12
        L78:
            u.t r8 = new u.t     // Catch: java.lang.ClassCastException -> Laf
            java.lang.CharSequence r9 = r3.getCharSequence(r11)     // Catch: java.lang.ClassCastException -> Laf
            long r10 = r3.getLong(r10)     // Catch: java.lang.ClassCastException -> Laf
            r8.<init>(r9, r10, r7)     // Catch: java.lang.ClassCastException -> Laf
            boolean r7 = r3.containsKey(r6)     // Catch: java.lang.ClassCastException -> Laf
            if (r7 == 0) goto L9f
            boolean r7 = r3.containsKey(r5)     // Catch: java.lang.ClassCastException -> Laf
            if (r7 == 0) goto L9f
            java.lang.String r6 = r3.getString(r6)     // Catch: java.lang.ClassCastException -> Laf
            android.os.Parcelable r5 = r3.getParcelable(r5)     // Catch: java.lang.ClassCastException -> Laf
            android.net.Uri r5 = (android.net.Uri) r5     // Catch: java.lang.ClassCastException -> Laf
            r8.f3783e = r6     // Catch: java.lang.ClassCastException -> Laf
            r8.f3784f = r5     // Catch: java.lang.ClassCastException -> Laf
        L9f:
            boolean r5 = r3.containsKey(r4)     // Catch: java.lang.ClassCastException -> Laf
            if (r5 == 0) goto Lae
            android.os.Bundle r5 = r8.f3782d     // Catch: java.lang.ClassCastException -> Laf
            android.os.Bundle r3 = r3.getBundle(r4)     // Catch: java.lang.ClassCastException -> Laf
            r5.putAll(r3)     // Catch: java.lang.ClassCastException -> Laf
        Lae:
            r12 = r8
        Laf:
            if (r12 == 0) goto Lb4
            r0.add(r12)
        Lb4:
            int r2 = r2 + 1
            goto L8
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u.t.b(android.os.Parcelable[]):java.util.ArrayList");
    }

    public final Notification.MessagingStyle.Message c() {
        Notification.MessagingStyle.Message a2;
        int i2 = Build.VERSION.SDK_INT;
        CharSequence charSequence = null;
        Person person = null;
        long j2 = this.f3780b;
        CharSequence charSequence2 = this.f3779a;
        K k2 = this.f3781c;
        if (i2 >= 28) {
            if (k2 != null) {
                person = AbstractC0005e.s(k2);
            }
            a2 = s.b(charSequence2, j2, person);
        } else {
            if (k2 != null) {
                charSequence = k2.f3700a;
            }
            a2 = r.a(charSequence2, j2, charSequence);
        }
        String str = this.f3783e;
        if (str != null) {
            r.b(a2, str, this.f3784f);
        }
        return a2;
    }
}
