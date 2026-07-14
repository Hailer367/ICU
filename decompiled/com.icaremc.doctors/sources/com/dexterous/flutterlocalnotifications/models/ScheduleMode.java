package com.dexterous.flutterlocalnotifications.models;

import androidx.annotation.Keep;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

@Keep
/* loaded from: classes.dex */
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    /* loaded from: classes.dex */
    public static class Deserializer implements JsonDeserializer<ScheduleMode> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public ScheduleMode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            try {
                return ScheduleMode.valueOf(jsonElement.getAsString());
            } catch (Exception unused) {
                return jsonElement.getAsBoolean() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
            }
        }
    }

    public boolean useAlarmClock() {
        if (this == alarmClock) {
            return true;
        }
        return false;
    }

    public boolean useAllowWhileIdle() {
        if (this != exactAllowWhileIdle && this != inexactAllowWhileIdle) {
            return false;
        }
        return true;
    }

    public boolean useExactAlarm() {
        if (this != exact && this != exactAllowWhileIdle) {
            return false;
        }
        return true;
    }
}
