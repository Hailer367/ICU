package E;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: E.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0017q {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f246a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f247b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f248c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f249d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f250e;

    public C0017q(ViewGroup viewGroup) {
        this.f248c = viewGroup;
    }

    public final boolean a(float f2, float f3, boolean z) {
        ViewParent e2;
        if (this.f249d && (e2 = e(0)) != null) {
            try {
                return e2.onNestedFling(this.f248c, f2, f3, z);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + e2 + " does not implement interface method onNestedFling", e3);
            }
        }
        return false;
    }

    public final boolean b(float f2, float f3) {
        ViewParent e2;
        if (this.f249d && (e2 = e(0)) != null) {
            try {
                return e2.onNestedPreFling(this.f248c, f2, f3);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + e2 + " does not implement interface method onNestedPreFling", e3);
            }
        }
        return false;
    }

    public final boolean c(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        ViewParent e2;
        int i5;
        int i6;
        if (!this.f249d || (e2 = e(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f248c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            if (this.f250e == null) {
                this.f250e = new int[2];
            }
            iArr = this.f250e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        if (e2 instanceof r) {
            ((r) e2).d(i2, i3, iArr, i4);
        } else if (i4 == 0) {
            try {
                e2.onNestedPreScroll(viewGroup, i2, i3, iArr);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + e2 + " does not implement interface method onNestedPreScroll", e3);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public final boolean d(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent e2;
        int i7;
        int i8;
        int[] iArr3;
        if (this.f249d && (e2 = e(i6)) != null) {
            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                if (iArr != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    return false;
                }
            } else {
                ViewGroup viewGroup = this.f248c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i7 = iArr[0];
                    i8 = iArr[1];
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                if (iArr2 == null) {
                    if (this.f250e == null) {
                        this.f250e = new int[2];
                    }
                    int[] iArr4 = this.f250e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (e2 instanceof InterfaceC0018s) {
                    ((InterfaceC0018s) e2).e(viewGroup, i2, i3, i4, i5, i6, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i4;
                    iArr3[1] = iArr3[1] + i5;
                    if (e2 instanceof r) {
                        ((r) e2).b(viewGroup, i2, i3, i4, i5, i6);
                    } else if (i6 == 0) {
                        try {
                            e2.onNestedScroll(viewGroup, i2, i3, i4, i5);
                        } catch (AbstractMethodError e3) {
                            Log.e("ViewParentCompat", "ViewParent " + e2 + " does not implement interface method onNestedScroll", e3);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i7;
                    iArr[1] = iArr[1] - i8;
                }
                return true;
            }
        }
        return false;
    }

    public final ViewParent e(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return this.f247b;
        }
        return this.f246a;
    }

    public final boolean f(int i2) {
        if (e(i2) != null) {
            return true;
        }
        return false;
    }

    public final boolean g(int i2, int i3) {
        boolean onStartNestedScroll;
        if (!f(i3)) {
            if (this.f249d) {
                View view = this.f248c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof r;
                    if (z) {
                        onStartNestedScroll = ((r) parent).f(view2, view, i2, i3);
                    } else {
                        if (i3 == 0) {
                            try {
                                onStartNestedScroll = parent.onStartNestedScroll(view2, view, i2);
                            } catch (AbstractMethodError e2) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e2);
                            }
                        }
                        onStartNestedScroll = false;
                    }
                    if (onStartNestedScroll) {
                        if (i3 != 0) {
                            if (i3 == 1) {
                                this.f247b = parent;
                            }
                        } else {
                            this.f246a = parent;
                        }
                        if (z) {
                            ((r) parent).a(view2, view, i2, i3);
                        } else if (i3 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i2);
                            } catch (AbstractMethodError e3) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e3);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i2) {
        ViewParent e2 = e(i2);
        if (e2 != null) {
            boolean z = e2 instanceof r;
            ViewGroup viewGroup = this.f248c;
            if (z) {
                ((r) e2).c(viewGroup, i2);
            } else if (i2 == 0) {
                try {
                    e2.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewParentCompat", "ViewParent " + e2 + " does not implement interface method onStopNestedScroll", e3);
                }
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f247b = null;
                    return;
                }
                return;
            }
            this.f246a = null;
        }
    }
}
