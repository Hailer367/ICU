package p0;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5817a;

    public u(ArrayList arrayList) {
        this.f5817a = arrayList;
    }

    public final WebResourceResponse a(Uri uri) {
        WebResourceResponse webResourceResponse;
        ArrayList arrayList = this.f5817a;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            webResourceResponse = null;
            r3 = null;
            r3 = null;
            r3 = null;
            s sVar = null;
            if (i4 >= size) {
                break;
            }
            Object obj = arrayList.get(i4);
            i4++;
            t tVar = (t) obj;
            tVar.getClass();
            String str = tVar.f5815c;
            if ((!uri.getScheme().equals("http") || tVar.f5813a) && ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(tVar.f5814b) && uri.getPath().startsWith(str))) {
                sVar = tVar.f5816d;
            }
            if (sVar != null && (webResourceResponse = sVar.handle(uri.getPath().replaceFirst(str, ""))) != null) {
                break;
            }
        }
        return webResourceResponse;
    }
}
