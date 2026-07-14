package l2;

import A2.q;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import i2.C0374i;
import java.nio.ByteBuffer;
import q1.AbstractC0602b;

/* renamed from: l2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0435b extends q {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5122h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0435b(C0374i c0374i, int i4) {
        super(29, c0374i);
        this.f5122h = i4;
    }

    @Override // A2.q
    public final Bitmap w(ByteBuffer byteBuffer, d dVar) {
        switch (this.f5122h) {
            case 0:
                Bitmap w2 = super.w(byteBuffer, dVar);
                if (w2 == null) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    byteBuffer.rewind();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, remaining, options);
                    if (dVar.f5126c != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(dVar.f5126c);
                        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                        decodeByteArray.recycle();
                        return AbstractC0602b.b(createBitmap, dVar.f5128e);
                    }
                    return AbstractC0602b.b(decodeByteArray, dVar.f5128e);
                }
                return w2;
            default:
                return AbstractC0602b.b(super.w(byteBuffer, dVar), dVar.f5128e);
        }
    }
}
