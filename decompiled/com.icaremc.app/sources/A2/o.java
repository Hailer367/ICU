package A2;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import io.flutter.plugin.platform.ViewOnSystemUiVisibilityChangeListenerC0380d;
import java.io.File;
import java.util.Arrays;
import s2.C0644p;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f87f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f88g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f89h;

    public /* synthetic */ o(Object obj, int i4, int i5) {
        this.f87f = i5;
        this.f88g = obj;
        this.f89h = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f87f) {
            case 0:
                u uVar = (u) this.f88g;
                if (this.f89h == -1) {
                    Uri uri = uVar.f110o;
                    R1.c cVar = uVar.k;
                    String str = "";
                    if (uri == null) {
                        uri = Uri.parse(uVar.f105i.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", ""));
                    }
                    final p pVar = new p(uVar, 0);
                    Activity activity = (Activity) cVar.f1532g;
                    if (uri != null) {
                        str = uri.getPath();
                    }
                    MediaScannerConnection.scanFile(activity, new String[]{str}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: A2.r
                        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                        public final void onScanCompleted(String str2, Uri uri2) {
                            y yVar;
                            p pVar2 = p.this;
                            int i4 = pVar2.f90a;
                            u uVar2 = pVar2.f91b;
                            switch (i4) {
                                case 0:
                                    synchronized (uVar2.f112q) {
                                        t tVar = uVar2.f111p;
                                        if (tVar != null) {
                                            yVar = (y) tVar.f99g;
                                        } else {
                                            yVar = null;
                                        }
                                    }
                                    if (yVar != null) {
                                        String b4 = uVar2.f104h.b(str2, yVar.f118a, yVar.f119b, (int) yVar.f120c);
                                        if (b4 != null && !b4.equals(str2)) {
                                            new File(str2).delete();
                                        }
                                        uVar2.d(b4);
                                        return;
                                    }
                                    uVar2.d(str2);
                                    return;
                                default:
                                    uVar2.d(str2);
                                    return;
                            }
                        }
                    });
                    return;
                }
                uVar.d(null);
                return;
            case 1:
                u uVar2 = (u) this.f88g;
                if (this.f89h == -1) {
                    Uri uri2 = uVar2.f110o;
                    R1.c cVar2 = uVar2.k;
                    String str2 = "";
                    if (uri2 == null) {
                        uri2 = Uri.parse(uVar2.f105i.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", ""));
                    }
                    final p pVar2 = new p(uVar2, 1);
                    Activity activity2 = (Activity) cVar2.f1532g;
                    if (uri2 != null) {
                        str2 = uri2.getPath();
                    }
                    MediaScannerConnection.scanFile(activity2, new String[]{str2}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: A2.r
                        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                        public final void onScanCompleted(String str22, Uri uri22) {
                            y yVar;
                            p pVar22 = p.this;
                            int i4 = pVar22.f90a;
                            u uVar22 = pVar22.f91b;
                            switch (i4) {
                                case 0:
                                    synchronized (uVar22.f112q) {
                                        t tVar = uVar22.f111p;
                                        if (tVar != null) {
                                            yVar = (y) tVar.f99g;
                                        } else {
                                            yVar = null;
                                        }
                                    }
                                    if (yVar != null) {
                                        String b4 = uVar22.f104h.b(str22, yVar.f118a, yVar.f119b, (int) yVar.f120c);
                                        if (b4 != null && !b4.equals(str22)) {
                                            new File(str22).delete();
                                        }
                                        uVar22.d(b4);
                                        return;
                                    }
                                    uVar22.d(str22);
                                    return;
                                default:
                                    uVar22.d(str22);
                                    return;
                            }
                        }
                    });
                    return;
                }
                uVar2.d(null);
                return;
            default:
                io.flutter.plugin.platform.s sVar = (io.flutter.plugin.platform.s) ((ViewOnSystemUiVisibilityChangeListenerC0380d) this.f88g).f4324b.f4327c;
                if ((this.f89h & 4) == 0) {
                    ((C0644p) sVar.f4390g).a("SystemChrome.systemUIChange", Arrays.asList(Boolean.TRUE), null);
                    return;
                } else {
                    ((C0644p) sVar.f4390g).a("SystemChrome.systemUIChange", Arrays.asList(Boolean.FALSE), null);
                    return;
                }
        }
    }
}
