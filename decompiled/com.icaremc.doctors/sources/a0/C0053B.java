package a0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: a0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0053B {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f891a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f892b;

    /* renamed from: c, reason: collision with root package name */
    public int f893c;

    /* renamed from: d, reason: collision with root package name */
    public int f894d;

    /* renamed from: e, reason: collision with root package name */
    public C0052A f895e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f896f;

    public C0053B(RecyclerView recyclerView) {
        this.f896f = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f891a = arrayList;
        this.f892b = new ArrayList();
        Collections.unmodifiableList(arrayList);
        this.f893c = 2;
        this.f894d = 2;
    }

    public final void a(int i2) {
        RecyclerView recyclerView = this.f896f;
        C0056E c0056e = recyclerView.f1920W;
        if (i2 >= 0 && i2 < c0056e.a()) {
            boolean z = c0056e.f900c;
            ArrayList arrayList = this.f891a;
            if (arrayList.size() <= 0) {
                ArrayList arrayList2 = (ArrayList) recyclerView.f1929f.f32f;
                if (arrayList2.size() <= 0) {
                    ArrayList arrayList3 = this.f892b;
                    if (arrayList3.size() <= 0) {
                        int b2 = recyclerView.f1927e.b(i2, 0);
                        if (b2 >= 0) {
                            throw null;
                        }
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + b2 + ").state:" + c0056e.a() + recyclerView.h());
                    }
                    arrayList3.get(0).getClass();
                    throw new ClassCastException();
                }
                RecyclerView.j((View) arrayList2.get(0));
                throw null;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
        throw new IndexOutOfBoundsException("Invalid item position " + i2 + "(" + i2 + "). Item count:" + c0056e.a() + recyclerView.h());
    }

    public final void b() {
        this.f894d = this.f893c;
        ArrayList arrayList = this.f892b;
        int size = arrayList.size() - 1;
        if (size >= 0 && arrayList.size() > this.f894d) {
            if (arrayList.get(size) == null) {
                int[] iArr = RecyclerView.f1895j0;
                throw null;
            }
            throw new ClassCastException();
        }
    }
}
