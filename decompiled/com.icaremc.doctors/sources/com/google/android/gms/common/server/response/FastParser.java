package com.google.android.gms.common.server.response;

import O.a;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaf = {'u', 'l', 'l'};
    private static final char[] zag = {'r', 'u', 'e'};
    private static final char[] zah = {'r', 'u', 'e', '\"'};
    private static final char[] zai = {'a', 'l', 's', 'e'};
    private static final char[] zaj = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zak = {'\n'};
    private static final zai zam = new zaa();
    private static final zai zan = new zab();
    private static final zai zao = new zac();
    private static final zai zap = new zad();
    private static final zai zaq = new zae();
    private static final zai zar = new zaf();
    private static final zai zas = new zag();
    private static final zai zat = new zah();
    private final char[] zaa = new char[1];
    private final char[] zab = new char[32];
    private final char[] zac = new char[1024];
    private final StringBuilder zad = new StringBuilder(32);
    private final StringBuilder zae = new StringBuilder(1024);
    private final Stack zal = new Stack();

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ParseException extends Exception {
        @KeepForSdk
        public ParseException(String str) {
            super(str);
        }

        @KeepForSdk
        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        @KeepForSdk
        public ParseException(Throwable th) {
            super(th);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z = false;
        boolean z2 = false;
        loop0: while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                int i2 = 0;
                while (i2 < read) {
                    char c2 = cArr[i2];
                    if (!Character.isISOControl(c2) || (cArr2 != null && cArr2[0] == c2)) {
                        int i3 = i2 + 1;
                        if (c2 == '\"') {
                            if (!z) {
                                sb.append(cArr, 0, i2);
                                bufferedReader.reset();
                                bufferedReader.skip(i3);
                                if (z2) {
                                    return JsonUtils.unescapeString(sb.toString());
                                }
                                return sb.toString();
                            }
                        } else if (c2 == '\\') {
                            z = !z;
                            z2 = true;
                            i2 = i3;
                        }
                        z = false;
                        i2 = i3;
                    }
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zai(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        HashMap hashMap;
        int i2 = 1;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaj2 = zaj(bufferedReader);
        if (zaj2 != null) {
            while (zaj2 != null) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaj2);
                if (field == null) {
                    zaj2 = zak(bufferedReader);
                } else {
                    Stack stack = this.zal;
                    stack.push(4);
                    int i3 = field.zaa;
                    char c2 = '}';
                    switch (i3) {
                        case 0:
                            if (field.zab) {
                                fastJsonResponse.zab(field, zam(bufferedReader, zam));
                                break;
                            } else {
                                fastJsonResponse.zaa(field, zab(bufferedReader));
                                break;
                            }
                        case 1:
                            if (field.zab) {
                                fastJsonResponse.zad(field, zam(bufferedReader, zas));
                                break;
                            } else {
                                fastJsonResponse.zac(field, zad(bufferedReader));
                                break;
                            }
                        case 2:
                            if (field.zab) {
                                fastJsonResponse.zaf(field, zam(bufferedReader, zan));
                                break;
                            } else {
                                fastJsonResponse.zae(field, zac(bufferedReader));
                                break;
                            }
                        case 3:
                            if (field.zab) {
                                fastJsonResponse.zah(field, zam(bufferedReader, zao));
                                break;
                            } else {
                                fastJsonResponse.zag(field, zaf(bufferedReader));
                                break;
                            }
                        case 4:
                            if (field.zab) {
                                fastJsonResponse.zaj(field, zam(bufferedReader, zap));
                                break;
                            } else {
                                fastJsonResponse.zai(field, zag(bufferedReader));
                                break;
                            }
                        case 5:
                            if (field.zab) {
                                fastJsonResponse.zal(field, zam(bufferedReader, zat));
                                break;
                            } else {
                                fastJsonResponse.zak(field, zah(bufferedReader));
                                break;
                            }
                        case 6:
                            if (field.zab) {
                                fastJsonResponse.zan(field, zam(bufferedReader, zaq));
                                break;
                            } else {
                                fastJsonResponse.zam(field, zar(bufferedReader, false));
                                break;
                            }
                        case 7:
                            if (field.zab) {
                                fastJsonResponse.zap(field, zam(bufferedReader, zar));
                                break;
                            } else {
                                fastJsonResponse.zao(field, zaa(bufferedReader));
                                break;
                            }
                        case 8:
                            fastJsonResponse.zaq(field, Base64Utils.decode(zan(bufferedReader, this.zac, this.zae, zak)));
                            break;
                        case 9:
                            fastJsonResponse.zaq(field, Base64Utils.decodeUrlSafe(zan(bufferedReader, this.zac, this.zae, zak)));
                            break;
                        case 10:
                            char zaw = zaw(bufferedReader);
                            if (zaw == 'n') {
                                zay(bufferedReader, zaf);
                                hashMap = null;
                            } else if (zaw == '{') {
                                stack.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zaw2 = zaw(bufferedReader);
                                    if (zaw2 != 0) {
                                        if (zaw2 != '\"') {
                                            if (zaw2 == c2) {
                                                zaz(i2);
                                            }
                                        } else {
                                            char[] cArr = this.zab;
                                            StringBuilder sb = this.zad;
                                            String zaA = zaA(bufferedReader, cArr, sb, null);
                                            if (zaw(bufferedReader) == ':') {
                                                if (zaw(bufferedReader) == '\"') {
                                                    hashMap.put(zaA, zaA(bufferedReader, cArr, sb, null));
                                                    char zaw3 = zaw(bufferedReader);
                                                    if (zaw3 != ',') {
                                                        if (zaw3 == '}') {
                                                            zaz(1);
                                                        } else {
                                                            StringBuilder sb2 = new StringBuilder(String.valueOf(zaw3).length() + 47);
                                                            sb2.append("Unexpected character while parsing string map: ");
                                                            sb2.append(zaw3);
                                                            throw new ParseException(sb2.toString());
                                                        }
                                                    } else {
                                                        i2 = 1;
                                                        c2 = '}';
                                                    }
                                                } else {
                                                    throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                                }
                                            } else {
                                                throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                            }
                                        }
                                    } else {
                                        throw new ParseException("Unexpected EOF");
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse.zar(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zaw4 = zaw(bufferedReader);
                                if (zaw4 == 'n') {
                                    zay(bufferedReader, zaf);
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                    break;
                                } else {
                                    stack.push(5);
                                    if (zaw4 == '[') {
                                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zaw5 = zaw(bufferedReader);
                                if (zaw5 == 'n') {
                                    zay(bufferedReader, zaf);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                    break;
                                } else {
                                    stack.push(1);
                                    if (zaw5 == '{') {
                                        try {
                                            FastJsonResponse zaf2 = field.zaf();
                                            zai(bufferedReader, zaf2);
                                            fastJsonResponse.addConcreteTypeInternal(field, field.zae, zaf2);
                                            break;
                                        } catch (IllegalAccessException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        } catch (InstantiationException e3) {
                                            throw new ParseException("Error instantiating inner object", e3);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            throw new ParseException(a.h(new StringBuilder(String.valueOf(i3).length() + 19), "Invalid field type ", i3));
                    }
                    zaz(4);
                    zaz(2);
                    char zaw6 = zaw(bufferedReader);
                    if (zaw6 != ',') {
                        if (zaw6 == '}') {
                            zaj2 = null;
                        } else {
                            StringBuilder sb3 = new StringBuilder(String.valueOf(zaw6).length() + 54);
                            sb3.append("Expected end of object or field separator, but found: ");
                            sb3.append(zaw6);
                            throw new ParseException(sb3.toString());
                        }
                    } else {
                        zaj2 = zaj(bufferedReader);
                    }
                    i2 = 1;
                }
            }
            boolean z = i2;
            zaz(z ? 1 : 0);
            return z;
        }
        zaz(1);
        return false;
    }

    private final String zaj(BufferedReader bufferedReader) {
        Stack stack = this.zal;
        stack.push(2);
        char zaw = zaw(bufferedReader);
        if (zaw != '\"') {
            if (zaw != ']') {
                if (zaw == '}') {
                    zaz(2);
                    return null;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(zaw).length() + 18);
                sb.append("Unexpected token: ");
                sb.append(zaw);
                throw new ParseException(sb.toString());
            }
            zaz(2);
            zaz(1);
            zaz(5);
            return null;
        }
        stack.push(3);
        String zaA = zaA(bufferedReader, this.zab, this.zad, null);
        zaz(3);
        if (zaw(bufferedReader) == ':') {
            return zaA;
        }
        throw new ParseException("Expected key/value separator");
    }

    private final String zak(BufferedReader bufferedReader) {
        bufferedReader.mark(1024);
        char zaw = zaw(bufferedReader);
        int i2 = 1;
        if (zaw != '\"') {
            if (zaw != ',') {
                if (zaw != '[') {
                    if (zaw != '{') {
                        bufferedReader.reset();
                        zax(bufferedReader, this.zac);
                    } else {
                        this.zal.push(1);
                        bufferedReader.mark(32);
                        char zaw2 = zaw(bufferedReader);
                        if (zaw2 == '}') {
                            zaz(1);
                        } else if (zaw2 == '\"') {
                            bufferedReader.reset();
                            zaj(bufferedReader);
                            do {
                            } while (zak(bufferedReader) != null);
                            zaz(1);
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(zaw2).length() + 17);
                            sb.append("Unexpected token ");
                            sb.append(zaw2);
                            throw new ParseException(sb.toString());
                        }
                    }
                } else {
                    this.zal.push(5);
                    bufferedReader.mark(32);
                    if (zaw(bufferedReader) == ']') {
                        zaz(5);
                    } else {
                        bufferedReader.reset();
                        boolean z = false;
                        boolean z2 = false;
                        while (i2 > 0) {
                            char zaw3 = zaw(bufferedReader);
                            if (zaw3 != 0) {
                                if (!Character.isISOControl(zaw3)) {
                                    if (zaw3 == '\"') {
                                        if (!z2) {
                                            z = !z;
                                        }
                                        zaw3 = '\"';
                                    }
                                    if (zaw3 == '[') {
                                        if (!z) {
                                            i2++;
                                        }
                                        zaw3 = '[';
                                    }
                                    if (zaw3 == ']' && !z) {
                                        i2--;
                                    }
                                    if (zaw3 == '\\' && z) {
                                        z2 = !z2;
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    throw new ParseException("Unexpected control character while reading array");
                                }
                            } else {
                                throw new ParseException("Unexpected EOF while parsing array");
                            }
                        }
                        zaz(5);
                    }
                }
            } else {
                throw new ParseException("Missing value");
            }
        } else {
            char[] cArr = this.zaa;
            if (bufferedReader.read(cArr) != -1) {
                char c2 = cArr[0];
                boolean z3 = false;
                do {
                    if (c2 == '\"') {
                        if (z3) {
                            z3 = true;
                            c2 = '\"';
                        }
                    }
                    if (c2 == '\\') {
                        z3 = !z3;
                    } else {
                        z3 = false;
                    }
                    if (bufferedReader.read(cArr) != -1) {
                        c2 = cArr[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                } while (!Character.isISOControl(c2));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zaw4 = zaw(bufferedReader);
        if (zaw4 != ',') {
            if (zaw4 == '}') {
                zaz(2);
                return null;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(zaw4).length() + 17);
            sb2.append("Unexpected token ");
            sb2.append(zaw4);
            throw new ParseException(sb2.toString());
        }
        zaz(2);
        return zaj(bufferedReader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zal, reason: merged with bridge method [inline-methods] */
    public final String zaa(BufferedReader bufferedReader) {
        return zan(bufferedReader, this.zab, this.zad, null);
    }

    private final ArrayList zam(BufferedReader bufferedReader, zai zaiVar) {
        char zaw = zaw(bufferedReader);
        if (zaw == 'n') {
            zay(bufferedReader, zaf);
            return null;
        }
        if (zaw == '[') {
            this.zal.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char zaw2 = zaw(bufferedReader);
                if (zaw2 != 0) {
                    if (zaw2 != ',') {
                        if (zaw2 != ']') {
                            bufferedReader.reset();
                            arrayList.add(zaiVar.zaa(this, bufferedReader));
                        } else {
                            zaz(5);
                            return arrayList;
                        }
                    }
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    private final String zan(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char zaw = zaw(bufferedReader);
        if (zaw != '\"') {
            if (zaw == 'n') {
                zay(bufferedReader, zaf);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return zaA(bufferedReader, cArr, sb, cArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zao, reason: merged with bridge method [inline-methods] */
    public final int zab(BufferedReader bufferedReader) {
        int i2;
        int i3;
        int i4;
        int i5;
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0;
        }
        if (zax > 0) {
            char c2 = cArr[0];
            if (c2 == '-') {
                i2 = Integer.MIN_VALUE;
            } else {
                i2 = -2147483647;
            }
            if (c2 == '-') {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 < zax) {
                i5 = i3 + 1;
                int digit = Character.digit(cArr[i3], 10);
                if (digit >= 0) {
                    i4 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i4 = 0;
                i5 = i3;
            }
            while (i5 < zax) {
                int i6 = i5 + 1;
                int digit2 = Character.digit(cArr[i5], 10);
                if (digit2 >= 0) {
                    if (i4 >= -214748364) {
                        int i7 = i4 * 10;
                        if (i7 >= i2 + digit2) {
                            i4 = i7 - digit2;
                            i5 = i6;
                        } else {
                            throw new ParseException("Number too large");
                        }
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            if (i3 != 0) {
                if (i5 > 1) {
                    return i4;
                }
                throw new ParseException("No digits to parse");
            }
            return -i4;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zap, reason: merged with bridge method [inline-methods] */
    public final long zac(BufferedReader bufferedReader) {
        long j2;
        long j3;
        int i2;
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0L;
        }
        if (zax > 0) {
            int i3 = 0;
            char c2 = cArr[0];
            if (c2 == '-') {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = -9223372036854775807L;
            }
            if (c2 == '-') {
                i3 = 1;
            }
            int i4 = 10;
            if (i3 < zax) {
                i2 = i3 + 1;
                int digit = Character.digit(cArr[i3], 10);
                if (digit >= 0) {
                    j3 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j3 = 0;
                i2 = i3;
            }
            while (i2 < zax) {
                int i5 = i2 + 1;
                int digit2 = Character.digit(cArr[i2], i4);
                if (digit2 >= 0) {
                    if (j3 >= -922337203685477580L) {
                        long j4 = j3 * 10;
                        long j5 = j2;
                        long j6 = digit2;
                        if (j4 >= j5 + j6) {
                            j3 = j4 - j6;
                            i2 = i5;
                            j2 = j5;
                            i4 = 10;
                        } else {
                            throw new ParseException("Number too large");
                        }
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            if (i3 != 0) {
                if (i2 > 1) {
                    return j3;
                }
                throw new ParseException("No digits to parse");
            }
            return -j3;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaq, reason: merged with bridge method [inline-methods] */
    public final BigInteger zad(BufferedReader bufferedReader) {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return null;
        }
        return new BigInteger(new String(cArr, 0, zax));
    }

    private final boolean zar(BufferedReader bufferedReader, boolean z) {
        char[] cArr;
        char[] cArr2;
        char zaw = zaw(bufferedReader);
        if (zaw != '\"') {
            if (zaw != 'f') {
                if (zaw != 'n') {
                    if (zaw == 't') {
                        if (z) {
                            cArr2 = zah;
                        } else {
                            cArr2 = zag;
                        }
                        zay(bufferedReader, cArr2);
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(zaw).length() + 18);
                    sb.append("Unexpected token: ");
                    sb.append(zaw);
                    throw new ParseException(sb.toString());
                }
                zay(bufferedReader, zaf);
                return false;
            }
            if (z) {
                cArr = zaj;
            } else {
                cArr = zai;
            }
            zay(bufferedReader, cArr);
            return false;
        }
        if (!z) {
            return zar(bufferedReader, true);
        }
        throw new ParseException("No boolean value found in string");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zas, reason: merged with bridge method [inline-methods] */
    public final float zaf(BufferedReader bufferedReader) {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(cArr, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zat, reason: merged with bridge method [inline-methods] */
    public final double zag(BufferedReader bufferedReader) {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(cArr, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zau, reason: merged with bridge method [inline-methods] */
    public final BigDecimal zah(BufferedReader bufferedReader) {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return null;
        }
        return new BigDecimal(new String(cArr, 0, zax));
    }

    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) {
        ArrayList arrayList = new ArrayList();
        char zaw = zaw(bufferedReader);
        if (zaw != ']') {
            if (zaw != 'n') {
                if (zaw == '{') {
                    Stack stack = this.zal;
                    stack.push(1);
                    while (true) {
                        try {
                            FastJsonResponse zaf2 = field.zaf();
                            if (zai(bufferedReader, zaf2)) {
                                arrayList.add(zaf2);
                                char zaw2 = zaw(bufferedReader);
                                if (zaw2 != ',') {
                                    if (zaw2 == ']') {
                                        zaz(5);
                                        return arrayList;
                                    }
                                    StringBuilder sb = new StringBuilder(String.valueOf(zaw2).length() + 18);
                                    sb.append("Unexpected token: ");
                                    sb.append(zaw2);
                                    throw new ParseException(sb.toString());
                                }
                                if (zaw(bufferedReader) == '{') {
                                    stack.push(1);
                                } else {
                                    throw new ParseException("Expected start of next object in array");
                                }
                            } else {
                                return arrayList;
                            }
                        } catch (IllegalAccessException e2) {
                            throw new ParseException("Error instantiating inner object", e2);
                        } catch (InstantiationException e3) {
                            throw new ParseException("Error instantiating inner object", e3);
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zaw).length() + 18);
                    sb2.append("Unexpected token: ");
                    sb2.append(zaw);
                    throw new ParseException(sb2.toString());
                }
            } else {
                zay(bufferedReader, zaf);
                zaz(5);
                return null;
            }
        } else {
            zaz(5);
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        return r0[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (r5.read(r0) != (-1)) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (java.lang.Character.isWhitespace(r0[0]) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r5.read(r0) != (-1)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final char zaw(java.io.BufferedReader r5) {
        /*
            r4 = this;
            char[] r0 = r4.zaa
            int r1 = r5.read(r0)
            r2 = 0
            r3 = -1
            if (r1 == r3) goto L1c
        La:
            char r1 = r0[r2]
            boolean r1 = java.lang.Character.isWhitespace(r1)
            if (r1 == 0) goto L19
            int r1 = r5.read(r0)
            if (r1 != r3) goto La
            goto L1c
        L19:
            char r5 = r0[r2]
            return r5
        L1c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaw(java.io.BufferedReader):char");
    }

    private final int zax(BufferedReader bufferedReader, char[] cArr) {
        int i2;
        char zaw = zaw(bufferedReader);
        if (zaw != 0) {
            if (zaw != ',') {
                if (zaw == 'n') {
                    zay(bufferedReader, zaf);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (zaw == '\"') {
                    i2 = 0;
                    boolean z = false;
                    while (i2 < 1024 && bufferedReader.read(cArr, i2, 1) != -1) {
                        char c2 = cArr[i2];
                        if (!Character.isISOControl(c2)) {
                            int i3 = i2 + 1;
                            if (c2 == '\"') {
                                if (!z) {
                                    bufferedReader.reset();
                                    bufferedReader.skip(i3);
                                    return i2;
                                }
                            } else if (c2 == '\\') {
                                z = !z;
                                i2 = i3;
                            }
                            z = false;
                            i2 = i3;
                        } else {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                } else {
                    cArr[0] = zaw;
                    i2 = 1;
                    while (i2 < 1024 && bufferedReader.read(cArr, i2, 1) != -1) {
                        char c3 = cArr[i2];
                        if (c3 != '}' && c3 != ',' && !Character.isWhitespace(c3) && cArr[i2] != ']') {
                            i2++;
                        } else {
                            bufferedReader.reset();
                            bufferedReader.skip(i2 - 1);
                            cArr[i2] = 0;
                            return i2;
                        }
                    }
                }
                if (i2 == 1024) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final void zay(BufferedReader bufferedReader, char[] cArr) {
        int i2 = 0;
        while (true) {
            int length = cArr.length;
            if (i2 < length) {
                char[] cArr2 = this.zab;
                int read = bufferedReader.read(cArr2, 0, length - i2);
                if (read != -1) {
                    for (int i3 = 0; i3 < read; i3++) {
                        if (cArr[i3 + i2] != cArr2[i3]) {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i2 += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    private final void zaz(int i2) {
        Stack stack = this.zal;
        if (!stack.isEmpty()) {
            int intValue = ((Integer) stack.pop()).intValue();
            if (intValue == i2) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 24 + String.valueOf(intValue).length());
            sb.append("Expected state ");
            sb.append(i2);
            sb.append(" but had ");
            sb.append(intValue);
            throw new ParseException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 35);
        sb2.append("Expected state ");
        sb2.append(i2);
        sb2.append(" but had empty stack");
        throw new ParseException(sb2.toString());
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t2) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                Stack stack = this.zal;
                stack.push(0);
                char zaw = zaw(bufferedReader);
                if (zaw != 0) {
                    if (zaw != '[') {
                        if (zaw == '{') {
                            stack.push(1);
                            zai(bufferedReader, t2);
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(zaw).length() + 18);
                            sb.append("Unexpected token: ");
                            sb.append(zaw);
                            throw new ParseException(sb.toString());
                        }
                    } else {
                        stack.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t2.getFieldMappings();
                        if (fieldMappings.size() == 1) {
                            FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                            t2.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                        } else {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                    }
                    zaz(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        Log.w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e2) {
                throw new ParseException(e2);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }

    public final /* synthetic */ boolean zae(BufferedReader bufferedReader, boolean z) {
        return zar(bufferedReader, false);
    }
}
