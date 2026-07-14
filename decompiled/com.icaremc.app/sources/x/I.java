package x;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f6330a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f6331b;

    /* renamed from: c, reason: collision with root package name */
    public String f6332c;

    /* renamed from: d, reason: collision with root package name */
    public String f6333d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6334e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6335f;

    /* JADX WARN: Type inference failed for: r5v1, types: [x.I, java.lang.Object] */
    public static I a(Bundle bundle) {
        IconCompat iconCompat;
        Bundle bundle2 = bundle.getBundle("icon");
        CharSequence charSequence = bundle.getCharSequence("name");
        if (bundle2 != null) {
            iconCompat = IconCompat.a(bundle2);
        } else {
            iconCompat = null;
        }
        String string = bundle.getString("uri");
        String string2 = bundle.getString("key");
        boolean z = bundle.getBoolean("isBot");
        boolean z3 = bundle.getBoolean("isImportant");
        ?? obj = new Object();
        obj.f6330a = charSequence;
        obj.f6331b = iconCompat;
        obj.f6332c = string;
        obj.f6333d = string2;
        obj.f6334e = z;
        obj.f6335f = z3;
        return obj;
    }

    public final Bundle b() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("name", this.f6330a);
        IconCompat iconCompat = this.f6331b;
        if (iconCompat != null) {
            iconCompat.getClass();
            bundle = new Bundle();
            switch (iconCompat.f2508a) {
                case -1:
                    bundle.putParcelable("obj", (Parcelable) iconCompat.f2509b);
                    break;
                case 0:
                default:
                    throw new IllegalArgumentException("Invalid icon");
                case 1:
                case 5:
                    bundle.putParcelable("obj", (Bitmap) iconCompat.f2509b);
                    break;
                case 2:
                case 4:
                case 6:
                    bundle.putString("obj", (String) iconCompat.f2509b);
                    break;
                case 3:
                    bundle.putByteArray("obj", (byte[]) iconCompat.f2509b);
                    break;
            }
            bundle.putInt("type", iconCompat.f2508a);
            bundle.putInt("int1", iconCompat.f2512e);
            bundle.putInt("int2", iconCompat.f2513f);
            bundle.putString("string1", iconCompat.f2517j);
            ColorStateList colorStateList = iconCompat.f2514g;
            if (colorStateList != null) {
                bundle.putParcelable("tint_list", colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f2515h;
            if (mode != IconCompat.k) {
                bundle.putString("tint_mode", mode.name());
            }
        } else {
            bundle = null;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.f6332c);
        bundle2.putString("key", this.f6333d);
        bundle2.putBoolean("isBot", this.f6334e);
        bundle2.putBoolean("isImportant", this.f6335f);
        return bundle2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof I)) {
            return false;
        }
        I i4 = (I) obj;
        String str = this.f6333d;
        String str2 = i4.f6333d;
        if (str == null && str2 == null) {
            if (!Objects.equals(Objects.toString(this.f6330a), Objects.toString(i4.f6330a)) || !Objects.equals(this.f6332c, i4.f6332c) || !Boolean.valueOf(this.f6334e).equals(Boolean.valueOf(i4.f6334e)) || !Boolean.valueOf(this.f6335f).equals(Boolean.valueOf(i4.f6335f))) {
                return false;
            }
            return true;
        }
        return Objects.equals(str, str2);
    }

    public final int hashCode() {
        String str = this.f6333d;
        if (str != null) {
            return str.hashCode();
        }
        return Objects.hash(this.f6330a, this.f6332c, Boolean.valueOf(this.f6334e), Boolean.valueOf(this.f6335f));
    }
}
