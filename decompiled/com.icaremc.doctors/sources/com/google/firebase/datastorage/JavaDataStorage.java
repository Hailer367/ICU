package com.google.firebase.datastorage;

import K.C0027b;
import K.InterfaceC0034i;
import M.d;
import M.e;
import N.l;
import N.m;
import O.c;
import O.g;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import i1.j;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.r;
import l1.AbstractC0244w;

/* loaded from: classes.dex */
public final class JavaDataStorage {
    static final /* synthetic */ j[] $$delegatedProperties;
    private final Context context;
    private final InterfaceC0034i dataStore;
    private final e1.a dataStore$delegate;
    private final ThreadLocal<Boolean> editLock;
    private final String name;

    static {
        n nVar = new n(b.NO_RECEIVER, JavaDataStorage.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        r.f2790a.getClass();
        $$delegatedProperties = new j[]{nVar};
    }

    public JavaDataStorage(Context context, String name) {
        h.e(context, "context");
        h.e(name, "name");
        this.context = context;
        this.name = name;
        this.editLock = new ThreadLocal<>();
        this.dataStore$delegate = android.support.v4.media.session.a.B(name, new F.h(4, new a(this, 0)), new a(this, 1), 8);
        this.dataStore = getDataStore(context);
    }

    public static final g dataStore_delegate$lambda$0(JavaDataStorage javaDataStorage, C0027b ex) {
        h.e(ex, "ex");
        Log.w(r.a(JavaDataStorage.class).b(), "CorruptionException in " + javaDataStorage.name + " DataStore running in process " + Process.myPid(), ex);
        return new c(true);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [V0.h, N.k] */
    public static final List dataStore_delegate$lambda$1(JavaDataStorage javaDataStorage, Context it) {
        h.e(it, "it");
        String sharedPreferencesName = javaDataStorage.name;
        LinkedHashSet keysToMigrate = m.f625a;
        h.e(sharedPreferencesName, "sharedPreferencesName");
        h.e(keysToMigrate, "keysToMigrate");
        return android.support.v4.media.session.a.y(new d(it, sharedPreferencesName, e.f609a, new l(keysToMigrate, null), new V0.h(3, null)));
    }

    private final InterfaceC0034i getDataStore(Context context) {
        return ((N.b) this.dataStore$delegate).a(context, $$delegatedProperties[0]);
    }

    public final <T> boolean contains(O.e key) {
        h.e(key, "key");
        return ((Boolean) AbstractC0244w.i(new JavaDataStorage$contains$1(this, key, null))).booleanValue();
    }

    public final g editSync(c1.l transform) {
        h.e(transform, "transform");
        return (g) AbstractC0244w.i(new JavaDataStorage$editSync$1(this, transform, null));
    }

    public final Map<O.e, Object> getAllSync() {
        return (Map) AbstractC0244w.i(new JavaDataStorage$getAllSync$1(this, null));
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getName() {
        return this.name;
    }

    public final <T> T getSync(O.e key, T t2) {
        h.e(key, "key");
        return (T) AbstractC0244w.i(new JavaDataStorage$getSync$1(this, key, t2, null));
    }

    public final <T> g putSync(O.e key, T t2) {
        h.e(key, "key");
        return (g) AbstractC0244w.i(new JavaDataStorage$putSync$1(this, key, t2, null));
    }
}
