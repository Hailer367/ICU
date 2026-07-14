package C0;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import io.flutter.util.ViewUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements h, ViewUtils.ViewVisitor, LibraryVersionComponent.VersionExtractor, Continuation, ObjectConstructor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f149a;

    public /* synthetic */ f(int i2) {
        this.f149a = i2;
    }

    @Override // C0.h
    public Object apply(Object obj) {
        byte[] decode;
        Cursor rawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        try {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                A0.g a2 = v0.j.a();
                a2.n(rawQuery.getString(1));
                a2.f32f = F0.a.b(rawQuery.getInt(2));
                String string = rawQuery.getString(3);
                if (string == null) {
                    decode = null;
                } else {
                    decode = Base64.decode(string, 0);
                }
                a2.f31e = decode;
                arrayList.add(a2.a());
            }
            return arrayList;
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Object lambda$newDefaultImplementationConstructor$17;
        Object lambda$newDefaultImplementationConstructor$9;
        Object lambda$newDefaultImplementationConstructor$10;
        Object lambda$newDefaultImplementationConstructor$11;
        Object lambda$newDefaultImplementationConstructor$12;
        Object lambda$newDefaultImplementationConstructor$13;
        Object lambda$newDefaultImplementationConstructor$14;
        Object lambda$newDefaultImplementationConstructor$15;
        Object lambda$newDefaultImplementationConstructor$16;
        switch (this.f149a) {
            case 11:
                lambda$newDefaultImplementationConstructor$17 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$17();
                return lambda$newDefaultImplementationConstructor$17;
            case 12:
                lambda$newDefaultImplementationConstructor$9 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$9();
                return lambda$newDefaultImplementationConstructor$9;
            case 13:
                lambda$newDefaultImplementationConstructor$10 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$10();
                return lambda$newDefaultImplementationConstructor$10;
            case 14:
                lambda$newDefaultImplementationConstructor$11 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$11();
                return lambda$newDefaultImplementationConstructor$11;
            case 15:
                lambda$newDefaultImplementationConstructor$12 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$12();
                return lambda$newDefaultImplementationConstructor$12;
            case 16:
                lambda$newDefaultImplementationConstructor$13 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$13();
                return lambda$newDefaultImplementationConstructor$13;
            case 17:
                lambda$newDefaultImplementationConstructor$14 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$14();
                return lambda$newDefaultImplementationConstructor$14;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                lambda$newDefaultImplementationConstructor$15 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$15();
                return lambda$newDefaultImplementationConstructor$15;
            default:
                lambda$newDefaultImplementationConstructor$16 = ConstructorConstructor.lambda$newDefaultImplementationConstructor$16();
                return lambda$newDefaultImplementationConstructor$16;
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.f149a) {
            case 4:
                return FirebaseCommonRegistrar.c(context);
            case 5:
                return FirebaseCommonRegistrar.b(context);
            case 6:
                return FirebaseCommonRegistrar.d(context);
            default:
                return FirebaseCommonRegistrar.a(context);
        }
    }

    @Override // io.flutter.util.ViewUtils.ViewVisitor
    public boolean run(View view) {
        return ViewUtils.a(view);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f149a) {
            case 8:
                return FcmBroadcastProcessor.d(task);
            default:
                return FcmBroadcastProcessor.c(task);
        }
    }
}
