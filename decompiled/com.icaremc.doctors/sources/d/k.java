package d;

import E.C0012l;
import E.C0013m;
import E.C0014n;
import E.InterfaceC0010j;
import E.InterfaceC0016p;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.M;
import androidx.fragment.app.Z;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.EnumC0145o;
import androidx.lifecycle.InterfaceC0140j;
import androidx.lifecycle.InterfaceC0148s;
import androidx.lifecycle.InterfaceC0150u;
import androidx.lifecycle.K;
import androidx.lifecycle.N;
import androidx.lifecycle.S;
import androidx.lifecycle.Y;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import b0.C0160b;
import b0.C0163e;
import b0.C0164f;
import b0.InterfaceC0165g;
import com.icaremc.doctors.R;
import d.RunnableC0173b;
import e.C0176a;
import e.InterfaceC0177b;
import f.AbstractC0187c;
import f.AbstractC0193i;
import f.InterfaceC0186b;
import f.InterfaceC0194j;
import g.AbstractC0199b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import u.AbstractActivityC0312c;
import u.C0313d;
import u.I;
import u.J;
import u.L;

/* loaded from: classes.dex */
public abstract class k extends AbstractActivityC0312c implements d0, InterfaceC0140j, InterfaceC0165g, u, InterfaceC0194j, v.d, v.e, I, J, InterfaceC0010j {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final f Companion = new Object();
    private c0 _viewModelStore;
    private final AbstractC0193i activityResultRegistry;
    private int contentLayoutId;
    private final C0176a contextAwareHelper = new C0176a();
    private final Q0.c defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final Q0.c fullyDrawnReporter$delegate;
    private final C0014n menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final Q0.c onBackPressedDispatcher$delegate;
    private final Q0.c onBackPressedInput$delegate;
    private final CopyOnWriteArrayList<D.a> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<D.a> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<D.a> onNewIntentListeners;
    private final CopyOnWriteArrayList<D.a> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<D.a> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final h reportFullyDrawnExecutor;
    private final C0164f savedStateRegistryController;

