package r2;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f6111a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6112b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6113c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6114d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6115e;

    public o(String str, int i4, int i5, int i6, int i7) {
        if ((i4 == -1 && i5 == -1) || (i4 >= 0 && i5 >= 0)) {
            if ((i6 == -1 && i7 == -1) || (i6 >= 0 && i6 <= i7)) {
                if (i7 <= str.length()) {
                    if (i4 <= str.length()) {
                        if (i5 <= str.length()) {
                            this.f6111a = str;
                            this.f6112b = i4;
                            this.f6113c = i5;
                            this.f6114d = i6;
                            this.f6115e = i7;
                            return;
                        }
                        throw new IndexOutOfBoundsException(A2.i.g(i5, "invalid selection end: "));
                    }
                    throw new IndexOutOfBoundsException(A2.i.g(i4, "invalid selection start: "));
                }
                throw new IndexOutOfBoundsException(A2.i.g(i6, "invalid composing start: "));
            }
            throw new IndexOutOfBoundsException("invalid composing range: (" + i6 + ", " + i7 + ")");
        }
        throw new IndexOutOfBoundsException("invalid selection: (" + i4 + ", " + i5 + ")");
    }

    public static o a(JSONObject jSONObject) {
        return new o(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
    }
}
