package androidx.fragment.app;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.EnumC0145o;
import com.icaremc.doctors.R;
import io.flutter.embedding.android.FlutterFragmentActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final N f1709a;

    /* renamed from: b, reason: collision with root package name */
    public final p0 f1710b;

    /* renamed from: c, reason: collision with root package name */
    public final H f1711c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1712d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f1713e = -1;

    public o0(N n2, p0 p0Var, H h2) {
        this.f1709a = n2;
        this.f1710b = p0Var;
        this.f1711c = h2;
    }

    public final void a() {
        Bundle bundle;
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + h2);
        }
        Bundle bundle2 = h2.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        h2.performActivityCreated(bundle);
        this.f1709a.a(h2, false);
    }

    public final void b() {
        H h2;
        View view;
        View view2;
        H h3;
        H h4 = this.f1711c;
        View view3 = h4.mContainer;
        while (true) {
            h2 = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            if (tag instanceof H) {
                h3 = (H) tag;
            } else {
                h3 = null;
            }
            if (h3 != null) {
                h2 = h3;
                break;
            }
            Object parent = view3.getParent();
            if (parent instanceof View) {
                view3 = (View) parent;
            } else {
                view3 = null;
            }
        }
        H parentFragment = h4.getParentFragment();
        if (h2 != null && !h2.equals(parentFragment)) {
            int i2 = h4.mContainerId;
            R.c cVar = R.d.f732a;
            R.d.b(new R.h(h4, "Attempting to nest fragment " + h4 + " within the view of parent fragment " + h2 + " via container with ID " + i2 + " without using parent's childFragmentManager"));
            R.d.a(h4).getClass();
        }
        ArrayList arrayList = this.f1710b.f1719a;
        ViewGroup viewGroup = h4.mContainer;
        int i3 = -1;
        if (viewGroup != null) {
            int indexOf = arrayList.indexOf(h4);
            int i4 = indexOf - 1;
            while (true) {
                if (i4 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        H h5 = (H) arrayList.get(indexOf);
                        if (h5.mContainer == viewGroup && (view = h5.mView) != null) {
                            i3 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    H h6 = (H) arrayList.get(i4);
                    if (h6.mContainer == viewGroup && (view2 = h6.mView) != null) {
                        i3 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i4--;
                }
            }
        }
        h4.mContainer.addView(h4.mView, i3);
    }

    public final void c() {
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "moveto ATTACHED: " + h2);
        }
        H h3 = h2.mTarget;
        o0 o0Var = null;
        p0 p0Var = this.f1710b;
        if (h3 != null) {
            o0 o0Var2 = (o0) p0Var.f1720b.get(h3.mWho);
            if (o0Var2 != null) {
                h2.mTargetWho = h2.mTarget.mWho;
                h2.mTarget = null;
                o0Var = o0Var2;
            } else {
                throw new IllegalStateException("Fragment " + h2 + " declared target fragment " + h2.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = h2.mTargetWho;
            if (str != null && (o0Var = (o0) p0Var.f1720b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(h2);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(O.a.i(sb, h2.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (o0Var != null) {
            o0Var.k();
        }
        h0 h0Var = h2.mFragmentManager;
        h2.mHost = h0Var.f1652v;
        h2.mParentFragment = h0Var.f1654x;
        N n2 = this.f1709a;
        n2.g(h2, false);
        h2.performAttach();
        n2.b(h2, false);
    }

    public final int d() {
        int i2;
        int i3;
        H h2 = this.f1711c;
        if (h2.mFragmentManager == null) {
            return h2.mState;
        }
        int i4 = this.f1713e;
        int ordinal = h2.mMaxState.ordinal();
        int i5 = 0;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        i4 = Math.min(i4, -1);
                    }
                } else {
                    i4 = Math.min(i4, 5);
                }
            } else {
                i4 = Math.min(i4, 1);
            }
        } else {
            i4 = Math.min(i4, 0);
        }
        if (h2.mFromLayout) {
            if (h2.mInLayout) {
                i4 = Math.max(this.f1713e, 2);
                View view = h2.mView;
                if (view != null && view.getParent() == null) {
                    i4 = Math.min(i4, 2);
                }
            } else {
                i4 = this.f1713e < 4 ? Math.min(i4, h2.mState) : Math.min(i4, 1);
            }
        }
        if (!h2.mAdded) {
            i4 = Math.min(i4, 1);
        }
        ViewGroup viewGroup = h2.mContainer;
        if (viewGroup != null) {
            C0121p j2 = C0121p.j(viewGroup, h2.getParentFragmentManager());
            j2.getClass();
            E0 g2 = j2.g(h2);
            if (g2 != null) {
                i2 = g2.f1535b;
            } else {
                i2 = 0;
            }
            E0 h3 = j2.h(h2);
            if (h3 != null) {
                i5 = h3.f1535b;
            }
            if (i2 == 0) {
                i3 = -1;
            } else {
                i3 = F0.f1546a[N.i.b(i2)];
            }
            if (i3 != -1 && i3 != 1) {
                i5 = i2;
            }
        }
        if (i5 == 2) {
            i4 = Math.min(i4, 6);
        } else if (i5 == 3) {
            i4 = Math.max(i4, 3);
        } else if (h2.mRemoving) {
            if (h2.isInBackStack()) {
                i4 = Math.min(i4, 1);
            } else {
                i4 = Math.min(i4, -1);
            }
        }
        if (h2.mDeferStart && h2.mState < 5) {
            i4 = Math.min(i4, 4);
        }
        if (h2.mTransitioning && h2.mContainer != null) {
            i4 = Math.max(i4, 3);
        }
        if (h0.K(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i4 + " for " + h2);
        }
        return i4;
    }

    public final void e() {
        Bundle bundle;
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "moveto CREATED: " + h2);
        }
        Bundle bundle2 = h2.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        if (!h2.mIsCreated) {
            N n2 = this.f1709a;
            n2.h(h2, false);
            h2.performCreate(bundle);
            n2.c(h2, false);
            return;
        }
        h2.mState = 1;
        h2.restoreChildFragmentState();
    }

    public final void f() {
        Bundle bundle;
        String str;
        H h2 = this.f1711c;
        if (h2.mFromLayout) {
            return;
        }
        if (h0.K(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + h2);
        }
        Bundle bundle2 = h2.mSavedFragmentState;
        ViewGroup viewGroup = null;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        LayoutInflater performGetLayoutInflater = h2.performGetLayoutInflater(bundle);
        ViewGroup viewGroup2 = h2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = h2.mContainerId;
            if (i2 != 0) {
                if (i2 != -1) {
                    viewGroup = (ViewGroup) h2.mFragmentManager.f1653w.b(i2);
                    if (viewGroup == null) {
                        if (!h2.mRestored) {
                            try {
                                str = h2.getResources().getResourceName(h2.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(h2.mContainerId) + " (" + str + ") for fragment " + h2);
                        }
                    } else if (!(viewGroup instanceof Q)) {
                        R.c cVar = R.d.f732a;
                        R.d.b(new R.h(h2, "Attempting to add fragment " + h2 + " to container " + viewGroup + " which is not a FragmentContainerView"));
                        R.d.a(h2).getClass();
                    }
                } else {
                    throw new IllegalArgumentException(O.a.e("Cannot create fragment ", h2, " for a container view with no id"));
                }
            }
        }
        h2.mContainer = viewGroup;
        h2.performCreateView(performGetLayoutInflater, viewGroup, bundle);
        if (h2.mView != null) {
            if (h0.K(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + h2);
            }
            h2.mView.setSaveFromParentEnabled(false);
            h2.mView.setTag(R.id.fragment_container_view_tag, h2);
            if (viewGroup != null) {
                b();
            }
            if (h2.mHidden) {
                h2.mView.setVisibility(8);
            }
            if (h2.mView.isAttachedToWindow()) {
                View view = h2.mView;
                Field field = E.J.f180a;
                view.requestApplyInsets();
            } else {
                View view2 = h2.mView;
                view2.addOnAttachStateChangeListener(new n0(view2));
            }
            h2.performViewCreated();
            this.f1709a.m(h2, h2.mView, false);
            int visibility = h2.mView.getVisibility();
            h2.setPostOnViewCreatedAlpha(h2.mView.getAlpha());
            if (h2.mContainer != null && visibility == 0) {
                View findFocus = h2.mView.findFocus();
                if (findFocus != null) {
                    h2.setFocusedView(findFocus);
                    if (h0.K(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + h2);
                    }
                }
                h2.mView.setAlpha(0.0f);
            }
        }
        h2.mState = 2;
    }

    public final void g() {
        boolean z;
        boolean z2;
        H b2;
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "movefrom CREATED: " + h2);
        }
        boolean z3 = true;
        int i2 = 0;
        if (h2.mRemoving && !h2.isInBackStack()) {
            z = true;
        } else {
            z = false;
        }
        p0 p0Var = this.f1710b;
        if (z && !h2.mBeingSaved) {
            p0Var.i(null, h2.mWho);
        }
        if (!z) {
            k0 k0Var = p0Var.f1722d;
            if (k0Var.f1667d.containsKey(h2.mWho) && k0Var.f1670g) {
                z2 = k0Var.f1671h;
            } else {
                z2 = true;
            }
            if (!z2) {
                String str = h2.mTargetWho;
                if (str != null && (b2 = p0Var.b(str)) != null && b2.mRetainInstance) {
                    h2.mTarget = b2;
                }
                h2.mState = 0;
                return;
            }
        }
        T t2 = h2.mHost;
        if (t2 instanceof androidx.lifecycle.d0) {
            z3 = p0Var.f1722d.f1671h;
        } else {
            FlutterFragmentActivity flutterFragmentActivity = t2.f1567d;
            if (flutterFragmentActivity != null) {
                z3 = true ^ flutterFragmentActivity.isChangingConfigurations();
            }
        }
        if ((z && !h2.mBeingSaved) || z3) {
            p0Var.f1722d.d(h2, false);
        }
        h2.performDestroy();
        this.f1709a.d(h2, false);
        ArrayList d2 = p0Var.d();
        int size = d2.size();
        while (i2 < size) {
            Object obj = d2.get(i2);
            i2++;
            o0 o0Var = (o0) obj;
            if (o0Var != null) {
                H h3 = o0Var.f1711c;
                if (h2.mWho.equals(h3.mTargetWho)) {
                    h3.mTarget = h2;
                    h3.mTargetWho = null;
                }
            }
        }
        String str2 = h2.mTargetWho;
        if (str2 != null) {
            h2.mTarget = p0Var.b(str2);
        }
        p0Var.h(this);
    }

    public final void h() {
        View view;
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + h2);
        }
        ViewGroup viewGroup = h2.mContainer;
        if (viewGroup != null && (view = h2.mView) != null) {
            viewGroup.removeView(view);
        }
        h2.performDestroyView();
        this.f1709a.n(h2, false);
        h2.mContainer = null;
        h2.mView = null;
        h2.mViewLifecycleOwner = null;
        h2.mViewLifecycleOwnerLiveData.setValue(null);
        h2.mInLayout = false;
    }

    public final void i() {
        boolean z;
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + h2);
        }
        h2.performDetach();
        this.f1709a.e(h2, false);
        h2.mState = -1;
        h2.mHost = null;
        h2.mParentFragment = null;
        h2.mFragmentManager = null;
        if (!h2.mRemoving || h2.isInBackStack()) {
            k0 k0Var = this.f1710b.f1722d;
            if (k0Var.f1667d.containsKey(h2.mWho) && k0Var.f1670g) {
                z = k0Var.f1671h;
            } else {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        if (h0.K(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + h2);
        }
        h2.initState();
    }

    public final void j() {
        Bundle bundle;
        H h2 = this.f1711c;
        if (h2.mFromLayout && h2.mInLayout && !h2.mPerformedCreateView) {
            if (h0.K(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + h2);
            }
            Bundle bundle2 = h2.mSavedFragmentState;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            h2.performCreateView(h2.performGetLayoutInflater(bundle), null, bundle);
            View view = h2.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                h2.mView.setTag(R.id.fragment_container_view_tag, h2);
                if (h2.mHidden) {
                    h2.mView.setVisibility(8);
                }
                h2.performViewCreated();
                this.f1709a.m(h2, h2.mView, false);
                h2.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01b4, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o0.k():void");
    }

    public final void l(ClassLoader classLoader) {
        H h2 = this.f1711c;
        Bundle bundle = h2.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (h2.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                h2.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
            }
            try {
                h2.mSavedViewState = h2.mSavedFragmentState.getSparseParcelableArray("viewState");
                h2.mSavedViewRegistryState = h2.mSavedFragmentState.getBundle("viewRegistryState");
                m0 m0Var = (m0) h2.mSavedFragmentState.getParcelable("state");
                if (m0Var != null) {
                    h2.mTargetWho = m0Var.f1690n;
                    h2.mTargetRequestCode = m0Var.f1691o;
                    Boolean bool = h2.mSavedUserVisibleHint;
                    if (bool != null) {
                        h2.mUserVisibleHint = bool.booleanValue();
                        h2.mSavedUserVisibleHint = null;
                    } else {
                        h2.mUserVisibleHint = m0Var.p;
                    }
                }
                if (!h2.mUserVisibleHint) {
                    h2.mDeferStart = true;
                }
            } catch (BadParcelableException e2) {
                throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + h2, e2);
            }
        }
    }

    public final void m() {
        String str;
        boolean K2 = h0.K(3);
        H h2 = this.f1711c;
        if (K2) {
            Log.d("FragmentManager", "moveto RESUMED: " + h2);
        }
        View focusedView = h2.getFocusedView();
        if (focusedView != null) {
            if (focusedView != h2.mView) {
                for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != h2.mView) {
                    }
                }
            }
            boolean requestFocus = focusedView.requestFocus();
            if (h0.K(2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb.append(str);
                sb.append(" on Fragment ");
                sb.append(h2);
                sb.append(" resulting in focused view ");
                sb.append(h2.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        h2.setFocusedView(null);
        h2.performResume();
        this.f1709a.i(h2, false);
        this.f1710b.i(null, h2.mWho);
        h2.mSavedFragmentState = null;
        h2.mSavedViewState = null;
        h2.mSavedViewRegistryState = null;
    }

    public final Bundle n() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        H h2 = this.f1711c;
        if (h2.mState == -1 && (bundle = h2.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new m0(h2));
        if (h2.mState > -1) {
            Bundle bundle3 = new Bundle();
            h2.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f1709a.j(h2, bundle3, false);
            Bundle bundle4 = new Bundle();
            h2.mSavedStateRegistryController.c(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle W2 = h2.mChildFragmentManager.W();
            if (!W2.isEmpty()) {
                bundle2.putBundle("childFragmentManager", W2);
            }
            if (h2.mView != null) {
                o();
            }
            SparseArray<Parcelable> sparseArray = h2.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = h2.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = h2.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void o() {
        H h2 = this.f1711c;
        if (h2.mView != null) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + h2 + " with view " + h2.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            h2.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                h2.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            h2.mViewLifecycleOwner.f1501g.c(bundle);
            if (!bundle.isEmpty()) {
                h2.mSavedViewRegistryState = bundle;
            }
        }
    }

    public o0(N n2, p0 p0Var, ClassLoader classLoader, C0100a0 c0100a0, Bundle bundle) {
        this.f1709a = n2;
        this.f1710b = p0Var;
        m0 m0Var = (m0) bundle.getParcelable("state");
        H instantiate = H.instantiate(c0100a0.f1581a.f1652v.f1567d, m0Var.f1679c, null);
        instantiate.mWho = m0Var.f1680d;
        instantiate.mFromLayout = m0Var.f1681e;
        instantiate.mRestored = true;
        instantiate.mFragmentId = m0Var.f1682f;
        instantiate.mContainerId = m0Var.f1683g;
        instantiate.mTag = m0Var.f1684h;
        instantiate.mRetainInstance = m0Var.f1685i;
        instantiate.mRemoving = m0Var.f1686j;
        instantiate.mDetached = m0Var.f1687k;
        instantiate.mHidden = m0Var.f1688l;
        instantiate.mMaxState = EnumC0145o.values()[m0Var.f1689m];
        instantiate.mTargetWho = m0Var.f1690n;
        instantiate.mTargetRequestCode = m0Var.f1691o;
        instantiate.mUserVisibleHint = m0Var.p;
        this.f1711c = instantiate;
        instantiate.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle2);
        if (h0.K(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public o0(N n2, p0 p0Var, H h2, Bundle bundle) {
        this.f1709a = n2;
        this.f1710b = p0Var;
        this.f1711c = h2;
        h2.mSavedViewState = null;
        h2.mSavedViewRegistryState = null;
        h2.mBackStackNesting = 0;
        h2.mInLayout = false;
        h2.mAdded = false;
        H h3 = h2.mTarget;
        h2.mTargetWho = h3 != null ? h3.mWho : null;
        h2.mTarget = null;
        h2.mSavedFragmentState = bundle;
        h2.mArguments = bundle.getBundle("arguments");
    }
}
