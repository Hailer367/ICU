package U;

import A0.g;
import androidx.lifecycle.InterfaceC0150u;
import androidx.lifecycle.c0;
import java.io.PrintWriter;
import r.k;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f778a;

    /* renamed from: b, reason: collision with root package name */
    public final c f779b;

    public d(InterfaceC0150u interfaceC0150u, c0 c0Var) {
        this.f778a = interfaceC0150u;
        g gVar = new g(c0Var, c.f776e);
        String canonicalName = c.class.getCanonicalName();
        if (canonicalName != null) {
            this.f779b = (c) gVar.c(c.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void b(String str, PrintWriter printWriter) {
        k kVar = this.f779b.f777d;
        if (kVar.f3576e > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (kVar.f3576e > 0) {
                if (kVar.f3575d[0] == null) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(kVar.f3574c[0]);
                    printWriter.print(": ");
                    throw null;
                }
                throw new ClassCastException();
            }
        }
    }

    public final String toString() {
        int lastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f778a;
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}}");
        return sb.toString();
    }
}
