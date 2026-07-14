package com.dexterous.flutterlocalnotifications;

import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3334a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0643o f3335b;

    public /* synthetic */ c(int i4, InterfaceC0643o interfaceC0643o) {
        this.f3334a = i4;
        this.f3335b = interfaceC0643o;
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public final void a(boolean z) {
        switch (this.f3334a) {
            case 0:
                this.f3335b.success(Boolean.valueOf(z));
                return;
            default:
                this.f3335b.success(Boolean.valueOf(z));
                return;
        }
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public final void b() {
        switch (this.f3334a) {
            case 0:
                this.f3335b.error("permissionRequestInProgress", "Another permission request is already in progress", null);
                return;
            default:
                this.f3335b.error("permissionRequestInProgress", "Another permission request is already in progress", null);
                return;
        }
    }
}
