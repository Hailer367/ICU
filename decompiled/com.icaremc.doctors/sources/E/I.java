package E;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.icaremc.doctors.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class I {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f176d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f177a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f178b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f179c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f177a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View a2 = a(viewGroup.getChildAt(childCount));
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                arrayList.get(size).getClass();
                throw new ClassCastException();
            }
            return null;
        }
        return null;
    }
}
