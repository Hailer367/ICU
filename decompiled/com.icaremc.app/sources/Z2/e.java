package Z2;

import I2.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e extends f {
    public static List D(d dVar) {
        Iterator it = dVar.iterator();
        if (!it.hasNext()) {
            return m.f862f;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return android.support.v4.media.session.a.p(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
