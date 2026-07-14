package V;

import T.u;
import android.text.Editable;

/* loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f1651a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f1652b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f1653c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f1653c;
        if (cls != null) {
            return new u(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
