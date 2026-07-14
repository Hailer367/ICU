package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    public static final Scope zaa = new Scope(Scopes.PROFILE);
    public static final Scope zab = new Scope(Scopes.EMAIL);
    public static final Scope zac = new Scope(Scopes.OPEN_ID);
    public static final Scope zad;
    public static final Scope zae;
    private static final Comparator zaq;

    @SafeParcelable.VersionField(id = 1)
    final int zaf;

    @SafeParcelable.Field(getter = "getScopes", id = 2)
    private final ArrayList zag;

    @SafeParcelable.Field(getter = "getAccount", id = 3)
    private Account zah;

    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    private boolean zai;

    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean zaj;

    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean zak;

    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    private String zal;

    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    private String zam;

    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    private ArrayList zan;

    @SafeParcelable.Field(getter = "getLogSessionId", id = 10)
    private String zao;
    private Map zap;

    @Deprecated
    /* loaded from: classes.dex */
    public static final class Builder {
        private Set zaa;
        private boolean zab;
        private boolean zac;
        private boolean zad;
        private String zae;
        private Account zaf;
        private String zag;
        private Map zah;
        private String zai;

        public Builder() {
            this.zaa = new HashSet();
            this.zah = new HashMap();
        }

        private final String zaa(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.zae;
            boolean z = true;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            Preconditions.checkArgument(z, "two different server client ids provided");
            return str;
        }

        public Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.zah.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                List<Scope> impliedScopes = googleSignInOptionsExtension.getImpliedScopes();
                if (impliedScopes != null) {
                    this.zaa.addAll(impliedScopes);
                }
                this.zah.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        public GoogleSignInOptions build() {
            if (this.zaa.contains(GoogleSignInOptions.zae)) {
                Set set = this.zaa;
                Scope scope = GoogleSignInOptions.zad;
                if (set.contains(scope)) {
                    this.zaa.remove(scope);
                }
            }
            if (this.zad && (this.zaf == null || !this.zaa.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
        }

        public Builder requestEmail() {
            this.zaa.add(GoogleSignInOptions.zab);
            return this;
        }

        public Builder requestId() {
            this.zaa.add(GoogleSignInOptions.zac);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.zad = true;
            zaa(str);
            this.zae = str;
            return this;
        }

        public Builder requestProfile() {
            this.zaa.add(GoogleSignInOptions.zaa);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zaa.add(scope);
            this.zaa.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            requestServerAuthCode(str, false);
            return this;
        }

        public Builder setAccountName(String str) {
            this.zaf = new Account(Preconditions.checkNotEmpty(str), AccountType.GOOGLE);
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.zag = Preconditions.checkNotEmpty(str);
            return this;
        }

        @KeepForSdk
        public Builder setLogSessionId(String str) {
            this.zai = str;
            return this;
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.zab = true;
            zaa(str);
            this.zae = str;
            this.zac = z;
            return this;
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.zaa = new HashSet();
            this.zah = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zad());
            this.zab = googleSignInOptions.zag();
            this.zac = googleSignInOptions.zah();
            this.zad = googleSignInOptions.zaf();
            this.zae = googleSignInOptions.zai();
            this.zaf = googleSignInOptions.zae();
            this.zag = googleSignInOptions.zaj();
            this.zah = GoogleSignInOptions.zam(googleSignInOptions.zak());
            this.zai = googleSignInOptions.zal();
        }
    }

    static {
        Scope scope = new Scope(Scopes.GAMES_LITE);
        zad = scope;
        zae = new Scope(Scopes.GAMES);
        Builder builder = new Builder();
        builder.requestId();
        builder.requestProfile();
        DEFAULT_SIGN_IN = builder.build();
        Builder builder2 = new Builder();
        builder2.requestScopes(scope, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = builder2.build();
        CREATOR = new zad();
        zaq = new zac();
    }

    public /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, byte[] bArr) {
        this(3, arrayList, account, z, z2, z3, str, str2, map, str3);
    }

    public static GoogleSignInOptions zaa(String str) {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, AccountType.GOOGLE);
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z, z2, z3, str3, str4, new HashMap(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map zam(List list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
                hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0046, code lost:
    
        if (r1.equals(r5.getAccount()) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r5 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r5     // Catch: java.lang.ClassCastException -> L8e
            java.util.ArrayList r1 = r4.zan     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L8e
            java.util.ArrayList r1 = r5.zan     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L18
            goto L8e
        L18:
            java.util.ArrayList r1 = r4.zag     // Catch: java.lang.ClassCastException -> L8e
            int r2 = r1.size()     // Catch: java.lang.ClassCastException -> L8e
            java.util.ArrayList r3 = r5.getScopes()     // Catch: java.lang.ClassCastException -> L8e
            int r3 = r3.size()     // Catch: java.lang.ClassCastException -> L8e
            if (r2 != r3) goto L8e
            java.util.ArrayList r2 = r5.getScopes()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L33
            goto L8e
        L33:
            android.accounts.Account r1 = r4.zah     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L3e
            android.accounts.Account r1 = r5.getAccount()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L8e
            goto L48
        L3e:
            android.accounts.Account r2 = r5.getAccount()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L8e
        L48:
            java.lang.String r1 = r4.zal     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L5b
            java.lang.String r1 = r5.getServerClientId()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 == 0) goto L8e
            goto L68
        L5b:
            java.lang.String r1 = r4.zal     // Catch: java.lang.ClassCastException -> L8e
            java.lang.String r2 = r5.getServerClientId()     // Catch: java.lang.ClassCastException -> L8e
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != 0) goto L68
            goto L8e
        L68:
            boolean r1 = r4.zak     // Catch: java.lang.ClassCastException -> L8e
            boolean r2 = r5.isForceCodeForRefreshToken()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != r2) goto L8e
            boolean r1 = r4.zai     // Catch: java.lang.ClassCastException -> L8e
            boolean r2 = r5.isIdTokenRequested()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != r2) goto L8e
            boolean r1 = r4.zaj     // Catch: java.lang.ClassCastException -> L8e
            boolean r2 = r5.isServerAuthCodeRequested()     // Catch: java.lang.ClassCastException -> L8e
            if (r1 != r2) goto L8e
            java.lang.String r1 = r4.zao     // Catch: java.lang.ClassCastException -> L8e
            java.lang.String r5 = r5.getLogSessionId()     // Catch: java.lang.ClassCastException -> L8e
            boolean r5 = android.text.TextUtils.equals(r1, r5)     // Catch: java.lang.ClassCastException -> L8e
            if (r5 == 0) goto L8e
            r5 = 1
            return r5
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @KeepForSdk
    public Account getAccount() {
        return this.zah;
    }

    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zan;
    }

    @KeepForSdk
    public String getLogSessionId() {
        return this.zao;
    }

    public Scope[] getScopeArray() {
        ArrayList arrayList = this.zag;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zag);
    }

    @KeepForSdk
    public String getServerClientId() {
        return this.zal;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zag;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Scope) arrayList2.get(i2)).getScopeUri());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.addObject(arrayList);
        hashAccumulator.addObject(this.zah);
        hashAccumulator.addObject(this.zal);
        hashAccumulator.zaa(this.zak);
        hashAccumulator.zaa(this.zai);
        hashAccumulator.zaa(this.zaj);
        hashAccumulator.addObject(this.zao);
        return hashAccumulator.hash();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.zak;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.zai;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.zaj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = this.zaf;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i3);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zam, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zab() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = this.zag;
            Collections.sort(arrayList, zaq);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                jSONArray.put(((Scope) obj).getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.zah;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.zai);
            jSONObject.put("forceCodeForRefreshToken", this.zak);
            jSONObject.put("serverAuthRequested", this.zaj);
            if (!TextUtils.isEmpty(this.zal)) {
                jSONObject.put("serverClientId", this.zal);
            }
            if (!TextUtils.isEmpty(this.zam)) {
                jSONObject.put("hostedDomain", this.zam);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final /* synthetic */ ArrayList zad() {
        return this.zag;
    }

    public final /* synthetic */ Account zae() {
        return this.zah;
    }

    public final /* synthetic */ boolean zaf() {
        return this.zai;
    }

    public final /* synthetic */ boolean zag() {
        return this.zaj;
    }

    public final /* synthetic */ boolean zah() {
        return this.zak;
    }

    public final /* synthetic */ String zai() {
        return this.zal;
    }

    public final /* synthetic */ String zaj() {
        return this.zam;
    }

    public final /* synthetic */ ArrayList zak() {
        return this.zan;
    }

    public final /* synthetic */ String zal() {
        return this.zao;
    }

    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList arrayList, @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList arrayList2, @SafeParcelable.Param(id = 10) String str3) {
        this(i2, arrayList, account, z, z2, z3, str, str2, zam(arrayList2), str3);
    }

    private GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3) {
        this.zaf = i2;
        this.zag = arrayList;
        this.zah = account;
        this.zai = z;
        this.zaj = z2;
        this.zak = z3;
        this.zal = str;
        this.zam = str2;
        this.zan = new ArrayList(map.values());
        this.zap = map;
        this.zao = str3;
    }
}
