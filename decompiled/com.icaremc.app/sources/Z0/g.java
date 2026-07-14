package Z0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.icaremc.app.R;
import e0.InterfaceC0273a;
import j.InterfaceC0407b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import s2.C0641m;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class g implements K0.b, R0.a, InterfaceC0273a, InterfaceC0407b, InterfaceC0642n {

    /* renamed from: f, reason: collision with root package name */
    public static g f2139f;

    /* renamed from: g, reason: collision with root package name */
    public static g f2140g;

    public /* synthetic */ g(Object obj) {
    }

    public static String d(Context context, Uri uri) {
        String fileExtensionFromUrl;
        try {
            if (uri.getScheme().equals("content")) {
                fileExtensionFromUrl = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            } else {
                fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            }
            if (fileExtensionFromUrl != null && !fileExtensionFromUrl.isEmpty()) {
                return "." + i(fileExtensionFromUrl);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0061, code lost:
    
        r14.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[Catch: all -> 0x0081, TryCatch #1 {all -> 0x0081, blocks: (B:5:0x000d, B:54:0x004f, B:11:0x0065, B:13:0x006b, B:16:0x0084, B:17:0x00a7, B:26:0x00d3, B:40:0x00e5, B:39:0x00e2, B:42:0x008b, B:45:0x009d, B:46:0x0099, B:9:0x0061, B:65:0x005e, B:64:0x005b, B:34:0x00dc, B:48:0x0039, B:50:0x003f, B:53:0x0047, B:59:0x0055, B:20:0x00bf, B:21:0x00c1, B:23:0x00c8, B:25:0x00cc), top: B:4:0x000d, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8 A[Catch: all -> 0x00da, LOOP:0: B:21:0x00c1->B:23:0x00c8, LOOP_END, TryCatch #4 {all -> 0x00da, blocks: (B:20:0x00bf, B:21:0x00c1, B:23:0x00c8, B:25:0x00cc), top: B:19:0x00bf, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e(android.content.Context r13, android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z0.g.e(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static File h(String str, String str2) {
        File file = new File(str);
        if (file.getCanonicalPath().startsWith(str2)) {
            return file;
        }
        throw new IllegalArgumentException("Trying to open path outside of the expected directory. File: " + file.getCanonicalPath() + " was expected to be within directory: " + str2 + ".");
    }

    public static String i(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = {"..", "/"};
        String str2 = str.split("/")[r4.length - 1];
        for (int i4 = 0; i4 < 2; i4++) {
            str2 = str2.replace(strArr[i4], "_");
        }
        return str2;
    }

    @Override // R0.a
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // e0.InterfaceC0273a
    public CharSequence b(Preference preference) {
        ListPreference listPreference = (ListPreference) preference;
        if (!TextUtils.isEmpty(null)) {
            return null;
        }
        return listPreference.f3058f.getString(R.string.not_set);
    }

    public String c(List list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    public Signature[] f(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public boolean g(CharSequence charSequence) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [R0.a, java.lang.Object] */
    @Override // G2.a
    public Object get() {
        ?? obj = new Object();
        HashMap hashMap = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            hashMap.put(F0.d.f526f, new O0.c(30000L, 86400000L, set));
            if (set != null) {
                hashMap.put(F0.d.f528h, new O0.c(1000L, 86400000L, set));
                if (set != null) {
                    Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(O0.e.f1273g)));
                    if (unmodifiableSet != null) {
                        hashMap.put(F0.d.f527g, new O0.c(86400000L, 86400000L, unmodifiableSet));
                        if (hashMap.keySet().size() >= F0.d.values().length) {
                            new HashMap();
                            return new O0.b(obj, hashMap);
                        }
                        throw new IllegalStateException("Not all priorities have been configured");
                    }
                    throw new NullPointerException("Null flags");
                }
                throw new NullPointerException("Null flags");
            }
            throw new NullPointerException("Null flags");
        }
        throw new NullPointerException("Null flags");
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        ((r2.i) interfaceC0643o).success(null);
    }
}
