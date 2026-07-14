package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import j.AbstractActivityC0416k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class D implements LayoutInflater.Factory2 {

    /* renamed from: f, reason: collision with root package name */
    public final P f2716f;

    public D(P p3) {
        this.f2716f = p3;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t;
        X g4;
        boolean equals = B.class.getName().equals(str);
        P p3 = this.f2716f;
        if (equals) {
            return new B(context, attributeSet, p3);
        }
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t2 = null;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.a.f1987a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z = AbstractComponentCallbacksC0187t.class.isAssignableFrom(I.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (z) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    AbstractComponentCallbacksC0187t C3 = resourceId != -1 ? p3.C(resourceId) : null;
                    if (C3 == null && string != null) {
                        P1.y yVar = p3.f2752c;
                        ArrayList arrayList = (ArrayList) yVar.f1469f;
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size >= 0) {
                                AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t3 = (AbstractComponentCallbacksC0187t) arrayList.get(size);
                                abstractComponentCallbacksC0187t = abstractComponentCallbacksC0187t2;
                                if (abstractComponentCallbacksC0187t3 != null && string.equals(abstractComponentCallbacksC0187t3.f2906D)) {
                                    C3 = abstractComponentCallbacksC0187t3;
                                    break;
                                }
                                size--;
                                abstractComponentCallbacksC0187t2 = abstractComponentCallbacksC0187t;
                            } else {
                                abstractComponentCallbacksC0187t = abstractComponentCallbacksC0187t2;
                                Iterator it = ((HashMap) yVar.f1470g).values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        C3 = abstractComponentCallbacksC0187t;
                                        break;
                                    }
                                    X x3 = (X) it.next();
                                    if (x3 != null) {
                                        C3 = x3.f2804c;
                                        if (string.equals(C3.f2906D)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        abstractComponentCallbacksC0187t = null;
                    }
                    if (C3 == null && id != -1) {
                        C3 = p3.C(id);
                    }
                    if (C3 == null) {
                        I G3 = p3.G();
                        context.getClassLoader();
                        C3 = G3.a(attributeValue);
                        C3.f2936s = true;
                        C3.f2904B = resourceId != 0 ? resourceId : id;
                        C3.f2905C = id;
                        C3.f2906D = string;
                        C3.f2937t = true;
                        C3.f2941x = p3;
                        C0191x c0191x = p3.f2770v;
                        C3.f2942y = c0191x;
                        AbstractActivityC0416k abstractActivityC0416k = c0191x.f2949g;
                        C3.f2911I = true;
                        if ((c0191x == null ? abstractComponentCallbacksC0187t : c0191x.f2948f) != null) {
                            C3.f2911I = true;
                        }
                        g4 = p3.a(C3);
                        if (P.J(2)) {
                            Log.v("FragmentManager", "Fragment " + C3 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else if (!C3.f2937t) {
                        C3.f2937t = true;
                        C3.f2941x = p3;
                        C0191x c0191x2 = p3.f2770v;
                        C3.f2942y = c0191x2;
                        AbstractActivityC0416k abstractActivityC0416k2 = c0191x2.f2949g;
                        C3.f2911I = true;
                        if ((c0191x2 == null ? abstractComponentCallbacksC0187t : c0191x2.f2948f) != null) {
                            C3.f2911I = true;
                        }
                        g4 = p3.g(C3);
                        if (P.J(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + C3 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    Y.c cVar = Y.d.f2016a;
                    Y.d.b(new Y.a(C3, "Attempting to use <fragment> tag to add fragment " + C3 + " to container " + viewGroup));
                    Y.d.a(C3).getClass();
                    C3.f2912J = viewGroup;
                    g4.j();
                    g4.i();
                    throw new IllegalStateException(r2.k.b("Fragment ", attributeValue, " did not create a view."));
                }
            }
        }
        return null;
    }
}
