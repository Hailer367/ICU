package com.dexterous.flutterlocalnotifications;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    public static final f f3340f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f3341g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f3342h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f3343i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f3344j;
    public static final /* synthetic */ f[] k;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.dexterous.flutterlocalnotifications.f] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.dexterous.flutterlocalnotifications.f] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, com.dexterous.flutterlocalnotifications.f] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, com.dexterous.flutterlocalnotifications.f] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, com.dexterous.flutterlocalnotifications.f] */
    static {
        ?? r02 = new Enum("None", 0);
        f3340f = r02;
        ?? r12 = new Enum("RequestingNotificationPermission", 1);
        f3341g = r12;
        ?? r22 = new Enum("RequestingNotificationPolicyAccess", 2);
        f3342h = r22;
        ?? r3 = new Enum("RequestingExactAlarmsPermission", 3);
        f3343i = r3;
        ?? r4 = new Enum("RequestingFullScreenIntentPermission", 4);
        f3344j = r4;
        k = new f[]{r02, r12, r22, r3, r4};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) k.clone();
    }
}
