package m;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e0 extends I.c implements View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public static final /* synthetic */ int f3128A = 0;

    /* renamed from: k, reason: collision with root package name */
    public final int f3129k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3130l;

    /* renamed from: m, reason: collision with root package name */
    public final LayoutInflater f3131m;

    /* renamed from: n, reason: collision with root package name */
    public final SearchView f3132n;

    /* renamed from: o, reason: collision with root package name */
    public final SearchableInfo f3133o;
    public final Context p;
    public final WeakHashMap q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3134r;

    /* renamed from: s, reason: collision with root package name */
    public int f3135s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f3136t;

    /* renamed from: u, reason: collision with root package name */
    public int f3137u;

    /* renamed from: v, reason: collision with root package name */
    public int f3138v;

    /* renamed from: w, reason: collision with root package name */
    public int f3139w;

    /* renamed from: x, reason: collision with root package name */
    public int f3140x;
    public int y;
    public int z;

    public e0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f316d = true;
        this.f317e = null;
        this.f315c = false;
        this.f318f = context;
        this.f319g = -1;
        this.f320h = new I.a(this);
        this.f321i = new I.b(0, this);
        this.f3130l = suggestionRowLayout;
        this.f3129k = suggestionRowLayout;
        this.f3131m = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3135s = 1;
        this.f3137u = -1;
        this.f3138v = -1;
        this.f3139w = -1;
        this.f3140x = -1;
        this.y = -1;
        this.z = -1;
        this.f3132n = searchView;
        this.f3133o = searchableInfo;
        this.f3134r = searchView.getSuggestionCommitIconResId();
        this.p = context;
        this.q = weakHashMap;
    }

    public static String h(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0140  */
    @Override // I.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.e0.a(android.view.View, android.database.Cursor):void");
    }

    @Override // I.c
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f3137u = cursor.getColumnIndex("suggest_text_1");
                this.f3138v = cursor.getColumnIndex("suggest_text_2");
                this.f3139w = cursor.getColumnIndex("suggest_text_2_url");
                this.f3140x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // I.c
    public final String c(Cursor cursor) {
        String h2;
        String h3;
        if (cursor != null) {
            String h4 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
            if (h4 != null) {
                return h4;
            }
            SearchableInfo searchableInfo = this.f3133o;
            if (searchableInfo.shouldRewriteQueryFromData() && (h3 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
                return h3;
            }
            if (searchableInfo.shouldRewriteQueryFromText() && (h2 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) != null) {
                return h2;
            }
            return null;
        }
        return null;
    }

    @Override // I.c
    public final View d(ViewGroup viewGroup) {
        View inflate = this.f3131m.inflate(this.f3129k, viewGroup, false);
        inflate.setTag(new d0(inflate));
        ((ImageView) inflate.findViewById(R.id.edit_query)).setImageResource(this.f3134r);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f318f.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable f(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.e0.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f318f.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // I.c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View inflate = this.f3131m.inflate(this.f3130l, viewGroup, false);
            if (inflate != null) {
                ((d0) inflate.getTag()).f3121a.setText(e2.toString());
            }
            return inflate;
        }
    }

    @Override // I.c, android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View d2 = d(viewGroup);
            ((d0) d2.getTag()).f3121a.setText(e2.toString());
            return d2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.f317e;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f317e;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f3132n.n((CharSequence) tag);
        }
    }
}
