package F;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import p1.C0585n;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f518f = 0;

    /* renamed from: g, reason: collision with root package name */
    public Object f519g;

    /* renamed from: h, reason: collision with root package name */
    public Object f520h;

    /* renamed from: i, reason: collision with root package name */
    public Object f521i;

    public /* synthetic */ o() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i4;
        C0585n b4;
        switch (this.f518f) {
            case 0:
                try {
                    obj = ((g) this.f519g).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) this.f521i).post(new a(1, (h) this.f520h, obj));
                return;
            default:
                V0.a aVar = (V0.a) this.f520h;
                Intent intent = aVar.f1672f;
                String stringExtra = intent.getStringExtra("google.message_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("message_id");
                }
                boolean isEmpty = TextUtils.isEmpty(stringExtra);
                Integer num = null;
                if (isEmpty) {
                    b4 = AbstractC0602b.A(null);
                } else {
                    Bundle bundle = new Bundle();
                    Intent intent2 = aVar.f1672f;
                    String stringExtra2 = intent2.getStringExtra("google.message_id");
                    if (stringExtra2 == null) {
                        stringExtra2 = intent2.getStringExtra("message_id");
                    }
                    bundle.putString("google.message_id", stringExtra2);
                    Intent intent3 = aVar.f1672f;
                    if (intent3.hasExtra("google.product_id")) {
                        num = Integer.valueOf(intent3.getIntExtra("google.product_id", 0));
                    }
                    if (num != null) {
                        bundle.putInt("google.product_id", num.intValue());
                    }
                    Context context = (Context) this.f519g;
                    bundle.putBoolean("supports_message_handled", true);
                    V0.n a4 = V0.n.a(context);
                    synchronized (a4) {
                        i4 = a4.f1716d;
                        a4.f1716d = i4 + 1;
                    }
                    b4 = a4.b(new V0.m(i4, 2, bundle, 0));
                }
                b4.g(V0.h.f1690g, new R1.c(13, (CountDownLatch) this.f521i));
                return;
        }
    }

    public /* synthetic */ o(Context context, V0.a aVar, CountDownLatch countDownLatch) {
        this.f519g = context;
        this.f520h = aVar;
        this.f521i = countDownLatch;
    }
}
