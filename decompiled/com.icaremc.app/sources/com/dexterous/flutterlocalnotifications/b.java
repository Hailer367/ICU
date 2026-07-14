package com.dexterous.flutterlocalnotifications;

import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public final class b implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3332a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0643o f3333b;

    public /* synthetic */ b(int i4, InterfaceC0643o interfaceC0643o) {
        this.f3332a = i4;
        this.f3333b = interfaceC0643o;
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public final void a(boolean z) {
        switch (this.f3332a) {
            case 0:
                this.f3333b.success(Boolean.valueOf(z));
                return;
            default:
                this.f3333b.success(Boolean.valueOf(z));
                return;
        }
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public final void b() {
        switch (this.f3332a) {
            case 0:
                this.f3333b.error("permissionRequestInProgress", "Another permission request is already in progress", null);
                return;
            default:
                this.f3333b.error("permissionRequestInProgress", "Another permission request is already in progress", null);
                return;
        }
    }
}
