package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final NotificationDetails f3345f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3346g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3347h;

    public h(NotificationDetails notificationDetails, int i4, ArrayList arrayList) {
        this.f3345f = notificationDetails;
        this.f3346g = i4;
        this.f3347h = arrayList;
    }

    public final String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f3345f + ", startMode=" + this.f3346g + ", foregroundServiceTypes=" + this.f3347h + '}';
    }
}
