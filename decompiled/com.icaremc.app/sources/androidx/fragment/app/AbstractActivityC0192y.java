package androidx.fragment.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.EnumC0207n;
import f.InterfaceC0280b;
import j.AbstractActivityC0416k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import t.C0662k;
import x.InterfaceC0701a;

/* renamed from: androidx.fragment.app.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0192y extends e.l implements InterfaceC0701a {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final C mFragments;
    boolean mResumed;
    final C0214v mFragmentLifecycleRegistry = new C0214v(this);
    boolean mStopped = true;

    public AbstractActivityC0192y() {
        final AbstractActivityC0416k abstractActivityC0416k = (AbstractActivityC0416k) this;
        this.mFragments = new C(new C0191x(abstractActivityC0416k));
        getSavedStateRegistry().c(LIFECYCLE_TAG, new C0188u(0, abstractActivityC0416k));
        final int i4 = 0;
        addOnConfigurationChangedListener(new H.a() { // from class: androidx.fragment.app.v
            @Override // H.a
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        abstractActivityC0416k.mFragments.a();
                        return;
                    default:
                        abstractActivityC0416k.mFragments.a();
                        return;
                }
            }
        });
        final int i5 = 1;
        addOnNewIntentListener(new H.a() { // from class: androidx.fragment.app.v
            @Override // H.a
            public final void accept(Object obj) {
                switch (i5) {
                    case 0:
                        abstractActivityC0416k.mFragments.a();
                        return;
                    default:
                        abstractActivityC0416k.mFragments.a();
                        return;
                }
            }
        });
        addOnContextAvailableListener(new InterfaceC0280b() { // from class: androidx.fragment.app.w
            @Override // f.InterfaceC0280b
            public final void a(e.l lVar) {
                C0191x c0191x = AbstractActivityC0416k.this.mFragments.f2715a;
                c0191x.f2951i.b(c0191x, c0191x, null);
            }
        });
    }

    public static boolean f(P p3) {
        AbstractActivityC0416k abstractActivityC0416k;
        boolean z = false;
        for (AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t : p3.f2752c.j()) {
            if (abstractComponentCallbacksC0187t != null) {
                C0191x c0191x = abstractComponentCallbacksC0187t.f2942y;
                if (c0191x == null) {
                    abstractActivityC0416k = null;
                } else {
                    abstractActivityC0416k = c0191x.f2952j;
                }
                if (abstractActivityC0416k != null) {
                    z |= f(abstractComponentCallbacksC0187t.c());
                }
                if (abstractComponentCallbacksC0187t.f2919R.f3024c.compareTo(EnumC0207n.f3017i) >= 0) {
                    abstractComponentCallbacksC0187t.f2919R.g();
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f2715a.f2951i.f2755f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (!shouldDumpInternalState(strArr)) {
            return;
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            A2.t tVar = new A2.t(getViewModelStore(), b0.b.f3204e);
            String canonicalName = b0.b.class.getCanonicalName();
            if (canonicalName != null) {
                C0662k c0662k = ((b0.b) tVar.F(b0.b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).f3205d;
                if (c0662k.f6199h > 0) {
                    printWriter.print(str2);
                    printWriter.println("Loaders:");
                    if (c0662k.f6199h > 0) {
                        if (c0662k.f6198g[0] == null) {
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(c0662k.f6197f[0]);
                            printWriter.print(": ");
                            throw null;
                        }
                        throw new ClassCastException();
                    }
                }
            } else {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
        }
        this.mFragments.f2715a.f2951i.w(str, fileDescriptor, printWriter, strArr);
    }

    public P getSupportFragmentManager() {
        return this.mFragments.f2715a.f2951i;
    }

    @Deprecated
    public b0.a getSupportLoaderManager() {
        return new b0.c(this, getViewModelStore());
    }

    public void markFragmentsCreated() {
        do {
        } while (f(getSupportFragmentManager()));
    }

    @Override // e.l, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i4, i5, intent);
    }

    @Deprecated
    public void onAttachFragment(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
    }

    @Override // e.l, x.AbstractActivityC0705e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(EnumC0206m.ON_CREATE);
        Q q2 = this.mFragments.f2715a.f2951i;
        q2.f2741G = false;
        q2.f2742H = false;
        q2.f2748N.f2788i = false;
        q2.u(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f2715a.f2951i.l();
        this.mFragmentLifecycleRegistry.e(EnumC0206m.ON_DESTROY);
    }

    @Override // e.l, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 6) {
            return this.mFragments.f2715a.f2951i.j();
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f2715a.f2951i.u(5);
        this.mFragmentLifecycleRegistry.e(EnumC0206m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // e.l, android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f2715a.f2951i.A(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(EnumC0206m.ON_RESUME);
        Q q2 = this.mFragments.f2715a.f2951i;
        q2.f2741G = false;
        q2.f2742H = false;
        q2.f2748N.f2788i = false;
        q2.u(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            Q q2 = this.mFragments.f2715a.f2951i;
            q2.f2741G = false;
            q2.f2742H = false;
            q2.f2748N.f2788i = false;
            q2.u(4);
        }
        this.mFragments.f2715a.f2951i.A(true);
        this.mFragmentLifecycleRegistry.e(EnumC0206m.ON_START);
        Q q3 = this.mFragments.f2715a.f2951i;
        q3.f2741G = false;
        q3.f2742H = false;
        q3.f2748N.f2788i = false;
        q3.u(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        Q q2 = this.mFragments.f2715a.f2951i;
        q2.f2742H = true;
        q2.f2748N.f2788i = true;
        q2.u(4);
        this.mFragmentLifecycleRegistry.e(EnumC0206m.ON_STOP);
    }

    public void setEnterSharedElementCallback(x.L l3) {
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(x.L l3) {
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, Intent intent, int i4, Bundle bundle) {
        if (i4 == -1) {
            startActivityForResult(intent, -1, bundle);
            return;
        }
        if (abstractComponentCallbacksC0187t.f2942y != null) {
            P e4 = abstractComponentCallbacksC0187t.e();
            if (e4.f2736B != null) {
                e4.f2739E.addLast(new L(abstractComponentCallbacksC0187t.f2928j, i4));
                if (bundle != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                e4.f2736B.a(intent);
                return;
            }
            C0191x c0191x = e4.f2770v;
            c0191x.getClass();
            T2.h.e(intent, "intent");
            if (i4 == -1) {
                c0191x.f2949g.startActivity(intent, bundle);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0187t + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderFromFragment(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        if (i4 == -1) {
            startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
            return;
        }
        Intent intent2 = intent;
        if (abstractComponentCallbacksC0187t.f2942y != null) {
            if (P.J(2)) {
                Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0187t + " received the following in startIntentSenderForResult() requestCode: " + i4 + " IntentSender: " + intentSender + " fillInIntent: " + intent2 + " options: " + bundle);
            }
            P e4 = abstractComponentCallbacksC0187t.e();
            if (e4.f2737C != null) {
                if (bundle != null) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                    }
                    if (P.J(2)) {
                        Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + abstractComponentCallbacksC0187t);
                    }
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                T2.h.e(intentSender, "intentSender");
                g.j jVar = new g.j(intentSender, intent2, i5, i6);
                e4.f2739E.addLast(new L(abstractComponentCallbacksC0187t.f2928j, i4));
                if (P.J(2)) {
                    Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0187t + "is launching an IntentSender for result ");
                }
                e4.f2737C.a(jVar);
                return;
            }
            C0191x c0191x = e4.f2770v;
            c0191x.getClass();
            T2.h.e(intentSender, "intent");
            if (i4 == -1) {
                AbstractActivityC0416k abstractActivityC0416k = c0191x.f2948f;
                if (abstractActivityC0416k != null) {
                    abstractActivityC0416k.startIntentSenderForResult(intentSender, i4, intent2, i5, i6, i7, bundle);
                    return;
                }
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0187t + " not attached to Activity");
    }

    public void supportFinishAfterTransition() {
        finishAfterTransition();
    }

    public void supportPostponeEnterTransition() {
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        startPostponedEnterTransition();
    }

    @Override // x.InterfaceC0701a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i4) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, Intent intent, int i4) {
        startActivityFromFragment(abstractComponentCallbacksC0187t, intent, i4, (Bundle) null);
    }
}
