package r;

import android.content.ComponentName;
import android.os.Bundle;
import b.C0219b;
import b.InterfaceC0221d;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6011a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0221d f6012b;

    /* renamed from: c, reason: collision with root package name */
    public final BinderC0612g f6013c;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentName f6014d;

    public o(InterfaceC0221d interfaceC0221d, BinderC0612g binderC0612g, ComponentName componentName) {
        this.f6012b = interfaceC0221d;
        this.f6013c = binderC0612g;
        this.f6014d = componentName;
    }

    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return bundle2;
    }

    public final boolean b(Bundle bundle) {
        Bundle a4 = a(bundle);
        try {
            return ((C0219b) this.f6012b).a(this.f6013c, a4);
        } catch (SecurityException e4) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e4);
        }
    }
}
