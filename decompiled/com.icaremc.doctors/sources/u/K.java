package u;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f3700a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f3701b;

    /* renamed from: c, reason: collision with root package name */
    public String f3702c;

    /* renamed from: d, reason: collision with root package name */
    public String f3703d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3704e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3705f;

    /* JADX WARN: Type inference failed for: r5v1, types: [u.K, java.lang.Object] */
    public static K a(Bundle bundle) {
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
        boolean z2 = bundle.getBoolean("isImportant");
        ?? obj = new Object();
        obj.f3700a = charSequence;
        obj.f3701b = iconCompat;
        obj.f3702c = string;
        obj.f3703d = string2;
        obj.f3704e = z;
        obj.f3705f = z2;
        return obj;
    }

    public final Bundle b() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("name", this.f3700a);
        IconCompat iconCompat = this.f3701b;
        if (iconCompat != null) {
            iconCompat.getClass();
            bundle = new Bundle();
            switch (iconCompat.f1289a) {
                case -1:
                    bundle.putParcelable("obj", (Parcelable) iconCompat.f1290b);
                    break;
                case 0:
                default:
                    throw new IllegalArgumentException("Invalid icon");
                case 1:
                case 5:
                    bundle.putParcelable("obj", (Bitmap) iconCompat.f1290b);
                    break;
                case 2:
                case 4:
                case 6:
                    bundle.putString("obj", (String) iconCompat.f1290b);
                    break;
                case 3:
                    bundle.putByteArray("obj", (byte[]) iconCompat.f1290b);
                    break;
            }
            bundle.putInt("type", iconCompat.f1289a);
            bundle.putInt("int1", iconCompat.f1293e);
            bundle.putInt("int2", iconCompat.f1294f);
            bundle.putString("string1", iconCompat.f1298j);
            ColorStateList colorStateList = iconCompat.f1295g;
            if (colorStateList != null) {
                bundle.putParcelable("tint_list", colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f1296h;
            if (mode != IconCompat.f1288k) {
                bundle.putString("tint_mode", mode.name());
            }
        } else {
            bundle = null;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.f3702c);
        bundle2.putString("key", this.f3703d);
        bundle2.putBoolean("isBot", this.f3704e);
        bundle2.putBoolean("isImportant", this.f3705f);
        return bundle2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof K)) {
            return false;
        }
        K k2 = (K) obj;
        String str = this.f3703d;
        String str2 = k2.f3703d;
        if (str == null && str2 == null) {
            if (!Objects.equals(Objects.toString(this.f3700a), Objects.toString(k2.f3700a)) || !Objects.equals(this.f3702c, k2.f3702c) || !Boolean.valueOf(this.f3704e).equals(Boolean.valueOf(k2.f3704e)) || !Boolean.valueOf(this.f3705f).equals(Boolean.valueOf(k2.f3705f))) {
                return false;
            }
            return true;
        }
        return Objects.equals(str, str2);
    }

    public final int hashCode() {
        String str = this.f3703d;
        if (str != null) {
            return str.hashCode();
        }
        return Objects.hash(this.f3700a, this.f3702c, Boolean.valueOf(this.f3704e), Boolean.valueOf(this.f3705f));
    }
}
