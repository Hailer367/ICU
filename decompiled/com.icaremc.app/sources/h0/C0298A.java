package h0;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.flutter.plugin.platform.C0378b;
import io.flutter.view.TextureRegistry$ImageTextureEntry;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: h0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0298A implements io.flutter.plugin.platform.i {

    /* renamed from: f, reason: collision with root package name */
    public int f3818f;

    /* renamed from: g, reason: collision with root package name */
    public int f3819g;

    /* renamed from: h, reason: collision with root package name */
    public Object f3820h;

    /* renamed from: i, reason: collision with root package name */
    public Object f3821i;

    /* renamed from: j, reason: collision with root package name */
    public Object f3822j;
    public final Object k;

    public C0298A(TextureRegistry$ImageTextureEntry textureRegistry$ImageTextureEntry) {
        this.f3818f = 0;
        this.f3819g = 0;
        this.f3822j = new Handler();
        this.k = new C0378b(this);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3820h = textureRegistry$ImageTextureEntry;
            return;
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    public void a(int i4) {
        RecyclerView recyclerView = (RecyclerView) this.k;
        C0301D c0301d = recyclerView.f3104c0;
        if (i4 >= 0 && i4 < c0301d.a()) {
            boolean z = c0301d.f3826c;
            ArrayList arrayList = (ArrayList) this.f3821i;
            ArrayList arrayList2 = (ArrayList) this.f3820h;
            if (arrayList2.size() <= 0) {
                ArrayList arrayList3 = (ArrayList) recyclerView.f3113i.f101i;
                if (arrayList3.size() <= 0) {
                    if (arrayList.size() <= 0) {
                        int E3 = recyclerView.f3111h.E(i4, 0);
                        if (E3 >= 0) {
                            throw null;
                        }
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i4 + "(offset:" + E3 + ").state:" + c0301d.a() + recyclerView.h());
                    }
                    throw A2.i.f(arrayList, 0);
                }
                RecyclerView.j((View) arrayList3.get(0));
                throw null;
            }
            throw A2.i.f(arrayList2, 0);
        }
        throw new IndexOutOfBoundsException("Invalid item position " + i4 + "(" + i4 + "). Item count:" + c0301d.a() + recyclerView.h());
    }

    @Override // io.flutter.plugin.platform.i
    public void b(int i4, int i5) {
        ImageReader newInstance;
        ImageReader imageReader = (ImageReader) this.f3821i;
        if (imageReader != null && this.f3818f == i4 && this.f3819g == i5) {
            return;
        }
        if (imageReader != null) {
            ((TextureRegistry$ImageTextureEntry) this.f3820h).pushImage(null);
            ((ImageReader) this.f3821i).close();
            this.f3821i = null;
        }
        this.f3818f = i4;
        this.f3819g = i5;
        Handler handler = (Handler) this.f3822j;
        C0378b c0378b = (C0378b) this.k;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            A2.m.r();
            ImageReader.Builder h3 = A2.m.h(this.f3818f, this.f3819g);
            h3.setMaxImages(4);
            h3.setImageFormat(34);
            h3.setUsage(256L);
            newInstance = h3.build();
            newInstance.setOnImageAvailableListener(c0378b, handler);
        } else if (i6 >= 29) {
            newInstance = ImageReader.newInstance(i4, i5, 34, 4, 256L);
            newInstance.setOnImageAvailableListener(c0378b, handler);
        } else {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f3821i = newInstance;
    }

    public void c() {
        ArrayList arrayList = (ArrayList) this.f3821i;
        this.f3819g = this.f3818f;
        int size = arrayList.size() - 1;
        if (size >= 0 && arrayList.size() > this.f3819g) {
            if (arrayList.get(size) == null) {
                int[] iArr = RecyclerView.m0;
                throw null;
            }
            throw new ClassCastException();
        }
    }

    @Override // io.flutter.plugin.platform.i
    public int getHeight() {
        return this.f3819g;
    }

    @Override // io.flutter.plugin.platform.i
    public long getId() {
        return ((TextureRegistry$ImageTextureEntry) this.f3820h).id();
    }

    @Override // io.flutter.plugin.platform.i
    public Surface getSurface() {
        return ((ImageReader) this.f3821i).getSurface();
    }

    @Override // io.flutter.plugin.platform.i
    public int getWidth() {
        return this.f3818f;
    }

    @Override // io.flutter.plugin.platform.i
    public void release() {
        if (((ImageReader) this.f3821i) != null) {
            ((TextureRegistry$ImageTextureEntry) this.f3820h).pushImage(null);
            ((ImageReader) this.f3821i).close();
            this.f3821i = null;
        }
        this.f3820h = null;
    }

    public C0298A(RecyclerView recyclerView) {
        this.k = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f3820h = arrayList;
        this.f3821i = new ArrayList();
        Collections.unmodifiableList(arrayList);
        this.f3818f = 2;
        this.f3819g = 2;
    }
}
