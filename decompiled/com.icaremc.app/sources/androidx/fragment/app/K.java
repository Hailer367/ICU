package androidx.fragment.app;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import g.C0289a;
import h.AbstractC0296a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class K extends AbstractC0296a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2729a;

    public /* synthetic */ K(int i4) {
        this.f2729a = i4;
    }

    @Override // h.AbstractC0296a
    public final Intent a(AbstractActivityC0192y abstractActivityC0192y, Object obj) {
        Bundle bundleExtra;
        switch (this.f2729a) {
            case 0:
                g.j jVar = (g.j) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = jVar.f3761g;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        jVar = new g.j(jVar.f3760f, null, jVar.f3762h, jVar.f3763i);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", jVar);
                if (P.J(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                return d(abstractActivityC0192y, (g.k) obj);
            case 2:
                String[] strArr = (String[]) obj;
                T2.h.e(strArr, "input");
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                T2.h.d(putExtra, "putExtra(...)");
                return putExtra;
            default:
                Intent intent3 = (Intent) obj;
                T2.h.e(intent3, "input");
                return intent3;
        }
    }

    @Override // h.AbstractC0296a
    public A2.q b(AbstractActivityC0192y abstractActivityC0192y, Object obj) {
        switch (this.f2729a) {
            case 1:
                T2.h.e((g.k) obj, "input");
                return null;
            case 2:
                String[] strArr = (String[]) obj;
                T2.h.e(strArr, "input");
                if (strArr.length == 0) {
                    return new A2.q(22, I2.n.f863f);
                }
                for (String str : strArr) {
                    if (android.support.v4.media.session.a.i(abstractActivityC0192y, str) != 0) {
                        return null;
                    }
                }
                int Q2 = I2.p.Q(strArr.length);
                if (Q2 < 16) {
                    Q2 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(Q2);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new A2.q(22, linkedHashMap);
            default:
                return super.b(abstractActivityC0192y, obj);
        }
    }

    @Override // h.AbstractC0296a
    public final Object c(Intent intent, int i4) {
        List arrayList;
        boolean z;
        switch (this.f2729a) {
            case 0:
                return new C0289a(intent, i4);
            case 1:
                Object obj = null;
                if (i4 != -1) {
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
                        arrayList = I2.m.f862f;
                    } else {
                        if (clipData != null) {
                            int itemCount = clipData.getItemCount();
                            for (int i5 = 0; i5 < itemCount; i5++) {
                                Uri uri = clipData.getItemAt(i5).getUri();
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
                if (i4 == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList2 = new ArrayList(intArrayExtra.length);
                        for (int i6 : intArrayExtra) {
                            if (i6 == 0) {
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
                        ArrayList arrayList4 = new ArrayList(Math.min(arrayList3.size(), arrayList2.size()));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList4.add(new H2.d(it.next(), it2.next()));
                        }
                        return I2.p.R(arrayList4);
                    }
                }
                return I2.n.f863f;
            default:
                return new C0289a(intent, i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 >= 2) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent d(android.app.Activity r4, g.k r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            T2.h.e(r4, r0)
            java.lang.String r0 = "input"
            T2.h.e(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto L12
            goto L1d
        L12:
            r1 = 30
            if (r0 < r1) goto L38
            int r0 = F2.b.C()
            r1 = 2
            if (r0 < r1) goto L38
        L1d:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r0 = "android.provider.action.PICK_IMAGES"
            r4.<init>(r0)
            h.g r0 = r5.f3764a
            java.lang.String r0 = f1.AbstractC0286a.v(r0)
            r4.setType(r0)
            h.c r5 = r5.f3766c
            r5.getClass()
            java.lang.String r5 = "android.provider.extra.PICK_IMAGES_LAUNCH_TAB"
            r4.putExtra(r5, r2)
            return r4
        L38:
            android.content.pm.ResolveInfo r0 = f1.AbstractC0286a.t(r4)
            if (r0 == 0) goto L72
            android.content.pm.ResolveInfo r4 = f1.AbstractC0286a.t(r4)
            if (r4 == 0) goto L6a
            android.content.pm.ActivityInfo r4 = r4.activityInfo
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "androidx.activity.result.contract.action.PICK_IMAGES"
            r0.<init>(r1)
            android.content.pm.ApplicationInfo r1 = r4.applicationInfo
            java.lang.String r1 = r1.packageName
            java.lang.String r4 = r4.name
            r0.setClassName(r1, r4)
            h.g r4 = r5.f3764a
            java.lang.String r4 = f1.AbstractC0286a.v(r4)
            r0.setType(r4)
            h.c r4 = r5.f3766c
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
            h.g r5 = r5.f3764a
            java.lang.String r5 = f1.AbstractC0286a.v(r5)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.K.d(android.app.Activity, g.k):android.content.Intent");
    }
}
