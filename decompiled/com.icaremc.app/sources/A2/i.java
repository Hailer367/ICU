package A2;

import D2.C0022a;
import D2.C0028g;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.P;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract /* synthetic */ class i {
    public static final void a(int i4, View view, ViewGroup viewGroup) {
        T2.h.e(view, "view");
        T2.h.e(viewGroup, "container");
        int b4 = R.i.b(i4);
        ViewGroup viewGroup2 = null;
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 != 2) {
                    if (b4 == 3) {
                        if (P.J(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    }
                    return;
                }
                if (P.J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                }
                view.setVisibility(8);
                return;
            }
            if (P.J(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) parent;
            }
            if (viewGroup2 == null) {
                if (P.J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + viewGroup);
                }
                viewGroup.addView(view);
            }
            view.setVisibility(0);
            return;
        }
        ViewParent parent2 = view.getParent();
        if (parent2 instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) parent2;
        }
        if (viewGroup2 != null) {
            if (P.J(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup2);
            }
            viewGroup2.removeView(view);
        }
    }

    public static int b(String str) {
        String str2;
        for (int i4 : R.i.c(2)) {
            if (i4 != 1) {
                if (i4 == 2) {
                    str2 = "Brightness.dark";
                } else {
                    throw null;
                }
            } else {
                str2 = "Brightness.light";
            }
            if (str2.equals(str)) {
                return i4;
            }
        }
        throw new NoSuchFieldException(r2.k.d("No such Brightness: ", str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r5) {
        /*
            r0 = 8
            int[] r0 = R.i.c(r0)
            int r1 = r0.length
            r2 = 0
        L8:
            if (r2 >= r1) goto L35
            r3 = r0[r2]
            r4 = 0
            switch(r3) {
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L20;
                case 4: goto L1d;
                case 5: goto L1a;
                case 6: goto L17;
                case 7: goto L14;
                case 8: goto L11;
                default: goto L10;
            }
        L10:
            throw r4
        L11:
            java.lang.String r4 = "HapticFeedbackType.errorNotification"
            goto L25
        L14:
            java.lang.String r4 = "HapticFeedbackType.warningNotification"
            goto L25
        L17:
            java.lang.String r4 = "HapticFeedbackType.successNotification"
            goto L25
        L1a:
            java.lang.String r4 = "HapticFeedbackType.selectionClick"
            goto L25
        L1d:
            java.lang.String r4 = "HapticFeedbackType.heavyImpact"
            goto L25
        L20:
            java.lang.String r4 = "HapticFeedbackType.mediumImpact"
            goto L25
        L23:
            java.lang.String r4 = "HapticFeedbackType.lightImpact"
        L25:
            if (r4 != 0) goto L29
            if (r5 == 0) goto L31
        L29:
            if (r4 == 0) goto L32
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L32
        L31:
            return r3
        L32:
            int r2 = r2 + 1
            goto L8
        L35:
            java.lang.NoSuchFieldException r0 = new java.lang.NoSuchFieldException
            java.lang.String r1 = "No such HapticFeedbackType: "
            java.lang.String r5 = r2.k.d(r1, r5)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.i.c(java.lang.String):int");
    }

    public static int d(String str) {
        String str2;
        for (int i4 : R.i.c(3)) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        str2 = "SystemSoundType.alert";
                    } else {
                        throw null;
                    }
                } else {
                    str2 = "SystemSoundType.tick";
                }
            } else {
                str2 = "SystemSoundType.click";
            }
            if (str2.equals(str)) {
                return i4;
            }
        }
        throw new NoSuchFieldException(r2.k.d("No such SoundType: ", str));
    }

    public static /* synthetic */ int e(int i4) {
        switch (i4) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return 64;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            case 12:
                return 2048;
            case 13:
                return 4096;
            case 14:
                return 8192;
            case 15:
                return 16384;
            case 16:
                return 32768;
            case 17:
                return 65536;
            case 18:
                return 131072;
            case 19:
                return 262144;
            case 20:
                return 524288;
            case 21:
                return 1048576;
            case 22:
                return 2097152;
            case 23:
                return 4194304;
            case 24:
                return 8388608;
            case 25:
                return 16777216;
            case 26:
                return 33554432;
            case 27:
                return 67108864;
            case 28:
                return 134217728;
            case 29:
                return 268435456;
            case 30:
                return 536870912;
            case 31:
                return 1073741824;
            case 32:
                return Integer.MIN_VALUE;
            default:
                throw null;
        }
    }

    public static ClassCastException f(ArrayList arrayList, int i4) {
        arrayList.get(i4).getClass();
        return new ClassCastException();
    }

    public static String g(int i4, String str) {
        return str + i4;
    }

    public static String h(String str, String str2, int i4, int i5) {
        return str + i4 + str2 + i5;
    }

    public static String i(String str, Throwable th, String str2, String str3) {
        return str + th + str2 + str3;
    }

    public static StringBuilder j(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static HashMap k(Class cls, F1.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(cls, aVar);
        return hashMap;
    }

    public static Map l(HashMap hashMap) {
        return Collections.unmodifiableMap(new HashMap(hashMap));
    }

    public static /* synthetic */ void m(int i4, String str) {
        if (i4 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = T2.h.class.getName();
            int i5 = 0;
            while (!stackTrace[i5].getClassName().equals(name)) {
                i5++;
            }
            while (stackTrace[i5].getClassName().equals(name)) {
                i5++;
            }
            StackTraceElement stackTraceElement = stackTrace[i5];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            T2.h.f(nullPointerException, T2.h.class.getName());
            throw nullPointerException;
        }
    }

    public static void n(C0022a c0022a, String str, Object obj) {
        C0028g.l(str, obj, H2.f.a(k3.b.f(c0022a)));
    }

    public static /* synthetic */ void o(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void p(String str, String str2, String str3) {
        k3.b.f(new C0022a(str, str2, str3));
    }

    public static void q(String str, String str2, String str3, String str4, Object obj) {
        C0028g.l(str4, obj, H2.f.a(k3.b.f(new C0022a(str, str2, str3))));
    }

    public static void r(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.e(str2, sb.toString());
    }

    public static /* synthetic */ String s(int i4) {
        switch (i4) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return "NUMBER";
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }
}
