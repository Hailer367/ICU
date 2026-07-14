package androidx.appcompat.widget;

import A2.t;
import I.T;
import M2.f;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m.InterfaceC0439c;
import o.AbstractC0472F0;
import o.C0474G0;
import o.C0489O;
import o.C0508c1;
import o.C0531n;
import o.InterfaceC0511d1;
import o.InterfaceC0514e1;
import o.ViewOnFocusChangeListenerC0502a1;
import o.ViewOnLayoutChangeListenerC0505b1;
import o.Y0;
import o.Z0;
import o.f1;
import o.g1;
import o.h1;
import o.j1;

/* loaded from: classes.dex */
public class SearchView extends AbstractC0472F0 implements InterfaceC0439c {

    /* renamed from: l0, reason: collision with root package name */
    public static final f f2366l0;

    /* renamed from: A, reason: collision with root package name */
    public final ImageView f2367A;

    /* renamed from: B, reason: collision with root package name */
    public final ImageView f2368B;

    /* renamed from: C, reason: collision with root package name */
    public final View f2369C;

    /* renamed from: D, reason: collision with root package name */
    public h1 f2370D;

    /* renamed from: E, reason: collision with root package name */
    public final Rect f2371E;

    /* renamed from: F, reason: collision with root package name */
    public final Rect f2372F;

    /* renamed from: G, reason: collision with root package name */
    public final int[] f2373G;

    /* renamed from: H, reason: collision with root package name */
    public final int[] f2374H;

    /* renamed from: I, reason: collision with root package name */
    public final ImageView f2375I;

    /* renamed from: J, reason: collision with root package name */
    public final Drawable f2376J;

    /* renamed from: K, reason: collision with root package name */
    public final int f2377K;

    /* renamed from: L, reason: collision with root package name */
    public final int f2378L;

    /* renamed from: M, reason: collision with root package name */
    public final Intent f2379M;

    /* renamed from: N, reason: collision with root package name */
    public final Intent f2380N;

    /* renamed from: O, reason: collision with root package name */
    public final CharSequence f2381O;
    public View.OnFocusChangeListener P;

    /* renamed from: Q, reason: collision with root package name */
    public View.OnClickListener f2382Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f2383R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f2384S;

    /* renamed from: T, reason: collision with root package name */
    public M.c f2385T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f2386U;

    /* renamed from: V, reason: collision with root package name */
    public CharSequence f2387V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f2388W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f2389a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f2390b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2391c0;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f2392d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f2393e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f2394f0;

    /* renamed from: g0, reason: collision with root package name */
    public SearchableInfo f2395g0;

    /* renamed from: h0, reason: collision with root package name */
    public Bundle f2396h0;

    /* renamed from: i0, reason: collision with root package name */
    public final Z0 f2397i0;

    /* renamed from: j0, reason: collision with root package name */
    public final Z0 f2398j0;

    /* renamed from: k0, reason: collision with root package name */
    public final WeakHashMap f2399k0;

    /* renamed from: u, reason: collision with root package name */
    public final SearchAutoComplete f2400u;

    /* renamed from: v, reason: collision with root package name */
    public final View f2401v;

    /* renamed from: w, reason: collision with root package name */
    public final View f2402w;

    /* renamed from: x, reason: collision with root package name */
    public final View f2403x;

