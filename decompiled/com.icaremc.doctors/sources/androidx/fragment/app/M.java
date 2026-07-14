package androidx.fragment.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.EnumC0145o;
import e.InterfaceC0177b;
import io.flutter.embedding.android.FlutterFragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import u.InterfaceC0310a;

/* loaded from: classes.dex */
public abstract class M extends d.k implements InterfaceC0310a {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final S mFragments;
    boolean mResumed;
    final C0152w mFragmentLifecycleRegistry = new C0152w(this);
    boolean mStopped = true;

    public M() {
        final FlutterFragmentActivity flutterFragmentActivity = (FlutterFragmentActivity) this;
        this.mFragments = new S(new L(flutterFragmentActivity));
        getSavedStateRegistry().c(LIFECYCLE_TAG, new I(0, flutterFragmentActivity));
        final int i2 = 0;
        addOnConfigurationChangedListener(new D.a() { // from class: androidx.fragment.app.J
            @Override // D.a
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        flutterFragmentActivity.mFragments.a();
                        return;
                    default:
                        flutterFragmentActivity.mFragments.a();
                        return;
                }
            }
        });
        final int i3 = 1;
        addOnNewIntentListener(new D.a() { // from class: androidx.fragment.app.J
            @Override // D.a
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        flutterFragmentActivity.mFragments.a();
                        return;
                    default:
                        flutterFragmentActivity.mFragments.a();
                        return;
                }
            }
        });
        addOnContextAvailableListener(new InterfaceC0177b() { // from class: androidx.fragment.app.K
            @Override // e.InterfaceC0177b
            public final void a(d.k kVar) {
                L l2 = FlutterFragmentActivity.this.mFragments.f1565a;
                l2.f1569f.b(l2, l2, null);
            }
        });
    }

    public static boolean f(h0 h0Var) {
        boolean z = false;
        for (H h2 : h0Var.f1635c.f()) {
            if (h2 != null) {
                if (h2.getHost() != null) {
                    z |= f(h2.getChildFragmentManager());
                }
                A0 a02 = h2.mViewLifecycleOwner;
                EnumC0145o enumC0145o = EnumC0145o.f1847f;
                if (a02 != null) {
                    a02.b();
                    if (a02.f1500f.f1855c.compareTo(enumC0145o) >= 0) {
                        h2.mViewLifecycleOwner.f1500f.g();
                        z = true;
                    }
                }
                if (h2.mLifecycleRegistry.f1855c.compareTo(enumC0145o) >= 0) {
                    h2.mLifecycleRegistry.g();
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f1565a.f1569f.f1638f.onCreateView(view, str, context, attributeSet);
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
            U.a.a(this).b(str2, printWriter);
        }
        this.mFragments.f1565a.f1569f.v(str, fileDescriptor, printWriter, strArr);
    }

    public h0 getSupportFragmentManager() {
        return this.mFragments.f1565a.f1569f;
    }

    @Deprecated
    public U.a getSupportLoaderManager() {
        return U.a.a(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (f(getSupportFragmentManager()));
    }

    @Override // d.k, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(H h2) {
    }

    @Override // d.k, u.AbstractActivityC0312c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(EnumC0144n.ON_CREATE);
        i0 i0Var = this.mFragments.f1565a.f1569f;
        i0Var.f1625G = false;
        i0Var.f1626H = false;
        i0Var.f1631N.f1672i = false;
        i0Var.u(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f1565a.f1569f.l();
        this.mFragmentLifecycleRegistry.e(EnumC0144n.ON_DESTROY);
    }

    @Override // d.k, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 6) {
            return this.mFragments.f1565a.f1569f.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f1565a.f1569f.u(5);
        this.mFragmentLifecycleRegistry.e(EnumC0144n.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // d.k, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f1565a.f1569f.z(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(EnumC0144n.ON_RESUME);
        i0 i0Var = this.mFragments.f1565a.f1569f;
        i0Var.f1625G = false;
        i0Var.f1626H = false;
        i0Var.f1631N.f1672i = false;
        i0Var.u(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            i0 i0Var = this.mFragments.f1565a.f1569f;
            i0Var.f1625G = false;
            i0Var.f1626H = false;
            i0Var.f1631N.f1672i = false;
            i0Var.u(4);
        }
        this.mFragments.f1565a.f1569f.z(true);
        this.mFragmentLifecycleRegistry.e(EnumC0144n.ON_START);
        i0 i0Var2 = this.mFragments.f1565a.f1569f;
        i0Var2.f1625G = false;
        i0Var2.f1626H = false;
        i0Var2.f1631N.f1672i = false;
        i0Var2.u(5);
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
        i0 i0Var = this.mFragments.f1565a.f1569f;
        i0Var.f1626H = true;
        i0Var.f1631N.f1672i = true;
        i0Var.u(4);
        this.mFragmentLifecycleRegistry.e(EnumC0144n.ON_STOP);
    }

    public void setEnterSharedElementCallback(u.N n2) {
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(u.N n2) {
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(H h2, Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            h2.startActivityForResult(intent, i2, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(H h2, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (i2 == -1) {
            startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            h2.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        finishAfterTransition();
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        startPostponedEnterTransition();
    }

    @Override // u.InterfaceC0310a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(H h2, Intent intent, int i2) {
        startActivityFromFragment(h2, intent, i2, (Bundle) null);
    }
}
