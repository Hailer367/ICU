package f1;

import A2.A;
import A2.q;
import D2.C0030i;
import D2.C0034m;
import D2.J;
import D2.L;
import G.c;
import L.i;
import O0.j;
import P1.y;
import S2.l;
import T2.h;
import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.icu.text.DecimalFormatSymbols;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Xml;
import android.view.ActionMode;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import h.d;
import h.e;
import j.AbstractActivityC0416k;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.A1;
import o.C0516f0;
import o.U0;
import o.y1;
import org.xmlpull.v1.XmlSerializer;
import q1.AbstractC0602b;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;
import u1.f;
import v1.InterfaceC0691a;
import x1.C0721a;
import x1.g;
import x1.o;

/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0286a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f3702a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f3703b;

    /* renamed from: c, reason: collision with root package name */
    public static Context f3704c;

    public static void C(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream openFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                try {
                    try {
                        newSerializer.setOutput(openFileOutput, null);
                        newSerializer.startDocument("UTF-8", Boolean.TRUE);
                        newSerializer.startTag(null, "locales");
                        newSerializer.attribute(null, "application_locales", str);
                        newSerializer.endTag(null, "locales");
                        newSerializer.endDocument();
                        Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                    } catch (Throwable th) {
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: ".concat(str), e4);
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r3 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        if (r2.isEmpty() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        android.util.Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: ".concat(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        r9.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002d, code lost:
    
        if (r6 != 4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
    
        if (r4.getName().equals("locales") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:
    
        r2 = r4.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x004e, code lost:
    
        if (r3 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String D(android.content.Context r9) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L6b
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            int r5 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L17:
            int r6 = r4.next()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            r7 = 1
            if (r6 == r7) goto L43
            r7 = 3
            if (r6 != r7) goto L2a
            int r8 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r8 <= r5) goto L43
            goto L2a
        L28:
            r9 = move-exception
            goto L65
        L2a:
            if (r6 == r7) goto L17
            r7 = 4
            if (r6 != r7) goto L30
            goto L17
        L30:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r6 == 0) goto L17
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r2 = r4.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L43:
            if (r3 == 0) goto L51
        L45:
            r3.close()     // Catch: java.io.IOException -> L51
            goto L51
        L49:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L51
            goto L45
        L51:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L61
            java.lang.String r9 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            java.lang.String r9 = r9.concat(r2)
            android.util.Log.d(r1, r9)
            goto L64
        L61:
            r9.deleteFile(r0)
        L64:
            return r2
        L65:
            if (r3 == 0) goto L6a
            r3.close()     // Catch: java.io.IOException -> L6a
        L6a:
            throw r9
        L6b:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.AbstractC0286a.D(android.content.Context):java.lang.String");
    }

    public static void F(TextView textView, int i4) {
        int i5;
        if (i4 >= 0) {
            if (Build.VERSION.SDK_INT >= 28) {
                C.b.q(textView, i4);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i5 = fontMetricsInt.top;
            } else {
                i5 = fontMetricsInt.ascent;
            }
            if (i4 > Math.abs(i5)) {
                textView.setPadding(textView.getPaddingLeft(), i4 + i5, textView.getPaddingRight(), textView.getPaddingBottom());
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void G(TextView textView, int i4) {
        int i5;
        if (i4 >= 0) {
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i5 = fontMetricsInt.bottom;
            } else {
                i5 = fontMetricsInt.descent;
            }
            if (i4 > Math.abs(i5)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i4 - i5);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void H(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            y1.a(view, charSequence);
            return;
        }
        A1 a12 = A1.f5403p;
        if (a12 != null && a12.f5405f == view) {
            A1.b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            A1 a13 = A1.f5404q;
            if (a13 != null && a13.f5405f == view) {
                a13.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new A1(view, charSequence);
    }

    public static void I(InterfaceC0634f interfaceC0634f, final C0030i c0030i) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0030i != null && (l3 = c0030i.f401a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_defaultConstructor", a4, null);
        if (c0030i != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i4) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.settings", a4, null);
        if (c0030i != null) {
            final int i5 = 2;
            yVar2.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i5) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.loadData", a4, null);
        if (c0030i != null) {
            final int i6 = 6;
            yVar3.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i6) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.loadDataWithBaseUrl", a4, null);
        if (c0030i != null) {
            final int i7 = 7;
            yVar4.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i7) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.loadUrl", a4, null);
        if (c0030i != null) {
            final int i8 = 8;
            yVar5.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i8) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
        y yVar6 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.postUrl", a4, null);
        if (c0030i != null) {
            final int i9 = 9;
            yVar6.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i9) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar6.w(null);
        }
        y yVar7 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.getUrl", a4, null);
        if (c0030i != null) {
            final int i10 = 10;
            yVar7.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i10) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar7.w(null);
        }
        y yVar8 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.canGoBack", a4, null);
        if (c0030i != null) {
            final int i11 = 12;
            yVar8.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i11) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar8.w(null);
        }
        y yVar9 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.canGoForward", a4, null);
        if (c0030i != null) {
            final int i12 = 13;
            yVar9.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i12) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar9.w(null);
        }
        y yVar10 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.goBack", a4, null);
        if (c0030i != null) {
            final int i13 = 14;
            yVar10.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i13) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar10.w(null);
        }
        y yVar11 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.goForward", a4, null);
        if (c0030i != null) {
            final int i14 = 11;
            yVar11.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i14) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar11.w(null);
        }
        y yVar12 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.reload", a4, null);
        if (c0030i != null) {
            final int i15 = 15;
            yVar12.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i15) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar12.w(null);
        }
        y yVar13 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.clearCache", a4, null);
        if (c0030i != null) {
            final int i16 = 16;
            yVar13.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i16) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar13.w(null);
        }
        y yVar14 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.evaluateJavascript", a4, null);
        if (c0030i != null) {
            final int i17 = 17;
            yVar14.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i17) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar14.w(null);
        }
        y yVar15 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.getTitle", a4, null);
        if (c0030i != null) {
            final int i18 = 18;
            yVar15.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i18) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar15.w(null);
        }
        y yVar16 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebContentsDebuggingEnabled", a4, null);
        if (c0030i != null) {
            final int i19 = 19;
            yVar16.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i19) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar16.w(null);
        }
        y yVar17 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebViewClient", a4, null);
        if (c0030i != null) {
            final int i20 = 20;
            yVar17.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i20) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar17.w(null);
        }
        y yVar18 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.addJavaScriptChannel", a4, null);
        if (c0030i != null) {
            final int i21 = 21;
            yVar18.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i21) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar18.w(null);
        }
        y yVar19 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.removeJavaScriptChannel", a4, null);
        if (c0030i != null) {
            final int i22 = 22;
            yVar19.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i22) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar19.w(null);
        }
        y yVar20 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.setDownloadListener", a4, null);
        if (c0030i != null) {
            final int i23 = 1;
            yVar20.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i23) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar20.w(null);
        }
        y yVar21 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebChromeClient", a4, null);
        if (c0030i != null) {
            final int i24 = 3;
            yVar21.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i24) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar21.w(null);
        }
        y yVar22 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.setBackgroundColor", a4, null);
        if (c0030i != null) {
            final int i25 = 4;
            yVar22.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i25) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar22.w(null);
        }
        y yVar23 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebView.destroy", a4, null);
        if (c0030i != null) {
            final int i26 = 5;
            yVar23.w(new InterfaceC0630b() { // from class: D2.I
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    List C18;
                    List C19;
                    List C20;
                    List C21;
                    List C22;
                    List C23;
                    List C24;
                    switch (i26) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), c0030i2.a());
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0030i c0030i3 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c0030i3.getClass();
                                webView.setDownloadListener(downloadListener);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0030i c0030i4 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i4.f401a.f297g).a(((Long) obj5).longValue(), webView2.getSettings());
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0030i c0030i5 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView3 = (WebView) obj6;
                            W w2 = (W) list3.get(1);
                            try {
                                c0030i5.getClass();
                                webView3.setWebChromeClient(w2);
                                C6 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            C0030i c0030i6 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj8).longValue();
                            try {
                                c0030i6.getClass();
                                webView4.setBackgroundColor((int) longValue);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView5 = (WebView) obj9;
                            try {
                                c0030i7.getClass();
                                webView5.destroy();
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            C0030i c0030i8 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c0030i8.getClass();
                                webView6.loadData(str, str2, str3);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0030i c0030i9 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c0030i9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
                                C10 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th8) {
                                if (th8 instanceof C0022a) {
                                    C0022a c0022a8 = th8;
                                    C10 = I2.f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                                } else {
                                    C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            C0030i c0030i10 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map<String, String> map = (Map) obj16;
                            try {
                                c0030i10.getClass();
                                webView8.loadUrl(str9, map);
                                C11 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th9) {
                                if (th9 instanceof C0022a) {
                                    C0022a c0022a9 = th9;
                                    C11 = I2.f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                                } else {
                                    C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            C0030i c0030i11 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            T2.h.c(obj17, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.ByteArray");
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c0030i11.getClass();
                                webView9.postUrl(str10, bArr);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                if (th10 instanceof C0022a) {
                                    C0022a c0022a10 = th10;
                                    C12 = I2.f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                                } else {
                                    C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            C0030i c0030i12 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj20 = ((List) obj).get(0);
                            T2.h.c(obj20, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView10 = (WebView) obj20;
                            try {
                                c0030i12.getClass();
                                C13 = android.support.v4.media.session.a.p(webView10.getUrl());
                            } catch (Throwable th11) {
                                if (th11 instanceof C0022a) {
                                    C0022a c0022a11 = th11;
                                    C13 = I2.f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                                } else {
                                    C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            C0030i c0030i13 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj21 = ((List) obj).get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView11 = (WebView) obj21;
                            try {
                                c0030i13.getClass();
                                webView11.goForward();
                                C14 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th12) {
                                if (th12 instanceof C0022a) {
                                    C0022a c0022a12 = th12;
                                    C14 = I2.f.C(c0022a12.f349f, c0022a12.f350g, c0022a12.f351h);
                                } else {
                                    C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            C0030i c0030i14 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj22 = ((List) obj).get(0);
                            T2.h.c(obj22, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView12 = (WebView) obj22;
                            try {
                                c0030i14.getClass();
                                C15 = android.support.v4.media.session.a.p(Boolean.valueOf(webView12.canGoBack()));
                            } catch (Throwable th13) {
                                if (th13 instanceof C0022a) {
                                    C0022a c0022a13 = th13;
                                    C15 = I2.f.C(c0022a13.f349f, c0022a13.f350g, c0022a13.f351h);
                                } else {
                                    C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            C0030i c0030i15 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj23 = ((List) obj).get(0);
                            T2.h.c(obj23, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView13 = (WebView) obj23;
                            try {
                                c0030i15.getClass();
                                C16 = android.support.v4.media.session.a.p(Boolean.valueOf(webView13.canGoForward()));
                            } catch (Throwable th14) {
                                if (th14 instanceof C0022a) {
                                    C0022a c0022a14 = th14;
                                    C16 = I2.f.C(c0022a14.f349f, c0022a14.f350g, c0022a14.f351h);
                                } else {
                                    C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            sVar.t(C16);
                            return;
                        case 14:
                            C0030i c0030i16 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj24 = ((List) obj).get(0);
                            T2.h.c(obj24, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView14 = (WebView) obj24;
                            try {
                                c0030i16.getClass();
                                webView14.goBack();
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                if (th15 instanceof C0022a) {
                                    C0022a c0022a15 = th15;
                                    C17 = I2.f.C(c0022a15.f349f, c0022a15.f350g, c0022a15.f351h);
                                } else {
                                    C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            sVar.t(C17);
                            return;
                        case 15:
                            C0030i c0030i17 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj25 = ((List) obj).get(0);
                            T2.h.c(obj25, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView15 = (WebView) obj25;
                            try {
                                c0030i17.getClass();
                                webView15.reload();
                                C18 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th16) {
                                if (th16 instanceof C0022a) {
                                    C0022a c0022a16 = th16;
                                    C18 = I2.f.C(c0022a16.f349f, c0022a16.f350g, c0022a16.f351h);
                                } else {
                                    C18 = I2.f.C(th16.getClass().getSimpleName(), th16.toString(), A2.i.i("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            sVar.t(C18);
                            return;
                        case 16:
                            C0030i c0030i18 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c0030i18.getClass();
                                webView16.clearCache(booleanValue);
                                C19 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th17) {
                                if (th17 instanceof C0022a) {
                                    C0022a c0022a17 = th17;
                                    C19 = I2.f.C(c0022a17.f349f, c0022a17.f350g, c0022a17.f351h);
                                } else {
                                    C19 = I2.f.C(th17.getClass().getSimpleName(), th17.toString(), A2.i.i("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            sVar.t(C19);
                            return;
                        case 17:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            T2.h.c(obj28, "null cannot be cast to non-null type android.webkit.WebView");
                            Object obj29 = list10.get(1);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            A2.h hVar = new A2.h(sVar, 4);
                            c0030i.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new C0033l(hVar, 1));
                            return;
                        case 18:
                            C0030i c0030i19 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj30 = ((List) obj).get(0);
                            T2.h.c(obj30, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView17 = (WebView) obj30;
                            try {
                                c0030i19.getClass();
                                C20 = android.support.v4.media.session.a.p(webView17.getTitle());
                            } catch (Throwable th18) {
                                if (th18 instanceof C0022a) {
                                    C0022a c0022a18 = th18;
                                    C20 = I2.f.C(c0022a18.f349f, c0022a18.f350g, c0022a18.f351h);
                                } else {
                                    C20 = I2.f.C(th18.getClass().getSimpleName(), th18.toString(), A2.i.i("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            sVar.t(C20);
                            return;
                        case 19:
                            C0030i c0030i20 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj31 = ((List) obj).get(0);
                            T2.h.c(obj31, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c0030i20.getClass();
                                WebView.setWebContentsDebuggingEnabled(booleanValue2);
                                C21 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th19) {
                                if (th19 instanceof C0022a) {
                                    C0022a c0022a19 = th19;
                                    C21 = I2.f.C(c0022a19.f349f, c0022a19.f350g, c0022a19.f351h);
                                } else {
                                    C21 = I2.f.C(th19.getClass().getSimpleName(), th19.toString(), A2.i.i("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            sVar.t(C21);
                            return;
                        case 20:
                            C0030i c0030i21 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c0030i21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                C22 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th20) {
                                if (th20 instanceof C0022a) {
                                    C0022a c0022a20 = th20;
                                    C22 = I2.f.C(c0022a20.f349f, c0022a20.f350g, c0022a20.f351h);
                                } else {
                                    C22 = I2.f.C(th20.getClass().getSimpleName(), th20.toString(), A2.i.i("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            sVar.t(C22);
                            return;
                        case 21:
                            C0030i c0030i22 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            T2.h.c(obj33, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
                            C0042v c0042v = (C0042v) obj34;
                            try {
                                c0030i22.getClass();
                                webView19.addJavascriptInterface(c0042v, c0042v.f437a);
                                C23 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th21) {
                                if (th21 instanceof C0022a) {
                                    C0022a c0022a21 = th21;
                                    C23 = I2.f.C(c0022a21.f349f, c0022a21.f350g, c0022a21.f351h);
                                } else {
                                    C23 = I2.f.C(th21.getClass().getSimpleName(), th21.toString(), A2.i.i("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            sVar.t(C23);
                            return;
                        default:
                            C0030i c0030i23 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            T2.h.c(obj35, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj36;
                            try {
                                c0030i23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                C24 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th22) {
                                if (th22 instanceof C0022a) {
                                    C0022a c0022a22 = th22;
                                    C24 = I2.f.C(c0022a22.f349f, c0022a22.f350g, c0022a22.f351h);
                                } else {
                                    C24 = I2.f.C(th22.getClass().getSimpleName(), th22.toString(), A2.i.i("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            sVar.t(C24);
                            return;
                    }
                }
            });
        } else {
            yVar23.w(null);
        }
    }

    public static void J(InterfaceC0634f interfaceC0634f, final C0034m c0034m) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0034m != null && (l3 = c0034m.f416a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getIssuedBy", a4, null);
        if (c0034m != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.C
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    Long l4;
                    List C6;
                    Long l5;
                    List C7;
                    X509Certificate x509Certificate;
                    switch (i4) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c0034m2.getClass();
                                C3 = android.support.v4.media.session.a.p(sslCertificate.getIssuedBy());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c0034m3.getClass();
                                C4 = android.support.v4.media.session.a.p(sslCertificate2.getIssuedTo());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c0034m4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                if (validNotAfterDate != null) {
                                    l4 = Long.valueOf(validNotAfterDate.getTime());
                                } else {
                                    l4 = null;
                                }
                                C5 = android.support.v4.media.session.a.p(l4);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c0034m5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                if (validNotBeforeDate != null) {
                                    l5 = Long.valueOf(validNotBeforeDate.getTime());
                                } else {
                                    l5 = null;
                                }
                                C6 = android.support.v4.media.session.a.p(l5);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c0034m6.f416a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    z = true;
                                }
                                if (z) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                C7 = android.support.v4.media.session.a.p(x509Certificate);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getIssuedTo", a4, null);
        if (c0034m != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.C
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    Long l4;
                    List C6;
                    Long l5;
                    List C7;
                    X509Certificate x509Certificate;
                    switch (i5) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c0034m2.getClass();
                                C3 = android.support.v4.media.session.a.p(sslCertificate.getIssuedBy());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c0034m3.getClass();
                                C4 = android.support.v4.media.session.a.p(sslCertificate2.getIssuedTo());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c0034m4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                if (validNotAfterDate != null) {
                                    l4 = Long.valueOf(validNotAfterDate.getTime());
                                } else {
                                    l4 = null;
                                }
                                C5 = android.support.v4.media.session.a.p(l4);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c0034m5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                if (validNotBeforeDate != null) {
                                    l5 = Long.valueOf(validNotBeforeDate.getTime());
                                } else {
                                    l5 = null;
                                }
                                C6 = android.support.v4.media.session.a.p(l5);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c0034m6.f416a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    z = true;
                                }
                                if (z) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                C7 = android.support.v4.media.session.a.p(x509Certificate);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getValidNotAfterMsSinceEpoch", a4, null);
        if (c0034m != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.C
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    Long l4;
                    List C6;
                    Long l5;
                    List C7;
                    X509Certificate x509Certificate;
                    switch (i6) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c0034m2.getClass();
                                C3 = android.support.v4.media.session.a.p(sslCertificate.getIssuedBy());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c0034m3.getClass();
                                C4 = android.support.v4.media.session.a.p(sslCertificate2.getIssuedTo());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c0034m4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                if (validNotAfterDate != null) {
                                    l4 = Long.valueOf(validNotAfterDate.getTime());
                                } else {
                                    l4 = null;
                                }
                                C5 = android.support.v4.media.session.a.p(l4);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c0034m5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                if (validNotBeforeDate != null) {
                                    l5 = Long.valueOf(validNotBeforeDate.getTime());
                                } else {
                                    l5 = null;
                                }
                                C6 = android.support.v4.media.session.a.p(l5);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c0034m6.f416a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    z = true;
                                }
                                if (z) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                C7 = android.support.v4.media.session.a.p(x509Certificate);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getValidNotBeforeMsSinceEpoch", a4, null);
        if (c0034m != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b() { // from class: D2.C
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    Long l4;
                    List C6;
                    Long l5;
                    List C7;
                    X509Certificate x509Certificate;
                    switch (i7) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c0034m2.getClass();
                                C3 = android.support.v4.media.session.a.p(sslCertificate.getIssuedBy());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c0034m3.getClass();
                                C4 = android.support.v4.media.session.a.p(sslCertificate2.getIssuedTo());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c0034m4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                if (validNotAfterDate != null) {
                                    l4 = Long.valueOf(validNotAfterDate.getTime());
                                } else {
                                    l4 = null;
                                }
                                C5 = android.support.v4.media.session.a.p(l4);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c0034m5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                if (validNotBeforeDate != null) {
                                    l5 = Long.valueOf(validNotBeforeDate.getTime());
                                } else {
                                    l5 = null;
                                }
                                C6 = android.support.v4.media.session.a.p(l5);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c0034m6.f416a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    z = true;
                                }
                                if (z) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                C7 = android.support.v4.media.session.a.p(x509Certificate);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getX509Certificate", a4, null);
        if (c0034m != null) {
            final int i8 = 4;
            yVar5.w(new InterfaceC0630b() { // from class: D2.C
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    Long l4;
                    List C6;
                    Long l5;
                    List C7;
                    X509Certificate x509Certificate;
                    switch (i8) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c0034m2.getClass();
                                C3 = android.support.v4.media.session.a.p(sslCertificate.getIssuedBy());
                            } catch (Throwable th) {
                                if (th instanceof C0022a) {
                                    C0022a c0022a = th;
                                    C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c0034m3.getClass();
                                C4 = android.support.v4.media.session.a.p(sslCertificate2.getIssuedTo());
                            } catch (Throwable th2) {
                                if (th2 instanceof C0022a) {
                                    C0022a c0022a2 = th2;
                                    C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj4 = ((List) obj).get(0);
                            T2.h.c(obj4, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c0034m4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                if (validNotAfterDate != null) {
                                    l4 = Long.valueOf(validNotAfterDate.getTime());
                                } else {
                                    l4 = null;
                                }
                                C5 = android.support.v4.media.session.a.p(l4);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c0034m5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                if (validNotBeforeDate != null) {
                                    l5 = Long.valueOf(validNotBeforeDate.getTime());
                                } else {
                                    l5 = null;
                                }
                                C6 = android.support.v4.media.session.a.p(l5);
                            } catch (Throwable th4) {
                                if (th4 instanceof C0022a) {
                                    C0022a c0022a4 = th4;
                                    C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            C0034m c0034m6 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.net.http.SslCertificate");
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c0034m6.f416a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    z = true;
                                }
                                if (z) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                C7 = android.support.v4.media.session.a.p(x509Certificate);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
    }

    public static boolean K(Intent intent) {
        Bundle extras;
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return false;
        }
        return "1".equals(extras.getString("google.c.a.e"));
    }

    public static int L(Context context, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i4});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static ActionMode.Callback M(ActionMode.Callback callback) {
        if ((callback instanceof i) && Build.VERSION.SDK_INT >= 26) {
            return ((i) callback).f971a;
        }
        return callback;
    }

    public static ActionMode.Callback N(ActionMode.Callback callback, TextView textView) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26 && i4 <= 27 && !(callback instanceof i) && callback != null) {
            return new i(callback, textView);
        }
        return callback;
    }

    public static ArrayList P(DisplayManager displayManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new ArrayList();
        }
        try {
            Field declaredField = DisplayManager.class.getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(displayManager);
            Field declaredField2 = obj.getClass().getDeclaredField("mDisplayListeners");
            declaredField2.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField2.get(obj);
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            Field field = null;
            int i4 = 0;
            while (i4 < size) {
                Object obj2 = arrayList.get(i4);
                i4++;
                if (field == null) {
                    field = obj2.getClass().getField("mListener");
                    field.setAccessible(true);
                }
                arrayList2.add((DisplayManager.DisplayListener) field.get(obj2));
            }
            return arrayList2;
        } catch (IllegalAccessException | NoSuchFieldException e4) {
            Log.w("DisplayListenerProxy", "Could not extract WebView's display listeners. " + e4);
            return new ArrayList();
        }
    }

    public static void a(Throwable th, Throwable th2) {
        h.e(th, "<this>");
        h.e(th2, "exception");
        if (th != th2) {
            Integer num = O2.a.f1314a;
            if (num != null && num.intValue() < 19) {
                Method method = N2.a.f1073a;
                if (method != null) {
                    method.invoke(th, th2);
                    return;
                }
                return;
            }
            th.addSuppressed(th2);
        }
    }

    public static C0721a c(String str, String str2) {
        R1.a aVar = new R1.a(str, str2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(o.a(R1.a.class));
        return new C0721a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new J(21, aVar), hashSet3);
    }

    public static String d(Object obj, String str) {
        h.e(obj, "value");
        return str + " value: " + obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0143, code lost:
    
        if (e(r1.getValue(), r4.getValue()) == false) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.AbstractC0286a.e(java.lang.Object, java.lang.Object):boolean");
    }

    public static boolean f(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (objArr.length == objArr2.length) {
                Iterable aVar = new X2.a(0, objArr.length - 1, 1);
                if (!(aVar instanceof Collection) || !((Collection) aVar).isEmpty()) {
                    Iterator it = aVar.iterator();
                    while (((X2.b) it).f2008h) {
                        int nextInt = ((X2.b) it).nextInt();
                        if (!f(objArr[nextInt], objArr2[nextInt])) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() == list2.size()) {
                Collection collection = (Collection) obj;
                h.e(collection, "<this>");
                Iterable aVar2 = new X2.a(0, collection.size() - 1, 1);
                if (!(aVar2 instanceof Collection) || !((Collection) aVar2).isEmpty()) {
                    Iterator it2 = aVar2.iterator();
                    while (((X2.b) it2).f2008h) {
                        int nextInt2 = ((X2.b) it2).nextInt();
                        if (!f(list.get(nextInt2), list2.get(nextInt2))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof Map) && (obj2 instanceof Map)) {
            Map map = (Map) obj;
            Map map2 = (Map) obj2;
            if (map.size() == map2.size()) {
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (map2.containsKey(entry.getKey()) && f(entry.getValue(), map2.get(entry.getKey()))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return h.a(obj, obj2);
    }

    public static int g(Object obj) {
        int i4 = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.hashCode((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.hashCode((long[]) obj);
        }
        double d4 = 0.0d;
        int i5 = 1;
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length;
            while (i4 < length) {
                double d5 = dArr[i4];
                int i6 = i5 * 31;
                if (d5 == 0.0d) {
                    d5 = 0.0d;
                }
                long doubleToLongBits = Double.doubleToLongBits(d5);
                i5 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                i4++;
            }
            return i5;
        }
        float f4 = 0.0f;
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length;
            while (i4 < length2) {
                float f5 = fArr[i4];
                int i7 = i5 * 31;
                if (f5 == 0.0f) {
                    f5 = 0.0f;
                }
                i5 = i7 + Float.floatToIntBits(f5);
                i4++;
            }
            return i5;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length3 = objArr.length;
            while (i4 < length3) {
                i5 = (i5 * 31) + g(objArr[i4]);
                i4++;
            }
            return i5;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i5 = (i5 * 31) + g(it.next());
            }
            return i5;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                i4 += g(entry.getValue()) ^ (g(entry.getKey()) * 31);
            }
            return i4;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue != 0.0d) {
                d4 = doubleValue;
            }
            long doubleToLongBits2 = Double.doubleToLongBits(d4);
            return (int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32));
        }
        if (obj instanceof Float) {
            float floatValue = ((Number) obj).floatValue();
            if (floatValue != 0.0f) {
                f4 = floatValue;
            }
            return Float.floatToIntBits(f4);
        }
        return obj.hashCode();
    }

    public static boolean h() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            f.d();
            f d4 = f.d();
            d4.a();
            Context context = d4.f6221a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    public static boolean i(double d4, double d5) {
        double d6;
        double d7 = 0.0d;
        if (d4 == 0.0d) {
            d6 = 0.0d;
        } else {
            d6 = d4;
        }
        if (d5 != 0.0d) {
            d7 = d5;
        }
        if (d6 != d7) {
            if (Double.isNaN(d4) && Double.isNaN(d5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean j(float f4, float f5) {
        float f6;
        float f7 = 0.0f;
        if (f4 == 0.0f) {
            f6 = 0.0f;
        } else {
            f6 = f4;
        }
        if (f5 != 0.0f) {
            f7 = f5;
        }
        if (f6 != f7) {
            if (Float.isNaN(f4) && Float.isNaN(f5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static C0721a k(String str, V1.f fVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(o.a(R1.a.class));
        for (Class cls : new Class[0]) {
            AbstractC0602b.h(cls, "Null interface");
            hashSet.add(o.a(cls));
        }
        g a4 = g.a(Context.class);
        if (!hashSet.contains(a4.f6475a)) {
            hashSet2.add(a4);
            return new C0721a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new j(5, str, fVar), hashSet3);
        }
        throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0047, code lost:
    
        if (r5.f27c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList n(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            A.i r1 = new A.i
            r1.<init>(r0, r8)
            java.lang.Object r2 = A.m.f37c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = A.m.f36b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            A.h r5 = (A.h) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            android.content.res.Configuration r6 = r5.f26b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r8 != 0) goto L3f
            int r6 = r5.f27c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Lb8
        L3f:
            if (r8 == 0) goto L4d
            int r6 = r5.f27c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            android.content.res.ColorStateList r3 = r5.f25a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            return r3
        L55:
            java.lang.ThreadLocal r2 = A.m.f35a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L67
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L87
        L76:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = A.c.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7f
            goto L87
        L7f:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L87:
            if (r4 == 0) goto Lb3
            java.lang.Object r2 = A.m.f37c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = A.m.f36b     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L9f
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L9f
            if (r3 != 0) goto La1
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r8 = move-exception
            goto Lb1
        La1:
            A.h r0 = new A.h     // Catch: java.lang.Throwable -> L9f
            android.content.res.Resources r1 = r1.f28a     // Catch: java.lang.Throwable -> L9f
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L9f
            r0.<init>(r4, r1, r8)     // Catch: java.lang.Throwable -> L9f
            r3.append(r9, r0)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            goto Lb7
        Lb1:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r8
        Lb3:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        Lb7:
            return r4
        Lb8:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.AbstractC0286a.n(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static Drawable o(Context context, int i4) {
        return U0.b().c(context, i4);
    }

    public static Intent p(AbstractActivityC0416k abstractActivityC0416k) {
        Intent parentActivityIntent = abstractActivityC0416k.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String r3 = r(abstractActivityC0416k, abstractActivityC0416k.getComponentName());
            if (r3 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(abstractActivityC0416k, r3);
            try {
                if (r(abstractActivityC0416k, componentName) == null) {
                    return Intent.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + r3 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static Intent q(AbstractActivityC0416k abstractActivityC0416k, ComponentName componentName) {
        String r3 = r(abstractActivityC0416k, componentName);
        if (r3 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), r3);
        if (r(abstractActivityC0416k, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String r(Context context, ComponentName componentName) {
        int i4;
        String string;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 29) {
            i4 = 269222528;
        } else {
            i4 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i4);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    public static ResolveInfo t(Context context) {
        h.e(context, "context");
        return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
    }

    public static c u(C0516f0 c0516f0) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            return new c(C.b.n(c0516f0));
        }
        TextPaint textPaint = new TextPaint(c0516f0.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = c0516f0.getBreakStrategy();
        int hyphenationFrequency = c0516f0.getHyphenationFrequency();
        if (c0516f0.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            boolean z = true;
            if (i4 >= 28 && (c0516f0.getInputType() & 15) == 3) {
                byte directionality = Character.getDirectionality(C.b.d(DecimalFormatSymbols.getInstance(c0516f0.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                if (c0516f0.getLayoutDirection() != 1) {
                    z = false;
                }
                switch (c0516f0.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        break;
                    case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                        break;
                }
            }
        }
        return new c(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static String v(h.g gVar) {
        h.e(gVar, "input");
        if (gVar instanceof e) {
            return "image/*";
        }
        if (gVar instanceof h.f) {
            return "video/*";
        }
        if (gVar instanceof d) {
            return null;
        }
        throw new RuntimeException();
    }

    public static int w(int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                return 1;
            }
            if (i4 == 4) {
                return 2;
            }
            if (i4 != 8) {
                if (i4 == 16) {
                    return 4;
                }
                if (i4 != 32) {
                    if (i4 != 64) {
                        if (i4 != 128) {
                            if (i4 == 256) {
                                return 8;
                            }
                            if (i4 == 512) {
                                return 9;
                            }
                            throw new IllegalArgumentException(A2.i.g(i4, "type needs to be >= FIRST and <= LAST, type="));
                        }
                        return 7;
                    }
                    return 6;
                }
                return 5;
            }
            return 3;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void y(android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.AbstractC0286a.y(android.content.Intent):void");
    }

    public static void z(String str, Bundle bundle) {
        String str2;
        try {
            f.d();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("google.c.a.c_id");
            if (string != null) {
                bundle2.putString("_nmid", string);
            }
            String string2 = bundle.getString("google.c.a.c_l");
            if (string2 != null) {
                bundle2.putString("_nmn", string2);
            }
            String string3 = bundle.getString("google.c.a.m_l");
            if (!TextUtils.isEmpty(string3)) {
                bundle2.putString("label", string3);
            }
            String string4 = bundle.getString("google.c.a.m_c");
            if (!TextUtils.isEmpty(string4)) {
                bundle2.putString("message_channel", string4);
            }
            String string5 = bundle.getString("from");
            String str3 = null;
            if (string5 == null || !string5.startsWith("/topics/")) {
                string5 = null;
            }
            if (string5 != null) {
                bundle2.putString("_nt", string5);
            }
            String string6 = bundle.getString("google.c.a.ts");
            if (string6 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(string6));
                } catch (NumberFormatException e4) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e4);
                }
            }
            if (bundle.containsKey("google.c.a.udt")) {
                str3 = bundle.getString("google.c.a.udt");
            }
            if (str3 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(str3));
                } catch (NumberFormatException e5) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e5);
                }
            }
            if (q.I(bundle)) {
                str2 = "display";
            } else {
                str2 = "data";
            }
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", str2);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            f d4 = f.d();
            d4.a();
            if (d4.f6224d.a(InterfaceC0691a.class) == null) {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
                return;
            }
            throw new ClassCastException();
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    public abstract void A(Throwable th);

    public abstract void B(y yVar);

    public abstract AbstractC0286a E(String str, l lVar);

    public abstract void O(byte[] bArr, int i4, int i5);

    public abstract Object b();

    public abstract Method l(Class cls, Field field);

    public abstract Constructor m(Class cls);

    public abstract String[] s(Class cls);

    public abstract boolean x(Class cls);
}
