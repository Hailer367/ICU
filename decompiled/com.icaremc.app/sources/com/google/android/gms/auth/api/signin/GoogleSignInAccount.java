package com.google.android.gms.auth.api.signin;

import L.g;
import Z0.r;
import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractC0142a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new g(2);

    /* renamed from: f, reason: collision with root package name */
    public final String f3351f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3352g;

    /* renamed from: h, reason: collision with root package name */
    public final String f3353h;

    /* renamed from: i, reason: collision with root package name */
    public final String f3354i;

    /* renamed from: j, reason: collision with root package name */
    public final Uri f3355j;
    public String k;

    /* renamed from: l, reason: collision with root package name */
    public final long f3356l;

    /* renamed from: m, reason: collision with root package name */
    public final String f3357m;

    /* renamed from: n, reason: collision with root package name */
    public final List f3358n;

    /* renamed from: o, reason: collision with root package name */
    public final String f3359o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3360p;

    /* renamed from: q, reason: collision with root package name */
    public final HashSet f3361q = new HashSet();

    public GoogleSignInAccount(String str, String str2, String str3, String str4, Uri uri, String str5, long j4, String str6, ArrayList arrayList, String str7, String str8) {
        this.f3351f = str;
        this.f3352g = str2;
        this.f3353h = str3;
        this.f3354i = str4;
        this.f3355j = uri;
        this.k = str5;
        this.f3356l = j4;
        this.f3357m = str6;
        this.f3358n = arrayList;
        this.f3359o = str7;
        this.f3360p = str8;
    }

    public static GoogleSignInAccount a(String str) {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(1, jSONArray.getString(i4)));
        }
        String optString2 = jSONObject.optString("id");
        if (jSONObject.has("tokenId")) {
            str2 = jSONObject.optString("tokenId");
        } else {
            str2 = null;
        }
        if (jSONObject.has("email")) {
            str3 = jSONObject.optString("email");
        } else {
            str3 = null;
        }
        if (jSONObject.has("displayName")) {
            str4 = jSONObject.optString("displayName");
        } else {
            str4 = null;
        }
        if (jSONObject.has("givenName")) {
            str5 = jSONObject.optString("givenName");
        } else {
            str5 = null;
        }
        if (jSONObject.has("familyName")) {
            str6 = jSONObject.optString("familyName");
        } else {
            str6 = null;
        }
        String string = jSONObject.getString("obfuscatedIdentifier");
        r.c(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(optString2, str2, str3, str4, uri, null, parseLong, string, new ArrayList(hashSet), str5, str6);
        if (jSONObject.has("serverAuthCode")) {
            str7 = jSONObject.optString("serverAuthCode");
        }
        googleSignInAccount.k = str7;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj != this) {
                if (obj instanceof GoogleSignInAccount) {
                    GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
                    if (googleSignInAccount.f3357m.equals(this.f3357m)) {
                        HashSet hashSet = new HashSet(googleSignInAccount.f3358n);
                        hashSet.addAll(googleSignInAccount.f3361q);
                        HashSet hashSet2 = new HashSet(this.f3358n);
                        hashSet2.addAll(this.f3361q);
                        if (hashSet.equals(hashSet2)) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f3357m.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f3358n);
        hashSet.addAll(this.f3361q);
        return (hashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.M(parcel, 2, this.f3351f);
        AbstractC0141a.M(parcel, 3, this.f3352g);
        AbstractC0141a.M(parcel, 4, this.f3353h);
        AbstractC0141a.M(parcel, 5, this.f3354i);
        AbstractC0141a.L(parcel, 6, this.f3355j, i4);
        AbstractC0141a.M(parcel, 7, this.k);
        AbstractC0141a.P(parcel, 8, 8);
        parcel.writeLong(this.f3356l);
        AbstractC0141a.M(parcel, 9, this.f3357m);
        AbstractC0141a.O(parcel, 10, this.f3358n);
        AbstractC0141a.M(parcel, 11, this.f3359o);
        AbstractC0141a.M(parcel, 12, this.f3360p);
        AbstractC0141a.S(parcel, Q2);
    }
}
