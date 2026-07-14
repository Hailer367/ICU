package d2;

import com.google.android.play.core.install.zza;
import r2.i;
import s2.C0635g;

/* renamed from: d2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0261b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3476a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0265f f3477b;

    public /* synthetic */ C0261b(C0265f c0265f, int i4) {
        this.f3476a = i4;
        this.f3477b = c0265f;
    }

    public final void a(zza zzaVar) {
        switch (this.f3476a) {
            case 0:
                int i4 = zzaVar.f3395a;
                C0635g c0635g = this.f3477b.f3487i;
                if (c0635g != null) {
                    c0635g.a(Integer.valueOf(i4));
                    return;
                }
                return;
            default:
                int i5 = zzaVar.f3395a;
                C0265f c0265f = this.f3477b;
                C0635g c0635g2 = c0265f.f3487i;
                if (c0635g2 != null) {
                    c0635g2.a(Integer.valueOf(i5));
                }
                if (i5 == 11) {
                    i iVar = c0265f.k;
                    if (iVar != null) {
                        iVar.success(null);
                    }
                    c0265f.k = null;
                    return;
                }
                int i6 = zzaVar.f3398d;
                if (i6 != 0) {
                    i iVar2 = c0265f.k;
                    if (iVar2 != null) {
                        iVar2.error("Error during installation", String.valueOf(i6), null);
                    }
                    c0265f.k = null;
                    return;
                }
                return;
        }
    }
}
