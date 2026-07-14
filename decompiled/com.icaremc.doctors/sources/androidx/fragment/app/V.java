package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class V implements LayoutInflater.Factory2 {

    /* renamed from: c, reason: collision with root package name */
    public final h0 f1572c;

    public V(h0 h0Var) {
        this.f1572c = h0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        o0 g2;
        boolean equals = Q.class.getName().equals(str);
        h0 h0Var = this.f1572c;
        if (equals) {
            return new Q(context, attributeSet, h0Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Q.a.f710a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z = H.class.isAssignableFrom(C0100a0.a(attributeValue, context.getClassLoader()));
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (z) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    H C2 = resourceId != -1 ? h0Var.C(resourceId) : null;
                    if (C2 == null && string != null) {
                        C2 = h0Var.D(string);
                    }
                    if (C2 == null && id != -1) {
                        C2 = h0Var.C(id);
                    }
                    if (C2 == null) {
                        C0100a0 H2 = h0Var.H();
                        context.getClassLoader();
                        C2 = H.instantiate(H2.f1581a.f1652v.f1567d, attributeValue, null);
                        C2.mFromLayout = true;
                        C2.mFragmentId = resourceId != 0 ? resourceId : id;
                        C2.mContainerId = id;
                        C2.mTag = string;
                        C2.mInLayout = true;
                        C2.mFragmentManager = h0Var;
                        T t2 = h0Var.f1652v;
                        C2.mHost = t2;
                        C2.onInflate((Context) t2.f1567d, attributeSet, C2.mSavedFragmentState);
                        g2 = h0Var.a(C2);
                        if (h0.K(2)) {
                            Log.v("FragmentManager", "Fragment " + C2 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else if (!C2.mInLayout) {
                        C2.mInLayout = true;
                        C2.mFragmentManager = h0Var;
                        T t3 = h0Var.f1652v;
                        C2.mHost = t3;
                        C2.onInflate((Context) t3.f1567d, attributeSet, C2.mSavedFragmentState);
                        g2 = h0Var.g(C2);
                        if (h0.K(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + C2 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    R.c cVar = R.d.f732a;
                    R.d.b(new R.h(C2, "Attempting to use <fragment> tag to add fragment " + C2 + " to container " + viewGroup));
                    R.d.a(C2).getClass();
                    C2.mContainer = viewGroup;
                    g2.k();
                    g2.j();
                    View view2 = C2.mView;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (C2.mView.getTag() == null) {
                            C2.mView.setTag(string);
                        }
                        C2.mView.addOnAttachStateChangeListener(new U(this, g2));
                        return C2.mView;
                    }
                    throw new IllegalStateException(O.a.g("Fragment ", attributeValue, " did not create a view."));
                }
            }
        }
        return null;
    }
}
