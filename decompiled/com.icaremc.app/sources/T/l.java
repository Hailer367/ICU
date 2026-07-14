package T;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0212t;

/* loaded from: classes.dex */
public final class l implements DefaultLifecycleObserver {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0208o f1565f;

    public l(EmojiCompatInitializer emojiCompatInitializer, AbstractC0208o abstractC0208o) {
        this.f1565f = abstractC0208o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.lang.Runnable] */
    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void a(InterfaceC0212t interfaceC0212t) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = b.a(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new Object(), 500L);
        this.f1565f.b(this);
    }
}
