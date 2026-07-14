package K;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: f, reason: collision with root package name */
    public final InputContentInfo f905f;

    public g(Object obj) {
        this.f905f = (InputContentInfo) obj;
    }

    @Override // K.h
    public final Object g() {
        return this.f905f;
    }

    @Override // K.h
    public final ClipDescription getDescription() {
        return this.f905f.getDescription();
    }

    @Override // K.h
    public final Uri j() {
        return this.f905f.getContentUri();
    }

    @Override // K.h
    public final void m() {
        this.f905f.requestPermission();
    }

    @Override // K.h
    public final Uri p() {
        return this.f905f.getLinkUri();
    }

    public g(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f905f = new InputContentInfo(uri, clipDescription, uri2);
    }
}
