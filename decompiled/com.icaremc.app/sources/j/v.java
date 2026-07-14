package j;

import android.content.Context;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;
import m.AbstractC0438b;
import t.C0661j;

/* loaded from: classes.dex */
public final class v implements Window.Callback {

    /* renamed from: f, reason: collision with root package name */
    public final Window.Callback f5008f;

    /* renamed from: g, reason: collision with root package name */
    public C0402J f5009g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5010h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5011i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5012j;
    public final /* synthetic */ LayoutInflaterFactory2C0393A k;

    public v(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A, Window.Callback callback) {
        this.k = layoutInflaterFactory2C0393A;
        if (callback != null) {
            this.f5008f = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final void a(Window.Callback callback) {
        try {
            this.f5010h = true;
            callback.onContentChanged();
        } finally {
            this.f5010h = false;
        }
    }

    public final boolean b(int i4, Menu menu) {
        return this.f5008f.onMenuOpened(i4, menu);
    }

    public final void c(int i4, Menu menu) {
        this.f5008f.onPanelClosed(i4, menu);
    }

    public final void d(List list, Menu menu, int i4) {
        m.m.a(this.f5008f, list, menu, i4);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f5008f.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.f5011i;
        Window.Callback callback = this.f5008f;
        if (z) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        if (!this.k.v(keyEvent) && !callback.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.f5008f.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.k;
            layoutInflaterFactory2C0393A.B();
            AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
            if (abstractC0406a == null || !abstractC0406a.k(keyCode, keyEvent)) {
                z zVar = layoutInflaterFactory2C0393A.f4842R;
                if (zVar != null && layoutInflaterFactory2C0393A.G(zVar, keyEvent.getKeyCode(), keyEvent)) {
                    z zVar2 = layoutInflaterFactory2C0393A.f4842R;
                    if (zVar2 != null) {
                        zVar2.f5029l = true;
                        return true;
                    }
                } else {
                    if (layoutInflaterFactory2C0393A.f4842R == null) {
                        z A3 = layoutInflaterFactory2C0393A.A(0);
                        layoutInflaterFactory2C0393A.H(A3, keyEvent);
                        boolean G3 = layoutInflaterFactory2C0393A.G(A3, keyEvent.getKeyCode(), keyEvent);
                        A3.k = false;
                        if (G3) {
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f5008f.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f5008f.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f5008f.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f5008f.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f5008f.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f5008f.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f5010h) {
            this.f5008f.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 == 0 && !(menu instanceof n.n)) {
            return false;
        }
        return this.f5008f.onCreatePanelMenu(i4, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i4) {
        View view;
        C0402J c0402j = this.f5009g;
        if (c0402j != null) {
            if (i4 == 0) {
                view = new View(c0402j.f4893a.f4894a.f5734a.getContext());
            } else {
                view = null;
            }
            if (view != null) {
                return view;
            }
        }
        return this.f5008f.onCreatePanelView(i4);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f5008f.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        return this.f5008f.onMenuItemSelected(i4, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i4, Menu menu) {
        b(i4, menu);
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.k;
        if (i4 == 108) {
            layoutInflaterFactory2C0393A.B();
            AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
            if (abstractC0406a != null) {
                abstractC0406a.c(true);
            }
        } else {
            layoutInflaterFactory2C0393A.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i4, Menu menu) {
        if (this.f5012j) {
            this.f5008f.onPanelClosed(i4, menu);
            return;
        }
        c(i4, menu);
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.k;
        if (i4 == 108) {
            layoutInflaterFactory2C0393A.B();
            AbstractC0406a abstractC0406a = layoutInflaterFactory2C0393A.f4868t;
            if (abstractC0406a != null) {
                abstractC0406a.c(false);
                return;
            }
            return;
        }
        if (i4 == 0) {
            z A3 = layoutInflaterFactory2C0393A.A(i4);
            if (A3.f5030m) {
                layoutInflaterFactory2C0393A.t(A3, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        m.n.a(this.f5008f, z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i4, View view, Menu menu) {
        n.n nVar;
        if (menu instanceof n.n) {
            nVar = (n.n) menu;
        } else {
            nVar = null;
        }
        if (i4 == 0 && nVar == null) {
            return false;
        }
        if (nVar != null) {
            nVar.f5317y = true;
        }
        C0402J c0402j = this.f5009g;
        if (c0402j != null && i4 == 0) {
            C0403K c0403k = c0402j.f4893a;
            if (!c0403k.f4897d) {
                c0403k.f4894a.f5744l = true;
                c0403k.f4897d = true;
            }
        }
        boolean onPreparePanel = this.f5008f.onPreparePanel(i4, view, menu);
        if (nVar != null) {
            nVar.f5317y = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i4) {
        n.n nVar = this.k.A(0).f5026h;
        if (nVar != null) {
            d(list, nVar, i4);
        } else {
            d(list, menu, i4);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return m.l.a(this.f5008f, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f5008f.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.f5008f.onWindowFocusChanged(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [m.a, P1.y, java.lang.Object] */
    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i4) {
        if (i4 != 0) {
            return m.l.b(this.f5008f, callback, i4);
        }
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.k;
        Context context = layoutInflaterFactory2C0393A.f4864p;
        ?? obj = new Object();
        obj.f1470g = context;
        obj.f1469f = callback;
        obj.f1471h = new ArrayList();
        obj.f1472i = new C0661j(0);
        AbstractC0438b n3 = layoutInflaterFactory2C0393A.n(obj);
        if (n3 != null) {
            return obj.g(n3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f5008f.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
