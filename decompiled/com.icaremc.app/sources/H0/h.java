package H0;

/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f609a;

    /* renamed from: b, reason: collision with root package name */
    public final String f610b;

    /* renamed from: c, reason: collision with root package name */
    public final String f611c;

    /* renamed from: d, reason: collision with root package name */
    public final String f612d;

    /* renamed from: e, reason: collision with root package name */
    public final String f613e;

    /* renamed from: f, reason: collision with root package name */
    public final String f614f;

    /* renamed from: g, reason: collision with root package name */
    public final String f615g;

    /* renamed from: h, reason: collision with root package name */
    public final String f616h;

    /* renamed from: i, reason: collision with root package name */
    public final String f617i;

    /* renamed from: j, reason: collision with root package name */
    public final String f618j;
    public final String k;

    /* renamed from: l, reason: collision with root package name */
    public final String f619l;

    public h(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f609a = num;
        this.f610b = str;
        this.f611c = str2;
        this.f612d = str3;
        this.f613e = str4;
        this.f614f = str5;
        this.f615g = str6;
        this.f616h = str7;
        this.f617i = str8;
        this.f618j = str9;
        this.k = str10;
        this.f619l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f609a;
            if (num != null ? num.equals(((h) aVar).f609a) : ((h) aVar).f609a == null) {
                String str = this.f610b;
                if (str != null ? str.equals(((h) aVar).f610b) : ((h) aVar).f610b == null) {
                    String str2 = this.f611c;
                    if (str2 != null ? str2.equals(((h) aVar).f611c) : ((h) aVar).f611c == null) {
                        String str3 = this.f612d;
                        if (str3 != null ? str3.equals(((h) aVar).f612d) : ((h) aVar).f612d == null) {
                            String str4 = this.f613e;
                            if (str4 != null ? str4.equals(((h) aVar).f613e) : ((h) aVar).f613e == null) {
                                String str5 = this.f614f;
                                if (str5 != null ? str5.equals(((h) aVar).f614f) : ((h) aVar).f614f == null) {
                                    String str6 = this.f615g;
                                    if (str6 != null ? str6.equals(((h) aVar).f615g) : ((h) aVar).f615g == null) {
                                        String str7 = this.f616h;
                                        if (str7 != null ? str7.equals(((h) aVar).f616h) : ((h) aVar).f616h == null) {
                                            String str8 = this.f617i;
                                            if (str8 != null ? str8.equals(((h) aVar).f617i) : ((h) aVar).f617i == null) {
                                                String str9 = this.f618j;
                                                if (str9 != null ? str9.equals(((h) aVar).f618j) : ((h) aVar).f618j == null) {
                                                    String str10 = this.k;
                                                    if (str10 != null ? str10.equals(((h) aVar).k) : ((h) aVar).k == null) {
                                                        String str11 = this.f619l;
                                                        if (str11 != null ? str11.equals(((h) aVar).f619l) : ((h) aVar).f619l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int i4 = 0;
        Integer num = this.f609a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        String str = this.f610b;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        String str2 = this.f611c;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i7 = (i6 ^ hashCode3) * 1000003;
        String str3 = this.f612d;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i8 = (i7 ^ hashCode4) * 1000003;
        String str4 = this.f613e;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int i9 = (i8 ^ hashCode5) * 1000003;
        String str5 = this.f614f;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i10 = (i9 ^ hashCode6) * 1000003;
        String str6 = this.f615g;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i11 = (i10 ^ hashCode7) * 1000003;
        String str7 = this.f616h;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i12 = (i11 ^ hashCode8) * 1000003;
        String str8 = this.f617i;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int i13 = (i12 ^ hashCode9) * 1000003;
        String str9 = this.f618j;
        if (str9 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str9.hashCode();
        }
        int i14 = (i13 ^ hashCode10) * 1000003;
        String str10 = this.k;
        if (str10 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str10.hashCode();
        }
        int i15 = (i14 ^ hashCode11) * 1000003;
        String str11 = this.f619l;
        if (str11 != null) {
            i4 = str11.hashCode();
        }
        return i4 ^ i15;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f609a);
        sb.append(", model=");
        sb.append(this.f610b);
        sb.append(", hardware=");
        sb.append(this.f611c);
        sb.append(", device=");
        sb.append(this.f612d);
        sb.append(", product=");
        sb.append(this.f613e);
        sb.append(", osBuild=");
        sb.append(this.f614f);
        sb.append(", manufacturer=");
        sb.append(this.f615g);
        sb.append(", fingerprint=");
        sb.append(this.f616h);
        sb.append(", locale=");
        sb.append(this.f617i);
        sb.append(", country=");
        sb.append(this.f618j);
        sb.append(", mccMnc=");
        sb.append(this.k);
        sb.append(", applicationBuild=");
        return r2.k.c(sb, this.f619l, "}");
    }
}
