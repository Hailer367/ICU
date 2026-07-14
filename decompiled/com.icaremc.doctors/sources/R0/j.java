package R0;

import com.google.firebase.encoders.json.BuildConfig;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class j extends p {
    public static boolean Q(Iterable iterable, Object obj) {
        int i2;
        kotlin.jvm.internal.h.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (iterable instanceof List) {
            i2 = ((List) iterable).indexOf(obj);
        } else {
            Iterator it = iterable.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (i3 >= 0) {
                        if (kotlin.jvm.internal.h.a(obj, next)) {
                            i2 = i3;
                            break;
                        }
                        i3++;
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
        }
        if (i2 < 0) {
            return false;
        }
        return true;
    }

    public static final void R(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, c1.l lVar) {
        kotlin.jvm.internal.h.e(iterable, "<this>");
        sb.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            boolean z = true;
            i2++;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            if (lVar != null) {
                sb.append((CharSequence) lVar.invoke(obj));
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

    public static String S(Collection collection, String str, String str2, String str3, c1.l lVar, int i2) {
        String str4;
        String str5;
        if ((i2 & 2) != 0) {
            str4 = BuildConfig.FLAVOR;
        } else {
            str4 = str2;
        }
        if ((i2 & 4) != 0) {
            str5 = BuildConfig.FLAVOR;
        } else {
            str5 = str3;
        }
        if ((i2 & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.h.e(collection, "<this>");
        StringBuilder sb = new StringBuilder();
        R(collection, sb, str, str4, str5, "...", lVar);
        return sb.toString();
    }

    public static final void T(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.h.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List U(Iterable iterable) {
        ArrayList arrayList;
        Object next;
        kotlin.jvm.internal.h.e(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return V(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = collection.iterator().next();
                }
                return android.support.v4.media.session.a.y(next);
            }
        } else {
            if (z) {
                arrayList = V((Collection) iterable);
            } else {
                ArrayList arrayList2 = new ArrayList();
                T(iterable, arrayList2);
                arrayList = arrayList2;
            }
            int size2 = arrayList.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return arrayList;
                }
                return android.support.v4.media.session.a.y(arrayList.get(0));
            }
        }
        return r.f750c;
    }

    public static ArrayList V(Collection collection) {
        kotlin.jvm.internal.h.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set W(Iterable iterable) {
        Object next;
        kotlin.jvm.internal.h.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(u.X(collection.size()));
                    T(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = collection.iterator().next();
                }
                Set singleton = Collections.singleton(next);
                kotlin.jvm.internal.h.d(singleton, "singleton(...)");
                return singleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            T(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                kotlin.jvm.internal.h.d(singleton2, "singleton(...)");
                return singleton2;
            }
        }
        return t.f752c;
    }
}
