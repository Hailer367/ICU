package m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.icaremc.app.R;

/* loaded from: classes.dex */
public final class e extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f5133f;

    /* renamed from: a, reason: collision with root package name */
    public int f5134a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f5135b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f5136c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f5137d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f5138e;

    public e(Context context, int i4) {
        super(context);
        this.f5134a = i4;
    }

    public final void a(Configuration configuration) {
        if (this.f5138e == null) {
            if (this.f5137d == null) {
                this.f5137d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f5135b == null) {
            this.f5135b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f5135b.setTo(theme);
            }
        }
        this.f5135b.applyStyle(this.f5134a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0.equals(m.e.f5133f) != false) goto L15;
     */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f5138e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f5137d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = m.e.f5133f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            m.e.f5133f = r1
        L1c:
            android.content.res.Configuration r1 = m.e.f5133f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f5137d
            android.content.Context r0 = m.AbstractC0440d.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f5138e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f5138e = r0
        L38:
            android.content.res.Resources r0 = r3.f5138e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.e.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f5136c == null) {
                this.f5136c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f5136c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f5135b;
        if (theme != null) {
            return theme;
        }
        if (this.f5134a == 0) {
            this.f5134a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f5135b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        if (this.f5134a != i4) {
            this.f5134a = i4;
            b();
        }
    }
}
