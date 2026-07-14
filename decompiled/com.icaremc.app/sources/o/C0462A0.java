package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.icaremc.app.R;
import java.lang.reflect.InvocationTargetException;

/* renamed from: o.A0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0462A0 extends ListView {

    /* renamed from: f, reason: collision with root package name */
    public final Rect f5392f;

    /* renamed from: g, reason: collision with root package name */
    public int f5393g;

    /* renamed from: h, reason: collision with root package name */
    public int f5394h;

    /* renamed from: i, reason: collision with root package name */
    public int f5395i;

    /* renamed from: j, reason: collision with root package name */
    public int f5396j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public C0554y0 f5397l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5398m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f5399n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5400o;

    /* renamed from: p, reason: collision with root package name */
    public L.c f5401p;

    /* renamed from: q, reason: collision with root package name */
    public F.b f5402q;

    public C0462A0(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f5392f = new Rect();
        this.f5393g = 0;
        this.f5394h = 0;
        this.f5395i = 0;
        this.f5396j = 0;
        this.f5399n = z;
        setCacheColorHint(0);
    }

    public final int a(int i4, int i5) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i7 = 0;
        View view = null;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            if (i9 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i4, makeMeasureSpec);
            view.forceLayout();
            if (i8 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i5) {
                return i5;
            }
        }
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x014d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r18, android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0462A0.b(int, android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f5392f;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f5402q == null) {
            super.drawableStateChanged();
            C0554y0 c0554y0 = this.f5397l;
            if (c0554y0 != null) {
                c0554y0.f5752g = true;
            }
            Drawable selector = getSelector();
            if (selector != null && this.f5400o && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        if (!this.f5399n && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        if (!this.f5399n && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean isFocused() {
        if (!this.f5399n && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        if ((this.f5399n && this.f5398m) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f5402q = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f5402q == null) {
            F.b bVar = new F.b(15, this);
            this.f5402q = bVar;
            post(bVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return onHoverEvent;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i4 >= 30 && AbstractC0550w0.f5728d) {
                    try {
                        AbstractC0550w0.f5725a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                        AbstractC0550w0.f5726b.invoke(this, Integer.valueOf(pointToPosition));
                        AbstractC0550w0.f5727c.invoke(this, Integer.valueOf(pointToPosition));
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                } else {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f5400o && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.k = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        F.b bVar = this.f5402q;
        if (bVar != null) {
            C0462A0 c0462a0 = (C0462A0) bVar.f483g;
            c0462a0.f5402q = null;
            c0462a0.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f5398m = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [o.y0, android.graphics.drawable.Drawable$Callback, android.graphics.drawable.Drawable] */
    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0554y0 c0554y0 = null;
        if (drawable != 0) {
            ?? drawable2 = new Drawable();
            Drawable drawable3 = drawable2.f5751f;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            drawable2.f5751f = drawable;
            drawable.setCallback(drawable2);
            drawable2.f5752g = true;
            c0554y0 = drawable2;
        }
        this.f5397l = c0554y0;
        super.setSelector(c0554y0);
        Rect rect = new Rect();
        if (drawable != 0) {
            drawable.getPadding(rect);
        }
        this.f5393g = rect.left;
        this.f5394h = rect.top;
        this.f5395i = rect.right;
        this.f5396j = rect.bottom;
    }
}
