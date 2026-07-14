package I;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.icaremc.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f698d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f699a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f700b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f701c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f699a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View a4 = a(viewGroup.getChildAt(childCount));
                    if (a4 != null) {
                        return a4;
                    }
                }
            }
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                throw A2.i.f(arrayList, size);
            }
            return null;
        }
        return null;
    }
}
