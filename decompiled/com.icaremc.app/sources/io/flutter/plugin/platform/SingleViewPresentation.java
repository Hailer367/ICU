package io.flutter.plugin.platform;

import android.app.Presentation;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;

/* JADX INFO: Access modifiers changed from: package-private */
@Keep
/* loaded from: classes.dex */
public class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final C0377a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private u rootView;
    private boolean startFocused;
    private final x state;
    private int viewId;

    /* JADX WARN: Type inference failed for: r3v1, types: [io.flutter.plugin.platform.x, java.lang.Object] */
    public SingleViewPresentation(Context context, Display display, InterfaceC0382f interfaceC0382f, C0377a c0377a, int i4, View.OnFocusChangeListener onFocusChangeListener) {
        super(new v(context, null), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c0377a;
        this.viewId = i4;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        ?? obj = new Object();
        this.state = obj;
        obj.f4400a = interfaceC0382f;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public x detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        u uVar = this.rootView;
        if (uVar != null) {
            uVar.removeAllViews();
        }
        return this.state;
    }

    public InterfaceC0382f getView() {
        return this.state.f4400a;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        x xVar = this.state;
        if (xVar.f4402c == null) {
            xVar.f4402c = new t(getContext());
        }
        if (this.state.f4401b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            x xVar2 = this.state;
            xVar2.f4401b = new F(windowManager, xVar2.f4402c);
        }
        this.container = new FrameLayout(getContext());
        w wVar = new w(getContext(), this.state.f4401b, this.outerContext);
        View view = this.state.f4400a.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) view.getContext()).setBaseContext(wVar);
        } else {
            Log.w(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(view);
        u uVar = new u(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = uVar;
        uVar.addView(this.container);
        this.rootView.addView(this.state.f4402c);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, C0377a c0377a, x xVar, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new v(context, null), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c0377a;
        this.state = xVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }
}
