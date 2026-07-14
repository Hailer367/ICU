package androidx.fragment.app;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import f.C0185a;
import f.C0195k;
import f.C0196l;
import g.AbstractC0199b;
import g.C0198a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: androidx.fragment.app.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0104c0 extends AbstractC0199b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1598a;

    public /* synthetic */ C0104c0(int i2) {
        this.f1598a = i2;
    }

    @Override // g.AbstractC0199b
    public final Intent a(M m2, Object obj) {
        Bundle bundleExtra;
        switch (this.f1598a) {
            case 0:
                C0195k c0195k = (C0195k) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = c0195k.f2273d;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        c0195k = new C0195k(c0195k.f2272c, null, c0195k.f2274e, c0195k.f2275f);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c0195k);
                if (h0.K(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                return d(m2, (C0196l) obj);
            case 2:
                String[] input = (String[]) obj;
                kotlin.jvm.internal.h.e(input, "input");
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
                kotlin.jvm.internal.h.d(putExtra, "putExtra(...)");
                return putExtra;
            default:
                Intent input2 = (Intent) obj;
                kotlin.jvm.internal.h.e(input2, "input");
                return input2;
        }
    }

    @Override // g.AbstractC0199b
    public C0198a b(M m2, Object obj) {
        switch (this.f1598a) {
            case 1:
                kotlin.jvm.internal.h.e((C0196l) obj, "input");
                return null;
            case 2:
                String[] input = (String[]) obj;
                kotlin.jvm.internal.h.e(input, "input");
                if (input.length == 0) {
                    return new C0198a(R0.s.f751c);
                }
                for (String str : input) {
                    if (android.support.v4.media.session.a.e(m2, str) != 0) {
                        return null;
                    }
                }
                int X2 = R0.u.X(input.length);
                if (X2 < 16) {
                    X2 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(X2);
                for (String str2 : input) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new C0198a(linkedHashMap);
            default:
                return super.b(m2, obj);
        }
    }

    @Override // g.AbstractC0199b
    public final Object c(int i2, Intent intent) {
        List arrayList;
        boolean z;
        switch (this.f1598a) {
            case 0:
                return new C0185a(i2, intent);
            case 1:
                Object obj = null;
                if (i2 != -1) {
                    intent = null;
                }
                if (intent == null) {
                    return null;
                }
                Uri data = intent.getData();
                if (data == null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Uri data2 = intent.getData();
                    if (data2 != null) {
                        linkedHashSet.add(data2);
                    }
                    ClipData clipData = intent.getClipData();
                    if (clipData == null && linkedHashSet.isEmpty()) {
                        arrayList = R0.r.f750c;
                    } else {
                        if (clipData != null) {
                            int itemCount = clipData.getItemCount();
                            for (int i3 = 0; i3 < itemCount; i3++) {
                                Uri uri = clipData.getItemAt(i3).getUri();
                                if (uri != null) {
                                    linkedHashSet.add(uri);
                                }
                            }
                        }
                        arrayList = new ArrayList(linkedHashSet);
                    }
                    if (!arrayList.isEmpty()) {
                        obj = arrayList.get(0);
                    }
                    return (Uri) obj;
                }
                return data;
            case 2:
                if (i2 == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList2 = new ArrayList(intArrayExtra.length);
                        for (int i4 : intArrayExtra) {
                            if (i4 == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList2.add(Boolean.valueOf(z));
                        }
                        ArrayList arrayList3 = new ArrayList();
                        for (String str : stringArrayExtra) {
                            if (str != null) {
                                arrayList3.add(str);
                            }
                        }
                        Iterator it = arrayList3.iterator();
                        Iterator it2 = arrayList2.iterator();
                        ArrayList arrayList4 = new ArrayList(Math.min(R0.l.O(arrayList3), R0.l.O(arrayList2)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList4.add(new Q0.e(it.next(), it2.next()));
                        }
                        return R0.u.Y(arrayList4);
                    }
                }
                return R0.s.f751c;
            default:
                return new C0185a(i2, intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 >= 2) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent d(android.content.Context r4, f.C0196l r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.h.e(r4, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.h.e(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto L12
            goto L1d
        L12:
            r1 = 30
            if (r0 < r1) goto L38
            int r0 = E.a0.C()
            r1 = 2
            if (r0 < r1) goto L38
        L1d:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r0 = "android.provider.action.PICK_IMAGES"
            r4.<init>(r0)
            g.h r0 = r5.f2276a
            java.lang.String r0 = android.support.v4.media.session.a.s(r0)
            r4.setType(r0)
            g.d r5 = r5.f2278c
            r5.getClass()
            java.lang.String r5 = "android.provider.extra.PICK_IMAGES_LAUNCH_TAB"
            r4.putExtra(r5, r2)
            return r4
        L38:
            android.content.pm.ResolveInfo r0 = android.support.v4.media.session.a.o(r4)
            if (r0 == 0) goto L72
            android.content.pm.ResolveInfo r4 = android.support.v4.media.session.a.o(r4)
            if (r4 == 0) goto L6a
            android.content.pm.ActivityInfo r4 = r4.activityInfo
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "androidx.activity.result.contract.action.PICK_IMAGES"
            r0.<init>(r1)
            android.content.pm.ApplicationInfo r1 = r4.applicationInfo
            java.lang.String r1 = r1.packageName
            java.lang.String r4 = r4.name
            r0.setClassName(r1, r4)
            g.h r4 = r5.f2276a
            java.lang.String r4 = android.support.v4.media.session.a.s(r4)
            r0.setType(r4)
            g.d r4 = r5.f2278c
            r4.getClass()
            java.lang.String r4 = "androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB"
            r0.putExtra(r4, r2)
            return r0
        L6a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Required value was null."
            r4.<init>(r5)
            throw r4
        L72:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.OPEN_DOCUMENT"
            r4.<init>(r0)
            g.h r5 = r5.f2276a
            java.lang.String r5 = android.support.v4.media.session.a.s(r5)
            r4.setType(r5)
            java.lang.String r5 = r4.getType()
            if (r5 != 0) goto L9a
        */
        //  java.lang.String r5 = "*/*"
        /*
            r4.setType(r5)
            java.lang.String r5 = "image/*"
            java.lang.String r0 = "video/*"
            java.lang.String[] r5 = new java.lang.String[]{r5, r0}
            java.lang.String r0 = "android.intent.extra.MIME_TYPES"
            r4.putExtra(r0, r5)
        L9a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0104c0.d(android.content.Context, f.l):android.content.Intent");
    }
}
