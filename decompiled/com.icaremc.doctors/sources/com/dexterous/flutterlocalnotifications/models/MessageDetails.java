package com.dexterous.flutterlocalnotifications.models;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
/* loaded from: classes.dex */
public class MessageDetails implements Serializable {
    public String dataMimeType;
    public String dataUri;
    public PersonDetails person;
    public String text;
    public Long timestamp;

    public MessageDetails(String str, Long l2, PersonDetails personDetails, String str2, String str3) {
        this.text = str;
        this.timestamp = l2;
        this.person = personDetails;
        this.dataMimeType = str2;
        this.dataUri = str3;
    }
}
