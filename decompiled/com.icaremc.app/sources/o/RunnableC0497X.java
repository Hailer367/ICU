package o;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import r.BinderC0612g;

/* renamed from: o.X, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0497X implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5546f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5547g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5548h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f5549i;

    public RunnableC0497X(TextView textView, Typeface typeface, int i4) {
        this.f5548h = textView;
        this.f5549i = typeface;
        this.f5547g = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5546f) {
            case 0:
                ((TextView) this.f5548h).setTypeface((Typeface) this.f5549i, this.f5547g);
                return;
            default:
                ((BinderC0612g) this.f5549i).f5993g.onNavigationEvent(this.f5547g, (Bundle) this.f5548h);
                return;
        }
    }

    public RunnableC0497X(int i4, Bundle bundle, BinderC0612g binderC0612g) {
        this.f5549i = binderC0612g;
        this.f5547g = i4;
        this.f5548h = bundle;
    }
}
