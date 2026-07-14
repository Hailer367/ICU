package e;

import I.C0059m;
import I.C0060n;
import I.C0061o;
import I.InterfaceC0062p;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.AbstractActivityC0192y;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.EnumC0207n;
import androidx.lifecycle.F;
import androidx.lifecycle.H;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0202i;
import androidx.lifecycle.InterfaceC0212t;
import androidx.lifecycle.M;
import androidx.lifecycle.T;
import androidx.lifecycle.V;
import androidx.lifecycle.X;
import androidx.lifecycle.Y;
import com.icaremc.app.R;
import f.C0279a;
import f.InterfaceC0280b;
import g.AbstractC0291c;
import g.InterfaceC0290b;
import h.AbstractC0296a;
import i0.C0359b;
import i0.C0362e;
import i0.C0363f;
import i0.InterfaceC0364g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import x.AbstractActivityC0705e;
import x.C0706f;
import x.J;
import y.InterfaceC0728d;

/* loaded from: classes.dex */
public abstract class l extends AbstractActivityC0705e implements Y, InterfaceC0202i, InterfaceC0364g, u, InterfaceC0728d {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final C0271f Companion = new Object();
    private X _viewModelStore;
    private final g.i activityResultRegistry;
    private int contentLayoutId;
    private final C0279a contextAwareHelper = new C0279a();
    private final H2.c defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final H2.c fullyDrawnReporter$delegate;
    private final C0061o menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final H2.c onBackPressedDispatcher$delegate;
    private final H2.c onBackPressedInput$delegate;
    private final CopyOnWriteArrayList<H.a> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<H.a> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<H.a> onNewIntentListeners;
    private final CopyOnWriteArrayList<H.a> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<H.a> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final h reportFullyDrawnExecutor;
    private final C0363f savedStateRegistryController;

    public l() {
        final AbstractActivityC0192y abstractActivityC0192y = (AbstractActivityC0192y) this;
        this.menuHostHelper = new C0061o(new RunnableC0267b(abstractActivityC0192y, 1));
        C0363f c0363f = new C0363f(this);
        this.savedStateRegistryController = c0363f;
        this.reportFullyDrawnExecutor = new i(abstractActivityC0192y);
        this.fullyDrawnReporter$delegate = new H2.g(new C0268c(abstractActivityC0192y, 1));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new k(abstractActivityC0192y);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        this.onBackPressedInput$delegate = new H2.g(new C0268c(abstractActivityC0192y, 2));
        if (getLifecycle() != null) {
            getLifecycle().a(new C0269d(0, abstractActivityC0192y));
            getLifecycle().a(new C0269d(1, abstractActivityC0192y));
            getLifecycle().a(new C0359b(4, abstractActivityC0192y));
            c0363f.a();
            M.d(this);
            getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new I(1, abstractActivityC0192y));
            addOnContextAvailableListener(new InterfaceC0280b() { // from class: e.e
                @Override // f.InterfaceC0280b
                public final void a(l lVar) {
                    l.e(AbstractActivityC0192y.this, lVar);
                }
            });
            this.defaultViewModelProviderFactory$delegate = new H2.g(new C0268c(abstractActivityC0192y, 3));
            this.onBackPressedDispatcher$delegate = new H2.g(new C0268c(abstractActivityC0192y, 4));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static Bundle a(AbstractActivityC0192y abstractActivityC0192y) {
        Bundle bundle = new Bundle();
        g.i iVar = ((l) abstractActivityC0192y).activityResultRegistry;
        iVar.getClass();
        LinkedHashMap linkedHashMap = iVar.f3754b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(iVar.f3756d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(iVar.f3759g));
        return bundle;
    }

    public static final void access$ensureViewModelStore(l lVar) {
        if (lVar._viewModelStore == null) {
            C0272g c0272g = (C0272g) lVar.getLastNonConfigurationInstance();
            if (c0272g != null) {
                lVar._viewModelStore = c0272g.f3554b;
            }
            if (lVar._viewModelStore == null) {
                lVar._viewModelStore = new X();
            }
        }
    }

    public static o b(AbstractActivityC0192y abstractActivityC0192y) {
        return new o(((l) abstractActivityC0192y).reportFullyDrawnExecutor, new C0268c(abstractActivityC0192y, 0));
    }

    public static void c(AbstractActivityC0192y abstractActivityC0192y, InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        if (enumC0206m == EnumC0206m.ON_DESTROY) {
            ((l) abstractActivityC0192y).contextAwareHelper.f3661b = null;
            if (!abstractActivityC0192y.isChangingConfigurations()) {
                abstractActivityC0192y.getViewModelStore().a();
            }
            i iVar = (i) ((l) abstractActivityC0192y).reportFullyDrawnExecutor;
            AbstractActivityC0192y abstractActivityC0192y2 = iVar.f3558i;
            abstractActivityC0192y2.getWindow().getDecorView().removeCallbacks(iVar);
            abstractActivityC0192y2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(iVar);
        }
    }

    public static void d(AbstractActivityC0192y abstractActivityC0192y) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e4) {
            if (T2.h.a(e4.getMessage(), "Can not perform this action after onSaveInstanceState")) {
            } else {
                throw e4;
            }
        } catch (NullPointerException e5) {
            if (!T2.h.a(e5.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e5;
            }
        }
    }