    /* renamed from: y, reason: collision with root package name */
    public final ImageView f2404y;
    public final ImageView z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends C0531n {

        /* renamed from: j, reason: collision with root package name */
        public int f2405j;
        public SearchView k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f2406l;

        /* renamed from: m, reason: collision with root package name */
        public final d f2407m;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2407m = new d(this);
            this.f2405j = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i4 = configuration.screenWidthDp;
            int i5 = configuration.screenHeightDp;
            if (i4 >= 960 && i5 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i4 < 600) {
                if (i4 < 640 || i5 < 480) {
                    return 160;
                }
                return 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            f fVar = SearchView.f2366l0;
            fVar.getClass();
            f.a();
            Method method = fVar.f1056c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            if (this.f2405j > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        @Override // o.C0531n, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2406l) {
                d dVar = this.f2407m;
                removeCallbacks(dVar);
                post(dVar);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i4, Rect rect) {
            super.onFocusChanged(z, i4, rect);
            SearchView searchView = this.k;
            searchView.v(searchView.f2384S);
            searchView.post(searchView.f2397i0);
            if (searchView.f2400u.hasFocus()) {
                searchView.k();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i4, KeyEvent keyEvent) {
            if (i4 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.k.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i4, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.k.hasFocus() && getVisibility() == 0) {
                this.f2406l = true;
                Context context = getContext();
                f fVar = SearchView.f2366l0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.f2407m;
            if (!z) {
                this.f2406l = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f2406l = false;
                    removeCallbacks(dVar);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f2406l = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.k = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i4) {
            super.setThreshold(i4);
            this.f2405j = i4;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, M2.f] */
    static {
        f fVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            ?? obj = new Object();
            obj.f1054a = null;
            obj.f1055b = null;
            obj.f1056c = null;
            f.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                obj.f1054a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                obj.f1055b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                obj.f1056c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            fVar = obj;
        }
        f2366l0 = fVar;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        int length;
        SearchAutoComplete searchAutoComplete = this.f2400u;
        searchAutoComplete.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        searchAutoComplete.setSelection(length);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f2389a0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f2400u;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f2389a0 = false;
    }

    public int getImeOptions() {
        return this.f2400u.getImeOptions();
    }

    public int getInputType() {
        return this.f2400u.getInputType();
    }

    public int getMaxWidth() {
        return this.f2390b0;
    }

    public CharSequence getQuery() {
        return this.f2400u.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f2387V;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2395g0;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.f2395g0.getHintId());
        }
        return this.f2381O;
    }

    public int getSuggestionCommitIconResId() {
        return this.f2378L;
    }

    public int getSuggestionRowLayout() {
        return this.f2377K;
    }

    public M.c getSuggestionsAdapter() {
        return this.f2385T;
    }

    public final Intent i(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2392d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2396h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f2395g0.getSearchActivity());
        return intent;
    }

    public final Intent j(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i4;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2396h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i4 = searchableInfo.getVoiceMaxResults();
        } else {
            i4 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i4);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void k() {
        int i4 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f2400u;
        if (i4 >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        f fVar = f2366l0;
        fVar.getClass();
        f.a();
        Method method = fVar.f1054a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        fVar.getClass();
        f.a();
        Method method2 = fVar.f1055b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void l() {
        SearchAutoComplete searchAutoComplete = this.f2400u;
        if (TextUtils.isEmpty(searchAutoComplete.getText())) {
            if (this.f2383R) {
                clearFocus();
                v(true);
                return;
            }
            return;
        }
        searchAutoComplete.setText("");
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
    }

    public final void m(int i4) {
        int i5;
        Uri parse;
        String h3;
        Cursor cursor = this.f2385T.f1027h;
        if (cursor != null && cursor.moveToPosition(i4)) {
            Intent intent = null;
            try {
                int i6 = j1.f5620C;
                String h4 = j1.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (h4 == null) {
                    h4 = this.f2395g0.getSuggestIntentAction();
                }
                if (h4 == null) {
                    h4 = "android.intent.action.SEARCH";
                }
                String h5 = j1.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (h5 == null) {
                    h5 = this.f2395g0.getSuggestIntentData();
                }
                if (h5 != null && (h3 = j1.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    h5 = h5 + "/" + Uri.encode(h3);
                }
                if (h5 == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(h5);
                }
                intent = i(h4, parse, j1.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), j1.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e4) {
                try {
                    i5 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i5 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i5 + " returned exception.", e4);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e5) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e5);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f2400u;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void n(int i4) {
        Editable text = this.f2400u.getText();
        Cursor cursor = this.f2385T.f1027h;
        if (cursor != null) {
            if (cursor.moveToPosition(i4)) {
                String c4 = this.f2385T.c(cursor);
                if (c4 != null) {
                    setQuery(c4);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    public final void o(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // m.InterfaceC0439c
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.f2400u;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f2392d0 = "";
        clearFocus();
        v(true);
        searchAutoComplete.setImeOptions(this.f2394f0);
        this.f2393e0 = false;
    }

    @Override // m.InterfaceC0439c
    public final void onActionViewExpanded() {
        if (this.f2393e0) {
            return;
        }
        this.f2393e0 = true;
        SearchAutoComplete searchAutoComplete = this.f2400u;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f2394f0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f2397i0);
        post(this.f2398j0);
        super.onDetachedFromWindow();
    }

    @Override // o.AbstractC0472F0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        super.onLayout(z, i4, i5, i6, i7);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.f2400u;
            int[] iArr = this.f2373G;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f2374H;
            getLocationInWindow(iArr2);
            int i8 = iArr[1] - iArr2[1];
            int i9 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i9;
            int height = searchAutoComplete.getHeight() + i8;
            Rect rect = this.f2371E;
            rect.set(i9, i8, width, height);
            int i10 = rect.left;
            int i11 = rect.right;
            int i12 = i7 - i5;
            Rect rect2 = this.f2372F;
            rect2.set(i10, 0, i11, i12);
            h1 h1Var = this.f2370D;
            if (h1Var == null) {
                h1 h1Var2 = new h1(rect2, rect, searchAutoComplete);
                this.f2370D = h1Var2;
                setTouchDelegate(h1Var2);
            } else {
                h1Var.f5588b.set(rect2);
                Rect rect3 = h1Var.f5590d;
                rect3.set(rect2);
                int i13 = -h1Var.f5591e;
                rect3.inset(i13, i13);
                h1Var.f5589c.set(rect);
            }
        }
    }

    @Override // o.AbstractC0472F0, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f2384S) {
            super.onMeasure(i4, i5);
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i6 = this.f2390b0) > 0) {
                    size = Math.min(i6, size);
                }
            } else {
                size = this.f2390b0;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i7 = this.f2390b0;
            size = i7 > 0 ? Math.min(i7, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g1 g1Var = (g1) parcelable;
        super.onRestoreInstanceState(g1Var.f1062f);
        v(g1Var.f5584h);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [N.c, android.os.Parcelable, o.g1] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? cVar = new N.c(super.onSaveInstanceState());
        cVar.f5584h = this.f2384S;
        return cVar;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.f2397i0);
    }

    public final void p() {
        SearchAutoComplete searchAutoComplete = this.f2400u;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f2395g0 != null) {
                getContext().startActivity(i("android.intent.action.SEARCH", null, null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    public final void q() {
        int i4;
        int[] iArr;
        boolean isEmpty = TextUtils.isEmpty(this.f2400u.getText());
        if (isEmpty && (!this.f2383R || this.f2393e0)) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        ImageView imageView = this.f2367A;
        imageView.setVisibility(i4);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (!isEmpty) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    public final void r() {
        int[] iArr;
        if (this.f2400u.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f2402w.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2403x.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i4, Rect rect) {
        if (this.f2389a0 || !isFocusable()) {
            return false;
        }
        if (!this.f2384S) {
            boolean requestFocus = this.f2400u.requestFocus(i4, rect);
            if (requestFocus) {
                v(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i4, rect);
    }

    public final void s() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z = this.f2383R;
        SearchAutoComplete searchAutoComplete = this.f2400u;
        if (z && (drawable = this.f2376J) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2396h0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            l();
            return;
        }
        v(false);
        SearchAutoComplete searchAutoComplete = this.f2400u;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f2382Q;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f2383R == z) {
            return;
        }
        this.f2383R = z;
        v(z);
        s();
    }

    public void setImeOptions(int i4) {
        this.f2400u.setImeOptions(i4);
    }

    public void setInputType(int i4) {
        this.f2400u.setInputType(i4);
    }

    public void setMaxWidth(int i4) {
        this.f2390b0 = i4;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.P = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2382Q = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2387V = charSequence;
        s();
    }

    public void setQueryRefinementEnabled(boolean z) {
        int i4;
        this.f2388W = z;
        M.c cVar = this.f2385T;
        if (cVar instanceof j1) {
            j1 j1Var = (j1) cVar;
            if (z) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            j1Var.f5631u = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        if (getContext().getPackageManager().resolveActivity(r0, 65536) != null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f2395g0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.f2400u
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f2395g0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f2395g0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f2395g0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            M.c r7 = r6.f2385T
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f2395g0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            o.j1 r7 = new o.j1
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f2395g0
            java.util.WeakHashMap r5 = r6.f2399k0
            r7.<init>(r3, r6, r4, r5)
            r6.f2385T = r7
            r2.setAdapter(r7)
            M.c r7 = r6.f2385T
            o.j1 r7 = (o.j1) r7
            boolean r3 = r6.f2388W
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.f5631u = r3
        L62:
            r6.s()
        L65:
            android.app.SearchableInfo r7 = r6.f2395g0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f2395g0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.f2379M
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f2395g0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.f2380N
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.f2391c0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.f2384S
            r6.v(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f2386U = z;
        v(this.f2384S);
    }

    public void setSuggestionsAdapter(M.c cVar) {
        this.f2385T = cVar;
        this.f2400u.setAdapter(cVar);
    }

    public final void t() {
        int i4;
        if ((this.f2386U || this.f2391c0) && !this.f2384S && (this.z.getVisibility() == 0 || this.f2368B.getVisibility() == 0)) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        this.f2403x.setVisibility(i4);
    }

    public final void u(boolean z) {
        int i4;
        boolean z3 = this.f2386U;
        if (z3 && ((z3 || this.f2391c0) && !this.f2384S && hasFocus() && (z || !this.f2391c0))) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        this.z.setVisibility(i4);
    }

    public final void v(boolean z) {
        int i4;
        int i5;
        int i6;
        this.f2384S = z;
        int i7 = 8;
        if (z) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f2400u.getText());
        this.f2404y.setVisibility(i4);
        u(!isEmpty);
        if (z) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        this.f2401v.setVisibility(i5);
        ImageView imageView = this.f2375I;
        if (imageView.getDrawable() != null && !this.f2383R) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        imageView.setVisibility(i6);
        q();
        if (this.f2391c0 && !this.f2384S && isEmpty) {
            this.z.setVisibility(8);
            i7 = 0;
        }
        this.f2368B.setVisibility(i7);
        t();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2371E = new Rect();
        this.f2372F = new Rect();
        this.f2373G = new int[2];
        this.f2374H = new int[2];
        this.f2397i0 = new Z0(this, 0);
        this.f2398j0 = new Z0(this, 1);
        this.f2399k0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        C0508c1 c0508c1 = new C0508c1(this);
        C0489O c0489o = new C0489O(1, this);
        C0474G0 c0474g0 = new C0474G0(1, this);
        Y0 y02 = new Y0(this);
        int[] iArr = AbstractC0357a.f4085u;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        t tVar = new t(context, obtainStyledAttributes);
        T.h(this, context, iArr, attributeSet, obtainStyledAttributes, i4);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f2400u = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f2401v = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.f2402w = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.f2403x = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f2404y = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.z = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f2367A = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f2368B = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f2375I = imageView5;
        findViewById.setBackground(tVar.H(10));
        findViewById2.setBackground(tVar.H(14));
        imageView.setImageDrawable(tVar.H(13));
        imageView2.setImageDrawable(tVar.H(7));
        imageView3.setImageDrawable(tVar.H(4));
        imageView4.setImageDrawable(tVar.H(16));
        imageView5.setImageDrawable(tVar.H(13));
        this.f2376J = tVar.H(12);
        AbstractC0286a.H(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f2377K = obtainStyledAttributes.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.f2378L = obtainStyledAttributes.getResourceId(5, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(y02);
        searchAutoComplete.setOnEditorActionListener(c0508c1);
        searchAutoComplete.setOnItemClickListener(c0489o);
        searchAutoComplete.setOnItemSelectedListener(c0474g0);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0502a1(this));
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(8, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f2381O = obtainStyledAttributes.getText(6);
        this.f2387V = obtainStyledAttributes.getText(11);
        int i5 = obtainStyledAttributes.getInt(3, -1);
        if (i5 != -1) {
            setImeOptions(i5);
        }
        int i6 = obtainStyledAttributes.getInt(2, -1);
        if (i6 != -1) {
            setInputType(i6);
        }
        setFocusable(obtainStyledAttributes.getBoolean(0, true));
        tVar.T();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f2379M = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f2380N = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2369C = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0505b1(this));
        }
        v(this.f2383R);
        s();
    }

    public void setOnCloseListener(InterfaceC0511d1 interfaceC0511d1) {
    }

    public void setOnQueryTextListener(InterfaceC0514e1 interfaceC0514e1) {
    }

    public void setOnSuggestionListener(f1 f1Var) {
    }
}
