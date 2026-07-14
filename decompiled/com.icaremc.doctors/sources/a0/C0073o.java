package a0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0073o {

    /* renamed from: a, reason: collision with root package name */
    public final v f998a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f999b;

    public C0073o(v vVar, int i2) {
        this.f999b = i2;
        new Rect();
        this.f998a = vVar;
    }

    public static C0073o a(v vVar, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return new C0073o(vVar, 1);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new C0073o(vVar, 0);
    }

    public final int b(View view) {
        int right;
        int i2;
        switch (this.f999b) {
            case 0:
                w wVar = (w) view.getLayoutParams();
                this.f998a.getClass();
                right = view.getRight() + ((w) view.getLayoutParams()).f1013a.right;
                i2 = ((ViewGroup.MarginLayoutParams) wVar).rightMargin;
                break;
            default:
                w wVar2 = (w) view.getLayoutParams();
                this.f998a.getClass();
                right = view.getBottom() + ((w) view.getLayoutParams()).f1013a.bottom;
                i2 = ((ViewGroup.MarginLayoutParams) wVar2).bottomMargin;
                break;
        }
        return right + i2;
    }

    public final int c(View view) {
        int left;
        int i2;
        switch (this.f999b) {
            case 0:
                w wVar = (w) view.getLayoutParams();
                this.f998a.getClass();
                left = view.getLeft() - ((w) view.getLayoutParams()).f1013a.left;
                i2 = ((ViewGroup.MarginLayoutParams) wVar).leftMargin;
                break;
            default:
                w wVar2 = (w) view.getLayoutParams();
                this.f998a.getClass();
                left = view.getTop() - ((w) view.getLayoutParams()).f1013a.top;
                i2 = ((ViewGroup.MarginLayoutParams) wVar2).topMargin;
                break;
        }
        return left - i2;
    }

    public final int d() {
        int i2;
        int t2;
        switch (this.f999b) {
            case 0:
                v vVar = this.f998a;
                i2 = vVar.f1011f;
                t2 = vVar.t();
                break;
            default:
                v vVar2 = this.f998a;
                i2 = vVar2.f1012g;
                t2 = vVar2.r();
                break;
        }
        return i2 - t2;
    }

    public final int e() {
        switch (this.f999b) {
            case 0:
                return this.f998a.s();
            default:
                return this.f998a.u();
        }
    }
}
