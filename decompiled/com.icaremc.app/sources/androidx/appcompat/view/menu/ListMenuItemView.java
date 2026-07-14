package androidx.appcompat.view.menu;

import A2.t;
import I.T;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.icaremc.app.R;
import i.AbstractC0357a;
import java.util.WeakHashMap;
import n.InterfaceC0450C;
import n.q;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0450C, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: f, reason: collision with root package name */
    public q f2275f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f2276g;

    /* renamed from: h, reason: collision with root package name */
    public RadioButton f2277h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f2278i;

    /* renamed from: j, reason: collision with root package name */
    public CheckBox f2279j;
    public TextView k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f2280l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f2281m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f2282n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f2283o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2284p;

    /* renamed from: q, reason: collision with root package name */
    public final Context f2285q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2286r;

    /* renamed from: s, reason: collision with root package name */
    public final Drawable f2287s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f2288t;

    /* renamed from: u, reason: collision with root package name */
    public LayoutInflater f2289u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2290v;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t P = t.P(getContext(), attributeSet, AbstractC0357a.f4082r, R.attr.listMenuViewStyle);
        this.f2283o = P.H(5);
        TypedArray typedArray = (TypedArray) P.f100h;
        this.f2284p = typedArray.getResourceId(1, -1);
        this.f2286r = typedArray.getBoolean(7, false);
        this.f2285q = context;
        this.f2287s = P.H(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f2288t = obtainStyledAttributes.hasValue(0);
        P.T();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f2289u == null) {
            this.f2289u = LayoutInflater.from(getContext());
        }
        return this.f2289u;
    }

    private void setSubMenuArrowVisible(boolean z) {
        int i4;
        ImageView imageView = this.f2280l;
        if (imageView != null) {
            if (z) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            imageView.setVisibility(i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    @Override // n.InterfaceC0450C
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(n.q r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.a(n.q):void");
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2281m;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2281m.getLayoutParams();
            rect.top = this.f2281m.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    @Override // n.InterfaceC0450C
    public q getItemData() {
        return this.f2275f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = T.f702a;
        setBackground(this.f2283o);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f2278i = textView;
        int i4 = this.f2284p;
        if (i4 != -1) {
            textView.setTextAppearance(this.f2285q, i4);
        }
        this.k = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f2280l = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2287s);
        }
        this.f2281m = (ImageView) findViewById(R.id.group_divider);
        this.f2282n = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (this.f2276g != null && this.f2286r) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2276g.getLayoutParams();
            int i6 = layoutParams.height;
            if (i6 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i6;
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (z || this.f2277h != null || this.f2279j != null) {
            if ((this.f2275f.f5348x & 4) != 0) {
                if (this.f2277h == null) {
                    RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                    this.f2277h = radioButton;
                    LinearLayout linearLayout = this.f2282n;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.f2277h;
                view = this.f2279j;
            } else {
                if (this.f2279j == null) {
                    CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                    this.f2279j = checkBox;
                    LinearLayout linearLayout2 = this.f2282n;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.f2279j;
                view = this.f2277h;
            }
            if (z) {
                compoundButton.setChecked(this.f2275f.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox2 = this.f2279j;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f2277h;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f2275f.f5348x & 4) != 0) {
            if (this.f2277h == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f2277h = radioButton;
                LinearLayout linearLayout = this.f2282n;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f2277h;
        } else {
            if (this.f2279j == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f2279j = checkBox;
                LinearLayout linearLayout2 = this.f2282n;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f2279j;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f2290v = z;
        this.f2286r = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        int i4;
        ImageView imageView = this.f2281m;
        if (imageView != null) {
            if (!this.f2288t && z) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            imageView.setVisibility(i4);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z;
        if (!this.f2275f.f5338n.f5311s && !this.f2290v) {
            z = false;
        } else {
            z = true;
        }
        if (z || this.f2286r) {
            ImageView imageView = this.f2276g;
            if (imageView != null || drawable != null || this.f2286r) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                    this.f2276g = imageView2;
                    LinearLayout linearLayout = this.f2282n;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable == null && !this.f2286r) {
                    this.f2276g.setVisibility(8);
                    return;
                }
                ImageView imageView3 = this.f2276g;
                if (!z) {
                    drawable = null;
                }
                imageView3.setImageDrawable(drawable);
                if (this.f2276g.getVisibility() != 0) {
                    this.f2276g.setVisibility(0);
                }
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2278i.setText(charSequence);
            if (this.f2278i.getVisibility() != 0) {
                this.f2278i.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f2278i.getVisibility() != 8) {
            this.f2278i.setVisibility(8);
        }
    }
}