    public static void e(AbstractActivityC0192y abstractActivityC0192y, Context context) {
        T2.h.e(context, "it");
        Bundle a4 = abstractActivityC0192y.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a4 != null) {
            g.i iVar = ((l) abstractActivityC0192y).activityResultRegistry;
            LinkedHashMap linkedHashMap = iVar.f3754b;
            LinkedHashMap linkedHashMap2 = iVar.f3753a;
            Bundle bundle = iVar.f3759g;
            ArrayList<Integer> integerArrayList = a4.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = a4.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                ArrayList<String> stringArrayList2 = a4.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                if (stringArrayList2 != null) {
                    iVar.f3756d.addAll(stringArrayList2);
                }
                Bundle bundle2 = a4.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                int size = stringArrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String str = stringArrayList.get(i4);
                    if (linkedHashMap.containsKey(str)) {
                        Integer num = (Integer) linkedHashMap.remove(str);
                        if (bundle.containsKey(str)) {
                            continue;
                        } else if (!(linkedHashMap2 instanceof U2.a)) {
                            linkedHashMap2.remove(num);
                        } else {
                            T2.s.e(linkedHashMap2, "kotlin.collections.MutableMap");
                            throw null;
                        }
                    }
                    Integer num2 = integerArrayList.get(i4);
                    T2.h.d(num2, "get(...)");
                    int intValue = num2.intValue();
                    String str2 = stringArrayList.get(i4);
                    T2.h.d(str2, "get(...)");
                    String str3 = str2;
                    linkedHashMap2.put(Integer.valueOf(intValue), str3);
                    iVar.f3754b.put(str3, Integer.valueOf(intValue));
                }
            }
        }
    }

    public void addMenuProvider(InterfaceC0062p interfaceC0062p) {
        T2.h.e(interfaceC0062p, "provider");
        C0061o c0061o = this.menuHostHelper;
        c0061o.f775b.add(interfaceC0062p);
        c0061o.f774a.run();
    }

    @Override // y.InterfaceC0728d
    public final void addOnConfigurationChangedListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(InterfaceC0280b interfaceC0280b) {
        T2.h.e(interfaceC0280b, "listener");
        C0279a c0279a = this.contextAwareHelper;
        c0279a.getClass();
        l lVar = c0279a.f3661b;
        if (lVar != null) {
            interfaceC0280b.a(lVar);
        }
        c0279a.f3660a.add(interfaceC0280b);
    }

    public final void addOnMultiWindowModeChangedListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onTrimMemoryListeners.add(aVar);
    }

    public final void addOnUserLeaveHintListener(Runnable runnable) {
        T2.h.e(runnable, "listener");
        this.onUserLeaveHintListeners.add(runnable);
    }

    public final g.i getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0202i
    public a0.b getDefaultViewModelCreationExtras() {
        Bundle bundle;
        a0.c cVar = new a0.c(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = cVar.f2215a;
        if (application != null) {
            linkedHashMap.put(T.f2996a, getApplication());
        }
        linkedHashMap.put(M.f2978a, this);
        linkedHashMap.put(M.f2979b, this);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            linkedHashMap.put(M.f2980c, bundle);
        }
        return cVar;
    }

    public V getDefaultViewModelProviderFactory() {
        return (V) ((H2.g) this.defaultViewModelProviderFactory$delegate).a();
    }

    public o getFullyDrawnReporter() {
        return (o) ((H2.g) this.fullyDrawnReporter$delegate).a();
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0272g c0272g = (C0272g) getLastNonConfigurationInstance();
        if (c0272g != null) {
            return c0272g.f3553a;
        }
        return null;
    }

    @Override // x.AbstractActivityC0705e, androidx.lifecycle.InterfaceC0212t
    public AbstractC0208o getLifecycle() {
        return super.getLifecycle();
    }

    public d0.c getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().a().f3580c;
    }

    @Override // e.u
    public final t getOnBackPressedDispatcher() {
        return (t) ((H2.g) this.onBackPressedDispatcher$delegate).a();
    }

    @Override // i0.InterfaceC0364g
    public final C0362e getSavedStateRegistry() {
        return this.savedStateRegistryController.f4101b;
    }

    @Override // androidx.lifecycle.Y
    public X getViewModelStore() {
        if (getApplication() != null) {
            if (this._viewModelStore == null) {
                C0272g c0272g = (C0272g) getLastNonConfigurationInstance();
                if (c0272g != null) {
                    this._viewModelStore = c0272g.f3554b;
                }
                if (this._viewModelStore == null) {
                    this._viewModelStore = new X();
                }
            }
            X x3 = this._viewModelStore;
            T2.h.b(x3);
            return x3;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        T2.h.d(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        T2.h.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        T2.h.d(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        T2.h.d(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        T2.h.d(decorView5, "getDecorView(...)");
        decorView5.setTag(R.id.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        T2.h.d(decorView6, "getDecorView(...)");
        decorView6.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (!this.activityResultRegistry.a(i4, i5, intent)) {
            super.onActivityResult(i4, i5, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ((d0.a) ((H2.g) this.onBackPressedInput$delegate).a()).a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        T2.h.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<H.a> it = this.onConfigurationChangedListeners.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // x.AbstractActivityC0705e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.b(bundle);
        C0279a c0279a = this.contextAwareHelper;
        c0279a.getClass();
        c0279a.f3661b = this;
        Iterator it = c0279a.f3660a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0280b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i4 = H.f2965g;
        F.b(this);
        int i5 = this.contentLayoutId;
        if (i5 != 0) {
            setContentView(i5);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i4, Menu menu) {
        T2.h.e(menu, "menu");
        if (i4 == 0) {
            super.onCreatePanelMenu(i4, menu);
            C0061o c0061o = this.menuHostHelper;
            getMenuInflater();
            Iterator it = c0061o.f775b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.H) ((InterfaceC0062p) it.next())).f2725a.k();
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        T2.h.e(menuItem, "item");
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 0) {
            return this.menuHostHelper.a();
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<H.a> it = this.onMultiWindowModeChangedListeners.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new C0706f(z));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        T2.h.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator<H.a> it = this.onNewIntentListeners.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        T2.h.e(menu, "menu");
        Iterator it = this.menuHostHelper.f775b.iterator();
        while (it.hasNext()) {
            ((androidx.fragment.app.H) ((InterfaceC0062p) it.next())).f2725a.q();
        }
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<H.a> it = this.onPictureInPictureModeChangedListeners.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new J(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i4, View view, Menu menu) {
        T2.h.e(menu, "menu");
        if (i4 == 0) {
            super.onPreparePanel(i4, view, menu);
            Iterator it = this.menuHostHelper.f775b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.H) ((InterfaceC0062p) it.next())).f2725a.t();
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        T2.h.e(strArr, "permissions");
        T2.h.e(iArr, "grantResults");
        if (!this.activityResultRegistry.a(i4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            super.onRequestPermissionsResult(i4, strArr, iArr);
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, e.g] */
    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        C0272g c0272g;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        X x3 = this._viewModelStore;
        if (x3 == null && (c0272g = (C0272g) getLastNonConfigurationInstance()) != null) {
            x3 = c0272g.f3554b;
        }
        if (x3 == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        ?? obj = new Object();
        obj.f3553a = onRetainCustomNonConfigurationInstance;
        obj.f3554b = x3;
        return obj;
    }

    @Override // x.AbstractActivityC0705e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        T2.h.e(bundle, "outState");
        if (getLifecycle() instanceof C0214v) {
            AbstractC0208o lifecycle = getLifecycle();
            T2.h.c(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((C0214v) lifecycle).g();
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
        Iterator<H.a> it = this.onTrimMemoryListeners.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i4));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        T2.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.f3661b;
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object, g.c] */
    public final <I, O> AbstractC0291c registerForActivityResult(final AbstractC0296a abstractC0296a, final g.i iVar, final InterfaceC0290b interfaceC0290b) {
        T2.h.e(abstractC0296a, "contract");
        T2.h.e(iVar, "registry");
        T2.h.e(interfaceC0290b, "callback");
        final String str = "activity_rq#" + this.nextLocalRequestCode.getAndIncrement();
        LinkedHashMap linkedHashMap = iVar.f3755c;
        T2.h.e(str, "key");
        AbstractC0208o lifecycle = getLifecycle();
        C0214v c0214v = (C0214v) lifecycle;
        if (c0214v.f3024c.compareTo(EnumC0207n.f3017i) < 0) {
            iVar.d(str);
            g.f fVar = (g.f) linkedHashMap.get(str);
            if (fVar == null) {
                fVar = new g.f(lifecycle);
            }
            androidx.lifecycle.r rVar = new androidx.lifecycle.r() { // from class: g.d
                @Override // androidx.lifecycle.r
                public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
                    i iVar2 = i.this;
                    LinkedHashMap linkedHashMap2 = iVar2.f3757e;
                    EnumC0206m enumC0206m2 = EnumC0206m.ON_START;
                    String str2 = str;
                    if (enumC0206m2 == enumC0206m) {
                        Bundle bundle = iVar2.f3759g;
                        LinkedHashMap linkedHashMap3 = iVar2.f3758f;
                        AbstractC0296a abstractC0296a2 = abstractC0296a;
                        InterfaceC0290b interfaceC0290b2 = interfaceC0290b;
                        linkedHashMap2.put(str2, new e(abstractC0296a2, interfaceC0290b2));
                        if (linkedHashMap3.containsKey(str2)) {
                            Object obj = linkedHashMap3.get(str2);
                            linkedHashMap3.remove(str2);
                            interfaceC0290b2.c(obj);
                        }
                        C0289a c0289a = (C0289a) k3.b.j(bundle, str2, C0289a.class);
                        if (c0289a != null) {
                            bundle.remove(str2);
                            interfaceC0290b2.c(abstractC0296a2.c(c0289a.f3741g, c0289a.f3740f));
                            return;
                        }
                        return;
                    }
                    if (EnumC0206m.ON_STOP == enumC0206m) {
                        linkedHashMap2.remove(str2);
                    } else if (EnumC0206m.ON_DESTROY == enumC0206m) {
                        iVar2.e(str2);
                    }
                }
            };
            fVar.f3748a.a(rVar);
            fVar.f3749b.add(rVar);
            linkedHashMap.put(str, fVar);
            return new Object();
        }
        throw new IllegalStateException(("LifecycleOwner " + this + " is attempting to register while current state is " + c0214v.f3024c + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    public void removeMenuProvider(InterfaceC0062p interfaceC0062p) {
        T2.h.e(interfaceC0062p, "provider");
        this.menuHostHelper.b(interfaceC0062p);
    }

    @Override // y.InterfaceC0728d
    public final void removeOnConfigurationChangedListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(InterfaceC0280b interfaceC0280b) {
        T2.h.e(interfaceC0280b, "listener");
        C0279a c0279a = this.contextAwareHelper;
        c0279a.getClass();
        c0279a.f3660a.remove(interfaceC0280b);
    }

    public final void removeOnMultiWindowModeChangedListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(H.a aVar) {
        T2.h.e(aVar, "listener");
        this.onTrimMemoryListeners.remove(aVar);
    }

    public final void removeOnUserLeaveHintListener(Runnable runnable) {
        T2.h.e(runnable, "listener");
        this.onUserLeaveHintListeners.remove(runnable);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (k3.b.s()) {
                Trace.beginSection(k3.b.B("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            o fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f3570a) {
                try {
                    fullyDrawnReporter.f3571b = true;
                    ArrayList arrayList = fullyDrawnReporter.f3572c;
                    int size = arrayList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        ((S2.a) obj).a();
                    }
                    fullyDrawnReporter.f3572c.clear();
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
    public abstract void setContentView(int i4);

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        h hVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        T2.h.d(decorView, "getDecorView(...)");
        i iVar = (i) hVar;
        iVar.getClass();
        if (!iVar.f3557h) {
            iVar.f3557h = true;
            decorView.getViewTreeObserver().addOnDrawListener(iVar);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i4) {
        T2.h.e(intent, "intent");
        super.startActivityForResult(intent, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7) {
        T2.h.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i4, Bundle bundle) {
        T2.h.e(intent, "intent");
        super.startActivityForResult(intent, i4, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        T2.h.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        T2.h.e(configuration, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<H.a> it = this.onMultiWindowModeChangedListeners.iterator();
            T2.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new C0706f(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        T2.h.e(configuration, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<H.a> it = this.onPictureInPictureModeChangedListeners.iterator();
            T2.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new J(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public void addMenuProvider(InterfaceC0062p interfaceC0062p, InterfaceC0212t interfaceC0212t) {
        T2.h.e(interfaceC0062p, "provider");
        T2.h.e(interfaceC0212t, "owner");
        C0061o c0061o = this.menuHostHelper;
        c0061o.f775b.add(interfaceC0062p);
        c0061o.f774a.run();
        AbstractC0208o lifecycle = interfaceC0212t.getLifecycle();
        HashMap hashMap = c0061o.f776c;
        C0060n c0060n = (C0060n) hashMap.remove(interfaceC0062p);
        if (c0060n != null) {
            c0060n.f772a.b(c0060n.f773b);
            c0060n.f773b = null;
        }
        hashMap.put(interfaceC0062p, new C0060n(lifecycle, new C0059m(0, c0061o, interfaceC0062p)));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final InterfaceC0062p interfaceC0062p, InterfaceC0212t interfaceC0212t, final EnumC0207n enumC0207n) {
        T2.h.e(interfaceC0062p, "provider");
        T2.h.e(interfaceC0212t, "owner");
        T2.h.e(enumC0207n, "state");
        final C0061o c0061o = this.menuHostHelper;
        c0061o.getClass();
        AbstractC0208o lifecycle = interfaceC0212t.getLifecycle();
        HashMap hashMap = c0061o.f776c;
        C0060n c0060n = (C0060n) hashMap.remove(interfaceC0062p);
        if (c0060n != null) {
            c0060n.f772a.b(c0060n.f773b);
            c0060n.f773b = null;
        }
        hashMap.put(interfaceC0062p, new C0060n(lifecycle, new androidx.lifecycle.r() { // from class: I.l
            @Override // androidx.lifecycle.r
            public final void d(InterfaceC0212t interfaceC0212t2, EnumC0206m enumC0206m) {
                EnumC0206m enumC0206m2;
                C0061o c0061o2 = C0061o.this;
                c0061o2.getClass();
                Runnable runnable = c0061o2.f774a;
                CopyOnWriteArrayList copyOnWriteArrayList = c0061o2.f775b;
                EnumC0206m.Companion.getClass();
                EnumC0207n enumC0207n2 = enumC0207n;
                int ordinal = enumC0207n2.ordinal();
                EnumC0206m enumC0206m3 = null;
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            enumC0206m2 = null;
                        } else {
                            enumC0206m2 = EnumC0206m.ON_RESUME;
                        }
                    } else {
                        enumC0206m2 = EnumC0206m.ON_START;
                    }
                } else {
                    enumC0206m2 = EnumC0206m.ON_CREATE;
                }
                InterfaceC0062p interfaceC0062p2 = interfaceC0062p;
                if (enumC0206m == enumC0206m2) {
                    copyOnWriteArrayList.add(interfaceC0062p2);
                    runnable.run();
                    return;
                }
                EnumC0206m enumC0206m4 = EnumC0206m.ON_DESTROY;
                if (enumC0206m == enumC0206m4) {
                    c0061o2.b(interfaceC0062p2);
                    return;
                }
                int ordinal2 = enumC0207n2.ordinal();
                if (ordinal2 != 2) {
                    if (ordinal2 != 3) {
                        if (ordinal2 == 4) {
                            enumC0206m3 = EnumC0206m.ON_PAUSE;
                        }
                    } else {
                        enumC0206m3 = EnumC0206m.ON_STOP;
                    }
                } else {
                    enumC0206m3 = enumC0206m4;
                }
                if (enumC0206m == enumC0206m3) {
                    copyOnWriteArrayList.remove(interfaceC0062p2);
                    runnable.run();
                }
            }
        }));
    }

    public final <I, O> AbstractC0291c registerForActivityResult(AbstractC0296a abstractC0296a, InterfaceC0290b interfaceC0290b) {
        T2.h.e(abstractC0296a, "contract");
        T2.h.e(interfaceC0290b, "callback");
        return registerForActivityResult(abstractC0296a, this.activityResultRegistry, interfaceC0290b);
    }
}
