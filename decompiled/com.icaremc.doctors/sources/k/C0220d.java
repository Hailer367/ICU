package k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import l.j;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: k.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0220d extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f2767e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f2768f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f2769a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2770b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f2771c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2772d;

    static {
        Class[] clsArr = {Context.class};
        f2767e = clsArr;
        f2768f = clsArr;
    }

    public C0220d(Context context) {
        super(context);
        this.f2771c = context;
        Object[] objArr = {context};
        this.f2769a = objArr;
        this.f2770b = objArr;
    }

    public static Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0208, code lost:
    
        if (r8 != null) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(org.xmlpull.v1.XmlPullParser r17, android.util.AttributeSet r18, android.view.Menu r19) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.C0220d.b(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i2, Menu menu) {
        if (!(menu instanceof j)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f2771c.getResources().getLayout(i2);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
