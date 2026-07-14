package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import i.AbstractC0357a;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: f, reason: collision with root package name */
    public final int f2260f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2261g;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4084t);
        this.f2261g = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f2260f = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
