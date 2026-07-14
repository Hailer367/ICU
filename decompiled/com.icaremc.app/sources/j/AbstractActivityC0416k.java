package j;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.AbstractActivityC0192y;
import f1.AbstractC0286a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import o.C0543t;
import o.C1;
import o.U0;
import t.C0658g;

/* renamed from: j.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0416k extends AbstractActivityC0192y implements InterfaceC0417l, x.M {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AbstractC0420o mDelegate;
    private Resources mResources;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        layoutInflaterFactory2C0393A.x();
        ((ViewGroup) layoutInflaterFactory2C0393A.f4831F.findViewById(R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C0393A.f4866r.a(layoutInflaterFactory2C0393A.f4865q.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Configuration configuration;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        layoutInflaterFactory2C0393A.f4844T = true;
        int i12 = layoutInflaterFactory2C0393A.f4848X;
        if (i12 == -100) {
            i12 = AbstractC0420o.f4995g;
        }
        int D3 = layoutInflaterFactory2C0393A.D(context, i12);
        if (AbstractC0420o.c(context) && AbstractC0420o.c(context)) {
            if (E.b.a()) {
                if (!AbstractC0420o.k) {
                    AbstractC0420o.f4994f.execute(new f0.g(context, 2));
                }
            } else {
                synchronized (AbstractC0420o.f5001n) {
                    try {
                        E.e eVar = AbstractC0420o.f4996h;
                        if (eVar == null) {
                            if (AbstractC0420o.f4997i == null) {
                                AbstractC0420o.f4997i = E.e.a(AbstractC0286a.D(context));
                            }
                            if (!AbstractC0420o.f4997i.f454a.f455a.isEmpty()) {
                                AbstractC0420o.f4996h = AbstractC0420o.f4997i;
                            }
                        } else if (!eVar.equals(AbstractC0420o.f4997i)) {
                            E.e eVar2 = AbstractC0420o.f4996h;
                            AbstractC0420o.f4997i = eVar2;
                            AbstractC0286a.C(context, eVar2.f454a.f455a.toLanguageTags());
                        }
                    } finally {
                    }
                }
            }
        }
        E.e q2 = LayoutInflaterFactory2C0393A.q(context);
        if (LayoutInflaterFactory2C0393A.f4825p0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(LayoutInflaterFactory2C0393A.u(context, D3, q2, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof m.e) {
            try {
                ((m.e) context).a(LayoutInflaterFactory2C0393A.u(context, D3, q2, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (LayoutInflaterFactory2C0393A.f4824o0) {
            int i13 = Build.VERSION.SDK_INT;
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f4 = configuration3.fontScale;
                    float f5 = configuration4.fontScale;
                    if (f4 != f5) {
                        configuration.fontScale = f5;
                    }
                    int i14 = configuration3.mcc;
                    int i15 = configuration4.mcc;
                    if (i14 != i15) {
                        configuration.mcc = i15;
                    }
                    int i16 = configuration3.mnc;
                    int i17 = configuration4.mnc;
                    if (i16 != i17) {
                        configuration.mnc = i17;
                    }
                    t.a(configuration3, configuration4, configuration);
                    int i18 = configuration3.touchscreen;
                    int i19 = configuration4.touchscreen;
                    if (i18 != i19) {
                        configuration.touchscreen = i19;
                    }
                    int i20 = configuration3.keyboard;
                    int i21 = configuration4.keyboard;
                    if (i20 != i21) {
                        configuration.keyboard = i21;
                    }
                    int i22 = configuration3.keyboardHidden;
                    int i23 = configuration4.keyboardHidden;
                    if (i22 != i23) {
                        configuration.keyboardHidden = i23;
                    }
                    int i24 = configuration3.navigation;
                    int i25 = configuration4.navigation;
                    if (i24 != i25) {
                        configuration.navigation = i25;
                    }
                    int i26 = configuration3.navigationHidden;
                    int i27 = configuration4.navigationHidden;
                    if (i26 != i27) {
                        configuration.navigationHidden = i27;
                    }
                    int i28 = configuration3.orientation;
                    int i29 = configuration4.orientation;
                    if (i28 != i29) {
                        configuration.orientation = i29;
                    }
                    int i30 = configuration3.screenLayout & 15;
                    int i31 = configuration4.screenLayout & 15;
                    if (i30 != i31) {
                        configuration.screenLayout |= i31;
                    }
                    int i32 = configuration3.screenLayout & 192;
                    int i33 = configuration4.screenLayout & 192;
                    if (i32 != i33) {
                        configuration.screenLayout |= i33;
                    }
                    int i34 = configuration3.screenLayout & 48;
                    int i35 = configuration4.screenLayout & 48;
                    if (i34 != i35) {
                        configuration.screenLayout |= i35;
                    }
                    int i36 = configuration3.screenLayout & 768;
                    int i37 = configuration4.screenLayout & 768;
                    if (i36 != i37) {
                        configuration.screenLayout |= i37;
                    }
                    if (i13 >= 26) {
                        i4 = configuration3.colorMode;
                        int i38 = i4 & 3;
                        i5 = configuration4.colorMode;
                        if (i38 != (i5 & 3)) {
                            i10 = configuration.colorMode;
                            i11 = configuration4.colorMode;
                            configuration.colorMode = i10 | (i11 & 3);
                        }
                        i6 = configuration3.colorMode;
                        int i39 = i6 & 12;
                        i7 = configuration4.colorMode;
                        if (i39 != (i7 & 12)) {
                            i8 = configuration.colorMode;
                            i9 = configuration4.colorMode;
                            configuration.colorMode = i8 | (i9 & 12);
                        }
                    }
                    int i40 = configuration3.uiMode & 15;
                    int i41 = configuration4.uiMode & 15;
                    if (i40 != i41) {
                        configuration.uiMode |= i41;
                    }
                    int i42 = configuration3.uiMode & 48;
                    int i43 = configuration4.uiMode & 48;
                    if (i42 != i43) {
                        configuration.uiMode |= i43;
                    }
                    int i44 = configuration3.screenWidthDp;
                    int i45 = configuration4.screenWidthDp;
                    if (i44 != i45) {
                        configuration.screenWidthDp = i45;
                    }
                    int i46 = configuration3.screenHeightDp;
                    int i47 = configuration4.screenHeightDp;
                    if (i46 != i47) {
                        configuration.screenHeightDp = i47;
                    }
                    int i48 = configuration3.smallestScreenWidthDp;
                    int i49 = configuration4.smallestScreenWidthDp;
                    if (i48 != i49) {
                        configuration.smallestScreenWidthDp = i49;
                    }
                    int i50 = configuration3.densityDpi;
                    int i51 = configuration4.densityDpi;
                    if (i50 != i51) {
                        configuration.densityDpi = i51;
                    }
                }
            } else {
                configuration = null;
            }
            Configuration u3 = LayoutInflaterFactory2C0393A.u(context, D3, q2, configuration, true);
            m.e eVar3 = new m.e(context, com.icaremc.app.R.style.Theme_AppCompat_Empty);
            eVar3.a(u3);
            try {
                if (context.getTheme() != null) {
                    Resources.Theme theme = eVar3.getTheme();
                    if (i13 >= 29) {
                        A.l.a(theme);
                    } else {
                        synchronized (A.b.f10e) {
                            if (!A.b.f12g) {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    A.b.f11f = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException e4) {
                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e4);
                                }
                                A.b.f12g = true;
                            }
                            Method method = A.b.f11f;
                            if (method != null) {
                                try {
                                    method.invoke(theme, null);
                                } catch (IllegalAccessException | InvocationTargetException e5) {
                                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e5);
                                    A.b.f11f = null;
                                }
                            }
                        }
                    }
                }
            } catch (NullPointerException unused3) {
            }
            context = eVar3;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0406a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // x.AbstractActivityC0705e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0406a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.l(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i4) {
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        layoutInflaterFactory2C0393A.x();
        return (T) layoutInflaterFactory2C0393A.f4865q.findViewById(i4);
    }

    public final void g() {
        View decorView = getWindow().getDecorView();
        T2.h.e(decorView, "<this>");
        decorView.setTag(com.icaremc.app.R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        T2.h.e(decorView2, "<this>");
        decorView2.setTag(com.icaremc.app.R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        T2.h.e(decorView3, "<this>");
        decorView3.setTag(com.icaremc.app.R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        T2.h.e(decorView4, "<this>");
        decorView4.setTag(com.icaremc.app.R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    public AbstractC0420o getDelegate() {
        if (this.mDelegate == null) {
            ExecutorC0399G executorC0399G = AbstractC0420o.f4994f;
            this.mDelegate = new LayoutInflaterFactory2C0393A(this, null, this, this);
        }
        return this.mDelegate;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, j.b] */
    public InterfaceC0407b getDrawerToggleDelegate() {
        ((LayoutInflaterFactory2C0393A) getDelegate()).getClass();
        return new Object();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        Context context;
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        if (layoutInflaterFactory2C0393A.f4869u == null) {
            layoutInflaterFactory2C0393A.B();
            AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
            if (abstractC0406a != null) {
                context = abstractC0406a.e();
            } else {
                context = layoutInflaterFactory2C0393A.f4864p;
            }
            layoutInflaterFactory2C0393A.f4869u = new m.j(context);
        }
        return layoutInflaterFactory2C0393A.f4869u;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i4 = C1.f5426a;
        }
        if (resources == null) {
            return super.getResources();
        }
        return resources;
    }

    public AbstractC0406a getSupportActionBar() {
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        layoutInflaterFactory2C0393A.B();
        return layoutInflaterFactory2C0393A.f4868t;
    }

    @Override // x.M
    public Intent getSupportParentActivityIntent() {
        return AbstractC0286a.p(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().b();
    }

    @Override // e.l, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        if (layoutInflaterFactory2C0393A.f4836K && layoutInflaterFactory2C0393A.f4830E) {
            layoutInflaterFactory2C0393A.B();
            AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
            if (abstractC0406a != null) {
                abstractC0406a.i();
            }
        }
        C0543t a4 = C0543t.a();
        Context context = layoutInflaterFactory2C0393A.f4864p;
        synchronized (a4) {
            U0 u0 = a4.f5709a;
            synchronized (u0) {
                C0658g c0658g = (C0658g) u0.f5530b.get(context);
                if (c0658g != null) {
                    int i4 = c0658g.f6185i;
                    Object[] objArr = c0658g.f6184h;
                    for (int i5 = 0; i5 < i4; i5++) {
                        objArr[i5] = null;
                    }
                    c0658g.f6185i = 0;
                    c0658g.f6182f = false;
                }
            }
        }
        layoutInflaterFactory2C0393A.f4847W = new Configuration(layoutInflaterFactory2C0393A.f4864p.getResources().getConfiguration());
        layoutInflaterFactory2C0393A.o(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(x.N n3) {
        ArrayList arrayList = n3.f6342f;
        AbstractActivityC0416k abstractActivityC0416k = n3.f6343g;
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = AbstractC0286a.p(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(abstractActivityC0416k.getPackageManager());
            }
            int size = arrayList.size();
            try {
                for (Intent q2 = AbstractC0286a.q(abstractActivityC0416k, component); q2 != null; q2 = AbstractC0286a.q(abstractActivityC0416k, q2.getComponent())) {
                    arrayList.add(size, q2);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e4);
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0192y, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().e();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0192y, e.l, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        AbstractC0406a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() == 16908332 && supportActionBar != null && (supportActionBar.d() & 4) != 0) {
            return onSupportNavigateUp();
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i4, Menu menu) {
        return super.onMenuOpened(i4, menu);
    }

    @Override // e.l, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((LayoutInflaterFactory2C0393A) getDelegate()).x();
    }

    @Override // androidx.fragment.app.AbstractActivityC0192y, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        layoutInflaterFactory2C0393A.B();
        AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
        if (abstractC0406a != null) {
            abstractC0406a.q(true);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0192y, android.app.Activity
    public void onStart() {
        super.onStart();
        ((LayoutInflaterFactory2C0393A) getDelegate()).o(true, false);
    }

    @Override // androidx.fragment.app.AbstractActivityC0192y, android.app.Activity
    public void onStop() {
        super.onStop();
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        layoutInflaterFactory2C0393A.B();
        AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
        if (abstractC0406a != null) {
            abstractC0406a.q(false);
        }
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            x.N n3 = new x.N(this);
            onCreateSupportNavigateUpTaskStack(n3);
            onPrepareSupportNavigateUpTaskStack(n3);
            ArrayList arrayList = n3.f6342f;
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                n3.f6343g.startActivities(intentArr, null);
                try {
                    finishAffinity();
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        supportNavigateUpTo(supportParentActivityIntent);
        return true;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i4) {
        super.onTitleChanged(charSequence, i4);
        getDelegate().m(charSequence);
    }

    @Override // j.InterfaceC0417l
    public AbstractC0438b onWindowStartingSupportActionMode(InterfaceC0437a interfaceC0437a) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0406a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.m()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // e.l, android.app.Activity
    public void setContentView(int i4) {
        g();
        getDelegate().j(i4);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = (LayoutInflaterFactory2C0393A) getDelegate();
        if (!(layoutInflaterFactory2C0393A.f4863o instanceof Activity)) {
            return;
        }
        layoutInflaterFactory2C0393A.B();
        AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
        if (!(abstractC0406a instanceof Q)) {
            layoutInflaterFactory2C0393A.f4869u = null;
            if (abstractC0406a != null) {
                abstractC0406a.j();
            }
            layoutInflaterFactory2C0393A.f4868t = null;
            if (toolbar != null) {
                Object obj = layoutInflaterFactory2C0393A.f4863o;
                if (obj instanceof Activity) {
                    charSequence = ((Activity) obj).getTitle();
                } else {
                    charSequence = layoutInflaterFactory2C0393A.f4870v;
                }
                C0403K c0403k = new C0403K(toolbar, charSequence, layoutInflaterFactory2C0393A.f4866r);
                layoutInflaterFactory2C0393A.f4868t = c0403k;
                layoutInflaterFactory2C0393A.f4866r.f5009g = c0403k.f4896c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                layoutInflaterFactory2C0393A.f4866r.f5009g = null;
            }
            layoutInflaterFactory2C0393A.b();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        super.setTheme(i4);
        ((LayoutInflaterFactory2C0393A) getDelegate()).f4849Y = i4;
    }

    public AbstractC0438b startSupportActionMode(InterfaceC0437a interfaceC0437a) {
        return getDelegate().n(interfaceC0437a);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().b();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i4) {
        return getDelegate().g(i4);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // e.l, android.app.Activity
    public void setContentView(View view) {
        g();
        getDelegate().k(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        getDelegate().l(view, layoutParams);
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public void onLocalesChanged(E.e eVar) {
    }

    public void onNightModeChanged(int i4) {
    }

    public void onPrepareSupportNavigateUpTaskStack(x.N n3) {
    }

    @Override // j.InterfaceC0417l
    public void onSupportActionModeFinished(AbstractC0438b abstractC0438b) {
    }

    @Override // j.InterfaceC0417l
    public void onSupportActionModeStarted(AbstractC0438b abstractC0438b) {
    }

    @Deprecated
    public void setSupportProgress(int i4) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }
}
