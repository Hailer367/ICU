package j1;

import R0.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e extends f {
    public static List X(d dVar) {
        Iterator it = dVar.iterator();
        if (!it.hasNext()) {
            return r.f750c;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return android.support.v4.media.session.a.y(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
