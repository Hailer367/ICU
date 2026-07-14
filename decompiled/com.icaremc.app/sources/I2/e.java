package I2;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class e extends k {
    public static final void F(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, S2.l lVar) {
        T2.h.e(iterable, "<this>");
        sb.append(charSequence2);
        int i4 = 0;
        for (Object obj : iterable) {
            boolean z = true;
            i4++;
            if (i4 > 1) {
                sb.append(charSequence);
            }
            if (lVar != null) {
                sb.append((CharSequence) lVar.f(obj));
            } else {
                if (obj != null) {
                    z = obj instanceof CharSequence;
                }
                if (z) {
                    sb.append((CharSequence) obj);
                } else if (obj instanceof Character) {
                    sb.append(((Character) obj).charValue());
                } else {
                    sb.append((CharSequence) obj.toString());
                }
            }
        }
        sb.append(charSequence3);
    }

    public static String G(Collection collection, String str, String str2, String str3, S2.l lVar, int i4) {
        String str4;
        String str5;
        if ((i4 & 2) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i4 & 4) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i4 & 32) != 0) {
            lVar = null;
        }
        T2.h.e(collection, "<this>");
        StringBuilder sb = new StringBuilder();
        F(collection, sb, str, str4, str5, "...", lVar);
        return sb.toString();
    }

    public static final void H(Iterable iterable, AbstractCollection abstractCollection) {
        T2.h.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List I(Iterable iterable) {
        ArrayList arrayList;
        Object next;
        T2.h.e(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return J(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = collection.iterator().next();
                }
                return android.support.v4.media.session.a.p(next);
            }
        } else {
            if (z) {
                arrayList = J((Collection) iterable);
            } else {
                ArrayList arrayList2 = new ArrayList();
                H(iterable, arrayList2);
                arrayList = arrayList2;
            }
            int size2 = arrayList.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return arrayList;
                }
                return android.support.v4.media.session.a.p(arrayList.get(0));
            }
        }
        return m.f862f;
    }

    public static ArrayList J(Collection collection) {
        T2.h.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set K(Iterable iterable) {
        Object next;
        T2.h.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(p.Q(collection.size()));
                    H(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = collection.iterator().next();
                }
                Set singleton = Collections.singleton(next);
                T2.h.d(singleton, "singleton(...)");
                return singleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            H(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                T2.h.d(singleton2, "singleton(...)");
                return singleton2;
            }
        }
        return o.f864f;
    }
}
