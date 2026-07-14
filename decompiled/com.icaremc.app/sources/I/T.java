package I;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.icaremc.app.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import o.C0547v;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f702a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Field f703b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f704c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final E f705d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final G f706e = new G();

    public static Y a(View view) {
        if (f702a == null) {
            f702a = new WeakHashMap();
        }
        Y y3 = (Y) f702a.get(view);
        if (y3 == null) {
            Y y4 = new Y(view);
            f702a.put(view, y4);
            return y4;
        }
        return y3;
    }

    public static void b(View view, v0 v0Var) {
        WindowInsets a4;
        WindowInsets b4 = v0Var.b();
        if (b4 != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                a4 = P.a(view, b4);
            } else {
                a4 = I.a(view, b4);
            }
            if (!a4.equals(b4)) {
                v0.c(a4, view);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, I.S] */
    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList = S.f698d;
            S s3 = (S) view.getTag(R.id.tag_unhandled_key_event_manager);
            S s4 = s3;
            if (s3 == null) {
                ?? obj = new Object();
                obj.f699a = null;
                obj.f700b = null;
                obj.f701c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, obj);
                s4 = obj;
            }
            if (keyEvent.getAction() == 0) {
                WeakHashMap weakHashMap = s4.f699a;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                ArrayList arrayList2 = S.f698d;
                if (!arrayList2.isEmpty()) {
                    synchronized (arrayList2) {
                        try {
                            if (s4.f699a == null) {
                                s4.f699a = new WeakHashMap();
                            }
                            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                ArrayList arrayList3 = S.f698d;
                                View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                                if (view2 == null) {
                                    arrayList3.remove(size);
                                } else {
                                    s4.f699a.put(view2, Boolean.TRUE);
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        s4.f699a.put((View) parent, Boolean.TRUE);
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
            View a4 = s4.a(view);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (a4 != null && !KeyEvent.isModifierKey(keyCode)) {
                    if (s4.f700b == null) {
                        s4.f700b = new SparseArray();
                    }
                    s4.f700b.put(keyCode, new WeakReference(a4));
                }
            }
            if (a4 != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return O.a(view);
        }
        if (!f704c) {
            if (f703b == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    f703b = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable unused) {
                    f704c = true;
                    return null;
                }
            }
            try {
                Object obj = f703b.get(view);
                if (obj instanceof View.AccessibilityDelegate) {
                    return (View.AccessibilityDelegate) obj;
                }
                return null;
            } catch (Throwable unused2) {
                f704c = true;
                return null;
            }
        }
        return null;
    }

    public static String[] e(C0547v c0547v) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Q.a(c0547v);
        }
        return (String[]) c0547v.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void f(View view, int i4) {
        Object tag;
        boolean z;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i5 = Build.VERSION.SDK_INT;
            CharSequence charSequence = null;
            if (i5 >= 28) {
                tag = N.a(view);
            } else {
                tag = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            if (((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            int i6 = 32;
            if (view.getAccessibilityLiveRegion() == 0 && !z) {
                if (i4 == 32) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    view.onInitializeAccessibilityEvent(obtain);
                    obtain.setEventType(32);
                    obtain.setContentChangeTypes(i4);
                    obtain.setSource(view);
                    view.onPopulateAccessibilityEvent(obtain);
                    List<CharSequence> text = obtain.getText();
                    if (i5 >= 28) {
                        charSequence = N.a(view);
                    } else {
                        Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                        if (CharSequence.class.isInstance(tag2)) {
                            charSequence = tag2;
                        }
                    }
                    text.add(charSequence);
                    accessibilityManager.sendAccessibilityEvent(obtain);
                    return;
                }
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i4);
                        return;
                    } catch (AbstractMethodError e4) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e4);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            if (!z) {
                i6 = 2048;
            }
            obtain2.setEventType(i6);
            obtain2.setContentChangeTypes(i4);
            if (z) {
                List<CharSequence> text2 = obtain2.getText();
                if (i5 >= 28) {
                    charSequence = N.a(view);
                } else {
                    Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                    if (CharSequence.class.isInstance(tag3)) {
                        charSequence = tag3;
                    }
                }
                text2.add(charSequence);
                if (view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
            }
            view.sendAccessibilityEventUnchecked(obtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0052f g(View view, C0052f c0052f) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0052f + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Q.b(view, c0052f);
        }
        L.j jVar = (L.j) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC0067v interfaceC0067v = f705d;
        if (jVar != null) {
            C0052f a4 = L.j.a(view, c0052f);
            if (a4 == null) {
                return null;
            }
            if (view instanceof InterfaceC0067v) {
                interfaceC0067v = (InterfaceC0067v) view;
            }
            return interfaceC0067v.a(a4);
        }
        if (view instanceof InterfaceC0067v) {
            interfaceC0067v = (InterfaceC0067v) view;
        }
        return interfaceC0067v.a(c0052f);
    }

    public static void h(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            O.b(view, context, iArr, attributeSet, typedArray, i4, 0);
        }
    }

    public static void i(View view, C0048b c0048b) {
        C0047a c0047a;
        if (c0048b == null && (d(view) instanceof C0047a)) {
            c0048b = new C0048b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        if (c0048b == null) {
            c0047a = null;
        } else {
            c0047a = c0048b.f722b;
        }
        view.setAccessibilityDelegate(c0047a);
    }

    public static void j(View view, CharSequence charSequence) {
        boolean z;
        new F(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).d(view, charSequence);
        G g4 = f706e;
        if (charSequence != null) {
            WeakHashMap weakHashMap = g4.f690f;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z));
            view.addOnAttachStateChangeListener(g4);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(g4);
                return;
            }
            return;
        }
        g4.f690f.remove(view);
        view.removeOnAttachStateChangeListener(g4);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(g4);
    }
}
