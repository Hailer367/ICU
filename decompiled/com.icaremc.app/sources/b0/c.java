package b0;

import A2.t;
import androidx.lifecycle.InterfaceC0212t;
import androidx.lifecycle.X;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0212t f3206a;

    public c(InterfaceC0212t interfaceC0212t, X x3) {
        this.f3206a = interfaceC0212t;
        t tVar = new t(x3, b.f3204e);
        String canonicalName = b.class.getCanonicalName();
        if (canonicalName != null) {
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final String toString() {
        int lastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        InterfaceC0212t interfaceC0212t = this.f3206a;
        if (interfaceC0212t == null) {
            sb.append("null");
        } else {
            String simpleName = interfaceC0212t.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = interfaceC0212t.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(interfaceC0212t)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
