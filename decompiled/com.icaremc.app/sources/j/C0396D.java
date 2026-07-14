package j;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import t.C0661j;

/* renamed from: j.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0396D {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f4879b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4880c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f4881d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f4882e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f4883f = {R.attr.screenReaderFocusable};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f4884g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h, reason: collision with root package name */
    public static final C0661j f4885h = new C0661j(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f4886a = new Object[2];

    public final View a(Context context, String str, String str2) {
        String concat;
        C0661j c0661j = f4885h;
        Constructor constructor = (Constructor) c0661j.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f4879b);
            c0661j.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f4886a);
    }
}
