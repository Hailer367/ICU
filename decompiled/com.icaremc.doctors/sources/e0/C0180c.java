package e0;

import E.J;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.reflect.Field;

/* renamed from: e0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0180c extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2181a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0180c(String str, int i2, Class cls) {
        super(cls, str);
        this.f2181a = i2;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f2181a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(A.f2157a.C((View) obj));
            case 6:
                Field field = J.f180a;
                return ((View) obj).getClipBounds();
            default:
                return Float.valueOf(((SwitchCompat) obj).z);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f2181a) {
            case 0:
                C0183f c0183f = (C0183f) obj;
                PointF pointF = (PointF) obj2;
                c0183f.getClass();
                c0183f.f2184a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                c0183f.f2185b = round;
                int i2 = c0183f.f2189f + 1;
                c0183f.f2189f = i2;
                if (i2 == c0183f.f2190g) {
                    A.a(c0183f.f2188e, c0183f.f2184a, round, c0183f.f2186c, c0183f.f2187d);
                    c0183f.f2189f = 0;
                    c0183f.f2190g = 0;
                    return;
                }
                return;
            case 1:
                C0183f c0183f2 = (C0183f) obj;
                PointF pointF2 = (PointF) obj2;
                c0183f2.getClass();
                c0183f2.f2186c = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                c0183f2.f2187d = round2;
                int i3 = c0183f2.f2190g + 1;
                c0183f2.f2190g = i3;
                if (c0183f2.f2189f == i3) {
                    A.a(c0183f2.f2188e, c0183f2.f2184a, c0183f2.f2185b, c0183f2.f2186c, round2);
                    c0183f2.f2189f = 0;
                    c0183f2.f2190g = 0;
                    return;
                }
                return;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                A.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                return;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                A.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                return;
            case 4:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int round3 = Math.round(pointF5.x);
                int round4 = Math.round(pointF5.y);
                A.a(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                return;
            case 5:
                float floatValue = ((Float) obj2).floatValue();
                A.f2157a.P((View) obj, floatValue);
                return;
            case 6:
                Field field = J.f180a;
                ((View) obj).setClipBounds((Rect) obj2);
                return;
            default:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                return;
        }
    }
}