    public k() {
        final M m2 = (M) this;
        int i2 = 1;
        this.menuHostHelper = new C0014n(new RunnableC0173b(m2, i2));
        C0164f c0164f = new C0164f(this);
        this.savedStateRegistryController = c0164f;
        this.reportFullyDrawnExecutor = new i(m2);
        this.fullyDrawnReporter$delegate = new Q0.h(new C0174c(m2, i2));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new j(m2);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        this.onBackPressedInput$delegate = new Q0.h(new C0174c(m2, 2));
        if (getLifecycle() != null) {
            getLifecycle().a(new d(0, m2));
            int i3 = 1;
            getLifecycle().a(new d(i3, m2));
            getLifecycle().a(new C0160b(m2, i3));
            c0164f.a();
            S.d(this);
            getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new N(1, m2));
            addOnContextAvailableListener(new InterfaceC0177b() { // from class: d.e
                @Override // e.InterfaceC0177b
                public final void a(k kVar) {
                    k.e(M.this, kVar);
                }
            });
            this.defaultViewModelProviderFactory$delegate = new Q0.h(new C0174c(m2, 3));
            this.onBackPressedDispatcher$delegate = new Q0.h(new C0174c(m2, 4));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static Bundle a(M m2) {
        Bundle bundle = new Bundle();
        AbstractC0193i abstractC0193i = ((k) m2).activityResultRegistry;
        abstractC0193i.getClass();
        LinkedHashMap linkedHashMap = abstractC0193i.f2266b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(abstractC0193i.f2268d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(abstractC0193i.f2271g));
        return bundle;
    }

    public static final void access$ensureViewModelStore(k kVar) {
        if (kVar._viewModelStore == null) {
            g gVar = (g) kVar.getLastNonConfigurationInstance();
            if (gVar != null) {
                kVar._viewModelStore = gVar.f2124b;
            }
            if (kVar._viewModelStore == null) {
                kVar._viewModelStore = new c0();
            }
        }
    }

    public static n b(M m2) {
        return new n(((k) m2).reportFullyDrawnExecutor, new C0174c(m2, 0));
    }

    public static void c(M m2, InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        if (enumC0144n == EnumC0144n.ON_DESTROY) {
            ((k) m2).contextAwareHelper.f2156b = null;
            if (!m2.isChangingConfigurations()) {
                m2.getViewModelStore().a();
            }
            i iVar = (i) ((k) m2).reportFullyDrawnExecutor;
            M m3 = iVar.f2128f;
            m3.getWindow().getDecorView().removeCallbacks(iVar);
            m3.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(iVar);
        }
    }

    public static void d(M m2) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e2) {
            if (kotlin.jvm.internal.h.a(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
            } else {
                throw e2;
            }
        } catch (NullPointerException e3) {
            if (!kotlin.jvm.internal.h.a(e3.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e3;
            }
        }
    }

    public static void e(M m2, Context it) {
        kotlin.jvm.internal.h.e(it, "it");
        Bundle a2 = m2.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a2 != null) {
            AbstractC0193i abstractC0193i = ((k) m2).activityResultRegistry;
            LinkedHashMap linkedHashMap = abstractC0193i.f2266b;
            LinkedHashMap linkedHashMap2 = abstractC0193i.f2265a;
            Bundle bundle = abstractC0193i.f2271g;
            ArrayList<Integer> integerArrayList = a2.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                ArrayList<String> stringArrayList2 = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                if (stringArrayList2 != null) {
                    abstractC0193i.f2268d.addAll(stringArrayList2);
                }
                Bundle bundle2 = a2.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                int size = stringArrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = stringArrayList.get(i2);
                    if (linkedHashMap.containsKey(str)) {
                        Integer num = (Integer) linkedHashMap.remove(str);
                        if (bundle.containsKey(str)) {
                            continue;
                        } else if (!(linkedHashMap2 instanceof d1.a)) {
                            linkedHashMap2.remove(num);
                        } else {
                            kotlin.jvm.internal.t.e(linkedHashMap2, "kotlin.collections.MutableMap");
                            throw null;
                        }
                    }
                    Integer num2 = integerArrayList.get(i2);
                    kotlin.jvm.internal.h.d(num2, "get(...)");
                    int intValue = num2.intValue();
                    String str2 = stringArrayList.get(i2);
                    kotlin.jvm.internal.h.d(str2, "get(...)");
                    String str3 = str2;
                    linkedHashMap2.put(Integer.valueOf(intValue), str3);
                    abstractC0193i.f2266b.put(str3, Integer.valueOf(intValue));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        h hVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        ((i) hVar).a(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // E.InterfaceC0010j
    public void addMenuProvider(InterfaceC0016p provider) {
        kotlin.jvm.internal.h.e(provider, "provider");
        C0014n c0014n = this.menuHostHelper;
        c0014n.f242b.add(provider);
        c0014n.f241a.run();
    }

    @Override // v.d
    public final void addOnConfigurationChangedListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    public final void addOnContextAvailableListener(InterfaceC0177b listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        C0176a c0176a = this.contextAwareHelper;
        c0176a.getClass();
        k kVar = c0176a.f2156b;
        if (kVar != null) {
            listener.a(kVar);
        }
        c0176a.f2155a.add(listener);
    }

    @Override // u.I
    public final void addOnMultiWindowModeChangedListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    public final void addOnNewIntentListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    @Override // u.J
    public final void addOnPictureInPictureModeChangedListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    @Override // v.e
    public final void addOnTrimMemoryListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    public final void addOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onUserLeaveHintListeners.add(listener);
    }

    @Override // f.InterfaceC0194j
    public final AbstractC0193i getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0140j
    public T.b getDefaultViewModelCreationExtras() {
        Bundle bundle;
        T.c cVar = new T.c(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = cVar.f768a;
        if (application != null) {
            linkedHashMap.put(Y.f1824a, getApplication());
        }
        linkedHashMap.put(S.f1806a, this);
        linkedHashMap.put(S.f1807b, this);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            linkedHashMap.put(S.f1808c, bundle);
        }
        return cVar;
    }

    public a0 getDefaultViewModelProviderFactory() {
        return (a0) ((Q0.h) this.defaultViewModelProviderFactory$delegate).a();
    }

    public n getFullyDrawnReporter() {
        return (n) ((Q0.h) this.fullyDrawnReporter$delegate).a();
    }

    public Object getLastCustomNonConfigurationInstance() {
        g gVar = (g) getLastNonConfigurationInstance();
        if (gVar != null) {
            return gVar.f2123a;
        }
        return null;
    }

    @Override // u.AbstractActivityC0312c, androidx.lifecycle.InterfaceC0150u
    public AbstractC0146p getLifecycle() {
        return super.getLifecycle();
    }

    public W.c getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().b().f2149c;
    }

    @Override // d.u
    public final t getOnBackPressedDispatcher() {
        return (t) ((Q0.h) this.onBackPressedDispatcher$delegate).a();
    }

    @Override // b0.InterfaceC0165g
    public final C0163e getSavedStateRegistry() {
        return this.savedStateRegistryController.f1980b;
    }

    @Override // androidx.lifecycle.d0
    public c0 getViewModelStore() {
        if (getApplication() != null) {
            if (this._viewModelStore == null) {
                g gVar = (g) getLastNonConfigurationInstance();
                if (gVar != null) {
                    this._viewModelStore = gVar.f2124b;
                }
                if (this._viewModelStore == null) {
                    this._viewModelStore = new c0();
                }
            }
            c0 c0Var = this._viewModelStore;
            kotlin.jvm.internal.h.b(c0Var);
            return c0Var;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView5, "getDecorView(...)");
        decorView5.setTag(R.id.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView6, "getDecorView(...)");
        decorView6.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.activityResultRegistry.a(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterator<D.a> it = this.onConfigurationChangedListeners.iterator();
        kotlin.jvm.internal.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(newConfig);
        }
    }

    @Override // u.AbstractActivityC0312c, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.b(bundle);
        C0176a c0176a = this.contextAwareHelper;
        c0176a.getClass();
        c0176a.f2156b = this;
        Iterator it = c0176a.f2155a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0177b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i2 = androidx.lifecycle.M.f1793d;
        K.b(this);
        int i3 = this.contentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        kotlin.jvm.internal.h.e(menu, "menu");
        if (i2 == 0) {
            super.onCreatePanelMenu(i2, menu);
            C0014n c0014n = this.menuHostHelper;
            MenuInflater menuInflater = getMenuInflater();
            Iterator it = c0014n.f242b.iterator();
            while (it.hasNext()) {
                ((Z) ((InterfaceC0016p) it.next())).f1578a.k(menu, menuInflater);
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem item) {
        kotlin.jvm.internal.h.e(item, "item");
        if (super.onMenuItemSelected(i2, item)) {
            return true;
        }
        if (i2 == 0) {
            Iterator it = this.menuHostHelper.f242b.iterator();
            while (it.hasNext()) {
                if (((Z) ((InterfaceC0016p) it.next())).f1578a.p(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<D.a> it = this.onMultiWindowModeChangedListeners.iterator();
        kotlin.jvm.internal.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new C0313d(z));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.h.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator<D.a> it = this.onNewIntentListeners.iterator();
        kotlin.jvm.internal.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        kotlin.jvm.internal.h.e(menu, "menu");
        Iterator it = this.menuHostHelper.f242b.iterator();
        while (it.hasNext()) {
            ((Z) ((InterfaceC0016p) it.next())).f1578a.q(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<D.a> it = this.onPictureInPictureModeChangedListeners.iterator();
        kotlin.jvm.internal.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new L(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        kotlin.jvm.internal.h.e(menu, "menu");
        if (i2 == 0) {
            super.onPreparePanel(i2, view, menu);
            Iterator it = this.menuHostHelper.f242b.iterator();
            while (it.hasNext()) {
                ((Z) ((InterfaceC0016p) it.next())).f1578a.t(menu);
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.h.e(permissions, "permissions");
        kotlin.jvm.internal.h.e(grantResults, "grantResults");
        if (!this.activityResultRegistry.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults))) {
            super.onRequestPermissionsResult(i2, permissions, grantResults);
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, d.g] */
    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        g gVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        c0 c0Var = this._viewModelStore;
        if (c0Var == null && (gVar = (g) getLastNonConfigurationInstance()) != null) {
            c0Var = gVar.f2124b;
        }
        if (c0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        ?? obj = new Object();
        obj.f2123a = onRetainCustomNonConfigurationInstance;
        obj.f2124b = c0Var;
        return obj;
    }

    @Override // u.AbstractActivityC0312c, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.h.e(outState, "outState");
        if (getLifecycle() instanceof C0152w) {
            AbstractC0146p lifecycle = getLifecycle();
            kotlin.jvm.internal.h.c(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((C0152w) lifecycle).g();
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.c(outState);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator<D.a> it = this.onTrimMemoryListeners.iterator();
        kotlin.jvm.internal.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i2));
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.f2156b;
    }

    public final <I, O> AbstractC0187c registerForActivityResult(AbstractC0199b contract, AbstractC0193i registry, InterfaceC0186b callback) {
        kotlin.jvm.internal.h.e(contract, "contract");
        kotlin.jvm.internal.h.e(registry, "registry");
        kotlin.jvm.internal.h.e(callback, "callback");
        return registry.c("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, contract, callback);
    }

    @Override // E.InterfaceC0010j
    public void removeMenuProvider(InterfaceC0016p provider) {
        kotlin.jvm.internal.h.e(provider, "provider");
        this.menuHostHelper.a(provider);
    }

    @Override // v.d
    public final void removeOnConfigurationChangedListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    public final void removeOnContextAvailableListener(InterfaceC0177b listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        C0176a c0176a = this.contextAwareHelper;
        c0176a.getClass();
        c0176a.f2155a.remove(listener);
    }

    @Override // u.I
    public final void removeOnMultiWindowModeChangedListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    public final void removeOnNewIntentListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onNewIntentListeners.remove(listener);
    }

    @Override // u.J
    public final void removeOnPictureInPictureModeChangedListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    @Override // v.e
    public final void removeOnTrimMemoryListener(D.a listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    public final void removeOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.onUserLeaveHintListeners.remove(listener);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (android.support.v4.media.session.a.w()) {
                Trace.beginSection(android.support.v4.media.session.a.J("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            n fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f2137b) {
                try {
                    fullyDrawnReporter.f2138c = true;
                    ArrayList arrayList = fullyDrawnReporter.f2139d;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((c1.a) obj).invoke();
                    }
                    fullyDrawnReporter.f2139d.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        initializeViewTreeOwners();
        h hVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        ((i) hVar).a(decorView);
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        kotlin.jvm.internal.h.e(intent, "intent");
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int i2, Intent intent2, int i3, int i4, int i5) {
        kotlin.jvm.internal.h.e(intent, "intent");
        super.startIntentSenderForResult(intent, i2, intent2, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        kotlin.jvm.internal.h.e(intent, "intent");
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int i2, Intent intent2, int i3, int i4, int i5, Bundle bundle) {
        kotlin.jvm.internal.h.e(intent, "intent");
        super.startIntentSenderForResult(intent, i2, intent2, i3, i4, i5, bundle);
    }

    public final <I, O> AbstractC0187c registerForActivityResult(AbstractC0199b contract, InterfaceC0186b callback) {
        kotlin.jvm.internal.h.e(contract, "contract");
        kotlin.jvm.internal.h.e(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration newConfig) {
        kotlin.jvm.internal.h.e(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, newConfig);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<D.a> it = this.onMultiWindowModeChangedListeners.iterator();
            kotlin.jvm.internal.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new C0313d(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration newConfig) {
        kotlin.jvm.internal.h.e(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, newConfig);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<D.a> it = this.onPictureInPictureModeChangedListeners.iterator();
            kotlin.jvm.internal.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new L(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        h hVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        ((i) hVar).a(decorView);
        super.setContentView(view);
    }

    public void addMenuProvider(InterfaceC0016p provider, InterfaceC0150u owner) {
        kotlin.jvm.internal.h.e(provider, "provider");
        kotlin.jvm.internal.h.e(owner, "owner");
        C0014n c0014n = this.menuHostHelper;
        c0014n.f242b.add(provider);
        c0014n.f241a.run();
        AbstractC0146p lifecycle = owner.getLifecycle();
        HashMap hashMap = c0014n.f243c;
        C0013m c0013m = (C0013m) hashMap.remove(provider);
        if (c0013m != null) {
            c0013m.f239a.b(c0013m.f240b);
            c0013m.f240b = null;
        }
        hashMap.put(provider, new C0013m(lifecycle, new C0012l(0, c0014n, provider)));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        h hVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        ((i) hVar).a(decorView);
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final InterfaceC0016p provider, InterfaceC0150u owner, final EnumC0145o state) {
        kotlin.jvm.internal.h.e(provider, "provider");
        kotlin.jvm.internal.h.e(owner, "owner");
        kotlin.jvm.internal.h.e(state, "state");
        final C0014n c0014n = this.menuHostHelper;
        c0014n.getClass();
        AbstractC0146p lifecycle = owner.getLifecycle();
        HashMap hashMap = c0014n.f243c;
        C0013m c0013m = (C0013m) hashMap.remove(provider);
        if (c0013m != null) {
            c0013m.f239a.b(c0013m.f240b);
            c0013m.f240b = null;
        }
        hashMap.put(provider, new C0013m(lifecycle, new InterfaceC0148s() { // from class: E.k
            @Override // androidx.lifecycle.InterfaceC0148s
            public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
                EnumC0144n enumC0144n2;
                C0014n c0014n2 = C0014n.this;
                c0014n2.getClass();
                RunnableC0173b runnableC0173b = c0014n2.f241a;
                CopyOnWriteArrayList copyOnWriteArrayList = c0014n2.f242b;
                EnumC0144n.Companion.getClass();
                EnumC0145o enumC0145o = state;
                int ordinal = enumC0145o.ordinal();
                EnumC0144n enumC0144n3 = null;
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            enumC0144n2 = null;
                        } else {
                            enumC0144n2 = EnumC0144n.ON_RESUME;
                        }
                    } else {
                        enumC0144n2 = EnumC0144n.ON_START;
                    }
                } else {
                    enumC0144n2 = EnumC0144n.ON_CREATE;
                }
                InterfaceC0016p interfaceC0016p = provider;
                if (enumC0144n == enumC0144n2) {
                    copyOnWriteArrayList.add(interfaceC0016p);
                    runnableC0173b.run();
                    return;
                }
                EnumC0144n enumC0144n4 = EnumC0144n.ON_DESTROY;
                if (enumC0144n == enumC0144n4) {
                    c0014n2.a(interfaceC0016p);
                    return;
                }
                int ordinal2 = enumC0145o.ordinal();
                if (ordinal2 != 2) {
                    if (ordinal2 != 3) {
                        if (ordinal2 == 4) {
                            enumC0144n3 = EnumC0144n.ON_PAUSE;
                        }
                    } else {
                        enumC0144n3 = EnumC0144n.ON_STOP;
                    }
                } else {
                    enumC0144n3 = enumC0144n4;
                }
                if (enumC0144n == enumC0144n3) {
                    copyOnWriteArrayList.remove(interfaceC0016p);
                    runnableC0173b.run();
                }
            }
        }));
    }
}
