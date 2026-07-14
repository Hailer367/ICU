package androidx.appcompat.widget;

import A0.g;
import E.J;
import V0.f;
import a.AbstractC0051a;
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
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import h.AbstractC0201a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k.InterfaceC0217a;
import m.AbstractC0252E;
import m.AbstractC0265l;
import m.C0253F;
import m.S;
import m.T;
import m.U;
import m.V;
import m.W;
import m.X;
import m.Y;
import m.Z;
import m.a0;
import m.b0;
import m.c0;
import m.e0;

/* loaded from: classes.dex */
public class SearchView extends AbstractC0252E implements InterfaceC0217a {

    /* renamed from: i0, reason: collision with root package name */
    public static final f f1142i0;

    /* renamed from: A, reason: collision with root package name */
    public c0 f1143A;

    /* renamed from: B, reason: collision with root package name */
    public final Rect f1144B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f1145C;

    /* renamed from: D, reason: collision with root package name */
    public final int[] f1146D;

    /* renamed from: E, reason: collision with root package name */
    public final int[] f1147E;

    /* renamed from: F, reason: collision with root package name */
    public final ImageView f1148F;

    /* renamed from: G, reason: collision with root package name */
    public final Drawable f1149G;

    /* renamed from: H, reason: collision with root package name */
    public final int f1150H;

    /* renamed from: I, reason: collision with root package name */
    public final int f1151I;

    /* renamed from: J, reason: collision with root package name */
    public final Intent f1152J;

    /* renamed from: K, reason: collision with root package name */
    public final Intent f1153K;
    public final CharSequence L;

    /* renamed from: M, reason: collision with root package name */
    public View.OnFocusChangeListener f1154M;

    /* renamed from: N, reason: collision with root package name */
    public View.OnClickListener f1155N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f1156O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f1157P;

    /* renamed from: Q, reason: collision with root package name */
    public I.c f1158Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f1159R;

    /* renamed from: S, reason: collision with root package name */
    public CharSequence f1160S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f1161T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f1162U;

    /* renamed from: V, reason: collision with root package name */
    public int f1163V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f1164W;

    /* renamed from: a0, reason: collision with root package name */
    public CharSequence f1165a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f1166b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1167c0;

    /* renamed from: d0, reason: collision with root package name */
    public SearchableInfo f1168d0;

    /* renamed from: e0, reason: collision with root package name */
    public Bundle f1169e0;

    /* renamed from: f0, reason: collision with root package name */
    public final T f1170f0;

    /* renamed from: g0, reason: collision with root package name */
    public final T f1171g0;

    /* renamed from: h0, reason: collision with root package name */
    public final WeakHashMap f1172h0;

    /* renamed from: r, reason: collision with root package name */
    public final SearchAutoComplete f1173r;

    /* renamed from: s, reason: collision with root package name */
    public final View f1174s;

    /* renamed from: t, reason: collision with root package name */
    public final View f1175t;

    /* renamed from: u, reason: collision with root package name */
    public final View f1176u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f1177v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f1178w;

