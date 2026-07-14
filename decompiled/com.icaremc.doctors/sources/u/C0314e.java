package u;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* renamed from: u.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0314e {

    /* renamed from: a, reason: collision with root package name */
    public final IconCompat f3713a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f3714b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f3715c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3716d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f3717e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3718f;

    /* renamed from: g, reason: collision with root package name */
    public int f3719g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3720h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3721i;

    public C0314e(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        this.f3716d = true;
        this.f3720h = true;
        this.f3713a = iconCompat;
        this.f3714b = C0319j.b(charSequence);
        this.f3715c = pendingIntent;
        this.f3717e = bundle;
        this.f3718f = null;
        this.f3716d = true;
        this.f3719g = 0;
        this.f3720h = true;
        this.f3721i = false;
    }

    public final C0315f a() {
        M[] mArr;
        CharSequence[] charSequenceArr;
        if (!this.f3721i || this.f3715c != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = this.f3718f;
            if (arrayList3 != null) {
                int size = arrayList3.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList3.get(i2);
                    i2++;
                    M m2 = (M) obj;
                    if (!m2.f3709c && (((charSequenceArr = m2.f3708b) == null || charSequenceArr.length == 0) && !m2.f3711e.isEmpty())) {
                        arrayList.add(m2);
                    } else {
                        arrayList2.add(m2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
            }
            if (arrayList2.isEmpty()) {
                mArr = null;
            } else {
                mArr = (M[]) arrayList2.toArray(new M[arrayList2.size()]);
            }
            return new C0315f(this.f3713a, this.f3714b, this.f3715c, this.f3717e, mArr, this.f3716d, this.f3719g, this.f3720h, this.f3721i);
        }
        throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
    }
}
