package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import java.util.Comparator;

/* loaded from: classes.dex */
final /* synthetic */ class zab implements Comparator {
    static final /* synthetic */ zab zaa = new zab();

    private /* synthetic */ zab() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Feature feature = (Feature) obj2;
        Feature feature2 = (Feature) obj;
        Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
        if (!feature2.getName().equals(feature.getName())) {
            return feature2.getName().compareTo(feature.getName());
        }
        return Long.compare(feature2.getVersion(), feature.getVersion());
    }
}
