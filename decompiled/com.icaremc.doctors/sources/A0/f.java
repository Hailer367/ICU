package A0;

import B0.q;
import E.InterfaceC0023x;
import K.C0027b;
import K.InterfaceC0028c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Path;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.j;
import l.o;
import r.C0295g;

/* loaded from: classes.dex */
public final class f implements x0.b, InterfaceC0023x, InterfaceC0028c, Y.e, o {

    /* renamed from: d, reason: collision with root package name */
    public static f f26d;

    /* renamed from: e, reason: collision with root package name */
    public static f f27e;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f28c;

    public /* synthetic */ f(int i2) {
        this.f28c = i2;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static B.c d(Context context, String[] strArr, String str, q qVar) {
        String[] n2 = n(context);
        int length = n2.length;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = n2[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c2 = File.separatorChar;
                            sb.append(c2);
                            sb.append(str3);
                            sb.append(c2);
                            sb.append(str);
                            String sb2 = sb.toString();
                            qVar.c("Looking for %s in APK %s...", sb2, str2);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                B.c cVar = new B.c(6);
                                cVar.f39d = zipFile;
                                cVar.f40e = entry;
                                return cVar;
                            }
                        }
                        i5 = i6;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
        }
    }

    public static Path h(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        return path;
    }

    public static String[] i(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c2 = File.separatorChar;
        sb.append(c2);
        sb.append("([^\\");
        sb.append(c2);
        sb.append("]*)");
        sb.append(c2);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : n(context)) {
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

    public static String[] n(Context context) {
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

    @Override // l.o
    public boolean c(j jVar) {
        return false;
    }

    @Override // Y.e
    public void e() {
        switch (this.f28c) {
            case 7:
                return;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                return;
        }
    }

    @Override // Y.e
    public void g(int i2, Object obj) {
        String str;
        switch (this.f28c) {
            case 7:
                return;
            default:
                switch (i2) {
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
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = BuildConfig.FLAVOR;
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i2 != 6 && i2 != 7 && i2 != 8) {
                    Log.d("ProfileInstaller", str);
                    return;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    return;
                }
        }
    }

    @Override // P0.a
    public Object get() {
        f fVar = new f(3);
        HashMap hashMap = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            hashMap.put(s0.d.f3585c, new B0.c(30000L, 86400000L, set));
            if (set != null) {
                hashMap.put(s0.d.f3587e, new B0.c(1000L, 86400000L, set));
                if (set != null) {
                    Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(B0.f.f90d)));
                    if (unmodifiableSet != null) {
                        hashMap.put(s0.d.f3586d, new B0.c(86400000L, 86400000L, unmodifiableSet));
                        if (hashMap.keySet().size() >= s0.d.values().length) {
                            new HashMap();
                            return new B0.b(fVar, hashMap);
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

    public long j() {
        switch (this.f28c) {
            case 2:
                return SystemClock.elapsedRealtime();
            default:
                return System.currentTimeMillis();
        }
    }

    public CharSequence m(Preference preference) {
        switch (this.f28c) {
            case 5:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                if (!TextUtils.isEmpty(null)) {
                    return null;
                }
                return editTextPreference.f1876c.getString(R.string.not_set);
            default:
                ListPreference listPreference = (ListPreference) preference;
                if (!TextUtils.isEmpty(null)) {
                    return null;
                }
                return listPreference.f1876c.getString(R.string.not_set);
        }
    }

    public /* synthetic */ f(int i2, Object obj) {
        this.f28c = i2;
    }

    public f() {
        this.f28c = 16;
        new r.j(0);
        new C0295g();
    }

    private final void k() {
    }

    @Override // K.InterfaceC0028c
    public Object f(C0027b c0027b) {
        throw c0027b;
    }

    private final void l(int i2, Object obj) {
    }

    @Override // l.o
    public void a(j jVar, boolean z) {
    }

    @Override // E.InterfaceC0023x
    public void onScrollLimit(int i2, int i3, int i4, boolean z) {
    }

    @Override // E.InterfaceC0023x
    public void onScrollProgress(int i2, int i3, int i4, int i5) {
    }
}
