package f0;

import android.content.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3690f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f3691g;

    public /* synthetic */ g(Context context, int i4) {
        this.f3690f = i4;
        this.f3691g = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
    
        if (r5 != null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f3690f
            switch(r0) {
                case 0: goto L9c;
                case 1: goto L8e;
                default: goto L5;
            }
        L5:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto L8b
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r1 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            android.content.Context r3 = r11.f3691g
            r0.<init>(r3, r1)
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            int r1 = r1.getComponentEnabledSetting(r0)
            if (r1 == r2) goto L8b
            boolean r1 = E.b.a()
            java.lang.String r4 = "locale"
            if (r1 == 0) goto L62
            t.f r1 = j.AbstractC0420o.f4999l
            r1.getClass()
            t.a r5 = new t.a
            r5.<init>(r1)
        L31:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L50
            java.lang.Object r1 = r5.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r1 = r1.get()
            j.o r1 = (j.AbstractC0420o) r1
            if (r1 == 0) goto L31
            j.A r1 = (j.LayoutInflaterFactory2C0393A) r1
            android.content.Context r1 = r1.f4864p
            if (r1 == 0) goto L31
            java.lang.Object r1 = r1.getSystemService(r4)
            goto L51
        L50:
            r1 = 0
        L51:
            if (r1 == 0) goto L67
            android.os.LocaleList r1 = j.AbstractC0419n.a(r1)
            E.e r5 = new E.e
            E.f r6 = new E.f
            r6.<init>(r1)
            r5.<init>(r6)
            goto L69
        L62:
            E.e r5 = j.AbstractC0420o.f4996h
            if (r5 == 0) goto L67
            goto L69
        L67:
            E.e r5 = E.e.f453b
        L69:
            E.f r1 = r5.f454a
            android.os.LocaleList r1 = r1.f455a
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L84
            java.lang.String r1 = f1.AbstractC0286a.D(r3)
            java.lang.Object r4 = r3.getSystemService(r4)
            if (r4 == 0) goto L84
            android.os.LocaleList r1 = j.AbstractC0418m.a(r1)
            j.AbstractC0419n.b(r4, r1)
        L84:
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            r1.setComponentEnabledSetting(r0, r2, r2)
        L8b:
            j.AbstractC0420o.k = r2
            return
        L8e:
            f0.c r0 = new f0.c
            r0.<init>()
            H1.f r1 = f0.AbstractC0285e.f3679a
            r2 = 0
            android.content.Context r3 = r11.f3691g
            f0.AbstractC0285e.t(r3, r0, r1, r2)
            return
        L9c:
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            r4.<init>(r5, r6, r7, r9, r10)
            f0.g r0 = new f0.g
            r1 = 1
            android.content.Context r2 = r11.f3691g
            r0.<init>(r2, r1)
            r4.execute(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.g.run():void");
    }
}
