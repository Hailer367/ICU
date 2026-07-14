package j;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: j.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0395C implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public final View f4875f;

    /* renamed from: g, reason: collision with root package name */
    public final String f4876g;

    /* renamed from: h, reason: collision with root package name */
    public Method f4877h;

    /* renamed from: i, reason: collision with root package name */
    public Context f4878i;

    public ViewOnClickListenerC0395C(View view, String str) {
        this.f4875f = view;
        this.f4876g = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f4877h == null) {
            View view2 = this.f4875f;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f4876g;
                if (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                            this.f4877h = method;
                            this.f4878i = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                } else {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
                }
            }
        }
        try {
            this.f4877h.invoke(this.f4878i, view);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException("Could not execute method for android:onClick", e5);
        }
    }
}
