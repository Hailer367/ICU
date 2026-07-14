package a;

import A2.A;
import A2.i;
import D2.C0030i;
import D2.C0034m;
import D2.L;
import I.S;
import I.T;
import K2.g;
import K2.j;
import O.InterfaceC0080i;
import P1.y;
import S2.p;
import T2.e;
import T2.h;
import T2.s;
import W.b;
import W.c;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import b3.AbstractC0245u;
import b3.C0240o;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import g3.q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import l2.d;
import m2.C0447e;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;
import v.AbstractFutureC0676h;
import v.C0672d;
import v.C0675g;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0141a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f2210a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f2211b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2212c = false;

    /* renamed from: d, reason: collision with root package name */
    public static Field f2213d;

    public static boolean A(double d4, double d5) {
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
            if (!Double.isNaN(d4) || !Double.isNaN(d5)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void D(d dVar, MediaExtractor mediaExtractor) {
        try {
            int trackCount = mediaExtractor.getTrackCount();
            int i4 = 0;
            for (int i5 = 0; i5 < trackCount; i5++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i5);
                String string = trackFormat.getString("mime");
                if (string != null && string.startsWith("image/")) {
                    if (trackFormat.containsKey("rotation-degrees")) {
                        i4 = trackFormat.getInteger("rotation-degrees");
                    }
                    int i6 = dVar.f5130g;
                    int i7 = dVar.f5129f;
                    if (i4 != 90 && i4 != 270) {
                        i7 = i6;
                        i6 = i7;
                    }
                    dVar.f5125b = i6;
                    dVar.f5124a = i7;
                    dVar.f5126c = i4;
                    return;
                }
            }
        } catch (Exception e4) {
            Log.e("MediaMetadataReader", "Failed to decode HEIF image using MediaExtractor", e4);
        }
    }

    public static void E(InterfaceC0634f interfaceC0634f, final C0030i c0030i) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0030i != null && (l3 = c0030i.f401a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.pigeon_defaultConstructor", a4, null);
        if (c0030i != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.G
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    switch (i4) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), new W(c0030i2));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w2 = (W) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c0030i3.getClass();
                                w2.f331c = booleanValue;
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
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w3 = (W) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c0030i4.getClass();
                                w3.f332d = booleanValue2;
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
                            Object obj7 = list3.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w4 = (W) obj7;
                            Object obj8 = list3.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0030i5.getClass();
                                w4.f333e = booleanValue3;
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
                            Object obj9 = list4.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w5 = (W) obj9;
                            Object obj10 = list4.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0030i6.getClass();
                                w5.f334f = booleanValue4;
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
                        default:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w6 = (W) obj11;
                            Object obj12 = list5.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0030i7.getClass();
                                w6.f335g = booleanValue5;
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
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnShowFileChooser", a4, null);
        if (c0030i != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.G
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    switch (i5) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), new W(c0030i2));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w2 = (W) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c0030i3.getClass();
                                w2.f331c = booleanValue;
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
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w3 = (W) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c0030i4.getClass();
                                w3.f332d = booleanValue2;
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
                            Object obj7 = list3.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w4 = (W) obj7;
                            Object obj8 = list3.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0030i5.getClass();
                                w4.f333e = booleanValue3;
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
                            Object obj9 = list4.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w5 = (W) obj9;
                            Object obj10 = list4.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0030i6.getClass();
                                w5.f334f = booleanValue4;
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
                        default:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w6 = (W) obj11;
                            Object obj12 = list5.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0030i7.getClass();
                                w6.f335g = booleanValue5;
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
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnConsoleMessage", a4, null);
        if (c0030i != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.G
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    switch (i6) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), new W(c0030i2));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w2 = (W) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c0030i3.getClass();
                                w2.f331c = booleanValue;
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
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w3 = (W) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c0030i4.getClass();
                                w3.f332d = booleanValue2;
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
                            Object obj7 = list3.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w4 = (W) obj7;
                            Object obj8 = list3.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0030i5.getClass();
                                w4.f333e = booleanValue3;
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
                            Object obj9 = list4.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w5 = (W) obj9;
                            Object obj10 = list4.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0030i6.getClass();
                                w5.f334f = booleanValue4;
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
                        default:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w6 = (W) obj11;
                            Object obj12 = list5.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0030i7.getClass();
                                w6.f335g = booleanValue5;
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
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsAlert", a4, null);
        if (c0030i != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b() { // from class: D2.G
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    switch (i7) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), new W(c0030i2));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w2 = (W) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c0030i3.getClass();
                                w2.f331c = booleanValue;
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
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w3 = (W) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c0030i4.getClass();
                                w3.f332d = booleanValue2;
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
                            Object obj7 = list3.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w4 = (W) obj7;
                            Object obj8 = list3.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0030i5.getClass();
                                w4.f333e = booleanValue3;
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
                            Object obj9 = list4.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w5 = (W) obj9;
                            Object obj10 = list4.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0030i6.getClass();
                                w5.f334f = booleanValue4;
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
                        default:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w6 = (W) obj11;
                            Object obj12 = list5.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0030i7.getClass();
                                w6.f335g = booleanValue5;
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
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsConfirm", a4, null);
        if (c0030i != null) {
            final int i8 = 4;
            yVar5.w(new InterfaceC0630b() { // from class: D2.G
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    switch (i8) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), new W(c0030i2));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w2 = (W) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c0030i3.getClass();
                                w2.f331c = booleanValue;
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
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w3 = (W) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c0030i4.getClass();
                                w3.f332d = booleanValue2;
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
                            Object obj7 = list3.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w4 = (W) obj7;
                            Object obj8 = list3.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0030i5.getClass();
                                w4.f333e = booleanValue3;
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
                            Object obj9 = list4.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w5 = (W) obj9;
                            Object obj10 = list4.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0030i6.getClass();
                                w5.f334f = booleanValue4;
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
                        default:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w6 = (W) obj11;
                            Object obj12 = list5.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0030i7.getClass();
                                w6.f335g = booleanValue5;
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
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
        y yVar6 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsPrompt", a4, null);
        if (c0030i != null) {
            final int i9 = 5;
            yVar6.w(new InterfaceC0630b() { // from class: D2.G
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    switch (i9) {
                        case 0:
                            C0030i c0030i2 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0030i2.f401a.f297g).a(((Long) obj2).longValue(), new W(c0030i2));
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
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w2 = (W) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c0030i3.getClass();
                                w2.f331c = booleanValue;
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
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w3 = (W) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c0030i4.getClass();
                                w3.f332d = booleanValue2;
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
                            Object obj7 = list3.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w4 = (W) obj7;
                            Object obj8 = list3.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c0030i5.getClass();
                                w4.f333e = booleanValue3;
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
                            Object obj9 = list4.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w5 = (W) obj9;
                            Object obj10 = list4.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c0030i6.getClass();
                                w5.f334f = booleanValue4;
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
                        default:
                            C0030i c0030i7 = c0030i;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
                            W w6 = (W) obj11;
                            Object obj12 = list5.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c0030i7.getClass();
                                w6.f335g = booleanValue5;
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
                    }
                }
            });
        } else {
            yVar6.w(null);
        }
    }

    public static void F(InterfaceC0634f interfaceC0634f, final C0034m c0034m) {
        InterfaceC0640l a4;
        L l3;
        h.e(interfaceC0634f, "binaryMessenger");
        if (c0034m != null && (l3 = c0034m.f416a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.instance", a4, null);
        if (c0034m != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.A
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    Object asList;
                    List C5;
                    switch (i4) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj2).longValue();
                            try {
                                L l4 = c0034m2.f416a;
                                ((C0024c) l4.f297g).a(longValue, (C0039s) l4.f300j);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager");
                            C0039s c0039s = (C0039s) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            try {
                                c0034m3.getClass();
                                try {
                                    String[] list2 = c0039s.f433a.list(str);
                                    if (list2 == null) {
                                        asList = new ArrayList();
                                    } else {
                                        asList = Arrays.asList(list2);
                                    }
                                    C4 = android.support.v4.media.session.a.p(asList);
                                } catch (IOException e4) {
                                    throw new RuntimeException(e4.getMessage());
                                }
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
                        default:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj5 = list3.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager");
                            C0039s c0039s2 = (C0039s) obj5;
                            Object obj6 = list3.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj6;
                            try {
                                c0034m4.getClass();
                                C5 = android.support.v4.media.session.a.p(((C0447e) c0039s2.f434b.f1532g).b(str2));
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
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.list", a4, null);
        if (c0034m != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.A
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    Object asList;
                    List C5;
                    switch (i5) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj2).longValue();
                            try {
                                L l4 = c0034m2.f416a;
                                ((C0024c) l4.f297g).a(longValue, (C0039s) l4.f300j);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager");
                            C0039s c0039s = (C0039s) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            try {
                                c0034m3.getClass();
                                try {
                                    String[] list2 = c0039s.f433a.list(str);
                                    if (list2 == null) {
                                        asList = new ArrayList();
                                    } else {
                                        asList = Arrays.asList(list2);
                                    }
                                    C4 = android.support.v4.media.session.a.p(asList);
                                } catch (IOException e4) {
                                    throw new RuntimeException(e4.getMessage());
                                }
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
                        default:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj5 = list3.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager");
                            C0039s c0039s2 = (C0039s) obj5;
                            Object obj6 = list3.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj6;
                            try {
                                c0034m4.getClass();
                                C5 = android.support.v4.media.session.a.p(((C0447e) c0039s2.f434b.f1532g).b(str2));
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
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.getAssetFilePathByName", a4, null);
        if (c0034m != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.A
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    Object asList;
                    List C5;
                    switch (i6) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj2).longValue();
                            try {
                                L l4 = c0034m2.f416a;
                                ((C0024c) l4.f297g).a(longValue, (C0039s) l4.f300j);
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
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager");
                            C0039s c0039s = (C0039s) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            try {
                                c0034m3.getClass();
                                try {
                                    String[] list2 = c0039s.f433a.list(str);
                                    if (list2 == null) {
                                        asList = new ArrayList();
                                    } else {
                                        asList = Arrays.asList(list2);
                                    }
                                    C4 = android.support.v4.media.session.a.p(asList);
                                } catch (IOException e4) {
                                    throw new RuntimeException(e4.getMessage());
                                }
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
                        default:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj5 = list3.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager");
                            C0039s c0039s2 = (C0039s) obj5;
                            Object obj6 = list3.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj6;
                            try {
                                c0034m4.getClass();
                                C5 = android.support.v4.media.session.a.p(((C0447e) c0039s2.f434b.f1532g).b(str2));
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
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
    }

    public static final Object G(q qVar, q qVar2, p pVar) {
        Object c0240o;
        Object G3;
        try {
            s.a(2, pVar);
            c0240o = pVar.e(qVar2, qVar);
        } catch (Throwable th) {
            c0240o = new C0240o(th, false);
        }
        L2.a aVar = L2.a.f1019f;
        if (c0240o != aVar && (G3 = qVar.G(c0240o)) != AbstractC0245u.f3302d) {
            if (!(G3 instanceof C0240o)) {
                return AbstractC0245u.k(G3);
            }
            throw ((C0240o) G3).f3290a;
        }
        return aVar;
    }

    public static boolean H(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i4 = 0; i4 < bArr2.length; i4++) {
                if (bArr[i4] == bArr2[i4]) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean I(String str, S2.a aVar) {
        try {
            boolean booleanValue = ((Boolean) aVar.a()).booleanValue();
            if (!booleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public static ArrayList J(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }

    public static void K(Parcel parcel, int i4, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int Q2 = Q(parcel, i4);
        parcel.writeBundle(bundle);
        S(parcel, Q2);
    }

    public static void L(Parcel parcel, int i4, Parcelable parcelable, int i5) {
        if (parcelable == null) {
            return;
        }
        int Q2 = Q(parcel, i4);
        parcelable.writeToParcel(parcel, i5);
        S(parcel, Q2);
    }

    public static void M(Parcel parcel, int i4, String str) {
        if (str == null) {
            return;
        }
        int Q2 = Q(parcel, i4);
        parcel.writeString(str);
        S(parcel, Q2);
    }

    public static void N(Parcel parcel, int i4, Parcelable[] parcelableArr, int i5) {
        if (parcelableArr == null) {
            return;
        }
        int Q2 = Q(parcel, i4);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i5);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        S(parcel, Q2);
    }

    public static void O(Parcel parcel, int i4, List list) {
        if (list == null) {
            return;
        }
        int Q2 = Q(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            Parcelable parcelable = (Parcelable) list.get(i5);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        S(parcel, Q2);
    }

    public static void P(Parcel parcel, int i4, int i5) {
        parcel.writeInt(i4 | (i5 << 16));
    }

    public static int Q(Parcel parcel, int i4) {
        parcel.writeInt(i4 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void R(int i4, int i5) {
        String A3;
        if (i4 >= 0 && i4 < i5) {
            return;
        }
        if (i4 >= 0) {
            if (i5 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 15);
                sb.append("negative size: ");
                sb.append(i5);
                throw new IllegalArgumentException(sb.toString());
            }
            A3 = android.support.v4.media.session.a.A("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            A3 = android.support.v4.media.session.a.A("%s (%s) must not be negative", "index", Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(A3);
    }

    public static void S(Parcel parcel, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i4 - 4);
        parcel.writeInt(dataPosition - i4);
        parcel.setDataPosition(dataPosition);
    }

    public static void T(int i4, int i5, int i6) {
        String U3;
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                U3 = android.support.v4.media.session.a.A("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            } else {
                U3 = U(i5, "end index", i6);
            }
        } else {
            U3 = U(i4, "start index", i6);
        }
        throw new IndexOutOfBoundsException(U3);
    }

    public static String U(int i4, String str, int i5) {
        if (i4 < 0) {
            return android.support.v4.media.session.a.A("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return android.support.v4.media.session.a.A("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 15);
        sb.append("negative size: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:13:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0085 -> B:13:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.util.List r6, O.C0083l r7, M2.c r8) {
        /*
            boolean r0 = r8 instanceof O.C0077f
            if (r0 == 0) goto L13
            r0 = r8
            O.f r0 = (O.C0077f) r0
            int r1 = r0.f1184l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1184l = r1
            goto L18
        L13:
            O.f r0 = new O.f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.k
            int r1 = r0.f1184l
            r2 = 2
            r3 = 1
            L2.a r4 = L2.a.f1019f
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.util.Iterator r6 = r0.f1183j
            java.io.Serializable r7 = r0.f1182i
            T2.p r7 = (T2.p) r7
            k3.b.A(r8)     // Catch: java.lang.Throwable -> L30
            goto L65
        L30:
            r8 = move-exception
            goto L7e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.io.Serializable r6 = r0.f1182i
            java.util.List r6 = (java.util.List) r6
            k3.b.A(r8)
            goto L5c
        L42:
            k3.b.A(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            O.h r1 = new O.h
            r5 = 0
            r1.<init>(r6, r8, r5)
            r0.f1182i = r8
            r0.f1184l = r3
            java.lang.Object r6 = r7.a(r1, r0)
            if (r6 != r4) goto L5b
            goto L93
        L5b:
            r6 = r8
        L5c:
            T2.p r7 = new T2.p
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()
            S2.l r8 = (S2.l) r8
            r0.f1182i = r7     // Catch: java.lang.Throwable -> L30
            r0.f1183j = r6     // Catch: java.lang.Throwable -> L30
            r0.f1184l = r2     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.f(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r4) goto L65
            goto L93
        L7e:
            java.lang.Object r1 = r7.f1645f
            if (r1 != 0) goto L85
            r7.f1645f = r8
            goto L65
        L85:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            f1.AbstractC0286a.a(r1, r8)
            goto L65
        L8b:
            java.lang.Object r6 = r7.f1645f
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 != 0) goto L94
            H2.i r4 = H2.i.f681a
        L93:
            return r4
        L94:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0141a.a(java.util.List, O.l, M2.c):java.lang.Object");
    }

    public static final void e(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC0286a.a(th, th2);
            }
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] g(Serializable serializable) {
        if (serializable instanceof int[]) {
            int[] iArr = (int[]) serializable;
            long[] jArr = new long[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                jArr[i4] = iArr[i4];
            }
            return jArr;
        }
        if (serializable instanceof long[]) {
            return (long[]) serializable;
        }
        return null;
    }

    public static void h(b bVar, c cVar, int i4) {
        byte[] bArr = new byte[8192];
        while (i4 > 0) {
            int min = Math.min(i4, 8192);
            int read = bVar.read(bArr, 0, min);
            if (read == min) {
                i4 -= read;
                cVar.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    public static void i(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean j(File file, Resources resources, int i4) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i4);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean k = k(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return k;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean k(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            fileOutputStream.close();
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e5) {
            e = e5;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, I.S] */
    public static boolean m(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = T.f702a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = S.f698d;
            S s3 = (S) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            S s4 = s3;
            if (s3 == null) {
                ?? obj = new Object();
                obj.f699a = null;
                obj.f700b = null;
                obj.f701c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, obj);
                s4 = obj;
            }
            WeakReference weakReference2 = s4.f701c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                s4.f701c = new WeakReference(keyEvent);
                if (s4.f700b == null) {
                    s4.f700b = new SparseArray();
                }
                SparseArray sparseArray = s4.f700b;
                if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    throw i.f(arrayList, size);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(I.InterfaceC0057k r6, android.view.View r7, android.view.Window.Callback r8, android.view.KeyEvent r9) {
        /*
            r0 = 0
            if (r6 != 0) goto L5
            goto Le4
        L5:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L10
            boolean r6 = r6.superDispatchKeyEvent(r9)
            return r6
        L10:
            boolean r1 = r8 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L82
            android.app.Activity r8 = (android.app.Activity) r8
            r8.onUserInteraction()
            android.view.Window r6 = r8.getWindow()
            r7 = 8
            boolean r7 = r6.hasFeature(r7)
            if (r7 == 0) goto L65
            android.app.ActionBar r7 = r8.getActionBar()
            int r1 = r9.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L65
            if (r7 == 0) goto L65
            boolean r1 = a.AbstractC0141a.f2210a
            if (r1 != 0) goto L4d
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class<android.view.KeyEvent> r5 = android.view.KeyEvent.class
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L4b
            a.AbstractC0141a.f2211b = r1     // Catch: java.lang.NoSuchMethodException -> L4b
        L4b:
            a.AbstractC0141a.f2210a = r3
        L4d:
            java.lang.reflect.Method r1 = a.AbstractC0141a.f2211b
            if (r1 == 0) goto L62
            java.lang.Object[] r4 = new java.lang.Object[]{r9}     // Catch: java.lang.Throwable -> L62
            java.lang.Object r7 = r1.invoke(r7, r4)     // Catch: java.lang.Throwable -> L62
            if (r7 != 0) goto L5c
            goto L62
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L62
            boolean r0 = r7.booleanValue()     // Catch: java.lang.Throwable -> L62
        L62:
            if (r0 == 0) goto L65
            goto L81
        L65:
            boolean r7 = r6.superDispatchKeyEvent(r9)
            if (r7 == 0) goto L6c
            goto L81
        L6c:
            android.view.View r6 = r6.getDecorView()
            boolean r7 = I.T.c(r6, r9)
            if (r7 == 0) goto L77
            goto L81
        L77:
            if (r6 == 0) goto L7d
            android.view.KeyEvent$DispatcherState r2 = r6.getKeyDispatcherState()
        L7d:
            boolean r3 = r9.dispatch(r8, r2, r8)
        L81:
            return r3
        L82:
            boolean r1 = r8 instanceof android.app.Dialog
            if (r1 == 0) goto Ld5
            android.app.Dialog r8 = (android.app.Dialog) r8
            boolean r6 = a.AbstractC0141a.f2212c
            if (r6 != 0) goto L9b
            java.lang.Class<android.app.Dialog> r6 = android.app.Dialog.class
            java.lang.String r7 = "mOnKeyListener"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch: java.lang.NoSuchFieldException -> L99
            a.AbstractC0141a.f2213d = r6     // Catch: java.lang.NoSuchFieldException -> L99
            r6.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L99
        L99:
            a.AbstractC0141a.f2212c = r3
        L9b:
            java.lang.reflect.Field r6 = a.AbstractC0141a.f2213d
            if (r6 == 0) goto La6
            java.lang.Object r6 = r6.get(r8)     // Catch: java.lang.IllegalAccessException -> La6
            android.content.DialogInterface$OnKeyListener r6 = (android.content.DialogInterface.OnKeyListener) r6     // Catch: java.lang.IllegalAccessException -> La6
            goto La7
        La6:
            r6 = r2
        La7:
            if (r6 == 0) goto Lb4
            int r7 = r9.getKeyCode()
            boolean r6 = r6.onKey(r8, r7, r9)
            if (r6 == 0) goto Lb4
            goto Ld4
        Lb4:
            android.view.Window r6 = r8.getWindow()
            boolean r7 = r6.superDispatchKeyEvent(r9)
            if (r7 == 0) goto Lbf
            goto Ld4
        Lbf:
            android.view.View r6 = r6.getDecorView()
            boolean r7 = I.T.c(r6, r9)
            if (r7 == 0) goto Lca
            goto Ld4
        Lca:
            if (r6 == 0) goto Ld0
            android.view.KeyEvent$DispatcherState r2 = r6.getKeyDispatcherState()
        Ld0:
            boolean r3 = r9.dispatch(r8, r2, r8)
        Ld4:
            return r3
        Ld5:
            if (r7 == 0) goto Ldd
            boolean r7 = I.T.c(r7, r9)
            if (r7 != 0) goto Le3
        Ldd:
            boolean r6 = r6.superDispatchKeyEvent(r9)
            if (r6 == 0) goto Le4
        Le3:
            return r3
        Le4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0141a.n(I.k, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }

    public static boolean o(Method method, e eVar) {
        Class a4 = eVar.a();
        h.c(a4, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return method.getReturnType().equals(a4);
    }

    public static final Object p(InterfaceC0080i interfaceC0080i, p pVar, M2.h hVar) {
        return interfaceC0080i.a(new S.h(pVar, null), hVar);
    }

    public static InvocationHandler r() {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = WebView.getWebViewClassLoader();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, null).getClass().getClassLoader();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static g s(g gVar, K2.h hVar) {
        h.e(hVar, "key");
        if (h.a(gVar.getKey(), hVar)) {
            return gVar;
        }
        return null;
    }

    public static File t(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i4 = 0; i4 < 100; i4++) {
            File file = new File(cacheDir, str + i4);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static String u(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int i4 = 0; i4 < str.length(); i4++) {
                sb.append(str.charAt(i4));
                if (str2.length() > i4) {
                    sb.append(str2.charAt(i4));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    public static K2.i v(g gVar, K2.h hVar) {
        h.e(hVar, "key");
        if (h.a(gVar.getKey(), hVar)) {
            return j.f942f;
        }
        return gVar;
    }

    public static MappedByteBuffer w(Context context, Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (openFileDescriptor == null) {
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static Long x(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ec, code lost:
    
        if (y(r2, r5.getValue()) == false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean y(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0141a.y(java.lang.Object, java.lang.Object):boolean");
    }

    public static int z(Object obj) {
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
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i5 = (i5 * 31) + z(it.next());
            }
            return i5;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                i4 += z(entry.getValue()) ^ (z(entry.getKey()) * 31);
            }
            return i4;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length2 = objArr.length;
            while (i4 < length2) {
                i5 = (i5 * 31) + z(objArr[i4]);
                i4++;
            }
            return i5;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue != 0.0d) {
                d4 = doubleValue;
            }
            long doubleToLongBits2 = Double.doubleToLongBits(d4);
            return (int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32));
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (floatValue == 0.0f) {
                floatValue = 0.0f;
            }
            return Float.floatToIntBits(floatValue);
        }
        return obj.hashCode();
    }

    public abstract void B(C0675g c0675g, C0675g c0675g2);

    public abstract void C(C0675g c0675g, Thread thread);

    public abstract boolean b(AbstractFutureC0676h abstractFutureC0676h, C0672d c0672d);

    public abstract boolean c(AbstractFutureC0676h abstractFutureC0676h, Object obj, Object obj2);

    public abstract boolean d(AbstractFutureC0676h abstractFutureC0676h, C0675g c0675g, C0675g c0675g2);

    public abstract String l(byte[] bArr, int i4, int i5);

    public abstract int q(String str, byte[] bArr, int i4, int i5);
}
