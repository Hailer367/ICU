package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.EnumC0145o;
import androidx.lifecycle.InterfaceC0140j;
import androidx.lifecycle.InterfaceC0150u;
import b0.C0163e;
import b0.C0164f;
import b0.InterfaceC0165g;
import com.icaremc.doctors.R;
import f.AbstractC0187c;
import f.AbstractC0193i;
import f.C0195k;
import f.InterfaceC0186b;
import g.AbstractC0199b;
import io.flutter.embedding.android.FlutterFragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class H implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0150u, androidx.lifecycle.d0, InterfaceC0140j, InterfaceC0165g {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    E mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    androidx.lifecycle.a0 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    h0 mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    T mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    C0152w mLifecycleRegistry;
    H mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    C0164f mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    H mTarget;
    int mTargetRequestCode;
    boolean mTransitioning;
    View mView;
    A0 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    h0 mChildFragmentManager = new h0();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new RunnableC0129y(this, 0);
    EnumC0145o mMaxState = EnumC0145o.f1848g;
    androidx.lifecycle.D mViewLifecycleOwnerLiveData = new androidx.lifecycle.C();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<F> mOnPreAttachedListeners = new ArrayList<>();
    private final F mSavedStateAttachListener = new C0130z(this);

    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.lifecycle.D, androidx.lifecycle.C] */
    public H() {
        d();
    }

    @Deprecated
    public static H instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.E, java.lang.Object] */
    public final E a() {
        if (this.mAnimationInfo == null) {
            ?? obj = new Object();
            obj.f1525i = null;
            Object obj2 = USE_DEFAULT_TRANSITION;
            obj.f1526j = obj2;
            obj.f1527k = null;
            obj.f1528l = obj2;
            obj.f1529m = null;
            obj.f1530n = obj2;
            obj.q = 1.0f;
            obj.f1532r = null;
            this.mAnimationInfo = obj;
        }
        return this.mAnimationInfo;
    }

    public final int b() {
        EnumC0145o enumC0145o = this.mMaxState;
        if (enumC0145o != EnumC0145o.f1845d && this.mParentFragment != null) {
            return Math.min(enumC0145o.ordinal(), this.mParentFragment.b());
        }
        return enumC0145o.ordinal();
    }

    public final H c(boolean z) {
        String str;
        if (z) {
            R.c cVar = R.d.f732a;
            R.d.b(new R.h(this, "Attempting to get target fragment from fragment " + this));
            R.d.a(this).getClass();
        }
        H h2 = this.mTarget;
        if (h2 != null) {
            return h2;
        }
        h0 h0Var = this.mFragmentManager;
        if (h0Var != null && (str = this.mTargetWho) != null) {
            return h0Var.f1635c.b(str);
        }
        return null;
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        h0 h0Var;
        E e2 = this.mAnimationInfo;
        if (e2 != null) {
            e2.f1533s = false;
        }
        if (this.mView != null && (viewGroup = this.mContainer) != null && (h0Var = this.mFragmentManager) != null) {
            C0121p j2 = C0121p.j(viewGroup, h0Var);
            j2.k();
            if (z) {
                this.mHost.f1568e.post(new RunnableC0122q(1, j2));
            } else {
                j2.e();
            }
            Handler handler = this.mPostponedHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mPostponedDurationRunnable);
                this.mPostponedHandler = null;
            }
        }
    }

    public P createFragmentContainer() {
        return new A(this);
    }

    public final void d() {
        this.mLifecycleRegistry = new C0152w(this);
        this.mSavedStateRegistryController = new C0164f(this);
        this.mDefaultFactory = null;
        if (!this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            F f2 = this.mSavedStateAttachListener;
            if (this.mState >= 0) {
                f2.a();
            } else {
                this.mOnPreAttachedListeners.add(f2);
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        H c2 = c(false);
        if (c2 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(c2);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            U.a.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.v(O.a.f(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final C0128x e(AbstractC0199b abstractC0199b, C c2, InterfaceC0186b interfaceC0186b) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            D d2 = new D(this, c2, atomicReference, abstractC0199b, interfaceC0186b);
            if (this.mState >= 0) {
                d2.a();
            } else {
                this.mOnPreAttachedListeners.add(d2);
            }
            return new C0128x(atomicReference);
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public H findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.f1635c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final M getActivity() {
        T t2 = this.mHost;
        if (t2 == null) {
            return null;
        }
        return t2.f1566c;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        E e2 = this.mAnimationInfo;
        if (e2 != null && (bool = e2.p) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        E e2 = this.mAnimationInfo;
        if (e2 != null && (bool = e2.f1531o) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public View getAnimatingAway() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        e2.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final h0 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        T t2 = this.mHost;
        if (t2 == null) {
            return null;
        }
        return t2.f1567d;
    }

    @Override // androidx.lifecycle.InterfaceC0140j
    public T.b getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        if (application == null && h0.K(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        T.c cVar = new T.c(0);
        LinkedHashMap linkedHashMap = cVar.f768a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.Y.f1824a, application);
        }
        linkedHashMap.put(androidx.lifecycle.S.f1806a, this);
        linkedHashMap.put(androidx.lifecycle.S.f1807b, this);
        if (getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.S.f1808c, getArguments());
        }
        return cVar;
    }

    public androidx.lifecycle.a0 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (applicationContext instanceof ContextWrapper) {
                        if (applicationContext instanceof Application) {
                            application = (Application) applicationContext;
                            break;
                        }
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    } else {
                        application = null;
                        break;
                    }
                }
                if (application == null && h0.K(3)) {
                    Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.mDefaultFactory = new androidx.lifecycle.V(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public int getEnterAnim() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return 0;
        }
        return e2.f1518b;
    }

    public Object getEnterTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        return e2.f1525i;
    }

    public u.N getEnterTransitionCallback() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        e2.getClass();
        return null;
    }

    public int getExitAnim() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return 0;
        }
        return e2.f1519c;
    }

    public Object getExitTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        return e2.f1527k;
    }

    public u.N getExitTransitionCallback() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        e2.getClass();
        return null;
    }

    public View getFocusedView() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        return e2.f1532r;
    }

    @Deprecated
    public final h0 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        T t2 = this.mHost;
        if (t2 == null) {
            return null;
        }
        return ((L) t2).f1553g;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.InterfaceC0150u
    public AbstractC0146p getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public U.a getLoaderManager() {
        return U.a.a(this);
    }

    public int getNextTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return 0;
        }
        return e2.f1522f;
    }

    public final H getParentFragment() {
        return this.mParentFragment;
    }

    public final h0 getParentFragmentManager() {
        h0 h0Var = this.mFragmentManager;
        if (h0Var != null) {
            return h0Var;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return false;
        }
        return e2.f1517a;
    }

    public int getPopEnterAnim() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return 0;
        }
        return e2.f1520d;
    }

    public int getPopExitAnim() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return 0;
        }
        return e2.f1521e;
    }

    public float getPostOnViewCreatedAlpha() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return 1.0f;
        }
        return e2.q;
    }

    public Object getReenterTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        Object obj = e2.f1528l;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getExitTransition();
        }
        return obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        R.c cVar = R.d.f732a;
        R.d.b(new R.h(this, "Attempting to get retain instance for fragment " + this));
        R.d.a(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        Object obj = e2.f1526j;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getEnterTransition();
        }
        return obj;
    }

    @Override // b0.InterfaceC0165g
    public final C0163e getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f1980b;
    }

    public Object getSharedElementEnterTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        return e2.f1529m;
    }

    public Object getSharedElementReturnTransition() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return null;
        }
        Object obj = e2.f1530n;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getSharedElementEnterTransition();
        }
        return obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        E e2 = this.mAnimationInfo;
        if (e2 != null && (arrayList = e2.f1523g) != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        E e2 = this.mAnimationInfo;
        if (e2 != null && (arrayList = e2.f1524h) != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final H getTargetFragment() {
        return c(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        R.c cVar = R.d.f732a;
        R.d.b(new R.h(this, "Attempting to get target request code from fragment " + this));
        R.d.a(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC0150u getViewLifecycleOwner() {
        A0 a02 = this.mViewLifecycleOwner;
        if (a02 != null) {
            return a02;
        }
        throw new IllegalStateException(O.a.e("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    public androidx.lifecycle.C getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.d0
    public androidx.lifecycle.c0 getViewModelStore() {
        if (this.mFragmentManager != null) {
            if (b() != 1) {
                HashMap hashMap = this.mFragmentManager.f1631N.f1669f;
                androidx.lifecycle.c0 c0Var = (androidx.lifecycle.c0) hashMap.get(this.mWho);
                if (c0Var == null) {
                    androidx.lifecycle.c0 c0Var2 = new androidx.lifecycle.c0();
                    hashMap.put(this.mWho, c0Var2);
                    return c0Var2;
                }
                return c0Var;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        d();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new h0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        if (this.mHost != null && this.mAdded) {
            return true;
        }
        return false;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        boolean isHidden;
        if (!this.mHidden) {
            h0 h0Var = this.mFragmentManager;
            if (h0Var != null) {
                H h2 = this.mParentFragment;
                h0Var.getClass();
                if (h2 == null) {
                    isHidden = false;
                } else {
                    isHidden = h2.isHidden();
                }
                if (isHidden) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean isInBackStack() {
        if (this.mBackStackNesting > 0) {
            return true;
        }
        return false;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        boolean isMenuVisible;
        if (this.mMenuVisible) {
            if (this.mFragmentManager != null) {
                H h2 = this.mParentFragment;
                if (h2 == null) {
                    isMenuVisible = true;
                } else {
                    isMenuVisible = h2.isMenuVisible();
                }
                if (!isMenuVisible) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isPostponed() {
        E e2 = this.mAnimationInfo;
        if (e2 == null) {
            return false;
        }
        return e2.f1533s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        if (this.mState >= 7) {
            return true;
        }
        return false;
    }

    public final boolean isStateSaved() {
        h0 h0Var = this.mFragmentManager;
        if (h0Var == null) {
            return false;
        }
        if (!h0Var.f1625G && !h0Var.f1626H) {
            return false;
        }
        return true;
    }

    public final boolean isVisible() {
        View view;
        if (isAdded() && !isHidden() && (view = this.mView) != null && view.getWindowToken() != null && this.mView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.P();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (h0.K(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        T t2 = this.mHost;
        FlutterFragmentActivity flutterFragmentActivity = t2 == null ? null : t2.f1566c;
        if (flutterFragmentActivity != null) {
            this.mCalled = false;
            onAttach((Activity) flutterFragmentActivity);
        }
    }

    @Deprecated
    public void onAttachFragment(H h2) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        h0 h0Var = this.mChildFragmentManager;
        if (h0Var.f1651u >= 1) {
            return;
        }
        h0Var.f1625G = false;
        h0Var.f1626H = false;
        h0Var.f1631N.f1672i = false;
        h0Var.u(1);
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        T t2 = this.mHost;
        FlutterFragmentActivity flutterFragmentActivity = t2 == null ? null : t2.f1566c;
        if (flutterFragmentActivity != null) {
            this.mCalled = false;
            onInflate((Activity) flutterFragmentActivity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public abstract void onSaveInstanceState(Bundle bundle);

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        Bundle bundle2;
        this.mChildFragmentManager.P();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            if (h0.K(3)) {
                Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
            }
            if (this.mView != null) {
                Bundle bundle3 = this.mSavedFragmentState;
                if (bundle3 != null) {
                    bundle2 = bundle3.getBundle("savedInstanceState");
                } else {
                    bundle2 = null;
                }
                restoreViewState(bundle2);
            }
            this.mSavedFragmentState = null;
            h0 h0Var = this.mChildFragmentManager;
            h0Var.f1625G = false;
            h0Var.f1626H = false;
            h0Var.f1631N.f1672i = false;
            h0Var.u(4);
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        ArrayList<F> arrayList = this.mOnPreAttachedListeners;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            F f2 = arrayList.get(i2);
            i2++;
            f2.a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.f1567d);
        if (this.mCalled) {
            Iterator it = this.mFragmentManager.f1647o.iterator();
            while (it.hasNext()) {
                ((l0) it.next()).a(this);
            }
            h0 h0Var = this.mChildFragmentManager;
            h0Var.f1625G = false;
            h0Var.f1626H = false;
            h0Var.f1631N.f1672i = false;
            h0Var.u(0);
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onAttach()"));
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            return this.mChildFragmentManager.j(menuItem);
        }
        return false;
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.P();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new B(this));
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.e(EnumC0144n.ON_CREATE);
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.k(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.P();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new A0(this, getViewModelStore(), new RunnableC0127w(0, this));
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.b();
            if (h0.K(3)) {
                Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.mView + " for Fragment " + this);
            }
            View view = this.mView;
            A0 a02 = this.mViewLifecycleOwner;
            kotlin.jvm.internal.h.e(view, "<this>");
            view.setTag(R.id.view_tree_lifecycle_owner, a02);
            View view2 = this.mView;
            A0 a03 = this.mViewLifecycleOwner;
            kotlin.jvm.internal.h.e(view2, "<this>");
            view2.setTag(R.id.view_tree_view_model_store_owner, a03);
            View view3 = this.mView;
            A0 a04 = this.mViewLifecycleOwner;
            kotlin.jvm.internal.h.e(view3, "<this>");
            view3.setTag(R.id.view_tree_saved_state_registry_owner, a04);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.f1500f == null) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.l();
        this.mLifecycleRegistry.e(EnumC0144n.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
        } else {
            throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.u(1);
        if (this.mView != null) {
            A0 a02 = this.mViewLifecycleOwner;
            a02.b();
            if (a02.f1500f.f1855c.compareTo(EnumC0145o.f1846e) >= 0) {
                this.mViewLifecycleOwner.a(EnumC0144n.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            r.k kVar = U.a.a(this).f779b.f777d;
            if (kVar.f3576e <= 0) {
                this.mPerformedCreateView = false;
                return;
            } else {
                kVar.f3575d[0].getClass();
                throw new ClassCastException();
            }
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            h0 h0Var = this.mChildFragmentManager;
            if (!h0Var.f1627I) {
                h0Var.l();
                this.mChildFragmentManager = new h0();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onDetach()"));
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            return this.mChildFragmentManager.p(menuItem);
        }
        return false;
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.q(menu);
        }
    }

    public void performPause() {
        this.mChildFragmentManager.u(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0144n.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(EnumC0144n.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
        } else {
            throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.t(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean N2 = h0.N(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool != null && bool.booleanValue() == N2) {
            return;
        }
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(N2);
        onPrimaryNavigationFragmentChanged(N2);
        h0 h0Var = this.mChildFragmentManager;
        h0Var.e0();
        h0Var.r(h0Var.y);
    }

    public void performResume() {
        this.mChildFragmentManager.P();
        this.mChildFragmentManager.z(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            C0152w c0152w = this.mLifecycleRegistry;
            EnumC0144n enumC0144n = EnumC0144n.ON_RESUME;
            c0152w.e(enumC0144n);
            if (this.mView != null) {
                this.mViewLifecycleOwner.f1500f.e(enumC0144n);
            }
            h0 h0Var = this.mChildFragmentManager;
            h0Var.f1625G = false;
            h0Var.f1626H = false;
            h0Var.f1631N.f1672i = false;
            h0Var.u(7);
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.P();
        this.mChildFragmentManager.z(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            C0152w c0152w = this.mLifecycleRegistry;
            EnumC0144n enumC0144n = EnumC0144n.ON_START;
            c0152w.e(enumC0144n);
            if (this.mView != null) {
                this.mViewLifecycleOwner.f1500f.e(enumC0144n);
            }
            h0 h0Var = this.mChildFragmentManager;
            h0Var.f1625G = false;
            h0Var.f1626H = false;
            h0Var.f1631N.f1672i = false;
            h0Var.u(5);
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
        h0 h0Var = this.mChildFragmentManager;
        h0Var.f1626H = true;
        h0Var.f1631N.f1672i = true;
        h0Var.u(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0144n.ON_STOP);
        }
        this.mLifecycleRegistry.e(EnumC0144n.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
        } else {
            throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        onViewCreated(this.mView, bundle);
        this.mChildFragmentManager.u(2);
    }

    public void postponeEnterTransition() {
        a().f1533s = true;
    }

    public final <I, O> AbstractC0187c registerForActivityResult(AbstractC0199b abstractC0199b, InterfaceC0186b interfaceC0186b) {
        return e(abstractC0199b, new C(0, this), interfaceC0186b);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] permissions, int i2) {
        if (this.mHost != null) {
            h0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f1622D != null) {
                parentFragmentManager.f1623E.addLast(new C0106d0(this.mWho, i2));
                parentFragmentManager.f1622D.a(permissions);
                return;
            } else {
                parentFragmentManager.f1652v.getClass();
                kotlin.jvm.internal.h.e(permissions, "permissions");
                return;
            }
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to Activity"));
    }

    public final M requireActivity() {
        M activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final h0 requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to a host."));
    }

    public final H requireParentFragment() {
        H parentFragment = getParentFragment();
        if (parentFragment == null) {
            if (getContext() == null) {
                throw new IllegalStateException(O.a.e("Fragment ", this, " is not attached to any Fragment or host"));
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
        }
        return parentFragment;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 != null && (bundle = bundle2.getBundle("childFragmentManager")) != null) {
            this.mChildFragmentManager.V(bundle);
            h0 h0Var = this.mChildFragmentManager;
            h0Var.f1625G = false;
            h0Var.f1626H = false;
            h0Var.f1631N.f1672i = false;
            h0Var.u(1);
        }
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(EnumC0144n.ON_CREATE);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException(O.a.e("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        a().p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        a().f1531o = Boolean.valueOf(z);
    }

    public void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        a().f1518b = i2;
        a().f1519c = i3;
        a().f1520d = i4;
        a().f1521e = i5;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(u.N n2) {
        a().getClass();
    }

    public void setEnterTransition(Object obj) {
        a().f1525i = obj;
    }

    public void setExitSharedElementCallback(u.N n2) {
        a().getClass();
    }

    public void setExitTransition(Object obj) {
        a().f1527k = obj;
    }

    public void setFocusedView(View view) {
        a().f1532r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                ((L) this.mHost).f1553g.invalidateMenu();
            }
        }
    }

    public void setInitialSavedState(G g2) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (g2 == null || (bundle = g2.f1547c) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((L) this.mHost).f1553g.invalidateMenu();
            }
        }
    }

    public void setNextTransition(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        a();
        this.mAnimationInfo.f1522f = i2;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        a().f1517a = z;
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        a().q = f2;
    }

    public void setReenterTransition(Object obj) {
        a().f1528l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        R.c cVar = R.d.f732a;
        R.d.b(new R.h(this, "Attempting to set retain instance for fragment " + this));
        R.d.a(this).getClass();
        this.mRetainInstance = z;
        h0 h0Var = this.mFragmentManager;
        if (h0Var != null) {
            if (z) {
                h0Var.f1631N.c(this);
                return;
            } else {
                h0Var.f1631N.g(this);
                return;
            }
        }
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object obj) {
        a().f1526j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        a().f1529m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        a();
        E e2 = this.mAnimationInfo;
        e2.f1523g = arrayList;
        e2.f1524h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        a().f1530n = obj;
    }

    @Deprecated
    public void setTargetFragment(H h2, int i2) {
        h0 h0Var;
        if (h2 != null) {
            R.c cVar = R.d.f732a;
            R.d.b(new R.h(this, "Attempting to set target fragment " + h2 + " with request code " + i2 + " for fragment " + this));
            R.d.a(this).getClass();
        }
        h0 h0Var2 = this.mFragmentManager;
        if (h2 != null) {
            h0Var = h2.mFragmentManager;
        } else {
            h0Var = null;
        }
        if (h0Var2 != null && h0Var != null && h0Var2 != h0Var) {
            throw new IllegalArgumentException(O.a.e("Fragment ", h2, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (H h3 = h2; h3 != null; h3 = h3.c(false)) {
            if (h3.equals(this)) {
                throw new IllegalArgumentException("Setting " + h2 + " as the target of " + this + " would create a target cycle");
            }
        }
        if (h2 == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && h2.mFragmentManager != null) {
            this.mTargetWho = h2.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = h2;
        }
        this.mTargetRequestCode = i2;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        R.c cVar = R.d.f732a;
        R.d.b(new R.h(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        R.d.a(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            h0 h0Var = this.mFragmentManager;
            o0 g2 = h0Var.g(this);
            H h2 = g2.f1711c;
            if (h2.mDeferStart) {
                if (h0Var.f1634b) {
                    h0Var.f1628J = true;
                } else {
                    h2.mDeferStart = false;
                    g2.k();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        T t2 = this.mHost;
        if (t2 != null) {
            FlutterFragmentActivity flutterFragmentActivity = ((L) t2).f1553g;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                if (i2 >= 32) {
                    return flutterFragmentActivity.shouldShowRequestPermissionRationale(str);
                }
                if (i2 == 31) {
                    try {
                        return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(flutterFragmentActivity.getApplication().getPackageManager(), str)).booleanValue();
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        return flutterFragmentActivity.shouldShowRequestPermissionRationale(str);
                    }
                }
                return flutterFragmentActivity.shouldShowRequestPermissionRationale(str);
            }
            return false;
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intent, int i2, Intent intent2, int i3, int i4, int i5, Bundle bundle) {
        if (this.mHost != null) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intent + " fillInIntent: " + intent2 + " options: " + bundle);
            }
            h0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f1621C != null) {
                if (bundle != null) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                    }
                    if (h0.K(2)) {
                        Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
                    }
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                kotlin.jvm.internal.h.e(intent, "intentSender");
                C0195k c0195k = new C0195k(intent, intent2, i3, i4);
                parentFragmentManager.f1623E.addLast(new C0106d0(this.mWho, i2));
                if (h0.K(2)) {
                    Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
                }
                parentFragmentManager.f1621C.a(c0195k);
                return;
            }
            T t2 = parentFragmentManager.f1652v;
            t2.getClass();
            kotlin.jvm.internal.h.e(intent, "intent");
            if (i2 == -1) {
                FlutterFragmentActivity flutterFragmentActivity = t2.f1566c;
                if (flutterFragmentActivity != null) {
                    flutterFragmentActivity.startIntentSenderForResult(intent, i2, intent2, i3, i4, i5, bundle);
                    return;
                }
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && a().f1533s) {
            if (this.mHost == null) {
                a().f1533s = false;
            } else if (Looper.myLooper() != this.mHost.f1568e.getLooper()) {
                this.mHost.f1568e.postAtFrontOfQueue(new RunnableC0129y(this, 1));
            } else {
                callStartTransitionListener(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static H instantiate(Context context, String str, Bundle bundle) {
        try {
            H h2 = (H) C0100a0.b(str, context.getClassLoader()).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return h2;
            }
            bundle.setClassLoader(h2.getClass().getClassLoader());
            h2.setArguments(bundle);
            return h2;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(O.a.g("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(O.a.g("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(O.a.g("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(O.a.g("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
        }
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        a().f1533s = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        h0 h0Var = this.mFragmentManager;
        if (h0Var != null) {
            this.mPostponedHandler = h0Var.f1652v.f1568e;
        } else {
            this.mPostponedHandler = new Handler(Looper.getMainLooper());
        }
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> AbstractC0187c registerForActivityResult(AbstractC0199b abstractC0199b, AbstractC0193i abstractC0193i, InterfaceC0186b interfaceC0186b) {
        return e(abstractC0199b, new C(1, abstractC0193i), interfaceC0186b);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        T t2 = this.mHost;
        if (t2 != null) {
            kotlin.jvm.internal.h.e(intent, "intent");
            t2.f1567d.startActivity(intent, bundle);
            return;
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        if (this.mHost != null) {
            h0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f1620B != null) {
                parentFragmentManager.f1623E.addLast(new C0106d0(this.mWho, i2));
                if (bundle != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                parentFragmentManager.f1620B.a(intent);
                return;
            }
            T t2 = parentFragmentManager.f1652v;
            t2.getClass();
            kotlin.jvm.internal.h.e(intent, "intent");
            if (i2 == -1) {
                t2.f1567d.startActivity(intent, bundle);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(O.a.e("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        T t2 = this.mHost;
        if (t2 != null) {
            FlutterFragmentActivity flutterFragmentActivity = ((L) t2).f1553g;
            LayoutInflater cloneInContext = flutterFragmentActivity.getLayoutInflater().cloneInContext(flutterFragmentActivity);
            cloneInContext.setFactory2(this.mChildFragmentManager.f1638f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
