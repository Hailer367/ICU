package x;

import android.app.Notification;
import android.app.Person;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f6424a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6425b;

    /* renamed from: c, reason: collision with root package name */
    public final I f6426c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f6427d = new Bundle();

    /* renamed from: e, reason: collision with root package name */
    public String f6428e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f6429f;

    public v(CharSequence charSequence, long j4, I i4) {
        this.f6424a = charSequence;
        this.f6425b = j4;
        this.f6426c = i4;
    }

    public static Bundle[] a(ArrayList arrayList) {
        Bundle[] bundleArr = new Bundle[arrayList.size()];
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            v vVar = (v) arrayList.get(i4);
            I i5 = vVar.f6426c;
            Bundle bundle = new Bundle();
            CharSequence charSequence = vVar.f6424a;
            if (charSequence != null) {
                bundle.putCharSequence("text", charSequence);
            }
            bundle.putLong("time", vVar.f6425b);
            if (i5 != null) {
                bundle.putCharSequence("sender", i5.f6330a);
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("sender_person", u.a(C.b.t(i5)));
                } else {
                    bundle.putBundle("person", i5.b());
                }
            }
            String str = vVar.f6428e;
            if (str != null) {
                bundle.putString("type", str);
            }
            Uri uri = vVar.f6429f;
            if (uri != null) {
                bundle.putParcelable("uri", uri);
            }
            Bundle bundle2 = vVar.f6427d;
            if (bundle2 != null) {
                bundle.putBundle("extras", bundle2);
            }
            bundleArr[i4] = bundle;
        }
        return bundleArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r0.add(r12);
     */
    /* JADX WARN: Type inference failed for: r8v2, types: [x.I, java.lang.Object] */
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
            x.I r7 = x.I.a(r7)     // Catch: java.lang.ClassCastException -> Laf
            goto L78
        L41:
            boolean r9 = r3.containsKey(r8)     // Catch: java.lang.ClassCastException -> Laf
            if (r9 == 0) goto L5a
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.ClassCastException -> Laf
            r13 = 28
            if (r9 < r13) goto L5a
            android.os.Parcelable r7 = r3.getParcelable(r8)     // Catch: java.lang.ClassCastException -> Laf
            android.app.Person r7 = h2.l.c(r7)     // Catch: java.lang.ClassCastException -> Laf
            x.I r7 = C.b.c(r7)     // Catch: java.lang.ClassCastException -> Laf
            goto L78
        L5a:
            boolean r8 = r3.containsKey(r7)     // Catch: java.lang.ClassCastException -> Laf
            if (r8 == 0) goto L77
            java.lang.CharSequence r7 = r3.getCharSequence(r7)     // Catch: java.lang.ClassCastException -> Laf
            x.I r8 = new x.I     // Catch: java.lang.ClassCastException -> Laf
            r8.<init>()     // Catch: java.lang.ClassCastException -> Laf
            r8.f6330a = r7     // Catch: java.lang.ClassCastException -> Laf
            r8.f6331b = r12     // Catch: java.lang.ClassCastException -> Laf
            r8.f6332c = r12     // Catch: java.lang.ClassCastException -> Laf
            r8.f6333d = r12     // Catch: java.lang.ClassCastException -> Laf
            r8.f6334e = r1     // Catch: java.lang.ClassCastException -> Laf
            r8.f6335f = r1     // Catch: java.lang.ClassCastException -> Laf
            r7 = r8
            goto L78
        L77:
            r7 = r12
        L78:
            x.v r8 = new x.v     // Catch: java.lang.ClassCastException -> Laf
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
            r8.f6428e = r6     // Catch: java.lang.ClassCastException -> Laf
            r8.f6429f = r5     // Catch: java.lang.ClassCastException -> Laf
        L9f:
            boolean r5 = r3.containsKey(r4)     // Catch: java.lang.ClassCastException -> Laf
            if (r5 == 0) goto Lae
            android.os.Bundle r5 = r8.f6427d     // Catch: java.lang.ClassCastException -> Laf
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
        throw new UnsupportedOperationException("Method not decompiled: x.v.b(android.os.Parcelable[]):java.util.ArrayList");
    }

    public final Notification.MessagingStyle.Message c() {
        Notification.MessagingStyle.Message a4;
        int i4 = Build.VERSION.SDK_INT;
        CharSequence charSequence = null;
        Person person = null;
        long j4 = this.f6425b;
        CharSequence charSequence2 = this.f6424a;
        I i5 = this.f6426c;
        if (i4 >= 28) {
            if (i5 != null) {
                person = C.b.t(i5);
            }
            a4 = u.b(charSequence2, j4, person);
        } else {
            if (i5 != null) {
                charSequence = i5.f6330a;
            }
            a4 = t.a(charSequence2, j4, charSequence);
        }
        String str = this.f6428e;
        if (str != null) {
            t.b(a4, str, this.f6429f);
        }
        return a4;
    }
}