    /* renamed from: x, reason: collision with root package name */
    public final ImageView f1179x;
    public final ImageView y;
    public final View z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AbstractC0265l {

        /* renamed from: f, reason: collision with root package name */
        public int f1180f;

        /* renamed from: g, reason: collision with root package name */
        public SearchView f1181g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f1182h;

        /* renamed from: i, reason: collision with root package name */
        public final c f1183i;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1183i = new c(this);
            this.f1180f = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 < 600) {
                if (i2 < 640 || i3 < 480) {
                    return 160;
                }
                return 192;
            }
            return 192;
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            if (this.f1180f > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        @Override // m.AbstractC0265l, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1182h) {
                c cVar = this.f1183i;
                removeCallbacks(cVar);
                post(cVar);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            SearchView searchView = this.f1181g;
            searchView.u(searchView.f1157P);
            searchView.post(searchView.f1170f0);
            if (searchView.f1173r.hasFocus()) {
                searchView.j();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
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
                        this.f1181g.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            Method method;
            super.onWindowFocusChanged(z);
            if (z && this.f1181g.hasFocus() && getVisibility() == 0) {
                this.f1182h = true;
                Context context = getContext();
                f fVar = SearchView.f1142i0;
                if (context.getResources().getConfiguration().orientation == 2 && (method = SearchView.f1142i0.f786c) != null) {
                    try {
                        method.invoke(this, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
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
            c cVar = this.f1183i;
            if (!z) {
                this.f1182h = false;
                removeCallbacks(cVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f1182h = false;
                    removeCallbacks(cVar);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f1182h = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1181g = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f1180f = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [V0.f, java.lang.Object] */
    static {
        ?? obj = new Object();
        try {
            Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
            obj.f784a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        try {
            Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
            obj.f785b = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
            obj.f786c = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused3) {
        }
        f1142i0 = obj;
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
        SearchAutoComplete searchAutoComplete = this.f1173r;
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
        this.f1162U = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f1173r;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f1162U = false;
    }

    public int getImeOptions() {
        return this.f1173r.getImeOptions();
    }

    public int getInputType() {
        return this.f1173r.getInputType();
    }

    public int getMaxWidth() {
        return this.f1163V;
    }

    public CharSequence getQuery() {
        return this.f1173r.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1160S;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1168d0;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.f1168d0.getHintId());
        }
        return this.L;
    }

    public int getSuggestionCommitIconResId() {
        return this.f1151I;
    }

    public int getSuggestionRowLayout() {
        return this.f1150H;
    }

    public I.c getSuggestionsAdapter() {
        return this.f1158Q;
    }

    public final Intent h(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1165a0);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1169e0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f1168d0.getSearchActivity());
        return intent;
    }

    public final Intent i(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i2;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1169e0;
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
            i2 = searchableInfo.getVoiceMaxResults();
        } else {
            i2 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void j() {
        int i2 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f1173r;
        if (i2 >= 29) {
            searchAutoComplete.refreshAutoCompleteResults();
            return;
        }
        f fVar = f1142i0;
        Method method = fVar.f784a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        Method method2 = fVar.f785b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void k() {
        SearchAutoComplete searchAutoComplete = this.f1173r;
        if (TextUtils.isEmpty(searchAutoComplete.getText())) {
            if (this.f1156O) {
                clearFocus();
                u(true);
                return;
            }
            return;
        }
        searchAutoComplete.setText(BuildConfig.FLAVOR);
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
    }

    public final void l(int i2) {
        int i3;
        Uri parse;
        String h2;
        Cursor cursor = this.f1158Q.f317e;
        if (cursor != null && cursor.moveToPosition(i2)) {
            Intent intent = null;
            try {
                int i4 = e0.f3128A;
                String h3 = e0.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (h3 == null) {
                    h3 = this.f1168d0.getSuggestIntentAction();
                }
                if (h3 == null) {
                    h3 = "android.intent.action.SEARCH";
                }
                String h4 = e0.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (h4 == null) {
                    h4 = this.f1168d0.getSuggestIntentData();
                }
                if (h4 != null && (h2 = e0.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    h4 = h4 + "/" + Uri.encode(h2);
                }
                if (h4 == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(h4);
                }
                intent = h(h3, parse, e0.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), e0.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e2) {
                try {
                    i3 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i3 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e3) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e3);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f1173r;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void m(int i2) {
        Editable text = this.f1173r.getText();
        Cursor cursor = this.f1158Q.f317e;
        if (cursor != null) {
            if (cursor.moveToPosition(i2)) {
                String c2 = this.f1158Q.c(cursor);
                if (c2 != null) {
                    setQuery(c2);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    public final void n(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.f1173r;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1168d0 != null) {
                getContext().startActivity(h("android.intent.action.SEARCH", null, null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f1170f0);
        post(this.f1171g0);
        super.onDetachedFromWindow();
    }

    @Override // m.AbstractC0252E, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.f1173r;
            int[] iArr = this.f1146D;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f1147E;
            getLocationInWindow(iArr2);
            int i6 = iArr[1] - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i7;
            int height = searchAutoComplete.getHeight() + i6;
            Rect rect = this.f1144B;
            rect.set(i7, i6, width, height);
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = i5 - i3;
            Rect rect2 = this.f1145C;
            rect2.set(i8, 0, i9, i10);
            c0 c0Var = this.f1143A;
            if (c0Var == null) {
                c0 c0Var2 = new c0(rect2, rect, searchAutoComplete);
                this.f1143A = c0Var2;
                setTouchDelegate(c0Var2);
            } else {
                c0Var.f3116b.set(rect2);
                Rect rect3 = c0Var.f3118d;
                rect3.set(rect2);
                int i11 = -c0Var.f3119e;
                rect3.inset(i11, i11);
                c0Var.f3117c.set(rect);
            }
        }
    }

    @Override // m.AbstractC0252E, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        if (this.f1157P) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i4 = this.f1163V) > 0) {
                    size = Math.min(i4, size);
                }
            } else {
                size = this.f1163V;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i5 = this.f1163V;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
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
        if (!(parcelable instanceof b0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b0 b0Var = (b0) parcelable;
        super.onRestoreInstanceState(b0Var.f329c);
        u(b0Var.f3114e);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, m.b0, J.c] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? cVar = new J.c(super.onSaveInstanceState());
        cVar.f3114e = this.f1157P;
        return cVar;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.f1170f0);
    }

    public final void p() {
        int i2;
        int[] iArr;
        boolean isEmpty = TextUtils.isEmpty(this.f1173r.getText());
        if (isEmpty && (!this.f1156O || this.f1166b0)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        ImageView imageView = this.f1179x;
        imageView.setVisibility(i2);
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

    public final void q() {
        int[] iArr;
        if (this.f1173r.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1175t.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1176u.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void r() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        boolean z = this.f1156O;
        SearchAutoComplete searchAutoComplete = this.f1173r;
        if (z && (drawable = this.f1149G) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        if (this.f1162U || !isFocusable()) {
            return false;
        }
        if (!this.f1157P) {
            boolean requestFocus = this.f1173r.requestFocus(i2, rect);
            if (requestFocus) {
                u(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i2, rect);
    }

    public final void s() {
        int i2;
        if ((this.f1159R || this.f1164W) && !this.f1157P && (this.f1178w.getVisibility() == 0 || this.y.getVisibility() == 0)) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        this.f1176u.setVisibility(i2);
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1169e0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            k();
            return;
        }
        u(false);
        SearchAutoComplete searchAutoComplete = this.f1173r;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1155N;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1156O == z) {
            return;
        }
        this.f1156O = z;
        u(z);
        r();
    }

    public void setImeOptions(int i2) {
        this.f1173r.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f1173r.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.f1163V = i2;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1154M = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1155N = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1160S = charSequence;
        r();
    }

    public void setQueryRefinementEnabled(boolean z) {
        int i2;
        this.f1161T = z;
        I.c cVar = this.f1158Q;
        if (cVar instanceof e0) {
            e0 e0Var = (e0) cVar;
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            e0Var.f3135s = i2;
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
            r6.f1168d0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.f1173r
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f1168d0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f1168d0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f1168d0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            I.c r7 = r6.f1158Q
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f1168d0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            m.e0 r7 = new m.e0
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f1168d0
            java.util.WeakHashMap r5 = r6.f1172h0
            r7.<init>(r3, r6, r4, r5)
            r6.f1158Q = r7
            r2.setAdapter(r7)
            I.c r7 = r6.f1158Q
            m.e0 r7 = (m.e0) r7
            boolean r3 = r6.f1161T
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.f3135s = r3
        L62:
            r6.r()
        L65:
            android.app.SearchableInfo r7 = r6.f1168d0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f1168d0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.f1152J
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f1168d0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.f1153K
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
            r6.f1164W = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.f1157P
            r6.u(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1159R = z;
        u(this.f1157P);
    }

    public void setSuggestionsAdapter(I.c cVar) {
        this.f1158Q = cVar;
        this.f1173r.setAdapter(cVar);
    }

    public final void t(boolean z) {
        int i2;
        boolean z2 = this.f1159R;
        if (z2 && ((z2 || this.f1164W) && !this.f1157P && hasFocus() && (z || !this.f1164W))) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        this.f1178w.setVisibility(i2);
    }

    public final void u(boolean z) {
        int i2;
        int i3;
        int i4;
        this.f1157P = z;
        int i5 = 8;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f1173r.getText());
        this.f1177v.setVisibility(i2);
        t(!isEmpty);
        if (z) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        this.f1174s.setVisibility(i3);
        ImageView imageView = this.f1148F;
        if (imageView.getDrawable() != null && !this.f1156O) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        p();
        if (this.f1164W && !this.f1157P && isEmpty) {
            this.f1178w.setVisibility(8);
            i5 = 0;
        }
        this.y.setVisibility(i5);
        s();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1144B = new Rect();
        this.f1145C = new Rect();
        this.f1146D = new int[2];
        this.f1147E = new int[2];
        this.f1170f0 = new T(this, 0);
        this.f1171g0 = new T(this, 1);
        this.f1172h0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        W w2 = new W(this);
        X x2 = new X(this);
        C0253F c0253f = new C0253F(1, this);
        S s2 = new S(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.q, i2, 0);
        g gVar = new g(context, obtainStyledAttributes);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f1173r = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1174s = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.f1175t = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.f1176u = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f1177v = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f1178w = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f1179x = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.y = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f1148F = imageView5;
        Drawable e2 = gVar.e(10);
        Field field = J.f180a;
        findViewById.setBackground(e2);
        findViewById2.setBackground(gVar.e(14));
        imageView.setImageDrawable(gVar.e(13));
        imageView2.setImageDrawable(gVar.e(7));
        imageView3.setImageDrawable(gVar.e(4));
        imageView4.setImageDrawable(gVar.e(16));
        imageView5.setImageDrawable(gVar.e(13));
        this.f1149G = gVar.e(12);
        AbstractC0051a.O(getResources().getString(R.string.abc_searchview_description_search), imageView);
        this.f1150H = obtainStyledAttributes.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.f1151I = obtainStyledAttributes.getResourceId(5, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(s2);
        searchAutoComplete.setOnEditorActionListener(w2);
        searchAutoComplete.setOnItemClickListener(x2);
        searchAutoComplete.setOnItemSelectedListener(c0253f);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new U(this));
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(8, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.L = obtainStyledAttributes.getText(6);
        this.f1160S = obtainStyledAttributes.getText(11);
        int i3 = obtainStyledAttributes.getInt(3, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = obtainStyledAttributes.getInt(2, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(obtainStyledAttributes.getBoolean(0, true));
        gVar.k();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1152J = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1153K = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.z = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new V(this));
        }
        u(this.f1156O);
        r();
    }

    public void setOnCloseListener(Y y) {
    }

    public void setOnQueryTextListener(Z z) {
    }

    public void setOnSuggestionListener(a0 a0Var) {
    }
}
