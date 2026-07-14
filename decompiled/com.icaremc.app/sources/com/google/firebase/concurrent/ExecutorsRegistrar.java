package com.google.firebase.concurrent;

import P1.C0108l;
import V1.f;
import android.annotation.SuppressLint;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import q1.AbstractC0602b;
import r2.c;
import w1.InterfaceC0696a;
import w1.InterfaceC0697b;
import w1.InterfaceC0698c;
import w1.InterfaceC0699d;
import x1.C0721a;
import x1.k;
import x1.o;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    public static final k f3400a = new k(new C0108l(3));

    /* renamed from: b, reason: collision with root package name */
    public static final k f3401b = new k(new C0108l(4));

    /* renamed from: c, reason: collision with root package name */
    public static final k f3402c = new k(new C0108l(5));

    /* renamed from: d, reason: collision with root package name */
    public static final k f3403d = new k(new C0108l(6));

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        o oVar = new o(InterfaceC0696a.class, ScheduledExecutorService.class);
        o[] oVarArr = {new o(InterfaceC0696a.class, ExecutorService.class), new o(InterfaceC0696a.class, Executor.class)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(oVar);
        for (o oVar2 : oVarArr) {
            AbstractC0602b.h(oVar2, "Null interface");
        }
        Collections.addAll(hashSet, oVarArr);
        C0721a c0721a = new C0721a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new f(7), hashSet3);
        o oVar3 = new o(InterfaceC0697b.class, ScheduledExecutorService.class);
        o[] oVarArr2 = {new o(InterfaceC0697b.class, ExecutorService.class), new o(InterfaceC0697b.class, Executor.class)};
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(oVar3);
        for (o oVar4 : oVarArr2) {
            AbstractC0602b.h(oVar4, "Null interface");
        }
        Collections.addAll(hashSet4, oVarArr2);
        C0721a c0721a2 = new C0721a(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, new f(8), hashSet6);
        o oVar5 = new o(InterfaceC0698c.class, ScheduledExecutorService.class);
        o[] oVarArr3 = {new o(InterfaceC0698c.class, ExecutorService.class), new o(InterfaceC0698c.class, Executor.class)};
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(oVar5);
        for (o oVar6 : oVarArr3) {
            AbstractC0602b.h(oVar6, "Null interface");
        }
        Collections.addAll(hashSet7, oVarArr3);
        C0721a c0721a3 = new C0721a(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, new f(9), hashSet9);
        c a4 = C0721a.a(new o(InterfaceC0699d.class, Executor.class));
        a4.f6055f = new f(10);
        return Arrays.asList(c0721a, c0721a2, c0721a3, a4.b());
    }
}
