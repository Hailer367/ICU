package H1;

import D2.M;
import S2.l;
import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f653a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f654b;

    public /* synthetic */ d(e eVar, int i4) {
        this.f653a = i4;
        this.f654b = eVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String byteArrayOutputStream;
        switch (this.f653a) {
            case 0:
                e eVar = this.f654b;
                synchronized (eVar) {
                    try {
                        j jVar = (j) eVar.f655a.get();
                        ArrayList a4 = jVar.a();
                        synchronized (jVar) {
                            jVar.f670a.a(new M(1, jVar));
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (int i4 = 0; i4 < a4.size(); i4++) {
                            a aVar = (a) a4.get(i4);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("agent", aVar.f646a);
                            jSONObject.put("dates", new JSONArray((Collection) aVar.f647b));
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("heartbeats", jSONArray);
                        jSONObject2.put("version", "2");
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                            try {
                                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                                gZIPOutputStream.close();
                                base64OutputStream.close();
                                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
                            } finally {
                            }
                        } catch (Throwable th) {
                            try {
                                base64OutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return byteArrayOutputStream;
            default:
                e eVar2 = this.f654b;
                synchronized (eVar2) {
                    final j jVar2 = (j) eVar2.f655a.get();
                    long currentTimeMillis = System.currentTimeMillis();
                    final String a5 = ((R1.b) eVar2.f657c.get()).a();
                    synchronized (jVar2) {
                        final String b4 = jVar2.b(currentTimeMillis);
                        final S.d V3 = AbstractC0602b.V(a5);
                        jVar2.f670a.a(new l() { // from class: H1.i
                            @Override // S2.l
                            public final Object f(Object obj) {
                                Object obj2;
                                j jVar3 = j.this;
                                String str = b4;
                                String str2 = a5;
                                S.d dVar = V3;
                                S.b bVar = (S.b) obj;
                                Object obj3 = null;
                                if (((String) AbstractC0602b.D(bVar, j.f669d, "")).equals(str)) {
                                    S.d c4 = jVar3.c(bVar, str);
                                    if (c4 == null || c4.f1538a.equals(str2)) {
                                        return null;
                                    }
                                    synchronized (jVar3) {
                                        jVar3.d(bVar, str);
                                        HashSet hashSet = new HashSet((Collection) AbstractC0602b.D(bVar, dVar, new HashSet()));
                                        hashSet.add(str);
                                        bVar.f(dVar, hashSet);
                                    }
                                    return null;
                                }
                                S.d dVar2 = j.f668c;
                                long longValue = ((Long) AbstractC0602b.D(bVar, dVar2, 0L)).longValue();
                                if (longValue + 1 == 30) {
                                    synchronized (jVar3) {
                                        try {
                                            long longValue2 = ((Long) AbstractC0602b.D(bVar, dVar2, 0L)).longValue();
                                            String str3 = "";
                                            Set hashSet2 = new HashSet();
                                            String str4 = null;
                                            for (Map.Entry entry : bVar.a().entrySet()) {
                                                if (entry.getValue() instanceof Set) {
                                                    Set<String> set = (Set) entry.getValue();
                                                    for (String str5 : set) {
                                                        Object obj4 = obj3;
                                                        if (str4 != null && str4.compareTo(str5) <= 0) {
                                                            obj3 = obj4;
                                                        }
                                                        str3 = ((S.d) entry.getKey()).f1538a;
                                                        str4 = str5;
                                                        hashSet2 = set;
                                                        obj3 = obj4;
                                                    }
                                                }
                                                obj3 = obj3;
                                            }
                                            obj2 = obj3;
                                            HashSet hashSet3 = new HashSet(hashSet2);
                                            hashSet3.remove(str4);
                                            bVar.f(AbstractC0602b.V(str3), hashSet3);
                                            longValue = longValue2 - 1;
                                            bVar.e(j.f668c, Long.valueOf(longValue));
                                        } catch (Throwable th4) {
                                            throw th4;
                                        }
                                    }
                                } else {
                                    obj2 = null;
                                }
                                HashSet hashSet4 = new HashSet((Collection) AbstractC0602b.D(bVar, dVar, new HashSet()));
                                hashSet4.add(str);
                                bVar.f(dVar, hashSet4);
                                bVar.e(j.f668c, Long.valueOf(longValue + 1));
                                bVar.e(j.f669d, str);
                                return obj2;
                            }
                        });
                    }
                }
                return null;
        }
    }
}
