package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SslErrorExt extends SslError {
    private SslErrorExt(int i4, SslCertificate sslCertificate, String str) {
        super(i4, sslCertificate, str);
    }

    public static Map<String, Object> toMap(SslError sslError) {
        String str;
        Integer num = null;
        if (sslError == null) {
            return null;
        }
        int primaryError = sslError.getPrimaryError();
        if (primaryError != 0) {
            if (primaryError != 1) {
                if (primaryError != 2) {
                    if (primaryError != 3) {
                        if (primaryError != 4) {
                            if (primaryError != 5) {
                                str = null;
                            } else {
                                str = "A generic error occurred";
                            }
                        } else {
                            str = "The date of the certificate is invalid";
                        }
                    } else {
                        str = "The certificate authority is not trusted";
                    }
                } else {
                    str = "Hostname mismatch";
                }
            } else {
                str = "The certificate has expired";
            }
        } else {
            str = "The certificate is not yet valid";
        }
        HashMap hashMap = new HashMap();
        if (primaryError >= 0) {
            num = Integer.valueOf(primaryError);
        }
        hashMap.put("code", num);
        hashMap.put("message", str);
        return hashMap;
    }
}
