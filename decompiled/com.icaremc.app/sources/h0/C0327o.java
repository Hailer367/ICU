package h0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: h0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0327o {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0333u f3924a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3925b;

    public C0327o(AbstractC0333u abstractC0333u, int i4) {
        this.f3925b = i4;
        new Rect();
        this.f3924a = abstractC0333u;
    }

    public static C0327o a(AbstractC0333u abstractC0333u, int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                return new C0327o(abstractC0333u, 1);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new C0327o(abstractC0333u, 0);
    }

    public final int b(View view) {
        int right;
        int i4;
        switch (this.f3925b) {
            case 0:
                C0334v c0334v = (C0334v) view.getLayoutParams();
                this.f3924a.getClass();
                right = view.getRight() + ((C0334v) view.getLayoutParams()).f3937a.right;
                i4 = ((ViewGroup.MarginLayoutParams) c0334v).rightMargin;
                break;
            default:
                C0334v c0334v2 = (C0334v) view.getLayoutParams();
                this.f3924a.getClass();
                right = view.getBottom() + ((C0334v) view.getLayoutParams()).f3937a.bottom;
                i4 = ((ViewGroup.MarginLayoutParams) c0334v2).bottomMargin;
                break;
        }
        return right + i4;
    }

    public final int c(View view) {
        int left;
        int i4;
        switch (this.f3925b) {
            case 0:
                C0334v c0334v = (C0334v) view.getLayoutParams();
                this.f3924a.getClass();
                left = view.getLeft() - ((C0334v) view.getLayoutParams()).f3937a.left;
                i4 = ((ViewGroup.MarginLayoutParams) c0334v).leftMargin;
                break;
            default:
                C0334v c0334v2 = (C0334v) view.getLayoutParams();
                this.f3924a.getClass();
                left = view.getTop() - ((C0334v) view.getLayoutParams()).f3937a.top;
                i4 = ((ViewGroup.MarginLayoutParams) c0334v2).topMargin;
                break;
        }
        return left - i4;
    }

    public final int d() {
        int i4;
        int t3;
        switch (this.f3925b) {
            case 0:
                AbstractC0333u abstractC0333u = this.f3924a;
                i4 = abstractC0333u.f3935f;
                t3 = abstractC0333u.t();
                break;
            default:
                AbstractC0333u abstractC0333u2 = this.f3924a;
                i4 = abstractC0333u2.f3936g;
                t3 = abstractC0333u2.r();
                break;
        }
        return i4 - t3;
    }

    public final int e() {
        switch (this.f3925b) {
            case 0:
                return this.f3924a.s();
            default:
                return this.f3924a.u();
        }
    }
}
