package W0;

import I0.q;
import O.C0073b;
import O.InterfaceC0074c;
import P1.y;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.google.firebase.components.ComponentRegistrar;
import com.icaremc.app.R;
import e0.InterfaceC0273a;
import f0.InterfaceC0284d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import n.InterfaceC0448A;
import x1.C0721a;

/* loaded from: classes.dex */
public final class g implements K0.b, InterfaceC0074c, InterfaceC0273a, InterfaceC0284d, InterfaceC0448A {

    /* renamed from: f, reason: collision with root package name */
    public static g f1866f;

    /* renamed from: g, reason: collision with root package name */
    public static g f1867g;

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:96:0x03d2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x070b A[Catch: all -> 0x0714, Exception -> 0x0719, TryCatch #27 {Exception -> 0x0719, all -> 0x0714, blocks: (B:279:0x0707, B:281:0x070b, B:283:0x072d, B:296:0x071c), top: B:278:0x0707 }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x071c A[Catch: all -> 0x0714, Exception -> 0x0719, TryCatch #27 {Exception -> 0x0719, all -> 0x0714, blocks: (B:279:0x0707, B:281:0x070b, B:283:0x072d, B:296:0x071c), top: B:278:0x0707 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(W.h r109, W.h r110) {
        /*
            Method dump skipped, instructions count: 1980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.g.e(W.h, W.h):void");
    }

    public static E0.a f(Context context, String[] strArr, String str, y yVar) {
        String[] j4 = j(context);
        int length = j4.length;
        int i4 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i4 >= length) {
                return null;
            }
            String str2 = j4[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i5 = i6;
                }
            }
            if (zipFile != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c4 = File.separatorChar;
                            sb.append(c4);
                            sb.append(str3);
                            sb.append(c4);
                            sb.append(str);
                            String sb2 = sb.toString();
                            yVar.p("Looking for %s in APK %s...", sb2, str2);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                E0.a aVar = new E0.a(0, false);
                                aVar.f459g = zipFile;
                                aVar.f460h = entry;
                                return aVar;
                            }
                        }
                        i7 = i8;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i4++;
        }
    }

    public static String[] g(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c4 = File.separatorChar;
        sb.append(c4);
        sb.append("([^\\");
        sb.append(c4);
        sb.append("]*)");
        sb.append(c4);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : j(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0075, code lost:
    
        if (r11 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r10 != (-1)) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h(V.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.g.h(V.b, android.text.Editable, int, int, boolean):boolean");
    }

    public static String[] j(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            return strArr2;
        }
        return new String[]{applicationInfo.sourceDir};
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f7, code lost:
    
        r6 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean l(android.content.pm.PackageInfo r13) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.g.l(android.content.pm.PackageInfo):boolean");
    }

    public static k n(PackageInfo packageInfo, k... kVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            l lVar = new l(packageInfo.signatures[0].toByteArray());
            for (int i4 = 0; i4 < kVarArr.length; i4++) {
                if (kVarArr[i4].equals(lVar)) {
                    return kVarArr[i4];
                }
            }
        }
        return null;
    }

    @Override // e0.InterfaceC0273a
    public CharSequence b(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (!TextUtils.isEmpty(null)) {
            return null;
        }
        return editTextPreference.f3058f.getString(R.string.not_set);
    }

    @Override // n.InterfaceC0448A
    public boolean c(n.n nVar) {
        return false;
    }

    @Override // G2.a
    public Object get() {
        return new q(Executors.newSingleThreadExecutor());
    }

    public List i(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (C0721a c0721a : componentRegistrar.getComponents()) {
            String str = c0721a.f6455a;
            if (str != null) {
                c0721a = new C0721a(str, c0721a.f6456b, c0721a.f6457c, c0721a.f6458d, c0721a.f6459e, new O0.j(6, str, c0721a), c0721a.f6461g);
            }
            arrayList.add(c0721a);
        }
        return arrayList;
    }

    @Override // f0.InterfaceC0284d
    public void k() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // f0.InterfaceC0284d
    public void m(int i4, Object obj) {
        String str;
        switch (i4) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "RESULT_IO_EXCEPTION";
                break;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i4 != 6 && i4 != 7 && i4 != 8) {
            Log.d("ProfileInstaller", str);
        } else {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
    }

    @Override // O.InterfaceC0074c
    public Object t(C0073b c0073b) {
        throw c0073b;
    }

    @Override // n.InterfaceC0448A
    public void a(n.n nVar, boolean z) {
    }
}
