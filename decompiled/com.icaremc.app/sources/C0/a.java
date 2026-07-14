package C0;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final List f251f;

    /* renamed from: g, reason: collision with root package name */
    public final Boolean f252g;

    /* renamed from: h, reason: collision with root package name */
    public final String f253h;

    /* renamed from: i, reason: collision with root package name */
    public final List f254i;

    public a(List list, Boolean bool, String str, List list2) {
        this.f251f = list;
        this.f252g = bool;
        this.f253h = str;
        this.f254i = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            List list = aVar.f254i;
            String str = aVar.f253h;
            Boolean bool = aVar.f252g;
            List list2 = aVar.f251f;
            List list3 = this.f251f;
            if (list3 == null ? list2 != null : !list3.equals(list2)) {
                return false;
            }
            Boolean bool2 = this.f252g;
            if (bool2 == null ? bool != null : !bool2.equals(bool)) {
                return false;
            }
            String str2 = this.f253h;
            if (str2 == null ? str != null : !str2.equals(str)) {
                return false;
            }
            List list4 = this.f254i;
            if (list4 != null) {
                return list4.equals(list);
            }
            if (list == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        List list = this.f251f;
        if (list != null) {
            i4 = list.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = i4 * 31;
        Boolean bool = this.f252g;
        if (bool != null) {
            i5 = bool.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (i8 + i5) * 31;
        String str = this.f253h;
        if (str != null) {
            i6 = str.hashCode();
        } else {
            i6 = 0;
        }
        int i10 = (i9 + i6) * 31;
        List list2 = this.f254i;
        if (list2 != null) {
            i7 = list2.hashCode();
        }
        return i10 + i7;
    }
}
