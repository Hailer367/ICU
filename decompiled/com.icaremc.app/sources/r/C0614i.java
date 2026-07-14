package r;

import I.B;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: r.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0614i {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f5996a;

    /* renamed from: b, reason: collision with root package name */
    public final Z0.g f5997b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f5998c;

    /* renamed from: d, reason: collision with root package name */
    public ActivityOptions f5999d;

    /* renamed from: e, reason: collision with root package name */
    public Bundle f6000e;

    /* renamed from: f, reason: collision with root package name */
    public int f6001f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6002g;

    /* JADX WARN: Type inference failed for: r0v1, types: [Z0.g, java.lang.Object] */
    public C0614i() {
        this.f5996a = new Intent("android.intent.action.VIEW");
        this.f5997b = new Object();
        this.f6001f = 0;
        this.f6002g = true;
    }

    public final C0615j a() {
        String str;
        Bundle bundle;
        Intent intent = this.f5996a;
        Bundle bundle2 = null;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle3 = new Bundle();
            bundle3.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle3);
        }
        ArrayList<? extends Parcelable> arrayList = this.f5998c;
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f6002g);
        this.f5997b.getClass();
        intent.putExtras(new Bundle());
        Bundle bundle4 = this.f6000e;
        if (bundle4 != null) {
            intent.putExtras(bundle4);
        }
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f6001f);
        int i4 = Build.VERSION.SDK_INT;
        LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
        if (adjustedDefault.size() > 0) {
            str = adjustedDefault.get(0).toLanguageTag();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (intent.hasExtra("com.android.browser.headers")) {
                bundle = intent.getBundleExtra("com.android.browser.headers");
            } else {
                bundle = new Bundle();
            }
            if (!bundle.containsKey("Accept-Language")) {
                bundle.putString("Accept-Language", str);
                intent.putExtra("com.android.browser.headers", bundle);
            }
        }
        if (i4 >= 34) {
            if (this.f5999d == null) {
                this.f5999d = ActivityOptions.makeBasic();
            }
            B.h(this.f5999d);
        }
        if (i4 >= 36) {
            if (this.f5999d == null) {
                this.f5999d = ActivityOptions.makeBasic();
            }
            J.d.e(this.f5999d, !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
        }
        ActivityOptions activityOptions = this.f5999d;
        if (activityOptions != null) {
            bundle2 = activityOptions.toBundle();
        }
        return new C0615j(intent, bundle2);
    }

    public final void b(int i4) {
        if (i4 >= 0 && i4 <= 2) {
            this.f6001f = i4;
            Intent intent = this.f5996a;
            if (i4 == 1) {
                intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
                return;
            } else if (i4 == 2) {
                intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
                return;
            } else {
                intent.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid value for the shareState argument");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [Z0.g, java.lang.Object] */
    public C0614i(o oVar) {
        Intent intent = new Intent("android.intent.action.VIEW");
        this.f5996a = intent;
        this.f5997b = new Object();
        this.f6001f = 0;
        this.f6002g = true;
        if (oVar != null) {
            intent.setPackage(oVar.f6014d.getPackageName());
            BinderC0612g binderC0612g = oVar.f6013c;
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", binderC0612g);
            intent.putExtras(bundle);
        }
    }
}
