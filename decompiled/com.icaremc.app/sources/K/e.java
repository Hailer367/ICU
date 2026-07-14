package K;

import A2.q;
import D2.J;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class e extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f903a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InputConnection inputConnection, J j4) {
        super(inputConnection, false);
        this.f903a = j4;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i4, Bundle bundle) {
        q qVar = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            qVar = new q(5, new g(inputContentInfo));
        }
        if (this.f903a.h(qVar, i4, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i4, bundle);
    }
}
