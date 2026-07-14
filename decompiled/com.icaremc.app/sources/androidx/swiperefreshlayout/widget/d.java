package androidx.swiperefreshlayout.widget;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f3150a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f3151b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f3152c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f3153d;

    /* renamed from: e, reason: collision with root package name */
    public float f3154e;

    /* renamed from: f, reason: collision with root package name */
    public float f3155f;

    /* renamed from: g, reason: collision with root package name */
    public float f3156g;

    /* renamed from: h, reason: collision with root package name */
    public float f3157h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f3158i;

    /* renamed from: j, reason: collision with root package name */
    public int f3159j;
    public float k;

    /* renamed from: l, reason: collision with root package name */
    public float f3160l;

    /* renamed from: m, reason: collision with root package name */
    public float f3161m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3162n;

    /* renamed from: o, reason: collision with root package name */
    public Path f3163o;

    /* renamed from: p, reason: collision with root package name */
    public float f3164p;

    /* renamed from: q, reason: collision with root package name */
    public float f3165q;

    /* renamed from: r, reason: collision with root package name */
    public int f3166r;

    /* renamed from: s, reason: collision with root package name */
    public int f3167s;

    /* renamed from: t, reason: collision with root package name */
    public int f3168t;

    /* renamed from: u, reason: collision with root package name */
    public int f3169u;

    public d() {
        Paint paint = new Paint();
        this.f3151b = paint;
        Paint paint2 = new Paint();
        this.f3152c = paint2;
        Paint paint3 = new Paint();
        this.f3153d = paint3;
        this.f3154e = 0.0f;
        this.f3155f = 0.0f;
        this.f3156g = 0.0f;
        this.f3157h = 5.0f;
        this.f3164p = 1.0f;
        this.f3168t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i4) {
        this.f3159j = i4;
        this.f3169u = this.f3158i[i4];
    }
}
