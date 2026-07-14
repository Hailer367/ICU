package androidx.appcompat.view.menu;

import A0.g;
import E.J;
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
import com.icaremc.doctors.R;
import h.AbstractC0201a;
import java.lang.reflect.Field;
import l.j;
import l.k;
import l.q;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements q, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: c, reason: collision with root package name */
    public k f1068c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f1069d;

    /* renamed from: e, reason: collision with root package name */
    public RadioButton f1070e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f1071f;

    /* renamed from: g, reason: collision with root package name */
    public CheckBox f1072g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f1073h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f1074i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f1075j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f1076k;

    /* renamed from: l, reason: collision with root package name */
    public final Drawable f1077l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1078m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f1079n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1080o;
    public final Drawable p;
    public final boolean q;

    /* renamed from: r, reason: collision with root package name */
    public LayoutInflater f1081r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1082s;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g i2 = g.i(getContext(), attributeSet, AbstractC0201a.f2311n, R.attr.listMenuViewStyle);
        this.f1077l = i2.e(5);
        TypedArray typedArray = (TypedArray) i2.f31e;
        this.f1078m = typedArray.getResourceId(1, -1);
        this.f1080o = typedArray.getBoolean(7, false);
        this.f1079n = context;
        this.p = i2.e(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.q = obtainStyledAttributes.hasValue(0);
        i2.k();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f1081r == null) {
            this.f1081r = LayoutInflater.from(getContext());
        }
        return this.f1081r;
    }

    private void setSubMenuArrowVisible(boolean z) {
        int i2;
        ImageView imageView = this.f1074i;
        if (imageView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1075j;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1075j.getLayoutParams();
            rect.top = this.f1075j.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    @Override // l.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l.k r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.b(l.k):void");
    }

    @Override // l.q
    public k getItemData() {
        return this.f1068c;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Field field = J.f180a;
        setBackground(this.f1077l);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f1071f = textView;
        int i2 = this.f1078m;
        if (i2 != -1) {
            textView.setTextAppearance(this.f1079n, i2);
        }
        this.f1073h = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f1074i = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.p);
        }
        this.f1075j = (ImageView) findViewById(R.id.group_divider);
        this.f1076k = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        if (this.f1069d != null && this.f1080o) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1069d.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (z || this.f1070e != null || this.f1072g != null) {
            if ((this.f1068c.f2882x & 4) != 0) {
                if (this.f1070e == null) {
                    RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                    this.f1070e = radioButton;
                    LinearLayout linearLayout = this.f1076k;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.f1070e;
                view = this.f1072g;
            } else {
                if (this.f1072g == null) {
                    CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                    this.f1072g = checkBox;
                    LinearLayout linearLayout2 = this.f1076k;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.f1072g;
                view = this.f1070e;
            }
            if (z) {
                compoundButton.setChecked(this.f1068c.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox2 = this.f1072g;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f1070e;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f1068c.f2882x & 4) != 0) {
            if (this.f1070e == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f1070e = radioButton;
                LinearLayout linearLayout = this.f1076k;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f1070e;
        } else {
            if (this.f1072g == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f1072g = checkBox;
                LinearLayout linearLayout2 = this.f1076k;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f1072g;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1082s = z;
        this.f1080o = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        int i2;
        ImageView imageView = this.f1075j;
        if (imageView != null) {
            if (!this.q && z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void setIcon(Drawable drawable) {
        j jVar = this.f1068c.f2874n;
        boolean z = this.f1082s;
        if (z || this.f1080o) {
            ImageView imageView = this.f1069d;
            if (imageView != null || drawable != null || this.f1080o) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                    this.f1069d = imageView2;
                    LinearLayout linearLayout = this.f1076k;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable == null && !this.f1080o) {
                    this.f1069d.setVisibility(8);
                    return;
                }
                ImageView imageView3 = this.f1069d;
                if (!z) {
                    drawable = null;
                }
                imageView3.setImageDrawable(drawable);
                if (this.f1069d.getVisibility() != 0) {
                    this.f1069d.setVisibility(0);
                }
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1071f.setText(charSequence);
            if (this.f1071f.getVisibility() != 0) {
                this.f1071f.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f1071f.getVisibility() != 8) {
            this.f1071f.setVisibility(8);
        }
    }
}
