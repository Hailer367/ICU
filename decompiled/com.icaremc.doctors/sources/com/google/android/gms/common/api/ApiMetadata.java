package com.google.android.gms.common.api;

import O.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ApiMetadataCreator")
/* loaded from: classes.dex */
public final class ApiMetadata extends AbstractSafeParcelable {
    public static final ApiMetadata zza;

    @SafeParcelable.Field(getter = "getComplianceOptions", id = 1)
    private final ComplianceOptions zzc;

    @SafeParcelable.Field(getter = "isCallbackSupportEnabled", id = 2)
    private final boolean zzd;
    private boolean zze;
    public static final Parcelable.Creator<ApiMetadata> CREATOR = zza.zza();
    private static final ApiMetadata zzb = newBuilder().build();

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {
        private ComplianceOptions zza;
        private boolean zzb = false;
        private boolean zzc;

        @KeepForSdk
        public ApiMetadata build() {
            ApiMetadata apiMetadata = new ApiMetadata(this.zza, this.zzb);
            apiMetadata.zza(this.zzc);
            return apiMetadata;
        }

        @KeepForSdk
        public Builder setCallbackSupportEnabled(boolean z) {
            this.zzb = z;
            return this;
        }

        @KeepForSdk
        public Builder setComplianceOptions(ComplianceOptions complianceOptions) {
            this.zza = complianceOptions;
            return this;
        }

        public final /* synthetic */ Builder zza(boolean z) {
            this.zzc = z;
            return this;
        }
    }

    static {
        Builder newBuilder = newBuilder();
        newBuilder.zza(true);
        zza = newBuilder.build();
    }

    @SafeParcelable.Constructor
    public ApiMetadata(@SafeParcelable.Param(id = 1) ComplianceOptions complianceOptions, @SafeParcelable.Param(id = 2) boolean z) {
        this.zzc = complianceOptions;
        this.zzd = z;
    }

    @KeepForSdk
    public static final ApiMetadata fromComplianceOptions(ComplianceOptions complianceOptions) {
        Builder newBuilder = newBuilder();
        newBuilder.setComplianceOptions(complianceOptions);
        return newBuilder.build();
    }

    @KeepForSdk
    public static final ApiMetadata getEmptyInstance() {
        return zzb;
    }

    @KeepForSdk
    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ApiMetadata)) {
            return false;
        }
        ApiMetadata apiMetadata = (ApiMetadata) obj;
        if (!Objects.equal(this.zzc, apiMetadata.zzc) || this.zze != apiMetadata.zze || this.zzd != apiMetadata.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzd));
    }

    @KeepForSdk
    public Builder toBuilder() {
        Builder newBuilder = newBuilder();
        newBuilder.setComplianceOptions(this.zzc);
        newBuilder.setCallbackSupportEnabled(this.zzd);
        newBuilder.zza(this.zze);
        return newBuilder;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        return a.j(new StringBuilder(valueOf.length() + 31), "ApiMetadata(complianceOptions=", valueOf, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        if (this.zze) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
            parcel.setDataSize(parcel.dataSize() - 4);
            return;
        }
        parcel.writeInt(-204102970);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzc, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ void zza(boolean z) {
        this.zze = z;
    }
}
