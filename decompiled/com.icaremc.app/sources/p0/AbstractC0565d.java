package p0;

import android.content.Context;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import q0.AbstractC0598c;
import q0.C0597b;
import q0.InterfaceC0600e;

/* renamed from: p0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0565d {

    /* renamed from: a, reason: collision with root package name */
    public static final q0.j f5800a = new Object();

    public static boolean a(String str) {
        C0597b c0597b = q0.x.f5907a;
        Set<InterfaceC0600e> unmodifiableSet = Collections.unmodifiableSet(AbstractC0598c.f5863c);
        HashSet hashSet = new HashSet();
        for (InterfaceC0600e interfaceC0600e : unmodifiableSet) {
            if (((AbstractC0598c) interfaceC0600e).f5864a.equals(str)) {
                hashSet.add(interfaceC0600e);
            }
        }
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AbstractC0598c abstractC0598c = (AbstractC0598c) ((InterfaceC0600e) it.next());
                if (abstractC0598c.a() || abstractC0598c.b()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException(r2.k.d("Unknown feature ", str));
    }

    public static boolean b(Context context, String str) {
        C0597b c0597b = q0.x.f5907a;
        Set<q0.n> unmodifiableSet = Collections.unmodifiableSet(q0.n.f5878d);
        HashSet hashSet = new HashSet();
        for (q0.n nVar : unmodifiableSet) {
            if (nVar.f5879a.equals(str)) {
                hashSet.add(nVar);
            }
        }
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((q0.n) it.next()).a(context)) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException(r2.k.d("Unknown feature ", str));
    }

    public abstract void onMessage(o oVar, n nVar);

    public abstract void onRenderProcessResponsive(WebView webView, x xVar);

    public abstract void onRenderProcessUnresponsive(WebView webView, x xVar);
}
