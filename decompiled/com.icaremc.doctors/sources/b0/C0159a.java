package b0;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* renamed from: b0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0159a implements InterfaceC0162d {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1970a = new LinkedHashSet();

    public C0159a(C0163e c0163e) {
        c0163e.c("androidx.savedstate.Restarter", this);
    }

    @Override // b0.InterfaceC0162d
    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f1970a));
        return bundle;
    }
}
