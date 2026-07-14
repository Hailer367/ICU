package o;

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
import com.icaremc.app.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class j1 extends M.c implements View.OnClickListener {

    /* renamed from: C, reason: collision with root package name */
    public static final /* synthetic */ int f5620C = 0;

    /* renamed from: A, reason: collision with root package name */
    public int f5621A;

    /* renamed from: B, reason: collision with root package name */
    public int f5622B;

    /* renamed from: m, reason: collision with root package name */
    public final int f5623m;

    /* renamed from: n, reason: collision with root package name */
    public final int f5624n;

    /* renamed from: o, reason: collision with root package name */
    public final LayoutInflater f5625o;

    /* renamed from: p, reason: collision with root package name */
    public final SearchView f5626p;

    /* renamed from: q, reason: collision with root package name */
    public final SearchableInfo f5627q;

    /* renamed from: r, reason: collision with root package name */
    public final Context f5628r;

    /* renamed from: s, reason: collision with root package name */
    public final WeakHashMap f5629s;

    /* renamed from: t, reason: collision with root package name */
    public final int f5630t;

    /* renamed from: u, reason: collision with root package name */
    public int f5631u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f5632v;

    /* renamed from: w, reason: collision with root package name */
    public int f5633w;

    /* renamed from: x, reason: collision with root package name */
    public int f5634x;

    /* renamed from: y, reason: collision with root package name */
    public int f5635y;
    public int z;

    public j1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f1026g = true;
        this.f1027h = null;
        this.f1025f = false;
        this.f1028i = -1;
        this.f1029j = new M.a(this);
        this.k = new M.b(0, this);
        this.f5624n = suggestionRowLayout;
        this.f5623m = suggestionRowLayout;
        this.f5625o = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5631u = 1;
        this.f5633w = -1;
        this.f5634x = -1;
        this.f5635y = -1;
        this.z = -1;
        this.f5621A = -1;
        this.f5622B = -1;
        this.f5626p = searchView;
        this.f5627q = searchableInfo;
        this.f5630t = searchView.getSuggestionCommitIconResId();
        this.f5628r = context;
        this.f5629s = weakHashMap;
    }

    public static String h(Cursor cursor, int i4) {
        if (i4 == -1) {
            return null;
        }
        try {
            return cursor.getString(i4);
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e4);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013b  */
    @Override // M.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.j1.a(android.view.View, android.database.Cursor):void");
    }

    @Override // M.c
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f5633w = cursor.getColumnIndex("suggest_text_1");
                this.f5634x = cursor.getColumnIndex("suggest_text_2");
                this.f5635y = cursor.getColumnIndex("suggest_text_2_url");
                this.z = cursor.getColumnIndex("suggest_icon_1");
                this.f5621A = cursor.getColumnIndex("suggest_icon_2");
                this.f5622B = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e4);
        }
    }

    @Override // M.c
    public final String c(Cursor cursor) {
        String h3;
        String h4;
        if (cursor != null) {
            String h5 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
            if (h5 != null) {
                return h5;
            }
            SearchableInfo searchableInfo = this.f5627q;
            if (searchableInfo.shouldRewriteQueryFromData() && (h4 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
                return h4;
            }
            if (searchableInfo.shouldRewriteQueryFromText() && (h3 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) != null) {
                return h3;
            }
            return null;
        }
        return null;
    }

    @Override // M.c
    public final View d(ViewGroup viewGroup) {
        View inflate = this.f5625o.inflate(this.f5623m, viewGroup, false);
        inflate.setTag(new i1(inflate));
        ((ImageView) inflate.findViewById(R.id.edit_query)).setImageResource(this.f5630t);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f5628r.getPackageManager().getResourcesForApplication(authority);
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
        throw new UnsupportedOperationException("Method not decompiled: o.j1.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
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
        return this.f5628r.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // M.c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View inflate = this.f5625o.inflate(this.f5624n, viewGroup, false);
            if (inflate != null) {
                ((i1) inflate.getTag()).f5594a.setText(e4.toString());
            }
            return inflate;
        }
    }

    @Override // M.c, android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View d4 = d(viewGroup);
            ((i1) d4.getTag()).f5594a.setText(e4.toString());
            return d4;
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
        Cursor cursor = this.f1027h;
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
        Cursor cursor = this.f1027h;
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
            this.f5626p.o((CharSequence) tag);
        }
    }
}
