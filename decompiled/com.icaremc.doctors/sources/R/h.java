package R;

import androidx.fragment.app.H;

/* loaded from: classes.dex */
public abstract class h extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    public final H f733c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(H fragment, String str) {
        super(str);
        kotlin.jvm.internal.h.e(fragment, "fragment");
        this.f733c = fragment;
    }
}
