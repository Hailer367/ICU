package m;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import java.io.IOException;
import n.r;
import o.AbstractC0546u0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class j extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f5178e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f5179f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f5180a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f5181b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f5182c;

    /* renamed from: d, reason: collision with root package name */
    public Object f5183d;

    static {
        Class[] clsArr = {Context.class};
        f5178e = clsArr;
        f5179f = clsArr;
    }

    public j(Context context) {
        super(context);
        this.f5182c = context;
        Object[] objArr = {context};
        this.f5180a = objArr;
        this.f5181b = objArr;
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

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        int i4;
        XmlPullParser xmlPullParser2;
        char charAt;
        char charAt2;
        boolean z;
        ColorStateList colorStateList;
        int resourceId;
        i iVar = new i(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i4 = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        while (!z3) {
            if (eventType != 1) {
                if (eventType != i4) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z4 && name2.equals(str)) {
                            xmlPullParser2 = xmlPullParser;
                            z4 = false;
                            str = null;
                            eventType = xmlPullParser2.next();
                            i4 = 2;
                            z3 = z3;
                            z4 = z4;
                        } else if (name2.equals("group")) {
                            iVar.f5155b = 0;
                            iVar.f5156c = 0;
                            iVar.f5157d = 0;
                            iVar.f5158e = 0;
                            iVar.f5159f = true;
                            iVar.f5160g = true;
                        } else if (name2.equals("item")) {
                            if (!iVar.f5161h) {
                                r rVar = iVar.z;
                                if (rVar != null && rVar.f5350a.hasSubMenu()) {
                                    iVar.f5161h = true;
                                    iVar.b(iVar.f5154a.addSubMenu(iVar.f5155b, iVar.f5162i, iVar.f5163j, iVar.k).getItem());
                                } else {
                                    iVar.f5161h = true;
                                    iVar.b(iVar.f5154a.add(iVar.f5155b, iVar.f5162i, iVar.f5163j, iVar.k));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z3 = true;
                        }
                    }
                    xmlPullParser2 = xmlPullParser;
                    z3 = z3;
                } else {
                    if (!z4) {
                        String name3 = xmlPullParser.getName();
                        if (name3.equals("group")) {
                            TypedArray obtainStyledAttributes = this.f5182c.obtainStyledAttributes(attributeSet, AbstractC0357a.f4080p);
                            iVar.f5155b = obtainStyledAttributes.getResourceId(1, 0);
                            iVar.f5156c = obtainStyledAttributes.getInt(3, 0);
                            iVar.f5157d = obtainStyledAttributes.getInt(4, 0);
                            iVar.f5158e = obtainStyledAttributes.getInt(5, 0);
                            iVar.f5159f = obtainStyledAttributes.getBoolean(i4, true);
                            iVar.f5160g = obtainStyledAttributes.getBoolean(0, true);
                            obtainStyledAttributes.recycle();
                        } else {
                            if (name3.equals("item")) {
                                int[] iArr = AbstractC0357a.f4081q;
                                Context context = this.f5182c;
                                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr);
                                iVar.f5162i = obtainStyledAttributes2.getResourceId(i4, 0);
                                iVar.f5163j = (obtainStyledAttributes2.getInt(6, iVar.f5157d) & 65535) | (obtainStyledAttributes2.getInt(5, iVar.f5156c) & (-65536));
                                iVar.k = obtainStyledAttributes2.getText(7);
                                iVar.f5164l = obtainStyledAttributes2.getText(8);
                                iVar.f5165m = obtainStyledAttributes2.getResourceId(0, 0);
                                String string = obtainStyledAttributes2.getString(9);
                                if (string == null) {
                                    charAt = 0;
                                } else {
                                    charAt = string.charAt(0);
                                }
                                iVar.f5166n = charAt;
                                iVar.f5167o = obtainStyledAttributes2.getInt(16, 4096);
                                String string2 = obtainStyledAttributes2.getString(10);
                                if (string2 == null) {
                                    charAt2 = 0;
                                } else {
                                    charAt2 = string2.charAt(0);
                                }
                                iVar.f5168p = charAt2;
                                iVar.f5169q = obtainStyledAttributes2.getInt(20, 4096);
                                if (obtainStyledAttributes2.hasValue(11)) {
                                    iVar.f5170r = obtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                                } else {
                                    iVar.f5170r = iVar.f5158e;
                                }
                                iVar.f5171s = obtainStyledAttributes2.getBoolean(3, false);
                                iVar.f5172t = obtainStyledAttributes2.getBoolean(4, iVar.f5159f);
                                iVar.f5173u = obtainStyledAttributes2.getBoolean(1, iVar.f5160g);
                                iVar.f5174v = obtainStyledAttributes2.getInt(21, -1);
                                iVar.f5177y = obtainStyledAttributes2.getString(12);
                                iVar.f5175w = obtainStyledAttributes2.getResourceId(13, 0);
                                iVar.f5176x = obtainStyledAttributes2.getString(15);
                                String string3 = obtainStyledAttributes2.getString(14);
                                if (string3 != null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z && iVar.f5175w == 0 && iVar.f5176x == null) {
                                    iVar.z = (r) iVar.a(string3, f5179f, this.f5181b);
                                } else {
                                    if (z) {
                                        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                    }
                                    iVar.z = null;
                                }
                                iVar.f5149A = obtainStyledAttributes2.getText(17);
                                iVar.f5150B = obtainStyledAttributes2.getText(22);
                                if (obtainStyledAttributes2.hasValue(19)) {
                                    iVar.f5152D = AbstractC0546u0.c(obtainStyledAttributes2.getInt(19, -1), iVar.f5152D);
                                } else {
                                    iVar.f5152D = null;
                                }
                                if (obtainStyledAttributes2.hasValue(18)) {
                                    if (!obtainStyledAttributes2.hasValue(18) || (resourceId = obtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = AbstractC0286a.n(context, resourceId)) == null) {
                                        colorStateList = obtainStyledAttributes2.getColorStateList(18);
                                    }
                                    iVar.f5151C = colorStateList;
                                } else {
                                    iVar.f5151C = null;
                                }
                                obtainStyledAttributes2.recycle();
                                iVar.f5161h = false;
                                xmlPullParser2 = xmlPullParser;
                            } else if (name3.equals("menu")) {
                                iVar.f5161h = true;
                                SubMenu addSubMenu = iVar.f5154a.addSubMenu(iVar.f5155b, iVar.f5162i, iVar.f5163j, iVar.k);
                                iVar.b(addSubMenu.getItem());
                                xmlPullParser2 = xmlPullParser;
                                b(xmlPullParser2, attributeSet, addSubMenu);
                            } else {
                                xmlPullParser2 = xmlPullParser;
                                str = name3;
                                z4 = true;
                            }
                            eventType = xmlPullParser2.next();
                            i4 = 2;
                            z3 = z3;
                            z4 = z4;
                        }
                    }
                    xmlPullParser2 = xmlPullParser;
                    z3 = z3;
                }
                eventType = xmlPullParser2.next();
                i4 = 2;
                z3 = z3;
                z4 = z4;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i4, Menu menu) {
        if (!(menu instanceof n.n)) {
            super.inflate(i4, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f5182c.getResources().getLayout(i4);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e4) {
                    throw new InflateException("Error inflating menu XML", e4);
                }
            } catch (XmlPullParserException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
