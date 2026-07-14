package r2;

import android.util.Log;
import io.flutter.plugin.platform.s;
import o.C0541s;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public final class i implements InterfaceC0643o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6088a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6089b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6090c;

    public /* synthetic */ i(int i4, Object obj, Object obj2) {
        this.f6088a = i4;
        this.f6090c = obj;
        this.f6089b = obj2;
    }

    @Override // s2.InterfaceC0643o
    public final void error(String str, String str2, Object obj) {
        switch (this.f6088a) {
            case 0:
                Log.e("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
                return;
            default:
                ((j2.g) this.f6089b).a(((C0644p) ((s) this.f6090c).f4391h).f6159c.c(str, str2, obj));
                return;
        }
    }

    @Override // s2.InterfaceC0643o
    public final void notImplemented() {
        switch (this.f6088a) {
            case 0:
                return;
            default:
                ((j2.g) this.f6089b).a(null);
                return;
        }
    }

    @Override // s2.InterfaceC0643o
    public final void success(Object obj) {
        switch (this.f6088a) {
            case 0:
                ((C0541s) this.f6090c).f5697f = (byte[]) this.f6089b;
                return;
            default:
                ((j2.g) this.f6089b).a(((C0644p) ((s) this.f6090c).f4391h).f6159c.a(obj));
                return;
        }
    }

    private final void a() {
    }
}
