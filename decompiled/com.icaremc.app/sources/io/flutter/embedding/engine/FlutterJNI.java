package io.flutter.embedding.engine;

import A2.m;
import E0.a;
import E0.c;
import P1.y;
import W.h;
import a.AbstractC0141a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaExtractor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.AttachedSurfaceControl;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import c1.AbstractC0255a;
import h2.AbstractActivityC0349b;
import h2.C0354g;
import h2.n;
import h2.o;
import h2.p;
import i2.C0374i;
import i2.InterfaceC0367b;
import i2.InterfaceC0375j;
import i2.InterfaceC0376k;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.renderer.k;
import io.flutter.plugin.platform.C0377a;
import io.flutter.plugin.platform.C0379c;
import io.flutter.plugin.platform.InterfaceC0382f;
import io.flutter.plugin.platform.q;
import io.flutter.plugin.platform.r;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.d;
import io.flutter.view.g;
import io.flutter.view.s;
import io.flutter.view.t;
import j2.f;
import j2.i;
import j2.j;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import k2.InterfaceC0431a;
import l2.C0435b;
import l2.C0436c;
import n2.C0460a;
import r2.l;
import s2.C0650v;
import s2.InterfaceC0633e;
import t2.C0664a;

@Keep
/* loaded from: classes.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static InterfaceC0376k asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private InterfaceC0375j accessibilityDelegate;
    private InterfaceC0431a deferredComponentManager;
    private C0664a localizationPlugin;
    private Long nativeShellHolderId;
    private j platformMessageHandler;
    private r platformViewsController;
    private q platformViewsController2;
    private l settingsChannel;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<InterfaceC0367b> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<k> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Set<io.flutter.embedding.engine.renderer.l> flutterUiResizeListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    private static void asyncWaitForVsync(long j4) {
        InterfaceC0376k interfaceC0376k = asyncWaitForVsyncDelegate;
        if (interfaceC0376k != null) {
            d dVar = (d) interfaceC0376k;
            dVar.getClass();
            Choreographer choreographer = Choreographer.getInstance();
            t tVar = (t) dVar.f4423a;
            s sVar = tVar.f4550c;
            if (sVar != null) {
                sVar.f4544a = j4;
                tVar.f4550c = null;
            } else {
                sVar = new s(tVar, j4);
            }
            choreographer.postFrameCallback(sVar);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, l2.d] */
    public static Bitmap decodeImage(ByteBuffer byteBuffer, long j4) {
        C0435b c0435b;
        A2.q qVar = 0;
        qVar = 0;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        C0374i c0374i = new C0374i(j4);
        ?? obj = new Object();
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        byteBuffer.rewind();
        int i4 = 1;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, remaining, options);
            obj.f5127d = options.outMimeType;
            obj.f5129f = options.outHeight;
            obj.f5130g = options.outWidth;
        } catch (Exception e4) {
            Log.e("BitmapMetadataReader", "Failed to decode image for mime type", e4);
        }
        if ("image/heif".equals(obj.f5127d)) {
            try {
                C0436c c0436c = new C0436c(bArr);
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(c0436c);
                AbstractC0141a.D(obj, mediaExtractor);
            } catch (Exception e5) {
                Log.e("MediaMetadataReader", "Failed to decode HEIF image using MediaExtractor", e5);
            }
            nativeImageHeaderCallback(c0374i.f4148a, obj.f5124a, obj.f5125b);
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    h hVar = new h(byteArrayInputStream);
                    W.d c4 = hVar.c("Orientation");
                    if (c4 != null) {
                        try {
                            i4 = c4.i(hVar.f1834g);
                        } catch (NumberFormatException unused) {
                        }
                    }
                    obj.f5128e = i4;
                    byteArrayInputStream.close();
                } finally {
                }
            } catch (IOException e6) {
                Log.e("ExifMetadataReader", "Failed to read EXIF metadata", e6);
            }
        }
        if ("image/heif".equals(obj.f5127d)) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 == 36) {
                c0435b = new C0435b(qVar, 0);
            } else if (i5 < 36) {
                c0435b = new C0435b(qVar, 1);
            }
            qVar = c0435b;
        }
        if (qVar == 0) {
            qVar = new A2.q(29, c0374i);
        }
        return qVar.w(byteBuffer, obj);
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId != null) {
        } else {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId == null) {
        } else {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i4, ByteBuffer byteBuffer) {
        InterfaceC0633e interfaceC0633e;
        j jVar = this.platformMessageHandler;
        if (jVar != null && (interfaceC0633e = (InterfaceC0633e) ((i) jVar).k.remove(Integer.valueOf(i4))) != null) {
            try {
                interfaceC0633e.a(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Error e4) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.getUncaughtExceptionHandler() != null) {
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e4);
                    return;
                }
                throw e4;
            } catch (Exception e5) {
                Log.e("DartMessenger", "Uncaught exception in binary message reply handler", e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadLibrary$0(String str) {
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j4);

    private native void nativeDeferredComponentInstallFailure(int i4, String str, boolean z);

    private native void nativeDestroy(long j4);

    private native void nativeDispatchEmptyPlatformMessage(long j4, String str, int i4);

    private native void nativeDispatchPlatformMessage(long j4, String str, ByteBuffer byteBuffer, int i4, int i5);

    private native void nativeDispatchPointerDataPacket(long j4, ByteBuffer byteBuffer, int i4);

    private native void nativeDispatchSemanticsAction(long j4, int i4, int i5, ByteBuffer byteBuffer, int i6);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i4);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i4);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i4);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i4);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i4);

    private native Bitmap nativeGetBitmap(long j4);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j4, int i4, int i5);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j4, int i4);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j4, int i4);

    private native void nativeInvokePlatformMessageResponseCallback(long j4, int i4, ByteBuffer byteBuffer, int i5);

    private native boolean nativeIsSurfaceControlEnabled(long j4);

    private native void nativeLoadDartDeferredLibrary(long j4, int i4, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j4);

    private native void nativeMarkTextureFrameAvailable(long j4, long j5);

    private native void nativeNotifyLowMemoryWarning(long j4);

    private native void nativeOnVsync(long j4, long j5, long j6);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j4, long j5, WeakReference<TextureRegistry$ImageConsumer> weakReference, boolean z);

    private native void nativeRegisterTexture(long j4, long j5, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j4, String str, String str2, String str3, AssetManager assetManager, List<String> list, long j5);

    private native void nativeScheduleFrame(long j4);

    private native void nativeSetAccessibilityFeatures(long j4, int i4);

    private native void nativeSetSemanticsEnabled(long j4, boolean z);

    private native void nativeSetViewportMetrics(long j4, float f4, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int[] iArr, int[] iArr2, int[] iArr3, int i19, int i20, int i21, int i22);

    private native FlutterJNI nativeSpawn(long j4, String str, String str2, String str3, List<String> list, long j5);

    private native void nativeSurfaceChanged(long j4, int i4, int i5);

    private native void nativeSurfaceCreated(long j4, Surface surface);

    private native void nativeSurfaceDestroyed(long j4);

    private native void nativeSurfaceWindowChanged(long j4, Surface surface);

    private native void nativeUnregisterTexture(long j4, long j5);

    private native void nativeUpdateDisplayMetrics(long j4);

    private native void nativeUpdateJavaAssetManager(long j4, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f4);

    private void onPreEngineRestart() {
        Iterator<InterfaceC0367b> it = this.engineLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void setApplicationLocale(String str) {
        ensureRunningOnMainThread();
        InterfaceC0375j interfaceC0375j = this.accessibilityDelegate;
        if (interfaceC0375j != null) {
            ((io.flutter.view.j) ((d) interfaceC0375j).f4423a).f4520m = str;
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        InterfaceC0375j interfaceC0375j = this.accessibilityDelegate;
        if (interfaceC0375j != null) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            io.flutter.view.j jVar = (io.flutter.view.j) ((d) interfaceC0375j).f4423a;
            while (byteBuffer.hasRemaining()) {
                io.flutter.view.h b4 = jVar.b(byteBuffer.getInt());
                b4.f4453c = byteBuffer.getInt();
                b4.f4454d = io.flutter.view.j.d(byteBuffer, strArr);
                b4.f4455e = io.flutter.view.j.d(byteBuffer, strArr);
            }
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        InterfaceC0375j interfaceC0375j = this.accessibilityDelegate;
        if (interfaceC0375j != null) {
            ((d) interfaceC0375j).a(byteBuffer, strArr, byteBufferArr);
        }
    }

    public boolean IsSurfaceControlEnabled() {
        return nativeIsSurfaceControlEnabled(this.nativeShellHolderId.longValue());
    }

    public void addEngineLifecycleListener(InterfaceC0367b interfaceC0367b) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(interfaceC0367b);
    }

    public void addIsDisplayingFlutterUiListener(k kVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(kVar);
    }

    public void addResizingFlutterUiListener(io.flutter.embedding.engine.renderer.l lVar) {
        ensureRunningOnMainThread();
        this.flutterUiResizeListeners.add(lVar);
    }

    @SuppressLint({"NewApi"})
    public void applyTransactions() {
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            ArrayList arrayList = qVar.f4361q;
            SurfaceControl.Transaction g4 = AbstractC0255a.g();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                g4 = g4.merge(AbstractC0255a.i(arrayList.get(i4)));
            }
            g4.apply();
            arrayList.clear();
            return;
        }
        throw new RuntimeException("");
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j4) {
        nativeCleanupMessageData(j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
    
        if (r10 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
    
        r4 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011e, code lost:
    
        if (r5 >= r4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0120, code lost:
    
        r6 = r0.get(r5);
        r5 = r5 + 1;
        r6 = (java.util.Locale) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0134, code lost:
    
        if (r3.getLanguage().equals(r6.toLanguageTag()) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0137, code lost:
    
        r4 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013c, code lost:
    
        if (r5 >= r4) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013e, code lost:
    
        r6 = r0.get(r5);
        r5 = r5 + 1;
        r6 = (java.util.Locale) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0152, code lost:
    
        if (r3.getLanguage().equals(r6.getLanguage()) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0155, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] computePlatformResolvedLocale(java.lang.String[] r10) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.computePlatformResolvedLocale(java.lang.String[]):java.lang.String[]");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [h2.g, java.lang.Object, io.flutter.plugin.platform.c] */
    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        r rVar = this.platformViewsController;
        if (rVar != null) {
            Context context = rVar.f4372i.getContext();
            int width = rVar.f4372i.getWidth();
            int height = rVar.f4372i.getHeight();
            C0377a c0377a = rVar.f4376n;
            ?? c0354g = new C0354g(context, width, height, 2);
            c0354g.f4322m = c0377a;
            int i4 = rVar.f4383u;
            rVar.f4383u = i4 + 1;
            rVar.f4381s.put(i4, c0354g);
            return new FlutterOverlaySurface(i4, c0354g.getSurface());
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @SuppressLint({"NewApi"})
    public FlutterOverlaySurface createOverlaySurface2() {
        SurfaceControl build;
        AttachedSurfaceControl rootSurfaceControl;
        SurfaceControl.Transaction buildReparentTransaction;
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            if (qVar.f4363s == null) {
                SurfaceControl.Builder f4 = AbstractC0255a.f();
                f4.setBufferSize(qVar.f4354i.getWidth(), qVar.f4354i.getHeight());
                f4.setFormat(1);
                f4.setName("Flutter Overlay Surface");
                f4.setOpaque(false);
                m.u(f4);
                build = f4.build();
                rootSurfaceControl = qVar.f4354i.getRootSurfaceControl();
                buildReparentTransaction = rootSurfaceControl.buildReparentTransaction(build);
                buildReparentTransaction.setLayer(build, 1000);
                buildReparentTransaction.apply();
                qVar.f4363s = AbstractC0255a.e(build);
                qVar.f4364t = build;
            }
            return new FlutterOverlaySurface(0, qVar.f4363s);
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @SuppressLint({"NewApi"})
    public SurfaceControl.Transaction createTransaction() {
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            SurfaceControl.Transaction g4 = AbstractC0255a.g();
            qVar.f4361q.add(g4);
            return g4;
        }
        throw new RuntimeException("");
    }

    public void deferredComponentInstallFailure(int i4, String str, boolean z) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i4, str, z);
    }

    @SuppressLint({"NewApi"})
    public void destroyOverlaySurface2() {
        ensureRunningOnMainThread();
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            Surface surface = qVar.f4363s;
            if (surface != null) {
                surface.release();
                qVar.f4363s = null;
                qVar.f4364t = null;
                return;
            }
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        r rVar = this.platformViewsController;
        if (rVar != null) {
            rVar.c();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i4) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i4);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i4);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i4, int i5) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i4, i5);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i5);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i4);
    }

    public void dispatchSemanticsAction(int i4, g gVar) {
        dispatchSemanticsAction(i4, gVar, null);
    }

    @SuppressLint({"NewApi"})
    public void endFrame2() {
        AttachedSurfaceControl rootSurfaceControl;
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            ArrayList arrayList = qVar.f4362r;
            SurfaceControl.Transaction g4 = AbstractC0255a.g();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                g4 = g4.merge(AbstractC0255a.i(arrayList.get(i4)));
            }
            arrayList.clear();
            qVar.f4354i.invalidate();
            rootSurfaceControl = qVar.f4354i.getRootSurfaceControl();
            rootSurfaceControl.applyTransactionOnDraw(g4);
            return;
        }
        throw new RuntimeException("");
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float getScaledFontSize(float r7, int r8) {
        /*
            r6 = this;
            r2.l r0 = r6.settingsChannel
            r1 = 0
            if (r0 != 0) goto L6
            goto L70
        L6:
            A2.t r0 = r0.f6094a
            java.lang.Object r2 = r0.f99g
            java.util.concurrent.ConcurrentLinkedQueue r2 = (java.util.concurrent.ConcurrentLinkedQueue) r2
            java.lang.Object r3 = r0.f100h
            r2.j r3 = (r2.j) r3
            if (r3 != 0) goto L1a
            java.lang.Object r3 = r2.poll()
            r2.j r3 = (r2.j) r3
            r0.f100h = r3
        L1a:
            java.lang.Object r3 = r0.f100h
            r2.j r3 = (r2.j) r3
            if (r3 == 0) goto L2d
            int r4 = r3.f6092a
            if (r4 >= r8) goto L2d
            java.lang.Object r3 = r2.poll()
            r2.j r3 = (r2.j) r3
            r0.f100h = r3
            goto L1a
        L2d:
            java.lang.String r2 = "Cannot find config with generation: "
            java.lang.String r4 = "SettingsChannel"
            if (r3 != 0) goto L49
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r2 = ", after exhausting the queue."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
        L47:
            r3 = r1
            goto L6b
        L49:
            int r5 = r3.f6092a
            if (r5 == r8) goto L6b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r8)
            java.lang.String r2 = ", the oldest config is now: "
            r3.append(r2)
            java.lang.Object r0 = r0.f100h
            r2.j r0 = (r2.j) r0
            int r0 = r0.f6092a
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r4, r0)
            goto L47
        L6b:
            if (r3 != 0) goto L6e
            goto L70
        L6e:
            android.util.DisplayMetrics r1 = r3.f6093b
        L70:
            if (r1 != 0) goto L91
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "getScaledFontSize called with configurationId "
            r7.<init>(r0)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.append(r8)
            java.lang.String r8 = ", which can't be found."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "FlutterJNI"
            android.util.Log.e(r8, r7)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            return r7
        L91:
            r8 = 2
            float r7 = android.util.TypedValue.applyDimension(r8, r7, r1)
            float r8 = r1.density
            float r7 = r7 / r8
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.getScaledFontSize(float, int):float");
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i4, long j4) {
        f fVar;
        boolean z;
        j jVar = this.platformMessageHandler;
        if (jVar != null) {
            i iVar = (i) jVar;
            synchronized (iVar.f5080i) {
                try {
                    fVar = (f) iVar.f5078g.get(str);
                    if (iVar.f5081j.get() && fVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (!iVar.f5079h.containsKey(str)) {
                            iVar.f5079h.put(str, new LinkedList());
                        }
                        ((List) iVar.f5079h.get(str)).add(new j2.d(j4, byteBuffer, i4));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z) {
                iVar.b(str, fVar, byteBuffer, i4, j4);
                return;
            }
            return;
        }
        nativeCleanupMessageData(j4);
    }

    @SuppressLint({"NewApi"})
    public void hideOverlaySurface2() {
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            if (qVar.f4364t == null) {
                return;
            }
            SurfaceControl.Transaction g4 = AbstractC0255a.g();
            g4.setVisibility(qVar.f4364t, false);
            g4.apply();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    @SuppressLint({"NewApi"})
    public void hidePlatformView2(int i4) {
        ensureRunningOnMainThread();
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            if (!qVar.a(i4)) {
                return;
            }
            ((C0460a) qVar.f4359o.get(i4)).setVisibility(8);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to hide a platform view");
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j4, int i4) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j4, i4);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i4) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i4);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i4);
            }
            this.shellHolderLock.readLock().unlock();
        } catch (Throwable th) {
            this.shellHolderLock.readLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v9, types: [io.flutter.embedding.engine.FlutterJNI] */
    public void invokePlatformMessageResponseCallback(int i4, ByteBuffer byteBuffer, int i5) {
        FlutterJNI flutterJNI;
        if (byteBuffer.isDirect()) {
            this.shellHolderLock.readLock().lock();
            try {
                flutterJNI = isAttached();
                try {
                    if (flutterJNI != 0) {
                        FlutterJNI flutterJNI2 = this;
                        flutterJNI2.nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i4, byteBuffer, i5);
                        flutterJNI = flutterJNI2;
                    } else {
                        flutterJNI = this;
                        Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i4);
                    }
                    flutterJNI.shellHolderLock.readLock().unlock();
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    flutterJNI.shellHolderLock.readLock().unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                flutterJNI = this;
            }
        } else {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
    }

    public boolean isAttached() {
        if (this.nativeShellHolderId != null) {
            return true;
        }
        return false;
    }

    public boolean isCodePointEmoji(int i4) {
        return nativeFlutterTextUtilsIsEmoji(i4);
    }

    public boolean isCodePointEmojiModifier(int i4) {
        return nativeFlutterTextUtilsIsEmojiModifier(i4);
    }

    public boolean isCodePointEmojiModifierBase(int i4) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i4);
    }

    public boolean isCodePointRegionalIndicator(int i4) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i4);
    }

    public boolean isCodePointVariantSelector(int i4) {
        return nativeFlutterTextUtilsIsVariationSelector(i4);
    }

    public void loadDartDeferredLibrary(int i4, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i4, strArr);
    }

    public void loadLibrary(Context context) {
        String[] strArr;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        long j4;
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        V1.f fVar = new V1.f(1);
        y yVar = new y(1);
        yVar.f1472i = fVar;
        if (context != null) {
            yVar.p("Beginning load of %s...", "flutter");
            Z0.g gVar = (Z0.g) yVar.f1470g;
            HashSet hashSet = (HashSet) yVar.f1469f;
            if (hashSet.contains("flutter")) {
                yVar.p("%s already loaded previously!", "flutter");
            } else {
                a aVar = null;
                try {
                    gVar.getClass();
                    System.loadLibrary("flutter");
                    hashSet.add("flutter");
                    yVar.p("%s (%s) was loaded normally!", "flutter", null);
                } catch (UnsatisfiedLinkError e4) {
                    yVar.p("Loading the library normally failed: %s", Log.getStackTraceString(e4));
                    yVar.p("%s (%s) was not loaded normally, re-linking...", "flutter", null);
                    File m3 = yVar.m(context);
                    if (!m3.exists()) {
                        File dir = context.getDir("lib", 0);
                        File m4 = yVar.m(context);
                        gVar.getClass();
                        File[] listFiles = dir.listFiles(new c(System.mapLibraryName("flutter")));
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (!file.getAbsolutePath().equals(m4.getAbsolutePath())) {
                                    file.delete();
                                }
                            }
                        }
                        W0.g gVar2 = (W0.g) yVar.f1471h;
                        String[] strArr2 = Build.SUPPORTED_ABIS;
                        if (strArr2.length <= 0) {
                            String str = Build.CPU_ABI2;
                            if (str != null && str.length() != 0) {
                                strArr2 = new String[]{Build.CPU_ABI, str};
                            } else {
                                strArr2 = new String[]{Build.CPU_ABI};
                            }
                        }
                        String mapLibraryName = System.mapLibraryName("flutter");
                        gVar2.getClass();
                        try {
                            a f4 = W0.g.f(context, strArr2, mapLibraryName, yVar);
                            try {
                                if (f4 != null) {
                                    ZipFile zipFile = (ZipFile) f4.f459g;
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4 + 1;
                                        if (i4 < 5) {
                                            yVar.p("Found %s! Extracting...", mapLibraryName);
                                            try {
                                                if (m3.exists() || m3.createNewFile()) {
                                                    try {
                                                        inputStream2 = zipFile.getInputStream((ZipEntry) f4.f460h);
                                                    } catch (FileNotFoundException unused) {
                                                        inputStream2 = null;
                                                    } catch (IOException unused2) {
                                                        inputStream2 = null;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream = null;
                                                    }
                                                    try {
                                                        fileOutputStream2 = new FileOutputStream(m3);
                                                        try {
                                                            byte[] bArr = new byte[4096];
                                                            j4 = 0;
                                                            while (true) {
                                                                int read = inputStream2.read(bArr);
                                                                if (read == -1) {
                                                                    break;
                                                                }
                                                                fileOutputStream2.write(bArr, 0, read);
                                                                j4 += read;
                                                            }
                                                            fileOutputStream2.flush();
                                                            fileOutputStream2.getFD().sync();
                                                        } catch (FileNotFoundException unused3) {
                                                            W0.g.d(inputStream2);
                                                            W0.g.d(fileOutputStream2);
                                                            i4 = i5;
                                                        } catch (IOException unused4) {
                                                            W0.g.d(inputStream2);
                                                            W0.g.d(fileOutputStream2);
                                                            i4 = i5;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            inputStream = inputStream2;
                                                            fileOutputStream = fileOutputStream2;
                                                            W0.g.d(inputStream);
                                                            W0.g.d(fileOutputStream);
                                                            throw th;
                                                        }
                                                    } catch (FileNotFoundException unused5) {
                                                        fileOutputStream2 = null;
                                                        W0.g.d(inputStream2);
                                                        W0.g.d(fileOutputStream2);
                                                        i4 = i5;
                                                    } catch (IOException unused6) {
                                                        fileOutputStream2 = null;
                                                        W0.g.d(inputStream2);
                                                        W0.g.d(fileOutputStream2);
                                                        i4 = i5;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        inputStream = inputStream2;
                                                        fileOutputStream = null;
                                                        W0.g.d(inputStream);
                                                        W0.g.d(fileOutputStream);
                                                        throw th;
                                                    }
                                                    if (j4 != m3.length()) {
                                                        W0.g.d(inputStream2);
                                                        W0.g.d(fileOutputStream2);
                                                    } else {
                                                        W0.g.d(inputStream2);
                                                        W0.g.d(fileOutputStream2);
                                                        m3.setReadable(true, false);
                                                        m3.setExecutable(true, false);
                                                        m3.setWritable(true);
                                                        break;
                                                    }
                                                }
                                            } catch (IOException unused7) {
                                            }
                                            i4 = i5;
                                        } else if (((V1.f) yVar.f1472i) != null) {
                                            lambda$loadLibrary$0("FATAL! Couldn't extract the library from the APK!");
                                        }
                                    }
                                    try {
                                        zipFile.close();
                                    } catch (IOException unused8) {
                                        String absolutePath = m3.getAbsolutePath();
                                        gVar.getClass();
                                        System.load(absolutePath);
                                        hashSet.add("flutter");
                                        yVar.p("%s (%s) was re-linked!", "flutter", null);
                                        loadLibraryCalled = true;
                                        return;
                                    }
                                } else {
                                    try {
                                        strArr = W0.g.g(context, mapLibraryName);
                                    } catch (Exception e5) {
                                        strArr = new String[]{e5.toString()};
                                    }
                                    StringBuilder sb = new StringBuilder("Could not find '");
                                    sb.append(mapLibraryName);
                                    sb.append("'. Looked for: ");
                                    sb.append(Arrays.toString(strArr2));
                                    sb.append(", but only found: ");
                                    throw new RuntimeException(r2.k.c(sb, Arrays.toString(strArr), "."));
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                aVar = f4;
                                if (aVar != null) {
                                    try {
                                        ((ZipFile) aVar.f459g).close();
                                    } catch (IOException unused9) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    String absolutePath2 = m3.getAbsolutePath();
                    gVar.getClass();
                    System.load(absolutePath2);
                    hashSet.add("flutter");
                    yVar.p("%s (%s) was re-linked!", "flutter", null);
                }
            }
            loadLibraryCalled = true;
            return;
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public void markTextureFrameAvailable(long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j4);
    }

    public void maybeResizeSurfaceView(int i4, int i5) {
        boolean z;
        Iterator<io.flutter.embedding.engine.renderer.l> it = this.flutterUiResizeListeners.iterator();
        while (it.hasNext()) {
            p pVar = ((n) it.next()).f4011a;
            View view = pVar.k;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                boolean z3 = true;
                if (view.getHeight() != i5) {
                    layoutParams.height = i5;
                    z = true;
                } else {
                    z = false;
                }
                if (view.getWidth() != i4) {
                    layoutParams.width = i4;
                } else {
                    z3 = z;
                }
                if (z3) {
                    pVar.f4023f.set(false);
                    view.setLayoutParams(layoutParams);
                }
            } else {
                Log.e("FlutterView", "Flutter engine view not set.");
            }
        }
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        r rVar = this.platformViewsController;
        if (rVar != null) {
            rVar.f4386x.clear();
            rVar.f4387y.clear();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
    }

    public void onDisplayOverlaySurface(int i4, int i5, int i6, int i7, int i8) {
        ensureRunningOnMainThread();
        r rVar = this.platformViewsController;
        if (rVar != null) {
            SparseArray sparseArray = rVar.f4381s;
            if (sparseArray.get(i4) != null) {
                rVar.i();
                View view = (C0379c) sparseArray.get(i4);
                if (view.getParent() == null) {
                    rVar.f4372i.addView(view);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
                layoutParams.leftMargin = i5;
                layoutParams.topMargin = i6;
                view.setLayoutParams(layoutParams);
                view.setVisibility(0);
                view.bringToFront();
                rVar.f4386x.add(Integer.valueOf(i4));
                return;
            }
            throw new IllegalStateException("The overlay surface (id:" + i4 + ") doesn't exist");
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void onDisplayPlatformView(int i4, int i5, int i6, int i7, int i8, int i9, int i10, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        r rVar = this.platformViewsController;
        if (rVar != null) {
            rVar.i();
            SparseArray sparseArray = rVar.f4380r;
            SparseArray sparseArray2 = rVar.f4379q;
            InterfaceC0382f interfaceC0382f = (InterfaceC0382f) sparseArray2.get(i4);
            if (interfaceC0382f == null) {
                return;
            }
            if (sparseArray.get(i4) == null) {
                View view = interfaceC0382f.getView();
                if (view != null) {
                    if (view.getParent() == null) {
                        AbstractActivityC0349b abstractActivityC0349b = rVar.f4371h;
                        C0460a c0460a = new C0460a(abstractActivityC0349b, abstractActivityC0349b.getResources().getDisplayMetrics().density, rVar.f4370g);
                        c0460a.setOnDescendantFocusChangeListener(new io.flutter.plugin.platform.m(rVar, i4, 0));
                        sparseArray.put(i4, c0460a);
                        view.setImportantForAccessibility(4);
                        c0460a.addView(view);
                        rVar.f4372i.addView(c0460a);
                    } else {
                        throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
                    }
                } else {
                    throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
                }
            }
            C0460a c0460a2 = (C0460a) sparseArray.get(i4);
            c0460a2.f5382f = flutterMutatorsStack;
            c0460a2.f5384h = i5;
            c0460a2.f5385i = i6;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
            layoutParams.leftMargin = i5;
            layoutParams.topMargin = i6;
            c0460a2.setLayoutParams(layoutParams);
            c0460a2.setWillNotDraw(false);
            c0460a2.setVisibility(0);
            c0460a2.bringToFront();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i9, i10);
            View view2 = ((InterfaceC0382f) sparseArray2.get(i4)).getView();
            if (view2 != null) {
                view2.setLayoutParams(layoutParams2);
                view2.bringToFront();
            }
            rVar.f4387y.add(Integer.valueOf(i4));
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    @SuppressLint({"NewApi"})
    public void onDisplayPlatformView2(int i4, int i5, int i6, int i7, int i8, int i9, int i10, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            if (qVar.a(i4)) {
                C0460a c0460a = (C0460a) qVar.f4359o.get(i4);
                c0460a.f5382f = flutterMutatorsStack;
                c0460a.f5384h = i5;
                c0460a.f5385i = i6;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
                layoutParams.leftMargin = i5;
                layoutParams.topMargin = i6;
                c0460a.setLayoutParams(layoutParams);
                c0460a.setWillNotDraw(false);
                c0460a.setVisibility(0);
                c0460a.bringToFront();
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i9, i10);
                View view = ((InterfaceC0382f) qVar.f4358n.get(i4)).getView();
                if (view != null) {
                    view.setLayoutParams(layoutParams2);
                    view.bringToFront();
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, io.flutter.embedding.engine.renderer.m] */
    public void onEndFrame() {
        boolean z;
        ?? r3;
        ensureRunningOnMainThread();
        r rVar = this.platformViewsController;
        if (rVar != null) {
            boolean z3 = false;
            if (rVar.f4384v && rVar.f4387y.isEmpty()) {
                rVar.f4384v = false;
                p pVar = rVar.f4372i;
                A.k kVar = new A.k(11, rVar);
                C0354g c0354g = pVar.f4027j;
                if (c0354g == null || (r3 = pVar.f4028l) == 0) {
                    return;
                }
                pVar.k = r3;
                pVar.f4028l = null;
                io.flutter.embedding.engine.renderer.j jVar = pVar.f4031o.f4107b;
                if (jVar == null) {
                    c0354g.a();
                    C0354g c0354g2 = pVar.f4027j;
                    if (c0354g2 != null) {
                        c0354g2.f3991f.close();
                        pVar.removeView(pVar.f4027j);
                        pVar.f4027j = null;
                    }
                    kVar.run();
                    return;
                }
                r3.b();
                jVar.a(new o(pVar, jVar, kVar));
                return;
            }
            if (rVar.f4384v) {
                C0354g c0354g3 = rVar.f4372i.f4027j;
                if (c0354g3 != null) {
                    z = c0354g3.e();
                } else {
                    z = false;
                }
                if (z) {
                    z3 = true;
                }
            }
            rVar.f(z3);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<k> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<k> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void onSurfaceChanged(int i4, int i5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i4, i5);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j4, long j5, long j6) {
        nativeOnVsync(j4, j5, j6);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j4, TextureRegistry$ImageConsumer textureRegistry$ImageConsumer, boolean z) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j4, new WeakReference<>(textureRegistry$ImageConsumer), z);
    }

    public void registerTexture(long j4, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j4, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(InterfaceC0367b interfaceC0367b) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(interfaceC0367b);
    }

    public void removeIsDisplayingFlutterUiListener(k kVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(kVar);
    }

    public void removeResizingFlutterUiListener(io.flutter.embedding.engine.renderer.l lVar) {
        ensureRunningOnMainThread();
        this.flutterUiResizeListeners.remove(lVar);
    }

    public void requestDartDeferredLibrary(int i4) {
        Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list, long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list, j4);
    }

    public void scheduleFrame() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeScheduleFrame(this.nativeShellHolderId.longValue());
    }

    public void setAccessibilityDelegate(InterfaceC0375j interfaceC0375j) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = interfaceC0375j;
    }

    public void setAccessibilityFeatures(int i4) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setAccessibilityFeaturesInNative(i4);
        }
    }

    public void setAccessibilityFeaturesInNative(int i4) {
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i4);
    }

    public void setAsyncWaitForVsyncDelegate(InterfaceC0376k interfaceC0376k) {
        asyncWaitForVsyncDelegate = interfaceC0376k;
    }

    public void setDeferredComponentManager(InterfaceC0431a interfaceC0431a) {
        ensureRunningOnMainThread();
        if (interfaceC0431a != null) {
            interfaceC0431a.a();
        }
    }

    public void setLocalizationPlugin(C0664a c0664a) {
        ensureRunningOnMainThread();
        this.localizationPlugin = c0664a;
    }

    public void setPlatformMessageHandler(j jVar) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = jVar;
    }

    public void setPlatformViewsController(r rVar) {
        ensureRunningOnMainThread();
        this.platformViewsController = rVar;
    }

    public void setPlatformViewsController2(q qVar) {
        ensureRunningOnMainThread();
        this.platformViewsController2 = qVar;
    }

    public void setRefreshRateFPS(float f4) {
        refreshRateFPS = f4;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setSemanticsEnabledInNative(z);
        }
    }

    public void setSemanticsEnabledInNative(boolean z) {
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z);
    }

    public void setSemanticsTreeEnabled(boolean z) {
        ensureRunningOnMainThread();
        InterfaceC0375j interfaceC0375j = this.accessibilityDelegate;
        if (interfaceC0375j != null && !z) {
            io.flutter.view.j jVar = (io.flutter.view.j) ((d) interfaceC0375j).f4423a;
            jVar.f4515g.clear();
            io.flutter.view.i iVar = jVar.f4517i;
            if (iVar != null) {
                jVar.h(iVar.f4483b, 65536);
            }
            jVar.f4517i = null;
            jVar.f4523p = null;
            AccessibilityEvent e4 = jVar.e(0, 2048);
            e4.setContentChangeTypes(1);
            jVar.i(e4);
        }
    }

    public void setSettingsChannel(l lVar) {
        ensureRunningOnMainThread();
        this.settingsChannel = lVar;
    }

    public void setViewportMetrics(float f4, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int[] iArr, int[] iArr2, int[] iArr3, int i19, int i20, int i21, int i22) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f4, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, iArr, iArr2, iArr3, i19, i20, i21, i22);
    }

    @SuppressLint({"NewApi"})
    public void showOverlaySurface2() {
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            if (qVar.f4364t == null) {
                return;
            }
            SurfaceControl.Transaction g4 = AbstractC0255a.g();
            g4.setVisibility(qVar.f4364t, true);
            g4.apply();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list, long j4) {
        boolean z;
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list, j4);
        Long l3 = nativeSpawn.nativeShellHolderId;
        if (l3 != null && l3.longValue() != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return nativeSpawn;
        }
        throw new IllegalStateException("Failed to spawn new JNI connected shell from existing shell.");
    }

    @SuppressLint({"NewApi"})
    public void swapTransactions() {
        q qVar = this.platformViewsController2;
        if (qVar != null) {
            synchronized (qVar) {
                try {
                    qVar.f4362r.clear();
                    for (int i4 = 0; i4 < qVar.f4361q.size(); i4++) {
                        qVar.f4362r.add(AbstractC0255a.i(qVar.f4361q.get(i4)));
                    }
                    qVar.f4361q.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new RuntimeException("");
    }

    public void unregisterTexture(long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j4);
    }

    public void updateDisplayMetrics(int i4, float f4, float f5, float f6) {
        displayWidth = f4;
        displayHeight = f5;
        displayDensity = f6;
        if (!loadLibraryCalled) {
            return;
        }
        nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (!loadLibraryCalled) {
            return;
        }
        nativeUpdateRefreshRate(refreshRateFPS);
    }

    public void dispatchSemanticsAction(int i4, g gVar, Object obj) {
        ByteBuffer byteBuffer;
        int i5;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = C0650v.f6160a.a(obj);
            i5 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i5 = 0;
        }
        dispatchSemanticsAction(i4, gVar.f4450f, byteBuffer, i5);
    }

    public void dispatchSemanticsAction(int i4, int i5, ByteBuffer byteBuffer, int i6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i4, i5, byteBuffer, i6);
    }
}
