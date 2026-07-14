package R1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1528a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1529b;

    public b(Set set, c cVar) {
        this.f1528a = b(set);
        this.f1529b = cVar;
    }

    public static String b(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            sb.append(aVar.f1526a);
            sb.append('/');
            sb.append(aVar.f1527b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String a() {
        Set unmodifiableSet;
        Set unmodifiableSet2;
        String str = this.f1528a;
        c cVar = this.f1529b;
        synchronized (((HashSet) cVar.f1532g)) {
            unmodifiableSet = Collections.unmodifiableSet((HashSet) cVar.f1532g);
        }
        if (unmodifiableSet.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (((HashSet) cVar.f1532g)) {
            unmodifiableSet2 = Collections.unmodifiableSet((HashSet) cVar.f1532g);
        }
        sb.append(b(unmodifiableSet2));
        return sb.toString();
    }
}
