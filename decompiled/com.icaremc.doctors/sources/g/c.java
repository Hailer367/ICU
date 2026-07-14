package g;

import R0.r;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.M;
import f.C0196l;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class c extends AbstractC0199b {

    /* renamed from: a, reason: collision with root package name */
    public final int f2282a;

    public c(int i2) {
        this.f2282a = i2;
        if (i2 > 1) {
        } else {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    @Override // g.AbstractC0199b
    public final C0198a b(M m2, Object obj) {
        C0196l input = (C0196l) obj;
        kotlin.jvm.internal.h.e(input, "input");
        return null;
    }

    @Override // g.AbstractC0199b
    public final Object c(int i2, Intent intent) {
        if (i2 != -1) {
            intent = null;
        }
        if (intent != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData != null || !linkedHashSet.isEmpty()) {
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        Uri uri = clipData.getItemAt(i3).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }
        }
        return r.f750c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if (r0 >= 2) goto L9;
     */
    @Override // g.AbstractC0199b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.Intent a(android.content.Context r6, f.C0196l r7) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.h.e(r6, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.h.e(r7, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 0
            int r3 = r5.f2282a
            r4 = 1
            if (r0 < r1) goto L15
            goto L20
        L15:
            r1 = 30
            if (r0 < r1) goto L5b
            int r0 = E.a0.C()
            r1 = 2
            if (r0 < r1) goto L5b
        L20:
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "android.provider.action.PICK_IMAGES"
            r6.<init>(r0)
            g.h r0 = r7.f2276a
            java.lang.String r0 = android.support.v4.media.session.a.s(r0)
            r6.setType(r0)
            int r0 = r7.f2277b
            int r0 = java.lang.Math.min(r3, r0)
            if (r0 <= r4) goto L53
            int r1 = F.c.a()
            if (r0 > r1) goto L53
            java.lang.String r1 = "android.provider.extra.PICK_IMAGES_MAX"
            r6.putExtra(r1, r0)
            g.d r7 = r7.f2278c
            r7.getClass()
            java.lang.String r7 = "android.provider.extra.PICK_IMAGES_LAUNCH_TAB"
            r6.putExtra(r7, r4)
            java.lang.String r7 = "android.provider.extra.PICK_IMAGES_IN_ORDER"
            r6.putExtra(r7, r2)
            return r6
        L53:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()"
            r6.<init>(r7)
            throw r6
        L5b:
            android.content.pm.ResolveInfo r0 = android.support.v4.media.session.a.o(r6)
            if (r0 == 0) goto Laf
            android.content.pm.ResolveInfo r6 = android.support.v4.media.session.a.o(r6)
            if (r6 == 0) goto La7
            android.content.pm.ActivityInfo r6 = r6.activityInfo
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "androidx.activity.result.contract.action.PICK_IMAGES"
            r0.<init>(r1)
            android.content.pm.ApplicationInfo r1 = r6.applicationInfo
            java.lang.String r1 = r1.packageName
            java.lang.String r6 = r6.name
            r0.setClassName(r1, r6)
            g.h r6 = r7.f2276a
            java.lang.String r6 = android.support.v4.media.session.a.s(r6)
            r0.setType(r6)
            int r6 = r7.f2277b
            int r6 = java.lang.Math.min(r3, r6)
            if (r6 <= r4) goto L9f
            java.lang.String r1 = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX"
            r0.putExtra(r1, r6)
            g.d r6 = r7.f2278c
            r6.getClass()
            java.lang.String r6 = "androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB"
            r0.putExtra(r6, r4)
            java.lang.String r6 = "androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER"
            r0.putExtra(r6, r2)
            return r0
        L9f:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Max items must be greater than 1"
            r6.<init>(r7)
            throw r6
        La7:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Required value was null."
            r6.<init>(r7)
            throw r6
        Laf:
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.OPEN_DOCUMENT"
            r6.<init>(r0)
            g.h r7 = r7.f2276a
            java.lang.String r7 = android.support.v4.media.session.a.s(r7)
            r6.setType(r7)
            java.lang.String r7 = "android.intent.extra.ALLOW_MULTIPLE"
            r6.putExtra(r7, r4)
            java.lang.String r7 = r6.getType()
            if (r7 != 0) goto Ldc
        */
        //  java.lang.String r7 = "*/*"
        /*
            r6.setType(r7)
            java.lang.String r7 = "image/*"
            java.lang.String r0 = "video/*"
            java.lang.String[] r7 = new java.lang.String[]{r7, r0}
            java.lang.String r0 = "android.intent.extra.MIME_TYPES"
            r6.putExtra(r0, r7)
        Ldc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g.c.a(android.content.Context, f.l):android.content.Intent");
    }
}
