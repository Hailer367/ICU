package B;

import a.AbstractC0051a;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final r.i f44a = new r.i(2);

    /* renamed from: b, reason: collision with root package name */
    public static final d f45b = new Object();

    public static l a(Context context, List list) {
        String str;
        Typeface c2;
        Trace.beginSection(android.support.v4.media.session.a.J("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                g gVar = (g) list.get(i2);
                if (Build.VERSION.SDK_INT >= 31 && (c2 = x.d.c((str = gVar.f50e))) != null && x.d.d(c2) != null) {
                    arrayList.add(new m[]{new m(str, gVar.f51f)});
                } else {
                    ProviderInfo b2 = b(context.getPackageManager(), gVar, context.getResources());
                    if (b2 == null) {
                        return new l();
                    }
                    arrayList.add(c(context, gVar, b2.authority));
                }
            }
            return new l(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [B.e, java.lang.Object] */
    public static ProviderInfo b(PackageManager packageManager, g gVar, Resources resources) {
        d dVar = f45b;
        r.i iVar = f44a;
        Trace.beginSection(android.support.v4.media.session.a.J("FontProvider.getProvider"));
        try {
            List list = gVar.f49d;
            String str = gVar.f46a;
            String str2 = gVar.f47b;
            if (list == null) {
                list = AbstractC0051a.K(resources, 0);
            }
            ?? obj = new Object();
            obj.f41a = str;
            obj.f42b = str2;
            obj.f43c = list;
            ProviderInfo providerInfo = (ProviderInfo) iVar.get(obj);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(str2)) {
                    Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
                    ArrayList arrayList = new ArrayList();
                    for (Signature signature : signatureArr) {
                        arrayList.add(signature.toByteArray());
                    }
                    Collections.sort(arrayList, dVar);
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        ArrayList arrayList2 = new ArrayList((Collection) list.get(i2));
                        Collections.sort(arrayList2, dVar);
                        if (arrayList.size() == arrayList2.size()) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                if (!Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                                    break;
                                }
                            }
                            iVar.put(obj, resolveContentProvider);
                            return resolveContentProvider;
                        }
                    }
                    Trace.endSection();
                    return null;
                }
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
        } finally {
            Trace.endSection();
        }
    }

    public static m[] c(Context context, g gVar, String str) {
        int i2;
        int i3;
        Uri withAppendedId;
        int i4;
        boolean z;
        Trace.beginSection(android.support.v4.media.session.a.J("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
            Cursor cursor = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(android.support.v4.media.session.a.J("ContentQueryWrapper.query"));
                try {
                    String[] strArr2 = {gVar.f48c};
                    if (acquireUnstableContentProviderClient != null) {
                        try {
                            cursor = acquireUnstableContentProviderClient.query(build, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e2) {
                            Log.w("FontsProvider", "Unable to query the content provider", e2);
                        }
                    }
                    Trace.endSection();
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i2 = cursor.getInt(columnIndex);
                            } else {
                                i2 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i3 = cursor.getInt(columnIndex4);
                            } else {
                                i3 = 0;
                            }
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            Uri uri = withAppendedId;
                            if (columnIndex5 != -1) {
                                i4 = cursor.getInt(columnIndex5);
                            } else {
                                i4 = 400;
                            }
                            int i5 = i4;
                            if (columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList2.add(new m(uri, i3, i5, z, gVar.f51f, i2));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (acquireUnstableContentProviderClient != null) {
                        acquireUnstableContentProviderClient.close();
                    }
                    return (m[]) arrayList.toArray(new m[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (acquireUnstableContentProviderClient != null) {
                    acquireUnstableContentProviderClient.close();
                }
                throw th;
            }
        } finally {
        }
    }
}
